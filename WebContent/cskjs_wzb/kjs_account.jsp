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
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
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
.autocut{    
    overflow:hidden;  
    white-space:nowrap;  
    text-overflow:ellipsis;  
    -o-text-overflow:ellipsis;  
    -icab-text-overflow: ellipsis;  
    -khtml-text-overflow: ellipsis;  
    -moz-text-overflow: ellipsis;  
    -webkit-text-overflow: ellipsis;   
}
.td:hover{color:red;}
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
			<script type="text/javascript">
		 //获取checkbox按钮组
		 var allpro = document.getElementsByName("delid");
		 //全选方法
		 function change() {
		    //获取全选按钮
		 var all = document.getElementById("btcheck_all");
		 //全选按钮被选中时，遍历所有按钮
		    if (all.checked) {
		     for (var i = 0; i < allpro.length; i++) {
		     if (allpro[i].type=="checkbox") {
		     allpro[i].checked=true;

		     }
		     }
		     //全选按钮未被选中时
		    }else{
		     for (var i = 0; i < allpro.length; i++) {
		     if (allpro[i].type=="checkbox") {
		     allpro[i].checked=false;
		     }
		     }
		    }
		 }
		</script>
<body class="skin-green sidebar-mini fixed">
	<div class="wrapper">
<!-- 导航栏 -->
<jsp:include page="kjs_navbar.jsp"></jsp:include>
<!-- 内容 -->
<div class="content-wrapper" style="min-height: 517px;">
		<!-- Content Header (Page header) -->

		<section class="content-header">
			<h1 class="dada">
			账户管理<small>共个</small>				
			</h1>			
		</section>
		<!-- Main content -->
		<section class="content">
			<div class="admin-tools">
				<div class="row">
					<div class="col-sm-10 admin-button">
					<div class="btn-group">
					<a data-toggle="modal" href="" data-target="#modal" class="btn btn-default">
					<i class="fa fa-edit"></i> 新增</a>
					<a href="javascript:;" onclick="ajax_edit(null,'showtag','1')" class="btn btn-default" style="display: none;">
					<i class="fa fa-arrow-circle-o-up"></i> 发布</a>
					<a href="javascript:;" onclick="ajax_edit(null,'showtag','0')" class="btn btn-default" style="display: none;">
					<i class="fa fa-arrow-circle-o-down"></i> 待审</a>
					<a href="javascript:;" id="del_more_btn" class="btn btn-default">
					<i class="fa fa-trash-o"></i> 删除</a>
					</div>
					</div>
					<div class="col-sm-2 admin-page-top hidden-xs">
							<select id="page_limit_select" onchange="window.location.href='/assess/manager/index.php?type=sysset&amp;do=list&amp;cn=assess_admin&amp;nav=0&amp;l='+this.value" class="form-control">
														<option value="10">每页10条</option>
														<option value="20">每页20条</option>
														<option value="30">每页30条</option>
														<option value="40">每页40条</option>
														<option value="50">每页50条</option>
														<option value="60">每页60条</option>
														<option value="70">每页70条</option>
														<option value="80">每页80条</option>
														<option value="90">每页90条</option>
														<option value="100">每页100条</option>
													</select>
												<div class="btn-group">
														
														<a href="/assess/manager/index.php?type=sysset&amp;do=list&amp;cn=assess_admin&amp;nav=0&amp;p=2" class="btn btn-default">»</a>
													</div>
											</div>
				</div>
			</div>
			<div id="main_list" class="admin-content box">
					<!-- 数据载入中 请在搜索，筛选，载入的时候显示 放在.box里 -->
				<div class="overlay" style="display:none;">
					<i class="fa fa-refresh fa-spin"></i>
				</div>
				<!-- 数据载入中结束 -->
				<table class="table table-bordered table-hover">
	<tbody>
		<tr>
			<th style="width: 3%" class="text-center hidden-xs">
			<input id="btcheck_all" class="check_all" onchange="change()" type="checkbox"></th>
			<th class="text-center hidden-xs" width="50">ID|GEMSID</th>
			<th class="text-center">姓名|用户名</th>
			<th class="text-center hidden-xs">电话|推送ID</th>
			<th class="text-center hidden-xs">权限组</th>
			<th class="text-center hidden-xs">账号分类</th>
			<th class="text-center hidden-xs" width="80">添加时间</th>
			<th class="hidden-xs text-center" width="100">最后登录</th>
			<th class="hidden-xs text-center" width="100">IP</th>
			<th class="text-center hidden-xs" style="width:110px;">状态</th>
			<th class="text-center" width="100">操作</th>
		</tr>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="4779" type="checkbox"></td>
			<td class="text-center hidden-xs"><p>4779<br>4503</p></td>
			<td class="text-center"><span class="s-font-blue">张瑞娟<br><font color="red">yjct@15318484066</font></span></td>
			<td class="text-center hidden-xs"><p>15318484066<br></p></td>
			<td class="text-center hidden-xs"><p><font style="color:black;background:yellow">远景创投金融技术服务有限公司-普通鉴定师</font></p><br></td>
			<td class="text-center hidden-xs"><p>前台APP</p></td>
			<td class="text-center hidden-xs"><p>2018-07-20</p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs">
				<select id="showtag_4779" onchange="ajax_edit(4779,'showtag',this.value,'assess_admin');" class="form-control">
					<option value="1">开通</option>
					<option value="0">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a data-toggle="modal" data-target="#modal" href="float.php?type=sysset&amp;cn=assess_admin&amp;do=form&amp;id=4779" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_4779" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="4778" type="checkbox"></td>
			<td class="text-center hidden-xs"><p>4778<br>4502</p></td>
			<td class="text-center"><span class="s-font-blue">杨佳建<br><font color="red">yjct@15659988087</font></span></td>
			<td class="text-center hidden-xs"><p>15659988087<br></p></td>
			<td class="text-center hidden-xs"><p><font style="color:black;background:yellow">远景创投金融技术服务有限公司-普通鉴定师</font></p><br></td>
			<td class="text-center hidden-xs"><p>前台APP</p></td>
			<td class="text-center hidden-xs"><p>2018-07-20</p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs">
				<select id="showtag_4778" onchange="ajax_edit(4778,'showtag',this.value,'assess_admin');" class="form-control">
					<option value="1">开通</option>
					<option value="0">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a data-toggle="modal" data-target="#modal" href="float.php?type=sysset&amp;cn=assess_admin&amp;do=form&amp;id=4778" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_4778" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="4777" type="checkbox"></td>
			<td class="text-center hidden-xs"><p>4777<br>4501</p></td>
			<td class="text-center"><span class="s-font-blue">马荣荣<br><font color="red">yjct@18506922535</font></span></td>
			<td class="text-center hidden-xs"><p>18506922535<br></p></td>
			<td class="text-center hidden-xs"><p><font style="color:black;background:yellow">远景创投金融技术服务有限公司-普通鉴定师</font></p><br></td>
			<td class="text-center hidden-xs"><p>前台APP</p></td>
			<td class="text-center hidden-xs"><p>2018-07-20</p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs">
				<select id="showtag_4777" onchange="ajax_edit(4777,'showtag',this.value,'assess_admin');" class="form-control">
					<option value="1">开通</option>
					<option value="0">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a data-toggle="modal" data-target="#modal" href="float.php?type=sysset&amp;cn=assess_admin&amp;do=form&amp;id=4777" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_4777" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="4776" type="checkbox"></td>
			<td class="text-center hidden-xs"><p>4776<br>4500</p></td>
			<td class="text-center"><span class="s-font-blue">宋纪发<br><font color="red">yjct@18570626270</font></span></td>
			<td class="text-center hidden-xs"><p>18570626270<br></p></td>
			<td class="text-center hidden-xs"><p><font style="color:black;background:yellow">远景创投金融技术服务有限公司-店长</font></p><br></td>
			<td class="text-center hidden-xs"><p>前台APP</p></td>
			<td class="text-center hidden-xs"><p>2018-07-20</p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs">
				<select id="showtag_4776" onchange="ajax_edit(4776,'showtag',this.value,'assess_admin');" class="form-control">
					<option value="1">开通</option>
					<option value="0">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a data-toggle="modal" data-target="#modal" href="float.php?type=sysset&amp;cn=assess_admin&amp;do=form&amp;id=4776" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_4776" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="4775" type="checkbox"></td>
			<td class="text-center hidden-xs"><p>4775<br>4499</p></td>
			<td class="text-center"><span class="s-font-blue">张耀<br><font color="red">yjct@17859778767</font></span></td>
			<td class="text-center hidden-xs"><p>17859778767<br></p></td>
			<td class="text-center hidden-xs"><p><font style="color:black;background:yellow">远景创投金融技术服务有限公司-</font></p><br></td>
			<td class="text-center hidden-xs"><p>前台APP</p></td>
			<td class="text-center hidden-xs"><p>2018-07-20</p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs">
				<select id="showtag_4775" onchange="ajax_edit(4775,'showtag',this.value,'assess_admin');" class="form-control">
					<option value="1">开通</option>
					<option value="0">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a data-toggle="modal" data-target="#modal" href="float.php?type=sysset&amp;cn=assess_admin&amp;do=form&amp;id=4775" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_4775" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="4774" type="checkbox"></td>
			<td class="text-center hidden-xs"><p>4774<br>4498</p></td>
			<td class="text-center"><span class="s-font-blue">李天寿<br><font color="red">yjct@17720731320</font></span></td>
			<td class="text-center hidden-xs"><p>17720731320<br></p></td>
			<td class="text-center hidden-xs"><p><font style="color:black;background:yellow">远景创投金融技术服务有限公司-普通鉴定师</font></p><br></td>
			<td class="text-center hidden-xs"><p>前台APP</p></td>
			<td class="text-center hidden-xs"><p>2018-07-20</p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs">
				<select id="showtag_4774" onchange="ajax_edit(4774,'showtag',this.value,'assess_admin');" class="form-control">
					<option value="1">开通</option>
					<option value="0">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a data-toggle="modal" data-target="#modal" href="float.php?type=sysset&amp;cn=assess_admin&amp;do=form&amp;id=4774" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_4774" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="4773" type="checkbox"></td>
			<td class="text-center hidden-xs"><p>4773<br>4497</p></td>
			<td class="text-center"><span class="s-font-blue">李和勋<br><font color="red">yjct@18959237271</font></span></td>
			<td class="text-center hidden-xs"><p>18959237271<br></p></td>
			<td class="text-center hidden-xs"><p><font style="color:black;background:yellow">远景创投金融技术服务有限公司-普通鉴定师</font></p><br></td>
			<td class="text-center hidden-xs"><p>前台APP</p></td>
			<td class="text-center hidden-xs"><p>2018-07-20</p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs">
				<select id="showtag_4773" onchange="ajax_edit(4773,'showtag',this.value,'assess_admin');" class="form-control">
					<option value="1">开通</option>
					<option value="0">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a data-toggle="modal" data-target="#modal" href="float.php?type=sysset&amp;cn=assess_admin&amp;do=form&amp;id=4773" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_4773" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="4772" type="checkbox"></td>
			<td class="text-center hidden-xs"><p>4772<br>4496</p></td>
			<td class="text-center"><span class="s-font-blue">戴丽娟<br><font color="red">yjct@18559258831</font></span></td>
			<td class="text-center hidden-xs"><p>18559258831<br></p></td>
			<td class="text-center hidden-xs"><p><font style="color:black;background:yellow">远景创投金融技术服务有限公司-普通鉴定师</font></p><br></td>
			<td class="text-center hidden-xs"><p>前台APP</p></td>
			<td class="text-center hidden-xs"><p>2018-07-20</p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs">
				<select id="showtag_4772" onchange="ajax_edit(4772,'showtag',this.value,'assess_admin');" class="form-control">
					<option value="1">开通</option>
					<option value="0">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a data-toggle="modal" data-target="#modal" href="float.php?type=sysset&amp;cn=assess_admin&amp;do=form&amp;id=4772" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_4772" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="4771" type="checkbox"></td>
			<td class="text-center hidden-xs"><p>4771<br>4495</p></td>
			<td class="text-center"><span class="s-font-blue">刘金国<br><font color="red">yjct@15859278126</font></span></td>
			<td class="text-center hidden-xs"><p>15859278126<br></p></td>
			<td class="text-center hidden-xs"><p><font style="color:black;background:yellow">远景创投金融技术服务有限公司-普通鉴定师</font></p><br></td>
			<td class="text-center hidden-xs"><p>前台APP</p></td>
			<td class="text-center hidden-xs"><p>2018-07-20</p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs">
				<select id="showtag_4771" onchange="ajax_edit(4771,'showtag',this.value,'assess_admin');" class="form-control">
					<option value="1">开通</option>
					<option value="0">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a data-toggle="modal" data-target="#modal" href="float.php?type=sysset&amp;cn=assess_admin&amp;do=form&amp;id=4771" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_4771" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="4770" type="checkbox"></td>
			<td class="text-center hidden-xs"><p>4770<br>4494</p></td>
			<td class="text-center"><span class="s-font-blue">黄志雄<br><font color="red">yjct@15106090653</font></span></td>
			<td class="text-center hidden-xs"><p>15106090653<br></p></td>
			<td class="text-center hidden-xs"><p><font style="color:black;background:yellow">远景创投金融技术服务有限公司-普通鉴定师</font></p><br></td>
			<td class="text-center hidden-xs"><p>前台APP</p></td>
			<td class="text-center hidden-xs"><p>2018-07-20</p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs">
				<select id="showtag_4770" onchange="ajax_edit(4770,'showtag',this.value,'assess_admin');" class="form-control">
					<option value="1">开通</option>
					<option value="0">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a data-toggle="modal" data-target="#modal" href="float.php?type=sysset&amp;cn=assess_admin&amp;do=form&amp;id=4770" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_4770" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
		</tbody>
