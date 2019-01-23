<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html><head>
<link rel="icon" href="${pageContext.request.contextPath }/cskjs_css/logo.png" type="image/x-icon"/>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>快加后台管理</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<script type="text/javascript">
		var _rooturl = "http://a.kcway.net/assess/";
		var page_cn = "";
	</script>
<!-- Bootstrap 3.3.4 -->
<link href="${pageContext.request.contextPath }/cskjs_css/bootstrap.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">

<!-- Font Awesome Icons -->
<!-- Font Awesome Icons -->
<link href="${pageContext.request.contextPath }/cskjs_css/font-awesome.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/cskjs_css/select2.css" rel="stylesheet" type="text/css">
<!-- Theme style -->
<link href="${pageContext.request.contextPath }/cskjs_css/AdminLTE.css" rel="stylesheet" type="text/css">
<!-- AdminLTE Skins. We have chosen the skin-blue for this starter
			page. However, you can choose any other skin. Make sure you
			apply the skin class to the body tag so the changes take effect.
	-->
<link href="${pageContext.request.contextPath }/cskjs_css/skin-green.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/cskjs_css/style.css" rel="stylesheet" type="text/css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		<script src="https://cdn.bootcss.com/html5shiv/r29/html5.min.js"></script>
		<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
<!-- jQuery 2.1.4 -->
<script src="${pageContext.request.contextPath }/cskjs_css/jQuery-2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/jquery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/ajaxfileupload.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/cskjs_css/php.js"></script>
<!-- Bootstrap 3.3.2 JS -->
<script src="${pageContext.request.contextPath }/cskjs_css/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/moment.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/daterangepicker.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/cskjs_css/daterangepicker-bs3.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/cskjs_css/bootstrap-datepicker.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/cskjs_css/datepicker3.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/cskjs_css/bootstrap-datepicker_002.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/bootstrap-datetimepicker.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/cskjs_css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/cskjs_css/bootstrap-datetimepicker_002.js" type="text/javascript"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/cskjs_css/ueditor_002.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/cskjs_css/ueditor.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script src="${pageContext.request.contextPath }/cskjs_css/select2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/zh-CN.js" type="text/javascript"></script>
<style type="text/css">
select {
/*Chrome和Firefox里面的边框是不一样的，所以复写了一下*/
border: solid 1px #fff0;

/*很关键：将默认的select选择框样式清除*/
appearance:none;
-moz-appearance:none;
-webkit-appearance:none;

/*在选择框的最右侧中间显示小箭头图片*/
background: url("${pageContext.request.contextPath }/cskjs_css/xljt@2x.png") no-repeat scroll right center transparent;
/*为下拉小箭头留出一点位置，避免被文字覆盖*/
padding-right: 30px;
}
/*清除ie的默认选择框样式清除，隐藏下拉箭头*/
select::-ms-expand { display: none; }
		
		</style>	
<style type="text/css">

li{list-style-type:none;}

.dada{

    border-bottom: 1px solid #cccee1;
    border-left: 1px solid #cccee1;
    border-right: 1px solid #cccee1;
    padding:15px 15px 15px 15px;
    -moz-border-radius: 5px;
    -webkit-border-radius: 5px;
    border-radius: 4px;
    overflow: hidden;
    -moz-box-shadow: 0 0 60px rgba(0, 0, 0, 0.1);
    -webkit-box-shadow: 0 0 60px rgba(0, 0, 0, 0.1);
    box-shadow: 0 0 5px #4187dd66;
}
		
		</style>
<script src="${pageContext.request.contextPath }/cskjs_css/circleChart.min.js"></script>   
	<style>

	.divcss{
	height:273px;
	overflow:hidden; zoom:1;
	margin-top:10px;
    border-bottom: 1px solid #cccee100;
    border-left: 1px solid #cccee100;
    border-right: 1px solid #cccee100;    
    padding:15px 15px 15px 15px;
    -moz-border-radius: 5px;
    -webkit-border-radius: 5px;
    border-radius: 4px;
    overflow: hidden;
    -moz-box-shadow: 0 0 60px #cccee100;
    -webkit-box-shadow: 0 0 60px #cccee100;
    box-shadow: 0 0 5px #4187dd33;    
         }
      .left {
        float: left;
        width: 40%;
        height:100%;
        margin-left: 20px;
      }
      .left1 {
        float: left;
        width: 42%;
        height:100%;
        margin-left: 20px;
      }
      .right {
        float: right;
        width: 55%;
        height:100%;               
      }
    .ah:hover{
	text-decoration:none;
    display:block;/*第一步要将a标签定义为块级标记，这个很重要，如果不定义为块，就不好使，你可以试试*/ 
    /*以下代码是以前bar1的样式*/
    border:1px solid #ff8700;
    height:50px;
    width:100px;
    background-color:#ff8700;
    border-radius: 4px;
        }
    .acolor:hover{
    color: #ec3838;
    }
    .licolor:hover{
    color: #447feb;
    }
    .circle{
width: 100px;
height: 100px;
border: 5px solid #f21515 ;
border-radius: 50%;
}
    </style>
    <style>
