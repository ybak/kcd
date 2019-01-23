<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'ywxxxgsq_96')==true}">
<li class="text-primary">
<em>业务属性值修改申请:</em>
<div class="big-conte_">  
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
<form id="ywxxxgsh_96" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
   <!-- ngIf: notUseButton -->
	<input type="hidden" name="adminid" value="${sessionScope.pd.id}">
	<input type="hidden" name="type_id" value="${requestScope.type_id}"> 
	<input type="hidden" name="icbc_id" value="${pd.icbc_id}"> 
   <div class="form-group ng-scope">
		<label class="col-sm-2 control-label">业务类型</label>
		<div class="col-sm-6">
			<select id="ywlx" name="ywxxxgsh_96_ywlx"  class="form-control form-inline hidden-xs">
				<option value="">***业务类型***</option>
				<option value="征信查询">征信查询</option>
				<option value="征信通融">征信通融</option>
				<option value="车辆评估">车辆评估</option>
				<option value="银行电审">银行电审</option>
				<option value="开卡申请">开卡申请</option>
				<option value="视频面签">视频面签</option>
				<option value="跨区域业务审批">跨区域业务审批</option>
				<option value="汽车贷款">汽车贷款</option>
				<option value="内审通融">内审通融</option>
				<option value="资金分配">资金分配</option>
				<option value="银行贷款申请">银行贷款申请</option>
				<option value="公司归档">公司归档</option>
				<option value="抵押归档">抵押归档</option>
				<option value="业务信息修改">业务信息修改</option>
				<option value="退单退费">退单退费</option>
			</select>
		</div>
		<!-- 属性修改弹框 start -->
		<%-- <div class="form-group">
			<table class="table table-bordered" style="width:50%;margin-left:307px;margin-top:50px;">
			<thead>
			     <tr>
			         <th width="30%">业务属性</th>
			         <th>原值--&gt;更改值 
			         <button class="btn btn-sm btn-success" style="float:right;" type="button" ng-init="data.dataList=data.dataList?data.dataList:[];data.dataList.push({});" ng-click="data.dataList=data.dataList?data.dataList:[];data.dataList.push({});">
			            <i class="glyphicon glyphicon-plus"></i> 添加要修改的属性
			       	 </button>
			        </th>
			     </tr>
			 </thead>
			 <tbody class="ng-scope" ng-if="displayedList.count !=0 "> 
			 <tr class="ng-scope" ng-repeat="item in displayedList">
		         <td>
			         <select class="fieldAttr form-control ng-isolate-scope ng-empty ng-invalid ng-invalid-required ng-touched" required="required" ng-model="data.field[$index]" cg-required="" source="businessAttr" index="creditQuery" parent-id="tranCode" ng-options="opt.realValue as opt.displayValue for opt in options">
				         <option class="ng-binding" selected="selected" value="">--请选择--</option>
				         <option value="number:18" label="征信结果">征信结果</option>
				         <option value="number:19" label="征信内容">征信内容</option>
			         </select>
		         </td>
		         <td>
		         	<cg-dync-form class="ng-pristine ng-untouched ng-valid ng-isolate-scope ng-empty" ng-model="item.businessAttr" obj_model="businessAttr" parent-model="data.field[$index]"></cg-dync-form>
		         </td>
		     </tr>
			 </tbody>
			</table>
		</div> --%>
		<!-- 属性修改弹框 end -->
		
	</div><!-- end ngIf: notUseButton -->
	<!-- ngIf: !notUseButton -->
	<!-- ngIf: !notUseButton -->
	<!-- ngIf: task.tranCode&&!notUseButton -->
	<div class="form-group">
		<label class="col-sm-2 control-label">修改内容备注</label>
		<div class="col-sm-8">
			<textarea name="ywxxxgsh_96_xgbz" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text" ></textarea>
		</div>
	</div>
	<!-- ngIf: currentUser.orgType=='ALAN' -->
	<div class="ng-scope">
		<!-- <label class="col-sm-2 control-label">上传相关材料:</label>	
	     	<div style="overflow: hidden;margin-left: 7%;">
			</div> -->
			<div class="clear"></div> 
	<!-- ngIf: (!notUseButton&&rootData.taskDefKey == 'updateLoanField_updateLoan_operation1')||(notUseButton&&taskAct.activityId=='updateLoanField_updateLoan_operation1') -->
	<div class="form-group">
		<label class="col-sm-2 control-label">修改原因备注</label>
		<div class="col-sm-8">
			<textarea name="result_1_msg" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"></textarea>
		</div>
	</div>
	</div><!-- end ngIf: currentUser.orgType=='ALAN' -->
	<!-- ngIf: !notUseButton -->
<div class="modal-footer">
	<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
	<a onclick="erp_ywxxxgsh_96()"  class="btn btn-primary" >提交</a>	
</div>
</form>
<script type="text/javascript">
function erp_ywxxxgsh_96(){
	   	var form = new FormData(document.getElementById("ywxxxgsh_96"));
	   	$.ajax({
	           url:"${pageContext.request.contextPath}/erp/erp_ywxxxgsh_96.do",
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
</div>							  	
</li>
</c:if>