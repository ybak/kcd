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
		window.location.href ="${pageContext.request.contextPath}/electricityController/select.do?type=dczy&dn=dh_electricOperation&qn=list&pagesize="+s+"&pagenow=1";
    }
    
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
									<option value="">初级</option>
									<option value="">中级</option>
									<option value="">高级</option>
								</select>
							</label>	
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<label>
							金融产品
							<select class="form-control form-inline hidden-xs">
								<option value="">***金融产品***</option>
							</select>
							</label>	
							
							<form class="form-horizontal" name="myform" action="${pageContext.request.contextPath }/electricityController/select.do?type=dczy&dn=dh_electricOperation&qn=list" method="post">
								<input autocomplete="off" type="text" placeholder="请输入客户姓名或身份证号" name="param" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" style="width:500px;">
								<button class="btn btn-info search-btn" type="submit" style="background-color:#00acd6;">查询</button>   			
								<button class="btn btn-info search-btn" type="button" onclick="reset()" style="background-color:#00acd6;">重置</button>   																	
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
							<a href="${pageContext.request.contextPath }/electricityController/select.do?type=dczy&dn=dh_electricOperation&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow-1}" class="btn btn-default">«</a>						
							<%				    	
					         }						
							 if(pagenow1>=1&&pagenow1<totalpage1){
							%>
							<a href="${pageContext.request.contextPath }/electricityController/select.do?type=dczy&dn=dh_electricOperation&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow+1}" class="btn btn-default">»</a>
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
						<th class="text-center" >代理团队</th>
						<th class="text-center" >业务员</th>
						<th class="text-center" >催收人员</th>
						<th class="text-center" >操作</th>
					</tr>
					<c:forEach items="${selList}" var="sel">
					<tr>
						<td class="text-center hidden-xs">
						<input name="delid"  type="checkbox">
						</td>
						<td class="text-center ">
							${sel.gems_code}
						</td>
						<td class="text-center">
							<span class="s-font-blue">
								${sel.c_name}
							</span>
						</td>
						<td class="text-center">
							${sel.c_cardno}
						</td>
						<td class="text-center">
							<p>
								${sel.y_name}
							</p>
						</td>
						<td class="text-center">
							<p>
								${sel.fk_money}
							</p>
						</td>
						<td class="text-center">
							<p>
								${sel.yqwhtotal}
							</p>
						</td>
							<td class="text-center">
							<p>
								
								${sel.fs_name }
							</p>
						</td>
						<td class="text-center">
							<p>
								${pd.name }
							</p>
						</td>
						<td class="text-center">
							<p>
								${pd.name }
							</p>
						</td>
						<td class="text-center">
							<a href="${pageContext.request.contextPath }/electricityController/hgrt.do?type=hkqkxq&dn=dh_repaymentTelReminders&qn=form&icbc_id=${sel.icbc_id}">
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
				        <li><a href="${pageContext.request.contextPath }/electricityController/select.do?type=dczy&dn=dh_electricOperation&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow-1}" aria-label="Next"><span aria-hidden="true">«</span></a></li>
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
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/electricityController/select.do?type=dczy&dn=dh_electricOperation&qn=list&pagesize=${requestScope.pagesize}&pagenow=<%=j %>">
					   <%=j %>
					   </a>
					   </li>
					   <%
				       }else{
					   %>
	                   <li id="l<%=j %>" >
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/electricityController/select.do?type=dczy&dn=dh_electricOperation&qn=list&pagesize=${requestScope.pagesize}&pagenow=<%=j %>">
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
						  <li><a href="${pageContext.request.contextPath }/electricityController/select.do?type=dczy&dn=dh_electricOperation&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow+1}" aria-label="Next"><span aria-hidden="true">»</span></a></li>  
						   </c:if>
					   </c:if>
					     				
					   </ul>
			</c:if>		   
				<div class="page-num">共${requestScope.totalsize}个 分${requestScope.totalpage }页显示</div>
			</div>
	</section>
	<!-- /.content -->
</div>