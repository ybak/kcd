<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="content-wrapper" style="min-height: 943px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
			放款记录<small>
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
<form  id="search_form" class="form-horizontal" action="${pageContext.request.contextPath}/erp/lengding_list.do">
<input style="display:none">
<input type="hidden" id="type" name="type" value="${requestScope.type}">
<input type="hidden" id="dn" name="dn" value="${requestScope.dn}">
<input type="hidden" id="qn" name="qn" value="${requestScope.qn}">
<input type="hidden" id="cn" name="cn" value="${requestScope.cn}">

<label>搜索功能</label>
<input placeholder="请输入业务编号或客户姓名或身份证号码" style="width: 300px;" value="" class="form-control" id="selectMsg" name="selectMsg"/>
<label >是否放款</label>
<select style="width: 200px;" class="form-control" id="assess_cp" name="assess_cp">
<option value="">--请选择--</option>
<option value="1" ${requestScope.assess_cp eq '1'?"selected='selected'":'' }>未垫资/放款</option>
<option value="2" ${requestScope.assess_cp eq '2'?"selected='selected'":'' }>已垫资</option>
<option value="3" ${requestScope.assess_cp eq '3'?"selected='selected'":'' }>已放款</option>
<option value="0" ${requestScope.assess_cp eq '0'?"selected='selected'":'' }>未放款</option>
<option value="" >全部</option>
</select>
<%-- 
<label>时间区间</label>
<input style="width: 200px;" type="text" class="form-control" id="date1" name="date1" value="${requestScope.date1}" />-
<input style="width: 200px;" type="text" class="form-control" id="date2" name="date2" value="${requestScope.date2}"/>
 --%>
