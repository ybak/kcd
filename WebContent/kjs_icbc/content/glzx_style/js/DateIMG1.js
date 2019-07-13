/*点击切换事件 直接用js吧*/
function graphTransform(){
	var graphTransform2=document.getElementById("graph_transform2")
	var graphTransform1=document.getElementById("graph_transform1")
    if (graphTransform2.style.display=="block"){
        graphTransform2.style.display="none";
        graphTransform1.style.display="block";
    } else {
        graphTransform2.style.display="block";
        graphTransform1.style.display="none";
    }
}
  /*报单统计start*/
  //通用样式
   var axistick="{lineStyle:{color:'white',type:'dashed'}}";//刻度
   var baodan = echarts.init(document.getElementById('baodan'));
   function baodanselect(){
       var sel=document.getElementById("baodanval").value
       var obj = document.getElementById('baodansel'); //定位id
       var index = obj.selectedIndex; // 选中索引
       var value = obj.options[index].value; // 选中值
       var obj1 = document.getElementById('baodantime'); //定位id
       var index1 = obj1.selectedIndex; // 选中索引
       var time = obj1.options[index1].value; // 选中值
   //前台数据图后台获取数据绘制
   $.ajax({
 		dataType : "json",
 		type : "POST",
 		url : "Management/getPathMap.do",
 		data : {baodanname:sel,baodancity:value,baodantime:time},
 		success : function(data) {
 			 var summarydata = [6139,6292,6412,4708,8477,7983,4916,5102,328];
             var timeline = ["2018-11","2018-12","2019-01","2019-02","2019-03","2019-04","2019-05","2019-06","2019-07"];
             if(time == "2018"){
                 summarydata = [1946,4166,3430,3309,4128,3871,5870,5965,6149];
                 timeline = ["2018-02","2018-03","2018-04","2018-05","2018-06","2018-07","2018-08","2018-09","2018-10"];
             }
 	//数据图绘制
   option_baodan = {
	    xAxis: {
	        type: 'category',
	        boundaryGap: false,
	        data: timeline,//后台获取时间
	        name:'时间',
	        splitLine:{show: false},//去除网格线
            nameTextStyle:{//坐标轴名称的文字样式。
        		padding: [0, 0, 0, -8]
        	},
        	axisLabel:{
        		rotate:70
        	},
	        axisTick:axistick,
	        axisLine :{symbol:['none', 'arrow'],symbolSize:['10', '13'],lineStyle:{color:'#4667f2'}}//轴线
	    },
	    grid:{
	    	left:'15%'
	    },
	    yAxis: {
	        type: 'value',
	        name:'数量',
	        splitLine:{show: false},//去除网格线
	        nameTextStyle:{
	        	color:'#3b56cc'
	        },
	        axisTick:axistick,
	        axisLine :{symbol:['none', 'arrow'],symbolSize:['10', '13'],lineStyle:{color:'#4667f2'}}//轴线
	    },	    
	    series: [{
	    	
	    	name:'报单统计',
	        data: summarydata,//后台获取数据
	        type: 'line',
	        areaStyle: {
	        	// 线性渐变，前四个参数分别是 x0, y0, x2, y2, 范围从 0 - 1，相当于在图形包围盒中的百分比，如果 globalCoord 为 `true`，则该四个值是绝对的像素位置
				color: {
				    type: 'linear',
				    x: 0,
				    y: 0,
				    x2: 0,
				    y2: 1,
				    colorStops: [{
				        offset: 0, color: '#0f122b' // 0% 处的颜色
				    }, {
				        offset: 1, color: '#0f122b' // 100% 处的颜色
				    }],
				    globalCoord: false // 缺省为 false
				}
	        },
	        /*线条样式。*/
	    	lineStyle:{
			    color:"#4667f2",   //颜色，'rgb(128, 128, 128)'，'rgba(128, 128, 128, 0.5)'，支持线性渐变，径向渐变，纹理填充
			    shadowColor:"black",//阴影颜色
			    type:"solid",     //坐标轴线线的类型，solid，dashed，dotted
			    width:2          //坐标轴线线宽
			},
			/*折线拐点标志的样式。*/
	    	itemStyle:{
	    		color:"#4667f2",         //颜色
				borderType:"solid",  //柱条的描边类型，默认为实线，支持 'dashed', 'dotted'。
				shadowBlur:10,       //图形阴影的模糊大小。
				shadowColor:"#000"  //阴影颜色
	    	},
	        textStyle:{
	        	color:'white'
	        }
	    }],
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} "
	    }	
	};
 baodan.setOption(option_baodan);
 		//ajax结尾
 		},
 		error : function(e, type, msg) {
 			console.log(type + "=报单统计=" + msg);
 		}
 	}) 
  }	
/*报单统计end*/
 	
 //----------------------------------------------------------------------------汽车贷款过件率--------------------------------------
 	
