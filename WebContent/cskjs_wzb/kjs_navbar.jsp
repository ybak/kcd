<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath ="https://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" href="${pageContext.request.contextPath }/cskjs_css/logo.png" type="image/x-icon"/>
	<style>
		.z{
			position: absolute;width: 100%; height:71px; 
		}
		.z1{
			position: absolute;width: 100%; height:109px; 
		}
	</style>
<script type="text/javascript">
$(document).ready(function(){
    //alert('加载完毕');
	$.ajax({
        type: "GET",
        url: "${pageContext.request.contextPath }/icbcno.do",
        dataType: "text",
        success: function(data){
        	$("#sl1").text(data);
        	$("#ft1").text(data);
        }
    });
});
$(document).ready(function(){
$.ajax({
    type: "GET",
    url: "${pageContext.request.contextPath }/kjs_count.do",
    dataType: "text",
    success: function(data){
    	$("#zx").text(data);
    }
});
});
$(document).ready(function(){
	$.ajax({
	    type: "GET",
	    url: "${pageContext.request.contextPath }/kjs_cars_count.do",
	    dataType: "text",
	    success: function(data){
	    	$("#pg").text(data);
	    }
	});
	});
$(document).ready(function(){
	$.ajax({
	    type: "GET",
	    url: "${pageContext.request.contextPath }/kjs_mq_count.do",
	    dataType: "text",
	    success: function(data){
	    	$("#mq").text(data);
	    }
	});
	});
$(document).ready(function(){
	$.ajax({
	    type: "GET",
	    url: "${pageContext.request.contextPath }/kjs_kk_count.do",
	    dataType: "text",
	    success: function(data){
	    	$("#kk").text(data);
	    }
	});
	});
