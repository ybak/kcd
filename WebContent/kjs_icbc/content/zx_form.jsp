<%@page import="com.model.icbc.icbc_result"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- <script src="${pageContext.request.contextPath }/cskjs_css/jQuery-2.js" type="text/javascript"></script> --%>
<div class="content-wrapper fixed-footer" style="min-height: 652px;">
		<!-- Main content -->
<section class="content">
<input type="hidden" value="1" id="colortype" name="colortype">
	<ul id="myTab" class="nav nav-tabs">
			<li class="active">
			<a id="icbc1" style="background-color: rgb(255, 135, 0); color: rgb(255, 255, 255);" href="#">
			征信</a></li>
			<!--  
			<li ><a id="icbc2"  href="yp_sh.do?icbc_type=2&icbc_id=418&querytype=&size=15&status=" >预评</a></li>
			-->
			<!-- <li>
			<a id="icbc3" style="background-color: #b1bacb;color: #ffffff;" href="icbc_cars_sh.do?icbc_type=3&amp;icbc_id=418&amp;querytype=&amp;size=15&amp;status=">
			评估</a></li>
			<li>
			<a id="icbc4" style="background-color: #b1bacb;color: #ffffff;" href="icbc_sp_sh.do?icbc_type=4&amp;icbc_id=418&amp;querytype=&amp;size=15&amp;status=">
			视频</a></li>
			<li>
			<a id="icbc5" style="background-color: #b1bacb;color: #ffffff;" href="kk_sh.do?icbc_type=5&amp;icbc_id=418&amp;querytype=&amp;size=15&amp;status=">
			开卡</a></li>
			<li>
			<a id="icbc6" style="background-color: #b1bacb;color: #ffffff;" href="dk_sh.do?icbc_type=6&amp;icbc_id=418&amp;querytype=&amp;size=15&amp;status=">
			汽车贷款</a></li> -->
	</ul>
<div id="divmsg" class="admin-content nav-tabs-custom box">
    

<script type="text/javascript" src="/kcd/cskjs_css/bootstrap-select.js"></script>    
<link rel="stylesheet" type="text/css" href="/kcd/cskjs_css/bootstrap-select.css">    
<link rel="icon" href="/kcd/cskjs_css/logo.png" type="image/x-icon">
<script src="/kcd/cskjs_css/jquery.circliful.js" type="text/javascript"></script>
<script src="/kcd/cskjs_css/jquery.circliful.min.js" type="text/javascript"></script>
<script src="/kcd/jquery-photo-gallery/jquery.photo.gallery.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
//居左
.alignleft { 
display: inline; 
float: left; 
} 
//居右
.alignright { 
display: inline; 
float: right; 
} 
//居中
.aligncenter { 
clear: both; 
display: block; 
margin:auto; 
} 
/* 图片放大tooltip */  
.tooltip{  
position:absolute;  
border:1px solid #eeeeee;  
background:#eeeeee;  
padding:1px 1px 1px 1px;  
display:none;  
} 
li{list-style-type: none;}
img{border-radius:50%; width:150px;height:150px;}
</style>
<script type="text/javascript">
function zxup(){
	var form = new FormData(document.getElementById("zx_form"));
	$.ajax({
		   type:"post",   
		   url:"${pageContext.request.contextPath}/erp/upicbc.do",
		   data:form,
		   /**
	        *必须false才会自动加上正确的Content-Type
	        */
	        contentType: false,
	        /**
	        * 必须false才会避开jQuery对 formdata 的默认处理
	        * XMLHttpRequest会对 formdata 进行正确的处理
	    	* window.location.reload();	
	        */
	        processData: false,
	  	 success: function(msg){
		  alert("提交成功");
		  window.location.reload();
		 },
		 error:function(){
	          alert("提交失败，请稍后重试...");         
	     }
	  });
}
</script>
<form id="zx_form" action="" class="form-horizontal" method="post" enctype="multipart/form-data" onsubmit="return check()">
<input id="id" name="id" value="${requestScope.icbc.id}" type="hidden">
<input id="mid_add" name="mid_add" value="${requestScope.icbc.mid_add}" type="hidden">
<input id="adminid" name="adminid" value="${sessionScope.pd.id}" type="hidden">
<input id="gems_code" name="gems_code" value="${requestScope.icbc.gems_code}" type="hidden">
<div class="box-header with-border">
	<div  class="box-body" style="margin-left: 150px;width: 80%" >  	
			  <div class="form-group">						
			  <h3 align="center" style="margin-right: 300px">用户提交信息</h3>
			  <div  style="padding-top: 60px;width:85%;">               
             <p>工行进件审核 来自：${requestScope.icbc.gname}-${requestScope.icbc.pname}<span style="float:right;display:block;">${fn:substring(requestScope.icbc.dt_add,0,19)} 合同编码：<font style="color: #ff8700;">${requestScope.icbc.gems_code }</font></span></p>            
               <table id="data_table" class="divcss table" style="border-style:none">  
               <tr>
               <td style="color: #5f5f6c;">借款人姓名</td>
               <td><input class="inputcss" id="c_name" name="c_name" type="text" value="${requestScope.icbc.c_name }" /></td>
               <td style="color: #5f5f6c;">配偶姓名</td>
               <td><input class="inputcss" id="c_name_mt" name="c_name_mt" type="text" value="${requestScope.icbc.c_name_mt }" /></td>
               <td style="color: #5f5f6c;">共同借款人姓名1</td>
               <td><input class="inputcss" id="c_name_gj1" name="c_name_gj1" type="text" value="${requestScope.icbc.c_name_gj1 }" /></td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">借款人身份证</td>
               <td><input class="inputcss" id="c_cardno" name="c_cardno" type="text" value="${requestScope.icbc.c_cardno }" /></td>
               <td style="color: #5f5f6c;">配偶身份证</td>
               <td><input class="inputcss" id="c_cardno_mt" name="c_cardno_mt" type="text" value="${requestScope.icbc.c_cardno_mt }" /></td>
               <td style="color: #5f5f6c;">共同借款人身份证1</td>
               <td><input class="inputcss" id="c_cardno_gj1" name="c_cardno_gj1" type="text" value="${requestScope.icbc.c_cardno_gj1 }" /></td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">借款人电话</td>
               <td><input class="inputcss" id="c_tel" name="c_tel" type="text" value="${requestScope.icbc.c_tel }" /></td>
               <td style="color: #5f5f6c;">配偶电话</td>
               <td><input class="inputcss" id="c_tel_mt" name="c_tel_mt" type="text" value="${requestScope.icbc.c_tel_mt }" /></td>
               <td style="color: #5f5f6c;">共同借款人电话1</td>
               <td><input class="inputcss" id="c_tel_gj1" name="c_tel_gj1" type="text" value="${requestScope.icbc.c_tel_gj1 }" /></td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">借款人性别</td>
               <td>
                <select id="c_sex" name="c_sex" >
                <option value="1" ${requestScope.icbc.c_sex==1?"selected='selected'":''}>男</option>
                <option value="0" ${requestScope.icbc.c_sex==0?"selected='selected'":''}>女</option>
                </select>
               </td>
               <td></td>
               <td></td>
               <td style="color: #5f5f6c;">共同借款人姓名2</td>
               <td><input class="inputcss" id="c_name_gj2" name="c_name_gj2" type="text" value="${requestScope.icbc.c_name_gj2 }" /></td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">按揭银行</td>
               <td>
                <select id="bank_id" name="bank_id" >
                <option value="0" ${requestScope.icbc.bank_id==0?"selected='selected'":'' }>请选择按揭银行</option>  
                <option value="1" ${requestScope.icbc.bank_id==1?"selected='selected'":'' }>工行绍兴分行</option>
                <option value="2" ${requestScope.icbc.bank_id==2?"selected='selected'":'' }>工行武林支行</option>
                <option value="3" ${requestScope.icbc.bank_id==3?"selected='selected'":'' }>工行义乌支行</option>              
                </select>
               </td>
               <td></td>
               <td></td>
               <td style="color: #5f5f6c;">共同借款人身份证2</td>
               <td><input class="inputcss" id="c_cardno_gj2" name="c_cardno_gj2" type="text" value="${requestScope.icbc.c_cardno_gj2 }" /></td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">贷款产品</td>
               <td>
                <select id="loan_tpid" name="loan_tpid" >
                <option value="0" ${requestScope.icbc.loan_tpid==0?"selected='selected'":'' }>请选择贷款产品</option>
                <option value="1" ${requestScope.icbc.loan_tpid==1?"selected='selected'":'' }>卡分期</option>              
                </select>
               </td>
               <td></td>
               <td></td>
               <td style="color: #5f5f6c;">共同借款人手机2</td>
               <td><input class="inputcss" id="c_tel_gj2" name="c_tel_gj2" type="text" value="${requestScope.icbc.c_tel_gj2 }" /></td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">业务等级</td>
               <td>
                <select id="loan_level" name="loan_level">
                <option value="0" ${requestScope.icbc.loan_level==0?"selected='selected'":'' }>请选择业务等级</option>
                <option value="1" ${requestScope.icbc.loan_level==1?"selected='selected'":'' }>预期贷款额度10万以下(含10万)</option>
                <option value="2" ${requestScope.icbc.loan_level==2?"selected='selected'":'' }>预期贷款额度10万以上</option>
                </select>
               </td>
               </tr>
               </table>              
              </div>
              </div>
              </div>
		   </div>			

	
