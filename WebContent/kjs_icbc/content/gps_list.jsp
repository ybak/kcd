<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="content-wrapper" >

	<!-- http://www.tianyigps.cn -->
	<iframe id="mainiframe" width="100%"  height="411px"
	 src="http://www.hywtech.cn/zhaonaservice/monitor/loginIndex.jhtml" frameborder="0" scrolling="auto">
	
	</iframe>

</div>
<script type="text/javascript">
function changeFrameHeight(){
      var ifm= document.getElementById("mainiframe");
      ifm.height=document.documentElement.clientHeight-56;
  }
  window.onresize=function(){ changeFrameHeight();}
  $(function(){changeFrameHeight();});
</script>