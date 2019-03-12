<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/jquery.slimscroll.js " type="text/javascript"></script>
<aside class="main-sidebar" style="background-color:#12122b; ">
	<!-- sidebar: style can be found in sidebar.less -->
	<div class="slimScrollDiv">
	<section class="sidebar">
		<!-- Sidebar Menu -->
		<ul   class="sidebar-menu">
		<c:if  test="${fn:contains(sessionScope.pd.purview_map,'glzx')==true}">
		<li ${requestScope.type=='glzx'?"class='treeview active'":''}>
		<a href="${pageContext.request.contextPath }/erp/index.do"> 
		<i class="fa fa-home"></i> 
		<span>管理中心首页</span>
		</a>
		</li>
		</c:if>
		<!--  -->
		<c:if  test="${fn:contains(sessionScope.pd.purview_map,'gzrw')==true}">
		<li ${ requestScope.type eq 'wdrw'?"class='treeview active'":''}>
		<a href=""> 
		<i class="fa fa-tasks"></i> 
		<span>工作任务</span>
		</a>
		<ul class="treeview-menu">
        <c:if  test="${fn:contains(sessionScope.pd.purview_map,'qbrw')==true}">
		<li ${ requestScope.cn eq 'w0'?"class='treeview active'":''}>
		<a href="${pageContext.request.contextPath }/erp/wdrw_list.do?type=wdrw&dn=wdrw&qn=list&cn=w0&yw_id=${requestScope.yw_id}"> 
		<i class="fa fa-arrow-circle-o-right"></i>全部任务
		</a>
		</li>
        </c:if>
		<c:if  test="${fn:contains(sessionScope.pd.purview_map,'wdrw')==true}">
		<li ${ requestScope.cn eq 'w1'?"class='treeview active'":''}>
		<a href="${pageContext.request.contextPath }/erp/wdrw_list.do?type=wdrw&dn=wdrw&qn=list&cn=w1&yw_id=${requestScope.yw_id}"> 
		<i class="fa fa-arrow-circle-o-right"></i>我的任务
		</a>
		</li>
		</c:if>
		<c:if  test="${fn:contains(sessionScope.pd.purview_map,'wdcy')==true}">
		<li ${ requestScope.cn eq 'w2'?"class='treeview active'":''}>
		<a href="${pageContext.request.contextPath }/erp/wdrw_list.do?type=wdrw&dn=wdrw&qn=list&cn=w2&yw_id=${requestScope.yw_id}"> 
		<i class="fa fa-arrow-circle-o-right"></i>我参与的任务
		</a>
		</li>
		</c:if>
<%-- 		<c:if  test="${fn:contains(sessionScope.pd.purview_map,'wdqd')==true}">
		<li ${ requestScope.cn eq 'w3'?"class='treeview active'":''}>
		<a href="${pageContext.request.contextPath }/erp/wdrw_list.do?type=wdrw&dn=wdrw&qn=list&cn=w3&yw_id=${requestScope.yw_id}"> 
		<i class="fa fa-arrow-circle-o-right"></i>我启动的发起
		</a>
		</li>
		</c:if> --%>
		</ul>
		</li>
		</c:if>
		<!--  -->
			<!--  /// /// /// /// /// /// /// /// /// /// /// /// /// /// /// /// /// /// /// -->
             <c:if  test="${fn:contains(sessionScope.pd.purview_map,'zhgl')==true}">
		        <li ${requestScope.type=='zhgl'?"class='treeview active'":''} >
				<a href="#"> 
				<i class="fa fa-users"></i> <span>账户管理</span>
				</a>
				<ul class="treeview-menu">
				<c:if  test="${fn:contains(sessionScope.pd.purview_map,'gsgl')==true}">
				<li ${requestScope.dn=='assess_fs' and (requestScope.qn=='list' or requestScope.qn=='form')?"class='active'":''} >
				<a href="${pageContext.request.contextPath }/erp/user_list.do?type=zhgl&dn=assess_fs&qn=list"> 
				<i class="fa fa-arrow-circle-o-right"></i>公司管理
				</a>
				</li>
				</c:if>
