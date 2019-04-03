<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form id="info_form" action="${pageContext.request.contextPath }/erp/icbc_erp_admin_agp_add.do" class="form-horizontal" method="post" enctype="multipart/form-data">
		<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper fixed-footer" style="min-height: 943px;">
		<!-- Main content -->
		<section class="content">
			
				    <style>
                        .form-horizontal table .checkbox-inline{padding-top: 0; font-size:14px;}
                        /**
 * Create the slider bar
 */
.checkboxOne {
	width: 40px;
	height: 10px;
	background: #555;
	margin: 20px 80px;
	position: relative;
	border-radius: 3px;
}
.yangshi1{ font-weight:bold}

.yangshi2{ font-weight:800}
                    </style>

<div class="admin-content box">
	<div class="box-header with-border">
		<h3 class="box-title">管理员权限组编辑</h3>
	</div>
	<input  id="dn" name="dn" value="icbc_erp_admin_agp" type="hidden"  />
	<input  id="qn" name="qn" value="list" type="hidden"  />
	<input  id="type" name="type" value="zhgl" type="hidden"  />
	<input  id="cn" name="cn" value="${requestScope.cn}" type="hidden"  />
	<input  id="id" name="id" value="${requestScope.pd.id}" type="hidden"  />
	<input  id="qx" name="qx" value="${requestScope.pd.purview_map }" type="hidden"  />
	<div class="form-horizontal">
		<div class="box-body">
			    <div class="form-group">
				<label for="name" class="col-sm-2 control-label">管理组名称</label>
				<div class="col-sm-6">
					<input class="form-control" name="name" placeholder="" value="${requestScope.pd.name }" type="text">
				</div>
				
				</div>
			<div class="form-group">
			    <%-- <label class="col-sm-2 control-label">权限组模板</label>
				<div class="col-sm-2">
				<select id="modal_tag" name="modal_tag" class="form-control">
				 <option value="0">--请选择--</option>
				 <option value="0" ${requestScope.pd.modal_tag eq '0'?"selected='selected'":''}>否</option>
				 <option value="1" ${requestScope.pd.modal_tag eq '1'?"selected='selected'":''}>是</option>
				</select>
			    </div> --%>
			    <label class="col-sm-2 control-label">权限组类型</label>
				<div class="col-sm-2">
				<select id="qx_type" name="qx_type" class="form-control">
				 <option value="0">--请选择--</option>
				 <option value="1" ${requestScope.pd.qx_type eq '1'?"selected='selected'":''}>业务员</option>
				 <option value="2" ${requestScope.pd.qx_type eq '2'?"selected='selected'":''}>管理员/审核员</option>
				</select>
			    </div>
			</div>
			<div class="form-group">
				<label for="link" class="col-sm-2 control-label">权限列表</label>
				<div class="col-sm-10">
					<table class="table table-bordered table-hover">
						<tbody>
							    <tr>
								<th style="width: 140px">
								<label class="checkbox-inline"><input class="check_all" onclick="checkall(this,1)" type="checkbox">全选</label></th>
								<th><label class="checkbox-inline"><input class="check_all" onclick="checkall(this,2)" type="checkbox">全选</label></th>
							    </tr>
				
								<tr >
								<td >
								<label class="checkbox-inline">
								<input name="glzx" id="glzx" value="0" onclick="checkfl(this)" type="checkbox">
								<strong>管理中心</strong>							
								</label>
								</td>
								<td>
								</td>
				                </tr>		
				                <tr >
								<td>
								<label class="checkbox-inline">
								<input name="gzrw" id="gzrw" value="0" onclick="checkfl(this)" type="checkbox">工作任务</label>
								</td>
								<td id="gzrw1" name="node">
								<label class="checkbox-inline"><input name="qbrw" id="qbrw" value="0" onclick="check(this)" type="checkbox">全部任务</label>
								<label class="checkbox-inline"><input name="wdrw" id="wdrw" value="0" onclick="check(this)" type="checkbox">我的任务</label>
								<label class="checkbox-inline"><input name="wdcy" id="wdcy" value="0" onclick="check(this)" type="checkbox">我参与的任务</label>
								<!-- <label class="checkbox-inline"><input name="wdqd" id="wdqd" value="0" onclick="check(this)" type="checkbox">我启动的任务</label> -->
								</td>
				                </tr>				
				                <tr >
								<td>
								<label class="checkbox-inline"><input name="zhgl" id="zhgl" value="0" onclick="checkfl(this)" type="checkbox">账户管理</label>
								</td>
								<td id="zhgl1" name="node"> 
                                <table class="table table-bordered table-hover">
                                <tr>
                                <td>
                                <label class="checkbox-inline"><input name="gsgl" id="gsgl" value="0" onclick="check(this)" type="checkbox">公司管理</label>
                                </td >
                                <td>
                                <label class="checkbox-inline"><input name="gsgladd" id="gsgladd" value="0" onclick="check(this)" type="checkbox">新增</label>								
								<label class="checkbox-inline"><input name="gsgldelete" id="gsgldelete" value="0" onclick="check(this)" type="checkbox">删除</label>	
								<label class="checkbox-inline"><input name="gsglupdate" id="gsglupdate" value="0" onclick="check(this)" type="checkbox">编辑</label>							
								
                                </td>
                                </tr>
				                <tr>
				                <td> 
								<label class="checkbox-inline"><input name="zhqx" id="zhqx" value="0" onclick="check(this)" type="checkbox">账号权限</label>
								</td>
								<td>
								<label class="checkbox-inline"><input name="zhqxadd" id="zhqxadd" value="0" onclick="check(this)" type="checkbox">新增</label>								
								<label class="checkbox-inline"><input name="zhqxdelete" id="zhqxdelete" value="0" onclick="check(this)" type="checkbox">删除</label>	
								<label class="checkbox-inline"><input name="zhqxupdate" id="zhqxupdate" value="0" onclick="check(this)" type="checkbox">编辑</label>	
								</td>
				                </tr>	
                               	<tr>
				                <td> 
								<label class="checkbox-inline"><input name="rygl" id="rygl" value="0" onclick="check(this)" type="checkbox">人员管理</label>
								</td>
								<td>
								<label class="checkbox-inline"><input name="rygladd" id="rygladd" value="0" onclick="check(this)" type="checkbox">新增</label>								
								<label class="checkbox-inline"><input name="rygldelete" id="rygldelete" value="0" onclick="check(this)" type="checkbox">删除</label>	
								<label class="checkbox-inline"><input name="ryglupdate" id="ryglupdate" value="0" onclick="check(this)" type="checkbox">编辑</label>	
								</td>
				                </tr>
                                </table>
                                </td>								
				                </tr>	

			                    <!-- 杭州武林支行 -->
				                <tr>
								<td><label class="checkbox-inline"><input name="wlghd" id="wlghd" value="0" onclick="checkfl(this)" type="checkbox">杭州武林支行</label>
								</td>
								<td id="wlghd1" name="node"> 
								<label class="checkbox-inline"><input name="zx" id="zx" value="0" onclick="check(this)" type="checkbox">征信</label>
								<label class="checkbox-inline"><input name="qcpg" id="qcpg" value="0" onclick="check(this)" type="checkbox">汽车评估</label>
								<label class="checkbox-inline"><input name="kk" id="kk" value="0" onclick="check(this)" type="checkbox">开卡</label>
								<label class="checkbox-inline"><input name="ssmq" id="ssmq" value="0" onclick="check(this)" type="checkbox">视频面签</label>
								<label class="checkbox-inline"><input name="qcdk" id="qcdk" value="0" onclick="check(this)" type="checkbox">汽车贷款</label>
								<label class="checkbox-inline"><input name="clhs" id="clhs" value="0" onclick="check(this)" type="checkbox">材料回收</label>
								</td>
				                </tr>
				                <!-- 杭州城站支行 -->
				                <tr>
								<td><label class="checkbox-inline"><input name="hzczzh" id="hzczzh" value="0" onclick="checkfl(this)" type="checkbox">杭州城站支行</label>
								</td>
								<td id="hzczzh1" name="node"> 
								<label class="checkbox-inline"><input name="zx1" id="zx1" value="0" onclick="check(this)" type="checkbox">征信</label>
								<label class="checkbox-inline"><input name="qcpg1" id="qcpg1" value="0" onclick="check(this)" type="checkbox">汽车评估</label>
								<label class="checkbox-inline"><input name="ssmq1" id="ssmq1" value="0" onclick="check(this)" type="checkbox">视频面签</label>
								<label class="checkbox-inline"><input name="qcdk1" id="qcdk1" value="0" onclick="check(this)" type="checkbox">汽车贷款</label>
								<label class="checkbox-inline"><input name="clhs1" id="clhs1" value="0" onclick="check(this)" type="checkbox">材料回收</label>
								</td>
				                </tr>
				                <!-- 哈尔滨顾乡支行 -->
				                <tr>
								<td><label class="checkbox-inline"><input name="hebgxzh" id="hebgxzh" value="0" onclick="checkfl(this)" type="checkbox">哈尔滨顾乡支行</label>
								</td>
								<td id="hebgxzh1" name="node"> 
								<label class="checkbox-inline"><input name="zx2" id="zx2" value="0" onclick="check(this)" type="checkbox">征信</label>
								<label class="checkbox-inline"><input name="qcpg2" id="qcpg2" value="0" onclick="check(this)" type="checkbox">汽车评估</label>
								<label class="checkbox-inline"><input name="ssmq2" id="ssmq2" value="0" onclick="check(this)" type="checkbox">视频面签</label>
								<label class="checkbox-inline"><input name="qcdk2" id="qcdk2" value="0" onclick="check(this)" type="checkbox">汽车贷款</label>
								<label class="checkbox-inline"><input name="clhs2" id="clhs2" value="0" onclick="check(this)" type="checkbox">材料回收</label>
								</td>
				                </tr>
				                <!-- 台州路桥支行 -->
				                <tr>
								<td><label class="checkbox-inline"><input name="tzlqzh" id="tzlqzh" value="0" onclick="checkfl(this)" type="checkbox">台州路桥支行</label>
								</td>
								<td id="tzlqzh1" name="node"> 
								<label class="checkbox-inline"><input name="zx3" id="zx3" value="0" onclick="check(this)" type="checkbox">征信</label>
								<label class="checkbox-inline"><input name="qcpg3" id="qcpg3" value="0" onclick="check(this)" type="checkbox">汽车评估</label>
								<label class="checkbox-inline"><input name="ssmq3" id="ssmq3" value="0" onclick="check(this)" type="checkbox">视频面签</label>
								<label class="checkbox-inline"><input name="qcdk3" id="qcdk3" value="0" onclick="check(this)" type="checkbox">汽车贷款</label>
								<label class="checkbox-inline"><input name="clhs3" id="clhs3" value="0" onclick="check(this)" type="checkbox">材料回收</label>
								</td>
				                </tr>
				                <!-- 南京江宁支行 -->
				                <tr>
								<td><label class="checkbox-inline"><input name="njjnzh" id="njjnzh" value="0" onclick="checkfl(this)" type="checkbox">南京江宁支行</label>
								</td>
								<td id="njjnzh1" name="node"> 
								<label class="checkbox-inline"><input name="zx4" id="zx4" value="0" onclick="check(this)" type="checkbox">征信</label>
								<label class="checkbox-inline"><input name="qcpg4" id="qcpg4" value="0" onclick="check(this)" type="checkbox">汽车评估</label>
								<label class="checkbox-inline"><input name="ssmq4" id="ssmq4" value="0" onclick="check(this)" type="checkbox">视频面签</label>
								<label class="checkbox-inline"><input name="qcdk4" id="qcdk4" value="0" onclick="check(this)" type="checkbox">汽车贷款</label>
								<label class="checkbox-inline"><input name="clhs4" id="clhs4" value="0" onclick="check(this)" type="checkbox">材料回收</label>
								</td>
				                </tr>
