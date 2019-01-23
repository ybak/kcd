<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
.flex-box {
	display: flex;
	flex-direction: column;
}

.flex-box div[class^='flex-row'] {
	width: 100%;
}

.flex-box .flex-row {
	height: 35px;
}

.flex-row-rhcen {
	display: flex;
	justify-content: flex-end;
	align-items: center;
}

em {
	cursor: pointer;
}

.flex-row-rhcen em {
	padding: 0 5px;
}

.flex-rowcen {
	flex: 1;
}

.text-primary em {
	display: block;
	font-size: 15px;
	line-height: 25px;
}

.text-primary .big-conte {
	background-color: #f7f7f7;
	height: auto !important;
	height: 100px;
	display: none;
	min-height: 100px;
	padding: 15px 0;
	margin: 15px 0;
	border-radius: 10px;
}

.big-conte-row span {
	text-align: right;
	padding-right: 15px;
	line-height: 34px;
	width: 25%;
	float: left;
}

.big-conte-row input {
	float: left;
	width: 20%;
}

.big-conte-row {
	margin: 20px;
	height: 34px;
}
</style>
<%
	request.setCharacterEncoding("utf-8");
%>
<div class="modal-body flex-box" style="height: auto;">
	<div class="flex-row flex-row-rhcen">
		<em onclick="funUnfold()" class="text-muted">全部展开</em> <em
			onclick="funClose()" class="text-muted">全部收起</em>
	</div>
	<div class="flex-rowcen">
		<ol>
			<c:forEach var="erp15" items="${requestScope.erp15 }"
				varStatus="status">
				<textarea id="dygd_${erp15.status}_${status.index+1 }"
					name="dygd_${erp15.status}_${status.index+1 }"
					style="display: none;">${erp15.result_1_value }</textarea>
				<c:if test="${erp15.status eq '72'}">
					<li class="text-primary"><em>${status.index+1 }.${erp15.taskname_name }：</em>
						<div class="big-conte" style="display: none;">
							<div style="float: left; margin-left: 20px; width: 260px;">
								<strong>开始时间：</strong>
								<fmt:formatDate value="${erp15.dt_add}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</div>
							<div style="float: left; margin-left: 20px; width: 260px;">
								<strong>处理人：</strong>${erp15.gname1 }
							</div>
						</div></li>
				</c:if>
				<c:if test="${erp15.status eq '73'}">
					<li class="text-primary"><em>${status.index+1 }.${erp15.taskname_name }：</em>
						<div class="big-conte" style="display: none;">
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>开始时间：</strong>
								<fmt:formatDate value="${erp15.dt_add}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</div>
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>处理时间：</strong>
								<fmt:formatDate value="${erp15.dt_edit}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</div>
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>处理人：</strong>${erp15.gname1 }</div>
							<strong style="margin-left: 10px;"><i>处理信息：</i></strong><br>
							<div class="task_margin ng-scope"
								style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">
								<form name="modalForm"
									class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
		<div class="form-group">
		<label class="col-sm-2 control-label">开始日期</label>
		<div class="col-sm-3">
		<div class="input-group date ng-isolate-scope ng-not-empty ng-valid">
			<input class="form-control" id="${erp15.status}_ksrq_${status.index+1 }" name="${erp15.status}_ksrq_${status.index+1 }" value="" >
		<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
		</div>
		</div>
        </div>
		<div class="form-group">
		<label class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea rows="3" id="bz" name="bz" class="form-control" type="text" >${erp15.result_1_msg }</textarea>
		</div>
</div>
<script type="text/javascript">
$(document).ready(function(){	
	var dygd_73=document.getElementById("dygd_"+'${erp15.status}'+"_"+'${status.index+1 }').value;
	if(dygd_73!=null){
		var json = jQuery.parseJSON(dygd_73);
		for ( var item in json) {
			$("#"+item+"_${status.index+1 }").val(json[item]);
		}
	}
});

