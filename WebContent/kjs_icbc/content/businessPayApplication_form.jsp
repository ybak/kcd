<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form id="businessPayForm" name="businessPayForm" method="post" enctype="multipart/form-data" class="form-horizontal">
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper fixed-footer" style="min-height: 943px;">
		<!-- Main content -->
	<section class="content">
<div style="border:1px solid #478FCA;   margin:5px; padding:20px;border-radius: 10px;">
	    <div class="form-group" >
			<label class="col-sm-2 control-label">业务编号<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="code" name="code" value="${pd.code}" class="form-control" type="text" />
		    </div>
			<label class="col-sm-2 control-label">客户姓名<i class="red">*</i></label>
			<div class="col-sm-3">
	      		<input id="name" name="name" value="${pd.name}" class="form-control" type="text" />
			</div>
		</div>
		<div class="form-group" >
			<label class="col-sm-2 control-label">业务类型<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<select name="businessType" id="businessType" class="form-control">
				<option  value="">请选择</option>
				<option value="1" ${pd.cars_type==1?"selected='selected'":''}>新车</option>
				<option value="2" ${pd.cars_type==2?"selected='selected'":''}>二手车</option>		
			</select>
			</div>
			<label class="col-sm-2 control-label">合作商<i class="red">*</i></label>
			<div class="col-sm-3">
	      		<input id="fs" name="fs" value="${pd.fs_name}" class="form-control" type="text" />
			</div>
		</div>
		<div class="form-group" >
			<label class="col-sm-2 control-label">申请人<i class="red">*</i></label>
	  		<div class="col-sm-3">
				<input id="reqName" name="reqName" value="${requestScope.reqName}" class="form-control" type="text" />
		    </div>
			<label class="col-sm-2 control-label">部门<i class="red">*</i></label>
			<div class="col-sm-3">
	      	<select name="dept" id="dept" class="form-control">
				<option  value="0">请选择</option>
				<option value="1">运营部</option>
				<option value="2" selected="selected">财务部**</option>		
				<option value="3">风控部</option>
				<option value="4">技术部</option>	
			</select>
			</div>
		</div>
		<div class="form-group" >
			<label class="col-sm-2 control-label">申请日期<i class="red">*</i></label>
	  		<div class="col-sm-3">
				<input id="date" name="date" value="${fn:substring(pd.date,0,19)}" class="form-control" type="text" />
		    </div>
		</div>
		<div style="border:1px solid #478FCA; margin:5px; padding:20px;border-radius: 10px;">
		<div class="form-group" >
		    <label class="col-sm-2 control-label">收款账户<i class="red">*</i></label>
	  		<div class="col-sm-2">
			<input id="moneyName" name="moneyName" value="${pd.account_name!=null?(pd.account_name):'无'}" class="form-control" type="text" />
		    </div>
		    <label class="col-sm-2 control-label">收款账号<i class="red">*</i></label>
			<div class="col-sm-2">
	      		<input id="moneyNumber" name="moneyNumber" value="${pd.bank_account!=null?(pd.bank_account):'无'}" class="form-control" type="text" />
			</div>
			<label class="col-sm-2 control-label">收款开户行<i class="red">*</i></label>
	  		<div class="col-sm-2">
			<input id="bank" name="bank" value="${pd.open_bank!=null?(pd.open_bank):'无'}" class="form-control" type="text" />
		    </div>	
		</div>
		</div>
		<div style="border:1px solid #478FCA; margin:5px; padding:20px;border-radius: 10px;">
		<div class="form-group" >
			<label class="col-sm-2 control-label">金额<i class="red">*</i></label>
			<div class="col-sm-2">
	      		<input id="money" name="money" value="" class="form-control" type="text" />
	      		<input id="dk_price" name="dk_price" type="hidden" value="${pd.dk_price}">
	      		<input id="jrfw_price" name="jrfw_price" type="hidden" value="${pd.jrfw_price}">
			</div>		
			<label class="col-sm-2 control-label">大写金额<i class="red">*</i></label>
	  		<div class="col-sm-2">
			<input id="bigMoney" name="bigMoney" value="" class="form-control" type="text" />
		    </div>
		    <label class="col-sm-2 control-label">付款用途<i class="red">*</i></label>
		    <div class="col-sm-2">
				<select onclick="getPriceUse(this.value)" title="随时账户打印前选择" id="moneyUse" name="moneyUse" class="form-control" tabindex="-1">
					<option value="0" selected="selected">请选择</option>
					<option value="1">代收代付购车本金</option>
					<option value="2">代收代付服务费</option>							
				</select>
			</div>
		</div>
		</div>
		<div class="form-group" style="padding-right:20px;">
			<!-- btn btn-info search-btn ${pageContext.request.contextPath}/erp/businessPaymentRequestForm.do-->
			<a onclick="out()" href="#" class="btn btn-primary pull-right" style="background: red;">导出打印</a>
		</div>
