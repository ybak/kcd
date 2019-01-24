<%@page import="java.util.Random"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
                 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function kkup() {
	var form = new FormData(document.getElementById("kk_form"));
	$.ajax({
		   type:"post",   
		   url:"kk_up.do",
		   data:form,
		   /**
	        *必须false才会自动加上正确的Content-Type
	        */
	        contentType: false,
	        /**
	        * 必须false才会避开jQuery对 formdata 的默认处理
	        * XMLHttpRequest会对 formdata 进行正确的处理
	    	* window.location.reload();	
	        */
	        processData: false,
	  success: function(msg){
		  alert("提交成功");
		  window.location.reload();
		},
		 error:function(){
	          alert("提交失败，请稍后重试...");         
	       }
	  });
	
	
}
</script>

</head>
<body eftmargin=0>
<script type="text/javascript">
$(document).ready(function(){
	var kk_car_stateid=document.getElementById("states1").value;
	var states2=document.getElementById("states2").value;
	var s="<option value='0'>请选择</option>";
$.ajax({ 	
		url:"finfdstates.do",
	    type:"POST",
	    dataType: "json",
       success: function(msg){
       	 var con = ""; 
       	 var con1= "";  
       	$("#kk_car_stateid").empty();
       	$("#kk_loan_stateid").empty();
       	$.each(msg,function(index, n){
       		if(msg[index].id==kk_car_stateid){
       			cityid=msg[index].id;
       			con += "<option  selected='selected' value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";
       		}else{
       			cityid=msg[0].id;       			
       			con += "<option  value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";	        			
       		}  
       		
       		if(msg[index].id==states2){
       			cityid2=msg[index].id;
       			con1 += "<option  selected='selected' value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";
       		}else{
       			cityid2=msg[0].id;
       			con1 += "<option  value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";	        			
       		}       		
       	 });           	
       	$("#kk_car_stateid").append(s+con);
       	$("#kk_loan_stateid").append(s+con1);
       	citys1($("#kk_car_stateid").val());
       	citys2($("#kk_loan_stateid").val());
       }
});


});

