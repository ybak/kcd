<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
<link href="${pageContext.request.contextPath}/kjs_icbc/kjs_icbc_style/css/bootstrap.css" rel="stylesheet" type="text/css">
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
<body>


<li class="text-primary">
<h4>业务属性值修改申请</h4>
<!-- <div class="big-conte_">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong></div>
<strong style="margin-left:10px;"><i>处理信息：</i></strong>
<br> -->

<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form id="ywxxxgsh_96" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
   <!-- ngIf: notUseButton -->
	<input type="hidden" name="adminid" value="${sessionScope.pd.id}">
	<input type="hidden" name="type_id" value="14"> 
	<input type="hidden" name="icbc_id" value="${pd.id}"> 
   <div class="form-group ng-scope">
		<label class="col-sm-2 control-label">业务类型</label>
		<div class="col-sm-6">
			<select id="ywlx" name="ywxxxgsh_96_ywlx"  class="form-control form-inline hidden-xs">
				<option value="">***业务类型***</option>
				<option value="征信查询">征信查询</option>
				<option value="征信通融">征信通融</option>
				<option value="车辆评估">车辆评估</option>
				<option value="银行电审">银行电审</option>
				<option value="开卡申请">开卡申请</option>
				<option value="视频面签">视频面签</option>
				<option value="跨区域业务审批">跨区域业务审批</option>
				<option value="汽车贷款">汽车贷款</option>
				<option value="内审通融">内审通融</option>
				<option value="资金分配">资金分配</option>
				<option value="银行贷款申请">银行贷款申请</option>
				<option value="公司归档">公司归档</option>
				<option value="抵押归档">抵押归档</option>
				<option value="业务信息修改">业务信息修改</option>
				<option value="退单退费">退单退费</option>
			</select>
		</div>
		<!-- 属性修改弹框 start -->
		<%-- <div class="form-group">
			<table class="table table-bordered" style="width:50%;margin-left:307px;margin-top:50px;">
			<thead>
			     <tr>
			         <th width="30%">业务属性</th>
			         <th>原值--&gt;更改值 
			         <button class="btn btn-sm btn-success" style="float:right;" type="button" ng-init="data.dataList=data.dataList?data.dataList:[];data.dataList.push({});" ng-click="data.dataList=data.dataList?data.dataList:[];data.dataList.push({});">
			            <i class="glyphicon glyphicon-plus"></i> 添加要修改的属性
			       	 </button>
			        </th>
			     </tr>
			 </thead>
			 <tbody class="ng-scope" ng-if="displayedList.count !=0 "> 
			 <tr class="ng-scope" ng-repeat="item in displayedList">
		         <td>
			         <select class="fieldAttr form-control ng-isolate-scope ng-empty ng-invalid ng-invalid-required ng-touched" required="required" ng-model="data.field[$index]" cg-required="" source="businessAttr" index="creditQuery" parent-id="tranCode" ng-options="opt.realValue as opt.displayValue for opt in options">
				         <option class="ng-binding" selected="selected" value="">--请选择--</option>
				         <option value="number:18" label="征信结果">征信结果</option>
				         <option value="number:19" label="征信内容">征信内容</option>
			         </select>
		         </td>
		         <td>
		         	<cg-dync-form class="ng-pristine ng-untouched ng-valid ng-isolate-scope ng-empty" ng-model="item.businessAttr" obj_model="businessAttr" parent-model="data.field[$index]"></cg-dync-form>
		         </td>
		     </tr>
			 </tbody>
			</table>
		</div> --%>
		<!-- 属性修改弹框 end -->
		
	</div><!-- end ngIf: notUseButton -->
	<!-- ngIf: !notUseButton -->
	<!-- ngIf: !notUseButton -->
	<!-- ngIf: task.tranCode&&!notUseButton -->
	<div class="form-group">
		<label class="col-sm-2 control-label">修改内容备注</label>
		<div class="col-sm-8">
			<textarea name="ywxxxgsh_96_xgbz" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text" ></textarea>
		</div>
	</div>
	<!-- ngIf: currentUser.orgType=='ALAN' -->
	<div class="ng-scope">
		<!-- <label class="col-sm-2 control-label">上传相关材料:</label>	
	     	<div style="overflow: hidden;margin-left: 7%;">
			</div> -->
			<div class="clear"></div> 
	<!-- ngIf: (!notUseButton&&rootData.taskDefKey == 'updateLoanField_updateLoan_operation1')||(notUseButton&&taskAct.activityId=='updateLoanField_updateLoan_operation1') -->
	<div class="form-group">
		<label class="col-sm-2 control-label">修改原因备注</label>
		<div class="col-sm-8">
			<textarea name="result_1_msg" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"></textarea>
		</div>
	</div>
	</div><!-- end ngIf: currentUser.orgType=='ALAN' -->
	<!-- ngIf: !notUseButton -->
<div class="modal-footer">
	<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
	<a onclick="erp_ywxxxgsh_96(14,${sessionScope.pd.id},${pd.id})"  class="btn btn-primary" >提交</a>	
</div>
</form>
<script type="text/javascript">
function erp_ywxxxgsh_96(type_id,adminid,icbc_id){
	$.ajax({
		url: "${pageContext.request.contextPath}/erp/erp_sh_add.do",
	    type: "post",
	    data:{
	    	type_id:type_id,
	    	adminid:adminid,
	    	icbc_id:icbc_id
	    },
        success: function(data){
        	var form = new FormData(document.getElementById("ywxxxgsh_96"));
		   	$.ajax({
		           url:"${pageContext.request.contextPath}/erp/erp_ywxxxgsh_96.do",
		           type:"post",
		           data:form,
		           processData:false,
		           contentType:false,
		           success:function(data){
		            alert("提交成功!");
		            window.location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }';
		           },
		           error:function(e){
		            alert("错误！！");
		           }
		    });  
        },
        error:function(data){
        	alert("一层错误");
        }
  	});
}
</script>
</div>                                             
</div>							  	
</li>




</body>
</html>