<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/bootstrap-select.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/bootstrap-select.min.js"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/i18n/defaults-zh_CN.min.js"></script>

		<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper fixed-footer" style="min-height: 943px;">
		<!-- Main content -->
<section class="content">
<div class="admin-content nav-tabs-custom box">
<ul id="fsTab" class="nav nav-tabs">
   <li>
   <a href="#gszl" data-toggle="tab">
         基础资料
   </a>
   </li>
   <li>
   <a href="#yxcl" data-toggle="tab">
         影像材料
   </a>
   </li>
</ul>
<div id="fsTabContent" class="tab-content"> 
<div id="gszl" class="tab-pane fade active in">
<c:if test="${requestScope.cn eq '3'}">
<form onsubmit = "return checkUser();"  id="info_form" action="${pageContext.request.contextPath }/erp/assess_fs_update.do" class="form-horizontal" method="post" enctype="multipart/form-data">
</c:if>
<c:if test="${requestScope.cn eq '1'}">
<form onsubmit = "return checkUser();"  id="info_form" action="${pageContext.request.contextPath }/erp/assess_fs_add.do" class="form-horizontal" method="post" enctype="multipart/form-data">
</c:if>
<c:if test="${requestScope.cn eq '4'}">
<form   id="info_form" action="" class="form-horizontal" method="post" enctype="multipart/form-data">
</c:if>
<input name="type" value="zhgl" type="hidden">
<input name="dn" value="assess_fs" type="hidden">
<input name="qn" value="list" type="hidden">
<input name="userid" value="${sessionScope.pd.id }" type="hidden">
<input name="id" value="${requestScope.pd.id }" type="hidden">
<input name="fs_details_id" value="${requestScope.pd.fs_details_id }" type="hidden">
<div class="panel-group" id="accordion">
<div class="panel panel-default">
        <div class="panel-heading">
           <h4 class="box-title">
           <a data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="false" class="collapsed">公司资料</a>
		   <a class=" btn btn-info search-btn pull-right">导出</a>
		   </h4>
		        
		</div>
		<div id="collapseOne" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
			<div class="panel-body">
		<div class="box-body">
		<div class="form-group">
			<label for="inputHouse" class="col-sm-2 control-label">基本资料</label>
			<div class="col-sm-10">
				<div class="row inline-from">
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">
								<a href="javascript:dofind()">公司简称</a>
							</span>
							<input  id="name" name="name" value="${requestScope.pd.name }" class="form-control" onblur="showun();" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">签约公司名称</span>
							<input id="name_qy" name="name_qy" value="${requestScope.pd.name_qy }" class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">		
							<span class="input-group-addon">合同编号</span>
							<input id="contract_code" name="contract_code" value="${requestScope.pd.contract_code }" class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">合作起止日期</span>
							<input id="hz_date1" name="hz_date1" value="${requestScope.pd.hz_date1 }" class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
							<input id="hz_date2" name="hz_date2" value="${requestScope.pd.hz_date2 }" class="form-control" placeholder="" type="text">
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">法人姓名</span>
							<input id="fr_name" name="fr_name" value="${requestScope.pd.fr_name }" class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">法人身份证号</span>
							<input id="fr_card" name="fr_card" value="${requestScope.pd.fr_card }" class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">法人联系电话</span>
							<input id="fr_tel" name="fr_tel" value="${requestScope.pd.fr_tel }" class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">实际控股人</span>
							<select id="sjkgr" name="sjkgr" onchange="sjkgr_hidden()" class="form-control">
							<option value="0">请选择</option>
							<option value="1" ${requestScope.pd.sjkgr eq '1'?"selected='selected'":''}>法人</option>
							<option value="2" ${requestScope.pd.sjkgr eq '2'?"selected='selected'":''}>股东</option>
							</select>
						</div>
					</div>
					<script type="text/javascript">
					$(document).ready(function(){
						sjkgr_hidden();
					});
					   function sjkgr_hidden() {
						  var sjkgr=$("#sjkgr").val();
						  if(sjkgr==2){
							 document.getElementById('sjkgr1').style.display="block";
							 document.getElementById('sjkgr2').style.display="block";
							 document.getElementById('sjkgr3').style.display="block";
						  }else{
							 document.getElementById('sjkgr1').style.display="none";
							 document.getElementById('sjkgr2').style.display="none";
							 document.getElementById('sjkgr3').style.display="none";
						  }
					   }
					</script>
					<div id="sjkgr1" style="display:none;" class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">实际控股人姓名</span>
							<input id="sjkgr_name" name="sjkgr_name" value="${requestScope.pd.sjkgr_name}" class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div id="sjkgr2" style="display:none;" class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">实际控股人身份证号</span>
							<input id="sjkgr_card" name="sjkgr_card" value="${requestScope.pd.sjkgr_card}" class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div id="sjkgr3" style="display:none;" class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">实际控股人联系电话</span>
							<input id="sjkgr_tel" name="sjkgr_tel" value="${requestScope.pd.sjkgr_tel}" class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon">公司注册日期</span>
							<input id="company_date" name="company_date" value="${requestScope.pd.company_date}" class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon">注册资本（万元）</span>
							<input id="register_capital" name="register_capital" value="${requestScope.pd.register_capital}" class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon">实缴资本（万元）</span>
							<input id="sj_capital" name="sj_capital" value="${requestScope.pd.sj_capital}" class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon">公司办公人数 </span>
							<input id="company_num" name="company_num" value="${requestScope.pd.company_num}" class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">公司办公所在地址 </span>
							<select onchange="citys('company_city',this.options[this.options.selectedIndex].value)" name="company_province" id="company_province"  class="form-control">
                            <option value="0">所在省</option>
							</select>
						</div>
					</div>
					<div class="col-sm-4">
							<select onchange="getcomm_zones('company_section','company_province',this.options[this.options.selectedIndex].value)" name="company_city" id="company_city"  class="form-control">
                            <option value="0">所在市</option>
							</select>
					</div>
					<div class="col-sm-4">
							<select name="company_section" id="company_section"  class="form-control">
                            <option value="0">所在区</option>
							</select>
					</div>
					<div class="col-sm-12">
						<div class="input-group">
							<span class="input-group-addon">详细地址</span>
							<input id="company_address" name="company_address" value="${requestScope.pd.company_address}" class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">营业执照注册地址 </span>
							<select onchange="citys('register_city',this.options[this.options.selectedIndex].value)" name="register_province" id="register_province"  class="form-control">
                            <option value="0">所在省</option>
							</select>
						</div>
					</div>
					<div class="col-sm-4">
							<select onchange="getcomm_zones('register_section','register_province',this.options[this.options.selectedIndex].value)" name="register_city" id="register_city"  class="form-control">
                            <option value="0">所在市</option>
							</select>
					</div>
					<div class="col-sm-4">
							<select name="register_section" id="register_section"  class="form-control">
                            <option value="0">所在区</option>
							</select>
					</div>
					<div class="col-sm-12">
						<div class="input-group">
							<span class="input-group-addon">详细地址</span>
							<input id="register_address" name="register_address" value="${requestScope.pd.register_address}" class="form-control" placeholder="" type="text">
						</div>
					</div>
					<%-- <div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">所在城市</span>
							<input type="hidden" name="stateid" id="stateid"  value="${requestScope.pd.state_id }"  />
							<select name="state_id" id="state_id" onchange="citys1(this.options[this.options.selectedIndex].value)" class="form-control">

							</select>
							</div>
					</div>
					<div class="col-sm-4">
					    <input type="hidden" name="cityid" id="cityid"  value="${requestScope.pd.city_id }"  />  
						<select name="city_id" id="city_id"  class="form-control">
						
						</select>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">详细地址</span>
							<input id="address" name="address" value="${requestScope.pd.address }"  class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">联系人</span>
							<input id="" name="" value=""  class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">联系电话</span>
							<input id="" name="" value=""  class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">邮箱</span>
							<input id="" name="" value=""  class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">账户名</span>
							<input id="" name="" value=""  class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">银行账号</span>
							<input id="" name="" value=""  class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">开户行</span>
							<input id="" name="" value=""  class="form-control" placeholder="" type="text">
						</div>
					</div> --%>
				</div>
				<!-- <script>
				$(document).ready(function(){
					var stateid=document.getElementById("stateid").value;
				$.ajax({ 	
						url:"${pageContext.request.contextPath }/finfdstates.do",
					    type:"POST",
					    dataType: "json",
				       success: function(msg){
				       	 var con = ""; 
				       	$("#state_id").empty();
				       	$.each(msg,function(index, n){
				       	  if(stateid==msg[index].id){
				       		con += "<option selected='selected' value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";  
				       	  }else{
				       		con += "<option  value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>"; 
				       	  }
				       	});           	
				       	$("#state_id").append(con);
				       	
				       }
				
				});
				if(stateid!=null&&stateid!=""){
					 citys1(stateid);
				}else{
					citys1('24');
				}
				  
				});
				function citys1(cityid){
					var cityid1=document.getElementById("cityid").value;
					$.ajax({ 	
						url:"${pageContext.request.contextPath }/fincitys.do",
					    type:"POST",
					    dataType: "json",
					    data :{
					    	state_id : cityid
					    },
				       success: function(msg){
				       	 var con = "";         	  
				       	$("#city_id").empty();
				       	$.each(msg,function(index, n){
				       		if(cityid1==msg[index].id){
					       		con += "<option selected='selected' value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";  
					       	  }else{
					       		con += "<option  value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>"; 
					       	  }	        			   	      		
				       	 });           	
				       	$("#city_id").append(con);      	
				       }
				});
				}
				</script> -->
			</div>
		</div>
		<div class="form-group">
		<label for="inputHouse" class="col-sm-2 control-label">账户资料</label>
		<div class="col-sm-10">
				<div class="row inline-from">
				    <div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">结算账户性质</span>
							<select id="account_type" name="account_type" class="form-control">
							<option value="0" >请选择</option>
							<option value="1" ${requestScope.pd.account_type eq '1'?"selected='selected'":''}>基本户</option>
							<option value="2" ${requestScope.pd.account_type eq '2'?"selected='selected'":''}>一般户</option>
							</select>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">账户名</span>
							<input id="account_name" name="account_name" value="${requestScope.pd.account_name}"  class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">银行账号</span>
							<input id="bank_account" name="bank_account" value="${requestScope.pd.bank_account}"  class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">开户行</span>
							<input id="open_bank" name="open_bank" value="${requestScope.pd.open_bank}"  class="form-control" placeholder="" type="text">
						</div>
					</div>
				</div>
		</div>		
		</div>
		
		<!--担保信息  -->
		<div class="form-group">
		<label for="inputHouse" class="col-sm-2 control-label">担保信息</label>
		<div class="col-sm-10">
				<div id="dbxx" class="row inline-from">
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon">担保人姓名1</span>
							<input id="dbr_name1" name="dbr_name[]" value=""  class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon">担保人身份证号1</span>
							<input id="dbr_card1" name="dbr_card[]" value=""  class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon">担保人联系电话1</span>
							<input id="dbr_tel1" name="dbr_tel[]" value=""  class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
						    <input id="dbxx_num" name="dbxx_num" value="1" type="hidden">
							<a id="" name="" onclick="adddbxx()" class="btn btn-primary">新增</a>
							<a id="" name="" onclick="redbxx()" class="btn btn-primary">重置</a>
						</div>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon">担保人配偶姓名1</span>
							<input id="dbrpo_name1" name="dbrpo_name[]" value=""  class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon">担保人配偶身份证号1</span>
							<input id="dbrpo_card1" name="dbrpo_card[]" value=""  class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon">担保人配偶联系电话1</span>
							<input id="dbrpo_tel1" name="dbrpo_tel[]" value=""  class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div id="" class="col-sm-3">
						<div class="input-group">
						   <input id="dbpoxx_num" name="dbpoxx_num" value="1" type="hidden">
							<a id="" name="" onclick="adddbpoxx()" class="btn btn-primary">新增</a>
							<a id="" name="" onclick="redbpoxx()" class="btn btn-primary">重置</a>
						</div>
					</div>
				</div>
		</div>		
		</div>
		<script type="text/javascript">
		$(document).ready(function(){
			document.getElementById("dbxx_num").value=1;
			document.getElementById("dbpoxx_num").value=1;
			if('${requestScope.pd.dbr_map}'!=null&&'${requestScope.pd.dbr_map}'!=''){
				dbxxlist(${requestScope.pd.dbr_map});
			}
			if('${requestScope.pd.dbrpo_map}'!=null&&'${requestScope.pd.dbrpo_map}'!=''){
				dbpoxxlist(${requestScope.pd.dbrpo_map});
			}
		});
		//重置
		function redbxx() {
			var num=$("#dbxx_num").val();
			for(var i=2;i<=num;i++){
				$("#dbr_name_"+i).remove();
				$("#dbr_card_"+i).remove();
				$("#dbr_tel_"+i).remove();
				$("#dbr_del_"+i).remove();
			}
			document.getElementById("dbxx_num").value=1;
		}
        function redbpoxx() {
        	var num=$("#dbpoxx_num").val();
            for(var i=2;i<=num;i++){
            	$("#dbrpo_name_"+i).remove();
    			$("#dbrpo_card_"+i).remove();
    			$("#dbrpo_tel_"+i).remove();
    			$("#dbrpo_del_"+i).remove();
			}
            document.getElementById("dbpoxx_num").value=1;
		}
		function deldbxx(id) {
			$("#dbr_name_"+id).remove();
			$("#dbr_card_"+id).remove();
			$("#dbr_tel_"+id).remove();
			$("#dbr_del_"+id).remove();
		}
        function deldbpoxx(id) {
        	$("#dbrpo_name_"+id).remove();
			$("#dbrpo_card_"+id).remove();
			$("#dbrpo_tel_"+id).remove();
			$("#dbrpo_del_"+id).remove();
		}
		function adddbxx() {
			var num=$("#dbxx_num").val();
			num=Number(num)+1;
            $("#dbxx").append("<div id='dbr_name_"+num+"' class='col-sm-3'>"+
			"<div class='input-group'>"+
			"<span class='input-group-addon'>担保人姓名"+num+"</span>"+
			"<input id='dbr_name"+num+"' name='dbr_name[]' value=''  class='form-control' placeholder='' type='text'>"+
		    "</div>"+
	        "</div>");
            $("#dbxx").append("<div id='dbr_card_"+num+"' class='col-sm-3'>"+
        			"<div class='input-group'>"+
        			"<span class='input-group-addon'>担保人身份证号"+num+"</span>"+
        			"<input id='dbr_card"+num+"' name='dbr_card[]' value=''  class='form-control' placeholder='' type='text'>"+
        		    "</div>"+
        	        "</div>");
            $("#dbxx").append("<div id='dbr_tel_"+num+"' class='col-sm-3'>"+
        			"<div class='input-group'>"+
        			"<span class='input-group-addon'>担保人联系电话"+num+"</span>"+
        			"<input id='dbr_tel"+num+"' name='dbr_tel[]' value=''  class='form-control' placeholder='' type='text'>"+
        		    "</div>"+
        	        "</div>");
            $("#dbxx").append("<div id='dbr_del_"+num+"'  class='col-sm-3'>"+
        			"<div class='input-group'>"+
        			"<a id='' name='' onclick='deldbxx("+num+")' oncli class='btn btn-primary'>删除</a>"+
        		    "</div>"+
        	        "</div>");
            $("#dbxx_num").val(Number(num));
		}
		function adddbpoxx() {
			        var num=$("#dbpoxx_num").val();
			        num=Number(num)+1;
			        $("#dbxx").append("<div id='dbrpo_name_"+num+"' class='col-sm-3'>"+
	        			"<div class='input-group'>"+
	        			"<span class='input-group-addon'>担保人配偶姓名"+num+"</span>"+
	        			"<input id='dbrpo_name"+num+"' name='dbrpo_name[]' value=''  class='form-control' placeholder='' type='text'>"+
	        		    "</div>"+
	        	        "</div>");
		            $("#dbxx").append("<div id='dbrpo_card_"+num+"' class='col-sm-3'>"+
		        			"<div class='input-group'>"+
		        			"<span class='input-group-addon'>担保人配偶身份证号"+num+"</span>"+
		        			"<input id='dbrpo_card"+num+"' name='dbrpo_card[]' value=''  class='form-control' placeholder='' type='text'>"+
		        		    "</div>"+
		        	        "</div>");
		            $("#dbxx").append("<div id='dbrpo_tel_"+num+"' class='col-sm-3'>"+
		        			"<div class='input-group'>"+
		        			"<span class='input-group-addon'>担保人配偶联系电话"+num+"</span>"+
		        			"<input id='dbrpo_tel"+num+"' name='dbrpo_tel[]' value=''  class='form-control' placeholder='' type='text'>"+
		        		    "</div>"+
		        	        "</div>");
		            $("#dbxx").append("<div id='dbrpo_del_"+num+"'  class='col-sm-3'>"+
		        			"<div class='input-group'>"+
		        			"<a id='' name='' onclick='deldbpoxx("+num+")' class='btn btn-primary'>删除</a>"+
		        		    "</div>"+
		        	        "</div>");
		            $("#dbpoxx_num").val(Number(num));
		}
        function dbxxlist(obj) {
        	//${requestScope.pd.dbr_map}
        	//var obj =${requestScope.pd.dbr_map}; 
        	var name = obj.dbr_name.split('\u0005');
        	var card = obj.dbr_card.split('\u0005');
        	var tel = obj.dbr_tel.split('\u0005');
        	for ( var i = 0; i <name.length; i++){
        		num=Number(i)+1;
        		$("#dbxx").append("<div id='dbr_name_"+num+"' class='col-sm-3'>"+
        				"<div class='input-group'>"+
        				"<span class='input-group-addon'>担保人姓名"+num+"</span>"+
        				"<input id='dbr_name"+num+"' name='dbr_name[]' value='"+name[i]+"'  class='form-control' placeholder='' type='text'>"+
        			    "</div>"+
        		        "</div>");
        	            $("#dbxx").append("<div id='dbr_card_"+num+"' class='col-sm-3'>"+
        	        			"<div class='input-group'>"+
        	        			"<span class='input-group-addon'>担保人身份证号"+num+"</span>"+
        	        			"<input id='dbr_card"+num+"' name='dbr_card[]' value='"+card[i]+"'  class='form-control' placeholder='' type='text'>"+
        	        		    "</div>"+
        	        	        "</div>");
        	            $("#dbxx").append("<div id='dbr_tel_"+num+"' class='col-sm-3'>"+
        	        			"<div class='input-group'>"+
        	        			"<span class='input-group-addon'>担保人联系电话"+num+"</span>"+
        	        			"<input id='dbr_tel"+num+"' name='dbr_tel[]' value='"+tel[i]+"'  class='form-control' placeholder='' type='text'>"+
        	        		    "</div>"+
        	        	        "</div>");
        	            $("#dbxx").append("<div id='dbr_del_"+num+"'  class='col-sm-3'>"+
        	        			"<div class='input-group'>"+
        	        			"<a id='' name='' onclick='deldbxx("+num+")' oncli class='btn btn-primary'>删除</a>"+
        	        		    "</div>"+
        	        	        "</div>");
        	            $("#dbxx_num").val(Number(num));
        	}
        }
        function dbpoxxlist(obj) {
        	//${requestScope.pd.dbrpo_map}
        	//var obj =${requestScope.pd.dbrpo_map}; 
        	var name = obj.dbrpo_name.split('\u0005');
        	var card = obj.dbrpo_card.split('\u0005');
        	var tel = obj.dbrpo_tel.split('\u0005');
        	for ( var i = 0; i <name.length; i++){
        		num=Number(i)+1;
		        $("#dbxx").append("<div id='dbrpo_name_"+num+"' class='col-sm-3'>"+
        			"<div class='input-group'>"+
        			"<span class='input-group-addon'>担保人配偶姓名"+num+"</span>"+
        			"<input id='dbrpo_name"+num+"' name='dbrpo_name[]' value='"+name[i]+"'  class='form-control' placeholder='' type='text'>"+
        		    "</div>"+
        	        "</div>");
	            $("#dbxx").append("<div id='dbrpo_card_"+num+"' class='col-sm-3'>"+
	        			"<div class='input-group'>"+
	        			"<span class='input-group-addon'>担保人配偶身份证号"+num+"</span>"+
	        			"<input id='dbrpo_card"+num+"' name='dbrpo_card[]' value='"+card[i]+"'  class='form-control' placeholder='' type='text'>"+
	        		    "</div>"+
	        	        "</div>");
	            $("#dbxx").append("<div id='dbrpo_tel_"+num+"' class='col-sm-3'>"+
	        			"<div class='input-group'>"+
	        			"<span class='input-group-addon'>担保人配偶联系电话"+num+"</span>"+
	        			"<input id='dbrpo_tel"+num+"' name='dbrpo_tel[]' value='"+tel[i]+"'  class='form-control' placeholder='' type='text'>"+
	        		    "</div>"+
	        	        "</div>");
	            $("#dbxx").append("<div id='dbrpo_del_"+num+"'  class='col-sm-3'>"+
	        			"<div class='input-group'>"+
	        			"<a id='' name='' onclick='deldbpoxx("+num+")' class='btn btn-primary'>删除</a>"+
	        		    "</div>"+
	        	        "</div>");
	            $("#dbpoxx_num").val(Number(num));
        	}
        }
		</script>
		<!--其他-->
		<div class="form-group">
		<label for="inputHouse" class="col-sm-2 control-label">其他</label>
		<div class="col-sm-10">
				<div class="row inline-from">
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">业务联系人</span>
							<input id="yw_lxr" name="yw_lxr" value="${requestScope.pd.yw_lxr}"  class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">联系电话</span>
							<input id="yw_tel" name="yw_tel" value="${requestScope.pd.yw_tel}"  class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">邮箱</span>
							<input id="yw_email" name="yw_email" value="${requestScope.pd.yw_email}"  class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">分管大区经理</span>
							<input id="yw_fgdqjl" name="yw_fgdqjl" value="${requestScope.pd.yw_fgdqjl}"  class="form-control" placeholder="" type="text">
						</div>
					</div>
				</div>
		</div>		
		</div>
	</div>
			</div>
		</div>