</script>
									</form>
									</div>
									</div>
									</li>
				</c:if>
				<c:if test="${erp15.status eq '74'}">
					<li class="text-primary"><em>${status.index+1 }.${erp15.taskname_name }：</em>
						<div class="big-conte" style="display: none;">
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>开始时间：</strong>
								<fmt:formatDate value="${erp15.dt_add}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</div>
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>处理时间：</strong>
								<fmt:formatDate value="${erp15.dt_edit}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</div>
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>处理人：</strong>${erp15.gname1 }</div>
							<strong style="margin-left: 10px;"><i>处理信息：</i></strong><br>
							<div class="task_margin ng-scope"
								style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">
								<form name="modalForm"
									class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
									<!-- 	<div class="form-group" ng-if="notUseButton && task.postRet != null">
		<label class="col-sm-2 control-label">收件确认</label>
		<div class="col-sm-6">
			<input type="radio" value="1" ng-model="task.postRet" disabled="true">已收到
	            &nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="radio" value="0" ng-model="task.postRet" disabled="true">未收到
		</div>
	</div> -->
									<!-- ngIf: (rootData.taskDefKey == 'loanOrder_postinfo_send' || (task.notarizeEndDate !=null))&&task.justRecord==true -->
									<div class="form-group">
										<label class="col-sm-2 control-label">快递公司</label>
										<div class="col-sm-3">
											<input id="${erp15.status}_kdgs_${status.index+1 }" name="${erp15.status}_kdgs_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-empty">
										</div>
										<!-- ngIf: rootData.taskDefKey == 'loanOrder_postinfo_send'||($parent.taskAct.activityId=='loanOrder_postinfo_send'&&notUseButton) -->
										<div
											ng-if="rootData.taskDefKey == 'loanOrder_postinfo_send'||($parent.taskAct.activityId=='loanOrder_postinfo_send'&amp;&amp;notUseButton)"
											class="ng-scope">
											<label class="col-sm-2 control-label">合同编码</label>
											<div class="col-sm-3">
												<input id="${erp15.status}_htbm_${status.index+1 }" name="${erp15.status}_htbm_${status.index+1 }"
													class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
													value="FQ-QC-12020212-201">
											</div>
										</div>
										<!-- end ngIf: rootData.taskDefKey == 'loanOrder_postinfo_send'||($parent.taskAct.activityId=='loanOrder_postinfo_send'&&notUseButton) -->
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">快递单号</label>
										<div class="col-sm-3">
											<input id="${erp15.status}_kddh_${status.index+1 }" name="${erp15.status}_kddh_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-empty">
										</div>
										<label class="col-sm-2 control-label">寄出日期<i
											class="red">*</i></label>
										<div class="col-sm-3">
											<div
												class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required">
												<input id="${erp15.status}_jcrq_${status.index+1 }" name="${erp15.status}_jcrq_${status.index+1 }" class="form-control" type="text"><span
													class="input-group-addon"><i class="fa fa-calendar"></i></span>
											</div>
										</div>
									</div>
<!-- 									ngIf: !notUseButton
									<br>
									<div style="overflow: hidden; margin-left: 7%">
										ngRepeat: img in task.filepathlist
									</div>
									ngIf: rootData.taskDefKey!='loanOrder_postinfo_return'
									<div style="overflow: hidden; margin-left: 7%" class="ng-scope">
										ngRepeat: img in task.filepathlist
									</div>
									end ngIf: rootData.taskDefKey!='loanOrder_postinfo_return'
									<div class="clear" style="margin-top: 10%"></div>
									<div class="form-group ng-hide">
										<label class="col-sm-2 control-label">车牌号码</label>
										<div class="col-sm-3">
											<input id="bz" name="bz"
												class="form-control ng-pristine ng-untouched ng-valid ng-empty"
												type="text">
										</div>
									</div> -->
									<div class="form-group">
										<label class="col-sm-2 control-label">备注</label>
										<div class="col-sm-8">
											<textarea rows="3" id="bz" name="bz"
												class="form-control ng-pristine ng-untouched ng-valid ng-empty"
												type="text">${erp15.result_1_msg }</textarea>
										</div>
									</div>
									<!-- ngIf: !notUseButton -->
<script type="text/javascript">
$(document).ready(function(){	
	var dygd_74=document.getElementById("dygd_"+'${erp15.status}'+"_"+'${status.index+1 }').value;
	if(dygd_74!=null){
		var json = jQuery.parseJSON(dygd_74);
		for ( var item in json) {
			$("#"+item+"_${status.index+1 }").val(json[item]);
		}
	}
});

