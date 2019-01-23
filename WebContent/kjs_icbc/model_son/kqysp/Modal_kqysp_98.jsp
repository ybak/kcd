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
<h4>跨区域业务申请</h4>
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
<form id="kqyspsh_98" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
	    <input type="hidden" name="adminid" value="${sessionScope.pd.id}">
		<input type="hidden" name="type_id" value="7"> 
		<input type="hidden" name="icbc_id" value="${pd.id}"> 
	 <div class="form-group ng-scope">
		<label class="col-sm-2 control-label">申请上牌地</label>
		<div class="col-sm-8">
			<input name="kqyspsh_98_sqspd"  type="text" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required">
		</div>
	 </div>	
    <!-- <div class="form-group">
        <label class="col-sm-2 control-label">申请上牌地<i class="red">*</i>：</label>
        <div class="col-sm-3">
            <select class="form-control ng-isolate-scope ng-not-empty ng-valid ng-valid-required" id="provinceCode" >
            <option value="" class="ng-binding" selected="selected">--请选择--</option><option label="北京市" value="number:11">北京市</option><option label="天津市" value="number:12">天津市</option><option label="河北省" value="number:13">河北省</option><option label="山西" value="number:14">山西</option><option label="内蒙古自治区" value="number:15">内蒙古自治区</option><option label="辽宁省" value="number:21">辽宁省</option><option label="吉林省" value="number:22">吉林省</option><option label="黑龙江省" value="number:23">黑龙江省</option><option label="上海市" value="number:31">上海市</option><option label="江苏省" value="number:32" selected="selected">江苏省</option><option label="浙江省" value="number:33">浙江省</option><option label="安徽省" value="number:34">安徽省</option><option label="福建省" value="number:35">福建省</option><option label="江西省" value="number:36">江西省</option><option label="山东省" value="number:37">山东省</option><option label="河南省" value="number:41">河南省</option><option label="湖北省" value="number:42">湖北省</option><option label="湖南省" value="number:43">湖南省</option><option label="广东省" value="number:44">广东省</option><option label="广西壮族自治区" value="number:45">广西壮族自治区</option><option label="海南省" value="number:46">海南省</option><option label="重庆市" value="number:50">重庆市</option><option label="四川省" value="number:51">四川省</option><option label="贵州省" value="number:52">贵州省</option><option label="云南省" value="number:53">云南省</option><option label="西藏自治区" value="number:54">西藏自治区</option><option label="陕西省" value="number:61">陕西省</option><option label="甘肃省" value="number:62">甘肃省</option><option label="青海省" value="number:63">青海省</option><option label="宁夏回族自治区" value="number:64">宁夏回族自治区</option><option label="新疆维吾尔自治区" value="number:65">新疆维吾尔自治区</option><option label="台湾省" value="number:71">台湾省</option><option label="香港特别行政区" value="number:81">香港特别行政区</option><option label="澳门特别行政区" value="number:82">澳门特别行政区</option></select>
        </div>
        <div class="col-sm-3">
            <select class="form-control ng-isolate-scope ng-not-empty ng-valid ng-valid-required"  name="cityCode" >
            <option value="" class="ng-binding" selected="selected">--请选择--</option><option label="南京市" value="number:3201">南京市</option><option label="无锡市" value="number:3202">无锡市</option><option label="徐州市" value="number:3203">徐州市</option><option label="常州市" value="number:3204">常州市</option><option label="苏州市" value="number:3205" selected="selected">苏州市</option><option label="南通市" value="number:3206">南通市</option><option label="连云港市" value="number:3207">连云港市</option><option label="淮安市" value="number:3208">淮安市</option><option label="盐城市" value="number:3209">盐城市</option><option label="扬州市" value="number:3210">扬州市</option><option label="镇江市" value="number:3211">镇江市</option><option label="泰州市" value="number:3212">泰州市</option><option label="宿迁市" value="number:3213">宿迁市</option></select>
        </div>
        <div class="col-sm-2">
            <select class="form-control ng-isolate-scope ng-not-empty ng-valid" ><option value="" class="ng-binding" selected="selected">--请选择--</option><option label="沧浪区" value="number:320502">沧浪区</option><option label="平江区" value="number:320503">平江区</option><option label="金阊区" value="number:320504">金阊区</option><option label="虎丘区" value="number:320505" selected="selected">虎丘区</option><option label="工业园区" value="number:320508">工业园区</option><option label="高新区" value="number:320509">高新区</option><option label="吴中区" value="number:320506">吴中区</option><option label="相城区" value="number:320507">相城区</option><option label="常熟市" value="number:320581">常熟市</option><option label="张家港市" value="number:320582">张家港市</option><option label="昆山市" value="number:320583">昆山市</option><option label="吴江市" value="number:320584">吴江市</option><option label="太仓市" value="number:320585">太仓市</option></select>
    	</div>
    </div> -->
    <div class="form-group">
        <label class="col-sm-2 control-label">申请原因：</label>
        <div class="col-sm-8">
            <textarea name="result_1_msg" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text" ></textarea>
        </div>
    </div>

    <!-- ngIf: !notUseButton -->
<div class="modal-footer">
	<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
	<a onclick="erp_kqyspsh_98(7,${sessionScope.pd.id},${pd.id})"  class="btn btn-primary" >提交</a>	
</div>
</form>
<script type="text/javascript">
function erp_kqyspsh_98(type_id,adminid,icbc_id){
	$.ajax({
		url: "${pageContext.request.contextPath}/erp/erp_sh_add.do",
	    type: "post",
	    data:{
	    	type_id:type_id,
	    	adminid:adminid,
	    	icbc_id:icbc_id
	    },
        success: function(data){
        	var form = new FormData(document.getElementById("kqyspsh_98"));
		   	$.ajax({
		           url:"${pageContext.request.contextPath}/erp/erp_kqyspsh_98.do",
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