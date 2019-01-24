/** 
 * 技术方案选择的弹框
 * 用途：
 * 1. 发起通话时提供方案选择:WebRTC和PC Agent
 * @param {string} option.callMethod 方法选择
 * @param {fn} option.cbConfirm 确认回调
 * @param {fn} option.cbCancel 取消回调
 */
NetcallBridge.fn.dialog_call = {
	//打开方案选择框
    open: function (option) {
    	
       /* this.callMethod = option.callMethod*/
    	this.callMethod="webrtc"; //默认wrc 方案 忽略其他的方案
        this.cbConfirm = option.cbConfirm || function () { };//回调方法名
        this.cbCancel = option.cbCancel || function () { };
        this.yx = option.yx || {}
        this.env = option.env || this;
        var $dialog = this.$dialog = $('#dialogCallMethod'), that = this;

        this.load();
        //技术方案选框
        var $dialog = this.$dialog = $('#dialogCallMethod'), that = this;
        
        that.selectedNum = 0;
        this.isOpen = true;
        // 事件绑定一次就行了
        if (that.isInited) return;
        //在$dialog元素上绑定click事件处理函数，如果这个click事件是由其后代的.j-confirm触发的，就执行函数
        $dialog.on('click', '.j-confirm', function (e) {
            e.preventDefault();//event.preventDefault() 方法阻止元素发生默认的行为。
            if ($(this).hasClass('disabled')) return; //默认不能点击

            var type = $('.J-all-type-box .radio.active').data('type') //技术方案选择
            //var isRemeber = !!('.J-all-type-box .J-remember.active').length //是否记住选择
             var isRemeber=true;//这里修改为直接记住
            that.close()
            that.cbConfirm.call(that.env, { type: type, isRemeber: isRemeber });
        });
        $dialog.on('click', '.j-close', function (e) {
            e.preventDefault();
            that.close();
            that.cbCancel.call(that.env);
        });
        //技术方案点击选中或者取消
        $dialog.on('click', '.radio', function (e) {
        	$dialog.find('.radio').toggleClass('active', false) //false 先移除类。
            e.preventDefault();
            $(e.target).toggleClass('active', true)// 点击的添加 样式

            $dialog.find('.j-confirm').toggleClass('disabled', false) //确定键可用 即可点击
            var type = $(e.target).data('type');
            $dialog.find('.J-webrtc').toggleClass('hide', type === 'webrtc')
        });
        //是否记住选择
        $dialog.on('click', '.checkbox', function (e) {
            e.preventDefault();
            $(e.target).toggleClass('active')
        });

        that.isInited = true;
    },
    // dom渲染流程 
    load: function (list, selectedlist) {
        var that = this;
        that.cbConfirm.call(that.env, { type: 'webrtc', isRemeber: true });
       /* var $dialog = that.$dialog;
        var fname = 'selectCallMethod';
        //加载 技术弹框界面
        $dialog.load('./' + fname + '.html', function () {
    
            if(that.callMethod){//默认选中的方法 活跃
                $('.radio[data-type=' + that.callMethod + ']').addClass('active')
            }
            $dialog.find('.J-webrtc').toggleClass('hide', !that.callMethod || that.callMethod === 'webrtc')
            $dialog.removeClass('hide')
            that.yx.$mask.removeClass('hide')
            $dialog.find('.j-confirm').toggleClass('disabled', $dialog.find('.radio.active').length === 0) //还没有勾选方案
        });*/
    },
    //关闭弹框 
    close: function () {
        this.isOpen = false;
        this.$dialog && this.$dialog.addClass('hide')
        this.yx && this.yx.$mask && this.yx.$mask.addClass('hide')
    }
}