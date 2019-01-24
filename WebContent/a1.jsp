<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- saved from url=(0108)http://a.kcway.net/assess/manager/index.php?type=assess&cn=assess_query_dr&nav=1&bc_status=0&do=form&id=6774 -->
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>快加认证-业务详情页</title>
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
	<!-- <div class="wrapper">
 -->
<script language="javascript">
$(document).ready(function(){
	var id=document.getElementById("uid").value;
	//alert(id);
	test();
	pdf();
function test() {
	  $.ajax({
		   type: "post",
		   dataType: "json",
		   url: "historylist.do",
		   data:{
			     uid : id			   
		   },
		   success: function(msg){
			    var result=msg;
			    str="";
			    $.each(result,function(index, n){
			    	   var zt=result[index].zt;
					   var ly=result[index].ly;
					   var htime=result[index].htime;
					   var time=htime.replace(".0"," ");
					   //alert(time);
			    str="状态:"+zt+" "+"留言:"+ly+" "+"时间:"+time+"\n"+str;
			    
			    }); 
		 document.getElementById("text").value =str;   
			   
		   }

	       })
	

//document.getElementById("text").value ="222222222";
}

function pdf() {
	  $.ajax({
		   type: "post",
		   dataType: "json",
		   url: "pdfend.do",
		   data:{
			     uid : id			   
		   },
		   success: function(msg){
			    var result=msg;
			    str="";
			    $.each(result,function(index, n){
			    	   var pdfname=result[index].pdfname;
			    str=pdfname;			    
			    }); 
   document.getElementById("links").href="http://apitest.kcway.net/image/upload/"+str;   
   document.getElementById("links1").href="http://apitest.kcway.net/image/upload/"+str;     
		   }
	  })
}


})
</script> 
		

<!-- <script>
$('li.active').parents('li').addClass('treeview').addClass('active');
</script> -->
<!-- <form id="info_form" action="http://a.kcway.net/assess/manager/index.php?type=assess&amp;cn=assess_query_dr&amp;nav=1&amp;bc_status=0&amp;do=form&amp;id=6774" class="form-horizontal" method="post" enctype="multipart/form-data" onsubmit="return check()">
		<input type="hidden" id="id" name="id" value="6774"> -->
		<!-- Content Wrapper. Contains page content -->
	<!-- <div class="content-wrapper fixed-footer" style="min-height: 847px;"> -->
		<!-- Main content -->
		<section class="content">
			
