<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>

<script src="./acss/jQuery-2.1.4.min.js" type="text/javascript"></script>
<script src="./acss/jquery.form.js" type="text/javascript"></script>
</head>
<body>
<div align="center">
<h1>征信查询接口 base64 统一</h1>
<form action="zxsave.do" method="post" enctype="multipart/form-data">
          正面照图片:
<input style="background-color:lime;" type="file" name="fronttobase" value="选择图片"/>      
          <br/>
          反面照图片:
         <input style="background-color:lime;" type="file" name="oppositetobase" value="选择图片"/> 
          <br/>
          授权书图片:<input style="background-color:lime;" type="file" name="applytobase" value="选择图片" /><br/>
          申请书图片:<input style="background-color:lime;" type="file" name="authorizetobase" value="选择图片"/><br/>
          合照图片:<input style="background-color:lime;" type="file" name="hztobase" value="选择图片"/><br/>
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
<h1>根据订单编号查询</h1>
<form action="tobase64img.do" method="post" enctype="multipart/form-data">
          正面照图片:<input type="text" name="fronttobase"/><br/>
          反面照图片:<input type="text" name="oppositetobase"/><br/>
          授权书图片:<input type="text" name="applytobase"/><br/>
          申请书图片:<input type="text" name="authorizetobase"/><br/>
          合照图片:<input type="text" name="hztobase"/><br/>
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
<h1>空白申请书和授权书申请</h1>
<form action="getapply.do" method="post" enctype="multipart/form-data">
 申请数量:<input type="text" name="num" value=""/><br/>  
  ckey:<input type="text" name="ckey" value=""/><br/> 
<input type="submit" value="提交" /> 
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

<div align="center">
<h1>下载测试</h1>
<form action="downloadtu.do" method="post" enctype="multipart/form-data">
日期:<input type="text" value="" name="timepath" /><br/>
文件名:<input type="text" value="" name="fileName" /><br/>
 <input type="submit" value="上传"/><br/>  
</form>
</div>

<div align="center">
<h1>黑名单</h1>
<form action="blacktbl.do" method="post" enctype="multipart/form-data">
回调url:<input type="text" value="" name="callbackUrl" /><br/>
姓名:<input type="text" value="" name="name" /><br/>
身份证号:<input type="text" value="" name="idCardNo" /><br/>
手机号:<input type="text" value="" name="phoneNo" /><br/>
sync:<input type="text" value="" name="sync" /><br/>
ckey:<input type="text" value="" name="ckey" /><br/>
 <input type="submit" value="上传"/><br/>  
</form>
</div>
<script type="text/javascript">
function sss(){
	var form = new FormData(document.getElementById("tf"));
	var id= document.getElementById("orderNo").value;
	var errmsg= document.getElementById("errmsg").value;
	alert(id);
	//alert(errmsg);
		$.ajax({
        url:"sss1.do",
        type:"post",
        data:{orderNo:id},
        success:function(data){
        
        },
        error:function(e){
            alert("错误！！");

        }
    }); 
     
   
}

</script>
<div align="center">
<h1>异步</h1>
<form id="tf" action="sss.do" method="post" enctype="multipart/form-data">
订单编号:<input type="text" value=""  id="orderNo" name="orderNo" /><br/>
状态:<input type="text" value=""  id="errmsg" name="errmsg" /><br/>
<input type="submit" onclick="sss()" value="上传"/><br/> 
 <a></a> 
</form>
</div>
<div align="center">
<h1>根据url获取文件大小</h1>
<form action="filesize.do" method="post" enctype="application/x-www-form-urlencoded">
订单编号:<input type="text" value=""  id="url" name="url" /><br/>
<input type="submit"  value="上传"/><br/> 
 <a></a> 
</form>
</div>
</body>
</html>