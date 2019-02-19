<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html >
<head>
<meta charset="UTF-8">
<title>后台管理员模式</title>
<meta name="viewport" content="width=device-width,initial-scale=1,viewport-fit=cover,user-scalable=0">
<meta name="description" content="快加认证专业第三方汽车鉴定评估系统还提供车辆核档、维保记录、风控系统化管理等，为金融公司把控风险，节省成本！快加认证作为专业权威的第三方车辆鉴定评估机构，创新 制订出高于行业规范标准的服务+、规范+、诚信+、专业+、 创新+的“五+”服务体系。为二手车 交易、汽车金融提供最专业的服务。目前全国已有近百家实体 门店相继加盟并开业，区域覆盖上海、北京、武汉、西安、福 建等全国多个重点城市和区域，用心给客户提供细致、周到的 服务。">
<meta name="keywords" content="快加认证,车辆鉴定,车辆评估,二手车鉴定,二手车评估,福建,上海,福州">
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/jQuery-2.1.4.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/jquery.form.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/php.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/common.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/fileupload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/exif.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/megapic-image.js"></script>
<link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/amazeui.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/layer.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/08335.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/21448.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/21539.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/app.css" />
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/layer.js"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/swiper.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/swiper.min.css">
</head>
<header data-am-widget="header" class="am-header am-header-default am-header-fixed">
	<div class="am-header-left am-header-nav">
		<a href="javascript:window.history.back();" class="">
			<i class="am-header-icon iconfont icon-back"></i>
		</a>
	</div>
</header><div class="p-steps am-margin-sm am-margin-top-0">
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
		<div class="attr">
			<div class="p-yhColor-blove">订单号：${icbc.gems_code }</div>
			<span class="am-text-xs">提交时间：${fn:replace(icbc.dt_add, ".0", "")}</span>
		</div>
		<div class="btn">
			<button type="button" class="am-btn am-btn-success am-round am-text-xs">查询完成</button>
		</div>
	</div>
	<div class="cnt assess vio">
		<div class="cntlt">
			<span class="am-text-lg p-yhColor-secondary">大数据<br>查询</span>
		</div>
		<div class="cntrt ">
			<ul class="list">
				<li>
					<span class="">被查询人：</span>
					<span class="p-yhColor-secondary">${data.resultData.name }</span>
										<span class="tag" style="color:white;background:green;">实名：${data.resultData.idVerification.message }</span>
				</li>
				<li>
					<span class="">身份证：</span>
					<span class="p-yhColor-common">${data.resultData.idCardNo }</span>
				</li>
				<li>
					<span class="">电话：</span>
					<span class="p-yhColor-secondary">${data.resultData.mobileNo }</span>
				</li>
				<li>
					<span class="">报告基准日：</span>
					<span class="p-yhColor-common">报告基准日</span>
				</li>
			</ul>
		</div>
	</div>
</div><div class="am-margin-sm am-padding-sm am-radius-lg p-boxShadow p-panel p-yhOrder">
	<div class="">
		<span class="am-text-sm p-yhColor-warm">欺诈分:${data.resultData.riskList.fraudScore }</span>
		<span class="am-text-xs p-yhColor-disable">（越高风险越高）</span>
	</div>
	<div class="p-yhProgress">
		<span class="grade" style="width: ${data.resultData.riskList.fraudScore/10 }%"></span>
		<div class="am-progress am-progress-xs">
			<div class="am-progress-bar am-progress-bar-danger" style="width: ${data.resultData.riskList.fraudScore/10}%"></div>
		</div>
		<span class="start">0</span>
		<span class="finish">1000</span>
	</div>	<ul class="p-yhOrder-useInfo">
		<li>
			<div class="title stateError">人工审核</div>
			<div class="sub">个人基本信息核查</div>
		</li>
		<li>
			<div class="title stateError">${data.resultData.idVerification.location }</div>
			<div class="sub">身份证归属地</div>
		</li>
		<li>
			<div class="title stateError">${data.resultData.carrier.location }</div>
			<div class="sub">手机号码归属地</div>
		</li>
	</ul>
