<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
       <style type="text/css">  

        </style> 
<script type="text/javascript">
function dkup() {
	id=document.getElementById("id").value;
	adminid=document.getElementById("adminid").value;
	bc_status=document.getElementById("status").value;
	remark=document.getElementById("remark").value;
         $.ajax({
		   type:"post",   
		   url:"dk_up.do",
		   data:{
			   id : id,
			   adminid : adminid,
			   bc_status : bc_status,
			   remark : remark
		   },
	  success: function(msg){
		  alert("提交成功");
		  window.location.reload();
		},
		 error:function(){
	      alert("提交失败，请稍后重试...");         
	       }
	  })
	
	
}
function li1(id){		
	var i=1;
    for(i;i<=4;i++){
    var imgsrc= document.getElementById("img"+i).src;
    //alert(imgsrc.substring(36,imgsrc.length));
    if(imgsrc.substring(36,imgsrc.length)=="537519733460888498.png"){
    document.getElementById("img"+i).src="${pageContext.request.contextPath }/cskjs_css/439429027073864254.png";   
    } 
    }
document.getElementById("img"+id).src="${pageContext.request.contextPath }/cskjs_css/537519733460888498.png";        
}

</script>

</head>
<body>
<form id="info_form" action="" class="form-horizontal" method="post" enctype="multipart/form-data" onsubmit="return check()">
<input id="id" name="id" value="${requestScope.icbc_dk.id }" type="hidden">
<input id="adminid" name="adminid" value="${sessionScope.id }" type="hidden">
<input id="icbc_id" name="icbc_id" value="${requestScope.id }" type="hidden">
<div class="box-body">
<div style="position:fixed; right: 2%;top: 25%;">
         <ul>
          <li style="height: 30px;">                     
            <a  onclick="li1('1');"  class="licolor" href="#section1">
            <img  id="img1" alt="" src="${pageContext.request.contextPath }/cskjs_css/439429027073864254.png">
            <font style="margin-left:8px;">合同材料</font> 
            </a>
          </li>	
          <li style="margin-left:7px;margin-top:-6px; height:30PX; border-left: 1px dashed #447feb;"></li>
          <li style="height: 30px;">          
          <a onclick="li1('2');" class="licolor" href="#section2">
          <img id="img2" alt="" src="${pageContext.request.contextPath }/cskjs_css/439429027073864254.png">
          <font style="margin-left:8px;">证明材料</font></a>
          </li>
          <li style="margin-left:7px;margin-top:-6px; height:30PX; border-left: 1px dashed #447feb;"></li>
          <li style="height: 30px;">
          <a onclick="li1('3');" class="licolor" href="#section3">
          <img id="img3"  alt="" src="${pageContext.request.contextPath }/cskjs_css/439429027073864254.png">
          <font style="margin-left:8px;">其他材料</font></a>
          </li>
          <li style="margin-left:7px;margin-top:-6px; height:30PX; border-left: 1px dashed #447feb;"></li>
          <li style="height: 30px;">
          <a onclick="li1('4');" class="licolor" href="#section4">
          <img  id="img4" alt="" src="${pageContext.request.contextPath }/cskjs_css/439429027073864254.png">
          <font style="margin-left:8px;">补充材料</font></a></li>

        </ul>
