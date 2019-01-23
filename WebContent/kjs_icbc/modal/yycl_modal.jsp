<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
request.setCharacterEncoding("utf-8");
%>  
<style type="text/css">
.myself {background:black;color:white;width:80px; height: 30px;}
.max{width:100%,height:auto;}
</style>
<form name="modalForm" class="form-horizontal">
<script type="text/javascript">
function yycl_download(id,image_name){
	$("#yycl_form").remove();
	var objInput = document.getElementsByName("zx_imgstep_"+id);
	var image_data="";
	for (var i=0;i<objInput.length;i++) {  
		var src=objInput[i].src;
		image_data=image_data+src+",";
	}
    var form=$("<form id='yycl_form'>");//定义一个form表单
    form.attr("style","display:none");
    form.attr("target","");
    form.attr("method","post");
    form.attr("action","${pageContext.request.contextPath}/erp/download_lsjlimage.do");//请求url
    var input1=$("<input>");
    input1.attr("type","hidden");
    input1.attr("name","image_data");//设置属性的名字
    input1.attr("value",image_data);//设置属性的值

    var input3=$("<input>");
    input3.attr("type","hidden");
    input3.attr("name","image_name");//设置属性的名字
    input3.attr("value",image_name);//设置属性的值
    $("body").append(form);//将表单放置在web中
    form.append(input1);

    form.append(input3);
    form.submit();//表单提交       
              }

