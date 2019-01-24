 <%@ page trimDirectiveWhitespaces="true" %> 
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>下载</title>
    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <script src="./js/jquery-1.7.1.js"></script>
	<script src="js/jquery.js"></script>
      
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css" rel="stylesheet"><base target="_blank">
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
</head>
<body class="gray-bg"   >
    <div class="row wrapper border-bottom white-bg page-heading">
      <!-- ********************************************************** -->
             <div class="ibox-content">
                        <form action=""  method="post" class="form-horizontal"  enctype="multipart/form-data">
                         <h1>下载</h1>
                         <div class="hr-line-dashed"></div>   
                         <!--  <div class="form-group">
                             <label class="col-sm-3 control-label">下载链接：</label>
                             <div class="col-sm-8">
                                 <input id="authorizeName"  name="authorizeName" value="" type="text" placeholder="请输入下载链接" class="form-control">
                             </div>
                         </div> -->
                            
                         <div class="form-group">
                             <label class="col-sm-3 control-label">公司名称：</label>

                             <div class="col-sm-8">
                                 <input id="downloadCompany" name="downloadCompany" type="text" placeholder="请输入公司名称" class="form-control">
                             </div>
                         </div>
                          <div class="form-group">
                             <label class="col-sm-3 control-label">下载数量：</label>
                             <div class="col-sm-8">                                 
                                 <select id="apply_address" name="apply_address" class="form-control" >
                                     <option value="1">典当行</option>
                                     <option value="2">快车道</option>
                                 </select>                                
                             </div>
                         </div>
                         <div class="form-group">
                             <label class="col-sm-3 control-label">下载数量：</label>

                             <div class="col-sm-8">
                                 <input  id="downloadNum" name="downloadNum" type="text" placeholder="请输入下载数量" class="form-control">
                             </div>
                         </div>
 
                         <div class="form-group">
                             <!-- <label class="col-sm-3 control-label">操作人：</label> -->
                             <div class="col-sm-8">
                                 <input   id="downloadCzr" name="downloadCzr" value="${sessionScope.name}" type="hidden" placeholder="请输入操作人" class="form-control">
                             </div>
                         </div>
                          <input type="hidden" id="error" name="error"  value="${sessionScope.error }" />
                         <div class="hr-line-dashed"></div>
                         <div class="form-group">
                             <div class="col-sm-4 col-sm-offset-3">
                                 <!-- <input type="submit" class="btn btn-primary"  value="提交" />
                                 <input type="button" class="btn btn-white" value="返回" /> -->
                                 <!-- 
                                 <button class="btn btn-primary" type="submit" onclick="doReset()">下载</button>
                                 -->
                                 <!-- <a id="downFile" href="login.jsp"></a>    onclick="tijiao()"             -->
                               	 <input type="button" class="btn btn-primary" onclick="tijiao()"  value="下载"/> 
                                 <button class="btn btn-white" type="reset">清空</button>
                                 <button class="btn btn-white" type="button">返回</button>
                             </div>
                         </div>
                         
                        </form>
                    </div>
         <!-- ********************************************************** -->

         
         <script type="text/javascript">
         window.onload=function(){
        	 var s= document.getElementById('error').value;
        	 if(s!=''){
        		 alert(s); 
        	 }
        	 
         } 
           
         
            function tijiao(){           	
            	//document.getElementById('submitForm').submit();
            	var downloadCompany= document.getElementById('downloadCompany').value;
            	var downloadNum= document.getElementById('downloadNum').value;
            	var downloadCzr= document.getElementById('downloadCzr').value;
            	var apply_address= document.getElementById('apply_address').value;
            	//alert(downloadCompany);            	
            	/*
            	window.location.href='Zip.do?downloadCompany='+downloadCompany
            			+"&downloadNum="+downloadNum
            			+"&downloadCzr="+downloadCzr
            			+"&apply_address="+apply_address;
            	*/
            	$.ajax({
           		   url: "Zip1.do",
           		   type: "post",
           		   dataType: "json",
           		   //async : false,  
           		   data:{
           			downloadCompany:downloadCompany,
           			downloadNum:downloadNum,
           			downloadCzr:downloadCzr,
           			apply_address:apply_address
           		   },
       	 	   success: function(data){
       	 		   if(data.code=="1"){
              	 		window.location.href='Zip.do?downloadCompany='+downloadCompany
            			+"&downloadNum="+downloadNum
            			+"&downloadCzr="+downloadCzr
            			+"&apply_address="+apply_address;  
       	 		   }else{
       	 			   alert("授权书申请书数量不足!当前剩余"+data.no+"份");
       	 		   }
    
       	 	   }
           	}); 
            	
            	//回掉函数
            	//doReset();
            }
		    function doReset(){  
		    	//清空form表单的值
		    	document.getElementById('submitForm').reset();  
		    	/* http://pic.58pic.com/58pic/17/76/27/01u58PIC3ra_1024.jpg */
		    	//获取下载链接
		    	/* var pdf_url = $("#qygsm").val();  
		    	$.ajax({
              		   url: "PDFDownloadd.do",
              		   type: "post",
              		   dataType: "text",
              		   data:{
              			 authorizeName:pdf_url 
              		   },
          	 	   success: function(data){
          	 	       //alert(data);
          	 	   }
              	});  */
			}  
		</script>  
    </div>
</body>
</html>