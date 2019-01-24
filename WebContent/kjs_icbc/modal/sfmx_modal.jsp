<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form name="modalForm" action="" class="form-horizontal">
	<table class="table table-bordered">
		<thead>
		     <tr>
		         <th>费用名称</th>
		         <th>费用报价(元)</th>
<!-- 		         <th>费用实收(元)</th>
 -->		         <th>退费(元)</th>
		         <th>费率</th>
		     </tr>
		 </thead>
		 <!-- ngIf: data.count >0 --><tbody ng-if="data.count >0 " class="ng-scope"> 
		     <!-- ngRepeat: item in displayedList --><tr ng-repeat="item in displayedList" class="ng-scope">
		     	 <td><!-- ngRepeat: opt in options |filter:{realValue:realValue}:true --><div ng-repeat="opt in options |filter:{realValue:realValue}:true" index="acct_fee_type" source="acctFeeType" real-value="item.feeType" class="ng-binding ng-scope">跨区业务服务费</div><!-- end ngRepeat: opt in options |filter:{realValue:realValue}:true --></td>
		         <td class="ng-binding">0</td>
<!-- 		         <td>{{item.netAmount==null?0:item.netAmount}}</td>
 -->		         <td class="ng-binding">0</td>
		         <td class="ng-binding">0%</td>
		     </tr><!-- end ngRepeat: item in displayedList --><tr ng-repeat="item in displayedList" class="ng-scope">
		     	 <td><!-- ngRepeat: opt in options |filter:{realValue:realValue}:true --><div ng-repeat="opt in options |filter:{realValue:realValue}:true" index="acct_fee_type" source="acctFeeType" real-value="item.feeType" class="ng-binding ng-scope">评估费</div><!-- end ngRepeat: opt in options |filter:{realValue:realValue}:true --></td>
		         <td class="ng-binding">0</td>
<!-- 		         <td>{{item.netAmount==null?0:item.netAmount}}</td>
 -->		         <td class="ng-binding">0</td>
		         <td class="ng-binding">0%</td>
		     </tr><!-- end ngRepeat: item in displayedList --><tr ng-repeat="item in displayedList" class="ng-scope">
		     	 <td><!-- ngRepeat: opt in options |filter:{realValue:realValue}:true --><div ng-repeat="opt in options |filter:{realValue:realValue}:true" index="acct_fee_type" source="acctFeeType" real-value="item.feeType" class="ng-binding ng-scope">汽车金融服务费</div><!-- end ngRepeat: opt in options |filter:{realValue:realValue}:true --></td>
		         <td class="ng-binding">0</td>
<!-- 		         <td>{{item.netAmount==null?0:item.netAmount}}</td>
 -->		         <td class="ng-binding">0</td>
		         <td class="ng-binding">0%</td>
		     </tr><!-- end ngRepeat: item in displayedList -->
		     <tr>
		     	<td>合计</td>
		     	<td class="ng-binding">0</td>
<!-- 		     	<td>{{data.totalNetAmount}}</td>
 -->		     	<td class="ng-binding">0</td>
		     </tr>
		 </tbody><!-- end ngIf: data.count >0 -->
	</table>  

</form>
<c:if test="${requestScope.type!='wdrw' }">
<div class="modal-footer">
<button onclick="location.href='${pageContext.request.contextPath}/erp/user_list_.do?type=wlghd&dn=${requestScope.cn }&qn=list&pagesize=10&pagenow=1'" class="btn btn-warning" >取消</button>
<button onclick="location.href=''" class="btn btn-primary" >提交</button>
</div>
</c:if>