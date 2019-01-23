<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'shjltdsh_90')==true}">
<li class="text-primary">
<em>审核经理退单审核:</em>
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
<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form id="tdtfsh_90"  name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
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
				<input value="${pd.gems_code}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
			</div>
		 </div>
		<div class="form-group ng-scope" >
			<label class="col-sm-2 control-label">审核结果<span class="red">*</span></label>
			<div class="col-sm-3">
				<input type="radio" value="1"  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code">通过  &nbsp;&nbsp;&nbsp;&nbsp;
		        <input type="radio" value="2"  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code">不通过
			</div>	
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">退单退费材料</label>
		</div>
		<div style="overflow: hidden;margin-left: 7%">
		<!-- ngRepeat: img in task.filepathlist -->
		</div>
		<!-- <div class="form-group">
			<label class="col-sm-2 control-label" style="margin-top: 57px;">退单退费说明</label>
			<div class="col-sm-8" style="margin-top: 40px;">
				<textarea rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text"></textarea>
			</div>
		</div>  -->
	<div class="form-group">
		<label class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea name="result_1_msg" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"></textarea>
		</div>
	</div> 
	<!-- ngIf: !notUseButton -->
<div class="modal-footer">
	<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
	<a onclick="erp_tdtfsh_90()"  class="btn btn-primary" >提交</a>	
</div>
</form>
<script type="text/javascript">
function erp_tdtfsh_90(){
	var val=$('input:radio[name="result_1_code"]:checked').val();
    if(val==null){
        alert("请选择审核结果!");
        return false;
    }else{
	   	var form = new FormData(document.getElementById("tdtfsh_90"));
	   	$.ajax({
	           url:"${pageContext.request.contextPath}/erp/erp_tdtfsh_90.do",
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
}
</script>
</div>                                             
</div>							  	
</li>
</c:if>