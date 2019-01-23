<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'skqr_62')==true}">
<li class="text-primary">
<em>收款确认</em>
<div class="big-conte_">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong></div>
<strong style="margin-left:10px;">
<i>处理信息：</i></strong><br>
<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form id="yhdksh_62" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required" >
	<input type="hidden" name="adminid" value="${sessionScope.pd.id}">
	<input type="hidden" name="type_id" value="${requestScope.type_id}"> 
	<input type="hidden" name="icbc_id" value="${pd.icbc_id}"> 
	<div id="haha" class="form-group">
		<label class="col-sm-2 control-label">放款日期<i class="red">*</i></label>
		<div class="col-sm-3">
			<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required">
 			 <input placeholder="请选择日期" id="date_62_1" name="yhdksh_62_fkrq" class="form-control" type="text" ><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
			</div>
		</div>
		<label class="col-sm-2 control-label">放款金额<i class="red">*</i></label>
		<div class="col-sm-3">
			<input id="yhdksh_62_fkje" name="yhdksh_62_fkje" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required" type="text">
		</div>
	</div>
	<div style="display:none;"> <!--  and (!empty erp15.result_1_value) -->
		<c:forEach var="erp15" items="${requestScope.erp15}" varStatus="status">
			<c:if test="${status.last}">
				<c:choose>
					<c:when test="${requestScope.erp_status eq '62'}">
						<textarea id="_inObj_61">${erp15.result_1_value}</textarea>
						<script>
						var index = ${status.index+1};
						// 61 处理 json ,并给相应的对象赋值
						var objS_61index = JSON.parse($("#_inObj_61").val()); //由JSON字符串转换为JSON对象
						document.getElementById("date_62_1").value = objS_61index['61_date'];
						document.getElementById("yhdksh_62_fkje").value = objS_61index['61_je']; 
						</script>
					</c:when>
					<c:otherwise>
						<script type="text/javascript">
							$("#haha").hide();//隐藏div
						</script>
					</c:otherwise>
				</c:choose>
			</c:if>
		</c:forEach>
	</div>
<!-- 	<div class="form-group">
		<label class="col-sm-2 control-label">垫资/划付金额</label>
		<div class="col-sm-3">
			<input class="form-control" type="text"	ng-model="task.payAmount" cg-required required/>
		</div>
		<label class="col-sm-2 control-label">差额</label>
		<div class="col-sm-3">
			<input class="form-control" type="text" ng-model="task.netting"  ng-value="(task.bankAmount-task.payAmount).toFixed(4)" disabled="true" />(计算方式:放贷额-垫资金额)
		</div>
	</div> -->
	<div class="form-group">
		<label class="col-sm-2 control-label">收款情况<span class="red">*</span></label> 
		<div class="col-sm-8">
			<input name="result_1_code" type="radio" value="1" class="ng-pristine ng-untouched ng-valid ng-not-empty"  >到账确认，本单已完整  &nbsp;&nbsp;&nbsp;&nbsp;
	        <input name="result_1_code" type="radio" value="3" class="ng-pristine ng-untouched ng-valid ng-not-empty"  >收款金额不符&nbsp;&nbsp;&nbsp;&nbsp;
	        <input name="result_1_code" type="radio" value="2" class="ng-pristine ng-untouched ng-valid ng-not-empty"  >未收到款项
        </div>
    </div>
    <div class="form-group">
		<label class="col-sm-2 control-label">收款日期<i class="red">*</i></label>
		 <div class="col-sm-3">
			<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required" >
  <input placeholder="请选择日期" id="date_62_2" name="yhdksh_62_sqrq" class="form-control" type="text" ><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
</div>
		</div>  
		<!-- ngIf: task.creditsMoney -->
		<!-- ngIf: task.creditsMoney -->
	</div>
    <!-- ngIf: task.recieveRet==0 -->
	<div class="form-group">
		<label class="col-sm-2 control-label">其它说明</label>
		<div class="col-sm-8">
			<textarea name="result_1_msg" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"  ></textarea>
		</div>
	</div>

	<!-- 根据action确定操作  -->
	<!-- ngIf: !notUseButton -->
	<div class="modal-footer">
		<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
		<a onclick="erp_yhdksh_62()" class="btn btn-primary" >提交</a>
	</div>
</form>

<script>
lay('#version').html('-v'+ laydate.v);
//执行一个laydate实例
laydate.render({
  elem: '#date_62_1'
});
laydate.render({
  elem: '#date_62_2'
});
</script>

<script type="text/javascript">
function erp_yhdksh_62(){
	var val=$('input:radio[name="result_1_code"]:checked').val();
    if(val==null){
        alert("请选择收款情况!");
    }else{
	   	var form = new FormData(document.getElementById("yhdksh_62"));
	   	$.ajax({
	           url:"${pageContext.request.contextPath}/erp/erp_yhdksh_62.do",
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