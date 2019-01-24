<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="float_page_div">
	          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
            <h4 class="modal-title" id="myModalLabel">编辑银联代收付系统_分期管理信息</h4>
          </div>
          <div class="modal-body">
          	<form class="form-horizontal" id="float_form" action="" method="post">
          		<div class="box-body">
	<div class="modal-header">
		<h4 class="modal-title" id="myModalLabel">已有<font color="green">代收</font>记录，
		创建时间：</h4>
	</div>
	<table class="table table-bordered table-hover">
		<tbody>
			<tr>
				<th class="text-center" style="width: 80px">预约日期${requestScope.status}</th>
				<th class="text-center" style="width: 80px">分期金额</th>
				<th class="text-center" style="width: 60px">已执行</th>
				<th class="text-center" style="width: 100px">执行结果</th>
				<th class="text-center" style="width: 150px">手动审核状态</th>
			</tr>
			<%-- <c:if test="${requestScope.yd != ''}">
				<c:forEach items="${requestScope.yd}" var="yd">
				<tr>
					<td class="text-center">${yd.yy_dt}</td>
					<td class="text-center">${yd.AMOUNT}</td>
					<c:if test="${yd.yy_runtag==0}">
						<td class="text-center">否</td>
					</c:if>
					<c:if test="${yd.yy_runtag==1}">
						<td class="text-center">是</td>
					</c:if>
					<td class="text-center">${yd.api_retcode_last}</td>
					<td class="text-center">
						<select >
							<option value="0" ${yd.checkstatus==0?"selected='selected'":''}>待审核</option>
							<option value="1" ${yd.checkstatus==1?"selected='selected'":''}>代收成功</option>
							<option value="2" ${yd.checkstatus==2?"selected='selected'":''}>其他渠道支付成功</option>
							<option value="3" ${yd.checkstatus==3?"selected='selected'":''}>失败</option>
						</select>
						
					</td>
				</tr>
				</c:forEach>
			</c:if> --%>
			<c:if test="${requestScope.status eq 3}">
				<tr>
					<td class="text-center">2017-11-28 13:15:45</td>
					<td class="text-center">165000</td>
					<td class="text-center">是</td>
					<td class="text-center">0000</td>
					<td class="text-center">
						<select >
							<option value="0" >待审核</option>
							<option value="1" >代收成功</option>
							<option value="2" selected='selected'>其他渠道支付成功</option>
							<option value="3" >失败</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="text-center">2017-10-26 10:17:25</td>
					<td class="text-center">165000</td>
					<td class="text-center">是</td>
					<td class="text-center">0000</td>
					<td class="text-center">
						<select >
							<option value="0" >待审核</option>
							<option value="1" >代收成功</option>
							<option value="2" selected='selected'>其他渠道支付成功</option>
							<option value="3" >失败</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="text-center">2017-9-27 11:18:05</td>
					<td class="text-center">165000</td>
					<td class="text-center">是</td>
					<td class="text-center">0000</td>
					<td class="text-center">
						<select >
							<option value="0" >待审核</option>
							<option value="1" >代收成功</option>
							<option value="2" selected='selected'>其他渠道支付成功</option>
							<option value="3" >失败</option>
						</select>
					</td>
				</tr>
			</c:if>
		</tbody>
	</table>
</div>
<div class="modal-header">
	<h4 class="modal-title" id="myModalLabel">新建-等额本息</h4>
</div>
<input name="qryid" value="547" type="hidden">
<input name="type" value="9" type="hidden">
<input name="gems_fs_id" value="511" type="hidden">
<input name="bank_id" value="101" type="hidden">
<input name="ds_type" value="0" type="hidden">
<input name="xname" value="assess_mgcert" type="hidden">
<div class="form-group" style="padding-top: 25px">
	<label for="title2" class="col-sm-3 control-label">签约银联卡:</label>
	<div class="col-sm-9">
			<%-- <input value="${ydd.c_name}-${ydd.c_cardno}" class="form-control" id="bt" disabled="disabled" type="text"> --%>
			<input value="${requestScope.khName}-${requestScope.khCardId}" class="form-control" id="bt" disabled="disabled" type="text">
	</div>
</div><div class="form-group">
	<label for="title2" class="col-sm-3 control-label">应还本金总额(分):</label>
		<div class="col-sm-3">
		<c:choose>			
			<c:when test="${requestScope.status == 3}">
				<input value="<%-- ${ydd.AMOUNT} --%>3000000" class="form-control" name="b_AMOUNT" id="b_AMOUNT"  readonly="readonly" type="number">
			</c:when>
			<c:otherwise>
				<input value="${ydd.AMOUNT}" class="form-control" name="b_AMOUNT" id="b_AMOUNT"  readonly="readonly" type="number">			
			</c:otherwise>
		</c:choose>
	</div>
	<label for="title2" class="col-sm-3 control-label">应还利息总额(分):</label>
	<div class="col-sm-3">
		<c:choose>			
			<c:when test="${requestScope.status == 3}">
				<input class="form-control" name="b_AMOUNT" id="b_AMOUNT" value="489600" readonly="readonly" type="number">
			</c:when>
			<c:otherwise>
				<input class="form-control" name="b_AMOUNT" id="b_AMOUNT" value="0" readonly="readonly" type="number">
			</c:otherwise>
		</c:choose>
	</div>
