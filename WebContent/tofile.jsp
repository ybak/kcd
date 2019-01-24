<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>

<script type="text/javascript">

 function a(path){
	 
	 var xmlHttp;

	//判断浏览器是否支持ActiveX控件

	if(window.ActiveXObject){

	//支持-通过ActiveXObject的一个新实例来创建XMLHttpRequest对象

	xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");

	}

	//不支持

	else if(window.XMLHttpRequest){

	xmlHttp = new XMLHttpRequest()

	}
	 alert("hello");

		 try {
		 var Message = "\u8bf7\u9009\u62e9\u6587\u4ef6\u5939"; //选择框提示信息
		 var Shell = new ActiveXObject("Shell.Application");
		 var Folder = Shell.BrowseForFolder(0, Message, 64, 17); //起始目录为：我的电脑
		 //var Folder = Shell.BrowseForFolder(0,Message,0); //起始目录为：桌面
		 if (Folder != null) {
		 Folder = Folder.items(); // 返回 FolderItems 对象
		 Folder = Folder.item(); // 返回 Folderitem 对象
		 Folder = Folder.Path; // 返回路径
		 if (Folder.charAt(Folder.length - 1) != "") {
		 Folder = Folder + "";
		 }
		 document.getElementById(path).value = Folder;
		 return Folder;
		 }
		 }
		 catch (e) {
		 alert(e.message);
		 }
		 
 }


</script>
</head>
<body>
<td>
<input type="text" name="path" />
</td>
<td>
<input type="button" onclick="a('path')"
value="选择生成路径" />
</td> 
</body>
</html>