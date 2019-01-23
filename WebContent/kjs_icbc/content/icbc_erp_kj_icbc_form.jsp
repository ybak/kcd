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
  if(type!=''){
	  var colors=document.getElementById("yw"+type);
	  colors.style.backgroundColor="#337ab7";
  }
 
});
</script>
<div class="content-wrapper fixed-footer" style="min-height: 943px;">
<section class="content">
<div class="admin-content nav-tabs-custom box">
<ul id="myTab" class="nav nav-tabs">
	<li class="active">
		<a href="#clgc" data-toggle="tab">处理过程</a>
	</li>
	<li><a href="#khgl" data-toggle="tab">客户管理</a></li>
	<li><a href="#dkgl" data-toggle="tab">贷款管理</a></li>
	<li>
		<a href="#clxx" data-toggle="tab">车辆信息</a>
	</li>
	<li>
		<a href="#zzsc" data-toggle="tab">资质审查</a>
	</li>
	<li>
		<a href="#yycl" data-toggle="tab">影音材料</a>
	</li>
	<li>
		<a href="#sfmx" data-toggle="tab">收费明细</a>
	</li>
</ul>
<div id="myTabContent" class="tab-content">

<%-- <a style="margin-bottom: 20px;"  class="btn btn-mini btn-primary">${yw.name }</a>
	 <span><i class="fa fa-long-arrow-right"></i></span> --%>
	<div class="tab-pane fade active in" id="clgc">
	<input type="hidden" value="${requestScope.type_id}" id="colortype" name="colortype"/>
	<div style="border:1px solid #478FCA;   margin:5px; padding:20px;border-radius: 10px;">
	 
	<ul id="yw" class="nav nav-tabs" style="border-bottom:none;" >

	 <li ${requestScope.type_id eq '1'?"class='active'":''} >
	 <c:if test="${!empty pd.gems_code}">
	 <a id="yw1" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wlghd&dn=jdgz&qn=form&icbc_id=${pd.icbc_id }&type_id=1"  >征信查询</a>
	 </c:if>
	 <c:if test="${empty pd.gems_code}">
	 <a href="javascript:void(0);"  disabled="disabled" class="btn btn-mini licolor">征信查询</a>
	</c:if>
     </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>

     <li ${requestScope.type_id eq '2'?"class='active'":''}>
     <c:if test="${pd.tr_status ne '0' and !empty pd.tr_status}">
	 <a id="yw2" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wlghd&dn=jdgz&qn=form&icbc_id=${pd.icbc_id }&type_id=2"  >征信通融</a>
	 </c:if>
	 <c:if test="${pd.tr_status eq '0' or empty pd.tr_status}">
	 <a href="" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">征信通融</a>
	 </c:if>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     <li ${requestScope.type_id eq '3'?"class='active'":''}>
     <c:if test="${!empty pd.cars_gems_code}">
	 <a id="yw3" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wlghd&dn=jdgz&qn=form&icbc_id=${pd.icbc_id }&type_id=3"  >车辆评估</a>
	 </c:if>
	 <c:if test="${empty pd.cars_gems_code}">
	 <a href="" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">车辆评估</a>
	 </c:if>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     <li ${requestScope.type_id eq '4'?"class='active'":''}>
	<!--  <a href="" data-toggle="tab" class="btn btn-mini btn-primary">银行电审</a> -->
	 <a href="" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">银行电审</a>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
   
     <li ${requestScope.type_id eq '5'?"class='active'":''}>
     <c:if test="${!empty pd.kk_gems_code}">
	 <a id="yw5" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wlghd&dn=jdgz&qn=form&icbc_id=${pd.icbc_id }&type_id=5" >开卡申请</a>
	 </c:if>
	 <c:if test="${empty pd.kk_gems_code}">
	 <a href="" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">开卡申请</a>
     </c:if>
	 </li>
	 
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     <li ${requestScope.type_id eq '6'?"class='active'":''}>
     <c:if test="${!empty pd.mq_gems_code}">
	 <a id="yw6" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wlghd&dn=jdgz&qn=form&icbc_id=${pd.icbc_id }&type_id=6" >视频面签</a>
	 </c:if>
	 <c:if test="${empty pd.mq_gems_code}">
	 <a href="" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">视频面签</a>
	 </c:if>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     <li ${requestScope.type_id eq '7'?"class='active'":''}>
	 <!-- <a href="#yw7" data-toggle="tab" class="btn btn-mini btn-primary">跨区域业务审批</a> -->
	 <a href="#yw7" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">跨区域业务审批</a>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     
     <li ${requestScope.type_id eq '8'?"class='active'":''}>
     <c:if test="${!empty pd.dk_gems_code}">
	 <a id="yw8" style="background-color:#3c8dbc;color: #ffffff;" href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wlghd&dn=jdgz&qn=form&icbc_id=${pd.icbc_id }&type_id=8" >汽车贷款</a>
	 </c:if>
	 <c:if test="${empty pd.dk_gems_code}">
	 <a href="" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">汽车贷款</a>
	 </c:if>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     
     <li ${requestScope.type_id eq '9'?"class='active'":''}>
	 <!-- <a href="#yw9" data-toggle="tab" class="btn btn-mini btn-primary">内审通融</a> -->
	 <a href="#yw9" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">内审通融</a>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     
     <li ${requestScope.type_id eq '10'?"class='active'":''}>
	 <!-- <a href="#yw10" data-toggle="tab" class="btn btn-mini btn-primary">资金分配</a> -->
	 <a href="#yw10" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">资金分配</a>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     
     <li ${requestScope.type_id eq '11'?"class='active'":''}>
	 <!-- <a href="#yw11" data-toggle="tab" class="btn btn-mini btn-primary">银行贷款申请</a> -->
	 <a href="#yw11" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">银行贷款申请</a>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     
     <li ${requestScope.type_id eq '12'?"class='active'":''}>
	 <!-- <a href="#yw12" data-toggle="tab" class="btn btn-mini btn-primary">公司归档</a> -->
	 <a href="#yw12" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">公司归档</a>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     
     <li ${requestScope.type_id eq '13'?"class='active'":''}>
	 <!-- <a href="#yw13" data-toggle="tab" class="btn btn-mini btn-primary">抵押归档</a> -->
	 <a href="#yw13" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">抵押归档</a>
	 </li>
      <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     <li ${requestScope.type_id eq '14'?"class='active'":''}>
	<!--  <a href="#yw14" data-toggle="tab" class="btn btn-mini btn-primary">业务信息修改</a> -->
	 <a href="#yw14" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">业务信息修改</a>
	 </li>
     <li style="display:block;text-align:center; line-height:50px"><i class="fa fa-long-arrow-right"></i></li>
     
     <li ${requestScope.type_id eq '15'?"class='active'":''}>
	 <!-- <a href="#yw15" data-toggle="tab" class="btn btn-mini btn-primary">退单退费</a> -->
	 <a href="#yw15" data-toggle="tab" disabled="disabled" class="btn btn-mini licolor">退单退费</a>
	 </li>
	</ul>
	</div>
