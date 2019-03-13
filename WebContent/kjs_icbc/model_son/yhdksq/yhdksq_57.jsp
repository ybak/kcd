<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'jgjscl_57')==true}">
<li class="text-primary">
<em>合作商寄送材料</em>
<div class="big-conte_" style="none;">  
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
<form id="yhdksh_57" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
		<input type="hidden" name="adminid" value="${sessionScope.pd.id}">
		<input type="hidden" name="type_id" value="${requestScope.type_id}"> 
		<input type="hidden" name="icbc_id" value="${requestScope.icbc_id}"> 
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
		<label class="col-sm-2 control-label">快递公司<i class="red">*</i></label>
		<div class="col-sm-3">
			<input id="yhdksh_57_kdgs" name="yhdksh_57_kdgs" class="form-control">
		</div>
		<!-- ngIf: rootData.taskDefKey == 'loanOrder_postinfo_send'||($parent.taskAct.activityId=='loanOrder_postinfo_send'&&notUseButton) -->
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">快递单号<i class="red">*</i></label>
		<div class="col-sm-3">
			<input type="text" id="yhdksh_57_kddh" name="yhdksh_57_kddh" class="form-control">
		</div>
		<label class="col-sm-1 control-label">寄出日期<i class="red">*</i></label>
		<div class="col-sm-3">
			<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required" >
  				<input  id="date_57" name="yhdksh_57_jcrq" class="form-control" type="text"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
			</div>
		</div>
	</div> 
	<!-- ngIf: !notUseButton -->
	<br>
	<div class="form-group">
		<label class="col-sm-2 control-label">上传快递图片</label>
     	<div class="col-sm-3">
     		<input type="hidden" id="yhdksh_57_bcimg1" name="yhdksh_57_bcimg1" value="" >
            <input style="display: none" onchange="javascript:setImagePreview();" type="file" value="" id="file" name="file" >
            <label for="file">
            <img  id="preview" style="display: block; width: 100px; height: 100px;"  class="img-thumbnail"  src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/images/icon.png"/>     
		    </label>
		</div>
	</div>
	<!-- ngIf: rootData.taskDefKey!='loanOrder_postinfo_return' -->
	<!-- <div style="overflow: hidden;margin-left: 7%"class="ng-scope">
	     ngRepeat: img in task.filepathlist --><!-- ngIf: img.materialType=='REG_CERT' --><!-- end ngRepeat: img in task.filepathlist
	</div>end ngIf: rootData.taskDefKey!='loanOrder_postinfo_return'
	<div class="clear" style="margin-top: 10%"></div> 
	<div class="form-group ng-hide">
		<label class="col-sm-2 control-label">车牌号码</label>
		<div class="col-sm-3">
			<input class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text">
		</div>
	</div> -->
	<div class="form-group">
		<label class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea name="result_1_msg" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"></textarea>
		</div>
	</div> 
	<!-- ngIf: !notUseButton -->
	<div class="modal-footer">
		<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
		<a onclick="erp_yhdksh_57()" class="btn btn-primary" >提交</a>
	</div>
</form>
<script>
lay('#version').html('-v'+ laydate.v);
//执行一个laydate实例
laydate.render({
  elem: '#date_57' //指定元素
});
</script>
<script type="text/javascript">
function erp_yhdksh_57(){
	var yhdksh_57_kdgs = $("#yhdksh_57_kdgs").val();
	var yhdksh_57_kddh=$("#yhdksh_57_kddh").val();
	var date_57 = $("#date_57").val();
	var yhdksh_57_bcimg1 = $("#yhdksh_57_bcimg1").val();
	if(yhdksh_57_kdgs==""){
		alert("请填写快递公司!");
	}else if(date_57==""){
		alert("请填写寄出日期!");
	}else if(yhdksh_57_kddh==""){
		alert("请填写快递单号!");
	}else if(yhdksh_57_bcimg1==""){
		alert("请上传快递图片!");
	}else{
		
		var form = new FormData(document.getElementById("yhdksh_57"));
	   	$.ajax({
	           url:"${pageContext.request.contextPath}/erp/erp_yhdksh_57.do",
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
function setImagePreview(avalue) {
    var docObj = document.getElementById("file");
    var imgObjPreview = document.getElementById("preview");
    if(docObj.files && docObj.files[0])
    {
        //火狐下，直接设img属性
        imgObjPreview.style.display = 'block';
        imgObjPreview.style.width = '100px';
        imgObjPreview.style.height = '100px';
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
        localImagId.style.width = "100px";
        localImagId.style.height = "100px"; //图片异常的捕捉，防止用户修改后缀来伪造图片
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
            document.getElementById("yhdksh_57_bcimg1").value=data;
        },
        error: function () {
            alert("上传失败！");
        }
    });
}
</script>
</div>
</div>   							  	
</li>
</c:if>