<script>

function downallfile(url){
	window.open(url);
}
function dodownall(){
	window.open('');
}
var current = 0; 
function xz(id){
        current = (current+90)%360;    
        document.getElementById(id).style.transform = 'rotate('+current+'deg)';
    }

</script>		
<script type="text/javascript">
function imgrotate(imgpath,fr) {
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
	  });
}
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

<div class="box-body">
<div style="width: 85%;" class="box-header with-border">
<h3 align="center" style="margin-right:30px;">相关审核</h3>
<a href="${pageContext.request.contextPath}/downloadFile_all.do?type=icbc&id=${requestScope.icbc.id}" class="btn btn-success">一键下载所有图片</a>
<a onclick="ylimage('0')" class="btn btn-success">一键预览所有图片</a>
</div>
			<div class="form-group" style="width: 100%;">
			<div id="section3" class="col-sm-10" style=" width: 85%;" >
			<div  align="center" style="color:#ff8700;" >征信材料</div>		
			</div>
				<div class="col-sm-12" style="margin-top: 50px;">
					<div id="d" class="row inline-from">
					<c:if test="${!empty requestScope.icbc.imgstep2_1 }">
					<div class="col-sm-2" style="margin:20px 10px;text-align: center;">
							<img class="img_q" id="imgstep2_1" onclick="ylimage(this)" name="imgstep2_1" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="http://a.kcway.net/assess/${requestScope.icbc.imgstep2_1 }" />
							<div  class="col-sm-12">	
							<a style="padding: 0px 5px;" class="btn btn-warning" id="xz" href="javascript:imgrotate('${requestScope.icbc.imgstep2_1 }','1');">左转</a>						
					        <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="${pageContext.request.contextPath}/downloadFile.do?fileUrl=http://a.kcway.net/assess/${requestScope.icbc.imgstep2_1 }&fileName=身份证正面"  >下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning" id="xz" href="javascript:imgrotate('${requestScope.icbc.imgstep2_1 }','2');">右转</a>
						    <br>
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="http://a.kcway.net/assess/${requestScope.icbc.imgstep2_1 }" target="_blank">身份证正面</a>
						    </div>
					</div> 
					</c:if>
					<c:if test="${empty requestScope.icbc.imgstep2_1 }">
						<div class="col-sm-2" style="margin:20px 10px;text-align: center;">
							<img class="img_q" id="imgstep2_1" name="imgstep2_1" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png" />							
							<div class="col-sm-12">	
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="javascript:void(0)" >左转</a>						
					        <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)" >下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="javascript:void(0)">右转</a>
						     <br>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">身份证正面</a>
						    </div>
					    </div> 
					</c:if>
					<c:if test="${!empty requestScope.icbc.imgstep2_2 }">
						<div class="col-sm-2" style="margin:20px 10px;text-align: center;">
							<img onclick="ylimage(this)"  class="img_q aligncenter" id="imgstep2_2" name="imgstep2_2" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="http://a.kcway.net/assess/${requestScope.icbc.imgstep2_2 }" />
							<div class="col-sm-12">
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:imgrotate('${requestScope.icbc.imgstep2_2 }','1');">左转</a>
					        <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="${pageContext.request.contextPath}/downloadFile.do?fileUrl=http://a.kcway.net/assess/${requestScope.icbc.imgstep2_2 }&fileName=身份证反面" >下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:imgrotate('${requestScope.icbc.imgstep2_2 }','2');">右转</a>
						    <br>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="http://a.kcway.net/assess/${requestScope.icbc.imgstep2_2 }" target="_blank">身份证反面</a>
						    
						    </div>
					</div> 
					</c:if>
                    <c:if test="${empty requestScope.icbc.imgstep2_2 }">
						<div class="col-sm-2" style="margin:20px 10px;text-align: center;">
							<img class="img_q aligncenter" id="imgstep2_2" name="imgstep2_2" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png" />							
							<div class="col-sm-12">
					        <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)" >下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)" >旋转</a>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">右转</a>
						    <br>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)" >身份证反面</a>
						    </div>
					</div> 
					</c:if>
					<c:if test="${!empty requestScope.icbc.imgstep2_3  }">
					<div class="col-sm-2" style="margin:20px 10px;text-align: center;">							
							<img onclick="ylimage(this)"  class="img_q aligncenter"   id="imgstep2_3" name="imgstep2_3" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="http://a.kcway.net/assess/${requestScope.icbc.imgstep2_3 }">
							<div class="col-sm-12" style="*display: inline;*zoom: 1;">
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:imgrotate('${requestScope.icbc.imgstep2_3 }','1');">左转</a>
					        <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="${pageContext.request.contextPath}/downloadFile.do?fileUrl=http://a.kcway.net/assess/${requestScope.icbc.imgstep2_3 }&fileName=手持身份证授权书/面签照" target="_blank">下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:imgrotate('${requestScope.icbc.imgstep2_3 }','2');">右转</a>
						     <br>
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="http://a.kcway.net/assess/${requestScope.icbc.imgstep2_3 }" target="_blank">手持身份证授权书/面签照</a>
							</div>
					</div> 
					</c:if>
                    <c:if test="${!empty requestScope.icbc.imgstep2_4  }">
					<div class="col-sm-2" style="margin:20px 10px;text-align: center;">							
							<img onclick="ylimage(this)"  class="img_q aligncenter" id="imgstep2_4" name="imgstep2_4" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="http://a.kcway.net/assess/${requestScope.icbc.imgstep2_4 }">
							<div class="col-sm-12" style="*display: inline;*zoom: 1;">
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:imgrotate('${requestScope.icbc.imgstep2_4 }','1');">左转</a>	
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="${pageContext.request.contextPath}/downloadFile.do?fileUrl=http://a.kcway.net/assess/${requestScope.icbc.imgstep2_4 }&fileName=手持身份证授权书/面签照" >下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:imgrotate('${requestScope.icbc.imgstep2_4 }','2');">右转</a>					        
						    <br>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="ashowpic3" href="http://a.kcway.net/assess/${requestScope.icbc.imgstep2_4 }" target="_blank">手持身份证授权书/面签照</a>
						    </div>
					</div> 
					</c:if>
					<c:if test="${empty requestScope.icbc.imgstep2_3 && empty requestScope.icbc.imgstep2_4 }">
					<div class="col-sm-2" style="margin:20px 10px;text-align: center;*display: inline;*zoom: 1;">
							<img class="img_q aligncenter" id="" name="" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png">
							<div class="col-sm-12" style="display:inline-block;*display:inline;*zoom:1;">
					        <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)" >左转</a>
					         <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)" >下载</a>							
							 <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)" >右转</a>
						     <br>
							<a style="padding: 0px 5px; " class="btn btn-warning" id="" href="javascript:void(0)">手持身份证授权书/面签照</a>
						    </div>
					</div> 
					</c:if>
					<c:if test="${!empty requestScope.icbc.imgstep2_5 }">
						<div class="col-sm-2" style="margin:20px 10px;text-align: center;">							
							<img onclick="ylimage(this)" class="img_q aligncenter" id="imgstep2_5" name="imgstep2_5" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="http://a.kcway.net/assess/${requestScope.icbc.imgstep2_5 }">
							<div class="col-sm-12">		
							<a style="padding: 0px 5px;" class="btn btn-warning"   id="" href="javascript:imgrotate('${requestScope.icbc.imgstep2_5 }','1');" >左转</a>					
					        <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="${pageContext.request.contextPath}/downloadFile.do?fileUrl=http://a.kcway.net/assess/${requestScope.icbc.imgstep2_5 }&fileName=授权书" >下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning"   id="" href="javascript:imgrotate('${requestScope.icbc.imgstep2_5 }','2');" >右转</a>
						    <br>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="http://a.kcway.net/assess/${requestScope.icbc.imgstep2_5 }" target="_blank">授权书</a>
						    </div>
					</div> 
					</c:if>
					<c:if test="${empty requestScope.icbc.imgstep2_5 }">
						<div class="col-sm-2" style="margin:20px 10px;text-align: center;">
							<img class="img_q aligncenter" id="imgstep2_5" name="imgstep2_5" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png">
							<div class="col-sm-12">
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="javascript:void(0)">左转</a>	
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="javascript:void(0)">右转</a>					       
					        <br>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">授权书</a>
						    
						    	</div>
					</div> 
					</c:if>
					<%
					int i=1;
					%>
					<c:forEach var="imgs" items="${requestScope.imgs}">
					<c:if test="${!empty imgs }">
					<div class="col-sm-2" style="margin:20px 10px;text-align: center;">	
							<img onclick="ylimage(this)" class="img_q aligncenter" id="imgs<%=i %>" name="imgs<%=i %>" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="http://a.kcway.net/assess/${imgs }">
							<div  class="col-sm-12">
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:imgrotate('${imgs }','1');">左转</a>						    
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="${pageContext.request.contextPath}/downloadFile.do?fileUrl=http://a.kcway.net/assess/${imgs }&fileName=补充材料<%=i %>" >下载</a>														
						    <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:imgrotate('${imgs }','2');">右转</a>
						    <br>
						    <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="http://a.kcway.net/assess/${imgs }" target="_blank">补充材料<%=i %></a>
						    </div>
					</div>	
					<%i++; %>
					</c:if>									
					</c:forEach>					
					</div>
					</div>
									
	</div>
	<!-- 信用评分 -->
	<%-- <div class="box-body">
	<div id="" class="box-header with-border" style="width: 85%">
	<h3 align="center" >信用评分</h3>
    </div>
    <div align="center"  style="width: 85%">
    <input  id="dsj_result" name="dsj_result"  type="hidden" value="${requestScope.icbc.dsj_result }" />
	<div id="myStat" data-dimension="150" data-text="0分" data-info="评分" 
    data-width="8" data-fontsize="30" data-percent="100" data-fgcolor="#f82c55" 
    data-bgcolor="#fff" data-fill="#fff">
    </div>  
    <img id="mz" alt="" src="${pageContext.request.contextPath }/cskjs_css/637889043846388630.png">
    <script>
    $( document ).ready(function() {
    	pf();                
    });
    function pf(){     
   	 var id=document.getElementById("id").value; 
    	$.ajax({
   		   type: "post",
   		   dataType:"json",
   		   url: "xypf.do",
   		   data:{
   			 id : id   			 
   		   },
   		   success: function(msg){  		    
   		    if(msg.code==1){  
   		    	var num=Math.round((msg.msg/59)*100);
   		    	$("#myStat").attr("data-text",num+"分");
   		    	$("#myStat").attr("data-percent",num);
   		    	$('#myStat').circliful(); 
   		    	$('#mz').attr("src","${pageContext.request.contextPath }/cskjs_css/325056673076264778.png");
   		    }else{
   		    	$('#myStat').circliful();
   		    }
   		   },
   		   error:function(){ 
 	          $('#myStat').circliful();
 	       }   		   
          });
    }
    </script>
	</div>
	</div> --%>
	<div id="section6" class="box-header with-border" style="width: 85%">
	<h3 align="center" >审核处理</h3>
    </div>
    <script type="text/javascript">
     function queryid(name,phone,cardno,dsjname) {
    	 $.ajax({
  		   type: "post",
  		   dataType:"json",
  		   url: "${pageContext.request.contextPath}/dsj_report_id.do",
  		   data:{
  			 name : name,
  			 phone : phone,
  			 cardno : cardno
  		   },
  		   success: function(msg){  		    
  		    if(msg.success==true){  
  		    	alert("获取成功!");
  		    	document.getElementById(dsjname).value=msg.report_id;		
  		    }else{
  		    	alert("获取失败，请重试...");
  		    }
  		   },
  		   error:function(){
	          alert("系统错误，请稍后重试...");         
	       }
  		   
           });
	 }   
     
     function query_result(){
    	 var report_id=document.getElementById("dsj_report_id").value; 
    	 $.ajax({
    		   type: "post",
    		   dataType:"text",
    		   url: "${pageContext.request.contextPath}/dsj_result.do",
    		   data:{
    			   report_id : report_id
    		   },
    		   success: function(msg){  		    
    		    	alert("报告获取成功!");
    		    	$("#dsj_result").val(msg);	    		    	    		    
    		   },
    		   error:function(){
  	          alert("系统错误，请稍后重试...");         
  	       }
    		   
             });
     }
     function dsj_bg(report_id) {
    	 var dsj_code=document.getElementById(report_id).value;
    	 if(dsj_code!=null&&dsj_code!=""){
    		 var frameSrc="${pageContext.request.contextPath}/dsj_result_jsp.do?report_id="+dsj_code;
      	   //给iframe加上src路径
           $("#NoPermissioniframe").attr("src", frameSrc);
            //显示模态框  只有在选择编辑的行   然后根据回调函数成功后才会显示模态框
           $('#myModal').modal({ show: true, backdrop: 'static' }); 
    	 }else{
    		 alert("大数据编码不能为空!");
    	 }
    	 
    	 	
     }
    </script>