.circliful {
    position: relative; 
}

.circle-text, .circle-info, .circle-text-half, .circle-info-half {
    width: 100%;
    position: absolute;
    text-align: center;
    display: inline-block;
}

.circle-info, .circle-info-half {
	color: #ff8700;
	font-size: 15px;
	margin-top: 10px;
}

.circliful .fa {
	margin: -10px 3px 0 3px;
	position: relative;
	bottom: 4px;
}
.img_q{
width:150px;height:150px; 
border:1px solid #fff;border-radius:50%;
}

</style>		
	<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath }/cskjs_css/app.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/combo.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/imgup.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/cskjs_css/imgup.css" rel="stylesheet" type="text/css">
<!-- <script src="/comm/jquery.dragsort-0.4.min.js" type="text/javascript"></script> -->
<link href="${pageContext.request.contextPath }/cskjs_css/iconfont.css" rel="stylesheet" type="text/css">
    <script src="${pageContext.request.contextPath }/cskjs_css/jquery.circliful.min.js"></script>
    <script src="${pageContext.request.contextPath }/cskjs_css/jquery.circliful.js"></script>

</head>
    <!--
	BODY TAG OPTIONS:
	=================
	Apply one or more of the following classes to get the
	desired effect
	|---------------------------------------------------------|
	| SKINS		 | skin-blue								 |
	|				 | skin-black								|
	|				 | skin-purple							 |
	|				 | skin-yellow							 |
	|				 | skin-red								|
	|				 | skin-green								|
	|---------------------------------------------------------|
	|LAYOUT OPTIONS | fixed									 |
	|				 | layout-boxed							|
	|				 | layout-top-nav							|
	|				 | sidebar-collapse						|
	|				 | sidebar-mini							|
	|---------------------------------------------------------|
	-->
<body class="skin-green sidebar-mini fixed">
	<div class="wrapper">
		<!-- 导航栏 -->
<jsp:include page="kjs_navbar.jsp"></jsp:include>
<!-- 内容 -->
<form id="info_form" action="" class="form-horizontal" method="post" enctype="multipart/form-data" onsubmit="return check()">
<input id="id" name="id" value="118" type="hidden">
		<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper fixed-footer" style="min-height: 905px;">
		<!-- Main content -->
<section class="content">
			
<script src="${pageContext.request.contextPath }/cskjs_css/jQueryRotate.js" type="text/javascript"></script>