</div>            
<div style="width: 85%;" class="box-header">
<p style="border-bottom: 1px solid #f4f4f4;">
工行进件审核 来自：${requestScope.icbc_dk.gname }-${requestScope.icbc_dk.pname }
<span style="float:right;display:block;">
${fn:substring(requestScope.icbc_dk.dt_add,0,19)} 合同编码：
<font style="color: #ff8700;">${requestScope.icbc_dk.gems_code }</font>
</span>
</p>
<script type="text/javascript">
function ylimage(obj){
	if(obj!=0){
	var $img = $(obj),
		imgUrl = $img[0].src;
	}
	var activeIndex=0;
	var imgs = [];
	$(".img_q").each(function(i,elem){
		//alert(elem.src);
		if(obj!=0){
		if(elem.src == imgUrl){
			activeIndex=i;	
		}
		}
		imgs.push({
			url: elem.src, 
			imgHeight :'820',
			imgWidth : '900'
		});
	});
localStorage["photoGalleryImgs"] = JSON.stringify(imgs); //因为此字符串可能是base64字符，appgo无法传
localStorage["photoGalleryActiveIndex"] = activeIndex; 
	   //给iframe加上src路径
    $("#J_pg").attr("src","jquery-photo-gallery/gallerys.jsp");
     //显示模态框  只有在选择编辑的行   然后根据回调函数成功后才会显示模态框
    $('#myModal1').modal({ show: true, backdrop: 'static' });
}
</script>  
<script type="text/javascript">
function imgrotate1(imgpath,fr) {
	  $.ajax({
		   type:"post",   
		   url:"icbc_img.do",
		   data:{
			   imgpath : imgpath,
			   fr : fr
		   },
	  success: function(msg){
		  window.location.reload();
		}
	  })
}
</script>
<h3 align="center" style="margin-right:30px;">相关审核</h3>
<a href="downloadFiles_all.do?type=dk&id=${requestScope.id }" class="btn btn-success" style="margin-left:100px">一键下载所有图片</a>
<a onclick="ylimage('0')" class="btn btn-success">一键预览所有图片</a>
</div>

			<div class="form-group" style="width: 100%;">
			
			<div id="section1" class="col-sm-10" style=" width: 85%;" >
			<div  align="center" style="color:#ff8700;" >合同材料</div>		
			</div>
				<div class="col-sm-12" style="width: 90%;margin-top: 50px;">
					<div class="row inline-from">
					<%Random a = new Random(); %>
					<c:if test="${!empty requestScope.imgs1 }">
					<c:forEach items="${requestScope.imgs1 }" var="img">
					<c:if test="${!empty img}">
                    <div class="col-sm-2 imgbig" style="margin:20px 10px;text-align: center;">
							
							<img onclick="ylimage(this)" class="img_q" id="imgstep2_1" name="imgstep2_1" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="http://a.kcway.net/assess/${img }">
							
							<div class="col-sm-12">
							<a style="padding: 0px 5px;" class="btn btn-warning" id="xz" href="javascript:imgrotate1('${img }','1');">左转</a>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="downloadFile.do?fileUrl=http://a.kcway.net/assess/${img }&fileName=<%=a.nextInt(10000)%>">下载</a>													
						    <a style="padding: 0px 5px;" class="btn btn-warning" id="xz" href="javascript:imgrotate1('${img }','2');">右转</a>
						    </div>
					</div>
					</c:if>
                   </c:forEach>
                   </c:if>                   
                   <c:if test="${empty requestScope.imgs1 }">
                   <%
                     for(int i=0;i<5;i++){
                   %>
                   <div class="col-sm-2 imgbig" style="margin:20px 10px;text-align: center;">
							<a  href="javascript:void(0)">
							<img class="img_q aligncenter" id="imgstep2_5" name="imgstep2_5" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png">
							</a><div class="col-sm-12">	
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="javascript:void(0)">左转</a> 						
					        <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="javascript:void(0)">右转</a>   
						   </div>
					</div>
                   <%} %>
                   </c:if>
					</div>
					</div>
			<div id="section2" class="col-sm-12" style="width: 85%;margin-top: 50px;" >
			<div align="center" style="color:#ff8700;" >证明材料</div>		
			</div>
					<div class="col-sm-10" style="width: 90%; margin-top: 50px;">
					<div class="row inline-from">							
                    <c:if test="${!empty requestScope.imgs2 }">
					<c:forEach items="${requestScope.imgs2 }" var="img">
					<c:if test="${!empty img}">
                    <div class="col-sm-2 imgbig" style="margin:20px 10px;text-align: center;">
							
							<img onclick="ylimage(this)" class="img_q" id="imgstep2_1" name="imgstep2_1" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="http://a.kcway.net/assess/${img }">
							
							<div class="col-sm-12">
							<a style="padding: 0px 5px;" class="btn btn-warning" id="xz" href="javascript:imgrotate1('${img }','1');">左转</a>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="downloadFile.do?fileUrl=http://a.kcway.net/assess/${img }&fileName=<%=a.nextInt(10000)%>">下载</a>													
						    <a style="padding: 0px 5px;" class="btn btn-warning" id="xz" href="javascript:imgrotate1('${img }','2');">右转</a>
						    </div>
					</div>
					</c:if>
                   </c:forEach>
                   </c:if>
                   <c:if test="${empty requestScope.imgs2 }">
                   <%
                     for(int i=0;i<5;i++){
                   %>
                   <div class="col-sm-2 imgbig" style="margin:20px 10px;text-align: center;">
							<a  href="javascript:void(0)">
							<img class="img_q aligncenter" id="imgstep2_5" name="imgstep2_5" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png">
							</a><div class="col-sm-12">		
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="javascript:void(0)">左转</a> 					
					        <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="javascript:void(0)">右转</a>   
						   </div>
					</div>
                   <%} %>
                   </c:if>
					</div>
