<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'yhfkjg_61')==true}">
<li class="text-primary">
<em>银行放款结果</em>
<div class="big-conte_" >  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong></div>
<strong style="margin-left:10px;">
<i>处理信息：</i></strong><br>
<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form id="yhdksh_61" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
	<input type="hidden" name="adminid" value="${sessionScope.pd.id}">
	<input type="hidden" name="type_id" value="${requestScope.type_id}"> 
	<input type="hidden" name="icbc_id" value="${requestScope.icbc_id}"> 
	<div class="form-group">		
		<label class="col-sm-2 control-label">放款结果</label>
		<div class="col-sm-8">
			<input type="radio" value="1" name="result_1_code1"  class="ng-pristine ng-untouched ng-valid ng-not-empty">成功  
				&nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="radio" value="2" name="result_1_code1"  class="ng-pristine ng-untouched ng-valid ng-not-empty">失败
       	</div>
	</div>
	<!-- ngIf: task.auditRet==null ||task.auditRet == 1 --><div class="ng-scope">
		<div class="form-group">
			<label class="col-sm-2 control-label">放款日期<i class="red">*</i></label>
			 <div class="col-sm-3">
				<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required">
  <input id="date_61_1" name="yhdksh_61_date" class="form-control" type="text"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
</div>
			</div>   
			<label class="col-sm-2 control-label">卡号<i class="red">*</i></label>
			<div class="col-sm-3">
				<input value="${pd.kk_kh}" id="yhdksh_61_kh" name="yhdksh_61_kh" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required" type="text" >
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">支行<i class="red">*</i></label>
			<div class="col-sm-3">
			    <c:if test="${pd.bank_id eq '1'}"><input value="工行绍兴分行" id="yhdksh_61_zh" name="yhdksh_61_zh" class="form-control" type="text"  ></c:if>
			    <c:if test="${pd.bank_id eq '2'}"><input value="工行武林支行" id="yhdksh_61_zh" name="yhdksh_61_zh" class="form-control" type="text"  ></c:if>
			    <c:if test="${pd.bank_id eq '3'}"><input value="工行义乌支行" id="yhdksh_61_zh" name="yhdksh_61_zh" class="form-control" type="text"  ></c:if>
				<c:if test="${empty pd.bank_id}"><input value="工行义乌支行" id="yhdksh_61_zh" name="yhdksh_61_zh" class="form-control" type="text"  ></c:if>
			</div>
			<label class="col-sm-2 control-label">分期数<i class="red">*</i></label>
			<div class="col-sm-3">
				<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required" >
					<input name="yhdksh_61_fq" id="yhdksh_61_fq" value="${pd.aj_date}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text"  >
					<span class="input-group-addon">期</span>
				</div>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">首期还款日期</label>
			<div class="col-sm-3">
				<div class="input-group date ng-isolate-scope ng-not-empty ng-valid" >
  <input id="date_61_2" name="yhdksh_61_sqhkr" class="form-control" type="text">
  <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
</div>
			</div>
			<label class="col-sm-2 control-label">金额<i class="red">*</i></label>
			<div class="col-sm-3">
				<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required" >
					<input value="${pd.dk_total_price }" onkeyup="show_two(this.value)" name="yhdksh_61_je" id="yhdksh_61_je" class="form-control" type="text" >
					<span class="input-group-addon">元</span>
				</div>
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label" title="首月还款=月还+100">首月还款</label>
			<div class="col-sm-3">
				<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required" >
					<input name="yhdksh_61_syhk" id="yhdksh_61_syhk" placeholder="填写金额后自动填充" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text"  ><span class="input-group-addon">元</span>
				</div>
			</div>
			<label class="col-sm-2 control-label" title="月还=金额/分期数(四入五入)">月还</label>
			<div class="col-sm-3">
				<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required" >
					<input name="yhdksh_61_yh" id="yhdksh_61_yh" placeholder="填写金额后自动填充" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text"  ><span class="input-group-addon">元</span>
				</div>
			</div>
			
		</div>
		<!-- ngIf: task.creditsMoney -->
<!-- 		<div class="form-group">		 -->
<!-- 			<label class="col-sm-2 control-label">打款至：</label> -->
<!-- 			<div  class="col-sm-8"> -->
<!-- 				<input type="radio" value="1000" ng-model="task.orgId" ng-checked="task.orgId==null || task.orgId==1000">资产公司  &nbsp;&nbsp;&nbsp;&nbsp; -->
<!-- 		        <input type="radio" value="1228" ng-model="task.orgId">网络公司 -->
<!-- 	       	</div> -->
<!-- 		</div> -->
	<!-- 	<div class="form-group">
			<label class="col-sm-2 control-label">垫资金额</label>
			<div class="col-sm-3">
				<input class="form-control" type="text"	ng-model="task.payAmount" cg-required required/>
			</div>
			<label class="col-sm-2 control-label">差额</label>
			<div class="col-sm-3">
				<input class="form-control" type="text" ng-model="task.netting"  ng-value="task.bankAmount-task.payAmount" disabled="true" />(计算方式:放贷额-垫资金额)
			</div>
		</div> -->
	</div><!-- end ngIf: task.auditRet==null ||task.auditRet == 1 -->
	<div class="form-group">
		<label class="col-sm-2 control-label">其它说明</label>
		<div class="col-sm-8">
			<textarea name="result_1_msg" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"  ></textarea>
		</div>
	</div>

	<!-- 根据action确定操作  -->
	<!-- ngIf: !notUseButton -->
	<div class="modal-footer">
		<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
		<a onclick="erp_yhdksh_61()" class="btn btn-primary" >提交</a>
	</div>
