<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"> 

<html> 

<head> 
<title>ceshi</title> 

<meta http-equiv="pragma" content="no-cache"> 

<meta http-equiv="cache-control" content="no-cache"> 

<meta http-equiv="expires" content="0"> 

<meta http-equiv="keywords" content="keyword1,keyword2,keyword3"> 

<meta http-equiv="description" content="This is my page"> 

<!-- 

<link rel="stylesheet" type="text/css" > 

--> 

</head> 

<body> 
<h1>个人征信查询</h1>
<form action="add.do" method="post" enctype="multipart/form-data">
 url:<input type="text " name="url" value="" /><br/>
 姓名:<input type="text " name="name" value="" /><br/>
身份证:<input type="text " name="IDcard_num" value="" /><br/>
手机号:<input type="text " name="phone_num" value="" /><br/>
留言:<input type="text " name="ly" value="" /><br/>
授权书编号:<input type="text " name="authorize_num" value="" /><br/>
登陆的用户名(从登陆信息里的Session获取):<input type="text " name="username" value="赵云" /><br/>
登陆用户的公司(从登陆信息里的Session获取):<input type="text " name="company" value="快加认证" /><br/>
<input style="background-color:lime;" type="file" name="front" value="正面照"/><br/>
<input style="background-color:lime;" type="file" name="opposite" value="反面照"/><br/>
<input style="background-color:lime;" type="file" name="apply" value="申请书"/><br/>
<input style="background-color:lime;" type="file" name="authorize" value="授权书"/><br/>
<input style="background-color:lime;" type="file" name="hz" value="合照"/>
<br/>

<!-- 请选择上传的图片： -->
<!-- <input type="file" name="file" accept="image/*" /> -->
<input type="submit" name="sum_bit" value="查询"/>
<input type="submit" name="sum_bit" value="草稿"/>
</form>

</body> 

</html> 