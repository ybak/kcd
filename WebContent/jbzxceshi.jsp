<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>注册第1步</h1>
<form action="getauthentication.do" method="post" enctype="multipart/form-data">
身份证号： <input type="text"  id="cardno"  name="cardno" /><br>
姓名： <input type="text"  id="name"  name="name" /><br>
验证key值：<input type="text"  id="appKey"  name="appKey" /><br>
<input type="submit" value="提交" /><br>
</form>



<h1>注册第2步</h1>
<form action="getcode.do" method="post" enctype="multipart/form-data" >
注册名：<input type="text"  id="name"  name="name" /><br>
手机号：<input type="text"  id="phoneNo"  name="phoneNo" /><br>
身份证号：<input type="text"  id="cardno"  name="cardno" /><br>
用户令牌：<input type="text"  id="appKey"  name="appKey" /><br>
<input type="submit" value="提交" />
</form>


<h1>注册第3步</h1>
<form action="getuserreg.do" method="post" enctype="multipart/form-data">
 注册名:<input type="text" id="name" name="name"/><br>
身份证名字段:<input type="text" id="cardno" name="cardno"/><br>
手机号:<input type="text" id="phoneNo" name="phoneNo"/><br>
登录名:<input type="text" id="loginName" name="loginName"/><br>
密码:<input type="text" id="passwd" name="passwd"/><br>
短信验证码:<input type="text" id="smsCode" name="smsCode"/><br>
用户令牌:<input type="text" id="appKey" name="appKey"/><br>
<input type="submit" value="提交" />
</form>
<h1>安全问题第1步</h1>
<form action="getquestions.do" method="post" enctype="multipart/form-data">
登录名称:<input type="text" id="loginName" name="loginName"/><br>
登录密码:<input type="text" id="passwd" name="passwd"/><br>
用户令牌:<input type="text" id="appKey" name="appKey"/><br>
<input type="submit" value="提交" />
</form>
<h1>安全问题第2步</h1>
<form action="outquestions.do" method="post" enctype="multipart/form-data">
登录名称:<input type="text" id="loginName" name="loginName"/><br>
登录密码:<input type="text" id="passwd" name="passwd"/><br>
问题1:<input type="text" id="qFirst" name="qFirst"/><br>
问题2:<input type="text" id="qSecond" name="qSecond"/><br>
问题3:<input type="text" id="qThird" name="qThird"/><br>
问题4:<input type="text" id="qFouth" name="qFouth"/><br>
问题5:<input type="text" id="qFivth" name="qFivth"/><br>
用户令牌:<input type="text" id="appKey" name="appKey"/><br>
订单编号:<input type="text" id="ordercode" name="ordercode"/><br>
<input type="submit" value="提交" />
</form>
<h1>征信报告测试</h1>
<form action="getjbzxreport.do" method="post" enctype="multipart/form-data">
用户名:<input type="text" id="loginName" name="loginName"/><br>
密码:<input type="text" id="passwd" name="passwd"/><br>
验证码:<input type="text" id="code" name="code"/><br>
订单编号:<input type="text" id="ordercode" name="ordercode"/><br>
用户令牌:<input type="text" id="appKey" name="appKey"/><br>
<input type="submit" value="提交" />
</form>
<h1>简版征信api开户</h1>
<form action="jsp/jbzxapi/saveapiuser.do" method="post" enctype="multipart/form-data">
姓名:<input type="text" id="api_name" name="api_name"/><br>
手机号:<input type="text" id="api_tel" name="api_tel"/><br>
身份证号:<input type="text" id="api_card" name="api_card"/><br>
公司名称:<input type="text" id="api_companyname" name="api_companyname"/><br>
公司地址:<input type="text" id="api_companyaddress" name="api_companyaddress"/><br>
权限类型:<input type="text" id="api_type" name="api_type"/><br>
<input type="submit" value="提交" />
</form>
</body>
</html>