 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
  <html>
  <head>
  <meta charset="UTF-8">
  <title>Insert title here</title>
  <style type="text/css">
      #progress:after {
          content: '%';
      }
 </style>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
 </head>
 <body>
     <button onclick="c()" id="b" style="background: red">
    	 下载world
     </button>
     <!--   <div id="progress"></div>
       <br> -->
       
       <div id="j" style="width: 800px;height: 50px">
       		<ul id="i"  class="nav nav-pills nav-justified step step-progress" data-step="0">
				<li>
					<a>数据处理中...<span class="caret"></span></a>
				</li>
				<li>
					<a>文件生成中...<span class="caret"></span></a>
				</li>
				<li >
					<a>打包中...<span class="caret"></span></a>
				</li>
			</ul>
       </div>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
     <script type="text/javascript">
    /* 当前页面URL中参数分析函数，正则校验 */
     $(function(){	
     	$("#j").hide();
  	 }); 
  	var v=0;
	function GetQueryString(name) {  
	    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");  
	    var r = window.location.search.substr(1).match(reg);  //获取url中"?"符后的字符串并正则匹配
	    var context = "";  
	    if (r != null) context = r[2];  
	    reg = null;  
	    r = null;  
	    return context;  
	}
    function c(){
     	$("#j").show();
     	var i=GetQueryString("cid");
    	if(!i){
    		alert('url格式不对！');
    		return;
    	}
    	//xun();
    	$("#b").attr('disabled',true);  
    	 $.ajax({
                 url: '${pageContext.request.contextPath}/icbc/excel.do',
                 type: 'POST',
                 dataType:'json',
                 data:{id:i},
                 success: function (data){
                    if(data.code=='1'){
                      //上传完成，清除循环事件
					  $("#i").attr("data-step",3);
					  $("li").addClass('active');
                      clearInterval(t); 
                     //将进度更新至100%  
                     f('/KCDIMG/assess/'+data.loadf);
                    }else if(data.code=='0'){
                    	$("#i").hide();
                    	alert(data.message);
                    }
                 },
                 error: function(d){
                     /* alert(d.status); */
                 }
          });
     }
	  var t;
      //循环查看状态
      function xun(){
      	 t = setInterval(function(){
              $.ajax({
                     url:'${pageContext.request.contextPath}/icbc/jd.do',
                     type:'POST',
                     dataType:'json',
                     success: function (r) {
                     		console.log(r);
                    	  //var data = JSON.parse(responseText);
                         //前台更新进度 处理bug 如果已经打包完成 但是没有关闭定时器的问题
                         if(parseInt(r)>v){
                        	 /* progress.innerText = parseInt(responseText)=v; */
                        	  v=parseInt(r);
                        	  $("#i").attr("data-step",v);
                        	  $("ul").find("li").eq(v).addClass('active');
                         }
                     },
                     error: function(d){
                        console.log(d.status)
                     }
                 });
             }, 80);
     };
     
     // 能够弹出保存文件对话框
    function f(file) {
    	console.log('下载开始');
        var url = "${pageContext.request.contextPath}/icbc/pdonload.do";
        var form = $("<form></form>").attr("action", url).attr("method", "post");
        form.append($("<input></input>").attr("type", "hidden").attr("name", "f").attr("value", file));
        form.appendTo('body').submit().remove();
    }       
     </script>
      	<script type="text/javascript" src="js/lib.js"></script>
		<script>
			$(function() {
				bsStep();
				//bsStep(i) i 为number 可定位到第几步 如bsStep(2)/bsStep(3)
			})
		</script>
 </body>
 </html>