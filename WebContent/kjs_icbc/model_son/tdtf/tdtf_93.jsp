<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'cljh_93')==true}">
<li class="text-primary">
<em>材料寄回</em>
<div class="big-conte_" style="none;">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong></div>
<strong style="margin-left:10px;"><i>处理信息：</i></strong><br>
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form id="tdtfsh_93" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
		<input type="hidden" name="adminid" value="${sessionScope.pd.id}">
		<input type="hidden" name="type_id" value="${requestScope.type_id}"> 
		<input type="hidden" name="icbc_id" value="${pd.icbc_id}"> 
<!-- 	<div class="form-group" ng-if="notUseButton && task.postRet != null">
		<label class="col-sm-2 control-label">收件确认</label>
		<div class="col-sm-6">
			<input type="radio" value="1" ng-model="task.postRet" disabled="true">已收到
	            &nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="radio" value="0" ng-model="task.postRet" disabled="true">未收到
		</div>
	</div> -->
	<!-- ngIf: (rootData.taskDefKey == 'loanOrder_postinfo_send' || (task.notarizeEndDate !=null))&&task.justRecord==true -->
	<div class="form-group">
		<label class="col-sm-2 control-label">快递公司</label>
		<div class="col-sm-3">
			<input name="tdtfsh_93_kdgs" class="form-control ng-pristine ng-untouched ng-valid ng-empty">
		</div>
		<!-- ngIf: rootData.taskDefKey == 'loanOrder_postinfo_send'||($parent.taskAct.activityId=='loanOrder_postinfo_send'&&notUseButton) -->
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">快递单号</label>
		<div class="col-sm-3">
			<input name="tdtfsh_93_kddh" class="form-control ng-pristine ng-untouched ng-valid ng-empty">
		</div>
		<label class="col-sm-1 control-label">寄出日期<i class="red">*</i></label>
		<div class="col-sm-3">
			<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required" >
  				<input placeholder="请选择日期" id="date_93" name="tdtfsh_93_jcrq" class="form-control" type="text"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
			</div>
		</div>
	</div> 
	<!-- ngIf: !notUseButton -->
	<br>
	<div class="form-group">
		<label class="col-sm-2 control-label">上传快递图片</label>
     	<div class="col-sm-3">
     		<input type="text" name="tdtfsh_93_bcimg1" >
	     	<li>
		     	<img  class="fileUpload_preview fileUpload_preview-small fileUpload_preview-square"  src="http://115.236.182.101:8083/Customer/0~50000/C000292957/20180611A0000061/POST_BILL/1531895808445.jpg">
	     	</li>
		</div>
	</div>
	<!-- ngIf: rootData.taskDefKey!='loanOrder_postinfo_return' -->
	<!-- <div style="overflow: hidden;margin-left: 7%"class="ng-scope">
	     ngRepeat: img in task.filepathlist --><!-- ngIf: img.materialType=='REG_CERT' --><!-- end ngRepeat: img in task.filepathlist
	</div>end ngIf: rootData.taskDefKey!='loanOrder_postinfo_return'
	<div class="clear" style="margin-top: 10%"></div> 
	<div class="form-group ng-hide">
		<label class="col-sm-2 control-label">车牌号码</label>
		<div class="col-sm-3">
			<input class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text">
		</div>
	</div> -->
	<div class="form-group">
		<label class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea name="result_1_msg" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"></textarea>
		</div>
	</div> 
	<!-- ngIf: !notUseButton -->
	<div class="modal-footer">
		<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
		<a onclick="erp_tdtfsh_93()" class="btn btn-primary" >提交</a>
	</div>
</form>
<script>
lay('#version').html('-v'+ laydate.v);
//执行一个laydate实例
laydate.render({
  elem: '#date_93' //指定元素
});
</script>
<script type="text/javascript">
function erp_tdtfsh_93(){
   	var form = new FormData(document.getElementById("tdtfsh_93"));
   	$.ajax({
           url:"${pageContext.request.contextPath}/erp/erp_tdtfsh_93.do",
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
}
</script>
</div>
</div>   							  	
</li>
</c:if>