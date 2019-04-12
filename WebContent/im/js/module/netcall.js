/*
 * 点对点音视频通话控制逻辑
 * 注：由于融合了WebRTC和Netcall两种音视频sdk，需要进行如下处理
 * 1. 分别初始化两种实例 webrtc(WebRTC) / webnet(Netcall), 注册各种事件
 * 2. 逻辑里真正调用的sdk API需要通过一个 bridge(目前名字叫netcall) 进行桥接选择当前使用的sdk，默认使用 Netcall 方式
 */
function NetcallBridge(yx) {
	  	  this.yx = yx;
	      this.$becallview=$(".becall-view")//被叫视图
	      //1.1级盒子 
	      this.$becallandcontent=$("#becall-content")
	      //1.2級盒子
	      this.$viedoview=$("#viedo-view");
	      //点对点视频盒子
	  	  this.$netcallBox=$("#netcallBox");
	  	  //p2p视频界面
	  	  this.$videoShowBox = $(".netcall-show-video");
	  	  
	      this.$beCallingAcceptButton = $(".beCallingAcceptButton");//被叫接听
	      this.$beCallingRejectButton = $(".beCallingRejectButton");//被叫拒绝
	      
	      this.$hangupButton = $(".hangupButton");//视频挂断按钮
	      this.$beCallingText = $("#becallingText"); //被叫内容提示 
	      this.$toggleFullScreenButton = $(".toggleFullScreenButton");//切换全屏
	      this.$switchViewPositionButton = $(".switchViewPositionButton");//切换视图位置按钮
	      this.$videoRemoteBox = this.$netcallBox.find(".netcall-video-remote");//远程的视频
	      //this.$videoLocalBox = this.$netcallBox.find(".netcall-video-local");//自己的视频
	      //麦克风 扬声器 摄像头 控制按钮
	      this.$controlItem = this.$netcallBox.find(".control-item");
	      //被呼叫超时检查定时器
	      this.beCallTimer = null;
	      //是否处于通话流程中
	      this.netcallActive = false;
	      //通话的channelId
	      this.channelId = null;
	      //通话流程的另一方账户
	      this.netcallAccount = "";
	      //通话时间长度
	      this.netcallDuration = 0;
	      //通话正式开始时间戳
	      this.netcallStartTime = 0;
	      //通话时长定时器
	      this.netcallDurationTimer = null;
	      //音视频流配置
	      this.sessionConfig = {
	          videoQuality: Netcall.CHAT_VIDEO_QUALITY_720P, //传输的视频分辨率
	          videoFrameRate: Netcall.CHAT_VIDEO_FRAME_RATE_NORMAL,//传输的视频帧率，实际帧率因画面采集频率和机器性能限制可能达不到期望值
	          videoBitrate: 0,//传输的视频码率, >=100000 <= 5000000 有效(PC Agent适用)
	          recordVideo: true,//是否开启服务器端的视频录制，默认不开
	          recordAudio: true,//是否开启服务器端的音频录制，默认不开
	          highAudio: true, //高清语音开关, 默认关闭
	          isHostSpeaker:false,
	          recordType:1  //recordType: type表示录制模式，默认为0表示参与混合录制并且录制单人文件，可以配置为1表示只参与混合录制，2表示只录制单人文件
	      };
	      // 是否开启摄像头输入
	      this.deviceVideoInOn = true;
	      // 是否开启音频输入
	      this.deviceAudioInOn = true;
	      // 是否开启扬声器输出
	      this.deviceAudioOutOn = true;
	      // 是否全屏状态
	      this.isFullScreen = false;
	      // 多人音视频的缓存对象
	      //this.meetingCall = {};
	      // 本地agent连接状态
	      this.signalInited = false;
	      // agent程序下载地址
	      this.agentDownloadUrl = "http://yx-web.nos.netease.com/package%2FWebAgent_Setup_V2.7.0.710.zip";
	      // 当前视频状态，是桌面共享还是视频: video / window / screen
	      this.videoType = 'video'
	     /* 是否支持rtc*/
	      this.isRtcSupported = true;
	      // 通话方式选择，是WebRTC还是Netcall，每次发起通话都要进行选择, 值有: WebRTC / Netcall
	      this.callMethod = "";
	      // 通话方式选择，是WebRTC还是Netcall，第一次进行选择后记住选择
	      this.callMethodRemember = "";
	      // 真正业务调用的 API 桥, 在进行通话方式选择之后赋值对应的实例
	      this.netcall = null;
	      // 开始初始化
	      this.init();
}
var fn = NetcallBridge.fn = NetcallBridge.prototype;
fn.init = function () {
    this.initEvent();
    this.initNetcall();
};
//初始化事件
fn.initEvent = function () {
    var that = this;
    // 被呼叫中接受
    this.$beCallingAcceptButton.on("click", this.accept.bind(this));
    // 被呼叫中拒绝
    this.$beCallingRejectButton.on("click", this.reject.bind(this));
    //下载音视频插件
    this.$becallview.find("#downloadAgentButton").on("click", this.clickAgentEvent.bind(this));
    // 通话中挂断
    this.$hangupButton.on("click", this.hangup.bind(this));
    this.$toggleFullScreenButton.on("click", this.toggleFullScreen.bind(this));
    // 视频通话时，切换自己和对方的画面显示位置
    this.$switchViewPositionButton.on("click", this.switchViewPosition.bind(this));
    // 离开页面调用destroy
    window.addEventListener('beforeunload', this.beforeunload.bind(this));
    // 点击扬声器控制按钮
    this.volumeDebounceState = null;
    this.volumeStateTimeout = null;
    this.$netcallBox.on('click', '.icon-volume', function (event) {
        if ($(event.target).parent().is(".no-device")) return;
        if (this.volumeDebounceState !== null) {
            this.volumeDebounceState = !this.volumeDebounceState;
        } else {
            this.volumeDebounceState = !this.deviceAudioOutOn;
        }
        if (this.volumeStateTimeout) clearTimeout(this.volumeStateTimeout);
        this.volumeStateTimeout = setTimeout(function () {
            this.volumeStateTimeout = null;
            if (this.volumeDebounceState !== this.deviceAudioOutOn) {
                var nextState = !this.deviceAudioOutOn
                that.setDeviceAudioOut(nextState);
                this.deviceAudioOutOn = nextState;
            }
            this.volumeDebounceState = null;
        }.bind(this), 300)
        $(".icon-volume").toggleClass("icon-disabled", !this.volumeDebounceState);
    }.bind(this));

    // 点击麦克风控制按钮
    this.microDebounceState = null;
    this.microStateTimeout = null;
    this.$netcallBox.on('click', '.icon-micro', function (event) {
        if ($(event.target).parent().is(".no-device")) return;
        if (this.microDebounceState !== null) {
            this.microDebounceState = !this.microDebounceState;
        } else {
            this.microDebounceState = !this.deviceAudioInOn;
        }
        if (this.microStateTimeout) clearTimeout(this.microStateTimeout);
        this.microStateTimeout = setTimeout(function () {
            this.microStateTimeout = null;
            if (this.microDebounceState !== this.deviceAudioInOn) {
                var nextState = !this.deviceAudioInOn;
                this.setDeviceAudioIn(nextState);
                this.deviceAudioInOn = nextState;
            }
            this.microDebounceState = null;
        }.bind(this), 300)
        $(".icon-micro").toggleClass("icon-disabled", !this.microDebounceState);
    }.bind(this));

    // 点击摄像头控制按钮
    this.cameraDebounceState = null;
    this.cameraStateTimeout = null;
    this.$netcallBox.on('click', '.icon-camera', function (event) {
        if ($(event.target).parent().is(".no-device")) return;
        if (this.cameraDebounceState !== null) {
            this.cameraDebounceState = !this.cameraDebounceState;
        } else {
            this.cameraDebounceState = !this.deviceVideoInOn;
        }
        if (this.cameraStateTimeout) clearTimeout(this.cameraStateTimeout);
        this.cameraStateTimeout = setTimeout(function () {
            this.cameraStateTimeout = null;
            if (this.cameraDebounceState !== this.deviceVideoInOn) {
                var nextState = !this.deviceVideoInOn;
                this.deviceVideoInOn = nextState;
                this.setDeviceVideoIn(nextState)
            }
            this.cameraDebounceState = null;
        }.bind(this), 300)
        $(".icon-camera").toggleClass("icon-disabled", !this.cameraDebounceState);
    }.bind(this));

    // 麦克风、扬声器按钮在hover的时候显示音量调节的slider
    this.$controlItem.hover(function () {
        if (this.hoverTimer) {
            clearTimeout(this.hoverTimer);
            this.hoverTimer = null;
        }
        $(this).find(".slider").removeClass("hide");
    }, function () {
        this.hoverTimer = setTimeout(function () {
            $(this).find(".slider").addClass("hide");
        }.bind(this), 250);
    });
    // 初始化音量调节slider
    function doRangeSliderInit(selector, fn) {
        $(selector).rangeslider({
            polyfill: false,
            onSlide: function (position, value) {
                $(selector).parent().find(".txt").text(value);
            },
            onSlideEnd: function (position, value) {
                this.netcall[fn](parseInt(255 * value / 10));
            }.bind(this)
        });
    }
    doRangeSliderInit = doRangeSliderInit.bind(this);
    //麦克风滑块的输入 设置捕获音量
    //音量滑块的输入 设置播放音量
    var map = {
        ".microSliderInput": "setCaptureVolume",
        ".volumeSliderInput": "setPlayVolume"
    };
    for (var selector in map) {
        doRangeSliderInit(selector, map[selector]);
    }
};
hangupexit=function(channelId,custom,netcallDuration,name){
	layer.confirm('客户'+name+',通话时长'+netcallDuration+'是否通过？', {
		  btn: ['通过','回退'],
		  closeBtn:false
		  //按钮
		}, function(index){
			window.viedoAudit('1',channelId,custom);
			layer.close(index);
		}, function(){
		   window.viedoAudit('3',channelId,custom);
		});
};