<!-- 				                 <tr >
								<td><label class="checkbox-inline"><input name="dhgl" id="dhgl" value="0" onclick="checkfl(this)" type="checkbox">贷后管理</label>
								</td>
								<td id="dhgl1" name="node"> 
								<label class="checkbox-inline"><input name="yhhkxq" id="yhhkxq" value="0" onclick="check(this)" type="checkbox">用户还款详情</label>
								<label class="checkbox-inline"><input name="yhhklr" id="yhhklr" value="0" onclick="check(this)" type="checkbox">客户还款录入</label>
								<label class="checkbox-inline"><input name="dclcjyq" id="dclcjyq" value="0" onclick="check(this)" type="checkbox">待处理初级逾期</label>
								<label class="checkbox-inline"><input name="dclzjyq" id="dclzjyq" value="0" onclick="check(this)" type="checkbox">待处理中级逾期</label>
								<label class="checkbox-inline"><input name="dclgjyq" id="dclgjyq" value="0" onclick="check(this)" type="checkbox">待处理高级逾期</label>
								<label class="checkbox-inline"><input name="dcltc" id="dcltc" value="0" onclick="check(this)" type="checkbox">待处理拖车</label>
								<label class="checkbox-inline"><input name="dclgs" id="dclgs" value="0" onclick="check(this)" type="checkbox">待处理公诉</label>
								<label class="checkbox-inline"><input name="dhx" id="dhx" value="0" onclick="check(this)" type="checkbox">待核销</label>
								<label class="checkbox-inline"><input name="yhx" id="yhx" value="0" onclick="check(this)" type="checkbox">已核销</label>
								</td>
				                </tr> -->	
				                
				                <tr >
								<td><label class="checkbox-inline"><input name="cwgl" id="cwgl" value="0" onclick="checkfl(this)" type="checkbox">财务管理</label>
								</td>
								<td id="cwgl1" name="node"> 
								<label class="checkbox-inline"><input name="dqywgl" id="dqywgl" value="0" onclick="check(this)" type="checkbox">贷前业务管理</label>
								<label class="checkbox-inline"><input name="ywfksq" id="ywfksq" value="0" onclick="check(this)" type="checkbox">业务付款申请</label>
								<label class="checkbox-inline"><input name="dzjl" id="dzjl" value="0" onclick="check(this)" type="checkbox">垫资记录</label>
								<label class="checkbox-inline"><input name="fkjl" id="fkjl" value="0" onclick="check(this)" type="checkbox">放款记录</label>
								<label class="checkbox-inline"><input name="dhywgl" id="dhywgl" value="0" onclick="check(this)" type="checkbox">贷后业务管理</label>
								<label class="checkbox-inline"><input name="sqdc" id="sqdc" value="0" onclick="check(this)" type="checkbox">申请代偿</label>
								<label class="checkbox-inline"><input name="dcqr" id="dcqr" value="0" onclick="check(this)" type="checkbox">代偿确认</label>
								<label class="checkbox-inline"><input name="hzsdc" id="hzsdc" value="0" onclick="check(this)" type="checkbox">合作商代偿</label>
								<label class="checkbox-inline"><input name="hzsdcqr" id="hzsdcqr" value="0" onclick="check(this)" type="checkbox">合作商代偿确认</label>
								<label class="checkbox-inline"><input name="gsdz" id="gsdz" value="0" onclick="check(this)" type="checkbox">公司垫资</label>
								<label class="checkbox-inline"><input name="cwgl_yhdk" id="cwgl_yhdk" value="0" onclick="check(this)" type="checkbox">银行贷款</label>
								<label class="checkbox-inline"><input name="cwsz" id="cwsz" value="0" onclick="check(this)" type="checkbox">财务收支</label>
								</td>
				                </tr>	
				                <tr >
								<td><label class="checkbox-inline"><input name="zxsp" id="zxsp" value="0" onclick="checkfl(this)" type="checkbox">视频面签</label>
								</td>
								<td> 
								</td>
				                </tr>	
