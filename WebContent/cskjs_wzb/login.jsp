<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<link rel="icon" href="${pageContext.request.contextPath }/cskjs_css/logo.png" type="image/x-icon"/>

    <title>H+ 后台 - 登录</title>
  
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/style.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/login.min.css" rel="stylesheet">
    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if(window.top!==window.self){window.top.location=window.location};
    </script>

</head>

<body class="signin">
    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <div class="logopanel m-b">
                        <h1>[ 快加 ]</h1>
                    </div>
                    <div class="m-b"></div>
                    <h4>欢迎使用 <strong>快加 管理后台</strong></h4>
          <!--          <ul class="m-b">
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> </li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> </li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> </li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> </li>
                        <li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> </li>
                    </ul>   --><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                    <strong>还没有账号？ <a href="#">立即注册&raquo;</a></strong>
                </div>
            </div>
            <div class="col-sm-5">
                <form method="post" action="${pageContext.request.contextPath }/ulogin.do?type=kjs" enctype="multipart/form-data">
                    <h4 class="no-margins">登录：</h4>
                    <p class="m-t-md">登录到快加管理后台</p>
                                    
                    <input type="text"  id="username" name="username" value="" class="form-control uname" placeholder="用户名" />
                    <input type="password" id="password" name="password" value="" class="form-control pword m-b" placeholder="密码" />
                    <a href="">忘记密码了？</a>
                    <button class="btn btn-success btn-block">登录</button>
                </form>
            </div>
        </div>
        <div class="signup-footer">
            <div class="pull-left">
                &copy; 2017 All Rights Reserved. 快加
            </div>
        </div>
    </div>
</body>

</html>