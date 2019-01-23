<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
<link rel="icon" href="${pageContext.request.contextPath }/cskjs_css/logo.png" type="image/x-icon"/>

    <title>K+ 后台 - 登录</title>
  
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/style.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/login.min.css" rel="stylesheet">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js" type="text/javascript"></script>
    <script src="kjs_icbc_style/js/jquery.form.js" type="text/javascript"></script>
    <!--[if lt IE 8]>
    <meta http-equiv="refresh" content="0;ie.html" />
    <![endif]-->
    <script>
        if(window.top!==window.self){window.top.location=window.location};
    </script>

</head>
<script type="text/javascript">
function dologin(){
	var form = $("#loginform").get(0);
	if(form.username.value==""){
		alert("请输入用户名");
		return false;
	}
	if(form.password.value==""){
		alert("请输入密码");
		return false;
	}
		//登陆
		var username =document.getElementById("username").value;
		var password =document.getElementById("password").value;
		$.ajax({
		       url:"${pageContext.request.contextPath}/erp/erp_login.do",
		       type:"post",
 		       dataType:"json",
		       data:{
		    	   username:username,
		    	   password:password
		       },	
		       success:function(data){
		    	alert(data.msg);
		    	if(data.code==1){
		    		 window.location.href='${pageContext.request.contextPath}/erp/index.do';
		    	}
		       },	
		       error:function(e){
		        alert("错误！！");
		       }
		});
}
</script>
<body class="signin">
    <div class="signinpanel">
        <div class="row">
            <div class="col-sm-7">
                <div class="signin-info">
                    <div class="logopanel m-b">
                        <h1>[ 快金所 ]</h1>
                    </div>
                    <div class="m-b"></div>
                    <h4>欢迎使用 <strong>快金所 管理后台</strong></h4>
      
                </div>
            </div>
            <div class="col-sm-5">
                <form id="loginform" >
                    <h4 class="no-margins">登录：</h4>
                    <p class="m-t-md">登录到快金所管理后台</p>   
                    <input type="text"  id="username" name="username" value="" class="form-control uname" placeholder="用户名" />
                    <input type="password" id="password" name="password" value="" class="form-control pword m-b" placeholder="密码" />
                    <a onclick="dologin()" id="btn_submit" class="btn btn-success btn-block">登录</a>
                </form>
            </div>
        </div>
        
    </div>
</body>

</html>