$(document).ready(function(){
	$.ajax({
	    type: "GET",
	    url: "${pageContext.request.contextPath }/kjs_dk_count.do",
	    dataType: "text",
	    success: function(data){
	    	$("#dk").text(data);
	    }
	});
});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- Main Header -->
		<header class="main-header"> <!-- Logo -->
		 <a href="" class="logo"> 
				<span class="logo-mini">
					<img src="${pageContext.request.contextPath }/cskjs_css/logo.png" class="logoimg" width="20" height="20">
				</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg">
					<img src="${pageContext.request.contextPath }/cskjs_css/logo.png" class="logoimg hidden-xs" width="20" height="20">
					<span class="logotxt">
						<b>快金所</b>
					</span>
				</span>
		    </a>
		 <!-- Header Navbar -->
			<nav class="navbar navbar-static-top" role="navigation">
				<!-- Sidebar toggle button--> <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"> <span class="sr-only">Toggle navigation</span>
			</a> <!-- Navbar Right Menu -->
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav">
					<li style="padding-top:13px;padding-right:4px;">
		             <img onclick="jsq_bg();" style="width: 18px;height: 20px;" src="${pageContext.request.contextPath }/cskjs_css/13221901520142706.png">
					</li>
						<!-- User Account Menu -->
						<li class="dropdown user user-menu">
							<!-- Menu Toggle Button --> 
							    <a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
							    <!-- The user image in the navbar-->
								<img src="${pageContext.request.contextPath }/cskjs_css/a.png" class="user-image" alt="User Image"> <!-- hidden-xs hides the username on small devices so only the image appears. -->
								<span class="hidden-xs">${sessionScope.name }</span>
								</a>
						
												
							<ul class="dropdown-menu">
								<!-- The user image in the menu -->
								<li class="user-header"><img src="${pageContext.request.contextPath }/cskjs_css/a.png" class="img-circle" alt="User Image">
									<p>
						${sessionScope.name }-快金所后台管理						
						<small></small>
								</p></li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a data-toggle="modal" data-target="#modal" data-backdrop="true" href="http://a.kcway.net/assess/manager/float.php?type=float&amp;do=setpass" class="btn btn-default btn-flat">修改密码</a>
									</div>
									<div class="pull-right">
										<a href="uloginout.do" class="btn btn-default btn-flat">退出登录</a>
									</div>
							</li>
						</ul>
					</li>
					
						<!-- Control Sidebar Toggle Button -->
					<li>
					<a href="#" data-toggle="control-sidebar" >
					<i class="fa fa-search"></i>
					</a>													
					</li>	
					
			</ul>
				</div>
		</nav>
		</header>

	<aside class="main-sidebar"  style="position: absolute">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar Menu -->
		<ul class="sidebar-menu">
		
		<!-- 
		<li class="">
				<a href="#"> <i class="fa fa-gear"></i> <span>系统管理</span>
				</a>
				<ul class="treeview-menu">
				<li>
						<a href="${pageContext.request.contextPath }/cskjs_wzb/kjs_qxz.jsp"> 
						<i class="fa fa-arrow-circle-o-right"></i> 账号权限
						</a>
					</li>
				<li>
						<a href="${pageContext.request.contextPath }/cskjs_wzb/kjs_account.jsp"> 
						<i class="fa fa-arrow-circle-o-right"></i> 账号管理
						</a>
					</li>
					<li>
						<a href="${pageContext.request.contextPath }/cskjs_wzb/kjs_salesman.jsp"> 
						<i class="fa fa-arrow-circle-o-right"></i> 业务员管理
						</a>
					</li>
					<li>
						<a href="cskjs_wzb/kjs_qxz.jsp"> 
						<i class="fa fa-arrow-circle-o-right"></i> 操作日志
						</a>
					</li>
					<li>
						<a href="cskjs_wzb/kjs_qxz.jsp"> 
						<i class="fa fa-arrow-circle-o-right"></i> 用户习惯
						</a>
					</li>
		</ul>
			</li>
			 -->
		<!--  /// /// /// /// /// /// /// /// /// /// /// /// /// /// /// /// /// /// /// 
		<li>
		<a href="#"> 
		<i class="fa fa-external-link"></i> 
		<span>快车贷<small class="label pull-right bg-red">0</small></span>
		</a>
				<ul class="treeview-menu">
				<li>
				<a href="${pageContext.request.contextPath }/TKJSselectAll.do?status=1&queryname=押车"> 
				<i class="fa fa-arrow-circle-o-right"></i> 
				押车进件(<font color="Lime">0</font>)
				</a>
				</li>	
				<li>
				<a href="${pageContext.request.contextPath }/TKJSselectAll.do?status=1&queryname=押证"> 
				<i class="fa fa-arrow-circle-o-right"></i> 
				押证进件(<font color="Lime">0</font>)
				</a>
				</li>					
			    </ul>
			</li>
			-->
        <c:choose>
        <c:when test="${fn:contains(apg,'ghd')}">
        <li class="treeview active">
        </c:when>
        <c:otherwise>
        <li>
        </c:otherwise>
        </c:choose>
		<a href="#"> 
		<i class="fa fa-align-left"></i> 
		<span>工行贷<small id="sl1" class="label pull-right bg-red">0</small></span>
		</a>		
		<ul class="treeview-menu "> 
		<c:choose>
		<c:when test="${fn:contains(apg,'ghd')}">
        <li class="active">
        </c:when>
        <c:otherwise>
        <li>
        </c:otherwise>
        </c:choose>
				<a href="${pageContext.request.contextPath }/newicbc.do?apg=ghd/ghdjj&out=1&id=${requestScope.id}&headid=1"> 
				<i class="fa fa-arrow-circle-o-right"></i> 
				工行贷进件(<font id="ft1" color="Lime">0</font>)	
				</a>
				</li>	
		<c:choose>
		<c:when test="${fn:contains(apg,'zx')}">
        <li class="active">
        </c:when>
        <c:otherwise>
        <li>
        </c:otherwise>
        </c:choose>
		<a href="${pageContext.request.contextPath }/kjs_zx.do?apg=ghd/zx&out=1&id=${requestScope.id}"> 
		<i class="fa fa-blind"></i> 
		<span>征信<small id="zx" class="label pull-right bg-red">0</small></span>
		</a>
		</li>
		<c:choose>
		<c:when test="${fn:contains(apg,'qcpg')}">
        <li class="active">
        </c:when>
        <c:otherwise>
        <li>
        </c:otherwise>
        </c:choose>
		<a href="${pageContext.request.contextPath }/kjs_pg.do?apg=ghd/qcpg&out=1&id=${requestScope.id}"> 
		<i class="fa fa-cab"></i> 
		<span>汽车评估<small id="pg" class="label pull-right bg-red">0</small></span>
			</a>
	
		</li>	

		<c:choose>
		<c:when test="${fn:contains(apg,'kk')}">
        <li class="active">
        </c:when>
        <c:otherwise>
        <li>
        </c:otherwise>
        </c:choose>
		<a href="${pageContext.request.contextPath }/kjs_kk.do?apg=ghd/kk&out=1&id=${requestScope.id}"> 
		<i class="fa fa-credit-card"></i> 
		<span>开卡<small id="kk" class="label pull-right bg-red">0</small></span>
			</a>
	
		</li>	

		<c:choose>
		<c:when test="${fn:contains(apg,'qcdk')}">
        <li class="active">
        </c:when>
        <c:otherwise>
        <li>
        </c:otherwise>
        </c:choose>
		<a href="${pageContext.request.contextPath }/kjs_dk.do?apg=ghd/qcdk&out=1&id=${requestScope.id}"> 
		<i class="fa fa-taxi"></i> 
		<span>汽车贷款<small id="dk" class="label pull-right bg-red">0</small></span>
			</a>
	
		</li>	

		<c:choose>
		<c:when test="${fn:contains(apg,'spmq')}">
        <li class="active">
        </c:when>
        <c:otherwise>
        <li>
        </c:otherwise>
        </c:choose>
		<a href="${pageContext.request.contextPath }/kjs_mq.do?apg=ghd/spmq&out=1&id=${requestScope.id}"> 
		<i class="fa fa-video-camera"></i> 
		<span>视频面签<small id="mq" class="label pull-right bg-red">0</small></span>
		</a>
	
		</li>
			</ul>
			
			</li>

		
		
		
				
			<!--  
		<li>
		<a href="#"> 
		<i class="fa fa-external-link"></i> 
		<span>资金方<small class="label pull-right bg-red">32</small></span>
		</a>
				<ul class="treeview-menu">
				<li>
				<a href=""> 
				<i class="fa fa-arrow-circle-o-right"></i> 
				资金方管理
				</a>
				</li>		
		        </ul>
		</li>
		-->
		<c:choose>
		<c:when test="${fn:contains(apg,'zhgl')}">
        <li class="active">
        </c:when>
        <c:otherwise>
        <li>
        </c:otherwise>
        </c:choose>
		<a href="#"> 
		<i class="fa fa-address-card "></i> 
		<span>账户管理</span>
		</a>
				<ul class="treeview-menu">
		<c:choose>
		<c:when test="${fn:contains(apg,'shsgl')}">
        <li class="active">
        </c:when>
        <c:otherwise>
        <li>
        </c:otherwise>
        </c:choose>
				<a href="${pageContext.request.contextPath }/icbc/gems_list.do?apg=zhgl/shsgl"> 
				<i class="fa fa-arrow-circle-o-right"></i> 
				商户师管理
				</a>
				</li>		
		        </ul>
		</li>
			<!--  /// /// /// /// /// /// /// /// /// /// /// /// /// /// /// /// /// /// /// -->
					</ul> <!-- /.sidebar-menu -->