<div class="box-body">
<div class="form-group">
<div class="form-group">
<label class="col-sm-2 control-label">大数据查询：</label>	   
<div class="col-sm-8">

<ul id="dsjTab"  class="nav nav-tabs">
 <li class="active"><a href="#dsjTab1" data-toggle="tab" aria-expanded="false">主贷人</a></li>
 <li><a href="#dsjTab2" data-toggle="tab" aria-expanded="false">配偶</a></li>
 <li><a href="#dsjTab3" data-toggle="tab" aria-expanded="false">共借人1</a></li>
 <li><a href="#dsjTab4" data-toggle="tab" aria-expanded="false">共借人2</a></li>
</ul>
<div id="dsjTabContent" class="tab-content">
<div class="tab-pane fade active in" id="dsjTab1">
<div class="box-body">
	<div class="form-group">
		<div class="col-sm-12">
			<div class="row inline-from">
			        <div class="input-group">
						<span  class="input-group-addon">大数据编码</span>
						<input class="form-control" name="dsj_report_id" id="dsj_report_id" value="${requestScope.icbc.dsj_report_id }" type="text">
					    <span class="input-group-addon">
						<a style="color: #72afd2;" href="javascript:queryid('${requestScope.icbc.c_name }','${requestScope.icbc.c_tel }','${requestScope.icbc.c_cardno }','dsj_report_id')">获取编码</a>
						</span>
						<span class="input-group-addon">
						<a   style="color: #72afd2;" href="javascript:dsj_bg('dsj_report_id');">查看报告</a>
						</span>
					</div>
					</div>
		</div>
	</div>
