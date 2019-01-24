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
<script type="text/javascript" src="${pageContext.request.contextPath }/cskjs_css/bootstrap-select.js"></script>    
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/cskjs_css/bootstrap-select.css">    
 
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
		var time=$("#new_time").val();
		var gems_fs_id=$("#new_gems_fs_id").val();	
		var keyword=$("#new_keyword").val();
		window.location.href ="${pageContext.request.contextPath }/icbc/gems_list.do?size="+s
		  +"&time="+time+
			"&gems_fs_id="+gems_fs_id+
				"&keyword="+keyword;
    }
</script>				
		<section class="content-header">
			<h1 class="dada">
			商户师管理<small>共${requestScope.totalno }个</small>
					
			</h1>
			
		</section>
		<!-- Main content -->
		<section class="content">
		<input type="hidden" id="new_time" name="new_time" value="${requestScope.new_time}" >
		<input type="hidden" id="new_gems_fs_id" name="new_gems_fs_id" value="${requestScope.new_gems_fs_id}" >
		<input type="hidden" id="new_keyword" name="new_keyword" value="${requestScope.new_keyword}" >

			<div class="admin-tools">
				<div class="row">
					<div class="col-sm-10 admin-button">
							<!-- 
							<div class="btn-group">						
							<a data-toggle="modal"  data-target="#myModal1" href="" style="background-color: #447feb;" class="btn btn-default">
							新增</a>																															
							</div>
							 -->
					</div>
					<div class="col-sm-2 admin-page-top hidden-xs">
					   <div class="btn-group" >											
					   <ul class="pagination no-margin">					     				       
						<li>
						<select id="page_limit_select" onchange="a3()" class="form-control">
						    <option value="">当前每页${requestScope.size}条</option>
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
						<a href="${pageContext.request.contextPath }/icbc/gems_list.do?size=${requestScope.size }&pagenow=${requestScope.pagenow-1}&time=${requestScope.new_time}&gems_fs_id=${requestScope.new_gems_fs_id}&keyword=${requestScope.new_keyword}" class="btn btn-default">«</a>						
						<%				    	
				         }						
						 if(pagenow1>=1&&pagenow1<totalpage1){
						%>
						<a href="${pageContext.request.contextPath }/icbc/gems_list.do?size=${requestScope.size }&pagenow=${requestScope.pagenow+1}&time=${requestScope.new_time}&gems_fs_id=${requestScope.new_gems_fs_id}&keyword=${requestScope.new_keyword}" class="btn btn-default">»</a>
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
			<th style="width: 3%" class="text-center hidden-xs">
			<input onchange="change()" id="btcheck_all" name="btcheck_all" class="check_all" type="checkbox">
			</th>
			<th class="text-center" style="width:150px;">姓名</th>
			<th class="text-center">手机-用户名</th>
			<th class="hidden-xs text-center">所属店名</th>
			<th class="hidden-xs text-center">级别</th>
			<th class="text-center" style="width:90px">状态</th>
			<th class="hidden-xs text-center">更新时间</th>
			<th style="width: 10% text-center" class="text-center">操作</th>
		</tr>
		<c:forEach items="${requestScope.list }" var="map">

		<tr>
			<td class="text-center hidden-xs">
			<input id="delid" name="delid" value="${map.id}" type="checkbox"></td>
			<td class="user-table-info">
				<div class="media">
					<div class="media-left hidden-xs">
					<a href="javascript:;" class="user-face-pic"> 
					<c:if test="${!empty map.imgurl }">
					<img class="media-object" src="http://a.kcway.net/assess/${map.imgurl }" width="36px" height="36px"> 
					</c:if>
					<c:if test="${empty map.imgurl }">
					<img class="media-object" src="http://a.kcway.net/assess/manager/css20/images/face.png"  width="36px" height="36px"> 
					</c:if>
					</a></div>
					<div class="media-body media-middle">
						<h5 class="media-heading">
							<a href="javascript:;">${map.name }</a>
						</h5>
						<p></p>
					</div>
				</div>
			</td>
			<td class="text-center">${map.mobile }-${map.username }</td>
			<td class="hidden-xs text-center">
			<a href="">
			${map.fsname }
			</a></td>
			<td class="hidden-xs text-center">
			<c:if test="${map.cp eq '0' }">
			<span class="label label-danger">三级账号</span>
			</c:if>
			<c:if test="${map.cp eq '1' }">
			<span class="label label-success">一级账号</span>
			</c:if>
            <c:if test="${map.cp eq '2' }">
			<span class="label label-warning">二级账号</span>
			</c:if>
			</td>
			<td class="text-center">
				<select id="showtag_${map.id}"  class="form-control">
					<option value="1" ${map.showtag==1?"selected='selected'":'' } >开通</option>
					<option value="0" ${map.showtag==0?"selected='selected'":'' } >屏蔽</option>
				</select>
			</td>
			<td class="hidden-xs text-center">${fn:substring(map.dt_edit,0,19)}</td>
			<td class="text-center">
				<div class="table-button text-center">
				  
					<a onclick="admincz('${map.id}');"  data-toggle="modal"  data-target="#myModal1"  class="btn btn-default">
                    <c:if test="${empty map.zx_result}">
                    <span class="label label-warning">无征信</span>
                    </c:if>
                    <c:if test="${!empty map.zx_result}">
                    <span class="label label-success">已有征信</span>
                    </c:if>
                   
                    </a>
				   
				</div>
			</td>
		    </tr>	    		
		</c:forEach>
			</tbody>
</table>	
<script type="text/javascript">
function admincz(id){	
	$.ajax({
		type: "post",
		dataType:"json",
		url: "${pageContext.request.contextPath }/icbc/gems_sh.do",
		data:{
			id : id
		},
		success: function(msg){  			 
			 document.getElementById("fs_name").value=msg.fsname;
			 document.getElementById("gems_name").value=msg.name;
			 document.getElementById("gems_tel").value=msg.mobile;
			 document.getElementById("gems_username").value=msg.username;
			 document.getElementById("cp").value=msg.cp;
			 document.getElementById("gems_card").value=msg.idcard;
			 document.getElementById("aid_ssm").value=msg.aid_ssm;
			 document.getElementById("gems_id").value=msg.id;
			 if(msg.zx_result!=null){				 
				 document.getElementById("zx_result").value=msg.zx_result; 				
			 }
			 if(msg.imgstep1_1!=null){
				 document.getElementById("result_image_view1").src="http://a.kcway.net/assess/"+msg.imgstep1_1; 
				 document.getElementById("apath1").href="http://a.kcway.net/assess/"+msg.imgstep1_1;
			 }
			 if(msg.imgstep2_1!=null){
				 document.getElementById("result_image_view2").src="http://a.kcway.net/assess/"+msg.imgstep2_1; 
				 document.getElementById("apath2").href="http://a.kcway.net/assess/"+msg.imgstep2_1;
			 }
			 if(msg.imgstep3_1!=null){
				 document.getElementById("result_image_view3").src="http://a.kcway.net/assess/"+msg.imgstep3_1; 
				 document.getElementById("apath3").href="http://a.kcway.net/assess/"+msg.imgstep3_1;
			 }
			 if(msg.imgstep4_1!=null){
				 document.getElementById("result_image_view4").src="http://a.kcway.net/assess/"+msg.imgstep4_1; 
				 document.getElementById("apath4").href="http://a.kcway.net/assess/"+msg.imgstep4_1;
			 }
		} 		   
    });
	
	
}

</script>			

			</div>
			
	<div class="foot-page">
			<!-- 分页 -->
			<c:if test="${requestScope.totalpage ge '1' }">
			<ul class="pagination no-margin">
				       <c:if test="${requestScope.pagenow ne '1' }">
				       <li >
				       <a  href="${pageContext.request.contextPath }/icbc/gems_list.do?size=${requestScope.size}&pagenow=${requestScope.pagenow-1}&time=${requestScope.new_time}&gems_fs_id=${requestScope.new_gems_fs_id}&keyword=${requestScope.new_keyword}">
				       <span >«</span>
				       </a>
				       </li>
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
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/icbc/gems_list.do?size=${requestScope.size }&pagenow=<%=j %>&time=${requestScope.new_time}&gems_fs_id=${requestScope.new_gems_fs_id}&keyword=${requestScope.new_keyword}">
					   <%=j %>
					   </a>
					   </li>
					   <%
				       }else{
					   %>
	                   <li id="l<%=j %>" >
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/icbc/gems_list.do?size=${requestScope.size }&pagenow=<%=j %>&time=${requestScope.new_time}&gems_fs_id=${requestScope.new_gems_fs_id}&keyword=${requestScope.new_keyword}"><%=j %>					   
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
						   <li>
							   <a href="${pageContext.request.contextPath }/icbc/gems_list.do?size=${requestScope.size }&pagenow=${requestScope.pagenow+1}&time=${requestScope.new_time}&gems_fs_id=${requestScope.new_gems_fs_id}&keyword=${requestScope.new_keyword}">
							   <span>»</span>
							   </a>
						   </li>  
						   </c:if>
					   </c:if>					
					   </ul>
					   </c:if>
		 <div class="page-num">共${requestScope.totalno}个 分${requestScope.totalpage}页显示</div>
	</div>
			
			</section><!-- /.content -->
		</div>
		
<!-- 弹窗框 -->
<div class="modal fade" id="myModal1"  aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" align="center" id="myModalLabel">编辑信息</h4>
            </div>
            <div class="modal-body">
 <form class="form-horizontal" id="float_form" enctype="multipart/form-data" action="${pageContext.request.contextPath }/icbc/gems_up.do" method="post">
        <input type="hidden" value="" id="gems_id" name="gems_id" />
        <div class="box-body">
	    <div class="form-group">
		<label for="title2" class="col-sm-4 control-label">
		商户店      
        </label>
		<div class="col-sm-5">
        <input id="fs_name"  name="fs_name" class="form-control" name="" type="text">
        </div>		
	    </div>
	    <div class="form-group">
		<label for="title2" class="col-sm-4 control-label">商户师姓名</label>
		<div class="col-sm-5">
			<input id="gems_name"  name="gems_name" class="form-control" name="" type="text">
		</div>		
	    </div>
	    <div class="form-group">
		<label for="title2" class="col-sm-4 control-label">电话</label>
		<div class="col-sm-5">
			<input id="gems_tel"  name="gems_tel" class="form-control" name="" type="text">
		</div>		
	    </div>
	    <div class="form-group">
		<label for="title2" class="col-sm-4 control-label">登陆用户名</label>
		<div class="col-sm-5">
			<input id="gems_username"  name="gems_username" class="form-control" name="" type="text">
		</div>		
	    </div>
	    <div class="form-group">
		<label for="title2" class="col-sm-4 control-label">密码</label>
		<div class="col-sm-5">
		<input class="form-control" name="" id="" value="" type="text">
		</div>		
	    </div>	    
	    <div class="form-group">
		<label for="title2" class="col-sm-4 control-label">级别</label>
		<div class="col-sm-5">
				<select name="cp" id="cp" class="form-control">
							<option value="1"  >一级账号</option>
							<option value="2"  >二级账号</option>
							<option value="0"  >三级账号</option>						
				</select>
		</div>		
	    </div>
	    <div class="form-group">
		<label for="title2" class="col-sm-4 control-label">实名认证身份证号</label>
		<div class="col-sm-5">
			<input class="form-control" id="gems_card"  name="gems_card" type="text">
		</div>		
	    </div>
	    <div class="form-group">
		<label for="title2" class="col-sm-4 control-label">关联业务员后台账号</label>
		<div class="col-sm-5">
			<select name="aid_ssm" id="aid_ssm" class="form-control">
							<option value="0">请选择</option>
														<option value="3475">张颖</option>
														<option value="3476">林晴</option>
														<option value="3477">薛花</option>
														<option value="3478">唐伟</option>
														<option value="3479">洪启荣</option>
														<option value="3480">游振鑫</option>
														<option value="3481">洪凯东</option>
														<option value="3482">余剑钊</option>
														<option value="3483">林福良</option>
														<option value="3484">薛强</option>
														<option value="3486">游振威</option>
														<option value="3487">万晓峰</option>
														<option value="3491">杨章伟</option>
														<option value="3492">马燕辉</option>
														<option value="3493">王信威</option>
			</select>
		</div>		
	    </div>
	    <div class="form-group">
	     <div class="col-sm-12">
	     <label for="title2" class="col-sm-4 control-label">资料照片 </label>
	     <div class="col-sm-2">
	     <a id="apath1" style="margin-left:30px;" target="_blank" class="badge bg-red" href="${pageContext.request.contextPath }/cskjs_css/301175241676158600.png" id="lblresult_pdf">点击查看</a>
		 <div class="input-group btn  btn-default" style="padding: 10px;">
		 <img id="result_image_view1" name="result_image_view1" width="100px" height="100px" src="${pageContext.request.contextPath }/cskjs_css/301175241676158600.png">									    	
         <input  id="imgstep1_1" name="imgstep1_1" accept="image/*" style="position: absolute; ; left: 1px; top: 1px; width: 100px; height: 100px; opacity: 0;" type="file">
         <span style="color:#dd4b39;position: absolute; top: 0; right: 0;">点击上传</span>
         </div>	
	     </div>	
	     <div class="col-sm-2">
	     <a id="apath2" style="margin-left:30px;"  target="_blank" class="badge bg-red" href="${pageContext.request.contextPath }/cskjs_css/301175241676158600.png" id="lblresult_pdf">点击查看</a>
		 <div class="input-group btn btn-default" style="padding: 10px;">
		 <img id="result_image_view2" name="result_image_view2" width="100px" height="100px" src="${pageContext.request.contextPath }/cskjs_css/301175241676158600.png">									    
         <input   id="imgstep2_1" name="imgstep2_1" accept="image/*" style="position: absolute; ; left: 1px; top: 1px; width: 100px; height: 100px; opacity: 0;" type="file">
         <span style="color:#dd4b39;position: absolute; top: 0; right: 0;">点击上传</span>
         </div>	
	     </div>
	     <div class="col-sm-2">
	     <a id="apath3" style="margin-left:30px;" target="_blank" class="badge bg-red" href="${pageContext.request.contextPath }/cskjs_css/301175241676158600.png" id="lblresult_pdf">点击查看</a>
		 <div class="input-group btn btn-default" style="padding: 10px;">
		 <img id="result_image_view3" name="result_image_view3" width="100px" height="100px" src="${pageContext.request.contextPath }/cskjs_css/301175241676158600.png">									    	
         <input   id="imgstep3_1" name="imgstep3_1" accept="image/*" style="position: absolute; ; left: 1px; top: 1px; width: 100px; height: 100px; opacity: 0;" type="file">
         <span style="color:#dd4b39;position: absolute; top: 0; right: 0;">点击上传</span>
         </div>	
	     </div>
	     <div class="col-sm-2">
	     <a id="apath4" style="margin-left:30px;" target="_blank" class="badge bg-red" href="${pageContext.request.contextPath }/cskjs_css/301175241676158600.png" id="lblresult_pdf">点击查看</a>
		 <div class="input-group btn btn-default" style="padding: 10px;">
		 <img id="result_image_view4" name="result_image_view4" width="100px" height="100px" src="${pageContext.request.contextPath }/cskjs_css/301175241676158600.png">									    	
         <input   id="imgstep4_1" name="imgstep4_1" accept="image/*" style="position: absolute; ; left: 1px; top: 1px; width: 100px; height: 100px; opacity: 0;" type="file">
         <span style="color:#dd4b39;position: absolute; top: 0; right: 0;">点击上传</span>
         </div>	
	     </div>      
	     </div>
	    </div>
<div class="form-group">
<label class="col-sm-2 control-label">征信结果：</label>
<div class="col-sm-10">
<textarea id="zx_result" name="zx_result" style="width: 80%; height: 200px" class="form-control">
</textarea>
</div>
</div>   
</div>
</form>
<script type="text/javascript">
/*window.FileReader本地预览*/
$( document ).ready(function() {
 console.log(2);
$("#imgstep1_1").change(function () {	
         var obj=$("#imgstep1_1")[0].files[0];
         var fr=new FileReader();
         fr.onload=function () {
          $("#result_image_view1").attr('src',this.result);
          $("#apath1").attr('href',this.result);
          console.log(this.result); 
         };
    fr.readAsDataURL(obj);
  });
  
$("#imgstep2_1").change(function () {	
    var obj=$("#imgstep2_1")[0].files[0];
    var fr=new FileReader();
    fr.onload=function () {
     $("#result_image_view2").attr('src',this.result);
     $("#apath2").attr('href',this.result);
     console.log(this.result); 
    };
fr.readAsDataURL(obj);
});

$("#imgstep3_1").change(function () {	
    var obj=$("#imgstep3_1")[0].files[0];
    var fr=new FileReader();
    fr.onload=function () {
     $("#result_image_view3").attr('src',this.result);
     $("#apath3").attr('href',this.result);
     console.log(this.result); 
    };
fr.readAsDataURL(obj);
});

$("#imgstep4_1").change(function () {	
    var obj=$("#imgstep4_1")[0].files[0];
    var fr=new FileReader();
    fr.onload=function () {
     $("#result_image_view4").attr('src',this.result);
     $("#apath4").attr('href',this.result);
     console.log(this.result); 
    };
fr.readAsDataURL(obj);
});

 });
</script>
            </div>
           <div class="modal-footer">
            <button type="button" class="btn btn-default pull-left" data-dismiss="modal" aria-label="Close">取消返回</button>
            <button type="submit" class="btn btn-danger" onclick="$('#float_form').submit()">保存提交</button>
           </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</div>
		
		<!-- 搜索 -->
<aside class="control-sidebar control-sidebar-dark" style="position: fixed; height: 100%; overflow: auto; padding-bottom: 50px;">
		
<div class="tab-content">
				<!-- Home tab content -->
<h3 class="control-sidebar-heading">开始搜索</h3>
<form id="search_form" action="" method="post" enctype="multipart/form-data">
<div class="form-group">
	<label>时间:</label>
	<div class="input-group">
	<input class="form-control daterange" id="time" name="time" value="" placeholder="区间" type="text">
	<div class="input-group-addon"><i class="fa fa-calendar"></i></div>
	</div>
</div>
<div class="form-group">
	<label>选择所属店</label> 
<select class="form-control m-select" name="gems_fs_id" id="gems_fs_id" data-edit-select="1" style="display: none;">
<option value="0">请选择</option>	
<c:forEach var="fs" items="${requestScope.fs }">
<option value="${fs.id }">${fs.namepy }-${fs.name }</option>	
</c:forEach>
</select>
</div>
<div class="form-group">
	<label>输入关键字:</label> 
	<input name="keyword" id="keyword" value="" class="form-control" placeholder="鉴定师/商户师名字/电话/用户名" type="text">
</div>
<button type="button"  onclick="search()" class="btn btn-block btn-primary" >搜索</button>

</form>
</div>
</aside>
<script>
function search() {
	var gems_fs_id=document.getElementById('gems_fs_id').value;
	var time=document.getElementById('time').value;
	var keyword=document.getElementById('keyword').value;
	window.location.href ="${pageContext.request.contextPath }/icbc/gems_list.do?"
	+"gems_fs_id="+gems_fs_id
	+"&time="+time
	+"&keyword="+keyword;
}
</script>
<script type="text/javascript">
$.fn.filterSelect = (function(){	
    // 我就 很 纠结的，把样式内嵌在这里了，让你怎么改!!!!
    var isInit = false;
    function initCss(){

        isInit = true;
        var style = document.createElement("style");
        var csstext = '.m-input-select{color:black;width:100%;display:inline-block;*display:inline;position:relative;-webkit-user-select:none;}'+
                        '.m-input-select ul, .m-input-select li{padding:0;margin:0;color:black;}'+
                        'n.m-input-select .m-input{padding-right:22px;color:black;}'+
                        '.m-input-select .m-input-ico{position:absolute;right:0;top:0;width:22px;height:100%;background:url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAwAAAAMCAYAAABWdVznAAAATElEQVQoU2NkIBEwkqiegTwNcXFx/4m1CW4DMZoWLVrEiOIkfJpAikGuwPADNk0wxVg1gASRNSErxqkBpgldMV4NuEKNvHggNg5A6gBo4xYmyyXcLAAAAABJRU5ErkJggg==) no-repeat 50% 50%;}'+
                        '.m-input-select .m-list-wrapper{}'+
                        '.m-input-select .m-list{display:none;position:absolute;z-index:9;top:100%;left:0;right:0;max-width:100%;max-height:500px;overflow:auto;border-bottom:1px solid #ddd;}'+
                        '.m-input-select .m-list-item{cursor:default;padding:5px;margin-top:-1px;list-style:none;background:#fff;color:black;border:1px solid #ddd;border-bottom:none;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;}'+
                        '.m-input-select .m-list-item:hover{background:#2D95FF;}'+
                        '.m-input-select .m-list-item-active{background:#2D95FF;}';
        style = $("<style>"+ csstext +"</style>")[0];
        // ie 竟然坑了...
        // if(style.styleSheet) {
        //     style.styleSheet.cssText = csstext;
        // }else{
        //     style.appendChild(document.createTextNode(csstext));
        // };

        var head = document.head || document.getElementsByTagName("head")[0];
        if(head.hasChildNodes()){
            head.insertBefore(style, head.firstChild);
        }else{
            head.appendChild(style);
        };

    };

    return function(){
        !isInit && initCss();

        var $body = $("body");
        
        this.each(function(i, v){
            var $sel = $(v), $div = $('<div class="m-input-select"></div>');
            var $input = $("<input type='text' class='m-input form-control' style='width:100%' />");
            // var $wrapper = $("<div class='m-list-wrapper'><ul class='m-list'></ul></div>");
            var $wrapper = $("<ul class='m-list'></ul>");
            
            $div = $sel.wrap($div).hide().addClass("m-select").parent();
            
            $div.append($input).append("<span class='m-input-ico'></span>").append($wrapper);

            // 遮罩层显示 + 隐藏
            var wrapper = {
                show: function(){
                    $wrapper.show();
                    this.$list = $wrapper.find(".m-list-item:visible");
                    this.setIndex(this.$list.filter(".m-list-item-active"));
                    this.setActive(this.index);
                },
                hide: function(){
                    $wrapper.hide();
                },
                next: function(){
                    return this.setActive(this.index + 1);
                },
                prev: function(){
                    return this.setActive(this.index - 1);
                },
                $list: $wrapper.find(".m-list-item"),
                index: 0,
                $cur: [],
                setActive: function(i){
                    // 找到第1个 li，并且赋值为 active
                    var $list = this.$list, size = $list.size();
                    if(size <= 0){
                        this.$cur = [];
                        return;
                    }
                    $list.filter(".m-list-item-active").removeClass("m-list-item-active");
                    if(i < 0){
                        i = 0;
                    }else if(i >= size){
                        i = size - 1;
                    }
                    this.index = i;
                    this.$cur = $list.eq(i).addClass("m-list-item-active");
                    this.fixScroll(this.$cur);
                    return this.$cur;
                },
                fixScroll: function($elem){
                    // console.log($wrapper);
                    var height = $wrapper.height(), top = $elem.position().top, eHeight = $elem.outerHeight();
                    var scroll = $wrapper.scrollTop();
                    // 因为 li 的 实际　top，应该要加上 滚上 的距离
                    top += scroll;
                    if(scroll > top){
                        $wrapper.scrollTop(top);
                    }else if(top + eHeight > scroll + height){
                        // $wrapper.scrollTop(top + height - eHeight);
                        $wrapper.scrollTop(top + eHeight - height);
                    }
                },
                setIndex: function($li){
                    if($li.size() > 0){
                        this.index = this.$list.index($li);
                        $li.addClass("m-list-item-active").siblings().removeClass("m-list-item-active");
                    }else{
                        this.index = 0;
                    }
                }
            };

            // input 的操作
            var operation = {
                // 文字更变了，更新 li, 最低效率的一种
                textChange: function(){
                    val = $.trim($input.val());
                    $wrapper.find(".m-list-item").each(function(i, v){
                        if(v.innerHTML.indexOf(val) >= 0){
                            $(v).show();
                        }else{
                            $(v).hide();
                        }
                    });
                    wrapper.show();
                },
                // 设值
                setValue: function($li){
                    if($li && $li.size() > 0){
                        var val = $.trim($li.html());
                        $input.val(val).attr("placeholder", val);
                        wrapper.setIndex($li);
                        $sel.val($li.attr("data-value")).trigger("change");
                    }else{
                        $input.val(function(i, v){
                            return $input.attr("placeholder");
                        });
                    };
                    wrapper.hide();
                    this.offBody();
                },
                onBody: function(){
                    var self = this;
                    setTimeout(function(){
                        self.offBody();
                        $body.on("click", self.bodyClick);
                    }, 10);
                },
                offBody: function(){
                    $body.off("click", this.bodyClick);
                },
                bodyClick: function(e){
                    var target = e.target;
                    if(target != $input[0] && target != $wrapper[0]){
                        wrapper.hide();
                        operation.setValue();
                        operation.offBody();
                    }
                }
            };
            // 遍历 $sel 对象
            function resetOption(){
            	
                var html = "", val = "";
                $sel.find("option").each(function(i, v){
                	//alert(v.value+"---");
                    if(v.selected && !val){
                        val = v.text;
                    };
                    html += '<li class="m-list-item'+ (v.selected ? " m-list-item-active" : "") +'" data-value="'+ v.value +'">'+ v.text +'</li>';
                });
                $input.val(val);
                $wrapper.html(html);
            };
            $sel.on("optionChange", resetOption).trigger("optionChange");
            $sel.on("setEditSelectValue", function(e, val){
                // console.log(val);
                var $all = $wrapper.find(".m-list-item"), $item;
                for(var i = 0, max = $all.size(); i < max; i++){
                    $item = $all.eq(i);
                    if($item.attr("data-value") == val){
                        operation.setValue($item);
                        return;
                    }
                }
            });

            // input 聚焦
            $input.on("focus", function(){
                this.value = "";
                operation.textChange();
                operation.onBody();
            }).on("input propertychange", function(e){
                operation.textChange();
            }).on("keydown", function(e){
                // 上 38, 下 40， enter 13
                switch(e.keyCode){
                    case 38:
                        wrapper.prev();
                        break;
                    case 40:
                        wrapper.next();
                        break;
                    case 13:
                        operation.setValue(wrapper.$cur);
                        break;
                }
            });

            $div.on("click", ".m-input-ico", function(){
                // 触发 focus 和 blur 事件
                // focus 是因为 input 有绑定
                // 而 blur，实际只是失去焦点而已，真正隐藏 wrapper 的是 $body 事件
                $wrapper.is(":visible") ? $input.blur() : ($input.val("").trigger("focus"));
            });

            // 选中
            $wrapper.on("click", ".m-list-item", function(){
                operation.setValue($(this));
                return false;
            });

            setTimeout(function(){
                // for ie
                wrapper.hide();
            },1);


        });

        return this;
    };
})();
</script>
<script>
// 使用了这个插件，select该怎么用就怎么用
// 任何选择，同样会触发 select 的 更变的说【即select的值会同步更新】
//
var $select = $("select[data-edit-select]").filterSelect();
// --> 这时候的  $select === $("#magicsuggest");
// 也可以 用 $("#magicsuggest").on("change")，两者等价
$select.on("change", function(){
	
    // console.log(this.value)
});
// 也可以通过 $("#magicsuggest").val() 拿到最新的值
// 通过 $("#magicsuggest").trigger("setEditSelectValue", 2); 设置选中的值为 2
// 通过  $("#magicsuggest").trigger("optionChange"); 触发 更新 option 的值
</script>

</body></html>