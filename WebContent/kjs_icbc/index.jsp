<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="style.jsp"></jsp:include>
<%-- <c:if test="${!empty sessionScope.pd.skins_name }">
<body class="${sessionScope.pd.skins_name }">
</c:if>
<c:if test="${empty sessionScope.pd.skins_name }">
</c:if> --%>
<body class="skin-purple sidebar-mini fixed">


<div class="wrapper">
<jsp:include page="header.jsp"></jsp:include>
<script type="text/javascript">
/* setInterval("sname()",1000); */

function sname(){
	$.post("${pageContext.request.contextPath }/erp/skins_name.do",
			function(result){
				document.getElementsByTagName("body")[0].className=result; 	
				})
}

 function skins(sn){
	 $.post("${pageContext.request.contextPath }/erp/skins.do",
				{skinsname:sn+" sidebar-mini fixed"},
				function(result){
					if(result==1){
					document.getElementsByTagName("body")[0].className=sn+" sidebar-mini fixed"; 	
					}

});
	 
 
 }
</script>

<jsp:include page="menu.jsp"></jsp:include>
<c:if test="${empty requestScope.qn }">
<c:choose>
<%-- <c:when test="${sessionScope.pd.icbc_erp_fsid ne '1708'}">
<jsp:include  page="content/nojsp.jsp" ></jsp:include>
</c:when> 
--%>
 <c:when test="${fn:contains(sessionScope.pd.purview_map,'glzx')!=true}">
<jsp:include  page="content/nojsp.jsp" ></jsp:include>
</c:when>

<c:otherwise>
<jsp:include  page="content/${requestScope.dn }.jsp" ></jsp:include>
</c:otherwise>
</c:choose>
</c:if>
<c:if test="${!empty requestScope.qn }">
<jsp:include  page="content/${requestScope.dn }_${requestScope.qn }.jsp" ></jsp:include>

</c:if>


	
<!-- 搜索层 -->
<div class="control-sidebar-bg" style="position: fixed; height: auto;"></div>
</div>
<!--弹窗框体开始-->

		
<!-- 弹窗框体结束-->
<div id="translate-man-app" class="content-3WfBL_0" style="display: none;">
<div data-v-2b7a7e32="" class="outputBox-qe9A4_0">
<div data-v-2b7a7e32="" class="outputBox-3oESn_0">
<span data-v-2b7a7e32="" class="outputBox-13Ovx_0">
</span><!---->
</div>
<div data-v-2b7a7e32="" class="outputBox-1GLb__0">
<!---->
<div data-v-2b7a7e32="" class="outputBox-onVZH_0">
<img src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/sound.svg" class="icon-tprjJ_0">
</div>
</div>
<div data-v-2b7a7e32="" class="outputBox-2sJgr_0">
</div>
<div data-v-2b7a7e32="" class="outputBox-17RAm_0" style="display: none;">
<!----><!----><!---->
<div data-v-2b7a7e32="">
</div>
</div>
</div>
</div>
</body>
</html>