</div>
<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="box-title">
           <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo1" aria-expanded="false" class="collapsed">账户管理</a>
		   <a class=" btn btn-info search-btn pull-right">导出</a>
			</h4>
		</div>
		<div id="collapseTwo1" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
			<div class="panel-body">
			<div class="box-body">
			<div class="form-group">
			<label for="inputHouse" class="col-sm-2 control-label">账户管理</label>
				<div class="col-sm-10">
				<div class="row inline-from">
				    <div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">启用状态</span>
							<select id="showtag" name="showtag" class="form-control">
							<option value="1" ${requestScope.pd.showtag==1?"selected='selected'":''}>是</option>
							<option value="0" ${requestScope.pd.showtag==0?"selected='selected'":''}>否</option>
							</select>
						</div>
					</div>
					<c:if test="${sessionScope.pd.erp_tag eq '1'}">
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">系统管理</span>
							<select id="icbc_erp_tag" name="icbc_erp_tag" class="form-control">
							<option value="0" ${requestScope.pd.icbc_erp_tag!=1?"selected='selected'":''}>否</option>
							<option value="1" ${requestScope.pd.icbc_erp_tag==1?"selected='selected'":''}>是</option>
							</select>
						</div>
					</div>
					</c:if>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">编号前缀</span>
							<input id="code_pre" name="code_pre" value="${requestScope.pd.code_pre }" class="form-control" placeholder="" onblur="this.value=this.value.toUpperCase();this.value=this.value.trim();" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">名字拼音</span>
							<input id="namepy" name="namepy" value="${requestScope.pd.namepy }" class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">充值币种</span>
							<select id="money_tag" name="money_tag" class="form-control" >
							<option value="0">请选择</option>
							<option value="1" ${requestScope.pd.money_tag==1?"selected='selected'":''}>体验金</option>
							<option value="2" ${requestScope.pd.money_tag==2?"selected='selected'":''}>现金</option>
							</select>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">金额</span>
							<input id="money_num" name="money_num" value="${requestScope.pd.money_num}" class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">类型</span>
							<select id="money_type" name="money_type" class="form-control" >
							<option value="0">请选择</option>
							<option value="1" ${requestScope.pd.money_type==1?"selected='selected'":''}>正常充值</option>
							<option value="2" ${requestScope.pd.money_type==2?"selected='selected'":''}>退款</option>
							</select>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">备注</span>
							<input id="money_bz" name="money_bz" value="${requestScope.pd.money_bz}" class="form-control" placeholder="" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">启用账户列表</span>
							<select id="" name="" class="form-control" >
							
							</select>
						</div>
					</div>
				</div>
				</div>
	</div>
			</div>
			</div>
		</div>
</div>		
<div class="panel panel-default">
		<div class="panel-heading">
			<h4 class="box-title">
           <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" class="collapsed">业务合作模式（上线）</a>
		   <a class=" btn btn-info search-btn pull-right">导出</a>
			</h4>
		</div>
		<div id="collapseTwo" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
			<div class="panel-body">
			<div class="box-body">
		    <div class="form-group">
			<label for="inputHouse" class="col-sm-2 control-label">合作方式 </label>
			<div class="col-sm-10">
				<div class="row inline-from">
				    <div class="col-sm-12">
						<div class="input-group">
							<span class="input-group-addon">展业银行</span>
							<select id="zy_bank" name="zy_bank" class="selectpicker show-tick form-control" multiple data-live-search="true">
							<option value="0">请选择</option>
							<option value="1">杭州城站支行</option>
							<option value="2">哈尔滨顾乡支行</option>
							<option value="3">台州路桥支行</option>
							<option value="4">南京江宁支行</option>
							<option value="5">杭州武林支行</option>
							</select>
						</div>
					</div>
					<script type="text/javascript">
					$(document).ready(function(){

						 if('${requestScope.pd.zy_bank}'!=null&&'${requestScope.pd.zy_bank}'!=''){
							
							var obj='${requestScope.pd.zy_bank}';
					    	var arr=obj.split('\u0005');
					    	/* for(var i=0;i<arr.length;i++){
					    		alert(arr[i]);
					    	} */
					    	
					    	$('#zy_bank').selectpicker({
								'noneSelectedText': '请选择',
						        'selectedText': 'cat'
						    });
					    	$('#zy_bank').selectpicker('val',arr);
						}else{
							$('#zy_bank').selectpicker({
								'noneSelectedText': '请选择',
						        'selectedText': 'cat'
						    });
						}
					});
					</script>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">展业城市</span>
							<select onchange="citys('zy_city',this.options[this.options.selectedIndex].value)" id="zy_province" name="zy_province" class="form-control">
							<option value="0">所在省</option>
							</select>
						</div>
					</div>
					<div class="col-sm-4">
							<select id="zy_city" name="zy_city" class="form-control">
							<option value="0">所在市</option>
							</select>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">业务合作模式</span>
							<select id="ywhz_type" name="ywhz_type" class="form-control">
							<option value="0">请选择</option>
							<option value="1" ${requestScope.pd.ywhz_type eq '1'?"selected='selected'":''}>全兜底</option>
							<option value="2" ${requestScope.pd.ywhz_type eq '2'?"selected='selected'":''}>一年期30%</option>
							<option value="3" ${requestScope.pd.ywhz_type eq '3'?"selected='selected'":''}>不兜底</option>
							</select>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">代理商评级</span>
							<select id="dlspj" name="dlspj" class="form-control">
							<option value="0">请选择</option>
							</select>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
						<span class="input-group-addon">合作类型</span>
						<div class="row" style="margin-left: 2px;">
