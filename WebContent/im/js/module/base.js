'use strict';
var YX = function() {
  this.initModule();
  this.mysdk = new SDKBridge(this);
  this.myNetcall = new NetcallBridge(this);
};
YX.fn = YX.prototype;
YX.fn.initModule = function() {
  this.initBase();
};
YX.fn.initBase = function() {
  /*右边面板*/
  this.$rightPanel = $('#rightPanel');
  //显示器会话类型
  this.crtSessionType="p2p";
};
YX.fn.openChatBox = function(account, scene,custom) {
  this.$rightPanel.removeClass('hide');
};