</div>	
</div>
<div class="tab-pane fade" id="dsjTab2">
<div class="box-body">
	<div class="form-group">
		<div class="col-sm-12">
			<div class="row inline-from">
			<div class="input-group">
						<span  class="input-group-addon">大数据编码</span>
						<input class="form-control" name="po_dsj_report_id" id="po_dsj_report_id" value="${requestScope.icbc.po_dsj_report_id }" type="text">
					    <span class="input-group-addon">
						<a style="color: #72afd2;" href="javascript:queryid('${requestScope.icbc.c_name_mt }','${requestScope.icbc.c_tel_mt }','${requestScope.icbc.c_cardno_mt }','po_dsj_report_id');">获取编码</a>
						</span>
						<span class="input-group-addon">
						<a   style="color: #72afd2;" href="javascript:dsj_bg('po_dsj_report_id');">查看报告</a>
						</span>
					</div>									
			</div>
		</div>
	</div>
</div>	
</div>
<div class="tab-pane fade" id="dsjTab3">
<div class="box-body">
	<div class="form-group">
		<div class="col-sm-12">
			<div class="row inline-from">
			<div class="input-group">
						<span  class="input-group-addon">大数据编码</span>
						<input class="form-control" name="gjr_dsj_report_id1" id="gjr_dsj_report_id1" value="${requestScope.icbc.gjr_dsj_report_id1 }" type="text">
					    <span class="input-group-addon">
						<a style="color: #72afd2;" href="javascript:queryid('${requestScope.icbc.c_name_gj1 }','${requestScope.icbc.c_tel_gj1 }','${requestScope.icbc.c_cardno_gj1 }','gjr_dsj_report_id1');">获取编码</a>
						</span>
						<span class="input-group-addon">
						<a   style="color: #72afd2;" href="javascript:dsj_bg('gjr_dsj_report_id1');">查看报告</a>
						</span>
					</div>								
			</div>
		</div>
	</div>