</div>
<div class="form-group">
	<label for="title2" class="col-sm-3 control-label">期数</label>
	<div class="col-sm-3">
		<c:choose>			
			<c:when test="${requestScope.status == 3}">
				<input value="24" class="form-control" name="a_qs" id="a_qs"  type="number">
			</c:when>
			<c:otherwise>
				<input value="0" class="form-control" name="a_qs" id="a_qs"  type="number">
			</c:otherwise>
		</c:choose>
	</div>
	<label for="title2" class="col-sm-3 control-label">首期金额(分):</label>
	<div class="col-sm-3">
		<c:choose>			
			<c:when test="${requestScope.status == 3}">
				<input class="form-control" name="a_sq" id="a_sq" value="145400" type="number">
			</c:when>
			<c:otherwise>
				<input class="form-control" name="a_sq" id="a_sq" value="0" type="number">
			</c:otherwise>
		</c:choose>
	</div>
</div>
<div class="form-group">
	<label for="title2" class="col-sm-3 control-label">每期金额(分):</label>
	<div class="col-sm-3">
		<c:choose>			
			<c:when test="${requestScope.status == 3}">
				<input class="form-control" name="a_pm" id="a_pm" value="145400" type="number">
			</c:when>
			<c:otherwise>
				<input class="form-control" name="a_pm" id="a_pm" value="0" type="number">				
			</c:otherwise>
		</c:choose>
	</div>
	<label for="title2" class="col-sm-3 control-label">尾期金额(分):</label>
	<div class="col-sm-3">
		<c:choose>			
			<c:when test="${requestScope.status == 3}">
				<input class="form-control" name="a_wq" id="a_wq" value="145400" type="number">
			</c:when>
			<c:otherwise>
				<input class="form-control" name="a_wq" id="a_wq" value="0" type="number">
			</c:otherwise>
		</c:choose>
	</div>
</div>
<div class="form-group">
	<label for="title2" class="col-sm-3 control-label">补息差(分,总/每期)</label>
	<div class="col-sm-4">
		<input class="form-control" name="bxc" value="0" readonly="readonly" type="text">
	</div>
	<label for="title2" class="col-sm-3 control-label">备注:</label>
	<div class="col-sm-2">
		<input class="form-control" name="remark" placeholder="比如:正常代收" type="text">
	</div>
</div>
<div class="form-group">
	<label for="title2" class="col-sm-3 control-label">指定分期基准日:</label>
	<div class="col-sm-9">
		<c:choose>			
			<c:when test="${requestScope.status == 3}">
				<input class="form-control" id="dt_fkk" name="dt_fkk" value="2017-12-20" type="date">
			</c:when>
			<c:otherwise>
				<input class="form-control" id="dt_fkk" name="dt_fkk" value="" type="date">
			</c:otherwise>
		</c:choose>
	</div>
</div>
<p style="float: center;">进件信息:${requestScope.khName},审批金额:3.00万元,借款天数:720,还款方式:等额本息-利率:0.68</p>
<script type="text/javascript">
<!--

//-->
$(function(){
	$("div.modal-dialog").css("width","830px");
    $('#cropbox').Jcrop({
      aspectRatio: 0,
      boxWidth:800,
      onSelect: updateCoords
    });

  });
/* $(function(){
	$("#float_form").attr("onsubmit","return check()"); 
}); */
function fmoney(s, n)   
{   
   n = n > 0 && n <= 20 ? n : 2;   
   s = parseFloat((s + "").replace(/[^\d\.-]/g, "")).toFixed(n) + "";   
   var l = s.split(".")[0].split("").reverse(),   
   r = s.split(".")[1];   
   t = "";   
   for(i = 0; i < l.length; i ++ )   
   {   
      t += l[i] + ((i + 1) % 3 == 0 && (i + 1) != l.length ? "," : "");   
   }   
   return t.split("").reverse().join("") + "." + r;   
} 

function float_form_check(){
	var nam = $("#b_AMOUNT").val();
	if (nam <=100){
			alert("金额不对,至少100分!");
			$("#b_AMOUNT").focus();
			return false;
	}
	var nam = $("#dt_fkk").val();
	if (nam==""){
			alert("放款基准日不能为空！");
			$("#dt_fkk").focus();
			return false;
	}
	var xm = fmoney($("#b_AMOUNT").val()/100/10000,2)+'】万元';
	var checkText=$("#bt").val()+"【分期代收】金额【"+xm; 
	if (!confirm('确定给'+checkText+'吗？')){
			return false;
	}
	return true;
} 

function float_submit_succ(){
	$("#modal").modal("hide");
	alert('新建批量代收成功!');
}
</script>
          	</form>
          </div>
          
                    <div class="modal-footer">
            <button type="button" class="btn btn-default pull-left" data-dismiss="modal" aria-label="Close">取消返回</button>
            <button type="submit" class="btn btn-danger" onclick="$('#float_form').submit()">保存提交</button>
          </div>
          	</div>

<script>
var float_submit=function (jo){
	eval('var jo='+jo);
	if(jo.succ){
		if(typeof(float_submit_succ)=='function'){
			float_submit_succ(jo);
		}else{
			window.location.reload();
		}
		$.fancybox.close();
	}else if(jo.msg){
		alert(jo.msg);
	}
}
$('#float_form').submit(function (){

	if(typeof(float_form_check)=='function'){
		if(!float_form_check()){
			return false;
		}
	}
	
	$('#float_form').ajaxSubmit(float_submit); 
	return false;
});
my_loaded($('#float_form'));
html_load_succ($('#float_form'));
</script>
<script>
var float_load_succ_close=null;
function float_reload(html){
	$('#fancybox-content>div').html(html);
	$.fancybox.resize();
	float_load_succ();
}
var float_load_succ=function (){
	if(float_load_succ_close){
		float_load_succ_close=null;
		$.fancybox.close();
		return ;
	}
	$('#fancybox-content form.thickbox').ajaxForm(function (html){
		if(html){
			float_reload(html)
		}
	})
}
//setTimeout(float_load_succ,100);
</script>           