/*
 * 1. 点对点音视频通话中对应的ui相关逻辑
 * 2. 多人音视频相关UI逻辑
*/

var fn = NetcallBridge.prototype;
// 每当设备信息发生变化时，调用此方法同步设备控制按钮状态和提示信息，更新设备输入,更新视频画面提示信息等
fn.checkDeviceStateUI = function () {
    var temp = this.netcall
    var p1 = this.netcall.getDevicesOfType(Netcall.DEVICE_TYPE_VIDEO).then(function (obj) {
        var $camera = $(".netcall-box .camera.control-item");
        if (obj.devices.length) {
            // 摄像头从无到有的变化
            if ($camera.is(".no-device")) {
                // 更新ui
                $camera.toggleClass("no-device", false).attr("title", "");
                // rtc模式检测
                if (this.callMethod === 'webrtc') {
                    if (!temp.devices.needVideo) {
                        return Promise.resolve()
                    }
                }
                // 开启摄像头
                this.setDeviceVideoIn(true);
                /** 如果是群聊，转到多人脚本处理 */
             /*   if (this.netcall.calling && this.yx.crtSessionType === 'team' && this.meetingCall.channelName) {
                    this.updateDeviceStatus(Netcall.DEVICE_TYPE_VIDEO, true, true);
                    this.isRtcSupported && this.startLocalStreamMeeting() && this.setVideoViewSize()
                } else {*/
                    this.isRtcSupported && this.startLocalStream() && this.this.setVideoViewSize()
                //}

                $(".netcall-video-local").toggleClass("empty", false);
                $(".netcall-video-local .message").text("");
            }
        } else {
            this.onDeviceNoUsable(Netcall.DEVICE_TYPE_VIDEO);
            // // 通知对方，我方摄像头不可用
            // this.netcall.control({
            //     command: Netcall.NETCALL_CONTROL_COMMAND_SELF_CAMERA_INVALID
            // });

            // $camera.toggleClass("no-device", true).attr("title", "摄像头不可用");
            // $(".netcall-video-local").toggleClass("empty", true);
            // $(".netcall-video-local .message").text("摄像头不可用");

            /** 如果是群聊，转到多人脚本处理 */
            if (this.netcall.calling && this.yx.crtSessionType === 'team' && this.meetingCall.channelName) {/*
                this.updateDeviceStatus(Netcall.DEVICE_TYPE_VIDEO, true, false);
            */}
        }
    }.bind(this));
    var p2 = this.netcall.getDevicesOfType(Netcall.DEVICE_TYPE_AUDIO_IN).then(function (obj) {
        var $microphone = $(".netcall-box .microphone.control-item");

        if (obj.devices.length) {
            if ($microphone.is(".no-device")) {
                // 更新ui
                $microphone.toggleClass("no-device", false).attr("title", "");
                // rtc模式检测
                if (this.callMethod === 'webrtc') {
                    if (!temp.devices.needAudio) {
                        return Promise.resolve()
                    }
                }
                this.setDeviceAudioIn(true);
            }
        } else {
            this.onDeviceNoUsable(Netcall.DEVICE_TYPE_AUDIO_IN);
            // $microphone.toggleClass("no-device", true).attr("title", "麦克风不可用");
        }
    }.bind(this));
    var p3 = this.netcall.getDevicesOfType(Netcall.DEVICE_TYPE_AUDIO_OUT_CHAT).then(function (obj) {
        var $volume = $(".netcall-box .volume.control-item");
        if (obj.devices.length) {
            if ($volume.is(".no-device")) {
                this.setDeviceAudioOut(true);
            }
            $volume.toggleClass("no-device", false).attr("title", "");
        } else {
            this.onDeviceNoUsable(Netcall.DEVICE_TYPE_AUDIO_OUT_CHAT);
            // $volume.toggleClass("no-device", true).attr("title", "麦克风不可用");
        }
    }.bind(this));
    return Promise.all([p1, p2, p3]);
};
//设备没有可用的
fn.onDeviceNoUsable = function (type) {
    if (type === Netcall.DEVICE_TYPE_VIDEO) {
        // 通知对方，我方摄像头不可用
        this.netcall.control({
            command: Netcall.NETCALL_CONTROL_COMMAND_SELF_CAMERA_INVALID
        });
        $(".netcall-box .camera.control-item").toggleClass("no-device", true).attr("title", "摄像头不可用");
        $(".netcall-video-local").toggleClass("empty", true);
        $(".netcall-video-local .message").text("摄像头不可用");
    } else if (type === Netcall.DEVICE_TYPE_AUDIO_IN) {
        // 通知对方，我方麦克风不可用
        this.netcall.control({
            command: Netcall.NETCALL_CONTROL_COMMAND_SELF_AUDIO_INVALID
        });
        this.$controlItem.filter(".microphone").toggleClass("no-device", true).attr("title", "麦克风不可用");
    } else if (type === Netcall.DEVICE_TYPE_AUDIO_OUT_CHAT) {
        this.$controlItem.filter(".volume").toggleClass("no-device", true).attr("title", "扬声器不可用");
    }

    /** 如果是群聊，转到多人脚本处理 */
    if (this.netcall.calling && this.yx.crtSessionType === 'team' && this.meetingCall.channelName) {
        this.updateDeviceStatus(type, true, false);
    }
}
// 切换对方我方画面位置, 需要重写!
fn.switchViewPosition = function () {
    var $smallView = $(".netcall-box .smallView");
    var $bigView = $(".netcall-box .bigView");
    var $smallParent = $smallView[0].parentNode;
    var $bigParent = $bigView[0].parentNode;
    $bigView.prependTo($smallParent).addClass("smallView").removeClass("bigView");
    $smallView.prependTo($bigParent).addClass("bigView").removeClass("smallView");

    // video标签位置移动以后，会变为pause状态，需要重新play
    this.$netcallBox1.find("video").each(function () {
        if (this.paused) this.play();
    })
    this.updateVideoShowSize(true, true);
};
//切换全屏
fn.toggleFullScreen = function (e) {
    console.log(e)
 
    this.isFullScreen = e && !$(e.target).hasClass('active'); //不活跃 
    this.$netcallBox1.toggleClass("fullscreen", this.isFullScreen);//添加样式
    // p2p模式
    if (this.yx.crtSessionType !== 'team' && !this.meetingCall.channelName) {
        this.$netcallBox.find(".fullScreenIcon").toggleClass("full", this.isFullScreen);
        this.updateVideoShowSize(true, true);
        e && $(e.target).toggleClass('active');
        return
    }
};
// UI界面蒙版展示提示信息，指定时间后消失，消失后执行回调函数
fn.showTip = function (message, duration, done) {
    $(".netcall-mask").toggleClass("hide", false).find(".netcallTip").text(message);
    this.showTipTimer = setTimeout(function () {
        $(".netcall-mask").toggleClass("hide", true).find(".netcallTip").text("");
        done && done();
        this.showTipTimer = null;
    }.bind(this), duration);
};
/** 
 * 设置视频画面尺寸 
 * 
*/
fn.setVideoSize = function (sizeObj) {
    var bigSize = {
        width: this.isFullScreen ? 640 : 320,
        height: this.isFullScreen ? 480 : 240
    };
    var smallSize = {
        width: this.isFullScreen ? 240 : 160,
        height: this.isFullScreen ? 180 : 120
    };
    var size = sizeObj && sizeObj.constructor === Object ? sizeObj : $(".netcall-video-local").is(".bigView") ? bigSize : smallSize;
    this.netcall.setVideoViewSize(size);
}
fn.setVideoRemoteSize = function (sizeObj) {
    var bigSize = {
        width: this.isFullScreen ? 640 : 320,
        height: this.isFullScreen ? 480 : 240
    };
    var smallSize = {
        width: this.isFullScreen ? 240 : 160,
        height: this.isFullScreen ? 180 : 120
    };

    var size = sizeObj && sizeObj.constructor === Object ? sizeObj : $(".netcall-video-local").is(".bigView") ? bigSize : smallSize;
    this.netcall.setVideoViewRemoteSize(size);
}
// 更新视频画面显示尺寸
fn.updateVideoShowSize = function (local, remote) {
    var bigSize = {
        cut: true,
        width: this.isFullScreen ? 640 : 320,
        height: this.isFullScreen ? 480 : 240
    };
    var smallSize = {
        cut: true,
        width: this.isFullScreen ? 240 : 160,
        height: this.isFullScreen ? 180 : 120
    };
    if (local) {
        var isBig = $(".netcall-video-local").is(".bigView")
        console.log('local big?', isBig, isBig ? bigSize : smallSize)
        this.netcall.setVideoViewSize(isBig ? bigSize : smallSize);
    }
    if (remote) {
        var isBig = $(".netcall-video-remote").is(".bigView")
        console.log('remote big?', isBig, isBig ? bigSize : smallSize)
        this.netcall.setVideoViewRemoteSize(isBig ? bigSize : smallSize);
    }
};

