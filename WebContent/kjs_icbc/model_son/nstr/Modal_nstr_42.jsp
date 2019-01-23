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
<h4>合作商总经理申请通融</h4>
<div class="big-conte_">  
<!-- <div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong></div>
<strong style="margin-left:10px;"><i>处理信息：</i></strong><br> -->
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form id="nstrsh_42" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
	    <input type="hidden" name="adminid" value="${sessionScope.pd.id}">
		<input type="hidden" name="type_id" value="9"> 
		<input type="hidden" name="icbc_id" value="${pd.id}"> 
    <div class="form-group">
		<label class="col-sm-2 control-label">关联客户</label>
		<div class="col-sm-3">
		    <input value="${pd.c_name}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
        </div>
         <label class="col-sm-2 control-label">业务编号</label>
		<div class="col-sm-3">
			<input value="${pd.gems_code}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">通融说明</label>
		<div class="col-sm-8">
			<textarea name="result_1_msg" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text"></textarea>
		</div>
	</div>
	<div class="form-group">
		<!-- ngIf: !notUseButton -->
		<div style="overflow: hidden;margin-left: 7%">
		     <!-- ngRepeat: img in task.filepathlist -->
		</div>
	</div>
	<!-- 根据action确定操作  -->
<!-- ngIf: !notUseButton -->
<div class="modal-footer">
	<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
	<a onclick="erp_nstrsh_42(9,${sessionScope.pd.id},${pd.id})"  class="btn btn-primary" >提交</a>	
</div>
</form>
<script type="text/javascript">
function erp_nstrsh_42(type_id,adminid,icbc_id){
		//内审通融开始
		$.ajax({
			url: "${pageContext.request.contextPath}/erp/erp_sh_add.do",
		    type: "post",
		    data:{
		    	type_id:type_id,
		    	adminid:adminid,
		    	icbc_id:icbc_id
		    },
	        success: function(data){
	        	//内审通融申请
	    	   	var form = new FormData(document.getElementById("nstrsh_42"));
	    	   	$.ajax({
	    	           url:"${pageContext.request.contextPath}/erp/erp_nstrsh_42.do",
	    	           type:"post",
	    	           data:form,
	    	           processData:false,
	    	           contentType:false,
	    	           success:function(data){
	    	            alert("提交成功!");
	    	            location.reload();
	    	            //window.location.reload();
	    	            //window.location.href='${pageContext.request.contextPath}/erp/wdrw_form.do?type=wdrw&dn=wdrw&qn=form&icbc_id='+icbc_id+'&cn=w1&cn1=3';
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