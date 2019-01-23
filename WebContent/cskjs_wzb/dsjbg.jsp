<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html class="js cssanimations"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>后台管理员模式</title>
<meta name="viewport" content="width=device-width,initial-scale=1,viewport-fit=cover,user-scalable=0">
<meta name="description" content="快加认证专业第三方汽车鉴定评估系统还提供车辆核档、维保记录、风控系统化管理等，为金融公司把控风险，节省成本！快加认证作为专业权威的第三方车辆鉴定评估机构，创新 制订出高于行业规范标准的服务+、规范+、诚信+、专业+、 创新+的“五+”服务体系。为二手车 交易、汽车金融提供最专业的服务。目前全国已有近百家实体 门店相继加盟并开业，区域覆盖上海、北京、武汉、西安、福 建等全国多个重点城市和区域，用心给客户提供细致、周到的 服务。">
<meta name="keywords" content="快加认证,车辆鉴定,车辆评估,二手车鉴定,二手车评估,福建,上海,福州"><script src="${pageContext.request.contextPath }/dsj_js_css/jQuery-2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/dsj_js_css/jquery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/dsj_js_css/php.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/dsj_js_css/common.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/dsj_js_css/fileupload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/dsj_js_css/exif.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/dsj_js_css/megapic-image.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/dsj_js_css/iconfont.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/dsj_js_css/amazeui.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/dsj_js_css/layer_002.css">
<script src="${pageContext.request.contextPath }/dsj_js_css/amazeui.js"></script>
<script src="${pageContext.request.contextPath }/dsj_js_css/layer.js"></script><link href="${pageContext.request.contextPath }/dsj_js_css/layer.css" type="text/css" rel="styleSheet" id="layermcss">
<script src="${pageContext.request.contextPath }/dsj_js_css/swiper.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/dsj_js_css/swiper.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/dsj_js_css/app.css">
</head><body class="am-with-fixed-header"><header data-am-widget="header" class="am-header am-header-default am-header-fixed am-no-layout">
	<div class="am-header-left am-header-nav">
		<a href="javascript:window.history.back();" class=""> <i class="am-header-icon iconfont icon-back"></i>
		</a>
	</div>
	<h1 class="am-header-title" style="line-height: 49px;"><a href="#title-link" class="">后台管理员模式</a></h1>
</header>
<!-- 
<div class="p-steps am-margin-sm am-margin-top-0">
	<ul class="am-avg-sm-3">
		<li class="p-steps-on">
			<div class="p-steps-item">提交订单</div>
			<i class="p-steps-icon iconfont icon-ok1"></i>
		</li>
		<li class="p-steps-on">
			<div class="p-steps-item">查询中</div>
			<i class="p-steps-icon iconfont icon-ok1"></i>
		</li>
		<li class="p-steps-on">
			<div class="p-steps-item">查询完成</div>
			<i class="p-steps-icon iconfont icon-ok1"></i>
		</li>
	</ul>
</div>
<div class="am-margin-sm am-padding-sm am-radius-lg p-boxShadow p-panel p-panel-def p-yhOrder">
	<div class="head">
		<div class="title">
			<div class="p-yhColor-blove">订单号：ZXLSRZ0040183</div>
			<span class="am-text-xs">提交时间：2018-06-27 11:10:52</span>
		</div>
		<div class="btn">
			<button type="button" class="am-btn am-btn-success am-round am-text-xs">查询完成</button>
		</div>
	</div>
	<div class="cnt assess vio">
		<div class="cntlt">
			<span class="am-text-lg p-yhColor-secondary">大数据查询</span>
		</div>
		<div class="cntrt ">
			<ul class="list">
				<li>
					<span class="">被查询人：</span>
					<span class="p-yhColor-secondary">李辉</span>
				</li>
				<li>
					<span class="">被查询人身份证号：</span>
					<span class="p-yhColor-common">420502197906130072</span>
				</li>
				<li>
					<span class="">被查询人电话：</span>
					<span class="p-yhColor-secondary">18727278226</span>
				</li>
				<li>
					<span class="">报告基准日：</span>
					<span class="p-yhColor-common">2018-06-27</span>
				</li>
			</ul>
		</div>
	</div>
</div>
 -->
