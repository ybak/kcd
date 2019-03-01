<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'shybcl_69')==true}">
<li class="text-primary">
<em>审核员补资料(未知--待定):</em>
<div class="big-conte_" >  
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
<form id="gsgdsh_69" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope" >
		<input type="hidden" name="adminid" value="${sessionScope.pd.id}">
		<input type="hidden" name="type_id" value="${requestScope.type_id}"> 
		<input type="hidden" name="icbc_id" value="${requestScope.icbc_id}"> 
	<div class="form-group">
		<label class="col-sm-2 control-label">客户姓名<span class="red">*</span></label>
		<div class="col-sm-3">
			<input name="name" id="name" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
		</div>
		<label class="col-sm-2 control-label">编号<span class="red">*</span></label><!--AX年份000001  -->
		<div class="col-sm-3">
			<input name="code" id="code" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea name="result_1_msg" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"></textarea>
			<!-- <input class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text" > -->
		</div>
	</div>
	<!-- ngIf: !notUseButton -->
<div class="modal-footer">
	<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
	<a onclick="erp_gsgdsh_69()"  class="btn btn-primary" >提交</a>	
</div>
</form>
<script type="text/javascript">
function erp_gsgdsh_69(){
		var name = $("#name").val();
		var code = $("#code").val();
		if(name==""){
			alert("请输入客户姓名!");
		}else if(code==""){
			alert("请输入编号!");
		}else{
			var form = new FormData(document.getElementById("gsgdsh_69"));
		   	$.ajax({
		           url:"${pageContext.request.contextPath}/erp/erp_gsgdsh_69.do",
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