<!-- 				                <tr >
								<td>
								<label class="checkbox-inline"><input name="clhsqk" id="clhsqk" value="0" onclick="checkfl(this)" type="checkbox">材料回收情况</label>
								</td>
                                <td>
                                </td>
                                </tr> -->
                                <tr >
								<td>
								<label class="checkbox-inline"><input name="cldy" id="cldy" value="0" onclick="checkfl(this)" type="checkbox">车辆抵押</label>
								</td>
                                <td>
                                </td>
                                </tr>
				                <tr >
								<td>
								<label class="checkbox-inline"><input name="gpsaz" id="gpsaz" value="0" onclick="checkfl(this)" type="checkbox">GPS安装</label>
								</td>
                                <td>
                                </td>
                                </tr>
				                <tr >
								<td>
								<label class="checkbox-inline"><input name="gpsgl" id="gpsgl" value="0" onclick="checkfl(this)" type="checkbox">GPS管理</label>
								</td>
                                <td>
                                </td>
                                </tr>
				                <tr>
				                <!--  -->
				                <tr >
								<td>
								<label class="checkbox-inline"><input name="khhkgl" id="khhkgl" value="0" onclick="checkfl(this)" type="checkbox">客户还款管理</label>
								</td>
                                <td id="khhkgl1" name="node">
                                <label class="checkbox-inline"><input name="khhklr" id="khhklr" value="0" onclick="check(this)" type="checkbox">客户还款录入</label>
                                <label class="checkbox-inline"><input name="khhkqk" id="khhkqk" value="0" onclick="check(this)" type="checkbox">客户还款情况</label>
                                </td>
                                </tr>
                                <!-- 客户逾期名单 -->
                                <tr >
								<td>
								<label class="checkbox-inline"><input name="khyqmd" id="khyqmd" value="0" onclick="checkfl(this)" type="checkbox">客户逾期名单</label>
								</td>
                                <td>
                                </td>
                                </tr>
                                <!-- 电催作业 -->
                                <tr >
								<td>
								<label class="checkbox-inline"><input name="dczy" id="dczy" value="0" onclick="checkfl(this)" type="checkbox">电催作业</label>
								</td>
                                <td>
                                </td>
                                </tr>
                                <!-- 拖车管理 -->
                                <tr >
								<td>
								<label class="checkbox-inline"><input name="tcgl" id="tcgl" value="0" onclick="checkfl(this)" type="checkbox">拖车管理</label>
								</td>
                                <td id="tcgl1" name="node">
                                <label class="checkbox-inline"><input name="tc_ysl" id="tc_ysl" value="0" onclick="check(this)" type="checkbox">拖车(已受理)</label>
                                <label class="checkbox-inline"><input name="tc_wsl" id="tc_wsl" value="0" onclick="check(this)" type="checkbox">拖车(未受理)</label>
                                <label class="checkbox-inline"><input name="tc_wc" id="tc_wc" value="0" onclick="check(this)" type="checkbox">拖车(完成)</label>
                                <label class="checkbox-inline"><input name="tc_sb" id="tc_sb" value="0" onclick="check(this)" type="checkbox">拖车(失败)</label>
                                </td>
                                </tr>
                                <!-- 拍卖管理 -->
                                <tr >
								<td>
								<label class="checkbox-inline"><input name="auction" id="auction" value="0" onclick="checkfl(this)" type="checkbox">拍卖管理</label>
								</td>
                                <td id="auction1" name="node">
                                <label class="checkbox-inline"><input name="auction_no" id="auction_no" value="0" onclick="check(this)" type="checkbox">未拍卖</label>
                                <label class="checkbox-inline"><input name="auction_loss" id="auction_loss" value="0" onclick="check(this)" type="checkbox">亏损(拍卖完成)</label>
                                <label class="checkbox-inline"><input name="auction_profit" id="auction_profit" value="0" onclick="check(this)" type="checkbox">盈利(拍卖完成)</label>
                                </td>
                                </tr>
                                <!-- 诉讼管理 -->
                                <tr >
								<td>
								<label class="checkbox-inline"><input name="ssgl" id="ssgl" value="0" onclick="checkfl(this)" type="checkbox">诉讼管理 </label>
								</td>
                                <td id="ssgl1" name="node">
                                <label class="checkbox-inline"><input name="ssgl_yes" id="ssgl_yes" value="0" onclick="check(this)" type="checkbox">已处理</label>
                                <label class="checkbox-inline"><input name="ssgl_no" id="ssgl_no" value="0" onclick="check(this)" type="checkbox">待处理</label>
                                </td>
                                </tr>
                                <!-- 保险管理 -->
                                <tr >
								<td>
								<label class="checkbox-inline"><input name="bxgl" id="bxgl" value="0" onclick="checkfl(this)" type="checkbox">保险管理 </label>
								</td>
                                <td>
                                </td>
                                </tr>
                                <!-- 车险理赔 -->
                                <tr >
								<td>
								<label class="checkbox-inline"><input name="cxlp" id="cxlp" value="0" onclick="checkfl(this)" type="checkbox">车险理赔 </label>
								</td>
                                <td>
                                </td>
                                </tr>
                                <!-- 核销管理 -->
                                <tr >
								<td>
								<label class="checkbox-inline"><input name="hx" id="hx" value="0" onclick="checkfl(this)" type="checkbox">核销管理</label>
								</td>
                                <td id="hx1" name="node">
                                <label class="checkbox-inline"><input name="hx_yes" id="hx_yes" value="0" onclick="check(this)" type="checkbox">已核销</label>
                                <label class="checkbox-inline"><input name="hx_no" id="hx_no" value="0" onclick="check(this)" type="checkbox">未核销</label>
                                </td>
                                </tr>
                                <!-- 结清处理 -->
                                <tr >
								<td>
								<label class="checkbox-inline"><input name="cqcl" id="cqcl" value="0" onclick="checkfl(this)" type="checkbox">结清处理</label>
								</td>
                                <td id="cqcl1" name="node">
                                <label class="checkbox-inline"><input name="cqcl_normal" id="cqcl_normal" value="0" onclick="check(this)" type="checkbox">正常结清</label>
                                <label class="checkbox-inline"><input name="cqcl_before" id="cqcl_before" value="0" onclick="check(this)" type="checkbox">提前结清</label>
                                <label class="checkbox-inline"><input name="cqcl_mandatory" id="cqcl_mandatory" value="0" onclick="check(this)" type="checkbox">强制结清</label>
                                <label class="checkbox-inline"><input name="cqcl_loss" id="cqcl_loss" value="0" onclick="check(this)" type="checkbox">亏损结清</label>
                                </td>
                                </tr>
                                <!--  -->
				                <tr>
								<td>
								<label class="checkbox-inline">
								<input name="rwcl" id="rwcl"  value="0" onclick="checkfl(this)" type="checkbox">
								<strong>任务处理</strong>
								
								</label>
								</td>
								<td>
								</td>
                                </tr>
				                <tr>
								<td>
								<label class="checkbox-inline">
								<input name="clgc" id="clgc"  value="0" onclick="checkfl(this)" type="checkbox">处理过程</label>
								</td>
								<td>
								
								</td>
                                </tr>
				                <tr>
								<td id="1">
								<label  class="checkbox-inline"><input name="zxcx" id="zxcx" value="0" onclick="checkfl(this)" type="checkbox">征信查询</label>
								</td>
                                <td  id="zxcx1" name="node">
                                <label class="checkbox-inline"><input name="cxjg_3" id="cxjg_3" value="0" onclick="check(this)" type="checkbox">查询结果</label>							
                                </td>
                                </tr>
                                <tr>
                                
								<td id="2">
								<label class="checkbox-inline"><input name="zxtr" id="zxtr" value="0" onclick="checkfl(this)" type="checkbox">征信通融</label>
								</td>
                                <td id="zxtr1" name="node">
                                <label class="checkbox-inline"><input name="zxyhyj_6" id="zxyhyj_6" value="0" onclick="check(this)" type="checkbox">征信员银行意见</label>							
                                <label class="checkbox-inline"><input name="trsh_7" id="trsh_7" value="0" onclick="check(this)" type="checkbox">通融审核</label>	
                                </td>
                                </tr>
                                <tr>
                                
								<td id="3">
								<label class="checkbox-inline"><input name="clpg" id="clpg" value="0" onclick="checkfl(this)" type="checkbox">车辆评估</label>
								</td>
                                <td id="clpg1" name="node">
                                <label class="checkbox-inline"><input name="pgjsh_11" id="pgjsh_11" value="0" onclick="check(this)" type="checkbox">评估价审核</label>							
                                </td>
                                </tr>	
                                <!-- 银行电审 暂时不用 -->