fn.hideAllNetcallUI = function () {
    this.clearRingPlay(); //关闭声音
    this.clearDurationTimer(); //通话时间定时器
    //this.clearCallTimer(); //关闭呼叫定时器
    this.clearBeCallTimer(); //关闭被教定时器

    //this.$netcallBox.toggleClass("calling", false); //网络回话盒子 清除高度
    this.$becallview.toggleClass("hide", true);
    //this.$chatBox.toggleClass("show-netcall-box", false); //网络回话盒子 删除没用
    /*this.$callingBox.toggleClass("hide", true);*/
    //this.$videoShowBox.toggleClass("hide", true);//隐藏视频通话界面 这里直接改
    this.$beCallingBox.toggleClass("hide", true);//隐藏被叫ui
    //this.$netcallBox.find(".top").toggleClass('hide', true); //没用
    this.netcallActive = false; //被叫不活跃
    this.netcallAccount = ""; //清空被叫accid
    this.stopRemoteStream();//关闭对方的流
    this.stopLocalStream();//关闭自己的流
    $(".netcall-video-local").toggleClass("empty", false);
    $(".netcall-video-local .message").text("");
    $(".netcall-video-remote").toggleClass("empty", false);
    $(".netcall-video-remote .message").text("");
    // 重置为非全屏状态
    if (this.isFullScreen) {
        this.toggleFullScreen();
        this.updateVideoShowSize(true, true);
    }
    // 重置视频画面显示位置
    if (this.$videoRemoteBox.is(".smallView")) {
        this.switchViewPosition();
    }
    // 关闭所有弹框
    minAlert.close();
    this.dialog_call && this.dialog_call.close();
    this.dialog && this.dialog.close();
    this.yx.dialog && this.yx.dialog.close();

    this.$beCallingAcceptButton.toggleClass("loading", false); //清除被叫链接状态
    if (this.requestSwitchToVideoWaiting) {
        this.requestSwitchToVideoWaiting = false;
        try {
            // $("#askSwitchToVideoDialog").dialog("close");
        } catch (e) { }
    }
    /*this.$switchToAudioButton.toggleClass("disabled", false);*/
   /* this.$callingHangupButton.toggleClass("disabled", false);*/
    this.isBusy = false;
    $(".netcall-mask").toggleClass("hide", true);
    this.$viedoview.toggleClass("hide", true);//隐藏通话界面
    this.$becallandcontent.toggleClass("hide", false);//显示主界面
    if (this.showTipTimer) {
        clearTimeout(this.showTipTimer);
        this.showTipTimer = null;
    }
    this.log("隐藏通话界面");
   // this.resizeChatContent();
};
// 通话建立成功后，展示视频通话或者音频通话画面
fn.showConnectedUI = function (type) {
    this.checkDeviceStateUI();//检查设备UI
    
    this.$toggleFullScreenButton.toggleClass("hide", false);
    //this.$netcallBox.find(".top").toggleClass('hide', false);
    this.$videoShowBox.toggleClass("hide", type !== Netcall.NETCALL_TYPE_VIDEO);
    //var info = this.yx.cache.getUserById(this.netcallAccount);
    this.$becallview.toggleClass("hide", true);//隐藏发起界面
    this.$viedoview.toggleClass("hide",false); //显示另外一个界面
    this.$becallandcontent.toggleClass("hide", true);//隐藏主界面
    console.log("custom"+custom)
    viewdate(custom,"A");
};

