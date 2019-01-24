<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link href="${pageContext.request.contextPath}/wangye0119/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/wangye0119/css/style.css" />
<link href="${pageContext.request.contextPath}/wangye0119/assets/css/codemirror.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/wangye0119/assets/css/ace.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/wangye0119/assets/css/font-awesome.min.css" />
<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
<script src="${pageContext.request.contextPath}/wangye0119/assets/js/jquery.min.js"></script>
<title>用户查看</title>
<style type="text/css">


</style>
</head>
<body>
	<div class="member_show">
		<%-- <div class="member_jbxx clearfix">
			 <img class="img" src="${pageContext.request.contextPath}/wangye0119/images/user.png">
			<dl class="right_xxln">
				<dt>
					<span class="">张三</span> <span class="">余额：40</span>
				</dt>
				<dd class="" style="margin-left: 0">这家伙很懒，什么也没有留下</dd>
			</dl> 
		</div> --%> 
		<div class="member_content">
			<button contenteditable="false" onclick="javascript:changeFont();" class="btn btn-xs">编辑</button>
			<button contenteditable="false" onclick="javascript:sub()" class="btn btn-xs">提交</button>
			<form id="updateOne" action="${pageContext.request.contextPath}/updateOneClientByTid.do" method="get">
				<input type="hidden" name="tid" value="${requestScope.oneClient.tid}">
				<ul id="abc" contenteditable="false">
					<li>  
						<label contenteditable="false" class="label_name" style="color: red;">T+ 1：</label>
						<%-- <span  class="name"><font>--${requestScope.oneClient.tb}</font></span> --%>
						<textarea id="txt"  style="resize:none" readonly="readonly" name="ta" rows="3" cols="40" contenteditable="false">${requestScope.oneClient.ta}</textarea>
					</li >
					
					<li>
						<label contenteditable="false" class="label_name" style="color: red;">T+ 7：</label>
						<%-- <span  class="name"><font name="tb">--${requestScope.oneClient.tb}</font></span> --%>
						<textarea id="txtt" style="resize:none" readonly="readonly" name="tb" rows="3" cols="40"  contenteditable="false">${requestScope.oneClient.tb}</textarea>
					</li>
					
					<li>
						<label contenteditable="false" class="label_name" style="color: red;">T+15：</label>
						<%-- <span  class="name"><font name="tc">--${requestScope.oneClient.tc}</font></span> --%>
						<textarea id="txttt" style="resize:none" readonly="readonly" name="tc" rows="3" cols="40" contenteditable="false">${requestScope.oneClient.tc}</textarea>
					</li>
					
					<li>
						<label contenteditable="false" class="label_name" style="color: red;">T+30：</label>
						<%-- <span  class="name"><font name="td">--${requestScope.oneClient.td}</font></span> --%>
						<textarea id="txtttt" style="resize:none" readonly="readonly" name="td" rows="3" cols="40" contenteditable="false">${requestScope.oneClient.td}</textarea>
					</li>
				</ul>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
function sub(){
	$("#updateOne").submit(); 		
}

function changeFont() {
	 var txt = document.getElementById('txt');
	 var txtt = document.getElementById('txtt');
	 var txttt = document.getElementById('txttt');
	 var txtttt = document.getElementById('txtttt');
	 txt.removeAttribute('readonly');
	 txtt.removeAttribute('readonly');
	 txttt.removeAttribute('readonly');
	 txtttt.removeAttribute('readonly');
	 /* var abc=document.getElementById('abc');
     abc.contentEditable=true; */
}

</script>
</html>