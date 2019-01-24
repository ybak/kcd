<%@page import="com.itextpdf.text.log.SysoCounter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style type="text/css">
/* 所有class为menu的div中的ul中的li样式 */
.licolor{
  color:#7a7a7a;
  background:#f5f5f5;
}
.liclass{
background-color:#3c8dbc;
color: #ffffff;
}
</style>

<script type="text/javascript">
$(document).ready(function(){
  var type=document.getElementById("colortype").value;
  if(type!=''&&type!=4){
	  var colors=document.getElementById("yw"+type);
	  colors.style.backgroundColor="#337ab7";
  }
  });
  /*获取当前要操作状态  */
/*   
  var erp_status=document.getElementById("erp_status").value;
  
  $.post("${pageContext.request.contextPath }/erp/ywlxstatus.do",
			{status:erp_status},
			function(result){
				document.getElementById("jdname1").text=result.name; 
				
	    },'json');
  
}); */
</script>
<div class="content-wrapper fixed-footer" style="min-height: 943px;">
<section class="content">
<div class="admin-content nav-tabs-custom box">
 
<ul id="myTab" class="nav nav-tabs">
      
    <c:if test="${requestScope.cn1 eq '3' }">      
     <li class="active">
		<a href="#jdname" data-toggle="tab">任务处理</a>
	 </li>
	 </c:if>
	<c:if  test="${fn:contains(sessionScope.pd.purview_map,'clgc')==true}">
	<c:choose>
	<c:when test="${requestScope.cn1 eq '3' }">
	<li >
		<a href="#clgc" data-toggle="tab">处理过程</a>
	</li>
	</c:when>
	<c:otherwise>
	<li class="active">
		<a href="#clgc" data-toggle="tab">处理过程</a>
	</li>
	</c:otherwise>
	</c:choose>
	</c:if>
	<c:if  test="${fn:contains(sessionScope.pd.purview_map,'sfmx')==true}">
	<li>
		<a href="#jcxx" data-toggle="tab">基础信息</a>
	</li>
	</c:if>
	<c:if  test="${fn:contains(sessionScope.pd.purview_map,'khgl')==true}">
	<li><a href="#khgl" data-toggle="tab">客户管理</a></li>
	</c:if>
	<c:if  test="${fn:contains(sessionScope.pd.purview_map,'dkgl')==true}">
	<li><a href="#dkgl" data-toggle="tab">贷款管理</a></li>
	
	</c:if>
	<c:if  test="${fn:contains(sessionScope.pd.purview_map,'clxx')==true}">
	<li>
		<a href="#clxx" data-toggle="tab">车辆信息</a>
	</li>
	</c:if>
	<c:if  test="${fn:contains(sessionScope.pd.purview_map,'zzsc')==true}">
	<li>
		<a href="#zzsc" data-toggle="tab">资质审查</a>
	</li>
	</c:if>
	<c:if  test="${fn:contains(sessionScope.pd.purview_map,'yycl')==true}">
	<li>
		<a href="#yycl" data-toggle="tab">影音材料</a>
	</li>
	</c:if>
	<c:if  test="${fn:contains(sessionScope.pd.purview_map,'sfmx')==true}">
	<li>
		<a href="#sfmx" data-toggle="tab">收费明细</a>
	</li>
	</c:if>
	
</ul>
<div id="myTabContent" class="tab-content">
    <c:if test="${requestScope.cn1 eq '3' }"> 
    <div class="tab-pane fade active in" id="jdname">
    
     <c:if test="${requestScope.type_id eq '1' }">
    <jsp:include page="/kjs_icbc/model_son/zx/zx_${requestScope.erp_status }.jsp"></jsp:include>
    </c:if>
    <c:if test="${requestScope.type_id eq '2' }">
    <jsp:include page="/kjs_icbc/model_son/zxtr/zxtr_${requestScope.erp_status }.jsp"></jsp:include>
    </c:if>
    <c:if test="${requestScope.type_id eq '3' }">
    <jsp:include page="/kjs_icbc/model_son/clpg/clpg_${requestScope.erp_status}.jsp"></jsp:include>
    </c:if>
    <c:if test="${requestScope.type_id eq '4' }">
    <jsp:include page="/kjs_icbc/model_son/yhds/yhds_${requestScope.erp_status}.jsp"></jsp:include>
    </c:if>
    <c:if test="${requestScope.type_id eq '5' }">
    <jsp:include page="/kjs_icbc/model_son/kksq/kksq_${requestScope.erp_status}.jsp"></jsp:include>
    </c:if>
    <c:if test="${requestScope.type_id eq '6' }">
    <jsp:include page="/kjs_icbc/model_son/sqmq/sqmq_${requestScope.erp_status}.jsp"></jsp:include>
    </c:if>
    <c:if test="${requestScope.type_id eq '7' }">
    <jsp:include page="/kjs_icbc/model_son/kqysp/kqysp_${requestScope.erp_status}.jsp"></jsp:include>
    </c:if>
    <c:if test="${requestScope.type_id eq '8' }">
    <jsp:include page="/kjs_icbc/model_son/qcdk/qcdk_${requestScope.erp_status}.jsp"></jsp:include>
    </c:if>
    <c:if test="${requestScope.type_id eq '9' }">
    <jsp:include page="/kjs_icbc/model_son/nstr/nstr_${requestScope.erp_status}.jsp"></jsp:include>
    </c:if>
    <c:if test="${requestScope.type_id eq '10' }">
    <jsp:include page="/kjs_icbc/model_son/zjfp_XX2/zjfp_${requestScope.erp_status}.jsp"></jsp:include>
    </c:if>
    <c:if test="${requestScope.type_id eq '11' }">
    <jsp:include page="/kjs_icbc/model_son/yhdksq/yhdksq_${requestScope.erp_status}.jsp"></jsp:include>
    </c:if>
    <c:if test="${requestScope.type_id eq '12' }">
    <jsp:include page="/kjs_icbc/model_son/gsgd/gsgd_${requestScope.erp_status}.jsp"></jsp:include>
    </c:if>
    <c:if test="${requestScope.type_id eq '13' }">
    <jsp:include page="/kjs_icbc/model_son/dygd/dygd_${requestScope.erp_status}.jsp"></jsp:include>
    </c:if>
    <c:if test="${requestScope.type_id eq '14' }">
    <jsp:include page="/kjs_icbc/model_son/ywxxxg/ywxxxg_${requestScope.erp_status}.jsp"></jsp:include>
    </c:if>
    <c:if test="${requestScope.type_id eq '15' }">
    <jsp:include page="/kjs_icbc/model_son/tdtf/tdtf_${requestScope.erp_status}.jsp"></jsp:include>
	</c:if>
    <c:if test="${requestScope.type_id eq '16' }">
    <jsp:include page="/kjs_icbc/model_son/rz/rz_${requestScope.erp_status}.jsp"></jsp:include>
	</c:if>
    </div>
    </c:if>