viedoAudit =function(value,channelId,custom){
	console.log("请求:"+value+" "+custom+" "+channelId)
	$("#viedo-view").toggleClass("hide", true);//隐藏界面
	$.ajax({
	    url:'../yx/viedoAudit.do',
	    type:'POST',
	    data:{auditstatus:value,customvalue:custom,channel:channelId},
	    dataType:'json',
	    success: function (data) {},
	    error: function(d){
	       console.log(d.status)
	    }
	});
} 

/** 页面卸载事件 */
fn.beforeunload = function (e) {
	//如果单纯的界面卸载事件 直接清空
    if (!this.netcall || !this.netcall.calling){
    	console.log("直接了当的离开界面")
    	window.destroysession();
    }else{//在通话中被挂断的情况   挂断并直接清空
        this.hangup("unload");
    }
}

/** 初始化p2p音视频响应事件 */
fn.initNetcall = function () {
    var NIM = window.SDK.NIM;
    var Netcall = window.Netcall;
    var WebRTC = window.WebRTC;
    NIM.use(WebRTC);
    NIM.use(Netcall);
    var that = this;
    // 初始化webrtc
    window.webrtc = this.webrtc = WebRTC.getInstance({
        nim: window.nim,
        container: $(".netcall-video-local")[0],
        remoteContainer: $(".netcall-video-remote")[0],
        debug: true
    })
    // 初始化netcall
    window.webnet = this.webnet = Netcall.getInstance({
    	 nim: window.nim,//音视频通话是基于 IM 的, 需要传入 NIM 初始化后的实例
         mirror: false,//是否对自己的画面进行镜像处理, 默认 false, 一般来讲请将此参数设置为 true（既自己看自己是反项的）
         mirrorRemote: false,//是否对对方的画面进行镜像处理, 默认 false
         /*kickLast: true,*/ //是否踢掉上次的通话, 默认 false
         container: $(".netcall-video-local")[0],//播放自己视频画面的容器节点
         remoteContainer: $(".netcall-video-remote")[0]//播放对方画面的容器节点
    });
    this.initWebRTCEvent();
    this.initNetcallEvent();
    // 默认使用agent模式
    this.netcall = this.webrtc
    this.callMethod = "webrtc";
};

