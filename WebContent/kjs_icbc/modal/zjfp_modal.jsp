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

				<textarea id="zjfp_${erp15.status}_${status.index+1 }"
					name="zjfp_${erp15.status}_${status.index+1 }"
					style="display: none;">${erp15.result_1_value }</textarea>
				<c:if test="${erp15.status eq '47'}">
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

				<c:if test="${erp15.status eq '48'}">

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
								<strong>处理人：</strong>${erp15.gname1 }
							</div>
							<strong style="margin-left: 10px;"><i>处理信息：</i></strong><br>
							<div class="task_margin ng-scope"
								style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">
								<form name="modalForm"
									class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">

									<!-- ngIf: notUseButton && taskAct.activityId !='loanOrder_leadercheck_pay' -->
									<!-- ngIf: notUseButton && (rootData.taskDefKey=='loanOrder_leadercheck_pay'||taskAct.activityId=='loanOrder_leadercheck_pay') -->

									<div class="form-group">
										<label class="col-sm-2 control-label">确认垫资申请</label>
										<div class="col-sm-6">
											<select class="form-control" id="dz_type_48_${status.index+1 }"
												name="dz_type_48_${status.index+1 }">
												<option value="0">--请选择--</option>
												<option value="1">不垫资</option>
												<option value="2">提车垫资</option>
											</select>
										</div>
									</div>
									<!-- end ngIf: notUseButton && (rootData.taskDefKey=='loanOrder_leadercheck_pay'||taskAct.activityId=='loanOrder_leadercheck_pay') -->
									<!-- ngIf: rootData.taskDefKey=='loanOrder_leadercheck_pay'||taskAct.activityId=='loanOrder_leadercheck_pay' -->
									<div class="form-group ng-scope">
										<label class="col-sm-2 control-label">可垫资金额(元)</label>
										<div class="col-sm-3">
											<input id="kdzje_48_${status.index+1 }" name="kdzje_48_${status.index+1 }" class="form-control"
												type="text">
										</div>
										<label class="col-sm-2 control-label">需垫资金额(元)<i
											class="red">*</i></label>
										<div class="col-sm-3">
											<input id="xdzje_48_${status.index+1 }" name="xdzje_48_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required"
												type="text">
										</div>
									</div>
									<!-- end ngIf: rootData.taskDefKey=='loanOrder_leadercheck_pay'||taskAct.activityId=='loanOrder_leadercheck_pay' -->
									<!-- ngIf: rootData.taskDefKey=='loanOrder_leadercheck_pay'||taskAct.activityId=='loanOrder_leadercheck_pay' -->
									<div class="form-group ng-scope">
										<!-- 		<div ng-if="rootData.orgType=='ALAN'" > -->
										<label class="col-sm-2 control-label">融资服务费</label>
										<div class="col-sm-3">
											<input id="rzfwf_48_${status.index+1 }" name="rzfwf_48_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
												type="text">
										</div>
										<!-- 		</div> -->
										<label class="col-sm-2 control-label">需垫资日期<i
											class="red">*</i></label>
										<div class="col-sm-3">
											<div
												class="input-group date ng-isolate-scope ng-not-empty ng-valid">
												<input id="xdz_date_48_${status.index+1 }" name="xdz_date_48_${status.index+1 }"
													class="form-control" type="text"> <span
													class="input-group-addon"><i class="fa fa-calendar"></i></span>
											</div>
										</div>
									</div>
									<!-- end ngIf: rootData.taskDefKey=='loanOrder_leadercheck_pay'||taskAct.activityId=='loanOrder_leadercheck_pay' -->
									<div class="form-group">
										<label class="col-sm-2 control-label">其它意见</label>
										<div class="col-sm-8">
											<textarea rows="3" id="qtyj_48_${status.index+1 }" name="qtyj_48_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-empty"
												type="text"></textarea>
										</div>
									</div>

									<!-- 	<div ng-if="rootData.orgType=='ALAN'" > -->
									<!-- ngIf: !notUseButton&&rootData.taskDefKey=='loanOrder_leadercheck_pay'||taskAct.activityId=='loanOrder_leadercheck_pay' -->
									<div class="btn btn-default btn-sm ng-scope"
										style="margin-left: 7%">
										<div>上传电子凭证</div>
									</div>
									<!-- end ngIf: !notUseButton&&rootData.taskDefKey=='loanOrder_leadercheck_pay'||taskAct.activityId=='loanOrder_leadercheck_pay' -->
									<!-- 			<div ng-repeat="mt in task.filepathlist"> -->
									<!-- 		     	<div type="hidden" ng-init="addImage(mt)"> -->
									<!-- 		     	</div> -->
									<!-- 	     	</div> -->
									<div style="overflow: hidden; margin-left: 7%;">
										<!-- ngRepeat: img in task.filepathlist -->
										<div id="img_48_${status.index+1 }"
											style="float: left; left: 5px; margin-top: 20px"
											class="ng-scope"></div>
										<!-- end ngRepeat: img in task.filepathlist -->
									</div>
									<div class="clear"></div>
									<br> <br>
									<!-- 	</div> -->
									<!-- 根据action确定操作  -->
									<!-- ngIf: !notUseButton -->
									<script type="text/javascript">						
						       $(document).ready(function(){				
							var zjfp_48=document.getElementById("zjfp_"+'${erp15.status}'+"_"+'${status.index+1 }').value;
							if(zjfp_48!=null){
							var dd = document.getElementById("img_48_"+'${status.index+1 }');
							var json = jQuery.parseJSON(zjfp_48);
							for ( var item in json) {
								if (item.match('img')) {
									if(json[item]!=null){
									$(dd).append("<div class='fileUpload_preview' style='margin-top:5px;'>"
															+ "<li>"
															+ "<img id='"+item+"_"+${status.index+1 }+"' name='"+item+"_"+${status.index+1 }+"' class='fileUpload_preview fileUpload_preview-small fileUpload_preview-square' src='http://a.kcway.net/assess/"+json[item]+"'>"
															+ "</li>"
															+ "<div class='btn btn-primary btn-download'>↓</div>"
															+ "<div id='close"+item+"' class='btn btn-danger btn-close'>x</div>"
															+ "</div>");
									}
								} else {
									$("#" + item+"_"+'${status.index+1 }').val(json[item]);
								}
							}
							};
						     });
						   </script>
								</form>
							</div>
						</div></li>

				</c:if>
				<c:if test="${erp15.status eq '52'}">
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
								<strong>处理人：</strong>${erp15.gname1 }
							</div>
							<strong style="margin-left: 10px;"><i>处理信息：</i></strong><br>
							<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
							<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
							<div class="task_margin ng-scope"
								style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">
								<form name="modalForm"
									class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">

									<div class="form-group ng-scope">
										<label class="col-sm-2 control-label">需垫资金额(元)<i
											class="red">*</i></label>
										<div class="col-sm-3">
											<input id="xdzje_52_${status.index+1 }" name="xdzje_52_${status.index+1 }"
												value="${requestScope.xdzje }"
												class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required"
												type="text">
										</div>
										<label class="col-sm-2 control-label">融资服务费</label>
										<div class="col-sm-3">
											<input id="rzfwf_52_${status.index+1 }" name="rzfwf_52_${status.index+1 }"
												value="${requestScope.rzfwf }"
												class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
												type="text">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">收款情况<span
											class="red">*</span></label>
										<div class="col-sm-8">
											<select class="form-control" id="skqk_52_${status.index+1 }" name="skqk_52_${status.index+1 }">
												<option value="0">--请选择--</option>
												<option value="1">到账确认，部分金额待核验</option>
												<option value="2">到账确认，本单已完整</option>
												<option value="3">金额不符</option>
											</select>
										</div>
									</div>
									<!-- ngIf: task.recieveRet==-1 -->
									<div class="form-group">
										<label class="col-sm-2 control-label">其它意见</label>
										<div class="col-sm-8">
											<textarea id="qtyj_52_${status.index+1 }" name="qtyj_52_${status.index+1 }" rows="3"
												class="form-control ng-pristine ng-untouched ng-valid ng-empty"
												type="text"></textarea>
										</div>
									</div>
									<!-- ngIf: !notUseButton -->
									<script type="text/javascript">						
						$(document).ready(function(){						
							var zjfp_52=document.getElementById("zjfp_"+'${erp15.status}'+"_"+'${status.index+1 }').value;
							if(zjfp_52!=null){
							var json = jQuery
									.parseJSON(zjfp_52);
							for ( var item in json) {
								$("#" + item+"_${status.index+1 }").val(json[item]);
							}
							}  
						});
						</script>
								</form>
							</div>
						</div></li>

				</c:if>
				<c:if test="${erp15.status eq '49'}">
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
								<strong>处理人：</strong>${erp15.gname1 }
							</div>
							<strong style="margin-left: 10px;"><i>处理信息：</i></strong><br>
							<div class="task_margin ng-scope"
								style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">
								<form name="modalForm"
									class="form-horizontal ng-pristine ng-valid ng-scope">

									<!-- ngIf: task.fundWay=='FINANCAL' -->
									<!-- ngIf: task.fundWay=='BANK' -->
									<c:choose>
										<c:when test="${pd.dz_type eq '2' }">
											<div class="ng-scope">
												<div class="form-group">
													<label class="col-sm-2 control-label">垫资伙伴</label>
													<div class="col-sm-3">
														<select class="form-control" id="dzhb_49_${status.index+1 }" name="dzhb_49_${status.index+1 }">
															<option value="0">--请选择--</option>
															<option value="1">金锤资产</option>
														</select>
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-2 control-label">垫资日期</label>
													<div class="col-sm-3">
														<div class="input-group">
															<input class="form-control" id="dz_date_49_${status.index+1 }"
																name="dz_date_49_${status.index+1 }" type="text"> <span
																class="input-group-addon"> <i
																class="fa fa-calendar"></i>
															</span>
														</div>
													</div>
													<label class="col-sm-2 control-label">到账金额(元)</label>
													<div class="col-sm-3">
														<input id="dzje_49_${status.index+1 }" name="dzje_49_${status.index+1 }" class="form-control"
															type="text">
													</div>
												</div>
											</div>
										</c:when>
										<c:otherwise>
											<div class="ng-scope">
												<div class="form-group">
													<label class="col-sm-2 control-label">划付日期</label>
													<div class="col-sm-3">
														<div class="input-group date">
															<input id="hf_date_49_${status.index+1 }" name="hf_date_49_${status.index+1 }"
																class="form-control" type="text"> <span
																class="input-group-addon"><i
																class="fa fa-calendar"></i></span>
														</div>
													</div>
													<label class="col-sm-2 control-label">划付金额(元)</label>
													<div class="col-sm-3">
														<input id="hfje_49_${status.index+1 }" name="hfje_49_${status.index+1 }" class="form-control"
															type="text">
													</div>
												</div>
												<div class="form-group">
													<label class="col-sm-2 control-label">代收金额</label>
													<div class="col-sm-3">
														<input id="dsje_49_${status.index+1 }" name="dsje_49_${status.index+1 }" class="form-control"
															type="text">
													</div>
												</div>
											</div>
										</c:otherwise>
									</c:choose>
									<!-- end ngIf: task.fundWay=='BANK' -->
									<!-- <div class="form-group">
		<label class="col-sm-2 control-label">划款账户</label>
		<div class="col-sm-3">
			<input class="form-control" type="text" ng-model="task.payAcctName"/>
		</div>
		<label class="col-sm-2 control-label">划款帐号</label>
		<div class="col-sm-3" >
			<input class="form-control" type="text" ng-model="task.payAcctNo"/>
		</div>
	</div>  -->

									<!-- ngIf: !notUseButton -->
									<script type="text/javascript">						
						$(document).ready(function(){							
							var zjfp_49=document.getElementById("zjfp_"+'${erp15.status}'+"_"+'${status.index+1 }').value;
							if(zjfp_49!=null){
							var json = jQuery
							.parseJSON(zjfp_49);
					         for ( var item in json) {
						$("#" + item+"_${status.index+1 }").val(json[item]);
					         }
							}  
						});
						</script>

								</form>
							</div>
						</div></li>

				</c:if>
				<c:if test="${erp15.status eq '50'}">
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
								<strong>处理人：</strong>${erp15.gname1 }
							</div>
							<strong style="margin-left: 10px;"><i>处理信息：</i></strong><br>
							<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
							<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
							<div class="task_margin ng-scope"
								style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">
								<form name="modalForm"
									class="form-horizontal ng-pristine ng-valid ng-scope">
									<div class="form-group">
										<label class="col-sm-2 control-label">机构名称<i
											class="red">*</i></label>
										<div class="col-sm-3">
											<select class="form-control m-select" name="gems_fs_id_50_${status.index+1 }"
												id="gems_fs_id_50_${status.index+1 }" data-edit-select="1"
												style="display: none;">
												<option value="0">--请选择--</option>
												<c:forEach var="fs" items="${requestScope.fs }">
													<option value="${fs.id }">${fs.namepy }-${fs.name }</option>
												</c:forEach>
											</select>
										</div>
										<label class="col-sm-2 control-label">开户行</label>
										<div class="col-sm-3">
											<input id="kh_bank_50_${status.index+1 }" name="kh_bank_50_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
												type="text">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">开户名</label>
										<div class="col-sm-3">
											<input id="kh_name_50_${status.index+1 }" name="kh_name_50_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
												type="text">
										</div>
										<label class="col-sm-2 control-label">账号</label>
										<div class="col-sm-3">
											<input id="zh_50_${status.index+1 }" name="zh_50_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
												type="text">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-2 control-label">应支付金额(元)</label>
										<div class="col-sm-3">
											<input id="yzfje_50_${status.index+1 }" name="yzfje_50_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
												type="text">
										</div>
										<label class="col-sm-2 control-label">服务费(元)</label>
										<div class="col-sm-3">
											<input id="fwf_50_${status.index+1 }" name="fwf_50_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
												type="text">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label">打款日期</label>
										<div class="col-sm-3">
											<div
												class="input-group date ng-isolate-scope ng-not-empty ng-valid">
												<input id="dk_date_50_${status.index+1 }" name="dk_date_50_${status.index+1 }"
													class="form-control" type="text"><span
													class="input-group-addon"><i class="fa fa-calendar"></i></span>
											</div>
										</div>
										<label class="col-sm-2 control-label">实际打款金额(元)</label>
										<div class="col-sm-3">
											<input id="sjdkje_50_${status.index+1 }" name="sjdkje_50_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
												type="text">
										</div>
									</div>
									<!-- ngIf: task.creditsMoney -->
									<div class="form-group">
										<label class="col-sm-2 control-label">备注</label>
										<div class="col-sm-8">
											<textarea rows="3" id="bz_50_${status.index+1 }" name="bz_50_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-empty"
												type="text"></textarea>
										</div>
									</div>

									<!-- ngIf: !notUseButton -->
									<br>
									<div style="overflow: hidden">
										<!-- ngRepeat: img in task.filepathlist -->
									</div>

									<!-- ngIf: !notUseButton -->
									<script type="text/javascript">						
					  $(document).ready(function(){							
							var zjfp_50=document.getElementById("zjfp_"+'${erp15.status}'+"_"+'${status.index+1 }').value;
							if(zjfp_50!=null){
							var json = jQuery
							.parseJSON(zjfp_50);
					         for ( var item in json) {
						$("#" + item+"_${status.index+1 }").val(json[item]);
					         }
							}  
					  });
						</script>
								</form>
							</div>
						</div></li>

				</c:if>
				<c:if test="${erp15.status eq '54'}">
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
								<strong>处理人：</strong> ${erp15.gname1 }
							</div>
							<strong style="margin-left: 10px;"><i>处理信息：</i></strong><br>
							<div class="task_margin ng-scope"
								style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">
							</div>
				</div>
				 </li>
				</c:if>
			<c:if test="${erp15.status eq '99'}">
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
								<strong>处理人：</strong> ${erp15.gname1 }
							</div>
							<strong style="margin-left: 10px;"><i>处理信息：</i></strong><br>
											<div class="task_margin ng-scope"
								style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">
          <form name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
	<div class="form-group">
		<label class="col-sm-2 control-label">垫资伙伴</label>
		<div class="col-sm-3"> 
			<select id="rz_dzhb_${status.index+1 }" name="rz_dzhb_${status.index+1 }"  class="form-control">
			<option value="" >--请选择--</option>
			<option value="1">金锤资产</option>
			</select>
		</div>
		<label class="col-sm-2 control-label">融资结果</label>
		<div class="col-sm-3"> 
			<select id="rz_jg_${status.index+1 }" name="rz_jg_${status.index+1 }" class="form-control">
			<option value="0">--请选择--</option>
			<option value="1">成功</option>
			<option value="2">失败</option>
			</select>
        </div>
	</div>   
	<div class="form-group"> 
	        <label class="col-sm-2 control-label">融资金额(元)<span class="red">*</span></label> 
			<div class="col-sm-3">
				<input id="rz_je_${status.index+1 }" name="rz_je_${status.index+1 }" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"  type="text">
			</div>
        <label class="col-sm-2 control-label">放贷日期<i class="red">*</i></label>
		<div class="col-sm-3">
			<div class="input-group date ng-isolate-scope ng-empty ng-valid" >
        <input  id="rz_fdrq_${status.index+1 }" name="rz_fdrq_${status.index+1 }" class="form-control" type="text">
        <span class="input-group-addon">
        <i class="fa fa-calendar"></i></span>
           </div>
		</div>
	</div> 
	<div class="form-group">
		<label class="col-sm-2 control-label">其它信息说明</label>
		<div class="col-sm-8">
		<textarea id="rz_qtxx_${status.index+1 }" name="rz_qtxx_${status.index+1 }" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"></textarea>
		</div>
	</div> 
			<script type="text/javascript">						
						$(document).ready(function(){							
							var zjfp_99=document.getElementById("zjfp_"+'${erp15.status}'+"_"+'${status.index+1 }').value;
							if(zjfp_99!=null){
							var json = jQuery
							.parseJSON(zjfp_99);
					         for ( var item in json) {
					        	 $("#" + item+"_${status.index+1 }").val(json[item]);
					         }
							}  
						});
			</script>