<%-- <a style="margin-bottom: 20px;"  class="btn btn-mini btn-primary">${yw.name }</a>
	 <span><i class="fa fa-long-arrow-right"></i></span> --%>
     <c:choose>
     <c:when test="${requestScope.cn1 eq '3' }">
	 <div class="tab-pane fade" id="clgc">
     </c:when>
     <c:otherwise>
     <div class="tab-pane fade active in" id="clgc">
     </c:otherwise>
     </c:choose>
	<input type="hidden" value="${requestScope.type_id}" id="colortype" name="colortype"/>
	<div style="border:1px solid #478FCA;   margin:5px; padding:20px;border-radius: 10px;">
	 
<ul id="yw" class="nav nav-tabs" >
     <c:if  test="${fn:contains(sessionScope.pd.purview_map,'zxcx')==true}">
	 <li ${requestScope.type_id eq '1'?"class='active'":''} >
	 <c:if test="${requestScope.erp1 eq '1' }">
	 <a id="yw1" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wdrw&dn=wdrw&qn=form&cn=${requestScope.cn }&icbc_id=${requestScope.icbc_id }&type_id=1&cn1=${requestScope.cn1}&yw_id=${requestScope.yw_id}">征信查询</a>
	 </c:if>
	 <c:if test="${requestScope.erp1 eq '0' }">
	 <a href="javascript:void(0);"  disabled="disabled" class="btn btn-mini licolor">征信查询</a>
	</c:if>
     </li>
     
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     </c:if>
     <c:if  test="${fn:contains(sessionScope.pd.purview_map,'zxtr')==true}">
     <li ${requestScope.type_id eq '2'?"class='active'":''}>
     <c:if test="${requestScope.erp2 eq '1'}">
	 <a id="yw2" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wdrw&dn=wdrw&qn=form&cn=${requestScope.cn }&icbc_id=${requestScope.icbc_id }&type_id=2&cn1=${requestScope.cn1}&yw_id=${requestScope.yw_id}"  >征信通融</a>
	 </c:if>
	 <c:if test="${requestScope.erp2 eq '0'}">
	 <a href="" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">征信通融</a>
	 </c:if>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     </c:if>
     <c:if  test="${fn:contains(sessionScope.pd.purview_map,'clpg')==true}">
     <li ${requestScope.type_id eq '3'?"class='active'":''}>
     <c:if test="${requestScope.erp3 eq '1'}">
	 <a id="yw3" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wdrw&dn=wdrw&qn=form&cn=${requestScope.cn }&icbc_id=${requestScope.icbc_id }&type_id=3&cn1=${requestScope.cn1}&yw_id=${requestScope.yw_id}"  >车辆评估</a>
	 </c:if>
	 <c:if test="${requestScope.erp3 eq '0'}">
	 <a href="" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">车辆评估</a>
	 </c:if>
	 </li>
  
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     </c:if>
     <%--   
     <c:if  test="${fn:contains(sessionScope.pd.purview_map,'yhds')==true}">
     <li ${requestScope.type_id eq '4'?"class='active'":''}>
     <c:if test="${requestScope.erp4 eq '1'}">
	 <a id="yw4" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wdrw&dn=wdrw&qn=form&cn=${requestScope.cn }&icbc_id=${requestScope.icbc_id }&type_id=4&cn1=${requestScope.cn1}&yw_id=${requestScope.yw_id}"  >银行电审</a>
	 </c:if>
	 <c:if test="${requestScope.erp4 eq '0'}">
	 <a href="" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">银行电审</a> 
	 </c:if>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     </c:if>
      --%>
     <c:if  test="${fn:contains(sessionScope.pd.purview_map,'kksq')==true}">
     <li ${requestScope.type_id eq '5'?"class='active'":''}>
     <c:if test="${requestScope.erp5 eq '1'}">
	 <a id="yw5" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wdrw&dn=wdrw&qn=form&cn=${requestScope.cn }&icbc_id=${requestScope.icbc_id }&type_id=5&cn1=${requestScope.cn1}&yw_id=${requestScope.yw_id}" >开卡申请</a>
	 </c:if>
	 <c:if test="${requestScope.erp5 eq '0'}">
	 <a href="" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">开卡申请</a>
     </c:if>
	 </li>
	 
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     </c:if>
     <c:if  test="${fn:contains(sessionScope.pd.purview_map,'spmq')==true}">
     <li ${requestScope.type_id eq '6'?"class='active'":''}>
     <c:if test="${requestScope.erp6 eq '1'}">
	 <a id="yw6" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wdrw&dn=wdrw&qn=form&cn=${requestScope.cn }&icbc_id=${requestScope.icbc_id }&type_id=6&cn1=${requestScope.cn1}&yw_id=${requestScope.yw_id}" >视频面签</a>
	 </c:if>
	 <c:if test="${requestScope.erp6 eq '0'}">
	 <a href="" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">视频面签</a>
	 </c:if>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     </c:if>
     

     
     
     <c:if  test="${fn:contains(sessionScope.pd.purview_map,'qcdksh')==true}">
     <li ${requestScope.type_id eq '8'?"class='active'":''}>
     <c:if test="${requestScope.erp8 eq '1'}">
	 <a id="yw8" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wdrw&dn=wdrw&qn=form&cn=${requestScope.cn }&icbc_id=${requestScope.icbc_id }&type_id=8&cn1=${requestScope.cn1}&yw_id=${requestScope.yw_id}" >贷款申请</a>
	 </c:if>
	 <c:if test="${requestScope.erp8 eq '0'}">
	 <a href="" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">贷款申请</a>
	 </c:if>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     </c:if>
     <c:if  test="${fn:contains(sessionScope.pd.purview_map,'nstr')==true}">
     <li ${requestScope.type_id eq '9'?"class='active'":''}>
	 <c:if test="${requestScope.erp9 eq '1'}">
	 <a id="yw9" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wdrw&dn=wdrw&qn=form&cn=${requestScope.cn }&icbc_id=${requestScope.icbc_id }&type_id=9&cn1=${requestScope.cn1}&yw_id=${requestScope.yw_id}" >内审通融</a>
	 </c:if>
	 <c:if test="${requestScope.erp9 eq '0'}">
	 <a id="yw9" class="btn btn-mini licolor" onclick="addOther(9,${sessionScope.pd.id},${pd.id})" href="#" >内审通融</a>
	 </c:if>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     </c:if>
     <c:if  test="${fn:contains(sessionScope.pd.purview_map,'zjfp')==true}">
     <li ${requestScope.type_id eq '10'?"class='active'":''}>
	  <c:if test="${requestScope.erp10 eq '1'}">
	  <a id="yw10" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wdrw&dn=wdrw&qn=form&cn=${requestScope.cn }&icbc_id=${requestScope.icbc_id }&type_id=10&cn1=${requestScope.cn1}&yw_id=${requestScope.yw_id}" >资金分配</a>
	  </c:if>
	  <c:if test="${requestScope.erp10 eq '0'}">
	  <a href="#yw10" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">资金分配</a>
	  </c:if>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     </c:if>
     
     <c:if  test="${fn:contains(sessionScope.pd.purview_map,'financing')==true}">
     <li ${requestScope.type_id eq '16'?"class='active'":''}>
	 <c:if test="${requestScope.erp16 eq '1'}">
	 <a id="yw16" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wdrw&dn=wdrw&qn=form&cn=${requestScope.cn }&icbc_id=${requestScope.icbc_id }&type_id=16&cn1=${requestScope.cn1}&yw_id=${requestScope.yw_id}" >融资</a>
	 </c:if>
	 <c:if test="${requestScope.erp16 eq '0'}">
	 <a id="yw16" class="btn btn-mini licolor" data-toggle="tab" disabled="disabled" >融资</a>
	 </c:if>
	 </li>
	 <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     </c:if>
     
     <c:if  test="${fn:contains(sessionScope.pd.purview_map,'yhdksq')==true}">
     <li ${requestScope.type_id eq '11'?"class='active'":''}>
     <c:if test="${requestScope.erp11 eq '1'}">
	 <a id="yw11" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wdrw&dn=wdrw&qn=form&cn=${requestScope.cn }&icbc_id=${requestScope.icbc_id }&type_id=11&cn1=${requestScope.cn1}&yw_id=${requestScope.yw_id}" >银行审批</a>
	 </c:if>
	 <c:if test="${requestScope.erp11 eq '0'}">
	 <a href="#yw11" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">银行审批</a>
	 </c:if>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     </c:if>
     <c:if  test="${fn:contains(sessionScope.pd.purview_map,'gsgd')==true}">
     <li ${requestScope.type_id eq '12'?"class='active'":''}>
	  <c:if test="${requestScope.erp12 eq '1'}">
	  <a id="yw12" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wdrw&dn=wdrw&qn=form&cn=${requestScope.cn }&icbc_id=${requestScope.icbc_id }&type_id=12&cn1=${requestScope.cn1}&yw_id=${requestScope.yw_id}" >公司归档</a>
	  </c:if>
	  <c:if test="${requestScope.erp12 eq '0'}">
	  <a href="#yw12" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">公司归档</a> 
	  </c:if>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     </c:if>
     <c:if  test="${fn:contains(sessionScope.pd.purview_map,'dygd')==true}">
     <li ${requestScope.type_id eq '13'?"class='active'":''}>
	  <c:if test="${requestScope.erp13 eq '1'}">
	 <a id="yw13" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wdrw&dn=wdrw&qn=form&cn=${requestScope.cn }&icbc_id=${requestScope.icbc_id }&type_id=13&cn1=${requestScope.cn1}&yw_id=${requestScope.yw_id}" >抵押归档</a>
	 </c:if>
	  <c:if test="${requestScope.erp13 eq '0'}">
	 <a href="#yw13" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">抵押归档</a>
	  </c:if>
	 </li>
      <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-arrows-h"></i></li>
     </c:if>
     
     <c:if  test="${fn:contains(sessionScope.pd.purview_map,'kqyywsp')==true}">
     <li ${requestScope.type_id eq '7'?"class='active'":''}>
     <c:if test="${requestScope.erp7 eq '1'}">
	 <a id="yw7" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wdrw&dn=wdrw&qn=form&cn=${requestScope.cn }&icbc_id=${requestScope.icbc_id }&type_id=7&cn1=${requestScope.cn1}&yw_id=${requestScope.yw_id}" >跨区域业务审批</a>
	 </c:if>
	 <c:if test="${requestScope.erp7 eq '0'}">
	 <a id="yw7" class="btn btn-mini licolor" onclick="addOther(7,${sessionScope.pd.id},${pd.id})" href="#" >跨区域业务审批</a>
	 </c:if>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-arrows-h"></i></li>
     </c:if>
     
     <c:if  test="${fn:contains(sessionScope.pd.purview_map,'ywxxxg')==true}">
     <li ${requestScope.type_id eq '14'?"class='active'":''}>
	 <c:if test="${requestScope.erp14 eq '1'}">
	 <a id="yw14" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wdrw&dn=wdrw&qn=form&cn=${requestScope.cn }&icbc_id=${requestScope.icbc_id }&type_id=14&cn1=${requestScope.cn1}&yw_id=${requestScope.yw_id}" >业务信息修改</a>
	 </c:if>
	 <c:if test="${requestScope.erp14 eq '0'}">
	 <a id="yw14" class="btn btn-mini licolor" onclick="addOther(14,${sessionScope.pd.id},${pd.id})" href="#" >业务信息修改</a>
	 </c:if>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-arrows-h"></i></li>
     </c:if>
     <c:if  test="${fn:contains(sessionScope.pd.purview_map,'tdtf')==true}">
     <li ${requestScope.type_id eq '15'?"class='active'":''}>
	 <c:if test="${requestScope.erp15s eq '1'}">
	 <a id="yw15" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wdrw&dn=wdrw&qn=form&cn=${requestScope.cn }&icbc_id=${requestScope.icbc_id }&type_id=15&cn1=${requestScope.cn1}&yw_id=${requestScope.yw_id}" >退单退费</a>
	 </c:if>
	 <c:if test="${requestScope.erp15s eq '0'}">
	 <a id="yw15" class="btn btn-mini licolor" onclick="addOther(15,${sessionScope.pd.id},${pd.id})" href="#" >退单退费</a>
	 </c:if>
	 </li>
	 </c:if>

	</ul>
	</div>
