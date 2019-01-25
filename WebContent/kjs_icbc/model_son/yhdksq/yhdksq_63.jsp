<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'bcclqr_63')==true}">
<li class="text-primary">
<em>补充材料确认</em>
<div class="big-conte_">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong></div>
<strong style="margin-left:10px;">
<i>处理信息：</i></strong><br>
<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form id="yhdksh_63" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
	<input type="hidden" name="adminid" value="${sessionScope.pd.id}">
	<input type="hidden" name="type_id" value="${requestScope.type_id}"> 
	<input type="hidden" name="icbc_id" value="${requestScope.icbc_id}"> 
	<div class="form-group">
		<label class="col-sm-2 control-label">检查结果</label>
		<div class="col-sm-8">
			<input name="result_1_code" class="ng-pristine ng-untouched ng-valid ng-not-empty" type="radio" value="1">完整
            &nbsp;&nbsp;&nbsp;&nbsp;
	        <input name="result_1_code" class="ng-pristine ng-untouched ng-valid ng-not-empty" type="radio" value="2">材料不完整，需要机构补充
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">其它说明</label>
		<div class="col-sm-8">
			<input name="result_1_msg" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text" ng-model="task.remarks">
		</div>
	</div> 
	<!-- ngIf: !notUseButton -->
	<div class="modal-footer">
		<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
		<a onclick="erp_yhdksh_63()" class="btn btn-primary" >提交</a>
	</div>
</form>
<script type="text/javascript">
function erp_yhdksh_63(){
	var val=$('input:radio[name="result_1_code"]:checked').val();
    if(val==null){
    	alert(val);
        alert("请选择检查结果!");
    }else{
	   	var form = new FormData(document.getElementById("yhdksh_63"));
	   	$.ajax({
	           url:"${pageContext.request.contextPath}/erp/erp_yhdksh_63.do",
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