</form>
<script>

lay('#version').html('-v'+ laydate.v);
//执行一个laydate实例
laydate.render({
  elem: '#date_61_1'
});
laydate.render({
  elem: '#date_61_2'
});
</script>
<script type="text/javascript">
$(document).ready(function(){
	var je='${pd.dk_total_price }';
	var fqs ='${pd.aj_date }';
	//计算月还  
	var yhdksh_61_yh = 0; // 月还
	var get_yh = je/fqs; 
	var yh_two = get_yh.toFixed(2);
	var yh_four = get_yh.toFixed(4);
	var yh_four_getThree = yh_four.indexOf('.');
	var getStrThree = yh_four.substr(yh_four_getThree+3,1);
	if(getStrThree>0 && getStrThree<5){
		//document.getElementById("yhdksh_61_yh").value=Number(yh_two)+Number(0.01)+"--月还(je/fqs)--"+get_yh;
		yhdksh_61_yh = Number(yh_two)+Number(0.01);
	}else{
		//document.getElementById("yhdksh_61_yh").value=Number(yh_two)+"-没有加0.01-月还(je/fqs)--"+get_yh;
		yhdksh_61_yh = Number(yh_two);
	}
	document.getElementById("yhdksh_61_yh").value= yhdksh_61_yh;
	//计算首月还款  yhdksh_61_syhk = 月还+100
    var max_yh = $("#yhdksh_61_yh").val(); // 月还
    var yhdksh_61_syhk = Number(max_yh)+Number(100);  // 首月还款
	document.getElementById("yhdksh_61_syhk").value=yhdksh_61_syhk;
});
function show_two(je){
	/* var s = 22.127456 + "";
    var str = s.substring(0,s.indexOf(".") + 3);
    alert(str); */
	//分期数  开卡时候
	var fqs = document.getElementById("yhdksh_61_fq").value;
    if(fqs==""){
    	alert("请先输入分期数,然后再输入金额!");
    }else{
    	//计算月还  
    	var yhdksh_61_yh = 0; // 月还
    	var get_yh = je/fqs; 
    	var yh_two = get_yh.toFixed(2);
    	var yh_four = get_yh.toFixed(4);
    	var yh_four_getThree = yh_four.indexOf('.');
    	var getStrThree = yh_four.substr(yh_four_getThree+3,1);
    	if(getStrThree>0 && getStrThree<5){
    		//document.getElementById("yhdksh_61_yh").value=Number(yh_two)+Number(0.01)+"--月还(je/fqs)--"+get_yh;
    		yhdksh_61_yh = Number(yh_two)+Number(0.01);
    	}else{
    		//document.getElementById("yhdksh_61_yh").value=Number(yh_two)+"-没有加0.01-月还(je/fqs)--"+get_yh;
    		yhdksh_61_yh = Number(yh_two);
    	}
    	document.getElementById("yhdksh_61_yh").value= yhdksh_61_yh;
    	//计算首月还款  yhdksh_61_syhk = 月还+100
        var max_yh = $("#yhdksh_61_yh").val(); // 月还
        var yhdksh_61_syhk = Number(max_yh)+Number(100);  // 首月还款
    	document.getElementById("yhdksh_61_syhk").value=yhdksh_61_syhk;
    }
	
	/* 
	//计算首月还款  yhdksh_61_syhk = 月还整数+100+月还小数点后两位*期数
    var max_yh = $("#yhdksh_61_yh").val(); // 月还
	var dianXh = max_yh.indexOf('.');
	var zs = max_yh.substr(0,dianXh); // 月还整数部分
	var xs = max_yh.substr(dianXh,dianXh+2); // 月还小数点后两位
	xs = xs*fqs; // 月还小数点后两位*期数
	var yhdksh_61_syhk = Number(zs)+Number(100)+Number(xs);  // 首月还款
    //document.getElementById("yhdksh_61_syhk").value=yhdksh_61_syhk+"--整数:"+zs+"--小数:"+xs; 
	*/
	
}

function erp_yhdksh_61(){
	var val=$('input:radio[name="result_1_code1"]:checked').val();
	var yhdksh_61_kh=$("#yhdksh_61_kh").val();
	var yhdksh_61_zh=$("#yhdksh_61_zh").val();
	var yhdksh_61_je=$("#yhdksh_61_je").val();
	var date_61_1 = $("#date_61_1").val();
	var date_61_2 = $("#date_61_2").val();
	if(yhdksh_61_kh==""){
		alert("请填写卡号!");
	}else if(date_61_1==""){
		alert("请选择放款日期!");首期还款日期
	}else if(date_61_2==""){
		alert("请选择首期还款日期!");
	}else if(yhdksh_61_zh==""){
		alert("请填写支行!");
	}else if(yhdksh_61_je==""){
		alert("请填写金额!");
	}else if(val==null){
        alert("请选择放款结果!");
    }else{
	   	var form = new FormData(document.getElementById("yhdksh_61"));
	   	$.ajax({
	           url:"${pageContext.request.contextPath}/erp/erp_yhdksh_61.do",
	           type:"post",
	           data:form,
	           processData:false,
	           contentType:false,
	           success:function(data){
	            alert("提交成功!");
	            window.location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }';
	           },
	           error:function(e){
	            alert("错误！！");
	           }
	     });  
    }
}
</script>
</div>
</div>   							  	
</li>								  	
</c:if>