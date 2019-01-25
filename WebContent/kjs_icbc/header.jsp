<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
		<!-- Main Header -->
		<header class="main-header" > <!-- Logo -->
		 <a href="" class="logo" style="background-color:#12122b;"> <!-- mini logo for sidebar mini 50x50 pixels -->
				<span class="logo-mini">
					<c:if test="${empty sessionScope.pd.fs_oemimgurl }"><img src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/images/logo.png" class="logoimg" width="20" height="20">
				    </c:if>
				    <c:if test="${!empty sessionScope.pd.fs_oemimgurl }"><img src="http://a.kcway.net/${sessionScope.pd.fs_oemimgurl }" class="logoimg" width="20" height="20">
				    </c:if>
				</span> <!-- logo for regular state and mobile devices -->
				<span class="logo-lg">
				<c:if test="${empty sessionScope.pd.fs_oemimgurl }"><img src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/images/logo.png" class="logoimg hidden-xs" width="20" height="20"></c:if>
				<c:if test="${!empty sessionScope.pd.fs_oemimgurl }"><img src="http://a.kcway.net/${sessionScope.pd.fs_oemimgurl }" class="logoimg hidden-xs" width="20" height="20"></c:if>
					<span class="logotxt">
						<b>
						<c:if test="${empty sessionScope.pd.fs_xt_name}">
						  快金所系统
					    </c:if>	
					    <c:if test="${!empty sessionScope.pd.fs_xt_name}">
						 ${sessionScope.pd.fs_xt_name}
					    </c:if>	
						</b>
					</span>
				</span>
				
				
		</a> 
		<!-- Header Navbar -->
			<nav class="navbar navbar-static-top" role="navigation" style="background-color:#12122b;">
				<!-- Sidebar toggle button--> 
				<a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button"> 
				<span class="sr-only">Toggle navigation</span>
			    </a> 
			    <!-- Navbar Right Menu -->
			    <div>
			    
			    </div>
			    
				<div class="navbar-custom-menu">
					<ul class="nav navbar-nav" style="height: 80px;">
<!-- 					<li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                                         主题皮肤
                    <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                    <li><a onclick="skins('skin-yellow')">黄色</a></li>
                    <li><a onclick="skins('skin-black')">白色</a></li>
                    <li><a onclick="skins('skin-blue')">蓝色</a></li>
                    <li><a onclick="skins('skin-purple')">紫色</a></li>
                    <li><a onclick="skins('skin-red')">红色</a></li>
                    <li><a onclick="skins('skin-green')">绿色</a></li>
                    </ul>
                    </li> -->
		    					  			
						<!-- User Account Menu -->
						<li class="dropdown user user-menu" style="height: 80px;">
							<!-- Menu Toggle Button --> 
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" style="height: 80px;">
							 <!-- The user image in the navbar-->
							    <c:if test="${empty sessionScope.pd.gems_imgurl }">
								<img src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/images/a.png" class="user-image" alt="User Image"> 
								</c:if>
								<c:if test="${!empty sessionScope.pd.gems_imgurl }">
								<img src="http://a.kcway.net/assess/${sessionScope.pd.gems_imgurl }" class="user-image" alt="User Image"> 
								</c:if>
								<!-- hidden-xs hides the username on small devices so only the image appears. -->
								<br/>
								${sessionScope.pd.name }
						</a>
							<ul class="dropdown-menu">
								<!-- The user image in the menu -->
								<li class="user-header">
								<c:if test="${empty sessionScope.pd.gems_imgurl }">
								<img src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/images/a.png" class="img-circle" alt="User Image">
								</c:if>
								<c:if test="${!empty sessionScope.pd.gems_imgurl }">
								<img src="http://a.kcway.net/assess/${sessionScope.pd.gems_imgurl }" class="img-circle" alt="User Image"> 
								</c:if>
								
									<p>
						       ${sessionScope.pd.fsname }-${sessionScope.pd.name }		
						       <small>${sessionScope.pd.bc_title }</small>
								</p></li>
								<!-- Menu Footer-->
								<li class="user-footer">
									<div class="pull-left">
										<a data-toggle="modal" data-target="#modal" data-backdrop="true" href="" class="btn btn-default btn-flat">修改密码</a>
									</div>
									<div class="pull-right">
										<a href="${pageContext.request.contextPath }/erp/erp_outlogin.do" class="btn btn-default btn-flat">退出登录</a>
									</div>
							</li>
						</ul>
					</li>
						<!-- Control Sidebar Toggle Button -->
								
			</ul>
				</div>
		</nav>
		</header>