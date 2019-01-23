<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- saved from url=(0116)http://a.kcway.net/assess/manager/index.php?type=assess&cn=assess_querybx&bc_tag=1&nav=0&do=form&id=499&action=check -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>快加后台管理</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<script type="text/javascript">
		var _rooturl = "http://a.kcway.net/assess/";
		var page_cn = "assess_querybx";
	</script>
<!-- Bootstrap 3.3.4 -->
<link href="./KJSTestCSS/bootstrap.min.css" rel="stylesheet" type="text/css">
<!-- Font Awesome Icons -->
<!-- Font Awesome Icons -->
<link href="./KJSTestCSS/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="./KJSTestCSS/select2.min.css" rel="stylesheet" type="text/css">
<!-- Theme style -->
<link href="./KJSTestCSS/AdminLTE.css" rel="stylesheet" type="text/css">
<!-- AdminLTE Skins. We have chosen the skin-blue for this starter
			page. However, you can choose any other skin. Make sure you
			apply the skin class to the body tag so the changes take effect.
	-->
<link href="./KJSTestCSS/skin-green.css" rel="stylesheet" type="text/css">
<link href="./KJSTestCSS/style.css" rel="stylesheet" type="text/css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		<script src="https://cdn.bootcss.com/html5shiv/r29/html5.min.js"></script>
		<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
<!-- jQuery 2.1.4 -->
<script src="./KJSTestCSS/jQuery-2.1.4.min.js" type="text/javascript"></script>
<script src="./KJSTestCSS/common.js" type="text/javascript"></script>
<script src="./KJSTestCSS/jquery.form.js" type="text/javascript"></script>
<script src="./KJSTestCSS/ajaxfileupload.js" type="text/javascript"></script>
<script type="text/javascript" src="./KJSTestCSS/php.js"></script>
<!-- Bootstrap 3.3.2 JS -->
<script src="./KJSTestCSS/bootstrap.min.js" type="text/javascript"></script>
<script src="./KJSTestCSS/moment.js" type="text/javascript"></script>
<script src="./KJSTestCSS/daterangepicker.js" type="text/javascript"></script>
<link href="./KJSTestCSS/daterangepicker-bs3.css" rel="stylesheet" type="text/css">
<script src="./KJSTestCSS/bootstrap-datepicker.js" type="text/javascript"></script>
<link href="./KJSTestCSS/datepicker3.css" rel="stylesheet" type="text/css">
<script src="./KJSTestCSS/bootstrap-datepicker.zh-CN.js" type="text/javascript"></script>
<script src="./KJSTestCSS/bootstrap-datetimepicker.js" type="text/javascript"></script>
<link href="./KJSTestCSS/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css">
<script src="./KJSTestCSS/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
<script type="text/javascript" charset="utf-8" src="./KJSTestCSS/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="./KJSTestCSS/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="./KJSTestCSS/zh-cn.js"></script>
<script src="./KJSTestCSS/select2.min.js" type="text/javascript"></script>
<script src="./KJSTestCSS/zh-cn(1).js" type="text/javascript"></script>
	
		
	<!-- AdminLTE App -->
<script src="./KJSTestCSS/app.min.js" type="text/javascript"></script>
<script src="./KJSTestCSS/combo.js" type="text/javascript"></script>
<script src="./KJSTestCSS/imgup.js" type="text/javascript"></script>
<link href="./KJSTestCSS/imgup.css" rel="stylesheet" type="text/css">
<!-- <script src="/comm/jquery.dragsort-0.4.min.js" type="text/javascript"></script> -->
<link href="./KJSTestCSS/iconfont.css" rel="stylesheet" type="text/css">
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
		
<script>
$('li.active').parents('li').addClass('treeview').addClass('active');
</script><form id="info_form" action="http://a.kcway.net/assess/manager/index.php?type=assess&amp;cn=assess_querybx&amp;bc_tag=1&amp;nav=0&amp;do=form&amp;id=499&amp;action=check" class="form-horizontal" method="post" enctype="multipart/form-data" onsubmit="return check()">
		<input type="hidden" id="id" name="id" value="499">
		<!-- Content Wrapper. Contains page content  content-wrapper fixed-footer -->
	<div class="" style="min-height: 1023px;">
		<!-- Main content -->
		<section class="">
			
<script src="./KJSTestCSS/jQueryRotate.2.2.js" type="text/javascript"></script>
<link href="./KJSTestCSS/frontend.css" rel="stylesheet" type="text/css">

<div class="admin-content nav-tabs-custom box">
	<div class="box-header with-border">
	商户车辆保险查询订单审核  来自：快车道-游振鑫-2018-04-03 10:50:28	<div class="box-body">
			<div class="form-group"><label class="col-sm-2 control-label">审核资料</label>
				<div class="col-sm-10">
					<div class="row inline-from">					<div class="col-sm-6">
							<div class="input-group"><span class="input-group-addon">车辆VIN</span>
								<input type="text" class="form-control" name="c_carvin" readonly=""></div>
					</div>
											<div class="col-sm-6">
							<div class="input-group"><span class="input-group-addon">车辆发动机号</span>
								<input type="text" class="form-control" name="c_carfdjh" readonly=""></div>
					</div>
											<div class="col-sm-6">
							<div class="input-group"><span class="input-group-addon">车辆车牌号</span>
								<input type="text" class="form-control" name="c_carno" readonly=""></div>
					</div>
											<div class="col-sm-6">
							<div class="input-group"><span class="input-group-addon">身份证号</span>
								<input type="text" class="form-control" name="c_cardno" readonly=""></div>
					</div>
											</div>
			</div></div>
	</div>
				<div class="box-header with-border">
			<h3 class="box-title">商户端车辆保险查询审核</h3>
	</div>
		<div class="box-body">
			<div class="form-group"><label class="col-sm-2 control-label">审核：</label>
				<div class="col-sm-10">
					<div class="row inline-from">
						<div class="col-sm-6">
							<div class="input-group"><span class="input-group-addon">审核状态</span> <select name="bc_status" class="form-control" id="bc_status" onchange="autoremark();">
                            	<option value="1">草稿箱</option><option value="2">正在查询</option><option selected="selected" value="3">查询完成</option><option value="4">回退</option><option value="5">已撤销</option>                            </select></div>
					</div>
						<div class="col-sm-6">
							<div class="input-group"><span class="input-group-addon">查询类型</span> <input type="text" class="form-control" readonly="" value="保险查询"></div>
					</div>
				</div>
			</div></div>
			
			<div class="ershou" style="padding-top: 0px; background: none;">
	<ul><li>
			<div class="left" style="width: 30%">
				车型</div>
			<div class="right" style="width:70%;">
				<span>奥迪FV7201BACWG轿车		</span>
		</div>
	</li>
		<li>
			<div class="left" style="width: 30%">
				车牌</div>
			<div class="right" style="width:70%;">
				<span><!-- 沪A632P6 -->${requestScope.carno}</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">
				车辆VIN</div>
			<div class="right" style="width:70%;">
				<span>LFV**********0240		</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">总出险记录数</div>
			<div class="right" style="width:70%;">
				<span>8</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔总金额</div>
			<div class="right" style="width:70%;">
				<span>￥79,584.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">维修总金额</div>
			<div class="right" style="width:70%;">
				<span>￥22,690.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">维修总件数</div>
			<div class="right" style="width:70%;">
				<span>42</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">换件总金额</div>
			<div class="right" style="width:70%;">
				<span>￥56,894.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">换件总件数</div>
			<div class="right" style="width:70%;">
				<span>34</span>
		</div>
	</li>
