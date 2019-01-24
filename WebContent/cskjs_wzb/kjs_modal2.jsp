<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
          	<form class="form-horizontal" id="float_form" action="http://a.kcway.net/assess/manager/command.php?do=add&amp;cn=yl_ds&amp;id=" method="post">
          		<div class="box-body">
	<div class="modal-header">
		<h4 class="modal-title" id="myModalLabel">已有<font color="green">代收</font>记录</h4>
	</div>
	<div class="modal-body form-horizontal">
		<ul class="nav nav-pills nav-stacked">
								<li style="padding-bottom: 10px"><i class="fa fa-circle-o" style="color: green"></i>暂无记录<span class="pull-right">暂无<font color="green">代收</font>记录</span></li>		</ul>
	</div>
	<div class="modal-header">
		<h4 class="modal-title" id="myModalLabel">新建<font color="green">代收</font></h4>
	</div>
	<input type="hidden" name="qryid" value="15"> <input type="hidden" name="type" value="">
<input type="hidden" name="gems_fs_id" value="">
<input type="hidden" name="bank_id" value="3">
<input type="hidden" name="ds_type" value="0">
<input type="hidden" name="c_name" value="">
<input type="hidden" name="c_cardno" value="">
<input type="hidden" name="sms_tel" value="">
	<div class="form-group" style="padding-top: 25px">
		<label for="title2" class="col-sm-3 control-label">签约银联卡:</label>
		<div class="col-sm-9">
			<input type="text" class="form-control" id="bt" value="-" disabled="">
		</div>
	</div>
	<div class="form-group">
		<label for="title2" class="col-sm-3 control-label"><font color="green">代收</font>金额(分):</label>
		<div class="col-sm-9">
			<input type="number" class="form-control" name="AMOUNT" id="AMOUNT" placeholder="输入代收金额,单位(分)" value="0">
		</div>
	</div>	<div class="form-group">
		<label for="title2" class="col-sm-3 control-label">备注(可不填)</label>
		<div class="col-sm-3">
			<input type="text" class="form-control" name="remark" placeholder="比如:正常代收" value="">
		</div>
		<div class="col-sm-6">
		<div class="input-group">
										<span class="input-group-addon">短信通知用户</span> <select name="sendsms" class="form-control" id="sendsms">
											<option value="1">是</option><option selected="selected" value="0">否</option>	                            		</select>
		</div>
		</div>
	</div>
</div>
<script type="text/javascript">
<!--
//-->
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
	var nam = $("#AMOUNT").val();
	if (nam <=100){
			alert("金额不对,至少100分!");
			$("#AMOUNT").focus();
			return false;
	}
	var xm = fmoney($("#AMOUNT").val()/100/10000,2)+'】万元';
	var checkText=$("#bt").val()+"【代收】金额【"+xm; 
	if (!confirm('确定给'+checkText+'吗？')){
			return false;
	}
	return true;
} 
function float_submit_succ(){
	$("#modal").modal("hide");
	alert('新建代收成功!');
}
</script>
          	</form>
</body>
</html>