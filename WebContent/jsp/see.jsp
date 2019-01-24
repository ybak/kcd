<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="assets/js/jquery.js"></script>
    <script type="text/javascript">
        if (!!window.EventSource) { 
        	//EventSource是SSE的客户端.此时说明浏览器支持EventSource对象
            var source = new EventSource('pushsee.do');//发送消息
            s = '';
            source.addEventListener('message', function(e) {
                s += e.data + "<br/>";
                $("#msgFromPush").html(s);
            });//添加客户端的监听

            source.addEventListener('open', function(e) {
                console.log("连接打开");
            }, false);

            source.addEventListener('error',function(e){
                if(e.readyState==EventSource.CLOSED){
                    console.log("连接关闭");
                }else{
                    console.log(e.readyState);
                }
            });
        }else{
            console.log("您的浏览器不支持SSE");
        }
    </script>
</head>
<body>
    <div id="msgFromPush"></div>      

</body>
</html>