</ul>
</div>
<ul class="p-list">
	<li class="p-list-item" style="margin-bottom: 0px;">
		<div class="clearfix hd">
			<div class="pull-right"><a href="http://a.kcway.net/assess/manager/index.php?type=assess&amp;cn=assess_querybx&amp;bc_tag=1&amp;nav=0&amp;do=form&amp;id=499&amp;action=check#" class="text-orange"><b></b></a></div>
			<div class="pull-left"><a href="http://a.kcway.net/assess/manager/index.php?type=assess&amp;cn=assess_querybx&amp;bc_tag=1&amp;nav=0&amp;do=form&amp;id=499&amp;action=check#" class="text-orange"><b>出险理赔金额摘要</b></a></div>
	</div>
</li>
</ul>
<div class="ershou" style="padding-top: 0px; background: none;">
	<ul>
		<li>
			<div class="left"><b>出险理赔总金额</b></div>
			<div class="right"><span><b>￥79,584.00</b></span></div>
	</li>
<li>
			<div class="left" style="width: 30%">
			<b>2017-02-12</b></div>
			<div class="right" style="width:70%;">
				<span><b>￥2,950.00</b></span>
		</div>
	</li><li>
			<div class="left" style="width: 30%">
			<b>2016-12-05</b></div>
			<div class="right" style="width:70%;">
				<span><b>￥32,061.00</b></span>
		</div>
	</li><li>
			<div class="left" style="width: 30%">
			<b>2016-11-10</b></div>
			<div class="right" style="width:70%;">
				<span><b>￥9,844.00</b></span>
		</div>
	</li><li>
			<div class="left" style="width: 30%">
			<b>2016-06-21</b></div>
			<div class="right" style="width:70%;">
				<span><b>￥700.00</b></span>
		</div>
	</li><li>
			<div class="left" style="width: 30%">
			<b>2016-03-20</b></div>
			<div class="right" style="width:70%;">
				<span><b>￥21,432.00</b></span>
		</div>
	</li><li>
			<div class="left" style="width: 30%">
			<b>2014-12-29</b></div>
			<div class="right" style="width:70%;">
				<span><b>￥9,197.00</b></span>
		</div>
	</li><li>
			<div class="left" style="width: 30%">
			<b>2014-11-19</b></div>
			<div class="right" style="width:70%;">
				<span><b>￥2,800.00</b></span>
		</div>
	</li><li>
			<div class="left" style="width: 30%">
			<b>2014-11-18</b></div>
			<div class="right" style="width:70%;">
				<span><b>￥600.00</b></span>
		</div>
	</li>	</ul>
</div>
<ul class="p-list">
	<li class="p-list-item" style="margin-bottom: 0px;">
		<div class="clearfix hd">
			<div class="pull-right"><a href="http://a.kcway.net/assess/manager/index.php?type=assess&amp;cn=assess_querybx&amp;bc_tag=1&amp;nav=0&amp;do=form&amp;id=499&amp;action=check#" class="text-orange"><b></b></a></div>
			<div class="pull-left"><a href="http://a.kcway.net/assess/manager/index.php?type=assess&amp;cn=assess_querybx&amp;bc_tag=1&amp;nav=0&amp;do=form&amp;id=499&amp;action=check#" class="text-orange"><b>出险详细记录1</b></a></div>
	</div>
</li>
</ul>
<div class="ershou" style="padding-top: 0px; background: none;">
	<ul>
<li>
			<div class="left" style="width: 30%">出险时间</div>
			<div class="right" style="width:70%;">
				<span>2017-02-12 18:37:00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车牌号</div>
			<div class="right" style="width:70%;">
				<span><!-- ${requestScope.carno} -->${requestScope.carno}</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车架号</div>
			<div class="right" style="width:70%;">
				<span>**************0240</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车型</div>
			<div class="right" style="width:70%;">
				<span>奥迪FV7201BACWG轿车</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔金额</div>
			<div class="right" style="width:70%;">
				<span>￥2,950.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">维修金额</div>
			<div class="right" style="width:70%;">
				<span>￥2,950.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">换件金额</div>
			<div class="right" style="width:70%;">
				<span>￥0.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">其他金额</div>
			<div class="right" style="width:70%;">
				<span>￥0.00</span>
		</div>
	</li>

	<div class="ershou" style="padding-top: 0px; background: none; padding-bottom: 15px;">
			<table style="width:100%;margin-left:0%;margin-right:0%;border-collapse:collapse;">	<tbody><tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2017-02-12 18:37:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前保险杠(全喷)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥1,200.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2017-02-12 18:37:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">左前叶子板(全喷)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥1,200.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2017-02-12 18:37:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">左倒车镜喷漆</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥200.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2017-02-12 18:37:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">左前叶子板整形修复(中)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥200.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2017-02-12 18:37:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前保险杠拆装(含附件)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥150.00</td>
			</tr>
					</tbody></table>
	</div>