</script>
								</form>
							</div>
						</div></li>
				</c:if>
				<c:if test="${erp15.status eq '75'}">
					<li class="text-primary"><em>${status.index+1 }.${erp15.taskname_name }：</em>
						<div class="big-conte" style="display: none;">
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>开始时间：</strong>
								<fmt:formatDate value="${erp15.dt_add}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</div>
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>处理时间：</strong>
								<fmt:formatDate value="${erp15.dt_edit}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</div>
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>处理人：</strong>${erp15.gname1 }</div>
							<strong style="margin-left: 10px;"><i>处理信息：</i></strong><br>
							<div class="task_margin ng-scope"
								style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">
								<form name="modalForm"
									class="form-horizontal ng-pristine ng-valid ng-scope">
									<div class="form-group">
										<label class="col-sm-2 control-label">收件确认</label>
										<div class="col-sm-3">
										<input class="form-control" id="${erp15.status}_sjqr_${status.index+1 }" name="${erp15.status}_sjqr_${status.index+1 }" />
										</div>
										<label class="col-sm-3 control-label">收件日期</label>
										<div class="col-sm-3">
											<div
												class="input-group date ng-isolate-scope ng-not-empty ng-valid">
												<input id="${erp15.status}_ksrq_${status.index+1 }" name="${erp15.status}_ksrq_${status.index+1 }" class="form-control" type="text">
												<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">材料复核结果</label>
										<div class="col-sm-3">
										<input class="form-control" id="${erp15.status}_clfh_${status.index+1 }" name="${erp15.status}_clfh_${status.index+1 }" />		
										</div>
										<!-- ngIf: rootData.taskDefKey=='postget'||taskAct.activityId=='postget' -->
										<!-- ngIf: rootData.taskDefKey=='loanOrder_postget_asun'||rootData.taskDefKey=='loanOrder_postget_bank'||taskAct.activityId=='loanOrder_postget_asun'||taskAct.activityId=='loanOrder_postget_bank' -->
									</div>
									<!-- ngIf: (rootData.taskDefKey&&rootData.taskDefKey =='loanOrder_postget_asun')||(taskAct.activityId&&taskAct.activityId=='loanOrder_postget_asun') -->
									<!-- ngIf: (rootData.taskDefKey&&rootData.taskDefKey == 'loanOrder_postget_asun')||(taskAct.activityId&&taskAct.activityId=='loanOrder_postget_asun') -->
									<!-- ngIf: (rootData.taskDefKey&&rootData.taskDefKey == 'loanOrder_postget_asun')||(taskAct.activityId&&taskAct.activityId=='loanOrder_postget_asun') -->
									<!-- ngIf: (rootData.taskDefKey=='loanOrder_postget_bank'||rootData.taskDefKey=='loanOrder_postget_asun')&&!notUseButton -->
									<!-- ngIf: rootData.taskDefKey=='loanOrder_postget_org'||taskAct.activityId=='loanOrder_postget_org' -->
									<div class="ng-scope">
										<!-- ngIf: !notUseButton -->
										<div class="form-group">
											<label class="col-sm-2 control-label">登记证书</label>
										</div>
										<div style="overflow: hidden; margin-left: 7%;">
										
											<div id="img_75_${status.index+1 }"
											style="float: left; left: 5px; margin-top: 20px"
											class="ng-scope"></div>
													
										</div>
									</div>
									<!-- end ngIf: rootData.taskDefKey=='loanOrder_postget_org'||taskAct.activityId=='loanOrder_postget_org' -->
									<div style="margin-top: 5%" class="clear"></div>
									<div class="form-group">
										<label class="col-sm-2 control-label">备注</label>
										<div class="col-sm-8">
											<textarea rows="3" id="result_1_msg_${status.index+1 }"  name="result_1_msg_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-empty"
												type="text">
												</textarea>
										</div>
									</div>
									<!-- ngIf: !notUseButton -->
									<script type="text/javascript">
$(document).ready(function(){	
	var dygd_75=document.getElementById("dygd_"+'${erp15.status}'+"_"+'${status.index+1 }').value;
	if(dygd_75!=null){
		var dd = document.getElementById("img_75_"+'${status.index+1 }');
		var json = jQuery.parseJSON(dygd_75);
		for ( var item in json) {
			if (item.match('bcimg')) {
				$(dd).append("<div class='fileUpload_preview' style='margin-top:5px;'>"
										+ "<li>"
										+ "<img onclick='dygdModal_image(this)' id='"+item+"_"+${status.index+1 }+"' name='"+item+"_"+${status.index+1 }+"' class='fileUpload_preview fileUpload_preview-small fileUpload_preview-square' src='http://a.kcway.net/assess/"+json[item]+"'>"
										+ "</li>"
										+ "<div class='btn btn-primary btn-download'>↓</div>"
										+ "<div id='close"+item+"' class='btn btn-danger btn-close'>x</div>"
										+ "</div>");
			} else {
				$("#" + item+"_"+'${status.index+1 }').val(json[item]);
			}
		}
	}
});
                                 </script>
								</form>
							</div>
						</div></li>
				</c:if>
				<script type="text/javascript">
				function dygdModal_image(obj){
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
		    	    $("#dygdModal_iframe").attr("src","${pageContext.request.contextPath}/jquery-photo-gallery/gallerys.jsp");
		    	     //显示模态框  只有在选择编辑的行   然后根据回调函数成功后才会显示模态框
		    	    $('#dygdModal').modal({ show: true, backdrop: 'static' });
				}
				
				</script>
