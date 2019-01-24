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
	  			123464
		    </div>
		    <label class="col-sm-1">身份证号:<i class="red">*</i></label>
			<div class="col-sm-2">
	      		李四
			</div>
			<label class="col-sm-1" >金融产品:<i class="red">*</i></label>
	  		<div class="col-sm-2">
				13464975464
		    </div>
		     <label class="col-sm-1" >车辆价格:<i class="red">*</i></label>
			<div class="col-sm-2">
				411325166545855
			</div> 
		</div>
		<div class="row">
	    	<label class="col-sm-1" >贷款金额:<i class="red">*</i></label>
	  		<div class="col-sm-2">
	  			大幅度
		    </div>
		    <label class="col-sm-1">贷款期数:<i class="red">*</i></label>
			<div class="col-sm-2">
	      		我是团队
			</div>
			<label class="col-sm-1" >每月应还:<i class="red">*</i></label>
	  		<div class="col-sm-2">
				1236.3
		    </div>
		     <label class="col-sm-1" >还款日期:<i class="red">*</i></label>
			<div class="col-sm-2">
				2018
			</div> 
		</div>
		<div class="row" >
	    	<label class="col-sm-1" >是否结清:<i class="red">*</i></label>
	  		<div class="col-sm-2">
	  			1236-799779
		    </div>
		   <label class="col-sm-1">贷款银行:<i class="red">*</i></label>
			<div class="col-sm-2">
	      		我是团队
			</div>
			<label class="col-sm-1">已还期数:<i class="red">*</i></label>
	  		<div class="col-sm-2">
				上海市浦东新区上岗新村 博大汽车公园
		    </div>
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
				<th class="text-center">实还金额</th>
				<th class="text-center">是否逾期</th>
				<th class="text-center">逾期金额</th>
				<th class="text-center">核销日期</th>
			</tr>
		   <c:forEach begin="1" end="12" var="i" varStatus="status">
			<tr>
				<td class="text-center">${status.index}</td>
				<td class="text-center">2020-12-27</td>
				<td class="text-center">10000</td>
				<td class="text-center">10000</td>
				<td class="text-center">否</td>
				<td class="text-center">0</td>
				<td class="text-center">2019-12-27</td>
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
				<td class="text-center">张三</td>
				<td class="text-center">410181196215642563</td>
				<td class="text-center">本人</td>
				<td class="text-center"><p>
				<i class="fa fa-search-plus"></i>
				</p></td>
				<td class="text-center"><p>
				<i class="fa fa-search-plus"></i>
				</p></td>
				<td class="text-center">15824569546</td>
				<td class="text-center"  onclick="toggleModel()" ><p>
				<i  class="fa fa-search-plus"></i>
				</p></td>
		    </tr>
		    <tr>
				<td class="text-center">紧急联系人</td>
				<td class="text-center">李四</td>
				<td class="text-center">410154956485213623</td>
				<td class="text-center">朋友</td>
				<td class="text-center"></td>
				<td class="text-center"></td>
				<td class="text-center">15985462315</td>	
				<td class="text-center"></td>	
		    </tr>
		    <tr>
				<td class="text-center">紧急联系人</td>
				<td class="text-center">王五</td>
				<td class="text-center">456213654895321633</td>
				<td class="text-center">朋友</td>
				<td class="text-center"></td>
				<td class="text-center"></td>
				<td class="text-center">15854695231</td>
				<td class="text-center"></td>
		    </tr>
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
	</script>
	<!-- 模态框 -->
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
				  			123464
					    </div>
					    <label class="col-sm-2 ">性别:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		李四
						</div>
						<label class="col-sm-2" >年龄:<i class="red">*</i></label>
				  		<div class="col-sm-2">
							13464975464
					    </div>
					</div>
					<div class="row" >
				    	<label class="col-sm-2 " style="" >手机号:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  			123464
					    </div>
					    <label class="col-sm-2 ">身份证号:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		李四
						</div>
						<label class="col-sm-2" >身份证地址:<i class="red">*</i></label>
				  		<div class="col-sm-2" style="    white-space: nowrap;overflow:auto;">
							上海市浦东新区上岗新村国展路博大汽车公园123456
					    </div>
					</div>
					<div class="row" >
				    	<label class="col-sm-2">居住地:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  			123464
					    </div>
					    <label class="col-sm-2">学历:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		李四
						</div>
						<label class="col-sm-2">婚姻情况:<i class="red">*</i></label>
				  		<div class="col-sm-2">
							13464975464
					    </div>
					</div>
					<div class="row" >
				    	<label class="col-sm-2 " style="" >单位性质:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  			123464
					    </div>
					    <label class="col-sm-2">单位名称:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		李四
						</div>
						<label class="col-sm-2" >单位职务:<i class="red">*</i></label>
				  		<div class="col-sm-2">
							13464975464
					    </div>
					</div>
					<div class="row" >
				    	<label class="col-sm-2">单位电话:<i class="red">*</i></label>
				  		<div class="col-sm-2">
				  			123464
					    </div>
					    <label class="col-sm-2">单位地址:<i class="red">*</i></label>
						<div class="col-sm-2">
				      		李四
						</div>
						<label class="col-sm-2" >个人月收入:<i class="red">*</i></label>
				  		<div class="col-sm-2">
							13464975464
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