/*过件率(汽车贷款通过)start*/
   var guojianlv = echarts.init(document.getElementById('guojianlv'));
   //前台数据图后台获取数据绘制
   function guojianselect() {
	    var sel = document.getElementById("guojianval").value
	    var obj = document.getElementById('guojiansel'); //定位id
	    var index = obj.selectedIndex; // 选中索引
	    var value = obj.options[index].value; // 选中值
	    var obj1 = document.getElementById('guojiantime'); //定位id
	    var index1 = obj1.selectedIndex; // 选中索引
	    var time = obj1.options[index1].value; // 选中值
   $.ajax({
 		dataType : "json",
 		type : "POST",
 		url : "Management/getCarPathMap.do",
 		data : {guojianname:sel,guojiancity:value,guojiantime:time},
 		success : function(data) {
 			 var carpassdata = [4473,4866,4992,3449,6521,5665,3569,3705,243];
             var carpasstime = ["2018-11","2018-12","2019-01","2019-02","2019-03","2019-04","2019-05","2019-06","2019-07"];
             if(time == "2018"){
            	 carpassdata = [1377,3029,2437,2673,3583,3237,5032,3806,4385];
            	 carpasstime = ["2018-02","2018-03","2018-04","2018-05","2018-06","2018-07","2018-08","2018-09","2018-10"];
             }
 	//数据图绘制
   option_guojianlv = {
	    xAxis: {
	        type: 'category',
        boundaryGap: false,
        data: carpasstime,//后台获取数据时间
        name:'时间',
        splitLine:{show: false},//去除网格线
        nameTextStyle:{//坐标轴名称的文字样式
        	padding: [0, 0, 0, -8]
        },
        axisLabel:{
    		rotate:70
        },
        axisTick:axistick,
        axisLine :{symbol:['none', 'arrow'],symbolSize:['10', '13'],lineStyle:{color:'#4667f2'}}//轴线
    },
    grid:{
    	left:'15%'
    },
    yAxis: {
        type: 'value',
        name:'数量',
        splitLine:{show: false},//去除网格线
        nameTextStyle:{
        	color:'#3b56cc'
        },
      /*  axisTick:{//刻度线
        	lineStyle:{ 
        		color:'white',
        		type:'dashed'
        	}
        }, */
        axisLine :{
        	symbol:['none', 'arrow'],
        	symbolSize:['10', '13'],
        	lineStyle:{
        		color:'#4667f2'
        	}
        }
    },
    series: [{
    	name:'过件率',
    	data: carpassdata,//后台获取数据
        type: 'line',
        areaStyle: {
        	// 线性渐变，前四个参数分别是 x0, y0, x2, y2, 范围从 0 - 1，相当于在图形包围盒中的百分比，如果 globalCoord 为 `true`，则该四个值是绝对的像素位置
			color: {
			    type: 'linear',
			    x: 0,
			    y: 0,
			    x2: 0,
			    y2: 1,
			    colorStops: [{
			        offset: 0, color: '#0f122b' // 0% 处的颜色
			    }, {
			        offset: 1, color: '#0f122b' // 100% 处的颜色
			    }],
			    globalCoord: false // 缺省为 false
			}
        },
        /*线条样式。*/
    	lineStyle:{
		    color:"#4667f2",   //颜色，'rgb(128, 128, 128)'，'rgba(128, 128, 128, 0.5)'，支持线性渐变，径向渐变，纹理填充
		    shadowColor:"black",//阴影颜色
		    type:"solid",     //坐标轴线线的类型，solid，dashed，dotted
		    width:2          //坐标轴线线宽
		},
		/*折线拐点标志的样式。*/
    	itemStyle:{
    		color:"#4667f2",         //颜色
			borderType:"solid",  //柱条的描边类型，默认为实线，支持 'dashed', 'dotted'。
			shadowBlur:10,       //图形阴影的模糊大小。
			shadowColor:"#000"  //阴影颜色
    	},
        textStyle:{
        	color:'white'
        }
    }],
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} "
    }
};
guojianlv.setOption(option_guojianlv);
	//ajax结尾
 		},
 		error : function(e, type, msg) {
 			console.log(type + "=汽车贷款过件=" + msg);
 		}
 	}) 
   }	
/*过件率(汽车贷款通过)end*/
   
//-----------------------------------------------------------------新旧车放款统计--------------------------------------------------
  
