<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>欢迎使用快车道后台系统</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/kjs_icbc/new_login/css/style2.0.css">
<style type="text/css">
	ul li{font-size: 30px;color:#2ec0f6;}
	.tyg-div{z-index:-1000;float:left;position:absolute;left:5%;top:20%;}
	.tyg-p{
		font-size: 14px;
	    font-family: 'microsoft yahei';
	    position: absolute;
	    top: 135px;
	    left: 60px;
	}
	.tyg-div-denglv{
		z-index:1000;float:right;position:absolute;right:3%;top:10%;
	}
	.tyg-div-form{
		background-color: #23305a;
		width:300px;
		height:auto;
		margin:120px auto 0 auto;
		color:#2ec0f6;
	}
	.tyg-div-form  {padding:10px;}
	.tyg-div-form  input[type="text"]{
		width: 270px;
	    height: 30px;
	    margin: 25px 10px 0px 0px;
	}
	.tyg-div-form  input[type="password"]{
		width: 270px;
	    height: 30px;
	    margin: 25px 10px 0px 0px;
	}
	.tyg-div-form  button{
	    cursor: pointer;
	    width: 270px;
	    height: 44px;
	    margin-top: 25px;
	    padding: 0;
	    background: #2ec0f6;
	    -moz-border-radius: 6px;
	    -webkit-border-radius: 6px;
	    border-radius: 6px;
	    border: 1px solid #2ec0f6;
	    -moz-box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    -webkit-box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    box-shadow:
	        0 15px 30px 0 rgba(255,255,255,.25) inset,
	        0 2px 7px 0 rgba(0,0,0,.2);
	    font-family: 'PT Sans', Helvetica, Arial, sans-serif;
	    font-size: 14px;
	    font-weight: 700;
	    color: #fff;
	    text-shadow: 0 1px 2px rgba(0,0,0,.1);
	    -o-transition: all .2s;
	    -moz-transition: all .2s;
	    -webkit-transition: all .2s;
	    -ms-transition: all .2s;
}
</style>
<body  style="background:#FFF">
<div class="tyg-div">
	<ul>
    	<li>让</li>
    	<li><div style="margin-left:20px;">数</div></li>
    	<li><div style="margin-left:40px;">据</div></li>
    	<li><div style="margin-left:60px;">改</div></li>
    	<li><div style="margin-left:80px;">变</div></li>
    	<li><div style="margin-left:100px;">生</div></li>
    	<li><div style="margin-left:120px;">活</div></li>
    </ul>
</div> 
<div id="contPar" class="contPar">
	<div id="page1"  style="z-index:1;">
		<div class="title0">快车道后台系统</div>
		<div class="title1">欢迎使用快车道后台系统</div>
		<div class="imgGroug">
			<ul>
				<img alt="" class="img0 png" src="${pageContext.request.contextPath }/kjs_icbc/new_login/img/fk.png">
				<img alt="" class="img1 png" src="${pageContext.request.contextPath }/kjs_icbc/new_login/img/jr.png">
				<img alt="" class="img2 png" src="${pageContext.request.contextPath }/kjs_icbc/new_login/img/kj.png">
			</ul>
		</div>
		<img style="padding-top:70px;" alt="" class="img3 png" src="${pageContext.request.contextPath }/kjs_icbc/new_login/img/dz.png">
	</div>
</div>
<div class="tyg-div-denglv" >
	<div class="tyg-div-form" style="background:#d7d9e0;width:273px;">

			<h2>登录</h2><p class="tyg-p">快车道后台系统</p>
			<div style="margin:5px 0px;">
				<input type="text"  id="username" name="username" placeholder="请输入账号..."/>
			</div>
			<div style="margin:5px 0px;">
				<input type="password" id="password" name="password" placeholder="请输入密码..."/>
			</div>
			<%-- <div style="margin:5px 0px;">
				<input type="text" style="width:150px;" placeholder="请输入验证码..."/>
				<img src="${pageContext.request.contextPath }/kjs_icbc/new_login/img/1.png" style="vertical-align:bottom;" alt="验证码"/>
			</div> --%>
			<button onclick="dologin()" type="submit" >登<span style="width:20px;"></span>录</button>
	</div>
</div>
<script type="text/javascript">
function dologin(){
	//登陆
	var username =document.getElementById("username").value;
	var password =document.getElementById("password").value;
	
	if(username==""){
		alert("请输入用户名");
		return false;
	}
	if(password==""){
		alert("请输入密码");
		return false;
	}

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
<script type="text/javascript" src="${pageContext.request.contextPath }/kjs_icbc/new_login/js/jquery-1.8.0.min.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath }/kjs_icbc/new_login/js/com.js"></script>
   
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/jquery.form.js" type="text/javascript"></script>



</body>
</html>