<%-- 				<c:if  test="${fn:contains(sessionScope.pd.purview_map,'tjgs')==true}">
				<li ${requestScope.dn=='assess_fs' and requestScope.qn=='form'?"class='active'":''}>
                <a href="${pageContext.request.contextPath }/erp/index.do?type=zhgl&dn=assess_fs&qn=form&cn=1"> 
					<i class="fa fa-arrow-circle-o-right"></i>添加公司
					</a>
					</li>
				</c:if> --%>
				<c:if  test="${fn:contains(sessionScope.pd.purview_map,'rygl')==true}">
				<li ${requestScope.dn=='assess_gems' and (requestScope.qn=='list' or requestScope.qn=='form')?"class='active'":''}>
						<a href="${pageContext.request.contextPath }/erp/user_list.do?type=zhgl&dn=assess_gems&qn=list&cn=4001">
						 <i class="fa fa-arrow-circle-o-right"></i>人员管理
						</a>
					</li>
				</c:if>
<%-- 				<c:if  test="${fn:contains(sessionScope.pd.purview_map,'tjry')==true}">
				<li ${requestScope.dn=='assess_gems' and requestScope.qn=='form'?"class='active'":''}>
						<a href="${pageContext.request.contextPath }/erp/index.do?type=zhgl&dn=assess_gems&qn=form&cn=1"> 
						<i class="fa fa-arrow-circle-o-right"></i>添加人员
						</a>
					</li>
				</c:if> --%>
				<c:if  test="${fn:contains(sessionScope.pd.purview_map,'zhqx')==true}">	
					<li ${requestScope.dn=='icbc_erp_admin_agp' and (requestScope.qn=='form' or requestScope.qn=='list')?"class='active'":''}>
						<a href="${pageContext.request.contextPath }/erp/index.do?type=zhgl&dn=icbc_erp_admin_agp&qn=list">
						 <i class="fa fa-arrow-circle-o-right"></i>账号权限
						</a>
					</li>
				</c:if>
                    </ul>
			   </li>
		        </c:if>
		        <c:if  test="${fn:contains(sessionScope.pd.fs_zy_bank,'1')==true}">
		        <li>
				<a href="#"><i class="fa fa-bank"></i> 
				<span>杭州城站支行<!-- <small class="label pull-right bg-red">33</small> --></span>
				</a>
				<ul class="treeview-menu">
				    
				    <c:if  test="${fn:contains(sessionScope.pd.purview_map,'zx1')==true }">
					<li ${requestScope.dn=='zx' && requestScope.type=='hzczzh'?"class='active'":'' }>
					<a href="${pageContext.request.contextPath}/erp/index_.do?type=hzczzh&dn=zx&qn=list">
					<i class="fa fa-arrow-circle-o-right"></i>征信
					</a>
					</li>
					</c:if>
				    <c:if  test="${fn:contains(sessionScope.pd.purview_map,'qcpg1')==true}">
					<li ${requestScope.dn=='pg' && requestScope.type=='hzczzh'?"class='active'":''}>
						<a href="${pageContext.request.contextPath}/erp/index_.do?type=hzczzh&dn=pg&qn=list">
						<i class="fa fa-arrow-circle-o-right"></i>汽车评估</a>
					</li>	
					</c:if>

					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'ssmq1')==true}">
					<li ${requestScope.dn=='mq' && requestScope.type=='hzczzh'?"class='active'":''}>
					<a href="${pageContext.request.contextPath}/erp/index_.do?type=hzczzh&dn=mq&qn=list">
					<i class="fa fa-arrow-circle-o-right"></i>视频面签</a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'qcdk1')==true}">					
					<li ${requestScope.dn=='cardk' && requestScope.type=='hzczzh'?"class='active'":''}>
						<a href="${pageContext.request.contextPath}/erp/index_.do?type=hzczzh&dn=cardk&qn=list">
						<i class="fa fa-arrow-circle-o-right"></i>汽车贷款
						</a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'clhs1')==true}">
					<li>
						<a href="javascript:void(0);">
						<i class="fa fa-arrow-circle-o-right"></i>材料回收
						</a>
					</li>
					</c:if>