<div class="modal fade" id="dygdModal" tabindex="-1" role="dialog" aria-labelledby="dygdModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title" align="center" id="dygdModalLabel">图片预览</h4>
	            </div>
	            <div class="modal-body" style="height:750px;">
	            <iframe id="dygdModal_iframe" width="100%" height="100%" frameborder="0"></iframe>
	            (左右键控制上一张,下一张)
	            </div>
	            <div class="modal-footer">
	                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div>
	    </div>
</div>
				<c:if test="${erp15.status eq '76'}">
					<li class="text-primary"><em>${status.index+1 }.${erp15.taskname_name }：</em>
						<div class="big-conte" style="display: none;">
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>开始时间：</strong>
								<fmt:formatDate value="${erp15.dt_add}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</div>
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>处理时间：</strong>
								<fmt:formatDate value="${erp15.dt_edit}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</div>
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>处理人：</strong>${erp15.gname1 }</div>
							<strong style="margin-left: 10px;"><i>处理信息：</i></strong><br>
							<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
							<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
							<div class="task_margin ng-scope"
								style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">
								<form name="modalForm"
									class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required ng-valid-pattern ng-valid-maxlength">
									<div class="form-group">
										<label class="col-sm-2 control-label">车牌号码<i
											class="red">*</i></label>
										<div class="col-sm-3">
											<input id="${erp15.status}_cphm_${status.index+1 }" name="${erp15.status}_cphm_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required ng-valid-pattern ng-valid-maxlength"
												type="text"
												pattern="([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}(([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳]{1})"
												maxlength="8" ng-model="task.plateNum" cg-required=""
												required="required">
										</div>
										<!-- 		<div ng-if="rootData.taskDefKey!='loanOrder_plegeinfo_bank'"> -->
										<!-- 			<label class="col-sm-2 control-label" ng-if="task.isNewCar==null||task.isNewCar==1">上牌日期</label> -->
										<!-- 			<div class="col-sm-3" ng-if="task.isNewCar==1"> -->
										<!-- 			<cg-datepicker ng-model="task.applyDate" cg-required></cg-datepicker> -->
										<!-- 			</div> -->
										<!-- 			<label class="col-sm-2 control-label" ng-if="task.isNewCar==0">过户日期</label> -->
										<!-- 			<div class="col-sm-3" ng-if="task.isNewCar==0"> -->
										<!-- 			<cg-datepicker ng-model="task.applyDate" cg-required></cg-datepicker> -->
										<!-- 			</div> -->
										<!-- 		</div> -->
										<div>
											<label class="col-sm-2 control-label">抵押完成日期<i
												class="red">*</i></label>
											<div class="col-sm-3">
												<div 
													class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required">
													<input id="${erp15.status}_dywcrq_${status.index+1 }" name="${erp15.status}_dywcrq_${status.index+1 }" class="form-control" type="text"><span
														class="input-group-addon"><i class="fa fa-calendar"></i></span>
												</div>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">登记证书号<i
											class="red">*</i></label>
										<div class="col-sm-3">
											<input id="${erp15.status}_djzsh_${status.index+1 }" name="${erp15.status}_djzsh_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
												type="text">
										</div>
										<label class="col-sm-2 control-label">抵押办理人员<i
											class="red">*</i></label>
										<div class="col-sm-3">
											<input id="${erp15.status}_dyblry_${status.index+1 }" name="${erp15.status}_dyblry_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
												type="text">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">上牌方式</label>
										<div class="col-sm-3">
											<input  id="${erp15.status}_spfs_${status.index+1 }" name="${erp15.status}_spfs_${status.index+1 }" value="" class="form-control">
										</div>
										<label class="col-sm-2 control-label">车辆类别</label>
										<!-- ngIf: rootData.editFlag!='1' && rootData.editFlag!='-1' -->
										<div class="col-sm-3 ng-scope">
											<input  id="${erp15.status}_cplb_${status.index+1 }" name="${erp15.status}_cplb_${status.index+1 }" value="" class="form-control">
										</div>
										<!-- end ngIf: rootData.editFlag!='1' && rootData.editFlag!='-1' -->
									</div>	
									<div class="form-group">
										<label class="col-sm-2 control-label">查验情况</label>
										<div class="col-sm-3">
											<input  id="${erp15.status}_cyqk_${status.index+1 }" name="${erp15.status}_cyqk_${status.index+1 }" value="" class="form-control">
										</div>
									</div>									
									<div class="form-group">
										<label class="col-sm-2 control-label"
											style="margin-top: 57px;">其它说明</label>
										<div class="col-sm-8" style="margin-top: 40px;">
											<textarea rows="3" id="result_1_msg_${status.index+1 }" name="result_1_msg_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-empty"
												type="text"></textarea>
										</div>
									</div>
									<!-- ngIf: !notUseButton -->