function citys1(cityid){
	var s="<option value='0'>请选择</option>";
	var cityid1=document.getElementById("cityid1").value;	
	$.ajax({ 	
		url:"fincitys.do",
	    type:"POST",
	    dataType: "json",
	    data :{
	    	state_id : cityid
	    },
       success: function(msg){
       	 var con = "";         	  
       	$("#kk_car_cityid").empty();
       	$.each(msg,function(index, n){
       		if(msg[index].id==cityid1){
       			con += "<option  selected='selected' value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";
       		}else{
       			con += "<option  value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";	        			
       		}       	      		
       	 });           	
       	$("#kk_car_cityid").append(s+con);      	
       }
});
}
function citys2(cityid){	
	var s="<option value='0'>请选择</option>";
	var cityid2=document.getElementById("cityid2").value;
	$.ajax({ 	
		url:"fincitys.do",
	    type:"POST",
	    dataType: "json",
	    data :{
	    	state_id : cityid
	    },
       success: function(msg){
       	 var con1 = "";  
       	$("#kk_loan_cityid").empty();
       	$.each(msg,function(index, n){
       		if(msg[index].id==cityid2){
       			con1 += "<option  selected='selected' value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";
       		}else{
       			con1 += "<option  value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";	        			
       		}
       	 });           	
       	$("#kk_loan_cityid").append(s+con1);
       }
});
}
</script>
<form id="kk_form" action="" class="form-horizontal" method="post" enctype="multipart/form-data" >
<input id="id" name="id" value="${requestScope.icbc_kk.id }" type="hidden">
<input id="adminid" name="adminid" value="${sessionScope.id }" type="hidden">
<div class="box-header with-border">
	<div  class="box-body" style="margin-left: 150px;width: 80%" >  	     	            
			<div class="form-group">						
			  <h3 align="center" style="margin-right: 300px">用户提交信息</h3>
			  <div  style="padding-top: 60px;width:85%;">               
             <p>工行进件审核 来自：${requestScope.icbc_kk.gname }-${requestScope.icbc_kk.pname }<span style="float:right;display:block;">${fn:substring(requestScope.icbc_kk.dt_add,0,19)} 合同编码：<font style="color: #ff8700;">${requestScope.icbc_kk.gems_code }</font></span></p>            
              
               <table id="data_table" class="divcss table" style="width:100%; ;border-style:none">  
               <tr>
               <td style="color: #5f5f6c;">客户姓名</td>
               <td><input id="c_name" name="c_name" class="inputcss" type="text" value="${requestScope.icbc_kk.c_name }" /></td>
               <td style="color: #5f5f6c;">按揭模式</td>
               <td>
               <select id="aj_type" name="aj_type">
                <option value="0">请选择按揭模式</option>
                <option value="1" ${requestScope.icbc_kk.aj_type==1?"selected='selected'":''}>卡分期</option>             
               </select>
               </td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">手机号码</td>
               <td><input id="c_tel" name="c_tel" class="inputcss" type="text" value="${requestScope.icbc_kk.c_tel }" /></td>
               <td style="color: #5f5f6c;">按揭期限</td>
               <td><select id="aj_date" name="aj_date">
                <option value="0">请选择按揭期限</option>
                <option value="24" ${requestScope.icbc_kk.aj_date==24?"selected='selected'":''}>24期</option>
                <option value="36" ${requestScope.icbc_kk.aj_date==36?"selected='selected'":''}>36期</option>            
                </select>
                </td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">车辆类型</td>
               <td>
                <select id="cars_type" name="cars_type">
                <option value="0">请选择车辆类型</option>
                <option value="1" ${requestScope.icbc_kk.cars_type==1?"selected='selected'":''}>新车</option>  
                <option value="2" ${requestScope.icbc_kk.cars_type==2?"selected='selected'":''}>二手车</option>
                </select>
               </td>
               <td style="color: #5f5f6c;">按揭银行</td>
               <td>
               <select id="aj_bank" name="aj_bank">
                <option value="0">请选择按揭银行</option>
                <option value="1" ${requestScope.icbc_kk.aj_bank==1?"selected='selected'":''}>工行绍兴分行</option>  
                <option value="2" ${requestScope.icbc_kk.aj_bank==2?"selected='selected'":''}>工行武林支行</option>
                <option value="3" ${requestScope.icbc_kk.aj_bank==3?"selected='selected'":''}>工行义乌支行</option>            
                </select>
                </td>
                </tr>
               <tr>
               <td style="color: #5f5f6c;">开票价</td>
               <td><input id="kp_price" name="kp_price" class="inputcss" type="text" value="${requestScope.icbc_kk.kp_price}" />
               <span style="margin-left:-26px;padding:3px;border:1px solid #b1bacb;border-radius: 2px;">元</span>
               </td>
               <td style="color: #5f5f6c;">贷款利率</td>
               <td >
               <input class="inputcss" id="dk_lv" name="dk_lv" type="text" value="${requestScope.icbc_kk.dk_lv}"  > 
                </td>
              </tr>
               <tr>
               <td style="color: #5f5f6c;">贷款金额</td>
               <td><input class="inputcss" id="dk_price" name="dk_price" type="text" value="${requestScope.icbc_kk.dk_price}" />
               <span style="margin-left:-26px;padding:3px;border:1px solid #b1bacb;border-radius: 2px;">元</span>
               </td>
               <td style="color: #5f5f6c;">垫资类型</td>
               <td><select id="dz_type" name="dz_type">
                <option value="0">请选择垫资类型</option>
                <option value="2" ${requestScope.icbc_kk.dz_type==2?"selected='selected'":''}>提车垫资</option>  
                <option value="1" ${requestScope.icbc_kk.dz_type==1?"selected='selected'":''}>不垫资</option>           
                </select></td>
               </tr>
                <tr>
               <td style="color: #5f5f6c;">金融服务费</td>
               <td><input class="inputcss" id="jrfw_price" name="jrfw_price" type="text" value="${requestScope.icbc_kk.jrfw_price}" />
               <span style="margin-left:-26px;padding:3px;border-left:1px solid #b1bacb;border-radius: 2px;">元</span>
               </td>
               <td style="color: #5f5f6c;">上牌地址</td>
               <td>         
                <input type="hidden" id="states1"  name="states1" value="${requestScope.states1.id}" />     
                <select id="kk_car_stateid" name="kk_car_stateid" onchange="citys1(this.options[this.options.selectedIndex].value)">
                <option value="${requestScope.states1.id}">${requestScope.states1.name}</option>       
                </select>
                <input type="hidden" id="cityid1"  name="cityid1" value="${requestScope.citys1.id}" />
                <select id="kk_car_cityid" name="kk_car_cityid" >
                <option value="${requestScope.citys1.id}">${requestScope.citys1.name}</option>       
                </select>
                </td>
               </tr>
                <tr>
               <td style="color: #5f5f6c;">贷款总额</td>
               <td>
               <input class="inputcss" id="dk_total_price" name="dk_total_price" type="text" value="${requestScope.icbc_kk.dk_total_price}" />
               <span style="margin-left:-26px;padding:3px;border:1px solid #b1bacb;border-radius: 2px;">元</span>
               </td>
                                       
               <td style="color: #5f5f6c;">业务所在地</td>
               <td>
               <input type="hidden" id="states2"  name="states2" value="${requestScope.states2.id}" />
                <select id="kk_loan_stateid" name="kk_loan_stateid" onchange="citys2(this.options[this.options.selectedIndex].value)">
                <option value="${requestScope.states2.id}">${requestScope.states2.name}</option>                  
                </select>
                <input type="hidden" id="cityid2"  name="cityid2" value="${requestScope.citys2.id}" />
                <select id="kk_loan_cityid" name="kk_loan_cityid">
                <option value="${requestScope.citys2.id}">${requestScope.citys2.name}</option>  
                </select>
                </td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">首付金额</td>
               <td>
               <input class="inputcss" id="sfje" name="sfje" type="text" value="${requestScope.icbc_kk.sfje}" />
               <span style="margin-left:-26px;padding:3px;border-left:1px solid #b1bacb;border-radius: 2px;">元</span>
               </td>
               </tr>
               </table>              
              </div>
              </div>
              </div>
              
              	<div  class="box-body" style="margin-left: 150px;width: 80%" >  	     	            
			<div class="form-group">						
			  <h3 align="center" style="margin-right: 300px">合同信息</h3>
			  <div  style="padding-top: 60px;width:85%;">               
               <table id="data_table" class="divcss table" style="width:100%; ;border-style:none">  
               <tr>
               <td align="center" style="color: #f52c0b">主贷人</td>
               <td></td>
               <td align="center" style="color: #f52c0b">配偶</td>
               <td></td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">婚姻状况</td>
               <td>
               <select id="zdr_hyzk" name="zdr_hyzk">
               <option>请选择</option>
                <option value="0" ${requestScope.icbc_kk.zdr_hyzk==0?"selected='selected'":''}>未婚</option>
                <option value="1" ${requestScope.icbc_kk.zdr_hyzk==1?"selected='selected'":''}>已婚</option>             
                <option value="2" ${requestScope.icbc_kk.zdr_hyzk==2?"selected='selected'":''}>离异</option>
                <option value="3" ${requestScope.icbc_kk.zdr_hyzk==3?"selected='selected'":''}>丧偶</option>
               </select>
               </td>
               
               <td style="color: #5f5f6c;">月收入</td>
               <td>
               <input class="inputcss" id="po_ysr" name="po_ysr" type="text" value="${requestScope.icbc_kk.po_ysr }"  />
               <span style="margin-left:-26px;padding:3px;border:1px solid #b1bacb;border-radius: 2px;">元</span>
               
               </td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">个人收入</td>
               <td>
               <input class="inputcss" id="zdr_grsr" name="zdr_grsr" type="text" value="${requestScope.icbc_kk.zdr_grsr }" />
               <span style="margin-left:-26px;padding:3px;border:1px solid #b1bacb;border-radius: 2px;">元</span>
               
               </td>
               
               <td style="color: #5f5f6c;">配偶学历</td>
               <td><select id="po_xl" name="po_xl" >
								<option value="0">请选择</option>
								<option value="1" ${requestScope.icbc_kk.po_xl==1?"selected='selected'":''}>小学</option>
								<option value="2" ${requestScope.icbc_kk.po_xl==2?"selected='selected'":''}>初中</option>
								<option value="3" ${requestScope.icbc_kk.po_xl==3?"selected='selected'":''}>高中</option>
								<option value="4" ${requestScope.icbc_kk.po_xl==4?"selected='selected'":''}>大专</option>
								<option value="5" ${requestScope.icbc_kk.po_xl==5?"selected='selected'":''}>本科</option>
								<option value="6" ${requestScope.icbc_kk.po_xl==6?"selected='selected'":''}>硕士</option>
								<option value="7" ${requestScope.icbc_kk.po_xl==7?"selected='selected'":''}>博士及以上</option>							
								</select>
                </td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">最高学历</td>
               <td>
               <select id="zdr_xl" name="zdr_xl" >
								<option value="0">请选择</option>
								<option value="1" ${requestScope.icbc_kk.zdr_xl==1?"selected='selected'":''}>小学</option>
								<option value="2" ${requestScope.icbc_kk.zdr_xl==2?"selected='selected'":''}>初中</option>
								<option value="3" ${requestScope.icbc_kk.zdr_xl==3?"selected='selected'":''}>高中</option>
								<option value="4" ${requestScope.icbc_kk.zdr_xl==4?"selected='selected'":''}>大专</option>
								<option value="5" ${requestScope.icbc_kk.zdr_xl==5?"selected='selected'":''}>本科</option>
								<option value="6" ${requestScope.icbc_kk.zdr_xl==6?"selected='selected'":''}>硕士</option>
								<option value="7" ${requestScope.icbc_kk.zdr_xl==7?"selected='selected'":''}>博士及以上</option>							
								</select>
                </td>
               <td style="color: #5f5f6c;">现住地址</td>
               <td>
               <input class="inputcss" id="po_xzdz" name="po_xzdz" type="text" value="${requestScope.icbc_kk.po_xzdz }" onmouseover="this.title=this.value" />
                </td>
                </tr>
               <tr>
               <td style="color: #5f5f6c;">居住状况</td>
               <td>
               <select id="zdr_jzzk" name="zdr_jzzk" >
               <option>请选择</option>
								<option  value="0" ${requestScope.icbc_kk.zdr_jzzk==0?"selected='selected'":''}>自有住房</option>
								<option value="1" ${requestScope.icbc_kk.zdr_jzzk==1?"selected='selected'":''}>租房</option>
								<option value="2" ${requestScope.icbc_kk.zdr_jzzk==2?"selected='selected'":''}>分期付款购房</option>
								<option value="3" ${requestScope.icbc_kk.zdr_jzzk==3?"selected='selected'":''}>集体宿舍</option>
								<option value="4" ${requestScope.icbc_kk.zdr_jzzk==4?"selected='selected'":''}>其他</option>							
								</select>
               </td>
               <td style="color: #5f5f6c;">邮政编码</td>
               <td >
               <input class="inputcss" id="po_yzbm" name="po_yzbm" type="text"  value="${requestScope.icbc_kk.po_yzbm }" onmouseover="this.title=this.value" />
               </td>
              </tr>
               <tr>
               <td style="color: #5f5f6c;">现住地址</td>
               <td><input class="inputcss" id="zdr_xzdz" name="zdr_xzdz" type="text" value="${requestScope.icbc_kk.zdr_xzdz}" onmouseover="this.title=this.value" />
               </td>
               <td style="color: #5f5f6c;">工作单位</td>
               <td><input class="inputcss" id="po_gzdw" name="po_gzdw" type="text" value="${requestScope.icbc_kk.po_gzdw}" onmouseover="this.title=this.value" />
               </td>
               </tr>
                <tr>
               <td style="color: #5f5f6c;">邮政编码</td>
               <td><input class="inputcss" type="text" id="zdr_yzbm" name="zdr_yzbm" value="${requestScope.icbc_kk.zdr_yzbm}" onmouseover="this.title=this.value" />
               </td>
               <td style="color: #5f5f6c;">单位地址</td>
               <td>
               <input class="inputcss" type="text" id="po_dwdz" name="po_dwdz" value="${requestScope.icbc_kk.po_dwdz}" onmouseover="this.title=this.value" />
               </td>
               </tr>
                <tr>
               <td style="color: #5f5f6c;">工作单位</td>
               <td>
               <input class="inputcss" type="text" id="zdr_gzdw" name="zdr_gzdw" value="${requestScope.icbc_kk.zdr_gzdw}" onmouseover="this.title=this.value"/>
               </td>
               <td style="color: #5f5f6c;">文书送达地址</td>
               <td>
               <input class="inputcss" type="text" id="po_wsdz" name="po_wsdz" value="${requestScope.icbc_kk.po_wsdz}" onmouseover="this.title=this.value" />
               </td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">单位电话</td>
               <td>
               <input class="inputcss" type="text" id="zdr_dwdh" name="zdr_dwdh" value="${requestScope.icbc_kk.zdr_dwdh}" onmouseover="this.title=this.value" />
               </td>
               <td style="color: #5f5f6c;">主要从事或职务</td>
               <td>
               <input class="inputcss" type="text" id="po_zw" name="po_zw" value="${requestScope.icbc_kk.po_zw}" onmouseover="this.title=this.value" />
               </td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">单位地址</td>
               <td>
               <input class="inputcss"  type="text" id="zdr_dwdz" name="zdr_dwdz" value="${requestScope.icbc_kk.zdr_dwdz}" onmouseover="this.title=this.value" />
               </td>
               
               </tr>
               <tr>
               <td style="color: #5f5f6c;">文书送达地址</td>
               <td>
               <input class="inputcss" type="text" id="zdr_wsdz" name="zdr_wsdz" value="${requestScope.icbc_kk.zdr_wsdz}" onmouseover="this.title=this.value" />
               </td>
               <td align="center" style="color: #f52c0b">紧急联系人</td>
               <td>               
               
               </td>
               </tr>
                <tr>