function  lsjjll(lx_id,icbc_id,status,type_id){
	var img_div = document.getElementById("imgs_yycl_div");
	 $(img_div).empty();
$.ajax({
    url:"${pageContext.request.contextPath}/erp/erp_icbc_lsjl.do",
    type:"post",
    data:{ 
    	lx_id:lx_id,
    	icbc_id: icbc_id, 
    	status: status,
    	type_id: type_id
    	} ,
    dataType: 'text',
    success:function(data){
    	//alert(data)
     if(data!=null){
    	 var data2 = eval(data);
    	 var n=0;
    	 var msg="";
    	 var msg1="";
    	 var msg3="";
    	 var n1=1;
    	 var n2=0;
    	 var lx_name="";
    	 //alert(data2.length);
    	 for(var i=0;i<data2.length;i++){
    		 
    		 n=parseInt(i)+parseInt(1);
    		 var arry;
    		 var str;
    		 if(lx_id==1){
    			 arry=data2[i].imgstep2_1ss;	 
    			 str=data2[i].img1;
    			 lx_name="主贷人材料";
    		 }
    		 if(lx_id==2){
    			 arry=data2[i].imgstep2_2ss;
    			 str=data2[i].img2;
    			 lx_name="主贷人配偶材料";
    		 }
    		 if(lx_id==3){
    			 arry=data2[i].imgstep2_3ss;	
    			 str=data2[i].img3;
    			 lx_name="共还人1材料";
    		 }
    		 if(lx_id==4){
    			 arry=data2[i].imgstep2_4ss;
    			 str=data2[i].img4;
    			 lx_name="共还人2材料";
    		 }
    		 if(lx_id==5){
    			 arry=data2[i].imgstep8_1ss;
    			 str=data2[i].img5;
    			 lx_name="征信通融材料";
    		 }
    		 if(lx_id==6){
    			 arry=data2[i].cars_icbc_imgs;
    			 lx_name="汽车评估材料";
    			 //alert(data2[i].cars_icbc_imgs+""+data2[i].img6);
    		 }
    		 if(lx_id==7){
    			 arry=data2[i].kk_list;
    			 lx_name="开卡申请材料";
    			 //alert(data2[i].cars_icbc_imgs+""+data2[i].img6);
    		 }
    		 if(lx_id==8){
    			 arry=data2[i].ht_lists;
    			 lx_name="合同材料";
    			 //alert(data2[i].cars_icbc_imgs+""+data2[i].img6);
    		 }
    		 if(lx_id==9){
    			 arry=data2[i].zm_lists;
    			 lx_name="合同材料";
    			 //alert(data2[i].cars_icbc_imgs+""+data2[i].img6);
    		 }
    		 if(lx_id==10){
    			 arry=data2[i].qt_lists;
    			 lx_name="合同材料";
    			 //alert(data2[i].cars_icbc_imgs+""+data2[i].img6);
    		 }
    		 if(lx_id==11){
    			 arry=data2[i].bc_lists;
    			 lx_name="合同材料";
    			 //alert(data2[i].cars_icbc_imgs+""+data2[i].img6);
    		 }
    		 var num=0;
    		 var msg2="";
				//alert("第"+i1+"次循环:"+num);
    		 //alert(arry.length+""+str.length);
			//assess/upload/2018/09/07/c16b52fa4474fb30fc1dbf4d95b8c05c.jpg----assess/upload/2018/09/07/510f801fa37c91c33b9dc57a05417929.jpg
					/* if(lx_id==6){
						for(var i1=0;i1<arry.length;i1++){
						if(arry[i1].bcimg!=null&&arry[i1].bcimg!=""){
							
				 msg2=msg2+"<div class='col-sm-3'><div class='thumbnail'><img class='zx_imgstep' id='' name='zx_imgstep_"+n1+"'  onclick='yycl_image(this)' style='width: 120px;height: 120px;' src='http://a.kcway.net/"+arry[i1].bcimg+"'>"
				 +" <a class='btn btn-primary btn-download' style='width:30px;height:30px;position:absolute;top:80px;left:90px;' href='${pageContext.request.contextPath}/erp/downloadOneFile.do?fileUrl=http://a.kcway.net/"+arry[i1].bcimg+"&fileName="+n1+"_"+i1+"'>↓</a>"
				 +"<a class='fileUpload_filename'>"+data2[i].dt_edit+"</a>"
				 +"</div></div>";

						
						}
						}
						if(msg2!=""){
							 msg1="<tr><td width='100'>"+lx_name+"第"+n1+"次补件<br><a onclick='yycl_download("+n1+",\""+lx_name+"第"+n1+"次补件\")' class='myself'>批量下载</a></td><td>";
				    		 msg3="</td>";
							 msg=msg+msg1+msg2+msg3;						 	
							 n1++;
						}
					}else  */
					if(lx_id==6||lx_id==7||lx_id==8||lx_id==9||lx_id==10||lx_id==11){
						for(var i1=0;i1<arry.length;i1++){
							if(arry[i1]!=null&&arry[i1]!=""){
					 msg2=msg2+"<div class='col-sm-3'><div class='thumbnail'><img class='zx_imgstep' id='' name='zx_imgstep_"+n1+"'  onclick='yycl_image(this)' style='width: 120px;height: 120px;' src='http://a.kcway.net/assess/"+arry[i1]+"'>"
					 +" <a class='btn btn-primary btn-download' style='width:30px;height:30px;position:absolute;top:80px;left:90px;' href='${pageContext.request.contextPath}/erp/downloadOneFile.do?fileUrl=http://a.kcway.net/assess/"+arry[i1]+"&fileName="+n1+"_"+i1+"'>↓</a>"
					 +"<a class='fileUpload_filename'>"+data2[i].dt_edit+"</a>"
					 +"</div></div>";

							}
							}
							if(msg2!=""){
								 msg1="<tr><td width='100'>"+lx_name+"第"+n1+"次补件<br><a onclick='yycl_download("+n1+",\""+lx_name+"第"+n1+"次补件\")' class='myself'>批量下载</a></td><td>";
					    		 msg3="</td>";
								 msg=msg+msg1+msg2+msg3;						 	
								 n1++;
							}
					}else{
						for(var i1=0;i1<arry.length;i1++){
						if(arry[i1]!=null&&arry[i1].length>0){

							if(str!=null&&str.length>0){
							for(var j=0;j<str.length;j++){
								if(str[j]!=null&&str[j].length>0){
									if(arry[i1]==str[j]){
										//alert(arry[i1]+"----"+str[j]);
										 num=1;
										 break;
									 }
								}
								}
							}
							/* else{
								 $(img_div).append("<div class='col-sm-6 col-md-3'><div class='thumbnail'>"
											+"<img class='zx_imgstep' id='' name=''  onclick='yycl_image(this)' style='width: 100px;height: 100px;' src='http://a.kcway.net/assess/"+arry[i1]+"'>"
											+"<div align='center'   class='caption'><p style='color: red;'>"
											+"第"+n+"次提交<br>"
						                    +data2[i].dt_edit+"</p>"
						                    +"</div></div></div>");	
						    } */
							
				if(num==0){
				 msg2=msg2+"<div class='col-sm-3'><div class='thumbnail'><img class='zx_imgstep' id='' name='zx_imgstep_"+n1+"'  onclick='yycl_image(this)' style='width: 120px;height: 120px;' src='http://a.kcway.net/assess/"+arry[i1]+"'>"
				 +" <a class='btn btn-primary btn-download' style='width:30px;height:30px;position:absolute;top:80px;left:90px;' href='${pageContext.request.contextPath}/erp/downloadOneFile.do?fileUrl=http://a.kcway.net/assess/"+arry[i1]+"&fileName="+n1+"_"+i1+"'>↓</a>"
				 +"<a class='fileUpload_filename'>"+data2[i].dt_edit+"</a>"
				 +"</div></div>";
				}
							/* else{
								$(img_div).append("<div class='col-sm-6 col-md-3'><div class='thumbnail'>"
										+"<img class='zx_imgstep' id='' name=''  onclick='yycl_image(this)' style='width: 100px;height: 100px;' src='http://a.kcway.net/assess/"+arry[i1]+"'>"
										+"<div align='center'  class='caption'><p>"
										+"第"+n+"次提交<br>"
					                    +data2[i].dt_edit+"</p>"
					                    +"</div></div></div>");	
							} */
													
						}
					}
						if(msg2!=""){
							 msg1="<tr><td width='100'>"+lx_name+"第"+n1+"次补件<br><a onclick='yycl_download("+n1+",\""+lx_name+"第"+n1+"次补件\")' class='myself'>批量下载</a></td><td>";
				    		 msg3="</td>";
							 msg=msg+msg1+msg2+msg3;						 	
							 n1++;
						}
					}
					
				} 		
	    		 
    	 $(img_div).append(msg);
     }
    }, 
    error:function(e){
     alert("错误！！");
    }
});
$('#imgs_yycl').modal('show');
}
$(document).ready(function(){
	$('#imgs_yyclModal').on('hide.bs.modal', function () {
	 if($('body').hasClass('modal-open')){

	}else{
		$('#imgs_yycl').modal('show');	
	}
	 });
	 });