<!-- 选择开始 -->
	<script type="text/javascript">
		function addOther(type_id,adminid,icbc_id){
    	     //显示模态框  只有在选择编辑的行   然后根据addModal_four
    	     if(type_id == 9){  // 内审通融
	    	    $('#addModal_nstr').modal({ show: true, backdrop: 'static' });
    	     }else if(type_id == 7){  // 跨区域审批
    	    	$('#addModal_kqysp').modal({ show: true, backdrop: 'static' });
 			 }else if(type_id == 14){ // 业务信息修改
 				$('#addModal_ywxxxg').modal({ show: true, backdrop: 'static' });
 			 }else if(type_id == 15){ // 退单退费
 				$('#addModal_tdtf').modal({ show: true, backdrop: 'static' });
 			 }
		}	
	</script>
	<!-- 内审通融审核  点击添加   start-->
	<div class="modal fade" id="addModal_nstr" tabindex="-1" role="dialog" aria-labelledby="addModal_nstrLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title" align="center" id="aayyclModalLabel">内审通融申请</h4>
	            </div>
	            <div class="modal-body" style="height:450px;">
	             <!-- 模态框插入内容 start -->
						<li class="text-primary">
						<h4>合作商总经理申请通融</h4>
						<div class="big-conte_">  
						<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
						<form id="nstrsh_42" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
							    <input type="hidden" name="adminid" value="${sessionScope.pd.id}">
								<input type="hidden" name="type_id" value="9"> 
								<input type="hidden" name="icbc_id" value="${pd.id}"> 
						    <div class="form-group">
								<label class="col-sm-2 control-label">关联客户</label>
								<div class="col-sm-3">
								    <input value="${pd.c_name}" id="" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
						        </div>
						         <label class="col-sm-2 control-label">业务编号</label>
								<div class="col-sm-3">
									<input value="${pd.gems_code}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
								</div>
							</div>
							
							<div class="form-group">
								<label class="col-sm-2 control-label">通融说明</label>
								<div class="col-sm-8">
									<textarea name="result_1_msg" id="result_1_msg" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text"></textarea>
								</div>
							</div>
							<div class="form-group">
								<!-- ngIf: !notUseButton -->
								<div style="overflow: hidden;margin-left: 7%">
								     <!-- ngRepeat: img in task.filepathlist -->
								</div>
							</div>
							<!-- 根据action确定操作  -->
						<!-- ngIf: !notUseButton -->
						<div class="modal-footer">
							<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
							<a onclick="erp_nstrsh_42(9,${sessionScope.pd.id},${pd.id})"  class="btn btn-primary" >提交</a>	
						</div>
						</form>
						<script type="text/javascript">
							function erp_nstrsh_42(type_id,adminid,icbc_id){
									//内审通融申请
									var form = new FormData(document.getElementById("nstrsh_42"));
									$.ajax({
									       url:"${pageContext.request.contextPath}/erp/erp_nstrsh_42.do",
									       type:"post",
									       data:form,
									       processData:false,
									       contentType:false,	
									       success:function(data){
									        alert("提交成功!");
									        //location.reload();
									      	//window.location.reload(true)   //强刷  从服务器加载
									        window.location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }';
									       },	
									       error:function(e){
									        alert("错误！！");
									       }
									});
							}
						</script>
						</div>                                             
						</div>											  	
						</li>
	           	 <!-- 模态框插入内容 end -->
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div>
	    </div>
	</div>
	<!-- 内审通融审核  点击添加   end-->
	<!-- 跨区域业务审批 start -->
	<div class="modal fade" id="addModal_kqysp" tabindex="-1" role="dialog" aria-labelledby="addModal_nstrLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title" align="center" id="aayyclModalLabel">跨区域业务申请</h4>
	            </div>
	            <div class="modal-body" style="height:450px;">
	             <!-- 模态框插入内容 start -->
						<li class="text-primary">
						<em>跨区域业务申请</em>
						<div class="big-conte_">  
						<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
						<form id="kqyspsh_98" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
							    <input type="hidden" name="adminid" value="${sessionScope.pd.id}">
								<input type="hidden" name="type_id" value="7"> 
								<input type="hidden" name="icbc_id" value="${pd.id}"> 
							 <div class="form-group ng-scope">
								<label class="col-sm-2 control-label">申请上牌地</label>
								<div class="col-sm-8">
									<input name="kqyspsh_98_sqspd"  type="text" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required">
								</div>
							 </div>	
						    <!-- <div class="form-group">
						        <label class="col-sm-2 control-label">申请上牌地<i class="red">*</i>：</label>
						        <div class="col-sm-3">
						            <select class="form-control ng-isolate-scope ng-not-empty ng-valid ng-valid-required" id="provinceCode" >
						            <option value="" class="ng-binding" selected="selected">--请选择--</option><option label="北京市" value="number:11">北京市</option><option label="天津市" value="number:12">天津市</option><option label="河北省" value="number:13">河北省</option><option label="山西" value="number:14">山西</option><option label="内蒙古自治区" value="number:15">内蒙古自治区</option><option label="辽宁省" value="number:21">辽宁省</option><option label="吉林省" value="number:22">吉林省</option><option label="黑龙江省" value="number:23">黑龙江省</option><option label="上海市" value="number:31">上海市</option><option label="江苏省" value="number:32" selected="selected">江苏省</option><option label="浙江省" value="number:33">浙江省</option><option label="安徽省" value="number:34">安徽省</option><option label="福建省" value="number:35">福建省</option><option label="江西省" value="number:36">江西省</option><option label="山东省" value="number:37">山东省</option><option label="河南省" value="number:41">河南省</option><option label="湖北省" value="number:42">湖北省</option><option label="湖南省" value="number:43">湖南省</option><option label="广东省" value="number:44">广东省</option><option label="广西壮族自治区" value="number:45">广西壮族自治区</option><option label="海南省" value="number:46">海南省</option><option label="重庆市" value="number:50">重庆市</option><option label="四川省" value="number:51">四川省</option><option label="贵州省" value="number:52">贵州省</option><option label="云南省" value="number:53">云南省</option><option label="西藏自治区" value="number:54">西藏自治区</option><option label="陕西省" value="number:61">陕西省</option><option label="甘肃省" value="number:62">甘肃省</option><option label="青海省" value="number:63">青海省</option><option label="宁夏回族自治区" value="number:64">宁夏回族自治区</option><option label="新疆维吾尔自治区" value="number:65">新疆维吾尔自治区</option><option label="台湾省" value="number:71">台湾省</option><option label="香港特别行政区" value="number:81">香港特别行政区</option><option label="澳门特别行政区" value="number:82">澳门特别行政区</option></select>
						        </div>
						        <div class="col-sm-3">
						            <select class="form-control ng-isolate-scope ng-not-empty ng-valid ng-valid-required"  name="cityCode" >
						            <option value="" class="ng-binding" selected="selected">--请选择--</option><option label="南京市" value="number:3201">南京市</option><option label="无锡市" value="number:3202">无锡市</option><option label="徐州市" value="number:3203">徐州市</option><option label="常州市" value="number:3204">常州市</option><option label="苏州市" value="number:3205" selected="selected">苏州市</option><option label="南通市" value="number:3206">南通市</option><option label="连云港市" value="number:3207">连云港市</option><option label="淮安市" value="number:3208">淮安市</option><option label="盐城市" value="number:3209">盐城市</option><option label="扬州市" value="number:3210">扬州市</option><option label="镇江市" value="number:3211">镇江市</option><option label="泰州市" value="number:3212">泰州市</option><option label="宿迁市" value="number:3213">宿迁市</option></select>
						        </div>
						        <div class="col-sm-2">
						            <select class="form-control ng-isolate-scope ng-not-empty ng-valid" ><option value="" class="ng-binding" selected="selected">--请选择--</option><option label="沧浪区" value="number:320502">沧浪区</option><option label="平江区" value="number:320503">平江区</option><option label="金阊区" value="number:320504">金阊区</option><option label="虎丘区" value="number:320505" selected="selected">虎丘区</option><option label="工业园区" value="number:320508">工业园区</option><option label="高新区" value="number:320509">高新区</option><option label="吴中区" value="number:320506">吴中区</option><option label="相城区" value="number:320507">相城区</option><option label="常熟市" value="number:320581">常熟市</option><option label="张家港市" value="number:320582">张家港市</option><option label="昆山市" value="number:320583">昆山市</option><option label="吴江市" value="number:320584">吴江市</option><option label="太仓市" value="number:320585">太仓市</option></select>
						    	</div>
						    </div> -->
						    <div class="form-group">
						        <label class="col-sm-2 control-label">申请原因：</label>
						        <div class="col-sm-8">
						            <textarea name="result_1_msg" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text" ></textarea>
						        </div>
						    </div>
						
						    <!-- ngIf: !notUseButton -->
						<div class="modal-footer">
							<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
							<a onclick="erp_kqyspsh_98()"  class="btn btn-primary" >提交</a>	
						</div>
						</form>
						<script type="text/javascript">
						function erp_kqyspsh_98(){
							   	var form = new FormData(document.getElementById("kqyspsh_98"));
							   	$.ajax({
							           url:"${pageContext.request.contextPath}/erp/erp_kqyspsh_98.do",
							           type:"post",
							           data:form,
							           processData:false,
							           contentType:false,
							           success:function(data){
							            alert("提交成功!");
							            //location.reload();
							            window.location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }';
							           },
							           error:function(e){
							            alert("错误！！");
							           }
							    });  
						}
						</script>
						</div>                                             
						</div>							  	
						</li> 
				</div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div>
	    </div>
	</div>
	<!-- 跨区域业务审批 end -->
	<!-- 业务信息修改申请审批 start -->
	<div class="modal fade" id="addModal_ywxxxg" tabindex="-1" role="dialog" aria-labelledby="addModal_nstrLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title" align="center" id="aayyclModalLabel">业务信息修改申请</h4>
	            </div>
	            <div class="modal-body" style="height:450px;">
	             <!-- 模态框插入内容 start -->
	             		<li class="text-primary">
						<em>业务属性值修改申请</em>
						<div class="big-conte_">  
						<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
						<form id="ywxxxgsh_96" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
						   <!-- ngIf: notUseButton -->
							<input type="hidden" name="adminid" value="${sessionScope.pd.id}">
							<input type="hidden" name="type_id" value="14"> 
							<input type="hidden" name="icbc_id" value="${pd.id}"> 
						   <div class="form-group ng-scope">
								<label class="col-sm-2 control-label">业务类型</label>
								<div class="col-sm-6">
									<select id="ywlx" name="ywxxxgsh_96_ywlx"  class="form-control form-inline hidden-xs">
										<option value="">***业务类型***</option>
										<option value="征信查询">征信查询</option>
										<option value="征信通融">征信通融</option>
										<option value="车辆评估">车辆评估</option>
										<option value="银行电审">银行电审</option>
										<option value="开卡申请">开卡申请</option>
										<option value="视频面签">视频面签</option>
										<option value="跨区域业务审批">跨区域业务审批</option>
										<option value="汽车贷款">汽车贷款</option>
										<option value="内审通融">内审通融</option>
										<option value="资金分配">资金分配</option>
										<option value="银行贷款申请">银行贷款申请</option>
										<option value="公司归档">公司归档</option>
										<option value="抵押归档">抵押归档</option>
										<option value="业务信息修改">业务信息修改</option>
										<option value="退单退费">退单退费</option>
									</select>
								</div>
								<!-- 属性修改弹框 start -->
								<%-- <div class="form-group">
									<table class="table table-bordered" style="width:50%;margin-left:307px;margin-top:50px;">
									<thead>
									     <tr>
									         <th width="30%">业务属性</th>
									         <th>原值--&gt;更改值 
									         <button class="btn btn-sm btn-success" style="float:right;" type="button" ng-init="data.dataList=data.dataList?data.dataList:[];data.dataList.push({});" ng-click="data.dataList=data.dataList?data.dataList:[];data.dataList.push({});">
									            <i class="glyphicon glyphicon-plus"></i> 添加要修改的属性
									       	 </button>
									        </th>
									     </tr>
									 </thead>
									 <tbody class="ng-scope" ng-if="displayedList.count !=0 "> 
									 <tr class="ng-scope" ng-repeat="item in displayedList">
								         <td>
									         <select class="fieldAttr form-control ng-isolate-scope ng-empty ng-invalid ng-invalid-required ng-touched" required="required" ng-model="data.field[$index]" cg-required="" source="businessAttr" index="creditQuery" parent-id="tranCode" ng-options="opt.realValue as opt.displayValue for opt in options">
										         <option class="ng-binding" selected="selected" value="">--请选择--</option>
										         <option value="number:18" label="征信结果">征信结果</option>
										         <option value="number:19" label="征信内容">征信内容</option>
									         </select>
								         </td>
								         <td>
								         	<cg-dync-form class="ng-pristine ng-untouched ng-valid ng-isolate-scope ng-empty" ng-model="item.businessAttr" obj_model="businessAttr" parent-model="data.field[$index]"></cg-dync-form>
								         </td>
								     </tr>
									 </tbody>
									</table>
								</div> --%>
								<!-- 属性修改弹框 end -->
								
							</div><!-- end ngIf: notUseButton -->
							<!-- ngIf: !notUseButton -->
							<!-- ngIf: !notUseButton -->
							<!-- ngIf: task.tranCode&&!notUseButton -->
							<div class="form-group">
								<label class="col-sm-2 control-label">修改内容备注</label>
								<div class="col-sm-8">
									<textarea name="ywxxxgsh_96_xgbz" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text" ></textarea>
								</div>
							</div>
							<!-- ngIf: currentUser.orgType=='ALAN' -->
							<div class="ng-scope">
								<!-- <label class="col-sm-2 control-label">上传相关材料:</label>	
							     	<div style="overflow: hidden;margin-left: 7%;">
									</div> -->
									<div class="clear"></div> 
							<!-- ngIf: (!notUseButton&&rootData.taskDefKey == 'updateLoanField_updateLoan_operation1')||(notUseButton&&taskAct.activityId=='updateLoanField_updateLoan_operation1') -->
							<div class="form-group">
								<label class="col-sm-2 control-label">修改原因备注</label>
								<div class="col-sm-8">
									<textarea name="result_1_msg" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"></textarea>
								</div>
							</div>
							</div><!-- end ngIf: currentUser.orgType=='ALAN' -->
							<!-- ngIf: !notUseButton -->
						<div class="modal-footer">
							<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
							<a onclick="erp_ywxxxgsh_96()"  class="btn btn-primary" >提交</a>	
						</div>
						</form>
						<script type="text/javascript">
						function erp_ywxxxgsh_96(){
							   	var form = new FormData(document.getElementById("ywxxxgsh_96"));
							   	$.ajax({
							           url:"${pageContext.request.contextPath}/erp/erp_ywxxxgsh_96.do",
							           type:"post",
							           data:form,
							           processData:false,
							           contentType:false,
							           success:function(data){
							            alert("提交成功!");
							            //location.reload();
							            window.location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }';
							           },
							           error:function(e){
							            alert("错误！！");
							           }
							    });  
						}
						</script>
						</div>                                             
						</div>							  	
						</li>
				 <!-- 模态框插入内容 end -->
				</div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div>
	    </div>
	</div>
	<!-- 业务信息修改申请审批 end -->
	<!-- 退单退费修改审批 start -->
	<div class="modal fade" id="addModal_tdtf" tabindex="-1" role="dialog" aria-labelledby="addModal_nstrLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title" align="center" id="aayyclModalLabel">退单退费申请</h4>
	            </div>
	            <div class="modal-body" style="height:450px;">
	             <!-- 模态框插入内容 start -->
	             		<li class="text-primary">
						<em>退单退费申请</em>
						<div class="big-conte_">  
						<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
						<form id="tdtfsh_97" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
								 <input type="hidden" name="adminid" value="${sessionScope.pd.id}">
								 <input type="hidden" name="type_id" value="15"> 
								 <input type="hidden" name="icbc_id" value="${pd.id}"> 
								 <div class="form-group">
									<label class="col-sm-2 control-label">客户姓名</label>
									<div class="col-sm-3">
										<input value="${pd.c_name}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
									</div>
									<label class="col-sm-2 control-label">业务编号</label>
									<div class="col-sm-3">
										<input value="${pd.gems_code}"  class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
									</div>
								 </div>
								<div class="file-upload">
								<label class="col-sm-2 control-label">退单退费材料</label>
							        <span class="file-upload-text">上传图片</span>
							        <input name="files" id="file0" imgid="img0" class="file-upload-input" onchange="javascript:setImagePreviews()" type="file" accept="image/jpg,image/jpeg,image/png">
						        </div>
						     	<div style="overflow: hidden;margin-left: 7%;">
							     	<div id="img_div"  style="float:left;left:5px;margin-top: 20px" class="ng-scope"></div>
							    </div>	
								<div class="form-group">
									<label class="col-sm-2 control-label" style="margin-top: 57px;">退单退费说明</label>
									<div class="col-sm-8" style="margin-top: 40px;">
										<textarea name="result_1_msg" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text"></textarea>
									</div>
								</div> 
							<!-- ngIf: !notUseButton -->
						<div class="modal-footer">
							<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
							<a onclick="erp_tdtfsh_97()"  class="btn btn-primary" >提交</a>	
						</div>
						</form>
						<script type="text/javascript">

						//图片回显+图片格式+文件类型
						var magId=0;
						function setImagePreviews(){
							var docobj=document.getElementById("file"+magId);
							var dd=document.getElementById("img_div");
							var fileList=docobj.files;	
							for( var i=0;i<fileList.length;i++){
								magId++;
								$(dd).append(
									"<div class='fileUpload_preview' imgid='img"+(magId-1)+"' style='margin-top:5px;'>"+
								     	"<li>"+
								     	"<img id='img"+(magId-1)+"' name='"+(magId-1)+"' class='fileUpload_preview fileUpload_preview-small fileUpload_preview-square' src='"+this.result+"'>"+	  
									    "</li>"+
									    /* "<div class='btn btn-primary btn-download'>↓</div>"+ */
									    "<div id='close"+(magId-1)+"' class='btn btn-danger btn-close'>x</div>"+
									    "</div>"
										);
								$(".file-upload [imgid=img"+(magId-1)+"]")[0].style.position="absolute";
								$(".file-upload [imgid=img"+(magId-1)+"]")[0].style.left="-10000px";		
								$(".file-upload").append('<input id="file'+magId+'" name="files" imgid="img'+magId+'" class="file-upload-input" onchange="javascript:setImagePreviews()" type="file" accept="image/jpg,image/jpeg,image/png">');		
								$("#close"+(magId-1)).on("click",function(e){
									var id=$(this).parents(".fileUpload_preview").attr("imgid");
									$(this).parent().remove();
									//删除input  type=file  
									$(".file-upload input[imgid="+id+"]").remove();
								});
								var imgObjPreview=document.getElementById("img"+(magId-1));
								if(docobj.files&&docobj.files[i]){
									imgObjPreview.style.display="block";
									imgObjPreview.style.width="100px";
									imgObjPreview.style.height="120px";
									imgObjPreview.src=window.URL.createObjectURL(docobj.files[i]);
								}else{
									//IE
									docobj.select();
									var imgsrc=document.selection.createRange().text;
									var localImageId=document.getElementById("img"+(magId-1));
									localImageId.style.width="100px";
									localImageId.style.height="120px";
									try{
										localIamgeId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
										localIamgeId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src=imgsrc;
									}catch(e){
										alert("上传图片出错");
										return false;
									}
									imgObjPreview.style.display="none";
									document.selection.empty();
								}		
							}
							return true;
						} 

						function erp_tdtfsh_97(){
							   	var form = new FormData(document.getElementById("tdtfsh_97"));
							   	$.ajax({
							           url:"${pageContext.request.contextPath}/erp/erp_tdtfsh_97.do",
							           type:"post",
							           data:form,
							           processData:false,
							           contentType:false,
							           success:function(data){
							            alert("提交成功!");
							            //location.reload();
							            window.location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }';
							           },
							           error:function(e){
							            alert("错误！！");
							           }
							    });  
						}
						</script>
						</div>                                             
						</div>							  	
						</li>
				 <!-- 模态框插入内容 end -->
				</div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div>
	    </div>
	</div>
	<!-- 退单退费修改审批 end -->
