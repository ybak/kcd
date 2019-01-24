<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="javascript" type="text/javascript" src="datechance/WdatePicker.js"></script>
</head>
<body>
<div align="center">
<h1>根据时间区间查询</h1>
<form action="ykdbb.do" method="post" enctype="multipart/form-data">
<input name="sdate" style="width: 120px;" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" />
         至
<input name="edate" style="width:120px;" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})" /> 
<br/>
ckey:<input type="text" name="ckey"/><br/>
<input type="submit" value="提交查询" /> 
</form>
</div>

<div align="center">
<h1>获取H5页面信息</h1>
<form action="toh5html.do" method="post" enctype="multipart/form-data">
          callback_url(回调 url):<input type="text" name="callback_url"/><br/>
          success_url(页面授权成功，跳转 url) :<input type="text" name="success_url"/><br/>
          failed_url(页面授权失败，跳转 url) :<input type="text" name="failed_url"/><br/>
          name(登记人的真实姓名) :<input type="text" name="name"/><br/>
          cert_no(身份证号) :<input type="text" name="cert_no"/><br/>
          contact_list(用户的联系人信息列表) :<input type="text" name="contact_list"/><br/>
          show_nav_bar :<input type="text" name="show_nav_bar"/><br/>
          phone_no(手机号):<input type="text" name="phone_no"/><br/>
          ckey:<input type="text" name="ckey"/><br/>
   <input type="submit" value="提交查询" /> 
</form>
</div>
<div align="center">
<h1>1获取运营商验证码</h1>
<form action="getcapcha.do" method="post" enctype="multipart/form-data">
  phone_no:<input type="text" name="phone_no"/><br/>
  name:<input type="text" name="name"/><br/>
    cert_no:<input type="text" name="cert_no"/><br/>
  contact_list:<input type="text" name="contact_list"/><br/>
    ckey:<input type="text" name="ckey"/><br/>
   <input type="submit" value="提交查询" /> 
</form>
</div>
<div align="center">
<h1>2运营商密码授权登陆</h1>
<form action="authorizelogin.do" method="post" enctype="multipart/form-data">
  phone_no:<input type="text" name="phone_no"/><br/>
  passwd:<input type="text" name="passwd"/><br/>
  capcha:<input type="text" name="capcha"/><br/>
  callback:<input type="text" name="callback"/><br/>
  ckey:<input type="text" name="ckey"/><br/>
   <input type="submit" value="提交查询" /> 
</form>
</div>

<div align="center">
<h1>3获取详单图片验证码 </h1>
<form action="toimage.do" method="post" enctype="multipart/form-data">
  phone_no:<input type="text" name="phone_no"/><br/>
  ckey:<input type="text" name="ckey"/><br/>
   <input type="submit" value="提交查询" /> 
</form>
</div>


<div align="center">
<h1>4请求短信验证码授权 </h1>
<form action="getsmscode.do" method="post" enctype="multipart/form-data">
  phone_no:<input type="text" name="phone_no"/><br/>
  ckey:<input type="text" name="ckey"/><br/>
   <input type="submit" value="提交查询" /> 
</form>
</div>


<div align="center">
<h1>5详单短信验证码验证 </h1>
<form action="verifysmscode.do" method="post" enctype="multipart/form-data">
  phone_no(手机号):<input type="text" name="phone_no"/><br/>
  sms_code(验证码):<input type="text" name="sms_code"/><br/>
  name:<input type="text" name="name"/><br/>
  cert_no:<input type="text" name="cert_no"/><br/>
  capcha:<input type="text" name="capcha"/><br/>
  ckey:<input type="text" name="ckey"/><br/>
   <input type="submit" value="提交查询" /> 
</form>
</div>

<div align="center">
<h1>数据查询 1：根据 token 查询分析报告 </h1>
<form action="analyzeddata.do" method="post" enctype="multipart/form-data">
 token:<input type="text" name="token"/><br/>
 ckey:<input type="text" name="ckey"/><br/> 
   <input type="submit" value="提交查询" />