<td style="color: #5f5f6c;">单位性质</td>
               <td>
               <select id="zdr_dwxz" name="zdr_dwxz" >
               <option>请选择</option>
								<option value="0" ${requestScope.icbc_kk.zdr_dwxz==0?"selected='selected'":''}>国有</option>
								<option value="1" ${requestScope.icbc_kk.zdr_dwxz==1?"selected='selected'":''}>集体经济</option>
								<option value="2" ${requestScope.icbc_kk.zdr_dwxz==2?"selected='selected'":''}>私营</option>
								<option value="3" ${requestScope.icbc_kk.zdr_dwxz==3?"selected='selected'":''}>民营</option>
								<option value="4" ${requestScope.icbc_kk.zdr_dwxz==4?"selected='selected'":''}>股份合作</option>
								<option value="5" ${requestScope.icbc_kk.zdr_dwxz==5?"selected='selected'":''}>其他股份制</option>
								<option value="6" ${requestScope.icbc_kk.zdr_dwxz==6?"selected='selected'":''}>个体</option>
								<option value="7" ${requestScope.icbc_kk.zdr_dwxz==7?"selected='selected'":''}>三资</option>
								<option value="8" ${requestScope.icbc_kk.zdr_dwxz==8?"selected='selected'":''}>其他</option>							
								</select>
								</td>
               <td style="color: #5f5f6c;">姓名</td>
               <td> 
               <input class="inputcss" type="text" id="jjlxr_c_name" name="jjlxr_c_name" value="${requestScope.icbc_kk.jjlxr_c_name}" onmouseover="this.title=this.value" />           
               </td>
               </tr>
                <tr>
               <td style="color: #5f5f6c;">所属行业</td>
               <td>
               <select id="zdr_sshy" name="zdr_sshy">
               <option>请选择</option>
								<option value="0" ${requestScope.icbc_kk.zdr_sshy==0?"selected='selected'":''}>农林牧渔</option>
								<option value="1" ${requestScope.icbc_kk.zdr_sshy==1?"selected='selected'":''}>邮电通讯</option>
								<option value="2" ${requestScope.icbc_kk.zdr_sshy==2?"selected='selected'":''}>房地产</option>
								<option value="3" ${requestScope.icbc_kk.zdr_sshy==3?"selected='selected'":''}>科教文卫</option>
								<option value="4" ${requestScope.icbc_kk.zdr_sshy==4?"selected='selected'":''}>工业</option>
								<option value="5" ${requestScope.icbc_kk.zdr_sshy==5?"selected='selected'":''}>银行</option>
								<option value="6" ${requestScope.icbc_kk.zdr_sshy==6?"selected='selected'":''}>证券</option>
								<option value="7" ${requestScope.icbc_kk.zdr_sshy==7?"selected='selected'":''}>保险</option>
								<option value="8" ${requestScope.icbc_kk.zdr_sshy==8?"selected='selected'":''}>商业</option>
								<option value="9" ${requestScope.icbc_kk.zdr_sshy==9?"selected='selected'":''}>机关团体</option>
								<option value="10" ${requestScope.icbc_kk.zdr_sshy==10?"selected='selected'":''}>其他</option>							
								</select> 
								</td>
               <td style="color: #5f5f6c;">电话</td>
               <td> 
               <input class="inputcss" type="text" id="jjlxr_c_tel" name="jjlxr_c_tel" value="${requestScope.icbc_kk.jjlxr_c_tel}" onmouseover="this.title=this.value" />           
               </td>
               </tr>
                <tr>
               <td style="color: #5f5f6c;">职业</td>
               <td>
               <select id="zdr_zy" name="zdr_zy" >
                                <option>请选择</option>
								<option value="0"  ${requestScope.icbc_kk.zdr_zy==0?"selected='selected'":''}>公务员</option>
								<option value="1" ${requestScope.icbc_kk.zdr_zy==1?"selected='selected'":''}>事业单位员工</option>
								<option value="2" ${requestScope.icbc_kk.zdr_zy==2?"selected='selected'":''}>工人</option>
								<option value="3" ${requestScope.icbc_kk.zdr_zy==3?"selected='selected'":''}>农民</option>
								<option value="4" ${requestScope.icbc_kk.zdr_zy==4?"selected='selected'":''}>军人</option>
								<option value="5" ${requestScope.icbc_kk.zdr_zy==5?"selected='selected'":''}>职员</option>
								<option value="6" ${requestScope.icbc_kk.zdr_zy==6?"selected='selected'":''}>私人业主</option>
								<option value="7" ${requestScope.icbc_kk.zdr_zy==7?"selected='selected'":''}>学生</option>
								<option value="8" ${requestScope.icbc_kk.zdr_zy==8?"selected='selected'":''}>自由职业</option>
								<option value="9" ${requestScope.icbc_kk.zdr_zy==9?"selected='selected'":''}>其他</option>							
								</select>
								</td>
               <td style="color: #5f5f6c;">与主贷人关系</td>
               <td> 
               <input class="inputcss" type="text"  id="jjlxr_jdrgx" name="jjlxr_jdrgx" value="${requestScope.icbc_kk.jjlxr_jdrgx }" onmouseover="this.title=this.value" />           
               </td>
               </tr>
                <tr>
                     <td style="color: #5f5f6c;">职务</td>
               <td>
               <select id="zdr_zw" name="zdr_zw" >
               <option>请选择</option>
								<option value="0" ${requestScope.icbc_kk.zdr_zw==0?"selected='selected'":''}>企业负责人</option>
								<option value="1" ${requestScope.icbc_kk.zdr_zw==1?"selected='selected'":''}>总经理</option>
								<option value="2" ${requestScope.icbc_kk.zdr_zw==2?"selected='selected'":''}>部门经理</option>
								<option value="3" ${requestScope.icbc_kk.zdr_zw==3?"selected='selected'":''}>职员</option>
								<option value="4" ${requestScope.icbc_kk.zdr_zw==4?"selected='selected'":''}>其他</option>							
								</select> </td>	
				<td style="color: #5f5f6c;">现住地址</td>
               <td> 
               <input class="inputcss" type="text" id="jjlxr_xzdz" name="jjlxr_xzdz" value="${requestScope.icbc_kk.jjlxr_xzdz}" onmouseover="this.title=this.value" />           
               </td>
               </tr>
                <tr>
         		  
               </tr>
                <tr>
               <td style="color: #5f5f6c;">工作年限</td>
               <td>
               <input class="inputcss" type="text" id="zdr_gznx" name="zdr_gznx" value="${requestScope.icbc_kk.zdr_gznx }" onmouseover="this.title=this.value" />
               <span style="margin-left:-26px;padding:3px;border:1px solid #b1bacb;border-radius: 2px;">年</span>               
               </td>
               
               </tr>
               <tr>
               <td align="center"  style="color: #f52c0b;">共借人1</td>
               <td>        
               </td>
               <td align="center"  style="color: #f52c0b;">共借人2</td>
               <td>        
               </td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">婚姻状况</td>
               <td> 
               <select id="gjr1_hyzk" name="gjr1_hyzk" >
               <option>请选择</option>
								<option  value="0" ${requestScope.icbc_kk.gjr1_hyzk==0?"selected='selected'":''}>未婚</option>
								<option value="1" ${requestScope.icbc_kk.gjr1_hyzk==1?"selected='selected'":''}>已婚</option>
								<option value="2" ${requestScope.icbc_kk.gjr1_hyzk==2?"selected='selected'":''}>离异</option>
								<option value="3" ${requestScope.icbc_kk.gjr1_hyzk==3?"selected='selected'":''}>丧偶</option>							
								</select>          
               </td>
               <td style="color: #5f5f6c;">婚姻状况</td>
               <td> 
               <select id="gjr2_hyzk" name="gjr2_hyzk" >
               <option>请选择</option>
								<option  value="0" ${requestScope.icbc_kk.gjr2_hyzk==0?"selected='selected'":''}>未婚</option>
								<option value="1" ${requestScope.icbc_kk.gjr2_hyzk==1?"selected='selected'":''}>已婚</option>
								<option value="2" ${requestScope.icbc_kk.gjr2_hyzk==2?"selected='selected'":''}>离异</option>
								<option value="3" ${requestScope.icbc_kk.gjr2_hyzk==3?"selected='selected'":''}>丧偶</option>							
								</select> 
								</td>
               </tr>
               <tr>
               <td>现住地址</td>
               <td><input class="inputcss" type="text" id="gjr1_xzdz" name="gjr1_xzdz" value="${requestScope.icbc_kk.gjr1_xzdz }" onmouseover="this.title=this.value" /></td>
               <td>现住地址</td>
               <td><input class="inputcss" type="text" id="gjr2_xzdz" name="gjr2_xzdz" value="${requestScope.icbc_kk.gjr2_xzdz }" onmouseover="this.title=this.value" /></td>
               
               </tr>
               <tr>
               <td>邮政编码</td>
               <td><input class="inputcss" type="text" id="gjr1_yzbm" name="gjr1_yzbm" value="${requestScope.icbc_kk.gjr1_yzbm }" onmouseover="this.title=this.value" /></td>
               <td>邮政编码</td>
               <td><input class="inputcss" type="text" id="gjr2_yzbm" name="gjr2_yzbm" value="${requestScope.icbc_kk.gjr2_yzbm }" onmouseover="this.title=this.value" /></td>
               
               </tr>
                <tr>
               <td>工作单位</td>
               <td><input class="inputcss" type="text" id="gjr1_gzdw" name="gjr1_gzdw" value="${requestScope.icbc_kk.gjr1_gzdw }" onmouseover="this.title=this.value" /></td>
               <td>工作单位</td>
               <td><input class="inputcss" type="text" id="gjr2_gzdw" name="gjr2_gzdw" value="${requestScope.icbc_kk.gjr2_gzdw }" onmouseover="this.title=this.value" /></td>
               
               </tr>
                <tr>
               <td>单位地址</td>
               <td><input class="inputcss" type="text" id="gjr1_dwdz" name="gjr1_dwdz" value="${requestScope.icbc_kk.gjr1_dwdz }" onmouseover="this.title=this.value" /></td>
               <td>单位地址</td>
               <td><input class="inputcss" type="text" id="gjr2_dwdz" name="gjr2_dwdz" value="${requestScope.icbc_kk.gjr2_dwdz }" onmouseover="this.title=this.value" /></td> 
               </tr>
               <tr>
               <td>文书送达地址</td>
               <td><input class="inputcss" type="text" id="gjr1_wsdz" name="gjr1_wsdz" value="${requestScope.icbc_kk.gjr1_wsdz }" onmouseover="this.title=this.value" /></td>
               <td>文书送达地址</td>
               <td><input class="inputcss" type="text" id="gjr2_wsdz" name="gjr2_wsdz" value="${requestScope.icbc_kk.gjr2_wsdz }" onmouseover="this.title=this.value" /></td>
               
               </tr>
                <tr>
               <td>与借款人关系</td>
               <td><input class="inputcss" type="text" id="gjr1_yzdrgx" name="gjr1_yzdrgx" value="${requestScope.icbc_kk.gjr1_yzdrgx }" onmouseover="this.title=this.value" /></td>
               <td>与借款人关系</td>
               <td><input class="inputcss" type="text" id="gjr2_yzdrgx" name="gjr2_yzdrgx" value="${requestScope.icbc_kk.gjr2_yzdrgx }" onmouseover="this.title=this.value" /></td>
               </tr>
               </table>              
              </div>
              </div>
              </div>
              	<div class="form-group">
				<label class="col-sm-2 control-label">相关合同:</label>
				<div class="col-sm-2">
				<div class="input-group btn btn-default" style="padding: 10px;">
				<c:if test="${empty requestScope.icbc_kk.pdf }">
				<img onclick="hzpdf('${requestScope.icbc_kk.icbc_id }')" id="pdf_image" name="pdf_image" style="width: 100px; heigth: 100px;" src="${pageContext.request.contextPath }/cskjs_css/301175241676158600.png">				
				</c:if>
				<c:if test="${!empty requestScope.icbc_kk.pdf }">
				<a target="_blank"  href="http://a.kcway.net/assess/${requestScope.icbc_kk.pdf }" >
				<img id="pdf_image" name="pdf_image" style="width: 100px; heigth: 100px;" src="${pageContext.request.contextPath }/cskjs_css/logo.png">								
				<span style="color:#dd4b39;position: absolute; top: 0; right: 0;">已生成合同</span>
				</a>
				</c:if>
	            </div>
	<div style="margin-top: 8px">
	<c:if test="${!empty requestScope.icbc_kk.pdf }">
	<a class="badge bg-red" href="http://a.kcway.net/assess/${requestScope.icbc_kk.pdf }" target="_blank" id="pdf">
	查看合同
	</a>
	<a class="badge bg-green" href="javascript:hzpdf('${requestScope.icbc_kk.icbc_id }')"  id="pdf1">
	重新生成
	</a>
	</c:if>
	<c:if test="${empty requestScope.icbc_kk.pdf }">
	<a class="badge bg-green" style="margin-left: 30px;" href="javascript:hzpdf('${requestScope.icbc_kk.icbc_id }')"  id="pdf">
	生成合同
	</a>
	</c:if>	
	</div>
	</div>
	<div class="col-sm-2">
	<div class="input-group btn btn-default" style="padding: 10px;">
	<c:if test="${!empty requestScope.icbc_kk.excel }">
	<a id="excel" name="excel" href="http://a.kcway.net/assess/${requestScope.icbc_kk.excel }"  target="_blank" >
	<img  id="" name="" style="width: 100px; heigth: 100px;" src="${pageContext.request.contextPath}/cskjs_css/logo.png">											
	<span style="font-size:12px ;color:#dd4b39;position: absolute; top: 0; right: 0;">已生成Excel,点击下载</span>
	</a>
	</c:if>
	<c:if test="${empty requestScope.icbc_kk.excel }">
	<img  id="" name="" style="width: 100px; heigth: 100px;" src="${pageContext.request.contextPath}/cskjs_css/301175241676158600.png">											
	</c:if>
	</div>
	<div style="margin-top: 8px">
	<a  class="badge bg-green" style="margin-left: 30px;" href="javascript:addexcel('${requestScope.icbc_kk.icbc_id }')" >
	生成Excel
	</a>
	</div>
	</div>
    </div>
    <script type="text/javascript">
    function addexcel(id) {
    	  $.ajax({
    		   type:'POST',   
    		   url:'${pageContext.request.contextPath}/icbc/excel.do',
    		   dataType:'json',
    		   data:{
    			   id : id
    		   },
    	  success: function(msg){
    		 if(msg.code==1){
    			alert("Excel生成成功!");
    			window.location.reload();
    		 }else{
    			alert("Excel生成失败;"+msg.message); 
    		 } 		  
    		},
  		error:function(){
  		   alert("系统错误,请稍后重试...");         
  		}
    	  });
       }
    
    function hzpdf(id) {
  	  $.ajax({
  		   type:'POST',   
  		   url:'${pageContext.request.contextPath}/icbc/ptreating.do',
  		   dataType:'json',
  		   data:{
  			   id : id
  		   },
  	  success: function(msg){
  		 if(msg.code==1){
  			alert("合同生成成功!");
  			window.location.reload();
  		 }else{
  			alert("合同生成失败;"+msg.message); 
  		 } 		  
  		},
		error:function(){
		   alert("系统错误,请稍后重试...");         
		}
  	  });
     }
    </script>
		   </div>			
		   <script type="text/javascript">
		   function ylimage(obj){
				if(obj!=0){
				var $img = $(obj),
					imgUrl = $img[0].src;
				}
				var activeIndex=0;
				var imgs = [];
				$(".img_q").each(function(i,elem){
					//alert(elem.src);
					if(obj!=0){
					if(elem.src == imgUrl){
						activeIndex=i;	
					}
					}
		imgs.push({
			url: elem.src, 
			imgHeight :'820',
			imgWidth : '900'
		});
	});
localStorage["photoGalleryImgs"] = JSON.stringify(imgs); //因为此字符串可能是base64字符，appgo无法传
localStorage["photoGalleryActiveIndex"] = activeIndex; 
	   //给iframe加上src路径
    $("#J_pg").attr("src","jquery-photo-gallery/gallerys.jsp");
     //显示模态框  只有在选择编辑的行   然后根据回调函数成功后才会显示模态框
    $('#myModal1').modal({ show: true, backdrop: 'static' });
}
</script> 
	<div class="box-body">
