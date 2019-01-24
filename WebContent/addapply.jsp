<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.lang.StringBuffer"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>添加申请书授权书文件</title>
    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css" rel="stylesheet"><base target="_blank">
    <script src="./js/jquery-1.7.1.js"></script>
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
<body class="gray-bg">
    <div class="row wrapper border-bottom white-bg page-heading">
      <!--**********************************************************-->
          <script type="text/javascript">
          window.name = "curWindow";
         </script>
             <div class="ibox-content">
                 <form action="scapply.do" target="curWindow" id=""  name="" class="form-horizontal"  method="post"  enctype="multipart/form-data">
                      <h1>添加申请书授权书文件</h1>  
                         <div class="hr-line-dashed"></div>  
                            <!-- 第一个文本框 --> 
                            <!-- <div class="form-group">
                                <label class="col-sm-3 control-label">选择申请书PDF文件：</label>
                                <div class="col-sm-8" >
                                    <input id="file1" type="file" name="file1" style="float: left;">
                                    <span style="float: left;" id="taoCode1"></span>
                                </div>
                            </div> -->
                            <div class="form-group">
                                <label class="col-sm-2 control-label">选择申请书授权书PDF文件：</label>
                                <div class="col-sm-8" style="float: left;">
                                    <input id="file" type="file"  name="file" onchange="return FileUpload_getDCodes()" style="float: left;">
                                    <span style="float: left;" id="taoCode2"></span>
                                </div>
                            </div>
                             <div class="form-group">
                             <label class="col-sm-2 control-label">选择渠道商：</label>
                             <!--  <span class="input-group-addon">选择渠道商：</span>-->
                              <div class="col-sm-8" style="float: left;">
							  <select class="form-control"  name="apply_address" id="apply_address">
                            	<option value="1">典当行</option>
                            	<option value="2">快车道</option>
                              </select>    
                             </div>
                             </div>
			        <div class="form-group">
				    <label class="col-sm-2 control-label">申请书授权书编码：</label>
				    <div class="col-sm-10">
				    <input type="hidden"  value="" id="pn"   name="pn"  />
				    <input type="hidden"  value="" id="codes"   name="codes"  />
				    <input type="hidden"  value="${requestScope.succode }" id="succode"   name="succode"  />
					<input type="hidden" id="aname" name="aname" value="${sessionScope.name}" >
		
					<textarea id="text" name="text" style="width:640px; height: 580px" class="form-control" readonly="readonly">

                    </textarea>
				    </div>
			        </div>	
                         <!-- 当选择文件后触发事件 -->
                                    <script type="text/javascript">	  
                                    function  reds(){
                                     var s= document.getElementById("succode").value;
                                     alert(s);
                                    }
                                    
	                                   function  FileUpload_getDCodes(){
	                                       var formData = new FormData();
	                                       formData.append("file", document.getElementById("file").files[0]); 
	                                       //formData.append("uid", document.getElementById("uid").value);    
	                                 
                                    	  $.ajax({
                                            url: "showCode.do",
                                            type: "POST",
                                            //dataType: "json",
                                            data: formData,
                                            /**
                                            *必须false才会自动加上正确的Content-Type
                                            */
                                            contentType: false,
                                            /**
                                            * 必须false才会避开jQuery对 formdata 的默认处理
                                            * XMLHttpRequest会对 formdata 进行正确的处理
                                        	* window.location.reload();	
                                            */                                         
                                            processData: false,
                                            success: function (data){ 
                                            	var json=eval('('+data+')');
                                                //alert(json.count);
                                                //alert(json.cl);
                                               var json1=json.cl;   
                                               var str="";
                                             $.each(json1,function(index,n){
                                            	 //int c=(index+1)/2;
                                            	 var i=1;
                                            //2	
                                     if((index+1)%2==0){
                                     str="授权书编码:"+json1[index].code+"---第"+(index+1)/2+"份,\n"+str;
                                     }
                                           //1
                                     if((index+1)%2==1){
                                     str="申请书编码:"+json1[index].code+"---第"+(index+2)/2+"份,\n"+str;	                                     	
                                     }                                        		 
                                              

                                   })
                                   alert("解析成功");
                                   document.getElementById("codes").value=json.cl;
                                   document.getElementById("pn").value=json.uuidName;        	
                                   document.getElementById("text").value="********一共解析到"+json.count+"份********,\n"+str;
                                               },
                                               error: function () {
                                                 alert("分析失败！");
                                               }
                                            })
	                                      }
                                   </script>
                            <div class="hr-line-dashed"></div>
				<div class="footer-wrap">
			<div class="box-footer">
				<button type="button" class="btn btn-default" >取消返回</button>
				<button type="submit" onclick="reds()" class="btn btn-primary pull-right"  style="">保存提交</button> 
			</div>
		</div>
                        </form>
                    </div>
         <!-- ********************************************************** -->
    </div>
</body>
</html>