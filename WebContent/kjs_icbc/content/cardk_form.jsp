<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="content-wrapper fixed-footer" style="min-height: 652px;">
		<!-- Main content -->
<section class="content">
<input type="hidden" value="6" id="colortype" name="colortype">
	<ul id="myTab" class="nav nav-tabs">
			<!-- <li>
			<a id="icbc1" style="background-color: #b1bacb;color: #ffffff;" href="newicbcsh.do?icbc_type=1&amp;id=93&amp;querytype=&amp;size=15&amp;status=">
			征信</a></li> -->
			<!--  
			<li ><a id="icbc2"  href="yp_sh.do?icbc_type=2&icbc_id=93&querytype=&size=15&status=" >预评</a></li>
			-->
			<!-- <li>
			<a id="icbc3" style="background-color: #b1bacb;color: #ffffff;" href="icbc_cars_sh.do?icbc_type=3&amp;icbc_id=93&amp;querytype=&amp;size=15&amp;status=">
			评估</a></li>
			<li>
			<a id="icbc4" style="background-color: #b1bacb;color: #ffffff;" href="icbc_sp_sh.do?icbc_type=4&amp;icbc_id=93&amp;querytype=&amp;size=15&amp;status=">
			视频</a></li>
			<li>
			<a id="icbc5" style="background-color: #b1bacb;color: #ffffff;" href="kk_sh.do?icbc_type=5&amp;icbc_id=93&amp;querytype=&amp;size=15&amp;status=">
			开卡</a></li> -->
			<li class="active">
			<a id="icbc6" style="background-color: rgb(255, 135, 0); color: rgb(255, 255, 255);" href="dk_sh.do?icbc_type=6&amp;icbc_id=93&amp;querytype=&amp;size=15&amp;status=">
			汽车贷款</a></li>
	       </ul>
  <div id="divmsg" class="admin-content nav-tabs-custom box">
  
  <!-- 
  <li ><a id="icbc6"  href="newicbcsh.do?icbc_type=7&id=93&querytype=&size=15&status=" >通融</a></li>
  <li ><a id="icbc6"  href="newicbcsh.do?icbc_type=8&id=93&querytype=&size=15&status=" >财务</a></li>	
  -->  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">  