/** 初始化webrtc事件 */
fn.initWebRTCEvent = function () {
    var webrtc = this.webrtc;
    var that = this;
    // 对方接受通话 或者 我方接受通话，都会触发
    webrtc.on("callAccepted", function (obj) {
        if (this.callMethod !== 'webrtc') return
        this.onCallAccepted(obj);
    }.bind(this));
    webrtc.on("callRejected", function (obj) {
        if (this.callMethod !== 'webrtc') return
        console.log("对方拒绝通话:(callRejected):"+JSON.stringify(obj))
        //this.onCallingRejected(obj);
    }.bind(this));
    // 当信令通道断开时, 会触发 signalClosed 事件
    webrtc.on('signalClosed', function () {
        if (this.callMethod !== 'webrtc') return
        console.log("signal closed");
        this.signalInited = false;
        this.showTip("信令断开了", 2000, function () {
            this.beCalling = false;
            this.beCalledInfo = null;
            this.hideAllNetcallUI();
            this.netcall.hangup();
            this.resetWhenHangup();//释放资源
        }.bind(this));
    }.bind(this));
    webrtc.on('rtcConnectFailed', function () {
        if (this.callMethod !== 'webrtc') return
        console.log("rtcConnectFailed");
        this.showTip("通话连接断开了", 2000, function () {
            this.beCalling = false;
            this.beCalledInfo = null;
            this.netcall.hangup();
            this.hideAllNetcallUI();//隐藏相关ui界面
        }.bind(this));
    }.bind(this));
    // 初始化过程中会通过 devices 事件回传所有的设备列表
    webrtc.on("devices", function (obj) {
        if (this.callMethod !== 'webrtc') return
        console.log("on devices:", obj);
        this.checkDeviceStateUI();
    }.bind(this));
    //通知设备状态的变更
    webrtc.on("deviceStatus", function (obj) {
        if (this.callMethod !== 'webrtc') return
        console.log("on deviceStatus:", obj);
        this.checkDeviceStateUI();//检查设备状态的ui界面
    }.bind(this));
    // webrtc.on('deviceAdd', function (obj) {
    //     if (this.callMethod !== 'webrtc') return
    //     console.log('on deviceAdd', obj)
    //     var temp = this.netcall
    //     if (!temp.signalInited) return;
    //     this.checkDeviceStateUI();
    // }.bind(this))
    // webrtc.on('deviceRemove', function (obj) {
    //     if (this.callMethod !== 'webrtc') return
    //     console.log('on deviceRemove', obj)
    //     var temp = this.netcall
    //     if (!temp.signalInited) return;
    //     this.checkDeviceStateUI();
    // }.bind(this))
    //接受请求
    webrtc.on("beCalling", function (obj) {
        if (this.callMethod !== 'webrtc' ) return
        this.onBeCalling(obj); //被呼叫
    }.bind(this));
    //监听音视频通话控制指令
    webrtc.on("control", function (obj) {
        if (this.callMethod !== 'webrtc'  ) return
        this.onControl(obj);
    }.bind(this));
    //监听挂断音视频通话 当一方挂断之后, 另一方会收到 `hangup` 事件
    webrtc.on("hangup", function (obj) {
        //if (this.callMethod !== 'webrtc'  ) return
        this.onHangup(obj);
    }.bind(this));
    webrtc.on("heartBeatError", function (obj) {
        if (this.callMethod !== 'webrtc'  ) return
        console.log("heartBeatError,要重建信令啦");
    }.bind(this));
    //其他端已处理
    webrtc.on("callerAckSync", function (obj) {
        if (this.callMethod !== 'webrtc'  ) return
        //this.onCallerAckSync(obj);
    }.bind(this));
    //网络监听
    webrtc.on("netStatus", function (obj) {
        if (this.callMethod !== 'webrtc'  ) return
        // console.log("on net status:", obj);
    }.bind(this))
    // 统计
    webrtc.on("statistics", function (obj) {
        if (this.callMethod !== 'webrtc'  ) return
        // console.log("on statistics:", obj);
    }.bind(this));
    // 音量监控
    webrtc.on("audioVolume", function (obj) {
        if (this.callMethod !== 'webrtc'  ) return
    }.bind(this));
    //监听对方加入通话的通知
    webrtc.on('joinChannel', function (obj) {
        if (this.callMethod !== 'webrtc'  ) return
        console.log('user join', obj)
    }.bind(this))
    //远程跟踪
    /*收到用户媒体流的通知
	API 介绍
	
	双人和多人通话中，加入房间后，可以通过该监听事件获取到其他新加入用户的媒体流通知，并作出相应处理
	展示对应用户的画面
	进行音视频录制等
	该事件抛出的目的也是为了方便用户做自定义操作，自己对媒体流的轨道信息做各种包装处理
	只有WebRTC支持该回调*/
    webrtc.on('remoteTrack', function (obj) {
    	 console.log('on remoteTrack', obj)
        if (this.callMethod !== 'webrtc'  ) return
        if (obj.track && obj.track.kind === 'audio') {
            that.setDeviceAudioOut(true);
         }
         if (obj.track && obj.track.kind === 'video') {
           // 重新设置尺寸
           this.startRemoteStream(obj)
           this.updateVideoShowSize(true, true)
         }
         //that.onJoinChannel(obj);
    }.bind(this))
}