</table>
<script>
$(".btn-group a:eq(1)").hide();
$(".btn-group a:eq(2)").hide();
</script>				
			</div>
						<div class="foot-page">
				<ul class="pagination no-margin">
					  <li class="active"><a href="/assess/manager/index.php?type=sysset&amp;do=list&amp;cn=assess_admin&amp;nav=0&amp;p=1">1 <span class="sr-only">(current)</span></a></li> <li><a href="/assess/manager/index.php?type=sysset&amp;do=list&amp;cn=assess_admin&amp;nav=0&amp;p=2">2</a></li> <li><a href="/assess/manager/index.php?type=sysset&amp;do=list&amp;cn=assess_admin&amp;nav=0&amp;p=3">3</a></li> <li><a href="/assess/manager/index.php?type=sysset&amp;do=list&amp;cn=assess_admin&amp;nav=0&amp;p=4">4</a></li> <li><a href="/assess/manager/index.php?type=sysset&amp;do=list&amp;cn=assess_admin&amp;nav=0&amp;p=5">5</a></li>  <li><a href="/assess/manager/index.php?type=sysset&amp;do=list&amp;cn=assess_admin&amp;nav=0&amp;p=2" aria-label="Next"><span aria-hidden="true">»</span></a></li>  				</ul>
				<div class="page-num">共4351个 分436页显示</div>
			</div>
					</section>
		</div>
		
