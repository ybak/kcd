<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>获取交管局</h2>
<form action="http://apitest.kcway.net/obtainRTA.do" enctype="multipart/form-data"   method="post">
appkey:<input type="text" id="appkey" name="appkey" value="" /><br/>
<input type="submit" value="提交">
</form>
<h2>获取车牌类型</h2>
<form action="http://apitest.kcway.net/obtaincarType.do" enctype="multipart/form-data"   method="post">
appkey:<input type="text" id="appkey" name="appkey" value="" /><br/>
<input type="submit" value="提交">
</form>
<h2>查询违章</h2>
<form action="http://apitest.kcway.net/queryPeccancy.do" enctype="multipart/form-data"  method="post">
appkey:<input type="text" id="appkey" name="appkey" value="" /><br/>
交管局代号:<input type="text" id="carorg" name="carorg" value="" /><br/>
车牌前缀:<input type="text" id="lsprefix" name="lsprefix" value="" /><br/>
车牌:<input type="text" id="lsnum" name="lsnum" value="" /><br/>
车辆类型:<input type="text" id="lstype" name="lstype" value="" /><br/>
车架号:<input type="text" id="frameno" name="frameno" value="" /><br/>
发动机号:<input type="text" id="engineno" name="engineno" value="" /><br/>
是否返回城市（1/0）:<input type="text" id="iscity" name="iscity" value="0" /><br/>
手机号:<input type="text" id="mobile" name="mobile" value="" /><br/>
<input type="submit" value="提交">
</form>
</body>
</html>