<input  class="btn btn-info search-btn" value="查询" type="submit" style="background-color:#00acd6;" />
<a class="btn btn-info search-btn" onclick="reset_myForm()" style="background-color:#00acd6;">重置</a>
<script>
function reset_myForm(){
	$('#search_form')[0].reset();
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
					<%-- <c:if  test="${fn:contains(sessionScope.pd.purview_map,'rygladd')==true}">
					<a href="${pageContext.request.contextPath }/erp/index.do?type=zhgl&dn=assess_gems&qn=form&cn=1" class="btn btn-default"><i class="fa fa-edit"></i> 新增</a>
					<!-- <a href="javascript:;" id="del_more_btn" class="btn btn-default">
					<i class="fa fa-trash-o"></i> 删除</a> -->
					</c:if> --%>
					</div>
					</div>
					<div class="col-sm-2 admin-page-top hidden-xs">
							<select id="page_limit_select" onchange="window.location.href='${pageContext.request.contextPath }/erp/lengding_list.do?type=wdrw&cn=${requestScope.cn}&dn=lendingResult&qn=list&assess_cp=${requestScope.assess_cp}&selectMsg=${requestScope.selectMsg}&pagenow=${requestScope.pagenow}&pagesize='+this.value+'&fsid=1'" class="form-control">
														<option value="10" ${requestScope.pagesize==10?"selected='selected'":""}>每页10条</option>
														<option value="20" ${requestScope.pagesize==20?"selected='selected'":""}>每页20条</option>
														<option value="30" ${requestScope.pagesize==30?"selected='selected'":""}>每页30条</option>
														<option value="40" ${requestScope.pagesize==40?"selected='selected'":""}>每页40条</option>
														<option value="50" ${requestScope.pagesize==50?"selected='selected'":""}>每页50条</option>
														<option value="60" ${requestScope.pagesize==60?"selected='selected'":""}>每页60条</option>
														<option value="70" ${requestScope.pagesize==70?"selected='selected'":""}>每页70条</option>
														<option value="80" ${requestScope.pagesize==80?"selected='selected'":""}>每页80条</option>
														<option value="90" ${requestScope.pagesize==90?"selected='selected'":""}>每页90条</option>
														<option value="100" ${requestScope.pagesize==100?"selected='selected'":""}>每页100条</option>
													</select>
		<div class="btn-group">
		                <%
						int pagenow1=Integer.parseInt(request.getAttribute("pagenow").toString());
					    int totalpage1=Integer.parseInt(request.getAttribute("totalpage").toString());
					    if(pagenow1>1&&pagenow1<=totalpage1){
						%>
						<a href="${pageContext.request.contextPath }/erp/lengding_list.do?type=wdrw&cn=${requestScope.cn}&dn=lendingResult&qn=list&assess_cp=${requestScope.assess_cp}&selectMsg=${requestScope.selectMsg}&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow-1}&fsid=${requestScope.fsid }" class="btn btn-default">«</a>						
						<%				    	
				         }						
						 if(pagenow1>=1&&pagenow1<totalpage1){
						%>
						<a href="${pageContext.request.contextPath }/erp/lengding_list.do?type=wdrw&cn=${requestScope.cn}&dn=lendingResult&qn=list&assess_cp=${requestScope.assess_cp}&selectMsg=${requestScope.selectMsg}&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow+1}&fsid=${requestScope.fsid }" class="btn btn-default">»</a>
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
			<th class="text-center" style="width:150px;">业务编号</th>
			<th class="text-center" style="width:100px">客户姓名</th>
			<th class="hidden-xs text-center" style="width:100px">身份证号</th>
			<th class="hidden-xs text-center" style="width:200px">合作商</th>
			<th class="hidden-xs text-center" style="width:100px">放款金额</th>
			<th class="text-center" style="width:100px">放款日期</th>
			<th class="hidden-xs text-center" style="width:100px">放款状态</th>
			<!-- <th style="width:200px;" class="text-center">操作</th> -->
		</tr>
		<c:forEach items="${pdDate}" var="p" varStatus="num">
		<tr>
			<td class="text-center hidden-xs"><input name="delid" value="4510" type="checkbox"></td>
			<td class="text-center">${p.code}</td>
			<td class="text-center">${p.name}</td>
			<td class="text-center">${p.c_cardno}</td>
			<td class="hidden-xs text-center">${p.fs_name}</td>
			<td class="hidden-xs text-center">${p.fk_money}</td>
			<td class="hidden-xs text-center">${p.fk_date}</td>
			<td class="text-center">
			 	<c:if test="${p.status == '0'}">
	                <span class="label label-danger">未放款</span>
	            </c:if>
	            <c:if test="${p.status == '1'}">
	                <span class="label label-success">未垫资/放款</span>
	            </c:if>
	            <c:if test="${p.status == '2'}">
	               <span class="label label-warning">已垫资</span>
	            </c:if>
	            <c:if test="${p.status == '3'}">
	               <span class="label label-success">已放款</span>
	            </c:if>
            </td>
			<%--  label label-danger
			<td class="text-center">
				<div class="table-button text-center">
				<a href="${pageContext.request.contextPath }/erp/index.do?type=zhgl&dn=assess_gems&qn=form&id=${pd.id }&cn=4" class="btn btn-default">
				<i class="fa fa-search-plus"></i>
				</a>
				<c:if  test="${fn:contains(sessionScope.pd.purview_map,'ryglupdate')==true}">
					<a href="${pageContext.request.contextPath }/erp/index.do?type=zhgl&dn=assess_gems&qn=form&id=${pd.id }&cn=3" class="btn btn-default">
					<i class="fa fa-pencil"></i></a>
				</c:if>
				<c:if  test="${fn:contains(sessionScope.pd.purview_map,'rygldelete')==true}">	
					<a onclick="ajaxdel(${pd.id})"  class="btn btn-default">
					<i class="fa fa-trash"></i></a>
				</c:if>
				</div>
			</td>
			 --%>
		</tr>
		</c:forEach>
	</tbody>
</table>
				<script type="text/javascript">
				function ajaxdel(id){
					if(window.confirm('你确定要删除吗？')){
				          //alert("确定");
				          window.location.href="${pageContext.request.contextPath }/erp/user_del.do?type=zhgl&dn=assess_gems&qn=list&id="+id;
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
				        <li><a href="${pageContext.request.contextPath }/erp/lengding_list.do?type=zhgl&dn=lendingResult&cn=${requestScope.cn}&qn=list&assess_cp=${requestScope.assess_cp}&selectMsg=${requestScope.selectMsg}&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow-1}" aria-label="Next"><span aria-hidden="true">«</span></a></li>
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
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/erp/lengding_list.do?type=zhgl&dn=lendingResult&cn=${requestScope.cn }&qn=list&assess_cp=${requestScope.assess_cp}&selectMsg=${requestScope.selectMsg}&pagesize=${requestScope.pagesize}&pagenow=<%=j %>">
					   <%=j %>
					   </a>
					   </li>
					   <%
				       }else{
					   %>
	                   <li id="l<%=j %>" >
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/erp/lengding_list.do?type=zhgl&dn=lendingResult&cn=${requestScope.cn }&qn=list&assess_cp=${requestScope.assess_cp}&selectMsg=${requestScope.selectMsg}&pagesize=${requestScope.pagesize}&pagenow=<%=j %>">
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
						  <li><a href="${pageContext.request.contextPath }/erp/lengding_list.do?type=zhgl&dn=lendingResult&cn=${requestScope.cn }&qn=list&assess_cp=${requestScope.assess_cp}&selectMsg=${requestScope.selectMsg}&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow+1}" aria-label="Next"><span aria-hidden="true">»</span></a></li>  
						   </c:if>
					   </c:if>
					     				
					   </ul>
			</c:if>		   
				<div class="page-num">共${requestScope.totalsize}个 分${requestScope.totalpage }页显示</div>
</div>
					</section><!-- /.content -->
		</div>