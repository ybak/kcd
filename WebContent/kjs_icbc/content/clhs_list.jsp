<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="content-wrapper" style="min-height: 943px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
			材料回收情况<small>
			共${requestScope.totalsize}个
			</small>
			</h1>
		</section>

		<!-- Main content -->
		<section class="content">
				<div class="admin-tools">
				<div class="row">
            <div class="col-sm-10 admin-button">
							<div class="btn-group">		
<form action="" class="form-horizontal" >
<input style="display:none">
<label>
搜索功能
</label>
<input onkeydown="javascript:if(event.keyCode==13)selectByC_name();" id="text" type="text" placeholder="请输入客户名字或客户身份证号或手机号或订单编号" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" style="width:500px;">
<button onclick="selectByC_name()" class="btn btn-info search-btn" type="button" style="background-color:#00acd6;">查询</button>
<script>
function selectByC_name(){
	var c_name = $("#text").val();
	location.href='${pageContext.request.contextPath }/erp/clhs_list.do?type=clhs&dn=${requestScope.dn }&qn=list&pagenow=${requestScope.pagenow}&cn=list&text='+c_name;
}
</script>								
</form>
							
							</div>
							</div>
	
					<div class="col-sm-2 admin-page-top hidden-xs">
							<select id="page_limit_select" onchange="window.location.href='${pageContext.request.contextPath }/erp/clhs_list.do?type=clhs&dn=${requestScope.dn }&qn=list&pagenow=${requestScope.pagenow}&cn=${requestScope.cn}&text=${requestScope.text }&pagesize='+this.value" class="form-control">
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
		       <div class="btn-group">
		                <%
						int pagenow1=Integer.parseInt(request.getAttribute("pagenow").toString());
					    int totalpage1=Integer.parseInt(request.getAttribute("totalpage").toString());
					    if(pagenow1>1&&pagenow1<=totalpage1){
						%>
						<a href="${pageContext.request.contextPath }/erp/clhs_list.do?type=clhs&dn=${requestScope.dn }&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow-1}&cn=${requestScope.cn}&text=${requestScope.text }" class="btn btn-default">«</a>						
						<%				    	
				         }						
						 if(pagenow1>=1&&pagenow1<totalpage1){
						%>
						<a href="${pageContext.request.contextPath }/erp/clhs_list.do?type=clhs&dn=${requestScope.dn }&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow+1}&cn=${requestScope.cn}&text=${requestScope.text }" class="btn btn-default">»</a>
                        <%
                        }
                        %>
		       </div>
		       </div>
				</div>
			</div>
			<div id="main_list" class="admin-content box">
					<!-- 数据载入中 请在搜索，筛选，载入的时候显示 放在.box里 -->
				<div class="overlay" style="display:none;">
					<i class="fa fa-refresh fa-spin"></i>
				</div>
				<!-- 数据载入中结束 -->
				<table class="table table-bordered table-hover">
	<tbody>
		<tr>
			<th style="width: 3%" class="text-center hidden-xs"><input class="check_all" type="checkbox"></th>
			<th class="text-center hidden-xs">编号</th>
			<th class="text-center">客户姓名</th>
			<th class="text-center">征信材料</th>
			<th class="text-center">开卡材料</th>
			<th class="text-center hidden-xs">贷款材料</th>
			<th class="text-center hidden-xs" >归档材料</th>
		</tr>
		   <c:forEach var="pd" items="${requestScope.newpdList }">
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="${pd.id }" type="checkbox"></td>
			<td class="text-center hidden-xs">${pd.gems_code }</td>
			<td class="text-center"><span class="s-font-blue">${pd.c_name }</span></td>
			<td class="text-center" style="word-wrap:break-word;word-break:break-all;">
			<select id=""  class="form-control">
					<option value="1">已收到</option>
					<option value="0">未收到</option>
			</select>
			</td>
			<td class="text-center ">
			<select id="" class="form-control">
					<option value="1">已收到</option>
					<option value="0">未收到</option>
			</select>
			</td>
			<td class="text-center">
			<select id="" class="form-control">
					<option value="1">已收到</option>
					<option value="0">未收到</option>
			</select>
			</td>
			<td class="text-center">
			<select id="" class="form-control">
					<option value="1">已收到</option>
					<option value="0">未收到</option>
			</select>
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
				        <li><a href="${pageContext.request.contextPath }/erp/clhs_list.do?type=clhs&dn=${requestScope.dn }&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow-1}&cn=${requestScope.cn}&text=${requestScope.text }" aria-label="Next"><span aria-hidden="true">«</span></a></li>
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
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/erp/clhs_list.do?type=clhs&dn=${requestScope.dn }&qn=list&pagesize=${requestScope.pagesize}&pagenow=<%=j %>&cn=${requestScope.cn}&text=${requestScope.text }">
					   <%=j %>
					   </a>
					   </li>
					   <%
				       }else{
					   %>
	                   <li id="l<%=j %>" >
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/erp/clhs_list.do?type=clhs&dn=${requestScope.dn }&qn=list&pagesize=${requestScope.pagesize}&pagenow=<%=j %>&cn=${requestScope.cn}&text=${requestScope.text }">
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
						  <li><a href="${pageContext.request.contextPath }/erp/clhs_list.do?type=clhs&dn=${requestScope.dn }&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow+1}&cn=${requestScope.cn}&text=${requestScope.text }" aria-label="Next"><span aria-hidden="true">»</span></a></li>  
						   </c:if>
					   </c:if>
					     				
					   </ul>
			</c:if>		   
				<div class="page-num">共${requestScope.totalsize}个 分${requestScope.totalpage }页显示</div>
			</div>
					</section><!-- /.content -->
		</div>


