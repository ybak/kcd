<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath }/cskjs_css/app.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/combo.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/imgup.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/cskjs_css/imgup.css" rel="stylesheet" type="text/css">
<!-- <script src="/comm/jquery.dragsort-0.4.min.js" type="text/javascript"></script> -->
<link href="${pageContext.request.contextPath }/cskjs_css/iconfont.css" rel="stylesheet" type="text/css">
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
<div class="content-wrapper" align="center" style="min-height: 517px;">
<img alt=""  src="${pageContext.request.contextPath }/cskjs_css/755603635019702149.jpg">
</div>
<!-- 搜索 -->
</div>
		



</body></html>