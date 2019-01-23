<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form name="modalForm" class="form-horizontal" >
<style type="text/css">
.form-control{border:none;}
</style>
<div class="content-wrapper fixed-footer" style="min-height: 943px;">
		<!-- Main content -->
	<section class="content">
<div style="border:1px solid #478FCA; margin:15px;margin-left:0px; padding:50px;padding-bottom:200px;border-radius: 10px;">
	    <div class="form-group" >
			<label class="col-sm-2 control-label" style="text-align:left;">业务编号:<i class="red">*</i></label>
	  		<div class="col-sm-2">
			<input readonly="readonly" style="margin-left:-105px;" id="" name="" value="${icbc_map.gems_code}" class="form-control" type="text" />
		    </div>
			<label class="col-sm-2 control-label" style="text-align:left;">主贷人姓名:<i class="red">*</i></label>
			<div class="col-sm-2">
	      	<input readonly="readonly" style="margin-left:-92px;" id="" name="" value="${icbc_map.c_name}" class="form-control" type="text" />
			</div>
			<label class="col-sm-2 control-label" style="text-align:left;">身份证号:<i class="red">*</i></label>
	  		<div class="col-sm-2">
			<input readonly="readonly" style="margin-left:-105px;" id="" name="" value="${icbc_map.c_cardno}" class="form-control" type="text" />
		    </div>
		</div>
		<div class="form-group" >
			
			<label class="col-sm-2 control-label" style="text-align:left;">上牌地:<i class="red">*</i></label>
			<div class="col-sm-2">
	      	<input readonly="readonly" style="margin-left:-105px;" id="" name="" value="${icbc_map.kk_car_stateid}${icbc_map.kk_car_cityid}" class="form-control" type="text" />
			</div>
			<label class="col-sm-2 control-label" style="text-align:left;">合伙人团队:<i class="red">*</i></label>
	  		<div class="col-sm-2">
			<input readonly="readonly" style="margin-left:-92px;" id="" name="" value="" class="form-control" type="text" />
		    </div>
		    <label class="col-sm-2 control-label" style="text-align:left;">业务员:<i class="red">*</i></label>
			<div class="col-sm-2">
	      	<input readonly="readonly" style="margin-left:-105px;" id="" name="" value="" class="form-control" type="text" />
			</div>
		</div>
		<div class="form-group" >
			<label class="col-sm-2 control-label" style="text-align:left;">贷款产品:<i class="red">*</i></label>
	  		<div class="col-sm-2">
			<input readonly="readonly" style="margin-left:-105px;" id="" name="" value="${icbc_map.loan_tpid}" class="form-control" type="text" />
			</div>
		    <label class="col-sm-2 control-label" style="text-align:left;">按揭期数:<i class="red">*</i></label>
			<div class="col-sm-2">
	      	<input readonly="readonly" style="margin-left:-92px;" id="" name="" value="${icbc_map.kk_loan_ajqx}" class="form-control" type="text" />
			</div>
			<label class="col-sm-2 control-label" style="text-align:left;">按揭银行:<i class="red">*</i></label>
	  		<div class="col-sm-2">
			<input readonly="readonly"  style="margin-left:-105px;" id="" name="" value="${icbc_map.bank_id}" class="form-control" type="text" />
		    </div>
		</div>
		<div class="form-group" >
		    <label class="col-sm-2 control-label" style="text-align:left;">贷款金额:<i class="red">*</i></label>
			<div class="col-sm-2">
	      	<input readonly="readonly" style="margin-left:-105px;" id="" name="" value="" class="form-control" type="text" />
			</div>
			<label class="col-sm-2 control-label" style="text-align:left;">银行分期本金:<i class="red">*</i></label>
	  		<div class="col-sm-2">
			<input readonly="readonly" style="margin-left:-90px;" id="" name="" value="${icbc_map.Principal}" class="form-control" type="text" />
			</div>
		    <label class="col-sm-2 control-label" style="text-align:left;">银行分期比例:<i class="red">*</i></label>
			<div class="col-sm-2">
	      	<input readonly="readonly"  style="margin-left:-105px;" id="" name="" value="" class="form-control" type="text" />
			</div>
		</div>
		<div class="form-group" >
			<label class="col-sm-2 control-label" style="text-align:left;">贷款利息:<i class="red">*</i></label>
	  		<div class="col-sm-2">
			<input readonly="readonly"  style="margin-left:-105px;" id="" name="" value="" class="form-control" type="text" />
			</div>
		    <label class="col-sm-2 control-label" style="text-align:left;">银行手续费:<i class="red">*</i></label>
			<div class="col-sm-2">
	      	<input readonly="readonly" style="margin-left:-92px;" id="" name="" value="" class="form-control" type="text" />
			</div>
			<label class="col-sm-2 control-label" style="text-align:left;">银行利率:<i class="red">*</i></label>
	  		<div class="col-sm-2">
			<input readonly="readonly" style="margin-left:-105px;" id="" name="" value="" class="form-control" type="text" />
			</div>
			
		</div>
		<div class="form-group" >
			<label class="col-sm-2 control-label" style="text-align:left;">首付款:<i class="red">*</i></label>
	  		<div class="col-sm-2">
			<input readonly="readonly" style="margin-left:-105px;" id="" name="" value="" class="form-control" type="text" />
		    </div>
		    <label class="col-sm-2 control-label" style="text-align:left;">首付比例:<i class="red">*</i></label>
			<div class="col-sm-2">
	      	<input readonly="readonly" style="margin-left:-92px;" id="" name="" value="" class="form-control" type="text" />
			</div>
			<label class="col-sm-2 control-label" style="text-align:left;">执行利率:<i class="red">*</i></label>
	  		<div class="col-sm-2">
			<input readonly="readonly" style="margin-left:-105px;" id="" name="" value="${icbc_map.kk_loan_rate}" class="form-control" type="text" />
			</div>
		    
		</div>

		<div class="form-group" >
			<label class="col-sm-2 control-label" style="text-align:left;">银行首月还款:<i class="red">*</i></label>
			<div class="col-sm-2">
	      	<input readonly="readonly" style="margin-left:-105px;" id="" name="" value="" class="form-control" type="text" />
			</div>
			<label class="col-sm-2 control-label" style="text-align:left;">月还款:<i class="red">*</i></label>
	  		<div class="col-sm-2">
			<input readonly="readonly" style="margin-left:-92px;" id="" name="" value="${icbc_map.Monthlypayments}" class="form-control" type="text" />
			</div>
		    <label class="col-sm-2 control-label" style="text-align:left;">主贷人手机:<i class="red">*</i></label>
			<div class="col-sm-2">
	      	<input readonly="readonly" style="margin-left:-105px;" id="" name="" value="${icbc_map.c_tel}" class="form-control" type="text" />
			</div>
		</div>
		<div class="form-group" >
			<label class="col-sm-2 control-label" style="text-align:left;">预留字段:<i class="red">*</i></label>
	  		<div class="col-sm-2">
			<input readonly="readonly" style="margin-left:-105px;" id="" name="" value="${pd.c_tel }aaaaaa" class="form-control" type="text" />
		    </div>
		    <label class="col-sm-2 control-label" style="text-align:left;">预留字段:<i class="red">*</i></label>
			<div class="col-sm-2">
	      	<input readonly="readonly" style="margin-left:-90px;" id="" name="" value="${pd.c_tel }bbbbbb" class="form-control" type="text" />
		    </div>
		</div>
		
</section>		
		</div>
		</div><!-- /.content-wrapper -->
</form>
			