<!--进度   -->
    <div id="" class="tab-content">
     
    <c:if test="${requestScope.type_id eq '1' }">
    <jsp:include page="/kjs_icbc/modal/zx_modal.jsp"></jsp:include>
    </c:if>
    <c:if test="${requestScope.type_id eq '2' }">
    <jsp:include page="/kjs_icbc/modal/zxtr_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '3' }">
    <jsp:include page="/kjs_icbc/modal/zxtr_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '4' }">
    <jsp:include page="/kjs_icbc/modal/zxtr_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '5' }">
    <jsp:include page="/kjs_icbc/modal/zxtr_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '6' }">
    <jsp:include page="/kjs_icbc/modal/zxtr_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '7' }">
    <jsp:include page="/kjs_icbc/modal/zxtr_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '8' }">
    <jsp:include page="/kjs_icbc/modal/zxtr_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '9' }">
    <jsp:include page="/kjs_icbc/modal/zxtr_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '10' }">
    <jsp:include page="/kjs_icbc/modal/zxtr_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '11' }">
    <jsp:include page="/kjs_icbc/modal/zxtr_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '12' }">
    <jsp:include page="/kjs_icbc/modal/zxtr_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '13' }">
    <jsp:include page="/kjs_icbc/modal/zxtr_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '14' }">
    <jsp:include page="/kjs_icbc/modal/zxtr_modal.jsp"></jsp:include>
    </c:if>
     <c:if test="${requestScope.type_id eq '15' }">
    <jsp:include page="/kjs_icbc/modal/zxtr_modal.jsp"></jsp:include>
    </c:if>
    </div>

<!--进度 -->
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
<div class="modal-footer">
<button onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=icbc_erp_kj_icbc&qn=list&cn=${requestScope.cn }'" class="btn btn-warning" >取消</button>
<button onclick="location.href=''" class="btn btn-primary" >提交</button>
</div>
</div>
</section>

</div>