/** 接收方显示来电界面，兼容多人音视频
 * 
 * @param {string} type 通话类型，1： 音频，2：视频
 * @param {string} scene 通话场景，p2p(默认值) / team
 * @param {object} option 通话场景，p2p(默认值) / team
 * @param {string} option.teamId 群视频id
 * @param {string} option.caller 发起群视频的人
 */
fn.showBeCallingUI = function (type, scene, option) {
    scene = scene || 'p2p';
    option = option || {};
    this.type = type;
    //this.$netcallBox.toggleClass("calling", true); //设置高度
    this.$toggleFullScreenButton.toggleClass("hide", true);//显示切换全屏

    this.isBusy = false;
    this.clearRingPlay();//关闭声音
    //$(".netcall-mask").toggleClass("hide", true);
    if (this.showTipTimer) {
        clearTimeout(this.showTipTimer);//如果定时器存在则关闭ui蒙版定时器
        this.showTipTimer = null;
    }
   
    this.$becallview.toggleClass("hide", false);//显示通话（被叫界面 或者是通话界面）盒子
    this.$beCallingBox.toggleClass("hide", false);//宣布事故被叫界面盒子
    var text = " 邀请" + (type === Netcall.NETCALL_TYPE_VIDEO ? "视频" : "音频") + "通话...";

    var info = {};
    info = this.yx.cache.getUserById(this.netcallAccount);//获得用户的信息
    //info.nick = this.yx.getNick(this.netcallAccount);//获取用户的昵称等
 
    this.$beCallingText.text(text);

    //this.$beCallingBox.find(".nick").text(info.nick); //用户昵称
    this.$beCallingBox.find('img').attr('src', getAvatar(info.avatar));//用户头像

   // this.resizeChatContent();
};
// 发起方显示通话界面
/*fn.showCallingUI = function () {
    this.$netcallBox.toggleClass("calling", true);
    $("#toggleFullScreenButton").toggleClass("hide", false);
    $("#switchToVideo").toggleClass("hide", true);
    $("#switchToAudio").toggleClass("hide", true);
    if (this.yx.crtSessionType === "p2p" && this.yx.crtSessionAccount === this.netcallAccount) {
        this.$chatBox.toggleClass("show-netcall-box", true);
        var top = $('#chatContent').scrollTop()
        $('#chatContent').scrollTop(top + 324)
    }
    this.$callingBox.toggleClass("hide", false);
    var info = this.yx.cache.getUserById(this.netcallAccount);
    this.$netcallBox.find(".top").toggleClass('hide', false);
    this.$callingBox.find(".nick").text(this.yx.getNick(this.netcallAccount));
    this.$callingBox.find('img').attr('src', getAvatar(info.avatar));

    this.$videoShowBox.toggleClass("hide", true);
    this.$beCallingBox.toggleClass("hide", true);
    this.$goNetcall.find(".tip").text("接通中...");
    this.$goNetcall.find(".netcall-icon-state").toggleClass("netcall-icon-state-audio", this.type === Netcall.NETCALL_TYPE_AUDIO).toggleClass("netcall-icon-state-video", this.type === Netcall.NETCALL_TYPE_VIDEO);
};*/
/**
 * 点击发起音视频通话按钮
 * @param {number} type 通话类型
 * 1: NETCALL_TYPE_AUDIO 音频通话
 * 2: NETCALL_TYPE_VIDEO 视频通话
 */
