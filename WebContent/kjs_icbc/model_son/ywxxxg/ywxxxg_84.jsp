<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'ywglb_84')==true}">
<li class="text-primary">
<em>业务管理部：</em>
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
<form id="ywxxxgsh_84" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
   <!-- ngIf: notUseButton -->
  	<input type="hidden" name="adminid" value="${sessionScope.pd.id}">
	<input type="hidden" name="type_id" value="${requestScope.type_id}"> 
	<input type="hidden" name="icbc_id" value="${pd.icbc_id}"> 
   <div class="form-group ng-scope">
		<label class="col-sm-2 control-label">审核结果</label>
		<div class="col-sm-6">
			<input type="radio" value="1"  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code">通过
	            &nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="radio" value="2" class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code">不通过
		</div>
	</div><!-- end ngIf: notUseButton -->
	<!-- ngIf: !notUseButton -->
	<!-- ngIf: !notUseButton -->

	
	<!-- ngIf: task.tranCode&&!notUseButton -->
	<div class="form-group">
		<label class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea name="result_1_msg" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text"></textarea>
		</div>
	</div>
	
	<!-- ngIf: currentUser.orgType=='ALAN' -->
	<div class="ng-scope">
	
		<label class="col-sm-2 control-label">相关材料:</label>								
	     	<div style="overflow: hidden;margin-left: 7%;">
	     	<!-- ngRepeat: img in task.filepathlist -->
			</div>
			<div class="clear"></div> 
			<br>
			<br>
	<!-- ngIf: (!notUseButton&&rootData.taskDefKey == 'updateLoanField_updateLoan_operation1')||(notUseButton&&taskAct.activityId=='updateLoanField_updateLoan_operation1') -->
		<!-- <div class="form-group">
			<label class="col-sm-2 control-label">修改原因备注</label>
			<div class="col-sm-8">
				<textarea class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"></textarea>
			</div>
		</div> -->
	</div><!-- end ngIf: currentUser.orgType=='ALAN' -->
	<!-- ngIf: !notUseButton -->
<div class="modal-footer">
	<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
	<a onclick="erp_ywxxxgsh_84()"  class="btn btn-primary" >提交</a>	
</div>
</form>
<script type="text/javascript">
function erp_ywxxxgsh_84(){
	var val=$('input:radio[name="result_1_code"]:checked').val();
    if(val==null){
        alert("请选择审核结果!");
        return false;
    }else{
	   	var form = new FormData(document.getElementById("ywxxxgsh_84"));
	   	$.ajax({
	           url:"${pageContext.request.contextPath}/erp/erp_ywxxxgsh_84.do",
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