/*放款统计分析start*/
/*left_top*/
var fangkkuan_bar_1 = echarts.init(document.getElementById('fangkkuan_bar_1'));
function fangkuanselect() {
    var sel = document.getElementById("fangkuanval").value
    var obj = document.getElementById('fangkuansel'); //定位id
    var index = obj.selectedIndex; // 选中索引
    var value = obj.options[index].value; // 选中值
    var obj1 = document.getElementById('fangkuantime'); //定位id
    var index1 = obj1.selectedIndex; // 选中索引
    var time = obj1.options[index1].value; // 选中值
	   //前台数据图后台获取数据绘制
	   $.ajax({
	 		dataType : "json",
	 		type : "POST",
	 		url : "Management/getCarFkPathMap.do",
	 		data: {fangkuanname: sel,fangkuancity:value,fangkuantime:time},
	 		success : function(data) {
	 			var newcar = 27;
		 		var oldcar = 216;
	 			if(time == "2018"){
	 				newcar = 487;
			 		oldcar = 4379;
	 			}
	 		   
	option_fangkkuan_bar_1 = {
		title:{
	    	show:true,
	    	subtext:'新车二手车放款分布',
	    	left:'center',
			subtextStyle :{
	    		fontSize:12,
	    		color:'#ffffff'
	    	},
			padding:[
	    	           0, // 上
	    	           0, // 右
	    	           3, // 下
	    	           0, // 左
	    	]
	    },
		legend: {
	        x : 'center',//图例组件离容器下侧的距离
			bottom: '3',
	        data: [
	        {name:'新车'} ,
	        {name:'二手车'}
	        ],
	        itemWidth:20,//图例标记的图形宽度
	        itemHeight:9,//图例标记的图形高度
	        textStyle:{
	        	fontSize:11,
	        	color:'#fff'
	        },
	        bottom:-5
	    },
	    series : [
	        	{
	            name: '放款分布',
	            type: 'pie',
	            radius: '55%',//大小
	            minAngle: 2,
	            data:[
	                {value:newcar, name:'新车',itemStyle:{color:'#ff8700'}},//放款分布
	                {value:oldcar, name:'二手车',itemStyle:{color:'#4667f2'}}
	            ],
	            //hoverAnimation:false,//是否开启 hover 在扇区上的放大动画效果。
	            hoverOffset:1,//高亮扇区的偏移距离。
		        labelLine:{
		        	length:10,//视觉引导线第一段的长度。
		        	length2:5 //视觉引导项第二段的长度。
		        },
		        label: {
	                normal: {
	                    textStyle: {
	                        color: 'rgba(255, 255, 255, 0.3)',
	                        fontSize:9,
	                        color:'#ff8700'
	                    }
	                }
	            },
	        }
	    ],
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    }
	};
	fangkkuan_bar_1.setOption(option_fangkkuan_bar_1);
	//ajax结尾
	 		},
	 		error : function(e, type, msg) {
	 			console.log(type + "=车辆新旧=" + msg);
	 		}
	 	}) 
	 
	/*left_bottom-----------------------------------------------------放款金额分布统计---------------------------------------------*/

	 	var fangkkuan_bar_2 = echarts.init(document.getElementById('fangkkuan_bar_2'));
	
	   //前台数据图后台获取数据绘制
	   $.ajax({
	 		dataType : "json",
	 		type : "POST",
	 		url : "Management/getMoneyPathMap.do",
	 		data: {fangkuanname: sel,fangkuancity:value,fangkuantime:time},
	 		success : function(data) {
	 		   var singular1 = 127;
	 		   var singular2 = 39;
	 		   var singular3 = 51;
			   var singular4 = 6;
			   if(time == "2018"){
				    singular1 = 2233;
		 		    singular2 = 811;
		 		    singular3 = 1511;
				    singular4 = 311;
			   }
	option_fangkkuan_bar_2 = {
	    title:{
	    	show:true,
	    	subtext:'放贷金额的分布',
	    	left:'center',
			subtextStyle :{
	    		fontSize:12,
	    		color:'#ffffff'
	    	},
			padding:[
	    	           0, // 上
	    	           0, // 右
	    	           5, // 下
	    	           0, // 左
	    	]
	    },
		legend: {
	        x : 'center',//图例组件离容器下侧的距离
	        data: ['3 - 10万','20-50万','10-20万','50万以上'],
	        itemWidth:15,//图例标记的图形宽度
	        itemHeight:7,//图例标记的图形高度
	        textStyle:{
	        	fontSize:9,
	        	color:'#fff'
	        },
	        itemGap:1,
	        bottom:-5
	    },
	    series : [
	        	{
	            name: '金额分布',
	            type: 'pie',
	            radius: '55%',
	            minAngle: 2,
	            data:[
	                {value:singular1, name:'3 - 10万',itemStyle:{color:'#4667f2'}},//金额分布
	                {value:singular2, name:'20-50万',itemStyle:{color:'#ffffff'}},
	                {value:singular3, name:'10-20万',itemStyle:{color:'#ff8700'}},
	                {value:singular4, name:'50万以上',itemStyle:{color:'#6c79a0'}}
	            ],
	            hoverOffset:1,//高亮扇区的偏移距离。
		        labelLine:{
		        	length:1,//视觉引导线第一段的长度。
		        	length2:5 //视觉引导项第二段的长度。
		        },
		        label: {
	                normal: {
	                    textStyle: {
	                        color: 'rgba(255, 255, 255, 0.3)',
	                        fontSize:9,
	                        color:'#ff8700'
	                    }
	                }
	            },
	        }
	    ],
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	};
	 fangkkuan_bar_2.setOption(option_fangkkuan_bar_2);
	 
	//ajax结尾
		},
		error : function(e, type, msg) {
			console.log(type + "=贷款金额=" + msg);
		}
	}) 
	 
	/* ------------------------------------------------------新旧车放款统计，总订单数，总金额数------------------------------------------------------------*/

	var fangkkuan_lineANDbar_3 = echarts.init(document.getElementById('fangkkuan_lineANDbar_3'));
	
	   $.ajax({
			dataType : "json",
			type : "POST",
			url : "Management/getNewOldCarsPathMap.do",
			data: {fangkuanname: sel,fangkuancity:value,fangkuantime:time},
			success : function(data) {
	               var carstime = ["2018-08","2018-09","2018-10","2018-11","2018-12","2019-01","2019-02","2019-03","2019-04","2019-05","2019-06","2019-07"];
	               var newcars = [503,380,438,447,486,499,344,652,566,356,309,27];
				   var newcarsmoney = [3724.561,2855.314,3532.033,3489.625,3845.224,3893.887,2553.256,5275.991,4249.652,2704.681,2565.521,195.28];
				   var oldcars = [4529,3426,3947,4026,4380,4493,3105,5869,5009, 3213,3396,216];
				   var oldcarsmoney = [33520.049,25696.826,31787.297,31405.625,34606.016,35043.983,22978.304,47482.919,38245.868,24341.129,25599.71,1724.44];
	             if(time == "2018"){
	                 carstime = ["2018-01","2018-02","2018-03","2018-04","2018-05","2018-06","2018-07","2018-08","2018-09","2018-10","2018-11","2018-12"];
	                 newcars = [163,137,302,243,267,358,323,503,380,438,447,486];
					 newcarsmoney = [1678.816,1061.137,2301.247,1901.242,2031.724,2688.607,2589.985,3724.561,2855.314,3532.033,3489.625,3845.224];
					 oldcars = [1476,1240,2727,2194,2406,3225,2914,4529,3426,3947,4026,4380];
					 oldcarsmoney = [15108.344,9549.233,20710.223,17110.178,18284.516,24196.463,23308.865,33520.049,25696.826,31787.297,31405.625,34606.016];
	             }
			   
	option_fangkkuan_lineANDbar_3 = {
	    tooltip: { //提示框组件。 
	        trigger: 'axis',//触发类型:'axis'坐标轴触发，主要在柱状图，折线图等会使用类目轴的图表中使用。
	        axisPointer: { //坐标轴指示器配置项。
	            type: 'cross', //指示器类型。 'cross' 十字准星指示器
	            crossStyle: {
	                color: '#999' //交叉风格
	            }
	        }
	    },
		legend: {
	        x : 'center',//图例组件离容器下侧的距离
			width: 300,//图例组件的宽度
	        data:['新车放款订单数',' 新车放贷金额  ','二手车放款订单数','二手车放贷金额'],
	        itemWidth:15,//图例标记的图形宽度
	        itemHeight:10,//图例标记的图形高度
	        textStyle:{
	        	fontSize:12,
	        	color:'#4667f2'
	        },
	        itemGap:7,
	        bottom:-5
	    },
	    grid:{//直角坐标系内绘图网格
	        show:false,//是否显示直角坐标系网格。[ default: false ]
	        right:"12%"
	    },
	    xAxis: [
	        {	
	        	name:'时间',
	        	nameTextStyle:{//坐标轴名称的文字样式。
	        		padding: [27, 0, 0, -6]
	        	},
	            type: 'category',
	            data: carstime,
	            axisPointer: {//坐标轴指示器配置项。
	                type: 'shadow'
	            },
	             axisTick:axistick,
				 axisLine :{symbolSize:['10', '13'],lineStyle:{color:'#4667f2'}}//轴线
	        }
	    ],
	    yAxis: [
	        {
	            type: 'value',
	            name: '总放款订单数量',
	            /*min: 0,
	            interval: 50,*/
	            axisLabel: {
	                formatter: '{value}'
	            },
	            nameTextStyle:{//坐标轴名称的文字样式。
	        		padding: [0, 0, 0, 20]
	        	},
	            splitLine:{show: false},//去除网格线
	            axisTick:axistick,
				axisLine :{lineStyle:{color:'#4667f2'}}//轴线
	        },
	        {
	            type: 'value',
	            name: '总放款金额:万',
	            axisLabel: {
	                formatter: '{value} '
	            },
	            nameTextStyle:{//坐标轴名称的文字样式。
	        		padding: [0, 0, 0, -20]
	        	},
	            splitLine:{show: false},//去除网格线
	            axisTick:axistick,
				axisLine :{lineStyle:{color:'#4667f2'}}//轴线
	        }
	    ],
	    series: [
	        {
	            name:'新车放款订单数',
	            type:'bar',
	            data:newcars
	        },
	        {
	            name:'二手车放款订单数',
	            type:'bar',
	            data:oldcars
	        },
	        {
	            name:' 新车放贷金额  ',
	            type:'line',
	            yAxisIndex: 1,
	            data:newcarsmoney
	        },
	        {
	            name:'二手车放贷金额',
	            type:'line',
	            yAxisIndex: 1,
	            data:oldcarsmoney
	        
	        }
	    ],
	    color:['#e07805','#344bb1'] //全局调色板  好用到爆炸
	};
	 fangkkuan_lineANDbar_3.setOption(option_fangkkuan_lineANDbar_3);
	//ajax结尾
			},
			error : function(e, type, msg) {
				console.log(type + "=新旧车放款金额曲线=" + msg);
			}
		}) 
}
/*right*/