<!--进度   -->
    <div id="" class="tab-content">
     
    <c:if test="${requestScope.type_id eq '1' }">
    <jsp:include page="/kjs_icbc/modal/zx_modal.jsp"></jsp:include>
    </c:if>
    <c:if test="${requestScope.type_id eq '2' }">
    <jsp:include page="/kjs_icbc/modal/zxtr_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '3' }">
    <jsp:include page="/kjs_icbc/modal/clpg_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '4' }">
    <jsp:include page="/kjs_icbc/modal/yhds_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '5' }">
    <jsp:include page="/kjs_icbc/modal/kksq_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '6' }">
    <jsp:include page="/kjs_icbc/modal/spmq_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '7' }">
    <jsp:include page="/kjs_icbc/modal/kqysp_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '8' }">
    <jsp:include page="/kjs_icbc/modal/qcdk_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '9' }">
    <jsp:include page="/kjs_icbc/modal/nstr_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '10' }">
    <jsp:include page="/kjs_icbc/modal/zjfp_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '11' }">
    <jsp:include page="/kjs_icbc/modal/yhdksq_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '12' }">
    <jsp:include page="/kjs_icbc/modal/gsgd_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '13' }">
    <jsp:include page="/kjs_icbc/modal/dygd_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '14' }">
    <jsp:include page="/kjs_icbc/modal/ywxxxg_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '15' }">
    <jsp:include page="/kjs_icbc/modal/tdtf_modal.jsp"></jsp:include>
    </c:if>
    <c:if test="${requestScope.type_id eq '16' }">
    <jsp:include page="/kjs_icbc/modal/rz_modal.jsp"></jsp:include>
    </c:if>
    </div>

