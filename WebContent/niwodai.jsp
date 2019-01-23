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
<h1>根据订单编号查询</h1>
<form action="findorder.do" method="post" enctype="multipart/form-data">
 订单编号:<input type="text" name="orderNo" value=""/><br/>
 ckey:<input type="text" name="ckey" value=""/><br/>   
<input type="submit" value="提交" /> 
</form>
</div>
<div align="center">
<h1>下载授权书申请书</h1>
<form action="download.do" method="post" enctype="multipart/form-data"><br/>
 授权书或申请书名称:<input type="text" name="fileName" value=""/><br/>  
 <input type="submit" value="下载"/><br/> 
</form>
</div>


<div align="center">
<h1>查询授权书申请书</h1>
<form action="getid.do" method="post" enctype="multipart/form-data">
ckey:<input type="text" name="ckey" value=""/><br/>
数量:<input type="text" name="num" value=""/><br/>    
<input type="submit" value="查询"/><br/> 
</form>
</div>
<div align="center">
<h1>审核信息失败结果异步推送接口   (嘉银征信-快加)</h1>
<form action="errcome.do" method="post" enctype="multipart/form-data"><br/>
   订单编号:<input type="text" value="" name="orderNo" /><br/> 
 code:<input type="text" value="" name="code" /><br/>
 codeMsg:<input type="text" value="" name="codeMsg" /><br/>
 <input type="submit" value="查询"/><br/>  
</form>
</div>
<div align="center">
<h1>查询报表信息</h1>
<form action="fbbbbyorder.do" method="post" enctype="multipart/form-data"><br/>
 订单编号:<input type="text" value="" name="orderid" /><br/>
 ckey:<input type="text" value="" name="ckey" /><br/>  
 <input type="submit" value="查询"/><br/>  
</form>
</div>


<div align="center">
<h1>添加门店及人员信息</h1>
<form action="savemdxx.do" method="post" enctype="application/x-www-form-urlencoded"><br/>
公司名称:<input type="text" value="" name="sname" /><br/>
开户等级:<input type="text" value="" name="alevel" /><br/>
开户人名称:<input type="text" value="" name="pname" /><br/>
开户人身份证号:<input type="text" value="" name="pIDcard" /><br/>
手机号:<input type="text" value="" name="pcall" /><br/>
sign:<input type="text" value="" name="sign" /><br/>
time:<input type="text" value="" name="time" /><br/>
 <input type="submit" value="查询"/><br/>  
</form>
</div>
</body>
</html>