</div>
<div style="wigth:1000px">
	<div class="p-yhOrder-rpt p-boxShadow am-radius-lg">
		<div class="rptTitle">基本信息</div>
		<ul class="am-avg-sm-2 rptCnt">
			<li class="credit">
				<div class="attr">
					<span>身份证实名</span>
				</div>
			</li>
			<li class="base">
				<div class="attr" style="color:green;">${data.resultData.idVerification.message }</div>
			</li>
		</ul>
	</div>
	<!-- 欺诈风险 -->
	<div class="p-yhOrder-rpt p-boxShadow am-radius-lg">
		<div class="rptTitle">欺诈风险</div>
		<ul class="am-avg-sm-2 rptCnt">
			<li class="credit">
				<div class="attr">
					<span>欺诈评分：${data.resultData.riskList.fraudScore }</span>
				</div>
			</li>
			<li class="base credit">
				<c:choose>
					<c:when test="${data.resultData.idVerification.message == '匹配'}">
						<div class="title">身份认证成功<span class="tag">低风险</span></div>
					</c:when>
					<c:otherwise>
						<div class="title">身份认证失败<span class="tag">中风险</span></div>	
					</c:otherwise>
				</c:choose>	
			</li>
		</ul>
	</div>
	<div class="p-yhOrder-rpt p-boxShadow am-radius-lg">
		<c:if test="${data1.resultData.ANTIFRAUD.final_decision == 'REJECT'}">
			<div class="rptTitle">贷前评估：【<font color=red><font color="green">建议拒绝</font></font>】</div>
		</c:if>	
		<c:if test="${data1.resultData.ANTIFRAUD.final_decision == 'REVIEW'}">
			<div class="rptTitle">贷前评估：【<font color=red><font color="green">建议审核</font></font>】</div>
		</c:if>	
		<c:if test="${data1.resultData.ANTIFRAUD.final_decision == 'PASS'}">
			<div class="rptTitle">贷前评估：【<font color=red><font color="green">建议通过</font></font>】</div>
		</c:if>	
				<div class="rptSplit"></div>
		<c:forEach items = "${data1.resultData.ANTIFRAUD.risk_items }" var="risk_items">
			<ul class="am-avg-sm-2 rptCnt">
				<li class="credit">
					<div class="title">
						<span>${risk_items.risk_name }</span>
							<span class="tag">中</span>
						
					</div>
					<div class="state">
						低				<span class="sub">风险</span>
					</div>
					<div class="info"></div>
				</li>
				
																	 
					<c:if test="${risk_items.risk_detail[0].type == 'grey_list' }">
						<li class="base">
							<strong>${risk_items.risk_detail[0].hit_type_display_name }</strong><br/>
							<strong>${risk_items.risk_detail[0].fraud_type_display_name }</strong>
							<c:forEach items = "${risk_items.risk_detail[0].grey_list_details }" var="grey_list_details">
								${grey_list_details.evidence_time }<br/>
								<strong><font color='red'>${grey_list_details.risk_level }</font></strong>风险<br/>
								<strong>${grey_list_details.fraud_type_display_name }</strong><br/>
								${grey_list_details.value }<br/>		
							</c:forEach>
						</li>
					</c:if>
																	
					<c:if test="${risk_items.risk_detail[0].type == 'frequency_detail' }">
						<li class="base">
							<c:forEach items = "${risk_items.risk_detail[0].frequency_detail_list }" var="frequency_detail_list">
								
								<c:forEach items = "${frequency_detail_list.data }" var="frequency_detail_listdata">
									${frequency_detail_listdata }<br/>
								</c:forEach>
								
								${frequency_detail_list.detail }<br/>	
							</c:forEach>
						</li>
					</c:if>
				
			</ul>		
			<div class="rptSplit"></div>
		</c:forEach>
		
		
	</div><!-- 移动通讯运营商 -->
	<div class="p-yhOrder-rpt p-boxShadow am-radius-lg">
		<div class="rptTitle">移动通讯</div>
		<ul class="am-avg-sm-2 rptCnt">
					<li class="credit">
				<div class="attr">
					<span>命中黑名单</span>
				</div>
			</li>
			<li class="base">
				<div class="attr">${data.resultData.carrier.isOnBlacklist == '0' ? '没有黑名单' : '存在黑名单'}</div>
			</li>
						<li class="credit">
				<div class="attr">
					<span>运营商</span>
				</div>
			</li>
			<li class="base">
				<div class="attr">${data.resultData.carrier.name }</div>
			</li>
						<li class="credit">
				<div class="attr">
					<span>运营商实名认证</span>
				</div>
			</li>
			<li class="base">
				<div class="attr">${data.resultData.carrier.verification.message }</div>
			</li>
		</ul>
	</div>
	<!-- 不良信息 -->
	<div class="p-yhOrder-rpt p-boxShadow am-radius-lg">
		<div class="rptTitle">不良信息</div>
		<ul class="am-avg-sm-2 rptCnt">
			<li class="credit">
				<div class="attr">
					<span>公安不良</span>
				</div>
			</li>
					<li class="base">
				<div class="attr">${data.resultData.badInfo }</div>
			</li>
				</ul>
		<div class="rptSplit"></div>
		<ul class="am-avg-sm-2 rptCnt">
			<li class="credit">
				<div class="attr">
					<span>司法不良</span>
				</div>
			</li>
			<li class="base">
				<div class="attr">失信信息：${data.resultData.badJudicialRecord.dishonest.count }</div>
				<div class="attr">执行信息：${data.resultData.badJudicialRecord.executed.count }</div>
				<div class="attr">案件信息：${data.resultData.badJudicialRecord.lawCase.count }</div>
				<div class="attr">网贷逾期：${data.resultData.badJudicialRecord.netLoanOverdue.count }</div>
				<div class="attr">催收公告：${data.resultData.badJudicialRecord.callLoan.count }</div>
				<div class="attr">开庭公告：${data.resultData.badJudicialRecord.courtNotice.count }</div>
				<div class="attr">法院公告：${data.resultData.badJudicialRecord.courtAnnouncement.count }</div>
				<div class="attr">案件流程：${data.resultData.badJudicialRecord.lawCaseProcess.count }</div>
			</li>
		</ul>
	</div>
	<!-- 多头借贷 -->
	<div class="p-yhOrder-rpt p-boxShadow am-radius-lg">
		<div class="rptTitle">多头借贷</div>
		<ul class="am-avg-sm-2 rptCnt">
			<li class="credit">
				<div class="attr">
					<span>注册情况</span>
				</div>
			</li>
			<li class="base">
				<div class="attr">注册银行数量：${data.resultData.loan.registration.bankCount }</div>
				<div class="attr">注册非银行数量：${data.resultData.loan.registration.nonBankCount }</div>
				<div class="attr">最早注册时间：${data.resultData.loan.registration.earliestTime }</div>
				<div class="attr">最近注册时间：${data.resultData.loan.registration.latestTime }</div>
			</li>
		</ul>
		<div class="rptSplit"></div>
		<ul class="am-avg-sm-2 rptCnt">
			<li class="credit">
				<div class="attr">
					<span>申请情况</span>
				</div>
			</li>
			<li class="base">
				<div class="attr">申请银行数量：${data.resultData.loan.application.bankCount }</div>
				<div class="attr">申请银行成功数量：${data.resultData.loan.application.bankSuccessCount }</div>
				<div class="attr">申请银行失败数量：${data.resultData.loan.application.backFailedCount }</div>
				<div class="attr">申请非银行数量：${data.resultData.loan.application.nonBankCount }</div>
				<div class="attr">申请非银行成功数量：${data.resultData.loan.application.nonBankSuccessCount }</div>
				<div class="attr">申请非银行失败数量：${data.resultData.loan.application.nonBankFailedCount }</div>
				<div class="attr">最早申请时间：${data.resultData.loan.application.earliestTime }</div>
				<div class="attr">最近申请时间：${data.resultData.loan.application.latestTime }</div>
				<div class="attr">最小申请额度：${data.resultData.loan.application.minAmount }</div>
				<div class="attr">最大申请额度：${data.resultData.loan.application.maxAmount }</div>
				<div class="attr">累计额度：${data.resultData.loan.application.totalAmount }</div>
			</li>
		</ul>
		<div class="rptSplit"></div>
		<ul class="am-avg-sm-2 rptCnt">
			<li class="credit">
				<div class="attr">
					<span>放款情况</span>
				</div>
			</li>
			<li class="base">
				<div class="attr">放款银行数量：${data.resultData.loan.approval.bankCount }</div>
				<div class="attr">放款非银行数量：${data.resultData.loan.approval.nonBankCount }</div>
				<div class="attr">最早放款时间：${data.resultData.loan.approval.earliestTime }</div>
				<div class="attr">最近放款时间：${data.resultData.loan.approval.latestTime }</div>
				<div class="attr">最小放款额度：${data.resultData.loan.approval.minAmount }</div>
				<div class="attr">最大放款额度：${data.resultData.loan.approval.maxAmount }</div>
				<div class="attr">累计额度：${data.resultData.loan.approval.totalAmount }</div>
				<div class="attr">最近放款距今月数：${data.resultData.loan.approval.monthToLatestApproval }</div>
			</li>
		</ul>
	</div>
	<!-- 逾期风险 -->
	<div class="p-yhOrder-rpt p-boxShadow am-radius-lg">
		<div class="rptTitle">逾期风险</div>
		<ul class="am-avg-sm-2 rptCnt">
			<li class="credit">
				<div class="attr">
					<span>驳回情况</span>
				</div>
			</li>
			<li class="base">
				<div class="attr">银行驳回次数：${data.resultData.loan.rejection.bankCount }</div>
				<div class="attr">非银行驳回次数：${data.resultData.loan.rejection.nonBankCount }</div>
			</li>
		</ul>
		<div class="rptSplit"></div>
		<ul class="am-avg-sm-2 rptCnt">
			<li class="credit">
				<div class="attr">
					<span>逾期情况</span>
				</div>
			</li>
			<li class="base">
				<div class="attr">累计逾期次数：${data.resultData.loan.overdue.count }</div>
				<div class="attr">累积逾期金额：${data.resultData.loan.overdue.totalAmount }</div>
				<div class="attr">最早逾期时间：${data.resultData.loan.overdue.earliestTime }</div>
				<div class="attr">最近逾期时间：${data.resultData.loan.overdue.latestTime }</div>
				<div class="attr">最近逾期时间距今月数：${data.resultData.loan.overdue.monthToLatestOverdue }</div>
				<div class="attr">最小逾期额度：${data.resultData.loan.overdue.minAmount }</div>
				<div class="attr">最大逾期额度：${data.resultData.loan.overdue.maxAmount }</div>
				<div class="attr">累计逾期额度：${data.resultData.loan.overdue.totalAmount }</div>
			</li>
		</ul>
	</div>
	<!-- 不良信息详情 -->
	<div class="p-yhOrder-rpt p-boxShadow am-radius-lg">
		<div class="rptTitle">不良信息详情</div>
		<p>提示： 个人每类风险概要信息仅展示前20条</p>
		<ul class="am-avg-sm-2 rptCnt">
			<li class="credit">
				<div class="attr">
					<span>失信信息${data.resultData.badJudicialRecord.dishonest.count }条</span>
				</div>
			</li>
			
				<li class="base">		
					<ul>
						<c:forEach items = "${data.resultData.badJudicialRecord.dishonest.items }" var="itemmap">
							<li>${itemmap.time }    ${itemmap.situation}    ${itemmap.execution }</li>
						</c:forEach>
					</ul>
				</li>
			
			
		</ul>
		<div class="rptSplit"></div>
		<ul class="am-avg-sm-2 rptCnt">
			<li class="credit">
				<div class="attr">
					<span>执行信息${data.resultData.badJudicialRecord.executed.count }条</span>
				</div>
			</li>
			<li class="base">	
				<ul>
						<c:forEach items = "${data.resultData.badJudicialRecord.executed.items }" var="itemmap">
							<li>${itemmap.time }  
							<c:if test="${itemmap.state == '0'} ? '执行中' : '已结案' "></c:if>  
							${itemmap.amount }</li>
						</c:forEach>
					</ul>
			</li>
		</ul>
		<div class="rptSplit"></div>
		<ul class="am-avg-sm-2 rptCnt">
			<li class="credit">
				<div class="attr">
					<span>案件信息${data.resultData.badJudicialRecord.lawCase.count }条</span>
				</div>
			</li>
			<li class="base">	
				<ul>
						<c:forEach items = "${data.resultData.badJudicialRecord.lawCase.items }" var="itemmap">
							<li>${itemmap.time }<br>   
							${itemmap.caseCause }<br> 
							${itemmap.title }<br> 
							${itemmap.judgeResult }</li>
						</c:forEach>
					</ul>
			</li>
		</ul>
		<div class="rptSplit"></div>
		<ul class="am-avg-sm-2 rptCnt">
			<li class="credit">
				<div class="attr">
					<span>网贷逾期${data.resultData.badJudicialRecord.netLoanOverdue.count }条</span>
				</div>
			</li>
			<li class="base">		
				<ul>
						<c:forEach items = "${data.resultData.badJudicialRecord.netLoanOverdue.items }" var="itemmap">
							<li>信息更新时间: ${itemmap.lastUpdateTime }   
							未还/罚息: ${itemmap.unpaidAmount }   
							本金/本息: ${itemmap.totalAmount }   
							数据来源单位: ${itemmap.dataSource }
							贷款时间: ${itemmap.time }</li>
						</c:forEach>
					</ul>
			</li>
		</ul>
		<div class="rptSplit"></div>
		<ul class="am-avg-sm-2 rptCnt">
			<li class="credit">
				<div class="attr">
					<span>催收公告${data.resultData.badJudicialRecord.callLoan.count }条</span>
				</div>
			</li>
			<li class="base">		
				<ul>
						<c:forEach items = "${data.resultData.badJudicialRecord.callLoan.items }" var="itemmap">
							<li>${itemmap.time }   
							${itemmap.caseCause }   
							${itemmap.amount }</li>
						</c:forEach>
					</ul>
			</li>
		</ul>
		<div class="rptSplit"></div>
		<ul class="am-avg-sm-2 rptCnt">
			<li class="credit">
				<div class="attr">
					<span>开庭公告${data.resultData.badJudicialRecord.courtNotice.count }条</span>
				</div>
			</li>
			<li class="base">		
				<ul>
						<c:forEach items = "${data.resultData.badJudicialRecord.courtNotice.items }" var="itemmap">
							<li>${itemmap.time }   
							${itemmap.caseCause }   
						</c:forEach>
					</ul>
			</li>
		</ul>
		<div class="rptSplit"></div>
		<ul class="am-avg-sm-2 rptCnt">
			<li class="credit">
				<div class="attr">
					<span>法院公告${data.resultData.badJudicialRecord.courtAnnouncement.count }条</span>
				</div>
			</li>
			<li class="base">		
				<ul>
						<c:forEach items = "${data.resultData.badJudicialRecord.courtAnnouncement.items }" var="itemmap">
							<li>${itemmap.time }   
							${itemmap.type }   
						</c:forEach>
					</ul>
			</li>
		</ul>
		<div class="rptSplit"></div>
		<ul class="am-avg-sm-2 rptCnt">
			<li class="credit">
				<div class="attr">
					<span>案件流程${data.resultData.badJudicialRecord.lawCaseProcess.count }条</span>
				</div>
			</li>
			<li class="base">		
				<ul>
						<c:forEach items = "${data.resultData.badJudicialRecord.lawCaseProcess.items }" var="itemmap">
							<li>${itemmap.time }   
							${itemmap.status }   
						</c:forEach>
					</ul>
			</li>
		</ul>
	</div>
</div>
</body></html>