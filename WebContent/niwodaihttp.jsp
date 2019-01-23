<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript">

function zx(){
	
	var fronttobase=document.getElementById("fronttobase").value;
	var	oppositetobase=document.getElementById("oppositetobase").value;
	var	applytobase=document.getElementById("applytobase").value; 
	var	authorizetobase=document.getElementById("authorizetobase").value;
	var	hztobase=document.getElementById("hztobase").value; 
	var	ckey=document.getElementById("ckey").value; 
	var	name=document.getElementById("name").value;
	var	IDcard_num=document.getElementById("IDcard_num").value;
	var	phone_num=document.getElementById("phone_num").value;
	var	authorize_num=document.getElementById("authorize_num").value;
	var	sum_bit=document.getElementById("sum_bit").value; 
	var	ly=document.getElementById("ly").value;
	var sign=document.getElementById("sign").value;
	var time=document.getElementById("time").value; 
	//alert(ckey);
	$.ajax({
		   type:"post",
		   dataType:"text",
		   url: "zxceshi.do",
		   traditional:true,
		   data:{
			   fronttobase : fronttobase,
			   oppositetobase : oppositetobase, 
			   applytobase : applytobase, 
			   authorizetobase : authorizetobase,
			   hztobase : hztobase, 
			   ckey : ckey,
			   name : name, 
			   IDcard_num : IDcard_num,
			   phone_num : phone_num,
			   authorize_num : authorize_num,
			   sum_bit : sum_bit,
			   ly : ly,
			   sign : sign,
			   time : time
			   
		   },
		   success: function(msg){
			var result =msg;
			
	    document.getElementById("text").value =result;
			   }
		   }
	   );
	
}

function cxceshi(){
	var	orderNo=document.getElementById("orderid").value; 
	var	ckey=document.getElementById("ckey1").value;
	$.ajax({
		   type:"post",
		   dataType:"text",
		   url: "cxceshi.do",
		   traditional:true,
		   data:{
			   orderNo : orderNo,
			   ckey : ckey
		   },
		   success: function(msg){
			var result =msg;
			
	    document.getElementById("text1").value =result;
			   }
		   }
	   );
	
	
	
}


</script>

</head>
<body>

  <div align="center">
<h1>征信查询接口</h1>
<form action="" method="post" enctype="multipart/form-data">
          正面照图片编码:<input type="text"  id="fronttobase"/><br/>
          反面照图片编码:<input type="text" id="oppositetobase"/><br/>
          授权书图片编码:<input type="text" id="applytobase"/><br/>
          申请书图片编码:<input type="text" id="authorizetobase"/><br/>
          合照图片编码:<input type="text" id="hztobase"/><br/>
          唯一的key(用来验证用户):<input type="text" id="ckey"/><br/>
          被 查询人名字:<input type="text" id="name"/><br/>
          手机号:<input type="text" id="phone_num"/><br/>
          身份证号:<input type="text" id="IDcard_num"/><br/>
          授权书编号:<input type="text" id="authorize_num"/><br/>
          操作状态:<input type="text" id="sum_bit"/><br/>
          备注:<input type="text" id="ly"/><br/>
   sign:<input type="text" id="sign"/><br/>
   time:<input type="text" id="time"/><br/>
    <input type="button" onclick="zx();" value="提交" /> 
</form>
<h3 align="left">返回数据:</h3>
	<textarea id="text" name="text" style="width:100%; height: 50px"  readonly="">
										
					
						
						
						
    </textarea>
</div>
<div align="center">
<h1>征信报告查询接口</h1>
<form action="" method="post" enctype="multipart/form-data"><br/>
 订单编号:<input type="text" value="" id="orderid" /><br/>
 ckey:<input type="text" value="" id="ckey1" /><br/>  
 <input type="button" onclick="cxceshi()" value="查询"/><br/>  
</form>
<h3 align="left">返回数据:</h3>
	<textarea id="text1" name="text1" style="width:100%; height: 50px"  readonly="">
										
					
						
						
						
    </textarea>
</div>
<script type="text/javascript">