<!--                                 <tr>
                                
								<td id="4">
								<label class="checkbox-inline"><input name="yhds" id="yhds" value="0" onclick="checkfl(this)" type="checkbox">银行电审</label>
								</td>
                                <td id="yhds1" name="node">
                                <label class="checkbox-inline"><input name="dsjg_15" id="dsjg_15" value="0" onclick="check(this)" type="checkbox">电审结果</label>							
                                </td>
                                </tr> -->	
                                <tr>

								<td id="5">
								<label class="checkbox-inline"><input name="kksq" id="kksq" value="0" onclick="checkfl(this)" type="checkbox">开卡申请</label>
								</td>
                                <td id="kksq1" name="node">
                                <label class="checkbox-inline"><input name="sfhcjg_19" id="sfhcjg_19" value="0" onclick="check(this)" type="checkbox">身份核查结果</label>							
                                <label class="checkbox-inline"><input name="fkkkjg_20" id="fkkkjg_20" value="0" onclick="check(this)" type="checkbox">反馈开卡结果</label>	
                                </td>
                                </tr>	
                                <tr>
                                
								<td id="6">
								<label class="checkbox-inline"><input name="spmq" id="spmq" value="0" onclick="checkfl(this)" type="checkbox">视频面签</label>
								</td>
                                <td id="spmq1" name="node">
                                <label class="checkbox-inline"><input name="jgfk_24" id="jgfk_24" value="0" onclick="check(this)" type="checkbox">结果反馈</label>							
                                </td>
                                </tr>	
                                <tr>
                               
								<td id="7">
								<label class="checkbox-inline"><input name="kqyywsp" id="kqyywsp" value="0" onclick="checkfl(this)" type="checkbox">跨区域业务审批</label>
								</td>
                                <td id="kqyywsp1" name="node">
                                <label class="checkbox-inline"><input name="zgsh_27" id="zgsh_27" value="0" onclick="check(this)" type="checkbox">主管审核</label>							
                                <label class="checkbox-inline"><input name="zjlsh_29" id="zjlsh_29" value="0" onclick="check(this)" type="checkbox">总经理审核</label>	
                                </td>
                                </tr>

                                <tr>
                                
								<td id="8">
								<label class="checkbox-inline"><input name="qcdksh" id="qcdksh" value="0" onclick="checkfl(this)" type="checkbox">贷款申请</label>
								</td>
                                <td id="qcdksh1" name="node">
                                <label class="checkbox-inline"><input name="zysh_33" id="zysh_33" value="0" onclick="check(this)" type="checkbox">专员审核</label>							
                                <label class="checkbox-inline"><input name="zgsh_35" id="zgsh_35" value="0" onclick="check(this)" type="checkbox">主管审核</label>	
                                <label class="checkbox-inline"><input name="jlsh_37" id="jlsh_37" value="0" onclick="check(this)" type="checkbox">经理审核</label>
                                <label class="checkbox-inline"><input name="zjsh_39" id="zjsh_39" value="0" onclick="check(this)" type="checkbox">总监审核</label>
                                </td>
                                </tr>
                                <tr>
                               
								<td id="9">
								<label class="checkbox-inline"><input name="nstr" id="nstr" value="0" onclick="checkfl(this)" type="checkbox">内审通融</label>
								</td>
                                <td id="nstr1" name="node">
                                <label class="checkbox-inline"><input name="jgzjl_42" id="jgzjl_42" value="0" onclick="check(this)" type="checkbox">合作商总经理申请通融</label>							
                                <label class="checkbox-inline"><input name="trshyj_43" id="trshyj_43" value="0" onclick="check(this)" type="checkbox">审核员通融审核意见反馈</label>	
                                <label class="checkbox-inline"><input name="trzg_44" id="trzg_44" value="0" onclick="check(this)" type="checkbox">通融主管</label>
                                <label class="checkbox-inline"><input name="trjl_45" id="trjl_45" value="0" onclick="check(this)" type="checkbox">通融经理</label>
                                </td>
                                </tr>
                                <tr>
                                
								<td id="10">
								<label class="checkbox-inline"><input name="zjfp" id="zjfp" value="0" onclick="checkfl(this)" type="checkbox">资金分配</label>
								</td>
                                <td id="zjfp1" name="node">
                                <label class="checkbox-inline"><input name="qrsqdz_48" id="qrsqdz_48" value="0" onclick="check(this)" type="checkbox">确认申请垫资</label>							
                                <label class="checkbox-inline"><input name="zjfp_49" id="zjfp_49" value="0" onclick="check(this)" type="checkbox">公司资金分配</label>	
                                <label class="checkbox-inline"><input name="cz_50" id="cz_50" value="0" onclick="check(this)" type="checkbox">出账</label>
                                <label class="checkbox-inline"><input name="sslr_51" id="sslr_51" value="0" onclick="check(this)" type="checkbox">实收录入-出纳</label>
                                <label class="checkbox-inline"><input name="cwqrdz_52" id="cwqrdz_52" value="0" onclick="check(this)" type="checkbox">公司财务确认到账</label>
                                </td>
                                </tr>
                                <tr>
                                
								<td id="11">
								<label class="checkbox-inline"><input name="yhdksq" id="yhdksq" value="0" onclick="checkfl(this)" type="checkbox">银行审批</label>
								</td>
                                <td id="yhdksq1" name="node">
                                <label class="checkbox-inline"><input name="jgjscl_57" id="jgjscl_57" value="0" onclick="check(this)" type="checkbox">合作商寄送材料</label>							
                                <label class="checkbox-inline"><input name="jtsjqr_58" id="jtsjqr_58" value="0" onclick="check(this)" type="checkbox">公司收件确认</label>	
                                <label class="checkbox-inline"><input name="yhsjqr_59" id="yhsjqr_59" value="0" onclick="check(this)" type="checkbox">银行收件确认</label>
                                <label class="checkbox-inline"><input name="yhspjg_60" id="yhspjg_60" value="0" onclick="check(this)" type="checkbox">银行审批结果</label>
                                <label class="checkbox-inline"><input name="yhfkjg_61" id="yhfkjg_61" value="0" onclick="check(this)" type="checkbox">银行放款结果</label>
                                <label class="checkbox-inline"><input name="skqr_62" id="skqr_62" value="0" onclick="check(this)" type="checkbox">收款确认</label>
                                <label class="checkbox-inline"><input name="bcclqr_63" id="bcclqr_63" value="0" onclick="check(this)" type="checkbox">补充材料确认</label>
                                <label class="checkbox-inline"><input name="bccl_64" id="bccl_64" value="0" onclick="check(this)" type="checkbox">补充材料</label>
                                </td>
                                </tr>
                                <tr>
                                
								<td id="12">
								<label class="checkbox-inline"><input name="gsgd" id="gsgd" value="0" onclick="checkfl(this)" type="checkbox">公司归档</label>
								</td>
                                <td id="gsgd1" name="node">
                                <label class="checkbox-inline"><input name="jtzzgd_67" id="jtzzgd_67" value="0" onclick="check(this)" type="checkbox">公司纸质归档</label>							
                                <label class="checkbox-inline"><input name="zzgd_68" id="zzgd_68" value="0" onclick="check(this)" type="checkbox">纸质归档</label>	
                                <label class="checkbox-inline"><input name="shybcl_69" id="shybcl_69" value="0" onclick="check(this)" type="checkbox">审核员补资料</label>
                                <label class="checkbox-inline"><input name="xzrk_70" id="xzrk_70" value="0" onclick="check(this)" type="checkbox">行政入库</label>
                                </td>
                                </tr>
                                <tr>                                
								<td id="13">
								<label class="checkbox-inline"><input name="dygd" id="dygd" value="0" onclick="checkfl(this)" type="checkbox">抵押归档</label>
								</td>
                                <td id="dygd1" name="node">
                                <label class="checkbox-inline"><input name="gzjl_73" id="gzjl_73" value="0" onclick="check(this)" type="checkbox">公证记录</label>							
                                <label class="checkbox-inline"><input name="dycljsjg_74" id="dycljsjg_74" value="0" onclick="check(this)" type="checkbox">抵押材料寄送至合作商</label>	
                                <label class="checkbox-inline"><input name="jgsjqr_75" id="jgsjqr_75" value="0" onclick="check(this)" type="checkbox">合作商收件确认</label>
                                <label class="checkbox-inline"><input name="dyqkjl_76" id="dyqkjl_76" value="0" onclick="check(this)" type="checkbox">抵押情况记录</label>
                                <label class="checkbox-inline"><input name="dycljh_77" id="dycljh_77" value="0" onclick="check(this)" type="checkbox">抵押材料寄回</label>
                                 <label class="checkbox-inline"><input name="shsjqr_78" id="shsjqr_78" value="0" onclick="check(this)" type="checkbox">审核收件确认</label>
                               <label class="checkbox-inline"><input name="dyclzyh_79" id="dyclzyh_79" value="0" onclick="check(this)" type="checkbox">抵押材料至银行</label>
                               <label class="checkbox-inline"><input name="yhsjqr_80" id="yhsjqr_80" value="0" onclick="check(this)" type="checkbox">银行收件确认</label>
                               <label class="checkbox-inline"><input name="lryhcyqk_81" id="lryhcyqk_81" value="0" onclick="check(this)" type="checkbox">录入银行查验情况</label>
                                </td>
                                </tr>
                                <tr>
                               
								<td id="14">
								<label class="checkbox-inline"><input name="ywxxxg" id="ywxxxg" value="0" onclick="checkfl(this)" type="checkbox">业务信息修改</label>
								</td>
                                <td id="ywxxxg1" name="node">
                                <label class="checkbox-inline"><input name="ywglb_84" id="ywglb_84" value="0" onclick="check(this)" type="checkbox">业务管理部</label>							
                                <label class="checkbox-inline"><input name="xtyw_85" id="xtyw_85" value="0" onclick="check(this)" type="checkbox">系统运维（专员）</label>	
                                <label class="checkbox-inline"><input name="ywxxxgsq_96" id="ywxxxgsq_96" value="0" onclick="check(this)" type="checkbox">业务信息修改申请</label>
                                </td>
                                </tr>
                                <tr>
                                
								<td id="15">
								<label class="checkbox-inline"><input name="tdtf" id="tdtf" value="0" onclick="checkfl(this)" type="checkbox">退单退费</label>
								</td>
                                <td id="tdtf1" name="node">
                                <label class="checkbox-inline"><input name="shytdsh_88" id="shytdsh_88" value="0" onclick="check(this)" type="checkbox">审核员退单审核</label>							
                                <label class="checkbox-inline"><input name="tdsjxz_89" id="tdsjxz_89" value="0" onclick="check(this)" type="checkbox">退单数据修正</label>	
                                <label class="checkbox-inline"><input name="shjltdsh_90" id="shjltdsh_90" value="0" onclick="check(this)" type="checkbox">审核经理退单审核</label>
                                 <label class="checkbox-inline"><input name="jghkjf_91" id="jghkjf_91" value="0" onclick="check(this)" type="checkbox">合作商回款缴费</label>
                                  <label class="checkbox-inline"><input name="gsqrdz_92" id="gsqrdz_92" value="0" onclick="check(this)" type="checkbox">公司确认到账</label>
                                   <label class="checkbox-inline"><input name="cljh_93" id="cljh_93" value="0" onclick="check(this)" type="checkbox">材料寄回</label>
                                    <label class="checkbox-inline"><input name="jgsjqr_94" id="jgsjqr_94" value="0" onclick="check(this)" type="checkbox">合作商收件确认</label>
                                </td>
                                </tr>
                                 <tr>
                                
								<td id="16">
								<label class="checkbox-inline"><input name="financing" id="financing" value="0" onclick="checkfl(this)" type="checkbox">融资</label>
								</td>
                                <td id="financing1" name="node">
                                <label class="checkbox-inline"><input name="financing_101" id="financing_101" value="0" onclick="check(this)" type="checkbox">融资结果</label>							
                                <label class="checkbox-inline"><input name="financing_102" id="financing_102" value="0" onclick="check(this)" type="checkbox">资金方出账</label>	
                                <label class="checkbox-inline"><input name="financing_103" id="financing_103" value="0" onclick="check(this)" type="checkbox">公司确认收款</label>
                                </td>
                                </tr>
                                <tr>
								<td>
								<label class="checkbox-inline"><input name="khgl" id="khgl" value="0" onclick="checkfl(this)" type="checkbox">
								<strong>客户管理</strong>
								</label>
								</td>
                                <td id="khgl1" name="node">
                                <label class="checkbox-inline"><input name="zdrxx" id="zdrxx" value="0" onclick="check(this)" type="checkbox">主贷人信息</label>							
                                <label class="checkbox-inline"><input name="ghrxx" id="ghrxx" value="0" onclick="check(this)" type="checkbox">共还人信息</label>	
                                <label class="checkbox-inline"><input name="qtlxr" id="qtlxr" value="0" onclick="check(this)" type="checkbox">其他联系人</label>
                                 <label class="checkbox-inline"><input name="srxx" id="srxx" value="0" onclick="check(this)" type="checkbox">收入信息</label>
                                  <label class="checkbox-inline"><input name="jtxx" id="jtxx" value="0" onclick="check(this)" type="checkbox">家庭信息</label>
                                   <label class="checkbox-inline"><input name="fcxx" id="fcxx" value="0" onclick="check(this)" type="checkbox">房产信息</label>
                                </td>
                                </tr>
                                <tr>
								<td>
								<label class="checkbox-inline"><input name="dkgl" id="dkgl" value="0" onclick="checkfl(this)" type="checkbox">
								贷款管理
								</label>
								</td>
                                <td>
                                </td>
                                </tr>
                                <tr>
								<td>
								<label class="checkbox-inline"><input name="clxx" id="clxx" value="0" onclick="checkfl(this)" type="checkbox">车辆信息</label>
								</td>
                                <td>
                                </td>
                                </tr>
                                <tr>
								<td>
								<label class="checkbox-inline"><input name="zzsc" id="zzsc" value="0" onclick="checkfl(this)" type="checkbox">资质审查</label>
								</td>
                                <td  id="zzsc1" name="node">
                                <label class="checkbox-inline"><input name="sfrz" id="sfrz" value="0" onclick="check(this)" type="checkbox">身份认证</label>
                                <label class="checkbox-inline"><input name="sjhm" id="sjhm" value="0" onclick="check(this)" type="checkbox">手机号码</label>
                                <label class="checkbox-inline"><input name="mzmd" id="mzmd" value="0" onclick="check(this)" type="checkbox">命中名单</label>
                                <label class="checkbox-inline"><input name="grfxxx" id="grfxxx" value="0" onclick="check(this)" type="checkbox">个人风险信息</label>
                                <label class="checkbox-inline"><input name="bjgcxxx" id="bjgcxxx" value="0" onclick="check(this)" type="checkbox">被合作商查询信息</label>
                                <label class="checkbox-inline"><input name="fqzbg" id="fqzbg" value="0" onclick="check(this)" type="checkbox">反欺诈报告</label>
                                <label class="checkbox-inline"><input name="zxbg" id="zxbg" value="0" onclick="check(this)" type="checkbox">征信报告</label>
                                </td>
                                </tr>
                                <tr>
								<td>
								<label class="checkbox-inline"><input name="yycl" id="yycl" value="0" onclick="checkfl(this)" type="checkbox">影音材料</label>
								</td>
                                <td id="yycl1" name="node">
                                <label class="checkbox-inline"><input name="yycl11" id="yycl11" value="0" onclick="check(this)" type="checkbox">征信材料 </label>
                                <label class="checkbox-inline"><input name="yycl2" id="yycl2" value="0" onclick="check(this)" type="checkbox">征信通融材料 </label>
                                <label class="checkbox-inline"><input name="yycl3" id="yycl3" value="0" onclick="check(this)" type="checkbox">汽车评估材料 </label>
                                <label class="checkbox-inline"><input name="yycl4" id="yycl4" value="0" onclick="check(this)" type="checkbox">开卡申请材料 </label>
                                <label class="checkbox-inline"><input name="yycl5" id="yycl5" value="0" onclick="check(this)" type="checkbox">开卡申请PDF材料 </label>
                                <label class="checkbox-inline"><input name="yycl6" id="yycl6" value="0" onclick="check(this)" type="checkbox">视频材料 </label>
                                <label class="checkbox-inline"><input name="yycl7" id="yycl7" value="0" onclick="check(this)" type="checkbox">签约材料 </label>
                                <label class="checkbox-inline"><input name="yycl8" id="yycl8" value="0" onclick="check(this)" type="checkbox">证明材料</label>
                                <label class="checkbox-inline"><input name="yycl9" id="yycl9" value="0" onclick="check(this)" type="checkbox">其他材料 </label>
                                <label class="checkbox-inline"><input name="yycl10" id="yycl10" value="0" onclick="check(this)" type="checkbox">补充材料</label>
                                </td>
                                </tr>
                                <tr>
								<td>
								<label class="checkbox-inline"><input name="sfmx" id="sfmx" value="0" onclick="checkfl(this)" type="checkbox">收费明细</label>
								</td>
                                <td>
                                </td>
                                </tr>
                                
					</tbody>
					</table>
				</div>
			</div>

		</div>
	</div>
