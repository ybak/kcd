/**
 * 多人音视频控制
 */

var fn = NetcallBridge.prototype;

window.requestAnimationFrame = (function () {
    return window.requestAnimationFrame ||
        window.webkitRequestAnimationFrame ||
        window.mozRequestAnimationFrame ||
        window.oRequestAnimationFrame ||
        window.msRequestAnimationFrame ||
        function (callback) {
            window.setTimeout(callback, 1000 / 60);
        };
})();
/** 摄像头状态切换的节点变化
 * @param {string} uid 唯一id帐号uid
 * @param {string} isEnable 摄像头是否开启
 */
fn.nodeCameraStatus = function (uid, isEnable) {
    isEnable = isEnable || false;
    this.meetingCall.$box && this.meetingCall.$box.find('.item[data-account=' + uid + '] canvas').toggleClass('hide', !isEnable);
}
/** 发送群视频提示消息 */
fn.sendTeamTip = function (message, isLocal) {
    this.yx.sendTeamNetCallTip({
        teamId: this.yx.crtSessionAccount,
        account: this.yx.accid,
        message: message,
        isLocal: isLocal
    });
}
/**
 * 有第三方加入房间
 */
fn.onJoinChannel = function (obj) {
    // 如果是p2p模式
    if (true) {
        this.startDeviceAudioOutChat() //播放声音
        this.startRemoteStreamMeeting(obj) //开启本地输入流
        this.updateVideoShowSize(false, true);
        return
    }
}

fn.resetWhenHangup = function () {
	console.log("音视频通信状态重置")
    /** 放开通道 */
    this.channelId = null;
    this.signalInited = false;
    this.netcall && this.netcall.stopSignal && this.netcall.stopSignal();
    this.isFullScreen = false
    this.videoType = null
    //自定义
    this.custom=null;
    this.beCallData=null;
    minAlert.close();
    /** 设置自己空闲 */
    this.netcall.calling = false;
    this.calling = false;
    this.beCalling = false;
    this.netcallActive = false;
    this.netcallAccount = "";
    //初始化通话时长
    this.netcallDuration=0;
    /** 关闭UI */
    this.$becallview.toggleClass("show-netcall-box", false);
    this.$becallview.toggleClass("hide-netcall-box", false);
    this.$netcallBox.toggleClass("fullscreen", false);
    /** 关闭呼叫响铃 */
    this.clearRingPlay();
    this.clearDurationTimer();
}



/** 关闭自己麦克风 */
fn.stopDeviceAudioIn = function () {
    var that = this;
    that.netcall.stopDevice(Netcall.DEVICE_TYPE_AUDIO_IN).then(function () {
        // 通知对方自己关闭了麦克风
        that.netcall.control({
            command: Netcall.NETCALL_CONTROL_COMMAND_NOTIFY_AUDIO_OFF
        })
    })
}
/** 关闭摄像头 */
fn.stopDeviceVideo = function () {
    var that = this;
    that.netcall.stopDevice(Netcall.DEVICE_TYPE_VIDEO).then(function () {
        // 通知对方自己关闭了摄像头
        that.netcall.control({
            command: Netcall.NETCALL_CONTROL_COMMAND_NOTIFY_VIDEO_OFF
        })
        that.nodeLoadingStatus(that.yx.accid, '摄像头已关闭');
        that.nodeCameraStatus(that.yx.accid, false);
    })
}
/** 开启远程音视频流 */
fn.startRemoteStreamMeeting = function (obj) {
    if (!obj.account && !obj.uid) {
        console.log('远程流错误，缺少account或者uid：', obj);
    }
    if (!obj.account) {
    	console.log("bu")
        obj.account = this.netcall.getAccountWithUid(obj.uid);
    }
    console.log("bu"+ obj.account)
    this.netcall.startRemoteStream(obj)
}
/** 关闭自己的声音 */
fn.stopDeviceAudioOutLocal = function () {
    this.netcall.stopDevice(Netcall.DEVICE_TYPE_AUDIO_OUT_LOCAL)
}
/** 播放远程声音 */
fn.startDeviceAudioOutChat = function () {
    var that = this;
    that.netcall.startDevice({
        type: Netcall.DEVICE_TYPE_AUDIO_OUT_CHAT
    }).catch(function () {
        that.log('播放对方的声音失败')
    })
}