function yycl_image(obj){
	$('#imgs_yycl').modal('hide');
	//alert(obj);
	if(obj!=0){
	var $img = $(obj),
		imgUrl = $img[0].src;
	}
	var activeIndex=0;
	var imgs = [];
	$(".zx_imgstep").each(function(i,elem){
		//alert(elem.src);
		if(obj!=0){
		if(elem.src == imgUrl){
			activeIndex=i;	
		}
		}
		imgs.push({
			url: elem.src, 
			imgHeight :'820',
			imgWidth : '1000'
		});
	});
localStorage["photoGalleryImgs"] = JSON.stringify(imgs); //因为此字符串可能是base64字符，appgo无法传
localStorage["photoGalleryActiveIndex"] = activeIndex;     
	   //给iframe加上src路径
   $("#yyclModal_iframe").attr("src","${pageContext.request.contextPath}/jquery-photo-gallery/gallerys.jsp");
    //显示模态框  只有在选择编辑的行   然后根据回调函数成功后才会显示模态框
   $('#imgs_yyclModal').modal({ show: true, backdrop: 'static' });
}
</script>
<!-- 模态框（Modal） -->
<div class="modal fade" id="imgs_yycl"  tabindex="-1" role="dialog" aria-labelledby="imgs_yyclLabel" aria-hidden="true" >
    <div class="modal-dialog" style="width: 900px;height: 800px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4  class="modal-title" id="imgs_yyclLabel">相关材料</h4>
            </div>
            <div  class="modal-body">
            <table class="table table-bordered table-hover"  >
            <tbody id="imgs_yycl_div">
            </tbody>
            </table>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<div class="modal fade" id="imgs_yyclModal" tabindex="-1" role="dialog" aria-labelledby="imgs_yyclModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" align="center" id="imgs_yyclModalLabel">图片预览</h4>
            </div>
            <div class="modal-body" style="height:750px;">
            <iframe id="yyclModal_iframe" width="100%" height="100%" frameborder="0"></iframe>
            (左右键控制上一张,下一张)
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<input style="display: none;">
<input style="display: none;">
<!-- <button class="btn btn-primary" ng-show="!rootData" ng-click="rootData={};rootData.editFlag='1'">人车分离审核申请</button> -->
<!-- <button class="btn btn-primary" ng-show="!rootData" ng-click="rootData={};rootData.editFlag='2'">人车合并贷款申请</button> -->
<!-- <div ng-show="rootData"> -->
<div  class="table-responsive">
 <table class="table table-bordered table-hover" id="tbl" >
 <tbody>
 <c:if test="${fn:contains(sessionScope.pd.purview_map,'yycl11')==true}">
 <tr>
 <td id="father_1_1">
 征信材料
<a href="${pageContext.request.contextPath}/erp/downloadFile_all.do?type=zx&id=${pd.id}&base_name=征信材料" class="myself">批量下载</a>
 </td>
 <td id="son_1_1">
 <table class="table table-bordered table-hover" id="tbl" >
 <tr>
 <td>主贷人材料
 <br>	
<c:if test="${!empty requestScope.zdr_imgss}">									
<a href="${pageContext.request.contextPath}/erp/downloadFile_all.do?type=zdr&id=${pd.id}&base_name=主贷人材料" class="myself">批量下载</a>
</c:if>
 </td>
 <td>
 <c:forEach var="bc"  items="${requestScope.zdr_imgss}" varStatus="status">
 <c:if test="${!empty bc}">
 <div class="col-sm-2">
 <img  id="" name="" onclick="yyclimage(this)" class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/${bc}">
 	<a class="btn btn-primary btn-download" style="width:30px;height:30px;position:absolute;top:50px;left:50px;" href="${pageContext.request.contextPath}/erp/downloadOneFile.do?fileUrl=http://a.kcway.net/assess/${bc}&fileName=${status.index+1}">↓</a>
	<a class="fileUpload_filename ng-binding" style="position:absolute;top:80px;left:15px;font-size:12px;" ><fmt:formatDate value="${requestScope.zx_dt_edit }" pattern="yyyy-MM-dd HH:mm"/></a>
</div>
 </c:if>
 </c:forEach>
 <c:if test="${!empty requestScope.zdr_imgss}">
  <div class="col-sm-2">
  <a onclick="lsjjll(1,${pd.id},2,1)" class="btn btn-primary ng-binding">补件历史</a>
  </div>
</c:if>  
 </td>
 </tr>

 <tr>
 <td>主贷人配偶材料
 <br>	
<c:if test="${!empty requestScope.zdrpo_imgss}">									
<a href="${pageContext.request.contextPath}/erp/downloadFile_all.do?type=zdrpo&id=${pd.id}&base_name=主贷人配偶材料" class="myself">批量下载</a>
</c:if>
<!--  <a href="${pageContext.request.contextPath}/downloadFile_all.do?type=icbc&id=${pd.id}" class="btn btn-primary ng-binding">批量下载</a>
 原来征信下载
-->
 </td>
 <td>
 <c:forEach var="bc"  items="${requestScope.zdrpo_imgss}" varStatus="status">
 <c:if test="${!empty bc}">
 <div class="col-sm-2">
 <img  id="" name="" onclick="yyclimage(this)" class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/${bc}">
 <a class="btn btn-primary btn-download" style="width:30px;height:30px;position:absolute;top:50px;left:50px;" href="${pageContext.request.contextPath}/erp/downloadOneFile.do?fileUrl=http://a.kcway.net/assess/${bc}&fileName=${status.index+1}">↓</a>
 <a class="fileUpload_filename ng-binding" style="position:absolute;top:80px;left:15px;font-size:12px;" ><fmt:formatDate value="${requestScope.zx_dt_edit }" pattern="yyyy-MM-dd HH:mm"/></a>
 </div>
 </c:if>
 </c:forEach>
 <c:if test="${!empty requestScope.zdrpo_imgss}">
   <div class="col-sm-2">
  <a onclick="lsjjll(2,${pd.id},2,1)" class="btn btn-primary ng-binding">补件历史</a>
  </div>
  </c:if>
 </td>
 </tr>
 <tr>
 <td>共还人1材料
 <br>	
<c:if test="${!empty requestScope.ghr1_imgss}">									
<a href="${pageContext.request.contextPath}/erp/downloadFile_all.do?type=ghr1&id=${pd.id}&base_name=共还人1材料" class="myself">批量下载</a>
</c:if>
<!--  <a href="${pageContext.request.contextPath}/downloadFile_all.do?type=icbc&id=${pd.id}" class="btn btn-primary ng-binding">批量下载</a>
 原来征信下载
