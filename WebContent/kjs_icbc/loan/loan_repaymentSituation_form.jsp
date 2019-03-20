<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
.row label{
	padding:0;
}
.content-wrapper .row {
	padding:10px 20px 0px 20px;
}
.modal-body{
	border:1px solid #ccc;
	background-color:#F7F7F7;
	border-radius: 10px;             
	margin-top:10px;  
}
::-webkit-scrollbar {
	display: none; /* 隐藏滚动条 */
}
/* 模态框里面的样式 */
.fade .row{
	padding-top:25px;
	margin:0 15px;
}
.fade .row label{
	color:#1F70B6
}
</style>
<div class="content-wrapper" style="min-height: 943px;padding-right:30px; padding-left: 30px;">
	<div  style="padding-top:20px;">
      <h4 class="modal-title"  id="aayyclModalLabel">业务状态:</h4>	       
    </div>	
   <div class="modal-body">
	    <div class="row" >
	    	<label class="col-sm-1"  >主贷人姓名:<i class="red">*</i></label>
	  		<div class="col-sm-2">
	  			${lborrow.c_name }
		    </div>
		    <label class="col-sm-1">身份证号:<i class="red">*</i></label>
			<div class="col-sm-2">
	      		${lborrow.c_cardno }
			</div>
			<label class="col-sm-1" >金融产品:<i class="red">*</i></label>
	  		<div class="col-sm-2">
				<c:if test="${lborrow.loan_tpid==1}">
								  卡分期
				</c:if>
		    </div>
		     <label class="col-sm-1" >车辆评估价格:<i class="red">*</i></label>
			<div class="col-sm-2">
				${lborrow.price_result}
			</div> 
		</div>
		<div class="row">
	    	<label class="col-sm-1" >贷款金额:<i class="red">*</i></label>
	  		<div class="col-sm-2">
	  			${lborrow.dk_total_price}
		    </div>
		    <label class="col-sm-1">贷款期数:<i class="red">*</i></label>
			<div class="col-sm-2">
	      		${lborrow.aj_date}
			</div>
			<label class="col-sm-1" >每月应还:<i class="red">*</i></label>
	  		<div class="col-sm-2">
				${lborrow.myyh}
		    </div>
		    <label class="col-sm-1">贷款银行:<i class="red">*</i></label>
			<div class="col-sm-2">
	      		${lborrow.y_name}
			</div>
		    <%-- <label class="col-sm-1" >还款日期:<i class="red">*</i></label>
			<div class="col-sm-2">
				${lborrow.dt_edit}
			</div> --%>
		</div>
		<div class="row" >
	    	<!-- <label class="col-sm-1" >是否结清:<i class="red">*</i></label>
	  		<div class="col-sm-2">
	  			暂时无此数据
		    </div> -->
			<!-- <label class="col-sm-1">已还期数:<i class="red">*</i></label>
	  		<div class="col-sm-2">
				1
		    </div> -->
		</div>
	</div>
	
	
	<div  style="padding-top:20px;">
      <h4 class="modal-title"  id="aayyclModalLabel">还款计划:</h4>	       
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
			<c:forEach items="${mapschedule}" var="map"  varStatus="status">
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
    
    <div  style="padding-top:20px;">
      <h4 class="modal-title"  id="aayyclModalLabel">贷后信息:</h4>	       
    </div>	
    <div class="box" style="margin-top:10px;">
		<!-- 数据载入中结束 -->
		<table class="table table-bordered table-hover">
	    	<tr>
				<th class="text-center">贷款类型</th>
				<th class="text-center">姓名</th>
				<th class="text-center">身份证号</th>
				<th class="text-center">与主贷人关系</th>
				<th class="text-center">银行征信</th>
				<th class="text-center">大数据征信</th>
				<th class="text-center">电话号码</th>
				<th class="text-center">操作</th>
			</tr>
			
		  	<tr>
				<td class="text-center">主贷人</td>
				<td class="text-center">${lborrow.c_name}</td>
				<td class="text-center">${lborrow.c_cardno}</td>
				<td class="text-center">本人</td>
				<td class="text-center"><i class="fa fa-search-plus"></i></td>
				<td class="text-center"><i class="fa fa-search-plus"></i></td>
				<td class="text-center">${lborrow.c_tel }</td>
				<td class="text-center" onclick="toggleModel()"><i class="fa fa-search-plus"></i></td>
		    </tr>
		   <c:forEach var="mapafter" items="${mapafter}">
		   <c:if test="${not empty mapafter.jjlxr_c_name}">
		     <tr>
				<td class="text-center">紧急联系人</td>
				<td class="text-center">${mapafter.jjlxr_c_name }</td>
				<td class="text-center">410154956485213623</td>
				<td class="text-center">${mapafter.jjlxr_jdrgx }</td>
				<td class="text-center"><i class="fa fa-search-plus"></i></td>
				<td class="text-center"><i class="fa fa-search-plus"></i></td>
				<td class="text-center">${mapafter.jjlxr_c_name  }</td>	
				<td class="text-center" onclick="jjlxrModel()"><i class="fa fa-search-plus"></i></td>	
		    </tr>
		    </c:if>
		    
		    <c:if test="${not empty mapafter.c_name_gj1}">
		     <tr>
				<td class="text-center">共借人1</td>
				<td class="text-center">${mapafter.c_name_gj1 }</td>
				<td class="text-center">${mapafter.c_cardno_gj1 }</td>
				<td class="text-center">${mapafter.gjr1_yzdrgx }</td>
				<td class="text-center"><i class="fa fa-search-plus"></i></td>
				<td class="text-center"><i class="fa fa-search-plus"></i></td>
				<td class="text-center">${mapafter.c_tel_gj1 }</td>
				<td class="text-center" onclick="gjrOneModel()"><i class="fa fa-search-plus"></i></td>
		    </tr>
		    </c:if> 
		    <c:if test="${not empty mapafter.c_name_gj2 }">
		     <tr>
				<td class="text-center">共借人2</td>
				<td class="text-center">${mapafter.c_name_gj2 }</td>
				<td class="text-center">${mapafter.c_cardno_gj2 }</td>
				<td class="text-center">${mapafter.gjr2_yzdrgx }</td>
				<td class="text-center"><i class="fa fa-search-plus"></i></td>
				<td class="text-center"><i class="fa fa-search-plus"></i></td>
				<td class="text-center">${mapafter.c_tel_gj2 }</td>
				<td class="text-center" onclick="gjrTwoModel()"><i class="fa fa-search-plus"></i></td>
		    </tr> 
		    </c:if> 
		      </c:forEach>
       </table>
     </div>
      <div style="height:50px;margin:10px 0;">
	  	 <button type="button" class="btn btn-info search-btn" style="float:right">申请催收</button>
	</div>	
