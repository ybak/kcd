<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form name="modalForm" class="form-horizontal">
<div style="border:1px solid #478FCA;   margin:5px; padding:20px;border-radius: 10px;">
	    <div class="form-group" >
			<label class="col-sm-2 control-label">姓名<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="" name="" value="${pd.c_name }" class="form-control" type="text" />
		    </div>
			<label class="col-sm-2 control-label">身份证<i class="red">*</i></label>
			<div class="col-sm-3">
	      		<input id="" name="" value="${pd.c_cardno }" class="form-control" type="text" />
			</div>
		</div>
		<div class="form-group" >
			<label class="col-sm-2 control-label">电话<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="" name="" value="${pd.c_tel }" class="form-control" type="text" />
		    </div>
			<label class="col-sm-2 control-label">性别<i class="red">*</i></label>
			<div class="col-sm-3">
	      	<select class="form-control" id="" name="">
			<option value="">--请选择--</option>
			<option value="1" ${requestScope.pd.c_sex eq '1'?"selected='selected'":''}>男</option>
			<option value="0" ${requestScope.pd.c_sex eq '0'?"selected='selected'":''}>女</option>
			</select>
			</div>
		</div>
		<div class="form-group" >
			<label class="col-sm-2 control-label">按揭银行<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<select id="" name="" class="form-control">
								<option  value="0">请选择按揭银行</option>
								<option value="1" ${requestScope.pd.bank_id eq '1'?"selected='selected'":''}>工行绍兴分行</option>
								<option value="2" ${requestScope.pd.bank_id eq '2'?"selected='selected'":''}>工行武林支行</option>
								<option value="3" ${requestScope.pd.bank_id eq '3'?"selected='selected'":''}>工行义乌支行</option>							
								</select>
		    </div>
			<label class="col-sm-2 control-label">贷款产品<i class="red">*</i></label>
			<div class="col-sm-3">
	      	<select name="" id="" class="form-control">
								<option  value="0">请选择贷款产品</option>
								<option value="1" ${requestScope.pd.loan_tpid eq '1'?"selected='selected'":''}>卡分期</option>							
			</select>
			</div>
		</div>
		<div class="form-group" >
			<label class="col-sm-2 control-label">业务等级<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<select id="" name="" class="form-control">
								<option  value="0">请选择业务等级</option>
								<option value="1" ${requestScope.pd.loan_level eq '1'?"selected='selected'":''}>预期贷款额10万以下（含10万）</option>
								<option value="2" ${requestScope.pd.loan_level eq '2'?"selected='selected'":''}>预期贷款额10万以上</option>							
			</select>
		    </div>
		    
		</div>
		<div style="border:1px solid #478FCA;   margin:5px; padding:20px;border-radius: 10px;">
		<div class="form-group" >
		    <label class="col-sm-2 control-label">配偶姓名<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="" name="" value="${pd.c_name_mt }" class="form-control" type="text" />
		    </div>
		    <label class="col-sm-2 control-label">配偶身份证<i class="red">*</i></label>
			<div class="col-sm-3">
	      		<input id="" name="" value="${pd.c_cardno_mt  }" class="form-control" type="text" />
			</div>
		</div>
	    <div class="form-group" >
				
			<label class="col-sm-2 control-label">配偶手机号<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="" name="" value="${pd.c_tel_mt  }" class="form-control" type="text" />
		    </div>	
		</div>
		</div>
		<div style="border:1px solid #478FCA;   margin:5px; padding:20px;border-radius: 10px;">
		<div class="form-group" >
			
			<label class="col-sm-2 control-label">共还人1姓名<i class="red">*</i></label>
			<div class="col-sm-3">
	      		<input id="" name="" value="${pd.c_name_gj1 }" class="form-control" type="text" />
			</div>		
			<label class="col-sm-2 control-label">共还人1身份证<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="" name="" value="${pd.c_cardno_gj1 }" class="form-control" type="text" />
		    </div>
		</div>
		<div class="form-group" >
			<label class="col-sm-2 control-label">共还人1手机号<i class="red">*</i></label>
			<div class="col-sm-3">
	      		<input id="" name="" value="${pd.c_tel_gj1 }" class="form-control" type="text" />
			</div>		
		</div>
		</div>
		<div style="border:1px solid #478FCA;   margin:5px; padding:20px;border-radius: 10px;">		
		<div class="form-group" >
			<label class="col-sm-2 control-label">共还人2姓名<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="" name="" value="${pd.c_name_gj2 }" class="form-control" type="text" />
		    </div>
			<label class="col-sm-2 control-label">共还人2身份证<i class="red">*</i></label>
			<div class="col-sm-3">
	      		<input id="" name="" value="${pd.c_cardno_gj2 }" class="form-control" type="text" />
			</div>					
		</div>
		<div class="form-group" >
		<label class="col-sm-2 control-label">共还人2手机号<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="" name="" value="${pd.c_tel_gj2 }" class="form-control" type="text" />
		    </div>
		</div>
		</div>
		</div>
</form>
			
