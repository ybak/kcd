/**
 * SDK连接 功能相关
 */

var SDKBridge = function(ctr, data) {
  var sdktoken = readCookie('sdktoken'),
    userUID = readCookie('uid'),
    that = this;
  if (!sdktoken) {
    window.location.href = './login.html';
    return;
  }
  //缓存需要获取的用户信息账号
  this.person = {};
  //缓存需要获取的群组账号
  this.team = [];
  this.person[userUID] = true;
  this.controller = ctr;
  this.cache = data;
  window.nim = ctr.nim = this.nim = SDK.NIM.getInstance({
    //控制台日志，上线时应该关掉
    debug: true || {
      api: 'info',
      style: 'font-size:14px;color:blue;background-color:rgba(0,0,0,0.1)'
    },
    db: true,
    appKey: CONFIG.appkey,
    account: userUID,
    token: sdktoken,
    // 私有化配置文件
    privateConf: CONFIG.privateConf,
    onconnect: onConnect,// 连接建立后的回调
    onwillreconnect: onWillReconnect,//即将重连的回调
    ondisconnect: onDisconnect,//断开连接后的回调
    ondisconnect: onDisconnect.bind(this),//
    onsyncdone: onSyncDone,//消息同步
    syncSessionUnread:false,//是否同步会话未读数(开启数据库时有效，保证多端未读数相一致)
    syncRelations:false,// 是否同步黑名单和静音列表, 默认true
    syncFriends:false,//是否同步好友列表, 默认true
    syncFriendUsers:false,//是否同步好友对应的用户名片列表, 默认true
    syncRobots:false,//是否同步机器人列表
    syncTeams:false,//是否同步群列表
    syncExtraTeamInfo:false,//是否同步额外的群信息
    syncRoamingMsgs:false,//是否同步漫游消息
    syncMsgReceipts:false,//是否同步已读回执时间戳
    syncBroadcastMsgs:false,//是否同步广播消息
    onsyncdone: onSyncDone,//消息同步
    onerror: onError //错误
  });

  function onDisconnect(error) {
    // 此时说明 `SDK` 处于断开状态，开发者此时应该根据错误码提示相应的错误信息，并且跳转到登录页面
    var that = this;
    console.log('连接断开');
    if (error) {
      switch (error.code) {
        // 账号或者密码错误, 请跳转到登录页面并提示错误
        case 302:
          alert(error.message);
          delCookie('uid');
          delCookie('sdktoken');
          delCookie('nickName');
          window.location.href = './login.html';
          break;
        // 被踢, 请提示错误后跳转到登录页面
        case 'kicked':
          var map = {
            PC: '电脑版',
            Web: '网页版',
            Android: '手机版',
            iOS: '手机版',
            Mac: '电脑版',
            WindowsPhone: '手机版'
          };
          var str = error.from;
          alert(
            '你的帐号于' +
              dateFormat(+new Date(), 'HH:mm') +
              '被' +
              (map[str] || '其他端') +
              '踢出下线，请确定帐号信息安全!'
          );
          delCookie('uid');
          delCookie('sdktoken');
          delCookie('nickName');
          window.location.href = './login.html';
          break;
        default:
          break;
      }
    }
  }
}
function onSyncDone() {
	 console.log('同步完成');
}
function onConnect() {
 console.log('登录成功');
}
function onWillReconnect(obj) {
 // 此时说明 SDK 已经断开连接, 请开发者在界面上提示用户连接已断开, 而且正在重新建立连接
 console.log('即将重连');
 console.log(obj.retryCount);//重试次数
 console.log(obj.duration);//持续的时间
}
function onError(error) {
 console.log(error);
}


/**
 * 发送普通文本消息
 * @param scene：场景，分为：P2P点对点对话，team群对话
 * @param to：消息的接收方
 * @param text：发送的消息文本
 * @param isLocal：是否是本地消息
 * @param callback：回调
 */
SDKBridge.prototype.sendTextMessage = function(
  scene,
  to,
  text,
  isLocal,
  callback
) {
  isLocal = !!isLocal;
  var options = {
    scene: scene || 'p2p',
    to: to,
    text: text,
    isLocal: isLocal,
    done: callback
  };
  this.nim.sendText(options);
};

/**
 * 获取本地系统消息记录
 * @param  {Funciton} done 回调
 * @return {void}
 */
SDKBridge.prototype.getLocalSysMsgs = function(done) {
  this.nim.getLocalSysMsgs({
    done: done
  });
};

/**
 * 获取删除本地系统消息记录
 * @param  {Funciton} done 回调
 * @return {void}
 */
SDKBridge.prototype.deleteAllLocalSysMsgs = function(done) {
  this.nim.deleteAllLocalSysMsgs({
    done: done
  });
};

/**
 * 踢人
 * @param  {int} type  设备端
 * @return {void}
 */
SDKBridge.prototype.kick = function(type) {
  var deviceIds = type === 0 ? this.mobileDeviceId : this.pcDeviceId;
  this.nim.kick({
    deviceIds: [deviceIds],
    done: function(error, obj) {
      alert(
        '踢' + (type === 0 ? '移动' : 'PC') + '端' + (!error ? '成功' : '失败')
      );
      console.log(error);
      console.log(obj);
    }
  });
};



/**
 * 获取用户信息（如果用户信息让SDK托管）上层限制每次拉取150条
 */
SDKBridge.prototype.getUsers = function(accounts, callback) {
  var arr1 = accounts.slice(0, 150);
  var arr2 = accounts.slice(150);
  var datas = [];
  var that = this;
  var getInfo = function() {
    if (!accounts || accounts.length <= 0) {
      console.warn('getUsers 方法参数 accounts 不能为空：', accounts);
      return;
    }
    that.nim.getUsers({
      accounts: arr1,
      done: function(err, data) {
        if (err) {
          callback(err);
        } else {
          datas = datas.concat(data);
          if (arr2.length > 0) {
            arr1 = arr2.slice(0, 150);
            arr2 = arr2.slice(150);
            getInfo();
          } else {
            callback(err, datas);
          }
        }
      }
    });
  };
  getInfo();
};
SDKBridge.prototype.getUser = function(account, callback) {
  this.nim.getUser({
    account: account,
    done: callback
  });
};