</div>

			<div id="section3" class="col-sm-10" style="width: 85%;margin-top: 50px;" >
			<div align="center" style="color:#ff8700;" >其他材料</div>		
			</div>
							<div class="col-sm-10" style="width: 90%; margin-top: 50px;">
							<div class="row inline-from">		
							<c:if test="${!empty requestScope.imgs3 }">				
				   <c:forEach items="${requestScope.imgs3 }" var="img">
					<c:if test="${!empty img}">
                    <div class="col-sm-2 imgbig" style="margin:20px 10px;text-align: center;">
							
							<img onclick="ylimage(this)" class="img_q" id="imgstep2_1" name="imgstep2_1" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="http://a.kcway.net/assess/${img }">
							
							<div class="col-sm-12">
							<a style="padding: 0px 5px;" class="btn btn-warning" id="xz" href="javascript:imgrotate1('${img }','1');">左转</a>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="downloadFile.do?fileUrl=http://a.kcway.net/assess/${img }&fileName=<%=a.nextInt(10000)%>">下载</a>													
						    <a style="padding: 0px 5px;" class="btn btn-warning" id="xz" href="javascript:imgrotate1('${img }','2');">右转</a>
						    </div>
					</div>
					</c:if>
                   </c:forEach>
                   </c:if>	
                   <c:if test="${empty requestScope.imgs3 }">
                   <%
                     for(int i=0;i<5;i++){
                   %>
                   <div class="col-sm-2 imgbig" style="margin:20px 10px;text-align: center;">
							<a  href="javascript:void(0)">
							<img class="img_q aligncenter" id="imgstep2_5" name="imgstep2_5" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png">
							</a><div class="col-sm-12">	
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="javascript:void(0)">左转</a>						
					        <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="javascript:void(0)">右转</a>   
						   </div>
					</div>
                   <%} %>
                   </c:if>
					</div>
</div>

			<div id="section4" class="col-sm-10" style="width: 85%;margin-top: 50px;" >
			<div align="center" style="color:#ff8700;" >补充材料</div>		
			</div>
			<div class="col-sm-10" style="width: 90%; margin-top: 50px;">
			<div class="row inline-from">	
			        <c:if test="${!empty requestScope.imgs4 }">					
					<c:forEach items="${requestScope.imgs4 }" var="img">
					<c:if test="${!empty img}">
                    <div class="col-sm-2 imgbig" style="margin:20px 10px;text-align: center;">
							
							<img onclick="ylimage(this)" class="img_q" id="imgstep2_1" name="imgstep2_1" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="http://a.kcway.net/assess/${img }">
							
							<div class="col-sm-12">
							<a style="padding: 0px 5px;" class="btn btn-warning" id="xz" href="javascript:imgrotate1('${img }','1');">左转</a>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="downloadFile.do?fileUrl=http://a.kcway.net/assess/${img }&fileName=<%=a.nextInt(10000)%>">下载</a>													
						    <a style="padding: 0px 5px;" class="btn btn-warning" id="xz" href="javascript:imgrotate1('${img }','2');">右转</a>
						    </div>
					</div>
					</c:if>
                   </c:forEach>
                   </c:if>	
                   <c:if test="${empty requestScope.imgs4 }">
                   <%
                     for(int i=0;i<5;i++){
                   %>
                   <div class="col-sm-2 imgbig" style="margin:20px 10px;text-align: center;">
							<a  href="javascript:void(0)">
							<img class="img_q aligncenter" id="imgstep2_5" name="imgstep2_5" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png">
							</a><div class="col-sm-12">	
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="javascript:void(0)">左转</a>						
					        <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="javascript:void(0)">右转</a>   
						   </div>
					</div>
                   <%} %>
                   </c:if>
					</div>
</div>
<!-- 视频 
			<div id="section4" class="col-sm-10" style="width: 85%;margin-top: 50px;" >
			<div align="center" style="color:#ff8700;" >视频材料</div>		
			</div>
<div class="col-sm-10" style="margin-left:100px; margin-top: 50px;">
	<div class="row inline-from">	
<div style="width: 85%;" align="center" >				
<video  width="658" height="444"  poster="${pageContext.request.contextPath }/cskjs_css/268222262987697898.jpg"  preload="none" controls="controls">
<source src="http://a.kcway.net/assess/${requestScope.icbc_dk.imgstep7_4v  }" />
</video>
</div>		
									
	</div>
</div>	
-->
</div>
  		<div id="section6" class="box-header with-border" style="width: 85%">
	<h3 align="center" >审核处理</h3>
    </div>
