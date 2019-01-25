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
		elem : '#dz_date' //指定元素

	});
</script>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'sslr_51')==true}">
<li class="text-primary"><em>实收录入-出纳</em>
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
			<form id="zjfp_form" name="zjfp_form"
				class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
	<input id="admin_id" name="admin_id" value="${sessionScope.pd.id }" type="hidden" />
    <input id="icbc_id" name="icbc_id" value="${requestScope.icbc_id }" type="hidden" />
    <input id="type_id" name="type_id" value="${requestScope.type_id }" type="hidden" />
    <input id="status_id" name="status_id" value="51" type="hidden" />
    <input id="yw_id" name="yw_id" value="${requestScope.yw_id }" type="hidden" />
	<input id="gems_id" name="gems_id" value="${requestScope.pd.gemsid }" type="hidden" />	
	<input id="fs_id" name="fs_id" value="${requestScope.pd.fsid }" type="hidden" />
	<input id="dz_type" name="dz_type" value="${pd.dz_type}" type="hidden"    />
				
				<div class="form-group">
					<label class="col-sm-2 control-label">
						<!-- ngIf: task.payfriendId == 0 -->
						<!-- ngIf: task.payfriendId != 0 --> 
						<span class="ng-scope">垫资日期</span>
					<!-- end ngIf: task.payfriendId != 0 -->
					</label>
					<div class="col-sm-3">
						<div
							class="input-group date ng-isolate-scope ng-not-empty ng-valid">
							<input id="dz_date" name="dz_date" class="form-control" type="text"> <span
								class="input-group-addon"><i class="fa fa-calendar"></i></span>
						</div>
					</div>
					<label class="col-sm-2 control-label">
						<!-- ngIf: task.payfriendId == 0 -->
						<!-- ngIf: task.payfriendId != 0 --> 
						<span class="ng-scope">垫资金额(元)</span>
					<!-- end ngIf: task.payfriendId != 0 -->
					</label>
					<div class="col-sm-3">
						<input id="dz_je" name="dz_je"
							class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
							type="text">
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-2 control-label">收款情况<span class="red">*</span></label>
					<div class="col-sm-8">
						<span> <input type="radio" value="2" id="sk_type2"
							class="ng-pristine ng-untouched ng-valid ng-not-empty"
							name="sk_type"> 到账确认，部分金额待核验&nbsp;&nbsp;&nbsp;&nbsp; <br></span>
						<input type="radio" value="1" id="sk_type1"
							class="ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required"
							name="sk_type"> 到账确认，本单已完整 &nbsp;&nbsp;&nbsp;&nbsp;<br>
						<input type="radio" value="3" id="sk_type3"
							class="ng-pristine ng-untouched ng-v alid ng-not-empty"
							name="sk_type"> 金额不符 &nbsp;&nbsp;&nbsp;&nbsp;<br>
					</div>
				</div>
				<!-- ngIf: task.recieveRet==-1 -->
				<div class="form-group">
					<label class="col-sm-2 control-label">其它说明</label>
					<div class="col-sm-8">
						<textarea id="qtsm"  name="qtsm"
							class="form-control"
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
	var val=$('input:radio[name="sk_type"]:checked').val();
	var dz_date = $("#dz_date").val();
	var dz_je = $("#dz_je").val();
    if(val==null){
        alert("请选择收款情况结果!");
        return false;
    }else if(dz_date==""){
    	alert("请选择垫资日期!");
    }else if(dz_je==""){
    	alert("请选择垫资金额(元)!");
    }else{
		var form = new FormData(document.getElementById("zjfp_form"));
		$.ajax({
	        url:"${pageContext.request.contextPath }/erp/erp_zjfp_51.do",
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