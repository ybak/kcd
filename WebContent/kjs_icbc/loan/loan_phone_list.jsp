<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="content-wrapper" style="min-height: 943px;">
<script type="text/javascript">
    function a3(){
		var s=$("#page_limit_select").val();
		var status=$("#status").val();
		var querytype=$("#querytype").val();		
		window.location.href ="${pageContext.request.contextPath}/loan/selectPhoneList.do?type_id=${requestScope.type_id}&type_status=${requestScope.type_status}&type=${requestScope.type}&dn=${requestScope.dn}&qn=list&pagesize="+s+"&pagenow=1";
    }
    </script>
		<section class="content-header">
			<h1>
			电催作业<small>
			共${requestScope.totalsize}个
			</small>
			</h1>
		</section>
		<!-- Main content -->
		<section class="content">
			<div class="admin-tools">
				<div class="row">
					<div class="col-sm-10">
							<label>
								逾期情况
								<select onchange="" class="form-control form-inline hidden-xs">
									<option value="">***逾期情况***</option>
									<option value="1">初级</option>
									<option value="2">中级</option>
									<option value="3">高级</option>
								</select>
							</label>	
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<label>
							金融产品
							<select class="form-control form-inline hidden-xs">
								<option value="">***金融产品***</option>
							</select>
							</label>	
							
							<form class="form-horizontal" name="myform" action="${pageContext.request.contextPath }/loan/selectPhoneList.do?type_id=${requestScope.type_id}&type_status=${requestScope.type_status}&type=${requestScope.type}&dn=${requestScope.dn}&qn=list&pagesize=${requestScope.pagesize}&pagenow=1" method="post">
								<input autocomplete="off" type="text" placeholder="请输入客户姓名或身份证号" name="param" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" style="width:500px;">
								<button class="btn btn-info search-btn" type="submit" style="background-color:#00acd6;">查询</button>   			
								<button class="btn btn-info search-btn" type="button" onclick="reset()" style="background-color:#00acd6;">重置</button>   																	
								<button class="btn btn-info search-btn" type="button" onclick="config()" style="background-color:#FFA500;">配置</button> 
								<!-- <i class="fa fa-search-plus" onclick="config()"></i> -->
							</form>
							
					</div>		
					<div class="col-sm-2 admin-page-top hidden-xs">
					   <div class="btn-group">											
					   <ul class="pagination no-margin">					     				       
						<li>
						<select id="page_limit_select" onchange="a3()" class="form-control">
						    <option value="${requestScope.pagesize}">当前每页${requestScope.pagesize}条</option>
							<option value="10">每页10条</option>
							<option value="20">每页20条</option>
							<option value="30">每页30条</option>
							<option value="40">每页40条</option>
							<option value="50">每页50条</option>
							<option value="60">每页60条</option>
							<option value="70">每页70条</option>
							<option value="80">每页80条</option>
							<option value="90">每页90条</option>
							<option value="100">每页100条</option>
						</select>
						</li>
						<li>
							<%
							int pagenow1=Integer.parseInt(request.getAttribute("pagenow").toString());
						    int totalpage1=Integer.parseInt(request.getAttribute("totalpage").toString());
						    if(pagenow1>1&&pagenow1<=totalpage1){
							%>
							<a href="${pageContext.request.contextPath }/loan/selectPhoneList.do?type_id=${requestScope.type_id}&type_status=${requestScope.type_status}&type=${requestScope.type}&dn=${requestScope.dn}&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow-1}" class="btn btn-default">«</a>						
							<%				    	
					         }						
							 if(pagenow1>=1&&pagenow1<totalpage1){
							%>
							<a href="${pageContext.request.contextPath }/loan/selectPhoneList.do?type_id=${requestScope.type_id}&type_status=${requestScope.type_status}&type=${requestScope.type}&dn=${requestScope.dn}&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow+1}" class="btn btn-default">»</a>
	                        <%
	                        }
	                        %>
                        </li>
						</ul>
					   </div>	
							</div>
			</div>
		</div>
		<div class="box">
			<!-- 数据载入中 请在搜索，筛选，载入的时候显示 放在.box里 -->
			<div class="overlay" style="display:none;">
				<i class="fa fa-refresh fa-spin"></i>
			</div>
			<!-- 数据载入中结束 -->
			<table class="table table-bordered table-hover">
				<tbody>	
					<tr>
						<th style="width:3%" class="text-center hidden-xs"><input class="check_all" type="checkbox"></th>
						<th class="text-center">订单编号</th>
						<th class="text-center">客户姓名</th>
						<th class="text-center">身份证号</th>
						<th class="text-center">金融产品</th>
						<th class="text-center">贷款金额</th>
						<th class="text-center" >逾期金额</th>
						<th class="text-center" >逾期天数</th>
						<th class="text-center" >代理团队</th>
						<th class="text-center" >业务员</th>
						<th class="text-center" >催收人员</th>
						<th class="text-center" >操作</th>
					</tr>
					<c:forEach items="${requestScope.newpdList}" var="sel">
					<tr>
						<td class="text-center hidden-xs">
						<input name="delid"  type="checkbox">
						</td>
						<td class="text-center ">${sel.gems_code}</td>
						<td class="text-center">${sel.c_name}</td>
						<td class="text-center">${sel.c_cardno}</td>
						<td class="text-center">${sel.bank_name}</td>
						<td class="text-center">${sel.dk_total_price}</td>
						<td class="text-center">${sel.overdue_amount}</td>
						<td class="text-center">
							<input type="hidden" value="${sel.overdue_days}"> 
							<c:choose>
								<c:when test="${sel.overdue_days >= 10}"><span class="label label-danger">高级逾期</span></c:when>
								<c:when test="${sel.overdue_days >= 3}"><span class="label label-warning">中级逾期</span></c:when>
								<c:when test="${sel.overdue_days >= 0}"><span class="label label-success">初级逾期</span></c:when>
								<c:otherwise>${sel.overdue_days}天</c:otherwise>
							</c:choose>
						</td>
						<td class="text-center">${sel.fs_name}</td>
						<td class="text-center">${sel.gems_name}</td>
						<td class="text-center">${sel.gems_name}</td>
						<td class="text-center">
							<a href="${pageContext.request.contextPath }/loan/selectPhoneForm.do?type=dczy&dn=loan_phone&qn=form&id=${sel.id}">
								<i class="fa fa-hand-paper-o"></i>
							</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
		<div class="foot-page">
			<c:if test="${requestScope.totalpage ge '1' }">
				<ul class="pagination no-margin">
				       <c:if test="${requestScope.pagenow ne '1' }">
				        <li><a href="${pageContext.request.contextPath }/loan/selectPhoneList.do?type_id=${requestScope.type_id}&type_status=${requestScope.type_status}&type=${requestScope.type}&dn=${requestScope.dn}&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow-1}" aria-label="Next"><span aria-hidden="true">«</span></a></li>
				       </c:if>
					   <%
				       int pagenow=Integer.parseInt(request.getAttribute("pagenow").toString());
				       int totalpage=Integer.parseInt(request.getAttribute("totalpage").toString());
				       int i=5; 
				       int h=1;
				    	 if(totalpage>=5){
				    		  if((pagenow-1)%4==0){
				    			 h=pagenow;
				    			 i=pagenow+4;
				    		  }else{
				    			 h=4*(pagenow-1-((pagenow-1)%4))/4+1;
				    			 i=h+4;
				    		  }				    		  
				    	  }else{
				    		i=totalpage;
				    	  } 
				       for(int j=h;j<i+1;j++){				    	   				    	   
				       if(j==pagenow){
				       %>
					   <li id="l<%=j %>" class="active">
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/loan/selectPhoneList.do?type_id=${requestScope.type_id}&type_status=${requestScope.type_status}&type=${requestScope.type}&dn=${requestScope.dn}&qn=list&pagesize=${requestScope.pagesize}&pagenow=<%=j %>">
					   <%=j %>
					   </a>
					   </li>
					   <%
				       }else{
					   %>
	                   <li id="l<%=j %>" >
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/loan/selectPhoneList.do?type_id=${requestScope.type_id}&type_status=${requestScope.type_status}&type=${requestScope.type}&dn=${requestScope.dn}&qn=list&pagesize=${requestScope.pagesize}&pagenow=<%=j %>">
					   <%=j %>					   
					   </a>
					   </li>					   
		               <%
				       }
				       if(j>=totalpage){
					    	  j=i+1; 
					   }
				       }				
		               %>
					   <c:if test="${requestScope.pagenow lt requestScope.totalpage}">
			               <c:if test="${requestScope.totalpage gt 5}">
						  <li><a href="${pageContext.request.contextPath }/loan/selectPhoneList.do?type_id=${requestScope.type_id}&type_status=${requestScope.type_status}&type=${requestScope.type}&dn=${requestScope.dn}&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow+1}" aria-label="Next"><span aria-hidden="true">»</span></a></li>  
						   </c:if>
					   </c:if>
					     				
					   </ul>
			</c:if>		   
				<div class="page-num">共${requestScope.totalsize}个 分${requestScope.totalpage }页显示</div>
			</div>
	</section>
	<!-- /.content -->