</section> <!-- /.sidebar -->
</aside>
<script>
$('li.active').parents('li').addClass('treeview').addClass('active');
</script>	
<script type="text/javascript">
				
				function jsq_bg() {
					 var frameSrc="https://www.jiandaoyun.com/f/5ac1916c493acc231b3eee25?from=groupmessage&isappinstalled=0";
			    	   //给iframe加上src路径
			         $("#jsqiframe").attr("src", frameSrc);					
			          //显示模态框  只有在选择编辑的行   然后根据回调函数成功后才会显示模态框
			         $('#jsqmyModal').modal({ show: true, backdrop: 'static' });
			    	 	}
</script>
<!-- 模态框（Modal） -->
<div class="modal fade" id="jsqmyModal" tabindex="-1" role="dialog" aria-labelledby="jsqmyModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
            </div>
            <div class="modal-body">
            <div style="height:800px; position: relative;">
			<div class='z' style="background:#0DB3A6;top: 0; text-align: center; font-size: 25px; font-weight: 800px; color:#ffffff; line-height: 70px;"> 
			费率计算器
			</div>
            <iframe  id="jsqiframe" name="jsqiframe"  width="100%" height="100%" frameborder="0">

            </iframe>
            <div class='z1' style="bottom:0; background:white;">
            <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
            </div>
		    </div>
            </div>
            
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</body>
</html>