<script type="text/javascript">
$(document).ready(function(){	
	var dygd_76=document.getElementById("dygd_"+'${erp15.status}'+"_"+'${status.index+1 }').value;
	if(dygd_76!=null){
		var json = jQuery.parseJSON(dygd_76);
		for ( var item in json) {
				$("#" + item+"_"+'${status.index+1 }').val(json[item]);
		}
	}
});

</script>
								</form>
							</div>
						</div></li>
				</c:if>
				<c:if test="${erp15.status eq '77'}">
					<li class="text-primary"><em>${status.index+1 }.${erp15.taskname_name }：</em>
						<div class="big-conte" style="display: none;">
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>开始时间：</strong>
								<fmt:formatDate value="${erp15.dt_add}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</div>
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>处理时间：</strong>
								<fmt:formatDate value="${erp15.dt_edit}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</div>
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>处理人：</strong>${erp15.gname1 }</div>
							<strong style="margin-left: 10px;"><i>处理信息：</i></strong><br>
							<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
							<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
							<div class="task_margin ng-scope"
								style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">
								<form name="modalForm"
									class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">

									<div class="form-group">
										<label class="col-sm-2 control-label">快递公司</label>
										<div class="col-sm-3">
											<input id="${erp15.status}_kdgs_${status.index+1 }"  name="${erp15.status}_kdgs_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-not-empty">
										</div>
										<!-- ngIf: rootData.taskDefKey == 'loanOrder_postinfo_send'||($parent.taskAct.activityId=='loanOrder_postinfo_send'&&notUseButton) -->
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">快递单号</label>
										<div class="col-sm-3">
											<input id="${erp15.status}_kddh_${status.index+1 }"  name="${erp15.status}_kddh_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-not-empty">
										</div>
										<label class="col-sm-2 control-label">寄出日期<i
											class="red">*</i></label>
										<div class="col-sm-3">
											<div
												class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required">
												<input id="${erp15.status}_jcrq_${status.index+1 }"  name="${erp15.status}_jcrq_${status.index+1 }" class="form-control" type="text"><span
													class="input-group-addon"><i class="fa fa-calendar"></i></span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">备注</label>
										<div class="col-sm-8">
											<textarea rows="3"  id="result_1_msg_${status.index+1 }"  name="result_1_msg_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-empty"
												type="text"></textarea>
										</div>
									</div>
									<!-- ngIf: !notUseButton -->
<script type="text/javascript">
$(document).ready(function(){	
	var dygd_77=document.getElementById("dygd_"+'${erp15.status}'+"_"+'${status.index+1 }').value;
	if(dygd_77!=null){
		var json = jQuery.parseJSON(dygd_77);
		for ( var item in json) {
				$("#" + item+"_"+'${status.index+1 }').val(json[item]);
		}
	}
});

