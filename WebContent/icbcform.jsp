<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
    
<!DOCTYPE html>
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
		var page_cn = "kj_icbc";
	</script>
	
	<!-- Bootstrap 3.3.4 -->
	<link href="icbc_cs_js/bootstrap_002.css" rel="stylesheet" type="text/css">
	<!-- Font Awesome Icons -->
	<!-- Font Awesome Icons -->
	<link href="icbc_cs_js/font-awesome.css" rel="stylesheet" type="text/css">
	
	<link href="icbc_cs_js/select2.css" rel="stylesheet" type="text/css">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Theme style -->
	<link href="icbc_cs_js/AdminLTE.css" rel="stylesheet" type="text/css">
	<!-- AdminLTE Skins. We have chosen the skin-blue for this starter
			page. However, you can choose any other skin. Make sure you
			apply the skin class to the body tag so the changes take effect.
	-->
	<link href="icbc_cs_js/skin-green.css" rel="stylesheet" type="text/css">
	<link href="icbc_cs_js/style.css" rel="stylesheet" type="text/css">

	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		<script src="https://cdn.bootcss.com/html5shiv/r29/html5.min.js"></script>
		<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
	
<style type="text/css">

.footer-wrap{ position: fixed;width: 100%; bottom: 0;z-index: 1000;}
.footer-wrap.box-footer{margin-right: 200px; border-top-color: #d2d6de;}
@media (max-width: 767px) {
.footer-wrap.box-footer {
      margin-right: 0;
  }
}
 
    </style>
	<!-- jQuery 2.1.4 -->
	<script src="icbc_cs_js/jQuery-2.js" type="text/javascript"></script>
	<script src="icbc_cs_js/common.js" type="text/javascript"></script>
	<script src="icbc_cs_js/jquery_002.js" type="text/javascript"></script>
	<script src="icbc_cs_js/ajaxfileupload.js" type="text/javascript"></script>
	<script type="text/javascript" src="icbc_cs_js/php.js"></script>

	<!-- Bootstrap 3.3.2 JS -->
	<script src="icbc_cs_js/bootstrap.js" type="text/javascript"></script>
	
	<script src="icbc_cs_js/moment.js" type="text/javascript"></script>
	<script src="icbc_cs_js/daterangepicker.js" type="text/javascript"></script>
	<link href="icbc_cs_js/daterangepicker-bs3.css" rel="stylesheet" type="text/css">
	
	<script src="icbc_cs_js/bootstrap-datepicker.js" type="text/javascript"></script>
	<link href="icbc_cs_js/datepicker3.css" rel="stylesheet" type="text/css">
	<script src="icbc_cs_js/bootstrap-datepicker_002.js" type="text/javascript"></script>
	
	<script src="icbc_cs_js/bootstrap-datetimepicker.js" type="text/javascript"></script>
	<link href="icbc_cs_js/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css">
	<script src="icbc_cs_js/bootstrap-datetimepicker_002.js" type="text/javascript"></script>
	
	
	<script type="text/javascript" charset="utf-8" src="icbc_cs_js/ueditor_002.js"></script>
	<script type="text/javascript" charset="utf-8" src="icbc_cs_js/ueditor.js"> </script>
	<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
	<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
	<script type="text/javascript" charset="utf-8" src="icbc_cs_js/zh-cn.js"></script>
	
	
	
	<script src="icbc_cs_js/select2.js" type="text/javascript"></script>
	<script src="icbc_cs_js/zh-CN.js" type="text/javascript"></script>
	
		
	<!-- AdminLTE App -->
	<script src="icbc_cs_js/app.js" type="text/javascript"></script>
	 
	<script src="icbc_cs_js/combo.js" type="text/javascript"></script>
	<script src="icbc_cs_js/imgup.js" type="text/javascript"></script>
	<link href="icbc_cs_js/imgup.css" rel="stylesheet" type="text/css">
	<!-- <script src="/comm/jquery.dragsort-0.4.min.js" type="text/javascript"></script> -->
	<style type="text/css">
	.navcss{
	width:100%;
	height:30px;
	position:fixed;
	top:0;
	left:0;
	
	}
	</style>
	<link href="icbc_cs_js/iconfont.css" rel="stylesheet" type="text/css">
	</head>
<body class="skin-green sidebar-mini fixed">
<script>
$('li.active').parents('li').addClass('treeview').addClass('active');
</script>
<form id="info_form" action="savetj.do" class="form-horizontal" method="post" enctype="multipart/form-data" onsubmit="return check()">
<input id="bc_status1" name="bc_status1" value="${requestScope.bc_status }" type="hidden">
<input id="id" name="id" value="${icbc.id }" type="hidden">
		<!-- Main content -->
<section class="content">			
<link rel="stylesheet" href="icbc_cs_js/bootstrap.css" />
<script src="icbc_cs_js/jquery.js"></script>
<script src="icbc_cs_js/bootstrap_002.js"></script>
<script src="icbc_cs_js/jQueryRotate.js" type="text/javascript"></script>
<div class="admin-content nav-tabs-custom box">
	<div class="box-header with-border">
		<div class="box-header with-border">
			<h3 class="box-title">相关图片材料</h3> 
			<a href="icbcdownload.do?id=${icbc.id }" class="btn btn-success" style="margin-left: 5px">一键下载所有图片</a>
	    </div>
		<ul id="myTab" class="nav nav-tabs">
			<li class="active"><a href="#tbstep2" data-toggle="tab" aria-expanded="true">征信</a></li>
			<li class=""><a href="#tbstep3" data-toggle="tab" aria-expanded="false">评估</a></li>
			<li class=""><a href="#tbstep4" data-toggle="tab" aria-expanded="false">开卡</a></li>
			<li class=""><a href="#tbstep5" data-toggle="tab" aria-expanded="false">贷款</a></li>
			<li class=""><a href="#tbstep6" data-toggle="tab" aria-expanded="false">视频</a></li>
			<li class=""><a href="#tbstep6" data-toggle="tab" aria-expanded="false">资金</a></li>
	   </ul>	   
	<div id="myTabContent" class="tab-content">
	        <!-- 征信开始 -->
			<div class="tab-pane fade active in" id="tbstep2">
			<div class="box-body">
	进件审核 来自：${requestScope.gname }-${requestScope.pname }-${fn:substring(requestScope.icbc.dt_add, 0,19)} 合同编码：${requestScope.icbc.gems_code }		
	<div class="box-body">
			
	</div>
	<div class="box-header with-border">
	<h3 class="box-title">用户提交信息</h3>
    </div>
			<div class="form-group">
				<div class="col-sm-10">
					<div class="row inline-from">
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">借款人姓名</span> <input class="form-control" name="c_name" id="c_name" value="${icbc.c_name }" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">借款人身份证</span> <input class="form-control" name="c_cardno" id="c_cardno" value="${icbc.c_cardno }" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">借款人电话</span>
							 <input class="form-control" name="c_tel" id="c_tel" value="${icbc.c_tel }" type="text">
							 </div>
					</div>
					<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">借款人性别</span> 
							<select class="form-control">
							<option value="">男</option>
							<option value="">女</option>
							</select>
							
							</div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">配偶姓名</span> <input class="form-control" name="c_name_mts[]" id="c_name_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">配偶身份证</span> <input class="form-control" name="c_cardno_mts[]" id="c_cardno_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">配偶手机</span> <input class="form-control" name="c_tel_mts[]" id="c_tel_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">共同还款人姓名</span> <input class="form-control" name="c_name_mts[]" id="c_name_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">共同还款人身份证</span> <input class="form-control" name="c_cardno_mts[]" id="c_cardno_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">共同还款人手机</span> <input class="form-control" name="c_tel_mts[]" id="c_tel_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
				</div>
			</div>
			</div>
	<div class="box-header with-border">
	<h3 class="box-title">征信图片</h3>
    </div>		
	<div class="form-group">
		<div class="col-sm-12">
			<div class="row inline-from">
			<% int i=1; %>
			<c:forEach var="zximg" items="${requestScope.zxlist1 }">
			<div class="col-sm-2" style="width: 20%; position: static">
					<div class="input-group">
					<div class="badge" style="position: absolute; bottom: 20px; right: 10px;">${zximg.imgsize}MB</div>
					<a style="padding: 5px 5px;" class="btn btn-default" id="ashowpic1" href="${zximg.path}" target="_blank"> 
					
					<img id="zx<%=i %>" name="zx<%=i %>" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 220px; height: 150px;" src="${zximg.path}">
				    </a>
				  </div>
			</div> 	
			<%i++; %>
			</c:forEach>
																
		   </div>
		</div>
	</div>
	<div class="box-header with-border">
	<h3 class="box-title">审核和数据填充处理</h3>
     </div>
	<div class="form-group">
	<label class="col-sm-2 control-label">审核：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
				<div class="col-sm-6">
					<div class="input-group"><span class="input-group-addon">审核状态</span> 
					<select name="bc_status" class="form-control" id="bc_status" onchange="autoremark();">
                            	<option value="3">初审通过，请补件</option>
                            	<option value="7">回退</option>
                            	<option value="5">完成-通过</option>
                            	<option value="6">完成-失败</option>                           
                            	</select>
                            	</div>
			</div>
				<div class="col-sm-6">
					<div class="input-group">
					<span class="input-group-addon">类型</span> 
					<input class="form-control" readonly="readonly" value="征信" type="text">
					</div>
			</div>
		</div>
	</div>
	</div>
		<div class="form-group">
		<label class="col-sm-2 control-label">留言备注说明：</label>
			<div class="col-sm-10">
				<div class="row inline-from">
					<div class="col-sm-8">
						<div class="input-group">
						<span class="input-group-addon">审核留言</span> 
						<input class="form-control" name="remark" id="remark" type="text">
						</div>
				</div>
					<div class="col-sm-4">
						<div class="input-group">
						<span class="input-group-addon">留言快速通道</span> 
						<select class="form-control" id="cyly" onchange="setremark(this)">
												<option value="请选择" selected="selected">请选择</option>						
												<option value="查询完成，详情请点击历史查询-&gt;已完成-&gt;查看订单！">查询完成，详情请点击历史查询-&gt;已完成-&gt;查看订单！</option>						
												<option value="恭喜您初审通过,请点编辑按钮,按提示上传其他补充材料！">恭喜您初审通过,请点编辑按钮,按提示上传其他补充材料！</option>						
												<option value="请拍摄驾驶证详细资料，请将保险单拍摄完整">请拍摄驾驶证详细资料，请将保险单拍摄完整</option>						
												<option value="请拍摄行驶证和驾驶证详细资料">请拍摄行驶证和驾驶证详细资料</option>						
												<option value="过于模糊">过于模糊</option>						
												<option value="过于模糊，无非识别">过于模糊，无非识别</option>						
												<option value="上传材料错误">上传材料错误</option>						
												<option value="该车况整体良好，品牌车型受市场欢迎度较低。">该车况整体良好，品牌车型受市场欢迎度较低。</option>						
												<option value="行驶证、驾驶证拍摄不清晰">行驶证、驾驶证拍摄不清晰</option>						
						</select>
												</div>
				</div>
			</div>
		</div></div>
	<div class="form-group">
	<label class="col-sm-2 control-label">征信结果返回：</label>
		<div class="col-sm-10">
		<textarea style="width: 100%; height: 120px"  name="zx_result" class="form-control">
		${icbc.zx_result  }
		</textarea></div></div>
	<div class="form-group">
	<label class="col-sm-2 control-label">历次审核事件和留言：</label>
		<div class="col-sm-10">
<textarea style="width: 100%; height: 150px" class="form-control" readonly="readonly">
<c:forEach items="${requestScope.irl }" var="irl">${fn:substring(irl.dt_add, 0,19)}:状态：<c:if test="${irl.status eq '1' }">草稿箱</c:if><c:if test="${irl.status eq '2' }">提交等待</c:if><c:if test="${irl.status eq '3' }">初审通过，请补件</c:if><c:if test="${irl.status eq '4' }">回退</c:if><c:if test="${irl.status eq '5' }">补件完成，提交审核</c:if><c:if test="${irl.status eq '6' }">完成-通过</c:if><c:if test="${irl.status eq '7' }">完成-失败</c:if>,留言：${irl.remark }
</c:forEach>
</textarea>
</div></div>
</div>	
		</div>
		<!-- 征信结束 -->
		<!-- 评估开始 -->
			<div class="tab-pane fade" id="tbstep3">
				<div class="box-body">
	进件审核 来自：${requestScope.gname }-${requestScope.pname }-${fn:substring(requestScope.icbc.dt_add, 0,19)} 合同编码：${requestScope.icbc.gems_code }		
	<div class="box-body">
			
	</div>
	<div class="box-header with-border">
	<h3 class="box-title">用户提交信息</h3>
    </div>
			<div class="form-group">
				<div class="col-sm-10">
					<div class="row inline-from">
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">车辆行驶里程</span> <input class="form-control" name="c_name" id="c_name" value="${icbc.c_name }" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">车身颜色</span> <input class="form-control" name="c_cardno" id="c_cardno" value="${icbc.c_cardno }" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">车型</span> <input class="form-control" name="c_tel" id="c_tel" value="${icbc.c_tel }" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">上牌年</span> <input class="form-control" name="c_name_mts[]" id="c_name_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">上牌月</span> <input class="form-control" name="c_cardno_mts[]" id="c_cardno_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">所在省</span> <input class="form-control" name="c_tel_mts[]" id="c_tel_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">所在市</span> <input class="form-control" name="c_name_mts[]" id="c_name_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">VIN</span> <input class="form-control" name="c_cardno_mts[]" id="c_cardno_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>					
				</div>
			</div>
			</div>
	<div class="box-header with-border">
	<h3 class="box-title">快速评估资料</h3>
    </div>							
	<div class="form-group">
		<div class="col-sm-12">
			<div class="row inline-from">
			<% int o=1; %>
			<c:forEach var="kk" items="${requestScope.kklist1 }">
			<div class="col-sm-2" style="width: 20%; position: static">
					<div class="input-group">
						<div class="badge" style="position: absolute; bottom: 20px; right: 10px;">${kk.imgsize }MB</div>
						<a style="padding: 5px 5px;" class="btn btn-default" id="ashowpic1" href="${kk.path }" target="_blank"> 
						<img id="kk<%=o %>" name="result_imgurl1_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 220px; height: 150px;" src="${kk.path }">
					</a>
					</div>
			</div> 
			<%o++; %>
            </c:forEach>
													
			</div>
		</div>
	</div>
		<div class="box-header with-border">
	<h3 class="box-title">专业评估资料</h3>
    </div>							
	<div class="form-group">
		<div class="col-sm-12">
			<div class="row inline-from">
			<% int o1=1; %>
			<c:forEach var="kk" items="${requestScope.kklist1 }">
			<div class="col-sm-2" style="width: 20%; position: static">
					<div class="input-group">
						<div class="badge" style="position: absolute; bottom: 20px; right: 10px;">${kk.imgsize }MB</div>
						<a style="padding: 5px 5px;" class="btn btn-default" id="ashowpic1" href="${kk.path }" target="_blank"> 
						<img id="kk<%=o1 %>" name="result_imgurl1_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 220px; height: 150px;" src="${kk.path }">
					</a>
					</div>
			</div> 
			<%o1++; %>
            </c:forEach>
													
			</div>
		</div>
	</div>
		<div class="box-header with-border">
	<h3 class="box-title">审核和数据填充处理</h3>
     </div>
	<div class="form-group">
	<label class="col-sm-2 control-label">审核：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
				<div class="col-sm-6">
					<div class="input-group"><span class="input-group-addon">审核状态</span> 
					<select name="bc_status" class="form-control" id="bc_status" onchange="autoremark();">
                            	<option value="3">初审通过，请补件</option>
                            	<option value="7">回退</option>
                            	<option value="5">完成-通过</option>
                            	<option value="6">完成-失败</option>                           
                            	</select>
                            	</div>
			</div>
				<div class="col-sm-6">
					<div class="input-group">
					<span class="input-group-addon">类型</span> 
					<input class="form-control" readonly="readonly" value="评估" type="text">
					</div>
			</div>
		</div>
	</div>
	</div>
		<div class="form-group">
		<label class="col-sm-2 control-label">留言备注说明：</label>
			<div class="col-sm-10">
				<div class="row inline-from">
					<div class="col-sm-8">
						<div class="input-group">
						<span class="input-group-addon">审核留言</span> 
						<input class="form-control" name="remark" id="remark" type="text">
						</div>
				</div>
					<div class="col-sm-4">
						<div class="input-group">
						<span class="input-group-addon">留言快速通道</span> 
						<select class="form-control" id="cyly" onchange="setremark(this)">
												<option value="请选择" selected="selected">请选择</option>						
												<option value="查询完成，详情请点击历史查询-&gt;已完成-&gt;查看订单！">查询完成，详情请点击历史查询-&gt;已完成-&gt;查看订单！</option>						
												<option value="恭喜您初审通过,请点编辑按钮,按提示上传其他补充材料！">恭喜您初审通过,请点编辑按钮,按提示上传其他补充材料！</option>						
												<option value="请拍摄驾驶证详细资料，请将保险单拍摄完整">请拍摄驾驶证详细资料，请将保险单拍摄完整</option>						
												<option value="请拍摄行驶证和驾驶证详细资料">请拍摄行驶证和驾驶证详细资料</option>						
												<option value="过于模糊">过于模糊</option>						
												<option value="过于模糊，无非识别">过于模糊，无非识别</option>						
												<option value="上传材料错误">上传材料错误</option>						
												<option value="该车况整体良好，品牌车型受市场欢迎度较低。">该车况整体良好，品牌车型受市场欢迎度较低。</option>						
												<option value="行驶证、驾驶证拍摄不清晰">行驶证、驾驶证拍摄不清晰</option>						
						</select>
												</div>
				</div>
			</div>
		</div></div>
	<div class="form-group">
	<label class="col-sm-2 control-label">历次审核事件和留言：</label>
		<div class="col-sm-10">
<textarea style="width: 100%; height: 150px" class="form-control" readonly="readonly">
<c:forEach items="${requestScope.irl }" var="irl">${fn:substring(irl.dt_add, 0,19)}:状态：<c:if test="${irl.status eq '1' }">草稿箱</c:if><c:if test="${irl.status eq '2' }">提交等待</c:if><c:if test="${irl.status eq '3' }">初审通过，请补件</c:if><c:if test="${irl.status eq '4' }">回退</c:if><c:if test="${irl.status eq '5' }">补件完成，提交审核</c:if><c:if test="${irl.status eq '6' }">完成-通过</c:if><c:if test="${irl.status eq '7' }">完成-失败</c:if>,留言：${irl.remark }
</c:forEach>
</textarea>
</div></div>
</div>	
		</div>
		 <!-- 评估结束-->
		 <!-- 开卡开始 -->
			<div class="tab-pane fade" id="tbstep4">
			<div class="box-body">
				进件审核 来自：${requestScope.gname }-${requestScope.pname }-${fn:substring(requestScope.icbc.dt_add, 0,19)} 合同编码：${requestScope.icbc.gems_code }		
	<div class="box-body">
			
	</div>
	<div class="box-header with-border">
	<h3 class="box-title">用户提交信息</h3>
    </div>
			<div class="form-group">
				<div class="col-sm-10">
					<div class="row inline-from">
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">姓名</span> <input class="form-control" name="c_name" id="c_name" value="${icbc.c_name }" type="text"></div>
					</div>				
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">电话</span> <input class="form-control" name="c_tel" id="c_tel" value="${icbc.c_tel }" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">开票价</span> <input class="form-control" name="c_name_mts[]" id="c_name_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">贷款金额</span> <input class="form-control" name="c_cardno_mts[]" id="c_cardno_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">服务费金额</span> <input class="form-control" name="c_tel_mts[]" id="c_tel_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">贷款总额</span> <input class="form-control" name="c_name_mts[]" id="c_name_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">按揭模式</span> <input class="form-control" name="c_cardno_mts[]" id="c_cardno_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">按揭期限</span> <input class="form-control" name="c_tel_mts[]" id="c_tel_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">按揭银行</span> <input class="form-control" name="c_tel_mts[]" id="c_tel_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
					<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">按揭利率</span> <input class="form-control" name="c_tel_mts[]" id="c_tel_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
					<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">按揭利率</span> <input class="form-control" name="c_tel_mts[]" id="c_tel_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
					<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">上牌省</span> <input class="form-control" name="c_tel_mts[]" id="c_tel_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
					<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">上牌市</span> <input class="form-control" name="c_tel_mts[]" id="c_tel_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
					<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">所在省</span> <input class="form-control" name="c_tel_mts[]" id="c_tel_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
					<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">所在市</span> <input class="form-control" name="c_tel_mts[]" id="c_tel_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
				</div>
			</div>
			</div>
	<div class="box-header with-border">
	<h3 class="box-title">开卡图片</h3>
    </div>	
	<div class="form-group">
		<div class="col-sm-12">
			<div class="row inline-from">
			<% int p=1; %>
			<c:forEach var="qf" items="${requestScope.qflist1 }">			
			<div class="col-sm-2" style="width: 20%; position: static">
					<div class="input-group">
						<div class="badge" style="position: absolute; bottom: 20px; right: 10px;">${qf.imgsize }MB</div>
						<a style="padding: 5px 5px;" class="btn btn-default" id="ashowpic1" href="${qf.path }" target="_blank"> 
						<img id="qf<%=p %>" name="result_imgurl1_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 220px; height: 150px;" src="${qf.path }">
					</a>
								</div>
			</div> 
			<%p++; %>
    	    </c:forEach>					
					</div>
		</div>
	</div>
		<div class="box-header with-border">
	<h3 class="box-title">审核和数据填充处理</h3>
     </div>
	<div class="form-group">
	<label class="col-sm-2 control-label">审核：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
				<div class="col-sm-6">
					<div class="input-group"><span class="input-group-addon">审核状态</span> 
					<select name="bc_status" class="form-control" id="bc_status" onchange="autoremark();">
                            	<option value="3">初审通过，请补件</option>
                            	<option value="7">回退</option>
                            	<option value="5">完成-通过</option>
                            	<option value="6">完成-失败</option>                           
                            	</select>
                            	</div>
			</div>
				<div class="col-sm-6">
					<div class="input-group">
					<span class="input-group-addon">类型</span>
					 <input class="form-control" readonly="readonly" value="开卡" type="text"></div>
			</div>
		</div>
	</div>
	</div>
		<div class="form-group">
		<label class="col-sm-2 control-label">留言备注说明：</label>
			<div class="col-sm-10">
				<div class="row inline-from">
					<div class="col-sm-8">
						<div class="input-group">
						<span class="input-group-addon">审核留言</span> 
						<input class="form-control" name="remark" id="remark" type="text">
						</div>
				</div>
					<div class="col-sm-4">
						<div class="input-group">
						<span class="input-group-addon">留言快速通道</span> 
						<select class="form-control" id="cyly" onchange="setremark(this)">
												<option value="请选择" selected="selected">请选择</option>						
												<option value="查询完成，详情请点击历史查询-&gt;已完成-&gt;查看订单！">查询完成，详情请点击历史查询-&gt;已完成-&gt;查看订单！</option>						
												<option value="恭喜您初审通过,请点编辑按钮,按提示上传其他补充材料！">恭喜您初审通过,请点编辑按钮,按提示上传其他补充材料！</option>						
												<option value="请拍摄驾驶证详细资料，请将保险单拍摄完整">请拍摄驾驶证详细资料，请将保险单拍摄完整</option>						
												<option value="请拍摄行驶证和驾驶证详细资料">请拍摄行驶证和驾驶证详细资料</option>						
												<option value="过于模糊">过于模糊</option>						
												<option value="过于模糊，无非识别">过于模糊，无非识别</option>						
												<option value="上传材料错误">上传材料错误</option>						
												<option value="该车况整体良好，品牌车型受市场欢迎度较低。">该车况整体良好，品牌车型受市场欢迎度较低。</option>						
												<option value="行驶证、驾驶证拍摄不清晰">行驶证、驾驶证拍摄不清晰</option>						
						</select>
												</div>
				</div>
			</div>
		</div></div>
	<div class="form-group">
	<label class="col-sm-2 control-label">历次审核事件和留言：</label>
	<div class="col-sm-10">
    <textarea style="width: 100%; height: 150px" class="form-control" readonly="readonly">
    <c:forEach items="${requestScope.irl }" var="irl">${fn:substring(irl.dt_add, 0,19)}:状态：<c:if test="${irl.status eq '1' }">草稿箱</c:if><c:if test="${irl.status eq '2' }">提交等待</c:if><c:if test="${irl.status eq '3' }">初审通过，请补件</c:if><c:if test="${irl.status eq '4' }">回退</c:if><c:if test="${irl.status eq '5' }">补件完成，提交审核</c:if><c:if test="${irl.status eq '6' }">完成-通过</c:if><c:if test="${irl.status eq '7' }">完成-失败</c:if>,留言：${irl.remark }
    </c:forEach>
    </textarea>
    </div>
    </div>
</div>	
		</div>
		    <!-- 汽车贷款 -->
			<div class="tab-pane fade" id="tbstep5">
			<div class="box-body">
				进件审核 来自：${requestScope.gname }-${requestScope.pname }-${fn:substring(requestScope.icbc.dt_add, 0,19)} 合同编码：${requestScope.icbc.gems_code }		
	<div class="box-body">
			
	</div>	
	<div class="box-header with-border">
	<h3 class="box-title">签约材料</h3>
    </div>	
	<div class="form-group">
		<div class="col-sm-12">
			<div class="row inline-from">
			<% int q1=1; %>
			<c:forEach var="jf" items="${requestScope.jflist1 }">			
			<div class="col-sm-2" style="width: 20%; position: static">
					<div class="input-group">
						<div class="badge" style="position: absolute; bottom: 20px; right: 10px;">${jf.imgsize }MB</div>
						<a style="padding: 5px 5px;" class="btn btn-default" id="ashowpic1" href="${jf.path }" target="_blank"> 
						<img id="jf<%=q1 %>" name="result_imgurl1_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 220px; height: 150px;" src="${jf.path }">
					</a>
								</div>
			</div> 
			<%q1++; %>
    	    </c:forEach>	
													
		    </div>
		</div>
	</div>
		<div class="box-header with-border">
	<h3 class="box-title">家访材料</h3>
    </div>	
	<div class="form-group">
		<div class="col-sm-12">
			<div class="row inline-from">
			<% int q2=1; %>
			<c:forEach var="jf" items="${requestScope.jflist1 }">			
			<div class="col-sm-2" style="width: 20%; position: static">
					<div class="input-group">
						<div class="badge" style="position: absolute; bottom: 20px; right: 10px;">${jf.imgsize }MB</div>
						<a style="padding: 5px 5px;" class="btn btn-default" id="ashowpic1" href="${jf.path }" target="_blank"> 
						<img id="jf<%=q2 %>" name="result_imgurl1_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 220px; height: 150px;" src="${jf.path }">
					</a>
								</div>
			</div> 
			<%q2++; %>
    	    </c:forEach>	
													
		    </div>
		</div>
	</div>
		<div class="box-header with-border">
	<h3 class="box-title">补充材料</h3>
    </div>	
	<div class="form-group">
		<div class="col-sm-12">
			<div class="row inline-from">
			<% int q3=1; %>
			<c:forEach var="jf" items="${requestScope.jflist1 }">			
			<div class="col-sm-2" style="width: 20%; position: static">
					<div class="input-group">
						<div class="badge" style="position: absolute; bottom: 20px; right: 10px;">${jf.imgsize }MB</div>
						<a style="padding: 5px 5px;" class="btn btn-default" id="ashowpic1" href="${jf.path }" target="_blank"> 
						<img id="jf<%=q3 %>" name="result_imgurl1_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 220px; height: 150px;" src="${jf.path }">
					</a>
								</div>
			</div> 
			<%q3++; %>
    	    </c:forEach>	
													
		    </div>
		</div>
	</div>
		<div class="box-header with-border">
	<h3 class="box-title">审核和数据填充处理</h3>
     </div>
	<div class="form-group">
	<label class="col-sm-2 control-label">审核：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
				<div class="col-sm-6">
					<div class="input-group"><span class="input-group-addon">审核状态</span> 
					<select name="bc_status" class="form-control" id="bc_status" onchange="autoremark();">
                            	<option value="3">初审通过，请补件</option>
                            	<option value="7">回退</option>
                            	<option value="5">完成-通过</option>
                            	<option value="6">完成-失败</option>                           
                            	</select>
                            	</div>
			</div>
				<div class="col-sm-6">
					<div class="input-group"><span class="input-group-addon">类型</span> 
					<input class="form-control" readonly="readonly" value="贷款" type="text"></div>
			</div>
		</div>
	</div>
	</div>
		<div class="form-group">
		<label class="col-sm-2 control-label">留言备注说明：</label>
			<div class="col-sm-10">
				<div class="row inline-from">
					<div class="col-sm-8">
						<div class="input-group">
						<span class="input-group-addon">审核留言</span> 
						<input class="form-control" name="remark" id="remark" type="text">
						</div>
				</div>
					<div class="col-sm-4">
						<div class="input-group">
						<span class="input-group-addon">留言快速通道</span> 
						<select class="form-control" id="cyly" onchange="setremark(this)">
												<option value="请选择" selected="selected">请选择</option>						
												<option value="查询完成，详情请点击历史查询-&gt;已完成-&gt;查看订单！">查询完成，详情请点击历史查询-&gt;已完成-&gt;查看订单！</option>						
												<option value="恭喜您初审通过,请点编辑按钮,按提示上传其他补充材料！">恭喜您初审通过,请点编辑按钮,按提示上传其他补充材料！</option>						
												<option value="请拍摄驾驶证详细资料，请将保险单拍摄完整">请拍摄驾驶证详细资料，请将保险单拍摄完整</option>						
												<option value="请拍摄行驶证和驾驶证详细资料">请拍摄行驶证和驾驶证详细资料</option>						
												<option value="过于模糊">过于模糊</option>						
												<option value="过于模糊，无非识别">过于模糊，无非识别</option>						
												<option value="上传材料错误">上传材料错误</option>						
												<option value="该车况整体良好，品牌车型受市场欢迎度较低。">该车况整体良好，品牌车型受市场欢迎度较低。</option>						
												<option value="行驶证、驾驶证拍摄不清晰">行驶证、驾驶证拍摄不清晰</option>						
						</select>
												</div>
				</div>
			</div>
		</div></div>
	<div class="form-group">
	<label class="col-sm-2 control-label">历次审核事件和留言：</label>
		<div class="col-sm-10">
<textarea style="width: 100%; height: 150px" class="form-control" readonly="readonly">
<c:forEach items="${requestScope.irl }" var="irl">${fn:substring(irl.dt_add, 0,19)}:状态：<c:if test="${irl.status eq '1' }">草稿箱</c:if><c:if test="${irl.status eq '2' }">提交等待</c:if><c:if test="${irl.status eq '3' }">初审通过，请补件</c:if><c:if test="${irl.status eq '4' }">回退</c:if><c:if test="${irl.status eq '5' }">补件完成，提交审核</c:if><c:if test="${irl.status eq '6' }">完成-通过</c:if><c:if test="${irl.status eq '7' }">完成-失败</c:if>,留言：${irl.remark }
</c:forEach>
</textarea>
</div></div>
</div>	
		</div>
		<!-- 汽车贷款 -->
		
		<!--  
			<div class="tab-pane fade" id="tbstep6">
			<div class="box-body">
				进件审核 来自：${requestScope.gname }-${requestScope.pname }-${fn:substring(requestScope.icbc.dt_add, 0,19)} 合同编码：${requestScope.icbc.gems_code }		
	<div class="box-body">
			
	</div>
	<div class="box-header with-border">
	<h3 class="box-title">用户提交信息</h3>
    </div>
			<div class="form-group">
				<div class="col-sm-10">
					<div class="row inline-from">
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">借款人姓名</span> <input class="form-control" name="c_name" id="c_name" value="${icbc.c_name }" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">借款人身份证</span> <input class="form-control" name="c_cardno" id="c_cardno" value="${icbc.c_cardno }" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">借款人电话</span> <input class="form-control" name="c_tel" id="c_tel" value="${icbc.c_tel }" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">配偶姓名</span> <input class="form-control" name="c_name_mts[]" id="c_name_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">配偶身份证</span> <input class="form-control" name="c_cardno_mts[]" id="c_cardno_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">配偶手机</span> <input class="form-control" name="c_tel_mts[]" id="c_tel_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">共同还款人姓名</span> <input class="form-control" name="c_name_mts[]" id="c_name_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">共同还款人身份证</span> <input class="form-control" name="c_cardno_mts[]" id="c_cardno_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">共同还款人手机</span> <input class="form-control" name="c_tel_mts[]" id="c_tel_mts[]" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text"></div>
					</div>
				</div>
			</div>
			</div>
	<div class="box-header with-border">
	<h3 class="box-title">贷款图片</h3>
    </div>	
	<div class="form-group">
		<div class="col-sm-12">
			<div class="row inline-from">
			<% int s=1; %>
			<c:forEach items="${requestScope.bclist1 }" var="bc">
			<div class="col-sm-2" style="width: 20%; position: static">
					<div class="input-group">
						<div class="badge" style="position: absolute; bottom: 20px; right: 10px;">${bc.imgsize }MB</div>
						<a style="padding: 5px 5px;" class="btn btn-default" id="ashowpic1" href="${bc.path }" target="_blank"> 
						<img id="bc<%=s %>" name="result_imgurl1_view" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 220px; height: 150px;" src="${bc.path }">
					</a>
								</div>
			</div> 
			<%s++; %>
			</c:forEach>
            </div>
		</div>
	</div>
		<div class="box-header with-border">
	<h3 class="box-title">审核和数据填充处理</h3>
     </div>
	<div class="form-group">
	<label class="col-sm-2 control-label">审核：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
				<div class="col-sm-6">
					<div class="input-group"><span class="input-group-addon">审核状态</span> 
					<select name="bc_status" class="form-control" id="bc_status" onchange="autoremark();">
                            	<option value="3">初审通过，请补件</option>
                            	<option value="7">回退</option>
                            	<option value="5">完成-通过</option>
                            	<option value="6">完成-失败</option>                           
                            	</select>
                            	</div>
			</div>
				<div class="col-sm-6">
					<div class="input-group"><span class="input-group-addon">类型</span> <input class="form-control" readonly="readonly" value="工行进件" type="text"></div>
			</div>
		</div>
	</div>
	</div>
		<div class="form-group">
		<label class="col-sm-2 control-label">留言备注说明：</label>
			<div class="col-sm-10">
				<div class="row inline-from">
					<div class="col-sm-8">
						<div class="input-group">
						<span class="input-group-addon">审核留言</span> 
						<input class="form-control" name="remark" id="remark" type="text">
						</div>
				</div>
					<div class="col-sm-4">
						<div class="input-group">
						<span class="input-group-addon">留言快速通道</span> 
						<select class="form-control" id="cyly" onchange="setremark(this)">
												<option value="请选择" selected="selected">请选择</option>						
												<option value="查询完成，详情请点击历史查询-&gt;已完成-&gt;查看订单！">查询完成，详情请点击历史查询-&gt;已完成-&gt;查看订单！</option>						
												<option value="恭喜您初审通过,请点编辑按钮,按提示上传其他补充材料！">恭喜您初审通过,请点编辑按钮,按提示上传其他补充材料！</option>						
												<option value="请拍摄驾驶证详细资料，请将保险单拍摄完整">请拍摄驾驶证详细资料，请将保险单拍摄完整</option>						
												<option value="请拍摄行驶证和驾驶证详细资料">请拍摄行驶证和驾驶证详细资料</option>						
												<option value="过于模糊">过于模糊</option>						
												<option value="过于模糊，无非识别">过于模糊，无非识别</option>						
												<option value="上传材料错误">上传材料错误</option>						
												<option value="该车况整体良好，品牌车型受市场欢迎度较低。">该车况整体良好，品牌车型受市场欢迎度较低。</option>						
												<option value="行驶证、驾驶证拍摄不清晰">行驶证、驾驶证拍摄不清晰</option>						
						</select>
												</div>
				</div>
			</div>
		</div></div>
	<div class="form-group">
	<label class="col-sm-2 control-label">征信结果返回：</label>
		<div class="col-sm-10">
		<textarea style="width: 100%; height: 120px"  name="zx_result" class="form-control">
		${icbc.zx_result  }
		</textarea></div></div>
	<div class="form-group">
	<label class="col-sm-2 control-label">历次审核事件和留言：</label>
		<div class="col-sm-10">
<textarea style="width: 100%; height: 150px" class="form-control" readonly="readonly">
<c:forEach items="${requestScope.irl }" var="irl">${fn:substring(irl.dt_add, 0,19)}:状态：<c:if test="${irl.status eq '1' }">草稿箱</c:if><c:if test="${irl.status eq '2' }">提交等待</c:if><c:if test="${irl.status eq '3' }">初审通过，请补件</c:if><c:if test="${irl.status eq '4' }">回退</c:if><c:if test="${irl.status eq '5' }">补件完成，提交审核</c:if><c:if test="${irl.status eq '6' }">完成-通过</c:if><c:if test="${irl.status eq '7' }">完成-失败</c:if>,留言：${irl.remark }
</c:forEach>
</textarea>
</div></div>
</div>	
		</div>
		-->
	</div>


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
	$("#upload_result_pdf").attr('filename','');
	$("#upload_result_pdf").val('');	
		if ($("#remark").val()==""){
			alert("留言为空！");
//			window.console.error('remark null');
			$("#remark").focus();
			return false;
		}
	return true;
} 
function delpic(obj){
	$("#result_doc"+obj+"_view").attr("src","/assess/upload/none.jpg");
	$("#result_doc"+obj).val("");
}
function downallfile(fid){
	window.open('/assess/manager/index.php?cn=kj_icbc&l=15&nav=0&bc_tag=3&action=check&type=downzxfile&do=downall&xtype=mgxc&cartype=0&id=59&fid='+fid);
}
function dodownall(){
	window.open('/assess/manager/index.php?cn=kj_icbc&l=15&nav=0&bc_tag=3&action=check&type=downzxfile&do=downallzip&id=59');
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
</script>		
</section>       
		<div class="footer-wrap">
			<div class="box-footer">
				<button type="button" class="btn btn-default" onclick="location.href='icbclist.do?bc_status=${requestScope.bc_status}'">取消返回</button>
				<button type="submit" class="btn btn-primary pull-right">保存提交</button> 
			</div>
		</div>
</form>

			
	
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
	
	<script type="text/javascript" src="icbc_cs_js/index.js"></script>
	<script type="text/javascript" src="icbc_cs_js/ui.js"></script>
	

</body></html>