</form>
          	            
          	            </div>
				</div>
				 </li>
				</c:if>
				<c:if test="${erp15.status eq '51'}">
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
								<strong>处理人：</strong> ${erp15.gname1 }
							</div>
							<strong style="margin-left: 10px;"><i>处理信息：</i></strong><br>
							<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
							<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
							<div class="task_margin ng-scope"
								style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">
								<form name="modalForm"
									class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
									<div class="form-group">
										<label class="col-sm-2 control-label"> <!-- ngIf: task.payfriendId == 0 -->
											<!-- ngIf: task.payfriendId != 0 --> <span class="ng-scope">垫资日期</span>
											<!-- end ngIf: task.payfriendId != 0 -->
										</label>
										<div class="col-sm-3">
											<div
												class="input-group date ng-isolate-scope ng-not-empty ng-valid">
												<input id="dz_date_51_${status.index+1 }" name="dz_date_51_${status.index+1 }"
													class="form-control" type="text"> <span
													class="input-group-addon"><i class="fa fa-calendar"></i></span>
											</div>
										</div>
										<label class="col-sm-2 control-label"> <!-- ngIf: task.payfriendId == 0 -->
											<!-- ngIf: task.payfriendId != 0 --> <span class="ng-scope">垫资金额(元)</span>
											<!-- end ngIf: task.payfriendId != 0 -->
										</label>
										<div class="col-sm-3">
											<input id="dz_je_51_${status.index+1 }" name="dz_je_51_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
												type="text">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label">收款情况<span
											class="red">*</span></label>
										<div class="col-sm-8">
											<span> <input type="radio" value="2"
												class="ng-pristine ng-untouched ng-valid ng-not-empty"
												id="sk_type_51_2_${status.index+1 }" name="sk_type">
												到账确认，部分金额待核验&nbsp;&nbsp;&nbsp;&nbsp; <br></span> <input
												type="radio" value="1" id="sk_type_51_1_${status.index+1 }"
												class="ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required"
												name="sk_type"> 到账确认，本单已完整 &nbsp;&nbsp;&nbsp;&nbsp;<br>
											<input type="radio" value="3" id="sk_type_51_3_${status.index+1 }"
												class="ng-pristine ng-untouched ng-valid ng-not-empty"
												name="sk_type"> 金额不符 &nbsp;&nbsp;&nbsp;&nbsp;<br>
										</div>
									</div>
									<!-- ngIf: task.recieveRet==-1 -->
									<div class="form-group">
										<label class="col-sm-2 control-label">其它说明</label>
										<div class="col-sm-8">
											<input id="qtsm_51_${status.index+1 }" name="qtsm_51_${status.index+1 }"
												class="form-control ng-pristine ng-untouched ng-valid ng-empty"
												type="text">
										</div>
									</div>
									<!-- ngIf: !notUseButton -->
									<script type="text/javascript">						
						$(document).ready(function(){							
							var zjfp_51=document.getElementById("zjfp_"+'${erp15.status}'+"_"+'${status.index+1 }').value;
							if(zjfp_51!=null){
							var json = jQuery
							.parseJSON(zjfp_51);
					         for ( var item in json) {
					         if(item=="sk_type_51"){	 
					        	 $("#"+item+"_"+json[item]+"_${status.index+1 }").attr("checked","checked");
					         }else{
					        	 $("#" + item+"_${status.index+1 }").val(json[item]);
					         }
					         }
							}  
						});
						</script>
								</form>
							</div>
						</div></li>

				</c:if>
				
					<c:choose>
						<c:when test="${erp15.status eq '55'}">
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
	<script type="text/javascript">
	
