<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div  class="ng-scope">

    <ul id="myTab1" class="nav nav-tabs">
         <c:if  test="${fn:contains(sessionScope.pd.purview_map,'sfrz')==true}">
        <li  class="active">
            <a href="#sfrz" data-toggle="tab">身份认证</a>
        </li>
        </c:if>
        <c:if  test="${fn:contains(sessionScope.pd.purview_map,'sjhm')==true}">
        <li >
            <a href="#sjhm" data-toggle="tab">手机号码</a>
        </li>
        </c:if>
        <c:if  test="${fn:contains(sessionScope.pd.purview_map,'mzmd')==true}">
         <li>
            <a href="#mzmd" data-toggle="tab">命中名单</a>
        </li>
        </c:if>
        <c:if  test="${fn:contains(sessionScope.pd.purview_map,'grfxxx')==true}">
         <li>
            <a href="#grfx" data-toggle="tab">个人风险信息 </a>
        </li>
        </c:if>
        <c:if  test="${fn:contains(sessionScope.pd.purview_map,'bjgcxxx')==true}">
         <li>
            <a href="#jg" data-toggle="tab">被机构查询信息</a>
        </li>
        </c:if>
        <c:if  test="${fn:contains(sessionScope.pd.purview_map,'fqzbg')==true}">
         <li>
            <a href="#fqz" data-toggle="tab">反欺诈报告</a>
        </li>
        </c:if>
        <c:if  test="${fn:contains(sessionScope.pd.purview_map,'zxbg')==true}">
         <li>
            <a href="#zxbg" data-toggle="tab">征信报告</a>
        </li>
        </c:if>
     
    </ul>
    <div id="myTab1Content" class="tab-content">
    <div id="sfrz" class="tab-pane fade active in">
    	<h4><font color="purple"> 查询条件</font></h4>
    	 <hr style="border:3px solid purple;margin-top:0px" width="100%" size="2" color="purple">
       <table class="table table-bordered">
			<thead>
				<tr>
					<!--  -->
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">姓名</th><!--   -->
					<!--  -->
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">证件号码</th><!--   -->
				</tr>
				<tr>
					<td class="ng-binding">${pd.c_name }</td>
					<td class="ng-binding">${pd.c_cardno }</td>

				</tr>
				<tr>
					<!--  -->
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">手机号码</th>
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">查询时间</th>
					<!--   -->
					<!--  -->
					<!-- <th ng-if="action=='update'||action=='detail'" class="ng-scope">查询时间</th> -->
					<!--   -->
				</tr>
				<tr>
					<td class="ng-binding">${pd.c_tel }</td>
					<td class="ng-binding"><fmt:formatDate value="${pd.dt_add }"
											pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<!-- <td class="ng-binding">20180515 14:41:58</td> -->
				</tr>
			</thead>
		</table>
		<h4><font color="purple"> 身份认证</font></h4>
		<hr style="border:3px solid purple;margin-top:0px" width="100%" size="2" color="purple">
       <table class="table table-bordered">
			<thead>
				<tr>
					<!--  -->
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">姓名</th><!--   -->
					<!--  -->
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">证件号码</th><!--   -->
				</tr>
				<tr>
					<td class="ng-binding">${pd.c_name }</td>
					<td class="ng-binding">${pd.c_cardno }</td>

				</tr>
				<tr>
					<!--  -->
					<th ng-if="action=='update'||action=='detail'" colspan="2" class="ng-scope">认证结果</th><!--   -->
				</tr>
				<tr>
					<!-- ngIf: data.cisReport.policeCheckInfo.policeCheckInfoItem.result=='1' -->
					<td colspan="2" ng-if="data.cisReport.policeCheckInfo.policeCheckInfoItem.result=='1'" class="ng-scope">身份认证结果:<font color="green">一致</font></td>
					<!--  ngIf: data.cisReport.policeCheckInfo.policeCheckInfoItem.result=='1' -->
					<!-- ngIf: data.cisReport.policeCheckInfo.policeCheckInfoItem.result=='2' -->
				</tr>
			</thead>
		</table>
    </div>
    <div class="tab-pane fade" id="sjhm">
     <h4><font color="purple">手机号码核查结果</font></h4>
      <hr style="border:3px solid purple;margin-top:0px" width="100%" size="2" color="purple">
       <table class="table table-bordered">
			<tbody><tr>
				<td rowspan="3" style=" vertical-align:middle">核查条件</td>
				<td>姓名</td>
				<td class="ng-binding">${pd.c_name }</td>
			</tr>
			<tr>
				<td>证件号码</td>
				<td class="ng-binding">${pd.c_cardno }9</td>
			</tr>
			<tr>
				<td>手机号码</td>
				<td class="ng-binding">${pd.c_tel }</td>
			</tr>
			<tr>
				<td>核查结果</td>
				<td colspan="2" class="ng-binding">一致</td>
			</tr>
		</tbody></table>
		<h4><font color="purple"> 手机号码信息</font></h4>
		<hr style="border:3px solid purple;margin-top:0px" width="100%" size="2" color="purple">
        <table class="table table-bordered">
			<tbody><tr>
				<td>手机号码</td>
				<td class="ng-binding">${pd.c_tel }</td>
			</tr>
			<tr>
				<td>运营商名称</td>
				<td class="ng-binding">中国移动</td>
			</tr>
			<tr>
				<td>手机号码归属地</td>
				<td class="ng-binding">福建省福州市</td>
			</tr>
			<tr>
				<td>手机号码状态</td>
				<td class="ng-binding">正常在用</td>
			</tr>
			<tr>
				<td>手机号在网时长</td>
				<td class="ng-binding">24个月以上</td>
			</tr>
		</tbody></table>
    </div>
	<div class="tab-pane fade" id="fqz">
		<h4>
			<font color="purple"> 反欺诈分析综述</font>
		</h4>
		<hr style="border: 3px solid purple; margin-top: 0px" width="100%" size="2" color="purple">
		<pre>			<div style="margin-left: -100px">
				<font class="ng-binding" size="3px">
		1、反欺诈风险评分为1分，风险等级为低，建议通过。
		2、中国移动手机号码${pd.c_tel }已使用24个月以上。
		3、未命中羊毛党名单。
		4、未命中欺诈风险名单。
		5、未命中高风险名单。
		6、在近两年被机构查询过5次个人信息。
	</font>
			</div>
		</pre>
		<h4>
			<font color="purple"> 反欺诈风险评分</font>
		</h4>
		<hr style="border: 3px solid purple; margin-top: 0px" width="100%" size="2" color="purple">
		<div style="margin-left: 15%">
			<strong><font class="ng-binding" size="4px" color="red">检测到低风险信息
					&nbsp;
					&nbsp;&nbsp;&nbsp;&nbsp;建议通过</font>
			</strong>
		</div>
		<div style="width: 85%; margin-left: 15%">
			<div style="width: 1%">
				<div style="float: right; margin-bottom: -5px">
					<i class="fa fa-caret-down" style="font-size: 20px" aria-hidden="true"></i>
				</div>
			</div>
		</div>
		<div style="clear: both">
			<div style="float: left; width: 15%">
				<font color="red">风险评分：<font class="ng-binding" size="4px">1分</font>&nbsp;
				</font>
			</div>
			<div class="progress" style="margin: auto; height: 22px">
				<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 50%;">
					<span> 低</span>
				</div>
				<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 25%;">
					<span> 中</span>
				</div>
				<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 25%;">
					<span> 高</span>
				</div>

			</div>
			<div style="clear: both">
				<div style="float: left; margin-left: 15%">0</div>
				<div>
					<div style="float: left; margin-left: 40.5%">50</div>
					<div style="float: left; margin-left: 20%">75</div>
					<div style="margin-left: 98%">100</div>
				</div>
			</div>
		</div>
		<div style="margin-top: 5px;">
			<font class="ng-binding" size="3px" color="black">命中:被机构查询信息
			</font>
		</div>
		<div style="background: #EAEAEA; color: #000; margin-top: 20px" class="ng-binding">
			提示信息：<br>风险评分值介于0到100分之间，分值越高， 风险值越高， 代表欺诈风险越高。<br>风险评分将分数0到100分为三级，
			该用户处于第一级。
		</div>
	</div>

	<div class="tab-pane fade" id="mzmd">
     <h4><font color="purple">羊毛党名单</font></h4>
      <hr style="border:3px solid purple;margin-top:0px" width="100%" size="2" color="purple">
       <table class="table table-bordered">
			<tbody><tr>
				<td style="background: #EAEAEA; color: #000;width:38%">身份信息 是否命中 羊毛党名单</td>
				<td class="ng-binding">否</td>
			</tr>
		</tbody></table>
		<h4><font color="purple"> 欺诈风险名单</font></h4>
		 <hr style="border:3px solid purple;margin-top:0px" width="100%" size="2" color="purple">
       <table class="table table-bordered">
		<tbody><tr>
				<td style="background: #EAEAEA; color: #000;width:38%">身份信息 是否命中 欺诈风险</td>
				<td class="ng-binding">否</td>
			</tr>
		</tbody></table>
		    <h4><font color="purple">高危人员名单</font></h4>
      <hr style="border:3px solid purple;margin-top:0px" width="100%" size="2" color="purple">
       <table class="table table-bordered">
			<tbody><tr>
				<td style="background: #EAEAEA; color: #000;width:38%">高危人员名单身份信息 是否命中高危人员名单 </td>
				<td class="ng-binding">否</td>
			</tr>
		</tbody></table>
		<h4><font color="purple">信贷逾期名单</font></h4>
		 <hr style="border:3px solid purple;margin-top:0px" width="100%" size="2" color="purple">
		 <font>证件号码命中汇总</font>
       <table class="table table-bordered">
			    <tbody><tr>
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">序号</th>
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">逾期类型</th>
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">逾期本金</th>
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">逾期总笔数</th>
				</tr>
				<tr>
					<td>1</td>
					<td class="ng-binding"></td>
					<td class="ng-binding"></td>
					<td class="ng-binding"></td>
				</tr>
		</tbody></table>
			<font>证件号码命中详情</font>
       <table st-table="displayedList" st-safe-src="data.cisReport.microNearlyThreeYearsOverdueInfo.items.item" class="table table-bordered">
			    <tbody><tr>
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">序号</th>
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">逾期类型</th>
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">逾期本金</th>
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">逾期总笔数</th>
				</tr>
				
		</tbody></table>
		
		<div style="background: #EAEAEA; color: #000;"> 提示： 信贷逾期名单采用的是近三年内的逾期数据。</div>
    </div>
    