</script>
								</form>
							</div>
						</div></li>
				</c:if>
				<c:if test="${erp15.status eq '78'}">
					<li class="text-primary"><em>${status.index+1 }.${erp15.taskname_name }：</em>
						<div class="big-conte" style="display: none;">
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>开始时间：</strong>
								<fmt:formatDate value="${erp15.dt_add}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</div>
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>处理时间：</strong>
								<fmt:formatDate value="${erp15.dt_edit}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</div>
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>处理人：</strong>${erp15.gname1 }</div>
							<strong style="margin-left: 10px;"><i>处理信息：</i></strong><br>
							<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
							<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
							<div class="task_margin ng-scope"
								style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">
								<form name="modalForm"
									class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
									<div class="form-group">
										<label class="col-sm-2 control-label">收件确认</label>
										<div class="col-sm-3">
											<input id="${erp15.status}_sjqr_${status.index+1 }" name="${erp15.status}_sjqr_${status.index+1 }" class="form-control"  />
										</div>
										<label class="col-sm-2 control-label">收件日期</label>
										<div class="col-sm-3">
											<div
												class="input-group date ng-isolate-scope ng-empty ng-valid">
												<input id="${erp15.status}_ksrq_${status.index+1 }" name="${erp15.status}_ksrq_${status.index+1 }" class="form-control" type="text"><span
													class="input-group-addon"><i class="fa fa-calendar"></i></span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">材料复核结果</label>
										<div class="col-sm-3">
											<input id="${erp15.status}_clfh_${status.index+1 }" name="${erp15.status}_clfh_${status.index+1 }" class="form-control"  />
										</div>
										<!-- ngIf: rootData.taskDefKey=='postget'||taskAct.activityId=='postget' -->
										<!-- ngIf: rootData.taskDefKey=='loanOrder_postget_asun'||rootData.taskDefKey=='loanOrder_postget_bank'||taskAct.activityId=='loanOrder_postget_asun'||taskAct.activityId=='loanOrder_postget_bank' -->
										<span class="ng-scope"> <label
											class="col-sm-2 control-label">车牌号码</label>
											<div class="col-sm-3">
												<input id="${erp15.status}_cphm_${status.index+1 }" name="${erp15.status}_cphm_${status.index+1 }"
						 							class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
													type="text">
											</div>
										</span>
								   </div>
									<div class="form-group">
										<label class="col-sm-2 control-label">备注</label>
										<div class="col-sm-8"> 
											<textarea rows="3"  id="result_1_msg_${status.index+1 }" name="result_1_msg_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-empty"
												type="text"></textarea>
										</div>
									</div>
									<!-- ngIf: !notUseButton -->
									<script type="text/javascript">
$(document).ready(function(){	
	var dygd_78=document.getElementById("dygd_"+'${erp15.status}'+"_"+'${status.index+1 }').value;
	if(dygd_78!=null){
		var json = jQuery.parseJSON(dygd_78);
		for ( var item in json) {
				$("#" + item+"_"+'${status.index+1 }').val(json[item]);
		}
	}
});

</script>
								</form>
							</div>
						</div></li>
				</c:if>
				<c:if test="${erp15.status eq '79'}">
					<li class="text-primary"><em>${status.index+1 }.${erp15.taskname_name }：</em>
						<div class="big-conte" style="display: none;">
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>开始时间：</strong>
								<fmt:formatDate value="${erp15.dt_add}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</div>
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>处理时间：</strong>
								<fmt:formatDate value="${erp15.dt_edit}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</div>
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>处理人：</strong>${erp15.gname1 }</div>
							<strong style="margin-left: 10px;"><i>处理信息：</i></strong><br>
							<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
							<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
							<div class="task_margin ng-scope"
								style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">
								<form name="modalForm"
									class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
                                    <div class="form-group">
										<label class="col-sm-2 control-label">快递公司</label>
										<div class="col-sm-3">
											<input id="${erp15.status}_kdgs_${status.index+1 }" name="${erp15.status}_kdgs_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-empty">
										</div>
										<!-- ngIf: rootData.taskDefKey == 'loanOrder_postinfo_send'||($parent.taskAct.activityId=='loanOrder_postinfo_send'&&notUseButton) -->
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">快递单号</label>
										<div class="col-sm-3">
											<input id="${erp15.status}_kddh_${status.index+1 }" name="${erp15.status}_kddh_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-empty">
										</div>
										<label class="col-sm-2 control-label">寄出日期<i
											class="red">*</i></label>
										<div class="col-sm-3">
											<div 
												class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required">
												<input id="${erp15.status}_jcrq_${status.index+1 }" name="${erp15.status}_jcrq_${status.index+1 }" class="form-control" type="text"><span
													class="input-group-addon"><i class="fa fa-calendar"></i></span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">备注</label>
										<div class="col-sm-8">
											<textarea rows="3" id="result_1_msg_${status.index+1 }" name="result_1_msg_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-empty"
												type="text"></textarea>
										</div>
									</div>
									<!-- ngIf: !notUseButton -->
									<script type="text/javascript">