<div class="checkbox checkbox-success checkbox-inline">
<input type="checkbox" class="styled" id="hz_type1"  name="hz_type"   value="hz_type1">
<label for="hz_type1">新车</label>
</div>
<div class="checkbox checkbox-success checkbox-inline">
<input type="checkbox" class="styled" id="hz_type2" name="hz_type" value="hz_type2">
<label for="hz_type2">二手车</label>
</div>
                        </div>
						</div>
					</div>
					<script type="text/javascript">
					$(document).ready(function(){
						var hz_type='${requestScope.pd.hz_type}';
						if(hz_type.indexOf("hz_type1") != -1){
							$('#hz_type1').attr('checked',true)
							document.getElementById('newcar').style.display="block";
						}
						if(hz_type.indexOf("hz_type2") != -1){
							$('#hz_type2').attr('checked',true)
							document.getElementById('oldcar').style.display="block";
						}
					});
					$("#hz_type1").change(function() {
						if($("#hz_type1").is(":checked")){
							document.getElementById('newcar').style.display="block";
						}else{
							document.getElementById('newcar').style.display="none";
						}
					 });
					$("#hz_type2").change(function() {
						if($("#hz_type2").is(":checked")){
							document.getElementById('oldcar').style.display="block";
						}else{
							document.getElementById('oldcar').style.display="none";
						}
					 });
					</script>
			    </div>
			</div>
			</div>
			<!-- 新车费用配置  -->
			<div id="newcar" style="display: none;" class="form-group">
			<label for="inputHouse" class="col-sm-2 control-label">新车费用配置 </label>
				<div class="col-sm-10">
				<div class="row inline-from">
				    <div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">个人风险筛查费（元）</span>
							<input id="new_grfx_price" name="new_grfx_price" class="form-control"  value="${requestScope.pd.new_grfx_price}" type="text">
						</div>
					</div>
				    <div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">车辆评估费用（元）</span>
							<input id="new_carpg_price" name="new_carpg_price" class="form-control"  value="${requestScope.pd.new_carpg_price}" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">汽车贷款费用（元）</span>
							<input id="new_cardk_price" name="new_cardk_price" class="form-control"  value="${requestScope.pd.new_cardk_price}" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">GPS费用（元）</span>
							<input id="new_gps_price" name="new_gps_price" class="form-control"  value="${requestScope.pd.new_gps_price}" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">其他费用（元）</span>
							<input id="new_qt_price" name="new_qt_price" class="form-control"  value="${requestScope.pd.new_qt_price}" type="text">
						</div>
					</div>
				</div>
				</div>
			</div>
			<!-- 二手车费用配置 -->
			<div id="oldcar" style="display: none;"  class="form-group">
			<label for="inputHouse" class="col-sm-2 control-label">二手车费用配置 </label>
				<div class="col-sm-10">
				<div class="row inline-from">
				    <div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">个人风险筛查费（元）</span>
							<input id="old_grfx_price" name="old_grfx_price" class="form-control"  value="${requestScope.pd.old_grfx_price}" type="text">
						</div>
					</div>
				    <div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">车辆评估费用（元）</span>
							<input id="old_carpg_price" name="old_carpg_price" class="form-control"  value="${requestScope.pd.old_carpg_price}" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">汽车贷款费用（元）</span>
							<input id="old_cardk_price" name="old_cardk_price" class="form-control"  value="${requestScope.pd.old_cardk_price}" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">GPS费用（元）</span>
							<input id="old_gps_price" name="old_gps_price" class="form-control"  value="${requestScope.pd.old_gps_price}" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">其他费用（元）</span>
							<input id="old_qt_price" name="old_qt_price" class="form-control"  value="${requestScope.pd.old_qt_price}" type="text">
						</div>
					</div>
				</div>
				</div>
			</div>
			<!-- 保证金及授信 -->
			<div class="form-group">
			<label for="inputHouse" class="col-sm-2 control-label">保证金及授信 </label>
				<div class="col-sm-10">
				<div id="bzj" class="row inline-from">
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon">授信额度（万元）</span>
							<input disabled="disabled" id="sx_price" name="sx_price" class="form-control"  value="${requestScope.pd.sx_price}" type="text">
						</div>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon">已用授信额度（万元）</span>
							<input disabled="disabled" id="sx_yyprice" name="sx_yyprice" class="form-control"  value="${requestScope.pd.sx_yyprice}" type="text">
						</div>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon">剩余授信额度（万元）</span>
							<input disabled="disabled" id="sx_syprice" name="sx_syprice" class="form-control"  value="${requestScope.pd.sx_syprice}" type="text">
						</div>
					</div>
					<div class="col-sm-3">
						<div class="input-group">
							<span class="input-group-addon">基础保证金杠杠比例</span>
							<input id="jc_bzjbl" name="jc_bzjbl" class="form-control"  value="${requestScope.pd.jc_bzjbl}" type="text">
						</div>
					</div>
				    <div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">基础保证金（万元）</span>
							<input id="jc_bzj1" name="jc_bzj[]" class="form-control"  value="" type="text">
						</div>
					</div>
				    <div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">基础保证金缴纳日期（年月日）</span>
							<input id="jc_bzjdate1" name="jc_bzjdate[]" class="form-control"  value="" type="date">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
						    <input id="bzj_num" name="bzj_num" value="1" type="hidden">
							<a id="" name="" onclick="addbzj()" class="btn btn-primary">新增</a>
							<a id="" name="" onclick="rebzj()" class="btn btn-primary">重置</a>
						</div>
					</div>
					<script type="text/javascript">
					$(document).ready(function(){
						document.getElementById("bzj_num").value=1;
						
						if('${requestScope.pd.jc_bzj}'!=null&&'${requestScope.pd.jc_bzj}'!=''){
						bzjlist('${requestScope.pd.jc_bzj}','${requestScope.pd.jc_bzjdate}');
						}
					});
					function delbzj(id) {
						$("#jc_bzj_"+id).remove();
						$("#jc_bzjdate_"+id).remove();
						$("#bzj_del_"+id).remove();
					}
					//重置
					function rebzj() {
						var num=$("#bzj_num").val();
						for(var i=2;i<=num;i++){
							$("#jc_bzj_"+i).remove();
							$("#jc_bzjdate_"+i).remove();
							$("#bzj_del_"+i).remove();
						}
						document.getElementById("bzj_num").value=1;
					}
					function bzjlist(obj1,obj2) {
						var jc_bzj = obj1.split('\u0005');
			        	var jc_bzjdate = obj2.split('\u0005');
			        	for ( var i = 0; i <jc_bzj.length; i++){
						num=Number(i)+1;
			            $("#bzj").append("<div id='jc_bzj_"+num+"' class='col-sm-4'>"+
						"<div class='input-group'>"+
						"<span class='input-group-addon'>基础保证金（万元）</span>"+
						"<input id='jc_bzj"+num+"' name='jc_bzj[]' value='"+jc_bzj[i]+"'  class='form-control' placeholder='' type='text'>"+
					    "</div>"+
				        "</div>");
			            $("#bzj").append("<div id='jc_bzjdate_"+num+"' class='col-sm-4'>"+
			        			"<div class='input-group'>"+
			        			"<span class='input-group-addon'>基础保证金缴纳日期（年月日）</span>"+
			        			"<input id='jc_bzjdate"+num+"' name='jc_bzjdate[]' value='"+jc_bzjdate[i]+"'  class='form-control' placeholder='' type='date'>"+
			        		    "</div>"+
			        	        "</div>");
			            $("#bzj").append("<div id='bzj_del_"+num+"'  class='col-sm-4'>"+
			        			"<div class='input-group'>"+
			        			"<a id='' name='' onclick='delbzj("+num+")' oncli class='btn btn-primary'>删除</a>"+
			        		    "</div>"+
			        	        "</div>");
			            $("#bzj_num").val(Number(num));
			        	}
					}
					function addbzj() {
						var num=$("#bzj_num").val();
						num=Number(num)+1;
			            $("#bzj").append("<div id='jc_bzj_"+num+"' class='col-sm-4'>"+
						"<div class='input-group'>"+
						"<span class='input-group-addon'>基础保证金（万元）</span>"+
						"<input id='jc_bzj"+num+"' name='jc_bzj[]' value=''  class='form-control' placeholder='' type='text'>"+
					    "</div>"+
				        "</div>");
			            $("#bzj").append("<div id='jc_bzjdate_"+num+"' class='col-sm-4'>"+
			        			"<div class='input-group'>"+
			        			"<span class='input-group-addon'>基础保证金缴纳日期（年月日）</span>"+
			        			"<input id='jc_bzjdate"+num+"' name='jc_bzjdate[]' value=''  class='form-control' placeholder='' type='date'>"+
			        		    "</div>"+
			        	        "</div>");
			            $("#bzj").append("<div id='bzj_del_"+num+"'  class='col-sm-4'>"+
			        			"<div class='input-group'>"+
			        			"<a id='' name='' onclick='delbzj("+num+")' oncli class='btn btn-primary'>删除</a>"+
			        		    "</div>"+
			        	        "</div>");
			            $("#bzj_num").val(Number(num));
					}
					
					</script>

				</div>
				</div>
			</div>
			<!--结算配置  -->
			<div class="form-group">
			<label for="inputHouse" class="col-sm-2 control-label">结算配置</label>
				<div class="col-sm-10">
				<div class="row inline-from">
				    <div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">基础结算费率（%）</span>
							<input id="jc_jsfl" name="jc_jsfl" class="form-control"  value="${requestScope.pd.jc_jsfl}" type="text">
						</div>
					</div>
				    <div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">业务保证金费率（%）</span>
							<input id="yw_nzjfl" name="yw_nzjfl" class="form-control"  value="${requestScope.pd.yw_nzjfl}" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">最高市场推广价</span>
							<input id="sc_maxprice" name="sc_maxprice" class="form-control"  value="${requestScope.pd.sc_maxprice}" type="text">
						</div>
					</div>
				</div>
				</div>
			</div>
			<!--  -->
			</div>
			</div>
		</div>
	</div>
<div class="panel panel-default">
<div class="panel-heading">
			<h4 class="box-title">
            <a data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" class="collapsed">业务合作模式（下线）</a>
		    <a class=" btn btn-info search-btn pull-right">导出</a>
			</h4>
</div>
<div id="collapseThree" class="panel-collapse collapse" aria-expanded="false" style="height: 0px;">
			<div class="panel-body">
			<div class="box-body">
			<div class="form-group">
			<label for="inputHouse" class="col-sm-2 control-label">合作方式 </label>
			<div class="col-sm-10">
				<div class="row inline-from">
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">终止协议编号</span>
							<input id="zzxx_code" name="zzxx_code" class="form-control" value="${requestScope.pd.zzxx_code}" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">基础保证金退还</span>
							<select id="jcbzxth" name="jcbzxth" class="form-control">
							<option value="0">请选择</option>
							<option value="1" ${requestScope.pd.jcbzxth eq '1'?"selected='selected'":''}>是</option>
							<option value="2" ${requestScope.pd.jcbzxth eq '2'?"selected='selected'":''}>否</option>
							</select>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">基础保证金退还金额（万元）</span>
							<input id="jcbzjth_price" name="jcbzjth_price" class="form-control" value="${requestScope.pd.jcbzjth_price}" type="text">
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">基础保证退还时间（年月日）</span>
							<input id="jcbzjth_date" name="jcbzjth_date" class="form-control" value="${requestScope.pd.jcbzjth_date}" type="text">
						</div>
					</div>
				</div>
			</div>
			</div>
			</div>
</div>

</div>

	

</div>

</div>
		<div style="margin-left: -25px;" class="footer-wrap">
			<div class="box-footer">
				<button  type="button"  class="btn btn-default" onclick="location.href='${pageContext.request.contextPath }/erp/user_list.do?type=icbc&dn=assess_fs&qn=list&mid_add=${sessionScope.pd.id }'">取消返回</button>
				<c:if  test="${fn:contains(sessionScope.pd.purview_map,'gsglupdate')==true or fn:contains(sessionScope.pd.purview_map,'gsgladd')==true}">
				<c:if test="${requestScope.cn!='4'}">
				<button id="submit_button" type="submit"  class="btn btn-primary pull-right">保存提交</button> 
				</c:if>
				</c:if>
			</div>
		</div>
</form>
</div>
<div id="yxcl" class="tab-pane fade">
	<div class="box-header with-border">
				<h3 class="box-title">影像材料</h3>
		<a class="btn btn-info search-btn">导出</a>
	</div>
</div>
</div>
</div>
<script>
lay('#version').html('-v'+ laydate.v);
//执行一个laydate实例
laydate.render({
  elem: '#hz_date1' //指定元素
});
laydate.render({
  elem: '#hz_date2' //指定元素
});
laydate.render({
	  elem: '#company_date' //指定元素
	});