<!-- 					<li>
						<a href="">
						<i class="fa fa-arrow-circle-o-right"></i>视频连线
						</a>
					</li> -->
			        </ul>
			        </li>
	                </c:if>
	                <c:if test="${fn:contains(sessionScope.pd.fs_zy_bank,'2')==true}">
	                <li>
					<a href=""><i class="fa fa-bank"></i> 
				    <span>哈尔滨顾乡支行<!-- <small class="label pull-right bg-red">33</small> --></span>
				    </a>
				    <ul class="treeview-menu">
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'zx2')==true }">
					<li ${requestScope.dn=='zx' && requestScope.type=='hebgxzh'?"class='active'":''}>
					<a href="${pageContext.request.contextPath}/erp/index_.do?type=hebgxzh&dn=zx&qn=list">
					<i class="fa fa-arrow-circle-o-right"></i>征信
					</a>
					</li>
					</c:if>
				    <c:if  test="${fn:contains(sessionScope.pd.purview_map,'qcpg2')==true}">
					<li ${requestScope.dn=='pg' && requestScope.type=='hebgxzh'?"class='active'":''}>
						<a href="${pageContext.request.contextPath}/erp/index_.do?type=hebgxzh&dn=pg&qn=list">
						<i class="fa fa-arrow-circle-o-right"></i>汽车评估</a>
					</li>	
					</c:if>

					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'ssmq2')==true}">
					<li ${requestScope.dn=='mq' && requestScope.type=='hebgxzh'?"class='active'":''}>
					<a href="${pageContext.request.contextPath}/erp/index_.do?type=hebgxzh&dn=mq&qn=list">
					<i class="fa fa-arrow-circle-o-right"></i>视频面签</a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'qcdk2')==true}">					
					<li ${requestScope.dn=='cardk' && requestScope.type=='hebgxzh'?"class='active'":''}>
						<a href="${pageContext.request.contextPath}/erp/index_.do?type=hebgxzh&dn=cardk&qn=list">
						<i class="fa fa-arrow-circle-o-right"></i>汽车贷款
						</a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'clhs2')==true}">
					<li>
						<a href="javascript:void(0);">
						<i class="fa fa-arrow-circle-o-right"></i>材料回收
						</a>
					</li>
					</c:if>
			        </ul>
					</li>
					</c:if>
					<c:if test="${fn:contains(sessionScope.pd.fs_zy_bank,'3')==true}">
					<li>
					<a href="#"> <i class="fa fa-bank"></i> 
				    <span>台州路桥支行<!-- <small class="label pull-right bg-red">33</small> --></span>
				    </a>
				    <ul class="treeview-menu">
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'zx3')==true }">
					<li ${requestScope.dn=='zx' && requestScope.type=='tzlqzh'?"class='active'":''}>
					<a href="${pageContext.request.contextPath}/erp/index_.do?type=tzlqzh&dn=zx&qn=list">
					<i class="fa fa-arrow-circle-o-right"></i>征信
					</a>
					</li>
					</c:if>
				<c:if  test="${fn:contains(sessionScope.pd.purview_map,'qcpg3')==true}">
					<li ${requestScope.dn=='pg' && requestScope.type=='tzlqzh'?"class='active'":''}>
						<a href="${pageContext.request.contextPath}/erp/index_.do?type=tzlqzh&dn=pg&qn=list">
						<i class="fa fa-arrow-circle-o-right"></i>汽车评估</a>
					</li>	
					</c:if>

					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'ssmq3')==true}">
					<li ${requestScope.dn=='mq' && requestScope.type=='tzlqzh'?"class='active'":''}>
					<a href="${pageContext.request.contextPath}/erp/index_.do?type=tzlqzh&dn=mq&qn=list">
					<i class="fa fa-arrow-circle-o-right"></i>视频面签</a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'qcdk3')==true}">					
					<li ${requestScope.dn=='cardk' && requestScope.type=='tzlqzh'?"class='active'":''}>
						<a href="${pageContext.request.contextPath}/erp/index_.do?type=tzlqzh&dn=cardk&qn=list">
						<i class="fa fa-arrow-circle-o-right"></i>汽车贷款
						</a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'clhs3')==true}">
					<li>
						<a href="javascript:void(0);">
						<i class="fa fa-arrow-circle-o-right"></i>材料回收
						</a>
					</li>
					</c:if>
			        </ul>
					</li>
					</c:if>
					<c:if test="${fn:contains(sessionScope.pd.fs_zy_bank,'4')==true}">
					<li>
					<a href="#"> <i class="fa fa-bank"></i> 
				    <span>南京江宁支行<!-- <small class="label pull-right bg-red">33</small> --></span>
				    </a>
				    <ul class="treeview-menu">
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'zx4')==true }">
					<li ${requestScope.dn=='zx' && requestScope.type=='njjnzh'?"class='active'":''}>
					<a href="${pageContext.request.contextPath}/erp/index_.do?type=njjnzh&dn=zx&qn=list">
					<i class="fa fa-arrow-circle-o-right"></i>征信
					</a>
					</li>
					</c:if>
				<c:if  test="${fn:contains(sessionScope.pd.purview_map,'qcpg4')==true}">
					<li ${requestScope.dn=='pg' && requestScope.type=='njjnzh'?"class='active'":''}>
						<a href="${pageContext.request.contextPath}/erp/index_.do?type=njjnzh&dn=pg&qn=list">
						<i class="fa fa-arrow-circle-o-right"></i>汽车评估</a>
					</li>	
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'ssmq4')==true}">
					<li ${requestScope.dn=='mq' && requestScope.type=='njjnzh'?"class='active'":''}>
					<a href="${pageContext.request.contextPath}/erp/index_.do?type=njjnzh&dn=mq&qn=list">
					<i class="fa fa-arrow-circle-o-right"></i>视频面签</a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'qcdk4')==true}">					
					<li ${requestScope.dn=='cardk' && requestScope.type=='njjnzh'?"class='active'":''}>
						<a href="${pageContext.request.contextPath}/erp/index_.do?type=njjnzh&dn=cardk&qn=list">
						<i class="fa fa-arrow-circle-o-right"></i>汽车贷款
						</a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'clhs4')==true}">
					<li>
						<a href="javascript:void(0);">
						<i class="fa fa-arrow-circle-o-right"></i>材料回收
						</a>
					</li>
					</c:if>
			        </ul>
					</li>
					</c:if>
					<c:if test="${fn:contains(sessionScope.pd.fs_zy_bank,'5')==true}">
					<li>
					<a href="#"> <i class="fa fa-bank"></i> 
				    <span>杭州武林支行<!-- <small class="label pull-right bg-red">33</small> --></span>
				    </a>
				    <ul class="treeview-menu">
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'zx')==true }">
					<li ${requestScope.dn=='zx' && requestScope.type=='wlghd'?"class='active'":''}>
					<a href="${pageContext.request.contextPath}/erp/index_.do?type=wlghd&dn=zx&qn=list">
					<i class="fa fa-arrow-circle-o-right"></i>征信
					</a>
					</li>
					</c:if>
				<c:if  test="${fn:contains(sessionScope.pd.purview_map,'qcpg')==true}">
					<li ${requestScope.dn=='pg' && requestScope.type=='wlghd'?"class='active'":''}>
						<a href="${pageContext.request.contextPath}/erp/index_.do?type=wlghd&dn=pg&qn=list">
						<i class="fa fa-arrow-circle-o-right"></i>汽车评估</a>
					</li>	
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'kk')==true}">				
					<li ${requestScope.dn=='kk' && requestScope.type=='wlghd'?"class='active'":''}>
						<a href="${pageContext.request.contextPath}/erp/index_.do?type=wlghd&dn=kk&qn=list">
							<i class="fa fa-arrow-circle-o-right"></i>开卡
						</a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'ssmq')==true}">
					<li ${requestScope.dn=='mq' && requestScope.type=='wlghd'?"class='active'":''}>
					<a href="${pageContext.request.contextPath}/erp/index_.do?type=wlghd&dn=mq&qn=list">
					<i class="fa fa-arrow-circle-o-right"></i>视频面签</a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'qcdk')==true}">					
					<li ${requestScope.dn=='cardk' && requestScope.type=='wlghd'?"class='active'":''}>
						<a href="${pageContext.request.contextPath}/erp/index_.do?type=wlghd&dn=cardk&qn=list">
						<i class="fa fa-arrow-circle-o-right"></i>汽车贷款
						</a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'clhs')==true}">		
					<li>
						<a href="javascript:void(0);">
						<i class="fa fa-arrow-circle-o-right"></i>材料回收
						</a>
					</li>
					</c:if>
			        </ul>
					</li>
					</c:if>
					<!-- 视频面签 -->
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'zxsp')==true}">		
				   <li ${requestScope.dn=='yxVideo'?"class='active'":'' }>
				   <a href="${pageContext.request.contextPath}/erp/demo.do?type=hk&dn=yxVideo&qn=form"> 
				   <i class="fa fa-external-link"></i> 
				   <span>视频面签</span>
				   </a>
			       </li>
			       </c:if>
					<!-- 车辆抵押 -->
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'cldy')==true}">
					<li>
					<a href=""> <i class="fa fa-automobile"></i> 
				    <span>车辆抵押</span>
				    </a>
				       <ul class="treeview-menu">
					    	<li ${requestScope.type=='cldynot'?"class='active'":''}>
								<a href="${pageContext.request.contextPath}/vehicleMortgageController/mortgageRecord.do?type=cldynot&dn=VehicleMortgage&qn=list">
								<i class="fa fa-arrow-circle-o-right"></i>待处理
							    </a>
							</li>
							<li ${requestScope.type=='cldyalready'?"class='active'":''}>
								<a href="${pageContext.request.contextPath}/vehicleMortgageController/mortgageRecord.do?type=cldyalready&dn=VehicleMortgage&qn=list">
								<i class="fa fa-arrow-circle-o-right"></i>已处理
							    </a>
							</li>
					    </ul>
					</li>
					</c:if>
					<!-- GPS安装 -->
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'gpsaz')==true}">
					<li>
					<a href="#"> <i class="fa fa-wrench"></i> 
				    <span>GPS安装</span>
				    </a>
					</li>
					</c:if>
					<!-- 财务管理 -->
			    <c:if  test="${fn:contains(sessionScope.pd.purview_map,'cwgl')==true}">
			 	<li>
				<a href="#"> <i class="fa fa-dollar"></i> 
				<span>财务管理</span>
				</a>
				<ul class="treeview-menu">
				    <%-- <c:if  test="${fn:contains(sessionScope.pd.purview_map,'khdkmx')==true}">
					<li ${requestScope.dn=='cw' and requestScope.qn=='list'?"class='active'":''}>
					<a href="${pageContext.request.contextPath}/erp/demo.do?type=cw&dn=cw&qn=list">
					<i class="fa fa-arrow-circle-o-right"></i>客户贷款明细
					</a>
					</li>	
					</c:if> --%>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'dqywgl')==true}">
                    <li><a href="#"> 
                       <i class="fa fa-dollar"></i><span>贷前业务管理&nbsp;&nbsp;&nbsp;↓</span></a>
						<ul class="treeview-menu">
						<c:if  test="${fn:contains(sessionScope.pd.purview_map,'ywfksq')==true}">
							<li ${requestScope.type=='dqywgl6' && requestScope.dn=='businessPayApplication'?"class='active'":''}>
							<a href="${pageContext.request.contextPath }/erp/loanBefore_list.do?type=dqywgl6&dn=businessPayApplication&qn=list">
							<i class="fa fa-arrow-circle-o-right"></i>业务付款申请
						    </a>
							</li>
						</c:if>
						<c:if  test="${fn:contains(sessionScope.pd.purview_map,'dzjl')==true}">
							<li ${requestScope.type=='dqywgl7' && requestScope.dn=='matEndowmentResult'?"class='active'":''}>
							<a href="${pageContext.request.contextPath }/erp/matEndowentResult_list.do?type=dqywgl7&dn=matEndowmentResult&qn=list">
							<i class="fa fa-arrow-circle-o-right"></i>垫资记录
						    </a>
							</li>
						</c:if>	
						<c:if  test="${fn:contains(sessionScope.pd.purview_map,'fkjl')==true}">
							<li ${requestScope.type=='dqywgl8' && requestScope.dn=='lendingResult'?"class='active'":''}>
							<a href="${pageContext.request.contextPath }/erp/lengding_list.do?type=dqywgl8&dn=lendingResult&qn=list">
							<i class="fa fa-arrow-circle-o-right"></i>放款记录
						    </a>
							</li>
						</c:if>
						</ul>
					</li>
                    </c:if>

                    <c:if  test="${fn:contains(sessionScope.pd.purview_map,'dhywgl')==true}">
					<li><a href="#"><i class="fa fa-dollar"></i><span>贷后业务管理&nbsp;&nbsp;&nbsp;↓</span></a>
						<ul class="treeview-menu">
							<c:if  test="${fn:contains(sessionScope.pd.purview_map,'sqdc')==true}">
							<li ${requestScope.type=='dhywgl' && requestScope.dn=='businessPayApplication'?"class='active'":''}>