$.fn.filterSelect = (function(){	
    // 我就 很 纠结的，把样式内嵌在这里了，让你怎么改!!!!
    var isInit = false;
    function initCss(){

        isInit = true;
        var style = document.createElement("style");
        var csstext = '.m-input-select{color:black;width:100%;display:inline-block;*display:inline;position:relative;-webkit-user-select:none;}'+
                        '.m-input-select ul, .m-input-select li{padding:0;margin:0;color:black;}'+
                        'n.m-input-select .m-input{padding-right:22px;color:black;}'+
                        '.m-input-select .m-input-ico{position:absolute;right:0;top:0;width:22px;height:100%;background:url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAwAAAAMCAYAAABWdVznAAAATElEQVQoU2NkIBEwkqiegTwNcXFx/4m1CW4DMZoWLVrEiOIkfJpAikGuwPADNk0wxVg1gASRNSErxqkBpgldMV4NuEKNvHggNg5A6gBo4xYmyyXcLAAAAABJRU5ErkJggg==) no-repeat 50% 50%;}'+
                        '.m-input-select .m-list-wrapper{}'+
                        '.m-input-select .m-list{display:none;position:absolute;z-index:9;top:100%;left:0;right:0;max-width:100%;max-height:500px;overflow:auto;border-bottom:1px solid #ddd;}'+
                        '.m-input-select .m-list-item{cursor:default;padding:5px;margin-top:-1px;list-style:none;background:#fff;color:black;border:1px solid #ddd;border-bottom:none;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;}'+
                        '.m-input-select .m-list-item:hover{background:#2D95FF;}'+
                        '.m-input-select .m-list-item-active{background:#2D95FF;}';
        style = $("<style>"+ csstext +"</style>")[0];
        // ie 竟然坑了...
        // if(style.styleSheet) {
        //     style.styleSheet.cssText = csstext;
        // }else{
        //     style.appendChild(document.createTextNode(csstext));
        // };

        var head = document.head || document.getElementsByTagName("head")[0];
        if(head.hasChildNodes()){
            head.insertBefore(style, head.firstChild);
        }else{
            head.appendChild(style);
        };

    };

    return function(){
        !isInit && initCss();

        var $body = $("body");
        
        this.each(function(i, v){
            var $sel = $(v), $div = $('<div class="m-input-select"></div>');
            var $input = $("<input id='putfsname' type='text' class='m-input form-control' style='width:100%' />");
            // var $wrapper = $("<div class='m-list-wrapper'><ul class='m-list'></ul></div>");
            var $wrapper = $("<ul class='m-list'></ul>");
            
            $div = $sel.wrap($div).hide().addClass("m-select").parent();
            
            $div.append($input).append("<span class='m-input-ico'></span>").append($wrapper);

            // 遮罩层显示 + 隐藏
            var wrapper = {
                show: function(){
                    $wrapper.show();
                    this.$list = $wrapper.find(".m-list-item:visible");
                    this.setIndex(this.$list.filter(".m-list-item-active"));
                    this.setActive(this.index);
                },
                hide: function(){
                    $wrapper.hide();
                },
                next: function(){
                    return this.setActive(this.index + 1);
                },
                prev: function(){
                    return this.setActive(this.index - 1);
                },
                $list: $wrapper.find(".m-list-item"),
                index: 0,
                $cur: [],
                setActive: function(i){
                    // 找到第1个 li，并且赋值为 active
                    var $list = this.$list, size = $list.size();
                    if(size <= 0){
                        this.$cur = [];
                        return;
                    }
                    $list.filter(".m-list-item-active").removeClass("m-list-item-active");
                    if(i < 0){
                        i = 0;
                    }else if(i >= size){
                        i = size - 1;
                    }
                    this.index = i;
                    this.$cur = $list.eq(i).addClass("m-list-item-active");
                    this.fixScroll(this.$cur);
                    return this.$cur;
                },
                fixScroll: function($elem){
                    // console.log($wrapper);
                    var height = $wrapper.height(), top = $elem.position().top, eHeight = $elem.outerHeight();
                    var scroll = $wrapper.scrollTop();
                    // 因为 li 的 实际　top，应该要加上 滚上 的距离
                    top += scroll;
                    if(scroll > top){
                        $wrapper.scrollTop(top);
                    }else if(top + eHeight > scroll + height){
                        // $wrapper.scrollTop(top + height - eHeight);
                        $wrapper.scrollTop(top + eHeight - height);
                    }
                },
                setIndex: function($li){
                    if($li.size() > 0){
                        this.index = this.$list.index($li);
                        $li.addClass("m-list-item-active").siblings().removeClass("m-list-item-active");
                    }else{
                        this.index = 0;
                    }
                }
            };

            // input 的操作
            var operation = {
                // 文字更变了，更新 li, 最低效率的一种
                textChange: function(){
                    val = $.trim($input.val());
                    $wrapper.find(".m-list-item").each(function(i, v){
                        if(v.innerHTML.indexOf(val) >= 0){
                            $(v).show();
                        }else{
                            $(v).hide();
                        }
                    });
                    wrapper.show();
                },
                // 设值
                setValue: function($li){
                    if($li && $li.size() > 0){
                        var val = $.trim($li.html());
                        $input.val(val).attr("placeholder", val);
                        wrapper.setIndex($li);
                        $sel.val($li.attr("data-value")).trigger("change");
                    }else{
                        $input.val(function(i, v){
                            return $input.attr("placeholder");
                        });
                    };
                    wrapper.hide();
                    this.offBody();
                },
                onBody: function(){
                    var self = this;
                    setTimeout(function(){
                        self.offBody();
                        $body.on("click", self.bodyClick);
                    }, 10);
                },
                offBody: function(){
                    $body.off("click", this.bodyClick);
                },
                bodyClick: function(e){
                    var target = e.target;
                    if(target != $input[0] && target != $wrapper[0]){
                        wrapper.hide();
                        operation.setValue();
                        operation.offBody();
                    }
                }
            };
            // 遍历 $sel 对象
            function resetOption(){
            	
                var html = "", val = "";
                $sel.find("option").each(function(i, v){
                	//alert(v.value+"---");
                    if(v.selected && !val){
                        val = v.text;
                    };
                    html += '<li class="m-list-item'+ (v.selected ? " m-list-item-active" : "") +'" data-value="'+ v.value +'">'+ v.text +'</li>';
                });
                $input.val(val);
                $wrapper.html(html);
            };
            $sel.on("optionChange", resetOption).trigger("optionChange");
            $sel.on("setEditSelectValue", function(e, val){
                // console.log(val);
                var $all = $wrapper.find(".m-list-item"), $item;
                for(var i = 0, max = $all.size(); i < max; i++){
                    $item = $all.eq(i);
                    if($item.attr("data-value") == val){
                        operation.setValue($item);
                        return;
                    }
                }
            });

            // input 聚焦
            $input.on("focus", function(){
                this.value = "";
                operation.textChange();
                operation.onBody();
            }).on("input propertychange", function(e){
                operation.textChange();
            }).on("keydown", function(e){
                // 上 38, 下 40， enter 13
                switch(e.keyCode){
                    case 38:
                        wrapper.prev();
                        break;
                    case 40:
                        wrapper.next();
                        break;
                    case 13:
                        operation.setValue(wrapper.$cur);
                        break;
                }
            });

            $div.on("click", ".m-input-ico", function(){
                // 触发 focus 和 blur 事件
                // focus 是因为 input 有绑定
                // 而 blur，实际只是失去焦点而已，真正隐藏 wrapper 的是 $body 事件
                $wrapper.is(":visible") ? $input.blur() : ($input.val("").trigger("focus"));
            });

            // 选中
            $wrapper.on("click", ".m-list-item", function(){
                operation.setValue($(this));
                return false;
            });

            setTimeout(function(){
                // for ie
                wrapper.hide();
            },1);


        });

        return this;
    };
})();
</script>
	<script>
// 使用了这个插件，select该怎么用就怎么用
// 任何选择，同样会触发 select 的 更变的说【即select的值会同步更新】
//
var $select = $("select[data-edit-select]").filterSelect();
// --> 这时候的  $select === $("#magicsuggest");
// 也可以 用 $("#magicsuggest").on("change")，两者等价
$select.on("change", function(){
	
    // console.log(this.value)
});
// 也可以通过 $("#magicsuggest").val() 拿到最新的值
// 通过 $("#magicsuggest").trigger("setEditSelectValue", 2); 设置选中的值为 2
// 通过  $("#magicsuggest").trigger("optionChange"); 触发 更新 option 的值
</script>
	<div class="flex-row flex-row-rhcen">
		<em onclick="funUnfold()" class="text-muted">全部展开</em> <em
			onclick="funClose()" class="text-muted">全部收起</em>
	</div>
</div>