laydate.render({
	  elem: '#jc_bzjdate' //指定元素
	});
laydate.render({
	  elem: '#jcbzjth_date' //指定元素
	});
</script>
<script>

var strChineseFirstPY = "YDYQSXMWZSSXJBYMGCCZQPSSQBYCDSCDQLDYLYBSSJGYZZJJFKCCLZDHWDWZJLJPFYYNWJJTMYHZWZHFLZPPQHGSCYYYNJQYXXGJHHSDSJNKKTMOMLCRXYPSNQSECCQZGGLLYJLMYZZSECYKYYHQWJSSGGYXYZYJWWKDJHYCHMYXJTLXJYQBYXZLDWRDJRWYSRLDZJPCBZJJBRCFTLECZSTZFXXZHTRQHYBDLYCZSSYMMRFMYQZPWWJJYFCRWFDFZQPYDDWYXKYJAWJFFXYPSFTZYHHYZYSWCJYXSCLCXXWZZXNBGNNXBXLZSZSBSGPYSYZDHMDZBQBZCWDZZYYTZHBTSYYBZGNTNXQYWQSKBPHHLXGYBFMJEBJHHGQTJCYSXSTKZHLYCKGLYSMZXYALMELDCCXGZYRJXSDLTYZCQKCNNJWHJTZZCQLJSTSTBNXBTYXCEQXGKWJYFLZQLYHYXSPSFXLMPBYSXXXYDJCZYLLLSJXFHJXPJBTFFYABYXBHZZBJYZLWLCZGGBTSSMDTJZXPTHYQTGLJSCQFZKJZJQNLZWLSLHDZBWJNCJZYZSQQYCQYRZCJJWYBRTWPYFTWEXCSKDZCTBZHYZZYYJXZCFFZZMJYXXSDZZOTTBZLQWFCKSZSXFYRLNYJMBDTHJXSQQCCSBXYYTSYFBXDZTGBCNSLCYZZPSAZYZZSCJCSHZQYDXLBPJLLMQXTYDZXSQJTZPXLCGLQTZWJBHCTSYJSFXYEJJTLBGXSXJMYJQQPFZASYJNTYDJXKJCDJSZCBARTDCLYJQMWNQNCLLLKBYBZZSYHQQLTWLCCXTXLLZNTYLNEWYZYXCZXXGRKRMTCNDNJTSYYSSDQDGHSDBJGHRWRQLYBGLXHLGTGXBQJDZPYJSJYJCTMRNYMGRZJCZGJMZMGXMPRYXKJNYMSGMZJYMKMFXMLDTGFBHCJHKYLPFMDXLQJJSMTQGZSJLQDLDGJYCALCMZCSDJLLNXDJFFFFJCZFMZFFPFKHKGDPSXKTACJDHHZDDCRRCFQYJKQCCWJDXHWJLYLLZGCFCQDSMLZPBJJPLSBCJGGDCKKDEZSQCCKJGCGKDJTJDLZYCXKLQSCGJCLTFPCQCZGWPJDQYZJJBYJHSJDZWGFSJGZKQCCZLLPSPKJGQJHZZLJPLGJGJJTHJJYJZCZMLZLYQBGJWMLJKXZDZNJQSYZMLJLLJKYWXMKJLHSKJGBMCLYYMKXJQLBMLLKMDXXKWYXYSLMLPSJQQJQXYXFJTJDXMXXLLCXQBSYJBGWYMBGGBCYXPJYGPEPFGDJGBHBNSQJYZJKJKHXQFGQZKFHYGKHDKLLSDJQXPQYKYBNQSXQNSZSWHBSXWHXWBZZXDMNSJBSBKBBZKLYLXGWXDRWYQZMYWSJQLCJXXJXKJEQXSCYETLZHLYYYSDZPAQYZCMTLSHTZCFYZYXYLJSDCJQAGYSLCQLYYYSHMRQQKLDXZSCSSSYDYCJYSFSJBFRSSZQSBXXPXJYSDRCKGJLGDKZJZBDKTCSYQPYHSTCLDJDHMXMCGXYZHJDDTMHLTXZXYLYMOHYJCLTYFBQQXPFBDFHHTKSQHZYYWCNXXCRWHOWGYJLEGWDQCWGFJYCSNTMYTOLBYGWQWESJPWNMLRYDZSZTXYQPZGCWXHNGPYXSHMYQJXZTDPPBFYHZHTJYFDZWKGKZBLDNTSXHQEEGZZYLZMMZYJZGXZXKHKSTXNXXWYLYAPSTHXDWHZYMPXAGKYDXBHNHXKDPJNMYHYLPMGOCSLNZHKXXLPZZLBMLSFBHHGYGYYGGBHSCYAQTYWLXTZQCEZYDQDQMMHTKLLSZHLSJZWFYHQSWSCWLQAZYNYTLSXTHAZNKZZSZZLAXXZWWCTGQQTDDYZTCCHYQZFLXPSLZYGPZSZNGLNDQTBDLXGTCTAJDKYWNSYZLJHHZZCWNYYZYWMHYCHHYXHJKZWSXHZYXLYSKQYSPSLYZWMYPPKBYGLKZHTYXAXQSYSHXASMCHKDSCRSWJPWXSGZJLWWSCHSJHSQNHCSEGNDAQTBAALZZMSSTDQJCJKTSCJAXPLGGXHHGXXZCXPDMMHLDGTYBYSJMXHMRCPXXJZCKZXSHMLQXXTTHXWZFKHCCZDYTCJYXQHLXDHYPJQXYLSYYDZOZJNYXQEZYSQYAYXWYPDGXDDXSPPYZNDLTWRHXYDXZZJHTCXMCZLHPYYYYMHZLLHNXMYLLLMDCPPXHMXDKYCYRDLTXJCHHZZXZLCCLYLNZSHZJZZLNNRLWHYQSNJHXYNTTTKYJPYCHHYEGKCTTWLGQRLGGTGTYGYHPYHYLQYQGCWYQKPYYYTTTTLHYHLLTYTTSPLKYZXGZWGPYDSSZZDQXSKCQNMJJZZBXYQMJRTFFBTKHZKBXLJJKDXJTLBWFZPPTKQTZTGPDGNTPJYFALQMKGXBDCLZFHZCLLLLADPMXDJHLCCLGYHDZFGYDDGCYYFGYDXKSSEBDHYKDKDKHNAXXYBPBYYHXZQGAFFQYJXDMLJCSQZLLPCHBSXGJYNDYBYQSPZWJLZKSDDTACTBXZDYZYPJZQSJNKKTKNJDJGYYPGTLFYQKASDNTCYHBLWDZHBBYDWJRYGKZYHEYYFJMSDTYFZJJHGCXPLXHLDWXXJKYTCYKSSSMTWCTTQZLPBSZDZWZXGZAGYKTYWXLHLSPBCLLOQMMZSSLCMBJCSZZKYDCZJGQQDSMCYTZQQLWZQZXSSFPTTFQMDDZDSHDTDWFHTDYZJYQJQKYPBDJYYXTLJHDRQXXXHAYDHRJLKLYTWHLLRLLRCXYLBWSRSZZSYMKZZHHKYHXKSMDSYDYCJPBZBSQLFCXXXNXKXWYWSDZYQOGGQMMYHCDZTTFJYYBGSTTTYBYKJDHKYXBELHTYPJQNFXFDYKZHQKZBYJTZBXHFDXKDASWTAWAJLDYJSFHBLDNNTNQJTJNCHXFJSRFWHZFMDRYJYJWZPDJKZYJYMPCYZNYNXFBYTFYFWYGDBNZZZDNYTXZEMMQBSQEHXFZMBMFLZZSRXYMJGSXWZJSPRYDJSJGXHJJGLJJYNZZJXHGXKYMLPYYYCXYTWQZSWHWLYRJLPXSLSXMFSWWKLCTNXNYNPSJSZHDZEPTXMYYWXYYSYWLXJQZQXZDCLEEELMCPJPCLWBXSQHFWWTFFJTNQJHJQDXHWLBYZNFJLALKYYJLDXHHYCSTYYWNRJYXYWTRMDRQHWQCMFJDYZMHMYYXJWMYZQZXTLMRSPWWCHAQBXYGZYPXYYRRCLMPYMGKSJSZYSRMYJSNXTPLNBAPPYPYLXYYZKYNLDZYJZCZNNLMZHHARQMPGWQTZMXXMLLHGDZXYHXKYXYCJMFFYYHJFSBSSQLXXNDYCANNMTCJCYPRRNYTYQNYYMBMSXNDLYLYSLJRLXYSXQMLLYZLZJJJKYZZCSFBZXXMSTBJGNXYZHLXNMCWSCYZYFZLXBRNNNYLBNRTGZQYSATSWRYHYJZMZDHZGZDWYBSSCSKXSYHYTXXGCQGXZZSHYXJSCRHMKKBXCZJYJYMKQHZJFNBHMQHYSNJNZYBKNQMCLGQHWLZNZSWXKHLJHYYBQLBFCDSXDLDSPFZPSKJYZWZXZDDXJSMMEGJSCSSMGCLXXKYYYLNYPWWWGYDKZJGGGZGGSYCKNJWNJPCXBJJTQTJWDSSPJXZXNZXUMELPXFSXTLLXCLJXJJLJZXCTPSWXLYDHLYQRWHSYCSQYYBYAYWJJJQFWQCQQCJQGXALDBZZYJGKGXPLTZYFXJLTPADKYQHPMATLCPDCKBMTXYBHKLENXDLEEGQDYMSAWHZMLJTWYGXLYQZLJEEYYBQQFFNLYXRDSCTGJGXYYNKLLYQKCCTLHJLQMKKZGCYYGLLLJDZGYDHZWXPYSJBZKDZGYZZHYWYFQYTYZSZYEZZLYMHJJHTSMQWYZLKYYWZCSRKQYTLTDXWCTYJKLWSQZWBDCQYNCJSRSZJLKCDCDTLZZZACQQZZDDXYPLXZBQJYLZLLLQDDZQJYJYJZYXNYYYNYJXKXDAZWYRDLJYYYRJLXLLDYXJCYWYWNQCCLDDNYYYNYCKCZHXXCCLGZQJGKWPPCQQJYSBZZXYJSQPXJPZBSBDSFNSFPZXHDWZTDWPPTFLZZBZDMYYPQJRSDZSQZSQXBDGCPZSWDWCSQZGMDHZXMWWFYBPDGPHTMJTHZSMMBGZMBZJCFZWFZBBZMQCFMBDMCJXLGPNJBBXGYHYYJGPTZGZMQBQTCGYXJXLWZKYDPDYMGCFTPFXYZTZXDZXTGKMTYBBCLBJASKYTSSQYYMSZXFJEWLXLLSZBQJJJAKLYLXLYCCTSXMCWFKKKBSXLLLLJYXTYLTJYYTDPJHNHNNKBYQNFQYYZBYYESSESSGDYHFHWTCJBSDZZTFDMXHCNJZYMQWSRYJDZJQPDQBBSTJGGFBKJBXTGQHNGWJXJGDLLTHZHHYYYYYYSXWTYYYCCBDBPYPZYCCZYJPZYWCBDLFWZCWJDXXHYHLHWZZXJTCZLCDPXUJCZZZLYXJJTXPHFXWPYWXZPTDZZBDZCYHJHMLXBQXSBYLRDTGJRRCTTTHYTCZWMXFYTWWZCWJWXJYWCSKYBZSCCTZQNHXNWXXKHKFHTSWOCCJYBCMPZZYKBNNZPBZHHZDLSYDDYTYFJPXYNGFXBYQXCBHXCPSXTYZDMKYSNXSXLHKMZXLYHDHKWHXXSSKQYHHCJYXGLHZXCSNHEKDTGZXQYPKDHEXTYKCNYMYYYPKQYYYKXZLTHJQTBYQHXBMYHSQCKWWYLLHCYYLNNEQXQWMCFBDCCMLJGGXDQKTLXKGNQCDGZJWYJJLYHHQTTTNWCHMXCXWHWSZJYDJCCDBQCDGDNYXZTHCQRXCBHZTQCBXWGQWYYBXHMBYMYQTYEXMQKYAQYRGYZSLFYKKQHYSSQYSHJGJCNXKZYCXSBXYXHYYLSTYCXQTHYSMGSCPMMGCCCCCMTZTASMGQZJHKLOSQYLSWTMXSYQKDZLJQQYPLSYCZTCQQPBBQJZCLPKHQZYYXXDTDDTSJCXFFLLCHQXMJLWCJCXTSPYCXNDTJSHJWXDQQJSKXYAMYLSJHMLALYKXCYYDMNMDQMXMCZNNCYBZKKYFLMCHCMLHXRCJJHSYLNMTJZGZGYWJXSRXCWJGJQHQZDQJDCJJZKJKGDZQGJJYJYLXZXXCDQHHHEYTMHLFSBDJSYYSHFYSTCZQLPBDRFRZTZYKYWHSZYQKWDQZRKMSYNBCRXQBJYFAZPZZEDZCJYWBCJWHYJBQSZYWRYSZPTDKZPFPBNZTKLQYHBBZPNPPTYZZYBQNYDCPJMMCYCQMCYFZZDCMNLFPBPLNGQJTBTTNJZPZBBZNJKLJQYLNBZQHKSJZNGGQSZZKYXSHPZSNBCGZKDDZQANZHJKDRTLZLSWJLJZLYWTJNDJZJHXYAYNCBGTZCSSQMNJPJYTYSWXZFKWJQTKHTZPLBHSNJZSYZBWZZZZLSYLSBJHDWWQPSLMMFBJDWAQYZTCJTBNNWZXQXCDSLQGDSDPDZHJTQQPSWLYYJZLGYXYZLCTCBJTKTYCZJTQKBSJLGMGZDMCSGPYNJZYQYYKNXRPWSZXMTNCSZZYXYBYHYZAXYWQCJTLLCKJJTJHGDXDXYQYZZBYWDLWQCGLZGJGQRQZCZSSBCRPCSKYDZNXJSQGXSSJMYDNSTZTPBDLTKZWXQWQTZEXNQCZGWEZKSSBYBRTSSSLCCGBPSZQSZLCCGLLLZXHZQTHCZMQGYZQZNMCOCSZJMMZSQPJYGQLJYJPPLDXRGZYXCCSXHSHGTZNLZWZKJCXTCFCJXLBMQBCZZWPQDNHXLJCTHYZLGYLNLSZZPCXDSCQQHJQKSXZPBAJYEMSMJTZDXLCJYRYYNWJBNGZZTMJXLTBSLYRZPYLSSCNXPHLLHYLLQQZQLXYMRSYCXZLMMCZLTZSDWTJJLLNZGGQXPFSKYGYGHBFZPDKMWGHCXMSGDXJMCJZDYCABXJDLNBCDQYGSKYDQTXDJJYXMSZQAZDZFSLQXYJSJZYLBTXXWXQQZBJZUFBBLYLWDSLJHXJYZJWTDJCZFQZQZZDZSXZZQLZCDZFJHYSPYMPQZMLPPLFFXJJNZZYLSJEYQZFPFZKSYWJJJHRDJZZXTXXGLGHYDXCSKYSWMMZCWYBAZBJKSHFHJCXMHFQHYXXYZFTSJYZFXYXPZLCHMZMBXHZZSXYFYMNCWDABAZLXKTCSHHXKXJJZJSTHYGXSXYYHHHJWXKZXSSBZZWHHHCWTZZZPJXSNXQQJGZYZYWLLCWXZFXXYXYHXMKYYSWSQMNLNAYCYSPMJKHWCQHYLAJJMZXHMMCNZHBHXCLXTJPLTXYJHDYYLTTXFSZHYXXSJBJYAYRSMXYPLCKDUYHLXRLNLLSTYZYYQYGYHHSCCSMZCTZQXKYQFPYYRPFFLKQUNTSZLLZMWWTCQQYZWTLLMLMPWMBZSSTZRBPDDTLQJJBXZCSRZQQYGWCSXFWZLXCCRSZDZMCYGGDZQSGTJSWLJMYMMZYHFBJDGYXCCPSHXNZCSBSJYJGJMPPWAFFYFNXHYZXZYLREMZGZCYZSSZDLLJCSQFNXZKPTXZGXJJGFMYYYSNBTYLBNLHPFZDCYFBMGQRRSSSZXYSGTZRNYDZZCDGPJAFJFZKNZBLCZSZPSGCYCJSZLMLRSZBZZLDLSLLYSXSQZQLYXZLSKKBRXBRBZCYCXZZZEEYFGKLZLYYHGZSGZLFJHGTGWKRAAJYZKZQTSSHJJXDCYZUYJLZYRZDQQHGJZXSSZBYKJPBFRTJXLLFQWJHYLQTYMBLPZDXTZYGBDHZZRBGXHWNJTJXLKSCFSMWLSDQYSJTXKZSCFWJLBXFTZLLJZLLQBLSQMQQCGCZFPBPHZCZJLPYYGGDTGWDCFCZQYYYQYSSCLXZSKLZZZGFFCQNWGLHQYZJJCZLQZZYJPJZZBPDCCMHJGXDQDGDLZQMFGPSYTSDYFWWDJZJYSXYYCZCYHZWPBYKXRYLYBHKJKSFXTZJMMCKHLLTNYYMSYXYZPYJQYCSYCWMTJJKQYRHLLQXPSGTLYYCLJSCPXJYZFNMLRGJJTYZBXYZMSJYJHHFZQMSYXRSZCWTLRTQZSSTKXGQKGSPTGCZNJSJCQCXHMXGGZTQYDJKZDLBZSXJLHYQGGGTHQSZPYHJHHGYYGKGGCWJZZYLCZLXQSFTGZSLLLMLJSKCTBLLZZSZMMNYTPZSXQHJCJYQXYZXZQZCPSHKZZYSXCDFGMWQRLLQXRFZTLYSTCTMJCXJJXHJNXTNRZTZFQYHQGLLGCXSZSJDJLJCYDSJTLNYXHSZXCGJZYQPYLFHDJSBPCCZHJJJQZJQDYBSSLLCMYTTMQTBHJQNNYGKYRQYQMZGCJKPDCGMYZHQLLSLLCLMHOLZGDYYFZSLJCQZLYLZQJESHNYLLJXGJXLYSYYYXNBZLJSSZCQQCJYLLZLTJYLLZLLBNYLGQCHXYYXOXCXQKYJXXXYKLXSXXYQXCYKQXQCSGYXXYQXYGYTQOHXHXPYXXXULCYEYCHZZCBWQBBWJQZSCSZSSLZYLKDESJZWMYMCYTSDSXXSCJPQQSQYLYYZYCMDJDZYWCBTJSYDJKCYDDJLBDJJSODZYSYXQQYXDHHGQQYQHDYXWGMMMAJDYBBBPPBCMUUPLJZSMTXERXJMHQNUTPJDCBSSMSSSTKJTSSMMTRCPLZSZMLQDSDMJMQPNQDXCFYNBFSDQXYXHYAYKQYDDLQYYYSSZBYDSLNTFQTZQPZMCHDHCZCWFDXTMYQSPHQYYXSRGJCWTJTZZQMGWJJTJHTQJBBHWZPXXHYQFXXQYWYYHYSCDYDHHQMNMTMWCPBSZPPZZGLMZFOLLCFWHMMSJZTTDHZZYFFYTZZGZYSKYJXQYJZQBHMBZZLYGHGFMSHPZFZSNCLPBQSNJXZSLXXFPMTYJYGBXLLDLXPZJYZJYHHZCYWHJYLSJEXFSZZYWXKZJLUYDTMLYMQJPWXYHXSKTQJEZRPXXZHHMHWQPWQLYJJQJJZSZCPHJLCHHNXJLQWZJHBMZYXBDHHYPZLHLHLGFWLCHYYTLHJXCJMSCPXSTKPNHQXSRTYXXTESYJCTLSSLSTDLLLWWYHDHRJZSFGXTSYCZYNYHTDHWJSLHTZDQDJZXXQHGYLTZPHCSQFCLNJTCLZPFSTPDYNYLGMJLLYCQHYSSHCHYLHQYQTMZYPBYWRFQYKQSYSLZDQJMPXYYSSRHZJNYWTQDFZBWWTWWRXCWHGYHXMKMYYYQMSMZHNGCEPMLQQMTCWCTMMPXJPJJHFXYYZSXZHTYBMSTSYJTTQQQYYLHYNPYQZLCYZHZWSMYLKFJXLWGXYPJYTYSYXYMZCKTTWLKSMZSYLMPWLZWXWQZSSAQSYXYRHSSNTSRAPXCPWCMGDXHXZDZYFJHGZTTSBJHGYZSZYSMYCLLLXBTYXHBBZJKSSDMALXHYCFYGMQYPJYCQXJLLLJGSLZGQLYCJCCZOTYXMTMTTLLWTGPXYMZMKLPSZZZXHKQYSXCTYJZYHXSHYXZKXLZWPSQPYHJWPJPWXQQYLXSDHMRSLZZYZWTTCYXYSZZSHBSCCSTPLWSSCJCHNLCGCHSSPHYLHFHHXJSXYLLNYLSZDHZXYLSXLWZYKCLDYAXZCMDDYSPJTQJZLNWQPSSSWCTSTSZLBLNXSMNYYMJQBQHRZWTYYDCHQLXKPZWBGQYBKFCMZWPZLLYYLSZYDWHXPSBCMLJBSCGBHXLQHYRLJXYSWXWXZSLDFHLSLYNJLZYFLYJYCDRJLFSYZFSLLCQYQFGJYHYXZLYLMSTDJCYHBZLLNWLXXYGYYHSMGDHXXHHLZZJZXCZZZCYQZFNGWPYLCPKPYYPMCLQKDGXZGGWQBDXZZKZFBXXLZXJTPJPTTBYTSZZDWSLCHZHSLTYXHQLHYXXXYYZYSWTXZKHLXZXZPYHGCHKCFSYHUTJRLXFJXPTZTWHPLYXFCRHXSHXKYXXYHZQDXQWULHYHMJTBFLKHTXCWHJFWJCFPQRYQXCYYYQYGRPYWSGSUNGWCHKZDXYFLXXHJJBYZWTSXXNCYJJYMSWZJQRMHXZWFQSYLZJZGBHYNSLBGTTCSYBYXXWXYHXYYXNSQYXMQYWRGYQLXBBZLJSYLPSYTJZYHYZAWLRORJMKSCZJXXXYXCHDYXRYXXJDTSQFXLYLTSFFYXLMTYJMJUYYYXLTZCSXQZQHZXLYYXZHDNBRXXXJCTYHLBRLMBRLLAXKYLLLJLYXXLYCRYLCJTGJCMTLZLLCYZZPZPCYAWHJJFYBDYYZSMPCKZDQYQPBPCJPDCYZMDPBCYYDYCNNPLMTMLRMFMMGWYZBSJGYGSMZQQQZTXMKQWGXLLPJGZBQCDJJJFPKJKCXBLJMSWMDTQJXLDLPPBXCWRCQFBFQJCZAHZGMYKPHYYHZYKNDKZMBPJYXPXYHLFPNYYGXJDBKXNXHJMZJXSTRSTLDXSKZYSYBZXJLXYSLBZYSLHXJPFXPQNBYLLJQKYGZMCYZZYMCCSLCLHZFWFWYXZMWSXTYNXJHPYYMCYSPMHYSMYDYSHQYZCHMJJMZCAAGCFJBBHPLYZYLXXSDJGXDHKXXTXXNBHRMLYJSLTXMRHNLXQJXYZLLYSWQGDLBJHDCGJYQYCMHWFMJYBMBYJYJWYMDPWHXQLDYGPDFXXBCGJSPCKRSSYZJMSLBZZJFLJJJLGXZGYXYXLSZQYXBEXYXHGCXBPLDYHWETTWWCJMBTXCHXYQXLLXFLYXLLJLSSFWDPZSMYJCLMWYTCZPCHQEKCQBWLCQYDPLQPPQZQFJQDJHYMMCXTXDRMJWRHXCJZYLQXDYYNHYYHRSLSRSYWWZJYMTLTLLGTQCJZYABTCKZCJYCCQLJZQXALMZYHYWLWDXZXQDLLQSHGPJFJLJHJABCQZDJGTKHSSTCYJLPSWZLXZXRWGLDLZRLZXTGSLLLLZLYXXWGDZYGBDPHZPBRLWSXQBPFDWOFMWHLYPCBJCCLDMBZPBZZLCYQXLDOMZBLZWPDWYYGDSTTHCSQSCCRSSSYSLFYBFNTYJSZDFNDPDHDZZMBBLSLCMYFFGTJJQWFTMTPJWFNLBZCMMJTGBDZLQLPYFHYYMJYLSDCHDZJWJCCTLJCLDTLJJCPDDSQDSSZYBNDBJLGGJZXSXNLYCYBJXQYCBYLZCFZPPGKCXZDZFZTJJFJSJXZBNZYJQTTYJYHTYCZHYMDJXTTMPXSPLZCDWSLSHXYPZGTFMLCJTYCBPMGDKWYCYZCDSZZYHFLYCTYGWHKJYYLSJCXGYWJCBLLCSNDDBTZBSCLYZCZZSSQDLLMQYYHFSLQLLXFTYHABXGWNYWYYPLLSDLDLLBJCYXJZMLHLJDXYYQYTDLLLBUGBFDFBBQJZZMDPJHGCLGMJJPGAEHHBWCQXAXHHHZCHXYPHJAXHLPHJPGPZJQCQZGJJZZUZDMQYYBZZPHYHYBWHAZYJHYKFGDPFQSDLZMLJXKXGALXZDAGLMDGXMWZQYXXDXXPFDMMSSYMPFMDMMKXKSYZYSHDZKXSYSMMZZZMSYDNZZCZXFPLSTMZDNMXCKJMZTYYMZMZZMSXHHDCZJEMXXKLJSTLWLSQLYJZLLZJSSDPPMHNLZJCZYHMXXHGZCJMDHXTKGRMXFWMCGMWKDTKSXQMMMFZZYDKMSCLCMPCGMHSPXQPZDSSLCXKYXTWLWJYAHZJGZQMCSNXYYMMPMLKJXMHLMLQMXCTKZMJQYSZJSYSZHSYJZJCDAJZYBSDQJZGWZQQXFKDMSDJLFWEHKZQKJPEYPZYSZCDWYJFFMZZYLTTDZZEFMZLBNPPLPLPEPSZALLTYLKCKQZKGENQLWAGYXYDPXLHSXQQWQCQXQCLHYXXMLYCCWLYMQYSKGCHLCJNSZKPYZKCQZQLJPDMDZHLASXLBYDWQLWDNBQCRYDDZTJYBKBWSZDXDTNPJDTCTQDFXQQMGNXECLTTBKPWSLCTYQLPWYZZKLPYGZCQQPLLKCCYLPQMZCZQCLJSLQZDJXLDDHPZQDLJJXZQDXYZQKZLJCYQDYJPPYPQYKJYRMPCBYMCXKLLZLLFQPYLLLMBSGLCYSSLRSYSQTMXYXZQZFDZUYSYZTFFMZZSMZQHZSSCCMLYXWTPZGXZJGZGSJSGKDDHTQGGZLLBJDZLCBCHYXYZHZFYWXYZYMSDBZZYJGTSMTFXQYXQSTDGSLNXDLRYZZLRYYLXQHTXSRTZNGZXBNQQZFMYKMZJBZYMKBPNLYZPBLMCNQYZZZSJZHJCTZKHYZZJRDYZHNPXGLFZTLKGJTCTSSYLLGZRZBBQZZKLPKLCZYSSUYXBJFPNJZZXCDWXZYJXZZDJJKGGRSRJKMSMZJLSJYWQSKYHQJSXPJZZZLSNSHRNYPZTWCHKLPSRZLZXYJQXQKYSJYCZTLQZYBBYBWZPQDWWYZCYTJCJXCKCWDKKZXSGKDZXWWYYJQYYTCYTDLLXWKCZKKLCCLZCQQDZLQLCSFQCHQHSFSMQZZLNBJJZBSJHTSZDYSJQJPDLZCDCWJKJZZLPYCGMZWDJJBSJQZSYZYHHXJPBJYDSSXDZNCGLQMBTSFSBPDZDLZNFGFJGFSMPXJQLMBLGQCYYXBQKDJJQYRFKZTJDHCZKLBSDZCFJTPLLJGXHYXZCSSZZXSTJYGKGCKGYOQXJPLZPBPGTGYJZGHZQZZLBJLSQFZGKQQJZGYCZBZQTLDXRJXBSXXPZXHYZYCLWDXJJHXMFDZPFZHQHQMQGKSLYHTYCGFRZGNQXCLPDLBZCSCZQLLJBLHBZCYPZZPPDYMZZSGYHCKCPZJGSLJLNSCDSLDLXBMSTLDDFJMKDJDHZLZXLSZQPQPGJLLYBDSZGQLBZLSLKYYHZTTNTJYQTZZPSZQZTLLJTYYLLQLLQYZQLBDZLSLYYZYMDFSZSNHLXZNCZQZPBWSKRFBSYZMTHBLGJPMCZZLSTLXSHTCSYZLZBLFEQHLXFLCJLYLJQCBZLZJHHSSTBRMHXZHJZCLXFNBGXGTQJCZTMSFZKJMSSNXLJKBHSJXNTNLZDNTLMSJXGZJYJCZXYJYJWRWWQNZTNFJSZPZSHZJFYRDJSFSZJZBJFZQZZHZLXFYSBZQLZSGYFTZDCSZXZJBQMSZKJRHYJZCKMJKHCHGTXKXQGLXPXFXTRTYLXJXHDTSJXHJZJXZWZLCQSBTXWXGXTXXHXFTSDKFJHZYJFJXRZSDLLLTQSQQZQWZXSYQTWGWBZCGZLLYZBCLMQQTZHZXZXLJFRMYZFLXYSQXXJKXRMQDZDMMYYBSQBHGZMWFWXGMXLZPYYTGZYCCDXYZXYWGSYJYZNBHPZJSQSYXSXRTFYZGRHZTXSZZTHCBFCLSYXZLZQMZLMPLMXZJXSFLBYZMYQHXJSXRXSQZZZSSLYFRCZJRCRXHHZXQYDYHXSJJHZCXZBTYNSYSXJBQLPXZQPYMLXZKYXLXCJLCYSXXZZLXDLLLJJYHZXGYJWKJRWYHCPSGNRZLFZWFZZNSXGXFLZSXZZZBFCSYJDBRJKRDHHGXJLJJTGXJXXSTJTJXLYXQFCSGSWMSBCTLQZZWLZZKXJMLTMJYHSDDBXGZHDLBMYJFRZFSGCLYJBPMLYSMSXLSZJQQHJZFXGFQFQBPXZGYYQXGZTCQWYLTLGWSGWHRLFSFGZJMGMGBGTJFSYZZGZYZAFLSSPMLPFLCWBJZCLJJMZLPJJLYMQDMYYYFBGYGYZMLYZDXQYXRQQQHSYYYQXYLJTYXFSFSLLGNQCYHYCWFHCCCFXPYLYPLLZYXXXXXKQHHXSHJZCFZSCZJXCPZWHHHHHAPYLQALPQAFYHXDYLUKMZQGGGDDESRNNZLTZGCHYPPYSQJJHCLLJTOLNJPZLJLHYMHEYDYDSQYCDDHGZUNDZCLZYZLLZNTNYZGSLHSLPJJBDGWXPCDUTJCKLKCLWKLLCASSTKZZDNQNTTLYYZSSYSSZZRYLJQKCQDHHCRXRZYDGRGCWCGZQFFFPPJFZYNAKRGYWYQPQXXFKJTSZZXSWZDDFBBXTBGTZKZNPZZPZXZPJSZBMQHKCYXYLDKLJNYPKYGHGDZJXXEAHPNZKZTZCMXCXMMJXNKSZQNMNLWBWWXJKYHCPSTMCSQTZJYXTPCTPDTNNPGLLLZSJLSPBLPLQHDTNJNLYYRSZFFJFQWDPHZDWMRZCCLODAXNSSNYZRESTYJWJYJDBCFXNMWTTBYLWSTSZGYBLJPXGLBOCLHPCBJLTMXZLJYLZXCLTPNCLCKXTPZJSWCYXSFYSZDKNTLBYJCYJLLSTGQCBXRYZXBXKLYLHZLQZLNZCXWJZLJZJNCJHXMNZZGJZZXTZJXYCYYCXXJYYXJJXSSSJSTSSTTPPGQTCSXWZDCSYFPTFBFHFBBLZJCLZZDBXGCXLQPXKFZFLSYLTUWBMQJHSZBMDDBCYSCCLDXYCDDQLYJJWMQLLCSGLJJSYFPYYCCYLTJANTJJPWYCMMGQYYSXDXQMZHSZXPFTWWZQSWQRFKJLZJQQYFBRXJHHFWJJZYQAZMYFRHCYYBYQWLPEXCCZSTYRLTTDMQLYKMBBGMYYJPRKZNPBSXYXBHYZDJDNGHPMFSGMWFZMFQMMBCMZZCJJLCNUXYQLMLRYGQZCYXZLWJGCJCGGMCJNFYZZJHYCPRRCMTZQZXHFQGTJXCCJEAQCRJYHPLQLSZDJRBCQHQDYRHYLYXJSYMHZYDWLDFRYHBPYDTSSCNWBXGLPZMLZZTQSSCPJMXXYCSJYTYCGHYCJWYRXXLFEMWJNMKLLSWTXHYYYNCMMCWJDQDJZGLLJWJRKHPZGGFLCCSCZMCBLTBHBQJXQDSPDJZZGKGLFQYWBZYZJLTSTDHQHCTCBCHFLQMPWDSHYYTQWCNZZJTLBYMBPDYYYXSQKXWYYFLXXNCWCXYPMAELYKKJMZZZBRXYYQJFLJPFHHHYTZZXSGQQMHSPGDZQWBWPJHZJDYSCQWZKTXXSQLZYYMYSDZGRXCKKUJLWPYSYSCSYZLRMLQSYLJXBCXTLWDQZPCYCYKPPPNSXFYZJJRCEMHSZMSXLXGLRWGCSTLRSXBZGBZGZTCPLUJLSLYLYMTXMTZPALZXPXJTJWTCYYZLBLXBZLQMYLXPGHDSLSSDMXMBDZZSXWHAMLCZCPJMCNHJYSNSYGCHSKQMZZQDLLKABLWJXSFMOCDXJRRLYQZKJMYBYQLYHETFJZFRFKSRYXFJTWDSXXSYSQJYSLYXWJHSNLXYYXHBHAWHHJZXWMYLJCSSLKYDZTXBZSYFDXGXZJKHSXXYBSSXDPYNZWRPTQZCZENYGCXQFJYKJBZMLJCMQQXUOXSLYXXLYLLJDZBTYMHPFSTTQQWLHOKYBLZZALZXQLHZWRRQHLSTMYPYXJJXMQSJFNBXYXYJXXYQYLTHYLQYFMLKLJTMLLHSZWKZHLJMLHLJKLJSTLQXYLMBHHLNLZXQJHXCFXXLHYHJJGBYZZKBXSCQDJQDSUJZYYHZHHMGSXCSYMXFEBCQWWRBPYYJQTYZCYQYQQZYHMWFFHGZFRJFCDPXNTQYZPDYKHJLFRZXPPXZDBBGZQSTLGDGYLCQMLCHHMFYWLZYXKJLYPQHSYWMQQGQZMLZJNSQXJQSYJYCBEHSXFSZPXZWFLLBCYYJDYTDTHWZSFJMQQYJLMQXXLLDTTKHHYBFPWTYYSQQWNQWLGWDEBZWCMYGCULKJXTMXMYJSXHYBRWFYMWFRXYQMXYSZTZZTFYKMLDHQDXWYYNLCRYJBLPSXCXYWLSPRRJWXHQYPHTYDNXHHMMYWYTZCSQMTSSCCDALWZTCPQPYJLLQZYJSWXMZZMMYLMXCLMXCZMXMZSQTZPPQQBLPGXQZHFLJJHYTJSRXWZXSCCDLXTYJDCQJXSLQYCLZXLZZXMXQRJMHRHZJBHMFLJLMLCLQNLDXZLLLPYPSYJYSXCQQDCMQJZZXHNPNXZMEKMXHYKYQLXSXTXJYYHWDCWDZHQYYBGYBCYSCFGPSJNZDYZZJZXRZRQJJYMCANYRJTLDPPYZBSTJKXXZYPFDWFGZZRPYMTNGXZQBYXNBUFNQKRJQZMJEGRZGYCLKXZDSKKNSXKCLJSPJYYZLQQJYBZSSQLLLKJXTBKTYLCCDDBLSPPFYLGYDTZJYQGGKQTTFZXBDKTYYHYBBFYTYYBCLPDYTGDHRYRNJSPTCSNYJQHKLLLZSLYDXXWBCJQSPXBPJZJCJDZFFXXBRMLAZHCSNDLBJDSZBLPRZTSWSBXBCLLXXLZDJZSJPYLYXXYFTFFFBHJJXGBYXJPMMMPSSJZJMTLYZJXSWXTYLEDQPJMYGQZJGDJLQJWJQLLSJGJGYGMSCLJJXDTYGJQJQJCJZCJGDZZSXQGSJGGCXHQXSNQLZZBXHSGZXCXYLJXYXYYDFQQJHJFXDHCTXJYRXYSQTJXYEFYYSSYYJXNCYZXFXMSYSZXYYSCHSHXZZZGZZZGFJDLTYLNPZGYJYZYYQZPBXQBDZTZCZYXXYHHSQXSHDHGQHJHGYWSZTMZMLHYXGEBTYLZKQWYTJZRCLEKYSTDBCYKQQSAYXCJXWWGSBHJYZYDHCSJKQCXSWXFLTYNYZPZCCZJQTZWJQDZZZQZLJJXLSBHPYXXPSXSHHEZTXFPTLQYZZXHYTXNCFZYYHXGNXMYWXTZSJPTHHGYMXMXQZXTSBCZYJYXXTYYZYPCQLMMSZMJZZLLZXGXZAAJZYXJMZXWDXZSXZDZXLEYJJZQBHZWZZZQTZPSXZTDSXJJJZNYAZPHXYYSRNQDTHZHYYKYJHDZXZLSWCLYBZYECWCYCRYLCXNHZYDZYDYJDFRJJHTRSQTXYXJRJHOJYNXELXSFSFJZGHPZSXZSZDZCQZBYYKLSGSJHCZSHDGQGXYZGXCHXZJWYQWGYHKSSEQZZNDZFKWYSSTCLZSTSYMCDHJXXYWEYXCZAYDMPXMDSXYBSQMJMZJMTZQLPJYQZCGQHXJHHLXXHLHDLDJQCLDWBSXFZZYYSCHTYTYYBHECXHYKGJPXHHYZJFXHWHBDZFYZBCAPNPGNYDMSXHMMMMAMYNBYJTMPXYYMCTHJBZYFCGTYHWPHFTWZZEZSBZEGPFMTSKFTYCMHFLLHGPZJXZJGZJYXZSBBQSCZZLZCCSTPGXMJSFTCCZJZDJXCYBZLFCJSYZFGSZLYBCWZZBYZDZYPSWYJZXZBDSYUXLZZBZFYGCZXBZHZFTPBGZGEJBSTGKDMFHYZZJHZLLZZGJQZLSFDJSSCBZGPDLFZFZSZYZYZSYGCXSNXXCHCZXTZZLJFZGQSQYXZJQDCCZTQCDXZJYQJQCHXZTDLGSCXZSYQJQTZWLQDQZTQCHQQJZYEZZZPBWKDJFCJPZTYPQYQTTYNLMBDKTJZPQZQZZFPZSBNJLGYJDXJDZZKZGQKXDLPZJTCJDQBXDJQJSTCKNXBXZMSLYJCQMTJQWWCJQNJNLLLHJCWQTBZQYDZCZPZZDZYDDCYZZZCCJTTJFZDPRRTZTJDCQTQZDTJNPLZBCLLCTZSXKJZQZPZLBZRBTJDCXFCZDBCCJJLTQQPLDCGZDBBZJCQDCJWYNLLZYZCCDWLLXWZLXRXNTQQCZXKQLSGDFQTDDGLRLAJJTKUYMKQLLTZYTDYYCZGJWYXDXFRSKSTQTENQMRKQZHHQKDLDAZFKYPBGGPZREBZZYKZZSPEGJXGYKQZZZSLYSYYYZWFQZYLZZLZHWCHKYPQGNPGBLPLRRJYXCCSYYHSFZFYBZYYTGZXYLXCZWXXZJZBLFFLGSKHYJZEYJHLPLLLLCZGXDRZELRHGKLZZYHZLYQSZZJZQLJZFLNBHGWLCZCFJYSPYXZLZLXGCCPZBLLCYBBBBUBBCBPCRNNZCZYRBFSRLDCGQYYQXYGMQZWTZYTYJXYFWTEHZZJYWLCCNTZYJJZDEDPZDZTSYQJHDYMBJNYJZLXTSSTPHNDJXXBYXQTZQDDTJTDYYTGWSCSZQFLSHLGLBCZPHDLYZJYCKWTYTYLBNYTSDSYCCTYSZYYEBHEXHQDTWNYGYCLXTSZYSTQMYGZAZCCSZZDSLZCLZRQXYYELJSBYMXSXZTEMBBLLYYLLYTDQYSHYMRQWKFKBFXNXSBYCHXBWJYHTQBPBSBWDZYLKGZSKYHXQZJXHXJXGNLJKZLYYCDXLFYFGHLJGJYBXQLYBXQPQGZTZPLNCYPXDJYQYDYMRBESJYYHKXXSTMXRCZZYWXYQYBMCLLYZHQYZWQXDBXBZWZMSLPDMYSKFMZKLZCYQYCZLQXFZZYDQZPZYGYJYZMZXDZFYFYTTQTZHGSPCZMLCCYTZXJCYTJMKSLPZHYSNZLLYTPZCTZZCKTXDHXXTQCYFKSMQCCYYAZHTJPCYLZLYJBJXTPNYLJYYNRXSYLMMNXJSMYBCSYSYLZYLXJJQYLDZLPQBFZZBLFNDXQKCZFYWHGQMRDSXYCYTXNQQJZYYPFZXDYZFPRXEJDGYQBXRCNFYYQPGHYJDYZXGRHTKYLNWDZNTSMPKLBTHBPYSZBZTJZSZZJTYYXZPHSSZZBZCZPTQFZMYFLYPYBBJQXZMXXDJMTSYSKKBJZXHJCKLPSMKYJZCXTMLJYXRZZQSLXXQPYZXMKYXXXJCLJPRMYYGADYSKQLSNDHYZKQXZYZTCGHZTLMLWZYBWSYCTBHJHJFCWZTXWYTKZLXQSHLYJZJXTMPLPYCGLTBZZTLZJCYJGDTCLKLPLLQPJMZPAPXYZLKKTKDZCZZBNZDYDYQZJYJGMCTXLTGXSZLMLHBGLKFWNWZHDXUHLFMKYSLGXDTWWFRJEJZTZHYDXYKSHWFZCQSHKTMQQHTZHYMJDJSKHXZJZBZZXYMPAGQMSTPXLSKLZYNWRTSQLSZBPSPSGZWYHTLKSSSWHZZLYYTNXJGMJSZSUFWNLSOZTXGXLSAMMLBWLDSZYLAKQCQCTMYCFJBSLXCLZZCLXXKSBZQCLHJPSQPLSXXCKSLNHPSFQQYTXYJZLQLDXZQJZDYYDJNZPTUZDSKJFSLJHYLZSQZLBTXYDGTQFDBYAZXDZHZJNHHQBYKNXJJQCZMLLJZKSPLDYCLBBLXKLELXJLBQYCXJXGCNLCQPLZLZYJTZLJGYZDZPLTQCSXFDMNYCXGBTJDCZNBGBQYQJWGKFHTNPYQZQGBKPBBYZMTJDYTBLSQMPSXTBNPDXKLEMYYCJYNZCTLDYKZZXDDXHQSHDGMZSJYCCTAYRZLPYLTLKXSLZCGGEXCLFXLKJRTLQJAQZNCMBYDKKCXGLCZJZXJHPTDJJMZQYKQSECQZDSHHADMLZFMMZBGNTJNNLGBYJBRBTMLBYJDZXLCJLPLDLPCQDHLXZLYCBLCXZZJADJLNZMMSSSMYBHBSQKBHRSXXJMXSDZNZPXLGBRHWGGFCXGMSKLLTSJYYCQLTSKYWYYHYWXBXQYWPYWYKQLSQPTNTKHQCWDQKTWPXXHCPTHTWUMSSYHBWCRWXHJMKMZNGWTMLKFGHKJYLSYYCXWHYECLQHKQHTTQKHFZLDXQWYZYYDESBPKYRZPJFYYZJCEQDZZDLATZBBFJLLCXDLMJSSXEGYGSJQXCWBXSSZPDYZCXDNYXPPZYDLYJCZPLTXLSXYZYRXCYYYDYLWWNZSAHJSYQYHGYWWAXTJZDAXYSRLTDPSSYYFNEJDXYZHLXLLLZQZSJNYQYQQXYJGHZGZCYJCHZLYCDSHWSHJZYJXCLLNXZJJYYXNFXMWFPYLCYLLABWDDHWDXJMCXZTZPMLQZHSFHZYNZTLLDYWLSLXHYMMYLMBWWKYXYADTXYLLDJPYBPWUXJMWMLLSAFDLLYFLBHHHBQQLTZJCQJLDJTFFKMMMBYTHYGDCQRDDWRQJXNBYSNWZDBYYTBJHPYBYTTJXAAHGQDQTMYSTQXKBTZPKJLZRBEQQSSMJJBDJOTGTBXPGBKTLHQXJJJCTHXQDWJLWRFWQGWSHCKRYSWGFTGYGBXSDWDWRFHWYTJJXXXJYZYSLPYYYPAYXHYDQKXSHXYXGSKQHYWFDDDPPLCJLQQEEWXKSYYKDYPLTJTHKJLTCYYHHJTTPLTZZCDLTHQKZXQYSTEEYWYYZYXXYYSTTJKLLPZMCYHQGXYHSRMBXPLLNQYDQHXSXXWGDQBSHYLLPJJJTHYJKYPPTHYYKTYEZYENMDSHLCRPQFDGFXZPSFTLJXXJBSWYYSKSFLXLPPLBBBLBSFXFYZBSJSSYLPBBFFFFSSCJDSTZSXZRYYSYFFSYZYZBJTBCTSBSDHRTJJBYTCXYJEYLXCBNEBJDSYXYKGSJZBXBYTFZWGENYHHTHZHHXFWGCSTBGXKLSXYWMTMBYXJSTZSCDYQRCYTWXZFHMYMCXLZNSDJTTTXRYCFYJSBSDYERXJLJXBBDEYNJGHXGCKGSCYMBLXJMSZNSKGXFBNBPTHFJAAFXYXFPXMYPQDTZCXZZPXRSYWZDLYBBKTYQPQJPZYPZJZNJPZJLZZFYSBTTSLMPTZRTDXQSJEHBZYLZDHLJSQMLHTXTJECXSLZZSPKTLZKQQYFSYGYWPCPQFHQHYTQXZKRSGTTSQCZLPTXCDYYZXSQZSLXLZMYCPCQBZYXHBSXLZDLTCDXTYLZJYYZPZYZLTXJSJXHLPMYTXCQRBLZSSFJZZTNJYTXMYJHLHPPLCYXQJQQKZZSCPZKSWALQSBLCCZJSXGWWWYGYKTJBBZTDKHXHKGTGPBKQYSLPXPJCKBMLLXDZSTBKLGGQKQLSBKKTFXRMDKBFTPZFRTBBRFERQGXYJPZSSTLBZTPSZQZSJDHLJQLZBPMSMMSXLQQNHKNBLRDDNXXDHDDJCYYGYLXGZLXSYGMQQGKHBPMXYXLYTQWLWGCPBMQXCYZYDRJBHTDJYHQSHTMJSBYPLWHLZFFNYPMHXXHPLTBQPFBJWQDBYGPNZTPFZJGSDDTQSHZEAWZZYLLTYYBWJKXXGHLFKXDJTMSZSQYNZGGSWQSPHTLSSKMCLZXYSZQZXNCJDQGZDLFNYKLJCJLLZLMZZNHYDSSHTHZZLZZBBHQZWWYCRZHLYQQJBEYFXXXWHSRXWQHWPSLMSSKZTTYGYQQWRSLALHMJTQJSMXQBJJZJXZYZKXBYQXBJXSHZTSFJLXMXZXFGHKZSZGGYLCLSARJYHSLLLMZXELGLXYDJYTLFBHBPNLYZFBBHPTGJKWETZHKJJXZXXGLLJLSTGSHJJYQLQZFKCGNNDJSSZFDBCTWWSEQFHQJBSAQTGYPQLBXBMMYWXGSLZHGLZGQYFLZBYFZJFRYSFMBYZHQGFWZSYFYJJPHZBYYZFFWODGRLMFTWLBZGYCQXCDJYGZYYYYTYTYDWEGAZYHXJLZYYHLRMGRXXZCLHNELJJTJTPWJYBJJBXJJTJTEEKHWSLJPLPSFYZPQQBDLQJJTYYQLYZKDKSQJYYQZLDQTGJQYZJSUCMRYQTHTEJMFCTYHYPKMHYZWJDQFHYYXWSHCTXRLJHQXHCCYYYJLTKTTYTMXGTCJTZAYYOCZLYLBSZYWJYTSJYHBYSHFJLYGJXXTMZYYLTXXYPZLXYJZYZYYPNHMYMDYYLBLHLSYYQQLLNJJYMSOYQBZGDLYXYLCQYXTSZEGXHZGLHWBLJHEYXTWQMAKBPQCGYSHHEGQCMWYYWLJYJHYYZLLJJYLHZYHMGSLJLJXCJJYCLYCJPCPZJZJMMYLCQLNQLJQJSXYJMLSZLJQLYCMMHCFMMFPQQMFYLQMCFFQMMMMHMZNFHHJGTTHHKHSLNCHHYQDXTMMQDCYZYXYQMYQYLTDCYYYZAZZCYMZYDLZFFFMMYCQZWZZMABTBYZTDMNZZGGDFTYPCGQYTTSSFFWFDTZQSSYSTWXJHXYTSXXYLBYQHWWKXHZXWZNNZZJZJJQJCCCHYYXBZXZCYZTLLCQXYNJYCYYCYNZZQYYYEWYCZDCJYCCHYJLBTZYYCQWMPWPYMLGKDLDLGKQQBGYCHJXY";  
//此处收录了375个多音字  
var oMultiDiff={"19969":"DZ","19975":"WM","19988":"QJ","20048":"YL","20056":"SC","20060":"NM","20094":"QG","20127":"QJ","20167":"QC","20193":"YG","20250":"KH","20256":"ZC","20282":"SC","20285":"QJG","20291":"TD","20314":"YD","20340":"NE","20375":"TD","20389":"YJ","20391":"CZ","20415":"PB","20446":"YS","20447":"SQ","20504":"TC","20608":"KG","20854":"QJ","20857":"ZC","20911":"PF","20504":"TC","20608":"KG","20854":"QJ","20857":"ZC","20911":"PF","20985":"AW","21032":"PB","21048":"XQ","21049":"SC","21089":"YS","21119":"JC","21242":"SB","21273":"SC","21305":"YP","21306":"QO","21330":"ZC","21333":"SDC","21345":"QK","21378":"CA","21397":"SC","21414":"XS","21442":"SC","21477":"JG","21480":"TD","21484":"ZS","21494":"YX","21505":"YX","21512":"HG","21523":"XH","21537":"PB","21542":"PF","21549":"KH","21571":"E","21574":"DA","21588":"TD","21589":"O","21618":"ZC","21621":"KHA","21632":"ZJ","21654":"KG","21679":"LKG","21683":"KH","21710":"A","21719":"YH","21734":"WOE","21769":"A","21780":"WN","21804":"XH","21834":"A","21899":"ZD","21903":"RN","21908":"WO","21939":"ZC","21956":"SA","21964":"YA","21970":"TD","22003":"A","22031":"JG","22040":"XS","22060":"ZC","22066":"ZC","22079":"MH","22129":"XJ","22179":"XA","22237":"NJ","22244":"TD","22280":"JQ","22300":"YH","22313":"XW","22331":"YQ","22343":"YJ","22351":"PH","22395":"DC","22412":"TD","22484":"PB","22500":"PB","22534":"ZD","22549":"DH","22561":"PB","22612":"TD","22771":"KQ","22831":"HB","22841":"JG","22855":"QJ","22865":"XQ","23013":"ML","23081":"WM","23487":"SX","23558":"QJ","23561":"YW","23586":"YW","23614":"YW","23615":"SN","23631":"PB","23646":"ZS","23663":"ZT","23673":"YG","23762":"TD","23769":"ZS","23780":"QJ","23884":"QK","24055":"XH","24113":"DC","24162":"ZC","24191":"GA","24273":"QJ","24324":"NL","24377":"TD","24378":"QJ","24439":"PF","24554":"ZS","24683":"TD","24694":"WE","24733":"LK","24925":"TN","25094":"ZG","25100":"XQ","25103":"XH","25153":"PB","25170":"PB","25179":"KG","25203":"PB","25240":"ZS","25282":"FB","25303":"NA","25324":"KG","25341":"ZY","25373":"WZ","25375":"XJ","25384":"A","25457":"A","25528":"SD","25530":"SC","25552":"TD","25774":"ZC","25874":"ZC","26044":"YW","26080":"WM","26292":"PB","26333":"PB","26355":"ZY","26366":"CZ","26397":"ZC","26399":"QJ","26415":"ZS","26451":"SB","26526":"ZC","26552":"JG","26561":"TD","26588":"JG","26597":"CZ","26629":"ZS","26638":"YL","26646":"XQ","26653":"KG","26657":"XJ","26727":"HG","26894":"ZC","26937":"ZS","26946":"ZC","26999":"KJ","27099":"KJ","27449":"YQ","27481":"XS","27542":"ZS","27663":"ZS","27748":"TS","27784":"SC","27788":"ZD","27795":"TD","27812":"O","27850":"PB","27852":"MB","27895":"SL","27898":"PL","27973":"QJ","27981":"KH","27986":"HX","27994":"XJ","28044":"YC","28065":"WG","28177":"SM","28267":"QJ","28291":"KH","28337":"ZQ","28463":"TL","28548":"DC","28601":"TD","28689":"PB","28805":"JG","28820":"QG","28846":"PB","28952":"TD","28975":"ZC","29100":"A","29325":"QJ","29575":"SL","29602":"FB","30010":"TD","30044":"CX","30058":"PF","30091":"YSP","30111":"YN","30229":"XJ","30427":"SC","30465":"SX","30631":"YQ","30655":"QJ","30684":"QJG","30707":"SD","30729":"XH","30796":"LG","30917":"PB","31074":"NM","31085":"JZ","31109":"SC","31181":"ZC","31192":"MLB","31293":"JQ","31400":"YX","31584":"YJ","31896":"ZN","31909":"ZY","31995":"XJ","32321":"PF","32327":"ZY","32418":"HG","32420":"XQ","32421":"HG","32438":"LG","32473":"GJ","32488":"TD","32521":"QJ","32527":"PB","32562":"ZSQ","32564":"JZ","32735":"ZD","32793":"PB","33071":"PF","33098":"XL","33100":"YA","33152":"PB","33261":"CX","33324":"BP","33333":"TD","33406":"YA","33426":"WM","33432":"PB","33445":"JG","33486":"ZN","33493":"TS","33507":"QJ","33540":"QJ","33544":"ZC","33564":"XQ","33617":"YT","33632":"QJ","33636":"XH","33637":"YX","33694":"WG","33705":"PF","33728":"YW","33882":"SR","34067":"WM","34074":"YW","34121":"QJ","34255":"ZC","34259":"XL","34425":"JH","34430":"XH","34485":"KH","34503":"YS","34532":"HG","34552":"XS","34558":"YE","34593":"ZL","34660":"YQ","34892":"XH","34928":"SC","34999":"QJ","35048":"PB","35059":"SC","35098":"ZC","35203":"TQ","35265":"JX","35299":"JX","35782":"SZ","35828":"YS","35830":"E","35843":"TD","35895":"YG","35977":"MH","36158":"JG","36228":"QJ","36426":"XQ","36466":"DC","36710":"JC","36711":"ZYG","36767":"PB","36866":"SK","36951":"YW","37034":"YX","37063":"XH","37218":"ZC","37325":"ZC","38063":"PB","38079":"TD","38085":"QY","38107":"DC","38116":"TD","38123":"YD","38224":"HG","38241":"XTC","38271":"ZC","38415":"YE","38426":"KH","38461":"YD","38463":"AE","38466":"PB","38477":"XJ","38518":"YT","38551":"WK","38585":"ZC","38704":"XS","38739":"LJ","38761":"GJ","38808":"SQ","39048":"JG","39049":"XJ","39052":"HG","39076":"CZ","39271":"XT","39534":"TD","39552":"TD","39584":"PB","39647":"SB","39730":"LG","39748":"TPB","40109":"ZQ","40479":"ND","40516":"HG","40536":"HG","40583":"QJ","40765":"YQ","40784":"QJ","40840":"YK","40863":"QJG"};  
//参数,中文字符串  
//返回值:拼音首字母串数组  
function makePy(str){  
if(typeof(str) != "string")  
throw new Error(-1,"函数makePy需要字符串类型参数!");  
var arrResult = new Array(); //保存中间结果的数组  
for(var i=0,len=str.length;i<len;i++){  
//获得unicode码  
var ch = str.charAt(i);  
//检查该unicode码是否在处理范围之内,在则返回该码对映汉字的拼音首字母,不在则调用其它函数处理  
arrResult.push(checkCh(ch));  
}  
//处理arrResult,返回所有可能的拼音首字母串数组  
return mkRslt(arrResult);  
}  
function checkCh(ch){  
var uni = ch.charCodeAt(0);  
//如果不在汉字处理范围之内,返回原字符,也可以调用自己的处理函数  
if(uni > 40869 || uni < 19968)  
return ch; //dealWithOthers(ch);  
//检查是否是多音字,是按多音字处理,不是就直接在strChineseFirstPY字符串中找对应的首字母  
//return (oMultiDiff[uni]?oMultiDiff[uni]:(strChineseFirstPY.charAt(uni-19968)));
return strChineseFirstPY.charAt(uni-19968);
}  
function mkRslt(arr){  
var arrRslt = [""];  
for(var i=0,len=arr.length;i<len;i++){  
var str = arr[i];  
var strlen = str.length;  
if(strlen == 1){  
for(var k=0;k<arrRslt.length;k++){  
arrRslt[k] += str;  
}  
}else{  
var tmpArr = arrRslt.slice(0);  
arrRslt = [];  
for(k=0;k<strlen;k++){  
//复制一个相同的arrRslt  
var tmp = tmpArr.slice(0);  
//把当前字符str[k]添加到每个元素末尾  
for(var j=0;j<tmp.length;j++){  
tmp[j] += str.charAt(k);  
}  
//把复制并修改后的数组连接到arrRslt上  
arrRslt = arrRslt.concat(tmp);  
}  
}  
}  
return arrRslt;  
}  
//两端去空格函数  
String.prototype.trim = function() {    
	return this.replace(/(^\s*)|(\s*$)/g,""); 
}  
function showun(){
	//alert("111");
	var tmpname = $("#name").val();
	tmpname = tmpname.trim();
	$("#name").val(tmpname);
	var arrRslt = makePy(tmpname);  
	arrRslt =""+arrRslt;
	$("#code_pre").val(arrRslt.substring(0,4));
	$("#namepy").val(arrRslt.substring(0,1));
	dofind();
	
}
function check(obj){
	obj.value=(obj.checked?"1":"0");
}
function checkall(obj,type){
	if (type==1){//勾选大类
        input = document.getElementsByTagName("input");
	    for (var i = 0; i < input.length; i++) {
	    		if(input[i].name.indexOf("kjs_")>=0){
			        continue;
		        }
	        if ((input[i].type == "checkbox")&&(input[i].name.length>0)&&(input[i].name.indexOf("/")<0)) {
	        		input[i].checked = obj.checked;
	            	input[i].value= obj.checked?1:0;
	        }
	    }	
	}else{
        input = document.getElementsByTagName("input");
	    for (var i = 0; i < input.length; i++) {
	    	 		if(input[i].name.indexOf("kjs_")>=0){
			        continue;
		        }
	        if ((input[i].type == "checkbox")&&(input[i].name.length>0)&&(input[i].name.indexOf("/")>=0)) {
	        		input[i].checked = obj.checked;
	            	input[i].value= obj.checked?1:0;
	        }
	    }	
		
	}
}
function checkallkjs(obj,type){
	if (type==1){//勾选大类
        input = document.getElementsByTagName("input");
	    for (var i = 0; i < input.length; i++) {
	        if ((input[i].type == "checkbox")&&(input[i].name.length>0)&&(input[i].name.indexOf("/")<0)) {
		        if(input[i].name.indexOf("kjs_")<0){
			        continue;
		        }
	        		input[i].checked = obj.checked;
	            	input[i].value= obj.checked?1:0;
	        }
	    }	
	}else{
        input = document.getElementsByTagName("input");
	    for (var i = 0; i < input.length; i++) {
	        if ((input[i].type == "checkbox")&&(input[i].name.length>0)&&(input[i].name.indexOf("/")>=0)) {
	        	 	if(input[i].name.indexOf("kjs_")<0){
					continue;
				}
	        		input[i].checked = obj.checked;
	            	input[i].value= obj.checked?1:0;
	        }
	    }	
		
	}
}
function checkfl(obj){
	obj.value=(obj.checked?"1":"0");
    input = document.getElementsByTagName("input");
    for (var i = 0; i < input.length; i++) {
        if ((input[i].type == "checkbox")&&(input[i].name.length>0)&&(input[i].name.indexOf(obj.name)>=0)) {
        		input[i].checked = obj.checked;
            	input[i].value= obj.checked?1:0;
        }
    }	
}

