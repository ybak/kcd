<%@page import="org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext"%>
<%@page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="java.io.FileOutputStream" %>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
	<body>
		<%
		//1.把文件上传到指定地方
			//设置pdf文件保存在SQL中的路径
			//设置request中输出字符格式 
			request.setCharacterEncoding("UTF-8"); 
			//获取服服务器根目录路径
			String realPath = getServletConfig().getServletContext().getRealPath("/upload");
			 DiskFileItemFactory factory = new DiskFileItemFactory();
	            ServletFileUpload upload = new ServletFileUpload(factory);
	            List<FileItem> list = upload.parseRequest(request);
	            for(FileItem item : list){
	                if(item.isFormField()){
	                    //为普通输入项
	                    String inputName = item.getFieldName();
	                    String inputValue = item.getString();
	                   // System.out.println(inputName + "="  + inputValue);
	                }else{
	                    //代表当前处理的item里面封装的是上传文件
	                    String filename = item.getName().substring(item.getName().lastIndexOf("\\")+1);  
	                    InputStream in = item.getInputStream();
	                    int len = 0;
	                    byte buffer[] = new byte[1024];
	                    FileOutputStream outa = new FileOutputStream(realPath+"\\"+filename);
	                    while((len=in.read(buffer))>0){
	                        outa.write(buffer, 0, len);
	                    }
	                    in.close();
	                    outa.close();
	                }
	            }
		//2.把url地址存放到数据中
		//3.把pdf文件中编码存放数据库
		//4.把pdf文件中套数存放在数据库（一份申请书和一份授权书为一套）
	            
			
		%>
	</body>
</html>