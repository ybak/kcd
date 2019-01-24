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
<script>
	lay('#version').html('-v' + laydate.v);
	//执行一个laydate实例
	laydate.render({
		elem : '#rz_date' //指定元素

	});
</script>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'financing_102')==true}">

<li class="text-primary"><em>出账</em>
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
    <input id="status_id" name="status_id" value="102" type="hidden" />
    <input id="yw_id" name="yw_id" value="${requestScope.yw_id }" type="hidden" />
	<input id="gems_id" name="gems_id" value="${requestScope.pd.gemsid }" type="hidden" />	
	<input id="fs_id" name="fs_id" value="${requestScope.pd.fsid }" type="hidden" />
	<input id="icbc_name" name="icbc_name" value="${pd.c_name }" type="hidden" />
    <input id="icbc_adminid" name="icbc_adminid" value="${pd.icbc_adminid }" type="hidden" />
    <input id="dt_date" name="dt_date" value="${pData2.dt_edit }" type="hidden" />
				<div class="form-group">					
					<label class="col-sm-2 control-label">账户</label>
					<div class="col-sm-3">
						<input id="rz_zh1" name="rz_zh1"
							class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
							type="text">
					</div>
					<label class="col-sm-2 control-label">开户行</label>
					<div class="col-sm-3">
						<input id="rz_bank" name="rz_bank"
							class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
							type="text">
					</div>
				</div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">账号</label>
					<div class="col-sm-3">
						<input id="rz_zh2" name="rz_zh2"
							class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
							type="text">
					</div>
					<label class="col-sm-2 control-label">垫资金额</label>
					<div class="col-sm-3">
						<input id="rz_dzje" name="rz_dzje"
							class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
							type="text">
					</div>
					
				</div>			
				<div class="form-group">
					<label class="col-sm-2 control-label">垫资日期</label>
					<div class="col-sm-3">
						<div
							class="input-group date ng-isolate-scope ng-not-empty ng-valid">
							<input id="rz_date" name="rz_date" class="form-control" type="text"><span
								class="input-group-addon"><i class="fa fa-calendar"></i></span>
						</div>
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

	var form = new FormData(document.getElementById("zjfp_form"));
	$.ajax({
        url:"${pageContext.request.contextPath }/erp/erp_rz_102.do",
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
	</div></li>
	</c:if>