$(document).ready(function(){	
	var dygd_79=document.getElementById("dygd_"+'${erp15.status}'+"_"+'${status.index+1 }').value;
	if(dygd_79!=null){
		var json = jQuery.parseJSON(dygd_79);
		for ( var item in json) {
				$("#" + item+"_"+'${status.index+1 }').val(json[item]);
		}
	}
});

</script>
								</form>
							</div>
						</div></li>
				</c:if>
				<c:if test="${erp15.status eq '80'}">
					<li class="text-primary"><em>${status.index+1 }.${erp15.taskname_name }：</em>
						<div class="big-conte" style="display: none;">
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>开始时间：</strong>
								<fmt:formatDate value="${erp15.dt_add}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</div>
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>处理时间：</strong>
								<fmt:formatDate value="${erp15.dt_edit}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</div>
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>处理人：</strong>${erp15.gname1 }</div>
							<strong style="margin-left: 10px;"><i>处理信息：</i></strong><br>
							<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
							<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
							<div class="task_margin ng-scope"
								style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">
								<form name="modalForm"
									class="form-horizontal ng-pristine ng-valid ng-scope">
									<div class="form-group">
										<label class="col-sm-2 control-label">收件确认</label>
										<div class="col-sm-3">
											<input id="${erp15.status}_sjqr_${status.index+1 }" name="${erp15.status}_sjqr_${status.index+1 }"  class="form-control"/>
										</div>
										<label class="col-sm-3 control-label">收件日期</label>
										<div class="col-sm-3">
											<div
												class="input-group date ng-isolate-scope ng-empty ng-valid">
												<input id="${erp15.status}_ksrq_${status.index+1 }" name="${erp15.status}_ksrq_${status.index+1 }" class="form-control" type="text"><span
													class="input-group-addon"><i class="fa fa-calendar"></i></span>
											</div>
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">材料复核结果</label>
										<div class="col-sm-3">
											<input id="${erp15.status}_clfh_${status.index+1 }" name="${erp15.status}_clfh_${status.index+1 }"  class="form-control"/>
										</div>
										<!-- ngIf: rootData.taskDefKey=='postget'||taskAct.activityId=='postget' -->
										<!-- ngIf: rootData.taskDefKey=='loanOrder_postget_asun'||rootData.taskDefKey=='loanOrder_postget_bank'||taskAct.activityId=='loanOrder_postget_asun'||taskAct.activityId=='loanOrder_postget_bank' -->
										<span class="ng-scope"> <label
											class="col-sm-3 control-label">车牌号码</label>
											<div class="col-sm-3">
												<input id="${erp15.status}_cphm_${status.index+1 }" name="${erp15.status}_cphm_${status.index+1 }"
													class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
													type="text">
											</div>
										</span>
										<!-- end ngIf: rootData.taskDefKey=='loanOrder_postget_asun'||rootData.taskDefKey=='loanOrder_postget_bank'||taskAct.activityId=='loanOrder_postget_asun'||taskAct.activityId=='loanOrder_postget_bank' -->
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">备注</label>
										<div class="col-sm-8">
											<textarea rows="3" id="result_1_msg_${status.index+1 }" name="result_1_msg_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-empty"
												type="text"></textarea>
										</div>
									</div>
									<!-- ngIf: !notUseButton -->
																		<script type="text/javascript">
$(document).ready(function(){	
	var dygd_80=document.getElementById("dygd_"+'${erp15.status}'+"_"+'${status.index+1 }').value;
	if(dygd_80!=null){
		var json = jQuery.parseJSON(dygd_80);
		for ( var item in json) {
				$("#" + item+"_"+'${status.index+1 }').val(json[item]);
		}
	}
});

