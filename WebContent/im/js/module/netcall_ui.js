/*
 * 1. 点对点音视频通话中对应的ui相关逻辑
 * 2. 多人音视频相关UI逻辑
*/

var fn = NetcallBridge.prototype;
// 每当设备信息发生变化时，调用此方法同步设备控制按钮状态和提示信息，更新设备输入,更新视频画面提示信息等
fn.checkDeviceStateUI = function () {
    var temp = this.netcall
    var p1 = this.netcall.getDevicesOfType(Netcall.DEVICE_TYPE_VIDEO).then(function (obj) {
    	console.log("摄像头变化")
        var $camera = $(".netcall-box .camera.control-item");
        if (obj.length || (obj.devices && obj.devices.length)) {
            // 摄像头从无到有的变化
            if ($camera.is(".no-device")) {
                // 更新ui
                $camera.toggleClass("no-device", false).attr("title", "");
                // rtc模式检测
//                if (this.callMethod === 'webrtc') {
//                	//设备需要视频
//                    if (!temp.devices.needVideo) {
//                        return Promise.resolve() 
//                    }
//                }
                // 开启摄像头
                this.setDeviceVideoIn(true);
                this.isRtcSupported && this.startLocalStream() && this.this.setVideoViewSize()           

                $(".netcall-video-local").toggleClass("empty", false);
                $(".netcall-video-local .message").text("");
            }
        } else {
            this.onDeviceNoUsable(Netcall.DEVICE_TYPE_VIDEO);
        }
    }.bind(this));
    var p2 = this.netcall.getDevicesOfType(Netcall.DEVICE_TYPE_AUDIO_IN).then(function (obj) {
    	console.log("麦克风变化")
        var $microphone = $(".netcall-box .microphone.control-item");

        if (obj.length || (obj.devices && obj.devices.length)) {
            if ($microphone.is(".no-device")) {
                // 更新ui
                $microphone.toggleClass("no-device", false).attr("title", "");
                // rtc模式检测
//                if (this.callMethod === 'webrtc') {
//                    if (!temp.devices.needAudio) {
//                        return Promise.resolve()
//                    }
//                }
                this.setDeviceAudioIn(true);
            }
        } else {
            this.onDeviceNoUsable(Netcall.DEVICE_TYPE_AUDIO_IN);
            // $microphone.toggleClass("no-device", true).attr("title", "麦克风不可用");
        }
    }.bind(this));
    var p3 = this.netcall.getDevicesOfType(Netcall.DEVICE_TYPE_AUDIO_OUT_CHAT).then(function (obj) {
    	console.log("音量变化")
        var $volume = $(".netcall-box .volume.control-item");
        if (obj.length || (obj.devices && obj.devices.length)) {
            if ($volume.is(".no-device")) {
                this.setDeviceAudioOut(true);
            }
            $volume.toggleClass("no-device", false).attr("title", "");
        } else {
            this.onDeviceNoUsable(Netcall.DEVICE_TYPE_AUDIO_OUT_CHAT);
             //$volume.toggleClass("no-device", true).attr("title", "麦克风不可用");
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
}
// 切换对方我方画面位置, 需要重写!
fn.switchViewPosition = function () {
    var $smallView = $(".netcall-box .smallView");
    var $bigView = $(".netcall-box .bigView");
    var $smallParent = $smallView[0].parentNode;
    var $bigParent = $bigView[0].parentNode;
    $bigView.prependTo($smallParent).addClass("smallView").removeClass("bigView");
    $smallView.prependTo($bigParent).addClass("bigView").removeClass("smallView");

    // video标签位置移动以后，会变为pause(暂停)状态，需要重新play(演奏)
    this.$netcallBox.find("video").each(function () {
        if (this.paused) this.play();
    })
    this.updateVideoShowSize(true, true);
};
//切换全屏
fn.toggleFullScreen = function (e) {
    console.log(e)
    this.isFullScreen = e && !$(e.target).hasClass('active'); //不活跃 
    this.$netcallBox.toggleClass("fullscreen", this.isFullScreen);//界面变大
    // p2p模式
    this.$netcallBox.find(".fullScreenIcon").toggleClass("full", this.isFullScreen); //箭头向内
    this.updateVideoShowSize(true, true);
    e && $(e.target).toggleClass('active');
    return
};
// UI界面蒙版展示提示信息，指定时间后消失，消失后执行回调函数
fn.showTip = function (message, duration, done) {
    $(".netcall-mask").toggleClass("hide", false).find(".netcallTip").text(message);
    this.showTipTimer = setTimeout(function () {
        $(".netcall-mask").toggleClass("hide", true).find(".netcallTip").text("");
        done && done();//存在回调函数则执行
        this.showTipTimer = null;
    }.bind(this), duration);
};
// 更新视频画面显示尺寸
fn.updateVideoShowSize = function (local, remote) {
    var bigSize = {
        cut: true,
        width: this.isFullScreen ? 640 : 400,//320,
        height: this.isFullScreen ? 480 : 300//240
    };
    var smallSize = {
        cut: true,
        width: this.isFullScreen ? 240 : 180,// 160,
        height: this.isFullScreen ? 180 : 140//120
    };
    if (local) {
        var isBig = $(".netcall-video-local").is(".bigView")
        console.log('local big?', isBig, isBig ? bigSize : smallSize)
        //设置视频视图大小
        this.netcall.setVideoViewSize(isBig ? bigSize : smallSize);
    }
    if (remote) {
        var isBig = $(".netcall-video-remote").is(".bigView")
        console.log('remote big?', isBig, isBig ? bigSize : smallSize)
        //设置视频查看远程大小
        this.netcall.setVideoViewRemoteSize(isBig ? bigSize : smallSize);
    }
};

fn.hideAllNetcallUI = function () {
	//删除忙碌中的 增加活跃中的
	free();
	//开始刷新
	refershFun();

    this.clearRingPlay(); //关闭声音
    this.clearDurationTimer(); //通话时间定时器
    this.clearBeCallTimer(); //关闭被叫定时器
    
    //播放声音画面相关: (己方本地操作，对端不受影响)
    this.stopRemoteStream();//关闭自己画面
    this.stopLocalStream();//关闭对方画面
    window.custom=null;
    window.channelId=null;
    this.netcallActive = false; //被叫不活跃
    this.netcallAccount = ""; //清空被叫accid

    this.$becallview.toggleClass("hide", true);//隐藏被叫ui
    $(".netcall-video-local").toggleClass("empty", false);
    $(".netcall-video-local .message").text("");
    $(".netcall-video-remote").toggleClass("empty", false);
    $(".netcall-video-remote .message").text("");
    this.$beCallingAcceptButton.toggleClass("loading", false); //清除被叫链接状态
    $(".netcall-mask").toggleClass("hide", true);
    this.$viedoview.toggleClass("hide", true);//隐藏通话界面
    this.$becallandcontent.toggleClass("hide", false);//显示主界面
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

    if (this.showTipTimer) {
        clearTimeout(this.showTipTimer);
        this.showTipTimer = null;
    }
    this.log("隐藏通话界面");
   // this.resizeChatContent();
};
// 通话建立成功后，展示视频通话或者音频通话画面
fn.showConnectedUI = function (type) {
	console.log("视频对话UI界面展示")
    this.checkDeviceStateUI();//检查设备UI
    this.$toggleFullScreenButton.toggleClass("hide", false);
    this.$netcallBox.find(".top").toggleClass('hide', false);//显示切换全屏按钮
    //如果不为视频通话则隐藏
    this.$videoShowBox.toggleClass("hide", type !== Netcall.NETCALL_TYPE_VIDEO);
    this.$becallview.toggleClass("hide", true);//隐藏发起界面
    this.$becallandcontent.toggleClass("hide", true);//隐藏主界面
    this.$viedoview.toggleClass("hide",false); //显示另外一个界面
};

/** 接收方显示来电界面，兼容多人音视频
 * 
 * @param {string} type 通话类型，1： 音频，2：视频
 * @param {string} scene 通话场景，p2p(默认值) / team
 * @param {object} option 通话场景，p2p(默认值) / team
 */
fn.showBeCallingUI = function (type, scene) {
    scene = scene || 'p2p';
    this.type = type;
    this.$toggleFullScreenButton.toggleClass("hide", true);//隐藏切换全屏按钮
    this.clearRingPlay();//关闭声音
    if (this.showTipTimer) {
        clearTimeout(this.showTipTimer);//如果定时器存在则关闭ui蒙版定时器
        this.showTipTimer = null;
    }
    this.$becallview.toggleClass("hide", false);//显示通话（被叫界面 或者是通话界面）盒子
    //this.$becallview.find('img').attr('src','images/default-icon.png');//用户头像
    var text ="<span style='color:#388bd4'>"+this.beCallData.c_name+"</span>邀请视频通话...";
    this.$beCallingText.html(text);
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
    this.$becallview.find(".checking-tip").toggleClass("hide", !showChecking); //插件检查中  规定是否添加(true)或移除(false)类。
    this.$beCallingAcceptButton.toggleClass("disabled", !!showChecking);//接听按钮不可用

    this.$becallview.find(".op").toggleClass("no-agent", !isSupport);//显示例外
    errObj = errObj || {};
    var msg = errObj && errObj.constructor === Object ? errObj.error : "下载音视频插件";
    this.$becallview.find("#downloadAgentButton").text(msg);
    if (errObj.errorType) {
    	//data() 方法向被选元素附加数据，或者从被选元素获取数据。 详情:http://www.w3school.com.cn/jquery/data_jquery_data.asp
        this.$becallview.find("#downloadAgentButton").data('error-type', errObj.errorType);
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

//获得时间
fn.getDurationText = function (ms) {
    var allSeconds = parseInt(ms / 1000);//秒
    var result = "";
    var hours, minutes, seconds;
/*    if (allSeconds >= 3600) {
        hours = parseInt(allSeconds / 3600); //小时
        result += ("00" + hours).slice(-2) + " : ";
    }*/
    if (allSeconds >= 60) {
        minutes = parseInt(allSeconds % 3600 / 60);//分钟
        result += ("00" + minutes).slice(-2) + "分";
    } else {
        result += "00分";
    }
    seconds = parseInt(allSeconds % 3600 % 60);//秒
    result += ("00" + seconds).slice(-2)+"秒";
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
        var timeText=this.getDurationText(now - this.netcallStartTime);
        this.netcallDuration =timeText
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
