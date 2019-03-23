<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	SimpleDateFormat formatter = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	long date = new Date().getTime();
	String dateString = formatter.format(date);
%>
<c:if test="${fn:contains(sessionScope.pd.purview_map,'cxjg_3')==true}">
	<li class="text-primary"><em>查询结果</em>
		<div class="big-conte" style="display: block;">
			<div style="float: left; margin-left: 20px; width: 260px;"
				class="ng-binding">
				<strong>开始时间：</strong><%=dateString%>
			</div>
			<br>
			<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
			<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
			<div class="task_margin ng-scope"
				style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">

				<form id="zx_Form" name="zx_Form"
					class="form-horizontal ng-pristine ng-valid ng-scope">
					<input id="admin_id" name="admin_id" value="${sessionScope.pd.id }"
						type="hidden" /> <input id="icbc_id" name="icbc_id"
						value="${requestScope.icbc_id }" type="hidden" /> <input
						id="type_id" name="type_id" value="${requestScope.type_id }"
						type="hidden" /> <input id="status_id" name="status_id" value="3"
						type="hidden" /> <input id="yw_id" name="yw_id"
						value="${requestScope.yw_id }" type="hidden" /> <input
						id="icbc_name" name="icbc_name" value="${pd.c_name }"
						type="hidden" /> <input id="icbc_adminid" name="icbc_adminid"
						value="${pd.icbc_adminid }" type="hidden" /> <input id="dt_date"
						name="dt_date" value="${pData2.dt_edit }" type="hidden" />
					<!-- ngIf: notUseButton -->
					<div class="form-group ng-scope">
						<label class="col-sm-2 control-label">审核结果</label>
						<div class="col-sm-8">
							<input type="radio" value="1" onchange="sh_result1(this.value)"
								id="zx_status" name="zx_status"
								class="ng-pristine ng-untouched ng-valid ng-not-empty">通过
							&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" value="2"
								onchange="sh_result1(this.value)" id="zx_status"
								name="zx_status"
								class="ng-pristine ng-untouched ng-valid ng-not-empty">不通过
							&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" value="3"
								onchange="sh_result1(this.value)" id="zx_status"
								name="zx_status"
								class="ng-pristine ng-untouched ng-valid ng-not-empty">回退补件
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">备注</label>
						<div class="col-sm-8">
							<textarea id="zx_remark" name="zx_remark"
								class="form-control ng-pristine ng-valid ng-not-empty ng-touched"
								style="margin: 0px -5.34375px 0px 0px; height: 50px; width: 545px;"></textarea>
						</div>
					</div>
					<div id="ul" style="margin-left: 200px;">
						<ul id="zxtap" class="nav nav-tabs" style="border-bottom: 0px;">
							<li class="active"><a href="#zdr" data-toggle="tab"
								aria-expanded="false">主贷人</a></li>
							<li><a href="#zdrpo" data-toggle="tab" aria-expanded="true">主贷人配偶
							</a></li>
							<li><a href="#ghr1" data-toggle="tab" aria-expanded="true">共还人1</a>
							</li>
							<li><a href="#ghr2" data-toggle="tab" aria-expanded="true">共还人2</a>
							</li>
						</ul>
					</div>
					<div id="zxtapContent" class="tab-content">
						<div id="zdr" class="tab-pane fade active in">
							<!-- end ngIf: notUseButton -->
							<div id="zdr_hai" class="form-group" style="margin-top: 20px;">
								<label class="col-sm-2 control-label">征信报告</label>
								<div class="col-sm-8">
									<textarea id="zx_result1" name="zx_result1"
										class="form-control ng-pristine ng-valid ng-not-empty ng-touched"
										style="margin: 0px -5.34375px 0px 0px; height: 141px; width: 545px;"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">大数据报告</label>
								<div class="col-sm-4">
									<div class="row inline-from">
										<div class="input-group">
											<input class="form-control" name="dsj_report_id"
												id="dsj_report_id" value="${pd.dsj_report_id }" type="text">
											<span class="input-group-addon"> <a
												style="color: #72afd2;"
												href="javascript:queryid('${requestScope.icbc_id }','1','${pd.c_name }','${pd.c_tel }','${pd.c_cardno }','dsj_report_id')">获取编码</a>
											</span> <span class="input-group-addon"> <a
												style="color: #72afd2;"
												href="javascript:dsj_bg('${requestScope.icbc_id }','1','dsj_report_id');">查看报告</a>
											</span>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div id="ghr1" class="tab-pane fade">

							<!-- end ngIf: notUseButton -->
							<div id="ghr1_hai" class="form-group" style="margin-top: 20px;">
								<label class="col-sm-2 control-label">征信报告</label>
								<div class="col-sm-8">
									<textarea id="zx_result2" name="zx_result2"
										class="form-control ng-pristine ng-valid ng-not-empty ng-touched"
										style="margin: 0px -5.34375px 0px 0px; height: 141px; width: 545px;"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">大数据报告</label>
								<div class="col-sm-4">
									<div class="row inline-from">
										<div class="input-group">
											<input class="form-control" name="gjr_dsj_report_id1"
												id="gjr_dsj_report_id1" value="${pd.gjr_dsj_report_id1 }"
												type="text"> <span class="input-group-addon">
												<a style="color: #72afd2;"
												href="javascript:queryid('${requestScope.icbc_id }','3','${pd.c_name_gj1 }','${pd.c_tel_gj1 }','${pd.c_cardno_gj1 }','gjr_dsj_report_id1')">获取编码</a>
											</span> <span class="input-group-addon"> <a
												style="color: #72afd2;"
												href="javascript:dsj_bg('${requestScope.icbc_id }','3','gjr_dsj_report_id1');">查看报告</a>
											</span>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div id="ghr2" class="tab-pane fade">
							<!-- end ngIf: notUseButton -->
							<div id="ghr2_hai" class="form-group" style="margin-top: 20px;">
								<label class="col-sm-2 control-label">征信报告</label>
								<div class="col-sm-8">
									<textarea id="zx_result3" name="zx_result3"
										class="form-control ng-pristine ng-valid ng-not-empty ng-touched"
										style="margin: 0px -5.34375px 0px 0px; height: 141px; width: 545px;"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">大数据报告</label>
								<div class="col-sm-4">
									<div class="row inline-from">
										<div class="input-group">
											<input class="form-control" name="gjr_dsj_report_id2"
												id="gjr_dsj_report_id2" value="${pd.gjr_dsj_report_id2 }"
												type="text"> <span class="input-group-addon">
												<a style="color: #72afd2;"
												href="javascript:queryid('${requestScope.icbc_id }','4','${pd.c_name_gj2 }','${pd.c_tel_gj2 }','${pd.c_cardno_gj2 }','gjr_dsj_report_id2')">获取编码</a>
											</span> <span class="input-group-addon"> <a
												style="color: #72afd2;"
												href="javascript:dsj_bg('${requestScope.icbc_id }','4','gjr_dsj_report_id2');">查看报告</a>
											</span>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div id="zdrpo" class="tab-pane fade">
							<!-- end ngIf: notUseButton -->
							<div id="zdrpo_hai" class="form-group" style="margin-top: 20px;">
								<label class="col-sm-2 control-label">征信报告</label>
								<div class="col-sm-8">
									<textarea id="zx_result4" name="zx_result4"
										class="form-control ng-pristine ng-valid ng-not-empty ng-touched"
										style="margin: 0px -5.34375px 0px 0px; height: 141px; width: 545px;"></textarea>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-2 control-label">大数据报告</label>
								<div class="col-sm-4">
									<div class="row inline-from">
										<div class="input-group">
											<input class="form-control" name="po_dsj_report_id"
												id="po_dsj_report_id" value="${pd.po_dsj_report_id }"
												type="text"> <span class="input-group-addon">
												<a style="color: #72afd2;"
												href="javascript:queryid('${requestScope.icbc_id }','2','${pd.c_name_mt }','${pd.c_tel_mt }','${pd.c_cardno_mt }','po_dsj_report_id')">获取编码</a>
											</span> <span class="input-group-addon"> <a
												style="color: #72afd2;"
												href="javascript:dsj_bg('${requestScope.icbc_id }','2','po_dsj_report_id');">查看报告</a>
											</span>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

					<div class="modal-footer">
						<a
							onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'"
							class="btn btn-warning">取消</a> <a onclick="erp_zxsh()"
							class="btn btn-primary">提交</a>
					</div>
				</form>
				<script type="text/javascript">
					function queryid(id, dsj_type, name, mobileNo, idCardNo,
							dsjname) {
						$
								.ajax({
									type : "post",
									dataType : "json",
									url : "${pageContext.request.contextPath }/erp/getxdfx_dsjzx.do",
									data : {
										id : id,
										dsj_type : dsj_type,
										name : name,
										idCardNo : idCardNo,
										mobileNo : mobileNo
									},
									success : function(msg) {
										alert(msg.status.responseMessage);
										if (msg.status.responseCode == '0000') {
											document.getElementById(dsjname).value = msg.status.requestId;
										}

										/* if(msg.success==true){  
											alert("获取成功!");
											document.getElementById(dsjname).value=msg.report_id;		
										}else{
											alert("获取失败，请重试...");
										} */
									},
									error : function() {
										alert("系统错误，请稍后重试...");
									}

								});
					}

					function query_result() {
						var report_id = document
								.getElementById("dsj_report_id").value;
						$
								.ajax({
									type : "post",
									dataType : "text",
									url : "${pageContext.request.contextPath }/dsj_result.do",
									data : {
										report_id : report_id
									},
									success : function(msg) {
										alert("报告获取成功!");
										$("#dsj_result").val(msg);
									},
									error : function() {
										alert("系统错误，请稍后重试...");
									}

								});
					}
					function dsj_bg(id, dsjtype, report_id) {
						var dsj_code = document.getElementById(report_id).value;
						if (dsj_code != null && dsj_code != "") {
							var frameSrc = "${pageContext.request.contextPath }/erp/getxdfx_dsjzx_result.do?id="
									+ id + "&dsjtype=" + dsjtype;
							//给iframe加上src路径
							$("#NoPermissioniframe").attr("src", frameSrc);
							//显示模态框  只有在选择编辑的行   然后根据回调函数成功后才会显示模态框
							$('#dsjModal').modal({
								show : true,
								backdrop : 'static'
							});
						} else {
							alert("大数据编码不能为空!");
						}

					}
				</script>
				<script type="text/javascript">
					function sh_result1(status) {
						/* alert(status); */
						if (status == 3) {
							document.getElementById("ul").style.display = "none";
							document.getElementById("zxtapContent").style.display = "none";
						} else {
							document.getElementById("ul").style.display = "";
							document.getElementById("zxtapContent").style.display = "";
						}

					}
					function sh_result2(status) {
						/* alert(status); */
						if (status == 3) {
							document.getElementById("ghr1_hai").style.display = "none";
						} else {
							document.getElementById("ghr1_hai").style.display = "";
						}

					}
					function sh_result3(status) {
						/* alert(status); */
						if (status == 3) {
							document.getElementById("ghr2_hai").style.display = "none";
						} else {
							document.getElementById("ghr2_hai").style.display = "";
						}

					}
					function sh_result4(status) {
						/* alert(status); */
						if (status == 3) {
							document.getElementById("zdrpo_hai").style.display = "none";
						} else {
							document.getElementById("zdrpo_hai").style.display = "";
						}

					}

					function erp_zxsh() {
						var val = $('input:radio[name="zx_status"]:checked')
								.val();
						if (val == null) {
							alert("请选择审核结果!");
							return false;
						} else {
							var form = new FormData(document
									.getElementById("zx_Form"));
							$
									.ajax({
										url : "${pageContext.request.contextPath }/erp/erp_zxsh.do",
										type : "post",
										data : form,
										processData : false,
										contentType : false,
										success : function(data) {
											alert("提交成功!");
											window.location.href = '${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }';
										},
										error : function(e) {
											alert("错误！！");
										}
									});
						}
						/* var status =$("input[type='radio']:checked").val();
						var  bc_status;
						if(status==1){
							bc_status=3;	
						}else if(status==2){
							bc_status=5;
						}else if(status==3){
							bc_status=4;
						} */
						/* var zx_result =$("#zx_result").val();
						var zx_remark =$("#zx_remark").val(); */
						/* $.post("${pageContext.request.contextPath }/erp/erp_zxsh.do",
							{
						 bc_status:bc_status,
						 zx_result:zx_result,
						 remark:zx_remark
							 },
							function(result){
						  		alert(result);
							}
							);  */
					}
				</script>
				<!-- 模态框（Modal） -->
				<div class="modal fade" id="dsjModal" tabindex="-1" role="dialog"
					aria-labelledby="dsjModalLabel" aria-hidden="true">
					<div class="modal-dialog modal-lg">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" align="center" id="dsjModalLabel">大数据报告</h4>
							</div>
							<div class="modal-body" style="height: 750px;">
								<iframe id="NoPermissioniframe" width="100%" height="100%"
									frameborder="0"></iframe>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
				</div>
			</div>
		</div></li>
</c:if>