<div style="width: 85%;" class="box-header with-border">
<h3 align="center" style="margin-right:30px;">相关审核</h3>
<a href="downloadFiles_all.do?type=kk&id=${requestScope.id }" class="btn btn-success" style="margin-left:100px">一键下载所有图片</a>
<a onclick="ylimage('0')" class="btn btn-success">一键预览所有图片</a>
</div>
<script type="text/javascript">
function imgrotate(imgpath,fr) {
	  $.ajax({
		   type:"post",   
		   url:"icbc_img.do",
		   data:{
			   imgpath : imgpath,
			   fr : fr
		   },
	  success: function(msg){
		  window.location.reload();
		},
		error:function(){
		       alert("系统错误,请稍后重试...");         
		    }
	  });
}
</script>
			<div class="form-group" style="width: 85%;">
				<div class="col-sm-12" style="margin-left:100px; margin-top: 50px;">
					<div class="row inline-from">
					
					<%
				    Map m=(Map)request.getAttribute("imgname");
				    int i=1;
				    Random a = new Random(); 
				    %>					    
				    <c:if test="${!empty requestScope.imgs }">					                   
                    <c:forEach var="imgs" items="${requestScope.imgs }">
                    <c:if test="${!empty imgs}">
						<div class="col-sm-2" style="margin:20px 10px;text-align: center;">
							
							<img onclick="ylimage(this)" class="img_q aligncenter" id="" name="" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="http://a.kcway.net/assess/${imgs}">
							
							<div class="col-sm-12">		
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="javascript:imgrotate('${imgs}','1');">左转</a> 					
					        <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="downloadFile.do?fileUrl=http://a.kcway.net/assess/${imgs}&fileName=<%=a.nextInt(10000) %>">下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="javascript:imgrotate('${imgs}','2');">右转</a>   
						    <br>
						    <%
						    if(i>9){						    							    
						    %>
						    <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="http://a.kcway.net/assess/${imgs}" target="_blank"><%=m.get(10) %></a>						     						    
						    <%
						    }else{
						    %>
						    <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="http://a.kcway.net/assess/${imgs}" target="_blank"><%=m.get(i) %></a>						     						    
						    <%} %>
						    </div>
					    </div>
					</c:if>
					<c:if test="${empty imgs}">
						<div class="col-sm-2" style="margin:20px 10px;text-align: center;">
							<a  href="javascript:void(0)">
							<img class="img_q aligncenter" id="" name="" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png">
							</a>
							<div class="col-sm-12">	
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="javascript:void(0)">左转</a>   
						    						
					        <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="javascript:void(0)">右转</a>   
						    <br>
						    <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)" ><%=m.get(i) %></a>						     
						    </div>
					    </div>
					</c:if>
					<%i++; %>
					</c:forEach>
					</c:if>
					<c:if test="${empty requestScope.imgs }">
					<%
					for(int is=1;is<=9;is++){
					%>
					<div class="col-sm-2" style="margin:20px 10px;text-align: center;">
							<a  href="javascript:void(0)">
							<img class="img_q aligncenter" id="" name="" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png">
							</a><div class="col-sm-12">		
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="javascript:void(0)">左转</a>					
					        <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning"  id="" href="javascript:void(0)">右转</a>   
						    <br>
						    <a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)" ><%=m.get(is) %></a>						     
						    </div>
					</div>
					<%} %>
					</c:if>
					</div>
					</div>