<script src="./acss/jQueryRotate.2.2.js" type="text/javascript"></script>
<div class="box-header with-border">
				<h1 class="box-title">相关审核</h1>
			</div>
 <div class="admin-content nav-tabs-custom box"> 
 	<div class="box-header with-border"> 
	<input type="hidden" name="adminop_tag" value="0">
 	<div class="box-body"> 
 	
			<div class="form-group">
				<label class="col-sm-2 control-label">审核材料(点击图片看大图)</label>
				<div class="col-sm-10">
					<div class="row inline-from">					
					 	   
					 	    <div class="col-sm-2">
							<a href="http://apitest.kcway.net/image/upload/${requestScope.map.front }" target="_blank"> 
							<img id="imgurl1" data-ri="0" data-src="" style="width: 100%;" src="./image/upload/${requestScope.map.front }">
							</a>
							<div class="col-sm-12">
								<a id="ashowpic0" href="http://apitest.kcway.net/image/upload/${requestScope.map.front }" target="_blank">查看</a>
								<a id="downpic" href="javascript:downpic(1);">下载</a>
							</div>
						    </div>		 			
						  
						    <div class="col-sm-2"> 
							<a href="http://apitest.kcway.net/image/upload/${requestScope.map.opposite }" target="_blank"> 
							<img id="imgurl2" data-ri="0" data-src="" style="width: 100%;" src="./image/upload/${requestScope.map.opposite }">
							</a>
							<div class="col-sm-12">
								<a id="ashowpic0" href="http://apitest.kcway.net/image/upload/${requestScope.map.opposite }" target="_blank">查看</a>
								<a id="downpic" href="javascript:downpic(2);">下载</a>
							</div>
						    </div>						
						   
						    <div class="col-sm-2">
							<a href="http://apitest.kcway.net/image/upload/${requestScope.map.apply }" target="_blank"> 
							<img id="imgurl3" data-ri="0" data-src="http://apitest.kcway.net/image/upload/${requestScope.map.apply }" style="width: 100%;" src="./image/upload/${requestScope.map.apply }"></a>
							<div class="col-sm-12">
								<a id="ashowpic0" href="http://apitest.kcway.net/image/upload/${requestScope.map.apply }" target="_blank">查看</a>
								<a id="downpic" href="javascript:downpic(3);">下载</a>
							</div>
						    </div>						
						   
						    <div class="col-sm-2">
							<a href="http://apitest.kcway.net/image/upload/${requestScope.map.authorize }" target="_blank"> 
							<img id="imgurl4" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 100%;" src="./image/upload/${requestScope.map.authorize }"></a>
							<div class="col-sm-12">
								<a id="ashowpic0" href="http://apitest.kcway.net/image/upload/${requestScope.map.authorize }" target="_blank">查看</a>
								<a id="downpic" href="javascript:downpic(4);">下载</a>
							</div>
						    </div>						
						
						<div class="col-sm-2">
							<a href="http://apitest.kcway.net/image/upload/${requestScope.map.hz }" target="_blank"> 
							<img id="imgurl5" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 100%;" src="./image/upload/${requestScope.map.hz }"></a>
							<div class="col-sm-12">
								<a id="ashowpic0" href="http://apitest.kcway.net/image/upload/${requestScope.map.hz }" target="_blank">查看</a>
								<a id="downpic" href="javascript:downpic(5);">下载</a>
							</div>
						</div>						
									
						</div>
				</div>
			</div>
			&nbsp;&nbsp;&nbsp;
	 	<div class="box-body"> 
				<div class="form-group">
					<label class="col-sm-2 control-label">API 身份查询结果：</label>
					<div class="col-sm-10">
						<textarea style="width: 100%; height: 50px" class="form-control" name="textvin" id="textvin"></textarea>
					</div>
				</div>
				&nbsp;&nbsp;&nbsp;
				<div class="form-group">
					<label class="col-sm-2 control-label">OCR身份证自动识别：</label>
					<div class="col-sm-10">
						<textarea style="width: 100%; height: 30px" class="form-control" name="textwz" id="textwz">OCR身份证识别</textarea>
					</div>
				</div>
				
				

			
		
			&nbsp;&nbsp;&nbsp;</br>
			&nbsp;&nbsp;&nbsp;</br>
		
			<div class="box-header with-border">
				<h3 class="box-title">征信查询处理</h3>
			</div>
			&nbsp;&nbsp;&nbsp;</br>
		   &nbsp;&nbsp;&nbsp;</br>
		
						<div class="form-group">
					<label class="col-sm-2 control-label">审核：</label>
					<div class="col-sm-10">
						<div class="row inline-from">
							<div class="col-sm-4">
									<div class="input-group">
										<span class="input-group-addon">审核状态</span> 
										<select name="bc_status" class="form-control" id="bc_status" onchange="autoremark();">
	                         			   <option value="1">草稿箱</option>
	                         			   <option selected="selected" value="2">正在查询</option>
	                         			   <option value="3">查询完成</option>
	                         			   <option value="4">回退</option>
	                         			   <option value="5">已撤销</option>	                            		
	                         			   </select>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="input-group">
										<span class="input-group-addon">授权书状态</span> 
										<select name="bc_status" class="form-control" id="bc_status" onchange="autoremark();">
	                         			   <option value="1">草稿箱</option>
	                         			   <option selected="selected" value="2">正在查询</option>
	                         			   <option value="3">查询完成</option>
	                         			   <option value="4">回退</option>
	                         			   <option value="5">已撤销</option>	                            		
	                         			   </select>
									</div>
								</div>
								<div class="col-sm-4">
									<div class="input-group">
										<span class="input-group-addon">查询类型</span> 
										<select name="bc_status" class="form-control" id="bc_status" onchange="autoremark();">
	                         			   <option value="1">草稿箱</option>
	                         			   <option selected="selected" value="2">正在查询</option>
	                         			   <option value="3">查询完成</option><option value="4">回退</option>
	                         			   <option value="5">已撤销</option>	                            		
	                         			   </select>
									</div>
								</div>
							
							
						</div>
					</div>
				</div>
				<!-- ************************************************ -->
						<div class="form-group">
				<label class="col-sm-2 control-label">查询结果(PDF)</label>
				<div class="col-sm-10">
					<div class="row inline-from">					
						<div class="col-sm-2">
							<a id="links" name="links" href="" target="_blank"> <img id="imgurl1" data-ri="0" data-src="" style="width: 100%;" src="./acss/logo.png"></a>
							<div class="col-sm-12">
								<a id="links1"  name="links1" href="" target="_blank">查看</a>
								<a id="downpic" href="javascript:downpic(1);">下载</a>
							</div>
						</div>						
									
						</div>
				</div>
			</div>
				<!-- ***************************************************** -->
						&nbsp;&nbsp;&nbsp;
						<div class="form-group">
					<label class="col-sm-2 control-label">留言备注说明：</label>
					<div class="col-sm-10">
						<div class="row inline-from">
						
							
							
							<div class="col-sm-4">
								<div class="input-group">
									<span class="input-group-addon">审核留言</span> <input style="width: 100%;  type="text" class="form-control" name="remark" id="remark" value="">
								</div>
							</div>
							 <div class="col-sm-4">
								<div class="input-group">
									 
								</div>
							</div> 
							<div class="col-sm-4">
								<div class="input-group">
									<span class="input-group-addon">常用留言快速通道</span> <select class="form-control" id="cyly" onchange="setremark(this)">
																			<option value="请选择">请选择</option>									<option value="查询完成，详情请点击订单详情页查看！">查询完成，详情请点击订单详情页查看！</option>									<option value="相关资料不完成或不够清晰！">相关资料不完成或不够清晰！</option>									<option value="图四应上传授权书，图五应上传无误的合照">图四应上传授权书，图五应上传无误的合照</option>									<option value="申请书与授权书日期不符，且授权书填写日期已过三天有效期">申请书与授权书日期不符，且授权书填写日期已过三天有效期</option>									<option value="上传的图片与上传的查询人信息不符">上传的图片与上传的查询人信息不符</option>									<option value="上传的图片与上传的名字信息不符。">上传的图片与上传的名字信息不符。</option>									<option value="图三图五申请书中“临柜”的柜字请书写清楚。">图三图五申请书中“临柜”的柜字请书写清楚。</option>									<option value="名字输入错误">名字输入错误</option>									<option value="图一、二编号与申请书不符。图五合照请手机横向拍摄">图一、二编号与申请书不符。图五合照请手机横向拍摄</option>									<option value="图五合照请不要闭眼拍摄">图五合照请不要闭眼拍摄</option>									<option value="图一、图二只需拍到身份证和申请书编码即可且图二需在申请书背景下拍摄，图五需手机横向拍摄，请重新拍摄上传。">图一、图二只需拍到身份证和申请书编码即可且图二需在申请书背景下拍摄，图五需手机横向拍摄，请重新拍摄上传。</option>									<option value="图1、2 中身份证请放在申请书上方拍摄。图三和图五中申请书办理业务处漏填。请重新拍摄上传。">图1、2 中身份证请放在申请书上方拍摄。图三和图五中申请书办理业务处漏填。请重新拍摄上传。</option>									<option value="通讯录未查询，划扣授权书未上传。近期客户频繁申请借款，属于高风险客户，请提供详细的面审资料。">通讯录未查询，划扣授权书未上传。近期客户频繁申请借款，属于高风险客户，请提供详细的面审资料。</option>									<option value="产权证、划扣授权书、视频未上传。">产权证、划扣授权书、视频未上传。</option>								</select>
								</div>
							</div> 
						</div>
					</div>
				</div>
				
				&nbsp;&nbsp;&nbsp;
				<div class="form-group">
					<label class="col-sm-2 control-label">历次审核事件和留言：</label>
					<div class="col-sm-10">
					<input type="hidden" id="uid" name="uid"  value="${requestScope.map.id }"/>
						<textarea id="text" name="text" style="width: 100%; height: 200px" class="form-control" readonly="">
										
					
						
						
						
                         </textarea>
					</div>
				</div>		
				<!-- ******************************************************************* -->
		
				
				<!-- ******************************************************************* -->
				</div>
		</div>
	</div>
</div>
		</section>
		
		 				<div class="footer-wrap">
			<div class="box-footer">
				<button type="button" class="btn btn-default" onclick="">取消返回</button>
				<button type="submit" class="btn btn-primary pull-right">保存提交</button> 
			</div>
		</div>
			
</body>

		<!-- Add the sidebar's background. This div must be placed
			 immediately after the control sidebar -->
		<div class="control-sidebar-bg" style="position: fixed; height: auto;"></div>
	</div><!-- ./wrapper -->
	

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
	
	<script type="text/javascript" src="./acss/index.js"></script>
	<script type="text/javascript" src="./acss/ui.js"></script>
	