</ul>
</div>
<ul class="p-list">
	<li class="p-list-item" style="margin-bottom: 0px;">
		<div class="clearfix hd">
			<div class="pull-right"><a href="http://a.kcway.net/assess/manager/index.php?type=assess&amp;cn=assess_querybx&amp;bc_tag=1&amp;nav=0&amp;do=form&amp;id=499&amp;action=check#" class="text-orange"><b></b></a></div>
			<div class="pull-left"><a href="http://a.kcway.net/assess/manager/index.php?type=assess&amp;cn=assess_querybx&amp;bc_tag=1&amp;nav=0&amp;do=form&amp;id=499&amp;action=check#" class="text-orange"><b>出险详细记录2</b></a></div>
	</div>
</li>
</ul>
<div class="ershou" style="padding-top: 0px; background: none;">
	<ul>
<li>
			<div class="left" style="width: 30%">出险时间</div>
			<div class="right" style="width:70%;">
				<span>2016-12-05 12:28:00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车牌号</div>
			<div class="right" style="width:70%;">
				<span><!-- ${requestScope.carno} -->${requestScope.carno}</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车架号</div>
			<div class="right" style="width:70%;">
				<span>**************0240</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车型</div>
			<div class="right" style="width:70%;">
				<span>奥迪FV7201BACWG轿车</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔金额</div>
			<div class="right" style="width:70%;">
				<span>￥32,061.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">维修金额</div>
			<div class="right" style="width:70%;">
				<span>￥4,820.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">换件金额</div>
			<div class="right" style="width:70%;">
				<span>￥27,241.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">其他金额</div>
			<div class="right" style="width:70%;">
				<span>￥0.00</span>
		</div>
	</li>

	<div class="ershou" style="padding-top: 0px; background: none; padding-bottom: 15px;">
			<table style="width:100%;margin-left:0%;margin-right:0%;border-collapse:collapse;">	<tbody><tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">引擎盖(全喷)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥1,200.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前保险杠(全喷)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥1,200.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">右前叶子板(全喷)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥1,200.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">水箱框架拆装</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥400.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">大灯线束修复</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥200.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">右前叶子板整形修复(中)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥200.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">引擎盖拆装</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥150.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前保险杠拆装(含附件)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥150.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">左前大灯拆装</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥60.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">右前大灯拆装</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥60.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前大灯（左）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥8,421.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前大灯（右）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥8,321.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">发动机罩</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥4,007.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前保险杠皮</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥2,860.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">中网</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥1,270.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">散热器框架</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥870.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">空气滤清器总成</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥574.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前叶子板前内衬（左）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥395.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">卡扣螺丝辅料</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥200.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">空气滤清器进气管</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥180.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">散热器上护板</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥45.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前大灯安装底板（右）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥45.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前保险杠内衬</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥30.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-12-05 12:28:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">散热器护板（右）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥23.00</td>
			</tr>
					</tbody></table>
	</div>
</ul>
</div>
<ul class="p-list">
	<li class="p-list-item" style="margin-bottom: 0px;">
		<div class="clearfix hd">
			<div class="pull-right"><a href="http://a.kcway.net/assess/manager/index.php?type=assess&amp;cn=assess_querybx&amp;bc_tag=1&amp;nav=0&amp;do=form&amp;id=499&amp;action=check#" class="text-orange"><b></b></a></div>
			<div class="pull-left"><a href="http://a.kcway.net/assess/manager/index.php?type=assess&amp;cn=assess_querybx&amp;bc_tag=1&amp;nav=0&amp;do=form&amp;id=499&amp;action=check#" class="text-orange"><b>出险详细记录3</b></a></div>
	</div>
</li>
</ul>
<div class="ershou" style="padding-top: 0px; background: none;">
	<ul>
<li>
			<div class="left" style="width: 30%">出险时间</div>
			<div class="right" style="width:70%;">
				<span>2016-11-10 09:19:00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车牌号</div>
			<div class="right" style="width:70%;">
				<span>${requestScope.carno}</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车架号</div>
			<div class="right" style="width:70%;">
				<span>**************0240</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车型</div>
			<div class="right" style="width:70%;">
				<span>奥迪FV7201BACWG轿车</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔金额</div>
			<div class="right" style="width:70%;">
				<span>￥9,844.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">维修金额</div>
			<div class="right" style="width:70%;">
				<span>￥3,230.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">换件金额</div>
			<div class="right" style="width:70%;">
				<span>￥6,614.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">其他金额</div>
			<div class="right" style="width:70%;">
				<span>￥0.00</span>
		</div>
	</li>

	<div class="ershou" style="padding-top: 0px; background: none; padding-bottom: 15px;">
			<table style="width:100%;margin-left:0%;margin-right:0%;border-collapse:collapse;">	<tbody><tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-11-10 09:19:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">右后门(全喷)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥1,200.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-11-10 09:19:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">后保险杠(半喷)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥650.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-11-10 09:19:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">右后车门壳拆装</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥380.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-11-10 09:19:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">右侧底大边喷漆</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥350.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-11-10 09:19:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">右侧底大边内板整形喷漆</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥350.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-11-10 09:19:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">右侧底大边拆装</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥300.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-11-10 09:19:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">后门壳（右）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥5,085.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-11-10 09:19:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">底大边（右）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥836.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-11-10 09:19:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">后门饰条（右）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥525.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-11-10 09:19:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">后门密封胶条（右）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥168.00</td>
			</tr>
					</tbody></table>
	</div>
</ul>
</div>
<ul class="p-list">
	<li class="p-list-item" style="margin-bottom: 0px;">
		<div class="clearfix hd">
			<div class="pull-right"><a href="http://a.kcway.net/assess/manager/index.php?type=assess&amp;cn=assess_querybx&amp;bc_tag=1&amp;nav=0&amp;do=form&amp;id=499&amp;action=check#" class="text-orange"><b></b></a></div>
			<div class="pull-left"><a href="http://a.kcway.net/assess/manager/index.php?type=assess&amp;cn=assess_querybx&amp;bc_tag=1&amp;nav=0&amp;do=form&amp;id=499&amp;action=check#" class="text-orange"><b>出险详细记录4</b></a></div>
	</div>
</li>
</ul>
<div class="ershou" style="padding-top: 0px; background: none;">
	<ul>