</div>

  		<div id="section6" class="box-header with-border" style="width: 85%">
	<h3 align="center" >审核处理</h3>
    </div>
<div class="box-body">
	<div class="form-group">
	<label class="col-sm-2 control-label">审核：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
				<div class="col-sm-4">
					<div class="input-group"><span class="input-group-addon">审核状态</span> 
					<select name="bc_status" class="form-control" id="bc_status" onchange="autoremark();">
                            	<option value="0">请选择</option>
                            	<option value="1"  ${requestScope.icbc_kk.bc_status==1?"selected='selected'":''}>草稿箱</option>
                            	<option value="2"  ${requestScope.icbc_kk.bc_status==2?"selected='selected'":''}>身份核查中</option>
                            	<option value="3"  ${requestScope.icbc_kk.bc_status==3?"selected='selected'":''}>开卡审核中</option>
                            	<option value="4"  ${requestScope.icbc_kk.bc_status==4?"selected='selected'":''}>回退补件</option>
                            	<option value="5"  ${requestScope.icbc_kk.bc_status==5?"selected='selected'":''}>申请失败</option>                            
                            	<option value="6"  ${requestScope.icbc_kk.bc_status==6?"selected='selected'":''}>撤销</option>  
                            	<option value="7"  ${requestScope.icbc_kk.bc_status==7?"selected='selected'":''}>申请成功</option>
                            	<option value="8"  ${requestScope.icbc_kk.bc_status==8?"selected='selected'":''}>电审回退(兼容旧版本)</option>                                                      	
                            	<option value="9"  ${requestScope.icbc_kk.bc_status==9?"selected='selected'":''}>开卡完成</option> 
                            	</select>
                            	</div>
			</div>
			<div class="col-sm-4">
					<div class="input-group"><span class="input-group-addon">开卡卡号</span> 
					<input id="kk_kh" name="kk_kh"  class="form-control"  value="${requestScope.icbc_kk.kk_kh }" type="text"></div>
			</div>
            <div class="col-sm-3">
					<div class="input-group">
					<span class="input-group-addon">类型</span> 
					<input class="form-control" readonly="" value="开卡" type="text"></div>
			</div>
		  </div>
	  </div>
	</div>
	<div class="form-group">
				<label class="col-sm-2 control-label">上传PDF文档:</label>
				<div class="col-sm-4">
				<div class="input-group btn btn-default" style="padding: 10px;">
				<c:if test="${empty requestScope.icbc_kk.pdfstep4_1 }">
				<img id="result_pdf_view" name="result_pdf_view" style="width: 100px; heigth: 100px;" src="${pageContext.request.contextPath }/cskjs_css/301175241676158600.png">				
				</c:if>
				<c:if test="${!empty requestScope.icbc_kk.pdfstep4_1 }">
				<img id="result_pdf_view" name="result_pdf_view" style="width: 100px; heigth: 100px;" src="${pageContext.request.contextPath }/cskjs_css/logo.png">								
				<span style="color:#dd4b39;position: absolute; top: 0; right: 0;">已上传报告</span>
				</c:if>
				<input id="result_pdf" name="result_pdf" value="" type="hidden"> 
