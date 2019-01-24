<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>员工注册</title>
  	<script src="./acss/jQuery-2.1.4.min.js" type="text/javascript"></script>
    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">
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
<script type="text/javascript">
$(document).ready(function(){
	
  //alert("111");
  
  
  $.ajax({
	   type: "post",
	   dataType: "json",
	   url: "findgsname.do",
	   success: function(msg){
	    var data1 =msg
	    $("#name").empty();//每次加载前清除缓存
	    $.each(data1,function(i, n){
	    	name=data1[i].name;
	    	gsid=data1[i].id;
	    	//document.getElementById("gsid").value=gsid;
	    	//alert(gsid)
	    	 $("#name").append("<option value='"+gsid+"'>"+name+"</option>");
	    	 
	         $("#name option[value='${vo.gsid}']").attr("selected",true);
			   //alert(khgsname); 
			 //  alert(count) 
			  // alert(result) 
	     }); 
	    
	    
	   } 
	   })
	   
	
}
)
</script>

<script type="text/javascript">
  
 function t1(){	  
	 
         var name =$("#name").find("option:selected").text();
         var khlevel =document.getElementById("khlevel").value;
         var khrname =document.getElementById("khrname").value;
         var khsfznum =document.getElementById("khsfznum").value;
         var khphonenum =document.getElementById("khphonenum").value;
         var username =document.getElementById("username").value;
         var password =document.getElementById("password").value;
         var czrid =document.getElementById("czrid").value;
         var gsid =document.getElementById("name").value;
         //alert(name+"---"+gsid)
         $.ajax({
        	
      	   type: "post",
      	   dataType:"json",
      	   traditional:true,
      	   url:"savekhgs.do",
      	   data:{      		 
      		 khgsname : name, 
      		khlevel : khlevel,
      		khrname : khrname,
      		khsfznum : khsfznum,
      		khphonenum : khphonenum,
      		username : username,
      		password : password,
      		czrid : czrid,
      		gsid : gsid
      	        },
         success: function(msg){ 
        	    var result =msg
        	    $.each(result,function(i, n){
        	    	   size=result[i].res;
        	    	   alert(size);
        			   //alert(size) 
        			 //  alert(count) 
        			  // alert(result) 
        	    })  
        	  
        	       
         }  
      	   });
		    
 }
</script> 
</head>

<body class="gray-bg"   >
    <div class="row wrapper border-bottom white-bg page-heading">
      
      <!-- ********************************************************** -->
         
             <div class="ibox-content">
                        <form method="get" class="form-horizontal">
                    
                         <h1>员工注册</h1>
                      
                         <div class="hr-line-dashed"></div>   
                            <div class="form-group">
                                <label class="col-sm-3 control-label">公司（公司）名称：</label>

                                <div class="col-sm-8">
                                   <select class="form-control"  id="name" name="name"> 
                                   
                                   
                                   </select>
                                </div>
                            </div>
                            
                           <div class="form-group">
                                <label class="col-sm-3 control-label">账户等级：</label>

                                <div class="col-sm-8">
                                   <select class="form-control" id="khlevel" name="khlevel">
                                   <option value="1">1级</option>
                                   <option value="2">2级</option>
                                   <option value="3">3级</option>
                                   </select>
                                </div>
                            </div>                                                        
                            <div class="form-group">
                                <label class="col-sm-3 control-label">员工姓名：</label>

                                <div class="col-sm-8">
                                    <input  id="khrname" type="text" placeholder="请输入员工姓名" class="form-control">
                                    <input  id="czrid" type="hidden" value="${sessionScope.id }">                                    
                                </div>
                            </div>
                                <div class="form-group">
                                <label class="col-sm-3 control-label">身份证号：</label>

                                <div class="col-sm-8">
                                    <input id="khsfznum" type="text" placeholder="请输入身份证号" class="form-control">
                                </div>
                            </div>
                                <div class="form-group">
                                <label class="col-sm-3 control-label">手机号：</label>

                                <div class="col-sm-8">
                                    <input id="khphonenum" type="text" placeholder="请输入手机号" class="form-control">
                                </div>
                            </div>
                            
                           <div class="form-group">
                                <label class="col-sm-3  control-label">账号：</label>

                                <div class="col-sm-8">
                                    <input id="username"  type="text" placeholder="请输入账号" class="form-control">
                                </div>
                            </div>
                         
                      
                                  <div class="form-group">
                                <label class="col-sm-3 control-label">密码：</label>

                                <div class="col-sm-8">
                                    <input id="password" type="password" placeholder="请输入密码" class="form-control">
                                </div>
                            </div>

                            
 
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <button class="btn btn-primary" onclick="t1()" type="button">提交</button>
                                    <button class="btn btn-white" type="button">返回</button>
                                </div>
                            </div>
                        </form>
                    </div>
         
         
         <!-- ********************************************************** -->

    </div>
   
</body>

</html>