fn.onClickNetcallLink = function (type) {
    var that = this;
    // 已经处于音视频通话中，弹窗提示
    // 已经处于互动白板流程中，弹窗提示
    var WB = window.yunXin.WB
    if (that.netcallActive || WB.isCalling || WB.isCalled) {
        minAlert.alert({
            type: 'error',
            msg: (WB.isCalling || WB.isCalled) ? '正在互动白板流程中，无法发起通话' : '正在通话中，无法发起新的通话', //消息主体
            cancelBtnMsg: '知道了' //取消按钮的按钮内容
        });
        return;
    }

    // p2p场景
    if (that.yx.crtSessionType === 'p2p') {
    	//显示调用方案UI
        this.displayCallMethodUI(deviceCheck.bind(that))
        return;
    }
    
    // team多人场景: 人数少于2人的多人视频
   /* var tn = that.yx.crtSessionAccount;
    that.yx.getTeamMembers(tn, function () {
        if (that.yx.cache.getTeamMembers(tn).members.length < 2) {
            that.showTip('无法发起，人数少于2人', 2000);
            return;
        }
        that.displayCallMethodUI(deviceCheck.bind(that))
        // deviceCheck.call(that);
    });*/

    // 下一步操作
    function next() {
        that.type = type;
        if (that.yx.crtSessionType === 'p2p') {
            that.doCalling.call(that, type)
            return;
        }
        //多人音视频
        that.showMeetingMemberListUI(type, that.yx.crtSessionAccount)
    }
    //设备检查
    function deviceCheck(data) {

        this.callMethod = data.type;//通话的类型
        this.callMethodRemember = data.type;// 通话方式选择，是WebRTC还是Netcall，第一次进行选择后记住选择

        // WebRTC模式
        if (data.type === 'webrtc') {
            this.netcall = this.webrtc;
            return next()
        }

        // agent模式
        this.netcall = this.webnet;
        // 检查设备支持情况
        that.checkNetcallSupporting(function () {
            that.netcall = that.webnet;
            next()
        }, reject, reject);

        function reject() {
            // 平台检查失败的处理
            if (that.yx.crtSessionType === 'team') {
                // that.sendTeamTip('发起视频通话失败', true)
                // 注：上面那种写法单单在IE10下面会报错说找不到sendTeamTip这个方法！！
                that.yx.sendTeamNetCallTip({
                    teamId: that.yx.crtSessionAccount,
                    account: that.yx.accid,
                    message: '发起视频通话失败',
                    isLocal: true
                });
            }
        }
    }
};
/** 错误事件响应，是应该下载插件还是重试 */
fn.clickAgentEvent = function (e) {
    var errorType = $(e.target).data('error-type');
    if (errorType === 'device_busy') {
        this.reCheckAgent();
        return;
    }
    this.clickDownloadAgent();
}
fn.reCheckAgent = function (e) {
    var that = this;
    function successCb() {
        that.updateBeCallingSupportUI(true);
    }
    function failureCb() {
        that.reject();
    }
    that.doAgentIntallCheck(successCb, failureCb);
}
fn.clickDownloadAgent = function (successCb, failureCb, isWhiteboard) {
    // location.href = this.agentDownloadUrl;
    window.open(this.agentDownloadUrl)
    if (!successCb) {
        successCb = function () {
            this.updateBeCallingSupportUI(true);
        }
        successCb = successCb.bind(this);
    }
    if (!failureCb) {
        failureCb = function () {
            this.updateBeCallingSupportUI(false);
        }
        failureCb = failureCb.bind(this);
    }
    var closeDialog = this.showAgentInstallConfirmDialog(function () {
        closeDialog();
        this.doAgentIntallCheck(successCb, failureCb, isWhiteboard);
    }.bind(this), function () {
        failureCb();
    });
};
//检查是否支持 视频通话  platformReject:平台形式拒绝   onlyCheckingSignal: 只检查信号  notShowCheckingDialog:没有显示检查对话框
fn.checkNetcallSupporting = function (done, platformReject, agentReject, onlyCheckingSignal, notShowCheckingDialog) {
    if (this.signalInited) {//如果几经检查通过了
        return done(); //完成
    }
    // 检查是否支持插件
    // 1. 检查操作系统和浏览器
    // 2. 检查是否能连通agent
    this.checkPlatform(function () {
    	//检查通过
        this.checkAgentWorking(done, agentReject, onlyCheckingSignal, notShowCheckingDialog);
    }.bind(this), platformReject)

    
    // mac测试，后期需要删除
    // this.checkAgentWorking(done, agentReject, onlyCheckingSignal, notShowCheckingDialog);
};
//检查平台形式
fn.checkPlatform = function (done, failure) {
	//失败回调函数
    failure = failure || function () { };
    if (platform.os.family.indexOf("Windows") !== -1 && (platform.os.version === "10" || platform.os.version === "7")) { // 判断是否是win7或win10
        if (/Chrome/gi.test(platform.name) || platform.name === "Microsoft Edge" || (platform.name === "IE" && platform.version === "11.0")) { // 判断是否是Chrome, Edge, IE 11
            done(); //如果支持则调用
        } else {
            // alert("只支持Chrome、Edge、IE 11");
            minAlert.alert({
                type: 'error',
                msg: '当前浏览器不支持音视频功能，请使用 Chrome、IE 11 或者 Edge 浏览器', //消息主体
                cancelBtnMsg: '知道了，挂断', //取消按钮的按钮内容
                cbCancel: failure
            });
        }
    } else {
        // alert("只支持win7或win10");
        minAlert.alert({
            type: 'error',
            msg: '当前系统不支持音视频功能，请使用win7、win10系统', //消息主体
            cancelBtnMsg: '知道了，挂断', //取消按钮的按钮内容
            cbCancel: failure
        });
    }
};
//更新正在调用支持UI isSupport:是支持 显示检查
fn.updateBeCallingSupportUI = function (isSupport, showChecking, errObj) {
    this.$beCallingBox.find(".checking-tip").toggleClass("hide", !showChecking); //插件检查中  规定是否添加(true)或移除(false)类。
    this.$beCallingAcceptButton.toggleClass("disabled", !!showChecking);

    this.$beCallingBox.find(".op").toggleClass("no-agent", !isSupport);
    errObj = errObj || {};
    var msg = errObj && errObj.constructor === Object ? errObj.error : "下载音视频插件";
    this.$beCallingBox.find("#downloadAgentButton").text(msg);
    if (errObj.errorType) {
        this.$beCallingBox.find("#downloadAgentButton").data('error-type', errObj.errorType);
    }

};
/*检查agent是否工作*/
fn.checkAgentWorking = function (done, failure, onlyCheckingSignal, notShowCheckingDialog, isWhiteboard) {
    console.log("checkAgentWorking");
    failure = failure || function () { };
    done = done || function () { };
    var closeCheckingDialog = function () { };
    var canceled = false;
    if (!notShowCheckingDialog) {
        closeCheckingDialog = this.showCheckingDialog(function () {
            // 点击弹框x时
            canceled = true;
            failure();
        });
    }
    console.log("start netcall initSignal");
    this.netcall.initSignal().then(function () {
        console.log("netcall initSignal success");
        this.signalInited = true;
        if (canceled) return;
        if (notShowCheckingDialog) return done();
        closeCheckingDialog();
        var closeSuccessDialog = this.showSuccessDialog(function () {
            done();
            closeSuccessDialog();
        });

    }.bind(this)).catch(function (err) {
        console.log("netcall initSignal error", err);
        if (canceled) return;
        // alert("未检测到agent");
        closeCheckingDialog();

        if (onlyCheckingSignal) return failure(err);
        this.showAgentNeedInstallDialog(err, done, failure, isWhiteboard);
    }.bind(this));
};
//显示代理需要安装对话框
fn.showAgentNeedInstallDialog = function (errOjb, successCb, failureCb, isWhiteboard) {
    var that = this;
    var msg_text = isWhiteboard ? '请安装插件PC Agent，方可使用白板互动功能。白板功能中的音频功能需要此插件的支持' : (errOjb.error || "请安装插件PC Agent，方可使用音视频功能");
    var errorType = errOjb.errorType || "agent_empty";
    var btn_text = (errorType === "device_busy" ? "已解决，重试" : "下载插件");
    minAlert.alert({
        type: 'error',
        msg: msg_text, //消息主体
        subMsg: '拒绝调用插件申请会导致无法唤起插件,需重启浏览器',
        cancelBtnMsg: isWhiteboard ? (window.yunXin.WB.isCalled ? '拒绝邀请' : '结束邀请') : '不使用音视频', //取消按钮的按钮内容
        confirmBtnMsg: btn_text,
        cbCancel: failureCb,
        cbConfirm: function () {
            if (errorType === "device_busy") {
                that.doAgentIntallCheck(successCb, failureCb, isWhiteboard);
                return;
            }
            // location.href = that.agentDownloadUrl;
            window.open(that.agentDownloadUrl)
            var closeDialog = that.showAgentInstallConfirmDialog(function () {
                closeDialog();
                that.doAgentIntallCheck(successCb, failureCb, isWhiteboard);
            }, function () {
                failureCb();
            });
        }
    });

};
//做代理安装检查
fn.doAgentIntallCheck = function (successCb, failureCb, isWhiteboard) {
    successCb = successCb || function () { };
    failureCb = failureCb || function () { };
    console.log("do checking");
    var canceled = false;
    var closeCheckingDialog = this.showCheckingDialog(function () {
        // 点击x关闭弹窗时
        canceled = true;
        failureCb();
    });
    console.log("start netcall initSignal");
    this.netcall.initSignal().then(function () {
        console.log("netcall initSignal success");
        this.signalInited = true;
        if (canceled) return;
        closeCheckingDialog();
        var closeSuccessDialog = this.showSuccessDialog(function () {
            closeSuccessDialog();
            successCb();
        });

    }.bind(this)).catch(function (err) {

        console.log("netcall initSignal error", err);
        if (canceled) return;
        // alert("未检测到agent");
        closeCheckingDialog();
        var closeDialog = this.showAgentCheckingFailureDialog(err, function () {
            this.doAgentIntallCheck(successCb, failureCb, isWhiteboard);
            // closeDialog();

        }.bind(this), function () {
            closeDialog();
            failureCb();
        }, isWhiteboard)
    }.bind(this))
};
//显示代理检查失败对话框
fn.showAgentCheckingFailureDialog = function (errOjb, done, reject, isWhiteboard) {
    var text = isWhiteboard ? '未检测到插件！请确认已安装插件并未被占用' : (errOjb.error || "未检测到插件！请确认已安装插件并未被占用");
    var errorType = errOjb.errorType;
    minAlert.alert({
        type: 'error',
        msg: text, //消息主体
        subMsg: '拒绝调用插件申请会导致无法唤起插件,需重启浏览器',
        cancelBtnMsg: isWhiteboard ? (window.yunXin.WB.isCalled ? '拒绝邀请' : '结束邀请') : '不使用音视频', //取消按钮的按钮内容
        confirmBtnMsg: '已解决，重试',
        cbCancel: reject,
        cbConfirm: done
    });

    return function () {
        minAlert.close();
    };
};
//显示代理安装确认对话框
fn.showAgentInstallConfirmDialog = function (done, failure) {
    minAlert.alert({
        type: 'error',
        msg: '下载完成后，需手动安装插件', //消息主体
        confirmBtnMsg: '已安装', //取消按钮的按钮内容
        showCancel: false,
        cbConfirm: done,
        cbCancel: failure
    });
    return function () {
        minAlert.close();
    };
};
//显示检查对话框
fn.showCheckingDialog = function (onCancel) {
    minAlert.alert({
        type: 'error',
        msg: '检查插件中...<span class="netcall-icon-checking"></span>', //消息主体
        showCancel: false,
        cbCancel: onCancel
    });
    return function () {
        minAlert.close();
    };
};
//显示成功对话框
fn.showSuccessDialog = function (done) {
    var timer;
    function agree() {
        clearTimeout(timer);
        done();
    }
    timer = setTimeout(agree, 1000);
    minAlert.alert({
        type: 'success',
        msg: '成功检测到插件！', //消息主体
        confirmBtnMsg: '自动跳转...', //取消按钮的按钮内容
        showCancel: false,
        cbConfirm: agree
    });
    return function () {
        minAlert.close();
        clearTimeout(timer);
    };
};
/** 点击左侧列表，打开聊天窗口时，判断是否是单人聊天，调整ui
 * 是否当前在通话中，切换了别的窗口
 */
