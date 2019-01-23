<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
		            	.flex-box{
		            		display: flex;
		            		flex-direction: column;
		            	}
		            	.flex-box div[class^='flex-row']{
		            		width: 100%;
		            	}
		            	.flex-box .flex-row{
		            		height: 35px;	
		            	}
		            	.flex-row-rhcen{
		            		display: flex;
		            		justify-content: flex-end;
		            		align-items: center;
		            	}
		            	em{
		            		cursor: pointer;
		            	}
		            	.flex-row-rhcen em{
		            		padding: 0 5px;
		            	}
		            	.flex-rowcen{
		            		flex: 1;
		            	}
		            	.text-primary em{
		            		display: block;
		            		font-size: 15px;
		            		line-height: 25px;
		            	}
	            		.text-primary .big-conte{
		            		background-color:#f7f7f7;
		            		height:auto!important; 
							height:100px; 
							display:none;
							min-height:100px;
		    				padding: 15px 0;
		    				margin: 15px 0;
		    				border-radius:10px;
		     			}
		     			.big-conte-row span{
		     				text-align: right;
		     				padding-right: 15px;
		     				line-height: 34px;
		     				width: 25%;
		     				float: left;
		     				
		     			}
		     			.big-conte-row input{
		     				float: left;
		     				width: 20%;
		     			}
		     			.big-conte-row{
		     				margin: 20px;
		     				height: 34px;
		     			}
		            </style>
	          <% request.setCharacterEncoding("utf-8"); %>  
<div class="modal-body flex-box" style="height: auto; ">
<div class="flex-row flex-row-rhcen">
<em onclick="funUnfold()" class="text-muted">全部展开</em> 
<em onclick="funClose()" class="text-muted">全部收起</em> 
</div>
<div class="flex-rowcen">
			            	<ol>
<c:forEach var="erp15" items="${requestScope.erp15 }" varStatus="status">
	<c:if test="${erp15.status eq '56'}">				            	
<li class="text-primary">
<em>${status.index+1 }.${erp15.taskname_name }：</em>
<div class="big-conte" style="display: none;">                    
<div style="float:left;margin-left:20px;width:260px;" >
<strong>开始时间：</strong>
<fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" >
<strong>处理人：${erp15.gname1 }</strong>
</div>         
</div>							  	
</li>
	</c:if>
	
