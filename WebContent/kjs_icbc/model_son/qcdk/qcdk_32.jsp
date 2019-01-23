<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% 
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
long date = new Date().getTime();
String dateString = formatter.format(date);
%>
<li class="text-primary">
<em>专员审核中</em>
<div class="big-conte" style="display:block;">             
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong><%=dateString %>
</div>
<br>
<div class="task_margin ng-scope" >
相关信息请查看对应页签			
</div>                                           
</div>							  	
</li>