<input id="upload_result_pdf" name="upload_result_pdf" accept="application/pdf" style="position: absolute; ; left: 1px; top: 1px; width: 100px; height: 100px; opacity: 0;" type="file">
<script>
//要求必须 jquery2.0 以上,因为 fileup 函数中用到了 .off().on()
$('#upload_result_pdf').on('change',function (){	
	//alert(txt+"--"+size);
	var formData = new FormData();
    formData.append("pdf", document.getElementById("upload_result_pdf").files[0]); 
    formData.append("id", document.getElementById("id").value);    
    $.ajax({
        url: "icbc_pdf.do",
        type: "POST",
        data: formData,
        /**
        *必须false才会自动加上正确的Content-Type
        */
        contentType: false,
        /**
        * 必须false才会避开jQuery对 formdata 的默认处理
        * XMLHttpRequest会对 formdata 进行正确的处理
    	* window.location.reload();	
        */
        processData: false,
        success: function (msg) {
           alert("上传成功");
           window.location.reload();
        },
		error:function(){
	       alert("上传失败，请稍后重试...");         
	    }
    });
})
</script>
</div>
	<div style="margin-left: 30px;margin-top: 8px">
	<c:if test="${!empty requestScope.icbc_kk.pdfstep4_1 }">
	<a class="badge bg-red" href="http://a.kcway.net/assess/${requestScope.icbc_kk.pdfstep4_1 }" target="_blank" id="lblresult_pdf">
	查看报告
	</a>
	</c:if>
	<c:if test="${empty requestScope.icbc_kk.pdfstep4_1 }">
	<a class="badge bg-red" href="javascript:void(0)"  id="lblresult_pdf">
	上传报告
	</a>
	</c:if>	
	</div>
	</div>
   </div>
	<div class="form-group"><label class="col-sm-2 control-label">留言备注说明：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
				<div class="col-sm-4">
				<div class="input-group">
				<span class="input-group-addon">审核留言</span>
				<textarea style="width: 100%; height: 40px" class="form-control" name="remark" id="remark"></textarea>
				</div>
			    </div>
				<div class="col-sm-4">
					<div class="input-group">
					<span class="input-group-addon">留言快速通道</span> 
					<select class="form-control" id="cyly" onchange="setremark(this)">
					<option value="请选择" selected="selected">请选择</option>						
					<option value="查询完成，详情请点击历史查询-&gt;已完成-&gt;查看订单！">查询完成，详情请点击历史查询-&gt;已完成-&gt;查看订单！</option>						
					<option value="恭喜您初审通过,请点编辑按钮,按提示上传其他补充材料！">恭喜您初审通过,请点编辑按钮,按提示上传其他补充材料！</option>						
					<option value="请提供行驶证与驾照正面照片！">请提供行驶证与驾照正面照片！</option>						
					<option value="请上传正确的行驶证照片">请上传正确的行驶证照片</option>						
					<option value="行驶证错误，要的是信息页。车牌车架发动机号页面">行驶证错误，要的是信息页。车牌车架发动机号页面</option>						
					<option value="行驶证要上传信息页面，上传后面一页无法识别。">行驶证要上传信息页面，上传后面一页无法识别。</option>						
					<option value="提交材料过于模糊，无法识别">提交材料过于模糊，无法识别</option>						
					<option value="请 上传行驶证">请 上传行驶证</option>						
					<option value="请上传完整的行驶证驾驶证照片">请上传完整的行驶证驾驶证照片</option>						
					</select></div>
			</div>
		</div>
	</div></div>
<div class="form-group">
<label class="col-sm-2 control-label">历次审核事件和留言：</label>
<div class="col-sm-10">
<textarea style="width: 80%; height: 200px" class="form-control" readonly="readonly">
<c:forEach items="${requestScope.iResults }" var="il">${fn:substring(il.dt_add,0,19)}:状态：${il.statusremark},留言：${il.remark }
</c:forEach>
</textarea>
</div>
</div>
</div>	
</div>
		<div class="footer-wrap">
			<div class="box-footer" style="margin-left:-50px;">
				<button type="button" class="btn btn-default" onclick="location.href='kjs_kk.do?out=1&id=${requestScope.id}&querytype=${requestScope.querytype}&size=${requestScope.size}&status=${requestScope.status}'">取消返回</button>
				<button type="button" style="margin-right: 70px;" onclick="kkup();" class="btn btn-primary pull-right">保存提交</button> 
			</div>
		</div>	
</form>
		<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" align="center" id="myModalLabel">图片预览</h4>
            </div>
            <div class="modal-body" style="height:750px;" >
            <iframe id="J_pg" width="100%" height="100%" frameborder="0"></iframe>
            (左右键控制上一张,下一张)
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>