<div class="admin-content nav-tabs-custom box">
	<div class="box-header with-border">	
	<div  class="box-body" style="margin-left: 150px;width: 80%" >       	            
			<div id="section1" class="form-group">			
			   <h3 align="center" style="margin-right: 300px">用户提交信息</h3>
			   <div  style="padding-top: 60px;width:85%;">               
               <div class="left" >
               <span>押车进件审核 来自：快车道-屠国强</span>
               <div class="divcss">
               <table id="data_table"  class="table" style="width:100%;border-style:none">  
               <tr>
               <td style="color: #5f5f6c;">借款人姓名</td>
               <td>屠国强</td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">车牌号</td>
               <td>粤A88888</td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">车型</td>
               <td>2017款1.2T E CVT新锐版</td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">借款人身份证</td>
               <td>1231564165413215</td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">共借人姓名</td>
               <td>粤A88888</td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">共借人身份证</td>
               <td>粤A88888</td>
               </tr>
               </table>
               </div>               
               </div>
               <div class="right">
               <span style="text-align: right;display:block;">2017-12-20 12:01:39 合同编码：<font style="color: #ff8700;">2017122010000118</font></span>
               <div class="divcss"> 
               <table id="data_table" class="table" style="width:100%">  
               <tr align="center">
               <td>
               <font style="margin-right:10px;color: #ef3e31;font-size:29px;">4.50</font>万</td>
               <td><font style="margin-right:10px;color: #ef3e31;font-size:29px;">30</font>天</td>
               <td>
               <select  style="color: #ef3e31;font-size:29px;" class="select">
               <option value="1">先息后本</option>
               <option value="2">等额本息</option>
               </select>
               </td>
               </tr>
               <tr align="center">
               <td style="color: #5f5f6c;">借款金额</td>
               <td style="color: #5f5f6c;">借款期限</td>
               <td style="color: #5f5f6c;">借款方式</td>
               </tr>
               <tr align="center">
               <td  colspan="3" style="font-size:16px;color:#ff8700;">补充信息</td>
               </tr>
               <tr align="center">
               <td>0</td>
               <td>SAFALSKFALF </td>
               <td>0.00</td>
               </tr>
               <tr align="center">
               <td style="color: #5f5f6c;">发动机号</td>
               <td style="color: #5f5f6c;">VIN码</td>
               <td style="color: #5f5f6c;">渠道利率(格式:0.68/1.0)</td>
               </tr>
               </table>               
               </div>               
               </div>
               </div>
		   </div>
			
	</div>
	<script type="text/javascript">
	function li1(id){		
		var i=1;
	    for(i;i<7;i++){
	    	var imgsrc= document.getElementById("img"+i).src;
	    	if(imgsrc.substring(36,imgsrc.length)=="537519733460888498.png"){
	    		document.getElementById("img"+i).src="${pageContext.request.contextPath }/cskjs_css/439429027073864254.png";   
	        } 
	    }
    document.getElementById("img"+id).src="${pageContext.request.contextPath }/cskjs_css/537519733460888498.png";        
	}
	</script>
	<div style="position:fixed; right: 2%;top: 20%;">  
         <ul>
          <li style="height: 30px;">                     
            <a  onclick="li1('1');"  class="licolor" href="#section1">
            <img  id="img1" alt="" src="${pageContext.request.contextPath }/cskjs_css/439429027073864254.png">
            <font style="margin-left:8px;">用户提交信息</font> 
            </a>
          </li>	
          <li style="margin-left:7px;margin-top:-6px; height:30PX; border-left: 1px dashed #447feb;"></li>
          <li style="height: 30px;">          
          <a onclick="li1('2');" class="licolor" href="#section2">
          <img id="img2" alt="" src="${pageContext.request.contextPath }/cskjs_css/439429027073864254.png">
          <font style="margin-left:8px;">反欺诈报告</font></a>
          </li>
          <li style="margin-left:7px;margin-top:-6px; height:30PX; border-left: 1px dashed #447feb;"></li>
          <li style="height: 30px;">
          <a onclick="li1('3');" class="licolor" href="#section3">
          <img id="img3"  alt="" src="${pageContext.request.contextPath }/cskjs_css/439429027073864254.png">
          <font style="margin-left:8px;">车辆证件</font></a>
          </li>
          <li style="margin-left:7px;margin-top:-6px; height:30PX; border-left: 1px dashed #447feb;"></li>
          <li style="height: 30px;">
          <a onclick="li1('4');" class="licolor" href="#section4">
          <img  id="img4" alt="" src="${pageContext.request.contextPath }/cskjs_css/439429027073864254.png">
          <font style="margin-left:8px;">合同和其他</font></a></li>
          <li style="margin-left:7px;margin-top:-6px; height:30PX; border-left: 1px dashed #447feb;"></li>
          <li style="height: 30px;">
          <a onclick="li1('5');" class="licolor" href="#section5">
          <img id="img5"  alt="" src="${pageContext.request.contextPath }/cskjs_css/439429027073864254.png">
          <font style="margin-left:8px;">车辆照片</font></a></li>
          <li style="margin-left:7px;margin-top:-6px; height:30PX; border-left: 1px dashed #447feb;"></li>
          <li style="height: 30px;">          
          <a onclick="li1('6');" class="licolor" href="#section6">
          <img id="img6" alt="" src="${pageContext.request.contextPath }/cskjs_css/439429027073864254.png">
          <font style="margin-left:8px;">审核处理</font></a></li>
        </ul>
	</div>
			<script type="text/javascript">
    $(".circleChart#circle1").circleChart({
        size:300
    });
	 function aimgafter(id,name) {
        	 var aa=document.getElementById("a"+id);
      		 aa.className="ah";
      		 document.getElementById("a"+id).innerHTML = 		 
      		 "<font>查看<br/>"+name+"</font>";		 		 		
	}
	 function aimgbefore(id,name) {
		 
			 document.getElementById("a"+id).innerHTML=
				 "<img id='i"+id+"'  alt='' color='#333;' src='${pageContext.request.contextPath }/cskjs_css/z12@2x.png'>命中<br/>"+
		         "<font id='f"+id+"' color='#5f5f6c'>"+name+"</font>"; 
	}
	</script>
		<div id="section2" class="box-body" style="margin-left: 150px; width: 80%">
        <div align="center" style="margin-right: 300px" class="box-header with-border">
        <img src="${pageContext.request.contextPath }/cskjs_css/logo.png" style="width: 32px; heigth: 32px; margin-top: -5px">
		<h3 class="box-title">反欺诈人车双认证报告</h3>
		</div>
		<div class="form-group">
		<div style="padding-top: 60px;width:85%;">
		<div class="left1" style="border-right: 1px solid #bac2d1;display: inline-table" >
        <table id="data_table" class="table" style="width:100%">
        <tr align="center"><td style="color: #5f5f6c;" colspan="4" >人认证-综合评分</td></tr>
        <tr align="center">
<td  colspan="4">
<div id="myStat" data-dimension="150" data-text="65分" data-info="伏灵" 
data-width="8" data-fontsize="30" data-percent="65" data-fgcolor="#f82c55" 
data-bgcolor="#fff" data-fill="#fff">
</div>    
<script>
$( document ).ready(function() {
        $('#myStat').circliful();
    });
