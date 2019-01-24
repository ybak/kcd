<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'pgjsh_11')==true}">
<li class="text-primary">
<em>评估价审核</em>
<div class="big-conte_" style="display: block;">  
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
<form id="pg_Form" action="${pageContext.request.contextPath}/erp/clpg_modal_up.do" method="post" enctype="multipart/form-data" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required" >
	<input type="hidden" name="adminid" value="${sessionScope.pd.id}">
	<input type="hidden" name="type_id" value="${requestScope.type_id}"> 
	<input type="hidden" name="icbc_id" value="${pd.icbc_id}"> 
	<input type="hidden" name="cars_id" value="${pd.carsid}"> 
	<div class="form-group ng-scope">  
		<label class="col-sm-2 control-label">审核结果<i class="red">*</i></label> 
		<div class="col-sm-3"> 
		<select class="form-control" id="result_1_code" name="result_1_code" >
					<option value="0">--请选择--</option>
					<option value="1">评估完成  </option>
					<option value="2">拒绝</option>
					<option value="3">回退补件</option>
		</select>
	    </div>
	</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">新车指导价</label>
			<div class="col-sm-3">
				<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required" >
					<input class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text" name="price_new"  value="${requestScope.pd.price_new}"><span class="input-group-addon">元</span>
				</div>
			</div> 
			<label class="col-sm-2 control-label">期望评估价</label>
			<div class="col-sm-3">
				<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required" >
					<input class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text" name="icbc_pricecs"  value="${requestScope.pd.icbc_pricecs}" ><span class="input-group-addon">元</span>
				</div>
			</div> 
		</div> 
		<div class="form-group">
			<label class="col-sm-2 control-label">建议评估价</label>
			<div class="col-sm-3">
				<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required" >
					<input class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text"  value="" ><span class="input-group-addon">元</span>
				</div>
			</div> 
			<label class="col-sm-2 control-label">最终评估价<i class="red">*</i></label>
			<div class="col-sm-3">
				<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required" >
					<input class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required" type="text" id="price_result" name="price_result" value="${requestScope.pd.price_result}"><span class="input-group-addon">元</span>
				</div>
			</div> 
		</div> 
		<div class="form-group">
			<label class="col-sm-2 control-label">备注</label>
			<div class="col-sm-8">
				<input class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text" name="remark" value="">
			</div>
		</div> 
	<div class="modal-footer">
	<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
	<a onclick="erp_pgsh()"  class="btn btn-primary" >提交</a>	
</div>
</form>
<script type="text/javascript">
function erp_pgsh(){
	var price_result = document.getElementById("price_result").value;	
	var val=$("#result_1_code").val();
    if(val==null||val==0){
        alert("请选择审核结果!");
        return false;
    }else{
	   	var form = new FormData(document.getElementById("pg_Form"));
	   	$.ajax({
	           url:"${pageContext.request.contextPath}/erp/erp_pgsh.do",
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

	