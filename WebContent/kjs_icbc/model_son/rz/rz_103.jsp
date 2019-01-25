<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	long date = new Date().getTime();
	String dateString = formatter.format(date);
%>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'financing_103')==true}">

<li class="text-primary"><em>公司确认收款</em>
	<div class="big-conte" style="display: block;">
		<div style="float: left; margin-left: 20px; width: 260px;"
			class="ng-binding">
			<strong>开始时间：</strong><%=dateString%>
		</div>
		<br>
		<div class="task_margin ng-scope"
			style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">
			<form id="zjfp_form" name="zjfp_form"
				class="form-horizontal ng-pristine ng-valid ng-scope">
	<input id="admin_id" name="admin_id" value="${sessionScope.pd.id }" type="hidden" />
    <input id="icbc_id" name="icbc_id" value="${requestScope.icbc_id }" type="hidden" />
    <input id="type_id" name="type_id" value="${requestScope.type_id }" type="hidden" />
    <input id="status_id" name="status_id" value="103" type="hidden" />
    <input id="yw_id" name="yw_id" value="${requestScope.yw_id }" type="hidden" />
	<input id="gems_id" name="gems_id" value="${requestScope.pd.gemsid }" type="hidden" />	
	<input id="fs_id" name="fs_id" value="${requestScope.pd.fsid }" type="hidden" />
	<input id="dz_type" name="dz_type" value="${pd.dz_type}" type="hidden"    />
    <input id="icbc_name" name="icbc_name" value="${pd.c_name }" type="hidden" />
    <input id="icbc_adminid" name="icbc_adminid" value="${pd.icbc_adminid }" type="hidden" />
    <input id="dt_date" name="dt_date" value="${pData2.dt_edit }" type="hidden" />

				<div class="form-group">					
					<label class="col-sm-2 control-label">公司确认收款</label>
					<div class="col-sm-3">
						<select id="gsqrsk" name="gsqrsk" class="form-control">
						 <option value="0">--请选择--</option>
						 <option value="1">已收款</option>
						 <option value="2">未收款</option>
						</select>
					</div>
				</div>		
				<div class="form-group">
					<label class="col-sm-2 control-label">备注</label>
					<div class="col-sm-8">
						<textarea rows="3" id="bz" name="bz"
							class="form-control ng-pristine ng-untouched ng-valid ng-empty"
							type="text"></textarea>
					</div>
				</div>
				<!-- ngIf: !notUseButton -->
<div class="modal-footer">
<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
<a onclick="erp()" class="btn btn-primary" >提交</a>
</div>
</form>
<script type="text/javascript">
function erp(){
	if(document.getElementById("gsqrsk").value!=0){
		var form = new FormData(document.getElementById("zjfp_form"));
		$.ajax({
	        url:"${pageContext.request.contextPath }/erp/erp_rz_103.do",
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
	}else{
		alert("请认真审核！！请选择公司是否确认收款!");
	}
}


</script>
		</div>
	</div></li>
	</c:if>