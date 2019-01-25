<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'zxyhyj_6')==true}">
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form id="zxtryh_form" name="zxtryh_form" class="form-horizontal ng-pristine ng-valid ng-scope">
    <input id="admin_id" name="admin_id" value="${sessionScope.pd.id }" type="hidden" />
    <input id="icbc_id" name="icbc_id" value="${requestScope.icbc_id }" type="hidden" />
    <input id="type_id" name="type_id" value="${requestScope.type_id }" type="hidden" />
    <input id="status_id" name="status_id" value="6" type="hidden" />
    <input id="yw_id" name="yw_id" value="${requestScope.yw_id }" type="hidden" />
     <input id="icbc_name" name="icbc_name" value="${pd.c_name }" type="hidden" />
    <input id="icbc_adminid" name="icbc_adminid" value="${pd.icbc_adminid }" type="hidden" />
    <input id="dt_date" name="dt_date" value="${pData2.dt_edit }" type="hidden" />
	<div class="form-group">
		<label class="col-sm-2 control-label">征信员银行意见：</label>
		<div class="col-sm-8">
		<textarea id="result_value" name="result_value"  rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"></textarea>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">申请通融原因</label>
		<div class="col-sm-8">
		<textarea class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">${requestScope.pd.tr_msg }</textarea>
		</div>
	</div>
     <div class="form-group">
		<label class="col-sm-2 control-label">通融资料:</label>
	     	<div style="overflow: hidden;margin-left: 7%;">
	     	 <c:forEach items="${requestScope.tr_imgs }" var="tr_img">
	     	  <c:if test="${!empty tr_img }">
	     	  <a href="http://a.kcway.net/assess/${tr_img }" target="_blank"><img class=""  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/${tr_img }"></a>
	     	  </c:if>
			  </c:forEach>
			</div>
	</div>	
<div class="modal-footer">
<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
<a onclick="erp_zxtrsh()" class="btn btn-primary" >提交</a>
</div>
<script type="text/javascript">
function erp_zxtrsh(){
	var result_value = $("#result_value").val();
	if(result_value==""){
		alert("请输入征信员银行意见");
	}else{
		var form = new FormData(document.getElementById("zxtryh_form"));
		$.ajax({
	        url:"${pageContext.request.contextPath }/erp/erp_zxtryhsh.do",
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
</form>	

</div>
</c:if>
