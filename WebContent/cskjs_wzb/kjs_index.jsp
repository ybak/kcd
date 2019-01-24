<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%
String path = request.getContextPath();
String basePath ="https://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html><head>
<link rel="icon" href="${pageContext.request.contextPath }/cskjs_css/logo.png" type="image/x-icon"/>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>快加后台管理</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<script type="text/javascript">
		var _rooturl = "http://a.kcway.net/assess/";
		var page_cn = "";
	</script>
<!-- Bootstrap 3.3.4 -->
<link href="${pageContext.request.contextPath }/cskjs_css/bootstrap.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">

<!-- Font Awesome Icons -->
<!-- Font Awesome Icons -->
<link href="${pageContext.request.contextPath }/cskjs_css/font-awesome.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/cskjs_css/select2.css" rel="stylesheet" type="text/css">
<!-- Theme style -->
<link href="${pageContext.request.contextPath }/cskjs_css/AdminLTE.css" rel="stylesheet" type="text/css">
<!-- AdminLTE Skins. We have chosen the skin-blue for this starter
			page. However, you can choose any other skin. Make sure you
			apply the skin class to the body tag so the changes take effect.
	-->
<link href="${pageContext.request.contextPath }/cskjs_css/skin-green.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/cskjs_css/style.css" rel="stylesheet" type="text/css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		<script src="https://cdn.bootcss.com/html5shiv/r29/html5.min.js"></script>
		<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
<!-- jQuery 2.1.4 -->
<script src="${pageContext.request.contextPath }/cskjs_css/jQuery-2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/jquery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/ajaxfileupload.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/cskjs_css/php.js"></script>
<!-- Bootstrap 3.3.2 JS -->
<script src="${pageContext.request.contextPath }/cskjs_css/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/moment.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/daterangepicker.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/cskjs_css/daterangepicker-bs3.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/cskjs_css/bootstrap-datepicker.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/cskjs_css/datepicker3.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/cskjs_css/bootstrap-datepicker_002.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/bootstrap-datetimepicker.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/cskjs_css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/cskjs_css/bootstrap-datetimepicker_002.js" type="text/javascript"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/cskjs_css/ueditor_002.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/cskjs_css/ueditor.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script src="${pageContext.request.contextPath }/cskjs_css/select2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/zh-CN.js" type="text/javascript"></script>
	
<style type="text/css">
.dada{

    border-bottom: 1px solid #cccee1;
    border-left: 1px solid #cccee1;
    border-right: 1px solid #cccee1;
    padding:15px 15px 15px 15px;
    -moz-border-radius: 5px;
    -webkit-border-radius: 5px;
    border-radius: 4px;
    overflow: hidden;
    -moz-box-shadow: 0 0 60px rgba(0, 0, 0, 0.1);
    -webkit-box-shadow: 0 0 60px rgba(0, 0, 0, 0.1);
    box-shadow: 0 0 5px #4187dd66;
}
		select {
/*Chrome和Firefox里面的边框是不一样的，所以复写了一下*/
border: solid 1px #fff0;

/*很关键：将默认的select选择框样式清除*/
appearance:none;
-moz-appearance:none;
-webkit-appearance:none;

/*在选择框的最右侧中间显示小箭头图片*/
background: url("${pageContext.request.contextPath }/cskjs_css/xljt@2x.png") no-repeat scroll right center transparent;
/*为下拉小箭头留出一点位置，避免被文字覆盖*/
padding-right: 30px;
}
/*清除ie的默认选择框样式清除，隐藏下拉箭头*/
select::-ms-expand { display: none; }
		</style>
	<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath }/cskjs_css/app.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/combo.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/imgup.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/cskjs_css/imgup.css" rel="stylesheet" type="text/css">
<!-- <script src="/comm/jquery.dragsort-0.4.min.js" type="text/javascript"></script> -->
<link href="${pageContext.request.contextPath }/cskjs_css/iconfont.css" rel="stylesheet" type="text/css">
</head>
<!--
	BODY TAG OPTIONS:
	=================
	Apply one or more of the following classes to get the
	desired effect
	|---------------------------------------------------------|
	| SKINS		 | skin-blue								 |
	|				 | skin-black								|
	|				 | skin-purple							 |
	|				 | skin-yellow							 |
	|				 | skin-red								|
	|				 | skin-green								|
	|---------------------------------------------------------|
	|LAYOUT OPTIONS | fixed									 |
	|				 | layout-boxed							|
	|				 | layout-top-nav							|
	|				 | sidebar-collapse						|
	|				 | sidebar-mini							|
	|---------------------------------------------------------|
	-->
