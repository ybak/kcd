<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <title>快加认证 - 主页</title>

    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->

    <link rel="shortcut icon" href="favicon.ico">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css" rel="stylesheet">
    
    <script language=javascript> 
    
function winclose() { 
	alert("sadas")
//此处填写要处理的逻辑代码
window.opener.location.reload();//刷新 
} 
</script> 

</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
    <div id="wrapper">
        <!--左侧导航开始-->
        <nav class="navbar-default navbar-static-side" role="navigation">
            <div class="nav-close"><i class="fa fa-times-circle"></i>
            </div>
            <div class="sidebar-collapse">
                <ul class="nav" id="side-menu">
                	<li class="nav-header">
                        <div class="dropdown profile-element">
                            <span><img alt="image" class="img-circle" src="img/profile_small.jpg" /></span>
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">${sessionScope.name }</strong></span>
                                <span class="text-muted text-xs block">${sessionScope.bc_title }<b class="caret"></b></span>
                                </span>
                            </a>
                            <ul class="dropdown-menu animated fadeInRight m-t-xs">
                              
                                <li><a class="J_menuItem" href="profile.html">个人资料</a>
                                </li>
  
                                <li class="divider"></li>
                                <li><a href="http://a.kcway.net/assess/manager/login.code.php?do=logout">安全退出</a>
                                </li>
                            </ul>
                        </div>
                    </li>
                    <!-- 快金所  start -->
                    <li>
                        <a href="#">
                            <!-- <i class="fa fa-star"></i> 五角小星 -->
                            <i class="fa fa-star"></i>
                            <span class="nav-label">快金所管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
	                        	<a>	
	                        		<i class="fa fa-group"></i>
	                        		<span class="nav-label" >快车贷</span>
	                        		<span class="fa arrow"></span>
	                        	</a>
                                <ul class="nav nav-second-level">
                                	<li>
	                                	<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;
	                                		<i class="fa fa-th-list"></i>押证订单
	                                	</a>
	                                	<ul class="nav nav-second-level">
	                                		<li>
		                                		<a class="J_menuItem" href="TKJSselectAll.do?status=2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审批进件<i class="fa fa-remove" ></i></a>
	                                			<a class="J_menuItem" href="TKJSselectAll.do?status=3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审批通过<i class="fa fa-check" ></i></a>
	                                			<a class="J_menuItem" href="TKJSselectAll.do?status=5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审批拒绝<i class="fa fa-remove"></i></a>
                                			</li>
	                                	</ul>
                                	</li>
                                	<li>
	                                	<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;
	                                		<i class="fa fa-th-list"></i>押车订单
	                                	</a>
	                                	<ul class="nav nav-second-level">
	                                		<li>
	                                			<a class="J_menuItem" href="TKJSselectAllCar.do?status=2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审批进件<i class="fa fa-remove"></i></a>
	                                			<a class="J_menuItem" href="TKJSselectAllCar.do?status=3">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审批通过<i class="fa fa-check"></i></a>
	                                			<a class="J_menuItem" href="TKJSselectAllCar.do?status=5">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;审批拒绝<i class="fa fa-remove"></i></a>
	                                		</li>
	                                	</ul>
                                	</li>
                                </ul>
                            </li>
                            <li>
                                <a onclick="alert('敬请期待!')" class="J_menuItem">
                               	<i class="fa fa-group"></i>
                               	工行贷
                                </a>
                                <!-- <ul class="nav nav-second-level">
                               		<li>
                               			<a href="javacript:;">&nbsp;&nbsp;->AAAAA</a>
                               			<ul class="nav nav-second-level">
	                                		<li>
	                                			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->a1111</a>
	                                			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->a2222</a>
	                                			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->a3333</a>
	                                		</li>
	                                	</ul>
                               		</li>
                               		<li>
                               			<a href="javacript:;">&nbsp;&nbsp;->BBBBB</a>
                               			<ul class="nav nav-second-level">
	                                		<li>
	                                			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->b1111</a>
	                                			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->b2222</a>
	                                			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->b3333</a>
	                                		</li>
	                                	</ul>
                               		</li>
                               		<li>
                               			<a href="#">&nbsp;&nbsp;->CCCCC</a>
                               			<ul class="nav nav-second-level">
	                                		<li>
	                                			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->c1111</a>
	                                			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->c2222</a>
	                                			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->c3333</a>
	                                		</li>
	                                	</ul>
                               		</li>
                               	</ul> -->
                            </li>
                            <li>
                               	<a class="J_menuItem" href="testKJSZJFTen.jsp">
                                <i class="fa fa-group"></i>                                                   
                                                                                   资金方
                                </a>
                                <ul class="nav nav-second-level">
                               		<!-- <li>
                               			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->点融</a>
                               			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->挖财</a>
                               			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->及时雨</a>
                               			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->金投行</a>
                               			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->南金交</a>
                               			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->随手记</a>
                               			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->杉易贷</a>
                               			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->搜易贷</a>
                               			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->铜板街</a>
                               			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->多盈金融</a>
                               			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->e路同心</a>
                               			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->凤凰金融</a>
                               			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->汇盈金融</a>
                               			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->海尔金融</a>
                               			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->海尔小贷</a>
                               			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->空中金融</a>
                               			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->利得金融</a>
                               			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->苏宁金融</a>
                               			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->泰融银行</a>
                               			<a class="J_menuItem" href="javacript:;">&nbsp;&nbsp;&nbsp;&nbsp;->众邦银行</a>
                               		</li> -->
                               	</ul>
                            </li>
                        </ul>
                    </li>
                    <!-- 快金所  end -->
                 </ul>
            </div>
        </nav>
        <!--左侧导航结束-->
        <!--右侧部分开始-->
        <div id="page-wrapper" class="gray-bg dashbard-1">
            <div class="row border-bottom">
                <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                    <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
                        <form role="search" class="navbar-form-custom" method="post" action="">
                            <div class="form-group">
                                <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">
                            </div>
                        </form>
                    </div>
    
                </nav>
            </div>
        <div class="row content-tabs">
                <button class="roll-nav roll-left J_tabLeft"><i class="fa fa-backward"></i>
                </button>
                <nav class="page-tabs J_menuTabs">
                    <div class="page-tabs-content">
                        <a href="javascript:;" class="active J_menuTab" data-id="index_V1.jsp">首页</a>
                    </div>
                </nav>
                <button class="roll-nav roll-right J_tabRight"><i class="fa fa-forward"></i>
                </button>
                <div class="btn-group roll-nav roll-right">
                    <button class="dropdown J_tabClose" data-toggle="dropdown">关闭操作<span class="caret"></span>

                    </button>
                    <ul role="menu" class="dropdown-menu dropdown-menu-right">
                        <li class="J_tabShowActive"><a>定位当前选项卡</a>
                        </li>
                        <li class="divider"></li>
                        <li class="J_tabCloseAll"><a>关闭全部选项卡</a>
                        </li>
                        <li class="J_tabCloseOther"><a>关闭其他选项卡</a>
                        </li>
                    </ul>
                </div>
                <a href="http://a.kcway.net/assess/manager/login.code.php?do=logout" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
            </div>
            <div class="row J_mainContent" id="content-main">
                <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="index_V1.jsp" frameborder="0" data-id="index_V1.jsp" seamless></iframe>
            </div>
            <div class="footer">
                <div class="pull-right">&copy; 2017-2018 <a href="http://www.zi-han.net/" target="_blank">快加认证</a>
                </div>
            </div>
        </div>
        <!--右侧部分结束-->
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/plugins/metisMenu/jquery.metisMenu.js"></script>
    <script src="js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
    <script src="js/plugins/layer/layer.min.js"></script>
    <script src="js/hplus.min.js"></script>
    <script type="text/javascript" src="js/contabs.min.js"></script>
    <script src="js/plugins/pace/pace.min.js"></script>
</body>

</html>