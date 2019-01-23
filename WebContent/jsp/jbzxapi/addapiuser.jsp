<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <title>API用户开户充值</title>  
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
<script type="text/javascript">  
 function gskh(){	 
	 
         var api_name =document.getElementById("api_name").value;
         var api_tel =document.getElementById("api_tel").value;
         var api_card =document.getElementById("api_card").value;
         var api_companyname =document.getElementById("api_companyname").value;
         var api_companyaddress =document.getElementById("api_companyaddress").value;
         var api_type =document.getElementById("api_type").value;
          //alert(api_type);
         $.ajax({        	
      	   type: "post",
      	   dataType:"text",
      	   traditional:true,
      	   url:"saveapiuser.do",
      	   data:{      		 
      		api_name : api_name, 
      		api_tel : api_tel,
      		api_card : api_card,
      		api_companyname : api_companyname,
      		api_companyaddress : api_companyaddress,
      		api_type : api_type
      	        },
         success: function(msg){ 
        	    var result =msg
        	    //$.each(result,function(i, n){
        	   // 	   size=result[i].res;
        	    alert(result);       	           	       
        			   //alert(size) 
        			 //  alert(count) 
        			  // alert(result) 
        	   // })  
        	  
        	       
         }  
      	   });
		    
 }
</script> 
<body class="gray-bg"   >
    <div class="row wrapper border-bottom white-bg page-heading">
 
      <!-- ********************************************************** -->
         
             <div class="ibox-content">
                        <form  action="" method="post" enctype="multipart/form-data" class="form-horizontal">
                    
                         <h1>API用户开户</h1>
                      
                         <div class="hr-line-dashed"></div>   
                          <div class="form-group">
                                <label class="col-sm-3 control-label"  >公司名称：</label>
                                <div class="col-sm-8">                             
                         <input id="api_companyname" name="api_companyname"  type="text" value="" class="form-control">                               
                                </div>
                          </div>
                          <div class="form-group">
                                <label class="col-sm-3 control-label">公司地址：</label>
                                <div class="col-sm-8">
                     <input id="api_companyaddress" name="api_companyaddress"  type="text" value="" class="form-control">                               
                         
                                </div>
                         </div>
                         <div class="form-group">
                                <label class="col-sm-3 control-label"  >客户名称：</label>
                                <div class="col-sm-8">                             
                                <input id="api_name" name="api_name"  type="text"  value="" class="form-control">                               
                                </div>
                         </div>              
                         <div class="form-group">
                                <label class="col-sm-3 control-label">客户手机号：</label>
                                <div class="col-sm-8">
                                    <input type="text" value="" id="api_tel" name="api_tel"  placeholder="请输入手机号" class="form-control">
                                </div>
                         </div>                              
                         <div class="form-group">
                                <label class="col-sm-3 control-label">客户身份证号：</label>

                                <div class="col-sm-8">
                                    <input type="text" value="" id="api_card" name="api_card"  placeholder="请输入身份证号" class="form-control">
                                </div>
                         </div>                                             
                         <div class="form-group">
                                <label class="col-sm-3 control-label">开户类型：</label>
                                <div class="col-sm-8">
                                <select class="form-control"  id="api_type" name="api_type">
                            	<option value="0">不扣费</option>
                            	<option value="1">扣费</option>
                            	<option value="2">体验扣费</option>                           
                            	</select>
                                </div>
                         </div>                                                                 
                            <div class="hr-line-dashed"></div>
 				<div class="footer-wrap">
			    <div class="box-footer">
				<button type="button" class="btn btn-default" onclick="window.location.href='addapiuser.jsp'">撤销</button>
				<button type="button" class="btn btn-primary pull-right" onclick="gskh()" style="">保存提交</button> 
			    </div>
		        </div>
                </form>
               </div>
         
         
         <!-- ********************************************************** -->
 
             
    </div>
   
</body>

</html>