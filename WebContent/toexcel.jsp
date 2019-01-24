<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Filefolder</title>
<script type="text/javascript" >
function browseFolder() {
	
	alert("sssss");
    try {
        var Message = "\请\选\择\文\件\夹";  //选择框提示信息
        var Shell = new ActiveXObject("Shell.Application");
        var Folder = Shell.BrowseForFolder(0, Message, 64, 17);//起始目录为：我的电脑
        //var Folder = Shell.BrowseForFolder(0,Message,0); //起始目录为：桌面
        if (Folder != null) {
            Folder = Folder.items();  // 返回 FolderItems 对象
            Folder = Folder.item();  // 返回 Folderitem 对象
            Folder = Folder.Path;   // 返回路径
            if (Folder.charAt(Folder.length - 1) != "\\") {
             Folder = Folder + "\\";
             }
             document.getElementById(path).val = Folder;
            return Folder;
         }
     }
    catch (e) {
         alert(e.message);
     }
}

</script>

</head>
<body><table><tr>
<td>选择路径:</td>
<td><input name="path" type=text ></td>
<td><input type=button value="Select" onclick="browseFolder()"></td>
</tr></table></body>
</html>