</script>
       

        </td>
        </tr>
        <tr align="center">
        <td>
        <a id="a5"  onmouseover="aimgafter('5','人行征信')" onmouseout="aimgbefore('5','人行征信')"  href="">
        <img alt="" src="${pageContext.request.contextPath }/cskjs_css/z12@2x.png">命中<br/>
        <font color="#5f5f6c">人行征信</font>
        </a>
        </td>
        <td>
        <a id="a6"  onmouseover="aimgafter('6','大数据征信')" onmouseout="aimgbefore('6','大数据征信')"  href="">
        <img alt="" src="${pageContext.request.contextPath }/cskjs_css/z12@2x.png">命中<br/><font color="#5f5f6c">大数据征信</font>
        </a>
        </td>
        <td>
        <a id="a7"  onmouseover="aimgafter('7','通讯数据')" onmouseout="aimgbefore('7','通讯数据')"  href="">
        <img alt="" src="${pageContext.request.contextPath }/cskjs_css/z12@2x.png">命中<br/><font color="#5f5f6c">通讯数据</font>
        </a>
        </td>
        <td>
        <a id="a8"  onmouseover="aimgafter('8','银行流水')" onmouseout="aimgbefore('8','银行流水')"  href="">
        <img alt="" src="${pageContext.request.contextPath }/cskjs_css/z12@2x.png">命中<br/><font color="#5f5f6c">银行流水</font>
        </a>
        </td>
        </tr>
        </table>
        </div>
		<div class="right">        
		<table  id="data_table" class="table" style="width:100%">
        <tr align="center"><td colspan="4">车认证-车评估价</td></tr>
        <tr align="center"><td colspan="4">
<div id="myStat1" data-dimension="150" data-text="9.8万" data-info="粤A8888" 
data-width="8" data-fontsize="30" data-percent="9.8" data-fgcolor="#3344f9" 
data-bgcolor="#fff" data-fill="#fff">
       </div>    
     <script>
     $( document ).ready(function() {
        $('#myStat1').circliful();
    });
    </script>
</td></tr>
        <tr align="center">
        <td>
        <a id="a1"  onmouseover="aimgafter('1','保险记录')" onmouseout="aimgbefore('1','保险记录')"  href="">
        <img id="i1"  style="color: #333;" alt="" src="${pageContext.request.contextPath }/cskjs_css/z12@2x.png">命中<br/>
        <font id="f1" color="#5f5f6c">保险记录</font>
        </a>
        </td>
        <td>
        <a id="a2"  onmouseover="aimgafter('2','车辆查档')" onmouseout="aimgbefore('2','车辆查档')"  href="">       
        <img id="i2" style="color: #333;" alt="" src="${pageContext.request.contextPath }/cskjs_css/z12@2x.png">命中<br/>
        <font id="f2" color="#5f5f6c">车辆查档</font>
        </a>
        </td>
        <td>
        <a id="a3"  onmouseover="aimgafter('3','保养记录')" onmouseout="aimgbefore('3','保养记录')"  href="">
        <img id="i3" style="color: #333;" alt="" src="${pageContext.request.contextPath }/cskjs_css/z12@2x.png">命中<br/>
        <font id="f3"  color="#5f5f6c">保养记录</font>
        </a>
        </td>        
        <td>
        <a id="a4"  onmouseover="aimgafter('4','违章查询')" onmouseout="aimgbefore('4','违章查询')"  href="">
                      未命中<br/>
        <font id="f4" color="#5f5f6c">违章查询</font>
        </a>
        </td>        
        </tr>
        </table>
        </div>
        </div>
		</div>