<div class="am-margin-sm am-padding-sm am-radius-lg p-boxShadow p-panel p-yhOrder">
	<div class="">
		<span class="am-text-sm p-yhColor-warm">风险分:${requestScope.final_score }</span>
		<span class="am-text-xs p-yhColor-disable">（越高风险越高）</span>
	</div>
	<div class="p-yhProgress">
		<span class="grade" style="width: ${requestScope.final_score }%">${requestScope.final_score }</span>
		<div class="am-progress am-progress-xs">
			<div class="am-progress-bar am-progress-bar-danger" style="width: ${requestScope.final_score }%"></div>
		</div>
		<span class="start">0</span>
		<span class="finish">100</span>
	</div>	
	<div class="am-margin-bottom-sm">
		<span class="am-text-sm am-text-warning">信用分:${requestScope.credit_score }</span>
		<span class="am-text-xs p-yhColor-disable">（越高信用越好）</span>
	</div>
	<div class="p-yhProgress">
		<div class="am-progress am-progress-xs">
			<div class="am-progress-bar am-progress-bar-warning" style="width: ${(requestScope.credit_score-300)*100/600 }%"></div>
		</div>
		<span class="start">300</span>
		<span class="finish">900</span>
	</div>	<ul class="p-yhOrder-useInfo">
		<li>
		
			<div class="title stateError">
			<c:if test="${requestScope.final_decision eq 'Accept' }">
			<font color="FF6633">建议通过</font>
			</c:if>
			<c:if test="${requestScope.final_decision eq 'Review' }">
			<font color="FF6633">建议审核</font>
			</c:if>
			<c:if test="${requestScope.final_decision eq 'Reject' }">
			<font color="FF6633">建议拒绝</font>
			</c:if>
			</div>
			<div class="sub">个人基本信息核查</div>
		</li>
		<li>
			<div class="title stateError">${requestScope.address_detect.id_card_address }</div>
			<div class="sub">身份证归属地</div>
		</li>
		<li>
			<div class="title stateError">${requestScope.address_detect.mobile_address }</div>
			<div class="sub">手机号码归属地</div>
		</li>
	</ul>
</div>
<div class="p-yhOrder-rpt p-boxShadow am-radius-lg">
	<div class="rptTitle">详细报告</div>
	<input type="hidden"  id="risk_items_count" name="risk_items_count" value="${requestScope.risk_items_count}">
<%
int i=1;  
%>
<c:if test="${!empty requestScope.risk_items}">

