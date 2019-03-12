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
		<script type="text/javascript">
    
    
    function tk(){
    	alert("正在处理")
    }
    function login(){    	
    	$.ajax({
    		type: "POST",
            url: "${pageContext.request.contextPath }/settleController/add.do?icbc_id=${grxxMap.id}",
            
            data: $('#form1').serialize(),
            success:function(data){
            		                 
                    location.reload(true);
            }
    	})
    }
    
    </script>
		<div style="margin-top:10px; display:flex; justify-content: space-between;">
	      <h4 class="modal-title" >客户信息:</h4>	  
	    </div>
	    
	    <div class="modal-body">
		    <div class="row" >
		    	<label class="col-sm-1" >订单编号:<i class="red">*</i></label>
		  		<div class="col-sm-2">
		  			${grxxMap.gems_code }
			    </div>
			    <label class="col-sm-1">主贷人姓名:<i class="red">*</i></label>
				<div class="col-sm-2">
		      		${grxxMap.c_name }
				</div>
				<label class="col-sm-1" >电话:<i class="red">*</i></label>
		  		<div class="col-sm-2">
					${grxxMap.c_tel }
			    </div>
			     <label class="col-sm-1" >身份证:<i class="red">*</i></label>
				<div class="col-sm-2">
					${grxxMap.c_cardno }
				</div> 
			</div>
			<div class="row">
		    	<label class="col-sm-1" >业务员:<i class="red">*</i></label>
		  		<div class="col-sm-2">
		  			${grxxMap.gems_name }
			    </div>
			    <label class="col-sm-1">代理团队:<i class="red">*</i></label>
				<div class="col-sm-2">
		      		${grxxMap.name }
				</div>
				<label class="col-sm-1" >现住地址:<i class="red">*</i></label>
		  		<div class="col-sm-2">
					${grxxMap.zdr_xzdz }
			    </div>
			     <label class="col-sm-1" >单位名称:<i class="red">*</i></label>
				<div class="col-sm-2">
					${grxxMap.zdr_gzdw }
				</div> 
			</div>
			<div class="row" >
		    	<label class="col-sm-1" >单位电话:<i class="red">*</i></label>
		  		<div class="col-sm-2">
		  			${grxxMap.zdr_dwdh }
			    </div>
			    <label class="col-sm-1">单位地址:<i class="red">*</i></label>
				<div class="col-sm-2">
		      		${grxxMap.zdr_dwdz }
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
		  			${clxxMap.kp_price }
			    </div>
			    <label class="col-sm-1">评估价格:<i class="red">*</i></label>
				<div class="col-sm-2">
		      		${clxxMap.price_result }
				</div>
				<label class="col-sm-1" >品牌:<i class="red">*</i></label>
		  		<div class="col-sm-2">
					
			    </div>
			     <label class="col-sm-1" >车辆型号:<i class="red">*</i></label>
				<div class="col-sm-2">
					
				</div> 
			</div>
	
			<div class="row" >
		    	<label class="col-sm-1" >车辆类型:<i class="red">*</i></label>
		  		<div class="col-sm-2">
		  			<c:if test="${clxxMap.cars_type == '1'}">
								新车
					</c:if>
					<c:if test="${clxxMap.cars_type == '0'}">
								二手车
					</c:if>
			    </div>
			    <label class="col-sm-1">车架号:<i class="red">*</i></label>
				<div class="col-sm-2">
		      		${clxxMap.carvin }
				</div>
				<label class="col-sm-1" >发动机号:<i class="red">*</i></label>
		  		<div class="col-sm-2">
					${clxxMap.motorcode }
			    </div>
			     <label class="col-sm-1" >车牌:<i class="red">*</i></label>
				<div class="col-sm-2">
					${clxxMap.carno }
				</div> 
			</div>
			
			<div class="row" >
		    	<label class="col-sm-1" >颜色:<i class="red">*</i></label>
		  		<div class="col-sm-2">
		  			暂无
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
		  			${dkfaMap.kp_price }
			    </div>
			    <label class="col-sm-1">业务产品名称:<i class="red">*</i></label>
				<div class="col-sm-2">
		      		
				</div>
				<label class="col-sm-1" >贷款银行:<i class="red">*</i></label>
		  		<div class="col-sm-2">
					${dkfaMap.y_name }
			    </div>
			     <label class="col-sm-1" >执行利率:<i class="red">*</i></label>
				<div class="col-sm-2">
					${dkfaMap.dk_lv }
				</div> 
			</div>
	
			<div class="row" >
		    	<label class="col-sm-1" >首付金额:<i class="red">*</i></label>
		  		<div class="col-sm-2">
		  			${dkfaMap.sfje }
			    </div>
			    <label class="col-sm-1">实际贷款额:<i class="red">*</i></label>
				<div class="col-sm-2">
		      		${dkfaMap.dk_total_price }
				</div>
				<label class="col-sm-1" >首付比例:<i class="red">*</i></label>
		  		<div class="col-sm-2">
					
			    </div>
			     <label class="col-sm-1" >贷款期数:<i class="red">*</i></label>
				<div class="col-sm-2">
					${dkfaMap.aj_date }
				</div> 
			</div>
			
			<div class="row" >
		    	<label class="col-sm-1" style="" >银行分期本金:<i class="red">*</i></label>
		  		<div class="col-sm-2">
		  			
			    </div>
			    <label class="col-sm-1">金融服务费:<i class="red">*</i></label>
				<div class="col-sm-2">
		      		${dkfaMap.jrfw_price }
				</div>
				<label class="col-sm-1" >本息合计:<i class="red">*</i></label>
		  		<div class="col-sm-2">
					${dkfaMap.bxhj }
			    </div>
			     <label class="col-sm-1" >首月还款:<i class="red">*</i></label>
				<div class="col-sm-2">
					
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
					<th class="text-center">实还金额</th>
					<th class="text-center">是否逾期</th>
					<th class="text-center">逾期金额</th>
					<th class="text-center">核销日期</th>
				</tr>
			   <c:forEach var="map" items="${scheduleMap }" varStatus="status">
				<tr>
					<td class="text-center">${status.index+1 }</td>
					<td class="text-center">${fn:substring(map.should_date,0,19)}</td>
					<td class="text-center">${map.should_money}</td>
					<td class="text-center">${map.practical_money}</td>
					<td class="text-center">
					<c:if test="${map.overdue == 1}">
						是
					</c:if>
					<c:if test="${map.overdue == 0}">
						否
					</c:if>
					</td>
					<td class="text-center">${map.overdue_money}</td>
					<td class="text-center">暂无</td>
			    </tr>
			   </c:forEach>
	       </table>
	  </div>
	  <form id="form1" onsubmit="return false" action="##" method="post">
	  <div style="margin-top:10px;">
	      <h4 class="modal-title">结清录入栏:</h4>	      
	      <textarea style="border:1px solid #ccc;margin-top:10px;height:150px" id="value" name="value" class="form-control"></textarea>		
	  </div>
	  <div style="height:50px;margin:20px 0 0 0;">
	  	 <button type="button" class="btn btn-info search-btn" style="float:right" onclick="login()">提交</button>
	</div>
 </form> 

	  <div style="">
	  	<div style="display: flex;">
	      <h4 class="modal-title" style="margin-bottom: 10px;">记录栏:</h4>					
		  <div class="foot-page" style="margin: -8px 10px;">			
				<ul class="pagination no-margin">				       
				    <li><a href="#" aria-label="Next"><span aria-hidden="true">上一页</span></a></li>				  
					<li><a href="#" aria-label="Next"><span aria-hidden="true">下一页</span></a></li>  				
				</ul>
	   
			</div>  
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
						<th class="text-center hidden-xs">日期时间</th>
						<th class="text-center">记录类型</th>
						<th class="text-center">操作人员</th>
						<!-- <th class="text-center">查看</th> -->
					</tr>
					<c:forEach items="${inputMap }" var="inputMap" varStatus="status">
					<tr>
						<td class="text-center hidden-xs">
						<input name="delid"  type="checkbox">
						</td>
						<td class="text-center hidden-xs">
							${status.index+1 }
						</td>
						<td class="text-center hidden-xs">
							${fn:substring(inputMap.present_date,0,19) }
						</td>
						<td class="text-center">
							<span class="s-font-blue">
							<c:if test="${inputMap.type_id eq 0 }">
								电催
							</c:if>
							<c:if test="${inputMap.type_id eq 1 }">
								拖车
							</c:if>
							<c:if test="${inputMap.type_id eq 2 }">
								诉讼
							</c:if>
							<c:if test="${inputMap.type_id eq 3 }">
								结清
							</c:if>	
							</span>
						</td>
						<td class="text-center">
							${pd.name }
						</td>
						<!-- <td class="text-center">
							<p>
								<i class="fa fa-search-plus" onclick="toggleModel()"></i>
							</p>
						</td> -->

					</tr>
					</c:forEach>
					
					
				</tbody>
			</table>
		</div>	
	  </div>
	  
	  <script>
	function text(){
		$('#entry').val();
	}
	</script>
	<!-- 模态框 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="addModal_nstrLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title">结清记录栏</h4>
	            </div>
	            <div class="modal-body" style="border:1px solid #ccc;background-color:#F7F7F7;border-radius: 10px;margin:30px;">
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
			
