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
				<textarea id="rz_${status.index+1 }"
					name="rz_${status.index+1 }"
					style="display: none;">${erp15.result_1_value }</textarea>
              <c:if test="${erp15.status eq '100'}">
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
						</div>
						</li>

             </c:if>
             <c:if test="${erp15.status eq '101'}">
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
			<label class="col-sm-2 control-label">垫资材料附件</label>
			<div class="col-sm-3">
				<button disabled="disabled" class="btn btn-primary">批量下载垫资材料附件</button>
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
							var rz_101=document.getElementById("rz_"+'${status.index+1 }').value;
							if(rz_101!=null){
							var json = jQuery
									.parseJSON(rz_101);
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
             <c:if test="${erp15.status eq '102'}">
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
				<div class="form-group">					
					<label class="col-sm-2 control-label">账户</label>
					<div class="col-sm-3">
						<input id="rz_zh1_${status.index+1 }" name="rz_zh1_${status.index+1 }"
							class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
							type="text">
					</div>
					<label class="col-sm-2 control-label">开户行</label>
					<div class="col-sm-3">
						<input id="rz_bank_${status.index+1 }" name="rz_bank_${status.index+1 }"
							class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
							type="text">
					</div>
				</div>
				<div class="form-group">
				    <label class="col-sm-2 control-label">账号</label>
					<div class="col-sm-3">
						<input id="rz_zh2_${status.index+1 }" name="rz_zh2_${status.index+1 }"
							class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
							type="text">
					</div>
					<label class="col-sm-2 control-label">垫资金额</label>
					<div class="col-sm-3">
						<input id="rz_dzje_${status.index+1 }" name="rz_dzje_${status.index+1 }"
							class="form-control ng-pristine ng-untouched ng-valid ng-not-empty"
							type="text">
					</div>
					
				</div>			
				<div class="form-group">
					<label class="col-sm-2 control-label">垫资日期</label>
					<div class="col-sm-3">
						<div
							class="input-group date ng-isolate-scope ng-not-empty ng-valid">
							<input id="rz_date_${status.index+1 }" name="rz_date_${status.index+1 }" class="form-control" type="text"><span
								class="input-group-addon"><i class="fa fa-calendar"></i></span>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">备注</label>
					<div class="col-sm-8">
						<textarea rows="3" id="bz_${status.index+1 }" name="bz_${status.index+1 }"
							class="form-control ng-pristine ng-untouched ng-valid ng-empty"
							type="text"></textarea>
					</div>
				</div>
										<script type="text/javascript">						
						$(document).ready(function(){						
							var rz_102=document.getElementById("rz_"+'${status.index+1 }').value;
							if(rz_102!=null){
							var json = jQuery
									.parseJSON(rz_102);
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
            <c:if test="${erp15.status eq '103'}">
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
<div class="form-group">					
					<label class="col-sm-2 control-label">公司确认收款</label>
					<div class="col-sm-3">
						<select id="gsqrsk_${status.index+1 }" name="gsqrsk_${status.index+1 }" class="form-control">
						 <option value="0">--请选择--</option>
						 <option value="1">已收款</option>
						 <option value="2">未收款</option>
						</select>
					</div>
				</div>		
				<div class="form-group">
					<label class="col-sm-2 control-label">备注</label>
					<div class="col-sm-8">
						<textarea rows="3" id="bz_${status.index+1 }" name="bz_${status.index+1 }"
							class="form-control ng-pristine ng-untouched ng-valid ng-empty"
							type="text"></textarea>
					</div>
				</div>
										<script type="text/javascript">						
						$(document).ready(function(){						
							var rz_103=document.getElementById("rz_"+'${status.index+1 }').value;
							if(rz_103!=null){
							var json = jQuery
									.parseJSON(rz_103);
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


				
					<c:choose>
						<c:when test="${erp15.status eq '104'}">
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