fn.whenOpenChatBox = function (scene, account) {
    // this.$msgInput.toggleClass("p2p", scene === "p2p");
    /** 多人或者我的手机隐藏音频按钮 */
    this.$netcallAudioLink.toggleClass("hide", scene !== "p2p" || account === userUID);
    /** 我的手机隐藏视频按钮 */ 
    this.$netcallVideoLink.toggleClass("hide", account === userUID);
    /** 多人或者我的手机隐藏白板按钮 */
    $('#showWhiteboard').toggleClass("hide", scene !== "p2p" || account === userUID);
    // this.$netcallVideoLink.toggleClass("hide", scene !== "p2p");

    /** 当前正在白板互动中，但窗口并非白板窗口，显示右上角提示框 */
    if (window.yunXin.WB) {
        if (window.yunXin.WB.isCalled || window.yunXin.WB.isCalling) {
            window.yunXin.WB.$goWhiteboard.toggleClass("hide", account === window.yunXin.WB.account);
            if (account !== window.yunXin.WB.account) {
                window.yunXin.WB.$goWhiteboard.find('.nick').text(window.yunXin.WB.nick)
                window.yunXin.WB.$goWhiteboard.find('.tip').text(
                    window.yunXin.WB.connected ? '互动中 ...' :
                    (window.yunXin.WB.isCalled ? '等待接受邀请...' : '发起中...')
                )
            }
        } else {
            window.yunXin.WB.$goWhiteboard.toggleClass("hide", true);
        }
    }
        
    /** 当前正在通话中或者被叫中 */
    if (this.netcallActive || this.beCalling) {
        isOtherBoxDisable = $('#teamInfoContainer').hasClass('hide') && $('#cloudMsgContainer').hasClass('hide')
        this.$goNetcall.toggleClass("hide", account === this.netcallAccount && isOtherBoxDisable);

        this.$chatBox.toggleClass("show-netcall-box", account === this.netcallAccount);

        this.$chatBox.toggleClass("hide-netcall-box", account !== this.netcallAccount);
    }
    // this.$goNetcall.toggleClass("hide", !this.netcallActive || account === this.netcallAccount);

    //this.resizeChatContent();
};
/** 动态更改文字聊天窗口的高度 */
/*fn.resizeChatContent = function (scene, account) {
    var h = this.yx.$chatTitle.height();
    h = h + (this.$chatBox.hasClass('show-netcall-box') ? this.$netcallBox.height() : 0);
    *//** 最小值81 *//*
    h = h >= 81 ? h : 81;
    var top = this.yx.$chatContent.position().top;

    if (h === top) return;
    this.yx.$chatContent.css({
        top: (h + 1) + 'px'
    });
};*/
//获得时间
fn.getDurationText = function (ms) {
    var allSeconds = parseInt(ms / 1000);
    var result = "";
    var hours, minutes, seconds;
    if (allSeconds >= 3600) {
        hours = parseInt(allSeconds / 3600);
        result += ("00" + hours).slice(-2) + " : ";
    }
    if (allSeconds >= 60) {
        minutes = parseInt(allSeconds % 3600 / 60);
        result += ("00" + minutes).slice(-2) + " : ";
    } else {
        result += "00 : ";
    }
    seconds = parseInt(allSeconds % 3600 % 60);
    result += ("00" + seconds).slice(-2);
    return result;
};

