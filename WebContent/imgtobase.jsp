<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>征信查询接口 base64 统一</h1>
<form action="tofindzx.do" method="post" enctype="multipart/form-data">
          正面照图片:<input type="text" name="fronttobase"/><br/>
          反面照图片:<input type="text" name="oppositetobase"/><br/>
          授权书图片:<input type="text" name="applytobase"/><br/>
          申请书图片:<input type="text" name="authorizetobase"/><br/>
          合照图片:<input type="text" name="hztobase"/><br/>
          唯一的key(用来验证用户):<input type="text" name="ckey"/><br/>
          被 查询人名字:<input type="text" name="name"/><br/>
          手机号:<input type="text" name="phone_num"/><br/>
          身份证号:<input type="text" name="IDcard_num"/><br/>
          授权书编号:<input type="text" name="authorize_num"/><br/>
          操作状态:<input type="text" name="sum_bit"/><br/>
          备注:<input type="text" name="ly"/><br/>
    <input type="submit" value="提交" /> 
</form>
</div>
<div align="center">
<h1>征信查询接口 base64</h1>
<form action="toadd.do" method="post" enctype="multipart/form-data">
          正面照图片:<input type="text" name="fronttobase"/><br/>
          反面照图片:<input type="text" name="oppositetobase"/><br/>
          授权书图片:<input type="text" name="applytobase"/><br/>
          申请书图片:<input type="text" name="authorizetobase"/><br/>
          合照图片:<input type="text" name="hztobase"/><br/>
          唯一的key(用来验证用户):<input type="text" name="ckey"/><br/>
          被 查询人名字:<input type="text" name="name"/><br/>
          手机号:<input type="text" name="phone_num"/><br/>
          身份证号:<input type="text" name="IDcard_num"/><br/>
          授权书编号:<input type="text" name="authorize_num"/><br/>
          操作状态:<input type="text" name="sum_bit"/><br/>
          备注:<input type="text" name="ly"/><br/>
    <input type="submit" value="提交" /> 
</form>
</div>
<div align="center">
<h1>征信编辑接口 base64</h1>
<form action="toup.do" method="post" enctype="multipart/form-data">
          正面照图片地址:<input type="text" name="fronttobase"/><br/>
          反面照图片地址:<input type="text" name="oppositetobase"/><br/>
          授权书图片地址:<input type="text" name="applytobase"/><br/>
          申请书图片地址:<input type="text" name="authorizetobase"/><br/>
          合照图片地址:<input type="text" name="hztobase"/><br/>
          唯一的key(用来验证用户):<input type="text" name="ckey"/><br/>
          被 查询人名字:<input type="text" name="name"/><br/>
          手机号:<input type="text" name="phone_num"/><br/>
          身份证号:<input type="text" name="IDcard_num"/><br/>
          授权书编号:<input type="text" name="authorize_num"/><br/>
          操作状态:<input type="text" name="sum_bit"/><br/>
   orderid:<input type="text" name="orderid"/><br/>
    <input type="submit" value="提交" /> 
</form>
</div>
<div align="center">
<h1>传base64编码 上传图片</h1>
<form action="tobase64.do" method="post" enctype="multipart/form-data">
          正面照图片base64编码 :<input type="text" name="fronttobase"/><br/>
          反面照图片base64编码 :<input type="text" name="oppositetobase"/><br/>
          授权书图片base64编码 :<input type="text" name="applytobase"/><br/>
          申请书图片base64编码 :<input type="text" name="authorizetobase"/><br/>
          合照图片base64编码 :<input type="text" name="hztobase"/><br/>
    <input type="submit" value="提交" /> 
</form>
</div>
</body>
</html>