<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"


%> 
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
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

<form action="uppdf.do?uid=33&ly=123&zt=查询完成" method="post" enctype="multipart/form-data">
<input style="background-color:lime;" type="file" name="file" value="选择pdf文件"/>
<!-- 请选择上传的图片： -->
<!-- <input type="file" name="file" accept="image/*" /> -->
<input type="submit" value="上传"/>
</form>

</body> 

</html> 