function sh(){
	var	name=document.getElementById("name1").value; 
	var	idCard=document.getElementById("idCard").value;
	var	orderNo=document.getElementById("orderNo").value; 
	var	phoneNo=document.getElementById("phoneNo").value;
	//alert(name)
	var t="{\"name\":\""+name+"\",\"idCard\":\""+idCard+"\",\"orderNo\":\""+orderNo+"\",\"phoneNo\":\""+phoneNo+"\"}"
	document.getElementById("shresult1").value =t;
	var json;
	$.ajax({
		   type:"post",
		   dataType:"text",
		   url: "shresult.do",
		   traditional:true,
		   data:{
			   name : name,
			   idCard : idCard,
			   orderNo : orderNo,
			   phoneNo : phoneNo
		   },
		   success: function(msg){
			var result =msg;
			 json= eval("("+result+")");			
	    document.getElementById("shresult2").value =result;
			   }
		   }
	   );
	
	
}


        
    </script>

<div align="center">
<h1>审核信息成功结果异步推送接口 (快加-嘉银征信)</h1>
<form action="" method="post" enctype="application/x-www-form-urlencoded"><br/>
 
  name:<input type="text" value="" id="name1" name="name1" /><br/>
    idCard:<input type="text" value="" id="idCard" name="idCard" /><br/>
      phoneNo:<input type="text" value="" id="phoneNo" name="phoneNo" /><br/>
        orderNo:<input type="text" value="" id="orderNo" name="orderNo" /><br/>
 <input type="button" onclick="sh()" value="审核成功"/><br/>    
</form>
<h3 align="left">推送数据:</h3>
	<textarea id="shresult1" name="shresult1"  style="width:100%; height: 50px"  readonly="">									
			
						
						
						
    </textarea>
<h3 align="left">返回数据:</h3>
	<textarea id="shresult2" name="shresult2"  style="width:100%; height: 50px"  readonly="">									
			
						
						
						
    </textarea>
</div>


<script type="text/javascript">
window.onload=function(){
odiv.onsubmit=function(){  
    if(!validate()){//validate()函数包含了多个表单验证方法  
        return false;//阻止表单默认提交  
    }  
    else  hqzxbg();  
    };  
};  

function hqzxbg(){
	var str;
	var	orderNo=document.getElementById("orderid").value; 
	var	pdfurl=document.getElementById("pdfurl").value;
	var	pdfname=document.getElementById("pdfname").value;
	var addtime=document.getElementById("addtime").value;
	str="{\"orderNo\":"+orderNo+",\"pdfurl\":"+pdfurl+",\"addtime\":"+addtime+",\"pdfname\":"+pdfname+"}";
	document.getElementById("text2").value =str;
	$.ajax({
		   type:"post",
		   dataType:"text",
		   url: "hqzxbg.do",
		   traditional:true,
		   data:{
			   orderNo : orderNo,
			   pdfurl : pdfurl,
			   addtime : addtime
		   },
		   success: function(msg){
			var result =msg;
			
	    document.getElementById("text3").value =result;
			   }
		   }
	   );
		
}
</script>
<div align="center">
<h1>征信报告推送</h1>
<form id="postForm" name="postForm" action="pdfceshi.do" method="post" enctype="multipart/form-data"><br/>
pdf报告上传:<input style="background-color:lime;" type="file" name="file" id="file" value="pdf报告"/><br/>
 订单编号:<input type="text" value="" name="orderNo" id="orderNo" /><br/>
  <input type="hidden" value="${requestScope.pdfurl }" name="pdfurl" id="pdfurl" />
  <input type="hidden" value="${requestScope.pdfname }" name="pdfname" id="pdfname" />  
 <input type="hidden" value="${requestScope.addtime }" name="addtime" id="addtime" />
<input type="submit" value="上传"/><br/>  
</form>
<h3 align="left">推送数据:</h3>
<textarea id="text2" name="text2" style="width:800px; height: 50px"  readonly="">
{"orderNo":"${requestScope.orderNo }","pdfurl":"${requestScope.pdfurl }","addtime":"${requestScope.addtime }"}									
					
						
						
						
</textarea>
<h3 align="left">返回数据:</h3>
	<textarea id="text3" name="text3" style="width:800px; height: 50px"  readonly="">
{"errcode":"${requestScope.errcode }","errmsg":"${requestScope.errmsg }"}										
					
						
						
						
    </textarea>
</div>




</body>
</html>