</div>	
</div>
<div class="tab-pane fade" id="dsjTab4">
<div class="box-body">
	<div class="form-group">
		<div class="col-sm-12">
			<div class="row inline-from">
			         <div class="input-group">
						<span  class="input-group-addon">大数据编码</span>
						<input class="form-control" name="gjr_dsj_report_id2" id="gjr_dsj_report_id2" value="${requestScope.icbc.gjr_dsj_report_id2 }" type="text">
					    <span class="input-group-addon">
						<a style="color: #72afd2;" href="javascript:queryid('${requestScope.icbc.c_name_gj2 }','${requestScope.icbc.c_tel_gj2 }','${requestScope.icbc.c_cardno_gj2 }','gjr_dsj_report_id2');">获取编码</a>
						</span>
						<span class="input-group-addon">
						<a   style="color: #72afd2;" href="javascript:dsj_bg('gjr_dsj_report_id2');">查看报告</a>
						</span>
					</div>								
			</div>
		</div>
	</div>
</div>	
</div>	
</div>
</div>
	</div>
	
	<!--  
<div class="form-group">
<label class="col-sm-2 control-label">大数据返回字段：</label>
<div class="col-sm-10">
<input type="hidden" >
<textarea id="dsj_result" name="dsj_result" style="width: 80%; height: 200px" class="form-control" readonly="readonly">
${requestScope.icbc.dsj_result }
</textarea>
</div>
</div>
-->
	<!-- 通融模块 start -->
	<div class="form-group">
	<label class="col-sm-2 control-label">回收：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
			   <div class="col-sm-4">
					<div class="input-group">
						<span  class="input-group-addon">身份证复印件状态</span>
						<select name="card_status" class="form-control" id="card_status">
                            	<option value="0">请选择</option>
                            	<option value="1" ${requestScope.icbc.card_status==1?"selected='selected'":''}>已完结</option>
                            	<option value="2" ${requestScope.icbc.card_status==2?"selected='selected'":''}>已扣款</option>
                        </select>
					</div>
				</div>
			   <div class="col-sm-4">
					<div class="input-group">
						<span class="input-group-addon">授权书状态</span>
						<select  name="book_status" class="form-control" id="book_status">
                            	<option value="0">请选择</option>
                            	<option value="1" ${requestScope.icbc.book_status==1?"selected='selected'":''}>原件不符</option>
                            	<option value="2" ${requestScope.icbc.book_status==2?"selected='selected'":''}>已完结</option>
                                <option value="3" ${requestScope.icbc.book_status==3?"selected='selected'":''}>已扣款</option>
                        </select>
					</div>
				</div>
	  </div>
	</div>
	</div>
	<div class="form-group">
	<label class="col-sm-2 control-label">通融：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
				<div class="col-sm-4">
					<div class="input-group">
					<span class="input-group-addon">通融状态</span> 
					<select  id="tr_status" name="tr_status" class="form-control">
						<option value="0" >请选择</option>
						<option value="1" ${requestScope.icbc.tr_status==1?"selected='selected'":''}>审核中</option>
	                    <option value="2" ${requestScope.icbc.tr_status==2?"selected='selected'":''}>通融通过</option>
	                    <option value="3" ${requestScope.icbc.tr_status==3?"selected='selected'":''}>通融不通过</option>                        
                    	<option value="4" ${requestScope.icbc.tr_status==4?"selected='selected'":''}>附条件通融</option>
                    </select>
                    </div>
			   </div>		               
	  </div>
	</div>
	</div>
<div class="form-group">
<label class="col-sm-2 control-label">通融留言：</label>
<div class="col-sm-10">
<textarea  style="width: 80%; height: 80px" class="form-control" readonly="readonly">
${requestScope.icbc.tr_msg }
</textarea>
</div>
</div>
<div class="form-group">
<label class="col-sm-2 control-label">通融材料：</label>
<div class="col-sm-10">
<c:if test="${empty requestScope.imgss}">
<%  
int ii=1;
for(ii=1;ii<5;ii++){
%>
<div class="col-sm-2" style="margin:20px 10px;text-align: center;">
							<img class="img_q aligncenter" id="imgss<%=ii %>" name="imgss<%=ii %>" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png">
							<div class="col-sm-12">
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="javascript:void(0)">左转</a>	
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="javascript:void(0)">右转</a>					       
                            </div>
</div> 
<%} %>
</c:if>
<c:if test="${!empty requestScope.imgss }">
<% int img=1; %>
<c:forEach items="${requestScope.imgss }" var="imgss">
<c:if test="${!empty imgss }">
<div class="col-sm-2" style="margin:20px 10px;text-align: center;">	
		<img onclick="ylimage(this)" class="img_q aligncenter" id="imgss<%=img %>" name="imgss<%=img %>" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="http://a.kcway.net/assess/${imgss }">
		<div  class="col-sm-12">
		<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:imgrotate('${imgss }','1');">左转</a>						    
		<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="${pageContext.request.contextPath}/downloadFile.do?fileUrl=http://a.kcway.net/assess/${imgss }&fileName=通融材料<%=img %>" target="_blank">下载</a>														
		<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:imgrotate('${imgss }','2');">右转</a>
		<br>
		</div>
