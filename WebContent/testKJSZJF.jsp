<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0088)http://a.kcway.net/assess/manager/index.php?type=assess&cn=assess_query_dr&do=list&nav=1 -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title></title>
	<!-- Tell the browser to be responsive to screen width -->
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	
	 <script type="text/javascript">
		var _rooturl = "http://a.kcway.net/assess/";
		var page_cn = "assess_query_dr";
		
	</script>
	
	<!-- Bootstrap 3.3.4 -->
	<link href="./acss/bootstrap.min.css" rel="stylesheet" type="text/css">
	<!-- Font Awesome Icons -->
	<!-- Font Awesome Icons -->
	<link href="./acss/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	<link href="./acss/select2.min.css" rel="stylesheet" type="text/css">
	
	
	<!-- Theme style -->
	<link href="./acss/AdminLTE.css" rel="stylesheet" type="text/css">
	<!-- AdminLTE Skins. We have chosen the skin-blue for this starter
			page. However, you can choose any other skin. Make sure you
			apply the skin class to the body tag so the changes take effect.
	-->
	<link href="./acss/skin-green.css" rel="stylesheet" type="text/css">
	<link href="./acss/style.css" rel="stylesheet" type="text/css">

	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		<script src="https://cdn.bootcss.com/html5shiv/r29/html5.min.js"></script>
		<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
	
	
	<!-- jQuery 2.1.4 -->
	<script src="./acss/jQuery-2.1.4.min.js" type="text/javascript"></script>
	<script src="./acss/common.js" type="text/javascript"></script>
	<script src="./acss/jquery.form.js" type="text/javascript"></script>
	<script src="./acss/ajaxfileupload.js" type="text/javascript"></script>
	<script type="text/javascript" src="./acss/php.js"></script>

	<!-- Bootstrap 3.3.2 JS -->
	<script src="./acss/bootstrap.min.js" type="text/javascript"></script>
	
	<script src="./acss/moment.js" type="text/javascript"></script>
	<script src="./acss/daterangepicker.js" type="text/javascript"></script>
	<link href="./acss/daterangepicker-bs3.css" rel="stylesheet" type="text/css">
	
	<script src="./acss/bootstrap-datepicker.js" type="text/javascript"></script>
	<link href="./acss/datepicker3.css" rel="stylesheet" type="text/css">
	<script src="./acss/bootstrap-datepicker.zh-CN.js" type="text/javascript"></script>
	
	<script src="./acss/bootstrap-datetimepicker.js" type="text/javascript"></script>
	<link href="./acss/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css">
	<script src="./acss/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
	
	
	<script type="text/javascript" charset="utf-8" src="./acss/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="./acss/ueditor.all.min.js"> </script>
	<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
	<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
	<script type="text/javascript" charset="utf-8" src="./acss/zh-cn.js"></script>
	
	
	
	<script src="./acss/select2.min.js" type="text/javascript"></script>
	<script src="./acss/zh-cn(1).js" type="text/javascript"></script>
	
		
	<!-- AdminLTE App -->
	<script src="./acss/app.min.js" type="text/javascript"></script>
	 
	<script src="./acss/combo.js" type="text/javascript"></script>
	<script src="./acss/imgup.js" type="text/javascript"></script>
	<link href="./acss/imgup.css" rel="stylesheet" type="text/css">
	<!-- <script src="/comm/jquery.dragsort-0.4.min.js" type="text/javascript"></script> -->
	
	<link href="./acss/iconfont.css" rel="stylesheet" type="text/css">
	<style>@font-face{font-family:uc-nexus-iconfont;src:url(chrome-extension://pogijhnlcfmcppgimcaccdkmbedjkmhi/res/font_9qmmi8b8jsxxbt9.woff) format('woff'),url(chrome-extension://pogijhnlcfmcppgimcaccdkmbedjkmhi/res/font_9qmmi8b8jsxxbt9.ttf) format('truetype')}</style></head>

	<body class="skin-green sidebar-mini fixed">

	


<script>
$('li.active').parents('li').addClass('treeview').addClass('active');
</script>	
<script type="text/javascript">
    function a3(){
		var s=$("#page_limit_select").val();
		if(s==10){
			window.location.href ="testKJSZJFTen.jsp";
		}else if(s>=20){
			window.location.href ="testKJSZJF.jsp";
		}
    }
</script>
		<section class="content-header">
			<h1>资金方
				<small>共20个</small>
			</h1>
		</section>

		<!-- Main content -->
		<section class="content">
			<input type="hidden" id="status" name="status" value="${requestScope.status}" >
			<div class="admin-tools">
				<div class="row">
				<div class="col-sm-7 admin-button">
					
					<!-- 增加删除按钮 --> 
					<div class="btn-group">
						<!-- <a href="" class="btn btn-default"><i class="fa fa-edit"></i> 导出</a>
						<a href="" class="btn btn-default" data-toggle="control-sidebar"><i class="fa fa-search"></i> 查询</a> -->
					</div> 
					</div>
					<div class="col-sm-5 admin-page-top hidden-xs">
								<select id="page_limit_select" onchange="a3()" class="form-control">
								                        <option value="10">每页显示条数</option>
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
														<a href="" class="btn btn-default">»</a>
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
			<th class="hidden-xs text-center" style="width:40px">编号</th>
			<th class="hidden-xs text-center" style="width:130px">资金方</th>
			<th class="hidden-xs text-center" style="width:80px">评分标准</th>
			<th class="hidden-xs text-center" style="width:80px">进件类型</th>
			<th class="hidden-xs text-center" style="width:80px">状态</th>
		</tr>
				
		<tr>
			<td class="text-center">1</td>
			<td class="text-center">点融</td>
			<td class="text-center">
				<select>
					<option>50</option>
					<option>60</option>
					<option>70</option>
					<option selected="selected">80</option>
					<option>90</option>
				</select>
			</td>
			<td class="text-center">
				<select>
					<option>押车</option>
					<option selected="selected">押证</option>
					<option>工行贷</option>
				</select>
			</td>
			<td class="text-center hidden-xs">   <!-- warning -->
				<span class="label label-success">已启用</span>
			</td>
	    </tr>
	    
	    <tr>
			<td class="text-center">2</td>
			<td class="text-center">挖财</td>
			<td class="text-center">
				<select>
					<option>50</option>
					<option>60</option>
					<option selected="selected">70</option>
					<option>80</option>
					<option>90</option>
				</select>
			</td>
			<td class="text-center">
				<select>
					<option selected="selected">押车</option>
					<option>押证</option>
					<option>工行贷</option>
				</select>
			</td>
			<td class="text-center hidden-xs">   <!-- warning -->
				<span class="label label-success">已启用</span>
			</td>
	    </tr>
	    
	    <tr>
			<td class="text-center">3</td>
			<td class="text-center">及时雨</td>
			<td class="text-center">
				<select>
					<option>50</option>
					<option>60</option>
					<option>70</option>
					<option>80</option>
					<option selected="selected">90</option>
				</select>
			</td>
			<td class="text-center">
				<select>
					<option>押车</option>
					<option>押证</option>
					<option  selected="selected">工行贷</option>
				</select>
			</td>
			<td class="text-center hidden-xs">   <!-- warning -->
				<span class="label label-success">已启用</span>
			</td>
	    </tr>
	    
	    <tr>
			<td class="text-center">4</td>
			<td class="text-center">金投行</td>
			<td class="text-center">
				<select>
					<option selected="selected">50</option>
					<option>60</option>
					<option>70</option>
					<option>80</option>
					<option>90</option>
				</select>
			</td>
			<td class="text-center">
				<select>
					<option selected="selected">押车</option>
					<option>押证</option>
					<option>工行贷</option>
				</select>
			</td>
			<td class="text-center hidden-xs">   <!-- warning -->
				<span class="label label-success">已启用</span>
			</td>
	    </tr>
	    
	    <tr>
			<td class="text-center">5</td>
			<td class="text-center">南金交</td>
			<td class="text-center">
				<select>
					<option>50</option>
					<option selected="selected">60</option>
					<option>70</option>
					<option>80</option>
					<option>90</option>
				</select>
			</td>
			<td class="text-center">
				<select>
					<option>押车</option>
					<option>押证</option>
					<option  selected="selected">工行贷</option>
				</select>
			</td>
			<td class="text-center hidden-xs">   <!-- warning -->
				<span class="label label-success">已启用</span>
			</td>
	    </tr>
	    
	    <tr>
			<td class="text-center">6</td>
			<td class="text-center">随手记</td>
			<td class="text-center">
				<select>
					<option  selected="selected">50</option>
					<option>60</option>
					<option>70</option>
					<option>80</option>
					<option>90</option>
				</select>
			</td>
			<td class="text-center">
				<select>
					<option>押车</option>
					<option>押证</option>
					<option selected="selected">工行贷</option>
				</select>
			</td>
			<td class="text-center hidden-xs">   <!-- warning -->
				<span class="label label-success">已启用</span>
			</td>
	    </tr>
	    <tr>
			<td class="text-center">7</td>
			<td class="text-center">杉易贷</td>
			<td class="text-center">
				<select>
					<option>50</option>
					<option selected="selected">60</option>
					<option >70</option>
					<option>80</option>
					<option>90</option>
				</select>
			</td>
			<td class="text-center">
				<select>
					<option>押车</option>
					<option >押证</option>
					<option selected="selected">工行贷</option>
				</select>
			</td>
			<td class="text-center hidden-xs">   <!-- warning -->
				<span class="label label-success">已启用</span>
			</td>
	    </tr>
	    <tr>
			<td class="text-center">8</td>
			<td class="text-center">搜易贷</td>
			<td class="text-center">
				<select>
					<option>50</option>
					<option selected="selected">60</option>
					<option >70</option>
					<option>80</option>
					<option>90</option>
				</select>
			</td>
			<td class="text-center">
				<select>
					<option>押车</option>
					<option selected="selected">押证</option>
					<option>工行贷</option>
				</select>
			</td>
			<td class="text-center hidden-xs">   <!-- warning -->
				<span class="label label-success">已启用</span>
			</td>
	    </tr>
	    <tr>
			<td class="text-center">9</td>
			<td class="text-center">铜板街</td>
			<td class="text-center">
				<select>
					<option>50</option>
					<option>60</option>
					<option >70</option>
					<option selected="selected">80</option>
					<option>90</option>
				</select>
			</td>
			<td class="text-center">
				<select>
					<option selected="selected">押车</option>
					<option >押证</option>
					<option>工行贷</option>
				</select>
			</td>
			<td class="text-center hidden-xs">   <!-- warning -->
				<span class="label label-success">已启用</span>
			</td>
	    </tr>
	    <tr>
			<td class="text-center">10</td>
			<td class="text-center">多盈金融</td>
			<td class="text-center">
				<select>
					<option>50</option>
					<option>60</option>
					<option selected="selected">70</option>
					<option>80</option>
					<option>90</option>
				</select>
			</td>
			<td class="text-center">
				<select>
					<option>押车</option>
					<option selected="selected">押证</option>
					<option>工行贷</option>
				</select>
			</td>
			<td class="text-center hidden-xs">   <!-- warning -->
				<span class="label label-success">已启用</span>
			</td>
	    </tr>
	    <tr>
			<td class="text-center">11</td>
			<td class="text-center">e路同心</td>
			<td class="text-center">
				<select>
					<option>50</option>
					<option>60</option>
					<option >70</option>
					<option>80</option>
					<option selected="selected">90</option>
				</select>
			</td>
			<td class="text-center">
				<select>
					<option>押车</option>
					<option >押证</option>
					<option selected="selected">工行贷</option>
				</select>
			</td>
			<td class="text-center hidden-xs">   <!-- warning -->
				<span class="label label-success">已启用</span>
			</td>
	    </tr>
	    <tr>
			<td class="text-center">12</td>
			<td class="text-center">凤凰金融</td>
			<td class="text-center">
				<select>
					<option>50</option>
					<option>60</option>
					<option >70</option>
					<option selected="selected">80</option>
					<option>90</option>
				</select>
			</td>
			<td class="text-center">
				<select>
					<option>押车</option>
					<option selected="selected">押证</option>
					<option>工行贷</option>
				</select>
			</td>
			<td class="text-center hidden-xs">   <!-- warning -->
				<span class="label label-success">已启用</span>
			</td>
	    </tr>
	    <tr>
			<td class="text-center">13</td>
			<td class="text-center">汇盈金融</td>
			<td class="text-center">
				<select>
					<option>50</option>
					<option>60</option>
					<option selected="selected">70</option>
					<option>80</option>
					<option>90</option>
				</select>
			</td>
			<td class="text-center">
				<select>
					<option selected="selected">押车</option>
					<option >押证</option>
					<option>工行贷</option>
				</select>
			</td>
			<td class="text-center hidden-xs">   <!-- warning -->
				<span class="label label-success">已启用</span>
			</td>
	    </tr>
	    <tr>
			<td class="text-center">14</td>
			<td class="text-center">海尔金融</td>
			<td class="text-center">
				<select>
					<option  selected="selected">50</option>
					<option>60</option>
					<option>70</option>
					<option>80</option>
					<option>90</option>
				</select>
			</td>
			<td class="text-center">
				<select>
					<option>押车</option>
					<option >押证</option>
					<option selected="selected">工行贷</option>
				</select>
			</td>
			<td class="text-center hidden-xs">   <!-- warning -->
				<span class="label label-success">已启用</span>
			</td>
	    </tr>
	    <tr>
			<td class="text-center">15</td>
			<td class="text-center">海尔小贷</td>
			<td class="text-center">
				<select>
					<option>50</option>
					<option selected="selected">60</option>
					<option >70</option>
					<option>80</option>
					<option>90</option>
				</select>
			</td>
			<td class="text-center">
				<select>
					<option>押车</option>
					<option selected="selected">押证</option>
					<option>工行贷</option>
				</select>
			</td>
			<td class="text-center hidden-xs">   <!-- warning -->
				<span class="label label-success">已启用</span>
			</td>
	    </tr>
	    <tr>
			<td class="text-center">16</td>
			<td class="text-center">空中金融</td>
			<td class="text-center">
				<select>
					<option>50</option>
					<option>60</option>
					<option >70</option>
					<option selected="selected">80</option>
					<option>90</option>
				</select>
			</td>
			<td class="text-center">
				<select>
					<option>押车</option>
					<option selected="selected">押证</option>
					<option>工行贷</option>
				</select>
			</td>
			<td class="text-center hidden-xs">   <!-- warning -->
				<span class="label label-success">已启用</span>
			</td>
	    </tr>
	    <tr>
			<td class="text-center">17</td>
			<td class="text-center">利得金融</td>
			<td class="text-center">
				<select>
					<option>50</option>
					<option selected="selected">60</option>
					<option >70</option>
					<option>80</option>
					<option>90</option>
				</select>
			</td>
			<td class="text-center">
				<select>
					<option>押车</option>
					<option >押证</option>
					<option selected="selected">工行贷</option>
				</select>
			</td>
			<td class="text-center hidden-xs">   <!-- warning -->
				<span class="label label-success">已启用</span>
			</td>
	    </tr>
	    <tr>
			<td class="text-center">18</td>
			<td class="text-center">苏宁金融</td>
			<td class="text-center">
				<select>
					<option>50</option>
					<option>60</option>
					<option >70</option>
					<option>80</option>
					<option selected="selected">90</option>
				</select>
			</td>
			<td class="text-center">
				<select>
					<option>押车</option>
					<option selected="selected">押证</option>
					<option>工行贷</option>
				</select>
			</td>
			<td class="text-center hidden-xs">   <!-- warning -->
				<span class="label label-success">已启用</span>
			</td>
	    </tr>
	    <tr>
			<td class="text-center">19</td>
			<td class="text-center">泰融银行</td>
			<td class="text-center">
				<select>
					<option>50</option>
					<option>60</option>
					<option selected="selected">70</option>
					<option>80</option>
					<option>90</option>
				</select>
			</td>
			<td class="text-center">
				<select>
					<option>押车</option>
					<option selected="selected">押证</option>
					<option>工行贷</option>
				</select>
			</td>
			<td class="text-center hidden-xs">   <!-- warning -->
				<span class="label label-success">已启用</span>
			</td>
	    </tr>
	    <tr>
			<td class="text-center">20</td>
			<td class="text-center">众邦银行</td>
			<td class="text-center">
				<select>
					<option>50</option>
					<option>60</option>
					<option >70</option>
					<option selected="selected">80</option>
					<option>90</option>
				</select>
			</td>
			<td class="text-center">
				<select>
					<option selected="selected">押车</option>
					<option >押证</option>
					<option>工行贷</option>
				</select>
			</td>
			<td class="text-center hidden-xs">   <!-- warning -->
				<span class="label label-success">已启用</span>
			</td>
	    </tr>
	    
	</tbody>
</table>
			</div>
	<div class="foot-page">
			<!-- 分页 -->
			<ul class="pagination no-margin">
				       <li class="active">
					       <a href="#">
					       <span >1</span>
					       </a>
				       </li>
		   	</ul>
		 <div class="page-num">共20个 分1页显示</div>
	</div>
	</section><!-- /.content -->
    <script type="text/javascript" src="./acss/list.js"></script>		
	
<!--弹窗框体开始-->
	<div class="modal fade" id="modal" role="dialog" data-backdrop="static" aria-hidden="true" style="display: none;">
		<div class="modal-dialog" role="document" style="width: 830px;">
		<div id="mycontent" class="modal-content">
		<div id="float_page_div">
	          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
            <h4 class="modal-title" id="myModalLabel">编辑银联代收付系统信息</h4>
          </div>
          <div class="modal-body">
          	<form class="form-horizontal" id="float_form" action="http://a.kcway.net/assess/manager/command.php?do=add&amp;cn=yl_ds&amp;id=" method="post">
          		<div class="box-body">
	<div class="modal-header">
		<h4 class="modal-title" id="myModalLabel">已有<font color="green">代收</font>记录</h4>
	</div>
	<div class="modal-body form-horizontal">
		<ul class="nav nav-pills nav-stacked">
								<li style="padding-bottom: 10px"><i class="fa fa-circle-o" style="color: green"></i>暂无记录<span class="pull-right">暂无<font color="green">代收</font>记录</span></li>		</ul>
	</div>
	<div class="modal-header">
		<h4 class="modal-title" id="myModalLabel">新建<font color="green">代收</font></h4>
	</div>
	<input type="hidden" name="qryid" value="15"> <input type="hidden" name="type" value="">
<input type="hidden" name="gems_fs_id" value="">
<input type="hidden" name="bank_id" value="3">
<input type="hidden" name="ds_type" value="0">
<input type="hidden" name="c_name" value="">
<input type="hidden" name="c_cardno" value="">
<input type="hidden" name="sms_tel" value="">
	<div class="form-group" style="padding-top: 25px">
		<label for="title2" class="col-sm-3 control-label">签约银联卡:</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" id="bt" value="-" disabled="">
		</div>
	</div>
	<div class="form-group">
		<label for="title2" class="col-sm-3 control-label"><font color="green">代收</font>金额(分):</label>
		<div class="col-sm-9">
			<input type="number" class="form-control" name="AMOUNT" id="AMOUNT" placeholder="输入代收金额,单位(分)" value="0">
		</div>
	</div>	<div class="form-group">
		<label for="title2" class="col-sm-3 control-label">备注(可不填)</label>
		<div class="col-sm-3">
			<input type="text" class="form-control" name="remark" placeholder="比如:正常代收" value="">
		</div>
		<div class="col-sm-6">
		<div class="input-group">
										<span class="input-group-addon">短信通知用户</span> <select name="sendsms" class="form-control" id="sendsms">
											<option value="1">是</option><option selected="selected" value="0">否</option>	                            		</select>
		</div>
		</div>
	</div>
</div>
<script type="text/javascript">
<!--
//-->
/* $(function(){
	$("#float_form").attr("onsubmit","return check()"); 
}); */
function fmoney(s, n)   
{   
   n = n > 0 && n <= 20 ? n : 2;   
   s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";   
   var l = s.split(".")[0].split("").reverse(),   
   r = s.split(".")[1];   
   t = "";   
   for(i = 0; i < l.length; i ++ )   
   {   
      t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");   
   }   
   return t.split("").reverse().join("") + "." + r;   
} 

function float_form_check(){
	var nam = $("#AMOUNT").val();
	if (nam <=100){
			alert("金额不对,至少100分!");
			$("#AMOUNT").focus();
			return false;
	}
	var xm = fmoney($("#AMOUNT").val()/100/10000,2)+'】万元';
	var checkText=$("#bt").val()+"【代收】金额【"+xm; 
	if (!confirm('确定给'+checkText+'吗？')){
			return false;
	}
	return true;
} 
function float_submit_succ(){
	$("#modal").modal("hide");
	alert('新建代收成功!');
}
</script>
          	</form>
          </div>
          
          <div class="modal-footer">
            <button type="button" class="btn btn-default pull-left" data-dismiss="modal" aria-label="Close">取消返回</button>
            <button type="submit" class="btn btn-danger" onclick="$(&#39;#float_form&#39;).submit()">保存提交</button>
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
<!-- 弹窗框体结束-->
	<script>
		$('#modal').on('hidden.bs.modal', function (e) {
			$(this).removeData("bs.modal");
	})
	</script>
	
	<script type="text/javascript" src="./acss/index.js"></script>
	<script type="text/javascript" src="./acss/ui.js"></script>
	

<div class="daterangepicker dropdown-menu show-calendar opensright" style="top: 156px; left: 1394px; right: auto;"><div class="calendar first right"><div class="calendar-date"><table class="table-condensed"><thead><tr><th></th><th colspan="5" class="month">八月 2017</th><th class="next available"><i class="fa fa-arrow-right icon icon-arrow-right glyphicon glyphicon-arrow-right"></i></th></tr><tr><th>日</th><th>一</th><th>二</th><th>三</th><th>四</th><th>五</th><th>六</th></tr></thead><tbody><tr><td class="off disabled" data-title="r0c0">30</td><td class="off disabled" data-title="r0c1">31</td><td class="off disabled" data-title="r0c2">1</td><td class="off disabled" data-title="r0c3">2</td><td class="off disabled" data-title="r0c4">3</td><td class="off disabled" data-title="r0c5">4</td><td class="off disabled" data-title="r0c6">5</td></tr><tr><td class="off disabled" data-title="r1c0">6</td><td class="off disabled" data-title="r1c1">7</td><td class="off disabled" data-title="r1c2">8</td><td class="off disabled" data-title="r1c3">9</td><td class="off disabled" data-title="r1c4">10</td><td class="off disabled" data-title="r1c5">11</td><td class="off disabled" data-title="r1c6">12</td></tr><tr><td class="off disabled" data-title="r2c0">13</td><td class="off disabled" data-title="r2c1">14</td><td class="off disabled" data-title="r2c2">15</td><td class="off disabled" data-title="r2c3">16</td><td class="off disabled" data-title="r2c4">17</td><td class="off disabled" data-title="r2c5">18</td><td class="off disabled" data-title="r2c6">19</td></tr><tr><td class="off disabled" data-title="r3c0">20</td><td class="off disabled" data-title="r3c1">21</td><td class="off disabled" data-title="r3c2">22</td><td class="off disabled" data-title="r3c3">23</td><td class="off disabled" data-title="r3c4">24</td><td class="off disabled" data-title="r3c5">25</td><td class="off disabled" data-title="r3c6">26</td></tr><tr><td class="off disabled" data-title="r4c0">27</td><td class="off disabled" data-title="r4c1">28</td><td class="off disabled" data-title="r4c2">29</td><td class="available active start-date end-date" data-title="r4c3">30</td><td class="available" data-title="r4c4">31</td><td class="available off" data-title="r4c5">1</td><td class="available off" data-title="r4c6">2</td></tr><tr><td class="available off" data-title="r5c0">3</td><td class="available off" data-title="r5c1">4</td><td class="available off" data-title="r5c2">5</td><td class="available off" data-title="r5c3">6</td><td class="available off" data-title="r5c4">7</td><td class="available off" data-title="r5c5">8</td><td class="available off" data-title="r5c6">9</td></tr></tbody></table></div></div><div class="calendar second left"><div class="calendar-date"><table class="table-condensed"><thead><tr><th class="prev available"><i class="fa fa-arrow-left icon icon-arrow-left glyphicon glyphicon-arrow-left"></i></th><th colspan="5" class="month">八月 2017</th><th class="next available"><i class="fa fa-arrow-right icon icon-arrow-right glyphicon glyphicon-arrow-right"></i></th></tr><tr><th>日</th><th>一</th><th>二</th><th>三</th><th>四</th><th>五</th><th>六</th></tr></thead><tbody><tr><td class="available off" data-title="r0c0">30</td><td class="available off" data-title="r0c1">31</td><td class="available" data-title="r0c2">1</td><td class="available" data-title="r0c3">2</td><td class="available" data-title="r0c4">3</td><td class="available" data-title="r0c5">4</td><td class="available" data-title="r0c6">5</td></tr><tr><td class="available" data-title="r1c0">6</td><td class="available" data-title="r1c1">7</td><td class="available" data-title="r1c2">8</td><td class="available" data-title="r1c3">9</td><td class="available" data-title="r1c4">10</td><td class="available" data-title="r1c5">11</td><td class="available" data-title="r1c6">12</td></tr><tr><td class="available" data-title="r2c0">13</td><td class="available" data-title="r2c1">14</td><td class="available" data-title="r2c2">15</td><td class="available" data-title="r2c3">16</td><td class="available" data-title="r2c4">17</td><td class="available" data-title="r2c5">18</td><td class="available" data-title="r2c6">19</td></tr><tr><td class="available" data-title="r3c0">20</td><td class="available" data-title="r3c1">21</td><td class="available" data-title="r3c2">22</td><td class="available" data-title="r3c3">23</td><td class="available" data-title="r3c4">24</td><td class="available" data-title="r3c5">25</td><td class="available" data-title="r3c6">26</td></tr><tr><td class="available" data-title="r4c0">27</td><td class="available" data-title="r4c1">28</td><td class="available" data-title="r4c2">29</td><td class="available active start-date end-date" data-title="r4c3">30</td><td class="available" data-title="r4c4">31</td><td class="available off" data-title="r4c5">1</td><td class="available off" data-title="r4c6">2</td></tr><tr><td class="available off" data-title="r5c0">3</td><td class="available off" data-title="r5c1">4</td><td class="available off" data-title="r5c2">5</td><td class="available off" data-title="r5c3">6</td><td class="available off" data-title="r5c4">7</td><td class="available off" data-title="r5c5">8</td><td class="available off" data-title="r5c6">9</td></tr></tbody></table></div></div><div class="ranges"><div class="range_inputs"><div class="daterangepicker_start_input"><label for="daterangepicker_start">开始</label><input class="input-mini" type="text" name="daterangepicker_start" value=""></div><div class="daterangepicker_end_input"><label for="daterangepicker_end">结束</label><input class="input-mini" type="text" name="daterangepicker_end" value=""></div><button class="applyBtn btn btn-small btn-sm btn-success">确定</button>&nbsp;<button class="cancelBtn btn btn-small btn-sm btn-default">取消</button></div></div></div></body></html>