-->
 </td>
 <td>
 <c:forEach var="bc"  items="${requestScope.ghr1_imgss}" varStatus="status">
 <c:if test="${!empty bc}">
 <div class="col-sm-2">
 <img  id="" name="" onclick="yyclimage(this)" class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/${bc}">
 <a class="btn btn-primary btn-download" style="width:30px;height:30px;position:absolute;top:50px;left:50px;" href="${pageContext.request.contextPath}/erp/downloadOneFile.do?fileUrl=http://a.kcway.net/assess/${bc}&fileName=${status.index+1}">↓</a>
 <a class="fileUpload_filename ng-binding" style="position:absolute;top:80px;left:15px;font-size:12px;" ><fmt:formatDate value="${requestScope.zx_dt_edit }" pattern="yyyy-MM-dd HH:mm"/></a>
 </div>
 </c:if>
 </c:forEach>
 <c:if test="${!empty requestScope.ghr1_imgss}">	
   <div class="col-sm-2">
  <a onclick="lsjjll(3,${pd.id},2,1)" class="btn btn-primary ng-binding">补件历史</a>
  </div>
 </c:if>
 </td>
 </tr>
 <tr>
 <td>共还人2材料
 <br>	
<c:if test="${!empty requestScope.ghr2_imgss}">									
<a href="${pageContext.request.contextPath}/erp/downloadFile_all.do?type=ghr2&id=${pd.id}&base_name=共还人2材料" class="myself">批量下载</a>
</c:if>
<!--  <a href="${pageContext.request.contextPath}/downloadFile_all.do?type=icbc&id=${pd.id}" class="btn btn-primary ng-binding">批量下载</a>
 原来征信下载
-->
 </td>
 <td>
 <c:forEach var="bc"  items="${requestScope.ghr2_imgss}" varStatus="status">
 <c:if test="${!empty bc}">
 <div class="col-sm-2">
 <img  id="" name="" onclick="yyclimage(this)" class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/${bc}">
 <a class="btn btn-primary btn-download" style="width:30px;height:30px;position:absolute;top:50px;left:50px;" href="${pageContext.request.contextPath}/erp/downloadOneFile.do?fileUrl=http://a.kcway.net/assess/${bc}&fileName=${status.index+1}">↓</a>
 <a class="fileUpload_filename ng-binding" style="position:absolute;top:80px;left:15px;font-size:12px;" ><fmt:formatDate value="${requestScope.zx_dt_edit }" pattern="yyyy-MM-dd HH:mm"/></a>
 </div>
 </c:if>
 </c:forEach>
 <c:if test="${!empty requestScope.ghr2_imgss}">	
   <div class="col-sm-2">
  <a onclick="lsjjll(4,${pd.id},2,1)" class="btn btn-primary ng-binding">补件历史</a>
  </div>
  </c:if>
 </td>
 </tr>
 </table>
</td>
</tr>
  </c:if>
  <c:if test="${fn:contains(sessionScope.pd.purview_map,'yycl2')==true}">
 <tr id="faSon_2">
 <td id="father_2">征信通融材料
 <br>
 <c:if test="${!empty requestScope.tr_imgs}">
 <a href="${pageContext.request.contextPath}/erp/downloadFile_all.do?type=zxtr&id=${pd.id}&base_name=征信通融材料" class="myself">批量下载</a>
 </c:if>
 </td>
 <td id="son_2">
 <c:forEach var="tr" items="${requestScope.tr_imgs}">
 <c:if test="${!empty tr }">
 <div class="col-sm-2">
 <img id="" name="" onclick="yyclimage(this)" class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/${tr }">
 <a class="btn btn-primary btn-download" style="width:30px;height:30px;position:absolute;top:50px;left:50px;" href="${pageContext.request.contextPath}/erp/downloadOneFile.do?fileUrl=http://a.kcway.net/assess/${tr}&fileName=${status.index+1}">↓</a>
 <a class="fileUpload_filename ng-binding" style="position:absolute;top:80px;left:15px;font-size:12px;" ><fmt:formatDate value="${requestScope.trzx_dt_edit }" pattern="yyyy-MM-dd HH:mm"/></a>
 </div>
 </c:if>
 </c:forEach>
  <c:if test="${!empty requestScope.tr_imgs}">
  <div class="col-sm-2">
  <a onclick="lsjjll(5,${pd.id},5,2)" class="btn btn-primary ng-binding">补件历史</a>
  </div>
</c:if> 
 </td>
 </tr>
 </c:if>
  <c:if test="${fn:contains(sessionScope.pd.purview_map,'yycl3')==true}">
   <tr id="faSon_3">
  <td id="father_3">汽车评估材料
 <br>
 <c:if test="${!empty requestScope.cars_imgs}">
 <a href="${pageContext.request.contextPath}/erp/downloadFile_all.do?type=clpg&id=${pd.id}&base_name=汽车评估材料" class="myself">批量下载</a>
 </c:if>
 </td>
 <td id="son_3">
 <c:forEach var="pg" items="${requestScope.cars_imgs}" varStatus="status">
 <c:if test="${!empty pg}">
 <div class="col-sm-2">
 <img id="" name="" onclick="yyclimage(this)"  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/${pg}">
 <a class="btn btn-primary btn-download" style="width:30px;height:30px;position:absolute;top:50px;left:50px;" href="${pageContext.request.contextPath}/erp/downloadOneFile.do?fileUrl=http://a.kcway.net/assess/${pg}&fileName=${status.index+1}">↓</a>
 <a class="fileUpload_filename ng-binding" style="position:absolute;top:80px;left:15px;font-size:12px;" ><fmt:formatDate value="${requestScope.qcpg_dt_edit }" pattern="yyyy-MM-dd HH:mm"/></a>
 </div>
 </c:if>
 </c:forEach>
   <c:if test="${!empty requestScope.cars_imgs}">
  <div class="col-sm-2">
  <a onclick="lsjjll(6,${pd.id},10,3)" class="btn btn-primary ng-binding">补件历史</a>
  </div>
