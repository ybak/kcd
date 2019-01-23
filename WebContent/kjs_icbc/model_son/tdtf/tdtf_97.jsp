<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<li class="text-primary">
<em>退单退费申请:</em>
<div class="big-conte_">  
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
<form id="tdtfsh_97" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
		 <input type="hidden" name="adminid" value="${sessionScope.pd.id}">
		 <input type="hidden" name="type_id" value="${requestScope.type_id}"> 
		 <input type="hidden" name="icbc_id" value="${pd.icbc_id}"> 
		 <div class="form-group">
			<label class="col-sm-2 control-label">客户姓名</label>
			<div class="col-sm-3">
				<input value="${pd.c_name}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
			</div>
			<label class="col-sm-2 control-label">业务编号</label>
			<div class="col-sm-3">
				<input value="${pd.gems_code}"  class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
			</div>
		 </div>
		<div class="form-group">
			<label class="col-sm-2 control-label">退单退费材料</label>
		</div>
		<div style="overflow: hidden;margin-left: 7%">
		<!-- ngRepeat: img in task.filepathlist -->
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label" style="margin-top: 57px;">退单退费说明</label>
			<div class="col-sm-8" style="margin-top: 40px;">
				<textarea name="result_1_msg" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text"></textarea>
			</div>
		</div> 
	<!-- ngIf: !notUseButton -->
<div class="modal-footer">
	<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
	<a onclick="erp_tdtfsh_97()"  class="btn btn-primary" >提交</a>	
</div>
</form>
<script type="text/javascript">
function erp_tdtfsh_97(){
	   	var form = new FormData(document.getElementById("tdtfsh_97"));
	   	$.ajax({
	           url:"${pageContext.request.contextPath}/erp/erp_tdtfsh_97.do",
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