<div class="box-body">
	<div class="form-group">
	<label class="col-sm-2 control-label">审核：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
			<div class="col-sm-4">
					<div class="input-group"><span class="input-group-addon">审核状态</span> 
					<select name="status" class="form-control" id="status" onchange="">
					            <option value="0">请选择</option>
                            	<option value="1" ${requestScope.icbc_dk.bc_status==1?"selected='selected'":''}>草稿箱</option>
                            	<option value="2" ${requestScope.icbc_dk.bc_status==2?"selected='selected'":''}>正在审核中</option>
                            	<option value="3" ${requestScope.icbc_dk.bc_status==3?"selected='selected'":''}>订单结束(成功)</option>
                            	<option value="4" ${requestScope.icbc_dk.bc_status==4?"selected='selected'":''}>回退补件</option>
                            	<option value="5" ${requestScope.icbc_dk.bc_status==5?"selected='selected'":''}>订单结束(失败)</option>                            
                            	<option value="6" ${requestScope.icbc_dk.bc_status==6?"selected='selected'":''}>撤销</option>   
                            	<option value="7" ${requestScope.icbc_dk.bc_status==7?"selected='selected'":''}>附件待审</option>   
                            	<option value="8" ${requestScope.icbc_dk.bc_status==8?"selected='selected'":''}>附件回退</option>   
                            	</select>
                            	</div>
			</div>
            <div class="col-sm-3">
					<div class="input-group"><span class="input-group-addon">类型</span> 
					<input class="form-control" readonly="" value="汽车贷款" type="text"></div>
			</div>
		  </div>
	  </div>
	</div>
	<div class="form-group"><label class="col-sm-2 control-label">留言备注说明：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
				<div class="col-sm-4">
				<div class="input-group">
				<span class="input-group-addon">审核留言</span>
				<textarea style="width: 100%; height: 40px" class="form-control" name="remark" id="remark"></textarea>
				</div>
			    </div>
				<div class="col-sm-4">
					<div class="input-group">
					<span class="input-group-addon">留言快速通道</span> 
					<select class="form-control" id="cyly" onchange="setremark(this)">
					<option value="请选择" selected="selected">请选择</option>						
					<option value="查询完成，详情请点击历史查询-&gt;已完成-&gt;查看订单！">查询完成，详情请点击历史查询-&gt;已完成-&gt;查看订单！</option>						
					<option value="恭喜您初审通过,请点编辑按钮,按提示上传其他补充材料！">恭喜您初审通过,请点编辑按钮,按提示上传其他补充材料！</option>						
					<option value="请提供行驶证与驾照正面照片！">请提供行驶证与驾照正面照片！</option>						
					<option value="请上传正确的行驶证照片">请上传正确的行驶证照片</option>						
					<option value="行驶证错误，要的是信息页。车牌车架发动机号页面">行驶证错误，要的是信息页。车牌车架发动机号页面</option>						
					<option value="行驶证要上传信息页面，上传后面一页无法识别。">行驶证要上传信息页面，上传后面一页无法识别。</option>						<option value="提交材料过于模糊，无法识别">提交材料过于模糊，无法识别</option>						
					<option value="请 上传行驶证">请 上传行驶证</option>						
					<option value="请上传完整的行驶证驾驶证照片">请上传完整的行驶证驾驶证照片</option>						
					</select></div>
			</div>
		</div>
	</div></div>
<div class="form-group">
<label class="col-sm-2 control-label">历次审核事件和留言：</label>
<div class="col-sm-10">
<textarea style="width: 80%; height: 200px" class="form-control" readonly="readonly">
<c:forEach items="${requestScope.iResults }" var="il">${fn:substring(il.dt_add,0,19)}:状态：${il.status==0?'草稿':''}${il.status==1?'草稿箱':''}${il.status==2?'提交等待':''}${il.status==3?'查询成功':''}${il.status==4?'回退':''}${il.status==5?'撤销':''},留言：${il.remark }
</c:forEach>
</textarea>
</div>
</div>
</div>	
</div>
		<div class="footer-wrap">
			<div class="box-footer" >
				<button type="button" class="btn btn-default" onclick="location.href='kjs_dk.do?out=1&id=${requestScope.id}&querytype=${requestScope.querytype}&size=${requestScope.size}&status=${requestScope.status}'">取消返回</button>
				<button type="button" style="margin-right: 70px;" onclick="dkup();" class="btn btn-primary pull-right">保存提交</button> 
			</div>
		</div>	
		</form>
		
				<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" align="center" id="myModalLabel">图片预览</h4>
            </div>
            <div class="modal-body" style="height:750px;" >
            <iframe id="J_pg" width="100%" height="100%" frameborder="0"></iframe>
            (左右键控制上一张,下一张)
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>