/*抵押完成情况start*/
var diyawancheng = echarts.init(document.getElementById('diyawancheng'));

//前台数据图后台获取数据绘制
function diyaselect() {
    var sel = document.getElementById("diyaval").value
    var obj = document.getElementById('diyasel'); //定位id
    var index = obj.selectedIndex; // 选中索引
    var value = obj.options[index].value; // 选中值
    var obj1 = document.getElementById('diyatime'); //定位id
    var index1 = obj1.selectedIndex; // 选中索引
    var time = obj1.options[index1].value; // 选中值
$.ajax({
		dataType : "json",
		type : "POST",
		url : "Management/getPawnPathMap.do",
		data: {diyaname: sel,diyacity:value,diyatime:time},
		success : function(data) {
			var paw1=43;
            var paw2=150;
            var paw3=29;
            var paw4=1;
            var paw5=0;
            if(time == "2018"){
                 paw1=103;
                 paw2=2054;
                 paw3=2246;
                 paw4=340;
                 paw5=143;
            }
option_diyawancheng= {
    series : [
        {
            name: '抵押完成情况',
            type: 'pie',
            radius: '80%',
            roseType: 'angle',
            minAngle: 2,
            data:[
                {value:paw5, name:'60天以上',},
                {value:paw1, name:'0-15天'},
                {value:paw2, name:'15-30天',itemStyle:{color:'#ff8700' }},
                {value:paw3, name:'30-45天',},
                {value:paw4, name:'45-60天',}
            ],
            labelLine: {
                length:7,
                length2:7,
                lineStyle:{
					color: 'rgba(255, 255, 255, 0.3)'
                }
            },
            label: {
                normal: {
                    textStyle: {
                        color: '#4667f2'
                    }
                }
            },
             itemStyle: {
                normal: {
                    color: '#4161f1',
                    shadowBlur: 200
                },
                emphasis:{
                	color:'#ff8700'
                }
            }
        }
    ],
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
};
diyawancheng.setOption(option_diyawancheng);
//前台数据图后台获取数据绘制
//ajax结尾
		},
		error : function(e, type, msg) {
			console.log(type + "=抵押情况=" + msg);
		}
	}) 
}	
/*---------------------------------------------------------------抵押完成情况end------------------------------------------------------*/
/*材料回收情况start*/
var cailiaohuishou = echarts.init(document.getElementById('cailiaohuishou'));

//前台数据图后台获取数据绘制
function cailiaoselect() {
    var sel = document.getElementById("cailiaoval").value
    var obj = document.getElementById('cailiaosel'); //定位id
    var index = obj.selectedIndex; // 选中索引
    var value = obj.options[index].value; // 选中值
    var obj1 = document.getElementById('cailiaotime'); //定位id
    var index1 = obj1.selectedIndex; // 选中索引
    var time = obj1.options[index1].value; // 选中值
$.ajax({
		dataType : "json",
		type : "POST",
		url : "Management/getRecyclePathMap.do",
		data: {cailiaoname: sel,cailiaocity:value,cailiaotime:time},
		success : function(data) {
		   var recycledata = [4373,4766,4892,3349,6421,5565,3469,3705,243];
           var recycletime = ["2018-11","2018-12","2019-01","2019-02","2019-03","2019-04","2019-05","2019-06","2019-07"];
           if(time == "2018"){
        	   recycledata = [1277,2929,2337,2573,3483,3137,4932,3706,4285];
               recycletime = ["2018-02","2018-03","2018-04","2018-05","2018-06","2018-07","2018-08","2018-09","2018-10"];
           }
option_cailiaohuishou= {
    xAxis: {
        type: 'category',
        data: recycletime,
        name:'时间',
        nameTextStyle:{//坐标轴名称的文字样式。
				padding: [0, 0, 0, -10]
        },
        axisLabel:{
    		rotate:70
    	},
	    axisTick:axistick,
	    axisLine :{symbol:['none', 'arrow'],symbolSize:['10', '13'],lineStyle:{color:'#4667f2'}}//轴线
    },
   legend: {
        x : '20',//图例组件离容器下侧的距离
		width: 230,//图例组件的宽度
        data:['抵押材料'],//'征信授权书','贷款纸质材料','卡单'
        itemWidth:20,//图例标记的图形宽度
        itemHeight:10,//图例标记的图形高度
        textStyle:{
        	fontSize:12,
        	color:'#6c79a0'
        },
        itemGap:7,
        top:-6,
    },
    yAxis: {
        type: 'value',
        name:'过件数',
        axisTick:axistick,
	    axisLine :{symbol:['none', 'arrow'],symbolSize:['10', '13'],lineStyle:{color:'#4667f2'}},//轴线
	    splitLine:{show: false},//去除网格线
	    nameTextStyle:{//坐标轴名称的文字样式。
				padding: [0, 0, -8,30]
        },
    },
    series: [
    	/*{
	        data: [820, 932, 901, 934, 1290, 1330, 1320],
	        type: 'line',
	        name:'征信授权书',
	        lineStyle :{
	        	width:1
	        }
	    },
	    {
	        data: [80, 92, 91, 94, 10, 130, 120],
	        type: 'line',
	        name:'贷款纸质材料',
	        lineStyle :{
	        	width:1
	        }
	    },*/
	    {
	    	data: recycledata,
	        type: 'line',
	        name:'抵押材料',
	        lineStyle :{
	        	width:1
	        }
	    }/*,
	     {
	    	data: [456, 254, 356, 787, 444, 178, 564],
	        type: 'line',
	        name:'卡单',
	        lineStyle :{
	        	width:1
	        }
	    }*/
    ],
    color:['#8e0e46','#5c6789','#ff8700','#3c59d2']
};
cailiaohuishou.setOption(option_cailiaohuishou);
//ajax结尾
},
	error : function(e, type, msg) {
		console.log(type + "=抵押材料情况=" + msg);
		}
	}) 
}
/*材料回收情况end*/