</c:if>
  </td>
 </tr>
 </c:if>
  <c:if test="${fn:contains(sessionScope.pd.purview_map,'yycl4')==true}">
  <tr id="faSon_4">
  <td id="father_4">开卡申请材料
 <br>
 <c:if test="${!empty requestScope.kk_imgs}">
 <a href="${pageContext.request.contextPath}/erp/downloadFile_all.do?type=kk&id=${pd.id}&base_name=开卡申请材料" class="myself">批量下载</a>
 </c:if>
  </td>
  <td id="son_4">
  <c:forEach var="kk" items="${requestScope.kk_imgs}" varStatus="status">
  <c:if test="${!empty kk}">
  <div class="col-sm-2">
  <img id="" name="" onclick="yyclimage(this)" class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/${kk}">
 <a class="btn btn-primary btn-download" style="width:30px;height:30px;position:absolute;top:50px;left:50px;" href="${pageContext.request.contextPath}/erp/downloadOneFile.do?fileUrl=http://a.kcway.net/assess/${kk}&fileName=${status.index+1}">↓</a>
 <a class="fileUpload_filename ng-binding" style="position:absolute;top:80px;left:15px;font-size:12px;" ><fmt:formatDate value="${requestScope.kk_dt_edit }" pattern="yyyy-MM-dd HH:mm"/></a>
  </div>
  </c:if>
  </c:forEach>
  <c:if test="${!empty requestScope.kk_imgs}">
  <div class="col-sm-2">
  <a onclick="lsjjll(7,${pd.id},18,5)" class="btn btn-primary ng-binding">补件历史</a>
  </div>
</c:if>
  </td>
 </tr>
 </c:if>
  <c:if test="${fn:contains(sessionScope.pd.purview_map,'yycl5')==true}">
   <tr id="faSon_5">
  <td id="father_5">开卡申请PDF材料
	<c:if test="${!empty requestScope.KK_PDFs}">
	<a href="${pageContext.request.contextPath}/erp/downloadFile_all.do?type=kkPDF&id=${pd.id}&base_name=开卡申请PDF材料" class="myself">批量下载</a>
	</c:if>
  </td>
  <td id="son_5">
  <c:if test="${!empty pd.pdf}">
	  <div class="col-sm-2">
	  <a target="_blank" href="http://a.kcway.net/assess/${pd.pdf}">
	  <img id="" name=""  title="合同PDF" class="img-thumbnail"  style="width: 100px;height: 100px;" src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/images/301175241676158600.png">
	  <span style="color:#dd4b39;position:absolute;top:6px;left:30px;">已生成合同</span>
	  </a>
	  <a class="btn btn-primary btn-download" style="width:30px;height:30px;position:absolute;top:50px;left:50px;" href="${pageContext.request.contextPath}/erp/downloadOneFile.do?fileUrl=http://a.kcway.net/assess/${pd.pdf}&fileName=PDF合同">↓</a>
	  <a class="fileUpload_filename ng-binding" style="position:absolute;top:80px;left:15px;font-size:12px;">2018-07-18 16:56</a>
	  </div>
	  <%-- <div style="padding-top:14%;padding-left:5%;">
		<a class="badge bg-green" href="javascript:hzpdf('${pd.id}')" >重新生成合同</a>
	  </div> --%>
  </c:if>
  <c:if test="${!empty pd.pdfstep4_1}">
	  <div class="col-sm-2">
	  <a target="_blank" href="http://a.kcway.net/assess/${pd.pdfstep4_1}">
	  <img id="" name="" title="PDF文件" class="img-thumbnail"  style="width: 100px;height: 100px;" src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/images/301175241676158600.png">
	  <span style="color:#dd4b39;position:absolute;top:6px;left:30px;">已生成Excel</span>
	  </a>
	  <a class="btn btn-primary btn-download" style="width:30px;height:30px;position:absolute;top:50px;left:50px;" href="${pageContext.request.contextPath}/erp/downloadOneFile.do?fileUrl=http://a.kcway.net/assess/${pd.pdfstep4_1}&fileName=${status.index+2}">↓</a>
	  <a class="fileUpload_filename ng-binding" style="position:absolute;top:80px;left:15px;font-size:12px;" >2018-07-18 16:56</a>
	  </div>
	  <%-- <div style="padding-top:14%;padding-left:5%;">
		<a class="badge bg-green" href="javascript:addexcel('${pd.id}')" >重新生成Excel</a>
	  </div> --%>
  </c:if>
  </td>
 </tr>
 </c:if>
  <c:if test="${fn:contains(sessionScope.pd.purview_map,'yycl6')==true}">
    <tr id="faSon_6">
  <td id="father_6">视频材料
 <br>