</script>
								</form>
							</div>
						</div></li>
				</c:if>
				<c:if test="${erp15.status eq '81'}">
					<li class="text-primary"><em>${status.index+1 }.${erp15.taskname_name }：</em>
						<div class="big-conte" style="display: none;">
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>开始时间：</strong>
								<fmt:formatDate value="${erp15.dt_add}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</div>
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>处理时间：</strong>
								<fmt:formatDate value="${erp15.dt_edit}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</div>
							<div style="float: left; margin-left: 20px; width: 260px;"
								class="ng-binding">
								<strong>处理人：</strong>${erp15.gname1 }</div>
							<strong style="margin-left: 10px;"><i>处理信息：</i></strong><br>
							<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
							<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
							<div class="task_margin ng-scope"
								style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">
								<form name="modalForm"
									class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required ng-valid-pattern ng-valid-maxlength">
									<div class="form-group">
										<label class="col-sm-2 control-label">车牌号码<i
											class="red">*</i></label>
										<div class="col-sm-3">
											<input id="${erp15.status }_cphm_${status.index+1 }"  name="${erp15.status }_cphm_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required ng-valid-pattern ng-valid-maxlength"
												type="text"
												pattern="([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}(([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳]{1})"
												maxlength="8" ng-model="task.plateNum" cg-required=""
												required="required">
										</div>
											<label class="col-sm-2 control-label">抵押完成日期<i class="red">*</i></label>
											<div class="col-sm-3">
												<div
													class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required">
													<input id="${erp15.status }_dywcrq_${status.index+1 }"  name="${erp15.status }_dywcrq_${status.index+1 }" class="form-control" type="text"><span
														class="input-group-addon"><i class="fa fa-calendar"></i></span>
												</div>
											</div>
										
									</div>
								
									<div class="form-group">
										<label class="col-sm-2 control-label">登记证书号<i
											class="red">*</i></label>
										<div class="col-sm-3">
											<input id="${erp15.status }_djzsh_${status.index+1 }"  name="${erp15.status }_djzsh_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
												type="text">
										</div>
										<label class="col-sm-2 control-label">抵押办理人员<i
											class="red">*</i></label>
										<div class="col-sm-3">
											<input id="${erp15.status }_dyblry_${status.index+1 }"  name="${erp15.status }_dyblry_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
												type="text">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">上牌方式</label>
										<div class="col-sm-3">
											<input id="${erp15.status }_spfs_${status.index+1 }"  name="${erp15.status }_spfs_${status.index+1 }"
												class="form-control"
												type="text">
										</div>
										<label class="col-sm-2 control-label">车辆类别</label>
										<!-- ngIf: rootData.editFlag!='1' && rootData.editFlag!='-1' -->
										<div class="col-sm-3 ng-scope">
										<input id="${erp15.status }_cllb_${status.index+1 }"  name="${erp15.status }_cllb_${status.index+1 }"
												class="form-control"
												type="text">
										</div>
										<!-- end ngIf: rootData.editFlag!='1' && rootData.editFlag!='-1' -->
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label">查验情况</label>
										<div class="col-sm-3">
											<input id="${erp15.status }_cyqk_${status.index+1 }"  name="${erp15.status }_cyqk_${status.index+1 }"
												class="form-control"
												type="text">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label"
											>其它说明</label>
										<div class="col-sm-8">
											<textarea rows="3" id="result_1_msg_${status.index+1 }" name="result_1_msg_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-empty"
												type="text"></textarea>
										</div>
									</div>
									<!-- ngIf: !notUseButton -->
																		<script type="text/javascript">
$(document).ready(function(){	
	var dygd_81=document.getElementById("dygd_"+'${erp15.status}'+"_"+'${status.index+1 }').value;
	if(dygd_81!=null){
		var json = jQuery.parseJSON(dygd_81);
		for ( var item in json) {
				$("#" + item+"_"+'${status.index+1 }').val(json[item]);
		}
	}
});

</script>
								</form>
							</div>
						</div></li>
				</c:if>
				
					<c:choose>
						<c:when test="${erp15.status eq '82'}">
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
		function showradio(id, value) {
			switch (value) {
			case "1":
				$("#" + id + "2").removeAttr("checked");
				$("#" + id + "3").removeAttr("checked");
				break;
			case "2":
				$("#" + id + "3").removeAttr("checked");
				$("#" + id + "1").removeAttr("checked");
				break;
			case "3":
				$("#" + id + "1").removeAttr("checked");
				$("#" + id + "2").removeAttr("checked");
				break;
			default:
				break;
			}
		};

		$(".text-primary em").click(function() {
			$(this).next(".big-conte").slideToggle();
		})
		//全部展开
		function funUnfold() {
			$(".big-conte").slideDown();
		}
		//全部关闭
		function funClose() {
			$(".big-conte").slideUp();
		}
	</script>
	<div class="flex-row flex-row-rhcen">
		<em onclick="funUnfold()" class="text-muted">全部展开</em> <em
			onclick="funClose()" class="text-muted">全部收起</em>
	</div>
</div>