/*-----------------------------------------------------------------------------逾期率start---------------------------------------------------------------------*/
/*left*/
var yuqilv1 = echarts.init(document.getElementById('yuqilv1'));
function yuqiselect() {
    var sel = document.getElementById("yuqival").value
    var obj = document.getElementById('yuqisel'); //定位id
    var index = obj.selectedIndex; // 选中索引
    var value = obj.options[index].value; // 选中值
    $.ajax({
        dataType: "json",
        type: "POST",
        url: "Management/getOverdueMap.do",
        data: {yuqiname: sel,yuqicity:value},
        success: function (data) {
        	var amount = [0.49,0.36,0.24];
            var newcars = [0,0,0];
            var oldcars = [0.49,0.36,0.24];
            var amountmoney = [3.84,2.88,1.92];
            var newcarsmoney = [0,0,0];
            var oldcarsmoney = [3.84,2.88,1.92];
 option_yuqilv1 = {
    tooltip: { //提示框组件。 
        trigger: 'axis',//触发类型:'axis'坐标轴触发，主要在柱状图，折线图等会使用类目轴的图表中使用。
        axisPointer: { //坐标轴指示器配置项。
            type: 'cross', //指示器类型。 'cross' 十字准星指示器
            crossStyle: {
                color: '#999' //交叉风格
            }
        }
    },
	legend: {
        x : 'center',//图例组件离容器下侧的距离
		width: 250,//图例组件的宽度
        data:['订单总数量','新车数量','二手车数量','订单总金额','新车金额','二手车金额'],
        itemWidth:15,//图例标记的图形宽度
        itemHeight:10,//图例标记的图形高度
        textStyle:{
        	fontSize:12,
        	color:'#4667f2'
        },
        itemGap:7,
        bottom:-5
    },
    grid:{//直角坐标系内绘图网格
        show:false,//是否显示直角坐标系网格。[ default: false ]
        right:"12%"
    },
    xAxis: [
        {	
        	name:'逾期率',
        	nameTextStyle:{//坐标轴名称的文字样式。
        		padding: [27, 0, 0, -6]
        	},
            type: 'category',
            data: ['M1','M2','M3'],
            axisPointer: {//坐标轴指示器配置项。
                type: 'shadow'
            },
             axisTick:axistick,
			 axisLine :{symbolSize:['10', '13'],lineStyle:{color:'#4667f2'}}//轴线
        }
    ],
    yAxis: [
        {
            type: 'value',
            name: '逾期订单数量',
            min: 0,
            max: 15,
            interval: 50,
            axisLabel: {
                formatter: '{value}'
            },
            nameTextStyle:{//坐标轴名称的文字样式。
        		padding: [0, 0, 0, 20]
        	},
            splitLine:{show: false},//去除网格线
            axisTick:axistick,
			axisLine :{lineStyle:{color:'#4667f2'}}//轴线
        },
        {
            type: 'value',
            name: '逾期订单金额(万)',
            axisLabel: {
                formatter: '{value} '
            },
            nameTextStyle:{//坐标轴名称的文字样式。
        		padding: [0, 0, 0, -20]
        	},
            splitLine:{show: false},//去除网格线
            axisTick:axistick,
			axisLine :{lineStyle:{color:'#4667f2'}}//轴线
        }
    ],
    series: [
        {
            name: '订单总数量',
            type: 'bar',
            data: amount,
            barWidth: 16
        },
        {
            name: '新车数量',
            type: 'bar',
            data: newcars,
            barWidth: 16
        },
        {
            name: '二手车数量',
            type: 'bar',
            data: oldcars,
            barWidth: 16
        },
        {
            name: '订单总金额',
            type: 'line',
            yAxisIndex: 1,
            data: amountmoney
        },
        {
            name: '新车金额',
            type: 'line',
            yAxisIndex: 1,
            data: newcarsmoney

        },
        {
            name: '二手车金额',
            type: 'line',
            yAxisIndex: 1,
            data: oldcarsmoney

        }
    ],
    color:['#666699','#344bb1','#e07805'] //全局调色板  好用到爆炸
};
            yuqilv1.setOption(option_yuqilv1);
        },
        error: function (e, type, msg) {
        	console.log(type + "=逾期率M1，M2，M3查询=" + msg);
        }
    })

}