<div class="tab-pane fade" id="grfx">
     <h4><font color="purple">个人风险信息</font></h4>
      <hr style="border:3px solid purple;margin-top:0px" width="100%" size="2" color="purple">
        <h4><font color="purple"> 汇总信息</font></h4>
       <table class="table table-bordered">
			<tbody><tr>
				<td style="background: #EAEAEA; color: #000;width:38%">执行信息</td>
				<td class="ng-binding"></td>
				<td style="background: #EAEAEA; color: #000;width:38%">税务行政执法信息</td>
				<td class="ng-binding"></td>
			</tr>
				<tr>
				<td style="background: #EAEAEA; color: #000;width:38%">失信信息</td>
				<td class="ng-binding"></td>
				<td style="background: #EAEAEA; color: #000;width:38%">网贷逾期信息</td>
				<td class="ng-binding"></td>
			</tr>
				<tr>
				<td style="background: #EAEAEA; color: #000;width:38%">案例信息</td>
				<td class="ng-binding"></td>
				<td style="background: #EAEAEA; color: #000;width:38%">催欠公告信息</td>
				<td class="ng-binding"></td>
			</tr>
		</tbody></table>
		<div ng-click="isShowInfo=isShowInfo?false:true" style="font-size:18px"><div style="float:left" class="ng-binding">概要信息(共条概要信息)</div><div style="margin-left:92%"><i class="fa fa-chevron-down" aria-hidden="true" ng-show="!isShowInfo">展开</i> <i class="fa fa-chevron-up ng-hide" aria-hidden="true" ng-show="isShowInfo">收起</i></div></div>
    <div ng-show="isShowInfo" class="ng-hide">
    <h5 class="ng-binding">执行信息(条概要信息)</h5>
     <table st-table="displayedList1" st-safe-src="data.cisReport.personRiskInfo.summary.zxs.item" class="table table-bordered">
			    <tbody><tr style="background: #EAEAEA; color: #000;">
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">序号</th>
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">标题</th>
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">执行标的</th>
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">立案日期</th>
				</tr>
				
		</tbody></table>
		    <h5 class="ng-binding">失信信息(条概要信息)</h5>
     <table st-table="displayedList2" st-safe-src="data.cisReport.personRiskInfo.summary.sxs.item" class="table table-bordered">
			    <tbody><tr style="background: #EAEAEA; color: #000;">
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">序号</th>
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">标题</th>
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">立案日期</th>
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">发布日期</th>
				
		</tbody></table>
		 <h5 class="ng-binding">案例信息(条概要信息)</h5>
     <table st-table="displayedList3" st-safe-src="data.cisReport.personRiskInfo.summary.als.item" class="table table-bordered">
			    <tbody><tr style="background: #EAEAEA; color: #000;">
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">序号</th> 
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">标题</th> 
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">案件类型</th> 
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">审结年份</th> 
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">当事人类型</th> 
				</tr>
				
		</tbody></table>
		 <h5 class="ng-binding">税务行政执法信息(条概要信息)</h5>
     <table st-table="displayedList4" st-safe-src="data.cisReport.personRiskInfo.summary.sws.item" class="table table-bordered">
			    <tbody><tr style="background: #EAEAEA; color: #000;">
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">序号</th>
					 
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">标题</th>
					 
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">公告日期</th>
					 
				</tr>
				
		</tbody></table>
		
		 <h5 class="ng-binding">网贷逾期信息(条概要信息)</h5>
     <table st-table="displayedList5" st-safe-src="data.cisReport.personRiskInfo.summary.wdyqs.item" class="table table-bordered">
			    <tbody><tr style="background: #EAEAEA; color: #000;">
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">序号</th>
					 
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">标题</th>
					 
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">发布日期</th>
					 
				</tr>
				
		</tbody></table>
		
				 <h5 class="ng-binding">催欠公告信息(条概要信息)</h5>
     <table st-table="displayedList5" st-safe-src="data.cisReport.personRiskInfo.summary.cqs.item" class="table table-bordered">
			    <tbody><tr style="background: #EAEAEA; color: #000;">
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">序号</th>
					 
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">标题</th>
					 
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">发布日期</th>
					 
				</tr>
				
		</tbody></table>
    </div>
    </div>
    
     <div class="tab-pane fade" id="jg">
     <h4><font color="purple">被机构查询信息</font></h4>
      <hr style="border:3px solid purple;margin-top:0px" width="100%" size="2" color="purple">
      <table st-table="displayedList6" st-safe-src="data.cisReport.historySimpleQueryInfo.items.item" class="table table-bordered">
			    <tbody><tr style="background: #EAEAEA; color: #000;">
					
					<th ng-if="action=	='update'||action=='detail'" class="ng-scope">类别|时间</th> 
					
					<th ng-if="action=='update'||action=='detail'" class="ng-scope">近1个月</th> 
				    
				    <th ng-if="action=='update'||action=='detail'" class="ng-scope">近3个月</th> 
				    
				    <th ng-if="action=='update'||action=='detail'" class="ng-scope">近6个月</th> 
				    
				    <th ng-if="action=='update'||action=='detail'" class="ng-scope">近12个月</th> 
				    
				    <th ng-if="action=='update'||action=='detail'" class="ng-scope">近18个月</th> 
				    
				    <th ng-if="action=='update'||action=='detail'" class="ng-scope">近24个月</th> 
				</tr>
				<tr ng-repeat="item in displayedList6" class="ng-scope">
				    <td class="ng-binding">商业银行</td>
					<td class="ng-binding">0</td>
					<td class="ng-binding">0</td>
					<td class="ng-binding">0</td>
					<td class="ng-binding">0</td>
					<td class="ng-binding">3</td>
					<td class="ng-binding">4</td>
				</tr> <tr ng-repeat="item in displayedList6" class="ng-scope">
				    <td class="ng-binding">互联网金融</td>
					<td class="ng-binding">1</td>
					<td class="ng-binding">1</td>
					<td class="ng-binding">1</td>
					<td class="ng-binding">1</td>
					<td class="ng-binding">1</td>
					<td class="ng-binding">1</td>
				</tr> 
					<tr>
				    <td>合计</td>
					<td class="ng-binding">1</td>
					<td class="ng-binding">1</td>
					<td class="ng-binding">1</td>
					<td class="ng-binding">1</td>
					<td class="ng-binding">4</td>
					<td class="ng-binding">5</td>
				</tr>
		</tbody></table> 
    </div>
        
      <div class="tab-pane fade" id="zxbg">
     <h4><font color="purple">征信报告</font></h4>
      <hr style="border:3px solid purple;margin-top:0px" width="100%" size="2" color="purple">
      <c:if test="${!empty pd.zx_result }">
      <h5 class="ng-binding">主贷人征信</h5>
      <div style="background: #EAEAEA; color: #000;"> 
      <textarea class="form-control" style="width: 100%; height: 100%;" rows="" cols="">${pd.zx_result }</textarea>
      </div>
      </c:if>
      
      <c:if test="${!empty pd.gjr_zx_result1 }">
      <h5 class="ng-binding">共还人1征信</h5>
      <div style="background: #EAEAEA; color: #000;"> 
      <textarea class="form-control" style="width: 100%; height: 100%;" rows="" cols="">${pd.zx_result }</textarea>
      </div>
      </c:if>
      
      <c:if test="${!empty pd.gjr_zx_result2 }">
      <h5 class="ng-binding">共还人2征信</h5>
      <div style="background: #EAEAEA; color: #000;"> 
      <textarea class="form-control" style="width: 100%; height: 100%;" rows="" cols="">${pd.zx_result }</textarea>
      </div>
      </c:if>
      
      <c:if test="${!empty pd.po_zx_result }">
      <h5 class="ng-binding">主贷人配偶征信</h5>
      <div style="background: #EAEAEA; color: #000;"> 
      <textarea class="form-control" style="width: 100%; height: 100%;" rows="" cols="">${pd.zx_result }</textarea>
      </div>
      </c:if>
      </div>
    </div></div>
<c:if test="${requestScope.type!='wdrw' }">
<div class="modal-footer">
<button onclick="location.href='${pageContext.request.contextPath}/erp/user_list_.do?type=wlghd&dn=${requestScope.cn }&qn=list&pagesize=10&pagenow=1'" class="btn btn-warning" >取消</button>
<button onclick="location.href=''" class="btn btn-primary" >提交</button>
</div>
</c:if>