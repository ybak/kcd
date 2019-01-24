<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
		<div id="float_page_div">
	          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
            <h4 class="modal-title" id="myModalLabel">编辑信息</h4>
          </div>
          <div class="modal-body">

<form class="form-horizontal" id="float_form" action="" method="post">
          		<div class="box-body">
<input name="gems_fs_id" value="64" type="hidden">
	<div class="form-group">
		<label for="title2" class="col-sm-3 control-label">选择银行</label>
		<div class="col-sm-9">
			<select class="form-control" name="BANK_CODE" id="BANK_CODE">
			<option value="102" selected="selected">中国工商银行</option>
			<option value="104">中国银行</option>
			<option value="302">中信银行</option>
			<option value="303">中国光大银行</option>
			<option value="305">中国民生银行</option>
			<option value="306">广东发展银行</option>
			<option value="307">平安银行</option>
			<option value="308">招商银行</option>
			<option value="309">兴业银行</option>
			<option value="403">中国邮政储蓄银行</option>			
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="title2" class="col-sm-3 control-label">货币类型</label>
		<div class="col-sm-9">
			<select class="form-control" name="CURRENCY">
			<option value="CNY" selected="selected">人民币</option>
			<option value="HKD">港元</option>
			<option value="USD">美元</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="title2" class="col-sm-3 control-label">账号类型</label>
		<div class="col-sm-9">
			<select class="form-control" name="ACCOUNT_TYPE">
			<option value="00" ${qy.ACCOUNT_TYPE == 00?"selected='selected'":''} selected="selected">银行卡</option>
			<option value="01" ${qy.ACCOUNT_TYPE == 01?"selected='selected'":''}>存折</option>			
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="title2" class="col-sm-3 control-label">卡号/存折号</label>
		<div class="col-sm-9">
			<input value="${qy.ACCOUNT_NO}" class="form-control" name="ACCOUNT_NO" onkeyup="(this.v=function(){this.value=this.value.trim();this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)" onblur="this.v();" type="text">
		</div>
	</div>
	<div class="form-group">
		<label for="title2" class="col-sm-3 control-label">持有人姓名</label>
		<div class="col-sm-9">
			<input value="<%-- ${qy.ACCOUNT_NAME} --%>${requestScope.cname}" class="form-control" name="ACCOUNT_NAME" onblur="this.value=this.value.trim();"  type="text">
		</div>
	</div>
	<div class="form-group">
		<label for="title2" class="col-sm-3 control-label">开户行所在省</label>
		<div class="col-sm-9">
			<input value="${qy.PROVINCE}" class="form-control" name="PROVINCE" onblur="this.value=this.value.trim();" type="text">
		</div>
	</div>
	<div class="form-group">
		<label for="title2" class="col-sm-3 control-label">开户行所在市</label>
		<div class="col-sm-9">
			<input value="${qy.CITY}" class="form-control" name="CITY" onblur="this.value=this.value.trim();" type="text">
		</div>
	</div>
	<div class="form-group">
		<label for="title2" class="col-sm-3 control-label">开户行名称</label>
		<div class="col-sm-9">
			<input value="${qy.BANK_NAME}" class="form-control" name="BANK_NAME" onblur="this.value=this.value.trim();" type="text">
		</div>
	</div>
	<div class="form-group">
		<label for="title2" class="col-sm-3 control-label">私人/公司</label>
		<div class="col-sm-9">
			<select class="form-control" name="ACCOUNT_PROP">
				<option value="0" ${qy.ACCOUNT_PROP == 0 || qy.ACCOUNT_PROP == ''?"selected='selected'":''} selected="selected">私人</option>
				<option value="1" ${qy.ACCOUNT_PROP == 1?"selected='selected'":''}>公司</option>			
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="title2" class="col-sm-3 control-label">证件类型</label>
		<div class="col-sm-9">
			<select class="form-control" name="ID_TYPE">
				<option value="0" ${qy.ID_TYPE == 0?"selected='selected'":''} selected="selected">身份证</option>
				<option value="1" ${qy.ID_TYPE == 1?"selected='selected'":''}>户口簿</option>
				<option value="2" ${qy.ID_TYPE == 2?"selected='selected'":''}>护照</option>
				<option value="3" ${qy.ID_TYPE == 3?"selected='selected'":''}>军官证</option>
				<option value="4" ${qy.ID_TYPE == 4?"selected='selected'":''}>士兵证</option>
				<option value="5" ${qy.ID_TYPE == 5?"selected='selected'":''}>港澳居民来往内地通行证</option>
				<option value="6" ${qy.ID_TYPE == 6?"selected='selected'":''}>台湾同胞来往内地通行证</option>
				<option value="7" ${qy.ID_TYPE == 7?"selected='selected'":''}>临时身份证</option>
				<option value="8" ${qy.ID_TYPE == 8?"selected='selected'":''}>外国人居留证</option>
				<option value="9" ${qy.ID_TYPE == 9?"selected='selected'":''}>警官证</option>
				<option value="X" ${qy.ID_TYPE == X?"selected='selected'":''}>其他证件</option>			
			</select>
		</div>
	</div>
	<div class="form-group">
		<label for="title2" class="col-sm-3 control-label">证件号码</label>
		<div class="col-sm-9">
			<input value="<%-- ${qy.c_cardid} --%>${requestScope.idcard}"  class="form-control" name="c_cardid" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();"  type="text">
		</div>
	</div>
	<div class="form-group">
		<label for="title2" class="col-sm-3 control-label">电话</label>
		<div class="col-sm-9">
			<div class="input-group">
				<!-- 18616370921 -->
				<input value="${qy.TEL}" class="form-control" name="TEL" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text">
				<span class="input-group-addon"><a href="tel:">拨打</a></span>
			</div>
		</div>
	</div>
	<div class="form-group">
		<label for="title2" class="col-sm-3 control-label">备注</label>
		<div class="col-sm-9">
			<textarea  style="width: 100%; height: 40px" class="form-control" name="remark">12<%-- ${qy.remark} --%></textarea>
		</div>
	</div>
</div>
<script>

function float_form_check(){
	return true;
} 

function float_submit_succ(){
	$("#modal").modal("hide");
}
</script>          
</form>
          </div>          
            <div class="modal-footer">
            <button type="button" class="btn btn-default pull-left" data-dismiss="modal" aria-label="Close">取消返回</button>
            <button type="submit" class="btn btn-danger" onclick="$('#float_form').submit()">保存提交</button>
          </div>
        </div>