/*----------------------------------------------------------------------------right----------------------------------------------------------------*/
var yuqilv2 = echarts.init(document.getElementById('yuqilv2'));
$.ajax({
    dataType : "json",
    type : "POST",
    url : "Management/getStateMap.do",
    success : function(data){
option_yuqilv2= {
    tooltip: {
        trigger: 'item',
        formatter: "{a}<br/>{b}: {c} "
    },
    series: [
     {
            name:'省份逾期数量',
            type:'pie',
            selectedMode: 'single',
            radius: [0, '30%'],
            minAngle: 2,
          	label: {
                show:false
            },
            labelLine: {
                normal: {
                    show: false
                }
            },
            data:[
                {value:0, name:"河北省"},
                {value:0, name:"山西省"},
                {value:0, name:"山东省"},
                {value:0, name:"河南省"},
                {value:0, name:"江苏省"},
                {value:0, name:"其他省"}
            ],          
        },
        {
            name:'省份逾期金额',
            type:'pie',
            minAngle: 2,
            radius: ['40%', '55%'],
            data:[
                {value:0, name:"河北省"},
	            {value:0, name:"山西省"},
	            {value:0, name:"山东省"},
	            {value:0, name:"河南省"},
	            {value:0, name:"江苏省"},
	            {value:0, name:"其他省"}
            ]
        }
    ],
     color:['#666699','#fc4100','#ff8700','#47febf','#4667f2','#ffffff']
};
yuqilv2.setOption(option_yuqilv2);

//ajax结尾
    },
    error : function(e, type, msg) {
    	console.log(type + "=逾期省份=" + msg);
    }
})
/*------------------------------------------------------------------逾期率end---------------------------------------------------------------------*/
/*-----------------------------------------------------------------代理商综合能力分析start----------------------------------------------------------------*/
var zonghenenglifenxi = echarts.init(document.getElementById('zonghenenglifenxi'));
function dailiselect() {
	var sel = document.getElementById("dailival").value
    var obj = document.getElementById('dailitime'); //定位id
    var index = obj.selectedIndex; // 选中索引
    var value = obj.options[index].value; // 选中值
    var amount = [];
    var max1;
    var max2;
    var max3;
    var max4;
    var max5;
    $.ajax({
        dataType: "json",
        type: "POST",
        url: "Management/getAgencyMap.do",
        data: {dailiname: sel,dailitime:value},
        success: function (data) {
        	var year = "2019年";
            data[1] = 328;
            data[2] = 3;
            data[3] = 243;
            data[4] = 0;
            data[5] = 0;
            if(value == "2018"){
                year = "2018年"
                data[1] = 6292;
                data[2] = 3;
                data[3] = 4866;
                data[4] = 4;
                data[5] = 9;
            }

            for(var i=1;i<6;i++){
                amount[i-1]=data[i];
            }
            
            //报单量数据上限计算绘图
            if(data[1] < 100){
                max1 = 100/data[1]/10+2
            }else if(data[1] < 300){
                max1 = 300/data[1]/10+1.7
            }else if(data[1] < 600){
                max1 = 600/data[1]/10+1.5
            }else if(data[1] < 1200){
                max1 = 1200/data[1]/10+1.3
            }else if(data[1] < 2000){
                max1 = 2000/data[1]/10+1.1
            }else{
                max1 = 1.1-(data[1]/2000)/100
            }
            //抵押完成上限计算绘图
            if(data[3] < 80){
                max3 = 80/data[3]/10+2
            }else if(data[3] < 240){
                max3 = 240/data[3]/10+1.7
            }else if(data[3] < 480){
                max3 = 480/data[3]/10+1.5
            }else if(data[3] < 960){
                max3 = 960/data[3]/10+1.3
            }else if(data[3] < 1600){
                max3 = 1600/data[3]/10+1.1
            }else{
                max3 = 1.1-(data[3]/1600)/100
            }
            //进件效率上限计算绘图
            if(data[2] < 5){
                max2 = 1.0+data[2]/20
            }else if(data[2] < 10){
                max2 = 1.2+data[2]/40
            }else if(data[2] < 20){
                max2 = 1.6+data[2]/50
            }else if(data[2] < 40){
                max2 = 1.8+data[2]/100
            }else{
                max2 = 2.0+data[2]/200
            }
            //M3逾期上限计算绘图
            if(data[4] < 5){
                max4 = 1.0+data[4]/20
            }else if(data[4] < 10){
                max4 = 1.2+data[4]/40
            }else if(data[4] < 20){
                max4 = 1.4+data[4]/50
            }else if(data[4] < 40){
                max4 = 1.6+data[4]/100
            }else{
                max4 = 1.8+data[4]/200
            }
            //M1逾期上限计算绘图
            if(data[5] < 10){
                max5 = 1.0+data[5]/40
            }else if(data[5] < 20){
                max5 = 1.2+data[5]/70
            }else if(data[5] < 40){
                max5 = 1.4+data[5]/100
            }else if(data[5] < 60){
                max5 = 1.6+data[5]/200
            }else{
                max5 = 1.9+data[5]/200
            }
	option_zonghenenglifenxi = {
	    tooltip: {
	        trigger: 'item',
	        show:true,
	       	formatter:function(params){
	    		var s='';
	    		s+=params.name+'\n';
	    		var values=params.value.toString().split(",");
				s+='业务能力:'+values[0]+'\n';
				s+='进件效率'+values[1]+'\n';
				s+='运营能力'+values[2]+'\n';
				s+='贷后能力'+values[3]+'\n';
				s+='风控能力'+values[4]+'\n';
	    		//系列名称:seriesName: string  数据名，类目名 : name: string   传入的数据值:value: number|Array
	    		return s;
		     },
		     extraCssText:'width:120px; white-space:pre-wrap'//额外附加到浮层的 css 样式 pre-wrap:保留空白符序列，可是正常地进行换行。
	    },
	    visualMap: {
	    	show:false,
	        top: 'middle',
	        right: 10,
	        color: ['#d91564', '#c47332'],
	        calculable: true
	    },
	    radar: {
	       indicator : [
                {text : '业务能力-报单量',  max  : data[1] == 0?10:data[1] * max1},
                {text : '进件效率-订单提交至-银行放款时长',  max : data[1] == 0?10:data[2] * max2},
                {text : '运营能力-抵押完成情况', max  : data[1] == 0?10:data[3] * max3},
                {text : '贷后能力-M3及以上逾期率', max : data[1] == 0?10:data[4] * max4},
                {text : '风控能力-M1逾期率',  max : data[1] == 0?10:data[5] * max5}
	        ],
	        radius:'60%',
	        nameGap:-2,
	        name:{//这里以-分割
	        	formatter: function (value,indicator) {
				    var values=value.split('-');
				    var v='';
				    v+='{a|'+values[0]+'}\n{b|'+values[1]+'}';
				    if(!!values[2]){v+='\n{b|'+values[2]+'}'};
				    return v;
				},
				width:100,
				lineStyle: {
				   color: ['#415fe0']
				},
	        	rich:{//富文本标签
	        		a: {
			            color: '#4667f2',
			            lineHeight: 20,
			            fontSize:12,
			            align:'center'
			        },
			        b: {
			          color: '#6c79a0',
			          lineHeight: 15,
			          fontSize:11,
			          align:'center'
			        }
	        	}
	        },
	        splitArea: {
	        	areaStyle: {
	                color: ['#222f70', '#222f70','#354cb2','#3a54c5'] //分隔区域的样式设置。
	            }
	        },
	        axisLine: {//坐标线 直接隐藏
	        	show:false
	        },
	        splitLine: {//区域中的分隔线。
	            show:true,
	             lineStyle: {
				       color: ['#415fe0']
				  }
	        }
	    },
	    series : [
			{
			    type: 'radar',
			    itemStyle: {
			        normal: {
			            areaStyle: {
			                type: 'default'
			            }
			        }
			    },
			    data : [
			        {
			            value : amount,
			            name : year+'年'
			        },
			    ],
			    lineStyle : {
                    color: '#FA4889',
                    width: 2,
                    type: 'solid'
                },
                itemStyle: {normal: {areaStyle: {type: 'default',color:'rgb(255,19,109)'}}},
			}      
	    ]
	};
	zonghenenglifenxi.setOption(option_zonghenenglifenxi);
        },
        error: function (e, type, msg) {
            console.log(type + "=代理商综合能力分析=" + msg);
        }
    })
}
/*--------------------------------------------------------征信查询通过率start-------------------------------------------*/
	var zhengxinchaxuntongguolv = echarts.init(document.getElementById('zhengxinchaxuntongguolv'));
	function zhengxinselect() {
	    var sel = document.getElementById("zhengxinval").value
	    var obj = document.getElementById('zhengxinsel'); //定位id
	    var index = obj.selectedIndex; // 选中索引
	    var value = obj.options[index].value; // 选中值
	    var obj1 = document.getElementById('zhengxintime'); //定位id
	    var index1 = obj1.selectedIndex; // 选中索引
	    var time = obj1.options[index1].value; // 选中值
	$.ajax({
		dataType : "json",
		type : "POST",
		url : "Management/getCreditPathMap.do",
		data: {zhengxinname: sel,zhengxincity:value,zhengxintime:time},
		success : function(data) {
			 	var credit1= 85;
	            var credit2= 243;
	            if(time == "2018"){
	                credit1= 4866;
	                credit2= 1426;
	            }
	option_zhengxinchaxuntongguolv = {
	legend: {
        x : 'center',//图例组件离容器下侧的距离
		bottom: '0',
		width:200,
        data: [
        {name:'征信通过'} ,
        {name:'征信不通过'}
        ],
        itemWidth:15,//图例标记的图形宽度
        itemHeight:15,//图例标记的图形高度
        textStyle:{
        	fontSize:11,
        	color:'#fff'
        },
        bottom:8
    },
    series : [
        	{
            name: '征信查询通过率',
            type: 'pie',
            minAngle: 2,
            radius: '62%',//大小
            data:[
                {value:credit2, name:'征信通过'},
                {value:credit1, name:'征信不通过'}
            ],
            //hoverAnimation:false,//是否开启 hover 在扇区上的放大动画效果。
            hoverOffset:1,//高亮扇区的偏移距离。
	        labelLine:{
	        	length:15,//视觉引导线第一段的长度。
	        	length2:10 //视觉引导项第二段的长度。
	        },
	        label: {
                normal: {
                    textStyle: {
                        color: 'rgba(255, 255, 255, 0.3)',
                        fontSize:12
                    }
                }
            },
        }
    ],
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    color:['#ff8700','#4667f2']
};
zhengxinchaxuntongguolv.setOption(option_zhengxinchaxuntongguolv);
//ajax结尾
		},
		error : function(e, type, msg) {
			console.log(type + "=征信查询=" + msg);
		}
	}) 
	}	

