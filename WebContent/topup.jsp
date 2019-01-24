<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    

    <title>充值</title>
  
    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">
<script src="js/jquery.js"></script>
<script id="jquery_183" type="text/javascript" class="library" src="/js/sandbox/jquery/jquery-1.8.3.min.js"></script>      
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

<script>
$(document).ready(function(){	
  alert("加载公司姓名");   
  $.ajax({
	   type: "post",
	   dataType: "json",
	   url: "findgsname.do",
	   success: function(msg){
	    var data1 =msg
	    $("#khgsname").empty();//每次加载前清除缓存
	    $.each(data1,function(i, n){
	    	khgsname=data1[i].name;
	    	 $("#khgsname").append("<option value='"+khgsname+"'>"+khgsname+"</option>");
	         $("#khgsname option[value='${vo.khgsname}']").attr("selected",true);
			   //alert(khgsname); 
			 //  alert(count) 
			  // alert(result) 
	     }); 
	    
	    
	   } 
	   })
	   
	
}
)
 


</script>
<script >
function addkd(){
	var shgs=document.getElementById("khgsname").value;
	var qygsm=document.getElementById("qygsm").value;
	var je=document.getElementById("je").value;
	var bz=document.getElementById("bz").value;
	var lx=document.getElementById("lx").value;
	var rmk=document.getElementById("rmk").value;
	var zt=document.getElementById("zt").value;
	var num=document.getElementById("num").value;
	var czr=document.getElementById("czr").value;
	
	  $.ajax({
		   type: "post",
		   dataType: "json",
		   url: "addfinance.do",
		   traditional:true,
		   data:{
			   shgs : shgs,
			   qygsm : qygsm,
			   je : je,
			   bz : bz,
			   lx : lx,
			   rmk :rmk,
			   zt : zt,
			   num : num,
			   czr : czr
			   
		   },
		   success: function(msg){
			var result =msg
     	    $.each(result,function(i, n){
 	    	   rs=result[i].rs;
 	    	   alert(rs);

 	    })    
			   }
		   }
	   );
	
	
}
</script>
<script >
$(function(){  
    
  $('#je').bind('input propertychange', function() {  
      //$('#result').html($(this).val().length + ' characters');
     var je=$(this).val();
  	document.getElementById("num").value=je;
  });  
    
  })  
</script>
</head>


<body class="gray-bg"   >
    <div class="row wrapper border-bottom white-bg page-heading">
      
      <!-- ********************************************************** -->
         
             <div class="ibox-content">
                        <form method="get" class="form-horizontal">
                    
                         <h1>充值</h1>
                      
                         <div class="hr-line-dashed"></div>   
                            <div class="form-group">
                                <label class="col-sm-3 control-label">公司名称：</label>

                                <div class="col-sm-8">
                                <div id="parent">
                                     <select id="khgsname" name="khgsname" class="form-control" >
                                     
                                     
                                     </select>
                               </div>
                                    <!-- <input type="text" placeholder="请输入公司名称" class="form-control">
                                 --></div>
                            </div>
                            
                         <div class="form-group">
                                <label class="col-sm-3 control-label">签约公司：</label>

                                <div class="col-sm-8">
                                    <input id="qygsm" name="qygsm" type="text" placeholder="请输入签约公司名" class="form-control">
                                </div>
                            </div>
                         
                         <div class="form-group">
                                <label class="col-sm-3 control-label">金额：</label>

                                <div class="col-sm-8">
                                    <input autoComplete='off'  id="je" name="je" type="text" placeholder="请输入金额" class="form-control">
                                </div>
                                <!--<div id="result"></div>   --> 
                            </div>
                      <div class="form-group">
                                <label class="col-sm-3 control-label">币种：</label>

                                <div class="col-sm-8">
                                    <input id="bz" name="bz" type="text" placeholder="请输入币种" class="form-control">
                                </div>
                            </div>
                            
                       <div class="form-group">
                                <label class="col-sm-3 control-label">充值类型：</label>

                                <div class="col-sm-8">
                                    <input id="lx" name="lx" type="text" placeholder="请输入充值类型" class="form-control">
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label class="col-sm-3 control-label">留言：</label>

                                <div class="col-sm-8">
                                    <input id="rmk" name="rmk" type="text" placeholder="请输入留言" class="form-control">
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label class="col-sm-3 control-label">状态：</label>

                                <div class="col-sm-8">
                                    <input id="zt" name="zt"  type="text" placeholder="请输入状态" class="form-control">
                                </div>
                            </div>
                            
                            <div class="form-group">
                                <label class="col-sm-3 control-label">充值数量：</label>

                                <div class="col-sm-8">
                                    <input  id="num" name="num" type="text" placeholder="请输入充值数量" class="form-control">
                                </div>
                            </div>
 
                              <div class="form-group">
                                <label class="col-sm-3 control-label">操作人：</label>

                                <div class="col-sm-8">
                                    <input id="czr" name="czr"  type="text" placeholder="请输入操作人" class="form-control">
                                </div>
                            </div>
 
                            <div class="hr-line-dashed"></div>
                            <div class="form-group">
                                <div class="col-sm-4 col-sm-offset-3">
                                     <input type="button" class="btn btn-primary" onclick="addkd()" value="提交" />
                                     <input type="button" class="btn btn-white" value="返回" />
                                   <!--   <button class="btn btn-primary" type="submit">提交</button>
                                    <button class="btn btn-white" type="submit">返回</button>
                                    -->
                                </div>
                            </div>
                        </form>
                    </div>
         
         
         <!-- ********************************************************** -->

    </div>
   
</body>

</html>