<a href="${pageContext.request.contextPath }/businessPayApplicationController/select.do?type=dhywgl&dn=businessPayApplication&qn=list">
							<i class="fa fa-arrow-circle-o-right"></i>申请代偿

						    </a>
							</li>
							</c:if>
							<c:if  test="${fn:contains(sessionScope.pd.purview_map,'dcqr')==true}">
							<li ${requestScope.type=='dhywgl' && requestScope.dn=='matEndowmentResult'?"class='active'":''}>
<a href="${pageContext.request.contextPath }/matEndiwmentResultControoller/select.do?type=dhywgl&dn=matEndowmentResult&qn=list">
							<i class="fa fa-arrow-circle-o-right"></i>代偿确认

						    </a>
							</li>
							</c:if>
							<c:if  test="${fn:contains(sessionScope.pd.purview_map,'hzsdc')==true}">
							<li ${requestScope.type=='dhywgl3' && requestScope.dn=='lendingResult'?"class='active'":''}>
							<a href="${pageContext.request.contextPath }/lendingResultController/select.do?type=dhywgl3&dn=lendingResult&qn=list&pagesize=10&pagenow=1">
							<i class="fa fa-arrow-circle-o-right"></i>合作商代偿
						    </a>
							</li>
							</c:if>
							<c:if  test="${fn:contains(sessionScope.pd.purview_map,'hzsdcqr')==true}">
							<li ${requestScope.type=='dhywgl4' && requestScope.dn=='lendingResult1'?"class='active'":''}>
							<a href="${pageContext.request.contextPath }/lendingResult1Controller/select.do?type=dhywgl4&dn=lendingResult1&qn=list&pagesize=10&pagenow=1">
							<i class="fa fa-arrow-circle-o-right"></i>合作商代偿确认
						    </a>
							</li>
							</c:if>
						</ul>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'gsdz')==true}">
					<li>
					<a href="javascript:void(0);">
					<i class="fa fa-arrow-circle-o-right"></i>公司垫资
				    </a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'cwgl_yhdk')==true}">
					<li ${requestScope.dn=='financeone'?"class='active'":''}>
					<a href="${pageContext.request.contextPath}/financialExcelController/bankLoan.do?type=cwgl&dn=financeone&qn=list">
					<i class="fa fa-arrow-circle-o-right"></i>银行贷款
				    </a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'cwsz')==true}">
					<li>
					<a href="javascript:void(0);">
					<i class="fa fa-arrow-circle-o-right"></i>财务收支
				    </a>
					</li>
					</c:if>
				</ul>
			</li>
			</c:if>
			        <!--客户还款管理  -->
			        <c:if  test="${fn:contains(sessionScope.pd.purview_map,'khhkgl')==true}">
			        <li>
					<a href="#"> <i class="fa fa-user"></i> 
				    <span>客户还款管理 </span>
				    </a>
				    <ul class="treeview-menu">
				    <c:if  test="${fn:contains(sessionScope.pd.purview_map,'khhklr')==true}">
					<li ${requestScope.dn=='dh_repaymentEntry'?"class='active'":''}>
					    <a href="${pageContext.request.contextPath }/uploadExcelController/select.do?type=khhklr&dn=dh_repaymentEntry&qn=list&pagesize=10&pagenow=1">
						<i class="fa fa-arrow-circle-o-right"></i>客户还款录入
					    </a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'khhkqk')==true}">
					<li ${requestScope.dn=='dh_repaymentSituation'?"class='active'":''}>
					
                        <a href="${pageContext.request.contextPath }/repaymentController/select.do?type=khhkqk&dn=dh_repaymentSituation&qn=list&pagesize=10&pagenow=1">
						<i class="fa fa-arrow-circle-o-right"></i>客户还款情况
					    </a>

					</li>
					</c:if>
				    </ul>
					</li>
					</c:if>
			        <!--客户逾期名单  -->
			        <c:if  test="${fn:contains(sessionScope.pd.purview_map,'khyqmd')==true}">
			        <li>
					<a href="${pageContext.request.contextPath }/overdueController/select.do?type=khyqmd&dn=overdue&qn=list&pagesize=10&pagenow=1"> <i class="fa fa-user"></i> 
				    <span>客户逾期名单</span>
				    </a>
					</li>
					</c:if>
			         <!--催缴作业  -->
			        <c:if  test="${fn:contains(sessionScope.pd.purview_map,'dczy')==true}">
			        <li ${requestScope.dn=='dh_electricOperation'?"class='active'":'' or requestScope.dn=='dh_repaymentTelReminders'?"class='active'":''}>
					<a href="${pageContext.request.contextPath}/electricityController/select.do?type=dczy&dn=dh_electricOperation&qn=list"> <i class="fa fa-file-text"></i> 
				    <span>电催作业 </span>
				    </a>
					</li>
					</c:if>
					<!--拖车管理  -->
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'tcgl')==true}">
			        <li>
					<a href="#"> <i class="fa fa-truck"></i> 
				    <span>拖车管理 </span>
				    </a>
				    <ul class="treeview-menu">
					<li ${requestScope.type=='tcglnot'?"class='active'":''}>
					<a href="${pageContext.request.contextPath}/trailernotAcceptedController/select1.do?type=tc_ysl&dn=TrailernotAccepted1&qn=list"> <i class="fa fa-arrow-circle-o-right"></i> 
				    <span>拖车(已受理)</span>
				    </a>
					</li>
					<li ${requestScope.type=='tcglalready'?"class='active'":''}>
					<a href="${pageContext.request.contextPath}/trailernotAcceptedController/select.do?type=tc_wsl&dn=TrailernotAccepted&qn=list"> <i class="fa fa-arrow-circle-o-right"></i> 
				    <span>拖车(未受理)</span>
				    </a>
					</li>
					<li ${requestScope.type=='tcglnot'?"class='active'":''}>
					<a href="${pageContext.request.contextPath}/trailernotAcceptedController/select2.do?type=tc_wc&dn=TrailernotAccepted2&qn=list"> <i class="fa fa-arrow-circle-o-right"></i> 
				    <span>拖车(完成)</span>
				    </a>
					</li>
				    </ul>
					</li>
					</c:if>
					<!--诉讼管理  -->
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'ssgl')==true}">
			        <li>
						<a href="#"> <i class="fa fa-exclamation-triangle"></i> 
					    <span>诉讼管理</span>
					    </a>
					    <ul class="treeview-menu">
							<li ${requestScope.type=='ssglnot'?"class='active'":''}>
								<a href="${pageContext.request.contextPath}/lawsuitController/select1.do?type=ssgl&dn=lawsuit1&qn=list"> <i class="fa fa-arrow-circle-o-right"></i> 
							    <span>已处理</span>
							    </a>
							</li>
							<li ${requestScope.type=='ssglalready'?"class='active'":''}>
								<a href="${pageContext.request.contextPath}/lawsuitController/select.do?type=ssgl&dn=lawsuit&qn=list"> <i class="fa fa-arrow-circle-o-right"></i> 
							    <span>待处理</span>
							    </a>
							</li>
					    </ul>
					</li>
					</c:if>
					<!--保险管理  -->
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'bxgl')==true}">
			        <li>
					<a href="#"> <i class="fa fa-h-square"></i> 
				    <span>保险管理 </span>
				    </a>
					</li>
					</c:if>
					<!--车险理赔  -->
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'cxlp')==true}">
			        <li>
					<a href="#"> <i class="fa fa-ambulance"></i> 
				    <span>车险理赔</span>
				    </a>
					</li>
					</c:if>
					<!--结清处理  -->
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'cqcl')==true}">
			        <li>
					<a href="#"> <i class="fa fa-sign-language"></i> 
				    <span>结清处理</span>
				    </a>
				    <ul class="treeview-menu">
				    <c:if  test="${fn:contains(sessionScope.pd.purview_map,'cqcl_yjq')==true}">
						<li ${requestScope.type=='cqclalready'?"class='active'":''}>
						<a href="${pageContext.request.contextPath}/settleController/select.do?type=cqcl_yjq&dn=settle&qn=list"> <i class="fa fa-arrow-circle-o-right"></i> 
					    <span>已结清</span>
					    </a>
						</li>
					</c:if>

				    </ul>
					</li>
					</c:if>
					<!--GPS管理  -->
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'gpsgl')==true}">
					<li ${requestScope.type=='gps'?"class='active'":''}>
			        <a href="${pageContext.request.contextPath}/erp/gps_list.do?type=gps&dn=gps&qn=list">
			         <i class="fa fa-list"></i>
			        <span style="color:#ffffff">GPS管理</span>
			        </a>
			        </li>
			        </c:if>
