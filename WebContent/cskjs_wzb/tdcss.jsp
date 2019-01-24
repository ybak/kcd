<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>JQ实现鼠标经过显示大图效果-柯乐义</title>
<meta name="description" content="JQ实现鼠标经过显示大图效果 柯乐义" />
<meta name="keywords" content="JQ实现鼠标经过显示大图效果 keleyi.com" />
<script type="text/javascript" src="http://keleyi.com/keleyi/pmedia/jquery/jquery-1.10.2.min.js"></script>
<script type="text/javascript">
$(function () {
var x = 10;
var y = 20;
$("a.tooltip").mouseover(function (e) {
this.myTitle = this.title;
this.title = "";
var imgTitle = this.myTitle ? "<br />" + this.myTitle + " 产品预览图" : "";
var tooltip = "<div id='tooltip'><img src='" + this.href + "' alt='柯乐义产品' width='765' height='574' />" + imgTitle + "</div>";
$("body").append(tooltip);
$("#tooltip")
.css({
"top": (e.pageY + y) + "px",
"left": (e.pageX + x) + "px"
}).show("fast");
}).mouseout(function (e) {
this.title = this.myTitle;
$("#tooltip").remove();
}).mousemove(function (e) {
$("#tooltip").css({
"top": (e.pageY + y) + "px",
"left": (e.pageX + x) + "px"
});
});
})
</script>
<style>
ul{margin: 30px auto; width:1440px;}
ul li{float: left; padding-right: 20px; list-style: none;}
ul li img{width: 77px; height: 57px; padding: 6px; border: 1px solid #ccc; background-color:#eee; -webkit-border-radius: 8px;}
#tooltip{
position: absolute;
background-color: #eee;
border: 1px solid #999;
width: 765px;
height: 590px;
-webkit-border-radius: 8px;
font-family: "微软雅黑";
padding: 20px;
}
</style>
</head>
<body>
<div><a href="http://keleyi.com/a/bjac/h12vjfyv.htm" target="_blank">原文</a></div>
<div><ul>
<li><a href="http://keleyi.com/keleyi/phtml/image/img/bmw_m1_hood.jpg" title="柯乐义1" class="tooltip">
<img src="http://keleyi.com/keleyi/phtml/image/img/bmw_m1_hood.jpg" alt="柯乐义1" /></a></li>
<li><a href="http://keleyi.com/keleyi/phtml/image/img/bmw_m1_side.jpg" title="柯乐义2" class="tooltip">
<img src="http://keleyi.com/keleyi/phtml/image/img/bmw_m1_side.jpg" alt="柯乐义2" /></a></li>
<li><a href="http://keleyi.com/keleyi/phtml/image/img/bmw_m3_gt.jpg" title="柯乐义3" class="tooltip">
<img src="http://keleyi.com/keleyi/phtml/image/img/bmw_m3_gt.jpg" alt="柯乐义3" /></a></li>
<li><a href="http://keleyi.com/keleyi/phtml/image/img/corvette_pitstop.jpg" title="柯乐义4" class="tooltip">
<img src="http://keleyi.com/keleyi/phtml/image/img/corvette_pitstop.jpg" alt="柯乐义4" /></a></li>
</ul></div><div>柯乐义提醒您：把光标移动到图片上查看效果。</div>
</body>
</html>