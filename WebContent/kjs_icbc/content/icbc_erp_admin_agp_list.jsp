<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="content-wrapper" style="min-height: 943px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
			权限组管理<small>
			共${requestScope.totalsize}个
			</small>
			</h1>
		</section>

		<!-- Main content -->
		<section class="content">
<div class="admin-tools">
<div class="row">
<div class="col-sm-10">
<div class="btn-group">
<form id="serch_form" class="form-horizontal" method="post" action="${pageContext.request.contextPath }/erp/user_list.do">
<input style="display:none">
<input type="hidden" id="type" name="type" value="zhgl">
<input type="hidden" id="dn" name="dn" value="icbc_erp_admin_agp">
<input type="hidden" id="qn" name="qn" value="list">
<label >权限类型</label>
<select style="width: 200px;" class="form-control" id="qx_type" name="qx_type">
<option value="0">--请选择--</option>
<option value="1" ${requestScope.qx_type eq '1'?"selected='selected'":'' }>代理商</option>
<option value="2" ${requestScope.qx_type eq '2'?"selected='selected'":'' }>审核员/管理员</option>
</select>
<label>权限组名</label>
<input style="width: 200px;" type="text" value="${requestScope.assess_fs_msg}" class="form-control" id="assess_fs_msg" name="assess_fs_msg"/>
<label>时间区间</label>
<input style="width: 200px;" type="text" class="form-control" id="date1" name="date1" value="${requestScope.date1}" />-
<input style="width: 200px;" type="text" class="form-control" id="date2" name="date2" value="${requestScope.date2}"/>
<input  class="btn btn-info search-btn" value="查询" type="submit" style="background-color:#00acd6;" />
<a  class="btn btn-info search-btn" onclick="reset_myForm1()" style="background-color:#00acd6;">重置</a>
<script>
function reset_myForm1(){
	$('#serch_form')[0].reset();
}

lay('#version').html('-v'+ laydate.v);
//执行一个laydate实例
laydate.render({
  elem: '#date1' //指定元素
});
</script>
<script>
lay('#version').html('-v'+ laydate.v);
//执行一个laydate实例
laydate.render({
  elem: '#date2' //指定元素
});
</script>
</form>
</div>
</div>
</div>
</div>
			<div class="admin-tools">
				<div class="row">
					<div class="col-sm-10 admin-button">
					<div class="btn-group">
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'zhqxadd')==true}">
					<a href="${pageContext.request.contextPath }/erp/index.do?type=zhgl&dn=icbc_erp_admin_agp&qn=form&cn=1" class="btn btn-default">
					<i class="fa fa-edit"></i> 新增</a>
					</c:if>
					<!-- <a href="javascript:;" id="del_more_btn" class="btn btn-default">
					<i class="fa fa-trash-o"></i> 删除</a> -->
					</div>
					</div>
					<div class="col-sm-2 admin-page-top hidden-xs">
							<select id="page_limit_select" onchange="window.location.href='${pageContext.request.contextPath }/erp/user_list.do?type=zhgl&dn=icbc_erp_admin_agp&qn=list&qx_type=${requestScope.qx_type }&assess_fs_msg=${requestScope.assess_fs_msg }&date1=${requestScope.date1 }&date2=${requestScope.date2 }&pagenow=${requestScope.pagenow}&pagesize='+this.value" class="form-control">
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
						<a href="${pageContext.request.contextPath }/erp/user_list.do?type=zhgl&dn=icbc_erp_admin_agp&qn=list&qx_type=${requestScope.qx_type }&assess_fs_msg=${requestScope.assess_fs_msg }&date1=${requestScope.date1 }&date2=${requestScope.date2 }&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow-1}" class="btn btn-default">«</a>						
						<%				    	
				         }						
						 if(pagenow1>=1&&pagenow1<totalpage1){
						%>
						<a href="${pageContext.request.contextPath }/erp/user_list.do?type=zhgl&dn=icbc_erp_admin_agp&qn=list&qx_type=${requestScope.qx_type }&assess_fs_msg=${requestScope.assess_fs_msg }&date1=${requestScope.date1 }&date2=${requestScope.date2 }&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow+1}" class="btn btn-default">»</a>
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
			<th class="text-center hidden-xs" width="50">ID</th>
			<th class="text-center" width="200">权限组名</th>
			<th class="text-center hidden-xs" >权限类型</th>
			<th class="text-center hidden-xs" >权限模板</th>
			<th class="text-center" width="800">用户列表</th>
			<th class="text-center hidden-xs" width="200">添加时间</th>
			<th class="text-center hidden-xs" width="200">更新时间</th>
			<th class="text-center" width="200">状态</th>
			<th class="text-center" width="300">操作</th>
		</tr>
		   <c:forEach  var="pd" items="${requestScope.newpdList }">
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="${pd.id }" type="checkbox"></td>
			<td class="text-center hidden-xs">${pd.id }</td>
			<td class="text-center"><span class="s-font-blue">${pd.name }</span></td>
			<td class="text-center">
			<a href="">
			<c:if test="${pd.qx_type eq '1' }">
			<span class="label label-warning">代理商</span>
			</c:if>
			<c:if test="${pd.qx_type eq '2'}">
			<span class="label label-success">审核员/管理员</span>
			</c:if>
			</a>
			</td>
			<td class="text-center">
			<a href="">
			<c:if test="${pd.modal_tag eq '1' }">
			<span class="label label-success">模板</span>
			</c:if>
			<c:if test="${pd.modal_tag eq '0' or empty pd.modal_tag}">
			<span class="label label-warning">自定义</span>
			</c:if>
			</a>
			</td>
			<td class="text-center" style="word-wrap:break-word;word-break:break-all;">
			</td>
			<td class="text-center hidden-xs"><p>
			<fmt:formatDate value="${pd.dt_add}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</p></td>
			<td class="text-center hidden-xs"><p>
			<fmt:formatDate value="${pd.dt_edit}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</p></td>
			<td class="text-center">
				<select id="showtag_22" ${fn:contains(sessionScope.pd.purview_map,'zhqxupdate')==true?'':"disabled='disabled'"}  onchange="ajaxedit('icbc_erp_admin_agp','${pd.id }',this.value)" class="form-control">
					<option value="1" ${pd.showtag eq '1'?"selected='selected'":'' }>开通</option>
					<option value="0" ${pd.showtag eq '0'?"selected='selected'":'' }>屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
				    <a href="${pageContext.request.contextPath }/erp/index.do?type=zhgl&dn=icbc_erp_admin_agp&qn=form&id=${pd.id}&cn=4" class="btn btn-default"><i class="fa fa-search-plus"></i></a>
				    <c:if  test="${fn:contains(sessionScope.pd.purview_map,'zhqxupdate')==true}">
					<a href="${pageContext.request.contextPath }/erp/index.do?type=zhgl&dn=icbc_erp_admin_agp&qn=form&id=${pd.id}&cn=3" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'zhqxdelete')==true}">
					<a onclick="ajaxdel(${pd.id })" class="btn btn-default"><i class="fa fa-trash"></i></a>
                    </c:if>
				</div>
			</td>
		</tr>
			</c:forEach>
		</tbody>
