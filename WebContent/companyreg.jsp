<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">    
    <title>公司（门店）注册</title>  
    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
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
    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css" rel="stylesheet"><base target="_blank">
    <script src="js/jquery.js"></script>
    <script text="text/javascript" src="js/pinying.js" charset="GBK"></script>  
 <script type="text/javascript">  
 function gskh(){	  
         var name =document.getElementById("name").value;
         var address =document.getElementById("address").value;
         var ncode =document.getElementById("ncode").value;
         var qyname =document.getElementById("qyname").value;
         var qykhname =document.getElementById("qykhname").value;
         var khrname =document.getElementById("khrname").value;
         var czrid =document.getElementById("czrid").value;
         //alert(czrid);
         $.ajax({
        	
      	   type: "post",
      	   dataType:"text",
      	   traditional:true,
      	   url:"addgs.do",
      	   data:{      		 
      		 name : name, 
      		address : address,
      		ncode : ncode,
      		qyname : qyname,
      		qykhname : qykhname,
      		khrname : khrname,
      		czrid : czrid
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
  <script>
//根据文本框输入的汉字自动获取汉字拼音首字母到下拉列表中，支持多音字，需引入库pinying.js
function query(){
    var name = document.getElementById("name").value.trim();
    var khrname = document.getElementById("khrname").value.trim();
    if(name == "") return;
    var arrRslt = makePy(name);
    //循环将值到下拉框
    var option = null;
    document.getElementById("ncode").innerHTML="";//清空下拉框
    var first = document.getElementById("ncode");
    for(var j=0;j<arrRslt.length;j++){
				var obj = document.getElementById("ncode");
				obj.add(new Option(arrRslt[j],arrRslt[j]));
    }
}
</script>
</head>

<body class="gray-bg"   >
    <div class="row wrapper border-bottom white-bg page-heading">
 
      <!-- ********************************************************** -->
         
             <div class="ibox-content">
                        <form  action="" method="post" class="form-horizontal">
                    
                         <h1>公司（门店）注册</h1>
                      
                         <div class="hr-line-dashed"></div>   
                            <div class="form-group">
                                <label class="col-sm-3 control-label"  >公司（门店）名称：</label>
                                <div class="col-sm-8">                             
                                <input id="name" name="name" onKeyUp="query()" type="text" value="" class="form-control">                               
                                <input type="hidden" id="czrid" name="czrid"  value="${sessionScope.id }" >                               
                                
                                
                                </div>
                            </div>
                               <div class="form-group">
                                <label class="col-sm-3 control-label">公司名称英文缩写：</label>
                                <div class="col-sm-8">
                                     <select class="form-control"  id="ncode" name="ncode">
                                     
                                     </select>
                                </div>
                                </div>
                                <div class="form-group">
                                <label class="col-sm-3 control-label"  >公司详细地址：</label>
                                <div class="col-sm-8">                             
                                <input id="address" name="address"  type="text" value="" class="form-control">                               
                                </div>
                                </div>

              
                         <div class="form-group">
                                <label class="col-sm-3 control-label">签约时公司名称：</label>
                                <div class="col-sm-8">
                                    <input type="text" value="" id="qyname" name="qyname"  placeholder="请输入签约时公司名称" class="form-control">
                                </div>
                         </div>                              
                         <div class="form-group">
                                <label class="col-sm-3 control-label">签约客户姓名：</label>

                                <div class="col-sm-8">
                                    <input type="text" value="" id="qykhname" name="qykhname"  placeholder="请输入签约人姓名" class="form-control">
                                </div>
                         </div>                                             
                                                       <div class="form-group">
                                <label class="col-sm-3 control-label">开户人：</label>

                                <div class="col-sm-8">
                                    <input type="text" value="" id="khrname" name="khrname"  placeholder="请输入开户人姓名" class="form-control">
                                </div>
                         </div>                                                                 
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                    <input value="提交" onclick="gskh();" type="button" class="btn btn-primary" >
                                    <input value="返回" type="button" class="btn btn-white" >

                                   
                                </div>
                            </div>
                        </form>
                    </div>
         
         
         <!-- ********************************************************** -->

    </div>
   
</body>

</html>