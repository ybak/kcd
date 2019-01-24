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
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'financing_101')==true}">
<li class="text-primary"><em>融资结果</em>
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
    <input id="status_id" name="status_id" value="101" type="hidden" />
    <input id="yw_id" name="yw_id" value="${requestScope.yw_id }" type="hidden" />
	<input id="gems_id" name="gems_id" value="${requestScope.pd.gemsid }" type="hidden" />	
	<input id="fs_id" name="fs_id" value="${requestScope.pd.fsid }" type="hidden" />
	<input id="icbc_name" name="icbc_name" value="${pd.c_name }" type="hidden" />
    <input id="icbc_adminid" name="icbc_adminid" value="${pd.icbc_adminid }" type="hidden" />
    <input id="dt_date" name="dt_date" value="${pData2.dt_edit }" type="hidden" />
	<textarea id="rz_101"
					name="rz_101"
					style="display: none;">${pData2.result_1_value }</textarea>
					<script type="text/javascript">
					$(document).ready(function(){						
						var rz_101=document.getElementById("rz_101").value;
						if(rz_101!=null){
						var json = jQuery
								.parseJSON(rz_101);
						for ( var item in json) {							
								$("#rz_dzhb").val(json["dzhb"]);								
						}
						}  
					});
					</script>
	<div class="form-group">
		<label class="col-sm-2 control-label">垫资伙伴</label>
		<div class="col-sm-3"> 
			<select id="rz_dzhb" name="rz_dzhb"  class="form-control">
			<option value="" >--请选择--</option>
			<option value="1">金锤资产</option>
			</select>
		</div>
		<label class="col-sm-2 control-label">融资结果</label>
		<div class="col-sm-3"> 
			<select id="rz_jg" name="rz_jg" class="form-control">
			<option value="0">--请选择--</option>
			<option value="1">成功</option>
			<option value="2">失败</option>
			</select>
        </div>
	</div>   

	<div class="form-group"> 
	        <label class="col-sm-2 control-label">融资金额(元)<span class="red">*</span></label> 
			<div class="col-sm-3">
				<input id="rz_je" name="rz_je" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"  type="text">
			</div>
        <label class="col-sm-2 control-label">放贷日期<i class="red">*</i></label>
		<div class="col-sm-3">
			<div class="input-group date ng-isolate-scope ng-empty ng-valid" >
        <input  id="rz_fdrq" name="rz_fdrq" class="form-control" type="text">
        <span class="input-group-addon">
        <i class="fa fa-calendar"></i></span>
           </div>
		</div>
	</div> 
	<div class="form-group">
			<label class="col-sm-2 control-label">垫资材料附件</label>
			<div class="col-sm-3">
				<button disabled="disabled" class="btn btn-primary">批量下载垫资材料附件</button>
			</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">其它信息说明</label>
		<div class="col-sm-8">
		<textarea id="rz_qtxx" name="rz_qtxx" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"></textarea>
		</div>
	</div> 

	<div class="modal-footer">
<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
<a onclick="erp()" class="btn btn-primary" >提交</a>
</div>
</form>
<script>
lay('#version').html('-v'+ laydate.v);
//执行一个laydate实例
laydate.render({
  elem: '#rz_fdrq' //指定元素
});
</script>
<script type="text/javascript">
function erp(){
	if(document.getElementById("rz_jg").value!=0){
	var form = new FormData(document.getElementById("zjfp_form"));
	$.ajax({
        url:"${pageContext.request.contextPath }/erp/erp_rz_101.do",
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
		alert("请认真审核！！");
	}
}


</script>
		</div>
	</div></li>
	</c:if>