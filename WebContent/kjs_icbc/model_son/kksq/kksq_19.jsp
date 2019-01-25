<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<% 
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
long date = new Date().getTime();
String dateString = formatter.format(date);
%>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'sfhcjg_19')==true}">
<li class="text-primary"><em>身份核查结果</em>
	<div class="big-conte" style="display: block;">
		<div style="float: left; margin-left: 20px; width: 260px;"
			class="ng-binding">
			<strong>开始时间：</strong><%=dateString %>
		</div>
		<div style="float: left; margin-left: 20px; width: 260px;"
			class="ng-binding">
			<strong>处理时间：</strong>
		</div>
		<div style="float: left; margin-left: 20px; width: 260px;"
			class="ng-binding">
			<strong>处理人：</strong>
		</div>
		<strong style="margin-left: 10px;"><i>处理信息：</i></strong><br>
		<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
		<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
		<div class="task_margin ng-scope"
			style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">
			<form id="kkform" name="kkform"
				class="form-horizontal ng-pristine ng-valid ng-scope">
	<input id="admin_id" name="admin_id" value="${sessionScope.pd.id }" type="hidden" />
    <input id="icbc_id" name="icbc_id" value="${requestScope.icbc_id }" type="hidden" />
    <input id="type_id" name="type_id" value="${requestScope.type_id }" type="hidden" />
    <input id="status_id" name="status_id" value="19" type="hidden" />
    <input id="yw_id" name="yw_id" value="${requestScope.yw_id }" type="hidden" />
	<input id="kk_id" name="kk_id" value="${pd.kkid }" type="hidden" />	
	<input id="icbc_name" name="icbc_name" value="${pd.c_name }" type="hidden" />
    <input id="icbc_adminid" name="icbc_adminid" value="${pd.icbc_adminid }" type="hidden" />
    <input id="dt_date" name="dt_date" value="${pData2.dt_edit }" type="hidden" />
				<!-- ngIf: notUseButton -->
				<div class="form-group ng-scope">
					<label class="col-sm-2 control-label">审核结果</label>
					<div class="col-sm-6">
						<input type="radio" value="1"  onchange="showradio('kk_status',this.value)" id="kk_status" name="kk_status"
							class="ng-pristine ng-untouched ng-valid ng-not-empty"
							>通过 &nbsp;&nbsp;&nbsp;&nbsp; <input
							type="radio" value="3"  onchange="showradio('kk_status',this.value)" id="kk_status" name="kk_status"
							class="ng-pristine ng-untouched ng-valid ng-not-empty"
							>回退补件
					</div>
				</div>
				<!-- end ngIf: notUseButton -->
				<div class="form-group">
					<label class="col-sm-2 control-label">意见说明</label>
					<div class="col-sm-8">
						<textarea  id="yjsm" name="yjsm" rows="3"
							class="form-control"
							type="text"></textarea>
					</div>
				</div>
				<!-- 根据action确定操作  -->
				<!-- ngIf: !notUseButton -->
<div class="modal-footer">
<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
<a onclick="erp_kksfsh()" class="btn btn-primary" >提交</a>
</div>
</form>
<script type="text/javascript">
function erp_kksfsh(){
	var val=$('input:radio[name="kk_status"]:checked').val();
    if(val==null){
        alert("请选择审核结果!");
        return false;
    }else{
		var form = new FormData(document.getElementById("kkform"));
		$.ajax({
	        url:"${pageContext.request.contextPath }/erp/erp_kksfsh.do",
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
	</div></li>
	</c:if>