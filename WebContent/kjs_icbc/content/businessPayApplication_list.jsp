<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="content-wrapper" style="min-height: 943px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
			业务付款申请<small>
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
<form  id="search_form" class="form-horizontal" action="${pageContext.request.contextPath }/erp/loanBefore_list.do">
<input style="display:none">
<input type="hidden" id="type" name="type" value="${requestScope.type}">
<input type="hidden" id="dn" name="dn" value="${requestScope.dn}">
<input type="hidden" id="qn" name="qn" value="${requestScope.qn}">
<input type="hidden" id="cn" name="cn" value="${requestScope.cn}">
<label>搜索功能</label>
<input placeholder="请输入业务编号或客户姓名或合作商"  style="width:300px;" value="" class="form-control" id="selectMsg" name="selectMsg"/>
<%-- 
<label>时间区间</label>
<input style="width: 200px;" type="text" class="form-control" id="date1" name="date1" value="${requestScope.date1}" />-
<input style="width: 200px;" type="text" class="form-control" id="date2" name="date2" value="${requestScope.date2}"/>
 --%>
<input class="btn btn-info search-btn" value="查询" type="submit" style="background-color:#00acd6;" />
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
							<select id="page_limit_select" onchange="window.location.href='${pageContext.request.contextPath }/erp/loanBefore_list.do?type=wdrw&dn=businessPayApplication&cn=${requestScope.cn}&qn=list&selectMsg=${requestScope.selectMsg}&pagenow=${requestScope.pagenow}&pagesize='+this.value+'&fsid=1'" class="form-control">
														<option value="10" ${requestScope.pagesize==10?"selected='selected'":''}>每页10条</option>
														<option value="20" ${requestScope.pagesize==20?"selected='selected'":''}>每页20条</option>
														<option value="30" ${requestScope.pagesize==30?"selected='selected'":''}>每页30条</option>
														<option value="40" ${requestScope.pagesize==40?"selected='selected'":''}>每页40条</option>
														<option value="50" ${requestScope.pagesize==50?"selected='selected'":''}>每页50条</option>
														<option value="60" ${requestScope.pagesize==60?"selected='selected'":''}>每页60条</option>
														<option value="70" ${requestScope.pagesize==70?"selected='selected'":''}>每页70条</option>
														<option value="80" ${requestScope.pagesize==80?"selected='selected'":''}>每页80条</option>
														<option value="90" ${requestScope.pagesize==90?"selected='selected'":''}>每页90条</option>
														<option value="100" ${requestScope.pagesize==100?"selected='selected'":''}>每页100条</option>
													</select>
		<div class="btn-group">
		                <%
						int pagenow1=Integer.parseInt(request.getAttribute("pagenow").toString());
					    int totalpage1=Integer.parseInt(request.getAttribute("totalpage").toString());
					    if(pagenow1>1&&pagenow1<=totalpage1){
						%>
						<a href="${pageContext.request.contextPath }/erp/loanBefore_list.do?type=wdrw&dn=businessPayApplication&cn=${requestScope.cn }&qn=list&selectMsg=${requestScope.selectMsg}&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow-1}&fsid=${requestScope.fsid }" class="btn btn-default">«</a>						
						<%				    	
				         }						
						 if(pagenow1>=1&&pagenow1<totalpage1){
						%>
						<a href="${pageContext.request.contextPath }/erp/loanBefore_list.do?type=wdrw&dn=businessPayApplication&cn=${requestScope.cn }&qn=list&selectMsg=${requestScope.selectMsg}&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow+1}&fsid=${requestScope.fsid }" class="btn btn-default">»</a>
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
			<th class="hidden-xs text-center" style="width:100px">业务类型</th>
			<th class="hidden-xs text-center" style="width:100px">合作商</th>
			<th class="hidden-xs text-center" style="width:200px">申请日期</th>
			
			
			<!-- <th class="hidden-xs text-center" style="width:100px">申请人</th>
			<th class="text-center" style="width:100px">部门</th>
			<th class="hidden-xs text-center" style="width:200px">收款账户</th>
			<th class="hidden-xs text-center">收款开户行</th>
			<th class="hidden-xs text-center">金额</th>
			<th class="hidden-xs text-center">大写金额</th>
			<th class="hidden-xs text-center">付款用途</th> -->
			<!-- 付款用途（代收代付购车本金、代收代付服务费） -->
			<th style="width:100px;" class="text-center">操作</th>
		</tr>
		<c:forEach  var="pd" items="${requestScope.pdDate}" varStatus="status">
		<tr>
			<td class="text-center hidden-xs"><input name="delid" value="4510" type="checkbox"></td>
			<td class="text-center">${pd.code}</td>
			<td class="text-center">${pd.name}</td>
			<td class="text-center">
				<c:if test="${pd.cars_type==1}">
					新车
				</c:if>
				<c:if test="${pd.cars_type==2}">
					二手车
				</c:if>
			</td>
			<td class="hidden-xs text-center">${pd.fs_name}</td>
			<td class="text-center" ><fmt:formatDate value="${pd.date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
			<!-- 诗兴大发啊实打实的 -->
			<!-- <td class="hidden-xs text-center">刘大帅</td>
			<td class="hidden-xs text-center">技术部</td>
			<td class="hidden-xs text-center">云车网有限公司</td>
			<td class="hidden-xs text-center">中国建设银行大木桥路支行</td>
			<td class="hidden-xs text-center">60800</td>
			<td class="hidden-xs text-center">六万零八百</td>
			<td class="hidden-xs text-center">代收代付购车本金</td> -->
			<td class="text-center">
				<div class="table-button text-center">
					<a title="" href="${pageContext.request.contextPath}/erp/loanBefore_form.do?type=wdrw&dn=businessPayApplication&qn=form&cn=w1&icbc_id=${pd.icbc_id}&date=${pd.date}" class="btn btn-default">
					<i class="fa fa-pencil"></i></a>
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
				        <li><a href="${pageContext.request.contextPath }/erp/loanBefore_list.do?type=wdrw&dn=businessPayApplication&cn=${requestScope.cn }&qn=list&selectMsg=${requestScope.selectMsg}&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow-1}&fsid=${requestScope.fsid }" aria-label="Next"><span aria-hidden="true">«</span></a></li>
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
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/erp/loanBefore_list.do?type=wdrw&dn=businessPayApplication&cn=${requestScope.cn }&qn=list&selectMsg=${requestScope.selectMsg}&pagesize=${requestScope.pagesize}&pagenow=<%=j %>&fsid=${requestScope.fsid }">
					   <%=j %>
					   </a>
					   </li>
					   <%
				       }else{
					   %>
	                   <li id="l<%=j %>" >
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/erp/loanBefore_list.do?type=wdrw&dn=businessPayApplication&cn=${requestScope.cn }&qn=list&selectMsg=${requestScope.selectMsg}&pagesize=${requestScope.pagesize}&pagenow=<%=j %>&fsid=${requestScope.fsid }">
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
						  <li><a href="${pageContext.request.contextPath }/erp/loanBefore_list.do?type=wdrw&dn=businessPayApplication&cn=${requestScope.cn }&qn=list&selectMsg=${requestScope.selectMsg}&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow+1}&fsid=${requestScope.fsid }" aria-label="Next"><span aria-hidden="true">»</span></a></li>  
						   </c:if>
					   </c:if>
					     				
					   </ul>
			</c:if>		   
				<div class="page-num">共${requestScope.totalsize}个 分${requestScope.totalpage}页显示</div>
</div>
					</section><!-- /.content -->
		</div>