<c:forEach items="${requestScope.risk_items}"  var="risk_items">	
<div class="rptSplit"></div>
	<ul class="am-avg-sm-2 rptCnt">
		<li class="credit">
			<div class="title">
				<span>${risk_items.item_name}</span>
				<span class="tag">中</span>
			</div>
			<div class="state">
			<c:if test="${risk_items.risk_level eq 'low'}">
			低	
			</c:if>
			<c:if test="${risk_items.risk_level eq 'medium'}">
			中	
			</c:if>		
			<c:if test="${risk_items.risk_level eq 'high'}">
			高	
			</c:if>
			<span class="sub">风险</span>
			</div>
			<div class="info">${risk_items.group}</div>
		</li>	
	    <li class="base">
	    <c:if test="${empty risk_items.item_detail.type}">   
	     
	    <c:forEach items="${risk_items.item_detail.namelist_hit_details}" var="namelist_hit_details">
	    
	    <c:if test="${namelist_hit_details.type eq 'grey_list' }">
	    
	    <strong>${namelist_hit_details.hit_type_displayname }</strong>
		<br>${namelist_hit_details.fraud_type }:${namelist_hit_details.description }<br>	 
	    
	    </c:if>
	    
	    <c:if test="${namelist_hit_details.type eq 'black_lsit' }">	    
	    <strong>${namelist_hit_details.description }</strong>
	    <c:forEach var="court_details" items="${namelist_hit_details.court_details }">
	    <br>${court_details.id_number }</br>
	    <br>${court_details.fraud_type }:${court_details.name }<br>
	    </c:forEach>
	    
	    </c:if>
	    
	    <c:if test="${namelist_hit_details.type eq 'fuzzy_list' }">
	    <strong>${namelist_hit_details.description }</strong>
	    <c:forEach var="fuzzy_detail_hits" items="${namelist_hit_details.fuzzy_detail_hits }">
	    <div>${fuzzy_detail_hits.fuzzy_id_number }</div>
	    <div>${fuzzy_detail_hits.fraud_type }:${fuzzy_detail_hits.fuzzy_name }</div>	   
	    </c:forEach>
	    
	    </c:if>
	    
	    </c:forEach>
	    
	    </c:if>	
	    <c:if test="${!empty risk_items.item_detail.type}">
	    
	    <c:if test="${risk_items.item_detail.type eq 'platform_detail'}">
	     <div class="title">总条目数：${fn:length(risk_items.item_detail.platform_detail)}</div>
	     <c:forEach var="platform_detail" items="${risk_items.item_detail.platform_detail }">
	     <div class="attr">${platform_detail }</div>
	     </c:forEach>
	    
	    </c:if>
	    
	     <c:if test="${risk_items.item_detail.type eq 'frequency_detail'}">
	     <c:forEach var="frequency_detail_list" items="${risk_items.item_detail.frequency_detail_list }">
	     <div class="attr">${frequency_detail_list.detail }</div>
	     <c:if test="${!empty frequency_detail_list.data }">
	     <c:forEach var="data" items="${frequency_detail_list.data }">
	     <div class="attr">${data }</div>
	     </c:forEach>
	     </c:if>
	     </c:forEach>
	     </c:if>
	    
	     <c:if test="${risk_items.item_detail.type eq 'discredit_count'}">
	     <div class="title">逾期次数：${risk_items.item_detail.discredit_times }</div>
	     <c:forEach var="overdue_details" items="${risk_items.item_detail.overdue_details }">	     	     
	     <div class="attr">逾期金额：${overdue_details.overdue_amount }</div>
	     <div class="attr">逾期笔数：${overdue_details.overdue_count }</div>
	     <div class="attr">逾期天数：${overdue_details.overdue_day }</div>
	     </c:forEach>
	     </c:if>
	    
	     <c:if test="${risk_items.item_detail.type eq 'custom_list'}">
	     <div class="title">逾期次数：${risk_items.item_detail.discredit_times }</div>
	     <c:forEach var="overdue_details" items="${risk_items.item_detail.overdue_details }">	     	     
	     <div class="attr">逾期金额：${overdue_details.overdue_amount }</div>
	     <div class="attr">逾期笔数：${overdue_details.overdue_count }</div>
	     <div class="attr">逾期天数：${overdue_details.overdue_day }</div>
	     </c:forEach>
	     </c:if>
	    
	    </c:if>
		</li>
   
    </ul>	
    <%i++; %>
 </c:forEach> 
</c:if>  
  <!-- ******************************* -->  	
<div class="rptSplit"></div>
	<div class="am-margin-top-sm">
		<ul class="am-avg-sm-2 am-text-left am-text-sm p-yhColor-pass p-yhTable-avg">
						<li class="am-padding-right-xs">
				<span class="am-block hook">
					<span class="am-inline-block lt">个人基本信息核查</span>
					<span class="">√</span>
				</span>
			</li>				<li class="am-padding-right-xs">
				<span class="am-block hook">
					<span class="am-inline-block lt">不良信息扫描</span>
					<span class="">√</span>
				</span>
			</li>				<li class="am-padding-right-xs">
				<span class="am-block hook">
					<span class="am-inline-block lt">关联人信息扫描</span>
					<span class="">√</span>
				</span>
			</li>	</ul>
	</div>
</div>
<div id="translate-man-app" class="content-3WfBL_0" style="left: 12px; top: 167px; display: none;">
<div data-v-2b7a7e32="" class="outputBox-qe9A4_0">
<div data-v-2b7a7e32="" class="outputBox-3oESn_0">
<span data-v-2b7a7e32="" class="outputBox-13Ovx_0">
</span>
<!---->
</div>
<div data-v-2b7a7e32="" class="outputBox-1GLb__0">
<!---->
<div data-v-2b7a7e32="" class="outputBox-onVZH_0">
<img src="${pageContext.request.contextPath }/dsj_js_css/sound.svg" class="icon-tprjJ_0">
</div>
</div>
<div data-v-2b7a7e32="" class="outputBox-2sJgr_0">
</div>
<div data-v-2b7a7e32="" class="outputBox-17RAm_0" style="display: none;">
<!---->
<!---->
<!---->
<div data-v-2b7a7e32="">
</div>
</div>
</div>
</div>
</body>
</html>