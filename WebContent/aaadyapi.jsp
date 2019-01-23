<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


 <h1>1添加分类信息 √</h1>   
<form action="kjs_dyflxxsend.do" method="post" enctype="multipart/form-data">
 输入id:
 <input type="text" name="id" id="id"/><br/>
抵押类型:
 <input type="text" name="kjs_type" id="kjs_type"/><br/>

<input type="submit" value="提交" />        
</form>
 <h1>2添加借款人订单信息 √</h1>   
<form action="kjs_dysendjkrxx.do" method="post" enctype="multipart/form-data">
 输入id:
 <input type="text" name="id" id="id"/><br/>
抵押类型:
 <input type="text" name="kjs_type" id="kjs_type"/><br/>

<input type="submit" value="提交" />        
</form>
 <h1>3添加借款人进件信息 √</h1>   
<form action="kjs_jkrxx.do" method="post" enctype="multipart/form-data">
 输入id:
 <input type="text" name="id" id="id"/><br/>
抵押类型:
 <input type="text" name="kjs_type" id="kjs_type"/><br/>

<input type="submit" value="提交" />        
</form>
 <h1>4提交初审 √</h1>   
<form action="kjs_tjcs.do" method="post" enctype="multipart/form-data">
 输入id:
 <input type="text" name="id" id="id"/><br/>
抵押类型:
 <input type="text" name="kjs_type" id="kjs_type"/><br/>

<input type="submit" value="提交" />        
</form>
 <h1>5查询终审 √</h1>   
<form action="kjs_findzs.do" method="post" enctype="multipart/form-data">
 输入id:
 <input type="text" name="id" id="id"/><br/>
抵押类型:
 <input type="text" name="kjs_type" id="kjs_type"/><br/>

<input type="submit" value="提交" />        
</form>
 <h1>6抵押登记 √</h1>   
<form action="kjs_dydj.do" method="post" enctype="multipart/form-data">
 输入id:
 <input type="text" name="id" id="id"/><br/>
抵押类型:
 <input type="text" name="kjs_type" id="kjs_type"/><br/>

<input type="submit" value="提交" />        
</form>
 <h1>7查询放款许可 √</h1>   
<form action="kjs_fkxk.do" method="post" enctype="multipart/form-data">
 输入id:
 <input type="text" name="id" id="id"/><br/>
抵押类型:
 <input type="text" name="kjs_type" id="kjs_type"/><br/>

<input type="submit" value="提交" />        
</form>
 <h1>8放款√</h1>   
<form action="kjs_fkresult.do" method="post" enctype="multipart/form-data">
 输入id:
 <input type="text" name="id" id="id"/><br/>
抵押类型:
 <input type="text" name="kjs_type" id="kjs_type"/><br/>

<input type="submit" value="提交" />        
</form>
 <h1>9还款√</h1>   
<form action="kjs_hk.do" method="post" enctype="multipart/form-data">
 输入id:
 <input type="text" name="id" id="id"/><br/>
抵押类型:
 <input type="text" name="kjs_type" id="kjs_type"/><br/>

<input type="submit" value="提交" />        
</form>
</body>
</html>