</div>
<script>
function downallfile(fid){
	window.open('');
}
function dodownall(){
	window.open('');
}
</script>		
<div class="box-body">
<div style="width: 85%;" class="box-header with-border">
<h3 align="center" style="margin-right:30px;">相关审核</h3>
<a href="javascript:dodownall();" class="btn btn-success" style="margin-left:100px">一键下载所有图片</a>
</div>
			<div class="form-group" style="width: 100%;">
			<div id="section3" class="col-sm-10" style=" width: 85%;" >
			<div  align="center" style="color:#ff8700;" >车辆证件</div>		
			</div>
				<div class="col-sm-10" style="margin-left:100px; margin-top: 50px;">
					<div class="row inline-from">
					<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q" >
							<img  id="imgstep2_1_view" name="imgstep2_1_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png">
							</div>
							<div  class="col-sm-12">
							<a class="acolor"  id="ashowpic1" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看产权证1-2页</a>
						    </div>
					</div> 
					<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep2_2_view" name="imgstep2_2_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic2" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看产权证3-4页</a>
						</div>
					</div> 
					<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep2_3_view" name="imgstep2_3_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic3" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看产权证5-6页</a>
						</div>
					</div> 
					<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep2_4_view" name="imgstep2_4_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic4" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看行驶证</a>
						</div>
					</div> 
					<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep2_5_view" name="imgstep2_5_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic5" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看身份证正面</a>
						</div>
					</div> 
					<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep2_6_view" name="imgstep2_6_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic6" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看身份证反面</a>
						</div>
					</div> 
					<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep2_7_view" name="imgstep2_7_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic7" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看申请表</a>
						</div>
					</div> 
					<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep2_8_view" name="imgstep2_8_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic8" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看快加评估报告</a>
						</div>
					</div> 
					<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep2_9_view" name="imgstep2_9_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic9" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看查档照片</a>
						</div>
					</div> 
					<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep2_10_view" name="imgstep2_10_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic10" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看保单（交强）</a>
						</div>
					</div> 
					<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep2_11_view" name="imgstep2_11_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic11" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看违章</a>
						</div>
					</div> 
					<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep2_12_view" name="imgstep2_12_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic12" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看放款流水（或银行卡）</a>
						</div>
					</div> 
					<div class="col-sm-3" >
							<div class="input-group img_q"><img id="imgstep2_13_view" name="imgstep2_13_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic13" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看车商买卖协议</a>
						</div>
					</div> 
					<div class="col-sm-3" >
							<div class="input-group img_q"><img id="imgstep2_14_view" name="imgstep2_14_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic14" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看共借人身份证正面</a>
						</div>
					</div> 
					<div class="col-sm-3" >
							<div class="input-group img_q"><img id="imgstep2_15_view" name="imgstep2_15_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic15" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看共借人身份证反面</a>
						</div>
					</div> 
					<div class="col-sm-3" >
							<div class="input-group img_q"><img id="imgstep2_16_view" name="imgstep2_16_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic16" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看居住证明</a>
						</div>
					</div> 
					</div>
					</div>
			<div id="section4" class="col-sm-10" style="width: 85%;margin-top: 50px;" >
			<div align="center" style="color:#ff8700;" >合同和其他</div>		
			</div>
							<div class="col-sm-10" style="margin-left:100px; margin-top: 50px;">
							<div class="row inline-from">							
							<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep3_1_view" name="imgstep3_1_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic17" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看合同1</a>
						     </div>
					      </div> 
							<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep3_2_view" name="imgstep3_2_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic18" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看合同2</a>
						</div>
					</div> 
							<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep3_3_view" name="imgstep3_3_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic19" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看合同3</a>
						</div>
					</div> 
							<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep3_4_view" name="imgstep3_4_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic20" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看合同4</a>
						</div>
					</div> 
							<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep3_5_view" name="imgstep3_5_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic21" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看合同5</a>
						</div>
					</div> 
							<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep3_6_view" name="imgstep3_6_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic22" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看合同6</a>
						</div>
					</div> 
							<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep3_7_view" name="imgstep3_7_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic23" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看合同7</a>
						</div>
					</div> 
							<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep3_8_view" name="imgstep3_8_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic24" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看合同8</a>
						</div>
					</div> 
							<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep3_9_view" name="imgstep3_9_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic25" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看合同9</a>
						</div>
					</div> 
							<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep3_10_view" name="imgstep3_10_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic26" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看合同10</a>
						</div>
					</div> 
							<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep3_11_view" name="imgstep3_11_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic27" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看合同11</a>
						</div>
					</div> 
							<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep3_12_view" name="imgstep3_12_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic28" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看合同12</a>
						</div>
					</div> 
							<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep3_13_view" name="imgstep3_13_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic29" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看合同13</a>
						</div>
					</div> 
							<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep3_14_view" name="imgstep3_14_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic30" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看补充1</a>
						</div>
					</div> 
					<div class="col-sm-3" style="margin:20px 0">
						<div class="input-group img_q"><img id="imgstep3_15_view" name="imgstep3_15_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12">
							<a class="acolor" id="ashowpic31" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看补充2</a>
						</div>
					</div> 
					<div class="col-sm-3" style="margin:20px 0">
					<div class="input-group">
						<div class="input-group img_q"><img id="imgstep3_15_view" name="imgstep3_15_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12">
							<a class="acolor" id="ashowpic31" href="" target="_blank">无视频信息</a>
						</div>
					</div>
					</div>
					</div>
</div>
			   <div id="section5"  class="col-sm-10" style="width: 85%; margin-top: 50px;" >
			   <div align="center" style="color:#ff8700;" >车辆照片</div>		
			   </div>
						
						<div class="col-sm-10" style="margin-left:100px; margin-top: 50px;">
						<div class="row inline-from">							
						<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q" style="text-align: center;"><img align="middle" id="imgstep4_1_view" name="imgstep4_1_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12 "><a  class="acolor" id="ashowpic33" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看车辆铭牌</a>
						</div>
					    </div> 
						<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep4_2_view" name="imgstep4_2_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic34" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看车前45度</a>
						</div>
					</div> 
						<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep4_3_view" name="imgstep4_3_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic35" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看车后45度</a>
						</div>
					</div> 
						<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep4_4_view" name="imgstep4_4_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic36" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看发动机舱</a>
						</div>
					</div> 
						<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep4_5_view" name="imgstep4_5_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic37" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看后备箱</a>
						</div>
					</div> 
						<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep4_6_view" name="imgstep4_6_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic38" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看中控台</a>
						</div>
					</div> 
						<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep4_7_view" name="imgstep4_7_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic39" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看仪表台公里数</a>
						</div>
					</div> 
						<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep4_8_view" name="imgstep4_8_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic40" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看人车合影</a>
						</div>
					</div> 
						<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep4_9_view" name="imgstep4_9_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic41" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看车辆补充1</a>
						</div>
					</div> 
						<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep4_10_view" name="imgstep4_10_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic42" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看车辆补充2</a>
						</div>
					</div> 
						<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep4_11_view" name="imgstep4_11_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic43" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看行驶证背面</a>
						</div>
					</div> 
						<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep4_12_view" name="imgstep4_12_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic44" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看其他补充1</a>
						</div>
					</div> 
						<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep4_13_view" name="imgstep4_13_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic45" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看其他补充2</a>
						</div>
					</div> 
						<div class="col-sm-3" style="margin:20px 0">
							<div class="input-group img_q"><img id="imgstep4_14_view" name="imgstep4_14_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png"></div>
							<div class="col-sm-12"><a class="acolor" id="ashowpic46" href="http://a.kcway.net/assess/assess/upload/542820357249194375.png" target="_blank">查看其他补充3</a>
						</div>
					</div> 
												</div>
			</div>

	</div>
	<div id="section6" class="box-header with-border" style="width: 85%">
	<h3 align="center" >审核处理</h3>
    </div>