</div>
<script>
function config(){
	$('#myModal').modal({ show: true });
}
</script>
	<!-- 模态框 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="addModal_nstrLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title">逾期配置</h4>
	            </div>
	            <div class="modal-body" style="height:450px;">
	             <!-- 模态框插入内容 start -->
	             		<li class="text-primary">
						<div class="big-conte_">  
						<div class="task_margin ng-scope" style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
						<form id="configTable" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
						    <div class="form-group ng-scope">
								<label class="col-sm-3 control-label">初级逾期:<i class="red">*</i></label>天
								<div class="col-sm-2">
									<input id="overdue_one" name="overdue_one" type="text" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required">
								</div>
							</div>
							<div class="form-group ng-scope">
								<label class="col-sm-3 control-label">中级逾期:<i class="red">*</i></label>天
								<div class="col-sm-2">
									<input id="overdue_two" name="overdue_two" type="text" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required">
								</div>
							</div>
							<div class="form-group ng-scope">
								<label class="col-sm-3 control-label">高级逾期:<i class="red">*</i></label>天
								<div class="col-sm-2">
									<input id="overdue_three" name="overdue_three" type="text" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required">
								</div>
							</div>
							<div class="form-group ng-scope">
								<label class="col-sm-3 control-label">逾期时长进入电催:<i class="red">*</i></label>天
								<div class="col-sm-2">
									<input id="overdue_to_phone" name="overdue_to_phone" type="text" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required">
								</div>
							</div>
							<div class="form-group ng-scope">
								<label class="col-sm-3 control-label">拍卖亏损金额:<i class="red">*</i></label>元
								<div class="col-sm-2">
									<input id="overdue_money" name="overdue_money" type="text" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required">
								</div>
							</div>
							<div class="modal-footer">
								<a onclick="config_commit()" class="btn btn-primary">提交</a>	
							</div>
						</form>
						<script type="text/javascript">
						function config_commit(){
								var overdue_one = $("#overdue_one").val();
								var overdue_two = $("#overdue_two").val();
								var overdue_three = $("#overdue_three").val();
								var overdue_to_phone = $("#overdue_to_phone").val();
								var overdue_money = $("#overdue_money").val();
							
								if(overdue_one=="" ||
									overdue_two=="" ||
									overdue_three=="" ||
									overdue_to_phone=="" ||
									overdue_money==""){
									alert("请认真填写配置信息!");
									return false;
								}
							   	var form = new FormData(document.getElementById("configTable"));
							   	$.ajax({
							           url:"${pageContext.request.contextPath }/loan/loanConfig.do",
							           type:"post",
							           data:form,
							           processData:false,
							           contentType:false,
							           success:function(data){
								            alert("提交成功!");
								            location.reload();
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
				 <!-- 模态框插入内容 end -->
				</div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div>
	    </div>
	</div>