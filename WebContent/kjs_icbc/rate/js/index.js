		$('input:radio').wrap('<div class="radio-btn"><i></i></div>');
		$(function() {
			var v=$("input[type='radio']:checked").parent().parent();
			v.addClass('checkedRadio');
			v.next().css('color','#4b4b4b');//字体变色
		});
		
		//键盘监听
		$(".in").on("keyup", formatMN);
		 function formatMN(e){ 
	     var v=this.value.replace(/[^\d\.]/g,"");
	 	 this.value = v;
	   	}
		 var vehiclevalue=0.7;//车辆类型
		 var installmentDate=36;//分期期数
			//按钮监听
		$(".radio-btn").on('click', function () {
		    var _this = $(this),
		    p0=_this.parent();//li级
		    p1 =p0.parent();//ul级
		    p1.find('input:radio').attr('checked', false);
		    p1.find(".radio-btn").removeClass('checkedRadio');
		    p1.find('span').css('color','#969696');
		    _this.addClass('checkedRadio');
		    p0.find('span').css('color','#4b4b4b');
		    var i0=_this.find('input:radio');//获得单选框
		    i0.attr('checked',true);//选中
		    var v0=p1.attr('id');//获得name值
		   	var v1=i0.attr('value');//获得value值
		    if(v0=='vehicle_type'){//点击类型
		    	vehiclevalue=v1;
		    	//console.log("车辆类型："+vehiclevalue)
		    }else if(v0=='Installment_data'){//点击分期期数
		    	installmentDate=v1;
		    	//console.log("分期期数:"+installmentDate);
		    	installmentvalue={'36':0.09025,'24':0.065,'12':0.0358}[installmentDate] || 0.09025; //银行费率
		    }
		    maxvalue();
		    compute();
		});
		var marketrate=0; //市场费率
		var carInstallment=0;//购车分期本金
		var installmentvalue=0.09025;//银行费率
		var assessMoney=0;//评估价
	    $(".in").on({
	      focus:function(){ 
	      	//优化 如果输入框里面有个0(很常见) 则先清空
	      	var newVal=$(this).val(); 
	      	if(newVal==0){
	      		$(this).val("");
	      	}
	      },
	      blur: function(){
	        var newVal=$(this).val(); 
	        var id=$(this).attr('id');
			if(/.+\..*\..*/.test(newVal)){
			    return false;
		    }
			if(id=="assess_money"){//购车分期本金失去焦点
				assessMoney=hundred(newVal);//百位取整
				$(this).val(assessMoney);//重新赋值
				//console.log("评估价/开票价："+assessMoney);
				maxvalue();
			}else if(id=="market_rate"){//市场费率
					marketrate=keep2Decimal(newVal);//市场费率 保留两位小数
					$(this).val(marketrate);
					//console.log("市场费率："+assessMoney);
			}else if(id=="car_installment"){//购车分期本金
				carInstallment=hundred(newVal);
				$(this).val(carInstallment);
				//console.log("购车分期本金："+carInstallment);
				maxvalue();
			}
			compute();
		  }
	    });
	     /* accDiv 除法
	    accMul 乘法
	    accSub 减法 
	    accAdd 加法*/
	    /*
	     * 
	    $("#service_money_max").val();//金融服务费最大
	    $("#total_loan_max").val();//贷款总额最大
	    $("#car_installment_max").val();//分期本金最大
	    $("#assess_money").val();//开票价
	    $("#car_installment").val();//分期本金
	    $("#service_money").val();//金融服务费
	    $("#total_loan").val();//贷款总额
	    $("#wan").val();//万元系数
	    $("#principalANDinterest").val();//本息合计
	    $("#average_month").val();//平均月还
	    $("#first_month").val();//首月还款额*/
	    var marketRateMax;//市场费率最大值
	    var serviceMoneyMax;//金融服务费
	    var totalLoanMax;//贷款总额最大值
	    var carInstallmentMax;//购车分期本金最大值
	    function maxvalue(){
	    	carInstallmentMax=hundred(accMul(assessMoney,vehiclevalue));//购车分期本金最大值  新车:评*0.8 二手车 评*0.7 结果百位取整
	    	totalLoanMax=hundred(accMul(assessMoney,accAdd(vehiclevalue,0.1)));//新车:评*0.9 二手车 评*0.8 结果百位取整
	    	var v0=hundred(accMul(assessMoney,0.15));
	    	//console.log("v0:"+v0)
			var v1=accSub(totalLoanMax,carInstallment);
			//console.log("v1:"+v1)
			if(v1<=v0){
				serviceMoneyMax=v1;
			}else{
				serviceMoneyMax=v0;
			}	
			//console.log("金融服务费最大值:"+serviceMoneyMax)
	    	$("#service_money_max").text(serviceMoneyMax);
	    	$("#total_loan_max").text(totalLoanMax);
	    	$("#car_installment_max").text(carInstallmentMax);//重置购车分期本金最大值
	    	//不同年限购车分期本金取最大值时的最高市场费率
			var v2=accDiv(accAdd(accSub(totalLoanMax,carInstallmentMax),accMul(totalLoanMax,installmentvalue)),carInstallmentMax);
			//console.log("不同年限购车分期本金取最大值时的最高市场费率"+v2);
			//金融服务费收满的市场费率最大值
			var v3=accDiv(accAdd(serviceMoneyMax,accMul(totalLoanMax,installmentvalue)),carInstallment)
			//console.log("金融服务费收满的市场费率最大值"+v3);
			//市场费率最大值
			if(v3<=v2){
				marketRateMax=v2;
			}else{
				marketRateMax=v3;
			}
			$("#market_rate_max").text(accMul(marketRateMax,'100').toFixed(2));
	    }
	    //计算逻辑
	    function compute(){
    		  var serviceMoney=accMul(Math.round(accDiv(accDiv(accMul(carInstallment,accSub(accDiv(marketrate,'100'),installmentvalue)),accAdd(1,installmentvalue)),'100')),'100');//金融服务费
    		  var totalLoan=accAdd(serviceMoney,carInstallment);//贷款总额
    		  if(!!serviceMoneyMax && serviceMoneyMax<serviceMoney){
			  	 layalert('金融服务费超过')
			  }
			  if(!!totalLoanMax && totalLoanMax<totalLoan){
			  	layalert('贷款总额超过')
			  }
			  if(!!carInstallmentMax && carInstallmentMax<carInstallment){
			  	layalert('购车分期本金超过')
			  }
    	      $("#service_money").val(serviceMoney);//金融服务费
    		  $("#total_loan").val(totalLoan);//贷款总额
    		  var principalANDinterest=number1(accMul(totalLoan,accAdd(1,installmentvalue)));//本息合计
    		  $("#principalANDinterest").val(principalANDinterest);//本息合计
    		  var averageMonth=number1(accDiv(principalANDinterest,installmentDate));//平均月还
    		  $("#average_month").val(averageMonth);//平均月还
    		  var firstMonth=accAdd(averageMonth,200);//首月还款额 
    		  $("#first_month").val(firstMonth);//首月还款额 
    		  var wan;
    		  if(!!averageMonth && !!carInstallment){// 平均月还/购车分期本金
    		  	wan=Math.floor(accMul(accDiv(averageMonth,carInstallment),'10000'));
    		  }else{
    		  	wan=0;
    		  }
    		  $("#wan").val(wan);//万元系数
	    }
	    function layalert(msg){
	    	layer.msg(msg, function(){
			});
		}
	    
