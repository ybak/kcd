<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<style>
.row {
	padding:0 20px;
	margin-top:15px;
}
.row label{
	padding:0;
}
.modal-body{
	border:1px solid #ccc;
	background-color:#F7F7F7;
	border-radius: 10px;             
	margin-top:10px;  
}
</style>

	<div class="content-wrapper" style="min-height: 943px;padding-right:30px; padding-left: 30px;">
		<div style="margin-top:10px; display:flex; justify-content: space-between;">
	      <h4 class="modal-title" >客户信息:</h4>
	      <div style="display: inline-flex;">   
		      <h4 style="line-height:30px">操作选项:</h4>	
		     <!--   <image src="./../image/smcs.png" title="申请上门催收" style="height:30px;width:25px;margin-left:10px;"></image> --> 
		      <image src="./../image/sqtc.png" title="申请拖车" style="height:30px;width:25px;margin-left:35px;" onclick="appCar(1)"></image>  
		      <image src="./../image/sqss.png" title="申请诉讼" style="height:30px;width:25px;margin-left:40px;" onclick="appCar(2)"></image>  
	      </div>	  
	    </div>
	    <div class="modal-body">
		    <div class="row" >
		    	<label class="col-sm-1" >订单编号:<i class="red">*</i></label>
		  		<div class="col-sm-2">
		  			${CCL.gems_code}
			    </div>
			    <label class="col-sm-1">主贷人姓名:<i class="red">*</i></label>
				<div class="col-sm-2">
		      		${CCL.c_name }
				</div>
				<label class="col-sm-1" >电话:<i class="red">*</i></label>
		  		<div class="col-sm-2">
					${CCL.c_tel }
			    </div>
			     <label class="col-sm-1" >身份证:<i class="red">*</i></label>
				<div class="col-sm-2">
					${CCL.c_cardno }
				</div> 
			</div>
			<div class="row">
		    	<label class="col-sm-1" >业务员::<i class="red">*</i></label>
		  		<div class="col-sm-2">
		  			${CCL.gems_name }
			    </div>
			    <label class="col-sm-1">代理团队:<i class="red">*</i></label>
				<div class="col-sm-2">
		      		${CCL.fs_name }
				</div>
				<label class="col-sm-1" >现住地址:<i class="red">*</i></label>
		  		<div class="col-sm-2">
					${CCL.zdr_xzdz }
			    </div>
			     <label class="col-sm-1" >单位名称:<i class="red">*</i></label>
				<div class="col-sm-2">
					${CCL.zdr_gzdw }
				</div> 
			</div>
			<div class="row" >
		    	<label class="col-sm-1" >单位电话:<i class="red">*</i></label>
		  		<div class="col-sm-2">
		  			${CCL.zdr_dwdh }
			    </div>
			    <label class="col-sm-1">单位地址:<i class="red">*</i></label>
				<div class="col-sm-2">
		      		${CCL.zdr_dwdz }
				</div> 
			</div>
		</div>
		
		<div  style="padding-top:20px;">
	      <h4 class="modal-title"  id="aayyclModalLabel">车辆信息:</h4>	       
	    </div>	  	
	    <div class="modal-body">
		    <div class="row" >
		    	<label class="col-sm-1" >车辆价格:<i class="red">*</i></label>
		  		<div class="col-sm-2">
		  			${CCL.price_new}
			    </div>
			    <label class="col-sm-1">评估价格:<i class="red">*</i></label>
				<div class="col-sm-2">
					${CCL.price_result}
				</div>
				<label class="col-sm-1" >品牌:<i class="red">*</i></label>
		  		<div class="col-sm-2">
					${CCL.car_brand}
			    </div>
			     <label class="col-sm-1" >车辆型号:<i class="red">*</i></label>
				<div class="col-sm-2">
					${CCL.car_name}
				</div> 
			</div>
	
			<div class="row" >
		    	<label class="col-sm-1" >车辆类型:<i class="red">*</i></label>
		  		<div class="col-sm-2">
		  		    <!-- 1新车，2二手车 -->
		  			${CCL.cars_type==1?'新车':'二手车'}
			    </div>
			    <label class="col-sm-1">车架号:<i class="red">*</i></label>
				<div class="col-sm-2">
		      		${CCL.vincode}
				</div>
				<label class="col-sm-1" >发动机号:<i class="red">*</i></label>
		  		<div class="col-sm-2">
					${CCL.motorcode}
			    </div>
			     <label class="col-sm-1" >车牌:<i class="red">*</i></label>
				<div class="col-sm-2">
					${CCL.c_carno}
				</div> 
			</div>
			
			<div class="row" >
		    	<label class="col-sm-1" >颜色:<i class="red">*</i></label>
		  		<div class="col-sm-2">
		  			${CCL.color_id}
			    </div>
			</div>
		</div>
		
		<div style="padding-top:20px;">
	      <h4 class="modal-title"  id="aayyclModalLabel">贷款方案:</h4>	       
	    </div>	
	    
	    
	     <div class="modal-body">
		    <div class="row" >
		    	<label class="col-sm-1" >车辆价格:<i class="red">*</i></label>
		  		<div class="col-sm-2">
		  			${CCL.price_new}
			    </div>
			    <label class="col-sm-1">业务产品名称:<i class="red">*</i></label>
				<div class="col-sm-2">
		      		${CCL.loan_tpid==1?'卡分期':'汽车分期'}
				</div>
				<label class="col-sm-1" >贷款银行:<i class="red">*</i></label>
		  		<div class="col-sm-2">
					${CCL.bank_name}
			    </div>
			     <label class="col-sm-1" >执行利率:<i class="red">*</i></label>
				<div class="col-sm-2">
					${CCL.dk_lv}
				</div> 
			</div>
	
			<div class="row" >
		    	<label class="col-sm-1" >首付金额:<i class="red">*</i></label>
		  		<div class="col-sm-2">
		  			${CCL.sfje}
			    </div>
			    <label class="col-sm-1">实际贷款额:<i class="red">*</i></label>
				<div class="col-sm-2">
		      		${CCL.dk_total_price}
				</div>
				<label class="col-sm-1" >首付比例:<i class="red">*</i></label>
		  		<div class="col-sm-2">
					--
			    </div>
			     <label class="col-sm-1" >贷款期数:<i class="red">*</i></label>
				<div class="col-sm-2">
					${CCL.aj_date}
				</div>
			</div>
			
			<div class="row" >
		    	<label class="col-sm-1" style="" >银行分期本金:<i class="red">*</i></label>
		  		<div class="col-sm-2">
		  			--
			    </div>
			    <label class="col-sm-1">金融服务费:<i class="red">*</i></label>
				<div class="col-sm-2">
		      		${CCL.jrfw_price }
				</div>
				<label class="col-sm-1" >本息合计:<i class="red">*</i></label>
		  		<div class="col-sm-2">
		  			--
			    </div>
			</div>
		</div>

		<div style="padding-top:20px;">
	      <h4 class="modal-title">还款计划表:</h4>
	    </div>
	    <div class="box" style="margin-top:10px;">
			<!-- 数据载入中结束 -->
			<table class="table table-bordered table-hover">
	    	<tr>
				<th class="text-center">还款期数</th>
				<th class="text-center">应还日期</th>
				<th class="text-center">应还金额</th>
				<th class="text-center">实还日期</th>
				<th class="text-center">实还金额</th>
				<th class="text-center">是否逾期</th>
				<th class="text-center">逾期金额</th>
				<!-- <th class="text-center">核销日期</th> -->
			</tr>		   
			<c:forEach items="${paySchedule}" var="map"  varStatus="status">
			<tr>
				<td class="text-center">${map.overdue_which}</td>
				<td class="text-center">${map.should_date }</td>
				<td class="text-center">${map.should_money}</td>
				<td class="text-center">${map.practical_date}</td>
				<td class="text-center">${map.practical_money}</td>
				<td class="text-center">
				<c:if test="${map.overdue_status == 1 }">
				是
				</c:if>
				<c:if test="${map.overdue_status == 2 }">
				否
				</c:if>
				</td>
				<td class="text-center">${map.overdue_money}</td>
				<%-- <td class="text-center">${map.hx_date }</td> --%>
		    </tr>
		    </c:forEach>
       </table>
	  </div>
	  <form id="form1" onsubmit="return false" action="##"  method="post">
		  <div style="margin-top:10px;">
		      <h4 class="modal-title">电催录入栏:</h4>	      
		      <textarea style="border:1px solid #ccc;margin-top:10px;height:120px" id="result_msg" name="result_msg" class="form-control"></textarea>		
		  </div>
		  <div style="height:50px;margin:20px 0 0 0;">
		  	 <button type="button" class="btn btn-info search-btn" style="float:right" onclick="addPhoneResult()">提交</button>
		  </div>
	  </form>
	  <div style="">
	  	<div style="display: flex;">
	      <h4 class="modal-title" style="margin-bottom: 10px;">记录栏:</h4>					
		  
		  </div>		
	      	<!-- <textarea style="border:1px solid #ccc; height:200px;margin-top:10px;" class="form-control"></textarea> -->
	      	<div id="main_list" class="admin-content box">
			<!-- 数据载入中 请在搜索，筛选，载入的时候显示 放在.box里 -->
			<div class="overlay" style="display:none;">
				<i class="fa fa-refresh fa-spin"></i>
			</div>
			<!-- 数据载入中结束 -->
			<table class="table table-bordered table-hover">
				<tbody>	
					<tr>
						<th style="width:3%" class="text-center hidden-xs"><input class="check_all" type="checkbox"></th>
						<th class="text-center hidden-xs">序号</th>
						<th class="text-center hidden-xs">记录时间</th>
						<th class="text-center">记录类型</th>
						<th class="text-center">操作人员</th>
						<th class="text-center">记录查看</th> 
						<!-- <th class="text-center">查看</th>  -->
					</tr>
					<c:forEach items="${results}" var="results" varStatus="status">
					<tr>
						<td class="text-center hidden-xs"><input name="delid"  type="checkbox"></td>
						<td class="text-center">${status.index+1}</td>
						<td class="text-center">${fn:substring(results.dt_add,0,19)}</td>
						<td class="text-center">
							<span class="s-font-blue">
								<c:if test="${results.type_id eq 2}">电催</c:if>
								<c:if test="${results.type_id eq 3 }">拖车</c:if>
								<c:if test="${results.type_id eq 4 }">诉讼</c:if>
								<c:if test="${results.type_id eq 5 }">拍卖</c:if>
								<c:if test="${results.type_id eq 6 }">结清</c:if>
							</span>
						</td>
						<td class="text-center">${results.gems_name}</td>
						<td class="text-center">${results.result_msg}</td>
						<%-- <td class="text-center"><i class="fa fa-search-plus" onclick="toggleModel('${results.id}')"></i></td> --%>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>	
	  </div>
	  <script>
			function toggleModel(a){
				 $.ajax({
					type: "POST",
			        url: "${pageContext.request.contextPath }/electricityController/selectjll.do",
			        data: {id:a},	       
			        success:function(data){ 
			        	$('#myModal').modal({ show: true });
			        	$('#motaikuang').html(data.value);
			        },
			        error: function (data) {
			            alert("编辑失败...请稍后重试！");
			        }
				}) 
			}
	</script>
	<!-- 模态框 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="addModal_nstrLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title">电催记录栏</h4>
	            </div>
	            <div id="motaikuang" class="modal-body" style="border:1px solid #ccc;background-color:#F7F7F7;border-radius: 10px;margin:30px;">
	             	<!-- 模态框插入内容 start -->
	  	
					
				 <!-- 模态框插入内容 end -->
				</div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div>
	    </div>
	</div>