</div>
<%img++; %>
</c:if>
</c:forEach>
</c:if>
</div>
</div>
<!-- 通融模块 end -->
<script type="text/javascript">
function change(){
	var s=document.getElementById("bc_status").value;
	if(s==3){
		document.getElementById("zxok_tag").value=1;	
		document.getElementById("remark").value="查询完成，详情请点击历史查询-;已完成-;查看订单！";	
	 }	
	if(s==5){
		document.getElementById("zxok_tag").value=0;		
	 }	
}
</script>
<div class="form-group">
	<label class="col-sm-2 control-label">审核：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
				<div class="col-sm-4">
					<div class="input-group">
					<span class="input-group-addon">审核状态</span> 
					<select id="bc_status" name="bc_status" class="form-control"  onchange="change();">
					<option value="0">请选择</option>
					<%-- <option value="1" ${requestScope.icbc.bc_status==1?"selected='selected'":''}>草稿箱</option>
                    <option value="2" ${requestScope.icbc.bc_status==2?"selected='selected'":''}>审核中</option> --%>
                    <option value="3" ${requestScope.icbc.bc_status==3?"selected='selected'":''}>征信通过</option>
                    <option value="4" ${requestScope.icbc.bc_status==4?"selected='selected'":''}>回退补件</option>  
                    <option value="5" ${requestScope.icbc.bc_status>=5?"selected='selected'":''}>征信不通过</option>                          
                    <%-- <option value="6" ${requestScope.icbc.bc_status==6?"selected='selected'":''}>撤销6</option> --%>
                    </select>
                    </div>
			   </div>
			   <div class="col-sm-4">
					<div class="input-group">
						<span class="input-group-addon">征信是否通过状态</span>
						<select name="zxok_tag" class="form-control" id="zxok_tag">
						        <option value="2">请选择</option>
                            	<option value="1" ${requestScope.icbc.zxok_tag==1?"selected='selected'":''}>是</option>
                            	<option value="0" ${requestScope.icbc.zxok_tag==0?"selected='selected'":''}>否</option>                            
                        </select>
					</div>
				</div>
			 <div class="col-sm-3">
					<div class="input-group">
					<span class="input-group-addon">类型</span> 
					<input class="form-control" style="width: 115px;" readonly="" value="征信" type="text">
					</div>
			 </div>
             
	  </div>
	</div>
	</div>
	<div class="form-group">
	<label class="col-sm-2 control-label">留言备注说明：</label>
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
					<select class="form-control" id="cyly" name="cyly" onchange="setremark(this)">
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
	<script type="text/javascript">
	function zx_gems_up(id) {
		var imgstep1=document.getElementById("imgstep1").value;
		var imgstep2=document.getElementById("imgstep2").value;
		var imgstep3=document.getElementById("imgstep3").value;
		var imgstep4=document.getElementById("imgstep4").value;
		var zx_result=document.getElementById("zx_result").value;
		var icbc_id=document.getElementById("icbc_id").value;
			$.ajax({
				   type: "post",
				   dataType:'json',
				   url: "${pageContext.request.contextPath }/icbc/zx_gems_up.do",
				   data:{
					   gems_id : id,
					   icbc_id : icbc_id,
					   imgstep1_1 : imgstep1,
					   imgstep2_1 : imgstep2,
					   imgstep3_1 : imgstep3,
					   imgstep4_1 : imgstep4,
					   zx_result : zx_result,
					   },
				   success: function(msg){  
					   if(msg.code==1){
						   alert(msg.msg);
						   window.location.reload();
					   }else{
						   alert(msg.msg);
					   }
					  
				   } 		   
		       });	
		
	}
	</script>
	<input  type="hidden" id="icbc_id" name="icbc_id" value="${requestScope.icbc.id }"/>
	<input  type="hidden" id="imgstep1" name="imgstep1" value="${requestScope.icbc.imgstep2_1 }"/>
	<input  type="hidden" id="imgstep2" name="imgstep2" value="${requestScope.icbc.imgstep2_2 }"/>
	<input  type="hidden" id="imgstep3" name="imgstep3" value="${requestScope.icbc.imgstep2_3 }"/>
	<input  type="hidden" id="imgstep4" name="imgstep4" value="${requestScope.icbc.imgstep2_5 }"/>
	<div class="form-group">
    <label class="col-sm-2 control-label">关联商户师：</label>
	<div class="col-sm-10">
    <div class="row inline-from">
			   <div class="col-sm-4">
				<div class="input-group">
				<span class="input-group-addon">选择商户店</span>
                <select class="form-control m-select" name="gems_fs_id" id="gems_fs_id" data-edit-select="1" style="display: none;">
                <option value="0">请选择</option>	
                <c:forEach var="fs" items="${requestScope.fs }">
                <option value="${fs.id }">${fs.namepy }-${fs.name }</option>	
                </c:forEach>
                </select>
				</div>
			  </div>
			  <div class="col-sm-4">
				<div class="input-group">
				<span class="input-group-addon">选择商户师</span>
		        <select name="gems_id" id="gems_id" onchange="zx_gems_up(this.options[this.options.selectedIndex].value)" class="form-control m-select" >             
                <option value="0">请选择</option>
                </select>
				</div>
			  </div>
	</div>
	</div>
	</div>
	
<div class="form-group">
<label class="col-sm-2 control-label">征信结果返回：</label>
<div class="col-sm-10">
<!--  
<c:if test="${!empty requestScope.icbc.zx_result}">
<textarea id="zx_result" name="zx_result" style="width: 80%; height: 200px" class="form-control">${requestScope.icbc.zx_result}</textarea>
</c:if>
<c:if test="${empty requestScope.icbc.zx_result}">
<textarea id="zx_result" name="zx_result" style="width: 80%; height: 200px" class="form-control"></textarea>
</c:if>
-->
<ul id="zxTab"  class="nav nav-tabs">
 <li class="active">
 <a href="#tbstep1" data-toggle="tab" aria-expanded="false">主贷人</a>
 </li>
 <li><a href="#tbstep2" data-toggle="tab" aria-expanded="false">配偶</a></li>
 <li><a href="#tbstep3" data-toggle="tab" aria-expanded="false">共借人1</a></li>
 <li><a href="#tbstep4" data-toggle="tab" aria-expanded="false">共借人2</a></li>
</ul>
<div id="zxTabContent" class="tab-content">
<div class="tab-pane fade active in" id="tbstep1">
<div class="box-body">
	<div class="form-group">
		<div class="col-sm-12">
			<div class="row inline-from">
			<textarea id="zx_result" name="zx_result" style="width: 80%; height: 200px" class="form-control">${requestScope.icbc.zx_result}</textarea>						
			</div>
		</div>
	</div>
</div>	
</div>
<div class="tab-pane fade" id="tbstep2">
<div class="box-body">
	<div class="form-group">
		<div class="col-sm-12">
			<div class="row inline-from">
			<textarea id="po_zx_result" name="po_zx_result" style="width: 80%; height: 200px" class="form-control">${requestScope.icbc.po_zx_result}</textarea>						
												
			</div>
		</div>
	</div>