function dofind(){//vin车型
	name = $("#name").val();
	if(name.length ==0 ){
		alert('公司名为空');
		$("#submit_button").attr("style","display:none;");
	}else{
		 $.post("${pageContext.request.contextPath }/erp/ajax_fs_name.do",{name:name},
				 function(result){
			 if(result!=null&&result!=''){
			 var str="";
			 $.each(result, function(index, item){
				 str=item.name+"|"+str;
			 });
			 alert("已有公司名称:"+str);
			 $("#submit_button").attr("style","display:none;");
			 }else{
			 alert("无相关名称，名称可用！");
			 $("#submit_button").attr("style","display:block;");
			 }
			  }, "json");
		
	}
}
</script>		
</section>
<%-- 		<div class="footer-wrap">
			<div class="box-footer">
				<button type="button"  class="btn btn-default" onclick="location.href='${pageContext.request.contextPath }/erp/user_list.do?type=icbc&dn=assess_fs&qn=list&mid_add=${sessionScope.pd.id }'">取消返回</button>
				<c:if  test="${fn:contains(sessionScope.pd.purview_map,'gsglupdate')==true or fn:contains(sessionScope.pd.purview_map,'gsgladd')==true}">
				<c:if test="${requestScope.cn!='4'}">
				<button id="submit_button" type="submit"  class="btn btn-primary pull-right">保存提交</button> 
				</c:if>
				</c:if>
			</div>
		</div> --%>
			</div><!-- /.content-wrapper -->
				 <script>
	 $(document).ready(function(){
		
		 //公司办公所在地址
		 states('company_province','${requestScope.pd.company_province}');
		 citys('company_city','${requestScope.pd.company_province}','${requestScope.pd.company_city}');
		 getcomm_zones('company_section','${requestScope.pd.company_province}','${requestScope.pd.company_city}','${requestScope.pd.company_section}');
		 //公司办公所在地址
		 states('register_province','${requestScope.pd.register_province}');
		 citys('register_city','${requestScope.pd.register_province}','${requestScope.pd.register_city}');
		 getcomm_zones('register_section','${requestScope.pd.register_province}','${requestScope.pd.register_city}','${requestScope.pd.register_section}');
		 //zy_province
		 states('zy_province','${requestScope.pd.zy_province}');
		 citys('zy_city','${requestScope.pd.zy_province}','${requestScope.pd.zy_city}');
		});
	 function states(idname,selectid){
		 //alert(selectid);
		 $.ajax({ 	
				url:"${pageContext.request.contextPath }/finfdstates.do",
			    type:"POST",
			    dataType: "json",
		       success: function(msg){
		       	 var con = "<option value=''>所在省</option>"; 
		       	$("#"+idname).empty();
		       	$.each(msg,function(index, n){
		       	  if(selectid==msg[index].id){
		       		con += "<option selected='selected' value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";  
		       	  }else{ 
		       		con += "<option  value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>"; 
 		       	  }
		       	});           	
		       	$("#"+idname).append(con);
		       	
		       }
		
		});
	 }
		function citys(idname,cityid,selectid){
			$.ajax({ 	
				url:"${pageContext.request.contextPath }/fincitys.do",
			    type:"POST",
			    dataType: "json",
			    data :{
			    	state_id : cityid
			    },
		       success: function(msg){
		       	 var con = "<option value=''>所在市</option>";         	  
		       	$("#"+idname).empty();
		       	$.each(msg,function(index, n){
		       		if(selectid==msg[index].id){
			       		con += "<option selected='selected' value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";  
			       	  }else{ 
			       		con += "<option  value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";       		
			       	  }
			       	  });           	
		       	$("#"+idname).append(con);      	
		       }
		});
		}
		function getcomm_zones(idname,shengidname,cityid,selectid){
			var shengid=$("#"+shengidname).val();
			if(shengid!=0&&shengid!=''&&shengid!=null){
				shengid=$("#"+shengidname).val();
			}else{
				shengid=shengidname;
			}
			//alert(shengid);
			$.ajax({ 	
				url:"${pageContext.request.contextPath }/erp/getcomm_zones.do",
			    type:"POST",
			    dataType: "json",
			    data :{
			    	shengid : shengid,
			    	cityid : cityid
			    },
		       success: function(msg){
		       	 var con = "<option value=''>所在区</option>";         	  
		       	$("#"+idname).empty();
		       	$.each(msg,function(index, n){
		       		if(selectid==msg[index].id){
			       		con += "<option selected='selected' value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";  
			       	  }else{ 
			       		con += "<option  value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";       		
			       	  }
			       	  });           	
		       	$("#"+idname).append(con);      	
		       }
		});
		}

				</script>