/** 通话计时器
 * 场景：p2p音视频 / 多人音视频
 * @param {dom对象} box 倒计时容器
 */
fn.startDurationTimer = function (box) {
    box = box || $(".netcall-show-audio .tip,.netcall-show-video .tip,.asideBox .tip,.netcall-meeting-box .option-box .tip");
    this.clearDurationTimer();
    function timer() {
        var now = (new Date()).getTime();
        this.netcallDuration = now - this.netcallStartTime;
        var timeText = this.getDurationText(this.netcallDuration);
        box.text(timeText);
    }
    timer = timer.bind(this);
    this.netcallDuration = 0;
    this.netcallStartTime = (new Date()).getTime();
    this.netcallDurationTimer = setInterval(timer, 500);
    timer();
};
fn.clearDurationTimer = function () {
    if (this.netcallDurationTimer) {
        clearInterval(this.netcallDurationTimer);
        this.netcallDurationTimer = null;
    }
};

/***************多人音视频的UI部分******************************/
/**
 * 选择好友列表ui
 */
fn.showMeetingMemberListUI = function () {
    this.getMeetingMemberListUI()
}
/**
 * 选择通话方式
 */
fn.displayCallMethodUI = function (cbSuccess, cbFail) {
    var that = this
    function next(data) {

        console.log('选择情况', data)

        // 检查WebRTC情况
        if (data.type === 'webrtc') {
            var versionSupport = this.checkRtcBrowser()
            that.isRtcSupported = versionSupport && rtcSupport.supportGetUserMedia && rtcSupport.supportRTCPeerConnection && rtcSupport.supportMediaStream
            if (!that.isRtcSupported) {
                minAlert.alert({
                    type: 'error',
                    msg: '当前浏览器不支持WebRTC功能或H264的编解码格式, 无法使用音视频功能, 请使用最新版Chrome、Firefox浏览器',
                    confirmBtnMsg: '知道了，挂断',
                    cbConfirm: function () { //确定
                        cbFail && cbFail(data) 
                    },
                    cbCancel: function () { //取消
                        cbFail && cbFail(data)
                    }
                })
                return
            }
            if (!rtcSupport.supportWebAudio) {
                that.isRtcSupported = false
                minAlert.alert({
                    type: 'error',
                    msg: '当前浏览器不支持完整的WebAudio功能, 无法使用音视频功能, 请使用最新版chrome、Firefox浏览器',
                    confirmBtnMsg: '知道了，挂断',
                    cbConfirm: function () {
                        cbFail && cbFail(data)
                    },
                    cbCancel: function () {
                        cbFail && cbFail(data)
                    }
                })
                return
            }
            return cbSuccess && cbSuccess(data)
        }

        that.isRtcSupported = false;
        cbSuccess && cbSuccess(data)
        // console.log(data);
    }
    //打开界面
    this.dialog_call.open({
        callMethod: this.callMethod,//方案
        cbConfirm: next, //点击确认的回调函数
        yx: this.yx,
        env: this,
    })
};

fn.checkRtcBrowser = function () {
    var test = platform.ua.match(/(chrome|firefox)\/(\d+)/i)
    if (!test || /Edge\/([\d.]+)/.test(platform.ua)) return false
    var name = test[1], version = test[2]
    return (/chrome/i.test(name) && version > 57 || /firefox/i.test(name) && version > 56)
}

/****方案选择的UI弹框 */
