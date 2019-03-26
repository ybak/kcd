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
	  <form id="form1" onsubmit="return false" action="##"  method="post">
	  	  <!-- 拖车已受理  start -->
	  	  <c:if test="${requestScope.type eq 'tc_ysl'}">
  	  	  	  <div style="margin-top:20px;">
  	  	  		<label>拖车结果<i class="red">*</i>:</label>
  	  	  	  </div>
			   <ul class="pagination no-margin" style="padding-top: 10px;">					     				       
					<select id="coolStatus" name="coolStatus" style="width: 180px;" class="form-control">
					    <option value="">--请选择--</option>
						<option value="33">拖车完成</option>
						<option value="34">失败</option>
					</select>
				</ul>
	  		  <div style="margin-top:20px;">
			  		<label>入库时间:</label>
				  	<lable style="margin-left:310px;margin-top:40px;">入库地址:</lable>
				  	<lable style="margin-left:415px;">入库影像:</lable>
		  	  </div>
			  <div style="margin-top:10px;width:300px;">
					<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required">
			  			<input id="coolTime"  name="coolTime" class="form-control" type="text"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
					</div>
					<input id="coolAddress" name="coolAddress" type="text" style="margin-top:-35px;margin-left:380px;width:390px;" class="form-control">
					<!-- <input name="coolVideo" id="coolVideo" style="margin-top:-35px;margin-left:870px;width:390px;height:35px;"  class="file-upload-input" type="file"> -->
			  		<input type="hidden" id="coolVideo" name="coolVideo" value="" >
		            <input style="display: none" onchange="javascript:setImagePreview();" type="file" value="" id="file" name="file" >
		            <label for="file">
		            <img  id="preview" style="margin-top:-35px;margin-left:870px;width:50px;height:50px;"  class="img-thumbnail"  src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/images/icon.png"/>     
				    </label>
			  </div>
		  </c:if>
		  <!-- 拖车已受理  end -->
		  <!-- 拖车完成  start -->
	  	  <c:if test="${requestScope.type eq 'tc_wc'}">
  	  	  	  <div style="margin-top:20px;">
  	  	  		<label>处置结果<i class="red">*</i>:</label>
  	  	  	  </div>
			   <ul class="pagination no-margin" style="padding-top: 10px;">					     				       
					<select id="coolStatus" name="coolStatus" style="width: 180px;" class="form-control">
					    <option value="">--请选择--</option>
						<option value="51">拍卖</option>
						<option value="63">强制结清</option>
					</select>
				</ul>
		  </c:if>
		  <!-- 拖车完成  end -->
		  <!-- 拍卖未完成  start -->
	  	  <c:if test="${requestScope.type eq 'auction_no'}">
  	  	  	  <div style="margin-top:20px;">
  	  	  		<label>处置结果<i class="red">*</i>:</label>
  	  	  	  </div>
			   <ul class="pagination no-margin" style="padding-top: 10px;">					     				       
					<select id="coolStatus" name="coolStatus" style="width: 300px;" class="form-control">
					    <option value="">--请选择--</option>
						<option value="71">亏损<5000(拍卖完成)[进入未核销]</option>
						<option value="41">亏损>5000(拍卖完成)[进入诉讼]</option>
						<option value="53">盈利(拍卖完成)</option>
					</select>
				</ul>
		  </c:if>
		  <!-- 拍卖未完成  end -->
		  <!-- 已核销  start -->
	  	  <c:if test="${requestScope.type eq 'hx_yes'}">
  	  	  	  <div style="margin-top:20px;">
  	  	  		<label>处置结果<i class="red">*</i>:</label>
  	  	  	  </div>
			   <ul class="pagination no-margin" style="padding-top: 10px;">					     				       
					<select id="coolStatus" name="coolStatus" style="width: 300px;" class="form-control">
					    <option value="">--请选择--</option>
						<option value="61">正常结清</option>
						<option value="62">提前结清</option>
						<option value="63">强制结清</option>
						<option value="64">亏损结清</option>
					</select>
				</ul>
		  </c:if>
		  <!-- 已核销  end -->
		  <div style="margin-top:10px;">
		      <h4 class="modal-title">信息录入栏:</h4>	      
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
<script>
lay('#version').html('-v'+ laydate.v);
//执行一个laydate实例
laydate.render({
  elem: '#coolTime'
});
</script>
<script type="text/javascript">
function appCar(clickType){
	if(clickType==2){
		var type_id = 4;
		var type_status = 41;
		var result_msg = "开始申请诉讼";
	}
	var icbc_id = ${pdOne.icbc_id};
	var lolId = ${pdOne.id};
	//alert(icbc_id+"--"+lolId+"--"+type_id+"--"+type_status+"--"+result_msg);
	//确定提示框
	var confirmMsg = confirm("请问确定"+result_msg+"吗?");
	if(confirmMsg==true){
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
	}else if(confirmMsg==false){
		//如果取消，暂时不做操作
	}
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
	//拖车未受理和拖车已受理和拖车完成和拖车失败公用一个页面
	//获取是哪个页面的提交
	var formTypeWsl = ${requestScope.type eq 'tc_wsl'};
	var formType = ${requestScope.type eq 'tc_ysl'};
	var formTypeWc = ${requestScope.type eq 'tc_wc'};
	var formTypeSb = ${requestScope.type eq 'tc_sb'};
	var formTypeAuctionNo = ${requestScope.type eq 'auction_no'};
	var formTypehx_no = ${requestScope.type eq 'hx_no'};
	var formTypehx_yes = ${requestScope.type eq 'hx_yes'};
	var formTypessgl_no = ${requestScope.type eq 'ssgl_no'};
	var formTypessgl_yes = ${requestScope.type eq 'ssgl_yes'};
	if(formTypeWc || formTypeAuctionNo || formTypehx_yes){ //拖车完成页面提交
		//alert("拖车完成页面提交");
		//alert("未拍卖提交");
		//alert("已核销页面提交");
		var coolStatus = $('#coolStatus').val();
		if(coolStatus==""){
			alert("请选择处置结果!");
			return false;
		}
		$.ajax({
			type: "POST",
	        url: "${pageContext.request.contextPath}/loan/addCarWcResult.do",
	        data:{
	        	coolStatus:coolStatus,
	        	result_msg:result_msg,
	        	type_id:type_id,
	        	type_status:type_status,
	        	icbc_id:icbc_id,
	        	lolId:lolId
	       	},
	        success:function(data){  
	        	alert(data);
	        	self.location = document.referrer;
	        }
		})
	}
	
	if(formType){  //拖车已受理页面提交
		//alert("拖车已受理页面提交");
		var coolStatus = $('#coolStatus').val();
		if(coolStatus==""){
			alert("请选择拖车结果!");
			return false;
		}
		var coolTime = $('#coolTime').val();
		var coolAddress = $('#coolAddress').val();
		var coolVideo = $('#coolVideo').val();
		$.ajax({
			type: "POST",
	        url: "${pageContext.request.contextPath}/loan/addCarYslResult.do",
	        data:{
	        	coolTime:coolTime,
	        	coolAddress:coolAddress,
	        	coolVideo:coolVideo,
	        	coolStatus:coolStatus,
	        	result_msg:result_msg,
	        	type_id:type_id,
	        	type_status:type_status,
	        	icbc_id:icbc_id,
	        	lolId:lolId
	       	},
	        success:function(data){  
	        	alert(data);
	        	self.location = document.referrer;
	        	//location.href="${pageContext.request.contextPath}/loan/selectPhoneList.do?type_id=3&type_status=32&type=tc_ysl&dn=loan_car&qn=list&pagesize=10&pagenow=1";
	        }
		})
	}
	
	if(formTypeSb || formTypeWsl || formTypehx_no || formTypessgl_no || formTypessgl_yes){ //拖车未受理页面和拖车失败提交
		//alert("未受理提交");
		//alert("失败提交");
		//alert("未核销提交");
		//alert("未诉讼提交");
		//alert("已诉讼页面提交");
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
				//location.reload(true); // 刷新本页面
	            //window.history.go(-1); //是返回上一页
				//window.location.go(-1); //刷新上一页 
	            self.location = document.referrer;
	        }
		})
	}
	
}