/** 初始化netcall事件 */
fn.initNetcallEvent = function () {
    var webnet = this.webnet;
    var that = this;
    // 对方接受通话 或者 我方接受通话，都会触发
    webnet.on("callAccepted", function (obj) {
        if (this.callMethod !== 'webnet'  ) return
        this.onCallAccepted(obj);
    }.bind(this));
    //取消通话
    webnet.on("callRejected", function (obj) {
        if (this.callMethod !== 'webnet'  ) return
        //this.onCallingRejected(obj);
    }.bind(this));
    //信令通道关闭
    webnet.on('signalClosed', function () {
        if (this.callMethod !== 'webnet'  ) return
        console.log("signal closed");
        this.signalInited = false;
        this.showTip("信令断开了", 2000, function () {
            this.beCalling = false;
            this.beCalledInfo = null;
            this.hideAllNetcallUI();
            this.netcall.hangup();
        }.bind(this));
    }.bind(this));
    //设备
    webnet.on("devices", function (obj) {
        if (this.callMethod !== 'webnet'  ) return
        console.log("on devices:", obj);
        //this.checkDeviceStateUI();
    }.bind(this));
    //设备状态
    webnet.on("deviceStatus", function (obj) {
        if (this.callMethod !== 'webnet'  ) return
        console.log("on deviceStatus:", obj);
        this.checkDeviceStateUI();
    }.bind(this));
    webnet.on("beCalling", function (obj) {
        if (this.callMethod !== 'webnet'  ) return
        this.onBeCalling(obj);
    }.bind(this));
    webnet.on("control", function (obj) {
        if (this.callMethod !== 'webnet'  ) return
        this.onControl(obj);
    }.bind(this));
    webnet.on("hangup", function (obj) {
        if (this.callMethod !== 'webnet'  ) return
        this.onHangup(obj);
    }.bind(this));
    webnet.on("heartBeatError", function (obj) {
        if (this.callMethod !== 'webnet'  ) return
        console.log("heartBeatError,要重建信令啦");
    }.bind(this));
    webnet.on("callerAckSync", function (obj) {
        if (this.callMethod !== 'webnet'  ) return
        this.onCallerAckSync(obj);
    }.bind(this));

    webnet.on("netStatus", function (obj) {
        if (this.callMethod !== 'webnet') return
        // console.log("on net status:", obj);
    }.bind(this));
    webnet.on("statistics", function (obj) {
        if (this.callMethod !== 'webnet') return
        // console.log("on statistics:", obj);
    }.bind(this));
    webnet.on("audioVolume", function (obj) {
        if (this.callMethod !== 'webnet' || (!this.beCalling && !this.calling && !this.netcallActive)) return
        // console.log("on audioVolume:", obj);
    }.bind(this));
    webnet.on("streamResize", function () {
        if (this.callMethod !== 'webnet') return
        console.log("stream resize", arguments)
    }.bind(this))
    webnet.on('joinChannel', function (obj) {
        if (this.callMethod !== 'webnet') return
        // type多人没用
        console.log('user join', obj)
        that.onJoinChannel(obj);
    }.bind(this))
/*    webnet.on('leaveChannel', function (obj) {
        if (this.callMethod !== 'webnet') return
        console.log('sb leaveChannel', obj)
        that.onLeaveChannel(obj);
    }.bind(this))
*/
}

fn.onControl = function (obj) {
    console.log("on control:", obj);
    var netcall = this.netcall;
    // 如果不是当前通话的指令, 直接丢掉
    if (netcall.notCurrentChannelId(obj)) {
        this.log("非当前通话的控制信息");
        return;
    }
    var type = obj.type;
    switch (type) {
        // NETCALL_CONTROL_COMMAND_NOTIFY_AUDIO_ON 通知对方自己打开了音频
        case Netcall.NETCALL_CONTROL_COMMAND_NOTIFY_AUDIO_ON:
            this.log("对方打开了麦克风");
            break;
        // NETCALL_CONTROL_COMMAND_NOTIFY_AUDIO_OFF 通知对方自己关闭了音频
        case Netcall.NETCALL_CONTROL_COMMAND_NOTIFY_AUDIO_OFF:
            this.log("对方关闭了麦克风");
            break;
        // NETCALL_CONTROL_COMMAND_NOTIFY_VIDEO_ON 通知对方自己打开了视频
        case Netcall.NETCALL_CONTROL_COMMAND_NOTIFY_VIDEO_ON:
            this.log("对方打开了摄像头");
            this.$videoRemoteBox.toggleClass("empty", false).find(".message").text("");
            if (this.isRtcSupported) {
                //p2p
                if (this.yx.crtSessionType === 'p2p') {
                    return this.startRemoteStream();
                }
            }
            this.updateVideoShowSize(true, true);//更新视频显示界面
            break;
        // NETCALL_CONTROL_COMMAND_NOTIFY_VIDEO_OFF 通知对方自己关闭了视频
        case Netcall.NETCALL_CONTROL_COMMAND_NOTIFY_VIDEO_OFF:
            this.log("对方关闭了摄像头");
            this.$videoRemoteBox.toggleClass("empty", true).find(".message").text("对方关闭了摄像头");
            if (this.isRtcSupported) {
                //p2p
                if (this.yx.crtSessionType === 'p2p') {
                    return this.stopRemoteStream();//停止对方得视频流
                }
            }
            break;
        // NETCALL_CONTROL_COMMAND_SWITCH_AUDIO_TO_VIDEO_REJECT 拒绝从音频切换到视频
        case Netcall.NETCALL_CONTROL_COMMAND_SWITCH_AUDIO_TO_VIDEO_REJECT:
            break;
        // NETCALL_CONTROL_COMMAND_SWITCH_AUDIO_TO_VIDEO 请求从音频切换到视频
        case Netcall.NETCALL_CONTROL_COMMAND_SWITCH_AUDIO_TO_VIDEO:
            break;
        // NETCALL_CONTROL_COMMAND_SWITCH_AUDIO_TO_VIDEO_AGREE 同意从音频切换到视频
        case Netcall.NETCALL_CONTROL_COMMAND_SWITCH_AUDIO_TO_VIDEO_AGREE:
            break;
        // NETCALL_CONTROL_COMMAND_SWITCH_VIDEO_TO_AUDIO 从视频切换到音频
        case Netcall.NETCALL_CONTROL_COMMAND_SWITCH_VIDEO_TO_AUDIO:
            break;
        // NETCALL_CONTROL_COMMAND_BUSY 对方占线
        case Netcall.NETCALL_CONTROL_COMMAND_BUSY:
        // NETCALL_CONTROL_COMMAND_SELF_CAMERA_INVALID 自己的摄像头不可用
        case Netcall.NETCALL_CONTROL_COMMAND_SELF_CAMERA_INVALID:
            this.log("对方摄像头不可用");
            this.$videoRemoteBox.toggleClass("empty", true).find(".message").text("对方摄像头不可用");
            if (this.isRtcSupported) {
                //p2p
                if (this.yx.crtSessionType === 'p2p') {
                    return this.stopRemoteStream(); //停止对方得视频流
                }
            }
            break;
        // NETCALL_CONTROL_COMMAND_SELF_ON_BACKGROUND 自己处于后台
        // NETCALL_CONTROL_COMMAND_START_NOTIFY_RECEIVED 告诉发送方自己已经收到请求了（用于通知发送方开始播放提示音）
        // NETCALL_CONTROL_COMMAND_NOTIFY_RECORD_START 通知对方自己开始录制视频了
        // NETCALL_CONTROL_COMMAND_NOTIFY_RECORD_STOP 通知对方自己结束录制视频了
    }
};
//(己方本地操作，对端不受影响)关闭自己画面
fn.stopLocalStream = function () {
    this.log("停止本地流显示 stopLocalStream");
    try {
        this.netcall.stopLocalStream();
    } catch (e) {
        this.log("停止本地流失败");
        console && console.warn && console.warn(e);
    }
};
//(己方本地操作，对端不受影响)关闭对方画面
fn.stopRemoteStream = function () {
    this.log("停止远端流显示 stopRemoteStream");
    try {
        this.netcall.stopRemoteStream();
    } catch (e) {
        this.log("停止远端流失败");
        console && console.warn && console.warn(e);
    }
};
fn.startLocalStream = function (node) {
	node = node || this.$netcallBox.find(".netcall-video-local")[0]
    this.log("开启本地流显示 startLocalStream");
    try {
        this.netcall.startLocalStream(node);
    } catch (e) {
        this.log("开启本地流失败");
        console && console.warn && console.warn(e);
    }
};
fn.startRemoteStream = function (obj) {
	obj = obj || {}
	obj.node = obj.node || this.$netcallBox.find(".netcall-video-remote")[0]
    this.log("开启远端流显示 startRemoteStream");
    try {
        this.netcall.startRemoteStream(obj);
    } catch (e) {
        this.log("开启远端流失败");
        console && console.warn && console.warn(e);
    }
};
fn.requestSwitchToAudio = function () {
    this.log("请求切换到音频流");
    if (this.$switchToAudioButton.is(".disabled")) return;
    this.netcall.control({
        command: Netcall.NETCALL_CONTROL_COMMAND_SWITCH_VIDEO_TO_AUDIO
    });
    this.doSwitchToAudio();
};

