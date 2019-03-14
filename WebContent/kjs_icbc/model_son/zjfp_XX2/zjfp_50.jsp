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
		elem : '#dk_date' //指定元素

	});
</script>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'cz_50')==true}">
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
    <input id="status_id" name="status_id" value="50" type="hidden" />
    <input id="yw_id" name="yw_id" value="${requestScope.yw_id }" type="hidden" />
	<input id="gems_id" name="gems_id" value="${requestScope.pd.gemsid }" type="hidden" />	
	<input id="fs_id" name="fs_id" value="${requestScope.pd.fsid }" type="hidden" />
	<input id="dz_type" name="dz_type" value="${pd.dz_type}" type="hidden"    />

				<div class="form-group">
					<label class="col-sm-2 control-label">机构名称<i class="red">*</i></label>
					<div class="col-sm-3">
						<select class="form-control m-select" name="gems_fs_id" id="gems_fs_id" data-edit-select="1" style="display: none;">
						<option value="0">--请选择--</option>
							<c:forEach var="fs" items="${requestScope.fs}">
	                        	<option value="${fs.id }">${fs.namepy }-${fs.name }</option>	
	                        </c:forEach>
						</select>
					</div>
					<label class="col-sm-2 control-label">开户行</label>
					<div class="col-sm-3">
						<input id="kh_bank" name="kh_bank"
							class="form-control"
							type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">开户名</label>
					<div class="col-sm-3">
						<input id="kh_name" name="kh_name"
							class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
							type="text">
					</div>
					<label class="col-sm-2 control-label">账号</label>
					<div class="col-sm-3">
						<input id="zh" name="zh"
							class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
							type="text">
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">应支付金额(元)</label>
					<div class="col-sm-3">
						<input id="yzfje" name="yzfje"
							class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
							type="text">
					</div>
					<label class="col-sm-2 control-label">服务费(元)</label>
					<div class="col-sm-3">
						<input id="fwf" name="fwf"
							class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
							type="text">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">打款日期</label>
					<div class="col-sm-3">
						<div
							class="input-group date ng-isolate-scope ng-not-empty ng-valid">
							<input id="dk_date" name="dk_date" class="form-control" type="text"><span
								class="input-group-addon"><i class="fa fa-calendar"></i></span>
						</div>
					</div>
					<label class="col-sm-2 control-label">实际打款金额(元)</label>
					<div class="col-sm-3">
						<input id="sjdkje" name="sjdkje"
							class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
							type="text">
					</div>
				</div>
				<!-- ngIf: task.creditsMoney -->
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
	var gems_fs_id = $("#gems_fs_id").val();
	var kh_bank = $("#kh_bank").val();
	var kh_name = $("#kh_name").val();
	var zh = $("#zh").val();
	var yzfje = $("#yzfje").val();
	var fwf = $("#fwf").val();
	var dk_date = $("#dk_date").val();
	var sjdkje = $("#sjdkje").val();
	var gems_fs_id = $("#gems_fs_id").val();
	if(gems_fs_id==0){
		alert("请选择机构!");
	}else if(kh_bank==""){
		alert("请输入开户行!");
	}else if(kh_name==""){
		alert("请输入开户名!");
	}else if(zh==""){
		alert("请输入账号!");
	}else if(yzfje==""){
		alert("请输入应支付金额(元)!")
	}else if(fwf==""){
		alert("请输入服务费(元)!")
	}else if(dk_date==""){
		alert("请输入打款日期!")
	}else if(sjdkje==""){
		alert("请输入实际打款金额(元)!")
	}else{
		var form = new FormData(document.getElementById("zjfp_form"));
		$.ajax({
	        url:"${pageContext.request.contextPath }/erp/erp_zjfp_50.do",
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