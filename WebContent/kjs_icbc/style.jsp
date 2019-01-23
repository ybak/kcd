<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>快加后台管理</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<script type="text/javascript">
		var _rooturl = "http://a.kcway.net/assess/";
		var page_cn = "";
	</script>
	<link rel="icon" href="${pageContext.request.contextPath }/cskjs_css/logo.png" type="image/x-icon"/>
	    <link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/style1.css" rel="stylesheet" type="text/css">
<!-- Bootstrap 3.3.4 -->
<link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/bootstrap.css" rel="stylesheet" type="text/css">
<!-- Font Awesome Icons -->
<!-- Font Awesome Icons -->
<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/layui.css" rel="stylesheet" type="text/css">


<!--
<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/font-awesome.css" rel="stylesheet" type="text/css">
-->
<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/style.css" rel="stylesheet" type="text/css">

<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/select2.css" rel="stylesheet" type="text/css">
<!-- Theme style -->
<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/AdminLTE.css" rel="stylesheet" type="text/css">
<!-- AdminLTE Skins. We have chosen the skin-blue for this starter
			page. However, you can choose any other skin. Make sure you
			apply the skin class to the body tag so the changes take effect.
	-->
<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/skin-black.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/skin-green.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/skin-yellow.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/skin-blue.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/skin-purple.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/skin-red.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/kjs_icbc/kjs_icbc_style/css/angular-bootstrap-file-upload.min.css">    
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/kjs_icbc/kjs_icbc_style/css/bootstrap-datetimepicker.min.css">  
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		<script src="https://cdn.bootcss.com/html5shiv/r29/html5.min.js"></script>
		<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
<!-- jQuery 2.1.4 -->
<script src="http://apps.bdimg.com/libs/angular.js/1.4.6/angular.min.js"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/jQuery-2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/jquery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/ajaxfileupload.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/php.js"></script>
<!-- Bootstrap 3.3.2 JS -->
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/moment.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/daterangepicker.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/daterangepicker-bs3.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/bootstrap-datepicker.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/datepicker3.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/bootstrap-datepicker_002.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/bootstrap-datetimepicker.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/bootstrap-datetimepicker_002.js" type="text/javascript"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/ueditor_002.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/ueditor.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/select2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/zh-CN.js" type="text/javascript"></script>	
<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/iconfont_002.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/morris.css">		
	<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/app.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/combo.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/imgup.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/imgup.css" rel="stylesheet" type="text/css">
<!-- <script src="/comm/jquery.dragsort-0.4.min.js" type="text/javascript"></script> -->
<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/iconfont.css" rel="stylesheet" type="text/css">

<link href="${pageContext.request.contextPath }/kjs_icbc/content/glzx_style/css/build.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/kjs_icbc/content/glzx_style/css/demo.css" rel="stylesheet" type="text/css">

<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/raphael-min.js"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/morris.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/Chart.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/index.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/ui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/list.js"></script>
<!-- 图片对应操作  angular-bootstrap-file-upload-->
<script src="${pageContext.request.contextPath}/kjs_icbc/kjs_icbc_style/js/angular-bootstrap-file-upload.js"></script>
  
<!-- 时间date -->
<script src="${pageContext.request.contextPath}/kjs_icbc/kjs_icbc_style/js/fullcalendar.js"></script>

<script src="${pageContext.request.contextPath}/kjs_icbc/kjs_icbc_style/laydate/laydate.js"></script> 
</head>
<!--
	BODY TAG OPTIONS:
	=================
	Apply one or more of the following classes to get the
	desired effect
	|---------------------------------------------------------|
	| SKINS		     | skin-blue								 |
	|				 | skin-black								|
	|				 | skin-purple							 |
	|				 | skin-yellow							 |
	|				 | skin-red								|
	|				 | skin-green								|
	|---------------------------------------------------------|
	|LAYOUT OPTIONS  | fixed									 |
	|				 | layout-boxed							|
	|				 | layout-top-nav							|
	|				 | sidebar-collapse						|
	|				 | sidebar-mini							|
	|---------------------------------------------------------|
	-->