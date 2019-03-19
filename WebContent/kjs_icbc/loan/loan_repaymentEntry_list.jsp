<%@page import="com.model1.icbc.erp.PageData"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.util.pagedate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/ajaxfileupload.js"></script>
<style>
	.file {
	    position: relative;
	    display: inline-block;
	    background: #00acd6;
	    border: 1px solid #99D3F5;
	    border-radius: 4px;
	    padding: 6px 12px;
	    overflow: hidden;
	    color: #fff;
	    text-decoration: none;
	    text-indent: 0;
	    line-height: 20px;
	}
	.file input {
	    position: absolute;
	    font-size: 100px;
	    right: 0;
	    top: 0;
	    opacity: 0;
	}
	.file:hover {
	    background: #AADFFD;
	    border-color: #78C3F3;
	    color: #004974;
	    text-decoration: none;
	}
</style>

<div class="content-wrapper" style="min-height: 943px;">
<script type="text/javascript">
    function a3(){
		var s=$("#page_limit_select").val();
		var status=$("#status").val();
		var querytype=$("#querytype").val();		
		window.location.href ="${pageContext.request.contextPath }/loan/selectImpRecordList.do?type=khhklr&dn=loan_repaymentEntry&qn=list&pagesize="+s+"&pagenow=1";
    }
		</script>	
		<section class="content-header">
			<h1>
			客户还款录入<small>
			共1个
			</small>
			</h1>
		</section>
		<!-- Main content -->
		<section class="content">
		<input type="hidden" id="querytype" name="querytype" value="">
		<input type="hidden" id="status" name="status" value="${requestScope.status}">
		<input type="hidden" id="size" name="size" value="${reqeustScope.pagesize}">
			<div class="admin-tools">
				<div class="row">
					<div class="col-sm-10">
						<div class="btn-group">		
							<form style="float: left;" class="form-horizontal" id="ajaxForm" action="${pageContext.request.contextPath }/loan/selectImpRecordList.do?type=khhklr&dn=loan_repaymentEntry&qn=list&cn=w1&pagesize=${requestScope.pagesize}&pagenow=1&param=${requestScope.param}" enctype="multipart/form-data" method="post">
								<input type="text" placeholder="请输入文件名称" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" name="param" style="width:500px;">
								<button class="btn btn-info search-btn" type="submit"  style="background-color:#00acd6;">查询</button> 
							</form>	
							<a href="javascript:;" class="file">导入还款
							   <input id="picture_upload" name="file" type="file" onchange="upload_cover(this)">
							</a>
						</div>
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
							<a href="${pageContext.request.contextPath }/loan/selectImpRecordList.do?type=khhklr&dn=loan_repaymentEntry&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow-1}&param=${requestScope.param}" class="btn btn-default">«</a>						
							<%				    	
					         }						
							 if(pagenow1>=1&&pagenow1<totalpage1){
							%>
							<a href="${pageContext.request.contextPath }/loan/selectImpRecordList.do?type=khhklr&dn=loan_repaymentEntry&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow+1}&param=${requestScope.param}" class="btn btn-default">»</a>
	                        <%
	                        }
	                        %>
                        </li>
						</ul>
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
				<tbody id="titleBox">	
					<tr>
						<th style="width:3%" class="text-center hidden-xs"><input class="check_all" type="checkbox"></th>
						<th class="text-center hidden-xs">序号</th>
						<th class="text-center">文件名称</th>
						<th class="text-center">导入时间</th>
						<th class="text-center">金融产品</th>
						<th class="text-center">操作人员</th>
						<th class="text-center">查看</th>
						<th class="text-center" >下载</th>
					</tr>
					
					<c:forEach var="l1" items="${newpdList}" varStatus="status">
					<tr>
						<td class="text-center hidden-xs"><input name="delid" value="" type="checkbox"></td>
						<td class="text-center hidden-xs">${status.index + 1}</td>
						<td class="text-center">${l1.oriName }</td>
						<td class="text-center" >${fn:substring(l1.dt_add,0,19)}</td>
						<td class="text-center">
							<p>
								${l1.financial_products }
							</p>
						</td>
						<td class="text-center">${l1.mid_name }</td>
						<td class="text-center">
							<p>
							    <c:if test="${!empty l1.filepath}">
								<a href="http://a.kcway.net/assess/${l1.filepath}" target="view_window">
								<i class="fa fa-search-plus"></i>
								</a>
								</c:if>
								<c:if test="${empty l1.filepath}">
								<a href="javascript:alert('未检测到相关文档!')">
								<i class="fa fa-search-plus"></i>
								</a>
								</c:if>
							</p>
						</td>
						<td class="text-center">
							<a href="http://a.kcway.net/assess/${l1.filepath}"><image src="${pageContext.request.contextPath}/image/down.png" style="width:15px;height:15px;"></image></a>
							<%-- <a href="${pageContext.request.contextPath}/loan/downloadOneFile.do?fileUrl=http://a.kcway.net/assess/${l1.filepath}&fileName=${l1.oriName}"><image src="${pageContext.request.contextPath}/image/down.png" style="width:15px;height:15px;"></image></a> --%>
						
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
				        <li><a href="${pageContext.request.contextPath }/loan/selectImpRecordList.do?type=khhklr&dn=loan_repaymentEntry&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow-1}&param=${requestScope.param}" aria-label="Next"><span aria-hidden="true">«</span></a></li>
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
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/loan/selectImpRecordList.do?type=khhklr&dn=loan_repaymentEntry&qn=list&pagesize=${requestScope.pagesize}&pagenow=<%=j %>&param=${requestScope.param}">
					   <%=j %>
					   </a>
					   </li>
					   <%
				       }else{
					   %>
	                   <li id="l<%=j %>" >
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/loan/selectImpRecordList.do?type=khhklr&dn=loan_repaymentEntry&qn=list&pagesize=${requestScope.pagesize}&pagenow=<%=j %>&param=${requestScope.param}">
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
						  <li><a href="${pageContext.request.contextPath }/loan/selectImpRecordList.do?type=khhklr&dn=loan_repaymentEntry&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow+1}&param=${requestScope.param}" aria-label="Next"><span aria-hidden="true">»</span></a></li>  
						   </c:if>
					   </c:if>
					     				
					   </ul>
			</c:if>		   
				<div class="page-num">共${requestScope.totalsize}个 分${requestScope.totalpage }页显示</div>
			</div>
		
		

	<!-- 文件上传 -->
		<script type="text/javascript">
			function upload_cover(obj) {
		        ajax_upload(obj.id, function(data) { //function(data)是上传图片的成功后的回调方法
		            var isrc = data.relatPath.replace(/\/\//g, '/'); //获取的图片的绝对路径
		           console.log("图片的绝对路径->"+isrc)
		        });
		    }  
		    function ajax_upload(feid, callback) { //具体的上传图片方法
		    	console.log("上传开始")
		        if (image_check(feid)) { //自己添加的文件后缀名的验证
		            $.ajaxFileUpload({
		                fileElementId: feid,    //需要上传的文件域的ID，即<input type="file">的ID。
		                url:"${pageContext.request.contextPath}/loan/readExcel.do",		
		                type: 'post',   //当要提交自定义参数时，这个参数要设置成post
		                dataType: 'json',   //服务器返回的数据类型。可以为xml,script,json,html。如果不填写，jQuery会自动判断。
		                secureuri: false,   //是否启用安全提交，默认为false。
		                async : true,   //是否是异步
		                success: function(data) {   //提交成功后自动执行的处理函数，参数data就是服务器返回的数据。
		                	//$("#titleBox").html("");  
		                     alert(data.msg);
		                	 location.href="${pageContext.request.contextPath }/loan/selectImpRecordList.do?type=khhklr&dn=loan_repaymentEntry&qn=list&pagesize=10&pagenow=1";
						
		                },
		                error: function(data, status, e) {  //提交失败自动执行的处理函数。
		                    console.error(e);
		                }
		            });
		        }
		    }
		    function image_check(feid) { //自己添加的文件后缀名的验证
		        var img = document.getElementById(feid);
		        return /.(xlsx|xls)$/.test(img.value)?true:(function() {
		          	alert("格式不对")
		            return false;
		        })();
		    }	
		    
		
		
		</script>	
		
	</section><!-- /.content -->
		
</div>