<!-- 弹窗框 -->
<div class="modal fade" id="modal" role="dialog" data-backdrop="static" style="display: none;" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div id="mycontent" class="modal-content"><div id="float_page_div">
	          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
            <h4 class="modal-title" id="myModalLabel">新增</h4>
          </div>
          <div class="modal-body">
          	<form class="form-horizontal" id="float_form" action="command.php?do=add&amp;cn=assess_admin&amp;id=" method="post">
          		<div class="box-header with-border">
				<h3 class="box-title">管理员编辑</h3>
			</div>
			<div class="form-horizontal">
				<div class="box-body">
					<div class="form-group">
						<label for="title" class="col-sm-4 control-label">用户名</label>
						<div class="col-sm-8"><input class="form-control" name="username" placeholder="" type="text"></div>
					</div>
					<div class="form-group">
						<label for="title2" class="col-sm-4 control-label">密码</label>
						<div class="col-sm-8"><input class="form-control" name="userpass" value="" placeholder="" type="password"></div>
					</div>
					<div class="form-group">
						<label for="link" class="col-sm-4 control-label">姓名</label>
						<div class="col-sm-8"><input class="form-control" name="name" placeholder="" type="text"></div>
					</div>
					<div class="form-group">
						<label for="link" class="col-sm-4 control-label">电话</label>
						<div class="col-sm-8"><input class="form-control" name="tel" placeholder="" type="text"></div>
					</div>					<div class="form-group">
					<label for="inputHouse" class="col-sm-4 control-label">所属管理权限组</label>
						<div class="col-sm-8">									<select name="agpid" id="agpid" class="form-control">
										<option value="0">请选择</option>
										<option value="1">系统管理员</option><option value="6">车辆查询师</option><option value="8">车辆档案查询</option><option value="10">财务报表</option><option value="12">车辆查询-快金所-点融-征信（风控部）</option><option value="15">客服部模块</option><option value="18">快金所</option><option value="19">发现编辑</option><option value="20">快金所演示组</option><option value="21">点融</option><option value="22">快金所工行审核</option>									</select>						</div>
					</div>					<div class="form-group">
						<label for="link" class="col-sm-4 control-label">鉴定师职称</label>
						<div class="col-sm-8"><input class="form-control" name="bc_title" placeholder="输入职称，比如总部高级鉴定师" type="text"></div>
					</div>
					<div class="form-group">
						<label for="link" class="col-sm-4 control-label">E-mail</label>
						<div class="col-sm-8"><input class="form-control" name="email" placeholder="" type="email"></div>
					</div>
				</div>
				<!-- /.box-body -->
			</div>