<li>
			<div class="left" style="width: 30%">出险时间</div>
			<div class="right" style="width:70%;">
				<span>2016-06-21 17:10:00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车牌号</div>
			<div class="right" style="width:70%;">
				<span>${requestScope.carno}</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车架号</div>
			<div class="right" style="width:70%;">
				<span>**************0240</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车型</div>
			<div class="right" style="width:70%;">
				<span>奥迪FV7201BACWG轿车</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔金额</div>
			<div class="right" style="width:70%;">
				<span>￥700.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">维修金额</div>
			<div class="right" style="width:70%;">
				<span>￥700.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">换件金额</div>
			<div class="right" style="width:70%;">
				<span>￥0.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">其他金额</div>
			<div class="right" style="width:70%;">
				<span>￥0.00</span>
		</div>
	</li>

	<div class="ershou" style="padding-top: 0px; background: none; padding-bottom: 15px;">
			<table style="width:100%;margin-left:0%;margin-right:0%;border-collapse:collapse;">	<tbody><tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-06-21 17:10:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">后保险杠(全喷)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥600.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-06-21 17:10:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">后保险杠皮拆装</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥100.00</td>
			</tr>
					</tbody></table>
	</div>
</ul>
</div>
<ul class="p-list">
	<li class="p-list-item" style="margin-bottom: 0px;">
		<div class="clearfix hd">
			<div class="pull-right"><a href="http://a.kcway.net/assess/manager/index.php?type=assess&amp;cn=assess_querybx&amp;bc_tag=1&amp;nav=0&amp;do=form&amp;id=499&amp;action=check#" class="text-orange"><b></b></a></div>
			<div class="pull-left"><a href="http://a.kcway.net/assess/manager/index.php?type=assess&amp;cn=assess_querybx&amp;bc_tag=1&amp;nav=0&amp;do=form&amp;id=499&amp;action=check#" class="text-orange"><b>出险详细记录5</b></a></div>
	</div>
</li>
</ul>
<div class="ershou" style="padding-top: 0px; background: none;">
	<ul>
<li>
			<div class="left" style="width: 30%">出险时间</div>
			<div class="right" style="width:70%;">
				<span>2016-03-20 15:42:00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车牌号</div>
			<div class="right" style="width:70%;">
				<span>${requestScope.carno}</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车架号</div>
			<div class="right" style="width:70%;">
				<span>**************0240</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车型</div>
			<div class="right" style="width:70%;">
				<span>奥迪FV7201BACWG轿车</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔金额</div>
			<div class="right" style="width:70%;">
				<span>￥21,432.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">维修金额</div>
			<div class="right" style="width:70%;">
				<span>￥4,890.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">换件金额</div>
			<div class="right" style="width:70%;">
				<span>￥16,542.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">其他金额</div>
			<div class="right" style="width:70%;">
				<span>￥0.00</span>
		</div>
	</li>

	<div class="ershou" style="padding-top: 0px; background: none; padding-bottom: 15px;">
			<table style="width:100%;margin-left:0%;margin-right:0%;border-collapse:collapse;">	<tbody><tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-03-20 15:42:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">引擎盖(全喷)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥1,080.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-03-20 15:42:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">右前门(全喷)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥1,080.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-03-20 15:42:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前保险杠(全喷)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥1,080.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-03-20 15:42:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">右前叶子板(全喷)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥1,080.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-03-20 15:42:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">引擎盖整形修复(中)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥300.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-03-20 15:42:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前保险杠拆装(含附件)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥150.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-03-20 15:42:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">右前叶子板拆装</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥120.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-03-20 15:42:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前大灯（右）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥8,421.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-03-20 15:42:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前保险杠皮</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥2,860.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-03-20 15:42:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前叶子板（右）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥1,950.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-03-20 15:42:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">中网</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥1,270.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-03-20 15:42:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前大灯喷水嘴（右）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥699.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-03-20 15:42:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前叶子板内衬（右）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥448.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-03-20 15:42:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前叶子板前内衬（右）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥395.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-03-20 15:42:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前保险杠下护板</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥394.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-03-20 15:42:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前叶子板固定架（右）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥60.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2016-03-20 15:42:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前保险杠下隔栅（右）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥45.00</td>
			</tr>
					</tbody></table>
	</div>
</ul>
</div>
<ul class="p-list">
	<li class="p-list-item" style="margin-bottom: 0px;">
		<div class="clearfix hd">
			<div class="pull-right"><a href="http://a.kcway.net/assess/manager/index.php?type=assess&amp;cn=assess_querybx&amp;bc_tag=1&amp;nav=0&amp;do=form&amp;id=499&amp;action=check#" class="text-orange"><b></b></a></div>
			<div class="pull-left"><a href="http://a.kcway.net/assess/manager/index.php?type=assess&amp;cn=assess_querybx&amp;bc_tag=1&amp;nav=0&amp;do=form&amp;id=499&amp;action=check#" class="text-orange"><b>出险详细记录6</b></a></div>
	</div>
</li>
</ul>
<div class="ershou" style="padding-top: 0px; background: none;">
	<ul>
<li>
			<div class="left" style="width: 30%">出险时间</div>
			<div class="right" style="width:70%;">
				<span>2014-12-29 23:00:00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车牌号</div>
			<div class="right" style="width:70%;">
				<span>${requestScope.carno}</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车架号</div>
			<div class="right" style="width:70%;">
				<span>**************0240</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车型</div>
			<div class="right" style="width:70%;">
				<span>奥迪FV7201BACWG轿车</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔金额</div>
			<div class="right" style="width:70%;">
				<span>￥9,197.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">维修金额</div>
			<div class="right" style="width:70%;">
				<span>￥2,700.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">换件金额</div>
			<div class="right" style="width:70%;">
				<span>￥6,497.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">其他金额</div>
			<div class="right" style="width:70%;">
				<span>￥0.00</span>
		</div>
	</li>

	<div class="ershou" style="padding-top: 0px; background: none; padding-bottom: 15px;">
			<table style="width:100%;margin-left:0%;margin-right:0%;border-collapse:collapse;">	<tbody><tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2014-12-29 23:00:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前保险杠(全喷)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥700.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2014-12-29 23:00:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">左前叶子板(全喷)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥700.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2014-12-29 23:00:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">左前叶子板整形修复(中)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥500.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2014-12-29 23:00:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">四轮定位(含调整)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥400.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2014-12-29 23:00:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前保险杠拆装(含附件)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥300.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2014-12-29 23:00:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">左前车轮拆装</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥100.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2014-12-29 23:00:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前保险杠皮</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥2,860.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2014-12-29 23:00:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前大灯（左）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥2,838.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2014-12-29 23:00:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前叶子板前内衬（左）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥395.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2014-12-29 23:00:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">转向横拉杆（左）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥336.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2014-12-29 23:00:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前叶子板固定架（左）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥60.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2014-12-29 23:00:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">前保险杠支架（左）</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">换件</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥8.00</td>
			</tr>
					</tbody></table>
	</div>