<!--进度 -->
	</div>
	<div class="tab-pane fade" id="jcxx">
    <jsp:include page="/kjs_icbc/modal/jcxx_modal.jsp"></jsp:include>
	</div>
	<div class="tab-pane fade" id="khgl">
    <jsp:include page="/kjs_icbc/modal/khgl_modal.jsp"></jsp:include>
	</div>
	<div class="tab-pane fade" id="dkgl">
    <jsp:include page="/kjs_icbc/modal/dkgl_modal.jsp"></jsp:include>
	</div>
	<div class="tab-pane fade" id="clxx">
	<jsp:include page="/kjs_icbc/modal/qcpg_modal.jsp"></jsp:include>
	</div>
	<div class="tab-pane fade" id="zzsc">
    <jsp:include page="/kjs_icbc/modal/grfx_modal.jsp"></jsp:include>
	</div>
	<div class="tab-pane fade" id="yycl">
	 <jsp:include page="/kjs_icbc/modal/yycl_modal.jsp"></jsp:include>
	</div>
	<div class="tab-pane fade" id="sfmx">
	 <jsp:include page="/kjs_icbc/modal/sfmx_modal.jsp"></jsp:include>
	</div>

</div>
<%-- <div class="modal-footer">
<button onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }'" class="btn btn-warning" >取消</button>
<button onclick="location.href=''" class="btn btn-primary" >提交</button>
</div> --%>
</div>
</section>

</div>