<div class="box-body">
	<div class="form-group">
	<label class="col-sm-2 control-label">审核：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
				<div class="col-sm-3">
					<div class="input-group"><span class="input-group-addon">审核状态</span> <select name="bc_status" class="form-control" id="bc_status" onchange="autoremark();">
                            	<option value="1">草稿箱</option><option selected="selected" value="2">正在审核中</option><option value="3">审核通过</option><option value="4">回退补件</option><option value="5">已撤销</option>                            </select></div>
			</div>
				<div class="col-sm-3">
					<div class="input-group"><span class="input-group-addon">初审状态</span> <select name="cs_tag" class="form-control" id="cs_tag">
                            	<option value="0" selected="selected">初审中</option><option value="1">初审通过</option>                            </select></div>
			</div>
				<div class="col-sm-3">
					<div class="input-group"><span class="input-group-addon">审批金额</span> <input class="form-control" name="c_mgprice_result" id="c_mgprice_result" value="0.00" type="text"><span class="input-group-addon">万</span></div>
			</div>
				<div class="col-sm-2">
					<div class="input-group"><span class="input-group-addon">放款时间</span> <input class="form-control" name="dt_fk" placeholder="可不填,审核通过时自动填写" id="dt_fk" value="可不填,审核通过时自动填写" type="text"></div>
			</div>
		</div>
	  </div>
	</div>
	<div class="form-group"><label class="col-sm-2 control-label">留言备注说明：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
				<div class="col-sm-4">
					<div class="input-group"><span class="input-group-addon">审核留言</span> <input class="form-control" name="remark" id="remark" type="text"></div>
			</div>
				<div class="col-sm-4">
					<div class="input-group"><span class="input-group-addon">留言快速通道</span> <select class="form-control" id="cyly" onchange="setremark(this)">
												<option value="请选择" selected="selected">请选择</option>						<option value="查询完成，详情请点击历史查询-&gt;已完成-&gt;查看订单！">查询完成，详情请点击历史查询-&gt;已完成-&gt;查看订单！</option>						<option value="恭喜您初审通过,请点编辑按钮,按提示上传其他补充材料！">恭喜您初审通过,请点编辑按钮,按提示上传其他补充材料！</option>						<option value="请提供行驶证与驾照正面照片！">请提供行驶证与驾照正面照片！</option>						<option value="请上传正确的行驶证照片">请上传正确的行驶证照片</option>						<option value="行驶证错误，要的是信息页。车牌车架发动机号页面">行驶证错误，要的是信息页。车牌车架发动机号页面</option>						<option value="行驶证要上传信息页面，上传后面一页无法识别。">行驶证要上传信息页面，上传后面一页无法识别。</option>						<option value="提交材料过于模糊，无法识别">提交材料过于模糊，无法识别</option>						<option value="请 上传行驶证">请 上传行驶证</option>						<option value="请上传完整的行驶证驾驶证照片">请上传完整的行驶证驾驶证照片</option>						</select></div>
			</div>
		</div>
	</div></div>
			
<div class="form-group"><label class="col-sm-2 control-label">历次审核事件和留言：</label>
		<div class="col-sm-10"><textarea style="width: 80%; height: 200px" class="form-control" readonly="readonly">2017-12-20 12:01:18:状态：草稿箱,留言：
2017-12-20 12:01:39:状态：正在审核中,留言：用户提交押车进件申请-初审请求，快加正在审核..
</textarea></div></div>

<div class="form-group"><label class="col-sm-2 control-label">放款转账记录截图留档：</label>
	<div class="col-sm-10">
		<div class="row inline-from">
		<div   class="col-sm-2">
				<div  class="input-group">
				<img  id="result_imgurl1_view" name="result_imgurl1_view" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/301175241676158600.png">
				<input id="result_imgurl1" name="result_imgurl1" value="" type="hidden"> 