<body class="skin-green sidebar-mini fixed">
	<div class="wrapper">
<!-- 导航栏 -->
<jsp:include page="kjs_navbar.jsp"></jsp:include>
<!-- 内容 -->
<div class="content-wrapper" style="min-height: 517px;">
		<!-- Content Header (Page header) -->
<script type="text/javascript">
    function a3(){
		var s=$("#page_limit_select").val();
		var status=$("#status").val();
		var queryname=$("#queryname").val();		
		window.location.href ="TKJSselectAll.do?queryname="+queryname+"&size="+s+"&status="+status;
    }
    function a2(){
    	var oname=$("#type_select").find("option:selected").text();   	
		var s=$("#page_limit_select").val();
		var type_select=$("#type_select").val();
		var queryname=$("#queryname").val();		
		window.location.href ="TKJSselectAll.do?queryname="+queryname+"&size="+s+"&status="+type_select;
    }
</script>				
		<section class="content-header">
			<h1 class="dada">
			快车贷-${requestScope.queryname }<small>共${requestScope.totalCount }个</small>
			<select class="selector" id="type_select" onchange="a2()" style="float: right;">	
			<option value="1" ${requestScope.status==1?"selected='selected'":''}" >全部订单</option>
			<option value="2" ${requestScope.status==2?"selected='selected'":''}">待审核</option>
			<option value="3" ${requestScope.status==3?"selected='selected'":''}">审核通过</option>
			<option value="5" ${requestScope.status==5?"selected='selected'":''}">审核拒绝</option>
			</select>						
			</h1>
			
		</section>
		<!-- Main content -->
		<section class="content">
		<input type="hidden" id="queryname" name="queryname" value="${requestScope.queryname}" >
		<input type="hidden" id="status" name="status" value="${requestScope.status}" >
			<div class="admin-tools">
				<div class="row">
					<div class="col-sm-10 admin-button">
							<div class="btn-group">						
							<a data-toggle="modal"  data-target="#modal2" href="" style="background-color: #447feb;" class="btn btn-default">
							新增</a>																															
							<a href="" style="background-color: #ff8700;" class="btn btn-default">
							导出
							</a>
							</div>
					</div>
					<div class="col-sm-2 admin-page-top hidden-xs">
					   <div class="btn-group" >											
					   <ul class="pagination no-margin">					     				       
						<li>
						<select id="page_limit_select" onchange="a3()" class="form-control">
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
						<a href="TKJSselectAll.do?queryname=${requestScope.queryname }&size=${requestScope.size }&pagenow=${requestScope.pagenow+1}&status=${requestScope.status}" aria-label="Next"><span aria-hidden="true">»</span></a>
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
			<script type="text/javascript">
			 //获取checkbox按钮组
			 var allpro = document.getElementsByName("delid");
			 //全选方法
			 function change() {
			    //获取全选按钮
			 var all = document.getElementById("btcheck_all");
			 //全选按钮被选中时，遍历所有按钮
			    if (all.checked) {
			     for (var i = 0; i < allpro.length; i++) {
			     if (allpro[i].type=="checkbox") {
			     allpro[i].checked=true;

			     }
			     }
			     //全选按钮未被选中时
			    }else{
			     for (var i = 0; i < allpro.length; i++) {
			     if (allpro[i].type=="checkbox") {
			     allpro[i].checked=false;
			     }
			     }
			    }
			 }
			</script>
			<!-- 数据载入中结束 -->
	<table class="table table-bordered table-hover">
	<tbody>
		<tr>
			<th style="width: 3%" class="text-center">
			<input onchange="change()"  id="btcheck_all" class="check_all" type="checkbox">
			</th>
			<th class="hidden-xs text-center">订单编号</th>
			<th class="hidden-xs text-center">公司-姓名</th>
			<th class="hidden-xs text-center">提交时间</th>
			<th class="hidden-xs text-center">客户姓名</th>			
			<th style="width: 40px" class="text-center">操作</th>
			<th class="text-center hidden-xs" style="width: 188px">银联代收代付</th>			<th style="width: 80px">当前状态</th>
		</tr>
		<%int f=1; %>
		<c:forEach items="${requestScope.alist }" var="cert" varStatus="numb">
			<tr>
			<td class="text-center"><input name="delid" value="<%=f %>" type="checkbox"></td>
			<td class="hidden-xs text-center">${cert.gems_code}</td>
			<td class="hidden-xs text-center">来源:${cert.name}-${cert.namee}</td>
			<td class="hidden-xs text-center">${fn:substring(cert.dt_edit,0,16)}</td>
			<td class="hidden-xs text-center">${cert.c_name}</td>
			<td class="text-center">
				<!--  编辑-->
				<div class="table-button">
					<a href="cskjs_wzb/kjs_sh.jsp" class="btn btn-default"><i class="fa fa-pencil"></i></a>
				</div>
			</td>
			<td class="text-center hidden-xs">
					<!--  签约--> 
					<a data-toggle="modal" style="" data-target="#modal" href="icbcyl.do?type=1&name=${cert.c_name }&cardid=${cert.c_cardno}" class="btn btn-default">
					<i class="fa fa-credit-card"></i></a>
					<!--  分期代收--> 
					<a data-toggle="modal" style="" data-target="#modal" class="btn btn-warning" href="icbcyl.do?type=2">
					<i class="fa fa-soccer-ball-o"></i></a> 
					<!--  代收-->
					<a data-toggle="modal" style="" data-target="#modal" class="btn btn-success" href="icbcyl.do?type=3">
					<i class="fa fa-sign-in"></i></a> 
					<!-- 代付 -->
					<a data-toggle="modal" style="" data-target="#modal" class="btn btn-danger" href="icbcyl.do?type=4">
					<i class="fa fa-sign-out"></i></a>
			</td>		
			<td><!--当前状态  -->

			<c:choose>
			<c:when test="${requestScope.status eq '1'}">
			   <%
			   if(f%5==0){
			   %>
			   <span class="label label-success">回退补件</span>	
			   <%}else if(f%2==0||f%3==0){ %>
			   <span class="label label-warning">正在审核中</span>	
			   <%}else{%>
				<span class="label label-success">审核通过</span>	 
			   <% } %>
			</c:when>
			<c:otherwise>
			<c:if  test="${cert.bc_status eq '2'}">
			<span class="label label-warning">正在审核中</span>	
			</c:if>	
			<c:if  test="${cert.bc_status eq '3'}">
			<span class="label label-success">审核通过</span>	
			</c:if>	
			<c:if  test="${cert.bc_status eq '5'}">
			<span class="label label-success">审核通过</span>	
			</c:if>	
			</c:otherwise>
			</c:choose>		
			</td>
	        </tr>
	        <%f++; %>
			</c:forEach>
			</tbody>