/** 同意音视频通话, 兼容多人音视频 */
fn.accept = function (e) {
    // 如果在转圈的状态，忽略
    if (this.$beCallingAcceptButton.hasClass('loading')) return
    var that = this
    //如果不可用 忽略
    if (this.$beCallingAcceptButton.is(".disabled")) return; 
    //如果没有被呼叫中则忽略
    if (!this.beCalling) return; 

    // 发起通话选择UI 这里直接rtc 
    this.displayCallMethodUI(deviceCheck.bind(that), function () {
        that.reject() //错误直接挂断电话
    })

    function deviceCheck(data) {
        this.callMethod = data && data.type || this.callMethod; //选择的方案
        this.callMethodRemember = data && data.type || this.callMethodRemember;//是否记住选择
        this.$beCallingAcceptButton.toggleClass("loading", true);//链接中
        // WebRTC模式
        if (this.callMethod === 'webrtc') {
            this.netcall = this.webrtc;
            that.updateBeCallingSupportUI(true);//更新更新通话支持UI
            return this.callAcceptedResponse()
        }

        // webnet模式
        this.netcall = this.webnet;
        // 音视频插件检查, signal只做检测
        this.checkNetcallSupporting(function () {
            that.updateBeCallingSupportUI(true);
            this.callAcceptedResponse()/** 同意通话的操作 */ 
        }.bind(this), function () {
            // 平台不支持
            that.reject();
        }, function (err) {
            // 插件弹框报错
            that.showAgentNeedInstallDialog(err, deviceCheck.bind(that), function () {
                that.reject();
            })
            that.updateBeCallingSupportUI(false, null, err);
        }, true, true);
    }
};
/** 同意通话的操作 */
fn.callAcceptedResponse = function () {
    /** 如果是群视频通话 */
    this.clearBeCallTimer();
    this.log("同意对方音视频请求");
    this.beCalling = false;
    //被叫响应通话请求
    this.netcall.response({
        accepted: true,
        beCalledInfo: this.beCalledInfo,
        sessionConfig: this.sessionConfig
    }).then(function () {
        this.log("同意对方音视频请求成功");
        // 加个定时器 处理点击接听了 实际上对面杀进程了，没有callAccepted回调
        this.acceptAndWait = true; //链接中
        setTimeout(function () {
            if (this.acceptAndWait) {
                this.log("通话建立过程超时"); 
                this.hideAllNetcallUI();//隐藏所有的通话UI
                this.hangup()//挂断通话
                this.acceptAndWait = false; //接受和等待
            }
        }.bind(this), 45 * 1000)

    }.bind(this)).catch(function (err) {
        this.log("同意对方音视频通话失败，转为拒绝");
        console.log("error info:", err);
        this.$beCallingAcceptButton.toggleClass("loading", false); //取消等待
        this.reject();//拒绝通话 关闭beCallTimer 初始化beCalling beCalledInfo 隐藏ui
    }.bind(this));
}
/** 拒绝音视频通话, 兼容多人音视频 */
fn.reject = function () {
    if (!this.beCalling) return; //是否被叫
    //this.clearBeCallTimer();//关闭请求计时器  hideAllNetcallUI里面存在
    this.log("拒绝对方音视频通话请求");
    var beCalledInfo = this.beCalledInfo; //发起回话的信息
    this.netcall.response({//被叫响应通话 
        accepted: false,//回应类型，接听、拒绝
        beCalledInfo: beCalledInfo //呼叫信息，必传，该值可以在 beCalling 回调事件中获取）
    }).then(function () {
        this.log("拒绝对方音视频通话请求成功");
        this.beCalledInfo = null;
        this.beCalling = false;
        this.hideAllNetcallUI();
    }.bind(this)).catch(function (err) {
        // 自己断网了
        this.log("拒绝对方音视频通话请求失败");
        console.log("error info:", err);
        this.beCalledInfo = null;
        this.beCalling = false;
        this.hideAllNetcallUI(); //隐藏所有UI
    }.bind(this));
};
// 挂断通话过程
fn.hangup = function (param) {
    this.netcall.hangup();
//  this.setDeviceAudioIn(false);//关闭麦克风，停止将本地音频发送到对端
//  this.setDeviceVideoIn(false);// 关闭摄像头，停止向对端发送本地视频
//  this.setDeviceAudioOut(false);// (己方本地操作，对端不受影响)关闭对方声音
    
	   //如果在通话中并且是页面卸载事件 直接清空
	   if(param=='unload'){
		   console.log("通话中直接关闭界面的情况")
	       window.destroysession();
	   }else{
		   console.log("简单的挂断操作")
	  	   this.hideAllNetcallUI();
	   }
//    this.stopRemoteStream();//(己方本地操作，对端不受影响)关闭对方画面
//    this.stopLocalStream();//(己方本地操作，对端不受影响)关闭自己画面
    /**状态重置 */
    if(this.netcallDuration!=0 && this.netcallDuration!='00分00秒'){
    	console.log("通话时长大于0->"+this.netcallDuration)
    	/*window.hangupexit(this.channelId,this.beCalledInfo.custom,this.netcallDuration,this.beCallData.c_name);*/
    	
    	window.viedoAudit('1',this.channelId,this.beCalledInfo.custom);
    }else{
    	console.log("通话时长小于等于0->"+this.netcallDuration)
    }
    this.resetWhenHangup();//释放资源
};
// 其它端已处理
fn.onCallerAckSync = function (obj) {
    this.log("其它端已处理");
    if (this.beCalledInfo && obj.channelId === this.beCalledInfo.channelId) {
        console.log("on caller ack async:", obj);
        this.showTip("其它端已处理", 2000, function () {
            this.beCalledInfo = false;
            this.beCalling = false;
            this.hideAllNetcallUI();
        }.bind(this));
    }
};
// 对方挂断通话过程
// 1. 通话中挂断
// 2. 请求通话中挂断
fn.onHangup = function (obj) {
    this.log("收到对方挂断通话消息");
    console.log("on hange up", obj);
    console.log(this.beCalling, this.beCalledInfo, this.netcallDurationTimer);
    // 是否挂断当前通话
    if (obj.account && obj.account === this.netcallAccount) {
    	console.log("当前通话")
        close.call(this);
        return
    }
    if (this.netcallDurationTimer !== null && this.netcall.notCurrentChannelId(obj)) {
        return this.log("挂断消息不属于当前活动通话，忽略1");
    }
    if (this.netcallDurationTimer === null && this.beCalling && this.beCalledInfo.channelId !== obj.channelId) {
        return this.log("挂断消息不属于当前活动通话，忽略2");
    }
    if (this.netcallDurationTimer === null && !this.beCalling) {
        return this.log("挂断消息不属于当前活动通话，忽略3，当前无通话活动");
    }
    this.clearBeCallTimer();
    close.call(this);
    function close() {
        this.showTip("对方已挂断", 2000, function () {
            this.beCalling = false; //没有被呼叫
            this.beCalledInfo = null;//清空发起者信息
            this.hideAllNetcallUI();//隐藏相关ui
//            this.setDeviceVideoIn(false);
//            this.setDeviceAudioIn(false);
//            this.setDeviceAudioOut(false);
        }.bind(this));
        if(this.netcallDuration!=0 && this.netcallDuration!='00分00秒'){
        	console.log("通话时长大于0->"+this.netcallDuration)
        	/*window.hangupexit(this.channelId,this.beCalledInfo.custom,this.netcallDuration,this.beCallData.c_name);*/
        	window.viedoAudit('1',this.channelId,this.beCalledInfo.custom);
        }else{
        	console.log("通话时长小于等于0->"+this.netcallDuration)
        }
        /**状态重置 */
        this.resetWhenHangup();//释放资源
    }
};
// 打开当前音视频通话对象的聊天窗口
fn.doOpenChatBox = function () {
    var account = this.netcallAccount;
    if (!account) {//不存在发起者
    	//关闭显示提示计时器
        if (this.showTipTimer) {
            clearTimeout(this.showTipTimer);
            this.showTipTimer = null;
        }
        return;
    }
    this.yx.openChatBox(account, 'p2p'); //显示回话模板
};
/** 被呼叫
 * @param {object} obj 主叫信息
 * @param {string} scene 是否是群视频，默认值p2p
 */