</div>
<script>
function getPriceUse(price){
	var dk_price = $("#dk_price").val();
	var jrfw_price = $("#jrfw_price").val();
	if(price==0){
		$("#money").val("");
	}else if(price==1){
		$("#money").val(dk_price);
	}else if(price==2){
		$("#money").val(jrfw_price);
	}
	
	 //do something
   //获取阿拉伯数字金额
   var n = $("#money").val();
   if (!/^(0|[1-9]\d*)(\.\d+)?$/.test(n))
       return "数据非法";
   var unit = "仟佰拾亿仟佰拾万仟佰拾元角分", str = "";
       n += "00";
   var p = n.indexOf('.');
   if (p >= 0)
       n = n.substring(0, p) + n.substr(p+1, 2);
       unit = unit.substr(unit.length - n.length);
   for (var i=0; i < n.length; i++)
       str += '零壹贰叁肆伍陆柒捌玖'.charAt(n.charAt(i)) + unit.charAt(i);
   //得到大写金额
   var money = str.replace(/零(仟|佰|拾|角)/g, "零").replace(/(零)+/g, "零").replace(/零(万|亿|元)/g, "$1").replace(/(亿)万|壹(拾)/g, "$1$2").replace(/^元零?|零分/g, "").replace(/元$/g, "元整");
   //设置值
   $("#bigMoney").val(money);
}
function out(){
	var moneyUse = $("#moneyUse").val();
	if(moneyUse==0){
		alert("请选择右下角的<付款用途>");
	}else{
		var code = $("#code").val();
		var name = $("#name").val();
		var businessType = $("#businessType").val();
		var reqName = $("#reqName").val();
		var dept = $("#dept").val();
		var date = $("#date").val();
		var moneyName = $("#moneyName").val();
		var moneyNumber = $("#moneyNumber").val();
		var bank = $("#bank").val();
		var money = $("#money").val();
		var bigMoney = $("#bigMoney").val();
		var moneyUse = $("#moneyUse").val();
	    window.location.href='${pageContext.request.contextPath}/erp/businessPaymentRequestForm.do?code='+code+'&name='
	    					+name+'&businessType='+businessType+'&reqName='+reqName+'&dept='+dept+'&date='+date+'&moneyName='
	    					+moneyName+'&moneyNumber='+moneyNumber+'&bank='+bank+'&money='+money+'&bigMoney='+bigMoney+'&moneyUse='+moneyUse;
	}
}

</script>
</section>
		<div class="footer-wrap">
			<div class="box-footer">
				<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath }/erp/user_list.do?type=zhgl&dn=assess_gems&qn=list&cn=4001'">取消返回</button>
				<c:if test="${fn:contains(sessionScope.pd.purview_map,'ryglupdate')==true or fn:contains(sessionScope.pd.purview_map,'rygladd')==true}">
				<c:if test="${requestScope.cn != '4'}">
				<button id="save_button" type="submit" class="btn btn-primary pull-right">保存提交</button>
				</c:if>
				</c:if> 
			</div>
		</div>
			</div><!-- /.content-wrapper -->
</form>