<c:if test="${!empty requestScope.mq_videos}">
<a href="${pageContext.request.contextPath}/erp/downloadFile_all.do?type=sq&id=${pd.id}&base_name=视频材料" class="myself">批量下载</a>
</c:if>
  </td>
  <td id="son_6"> 
  <c:if test="${!empty pd.imgstep8_1v}">
  <div class="col-sm-2" style="margin:5px 5px">
  <video id="imgstep8_1v"  name="imgstep8_1v" width="200" height="200"  controls="controls">
  <source src="http://a.kcway.net/assess/${pd.imgstep8_1v}" />
  </video>
  <a class="btn btn-primary btn-download" style="width:30px;height:30px;position:absolute;top:50px;left:50px;" href="${pageContext.request.contextPath}/erp/downloadOneFile.do?fileUrl=http://a.kcway.net/assess/${pd.imgstep8_1v}&fileName=${status.index+1}">↓</a>
  <a class="fileUpload_filename ng-binding" style="position:absolute;top:80px;left:15px;font-size:12px;" >2018-07-18 16:56</a>
  </div>
  </c:if>
  
  <c:if test="${!empty pd.imgstep8_2v}">
  <div class="col-sm-2" style="margin:5px 5px">
  <video id="imgstep8_2v"  name="imgstep8_2v" width="200" height="200"  controls="controls">
  <source src="http://a.kcway.net/assess/${pd.imgstep8_2v}" />
  </video>
  <a class="btn btn-primary btn-download" style="width:30px;height:30px;position:absolute;top:50px;left:50px;" href="${pageContext.request.contextPath}/erp/downloadOneFile.do?fileUrl=http://a.kcway.net/assess/${pd.imgstep8_2v}&fileName=${status.index+2}">↓</a>
  <a class="fileUpload_filename ng-binding" style="position:absolute;top:80px;left:15px;font-size:12px;" >2018-07-18 16:56</a>
  </div>
  </c:if>
  
  <c:if test="${!empty pd.imgstep8_3v}" >
  <div class="col-sm-2" style="margin:5px 5px">
  <video id="imgstep8_3v"  name="imgstep8_3v" width="200" height="200"  controls="controls">
         <source src="http://a.kcway.net/assess/${pd.imgstep8_3v}" />
  </video>
  <a class="btn btn-primary btn-download" style="width:30px;height:30px;position:absolute;top:50px;left:50px;" href="${pageContext.request.contextPath}/erp/downloadOneFile.do?fileUrl=http://a.kcway.net/assess/${pd.imgstep8_3v}&fileName=${status.index+3}">↓</a>
  <a class="fileUpload_filename ng-binding" style="position:absolute;top:80px;left:15px;font-size:12px;" >2018-07-18 16:56</a>
  </div>
  </c:if>
  <c:if test="${!empty pd.imgstep8_4v}" >
  <div class="col-sm-2" style="margin:5px 5px">
  <video id="imgstep8_4v"  name="imgstep8_4v" width="200" height="200"  controls="controls">
  <source src="http://a.kcway.net/assess/${pd.imgstep8_4v}" />
  <a class="btn btn-primary btn-download" style="width:30px;height:30px;position:absolute;top:50px;left:50px;" href="${pageContext.request.contextPath}/erp/downloadOneFile.do?fileUrl=http://a.kcway.net/assess/${pd.imgstep8_4v}&fileName=${status.index+4}">↓</a>
  <a class="fileUpload_filename ng-binding" style="position:absolute;top:80px;left:15px;font-size:12px;" >2018-07-18 16:56</a>
  </video>
  </div>
  </c:if>
  </td>
 </tr>
 </c:if>
  <c:if test="${fn:contains(sessionScope.pd.purview_map,'yycl7')==true}">
  <tr id="faSon_7">
  <td id="father_7">合同材料
<br>
<c:if test="${!empty requestScope.qy_imgs}">
<a href="${pageContext.request.contextPath}/erp/downloadFile_all.do?type=qy&id=${pd.id}&base_name=签约材料" class="myself">批量下载</a>
</c:if>
  </td>
  <td id="son_7">
  <c:forEach var="qy" items="${requestScope.qy_imgs}" varStatus="status">
	  <c:if test="${!empty qy}">
	  <div class="col-sm-2">
	  <img id="" name="" onclick="yyclimage(this)"  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/${qy}">
	  <a class="btn btn-primary btn-download" style="width:30px;height:30px;position:absolute;top:50px;left:50px;" href="${pageContext.request.contextPath}/erp/downloadOneFile.do?fileUrl=http://a.kcway.net/assess/${qy}&fileName=${status.index+1}">↓</a>
	  <a class="fileUpload_filename ng-binding" style="position:absolute;top:80px;left:15px;font-size:12px;" ><fmt:formatDate value="${requestScope.qcdk_dt_edit }" pattern="yyyy-MM-dd HH:mm"/></a>
	  </div>
	  </c:if>
  </c:forEach>
    <c:if test="${!empty requestScope.qy_imgs}">
  <div class="col-sm-2">
  <a onclick="lsjjll(8,${pd.id},32,8)" class="btn btn-primary ng-binding">补件历史</a>
  </div>
</c:if>
  </td>
 </tr>
 </c:if>
  <c:if test="${fn:contains(sessionScope.pd.purview_map,'yycl8')==true}">
  <tr id="faSon_8">
  <td id="father_8">证明材料
<br>
<c:if test="${!empty requestScope.zm_imgs2}">
<a href="${pageContext.request.contextPath}/erp/downloadFile_all.do?type=zm&id=${pd.id}&base_name=证明材料" class="myself">批量下载</a>
</c:if>
  </td>
  <td id="son_8">
  <c:forEach var="zm" items="${requestScope.zm_imgs2 }" varStatus="status">
	  <c:if test="${!empty zm}">
	  <div class="col-sm-2">
	  <img id="" name=""  onclick="yyclimage(this)" class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/${zm }">
	  <a class="btn btn-primary btn-download" style="width:30px;height:30px;position:absolute;top:50px;left:50px;" href="${pageContext.request.contextPath}/erp/downloadOneFile.do?fileUrl=http://a.kcway.net/assess/${zm}&fileName=${status.index+1}">↓</a>
	  <a class="fileUpload_filename ng-binding" style="position:absolute;top:80px;left:15px;font-size:12px;" ><fmt:formatDate value="${requestScope.qcdk_dt_edit }" pattern="yyyy-MM-dd HH:mm"/></a>
	  </div>
	  </c:if>
  </c:forEach>
     <c:if test="${!empty requestScope.zm_imgs2}">
  <div class="col-sm-2">
  <a onclick="lsjjll(9,${pd.id},32,8)" class="btn btn-primary ng-binding">补件历史</a>
  </div>
</c:if>
  </td>
 </tr>
 </c:if>
  <c:if test="${fn:contains(sessionScope.pd.purview_map,'yycl9')==true}">
   <tr id="faSon_9">
  <td id="father_9">其他材料
  <br>