/*---------------------------------------------------------------客户和车辆画像start---------------------------------------------------------*/
/*left*/
var kehunianling = echarts.init(document.getElementById('kehunianling'));
	//前台数据图后台获取数据绘制
	$.ajax({
			dataType : "json",
			type : "POST",
			url : "Management/getAgePathMap.do",
			success : function(data) {
				var age1=44;
		        var age2=131;
		        var age3=47;
		        var age4=1;
option_kehunianling = {
legend: {
    x : 'center',//图例组件离容器下侧的距离
	bottom: '0',
	width:200,
    data: [
    {name:'18-30岁'} ,
    {name:'30-40岁'},
    {name:'40-50岁'},
    {name:'50岁以上'}
    ],
    itemWidth:15,//图例标记的图形宽度
    itemHeight:10,//图例标记的图形高度
    textStyle:{
    	fontSize:13,
    	color:'#fff'
    },
    bottom:-5
},
series : [
    	{
        name: '客户年龄分布',
        type: 'pie',
        radius: '62%',//大小
        minAngle: 2,
        data:[
            {value:age1, name:'18-30岁'},
            {value:age2, name:'30-40岁'},
            {value:age3, name:'40-50岁'},
            {value:age4, name:'50岁以上'}
        ],
        //hoverAnimation:false,//是否开启 hover 在扇区上的放大动画效果。
        hoverOffset:1,//高亮扇区的偏移距离。
        labelLine:{
        	length:15,//视觉引导线第一段的长度。
        	length2:10 //视觉引导项第二段的长度。
        },
        label: {
            normal: {
                textStyle: {
                    color: 'rgba(255, 255, 255, 0.3)',
                    fontSize:13
                }
            }
        },
    }
],
tooltip : {
    trigger: 'item',
    formatter: "{a} <br/>{b} : {c} ({d}%)"
},
color:['#4667f2','#ffffff','#6c79a0','#ff8700']
};
kehunianling.setOption(option_kehunianling);
//ajax结尾
	 		},
	 		error : function(e, type, msg) {
	 			console.log(type + "=客户年龄=" + msg);
	 		}
	 	}) 
