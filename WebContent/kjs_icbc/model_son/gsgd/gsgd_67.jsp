	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'jtzzgd_67')==true}">
<li class="text-primary">
<em>公司纸质归档:</em>
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
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form id="gsgdsh_67"  name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope" >
	<!-- ngIf: notUseButton && task.complete!=null -->
		<input type="hidden" name="adminid" value="${sessionScope.pd.id}">
		<input type="hidden" name="type_id" value="${requestScope.type_id}"> 
		<input type="hidden" name="icbc_id" value="${requestScope.icbc_id}"> 
	<div class="form-group ng-scope" >
		<label class="col-sm-2 control-label">材料审核<span class="red">*</span></label>
		<div class="col-sm-3">
			<input type="radio" value="1"  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code">通过  &nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="radio" value="2"  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code">不通过
		</div>	
	</div><!-- end ngIf: notUseButton && task.complete!=null -->
	<div class="form-group">
		<label class="col-sm-2 control-label">客户姓名</label>
		<div class="col-sm-3">
			<input  class="form-control" value="${pd.c_name }" type="text">
		</div>
		<span class="ng-hide">
		<label class="col-sm-2 control-label">编号</label><!--AX年份000001  -->
		<div class="col-sm-3">
			<input  class="form-control" value="${pd.gems_code }" type="text" >
		</div>
		</span>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea name="result_1_msg" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"></textarea>
			<!-- <input class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"  > -->
		</div>
	</div>
	<!-- ngIf: rootData.orgType=='ASUN'&&rootData.taskDefKey=='loanOrder_paperFiling_page' -->
	
	<!-- ngIf: !notUseButton -->
<div class="modal-footer">
	<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
	<a onclick="erp_gsgdsh_67()"  class="btn btn-primary" >提交</a>	
</div>
</form>
<script type="text/javascript">
function erp_gsgdsh_67(){
	var val=$('input:radio[name="result_1_code"]:checked').val();
    if(val==null){
        alert("请选择材料审核结果!");
        return false;
    }else{
	   	var form = new FormData(document.getElementById("gsgdsh_67"));
	   	$.ajax({
	           url:"${pageContext.request.contextPath}/erp/erp_gsgdsh_67.do",
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