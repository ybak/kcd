<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<!DOCTYPE html> 
<html> 
<head> 
<meta charset=" utf-8"> 
<title>脚本之家</title> 
<script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
<script type="text/javascript">
$(document).ready(function(){
 //var val = $("#bt").val();
 //var val = $("#bt1").val();
 //var val = $("#bt2").val();

 var page =1;
 //给上一页添加点击事件
   bt();  
  var size;
  var count;
function bt(){
  $.ajax({
   type: "post",
   dataType: "json",
   url: "financelistlimit.do",
   data:{
	     pagenow : page
	   
   },
   success: function(msg){
    var data1 =msg
    var result;
    $.each(data1,function(i, n){
    	   size=data1[i].size;
		   count=data1[i].count;
		   result=data1[i].result;
		   //alert(size) 
		 //  alert(count) 
		  // alert(result) 
    })    
    str="";
    $.each(result,function(index, n){
    	   var shgs=result[index].shgs;
		   var je=result[index].je;
		   var bz=result[index].bz;
		   var lx=result[index].lx;
		   var rmk=result[index].rmk;
		   var zt=result[index].zt;
		   var czr=result[index].czr;	
		   var addtime=result[index].addtime;	
 str=str+shgs+" "+je+" "+bz+" "+lx+" "+rmk+" "+zt+" "+czr+" "+addtime+"<br/>";
    
    }); 
		  
	       $("#show").html(str);  	  
   
   
   }
  });
 }
  //var count=5
  var size=3
  alert(size)//获取
  alert(count)//获取     
 $("#bt1").click(function() {
      page = page - 1;
      if(page < 1) {
          page = 1;
      }
      bt(); //加载数据
     
  })
    
$("#bt2").click(function() {
      page = page + 1;
      if(page*size < count) {
          page = page;
      }
      bt(); //加载数据
  })   
 
 
})
</script>
</head>
<body>

<div id="show"></div>
<input type="button" id="bt1" value="上一页"/>
<input type="button" id="bt2" value="下一页"/>
</body>
</html>