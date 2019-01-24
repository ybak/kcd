<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="content-wrapper" style="min-height: 876px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
			公司管理
            <small>
                                      共${requestScope.totalsize }个
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
<input type="hidden" id="dn" name="dn" value="assess_fs">
<input type="hidden" id="qn" name="qn" value="list">
<div class="form-group">
<label class="col-sm-2 control-label" for="ds_host">公司名称</label>
<div class="col-sm-4">
<select  class="selectpicker show-tick form-control"  data-live-search="true"  id="assess_fs_id" name="assess_fs_id">
<option value="0">--请选择--</option>
<c:forEach var="list" items="${requestScope.pdList1 }" varStatus="index">
  <option value="${list.id }" ${requestScope.assess_fs_id eq list.id?"selected='selected'":''  } >${list.name }</option>
</c:forEach>
</select>
</div>
<label class="col-sm-2 control-label" for="ds_host">所属机构/开户人</label>
<div class="col-sm-4">
<input  type="text" value="${requestScope.assess_fs_msg}" class="form-control" id="assess_fs_msg" name="assess_fs_msg"/>
</div>
</div>
<div class="form-group">
<label class="col-sm-2 control-label" for="ds_host">开始时间</label>
<div class="col-sm-4">
<input  type="text" class="form-control" id="date1" name="date1" value="${requestScope.date1}" />
</div>
<label class="col-sm-2 control-label" for="ds_host">结束时间</label>
<div class="col-sm-4">
<input  type="text" class="form-control" id="date2" name="date2" value="${requestScope.date2}"/>
</div>
</div>
<div class="form-group">
<input  class="btn btn-info search-btn" value="查询" type="submit" style="background-color:#00acd6;" />
<a  class="btn btn-info search-btn" onclick="reset_myForm1()" style="background-color:#00acd6;">重置</a>
</div>
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
<div class="col-sm-10">
<div class="btn-group">		
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'gsgladd')==true}">
<a href="${pageContext.request.contextPath }/erp/index.do?type=zhgl&dn=assess_fs&qn=form&cn=1" class="btn btn-default">
<i class="fa fa-edit"></i> 新增
</a>																																
<!-- <a href="javascript:;" id="del_more_btn" class="btn btn-default"><i class="fa fa-trash-o"></i> 删除</a> -->
</c:if>	
<!-- <a href="" class="btn btn-default"><i class="fa fa-share"></i> 导出</a>
<!-- <a href="" class="btn btn-default"><i class="fa fa-money"></i>有余额的</a> -->
<!-- <select  class="form-control form-inline hidden-xs">	
	<option value="dt_add_desc">按创建时间</option>
	<option value="dt_edit_desc">按最后更新</option>
</select>	 -->
				
