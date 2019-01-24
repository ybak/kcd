'use strict';
var YX = function(accid) {
  this.accid = accid;
  this.initModule();
  this.cache = new Cache();
  this.mysdk = new SDKBridge(this, this.cache);
  this.myNetcall = new NetcallBridge(this);
  this.firstLoadSysMsg = true;
  this.totalUnread = 0;
};
YX.fn = YX.prototype;

YX.fn.initModule = function() {
  this.initBase();
/*  this.message();*/
  /* this.notification();
  this.personCard();
  this.sysMsg();
  this.session();
  this.friend();
  this.team();
  this.cloudMsg();*/
};
YX.fn.initBase = function() {
	// 初始化节点事件
	this.$mask = $('#mask');
  /*右边面板*/
  this.$rightPanel = $('#rightPanel');
  //多端登陆
  this.multiportEvt();
  this.$chatContent = $('#chatContent');
  this.$chatTitle = $('#chatTitle');
};
/**
 * 初始化个人信息回调 显示左上角信息
 */
YX.fn.showMe = function() {
  var user = this.cache.getUserById(userUID);
  this.$userName.text(user.nick);
  this.$userPic.attr('src', getAvatar(user.avatar));
  setCookie('nickName', user.nick);
  setCookie('avatar', user.avatar);
};
;

/*********************************
 * 点击左边面板，打开聊天框
 *********************************/
YX.fn.openChatBox = function(account, scene,custom) {
  this.$rightPanel.removeClass('hide');
};


//获取好友备注名或者昵称
YX.fn.getNick = function(account) {
  // 使用util中的工具方法
  return getNick(account, this.cache);
};




/**********************************************
 * 多端登录管理
 ********************************************/
YX.fn.multiportEvt = function() {
  this.$devices = $('#devices');
  // 踢人 0：移动端 1：pc端
  $('#devices .mobile').on(
    'click',
    function() {
      this.mysdk.kick(0);
    }.bind(this)
  );
  $('#devices .pc').on(
    'click',
    function() {
      this.mysdk.kick(1);
    }.bind(this)
  );
  $('#backBtn2').on('click', this.hideDevices.bind(this));
  $('.m-devices').on('click', this.showDevices.bind(this));
};

  /**
   * 多端登录面板UI
   */
  (YX.fn.showDevices = function() {
    this.$devices.removeClass('hide');
  });
YX.fn.hideDevices = function() {
  this.$devices.addClass('hide');
};