</div>	
</div>
<div class="tab-pane fade" id="tbstep3">
<div class="box-body">
	<div class="form-group">
		<div class="col-sm-12">
			<div class="row inline-from">
			<textarea id="gjr_zx_result1" name="gjr_zx_result1" style="width: 80%; height: 200px" class="form-control">${requestScope.icbc.gjr_zx_result1}</textarea>						
											
			</div>
		</div>
	</div>
</div>	
</div>
<div class="tab-pane fade" id="tbstep4">
<div class="box-body">
	<div class="form-group">
		<div class="col-sm-12">
			<div class="row inline-from">
			<textarea id="gjr_zx_result2" name="gjr_zx_result2" style="width: 80%; height: 200px" class="form-control">${requestScope.icbc.gjr_zx_result2}</textarea>						
												
			</div>
		</div>
	</div>
</div>	
</div>
</div>
</div>
</div>
<div class="form-group">
<label class="col-sm-2 control-label">历次审核事件和留言：</label>
<div class="col-sm-10">
<input type="hidden" >

<textarea style="width: 80%; height: 200px" class="form-control" readonly="readonly">
<c:forEach items="${requestScope.iResultlist}" var="re">${fn:substring(re.dt_add,0,19)}:状态：${re.statusremark },留言：${re.remark }
</c:forEach>
</textarea>
</div>
</div>

</div>		
</div>
</div>
		<div class="footer-wrap" style="margin-right:20px;">
			<div class="box-footer">
				<button type="button"  class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/erp/index_.do?type=wlghd&dn=zx&qn=list&status=${requestScope.status}'">取消返回</button>
				<!-- <button type="submit" style="margin-right: 70px;" class="btn btn-primary pull-right">保存提交</button> --> 
				<button  type="button" onclick="zxup();" class="btn btn-primary pull-right">保存提交</button>
			</div>
		</div>
</form>