<c:if test="${!empty requestScope.qt_imgs3}">
<a href="${pageContext.request.contextPath}/erp/downloadFile_all.do?type=qt&id=${pd.id}&base_name=其他材料" class="myself">批量下载</a>
</c:if>
  </td>
  <td id="son_9">
  <c:forEach var="qt" items="${requestScope.qt_imgs3}" varStatus="status">
  <c:if test="${!empty qt }">
  <div class="col-sm-2">
  <img id="" name="" onclick="yyclimage(this)"  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/${qt}">
 <a class="btn btn-primary btn-download" style="width:30px;height:30px;position:absolute;top:50px;left:50px;" href="${pageContext.request.contextPath}/erp/downloadOneFile.do?fileUrl=http://a.kcway.net/assess/${qt}&fileName=${status.index+1}">↓</a>
<a class="fileUpload_filename ng-binding" style="position:absolute;top:80px;left:15px;font-size:12px;" ><fmt:formatDate value="${requestScope.qcdk_dt_edit }" pattern="yyyy-MM-dd HH:mm"/></a>
  </div>
  </c:if>
  </c:forEach>
       <c:if test="${!empty requestScope.qt_imgs3}">
  <div class="col-sm-2">
  <a onclick="lsjjll(10,${pd.id},32,8)" class="btn btn-primary ng-binding">补件历史</a>
  </div>
</c:if>
  </td>
 </tr>
 </c:if>
  <c:if test="${fn:contains(sessionScope.pd.purview_map,'yycl10')==true}">
   <tr id="faSon_10">
  <td id="father_10">补充材料
  <br>
<c:if test="${!empty requestScope.bc_imgs4}">
<a href="${pageContext.request.contextPath}/erp/downloadFile_all.do?type=bc&id=${pd.id}&base_name=补充材料" class="myself">批量下载</a>
</c:if> 
</td>
  <td id="son_10">
  <c:forEach var="bc" items="${requestScope.bc_imgs4}"  varStatus="status">
  <c:if test="${!empty bc}">
  <div class="col-sm-2">
  <img id="" name="" onclick="yyclimage(this)"  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/${bc }">
   <a class="btn btn-primary btn-download" style="width:30px;height:30px;position:absolute;top:50px;left:50px;" href="${pageContext.request.contextPath}/erp/downloadOneFile.do?fileUrl=http://a.kcway.net/assess/${bc}&fileName=${status.index+1}">↓</a>
   <a class="fileUpload_filename ng-binding" style="position:absolute;top:80px;left:15px;font-size:12px;" ><fmt:formatDate value="${requestScope.qcdk_dt_edit }" pattern="yyyy-MM-dd HH:mm"/></a>
  </div>
  </c:if>
  </c:forEach>
<c:if test="${!empty requestScope.bc_imgs4}">
  <div class="col-sm-2">
  <a onclick="lsjjll(11,${pd.id},32,8)" class="btn btn-primary ng-binding">补件历史</a>
  </div>
</c:if>
  </td>
 </tr>
 </c:if>
<!--   <tr>
  <td >营业执照</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
 <tr>
  <td >配偶身份证</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
  <tr>
  <td >共还人一套材料</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
   <tr>
  <td >担保人一套材料</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
  <tr>
  <td >汽车消费贷款担保申请表</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
   <tr>
  <td >公司内部调查报告</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
    <tr>
  <td >家访照片</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
     <tr>
  <td >车辆证明材料</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
  <tr>
  <td >车辆保单</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
  <tr>
  <td >购车发票</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
   <tr>
  <td >其他车辆相关材料</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
    <tr>
  <td >面签照片</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
     <tr>
  <td >面签视频</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
      <tr>
  <td >其他</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
  <tr>
  <td >电审音频/银行电审客户端视频</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
   <tr>
  <td >银行调查报告WORD版</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
  <tr>
  <td >银行大额调查报告、大额审批表</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
   <tr>
  <td >问答视频</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
   <tr>
  <td>面签资料WORD文档</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
    <tr>
  <td>垫资材料附件</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
    <tr>
  <td>已垫资凭证</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
  <tr>
  <td>提车照片</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
   <tr>
  <td>退单录音</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
    <tr>
  <td>视频面签（在线）</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td>
 </tr>
  <tr>
  <td>登记证书(抵押完成)</td>
  <td>
  <div class="col-sm-2">
  <img id="" name=""  class="img-thumbnail"  style="width: 100px;height: 100px;" src="http://a.kcway.net/assess/upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg">
  </div>
  </td> -->
 </tr>
 </tbody>
</table>
</div>
<script>+
//点击 材料 td 隐藏
$("#father_1_1").dblclick(function(){
   	if($("#son_1_1").is(":hidden")){$("#son_1_1").show();}else{$("#son_1_1").hide();}
})
$("#father_1_2").dblclick(function(){
   	if($("#son_1_2").is(":hidden")){$("#son_1_2").show();}else{$("#son_1_2").hide();}
})
$("#father_1_3").dblclick(function(){
   	if($("#son_1_3").is(":hidden")){$("#son_1_3").show();}else{$("#son_1_3").hide();}
})
$("#father_1_4").dblclick(function(){
   	if($("#son_1_4").is(":hidden")){$("#son_1_4").show();}else{$("#son_1_4").hide();}
})
$("#father_2").dblclick(function(){
	if($("#son_2").is(":hidden")){$("#son_2").show();}else{$("#son_2").hide();}
})
$("#father_3").dblclick(function(){
	if($("#son_3").is(":hidden")){$("#son_3").show();}else{$("#son_3").hide();}
})
$("#father_4").dblclick(function(){
	if($("#son_4").is(":hidden")){$("#son_4").show();}else{$("#son_4").hide();}
})
$("#father_5").dblclick(function(){
	if($("#son_5").is(":hidden")){$("#son_5").show();}else{$("#son_5").hide();}
})
$("#father_6").dblclick(function(){
	if($("#son_6").is(":hidden")){$("#son_6").show();}else{$("#son_6").hide();}
})
$("#father_7").dblclick(function(){
	if($("#son_7").is(":hidden")){$("#son_7").show();}else{$("#son_7").hide();}
})
$("#father_8").dblclick(function(){
	if($("#son_8").is(":hidden")){$("#son_8").show();}else{$("#son_8").hide();}
})
$("#father_9").dblclick(function(){
	if($("#son_9").is(":hidden")){$("#son_9").show();}else{$("#son_9").hide();}
})
$("#father_10").dblclick(function(){
	if($("#son_10").is(":hidden")){$("#son_10").show();}else{$("#son_10").hide();}
})


