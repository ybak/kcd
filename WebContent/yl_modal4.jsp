<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
            <div id="float_page_div">
	        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
            <h4 class="modal-title" id="myModalLabel">编辑银联代收付系统信息</h4>
          </div>
          <div class="modal-body">
          	<form class="form-horizontal" id="float_form" action="" method="post">
          		<div class="box-body">
	<div class="modal-header">
		<h4 class="modal-title" id="myModalLabel">已有<font color="red">代付</font>记录</h4>
	</div>
	<div class="modal-body form-horizontal">
		<ul class="nav nav-pills nav-stacked">
								<li style="padding-bottom: 10px"><i class="fa fa-circle-o" style="color: green"></i>暂无记录<span class="pull-right">暂无<font color="red">代付</font>记录</span></li>		</ul>
	</div>
	<div class="modal-header">
		<h4 class="modal-title" id="myModalLabel" style="color:red;">新建<font color="red">代付</font></h4>
	</div>
	<input name="qryid" value="471" type="hidden"> 
	<input name="type" value="9" type="hidden">
<input name="gems_fs_id" value="511" type="hidden">
<input name="bank_id" value="60" type="hidden">
<input name="ds_type" value="1" type="hidden">
<input name="c_name" value="黄忠" type="hidden">
<input name="c_cardno" value="513825198610252011" type="hidden">
<input name="sms_tel" value="13540960599" type="hidden">
	<div class="form-group" style="padding-top: 25px">
		<label for="title2" class="col-sm-3 control-label">签约银联卡:</label>
		<div class="col-sm-9">
			<input class="form-control" id="bt" value="" disabled="disabled" type="text">
		</div>
	</div>
	<div class="form-group">
		<label for="title2" class="col-sm-3 control-label"><font color="red">代付</font>金额(分):</label>
		<div class="col-sm-9">
			<input class="form-control" name="AMOUNT" id="AMOUNT" placeholder="输入代收金额,单位(分)" value="" type="number">
		</div>
	</div>	<div class="form-group">
		<label for="title2" class="col-sm-3 control-label">备注(可不填)</label>
		<div class="col-sm-3">
			<input class="form-control" name="remark" placeholder="比如:正常代收" type="text">
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
	var checkText=$("#bt").val()+"【代付】金额【"+xm; 
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