fn.onBeCalling = function (obj, scene) {	
	//暂停视频播放
    if(!!myPlayer){
    	myPlayer.pause();
    }
    layer.closeAll();
    scene = scene || 'p2p';
    this.log("收到音视频呼叫(onBeCalling):"+JSON.stringify(obj));
    window.channelId = obj.channelId;
    var netcall = this.netcall;
    // 如果是同一通呼叫，直接丢掉
    if (obj.channelId === this.channelId) return
    
	//关闭刷新定时器
	if(refreshTime){
		console.log("关闭刷新定时器")
		clearTimeout(refreshTime)
	}
	window.deleteActive()
	
    // p2p场景，先通知对方自己收到音视频通知
     if (scene === 'p2p') {
         netcall.control({
             channelId:  window.channelId,
             command: Netcall.NETCALL_CONTROL_COMMAND_START_NOTIFY_RECEIVED
         });
     }
    // 自己正在通话或者被叫中, 知对方忙并拒绝通话
    if (netcall.calling || this.beCalling ) {
        var tmp = { command: Netcall.NETCALL_CONTROL_COMMAND_BUSY };
        if (scene === 'p2p') {
            tmp.channelId = window.channelId;
        }
        this.log("通知呼叫方我方不空");
        netcall.control(tmp);
        return;
    }
    /*{"timetag":1550823353987,"type":2,"channelId":50817379631128,"account":"507da3a2ddd113ec9166fb8e58005fb5","uid":2498098925,"turnServerList":["223.112.179.146:80","223.112.179.146:8080","223.112.179.146:16285"],"sturnServerList":["223.112.179.146:3478","223.112.179.146:3479"],"proxyServerList":[],"accountUidMap":{"507da3a2ddd113ec9166fb8e58005fb5":2509901713,"c6fa296f9c17c8032be6593a5d02269b":2498098925},"clientConfig":"{\"net\":{\"record\":true,\"dtunnel\":true,\"p2p\":false}}","custom":"{\"id\":\"706\",\"latitude\":26.056487,\"longitude\":119.336294,\"address\":\"福建省\"}","pushConfig":{"enable":"1","needBadge":"1","needPushNick":"1","pushContent":"","custom":"{\"id\":\"706\",\"latitude\":26.056487,\"longitude\":119.336294,\"address\":\"福建省福州市台江区曙光路126号宇洋中央金座\"}","pushPayload":"","sound":"","webrtcEnable":"1"},"serverMap":"{\"webrtcarray\":[\"webrtcgwcn.netease.im/?ip=223.112.179.146:5060\",\"webrtcgwhz.netease.im/?ip=223.112.179.146:5060\"],\"wechatapparray\":[\"webrtcgwcn.netease.im/?ip=223.112.179.146:5061\",\"webrtcgwhz.netease.im/?ip=223.112.179.146:5061\"],\"token\":\"mljxyxct3qgh8h6rw41waxpunnje1n5rqwuw3s7k\",\"detectTurnAddrs\":[\"223.112.179.146:80\",\"113.108.226.138:80\",\"117.158.188.82:80\"],\"turnaddrs\":[[\"223.112.179.146:80\",\"223.112.179.146:8080\",\"223.112.179.146:16285\"]],\"grey\":false,\"webrtc\":\"webrtcgwcn.netease.im/?ip=223.112.179.146:5060\"}"}*/
    //设置状态:被叫中
    this.beCalling = true;
    this.channelId=window.channelId;
    this.dialog_call && this.dialog_call.close();
    //更新被叫支持ui
    this.updateBeCallingSupportUI(true);
    /**
     * 考虑被呼叫时，呼叫方断网，被呼叫方不能收到hangup消息，因此设置一个超时时间
     * 在通话连接建立后，停掉这个计时器
     */
    this.beCallTimer = setTimeout(function () {
        if (!this.beCallTimer) return;
        this.log("呼叫方可能已经掉线，挂断通话");
        this.beCallTimer = null;
        this.reject();//拒绝通话 关闭beCallTimer 初始化beCalling beCalledInfo 隐藏ui
    }.bind(this), 62 * 1000)
    //p2p场景
    this.beCalledInfo = obj;
   /* this.beCalledInfo.custom='{"id":"706",\"latitude\":26.056487,\"longitude\":119.336294,"address":"上海市"}';
    obj.custom='{"id":"706",\"latitude\":26.056487,\"longitude\":119.336294,"address":"上海市"}';*/
    this.netcallActive = true;
    this.netcallAccount = obj.account;//即帐号
    this.doOpenChatBox();
    window.custom=JSON.parse(obj.custom.replace("\\","").replace("(null)",""));
    var that=this;
    $.ajax({
        url:'../yx/viedoinfo.do',
        type:'POST',
        data:{id:window.custom.id,domvalue:"A"},
        dataType:'json',
        success: function (data) {
        	console.log("用户信息->"+JSON.stringify(data))
        	that.beCallData=data;
        	that.beCallData.address=window.custom.address;
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
        	var prefix="请求实时视频客户信息异常";
            console.log(prefix+":(状态码)"+XMLHttpRequest.status);
            console.log(prefix+":(状态)"+XMLHttpRequest.readyState);
            console.log(prefix+":(错误信息) "+textStatus);
        },
        complete:function(){
        	 that.showBeCallingUI(obj.type);//显示被叫界面
        	 that.playRing("E", 45);//打开声音
        }
    })
};
// 对方接受通话 或者 我方接受通话，都会触发
fn.onCallAccepted = function (obj) {
    function changeState() {
        this.acceptAndWait = false;
        this.log("音视频通话开始");
        this.type = obj.type;
        this.showConnectedUI(obj.type); // 通话建立成功后，展示视频通话或者音频通话画面
        this.clearRingPlay();//关闭铃声
        this.$beCallingAcceptButton.toggleClass("loading", false);
        window.initView("A");
        window.viewdate("A",this.beCallData);
    }
    changeState = changeState.bind(this);
    // WebRTC模式
    if (this.isRtcSupported) { 	
    	let that = this
        Promise.resolve().then(function () {
            that.log("开始webrtc连接")
            return that.netcall.startRtc();
        }).then(() => {
            that.log("webrtc连接成功")
            return that.setDeviceVideoIn(obj.type === WebRTC.NETCALL_TYPE_VIDEO);
        }).then(function () {
            return that.setDeviceAudioIn(true);
        }).then(function () {
            changeState();
        }).catch(function (e) {
            console.error(e);
            that.log("连接出错");

//            if (/webrtc兼容开关/i.test(e)) {
//                minAlert.alert({
//                    type: 'error',
//                    msg: '无法接通!请让呼叫方打开"WebRTC兼容开关"，方可正常通话', //消息主体
//                    confirmBtnMsg: '知道了，挂断',
//                    cbConfirm: that.hangup.bind(that)
//                })
//            }
        }.bind(that))
    } else {
        changeState();

        if (obj.type === Netcall.NETCALL_TYPE_VIDEO) {
            this.setDeviceAudioIn(true);
            this.setDeviceAudioOut(true);
            this.setDeviceVideoIn(true);
            this.netcall.startLocalStream();
            this.netcall.startRemoteStream();
            $("#videoWaitingAcceptedTip").toggleClass("hide", true);
            $("#microSliderInput1").val(10).change();
            $("#volumeSliderInput1").val(10).change();
            this.updateVideoShowSize(true, true);
        } else {
            this.setDeviceAudioIn(true);
            this.setDeviceAudioOut(true);
            this.setDeviceVideoIn(false);
            $("#microSliderInput").val(10).change();
            $("#volumeSliderInput").val(10).change();
        }
        // 设置采集和播放音量
        this.netcall.setCaptureVolume(255);
        this.netcall.setPlayVolume(255);
    }

    // 呼叫时长显示
    this.startDurationTimer();
    // 关闭被呼叫倒计时
    this.beCallTimer = null;
};
//(己方本地操作，对端不受影响)关闭/开启对方声音
fn.setDeviceAudioOut = function (state) {
    var that = this
    $(".icon-volume").toggleClass("icon-disabled", !state);
    that.deviceAudioOutOn = !!state;
    if (state) {
        that.log("开启扬声器");
        return that.netcall.startDevice({
            type: Netcall.DEVICE_TYPE_AUDIO_OUT_CHAT
        }).then(function () {
            that.netcall.setPlayVolume(255);
            that.log("开启扬声器成功");
        }).catch(function () {
            that.log("开启扬声器失败");
            that.onDeviceNoUsable(Netcall.DEVICE_TYPE_AUDIO_OUT_CHAT);
        });
    } else {
        that.log("关闭扬声器");
        return that.netcall.stopDevice(Netcall.DEVICE_TYPE_AUDIO_OUT_CHAT).then(function () {
            that.log("关闭扬声器成功");
        }).catch(function () {
            that.log("关闭扬声器失败");
        });
    }
};