</ul>
</div>
<ul class="p-list">
	<li class="p-list-item" style="margin-bottom: 0px;">
		<div class="clearfix hd">
			<div class="pull-right"><a href="http://a.kcway.net/assess/manager/index.php?type=assess&amp;cn=assess_querybx&amp;bc_tag=1&amp;nav=0&amp;do=form&amp;id=499&amp;action=check#" class="text-orange"><b></b></a></div>
			<div class="pull-left"><a href="http://a.kcway.net/assess/manager/index.php?type=assess&amp;cn=assess_querybx&amp;bc_tag=1&amp;nav=0&amp;do=form&amp;id=499&amp;action=check#" class="text-orange"><b>出险详细记录7</b></a></div>
	</div>
</li>
</ul>
<div class="ershou" style="padding-top: 0px; background: none;">
	<ul>
<li>
			<div class="left" style="width: 30%">出险时间</div>
			<div class="right" style="width:70%;">
				<span>2014-11-19 08:05:00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车牌号</div>
			<div class="right" style="width:70%;">
				<span>${requestScope.carno}</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车架号</div>
			<div class="right" style="width:70%;">
				<span>**************0240</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车型</div>
			<div class="right" style="width:70%;">
				<span>奥迪FV7201BACWG轿车</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔金额</div>
			<div class="right" style="width:70%;">
				<span>￥2,800.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">维修金额</div>
			<div class="right" style="width:70%;">
				<span>￥2,800.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">换件金额</div>
			<div class="right" style="width:70%;">
				<span>￥0.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">其他金额</div>
			<div class="right" style="width:70%;">
				<span>￥0.00</span>
		</div>
	</li>

	<div class="ershou" style="padding-top: 0px; background: none; padding-bottom: 15px;">
			<table style="width:100%;margin-left:0%;margin-right:0%;border-collapse:collapse;">	<tbody><tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2014-11-19 08:05:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">左前门(全喷)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥700.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2014-11-19 08:05:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">左后门(全喷)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥700.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2014-11-19 08:05:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">右后门(全喷)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥700.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2014-11-19 08:05:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">右后叶子板(全喷)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥700.00</td>
			</tr>
					</tbody></table>
	</div>
</ul>
</div>
<ul class="p-list">
	<li class="p-list-item" style="margin-bottom: 0px;">
		<div class="clearfix hd">
			<div class="pull-right"><a href="http://a.kcway.net/assess/manager/index.php?type=assess&amp;cn=assess_querybx&amp;bc_tag=1&amp;nav=0&amp;do=form&amp;id=499&amp;action=check#" class="text-orange"><b></b></a></div>
			<div class="pull-left"><a href="http://a.kcway.net/assess/manager/index.php?type=assess&amp;cn=assess_querybx&amp;bc_tag=1&amp;nav=0&amp;do=form&amp;id=499&amp;action=check#" class="text-orange"><b>出险详细记录8</b></a></div>
	</div>
</li>
</ul>
<div class="ershou" style="padding-top: 0px; background: none;">
	<ul>
<li>
			<div class="left" style="width: 30%">出险时间</div>
			<div class="right" style="width:70%;">
				<span>2014-11-18 22:03:00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车牌号</div>
			<div class="right" style="width:70%;">
				<span><!-- ${requestScope.carno} -->${requestScope.carno}</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车架号</div>
			<div class="right" style="width:70%;">
				<span>**************0240</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔车型</div>
			<div class="right" style="width:70%;">
				<span>奥迪FV7201BACWG轿车</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">理赔金额</div>
			<div class="right" style="width:70%;">
				<span>￥600.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">维修金额</div>
			<div class="right" style="width:70%;">
				<span>￥600.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">换件金额</div>
			<div class="right" style="width:70%;">
				<span>￥0.00</span>
		</div>
	</li>
<li>
			<div class="left" style="width: 30%">其他金额</div>
			<div class="right" style="width:70%;">
				<span>￥0.00</span>
		</div>
	</li>

	<div class="ershou" style="padding-top: 0px; background: none; padding-bottom: 15px;">
			<table style="width:100%;margin-left:0%;margin-right:0%;border-collapse:collapse;">	<tbody><tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2014-11-18 22:03:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">后保险杠(半喷)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥400.00</td>
			</tr>
				<tr style="background: #f5f5f5; height: 30px; line-height: 30px;border-bottom:1px solid #f7900f;">
					<td class="left" style="width: 40%; text-align: left;">2014-11-18 22:03:00</td>
					<td class="right" style="width: 60%; text-align: right; padding-right: 2px;"></td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%;">理赔项名称：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">后保险杠修复(小)</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项类型：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">维修</td>
			</tr>
				<tr style="border-bottom:1px solid #dcdcdc;">
					<td class="left" style="width: 20%">理赔项金额：</td>
					<td class="right" style="width: 80%; word-break: break-all; word-wrap: break-word;">￥200.00</td>
			</tr>
					</tbody></table>
	</div>
