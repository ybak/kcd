<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'dsjg_15')==true}">
<li class="text-primary">
<em>电审结果反馈</em>
<div class="big-conte_" style="display:block;">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong></div>
<strong style="margin-left:10px;"><i>处理信息：</i></strong><br>
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form id="ds_Form" class="form-horizontal ng-pristine ng-valid ng-scope">
	<input type="hidden" name="adminid" value="${sessionScope.pd.id}">
	<input type="hidden" name="type_id" value="${requestScope.type_id}"> 
	<input type="hidden" name="icbc_id" value="${pd.id}"> 
	<!-- ngIf: notUseButton -->
	<div class="form-group ng-scope" >
		<label class="col-sm-2 control-label">审核结果</label>
		<div class="col-sm-8"> 
			<input type="radio" value="1"  onchange="showradio('ds_status',this.value)" id="ds_status" name="ds_status"  class="ng-pristine ng-untouched ng-valid ng-not-empty">通过  
			&nbsp;&nbsp;&nbsp;&nbsp;
		    <input type="radio" value="3"  onchange="showradio('ds_status',this.value)" id="ds_status" name="ds_status"  class="ng-pristine ng-untouched ng-valid ng-not-empty">回退补件
	    </div>
	</div><!-- end ngIf: notUseButton -->
	<div class="form-group">
		<div class="form-group">
			<label class="col-sm-2 control-label" style="margin-left: 3%;margin-top:-1%;">银行电审材料</label>
		</div>
		<div style="overflow: hidden;margin-left: 7%">
		     <!-- ngRepeat: img in data.filepathlist -->
		</div>
	</div>
	<div class="form-group" style="margin-top:5px">
		<!-- ngIf: !notUseButton -->
	</div>
	<div class="clear"></div> 
	<div class="form-group">
		<label class="col-sm-2 control-label" style="margin-top: 57px;">电审发起说明</label>
		<div class="col-sm-8" style="margin-top: 40px;">
			<textarea id="dsfqsm" name="dsfqsm" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"></textarea>
		</div>
	</div> 
	<div class="form-group">
		<label class="col-sm-2 control-label" style="margin-top: 57px;">备注</label>
		<div class="col-sm-8" style="margin-top: 40px;">
			<textarea id="ds_remark" name="ds_remark" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text"></textarea>
		</div>
	</div> 
	<!-- ngIf: !notUseButton -->
	<div class="modal-footer">
		<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
		<a onclick="erp_dssh()" class="btn btn-primary" >提交</a>
	</div>
</form>
<script type="text/javascript">
function erp_dssh(){
	var val=$('input:radio[name="ds_status"]:checked').val();
    if(val==null){
        alert("请选择审核结果!");
    }else{
    	/* alert(1111111); */
    	var form = new FormData(document.getElementById("ds_Form"));
    	$.ajax({
            url:"${pageContext.request.contextPath}/erp/erp_dssh.do",
            type:"post",
            data:form,
            processData:false,
            contentType:false,
            success:function(data){
             alert("提交成功!");
             window.location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }';
            },
            error:function(e){
             alert("错误！！");
            }
        });  
    }
}
</script>
</div>                                             
</div>							  	
</li>
</c:if>