</div>
<script>
$(document).ready(function(){
	var input = document.getElementsByTagName("input");
	var qx=document.getElementById("qx").value;
	var map=qx.split(",");
	
	for (var i=0;i<input.length;i++) {
        if ((input[i].type == "checkbox")&&(input[i].name.length>0)) {
        	for(var j=0;j<map.length;j++){
        		//alert(input[i].name+"--"+map[j]);
        		if(input[i].name == map[j]){
        			input[i].checked = true;
        			input[i].value=map[j];
        			break;
        		}
        	} 
        	
       }
    }
	
	
	$("#info_form").submit(function(){
		//alert($("input:checkbox[name='orders']").val());
		if(this.name.value.length==0){
			alert("请输入管理组名称");
			return false;
		}
	});
});
function check(obj){
	obj.value=(obj.checked?obj.id:"");
}
function checkall(obj,type){
	if (type==1){//勾选大类
        input = document.getElementsByTagName("input");
	    
	    for (var i = 0; i < input.length; i++) {
	        if ((input[i].type == "checkbox")&&(input[i].id.length>0)&&(input[i].id.indexOf("/")<0)) {
	        		input[i].checked = obj.checked;
	            	input[i].value= obj.checked?input[i].id:'';
	        }
	    }	
	}else{
		var objInput = document.getElementsByName("node");
         for (var i=0;i<objInput.length;i++) {  
        	var inputs=objInput[i].getElementsByTagName("input");
        	for(var j=0;j<inputs.length;j++){
        		if((inputs[j].type == "checkbox")&&(inputs[j].id.length>0)){
        			inputs[j].checked = obj.checked;
        			inputs[j].value= obj.checked?inputs[j].id:'';
        		}
        	}
        	
        }
         
        /* input =document.getElementsByTagName("input");
	    for (var i = 0; i < input.length; i++) {
	        if ((input[i].type == "checkbox")&&(input[i].name.length>0)&&(input[i].name.indexOf("/")>=0)) {
	        		input[i].checked = obj.checked;
	            	input[i].value= obj.checked?input[i].name:'';
	        }
	    }	 */
		
	}
}
function checkfl(obj){
	obj.value=(obj.checked?obj.id:"");
	if(obj.id=="clgc"){
		for (var i = 1; i <17; i++) {    	
			input=document.getElementById(i).getElementsByTagName("input");
			for (var j = 0; j < input.length; j++) {    	
		        if ((input[j].type == "checkbox")&&(input[j].id.length>0)) {        	
		        		input[j].checked = obj.checked;
		            	input[j].value= obj.checked?input[j].id:'';
		            	/* input1=document.getElementById(input[j].id+"1").getElementsByTagName("input");   	
		            	 for (var k = 0; k < input1.length; k++) {    	
		         	        if ((input1[k].type == "checkbox")&&(input1[k].id.length>0)) {        	
		         	        		input1[k].checked = obj.checked;
		         	            	input1[k].value= obj.checked?input1[k].id:'';
		         	        }
		         	    } */
		        }
		    }	
	    }	
	}else{
		input=document.getElementById(obj.id+"1").getElementsByTagName("input");
	    for (var i = 0; i < input.length; i++) {    	
	        if ((input[i].type == "checkbox")&&(input[i].id.length>0)) {        	
	        		input[i].checked = obj.checked;
	            	input[i].value= obj.checked?input[i].id:'';
	        }
	    }	
	}
   
}
</script>
		</section>
				<div class="footer-wrap">
			<div class="box-footer">
				<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath }/erp/index.do?type=zhgl&dn=icbc_erp_admin_agp&qn=list'">取消返回</button>
				<c:if  test="${fn:contains(sessionScope.pd.purview_map,'zhqxupdate')==true or fn:contains(sessionScope.pd.purview_map,'zhqxadd')==true}">
				<c:if test="${requestScope.cn != '4' }">
				<button type="submit" class="btn btn-primary pull-right">保存提交</button>
				</c:if>
				</c:if> 
			</div>
		</div>
			</div><!-- /.content-wrapper -->
</form>