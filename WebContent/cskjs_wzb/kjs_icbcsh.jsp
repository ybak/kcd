<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%
String path = request.getContextPath();
String basePath ="https://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html><head>
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
//居中
.aligncenter { 
clear: both; 
display: block; 
margin:auto; 
} 
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
	height:100%;
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
  clear: both; 
display: block; 
margin:auto; 
width:150px;
height:150px; 
border:1px solid #fff;
border-radius:50%;

  }
.inputcss{
width:160px;
padding-left:6px;
border:1px solid #b1bacb;
border-radius: 2px;
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
<script type="text/javascript">
$(document).ready(function(){
  var type=document.getElementById("colortype").value;
  var colors=document.getElementById("icbc"+type)
  colors.style.backgroundColor="#ff8700";
});
</script>
<script src="${pageContext.request.contextPath }/cskjs_css/jQueryRotate.js" type="text/javascript"></script>

<body class="skin-green sidebar-mini fixed">
	<div class="wrapper">
		<!-- 导航栏 -->
<jsp:include page="kjs_navbar.jsp"></jsp:include>
<!-- 内容 -->

		<!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper fixed-footer" style="min-height: 905px;">
		<!-- Main content -->
<section class="content">
<input type="hidden" value="${requestScope.icbc_type}" id="colortype" name="colortype"/>
	<ul id="myTab" class="nav nav-tabs">
			<li ${requestScope.icbc_type==1 ? "class='active'":''} >
			<a id="icbc1" style="background-color: #b1bacb;color: #ffffff;" href="newicbcsh.do?icbc_type=1&id=${requestScope.id }&querytype=${requestScope.querytype}&size=${requestScope.size}&status=${requestScope.status}" >
			征信</a></li>
			<!--  
			<li ${requestScope.icbc_type==2 ? "class='active'":''}><a id="icbc2"  href="yp_sh.do?icbc_type=2&icbc_id=${requestScope.id }&querytype=${requestScope.querytype}&size=${requestScope.size}&status=${requestScope.status}" >预评</a></li>
			-->
			<li ${requestScope.icbc_type==3 ? "class='active'":''}>
			<a id="icbc3"  style="background-color: #b1bacb;color: #ffffff;" href="icbc_cars_sh.do?icbc_type=3&icbc_id=${requestScope.id }&querytype=${requestScope.querytype}&size=${requestScope.size}&status=${requestScope.status}" >
			评估</a></li>
			<li ${requestScope.icbc_type==4 ? "class='active'":''}>
			<a id="icbc4"  style="background-color: #b1bacb;color: #ffffff;" href="icbc_sp_sh.do?icbc_type=4&icbc_id=${requestScope.id }&querytype=${requestScope.querytype}&size=${requestScope.size}&status=${requestScope.status}" >
			视频</a></li>
			<li ${requestScope.icbc_type==5 ? "class='active'":''}>
			<a id="icbc5"  style="background-color: #b1bacb;color: #ffffff;" href="kk_sh.do?icbc_type=5&icbc_id=${requestScope.id }&querytype=${requestScope.querytype}&size=${requestScope.size}&status=${requestScope.status}" >
			开卡</a></li>
			<li ${requestScope.icbc_type==6 ? "class='active'":''}>
			<a id="icbc6"  style="background-color: #b1bacb;color: #ffffff;" href="dk_sh.do?icbc_type=6&icbc_id=${requestScope.id }&querytype=${requestScope.querytype}&size=${requestScope.size}&status=${requestScope.status}" >
			汽车贷款</a></li>
	       </ul>
  <div id="divmsg" class="admin-content nav-tabs-custom box">
  <c:if test="${requestScope.icbc_type eq '1' }">
  <jsp:include page="kjs_zxsh.jsp"></jsp:include>
  </c:if>
  <!-- 
  <li ${requestScope.icbc_type==7 ? "class='active'":''}><a id="icbc6"  href="newicbcsh.do?icbc_type=7&id=${requestScope.id }&querytype=${requestScope.querytype}&size=${requestScope.size}&status=${requestScope.status}" >通融</a></li>
  <li ${requestScope.icbc_type==8 ? "class='active'":''}><a id="icbc6"  href="newicbcsh.do?icbc_type=8&id=${requestScope.id }&querytype=${requestScope.querytype}&size=${requestScope.size}&status=${requestScope.status}" >财务</a></li>	
  <c:if test="${requestScope.icbc_type eq '2' }">
  <jsp:include page="kjs_ypsh.jsp"></jsp:include>
  </c:if>
  -->  
  <c:if test="${requestScope.icbc_type eq '3' }">
  <jsp:include page="kjs_pgsh.jsp"></jsp:include>
  </c:if> 
  <c:if test="${requestScope.icbc_type eq '4' }">
  <jsp:include page="icbc_vido.jsp"></jsp:include>
  </c:if>
  <c:if test="${requestScope.icbc_type eq '5' }">
  <jsp:include page="kjs_kksh.jsp"></jsp:include>
  </c:if>
  <c:if test="${requestScope.icbc_type eq '6' }">
  <jsp:include page="kjs_dksh.jsp"></jsp:include>
  </c:if>
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
		$("#remark").val("查询完成，详情请点击订单详情页查看！");
	}else{
		$("#remark").val("");
	}		
}
</script>		
</section>

			</div><!-- /.content-wrapper -->
				<!-- 搜索层 -->
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