<c:if test="${erp15.status eq '57'}">
<li class="text-primary">
<em>${status.index+1 }.${erp15.taskname_name }：</em>
<div class="big-conte" style="display: none;">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
<fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong>
<fmt:formatDate value="${erp15.dt_edit}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong>${erp15.gname1}</div>
<strong style="margin-left:10px;"><i>处理信息：</i></strong><br>
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
<!-- 	<div class="form-group" ng-if="notUseButton && task.postRet != null">
		<label class="col-sm-2 control-label">收件确认</label>
		<div class="col-sm-6">
			<input type="radio" value="1" ng-model="task.postRet" disabled="true">已收到
	            &nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="radio" value="0" ng-model="task.postRet" disabled="true">未收到
		</div>
	</div> -->
	<!-- ngIf: (rootData.taskDefKey == 'loanOrder_postinfo_send' || (task.notarizeEndDate !=null))&&task.justRecord==true -->
	<div style="display:none;">
		 <textarea id="inObj_57_${status.index+1}">${erp15.result_1_value}</textarea>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">快递公司</label>
		<div class="col-sm-3">
			<input id="kdgs_${status.index+1}"  class="form-control ng-pristine ng-untouched ng-valid ng-empty">
		</div>
		<!-- ngIf: rootData.taskDefKey == 'loanOrder_postinfo_send'||($parent.taskAct.activityId=='loanOrder_postinfo_send'&&notUseButton) -->
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">快递单号</label>
		<div class="col-sm-3">
			<input id="kddh_${status.index+1}" class="form-control ng-pristine ng-untouched ng-valid ng-empty">
		</div>
		<label class="col-sm-2 control-label">寄出日期<i class="red">*</i></label>
		<div class="col-sm-3">
			<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required" >
  				<input id="jcrq_${status.index+1}" class="form-control" type="text">
  				<span class="input-group-addon">
  				<i class="fa fa-calendar"></i>
  				</span>
			</div>
		</div>
	</div> 
	<!-- ngIf: !notUseButton -->
	<br>
	<!-- <div style="overflow: hidden;margin-left: 7%">
	     ngRepeat: img in task.filepathlist<div  style="float:left;left:5px;margin-top: 20px" class="ng-scope">
	     	<div class="fileUpload_preview" style="margin-top:5px;">
		     	<li> 
			     	<img onclick="alert('ylimage');" id="bcimg1" class="fileUpload_preview fileUpload_preview-small fileUpload_preview-square"  src="http://115.236.182.101:8083/Customer/0~50000/C000292957/20180611A0000061/POST_BILL/1531895808445.jpg">
		     	</li>
		     	<div class="btn btn-success btn-resize ng-hide">⇔</div>
		     	<div class="btn btn-danger btn-close ng-hide">x</div>
				<div class="btn btn-primary btn-download">↓</div>
				<div class="fileUpload_filename ng-binding">3282.jpg</div>
			</div>
			<div style="margin-top:5px;position: absolute;" class="ng-binding">2018-07-18</div>
		</div>end ngRepeat: img in task.filepathlist
	</div> -->
	<div class="form-group">
		<label class="col-sm-2 control-label">快递图片</label>
     	<div class="col-sm-3">
	     	<li> <!-- ylimage(this) -->
		     	<img onclick="aayyclimage(this)" id="bcimg1_${status.index+1}" class="fileUpload_preview fileUpload_preview-small fileUpload_preview-square"  src="http://115.236.182.101:8083/Customer/0~50000/C000292957/20180611A0000061/POST_BILL/1531895808445.jpg">
	     	</li>
	     	<div class="btn btn-success btn-resize ng-hide">⇔</div>
	     	<div class="btn btn-danger btn-close ng-hide">x</div>
			<!-- <div class="btn btn-primary btn-download">↓</div> -->
			<!-- <div class="fileUpload_filename ng-binding" style="margin-left:30px;">点击放大</div> -->
		</div>
	</div>
	<!-- ngIf: rootData.taskDefKey!='loanOrder_postinfo_return' -->
	<div class="form-group">
		<label class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea id="result_1_msg"  rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text">${erp15.result_1_msg}</textarea>
		</div>
	</div> 
	<!-- ngIf: !notUseButton -->
	<script>
		// 57 处理 json ,并给相应的对象赋值
		var index = ${status.index+1};
		var objS_57index = JSON.parse($("#inObj_57_${status.index+1}").val()); //由JSON字符串转换为JSON对象
		document.getElementById("kdgs_${status.index+1}").value = objS_57index['kdgs'];
		document.getElementById("kddh_${status.index+1}").value = objS_57index.kddh;
		document.getElementById("jcrq_${status.index+1}").value = objS_57index.jcrq;
		//alert("图片："+objS_57index.bcimg1);
		if(objS_57index.bcimg1!=null&&objS_57index.bcimg1!=''){
			document.getElementById("bcimg1_${status.index+1}").src = "http://a.kcway.net/"+objS_57index.bcimg1;	
		}else{
			document.getElementById("bcimg1_${status.index+1}").style.display="none";	
		}
		
		
		function aayyclimage(obj){
    		//alert(obj);
    		if(obj!=0){
    		var $img = $(obj),
    			imgUrl = $img[0].src;
    		}
    		/* alert($img[0].src); */
    		var activeIndex=0;
    		var imgs = [];
    		$(".fileUpload_preview").each(function(i,elem){
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
    	    $("#aayyclModal_iframe").attr("src","${pageContext.request.contextPath}/jquery-photo-gallery/gallerys.jsp");
    	     //显示模态框  只有在选择编辑的行   然后根据回调函数成功后才会显示模态框
    	    $('#aayyclModal').modal({ show: true, backdrop: 'static' });
		}
	</script>
	<div class="modal fade" id="aayyclModal" tabindex="-1" role="dialog" aria-labelledby="aayyclModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title" align="center" id="aayyclModalLabel">图片预览</h4>
	            </div>
	            <div class="modal-body" style="height:750px;">
	            <iframe id="aayyclModal_iframe" width="100%" height="100%" frameborder="0"></iframe>
	            (左右键控制上一张,下一张)
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div>
	    </div>
	</div>
</form>
</div>
</div>   							  	
</li>
</c:if>

<c:if test="${erp15.status eq '58'}">
<li class="text-primary">
<em>${status.index+1 }.${erp15.taskname_name }：</em>
<div class="big-conte" style="display: none;">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
<fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong>
<fmt:formatDate value="${erp15.dt_edit}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong>${erp15.gname1}</div>
<strong style="margin-left:10px;"><i>处理信息：</i></strong><br>
<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
	<div style="display:none;">
		 <textarea id="inObj_58_${status.index+1}">${erp15.result_1_value}</textarea>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">收件确认</label>
		<div class="col-sm-3">
			<input id="58_msg_${status.index+1}" type="radio" value="1"   class="ng-pristine ng-untouched ng-valid ng-not-empty">已收到
	            &nbsp;&nbsp;&nbsp;&nbsp;
	        <input id="58_msg_${status.index+1}_1" type="radio" value="2"  class="ng-pristine ng-untouched ng-valid ng-not-empty">未收到
		</div>
		<label class="col-sm-2 control-label">收件日期</label>
		<div class="col-sm-3">
        <div class="input-group date ng-isolate-scope ng-empty ng-valid">
        <input id="58_date_${status.index+1}" class="form-control selectData" type="text">
        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
        </div>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">材料复核结果</label>
		<div class="col-sm-3">
			<input id="result_1_code_1" type="radio" value="1" ${erp15.result_1_code eq '1'?"checked='checked'":'' } class="ng-pristine ng-untouched ng-valid ng-not-empty" >通过
	            &nbsp;&nbsp;&nbsp;&nbsp;
	        <input id="result_1_code_2" type="radio" value="2" ${erp15.result_1_code eq '2'?"checked='checked'":'' } class="ng-pristine ng-untouched ng-valid ng-not-empty" >不通过
		</div>
		<!-- ngIf: rootData.taskDefKey=='postget'||taskAct.activityId=='postget' -->
		<!-- ngIf: rootData.taskDefKey=='loanOrder_postget_asun'||rootData.taskDefKey=='loanOrder_postget_bank'||taskAct.activityId=='loanOrder_postget_asun'||taskAct.activityId=='loanOrder_postget_bank' -->
	</div>
	<!-- ngIf: (rootData.taskDefKey&&rootData.taskDefKey =='loanOrder_postget_asun')||(taskAct.activityId&&taskAct.activityId=='loanOrder_postget_asun') -->
	<!-- ngIf: (rootData.taskDefKey&&rootData.taskDefKey == 'loanOrder_postget_asun')||(taskAct.activityId&&taskAct.activityId=='loanOrder_postget_asun') --> 
	<!-- ngIf: (rootData.taskDefKey&&rootData.taskDefKey == 'loanOrder_postget_asun')||(taskAct.activityId&&taskAct.activityId=='loanOrder_postget_asun') -->
	<!-- ngIf: (rootData.taskDefKey=='loanOrder_postget_bank'||rootData.taskDefKey=='loanOrder_postget_asun')&&!notUseButton -->
	<!-- ngIf: rootData.taskDefKey=='loanOrder_postget_org'||taskAct.activityId=='loanOrder_postget_org' -->
	<div style="margin-top: 5%" class="clear"></div>
	<div class="form-group">
		<label class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea name="result_1_msg" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text" ng-model="task.remarks">${erp15.result_1_msg}</textarea>
		</div>
	</div> 
	<!-- ngIf: !notUseButton -->
	<script>
		// 58 处理 json ,并给相应的对象赋值
		var index = ${status.index+1};
		var objS_58index = JSON.parse($("#inObj_58_${status.index+1}").val()); //由JSON字符串转换为JSON对象
		if(objS_58index['58_msg'] == "已收到"){
			$("#58_msg_${status.index+1}").attr("checked","checked");
		}else if(objS_58index['58_msg'] == "未收到"){
			$("#58_msg_${status.index+1}_1").attr("checked","checked");
		}else{
			var a = 1;
		}
		document.getElementById("58_date_${status.index+1}").value = objS_58index['58_date'];
	</script>
</form>
</div>                                             
</div>									  	
</li>
</c:if>

<c:if test="${erp15.status eq '59'}">
<li class="text-primary">
<em>${status.index+1 }.${erp15.taskname_name }：</em>
<div class="big-conte" style="display: none;">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
<fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong>
<fmt:formatDate value="${erp15.dt_edit}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong>${erp15.gname1}</div>
<strong style="margin-left:10px;"><i>处理信息：</i></strong><br>
<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
	<div style="display:none;">
		 <textarea id="inObj_59_${status.index+1}">${erp15.result_1_value}</textarea>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">收件确认</label>
		<div class="col-sm-3">
			<input id="59_msg_${status.index+1}" type="radio" value="1"   class="ng-pristine ng-untouched ng-valid ng-not-empty" >已收到
	            &nbsp;&nbsp;&nbsp;&nbsp;
	        <input id="59_msg_${status.index+1}_1" type="radio" value="2" class="ng-pristine ng-untouched ng-valid ng-not-empty" >未收到
		</div>
		<label class="col-sm-2 control-label">收件日期</label>
		<div class="col-sm-3">
			<div class="input-group date ng-isolate-scope ng-empty ng-valid" >
  <input id="59_date_${status.index+1}" class="form-control" type="text"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
</div>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">材料复核结果</label>
		<div class="col-sm-3">
			<input type="radio" value="1" ${erp15.result_1_code eq '1'?"checked='checked'":'' }  class="ng-pristine ng-untouched ng-valid ng-not-empty">通过
	            &nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="radio" value="2" ${erp15.result_1_code eq '2'?"checked='checked'":'' } class="ng-pristine ng-untouched ng-valid ng-not-empty">不通过
		</div>
		<!-- ngIf: rootData.taskDefKey=='postget'||taskAct.activityId=='postget' -->
		<span class="ng-scope">
	    	<label class="col-sm-2 control-label">进银行日期</label>
			<div class="col-sm-3">
				<div class="input-group date ng-isolate-scope ng-empty ng-valid">
  <input id="59_jyhrq_${status.index+1}" class="form-control" type="text"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
</div>
			</div>
		</span><!-- end ngIf: rootData.taskDefKey=='postget'||taskAct.activityId=='postget' -->
		<!-- ngIf: rootData.taskDefKey=='loanOrder_postget_asun'||rootData.taskDefKey=='loanOrder_postget_bank'||taskAct.activityId=='loanOrder_postget_asun'||taskAct.activityId=='loanOrder_postget_bank' -->
	</div>
	<!-- ngIf: (rootData.taskDefKey&&rootData.taskDefKey =='loanOrder_postget_asun')||(taskAct.activityId&&taskAct.activityId=='loanOrder_postget_asun') -->
	<!-- ngIf: (rootData.taskDefKey&&rootData.taskDefKey == 'loanOrder_postget_asun')||(taskAct.activityId&&taskAct.activityId=='loanOrder_postget_asun') --> 
	<!-- ngIf: (rootData.taskDefKey&&rootData.taskDefKey == 'loanOrder_postget_asun')||(taskAct.activityId&&taskAct.activityId=='loanOrder_postget_asun') -->
	<!-- ngIf: (rootData.taskDefKey=='loanOrder_postget_bank'||rootData.taskDefKey=='loanOrder_postget_asun')&&!notUseButton -->
	<!-- ngIf: rootData.taskDefKey=='loanOrder_postget_org'||taskAct.activityId=='loanOrder_postget_org' -->
	<div style="margin-top: 5%" class="clear"></div>
	<div class="form-group">
		<label class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text">${erp15.result_1_msg}</textarea>
		</div>
	</div> 
	<!-- ngIf: !notUseButton -->
	<script>
		var index = ${status.index+1};
		// 59 处理 json ,并给相应的对象赋值
		var objS_59index = JSON.parse($("#inObj_59_${status.index+1}").val()); //由JSON字符串转换为JSON对象
		if(objS_59index['58_msg'] == "已收到"){
			$("#59_msg_${status.index+1}").attr("checked","checked");
		}else if(objS_59index['58_msg'] == "未收到"){
			$("#59_msg_${status.index+1}_1").attr("checked","checked");
		}else{}
		document.getElementById("59_date_${status.index+1}").value = objS_59index['58_date'];
		document.getElementById("59_jyhrq_${status.index+1}").value = objS_59index['58_jyhrq'];
	</script>
</form>
</div>                                             
</div>									  	
</li>
</c:if>

<c:if test="${erp15.status eq '60'}">
<li class="text-primary">
<em>${status.index+1 }.${erp15.taskname_name }：</em>
<div class="big-conte" style="display: none;">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
<fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong>
<fmt:formatDate value="${erp15.dt_edit}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong>${erp15.gname1 }</div>
<strong style="margin-left:10px;">
<i>处理信息：</i></strong><br>
<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope" cg-disabled="detail">
	<div class="form-group">		
		<label class="col-sm-2 control-label">审批结果</label>
		<div class="col-sm-8">
			<input type="radio" value="1" ${erp15.result_1_code eq '1'?"checked='checked'":'' } class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code" >通过&nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="radio" value="2" ${erp15.result_1_code eq '2'?"checked='checked'":'' } class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code" >不通过&nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="radio" value="3" ${erp15.result_1_code eq '3'?"checked='checked'":'' } class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code" >附条件&nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="radio" value="4" ${erp15.result_1_code eq '4'?"checked='checked'":'' } class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code" >先抵押后放贷
       	</div>
	</div>
	<!-- <div class="form-group" >
        <label class="col-sm-2 control-label">补资料<span class="red">*</span></label>
		<div class="col-sm-8">
			<input class="form-control" value=""  type="text" id="" name="" />
		</div>
	</div> -->
	<div class="form-group">
	<label class="col-sm-2 control-label">审批意见</label>
		<div class="col-sm-8">
			<textarea rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text">${erp15.result_1_msg }</textarea>
		</div>
	</div>	
	
	<!-- 根据action确定操作  -->
	<!-- ngIf: !notUseButton -->
</form>
</div>                                             
</div>									  	
</li>
</c:if>
<c:if test="${sessionScope.pd.agpid != '14' and sessionScope.pd.agpid != '15'}">
<c:if test="${erp15.status eq '61'}">
<li class="text-primary">
<em>${status.index+1 }.${erp15.taskname_name }：</em>
<div class="big-conte" style="display: none;">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
<fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong>
<fmt:formatDate value="${erp15.dt_edit}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong>${erp15.gname1 }</div>
<strong style="margin-left:10px;">
<i>处理信息：</i></strong><br>
<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
	<div style="display:none;">
		 <textarea id="inObj_61_${status.index+1}">${erp15.result_1_value}</textarea>
	</div>
	<div class="form-group">		
		<label class="col-sm-2 control-label">放款结果</label>
		<div class="col-sm-8">
			<input type="radio" value="1" ${erp15.result_1_code eq '1'?"checked='checked'":'' } class="ng-pristine ng-untouched ng-valid ng-not-empty" name="47692">成功  
			&nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="radio" value="2" ${erp15.result_1_code eq '2'?"checked='checked'":'' } class="ng-pristine ng-untouched ng-valid ng-not-empty" name="47693">失败
       	</div>
	</div>
	<!-- ngIf: task.auditRet==null ||task.auditRet == 1 --><div class="ng-scope">
		<div class="form-group">
			<label class="col-sm-2 control-label">放款日期<i class="red">*</i></label>
			 <div class="col-sm-3">
				<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required">
  <input id="61_date_${status.index+1}" class="form-control" type="text"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
</div>
			</div>   
			<label class="col-sm-2 control-label">卡号<i class="red">*</i></label>
			<div class="col-sm-3">
				<input id="61_kh_${status.index+1}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required" type="text" >
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">支行<i class="red">*</i></label>
			<div class="col-sm-3">
				<input id="61_zh_${status.index+1}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required" type="text"  >
			</div>
	
			<label class="col-sm-2 control-label">金额<i class="red">*</i></label>
			<div class="col-sm-3">
				<input id="61_je_${status.index+1}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required" type="text" >
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">首期还款日期</label>
			<div class="col-sm-3">
				<div class="input-group date ng-isolate-scope ng-not-empty ng-valid" >
  <input id="61_sqhkr_${status.index+1}" class="form-control" type="text"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
</div>
			</div>
	
			<label class="col-sm-2 control-label">月还</label>
			<div class="col-sm-3">
				<input id="61_yh_${status.index+1}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text"  >
			</div>
		</div>
		
		<div class="form-group">
			<label class="col-sm-2 control-label">首月还款</label>
			<div class="col-sm-3">
				<input id="61_syhk_${status.index+1}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text"  >
			</div>
	
			<label class="col-sm-2 control-label">分期数</label>
			<div class="col-sm-3">
				<input id="61_fq_${status.index+1}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text"  >
			</div>
		</div>
		<!-- ngIf: task.creditsMoney -->
<!-- 		<div class="form-group">		 -->
<!-- 			<label class="col-sm-2 control-label">打款至：</label> -->
<!-- 			<div  class="col-sm-8"> -->
<!-- 				<input type="radio" value="1000" ng-model="task.orgId" ng-checked="task.orgId==null || task.orgId==1000">资产公司  &nbsp;&nbsp;&nbsp;&nbsp; -->
<!-- 		        <input type="radio" value="1228" ng-model="task.orgId">网络公司 -->
<!-- 	       	</div> -->
<!-- 		</div> -->
	<!-- 	<div class="form-group">
			<label class="col-sm-2 control-label">垫资金额</label>
			<div class="col-sm-3">
				<input class="form-control" type="text"	ng-model="task.payAmount" cg-required required/>
			</div>
			<label class="col-sm-2 control-label">差额</label>
			<div class="col-sm-3">
				<input class="form-control" type="text" ng-model="task.netting"  ng-value="task.bankAmount-task.payAmount" disabled="true" />(计算方式:放贷额-垫资金额)
			</div>
		</div> -->
	</div><!-- end ngIf: task.auditRet==null ||task.auditRet == 1 -->
	<div class="form-group">
		<label class="col-sm-2 control-label">其它说明</label>
		<div class="col-sm-8">
			<textarea rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"  >${erp15.result_1_msg }</textarea>
		</div>
	</div>

	<!-- 根据action确定操作  -->
	<!-- ngIf: !notUseButton -->
	<script>
		var index = ${status.index+1};
		// 61 处理 json ,并给相应的对象赋值
		var objS_61index = JSON.parse($("#inObj_61_${status.index+1}").val()); //由JSON字符串转换为JSON对象
		document.getElementById("61_date_${status.index+1}").value = objS_61index['61_date'];
		document.getElementById("61_kh_${status.index+1}").value = objS_61index['61_kh'];
		document.getElementById("61_zh_${status.index+1}").value = objS_61index['61_zh'];
		document.getElementById("61_je_${status.index+1}").value = objS_61index['61_je'];
		document.getElementById("61_sqhkr_${status.index+1}").value = objS_61index['61_sqhkr'];
		document.getElementById("61_yh_${status.index+1}").value = objS_61index['61_yh'];
		document.getElementById("61_syhk_${status.index+1}").value = objS_61index['61_syhk'];
		document.getElementById("61_fq_${status.index+1}").value = objS_61index['61_fq'];
	</script>
</form>
</div>                                             
</div>									  	
</li>
</c:if>

<c:if test="${erp15.status eq '62'}">
<li class="text-primary">
<em>${status.index+1 }.${erp15.taskname_name }：</em>
<div class="big-conte" style="display: none;">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
<fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong>
<fmt:formatDate value="${erp15.dt_edit}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong>${erp15.gname1 }</div>
<strong style="margin-left:10px;">
<i>处理信息：</i></strong><br>
<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required" >
	<div style="display:none;">
		 <textarea id="inObj_62_${status.index+1 }">${erp15.result_1_value}</textarea>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">放款日期<i class="red">*</i></label>
		 <div class="col-sm-3">
			<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required">
  <input id="62_fkrq_${status.index+1}" class="form-control" type="text" ><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
</div>
		</div>
		<label class="col-sm-2 control-label">放款金额<i class="red">*</i></label>
		<div class="col-sm-3">
			<input id="62_fkje_${status.index+1}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required" type="text">
		</div>
	</div>
	<!-- <div class="form-group">
		<label class="col-sm-2 control-label">垫资/划付金额</label>
		<div class="col-sm-3">
			<input class="form-control" type="text"	ng-model="task.payAmount" cg-required required/>
		</div>
		<label class="col-sm-2 control-label">差额</label>
		<div class="col-sm-3">
			<input class="form-control" type="text" ng-model="task.netting"  ng-value="(task.bankAmount-task.payAmount).toFixed(4)" disabled="true" />(计算方式:放贷额-垫资金额)
		</div>
	</div> -->
	<div class="form-group">
		<label class="col-sm-2 control-label">收款情况<span class="red">*</span></label> 
		<div class="col-sm-8">
			<input type="radio" value="1" ${erp15.result_1_code eq '1'?"checked='checked'":'' } class="ng-pristine ng-untouched ng-valid ng-not-empty" >到账确认，本单已完整  &nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="radio" value="3" ${erp15.result_1_code eq '3'?"checked='checked'":'' } class="ng-pristine ng-untouched ng-valid ng-not-empty" >收款金额不符&nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="radio" value="2" ${erp15.result_1_code eq '2'?"checked='checked'":'' } class="ng-pristine ng-untouched ng-valid ng-not-empty" >未收到款项
        </div>
    </div>
    <div class="form-group">
		<label class="col-sm-2 control-label">收款日期<i class="red">*</i></label>
		 <div class="col-sm-3">
			<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required" >
  <input id="62_sqrq_${status.index+1}" class="form-control" type="text" ><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
</div>
		</div>  
		<!-- ngIf: task.creditsMoney -->
		<!-- ngIf: task.creditsMoney -->
	</div>
    <!-- ngIf: task.recieveRet==0 -->
	<div class="form-group">
		<label class="col-sm-2 control-label">其它说明</label>
		<div class="col-sm-8">
			<textarea rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text">${erp15.result_1_msg }</textarea>
		</div>
	</div>

	<!-- 根据action确定操作  -->
	<!-- ngIf: !notUseButton -->
	<script>
		var index = ${status.index+1};
		// 62 处理 json ,并给相应的对象赋值
		var objS_62index = JSON.parse($("#inObj_62_${status.index+1}").val()); //由JSON字符串转换为JSON对象
		document.getElementById("62_fkrq_${status.index+1}").value = objS_62index['62_fkrq'];
		document.getElementById("62_fkje_${status.index+1}").value = objS_62index['62_fkje'];
		document.getElementById("62_sqrq_${status.index+1}").value = objS_62index['62_sqrq'];
	</script>
</form>
</div>                                             
</div>									  	
</li>
</c:if>
</c:if>
<c:if test="${erp15.status eq '63'}">
<li class="text-primary">
<em>${status.index+1}.${erp15.taskname_name}：</em>
<div class="big-conte" style="display: none;">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
<fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong>
<fmt:formatDate value="${erp15.dt_edit}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong>${erp15.gname1 }</div>
<strong style="margin-left:10px;">
<i>处理信息：</i></strong><br>
<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form id="yhdksh_63" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
	<div class="form-group">
		<label class="col-sm-2 control-label">检查结果</label>
		<div class="col-sm-8">
			<input name="result_1_code" ${erp15.result_1_code eq '1'?"checked='checked'":'' } class="ng-pristine ng-untouched ng-valid ng-not-empty" type="radio" value="1"  ng-model="task.auditRet">完整
	            &nbsp;&nbsp;&nbsp;&nbsp;
	        <input name="result_1_code" ${erp15.result_1_code eq '2'?"checked='checked'":'' } class="ng-pristine ng-untouched ng-valid ng-not-empty" type="radio" value="2" ng-model="task.auditRet">材料不完整，需要机构补充
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">其它说明</label>
		<div class="col-sm-8">
			<textarea rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text">${erp15.result_1_msg }</textarea>
		</div>
	</div> 
	<!-- ngIf: !notUseButton -->
</form>
</div>
</div>   							  	
</li>	
</c:if>

<c:if test="${erp15.status eq '64'}">
<li class="text-primary">
<li class="text-primary">
<em>${status.index+1 }.${erp15.taskname_name }：</em>
<div class="big-conte" style="display: none;">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
<fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong>
<fmt:formatDate value="${erp15.dt_edit}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong>${erp15.gname1 }</div>
<strong style="margin-left:10px;">
<i>处理信息：</i></strong><br>
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<strong>材料已补充上传，请查看材料页签 </strong>
</div>
</div>
</li>
</c:if>


		<c:choose>
			<c:when test="${erp15.status eq '65'}">
				<li class="text-primary"><em>${status.index+1 }.完成：</em>
					<div class="big-conte" style="display: none;">
						<div style="float: left; margin-left: 20px; width: 260px;">
							<strong>完成时间：</strong>
							<fmt:formatDate value="${erp15.dt_edit}"
								pattern="yyyy-MM-dd HH:mm:ss" />
						</div>
					</div></li>
			</c:when>
			<c:otherwise>
			<c:if test="${status.last}">
				<jsp:include page="/kjs_icbc/model_son/starutil.jsp">
					<jsp:param value="${erp15.dt_edit }" name="sdate" />
					<jsp:param value="${requestScope.sh_name }" name="sname" />
					<jsp:param value="${status.index+2 }" name="snum" />
				</jsp:include>
				</c:if>
			</c:otherwise>
		</c:choose>
	

</c:forEach>
							</ol>
		            	</div>
		            	<script>
		            	function showradio(id,value) {
		            	    	switch(value){
		            	    	  case "1":
		            	    		  $("#"+id+"2").removeAttr("checked");
		            	    		  $("#"+id+"3").removeAttr("checked");
		            	    	   break;
		            	    	  case "2":
		            	    		  $("#"+id+"3").removeAttr("checked");
		            	    		  $("#"+id+"1").removeAttr("checked");
		            	    	   break;
		            	    	  case "3":
		            	    		  $("#"+id+"1").removeAttr("checked");
		            	    		  $("#"+id+"2").removeAttr("checked");
		            	    	   break;
		            	    	  default:
		            	    	   break;
		            	    	 }
		            	    };

		            		$(".text-primary em").click(function(){
		            			$(this).next(".big-conte").slideToggle();
		            		})
		            		//全部展开
		            		function funUnfold(){
		            			$(".big-conte").slideDown();
		            		}
		            		//全部关闭
		            		function funClose(){
		            			$(".big-conte").slideUp();
		            		}
		            	</script>
		            	<div class="flex-row flex-row-rhcen">
		            		<em onclick="funUnfold()" class="text-muted">全部展开</em> 
		            		<em onclick="funClose()" class="text-muted">全部收起</em> 
		            	</div>
		            </div>