<script type="text/javascript">
  function delfs(id){
	  if(window.confirm('你确定要删除吗？')){
          //alert("确定");
          window.location.href="${pageContext.request.contextPath }/erp/user_del.do?type=zhgl&dn=assess_fs&qn=list&id="+id;
	  }else{
         
       }
	  //
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
</div>
<div class="col-sm-2 admin-page-top hidden-xs">
							<select id="page_limit_select" onchange="window.location.href='${pageContext.request.contextPath }/erp/user_list.do?type=zhgl&dn=assess_fs&qn=list&assess_fs_id=${requestScope.assess_fs_id }&assess_fs_msg=${requestScope.assess_fs_msg }&date1=${requestScope.date1 }&date2=${requestScope.date2 }&pagenow=${requestScope.pagenow}&pagesize='+this.value" class="form-control">
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
						<a href="$${pageContext.request.contextPath }/erp/user_list.do?type=zhgl&dn=assess_fs&qn=list&assess_fs_id=${requestScope.assess_fs_id }&assess_fs_msg=${requestScope.assess_fs_msg }&date1=${requestScope.date1 }&date2=${requestScope.date2 }&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow-1}" class="btn btn-default">«</a>						
						<%				    	
				         }						
						 if(pagenow1>=1&&pagenow1<totalpage1){
						%>
						<a href="${pageContext.request.contextPath }/erp/user_list.do?type=zhgl&dn=assess_fs&qn=list&assess_fs_id=${requestScope.assess_fs_id }&assess_fs_msg=${requestScope.assess_fs_msg }&date1=${requestScope.date1 }&date2=${requestScope.date2 }&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow+1}" class="btn btn-default">»</a>
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
		    <th class="text-center" style="width: 80px">编号</th>
			<th class="text-center">公司名称</th>
			<th style="width: 80px" class="hidden-xs">账户总数</th>			
			<th class="text-center" style="width: 13%;">开户公司-开户人</th>			
			<th class="hidden-xs text-center" style="width: 13%">更新时间</th>
			<th class="hidden-xs text-center" style="width: 13%">创建时间</th>
			<th class="hidden-xs text-center" style="width: 13%">状态</th>
			<th style="width: 150px;" class="text-center">操作</th>
	</tr>
	<c:forEach var="list" items="${requestScope.newpdList }" varStatus="index">
		<tr>
		    <td class="text-center">${index.index+1 }</td>
			<td class="text-center">${list.name }</td>
			<td class="hidden-xs text-center">${list.num }</td>
			<td class="text-center">${list.fsname }-${list.adminname }</td>			
			<td class="hidden-xs text-center"><p class="text-gray">
			<fmt:formatDate value="${list.dt_edit}" pattern="yyyy-MM-dd hh:mm:ss"/>
			</p></td>
			<td class="hidden-xs text-center">
			<p class="text-gray">
			<fmt:formatDate value="${list.dt_add}" pattern="yyyy-MM-dd hh:mm:ss"/>
			</p></td>
			<td class="hidden-xs text-center">
			<select id="showtag_${list.id }" ${fn:contains(sessionScope.pd.purview_map,'gsglupdate')==true?'':"disabled='disabled'"}  onchange="ajaxedit('assess_fs','${list.id }',this.value)" class="form-control">
					<option value="1" ${list.showtag eq '1'?"selected='selected'":'' }>开通</option>
					<option value="0" ${list.showtag eq '0'?"selected='selected'":'' }>屏蔽</option>
			</select>
			</td>
			<td class="text-center">
			    <a title="查看" href="${pageContext.request.contextPath }/erp/index.do?type=zhgl&dn=assess_fs&qn=form&id=${list.id}&cn=4" class="btn btn-default">
					<i  class="fa fa-search-plus"></i>
				</a>
			    <c:if  test="${fn:contains(sessionScope.pd.purview_map,'gsglupdate')==true}">
				<a title="编辑" href="${pageContext.request.contextPath }/erp/index.do?type=zhgl&dn=assess_fs&qn=form&id=${list.id}&cn=3" class="btn btn-default">
					<i  class="fa fa-pencil"></i>
				</a>
				</c:if>
				<c:if  test="${fn:contains(sessionScope.pd.purview_map,'gsgldelete')==true}">
				<a title="删除" onclick="delfs(${list.id})" class="btn btn-default">
					<i  class="fa fa-trash"></i>
				</a>
				</c:if>
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
				        <li><a href="${pageContext.request.contextPath }/erp/user_list.do?type=zhgl&dn=assess_fs&qn=list&assess_fs_id=${requestScope.assess_fs_id }&assess_fs_msg=${requestScope.assess_fs_msg }&date1=${requestScope.date1 }&date2=${requestScope.date2 }&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow-1}" aria-label="Next"><span aria-hidden="true">«</span></a></li>
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
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/erp/user_list.do?type=zhgl&dn=assess_fs&qn=list&assess_fs_id=${requestScope.assess_fs_id }&assess_fs_msg=${requestScope.assess_fs_msg }&date1=${requestScope.date1 }&date2=${requestScope.date2 }&pagesize=${requestScope.pagesize}&pagenow=<%=j %>">
					   <%=j %>
					   </a>
					   </li>
					   <%
				       }else{
					   %>
	                   <li id="l<%=j %>" >
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/erp/user_list.do?type=zhgl&dn=assess_fs&qn=list&assess_fs_id=${requestScope.assess_fs_id }&assess_fs_msg=${requestScope.assess_fs_msg }&date1=${requestScope.date1 }&date2=${requestScope.date2 }&pagesize=${requestScope.pagesize}&pagenow=<%=j %>">
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
						  <li><a href="${pageContext.request.contextPath }/erp/user_list.do?type=zhgl&dn=assess_fs&qn=list&assess_fs_id=${requestScope.assess_fs_id }&assess_fs_msg=${requestScope.assess_fs_msg }&date1=${requestScope.date1 }&date2=${requestScope.date2 }&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow+1}" aria-label="Next"><span aria-hidden="true">»</span></a></li>  
						   </c:if>
					   </c:if>
					     				
					   </ul>
			</c:if>		   
				<div class="page-num">共${requestScope.totalsize}个 分${requestScope.totalpage }页显示</div>
			</div>
					</section><!-- /.content -->
		</div>
     <!-- bootstrap-select -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/css/bootstrap-select.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.12.4/js/bootstrap-select.min.js"></script>