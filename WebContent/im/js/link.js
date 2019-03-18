/**
 * SDK连接 功能相关
 */

var SDKBridge = function(ctr) {
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
    ondisconnect: onDisconnect.bind(this),
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
          window.deleteCookie();
          alert(
            '你的帐号于' +
              dateFormat(+new Date(), 'HH:mm') +
              '被' +
              (map[str] || '其他端') +
              '踢出下线，请确定帐号信息安全!'
          );
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
 console.log("重试次数"+obj.retryCount);
 console.log("持续的时间"+obj.duration);
}
function onError(error) {
 console.log(error);
}



