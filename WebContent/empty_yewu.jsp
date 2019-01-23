<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">    
    <title>快加认证 - 业务报表页</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="css/bootstrap.min.css?v=3.3.5" rel="stylesheet">
    <link href="css/font-awesome.min.css?v=4.4.0" rel="stylesheet">

    <link href="css/animate.min.css" rel="stylesheet">
    <link href="css/style.min.css?v=4.0.0" rel="stylesheet"><base target="_blank">
<script type="text/javascript">
$(document).ready(function(){
	
	//alert(sssssssssss)
})

$(document).ready(function(){
	 //var val = $("#bt").val();
	 //var val = $("#bt1").val();
	 //var val = $("#bt2").val();
   alert(aaaaaaaaaaaa)
	 var page =1;
	 //给上一页添加点击事件
	   bt();  
	 // var size;
	  //var count;
	function bt(){
	  $.ajax({
	   type: "post",
	   dataType: "json",
	   url: "limit.do",
	   data:{
		     pagenow : page		   
	   },
	   success: function(msg){
	    var data1 =msg 
	    str="";
	    $.each(data1,function(index, n){
	    	   var sum_bit=data1[index].sum_bit;
			   var url=data1[index].url;	
			   var add_time=data1[index].add_time;
			
		str=str+"<tr>"+				
		"<td>来源:点融网-API专用</td>"+		
		"<td class='hidden-xs'></td>"+	
		"<td class='hidden-xs'>"+
		add_time
		+"<td class='text-center'>"+	
		"<div class='table-button'>"+	
		"<a href='a1.jsp' class='btn btn-default'>"+	
		"<i class='fa fa-pencil'>"+	
		"</i>"+	
		"</a>"+	
		"</div>"+	
        "<span class='label label-danger'>待审核</span>"+	
		"</td>"+	
		"<td>"+	
		"<span class='label label-warning'>"+sum_bit+"</span>"+	
		"</td>"+	
		"</tr>"	   
	    }); 
			  
		       $("#show").html(str);  	  
	   
	   
	   }
	  });
	 }
	  //var count=5	 	 
	})
</script>
</head>

<body class="gray-bg">
    <div class="row wrapper border-bottom white-bg page-heading">
          <footer id="table" class="dark">
           	  <jsp:include page="a3.jsp"></jsp:include>
        </footer><!-- #底部 end -->
        
        
              
    </div>
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.5"></script>
    <script src="js/content.min.js?v=1.0.0"></script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>

</html>