</ul>
</div>
<div style="height: 15px; background: #ecf0f5;"></div>			<div class="form-group"><label class="col-sm-2 control-label">留言备注说明：</label>
				<div class="col-sm-10">
					<div class="row inline-from">
						<div class="col-sm-5">
							<div class="input-group"><span class="input-group-addon">审核留言</span> <input type="text" class="form-control" name="remark" id="remark"></div>
					</div>
						<div class="col-sm-5">
							<div class="input-group"><span class="input-group-addon">常用留言快速通道</span> <select class="form-control" id="cyly" onchange="setremark(this)">
												<option value="请选择">请选择</option>						<option value="查询完成，详情请点击订单详情页查看！">查询完成，详情请点击订单详情页查看！</option>						<option value="行驶证要上传信息页面，上传后面一页无法识别。">行驶证要上传信息页面，上传后面一页无法识别。</option>						<option value="提交材料过于模糊，无法识别">提交材料过于模糊，无法识别</option>						<option value="请 上传行驶证">请 上传行驶证</option>						<option value="请上传完整的行驶证驾驶证照片">请上传完整的行驶证驾驶证照片</option>						<option value="请上传清晰的行驶证、驾驶证照片">请上传清晰的行驶证、驾驶证照片</option>						<option value="请上传完整的行驶证照片">请上传完整的行驶证照片</option>						<option value="请提供完整的行驶证资料">请提供完整的行驶证资料</option>						<option value="相关资料不够完整">相关资料不够完整</option>						<option value="请提供完整的行驶证和驾驶证资料">请提供完整的行驶证和驾驶证资料</option>						<option value="行驶证相关资料不完整">行驶证相关资料不完整</option>						<option value="需要更清晰照片">需要更清晰照片</option>						<option value="个人风险筛查结果:通过;贷款汇总(抵押):未结清贷款笔数:1,2014.04房贷;未结清贷款余额:1097888;近两年逾期次数:0;单月最高逾期金额:0;当前逾期金额:0;近6个月平均月还:6530;信用卡汇总:张数:1;授信总额:20000;近6个月使用额:6241;近两年逾期次数:0;单月最高逾期金额:0;当前逾期金额:0;备注:房贷余额:苏州市元和电子元件厂;通过贷款逾期记录:-;信用卡逾期记录:-;工行专项卡分期笔数:-;未结清余额:-;备注:贷款汇总(抵押):未结清贷款笔数:1,2014.04">个人风险筛查结果:通过;贷款汇总(抵押):未结清贷款笔数:1,2014.04房贷;未结清贷款余额:1097888;近两年逾期次数:0;单月最高逾期金额:0;当前逾期金额:0;近6个月平均月还:6530;信用卡汇总:张数:1;授信总额:20000;近6个月使用额:6241;近两年逾期次数:0;单月最高逾期金额:0;当前逾期金额:0;备注:房贷余额:苏州市元和电子元件厂;通过贷款逾期记录:-;信用卡逾期记录:-;工行专项卡分期笔数:-;未结清余额:-;备注:贷款汇总(抵押):未结清贷款笔数:1,2014.04</option>						<option value="该车重要组成部件更换过">该车重要组成部件更换过</option>						</select></div>
					</div>
				</div>
			</div></div>
			<div class="form-group"><label class="col-sm-2 control-label">历次审核事件和留言：</label>
				<div class="col-sm-10"><textarea style="width: 100%; height: 200px" class="form-control" readonly="">2018-04-03 10:50:28:状态：草稿箱,留言：
2018-04-03 10:50:28:状态：正在查询,留言：用户提交，快加正在查询..
2018-04-03 10:50:30:状态：查询完成,留言：出险记录自助查询完成！
</textarea></div></div>		</div>
</div>
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
	if ($("#bc_status").val()>2){
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
	$("#result_imgurl"+obj+"_view").attr("src","/assess/upload/none.jpg");
	$("#result_imgurl"+obj).val("");
}

