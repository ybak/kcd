<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>全部门店4.4添加分类信息 √</h1>   
<form action="findfsdy.do" method="post" enctype="multipart/form-data">
 输入订单号:<input type="text" name=""/><br/>
        <input type="submit" value="提交" />        
</form>


 <h1>个人信息（borrower）押证4.1添加借款人(个人)</h1>   
<form action="addbow2.do" method="post" enctype="multipart/form-data">
 输入订单号:<input type="text" name=""/><br/>
       <input type="submit" value="提交" />        
</form> 

 <h1>AddLoanInfo4.3添加借款信息</h1>   
<form action="addLoanInfo.do" method="post" enctype="multipart/form-data">
 输入订单号:<input type="text" name=""/><br/>
       <input type="submit" value="提交" />        
</form> 
 
<h1>4.9提交初审结果</h1>   
<form action="approvalLoanInfo.do" method="post" enctype="multipart/form-data">
 输入订单号:<input type="text" name=""/><br/>
       <input type="submit" value="提交" />        
</form>

<h1>4.10终审结果</h1>   
<form action="zsresult.do" method="post" enctype="multipart/form-data">
 输入订单号:<input type="text" name=""/><br/>
       <input type="submit" value="提交" />        
</form>

<h1>4.5抵押登记</h1>   
<form action="dydj.do" method="post" enctype="multipart/form-data">
 输入订单号:<input type="text" name=""/><br/>
       <input type="submit" value="提交" />        
</form>


<h1>4.11放款许可</h1>   
<form action="queryfkxk.do" method="post" enctype="multipart/form-data">
 输入订单号:<input type="text" name=""/><br/>
       <input type="submit" value="提交" />        
</form>

<h1>4.6放款完成</h1>   
<form action="fksuccess.do" method="post" enctype="multipart/form-data">
 输入订单号:<input type="text" name=""/><br/>
       <input type="submit" value="提交" />        
</form>

<h1>4.7还款接口</h1>   
<form action="hk.do" method="post" enctype="multipart/form-data">
 输入订单号:<input type="text" name=""/><br/>
       <input type="submit" value="提交" />        
</form>
<h1>其它</h1>   
<form action="" method="post" enctype="multipart/form-data">
 输入订单号:<input type="text" name=""/><br/>
       <input type="submit" value="提交" />        
</form>

<h1>测试</h1>   
<form action="dyuceshi.do" method="post" enctype="multipart/form-data">
 输入订单号:<input type="text" name=""/><br/>
       <input type="submit" value="提交" />        
</form>
<h1>查车档测试</h1>   
<form action="jkrid.do" method="post" enctype="multipart/form-data">
 输入车牌号:<input type="text" name="c_carno"/><br/>
  输入vin:<input type="text" name="r_item6"/><br/>
<input type="submit" value="提交" />        
</form>
</body>
</html>