</form>
</div>
<div align="center">
<h1>数据查询 2：根据 token 查询原始数据</h1>
<form action="querydata.do" method="post" enctype="multipart/form-data">
 token:<input type="text" name="token"/><br/>
 ckey:<input type="text" name="ckey"/><br/> 
   <input type="submit" value="提交查询" /> 
</form>
</div>

<div align="center">
<h1>大数据查询</h1>
<form action="toreportId.do" method="post" enctype="multipart/form-data">
           姓名:<input type="text" name="name"/><br/>
          身份证号:<input type="text" name="ID_card"/><br/>
          手机号:<input type="text" name="mobile"/><br/>
   ckey:<input type="text" name="ckey"/><br/>
   <input type="submit" value="提交查询" /> 
</form>
</div>
<div align="center">
<h1>大数据查询</h1>
<form action="query.do" method="post" enctype="multipart/form-data">
           查询结果报告id:<input type="text" name="reportId"/><br/>
           ckey:<input type="text" name="ckey"/><br/>
   <input type="submit" value="提交查询" /> 
</form>
</div>
<div align="center">
<h1>公司注册 </h1>
<form action="addcompany.do" method="post" enctype="multipart/form-data">
     公司名称:<input type="text" name="company"/><br/>
          账户:<input type="text" name="pusername"/><br/>
          密码:<input type="text" name="ppassword"/><br/>
    <input type="submit" value="提交" /> 
</form>
</div>
<div align="center">
<h1>员工注册 </h1>
<form action="addperson.do" method="post" enctype="multipart/form-data">
     公司名称:<input type="text" name="owencompany"/><br/>
         员工等级:<input type="text" name="level" value="1>2>3" /><br/>
          员工姓名:<input type="text" name="name"/><br/>
          账号:<input type="text" name="account"/><br/>
          密码:<input type="text" name="password"/><br/>
    <input type="submit" value="提交" /> 
</form>
</div  >
<div align="center">
<h1>根据公司名查询员工</h1>
<form action="findperson.do" method="post" enctype="multipart/form-data">
     公司名称:<input type="text" name="company"/><br/>
<input type="submit" value="提交" /> 
</form>
</div>
<div align="center">
<h1>根据员工等级查询</h1>
<form action="findlevel.do" method="post" enctype="multipart/form-data">
     公司名称:<input type="text" name="company" value=""/><br/>
     员工等级:<input type="text" name="level" value="1>2>3"/><br/>
<input type="submit" value="提交" /> 
</form>
</div>
<div align="center">
<h1>充值</h1>
<form action="upcompany.do" method="post" enctype="multipart/form-data">
     公司名称:<input type="text" name="company" value=""/><br/>    
     签约公司:<input type="text" name="qygsm" value=""/><br/>
     金额:<input type="text" name="je" value=""/><br/>
     币种:<input type="text" name="bz" value=""/><br/>     
     充值类型:<input type="text" name="lx" value=""/><br/>     
     留言:<input type="text" name="rmk" value=""/><br/>
     状态:<input type="text" name="zt" value=""/><br/>     
     充值数量:<input type="text" name="beans" value=""/><br/>
     操作人:<input type="text" name="czr" value=""/><br/>     
<input type="submit" value="提交" /> 
</form>
</div>

<div align="center">
<h1>根据订单编号查询</h1>
<form action="findresult.do" method="post" enctype="multipart/form-data">
 订单编号:<input type="text" name="orderNo" value=""/><br/>  
  ckey:<input type="text" name="ckey" value=""/><br/> 
<input type="submit" value="提交" /> 
</form>
</div>	
<div align="center">
<h1>后台处理添加结果PDF文件</h1>
<form action="uppdf.do" method="post" enctype="multipart/form-data">
<input style="background-color:lime;" type="file" name="file" value="选择pdf文件"/>
<!-- 请选择上传的图片： -->
<!-- <input type="file" name="file" accept="image/*" /> -->
<br/> 
 订单编号:<input type="text" name="uid" value=""/><br/>  
 留言:<input type="text" name="ly" value=""/><br/>  
 状态:<input type="text" name="zt" value=""/><br/>  
 <input type="submit" value="上传"/><br/> 