//开启摄像头，将本地视频发送对端
fn.setDeviceVideoIn = function (state) {
    var that = this
    $(".icon-camera").toggleClass("icon-disabled", !state);
    that.deviceVideoInOn = !!state;

    if (state) {
        that.log("开启摄像头");
        return that.netcall.startDevice({
            type: Netcall.DEVICE_TYPE_VIDEO
            /* width: that.videoCaptureSize.width,
             height: that.videoCaptureSize.height */
        }).then(function () {
            that.videoType = 'video'
            that.log("开启摄像头成功，通知对方己方开启了摄像头");
            // 通知对方自己开启了摄像头
            that.netcall.control({
                command: Netcall.NETCALL_CONTROL_COMMAND_NOTIFY_VIDEO_ON
            });
            $(".netcall-video-local").toggleClass("empty", false);
            $(".netcall-video-local .message").text("");

            that.startLocalStream()
            that.updateVideoShowSize(true, false)

        }).catch(function (err) {
            console.error(err)
            that.videoType = null
            // 通知对方自己的摄像头不可用
            that.log("开启摄像头失败，通知对方己方摄像头不可用", err);
            that.onDeviceNoUsable(Netcall.DEVICE_TYPE_VIDEO);

            that.netcall.control({
                command: Netcall.NETCALL_CONTROL_COMMAND_SELF_CAMERA_INVALID
            });
            $(".netcall-video-local").toggleClass("empty", true);
            $(".netcall-video-local .message").text("摄像头不可用");
            $(".netcall-box .camera.control-item").toggleClass("no-device", true).attr("title", "摄像头不可用");
        });

    } else {
        that.videoType = null
        that.log("关闭摄像头");
        return that.netcall.stopDevice(Netcall.DEVICE_TYPE_VIDEO).then(function () {
            // 通知对方自己关闭了摄像头
            that.log("关闭摄像头成功，通知对方我方关闭了摄像头");
            that.netcall.control({
                command: Netcall.NETCALL_CONTROL_COMMAND_NOTIFY_VIDEO_OFF
            });
            $(".netcall-video-local").toggleClass("empty", true);
            $(".netcall-video-local .message").text("您关闭了摄像头");
        }).catch(function (e) {
            that.videoType = null
            that.log("关闭摄像头失败");
        });
    }
};