/*---------------------------------------------------------客户年龄right----------------------------------------------------*/
var cheliangnianling = echarts.init(document.getElementById('cheliangnianling'));
	
	//前台数据图后台获取数据绘制
	$.ajax({
			dataType : "json",
			type : "POST",
			url : "Management/getCarsAgePathMap.do",
			success : function(data) {
				var age1=3;
		        var age2=52;
		        var age3=122;
		        var age4=46;
option_cheliangnianling = {
legend: {
    x : 'center',//图例组件离容器下侧的距离
	bottom: '3',
	width:180,
    data: [
    {name:'1-3年'} ,
    {name:'3-6年'},
    {name:'6-9年'},
    {name:'9年以上'}
    ],
    itemWidth:15,//图例标记的图形宽度
    itemHeight:10,//图例标记的图形高度
    textStyle:{
    	fontSize:13,
    	color:'#fff'
    },
    bottom:-5
},
series : [
    	{
        name: '车辆年龄分布',
        type: 'pie',
        minAngle: 2,
        radius: '62%',//大小
        data:[
            {value:age1, name:'1-3年'},
            {value:age2, name:'3-6年'},
            {value:age3, name:'6-9年'},
            {value:age4, name:'9年以上'}
        ],
        //hoverAnimation:false,//是否开启 hover 在扇区上的放大动画效果。
        hoverOffset:1,//高亮扇区的偏移距离。
        labelLine:{
        	length:15,//视觉引导线第一段的长度。
        	length2:15 //视觉引导项第二段的长度。
        },
        label: {
            normal: {
                textStyle: {
                    color: 'rgba(255, 255, 255, 0.3)',
                    fontSize:13
                }
            }
        },
    }
],
tooltip : {
    trigger: 'item',
    formatter: "{a} <br/>{b} : {c} ({d}%)"
},
color:['#4667f2','#ffffff','#6c79a0','#ff8700']
};
cheliangnianling.setOption(option_cheliangnianling);
//ajax结尾
	},
	error : function(e, type, msg) {
		console.log(type + "=新车年龄=" + msg);
	}
}) 

/*------------------------------------------------------------------客户和车辆画像end-----------------------------------------------------------*/

/*资金周转率(垫资方)start*/
 var zijinzhouzhuanlv = echarts.init(document.getElementById('zijinzhouzhuanlv'));
	function dianziselect(){
	    var obj = document.getElementById('dianzisel'); //定位id
	    var index = obj.selectedIndex; // 选中索引
	    var value = obj.options[index].value; // 选中值
	$.ajax({
		dataType : "json",
		type : "POST",
		url : "Management/getAdvanceFundPathMap.do",
		data: {dianzicity:value },
		success : function(data) {
		   var advancefundtime = ["2018-08","2018-09","2018-10","2018-11","2018-12","2019-01","2019-02","2019-03","2019-04","2019-05","2019-06","2019-07",];
		   var advancefunddata = [3.25,4.09,3.65,3.35,3.12,2.98,2.65,3.04,3.87,3.25,2.58,3.36];
		   
		   
 option_zijinzhouzhuanlv = {
		    tooltip: { //提示框组件。 
        trigger: 'axis',//触发类型:'axis'坐标轴触发，主要在柱状图，折线图等会使用类目轴的图表中使用。
        axisPointer: { //坐标轴指示器配置项。
            type: 'cross', //指示器类型。 'cross' 十字准星指示器
            crossStyle: {
                color: '#999' //交叉风格
            }
        }
    },
	legend: {
        x : 'center',//图例组件离容器下侧的距离
		width: 300,//图例组件的宽度
        data:['资金使用时长',/*'资金周转率'*/],
        itemWidth:15,//图例标记的图形宽度
        itemHeight:15,//图例标记的图形高度
        textStyle:{
        	fontSize:13,
        	color:'#4667f2'
        },
        itemGap:7,
        bottom:-5
    },
    grid:{//直角坐标系内绘图网格
        show:false,//是否显示直角坐标系网格。[ default: false ]
        right:"12%"
    },
    xAxis: [
        {	
        	name:'时间',
        	nameTextStyle:{//坐标轴名称的文字样式。
        		padding: [27, 0, 0, -6],
        		fontSize:14
        	},
            type: 'category',
            data: advancefundtime,
            axisPointer: {//坐标轴指示器配置项。
                type: 'shadow'
            },
             axisTick:axistick,
			 axisLine :{symbolSize:['10', '13'],lineStyle:{color:'#4667f2'}},//轴线
			 textStyle:{
			 	fontSize:15
			 }
        }
    ],
    yAxis: [
        /*{
            type: 'value',
            name: '资金周转率(%)',
            min: 0,
            max: 250,
            interval: 50,
            axisLabel: {
                formatter: '{value}'
            },
            nameTextStyle:{//坐标轴名称的文字样式。
        		padding: [0, 0, 0, 20],
        		fontSize:14
        	},
            splitLine:{show: false},//去除网格线
            axisTick:axistick,
			axisLine :{lineStyle:{color:'#4667f2'}}//轴线
        },*/
        {
            type: 'value',
            name: '资金使用时长(天)',
            axisLabel: {
                formatter: '{value} '
            },
            nameTextStyle:{//坐标轴名称的文字样式。
        		padding: [0, 0, 0, -20],
        		fontSize:14
        	},
            splitLine:{show: false},//去除网格线
            axisTick:axistick,
			axisLine :{lineStyle:{color:'#4667f2'}}//轴线
        }
    ],
    series: [
        {
            name:'资金使用时长',
            type:'bar',
            data:advancefunddata,
            barWidth:20
        },
        /*{
            name:'资金周转率',
            type:'line',
            yAxisIndex: 1,
            data:[60, 50, 50, 70, 60, 80, 78, 66, 89, 76, 56, 38]
        }*/
    ],
    color:['#4667f2','#e87b02'] //全局调色板  好用到爆炸
};
zijinzhouzhuanlv.setOption(option_zijinzhouzhuanlv);

//ajax结尾
		},
		error : function(e, type, msg) {
			console.log("=垫资失败=");
		}
	}) 
	}	
/*资金周转率(垫资方)end*/