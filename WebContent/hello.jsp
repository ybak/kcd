<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"></script>
</head>
 <body>
 <ul>
<li>
5
</li>
<li>
4
</li>
<li>
3
</li>
<li>
2
</li>
</ul>
<form action="user_list.do" method="post" enctype="multipart/form-data">
          账户:<input type="text" name="level"/><br/>
          密码:<input type="text" name="password"/><br/>
    <input type="submit" onclick="s();" value="提交" /> 
    <a href="javascript:void(0)">不跳转</a>
</form>
</body>
</html>