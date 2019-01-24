<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="form-horizontal">
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper fixed-footer" style="min-height: 943px;">
		<iframe  NAME="content_frame" id="video" width=100% style="min-height:900px"  marginwidth=0 marginheight=0  ></iframe>
	</div>
</div>

<script type="text/javascript">
$(function(){
	//alert('de');
	$("#video").attr("src","../im/login.html"+"?time="+new Date().getTime());
});
 </script>