<input id="upload_result_imgurl1" name="upload_result_imgurl1" accept="image/*" style="position: absolute; ; left: 1px; top: 1px; width: 150px; height: 150px; opacity: 0;" type="file">
<script>
//要求必须 jquery2.0 以上,因为 fileup 函数中用到了 .off().on()
$('#upload_result_imgurl1').on('change',function (){
	fileup('upload_result_imgurl1',function (jo){
		if(typeof(upload_succ_result_imgurl1)=='function'){
			upload_succ_result_imgurl1(jo,$('#result_imgurl1'));
		}else{
			jo.url = "assess/"+jo.url;
			$('#result_imgurl1').val(jo.url);
						$('#result_imgurl1_view').attr('src',jo.imgurl);
						$('#result_imgurl1_view').parents('div.hide:first').removeClass('hide');
					}
	});
})
</script>
 </div>
				<div  style="margin-left:40px;" class="col-sm-12">
				<a class="acolor" href="http://a.kcway.net/assess/manager/images/301175241676158600.png" target="_blank">查看</a>
				</div>
		</div> 
														<div class="col-sm-2">
				<div class="input-group"><img id="result_imgurl2_view" name="result_imgurl2_view" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/301175241676158600.png">
									<input id="result_imgurl2" name="result_imgurl2" value="" type="hidden"> 
<input id="upload_result_imgurl2" name="upload_result_imgurl2" accept="image/*" style="position: absolute; ; left: 1px; top: 1px; width: 150px; height: 150px; opacity: 0;" type="file">
<script>
//要求必须 jquery2.0 以上,因为 fileup 函数中用到了 .off().on()
$('#upload_result_imgurl2').on('change',function (){
	fileup('upload_result_imgurl2',function (jo){
		if(typeof(upload_succ_result_imgurl2)=='function'){
			upload_succ_result_imgurl2(jo,$('#result_imgurl2'));
		}else{
			jo.url = "assess/"+jo.url;
			$('#result_imgurl2').val(jo.url);
						$('#result_imgurl2_view').attr('src',jo.imgurl);
						$('#result_imgurl2_view').parents('div.hide:first').removeClass('hide');
					}
	});
})
</script>
								</div>
				<div style="margin-left:40px;" class="col-sm-12"><a class="acolor" href="http://a.kcway.net/assess/manager/images/301175241676158600.png" target="_blank">查看</a></div>
		</div> 
														<div class="col-sm-2">
				<div class="input-group"><img id="result_imgurl3_view" name="result_imgurl3_view" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/301175241676158600.png">
									<input id="result_imgurl3" name="result_imgurl3" value="" type="hidden"> 
<input id="upload_result_imgurl3" name="upload_result_imgurl3" accept="image/*" style="position: absolute; ; left: 1px; top: 1px; width: 150px; height: 150px; opacity: 0;" type="file">
<script>
//要求必须 jquery2.0 以上,因为 fileup 函数中用到了 .off().on()
$('#upload_result_imgurl3').on('change',function (){
	fileup('upload_result_imgurl3',function (jo){
		if(typeof(upload_succ_result_imgurl3)=='function'){
			upload_succ_result_imgurl3(jo,$('#result_imgurl3'));
		}else{
			jo.url = "assess/"+jo.url;
			$('#result_imgurl3').val(jo.url);
						$('#result_imgurl3_view').attr('src',jo.imgurl);
						$('#result_imgurl3_view').parents('div.hide:first').removeClass('hide');
					}
	});
})
</script>
								</div>
		<div style="margin-left:40px;" class="col-sm-12">
		<a class="acolor" href="http://a.kcway.net/assess/manager/images/301175241676158600.png" target="_blank">查看</a></div>
		</div> 
				<div class="col-sm-2">
				<div class="input-group">
				<img id="result_imgurl4_view" name="result_imgurl4_view" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/301175241676158600.png">
				<input id="result_imgurl4" name="result_imgurl4" value="" type="hidden"> 
<input id="upload_result_imgurl4" name="upload_result_imgurl4" accept="image/*" style="position: absolute; ; left: 1px; top: 1px; width: 150px; height: 150px; opacity: 0;" type="file">
<script>
//要求必须 jquery2.0 以上,因为 fileup 函数中用到了 .off().on()
$('#upload_result_imgurl4').on('change',function (){
	fileup('upload_result_imgurl4',function (jo){
		if(typeof(upload_succ_result_imgurl4)=='function'){
			upload_succ_result_imgurl4(jo,$('#result_imgurl4'));
		}else{
			jo.url = "assess/"+jo.url;
			$('#result_imgurl4').val(jo.url);
						$('#result_imgurl4_view').attr('src',jo.imgurl);
						$('#result_imgurl4_view').parents('div.hide:first').removeClass('hide');
					}
	});
})
</script>
		</div>
		<div style="margin-left:40px;" class="col-sm-12">
		<a class="acolor" href="http://a.kcway.net/assess/manager/images/301175241676158600.png" target="_blank">查看</a></div>
		</div> 
		<div class="col-sm-2">
		<div class="input-group">
		<img id="result_imgurl5_view" name="result_imgurl5_view" style="width: 150px; heigth: 150px;" src="${pageContext.request.contextPath }/cskjs_css/301175241676158600.png">
		<input id="result_imgurl5" name="result_imgurl5" value="" type="hidden"> 
        <input id="upload_result_imgurl5" name="upload_result_imgurl5" accept="image/*" style="position: absolute; ; left: 1px; top: 1px; width: 150px; height: 150px; opacity: 0;" type="file">
