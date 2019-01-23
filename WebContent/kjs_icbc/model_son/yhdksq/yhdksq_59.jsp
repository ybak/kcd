<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'yhsjqr_59')==true}">
<li class="text-primary">
<em>银行收件确认</em>
<div class="big-conte_" >  
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
<form id="yhdksh_59" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
	<input type="hidden" name="adminid" value="${sessionScope.pd.id}">
	<input type="hidden" name="type_id" value="${requestScope.type_id}"> 
	<input type="hidden" name="icbc_id" value="${pd.icbc_id}"> 
	<div class="form-group">
		<label class="col-sm-2 control-label">收件确认</label>
		<div class="col-sm-3">
			<input type="radio" value="已收到"   class="ng-pristine ng-untouched ng-valid ng-not-empty" name="yhdksh_59_msg">已收到
	            &nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="radio" value="未收到" class="ng-pristine ng-untouched ng-valid ng-not-empty" name="yhdksh_59_msg">未收到
		</div>
		<label class="col-sm-2 control-label">收件日期</label>
		<div class="col-sm-3">
			<div class="input-group date ng-isolate-scope ng-empty ng-valid" >
  			<input placeholder="请选择日期" id="date_59_1" name="yhdksh_59_date" class="form-control" type="text"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">材料复核结果</label>
		<div class="col-sm-3">
			<input type="radio" value="1"  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code">通过
	            &nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="radio" value="2"  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code">不通过
		</div>
		<!-- ngIf: rootData.taskDefKey=='postget'||taskAct.activityId=='postget' -->
		<span class="ng-scope">
	    	<label class="col-sm-2 control-label">进银行日期</label>
			<div class="col-sm-3">
				<div class="input-group date ng-isolate-scope ng-empty ng-valid">
  <input placeholder="请选择日期" id="date_59_2"  name="yhdksh_59_jyhrq" class="form-control" type="text"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
</div>
			</div>
		</span><!-- end ngIf: rootData.taskDefKey=='postget'||taskAct.activityId=='postget' -->
		<!-- ngIf: rootData.taskDefKey=='loanOrder_postget_asun'||rootData.taskDefKey=='loanOrder_postget_bank'||taskAct.activityId=='loanOrder_postget_asun'||taskAct.activityId=='loanOrder_postget_bank' -->
	</div>
	<!-- ngIf: (rootData.taskDefKey&&rootData.taskDefKey =='loanOrder_postget_asun')||(taskAct.activityId&&taskAct.activityId=='loanOrder_postget_asun') -->
	<!-- ngIf: (rootData.taskDefKey&&rootData.taskDefKey == 'loanOrder_postget_asun')||(taskAct.activityId&&taskAct.activityId=='loanOrder_postget_asun') --> 
	<!-- ngIf: (rootData.taskDefKey&&rootData.taskDefKey == 'loanOrder_postget_asun')||(taskAct.activityId&&taskAct.activityId=='loanOrder_postget_asun') -->
	<!-- ngIf: (rootData.taskDefKey=='loanOrder_postget_bank'||rootData.taskDefKey=='loanOrder_postget_asun')&&!notUseButton -->
	<!-- ngIf: rootData.taskDefKey=='loanOrder_postget_org'||taskAct.activityId=='loanOrder_postget_org' -->
	<div style="margin-top: 5%" class="clear"></div>
	<div class="form-group">
		<label class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea name="result_1_msg" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"></textarea>
		</div>
	</div> 
	<!-- ngIf: !notUseButton -->
	<div class="modal-footer">
		<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
		<a onclick="erp_yhdksh_59()" class="btn btn-primary" >提交</a>
	</div>
</form>
<script>
lay('#version').html('-v'+ laydate.v);
//执行一个laydate实例
laydate.render({
  elem: '#date_59_1',  
});
laydate.render({
   elem: '#date_59_2'
});
</script>
<script type="text/javascript">
function erp_yhdksh_59(){
	var val=$('input:radio[name="yhdksh_59_msg"]:checked').val();
	var vall=$('input:radio[name="result_1_code"]:checked').val();
    if(val==null){
        alert("请选择收件结果!");
    }else if(vall==null){
    	alert("请选择材料复核结果!");
    }else{
	   	var form = new FormData(document.getElementById("yhdksh_59"));
	   	$.ajax({
	           url:"${pageContext.request.contextPath}/erp/erp_yhdksh_59.do",
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