</table>				
			</div>
	<div class="foot-page">
			<!-- 分页 -->
			<c:if test="${requestScope.w ge '1' }">
			<ul class="pagination no-margin">
				       <c:if test="${requestScope.pagenow ne '1' }">
				       <li >
				       <a  href="TKJSselectAll.do?queryname=${requestScope.queryname }&size=${requestScope.size}&pagenow=${requestScope.pagenow-1}&status=${requestScope.status}">
				       <span >«</span>
				       </a>
				       </li>
				       </c:if>
				       <%
				       int pagenow=Integer.parseInt(request.getAttribute("pagenow").toString());
				       int totalpage=Integer.parseInt(request.getAttribute("w").toString());
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
					   <a id="a<%=j %>" href="TKJSselectAll.do?queryname=${requestScope.queryname }&size=${requestScope.size }&pagenow=<%=j %>&status=${requestScope.status}">
					   <%=j %>
					   </a>
					   </li>
					   <%
				       }else{
					   %>
	                   <li id="l<%=j %>" >
					   <a id="a<%=j %>" href="TKJSselectAll.do?queryname=${requestScope.queryname }&size=${requestScope.size }&pagenow=<%=j %>&status=${requestScope.status}"><%=j %>					   
					   </a>
					   </li>					   
		               <%
				       }
				       if(j>=totalpage){
					    	  j=i+1; 
					   }
				       }				
		               %>
		               <c:if test="${requestScope.pagenow lt requestScope.w}">
			               <c:if test="${requestScope.w gt 5}">
						   <li>
							   <a href="TKJSselectAll.do?queryname=${requestScope.queryname }&size=${requestScope.size }&pagenow=${requestScope.pagenow+1}&status=${requestScope.status}">
							   <span>»</span>
							   </a>
						   </li>  
						   </c:if>
					   </c:if>					
					   </ul>
					   </c:if>
		 <div class="page-num">共${requestScope.totalCount}个 分${requestScope.w}页显示</div>
	</div>
			
			</section><!-- /.content -->
		</div>
		
		<!-- 弹窗框 -->
		<jsp:include page="kjs_modal.jsp"></jsp:include>


</div>
		



</body></html>