function setImagePreview(avalue) {
    var docObj = document.getElementById("file");
    var imgObjPreview = document.getElementById("preview");
    if(docObj.files && docObj.files[0])
    {
        //火狐下，直接设img属性
        imgObjPreview.style.display = 'block';
        imgObjPreview.style.width = '50px';
        imgObjPreview.style.height = '50px';
        //imgObjPreview.src = docObj.files[0].getAsDataURL();
        //火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
        imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
    }
    else
    {
        //IE下，使用滤镜
        docObj.select();
        var imgSrc = document.selection.createRange().text;
        var localImagId = document.getElementById("localImag"); //必须设置初始大小
        localImagId.style.width = "50px";
        localImagId.style.height = "50px"; //图片异常的捕捉，防止用户修改后缀来伪造图片
        try {
            localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            localImagId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
        } catch(e) {
            alert("您上传的图片格式不正确，请重新选择!");
            return false;
        }
        imgObjPreview.style.display = 'none';
        document.selection.empty();
    }
    file_up();
    return true;
}

function file_up(){
    var formData = new FormData();
    formData.append("file", document.getElementById("file").files[0]);
    $.ajax({
        url: "${pageContext.request.contextPath}/erp/file_up_util.do",
        type: "POST",
        data: formData,
        /**
         *必须false才会自动加上正确的Content-Type
         */
        contentType: false,
        /**
         * 必须false才会避开jQuery对 formdata 的默认处理
         * XMLHttpRequest会对 formdata 进行正确的处理
         */
        processData: false,
        success: function (data) {
            alert("上传成功！");
            document.getElementById("coolVideo").value=data;
        },
        error: function () {
            alert("上传失败！");
        }
    });
}
</script>			