function rpic(fid,type){
	var ri = parseInt($("#imgurl").attr("data-ri"));
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
var xfile = $("#imgurl").attr("data-src");
$.post("ajax.php?do=rpic",{src:xfile,rtype:type},function(res){
	eval("var res="+res);
	if(res.succ){
		$("#imgurl").rotate({animateTo:ri});	
		$("#imgurl").attr("data-ri",ri);
		var tmpstr  = $("#ashowpic"+fid).attr("href");
		var ni = tmpstr.indexOf('?');
		tmpstr = substr(tmpstr,0,ni); 
		var timestamp = Date.parse(new Date());
		//$("#imgurl").attr("src",tmpstr+"?"+timestamp);
		$("#ashowpic"+fid).attr("href",tmpstr+"?"+timestamp+"&nav=1");
	}else{
		alert(res.msg);
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
</script>		</section>
				<!-- <div class="footer-wrap">
			<div class="box-footer">
				<button type="button" class="btn btn-default" onclick="location.href=TKJSselectAll.do?status=3">取消返回</button>
				<button type="submit" class="btn btn-primary pull-right">保存提交</button> 
			</div>
		</div> -->
			</div><!-- /.content-wrapper -->
</form>

<script>editFun({"id":"499","mid_add":"257","mid_edit":"257","dt_add":"2018-04-03 10:50:27","dt_edit":"2018-04-03 10:50:28","imgurl":"","bc_status":"3","query_type":"0","gems_id":"48","gems_fs_id":"27","c_carvin":"LFV3A24G0D3030240","c_carfdjh":"","c_carno":"","c_cardno":"","result_imgurl1":"","result_imgurl2":"","result_imgurl3":"","gems_code":"BXkcd0000499","result_imgurl4":"","result_imgurl5":"","result_imgurl6":"","result_imgurl7":"","result_imgurl8":"","result_imgurl9":"","result_imgurl10":"","result_imgurl11":"","result_imgurl12":"","result_imgurl13":null,"result_imgurl14":null,"result_imgurl15":null,"result_imgurl16":null,"result_imgurl17":null,"result_imgurl18":null,"result_imgurl19":null,"result_imgurl20":null,"result_imgurl21":null,"result_imgurl22":null,"result_imgurl23":null,"result_imgurl24":null,"result_imgurl25":null,"result_imgurl26":null,"result_imgurl27":null,"result_imgurl28":null,"result_imgurl29":null,"result_imgurl30":null,"api_result":"{\"resultCode\":0,\"resultData\":{\"result\":{\"carClaimRecords\":[{\"frameNo\":\"**************0240\",\"licenseNo\":\"\u6caaA632P6\",\"otherAmount\":\"0\",\"claimDetails\":[{\"itemName\":\"\u524d\u4fdd\u9669\u6760(\u5168\u55b7)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"120000\"},{\"itemName\":\"\u5de6\u524d\u53f6\u5b50\u677f(\u5168\u55b7)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"120000\"},{\"itemName\":\"\u5de6\u5012\u8f66\u955c\u55b7\u6f06\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"20000\"},{\"itemName\":\"\u5de6\u524d\u53f6\u5b50\u677f\u6574\u5f62\u4fee\u590d(\u4e2d)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"20000\"},{\"itemName\":\"\u524d\u4fdd\u9669\u6760\u62c6\u88c5(\u542b\u9644\u4ef6)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"15000\"}],\"repairAmount\":\"295000\",\"vehicleModel\":\"\u5965\u8feaFV7201BACWG\u8f7f\u8f66\",\"dangerTime\":\"2017-02-12 18:37:00\",\"damageMoney\":\"295000\",\"renewalAmount\":\"0\"},{\"frameNo\":\"**************0240\",\"licenseNo\":\"\u6caaA632P6\",\"otherAmount\":\"0\",\"claimDetails\":[{\"itemName\":\"\u5f15\u64ce\u76d6(\u5168\u55b7)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"120000\"},{\"itemName\":\"\u524d\u4fdd\u9669\u6760(\u5168\u55b7)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"120000\"},{\"itemName\":\"\u53f3\u524d\u53f6\u5b50\u677f(\u5168\u55b7)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"120000\"},{\"itemName\":\"\u6c34\u7bb1\u6846\u67b6\u62c6\u88c5\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"40000\"},{\"itemName\":\"\u5927\u706f\u7ebf\u675f\u4fee\u590d\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"20000\"},{\"itemName\":\"\u53f3\u524d\u53f6\u5b50\u677f\u6574\u5f62\u4fee\u590d(\u4e2d)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"20000\"},{\"itemName\":\"\u5f15\u64ce\u76d6\u62c6\u88c5\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"15000\"},{\"itemName\":\"\u524d\u4fdd\u9669\u6760\u62c6\u88c5(\u542b\u9644\u4ef6)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"15000\"},{\"itemName\":\"\u5de6\u524d\u5927\u706f\u62c6\u88c5\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"6000\"},{\"itemName\":\"\u53f3\u524d\u5927\u706f\u62c6\u88c5\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"6000\"},{\"itemName\":\"\u524d\u5927\u706f\uff08\u5de6\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"842100\"},{\"itemName\":\"\u524d\u5927\u706f\uff08\u53f3\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"832100\"},{\"itemName\":\"\u53d1\u52a8\u673a\u7f69\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"400700\"},{\"itemName\":\"\u524d\u4fdd\u9669\u6760\u76ae\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"286000\"},{\"itemName\":\"\u4e2d\u7f51\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"127000\"},{\"itemName\":\"\u6563\u70ed\u5668\u6846\u67b6\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"87000\"},{\"itemName\":\"\u7a7a\u6c14\u6ee4\u6e05\u5668\u603b\u6210\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"57400\"},{\"itemName\":\"\u524d\u53f6\u5b50\u677f\u524d\u5185\u886c\uff08\u5de6\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"39500\"},{\"itemName\":\"\u5361\u6263\u87ba\u4e1d\u8f85\u6599\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"20000\"},{\"itemName\":\"\u7a7a\u6c14\u6ee4\u6e05\u5668\u8fdb\u6c14\u7ba1\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"18000\"},{\"itemName\":\"\u6563\u70ed\u5668\u4e0a\u62a4\u677f\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"4500\"},{\"itemName\":\"\u524d\u5927\u706f\u5b89\u88c5\u5e95\u677f\uff08\u53f3\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"4500\"},{\"itemName\":\"\u524d\u4fdd\u9669\u6760\u5185\u886c\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"3000\"},{\"itemName\":\"\u6563\u70ed\u5668\u62a4\u677f\uff08\u53f3\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"2300\"}],\"repairAmount\":\"482000\",\"vehicleModel\":\"\u5965\u8feaFV7201BACWG\u8f7f\u8f66\",\"dangerTime\":\"2016-12-05 12:28:00\",\"damageMoney\":\"3206100\",\"renewalAmount\":\"2724100\"},{\"frameNo\":\"**************0240\",\"licenseNo\":\"\u6caaA632P6\",\"otherAmount\":\"0\",\"claimDetails\":[{\"itemName\":\"\u53f3\u540e\u95e8(\u5168\u55b7)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"120000\"},{\"itemName\":\"\u540e\u4fdd\u9669\u6760(\u534a\u55b7)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"65000\"},{\"itemName\":\"\u53f3\u540e\u8f66\u95e8\u58f3\u62c6\u88c5\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"38000\"},{\"itemName\":\"\u53f3\u4fa7\u5e95\u5927\u8fb9\u55b7\u6f06\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"35000\"},{\"itemName\":\"\u53f3\u4fa7\u5e95\u5927\u8fb9\u5185\u677f\u6574\u5f62\u55b7\u6f06\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"35000\"},{\"itemName\":\"\u53f3\u4fa7\u5e95\u5927\u8fb9\u62c6\u88c5\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"30000\"},{\"itemName\":\"\u540e\u95e8\u58f3\uff08\u53f3\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"508500\"},{\"itemName\":\"\u5e95\u5927\u8fb9\uff08\u53f3\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"83600\"},{\"itemName\":\"\u540e\u95e8\u9970\u6761\uff08\u53f3\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"52500\"},{\"itemName\":\"\u540e\u95e8\u5bc6\u5c01\u80f6\u6761\uff08\u53f3\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"16800\"}],\"repairAmount\":\"323000\",\"vehicleModel\":\"\u5965\u8feaFV7201BACWG\u8f7f\u8f66\",\"dangerTime\":\"2016-11-10 09:19:00\",\"damageMoney\":\"984400\",\"renewalAmount\":\"661400\"},{\"frameNo\":\"**************0240\",\"licenseNo\":\"\u6caaA632P6\",\"otherAmount\":\"0\",\"claimDetails\":[{\"itemName\":\"\u540e\u4fdd\u9669\u6760(\u5168\u55b7)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"60000\"},{\"itemName\":\"\u540e\u4fdd\u9669\u6760\u76ae\u62c6\u88c5\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"10000\"}],\"repairAmount\":\"70000\",\"vehicleModel\":\"\u5965\u8feaFV7201BACWG\u8f7f\u8f66\",\"dangerTime\":\"2016-06-21 17:10:00\",\"damageMoney\":\"70000\",\"renewalAmount\":\"0\"},{\"frameNo\":\"**************0240\",\"licenseNo\":\"\u6caaA632P6\",\"otherAmount\":\"0\",\"claimDetails\":[{\"itemName\":\"\u5f15\u64ce\u76d6(\u5168\u55b7)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"108000\"},{\"itemName\":\"\u53f3\u524d\u95e8(\u5168\u55b7)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"108000\"},{\"itemName\":\"\u524d\u4fdd\u9669\u6760(\u5168\u55b7)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"108000\"},{\"itemName\":\"\u53f3\u524d\u53f6\u5b50\u677f(\u5168\u55b7)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"108000\"},{\"itemName\":\"\u5f15\u64ce\u76d6\u6574\u5f62\u4fee\u590d(\u4e2d)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"30000\"},{\"itemName\":\"\u524d\u4fdd\u9669\u6760\u62c6\u88c5(\u542b\u9644\u4ef6)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"15000\"},{\"itemName\":\"\u53f3\u524d\u53f6\u5b50\u677f\u62c6\u88c5\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"12000\"},{\"itemName\":\"\u524d\u5927\u706f\uff08\u53f3\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"842100\"},{\"itemName\":\"\u524d\u4fdd\u9669\u6760\u76ae\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"286000\"},{\"itemName\":\"\u524d\u53f6\u5b50\u677f\uff08\u53f3\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"195000\"},{\"itemName\":\"\u4e2d\u7f51\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"127000\"},{\"itemName\":\"\u524d\u5927\u706f\u55b7\u6c34\u5634\uff08\u53f3\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"69900\"},{\"itemName\":\"\u524d\u53f6\u5b50\u677f\u5185\u886c\uff08\u53f3\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"44800\"},{\"itemName\":\"\u524d\u53f6\u5b50\u677f\u524d\u5185\u886c\uff08\u53f3\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"39500\"},{\"itemName\":\"\u524d\u4fdd\u9669\u6760\u4e0b\u62a4\u677f\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"39400\"},{\"itemName\":\"\u524d\u53f6\u5b50\u677f\u56fa\u5b9a\u67b6\uff08\u53f3\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"6000\"},{\"itemName\":\"\u524d\u4fdd\u9669\u6760\u4e0b\u9694\u6805\uff08\u53f3\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"4500\"}],\"repairAmount\":\"489000\",\"vehicleModel\":\"\u5965\u8feaFV7201BACWG\u8f7f\u8f66\",\"dangerTime\":\"2016-03-20 15:42:00\",\"damageMoney\":\"2143200\",\"renewalAmount\":\"1654200\"},{\"frameNo\":\"**************0240\",\"licenseNo\":\"\u6caaA632P6\",\"otherAmount\":\"0\",\"claimDetails\":[{\"itemName\":\"\u524d\u4fdd\u9669\u6760(\u5168\u55b7)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"70000\"},{\"itemName\":\"\u5de6\u524d\u53f6\u5b50\u677f(\u5168\u55b7)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"70000\"},{\"itemName\":\"\u5de6\u524d\u53f6\u5b50\u677f\u6574\u5f62\u4fee\u590d(\u4e2d)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"50000\"},{\"itemName\":\"\u56db\u8f6e\u5b9a\u4f4d(\u542b\u8c03\u6574)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"40000\"},{\"itemName\":\"\u524d\u4fdd\u9669\u6760\u62c6\u88c5(\u542b\u9644\u4ef6)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"30000\"},{\"itemName\":\"\u5de6\u524d\u8f66\u8f6e\u62c6\u88c5\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"10000\"},{\"itemName\":\"\u524d\u4fdd\u9669\u6760\u76ae\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"286000\"},{\"itemName\":\"\u524d\u5927\u706f\uff08\u5de6\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"283800\"},{\"itemName\":\"\u524d\u53f6\u5b50\u677f\u524d\u5185\u886c\uff08\u5de6\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"39500\"},{\"itemName\":\"\u8f6c\u5411\u6a2a\u62c9\u6746\uff08\u5de6\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"33600\"},{\"itemName\":\"\u524d\u53f6\u5b50\u677f\u56fa\u5b9a\u67b6\uff08\u5de6\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"6000\"},{\"itemName\":\"\u524d\u4fdd\u9669\u6760\u652f\u67b6\uff08\u5de6\uff09\",\"itemType\":\"\u6362\u4ef6\",\"itemAmount\":\"800\"}],\"repairAmount\":\"270000\",\"vehicleModel\":\"\u5965\u8feaFV7201BACWG\u8f7f\u8f66\",\"dangerTime\":\"2014-12-29 23:00:00\",\"damageMoney\":\"919700\",\"renewalAmount\":\"649700\"},{\"frameNo\":\"**************0240\",\"licenseNo\":\"\u6caaA632P6\",\"otherAmount\":\"0\",\"claimDetails\":[{\"itemName\":\"\u5de6\u524d\u95e8(\u5168\u55b7)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"70000\"},{\"itemName\":\"\u5de6\u540e\u95e8(\u5168\u55b7)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"70000\"},{\"itemName\":\"\u53f3\u540e\u95e8(\u5168\u55b7)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"70000\"},{\"itemName\":\"\u53f3\u540e\u53f6\u5b50\u677f(\u5168\u55b7)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"70000\"}],\"repairAmount\":\"280000\",\"vehicleModel\":\"\u5965\u8feaFV7201BACWG\u8f7f\u8f66\",\"dangerTime\":\"2014-11-19 08:05:00\",\"damageMoney\":\"280000\",\"renewalAmount\":\"0\"},{\"frameNo\":\"**************0240\",\"licenseNo\":\"\u6caaA632P6\",\"otherAmount\":\"0\",\"claimDetails\":[{\"itemName\":\"\u540e\u4fdd\u9669\u6760(\u534a\u55b7)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"40000\"},{\"itemName\":\"\u540e\u4fdd\u9669\u6760\u4fee\u590d(\u5c0f)\",\"itemType\":\"\u7ef4\u4fee\",\"itemAmount\":\"20000\"}],\"repairAmount\":\"60000\",\"vehicleModel\":\"\u5965\u8feaFV7201BACWG\u8f7f\u8f66\",\"dangerTime\":\"2014-11-18 22:03:00\",\"damageMoney\":\"60000\",\"renewalAmount\":\"0\"}],\"summaryData\":{\"claimMoney\":7958400,\"repairMoney\":2269000,\"claimCount\":8,\"repairCount\":42,\"renewCount\":34,\"renewMoney\":5689400}},\"reason\":\"success\",\"error_code\":0},\"resultMsg\":\"\u6267\u884c\u6210\u529f\",\"success\":true}","api_msg":"\u6267\u884c\u6210\u529f","api_code":"0"},$('#info_form'));</script>		
		
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
	<script type="text/javascript" src="./KJSTestCSS/index.js"></script>
	<script type="text/javascript" src="./KJSTestCSS/ui.js"></script>


<div id="__nightingale_view_cover" style="width: 100%; height: 100%; transition: -webkit-transform 10s ease-in-out; position: fixed !important; left: 0px !important; bottom: 0px !important; overflow: hidden !important; background: rgb(0, 0, 0) !important; pointer-events: none !important; z-index: 2147483647; opacity: 0.1;"></div></body></html>