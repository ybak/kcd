<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
</style>
<%
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	long date = new Date().getTime();
	String dateString = formatter.format(date);
%>
<script>
	lay('#version').html('-v' + laydate.v);
	//执行一个laydate实例
	laydate.render({
		elem : '#dz_date' //指定元素
	});
</script>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'cwqrdz_52')==true}">
<li class="text-primary"><em>公司财务确认到账</em>
	<div class="big-conte" style="display: block;">
		<div style="float: left; margin-left: 20px; width: 260px;"
			class="ng-binding">
			<strong>开始时间：</strong><%=dateString%>
		</div>
		<br>
		<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
		<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
		<div class="task_margin ng-scope"
			style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">
			<form name="zjfp_form" id="zjfp_form"
				class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
	<input id="admin_id" name="admin_id" value="${sessionScope.pd.id }" type="hidden" />
    <input id="icbc_id" name="icbc_id" value="${requestScope.icbc_id }" type="hidden" />
    <input id="type_id" name="type_id" value="${requestScope.type_id }" type="hidden" />
    <input id="status_id" name="status_id" value="52" type="hidden" />
    <input id="yw_id" name="yw_id" value="${requestScope.yw_id }" type="hidden" />
	<input id="gems_id" name="gems_id" value="${requestScope.pd.gemsid }" type="hidden" />	
	<input id="fs_id" name="fs_id" value="${requestScope.pd.fsid }" type="hidden" />
	
	<div class="form-group ng-scope">
		<label class="col-sm-2 control-label">确认垫资申请</label>
		<div class="col-sm-3">
			<select class="form-control" id="dz_type" name="dz_type">
				<option value="0">--请选择--</option>
				<option value="1" ${requestScope.pd.dz_type eq '1'?"selected='selected'":'' }>不垫资</option>
				<option value="2" ${requestScope.pd.dz_type eq '2'?"selected='selected'":'' }>提车垫资</option>
			</select>
		</div>
	</div><!-- end ngIf: notUseButton && (rootData.taskDefKey=='loanOrder_leadercheck_pay'||taskAct.activityId=='loanOrder_leadercheck_pay') -->
	<!-- ngIf: rootData.taskDefKey=='loanOrder_leadercheck_pay'||taskAct.activityId=='loanOrder_leadercheck_pay' -->
	<div class="form-group ng-scope">
		<label class="col-sm-2 control-label">需垫资金额(元)<i class="red">*</i></label>
		<div class="col-sm-3">
			<input id="xdzje" name="xdzje"  value="${requestScope.xdzje}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required" type="text">
		</div>
				<label class="col-sm-2 control-label">融资服务费</label>
		<div class="col-sm-3">
			<input id="rzfwf" name="rzfwf"  value="${requestScope.rzfwf}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
		</div>
	</div>
					<div class="form-group">
					<label class="col-sm-2 control-label">收款情况<span class="red">*</span></label>
					<div class="col-sm-8">
						<span> 
						<input type="radio" value="1"
							class="ng-pristine ng-untouched ng-valid ng-not-empty" id="skqk"
							name="skqk"> 到账确认，部分金额待核验&nbsp;&nbsp;&nbsp;&nbsp; <br></span>
						<input type="radio" value="2" id="skqk"
							class="ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required"
							name="skqk"> 到账确认，本单已完整 &nbsp;&nbsp;&nbsp;&nbsp;<br>
						<input type="radio" value="3" id="skqk"
							class="ng-pristine ng-untouched ng-valid ng-not-empty"
							name="skqk"> 金额不符 &nbsp;&nbsp;&nbsp;&nbsp;<br>
					</div>
				</div>
	<div class="form-group">
	<label class="col-sm-2 control-label">其它意见</label>
		<div class="col-sm-8">
			<textarea id="qtyj" name="qtyj" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"></textarea>
		</div>
	</div>

	<div class="modal-footer">
<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
<a onclick="erp()" class="btn btn-primary" >提交</a>
</div>
</form>
<script type="text/javascript">
function erp(){
    var dz_type = document.getElementById("dz_type").value;	
    var val=$('input:radio[name="skqk"]:checked').val();
    if(val==null){
        alert("请选择收款情况结果!");
        return false;
    }else if(dz_type==0){
    	alert("请选择是否申请垫资!");
    }else{
		var form = new FormData(document.getElementById("zjfp_form"));
		$.ajax({
	        url:"${pageContext.request.contextPath }/erp/erp_zjfp_52.do",
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