fn.clearBeCallTimer = function () {
    if (this.beCallTimer) {
        clearTimeout(this.beCallTimer);
        this.beCallTimer = null;
    }
};
fn.clearRingPlay = function () {
    if (this.playRingInstance) {
        this.playRingInstance.cancel && this.playRingInstance.cancel();
        this.playRingInstance = null;
    }
};
//演奏铃声
fn.playRing = function (name, count, done) {
    done = done || function () { };
    this.playRingInstance = this.playRingInstance || {};
    var nameMap = {
        A: "avchat_connecting",
        B: "avchat_no_response",
        C: "avchat_peer_busy",
        D: "avchat_peer_reject",
        E: "avchat_ring"
    };
    var url = "audio/" + nameMap[name] + ".mp3";
    function doPlay(url, playDone) {
        var audio = document.createElement("audio");
        audio.autoplay = true;
        function onEnded() {

            this.playRingInstance.cancel = null;
            audio = null;
            playDone();
        }
        onEnded = onEnded.bind(this);
        audio.addEventListener("ended", onEnded);
        audio.src = url;
        this.playRingInstance.cancel = function () {
            audio.removeEventListener("ended", onEnded);
            audio.pause();
            audio = null;
        }
    }
    doPlay = doPlay.bind(this);
    var wrap = function () {
        this.playRingInstance = null
        done();
    }.bind(this);
    for (var i = 0; i < count; i++) {
        wrap = (function (wrap) {
            return function () {
                doPlay(url, wrap);
            };
        })(wrap);
    }
    wrap();
};
fn.log = function () {
    message = [].join.call(arguments, " ");
    console.log("%c" + message, "color: green;font-size:16px;");
};

//开启麦克风，将本地音频发送到对端
fn.setDeviceAudioIn = function (state) {
	var that = this
    $(".icon-micro").toggleClass("icon-disabled", !state);
    that.deviceAudioInOn = !!state;
    if (state) {
        that.log("开启麦克风");
        return that.netcall.startDevice({
            // 开启麦克风输入
            type: Netcall.DEVICE_TYPE_AUDIO_IN
        }).then(function () {
            that.log("开启麦克风成功，通知对方我方开启了麦克风");
            // 通知对方自己开启了麦克风
            that.netcall.control({
                command: Netcall.NETCALL_CONTROL_COMMAND_NOTIFY_AUDIO_ON
            })
            that.netcall.setCaptureVolume(255)
        }).catch(function () {
            console.log("开启麦克风失败");
            console.error("开启麦克风失败");
            that.log("开启麦克风失败");
            that.onDeviceNoUsable(Netcall.DEVICE_TYPE_AUDIO_IN);
        });
    } else {
        that.log("关闭麦克风");
        return that.netcall.stopDevice(Netcall.DEVICE_TYPE_AUDIO_IN) // 关闭麦克风输入
            .then(function () {
                that.log("关闭麦克风成功，通知对方我方关闭了麦克风");
                // 通知对方自己关闭了麦克风
                that.netcall.control({
                    command: Netcall.NETCALL_CONTROL_COMMAND_NOTIFY_AUDIO_OFF
                });
            }).catch(function () {
                that.log("关闭麦克风失败");
                console.error("关闭麦克风失败");
            });
    }
};