</div>
	<script>
	function toggleModel(){
		$('#myModal').modal({ show: true });
	}
	function jjlxrModel(){
		$('#jjlxrModal').modal({ show: true });
	}
	function gjrOneModel(){
		$('#oneModal').modal({ show: true });
	}
	function gjrTwoModel(){
		$('#twoModal').modal({ show: true });
	}
	</script>
	<!-- 模态框 主贷人 start-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="addModal_nstrLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title">主贷人信息</h4>
	            </div>
	            <div class="modal-body" style="border:1px solid #ccc;background-color:#F7F7F7;border-radius: 10px;margin:30px;">
	             	<!-- 模态框插入内容 start -->
	  	
					<div class="row" >
				    	<label class="col-sm-2">姓名:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  		${mapzdr.c_name }
					    </div>
					    <label class="col-sm-2 ">性别:<i class="red">*</i></label>
						<div class="col-sm-2">
						<c:if test="${mapzdr.c_sex == 1}">男</c:if>
				  		<c:if test="${mapzdr.c_sex == 0}">女</c:if>
				      		
						</div>
						<label class="col-sm-2" >年龄:<i class="red">*</i></label>
				  		<div class="col-sm-2">
							21
					    </div>
					</div>
					<div class="row" >
				    	<label class="col-sm-2 " style="" >手机号:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  			${mapzdr.c_tel }
					    </div>
					    <label class="col-sm-2 ">身份证号:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		${mapzdr.c_cardno}
						</div>
						<label class="col-sm-2" >身份证地址:<i class="red">*</i></label>
				  		<div class="col-sm-2" style="    white-space: nowrap;overflow:auto;">
							上海市浦东新区上岗新村国展路博大汽车公园123456
					    </div>
					</div>
					<div class="row" >
				    	<label class="col-sm-2">居住地:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  			${mapzdr.zdr_xzdz }
					    </div>
					    <label class="col-sm-2">学历:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		${mapzdr.zdr_xl }
						</div>
						<label class="col-sm-2">婚姻情况:<i class="red">*</i></label>
				  		<div class="col-sm-2">
							未婚
					    </div>
					</div>
					<div class="row" >
				    	<label class="col-sm-2 " style="" >单位性质:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  			私企
					    </div>
					    <label class="col-sm-2">单位名称:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		${mapzdr.zdr_gzdw}
						</div>
						<label class="col-sm-2" >单位职务:<i class="red">*</i></label>
				  		<div class="col-sm-2">
							开发
					    </div>
					</div>
					<div class="row" >
				    	<label class="col-sm-2">单位电话:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  			${mapzdr.zdr_dwdh }
					    </div>
					    <label class="col-sm-2">单位地址:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		${mapzdr.kk/zdr_dwdz}
						</div>
						<label class="col-sm-2" >个人月收入:<i class="red">*</i></label>
				  		<div class="col-sm-2">
							${mapzdr.zdr_grsr }
					    </div>
					</div>
				 <!-- 模态框插入内容 end -->
				</div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div>
	    </div>
	</div>	
	
	<!-- 模态框 紧急联系人 start-->
	<div class="modal fade" id="twoModal" tabindex="-1" role="dialog" aria-labelledby="addModal_nstrLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title">紧急联系人信息</h4>
	            </div>
	            <div class="modal-body" style="border:1px solid #ccc;background-color:#F7F7F7;border-radius: 10px;margin:30px;">
	             	<!-- 模态框插入内容 start -->
	  	
					<div class="row" >
				    	<label class="col-sm-2">姓名:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  		${mapzdr.c_name }
					    </div>
					    <label class="col-sm-2 ">性别:<i class="red">*</i></label>
						<div class="col-sm-2">
						<c:if test="${mapzdr.c_sex == 1}">男</c:if>
				  		<c:if test="${mapzdr.c_sex == 0}">女</c:if>
				      		
						</div>
						<label class="col-sm-2" >年龄:<i class="red">*</i></label>
				  		<div class="col-sm-2">
							21
					    </div>
					</div>
					<div class="row" >
				    	<label class="col-sm-2 " style="" >手机号:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  			${mapzdr.c_tel }
					    </div>
					    <label class="col-sm-2 ">身份证号:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		${mapzdr.c_cardno}
						</div>
						<label class="col-sm-2" >身份证地址:<i class="red">*</i></label>
				  		<div class="col-sm-2" style="    white-space: nowrap;overflow:auto;">
							上海市浦东新区上岗新村国展路博大汽车公园123456
					    </div>
					</div>
					<div class="row" >
				    	<label class="col-sm-2">居住地:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  			${mapzdr.zdr_xzdz }
					    </div>
					    <label class="col-sm-2">学历:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		${mapzdr.zdr_xl }
						</div>
						<label class="col-sm-2">婚姻情况:<i class="red">*</i></label>
				  		<div class="col-sm-2">
							未婚
					    </div>
					</div>
					<div class="row" >
				    	<label class="col-sm-2 " style="" >单位性质:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  			私企
					    </div>
					    <label class="col-sm-2">单位名称:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		${mapzdr.zdr_gzdw}
						</div>
						<label class="col-sm-2" >单位职务:<i class="red">*</i></label>
				  		<div class="col-sm-2">
							开发
					    </div>
					</div>
					<div class="row" >
				    	<label class="col-sm-2">单位电话:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  			${mapzdr.zdr_dwdh }
					    </div>
					    <label class="col-sm-2">单位地址:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		${mapzdr.kk/zdr_dwdz}
						</div>
						<label class="col-sm-2" >个人月收入:<i class="red">*</i></label>
				  		<div class="col-sm-2">
							${mapzdr.zdr_grsr }
					    </div>
					</div>
				 <!-- 模态框插入内容 end -->
				</div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div>
	    </div>
	</div>
	
	
	
	<!-- 模态框 共借人1 start-->
	<div class="modal fade" id="oneModal" tabindex="-1" role="dialog" aria-labelledby="addModal_nstrLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title">共借人1信息</h4>
	            </div>
	            <div class="modal-body" style="border:1px solid #ccc;background-color:#F7F7F7;border-radius: 10px;margin:30px;">
	             	<!-- 模态框插入内容 start -->
	  	
					<div class="row" >
				    	<label class="col-sm-2">姓名:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  		${mapzdr.c_name }
					    </div>
					    <label class="col-sm-2 ">性别:<i class="red">*</i></label>
						<div class="col-sm-2">
						<c:if test="${mapzdr.c_sex == 1}">男</c:if>
				  		<c:if test="${mapzdr.c_sex == 0}">女</c:if>
				      		
						</div>
						<label class="col-sm-2" >年龄:<i class="red">*</i></label>
				  		<div class="col-sm-2">
							21
					    </div>
					</div>
					<div class="row" >
				    	<label class="col-sm-2 " style="" >手机号:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  			${mapzdr.c_tel }
					    </div>
					    <label class="col-sm-2 ">身份证号:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		${mapzdr.c_cardno}
						</div>
						<label class="col-sm-2" >身份证地址:<i class="red">*</i></label>
				  		<div class="col-sm-2" style="    white-space: nowrap;overflow:auto;">
							上海市浦东新区上岗新村国展路博大汽车公园123456
					    </div>
					</div>
					<div class="row" >
				    	<label class="col-sm-2">居住地:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  			${mapzdr.zdr_xzdz }
					    </div>
					    <label class="col-sm-2">学历:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		${mapzdr.zdr_xl }
						</div>
						<label class="col-sm-2">婚姻情况:<i class="red">*</i></label>
				  		<div class="col-sm-2">
							未婚
					    </div>
					</div>
					<div class="row" >
				    	<label class="col-sm-2 " style="" >单位性质:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  			私企
					    </div>
					    <label class="col-sm-2">单位名称:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		${mapzdr.zdr_gzdw}
						</div>
						<label class="col-sm-2" >单位职务:<i class="red">*</i></label>
				  		<div class="col-sm-2">
							开发
					    </div>
					</div>
					<div class="row" >
				    	<label class="col-sm-2">单位电话:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  			${mapzdr.zdr_dwdh }
					    </div>
					    <label class="col-sm-2">单位地址:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		${mapzdr.kk/zdr_dwdz}
						</div>
						<label class="col-sm-2" >个人月收入:<i class="red">*</i></label>
				  		<div class="col-sm-2">
							${mapzdr.zdr_grsr }
					    </div>
					</div>
				 <!-- 模态框插入内容 end -->
				</div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div>
	    </div>
	</div>
	
	<!-- 模态框 共借人2 start-->
	<div class="modal fade" id="twoModal" tabindex="-1" role="dialog" aria-labelledby="addModal_nstrLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title">共借人2信息</h4>
	            </div>
	            <div class="modal-body" style="border:1px solid #ccc;background-color:#F7F7F7;border-radius: 10px;margin:30px;">
	             	<!-- 模态框插入内容 start -->
	  	
					<div class="row" >
				    	<label class="col-sm-2">姓名:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  		${mapzdr.c_name }
					    </div>
					    <label class="col-sm-2 ">性别:<i class="red">*</i></label>
						<div class="col-sm-2">
						<c:if test="${mapzdr.c_sex == 1}">男</c:if>
				  		<c:if test="${mapzdr.c_sex == 0}">女</c:if>
				      		
						</div>
						<label class="col-sm-2" >年龄:<i class="red">*</i></label>
				  		<div class="col-sm-2">
							21
					    </div>
					</div>
					<div class="row" >
				    	<label class="col-sm-2 " style="" >手机号:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  			${mapzdr.c_tel }
					    </div>
					    <label class="col-sm-2 ">身份证号:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		${mapzdr.c_cardno}
						</div>
						<label class="col-sm-2" >身份证地址:<i class="red">*</i></label>
				  		<div class="col-sm-2" style="    white-space: nowrap;overflow:auto;">
							上海市浦东新区上岗新村国展路博大汽车公园123456
					    </div>
					</div>
					<div class="row" >
				    	<label class="col-sm-2">居住地:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  			${mapzdr.zdr_xzdz }
					    </div>
					    <label class="col-sm-2">学历:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		${mapzdr.zdr_xl }
						</div>
						<label class="col-sm-2">婚姻情况:<i class="red">*</i></label>
				  		<div class="col-sm-2">
							未婚
					    </div>
					</div>
					<div class="row" >
				    	<label class="col-sm-2 " style="" >单位性质:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  			私企
					    </div>
					    <label class="col-sm-2">单位名称:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		${mapzdr.zdr_gzdw}
						</div>
						<label class="col-sm-2" >单位职务:<i class="red">*</i></label>
				  		<div class="col-sm-2">
							开发
					    </div>
					</div>
					<div class="row" >
				    	<label class="col-sm-2">单位电话:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  			${mapzdr.zdr_dwdh }
					    </div>
					    <label class="col-sm-2">单位地址:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		${mapzdr.kk/zdr_dwdz}
						</div>
						<label class="col-sm-2" >个人月收入:<i class="red">*</i></label>
				  		<div class="col-sm-2">
							${mapzdr.zdr_grsr }
					    </div>
					</div>
				 <!-- 模态框插入内容 end -->
				</div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div>
	    </div>
	</div>
	