</div>

<script type="text/javascript">
function appCar(clickType){
	if(clickType==1){//
		var type_id = 3;
		var type_status = 31;
		var result_msg = "开始申请拖车";
	}else if(clickType==2){
		var type_id = 4;
		var type_status = 41;
		var result_msg = "开始申请诉讼";
	}
	var icbc_id = ${pdOne.icbc_id};
	var lolId = ${pdOne.id};
	//alert(icbc_id+"--"+lolId+"--"+type_id+"--"+type_status+"--"+result_msg);
	$.ajax({
		type: "POST",
        url: "${pageContext.request.contextPath}/loan/updatePhoneStatusToCarOrLitigation.do",
        data:{
        	result_msg:result_msg,
        	type_id:type_id,
        	type_status:type_status,
        	icbc_id:icbc_id,
        	lolId:lolId
       	},
        success:function(data){  
        	alert(data);
			//location.reload(true);
			location.href="${pageContext.request.contextPath}/loan/selectPhoneList.do?type_id=2&type_status=0&type=dczy&dn=loan_phone&qn=list&pagesize=10&pagenow=1";
        }
        
	})
}

function addPhoneResult(){
	var result_msg = $('#result_msg').val();
	//alert(result_msg);
	if(result_msg==''){
		alert("请在录入栏填写信息!");
		return false;
	}
	var type_id = ${pdOne.type_id};
	var type_status = ${pdOne.type_status};
	var icbc_id = ${pdOne.icbc_id};
	var lolId = ${pdOne.id};
	//alert(lolId+"--"+icbc_id+"--"+type_status+"--"+type_id+"--");
	$.ajax({
		type: "POST",
        url: "${pageContext.request.contextPath}/loan/addPhoneResult.do",
        data:{
        	result_msg:result_msg,
        	type_id:type_id,
        	type_status:type_status,
        	icbc_id:icbc_id,
        	lolId:lolId
       	},
        success:function(data){  
        	alert(data);
            location.reload(true);
        }
	})
}
</script>			
