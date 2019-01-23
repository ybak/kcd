<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<%
String path = request.getContextPath();
// request.getScheme()+
String basePath ="https://"+request.getServerName()+":"+request.getServerPort()+path;
%>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">    
    <title>简版征信API用户开户</title>  
    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/font-awesome.min.css" rel="stylesheet">
<style type="text/css">
    select {  
    /*Chrome和Firefox里面的边框是不一样的，所以复写了一下*/  
    border: solid 1px #000;  
      
    /*很关键：将默认的select选择框样式清除*/  
    appearance:none;  
    -moz-appearance:none;  
    -webkit-appearance:none;  
      
    /*在选择框的最右侧中间显示小箭头图片*/  
    background: url("http://ourjs.github.io/static/2015/arrow.png") no-repeat scroll right center transparent;  
      
      
    /*为下拉小箭头留出一点位置，避免被文字覆盖*/  
    padding-right: 14px;  
    }             
    /*清除ie的默认选择框样式清除，隐藏下拉箭头*/  
    select::-ms-expand { display: none; }  
</style>
    <link href="${pageContext.request.contextPath }/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/css/style.min.css" rel="stylesheet"><base target="_blank">
    <script src="${pageContext.request.contextPath }/js/jquery.js"></script>
    <script text="text/javascript" src="${pageContext.request.contextPath }/js/pinying.js" charset="GBK"></script>  
</head>
<body class="gray-bg"   >
    <div class="row wrapper border-bottom white-bg page-heading">
 
      <!-- ********************************************************** -->
         
             <div class="ibox-content">
                        <form  action="upapiuser.do" method="post" enctype="multipart/form-data" class="form-horizontal">
                    
                         <h1>编辑API用户</h1>
                      
                         <div class="hr-line-dashed"></div>   
                          <div class="form-group">
                                <label class="col-sm-3 control-label"  >公司名称：</label>
                                <div class="col-sm-8">                             
                         <input id="api_companyname" name="api_companyname"  type="text" value="${requestScope.jau.api_companyname }" class="form-control">                               
                                </div>
                          </div>
                          <div class="form-group">
                                <label class="col-sm-3 control-label">公司地址：</label>
                                <div class="col-sm-8">
                     <input id="api_companyaddress" name="api_companyaddress"  type="text" value="${requestScope.jau.api_companyaddress }" class="form-control">                               
                         
                                </div>
                         </div>
                         <div class="form-group">
                                <label class="col-sm-3 control-label"  >客户名称：</label>
                                <div class="col-sm-8">                             
                                <input id="api_name" name="api_name"  type="text"  value="${requestScope.jau.api_name }" class="form-control">                               
                                </div>
                         </div>              
                         <div class="form-group">
                                <label class="col-sm-3 control-label">客户手机号：</label>
                                <div class="col-sm-8">
                                    <input type="text" value="${requestScope.jau.api_tel }" id="api_tel" name="api_tel"  placeholder="请输入手机号" class="form-control">
                                </div>
                         </div>                              
                         <div class="form-group">
                                <label class="col-sm-3 control-label">客户身份证号：</label>

                                <div class="col-sm-8">
                                    <input type="text" value="${requestScope.jau.api_card }" id="api_card" name="api_card"  placeholder="请输入身份证号" class="form-control">
                                </div>
                         </div>                                             
                         <div class="form-group">
                                <label class="col-sm-3 control-label">开户类型：</label>
                                <div class="col-sm-8">
                                <select class="form-control"  id="api_type" name="api_type">
                            	<option value="0" ${requestScope.jau.api_type eq '0'?"selected='selected'":'' }>不扣费</option>
                            	<option value="1" ${requestScope.jau.api_type eq '1'?"selected='selected'":'' }>扣费</option>
                            	<option value="2" ${requestScope.jau.api_type eq '2'?"selected='selected'":'' }>体验扣费</option>                           
                            	</select>
                                </div>
                         </div>
                         <c:choose>
                         <c:when test="${requestScope.jau.api_type ne '0'}">
                          <div class="form-group">
                                <label class="col-sm-3 control-label">账户余额：</label>
                                <div class="col-sm-8">
                                <input type="text" value="${requestScope.jau.api_money }元" id="api_money" name="api_money" disabled="disabled"  class="form-control">
                                                               
                                </div>
                         </div>
                         <div class="form-group">
                                <label class="col-sm-3 control-label">账户充值(单位：元)：</label>
                                <div class="col-sm-8">
                                <input type="text" value="" id="api_money1" name="api_money1"  class="form-control">                            
                                </div>
                         </div>                           
                         </c:when>
                         <c:otherwise>
                          <div class="form-group">
                                <label class="col-sm-3 control-label">账户余额：</label>
                                <div class="col-sm-8">
                                <input type="text" value="${requestScope.jau.api_money }元" id="api_money" name="api_money" disabled="disabled"  class="form-control">
                                                               
                                </div>
                         </div>
                         <input type="hidden" id="api_money1" name="api_money1"  />
                         </c:otherwise>
                         </c:choose>                                                                 
                            <div class="hr-line-dashed"></div>
                            
                <h1>充值记录</h1>
                <div class="hr-line-dashed"></div>
                <c:forEach items="${requestScope.al }" var="al">   
                <div class="form-group">                                     
                    <div class="input-group">
							<span class="input-group-addon">时间：</span>
							<input class="form-control" name="" id="" value="${fn:substring(al.addtime, 0,19)}" type="text"> 
							<span class="input-group-addon">充值金额：</span>
							<input class="form-control" name="" id="" value="${al.price }元" type="text"> 
					</div>                
                </div>
                </c:forEach>       
 				<div class="footer-wrap">
			    <div class="box-footer">
			    <input type="hidden" id="id" name="id"  value="${requestScope.jau.id }">
				<button type="button" class="btn btn-default" onclick="window.location.href='apiuserlist.do'">取消返回</button>
				<button type="button" class="btn btn-primary pull-right"  onclick="yh()"> 保存提交</button> 
			    </div>
		        </div>
                </form>
                    </div>
         <script type="text/javascript">
         
         function yh(){
        	 var api_name =document.getElementById("api_name").value;
        	 var api_tel =document.getElementById("api_tel").value;
        	 var api_card =document.getElementById("api_card").value;
        	 var api_companyname =document.getElementById("api_companyname").value;
        	 var api_companyaddress =document.getElementById("api_companyaddress").value;
             var api_type =document.getElementById("api_type").value;
             var id =document.getElementById("id").value;
             var api_money =document.getElementById("api_money").value;
             var api_money1 =document.getElementById("api_money1").value;                 
        	 //alert(api_type);
             $.ajax({        	
            	   type: "post",
            	   dataType:"text",
            	   //traditional:true,
            	   url:"upapiuser.do",
            	   data:{      		 
            		api_name : api_name, 
            		api_tel : api_tel,
            		api_card : api_card,
            		api_companyname : api_companyname,
            		api_companyaddress : api_companyaddress,
            		api_type : api_type,
            		id : id,
            		api_money : api_money,
            		api_money1 : api_money1,
            	        },
                	  success: function(msg){ 
              	    var result =msg
              	   // alert(result);
              	   if(result=='1'){
              		   window.location.href='apiuserlist.do'
              	   }
   
                   }  
            	   });
         }
         
         
         </script>
         
         <!-- ********************************************************** -->

    </div>
</body>

</html>