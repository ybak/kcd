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
			我的任务<small>
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
<script type="text/javascript">
$(document).ready(function(){
	var con="<option value=''>***业务类型***</option>";
	$.post("${pageContext.request.contextPath }/erp/ywlxname.do",
			function(result){
		     $("#ywlx").empty();
		 $.each(result, function(index, item){
		       con += "<option  value="+item.id+">"+item.name+"</option>";       			   	      		
	       	 });           	
	       	 $("#ywlx").append(con);  		
			},'json');
})
</script>
<form action="" class="form-horizontal" >
<label>
业务类型
<select  id="ywlx" name="ywlx" onchange="window.location.href='${pageContext.request.contextPath }/erp/wdrw_list.do?type=wdrw&dn=icbc_erp_kj_icbc&qn=list&cn=${requestScope.cn }&ywlx_id='+this.value" class="form-control form-inline hidden-xs">
	<option value="">--业务类型--</option>
</select>
</label>																				
</form>				
</div>
</div>
					<div class="col-sm-2 admin-page-top hidden-xs">
							<select id="page_limit_select" onchange="window.location.href='${pageContext.request.contextPath }/erp/wdrw_list.do?type=wdrw&dn=icbc_erp_kj_icbc&qn=list&pagenow=${requestScope.pagenow}&pagesize='+this.value" class="form-control">
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
						<a href="${pageContext.request.contextPath }/erp/wdrw_list.do?type=wdrw&dn=icbc_erp_kj_icbc&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow-1}" class="btn btn-default">«</a>						
						<%				    	
				         }						
						 if(pagenow1>=1&&pagenow1<totalpage1){
						%>
						<a href="${pageContext.request.contextPath }/erp/wdrw_list.do?type=wdrw&dn=icbc_erp_kj_icbc&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow+1}" class="btn btn-default">»</a>
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
			<th class="text-center">业务类型</th>
			<th class="text-center">任务名称</th>
			<th class="text-center hidden-xs">任务发起人</th>
			<th class="text-center hidden-xs" >发起机构</th>
			<th class="text-center" width="200">开始时间</th>
			<th class="text-center" width="200">操作</th>
		</tr>
		   <c:forEach var="pd" items="${requestScope.newpdList }">
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="${pd.id }" type="checkbox"></td>
			<td class="text-center hidden-xs">${pd.id }</td>
			<td class="text-center"><span class="s-font-blue">${pd.icbcname }</span></td>
			<td class="text-center" style="word-wrap:break-word;word-break:break-all;">
			${pd.tname }
			</td>
			<td class="text-center hidden-xs"><p>
			${pd.knname }
			</p></td>
			<td class="text-center hidden-xs"><p>
			${pd.gemsname }
			</p></td>
			<td class="text-center">
			${pd.fsname }
			</td>
			<td class="text-center">
			<fmt:formatDate value="${pd.dt_add}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
			<td class="text-center">
				<a href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wdrw&dn=icbc_erp_kj_icbc&qn=form&icbc_id=${pd.icbc_id}&cn=${requestScope.cn}">
					<i class="fa fa-search-plus"></i>
				</a>
				<a href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wdrw&dn=icbc_erp_kj_icbc&qn=form&icbc_id=${pd.icbc_id}&cn=${requestScope.cn}">
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
				        <li><a href="${pageContext.request.contextPath }/erp/wdrw_list.do?type=wdrw&dn=icbc_erp_kj_icbc&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow-1}" aria-label="Next"><span aria-hidden="true">«</span></a></li>
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
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/erp/wdrw_list.do?type=wdrw&dn=icbc_erp_kj_icbc&qn=list&pagesize=${requestScope.pagesize}&pagenow=<%=j %>">
					   <%=j %>
					   </a>
					   </li>
					   <%
				       }else{
					   %>
	                   <li id="l<%=j %>" >
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/erp/wdrw_list.do?type=wdrw&dn=icbc_erp_kj_icbc&qn=list&pagesize=${requestScope.pagesize}&pagenow=<%=j %>">
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
						  <li><a href="${pageContext.request.contextPath }/erp/wdrw_list.do?type=wdrw&dn=icbc_erp_kj_icbc&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow+1}" aria-label="Next"><span aria-hidden="true">»</span></a></li>  
						   </c:if>
					   </c:if>
					     				
					   </ul>
			</c:if>		   
				<div class="page-num">共${requestScope.totalsize}个 分${requestScope.totalpage }页显示</div>
			</div>
					</section><!-- /.content -->
		</div>