// 点击 "行" 图片隐藏
/* $("#faSon_1").dblclick(function(){
	if($("#son_1").is(":hidden")){$("#son_1").show();}else{$("#son_1").hide();}
})
$("#faSon_2").dblclick(function(){
	if($("#son_2").is(":hidden")){$("#son_2").show();}else{$("#son_2").hide();}
})
$("#faSon_3").dblclick(function(){
	if($("#son_3").is(":hidden")){$("#son_3").show();}else{$("#son_3").hide();}
})
$("#faSon_4").dblclick(function(){
	if($("#son_4").is(":hidden")){$("#son_4").show();}else{$("#son_4").hide();}
})
$("#faSon_5").dblclick(function(){
	if($("#son_5").is(":hidden")){$("#son_5").show();}else{$("#son_5").hide();}
})
$("#faSon_6").dblclick(function(){
	if($("#son_6").is(":hidden")){$("#son_6").show();}else{$("#son_6").hide();}
})
$("#faSon_7").dblclick(function(){
	if($("#son_7").is(":hidden")){$("#son_7").show();}else{$("#son_7").hide();}
})
$("#faSon_8").dblclick(function(){
	if($("#son_8").is(":hidden")){$("#son_8").show();}else{$("#son_8").hide();}
})
$("#faSon_9").dblclick(function(){
	if($("#son_9").is(":hidden")){$("#son_9").show();}else{$("#son_9").hide();}
})
$("#faSon_10").dblclick(function(){
	if($("#son_10").is(":hidden")){$("#son_10").show();}else{$("#son_10").hide();}
}) */


//双击照片所在的td,全部照片隐藏
/* $("#son_1").dblclick(function(){selectHide();})
$("#son_2").dblclick(function(){selectHide();})
$("#son_3").dblclick(function(){selectHide();})
$("#son_4").dblclick(function(){selectHide();})
$("#son_5").dblclick(function(){selectHide();})
$("#son_6").dblclick(function(){selectHide();})
$("#son_7").dblclick(function(){selectHide();})
$("#son_8").dblclick(function(){selectHide();})
$("#son_9").dblclick(function(){selectHide();})
$("#son_10").dblclick(function(){selectHide();})
function selectHide(){
    $("#son_1").hide();
	$("#son_2").hide();
	$("#son_3").hide();
	$("#son_4").hide();
	$("#son_5").hide();
	$("#son_6").hide();
	$("#son_7").hide();
	$("#son_8").hide();
	$("#son_9").hide();
	$("#son_10").hide(); 
} */
//点击查看图片
function yyclimage(obj){
	//alert(obj);
	if(obj!=0){
	var $img = $(obj),
		imgUrl = $img[0].src;
	}
	var activeIndex=0;
	var imgs = [];
	$(".img-thumbnail").each(function(i,elem){
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
    $("#yyclModal_iframe1").attr("src","${pageContext.request.contextPath}/jquery-photo-gallery/gallerys.jsp");
     //显示模态框  只有在选择编辑的行   然后根据回调函数成功后才会显示模态框
    $('#yyclModal1').modal({ show: true, backdrop: 'static'});
}

// 按键盘左上角  ESC 关闭照片查看模态框
/* if(event.keyCode==27 && $("#yyclModal").is(":hidden")){
	$("#yyclModal").hide();
} */

//重新生成合同
function hzpdf(id) {
	  $.ajax({
		   type:'POST',   
		   url:'${pageContext.request.contextPath}/icbc/ptreating.do',
		   dataType:'json',
		   data:{
			   id : id
		   },
	  success: function(msg){
		 if(msg.code==1){
			alert("合同生成成功!");
			window.location.reload();
		 }else{
			alert("合同生成失败;"+msg.message); 
		 } 		  
		},
		error:function(){
		   alert("系统错误,请稍后重试...");         
		}
	  });
   }
//重新生成Excel
function addexcel(id) {
	  $.ajax({
		   type:'POST',   
		   url:'${pageContext.request.contextPath}/icbc/excel.do',
		   dataType:'json',
		   data:{
			   id : id
		   },
	  success: function(msg){
		 if(msg.code==1){
			alert("Excel生成成功!");
			window.location.reload();
		 }else{
			alert("Excel生成失败;"+msg.message); 
		 } 		  
		},
	error:function(){
	   alert("系统错误,请稍后重试...");         
	}
	  });
 }

function waitDownload(){
	var wait = "请稍候";
	alert(wait);
	var second = 7;
	var time = setInterval(function(){
	    if(second>0){
	        second--;
	    }else{
	        clearInterval(time);
	    }
	},1000);
}

</script>
<div class="modal fade" id="yyclModal1" tabindex="-1" role="dialog" aria-labelledby="yyclModal1Label" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" align="center" id="yyclModal1Label">图片预览</h4>
            </div>
            <div class="modal-body" style="height:750px;">
            <iframe id="yyclModal_iframe1" width="100%" height="100%" frameborder="0"></iframe>
            (左右键控制上一张,下一张)
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</form>
<c:if test="${requestScope.type!='wdrw'}">
<div class="modal-footer">
<button onclick="location.href='${pageContext.request.contextPath}/erp/user_list_.do?type=wlghd&dn=${requestScope.cn }&qn=list&pagesize=10&pagenow=1'" class="btn btn-warning" >取消</button>
<button onclick="location.href=''" class="btn btn-primary" >提交</button>
</div>
</c:if>
			