<script>
$(document).ready(function(){
	$("#float_form").submit(function(){
		if(this.username.value==""){
			alert("请输入用户名");
			return false;
		}
		if(this.userpass.value==""){
			alert("请输入密码");
			return false;
		}
	});
});
</script>
          	</form>
          </div>
          
                    <div class="modal-footer">
            <button type="button" class="btn btn-default pull-left" data-dismiss="modal" aria-label="Close">取消返回</button>
            <button type="submit" class="btn btn-danger" onclick="$('#float_form').submit()">保存提交</button>
          </div>
          	</div>

<script>
var float_submit=function (jo){
	eval('var jo='+jo);
	if(jo.succ){
		if(typeof(float_submit_succ)=='function'){
			float_submit_succ(jo);
		}else{
			window.location.reload();
		}
		$.fancybox.close();
	}else if(jo.msg){
		alert(jo.msg);
	}
}
$('#float_form').submit(function (){

	if(typeof(float_form_check)=='function'){
		if(!float_form_check()){
			return false;
		}
	}
	
	$('#float_form').ajaxSubmit(float_submit); 
	return false;
});
my_loaded($('#float_form'));
html_load_succ($('#float_form'));
</script>
<script>
var float_load_succ_close=null;
function float_reload(html){
	$('#fancybox-content>div').html(html);
	$.fancybox.resize();
	float_load_succ();
}
var float_load_succ=function (){
	if(float_load_succ_close){
		float_load_succ_close=null;
		$.fancybox.close();
		return ;
	}
	$('#fancybox-content form.thickbox').ajaxForm(function (html){
		if(html){
			float_reload(html)
		}
	})
}
//setTimeout(float_load_succ,100);
</script></div>
		</div>
	</div>
<!-- 搜索 -->

</div>
</body>
</html>