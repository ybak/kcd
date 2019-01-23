<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<form name="modalForm" class="form-horizontal">
 <div style="border:1px solid #478FCA;   margin:5px; padding:20px;border-radius: 10px;">
	    <div class="form-group" >
			<label class="col-sm-2 control-label">开票价(元)<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="kp_price" name="kp_price" value="${pd.kp_price }" class="form-control" type="number" />
		    </div>
			<label class="col-sm-2 control-label">评估价(元)<i class="red">*</i></label>
			<div class="col-sm-3">
	      		<input id="price_result" name="price_result" value="${pd.price_result }" class="form-control" type="number" />
			</div>
		</div>
		<div class="form-group" >
			<label class="col-sm-2 control-label">贷款本金(元)<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="dk_price" name="dk_price" value="${pd.dk_price }" class="form-control" type="number" />
		    </div>
			<label class="col-sm-2 control-label">金融服务费(元)<i class="red">*</i></label>
			<div class="col-sm-3">
	      		<input id="jrfw_price" name="jrfw_price" value="${pd.jrfw_price }" class="form-control" type="number" />
			</div>
		</div>
		<div class="form-group" >
			<label class="col-sm-2 control-label">贷款总额(元)<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="dk_total_price" name="dk_total_price" value="${pd.dk_total_price }" class="form-control" type="number" />
		    </div>
			<label class="col-sm-2 control-label">首付款(元)<i class="red">*</i></label>
			<div class="col-sm-3">
	      		<input id="sfje" name="sfje" value="${pd.sfje}" class="form-control" type="number" />
			</div>
		</div>
		<div class="form-group" >
			<label class="col-sm-2 control-label">首付比例(%)<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input class="form-control" value="<fmt:formatNumber value='${pd.sfje/pd.kp_price }' maxFractionDigits='0'/>"  type="text" />
		    </div>
			<label class="col-sm-2 control-label">按揭模式<i class="red">*</i></label>
			<div class="col-sm-3">
	      		<select id="loan_tpid" name="loan_tpid" class="form-control">
				    <option>--请选择--</option>
					<option value="1" ${pd.loan_tpid eq '1'?"selected='selected'":''}>卡分期</option>
				</select>
			</div>
		</div>
		<div class="form-group" >
			<label class="col-sm-2 control-label">按揭银行<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<select id="bank_id" name="bank_id" class="form-control">
								<option selected="selected" value="0">请选择按揭银行</option>
								<option value="1" ${pd.bank_id eq '1'?"selected='selected'":''}>工行绍兴分行</option>
								<option value="2" ${pd.bank_id eq '2'?"selected='selected'":''}>工行武林支行</option>
								<option value="3" ${pd.bank_id eq '3'?"selected='selected'":''}>工行义乌支行</option>					
										</select>

		    </div>
			<label class="col-sm-2 control-label">按揭期限<i class="red">*</i></label>
			<div class="col-sm-3">
	      		<select id="aj_date" name="aj_date" class="form-control">
								 <option>--请选择--</option>
								 <option value="12"  ${pd.aj_date eq '12'?"selected='selected'":''}>12期</option>
								 <option value="24"  ${pd.aj_date eq '24'?"selected='selected'":''}>24期</option>
								 <option value="36"  ${pd.aj_date eq '36'?"selected='selected'":''}>36期</option>
								</select>
			</div>
		</div>
		<div class="form-group" >
			<label class="col-sm-2 control-label">贷款利率(%)<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="dk_lv" name="dk_lv" class="form-control" value="${pd.dk_lv }"  type="text" />
		    </div>
		</div>
		<div class="form-group" >
		    <input  id="kk_loan_stateid1" name="kk_loan_stateid1"  type="hidden"  value="${pd.kk_loan_stateidd }" />
		    <input id="kk_loan_cityid1" name="kk_loan_cityid1"  type="hidden" value="${pd.kk_loan_cityidd }" />
		
			<label class="col-sm-2 control-label">开票所在地<i class="red">*</i></label>
	  		<div class="col-sm-4">
			<select id="kk_loan_stateid" onchange="kk_loan_citys(this.options[this.options.selectedIndex].value)" name="kk_loan_stateid" class="form-control">
			<option> 省</option>
			</select>
		    </div>
		    <div class="col-sm-4">
			<select id="kk_loan_cityid" name="kk_loan_cityid" class="form-control">
			<option>市</option>
			</select>
		    </div>
		</div>
		<div class="form-group" >
		    <input  id="kk_car_stateid1" name="kk_car_stateid1"  type="hidden"  value="${pd.kk_car_stateidd }" />
		    <input id="kk_car_cityid1" name="kk_car_cityid1"  type="hidden" value="${pd.kk_car_cityidd }" />
			<label class="col-sm-2 control-label">上牌所在地<i class="red">*</i></label>
	  		<div class="col-sm-4">
			<select id="kk_car_stateid" onchange="kk_car_citys(this.options[this.options.selectedIndex].value)" name="kk_car_stateid" class="form-control">
			<option> 省</option>
			</select>
		    </div>
		    <div class="col-sm-4">
			<select id="kk_car_cityid" name="kk_car_cityid" class="form-control">
			<option>市</option>
			</select>
		    </div>
		</div>
		<div class="form-group" >
			<label class="col-sm-2 control-label">放贷帐号<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input  id="kk_kh" name="kk_kh" value="${pd.kk_kh }" class="form-control" type="text" />
		    </div>
		    <label class="col-sm-2 control-label">车辆使用人<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input  id="" id="" value="${pd.c_name }" class="form-control" type="text" />
		    </div>
		</div>
		<div class="form-group" >
			<label class="col-sm-2 control-label">是否公证<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<select class="form-control">
			                     <option value="0">请选择</option>
								 <option value="1">是</option>
								 <option value="2">否</option>
								</select>
		    </div>
		    <label class="col-sm-2 control-label">是否垫资<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<select id="dz_type" name="dz_type" class="form-control">
								 <option value="0">请选择</option>
								 <option value="2" ${pd.dz_type eq '2'?"selected='selected'":''}>提车垫资</option>
								 <option value="1" ${pd.dz_type eq '1'?"selected='selected'":''}>不垫资</option>
								</select>
			</div>
		</div>
	</div>
	 <script>
	 $(document).ready(function(){
			var stateid=document.getElementById("kk_loan_stateid1").value;
		$.ajax({ 	
				url:"${pageContext.request.contextPath }/finfdstates.do",
			    type:"POST",
			    dataType: "json",
		       success: function(msg){
		       	 var con = "<option value=''>所在省</option>"; 
		       	$("#kk_loan_stateid").empty();
		       	$.each(msg,function(index, n){
		       	  if(stateid==msg[index].id){
		       		con += "<option selected='selected' value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";  
		       	  }else{
		       		con += "<option  value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>"; 
		       	  }
		       	});           	
		       	$("#kk_loan_stateid").append(con);
		       	
		       }
		
		});
		if(stateid!=null&&stateid!=""){
			kk_loan_citys(stateid);
		}else{
			kk_loan_citys('24');
		}
		  
		});
		function kk_loan_citys(cityid){
			var cityid1=document.getElementById("kk_loan_cityid1").value;
			$.ajax({ 	
				url:"${pageContext.request.contextPath }/fincitys.do",
			    type:"POST",
			    dataType: "json",
			    data :{
			    	state_id : cityid
			    },
		       success: function(msg){
		       	 var con = "<option value=''>所在市</option>";         	  
		       	$("#kk_loan_cityid").empty();
		       	$.each(msg,function(index, n){
		       		if(cityid1==msg[index].id){
			       		con += "<option selected='selected' value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";  
			       	  }else{
			       		con += "<option  value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>"; 
			       	  }	        			   	      		
		       	 });           	
		       	$("#kk_loan_cityid").append(con);      	
		       }
		});
		}
	 
				$(document).ready(function(){
					var stateid=document.getElementById("kk_car_stateid1").value;
				$.ajax({ 	
						url:"${pageContext.request.contextPath }/finfdstates.do",
					    type:"POST",
					    dataType: "json",
				       success: function(msg){
				       	 var con = "<option value=''>所在省</option>"; 
				       	$("#kk_car_stateid").empty();
				       	$.each(msg,function(index, n){
				       	  if(stateid==msg[index].id){
				       		con += "<option selected='selected' value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";  
				       	  }else{
				       		con += "<option  value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>"; 
				       	  }
				       	});           	
				       	$("#kk_car_stateid").append(con);
				       	
				       }
				
				});
				if(stateid!=null&&stateid!=""){
					kk_car_citys(stateid);
				}else{
					kk_car_citys('24');
				}
				  
				});
				function kk_car_citys(cityid){
					var cityid1=document.getElementById("kk_car_cityid1").value;
					$.ajax({ 	
						url:"${pageContext.request.contextPath }/fincitys.do",
					    type:"POST",
					    dataType: "json",
					    data :{
					    	state_id : cityid
					    },
				       success: function(msg){
				       	 var con = "<option value=''>所在市</option>";         	  
				       	$("#kk_car_cityid").empty();
				       	$.each(msg,function(index, n){
				       		if(cityid1==msg[index].id){
					       		con += "<option selected='selected' value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";  
					       	  }else{
					       		con += "<option  value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>"; 
					       	  }	        			   	      		
				       	 });           	
				       	$("#kk_car_cityid").append(con);      	
				       }
				});
				}
				</script>

</form>
<c:if test="${requestScope.type!='wdrw' }">
<div class="modal-footer">
<button onclick="location.href='${pageContext.request.contextPath}/erp/user_list_.do?type=wlghd&dn=${requestScope.cn }&qn=list&pagesize=10&pagenow=1'" class="btn btn-warning" >取消</button>
<button onclick="location.href=''" class="btn btn-primary" >提交</button>
</div>
</c:if>
			