<!-- 模态框（Modal） -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" align="center" id="myModalLabel">大数据报告</h4>
            </div>
            <div class="modal-body" style="height:750px;">
            <iframe id="NoPermissioniframe" width="100%" height="100%" frameborder="0"></iframe>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
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
<script type="text/javascript">
$(document).ready(function(){
var icbc_id=document.getElementById("icbc_id").value;
$.ajax({
	   type: "post",
	   dataType:'json',
	   url: "${pageContext.request.contextPath }/icbc/gems_zx.do",
	   data:{
		   icbc_id : icbc_id,
		   },
	   success: function(msg){ 
           if(msg!=null){
        	   document.getElementById("putfsname").value=msg.fsname;
        	   document.getElementById("putfsname").placeholder=msg.fsname;
    		   gems_name(msg.fsid,msg.id); 
           }
	   }   
   });
   
  $('#gems_fs_id').on('change',function(){ 
   		gems_name(document.getElementById("gems_fs_id").value,0);
   });

function gems_name(id,gemsid){
	$("#gems_id").empty();
	var con = ""; 
	var con1="<option value='0' >请选择</option>";
	$.ajax({
		type: "post",
		dataType:"json",
		url: "${pageContext.request.contextPath}/icbc/gems_name.do",
		data:{
			id:id
		},
		success: function(msg){  	
			$.each(msg,function(index, n){
				if(msg[index].id==gemsid){
				con += "<option selected='selected' value="+msg[index].id+">"+msg[index].name+"</option>";	
				}else{
				con += "<option  value="+msg[index].id+">"+msg[index].name+"</option>";	
				}
			});
			$("#gems_id").append(con1+con);
		} 		   
    });
	
	
}
</script>
<script type="text/javascript">
$.fn.filterSelect = (function(){	
    // 我就 很 纠结的，把样式内嵌在这里了，让你怎么改!!!!
    var isInit = false;
    function initCss(){
        isInit = true;
        var style = document.createElement("style");
        var csstext = '.m-input-select{color:black;width:100%;display:inline-block;*display:inline;position:relative;-webkit-user-select:none;}'+
                        '.m-input-select ul, .m-input-select li{padding:0;margin:0;color:black;}'+
                        'n.m-input-select .m-input{padding-right:22px;color:black;}'+
                        '.m-input-select .m-input-ico{position:absolute;right:0;top:0;width:22px;height:100%;background:url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAwAAAAMCAYAAABWdVznAAAATElEQVQoU2NkIBEwkqiegTwNcXFx/4m1CW4DMZoWLVrEiOIkfJpAikGuwPADNk0wxVg1gASRNSErxqkBpgldMV4NuEKNvHggNg5A6gBo4xYmyyXcLAAAAABJRU5ErkJggg==) no-repeat 50% 50%;}'+
                        '.m-input-select .m-list-wrapper{}'+
                        '.m-input-select .m-list{display:none;position:absolute;z-index:9;top:100%;left:0;right:0;max-width:100%;max-height:500px;overflow:auto;border-bottom:1px solid #ddd;}'+
                        '.m-input-select .m-list-item{cursor:default;padding:5px;margin-top:-1px;list-style:none;background:#fff;color:black;border:1px solid #ddd;border-bottom:none;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;}'+
                        '.m-input-select .m-list-item:hover{background:#2D95FF;}'+
                        '.m-input-select .m-list-item-active{background:#2D95FF;}';
        style = $("<style>"+ csstext +"</style>")[0];
        // ie 竟然坑了...
        // if(style.styleSheet) {
        //     style.styleSheet.cssText = csstext;
        // }else{
        //     style.appendChild(document.createTextNode(csstext));
        // };

        var head = document.head || document.getElementsByTagName("head")[0];
        if(head.hasChildNodes()){
            head.insertBefore(style, head.firstChild);
        }else{
            head.appendChild(style);
        };

    };

    return function(){
        !isInit && initCss();

        var $body = $("body");
        
        this.each(function(i, v){
            var $sel = $(v), $div = $('<div class="m-input-select"></div>');
            var $input = $("<input id='putfsname' type='text' class='m-input form-control' style='width:100%' />");
            // var $wrapper = $("<div class='m-list-wrapper'><ul class='m-list'></ul></div>");
            var $wrapper = $("<ul class='m-list'></ul>");
            
            $div = $sel.wrap($div).hide().addClass("m-select").parent();
            
            $div.append($input).append("<span class='m-input-ico'></span>").append($wrapper);

            // 遮罩层显示 + 隐藏
            var wrapper = {
                show: function(){
                    $wrapper.show();
                    this.$list = $wrapper.find(".m-list-item:visible");
                    this.setIndex(this.$list.filter(".m-list-item-active"));
                    this.setActive(this.index);
                },
                hide: function(){
                    $wrapper.hide();
                },
                next: function(){
                    return this.setActive(this.index + 1);
                },
                prev: function(){
                    return this.setActive(this.index - 1);
                },
                $list: $wrapper.find(".m-list-item"),
                index: 0,
                $cur: [],
                setActive: function(i){
                    // 找到第1个 li，并且赋值为 active
                    var $list = this.$list, size = $list.size();
                    if(size <= 0){
                        this.$cur = [];
                        return;
                    }
                    $list.filter(".m-list-item-active").removeClass("m-list-item-active");
                    if(i < 0){
                        i = 0;
                    }else if(i >= size){
                        i = size - 1;
                    }
                    this.index = i;
                    this.$cur = $list.eq(i).addClass("m-list-item-active");
                    this.fixScroll(this.$cur);
                    return this.$cur;
                },
                fixScroll: function($elem){
                    // console.log($wrapper);
                    var height = $wrapper.height(), top = $elem.position().top, eHeight = $elem.outerHeight();
                    var scroll = $wrapper.scrollTop();
                    // 因为 li 的 实际　top，应该要加上 滚上 的距离
                    top += scroll;
                    if(scroll > top){
                        $wrapper.scrollTop(top);
                    }else if(top + eHeight > scroll + height){
                        // $wrapper.scrollTop(top + height - eHeight);
                        $wrapper.scrollTop(top + eHeight - height);
                    }
                },
                setIndex: function($li){
                    if($li.size() > 0){
                        this.index = this.$list.index($li);
                        $li.addClass("m-list-item-active").siblings().removeClass("m-list-item-active");
                    }else{
                        this.index = 0;
                    }
                }
            };

            // input 的操作
            var operation = {
                // 文字更变了，更新 li, 最低效率的一种
                textChange: function(){
                    val = $.trim($input.val());
                    $wrapper.find(".m-list-item").each(function(i, v){
                        if(v.innerHTML.indexOf(val) >= 0){
                            $(v).show();
                        }else{
                            $(v).hide();
                        }
                    });
                    wrapper.show();
                },
                // 设值
                setValue: function($li){
                    if($li && $li.size() > 0){
                        var val = $.trim($li.html());
                        $input.val(val).attr("placeholder", val);
                        wrapper.setIndex($li);
                        $sel.val($li.attr("data-value")).trigger("change");
                    }else{
                        $input.val(function(i, v){
                            return $input.attr("placeholder");
                        });
                    };
                    wrapper.hide();
                    this.offBody();
                },
                onBody: function(){
                    var self = this;
                    setTimeout(function(){
                        self.offBody();
                        $body.on("click", self.bodyClick);
                    }, 10);
                },
                offBody: function(){
                    $body.off("click", this.bodyClick);
                },
                bodyClick: function(e){
                    var target = e.target;
                    if(target != $input[0] && target != $wrapper[0]){
                        wrapper.hide();
                        operation.setValue();
                        operation.offBody();
                    }
                }
            };
            // 遍历 $sel 对象
            function resetOption(){
            	
                var html = "", val = "";
                $sel.find("option").each(function(i, v){
                	//alert(v.value+"---");
                    if(v.selected && !val){
                        val = v.text;
                    };
                    html += '<li class="m-list-item'+ (v.selected ? " m-list-item-active" : "") +'" data-value="'+ v.value +'">'+ v.text +'</li>';
                });
                $input.val(val);
                $wrapper.html(html);
            };
            $sel.on("optionChange", resetOption).trigger("optionChange");
            $sel.on("setEditSelectValue", function(e, val){
                // console.log(val);
                var $all = $wrapper.find(".m-list-item"), $item;
                for(var i = 0, max = $all.size(); i < max; i++){
                    $item = $all.eq(i);
                    if($item.attr("data-value") == val){
                        operation.setValue($item);
                        return;
                    }
                }
            });

            // input 聚焦
            $input.on("focus", function(){
                this.value = "";
                operation.textChange();
                operation.onBody();
            }).on("input propertychange", function(e){
                operation.textChange();
            }).on("keydown", function(e){
                // 上 38, 下 40， enter 13
                switch(e.keyCode){
                    case 38:
                        wrapper.prev();
                        break;
                    case 40:
                        wrapper.next();
                        break;
                    case 13:
                        operation.setValue(wrapper.$cur);
                        break;
                }
            });

            $div.on("click", ".m-input-ico", function(){
                // 触发 focus 和 blur 事件
                // focus 是因为 input 有绑定
                // 而 blur，实际只是失去焦点而已，真正隐藏 wrapper 的是 $body 事件
                $wrapper.is(":visible") ? $input.blur() : ($input.val("").trigger("focus"));
            });

            // 选中
            $wrapper.on("click", ".m-list-item", function(){
                operation.setValue($(this));
                return false;
            });

            setTimeout(function(){
                // for ie
                wrapper.hide();
            },1);


        });

        return this;
    };
})();
</script>
<script>
// 使用了这个插件，select该怎么用就怎么用
// 任何选择，同样会触发 select 的 更变的说【即select的值会同步更新】
//
var $select = $("select[data-edit-select]").filterSelect();
// --> 这时候的  $select === $("#magicsuggest");
// 也可以 用 $("#magicsuggest").on("change")，两者等价
$select.on("change", function(){
	
    // console.log(this.value)
});
// 也可以通过 $("#magicsuggest").val() 拿到最新的值
// 通过 $("#magicsuggest").trigger("setEditSelectValue", 2); 设置选中的值为 2
// 通过  $("#magicsuggest").trigger("optionChange"); 触发 更新 option 的值
</script>
  
  <!-- 
  <li ><a id="icbc6"  href="newicbcsh.do?icbc_type=7&id=418&querytype=&size=15&status=" >通融</a></li>
  <li ><a id="icbc6"  href="newicbcsh.do?icbc_type=8&id=418&querytype=&size=15&status=" >财务</a></li>	
  
  -->  
  
  
</div>
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
});
</script>		
</section>

			</div>