</form>
</div>

<div align="center">
<h1>查询授权书申请书</h1>
<form action="getid.do" method="post" enctype="multipart/form-data">
 ckey:<input type="text" name="ckey" value=""/><br/>
 num:<input type="text" name="num" value=""/><br/> 
  
 <input type="submit" value="查询"/><br/> 
</form>
</div>


<div align="center">
<h1>添加授权书申请书</h1>
<form action="saveapply.do" method="post" enctype="multipart/form-data"><br/>
<input style="background-color:lime;" type="file" name="apply" value="选择申请书文件"/><br/>
<input style="background-color:lime;" type="file" name="authorize" value="选择授权书文件"/><br/>
 编码:<input type="text" name="acode" value=""/><br/>  
 <input type="submit" value="上传"/><br/> 
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
<h1>创建excel</h1>
<form action="toexcel.do" method="post" enctype="multipart/form-data"><br/>
 ckey:<input type="text" value="" name="ckey" /><br/> 
 <input type="submit" value="创建"/><br/>  
</form>
</div>





<div align="center">
<h1>批量查询征信PDF结果</h1>
<form action="batchquery.do" method="post" enctype="multipart/form-data"><br/>
 客户姓名1:<input type="text" value="" name="name" />
 身份证号1<input type="text" value="" name="IDcard_num" /><br/> 
 客户姓名2:<input type="text" value="" name="name" />
 身份证号2<input type="text" value="" name="IDcard_num" /><br/>   
 客户姓名3:<input type="text" value="" name="name" />
 身份证号3<input type="text" value="" name="IDcard_num" /><br/> 
ckey:<input type="text" value="" name="ckey" /><br/>
 <input type="submit" value="查询"/><br/>  
</form>
</div>
<div align="center">
<h1>添加门店及人员信息</h1>
<form action="addmdxx.do" method="post" enctype="multipart/form-data"><br/>
 门店名称:<input type="text" value="" name="sname" /><br/>
 开户等级:<input type="text" value="" name="alevel" /><br/> 
 人员名称:<input type="text" value="" name="pname" /><br/>
 人员身份证号:<input type="text" value="" name="pIDcard" /><br/>   
 人员手机号:<input type="text" value="" name="pcall" /><br/>
 操作:<input type="text" value="" name="czcode" /><br/> 
 <input type="submit" value="查询"/><br/>  
</form>
</div>

<div align="center">
<h1>查询订单信息(仅查询)</h1>
<form action="findordrr.do" method="post" enctype="multipart/form-data"><br/>
订单编号:<input type="text" value="" name="orderNo" /><br/>
 用户key:<input type="text" value="" name="ckey" /><br/>  
 <input type="submit" value="查询"/><br/>  
</form>
</div>

<div align="center">
<h1>添加图片(base64编码)file</h1>
<form action="tutobase.do" method="post" enctype="multipart/form-data">
tu1:<input type="text" value="" name="tu1" /><br/>
tu2:<input type="text" value="" name="tu2" /><br/>  
tu3:<input type="text" value="" name="tu3" /><br/>
tu4:<input type="text" value="" name="tu4" /><br/> 
tu5:<input type="text" value="" name="tu5" /><br/>
 <input type="submit" value="添加"/><br/>  
</form>
</div>

<div align="center">
<h1>开户</h1>
<form action="tokhbyckey.do" method="post" enctype="multipart/form-data">
khgsname:<input type="text" value="" name="khgsname" /><br/>
khlevel:<input type="text" value="" name="khlevel" /><br/>  
khrname:<input type="text" value="" name="khrname" /><br/>
khsfznum:<input type="text" value="" name="khsfznum" /><br/> 
khphonenum:<input type="text" value="" name="khphonenum" /><br/>
 <input type="submit" value="添加"/><br/>  
</form>
</div>

</body>
</html>