li{list-style-type: none;}
.img_q{border-radius:50%; width:150px;height:150px;}
.img_q aligncenter{border-radius:50%; width:150px;height:150px;}
</style> 
<script type="text/javascript">
function dkup() {
	id=document.getElementById("id").value;
	adminid=document.getElementById("adminid").value;
	bc_status=document.getElementById("status").value;
	remark=document.getElementById("remark").value;
         $.ajax({
		   type:"post",   
		   url:"${pageContext.request.contextPath}/erp/dk_up.do",
		   data:{
			   id : id,
			   adminid : adminid,
			   bc_status : bc_status,
			   remark : remark
		   },
	  success: function(msg){
		  //alert("id:"+id+"--adminid:"+adminid+"--bc_status:"+bc_status+"--remark:"+remark);
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
    document.getElementById("img"+i).src="${pageContext.request.contextPath}/cskjs_css/439429027073864254.png";   
    } 
    }
document.getElementById("img"+id).src="${pageContext.request.contextPath}/cskjs_css/537519733460888498.png";        
}

</script>
<script>
$(function(){
	$("#info_form").attr("onsubmit","return check()"); 
});
function getprice(obj){
	if ($("#carid").val()!=null){
		url= "ajax.php?do=info&cn=car_model&id="+$("#carid").val();
		jQuery.getJSON(url,function (opt){
			if(opt){
				$("#price_new").val(opt.price);
			}
		})
	}
}
function setremark(obj){
	if ($("#cyly").val()!="请选择快速留言"){
		$("#remark").val($("#cyly").val());
	}
}
function check(){
	$("#upload_result_pdf").attr('filename','');
	$("#upload_result_pdf").val('');
	if ($("#bc_status").val()>4 && $("#bc_status").val()!=7){
		if ($("#remark").val()==""){
			alert("留言为空！");
//			window.console.error('remark null');
			$("#remark").focus();
			return false;
		}
	}
	return true;
} 
function delpic(obj){
	$("#result_doc"+obj+"_view").attr("src","/assess/upload/none.jpg");
	$("#result_doc"+obj).val("");
}

function rpic(fid,type){
	var ri = parseInt($("#result_imgurl"+fid+"_view").attr("data-ri"));
	switch (type){
		case 1:
			ri  = ri +90;
			/* if (ri>360){
				ri = 90 ;
			} */
			break;
		case 0:
			ri  = ri -90;
			/* if (ri<0){
				ri = 270 ;
			} */
			break;
	}
	var xfile = $("#result_imgurl"+fid+"_view").attr("data-src");
	$.post("ajax.php?do=rpic",{src:xfile,rtype:type},function(res){
		eval("var res="+res);
		if(res.succ){
			$("#result_imgurl"+fid+"_view").rotate({animateTo:ri});	
			$("#result_imgurl"+fid+"_view").attr("data-ri",ri);
			var tmpstr  = $("#ashowpic"+fid).attr("href");
			var ni = tmpstr.indexOf('?');
			tmpstr = substr(tmpstr,0,ni); 
			var timestamp = Date.parse(new Date());
			//$("#result_imgurl"+fid+"_view").attr("src",tmpstr+"?"+timestamp);
			$("#ashowpic"+fid).attr("href",tmpstr+"?"+timestamp);
		}
	});
}
function autoremark(){
	if ($("#bc_status").val()==3){//完成
		$("#remark").val("查询完成，详情请点击订单详情页查看！");
	}else{
		$("#remark").val("");
	}		
}
</script>

<form id="info_form" action="" class="form-horizontal" method="post" enctype="multipart/form-data" onsubmit="return check()">
<input id="id" name="id" value="${requestScope.icbc_dk.id}" type="hidden">
<input id="adminid" name="adminid" value="${sessionScope.pd.id}" type="hidden">
<input id="icbc_id" name="icbc_id" value="${requestScope.id}" type="hidden">
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
工行进件审核 来自：${requestScope.icbc_dk.gname}-${requestScope.icbc_dk.pname }
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
    $("#J_pg").attr("src","${pageContext.request.contextPath}/jquery-photo-gallery/gallerys.jsp");
     //显示模态框  只有在选择编辑的行   然后根据回调函数成功后才会显示模态框
    $('#myModal1').modal({ show: true, backdrop: 'static' });
}
</script>  
<script type="text/javascript">
function imgrotate1(imgpath,fr) {
	  $.ajax({
		   type:"post",   
		   url:"${pageContext.request.contextPath}/icbc_img.do",
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
<a href="${pageContext.request.contextPath}/downloadFiles_all.do?type=dk&id=${requestScope.id }" class="btn btn-success" style="margin-left:100px">一键下载所有图片</a>
<a onclick="ylimage('0')" class="btn btn-success">一键预览所有图片</a>
</div>

			<div class="form-group" style="width: 100%;">
			
			<div id="section1" class="col-sm-10" style="width:85%;">
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
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="${pageContext.request.contextPath}/downloadFile.do?fileUrl=http://a.kcway.net/assess/${img }&fileName=<%=a.nextInt(10000)%>">下载</a>													
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
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="${pageContext.request.contextPath}/downloadFile.do?fileUrl=http://a.kcway.net/assess/${img }&fileName=<%=a.nextInt(10000)%>">下载</a>													
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
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="${pageContext.request.contextPath}/downloadFile.do?fileUrl=http://a.kcway.net/assess/${img }&fileName=<%=a.nextInt(10000)%>">下载</a>													
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
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="${pageContext.request.contextPath}/downloadFile.do?fileUrl=http://a.kcway.net/assess/${img }&fileName=<%=a.nextInt(10000)%>">下载</a>													
						    <a style="padding: 0px 5px;" class="btn btn-warning" id="xz" href="javascript:imgrotate1('${img }','2');">右转</a>
						    </div>
					</div>
					</c:if>
                   </c:forEach>
                   </c:if>	
                   <c:if test="${empty requestScope.imgs4}">
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
    
<script type="text/javascript">

function change(){
	var s=document.getElementById("status").value;
	var shPeople=document.getElementById("shPeople").value;
	var sh = "";
	var shUP = "";
	if(shPeople==1){
		sh ="专员";
		shUP ="主管";
	}else if(shPeople==2){
		sh ="主管";
		shUP="经理";
	}else if(shPeople==3){
		sh ="经理";
		shUP="总监";
	}else if(shPeople==4){
		sh ="总监";
		shUP="专员";
	}
	if(s==8){
		document.getElementById("remark").value="由-"+sh+"-跳到下一级-"+shUP+"-审核";	
	}else{
		document.getElementById("remark").value="";
	}	
}
</script>   
<div class="box-body">
<!-- 审核人员级别 -->
<input type="hidden" id="shPeople" value="${requestScope.icbc_dk.sh_status}">
	<div class="form-group">
	<label class="col-sm-2 control-label">审核：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
			<div class="col-sm-4">
					<div class="input-group"><span class="input-group-addon">审核状态</span> 
					<select name="status" class="form-control" id="status" onchange="change();">
					            <option value="0">请选择</option>
                            	<%-- <option value="1" ${requestScope.icbc_dk.bc_status==1?"selected='selected'":''}>草稿箱</option> 
                            	<option value="2" ${requestScope.icbc_dk.bc_status==2?"selected='selected'":''}>
                            		<c:if test="${requestScope.icbc_dk.sh_status == 1}">专员</c:if>
									<c:if test="${requestScope.icbc_dk.sh_status == 2}">主管</c:if>
									<c:if test="${requestScope.icbc_dk.sh_status == 3}">经理</c:if>
									<c:if test="${requestScope.icbc_dk.sh_status == 4}">总监</c:if>
                            		正在审核中
                            	</option> --%>
                            	<option value="3" ${requestScope.icbc_dk.bc_status==3?"selected='selected'":''}>过件</option>
                            	<option value="4" ${requestScope.icbc_dk.bc_status==4?"selected='selected'":''}>回退补件</option>
                            	<%--<option value="5" ${requestScope.icbc_dk.bc_status==5?"selected='selected'":''}>订单结束(失败)</option>                            
                            	<option value="6" ${requestScope.icbc_dk.bc_status==6?"selected='selected'":''}>撤销</option>   
                            	<option value="7" ${requestScope.icbc_dk.bc_status==7?"selected='selected'":''}>附件待审</option>   --%> 
                            	<option value="8" ${requestScope.icbc_dk.bc_status==8?"selected='selected'":''}>过件附条件</option>   
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
<textarea style="width:80%; height: 200px" class="form-control" readonly="readonly">
<c:forEach items="${requestScope.iResults}" var="il">${fn:substring(il.dt_add,0,19)}:状态：${il.status==0?'草稿':''}${il.status==1?'草稿箱':''}${il.status==2?'提交等待':''}${il.status==3?'过件':''}${il.status==4?'回退补件':''}${il.status==8?'过件附条件':''},留言：${il.remark }
</c:forEach>
</textarea>
</div>
</div>
</div>	
</div>
		<div class="footer-wrap">
			<div class="box-footer" >
				<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/erp/index_.do?type=wlghd&dn=cardk&qn=list&status=${requestScope.status}'">取消返回</button>
				<button type="button"  onclick="dkup();" class="btn btn-primary pull-right">保存提交</button> 
			</div>
		</div>	
		</form>
		
				<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" align="center" id="myModalLabel">图片预览</h4>
            </div>
            <div class="modal-body" style="height:750px;">
            <iframe id="J_pg" width="100%" height="100%" frameborder="0"></iframe>
            (左右键控制上一张,下一张)
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


</div>
		
		
</section>

			</div>