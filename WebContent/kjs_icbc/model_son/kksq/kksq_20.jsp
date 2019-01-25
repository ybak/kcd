<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	long date = new Date().getTime();
	String dateString = formatter.format(date);
%>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'fkkkjg_20')==true}">
<li class="text-primary"><em>反馈开卡结果</em>
	<div class="big-conte" style="display: block;">
		<div style="float: left; margin-left: 20px; width: 260px;"
			class="ng-binding">
			<strong>开始时间：</strong><%=dateString%>
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
			<form id="kk_form" name="kk_form"
				class="form-horizontal ng-pristine ng-valid ng-scope">
	<input id="admin_id" name="admin_id" value="${sessionScope.pd.id }" type="hidden" />
    <input id="icbc_id" name="icbc_id" value="${requestScope.icbc_id }" type="hidden" />
    <input id="type_id" name="type_id" value="${requestScope.type_id }" type="hidden" />
    <input id="status_id" name="status_id" value="20" type="hidden" />
    <input id="yw_id" name="yw_id" value="${requestScope.yw_id }" type="hidden" />
	<input id="kk_id" name="kk_id" value="${pd.kkid }" type="hidden" />			
	<input id="icbc_name" name="icbc_name" value="${pd.c_name }" type="hidden" />
    <input id="icbc_adminid" name="icbc_adminid" value="${pd.icbc_adminid }" type="hidden" />
    <input id="dt_date" name="dt_date" value="${pData2.dt_edit }" type="hidden" />
	
				<div class="form-group">
					<label class="col-sm-2 control-label">开卡结果</label>
					<div class="col-sm-3">
					<select class="form-control" id="kk_status" name="kk_status" >
					<option value="0">--请选择--</option>
					<option value="1">开卡成功 </option>
					<option value="2">开卡失败</option>
					<option value="3">回退补件</option>
					</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">开卡日期</label>
					<div class="col-sm-3">
						<div
							class="input-group date ng-isolate-scope ng-not-empty ng-valid">
							<input class="form-control" id="kk_date" name="kk_date" placeholder="请选择日期" value="" type="text">
							<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
						</div>
					</div>
					<label class="col-sm-2 control-label">卡号</label>
					<div class="col-sm-3">
						<input  id="kk_kh" name="kk_kh" value=""
							class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
							type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">备注</label>
					<div class="col-sm-8">
						<textarea rows="3" id="kk_bz" name="kk_bz" value=""
							class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
							type="text"></textarea>
					</div>
				</div>

				<!-- 根据action确定操作  -->
				<!-- ngIf: !notUseButton -->
	<div class="modal-footer">
<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
<a onclick="erp_kksh()" class="btn btn-primary" >提交</a>
</div>
</form>
<script>
lay('#version').html('-v'+ laydate.v);
//执行一个laydate实例
laydate.render({
  elem: '#kk_date' //指定元素
});
</script>
<script type="text/javascript">
function erp_kksh(){
	var val=$("#kk_status").val();
	var kk_date=$("#kk_date").val();
	var kk_kh=$("#kk_kh").val();
    if(val==null||val==0){
        alert("请选择开卡审核结果!");
        return false;
    }else if(kk_date==""){
    	alert("请输入开卡日期!");
    }else if(kk_kh==""){
    	alert("请输入卡号!");
    }else{
		var form = new FormData(document.getElementById("kk_form"));
		$.ajax({
	        url:"${pageContext.request.contextPath }/erp/erp_kksh.do",
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