</table>
				<script type="text/javascript">
				function ajaxdel(id){
					if(window.confirm('你确定要删除吗？')){
				          //alert("确定");
				          window.location.href="${pageContext.request.contextPath }/erp/deletebyid.do?type=zhgl&dn=icbc_erp_admin_agp&qn=list&id="+id;
					}else{
				         
				       }
				}
				
				function ajaxedit(dn,id,showtag){
					$.post("${pageContext.request.contextPath }/erp/user_pb.do",
							{dn:dn,id:id,showtag:showtag},
							function(result){
					       if(result==1){
					    	   alert("更改成功!");
					    	   window.location.reload();
					       }else{
					    	   alert("更改失败!");
					       }
					  });
				}
				</script>
			</div>
<div class="foot-page">
			<c:if test="${requestScope.totalpage ge '1' }">
				<ul class="pagination no-margin">
				       <c:if test="${requestScope.pagenow ne '1' }">
				        <li><a href="${pageContext.request.contextPath }/erp/user_list.do?type=zhgl&dn=icbc_erp_admin_agp&qn=list&qx_type=${requestScope.qx_type }&assess_fs_msg=${requestScope.assess_fs_msg }&date1=${requestScope.date1 }&date2=${requestScope.date2 }&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow-1}" aria-label="Next"><span aria-hidden="true">«</span></a></li>
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
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/erp/user_list.do?type=zhgl&dn=icbc_erp_admin_agp&qn=list&qx_type=${requestScope.qx_type }&assess_fs_msg=${requestScope.assess_fs_msg }&date1=${requestScope.date1 }&date2=${requestScope.date2 }&pagesize=${requestScope.pagesize}&pagenow=<%=j %>">
					   <%=j %>
					   </a>
					   </li>
					   <%
				       }else{
					   %>
	                   <li id="l<%=j %>" >
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/erp/user_list.do?type=zhgl&dn=icbc_erp_admin_agp&qn=list&qx_type=${requestScope.qx_type }&assess_fs_msg=${requestScope.assess_fs_msg }&date1=${requestScope.date1 }&date2=${requestScope.date2 }&pagesize=${requestScope.pagesize}&pagenow=<%=j %>">
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
						  <li><a href="${pageContext.request.contextPath }/erp/user_list.do?type=zhgl&dn=icbc_erp_admin_agp&qn=list&qx_type=${requestScope.qx_type }&assess_fs_msg=${requestScope.assess_fs_msg }&date1=${requestScope.date1 }&date2=${requestScope.date2 }&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow+1}" aria-label="Next"><span aria-hidden="true">»</span></a></li>  
						   </c:if>
					   </c:if>
					     				
					   </ul>
			</c:if>		   
				<div class="page-num">共${requestScope.totalsize}个 分${requestScope.totalpage }页显示</div>
			</div>
					</section><!-- /.content -->
		</div>