<%--  		<c:if  test="${fn:contains(sessionScope.pd.purview_map,'zxsp')==true}">
	            <c:if test="${fn:contains(sessionScope.pd.purview_map,'dhgl')==true}">					  
		         <li>
				<a href="#"> <i class="fa fa-external-link"></i> 
				<span>贷后管理</span>
				</a>
				<ul class="treeview-menu">
				    <c:if  test="${fn:contains(sessionScope.pd.purview_map,'yhhkxq')==true}">
					<li ${requestScope.dn=='hk' and requestScope.qn=='list'?"class='active'":''}>
					<a href="${pageContext.request.contextPath}/erp/demo.do?type=hk&dn=hk&qn=list">
					<i class="fa fa-arrow-circle-o-right"></i>用户还款详情
					</a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'yhhklr')==true}">
					<li  ${requestScope.dn=='hk' and requestScope.qn=='form'?"class='active'":''}>
						<a href="${pageContext.request.contextPath}/erp/demo.do?type=hk&dn=hk&qn=form">
						<i class="fa fa-arrow-circle-o-right"></i>
						客户还款录入</a>
					</li>
					</c:if>	
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'dclcjyq')==true}">
					<li>
						<a href="javascript:void(0)">
						<i class="fa fa-arrow-circle-o-right"></i>
						待处理初级逾期</a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'dclzjyq')==true}">
					<li>
						<a href="javascript:void(0)">
						<i class="fa fa-arrow-circle-o-right"></i>
						待处理中级逾期</a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'dclgjyq')==true}">
					<li>
						<a href="javascript:void(0)">
						<i class="fa fa-arrow-circle-o-right"></i>
						待处理高级逾期</a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'dcltc')==true}">
					<li>
						<a href="javascript:void(0)">
						<i class="fa fa-arrow-circle-o-right"></i>
						待处理拖车</a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'dclgs')==true}">
					<li>
						<a href="javascript:void(0)">
						<i class="fa fa-arrow-circle-o-right"></i>
						待处理公诉</a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'dhx')==true}">
					<li>
						<a href="javascript:void(0)">
						<i class="fa fa-arrow-circle-o-right"></i>
						待核销</a>
					</li>
					</c:if>
					<c:if  test="${fn:contains(sessionScope.pd.purview_map,'yhx')==true}">
					<li>
						<a href="javascript:void(0)">
						<i class="fa fa-arrow-circle-o-right"></i>
						已核销</a>
					</li>
					</c:if>
				</ul>
			   </li>
			</c:if>
			</c:if>  --%>
<%-- 			<c:if  test="${fn:contains(sessionScope.pd.purview_map,'clhsqk')==true}">
			 <li>
				<a href="${pageContext.request.contextPath}/erp/clhs_list.do?type=clhs&dn=clhs&qn=list"> <i class="fa fa-external-link"></i> 
					<span style="color:#ffffff">材料回收情况</span>
				</a>
			 </li>
			 </c:if> --%>

			 
						</ul> <!-- /.sidebar-menu -->
</section> <!-- /.sidebar -->
</div>
</aside>
<script>
$('li.active').parents('li').addClass('treeview').addClass('active');
/*使用JavaScript来实现*/

var  menuHeight = document.getElementById('menu');
 
var  screenHeight = window.innerHeight  //浏览器窗口的内部高度
/* var  screenHeight =  document.documentElement.clientHeight; */
menuHeight.style.height=screenHeight-80+"px";
 
 
/*使用jQuery来实现*/
 
/****方法一****/
$('.menu').height($(window).height()-80);
 
 /****方法二****/
/* $('.menu').css("height",$(window).height()-80); */
</script>