<script>
//要求必须 jquery2.0 以上,因为 fileup 函数中用到了 .off().on()
$('#upload_result_imgurl5').on('change',function (){
	fileup('upload_result_imgurl5',function (jo){
		if(typeof(upload_succ_result_imgurl5)=='function'){
			upload_succ_result_imgurl5(jo,$('#result_imgurl5'));
		}else{
			jo.url = "assess/"+jo.url;
			$('#result_imgurl5').val(jo.url);
						$('#result_imgurl5_view').attr('src',jo.imgurl);
						$('#result_imgurl5_view').parents('div.hide:first').removeClass('hide');
					}
	});
})
</script>
		</div>
		<div style="margin-left:40px;" class="col-sm-12">
		<a class="acolor" href="http://a.kcway.net/assess/manager/images/301175241676158600.png" target="_blank">查看</a></div>
		</div> 
													
		</div>
</div></div>



</div>		</div>
</div>


<script>
$(function(){
	$("#info_form").attr("onsubmit","return check()"); 
});
function getprice(obj){
	if ($("#carid").val()!=null){
		url= "ajax.php?do=info&cn=car_model&id="+$("#carid").val();
		jQuery.getJSON(url,function (opt){
			if(opt){
				$("#price_new").val(opt.price);
			}
		})
	}
}
function setremark(obj){
	if ($("#cyly").val()!="请选择快速留言"){
		$("#remark").val($("#cyly").val());
	}
}
function check(){
	$("#upload_result_pdf").attr('filename','');
	$("#upload_result_pdf").val('');
	if ($("#bc_status").val()>4 && $("#bc_status").val()!=7){
		if ($("#remark").val()==""){
			alert("留言为空！");
//			window.console.error('remark null');
			$("#remark").focus();
			return false;
		}
	}
	return true;
} 
function delpic(obj){
	$("#result_doc"+obj+"_view").attr("src","/assess/upload/none.jpg");
	$("#result_doc"+obj).val("");
}

function rpic(fid,type){
	var ri = parseInt($("#result_imgurl"+fid+"_view").attr("data-ri"));
	switch (type){
		case 1:
			ri  = ri +90;
			/* if (ri>360){
				ri = 90 ;
			} */
			break;
		case 0:
			ri  = ri -90;
			/* if (ri<0){
				ri = 270 ;
			} */
			break;
	}
	var xfile = $("#result_imgurl"+fid+"_view").attr("data-src");
	$.post("ajax.php?do=rpic",{src:xfile,rtype:type},function(res){
		eval("var res="+res);
		if(res.succ){
			$("#result_imgurl"+fid+"_view").rotate({animateTo:ri});	
			$("#result_imgurl"+fid+"_view").attr("data-ri",ri);
			var tmpstr  = $("#ashowpic"+fid).attr("href");
			var ni = tmpstr.indexOf('?');
			tmpstr = substr(tmpstr,0,ni); 
			var timestamp = Date.parse(new Date());
			//$("#result_imgurl"+fid+"_view").attr("src",tmpstr+"?"+timestamp);
			$("#ashowpic"+fid).attr("href",tmpstr+"?"+timestamp);
		}
	});
}
function autoremark(){
	if ($("#bc_status").val()==3){//完成
		$("#remark").val("审核完成，坐等收钱！");
	}else{
		$("#remark").val("");
	}		
}
</script>		</section>
				<div class="footer-wrap">
			<div class="box-footer" style="margin-left:-50px;">
				<button type="button"  class="btn btn-default"  onclick="location.href='TKJSselectAll.do?status=1&queryname=押车'">取消返回</button>
				<button type="submit" style="margin-right: 50px;" class="btn btn-primary pull-right">保存提交</button> 
			</div>
		</div>
			</div><!-- /.content-wrapper -->
</form>
				<!-- 搜索层 -->
<jsp:include page="kjs_search.jsp"></jsp:include>
		<!-- /.control-sidebar -->
		<!-- Add the sidebar's background. This div must be placed
			 immediately after the control sidebar -->
		<div class="control-sidebar-bg" style="position: fixed; height: auto;"></div>
	</div>
	<!-- ./wrapper -->
	<!-- REQUIRED JS SCRIPTS -->
	<!-- Optionally, you can add Slimscroll and FastClick plugins.
			Both of these plugins are recommended to enhance the
			user experience. Slimscroll is required when using the
			fixed layout. -->
	<!--弹窗框体开始-->
	<div class="modal fade" id="modal" role="dialog" data-backdrop="static">
		<div class="modal-dialog" role="document">
			<div id="mycontent" class="modal-content">
				<!--将在这里载入链接页面-->
			</div>
		</div>
	</div>
	<!-- 弹窗框体结束-->
	<script>
		$('#modal').on('hidden.bs.modal', function (e) {
			$(this).removeData("bs.modal");
	})
</script>
</body></html>