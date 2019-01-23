<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
                                <li><a href="uloginout.do">安全退出</a>
                                </li>
                            </ul>
                        </div>
                        <div class="logo-element">快加
                        </div>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fa fa-home"></i>
                            <span class="nav-label">主页</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">

                        </ul>

                    </li>
                  					<!-- 业务管理后台 start -->
                      <li>
                      	<a href="wangye0119/login.jsp"  target="_blank">
                      		<i class="fa fa-home"></i>
                      		业务管理后台
                      	</a>
                      	
                      </li> 
                 <!-- 业务管理后台 end -->
                    <li>
                        <a href="#">
                            <i class="fa fa fa-money"></i>
                            <span class="nav-label">快豆充值</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="topup.jsp">充值</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="limitfinance.do">充值记录</a>
                            </li>
                    
                        </ul>
                    </li>

                    <li>
                        <a href="#">
                            <i class="fa fa fa-calendar-check-o"></i>
                            <span class="nav-label">征信材料初审</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="zxbybit.do?bit=<%=4%>" >待审核订单</a>
                            </li>
                            
                            <li>
                                <a class="J_menuItem" href="zxbybit.do?bit=<%=5%>" >查询完成订单</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="zxbybit.do?bit=<%=6%>" >回退(撤销)订单</a>
                            </li>
                            
                            <li>
                                <a class="J_menuItem" href="zxbybit.do">全部订单</a>
                            </li>
                        </ul>
                    </li>
                    <!--
                    <li>
                        <a href="#">
                            <i class="fa fa fa-calendar-check-o"></i>
                            <span class="nav-label">嘉银(你我贷)征信初审</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">                       
                            <li>
                                <a class="J_menuItem" href="nwddsh.do?bit=<%=4%>">待审核订单</a>
                            </li>                            
                            <li>
                                <a class="J_menuItem" href="nwddsh.do?bit=<%=5%>">查询完成订单</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="nwddsh.do?bit=<%=6%>">回退(撤销)订单</a>
                            </li>                            
                            <li>
                                <a class="J_menuItem" href="nwddsh.do">全部订单</a>
                            </li>
                        </ul>
                    </li>
                      
                        <li>
                        <a href="#">
                            <i class="fa fa fa-calendar-check-o"></i>
                            <span class="nav-label">嘉银(你我贷)门店人员管理</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">                       
                            <li>
                                <a class="J_menuItem" href="">人员操作记录</a>
                            </li>                            
                            <li>
                                <a class="J_menuItem" href="mdxxlist.do">门店人员列表</a>
                            </li>
                        </ul>
                    </li>
                    -->
                   <li>
                        <a href="#">
                            <i class="fa fa fa-search"></i>
                            <span class="nav-label">API查询记录</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="dsjlist.do">大数据查询</a>
                            </li>
                             <li>
                                <a class="J_menuItem" href="txllist.do">通讯录查询</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="hmdcx.do">黑名单查询</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="apilist.do">个人征信查询</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="wzlist.do">全国违章查询</a>
                            </li>
                            <li>
                            <a class="J_menuItem" href="jbzxlist.do">人行征信简版</a>
                            </li>
                            <li>
                            <a class="J_menuItem" href="selectbyrecord.do">车辆维修保养查询(查博士)</a>   
                            </li>
                            <li>
                            <a class="J_menuItem" href="sgi.do">车辆维修保养查询(瓜子)</a>                            
                            </li>
                            <li>
                            <a class="J_menuItem" href="showAllBX.do">车辆出险查询</a>
                            </li>
                            <li>
                            <a class="J_menuItem" href="selectAllAssessCars.do">车辆评估查询</a>
                            </li>
                        </ul>
                    </li>
                    
                    
                    
                        <li>
                        <a href="#">
                            <i class="fa fa fa-file-pdf-o"></i>
                            <span class="nav-label">授权书申请书</span>
                            <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a class="J_menuItem" href="addapply.jsp">添加</a>
                            </li>
                            <li>
		                        	<a class="J_menuItem">添加记录</a>
                                <ul class="nav nav-second-level">
                                	<li>
	                                	<a class="J_menuItem" href="KCDapply.do?fl=2">&nbsp;&nbsp;->快车道</a>
                                	</li>
                                	<li>
	                                	<a class="J_menuItem" href="KCDapply.do?fl=1">&nbsp;&nbsp;->典当行</a>
                                	</li>
                                </ul>
                            </li>
                            <li>
                                <a class="J_menuItem" href="NoPDFDownloadd.do?sa=0">未回收件</a>
                            </li>
                            <li>
                                <a class="J_menuItem" href="NoPDFDownloadd.do?sa=1">已回收件</a>
                            </li>
                            <li>
                            <a class="J_menuItem" href="PDFDownload.jsp">下载</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-group"></i> 
                        <span class="nav-label">用户</span>
                        <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li><a class="J_menuItem" href="companyreg.jsp">公司（门店）开户</a>
                            </li>
                            <li><a class="J_menuItem" href="staffreg.jsp">员工开户</a>
                            </li>
                             <li><a class="J_menuItem" href="khjl.do">开户记录</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-external-link"></i> 
                        <span class="nav-label">快金所</span>
                        <span class="fa arrow"></span>
                        </a>
                        <ul class="nav nav-second-level">
                            <li>
                            <a href=""><i></i> 
                            <span class="nav-label">工行贷</span>
                            <span class="fa arrow"></span>
                            </a>
                            <ul class="nav nav-second-level">
                                	<li>
	                                	<a class="J_menuItem" href="icbclist.do?bc_status=2">&nbsp;&nbsp;->待审批</a>
                                	</li>
                                	<li>
	                                	<a class="J_menuItem" href="icbclist.do">&nbsp;&nbsp;->全部</a>
                                	</li>
                            </ul>
                            </li>
                            
                        </ul>
                    </li>
                    <!-- 
                    <li>
                     
                     <a href="#">
                     	<i class="fa fa-edit"></i> 
                      <span class="nav-label">帐号管理</span>
                      <span class="fa arrow"></span>
                     </a>
                     <ul class="nav nav-second-level">
                         <li><a class="J_menuItem" href="form_basic.html">添加账号</a></li>
                         <li><a class="J_menuItem" href="empty_xqy.jsp">帐号管理</a></li>
                     </ul>
                    </li>
                        
                    <li>
                    	<a href="#">
                     		<i class="fa fa-home"></i>
                     	    <span class="nav-label">菜单</span>
                     	    <span class="fa arrow"></span>
                     	</a>	
                        <ul class="nav nav-second-level">
                        	<li><a class="J_menuItem" href="PDFDownload.jsp">下载</a></li>
                        	<li><a class="J_menuItem" href="#">管理</a></li>
                        </ul>
                    </li>
                    -->
                    <li>
                    	<a href="#">
                     		<i class="fa fa-home"></i>
                     	    <span class="nav-label">API用户管理</span>
                     	    <span class="fa arrow"></span>
                     	</a>	
                        <ul class="nav nav-second-level">
                        	<li><a class="J_menuItem" href="apiuserlist.do">API用户管理</a></li>
                        	<li><a class="J_menuItem" href="jsp/jbzxapi/addapiuser.jsp">API用户开户</a></li>
                        </ul>
                    </li>
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
                <a href="uloginout.do" class="roll-nav roll-right J_tabExit"><i class="fa fa fa-sign-out"></i> 退出</a>
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