<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<% 
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
long date = new Date().getTime();
String dateString = formatter.format(date);

%>
<style>
    .file-upload {
      position: relative;
      overflow: hidden;
      border: 1px solid #C5B7B7;
      display: inline-block;
      padding: 10px 10px;
      border-radius: 3px;
      margin-top: 10px;
      margin-left: 100px;
    }
    .file-upload-input {
      position: absolute;
      width: 999px;
      height: 999px;
      top: 0;
      right: 0;
      cursor: pointer;
    }
</style>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'jgsjqr_75')==true}">
<li class="text-primary">
<em>合作商收件确认</em>
<div class="big-conte" style="display:block;">                    
<div style="float:left;margin-left:20px;width:260px;" >
<strong>开始时间：</strong><%=dateString %>
</div>        
<br>
<div class="task_margin ng-scope"
			style="border: 1px solid #ccc; border-radius: 10px; background-color: #F7F7F7; padding-top: 10px;">			
<form id="erp_form" name="erp_form"  class="form-horizontal ng-pristine ng-valid ng-scope">
    <input id="admin_id" name="admin_id" value="${sessionScope.pd.id }" type="hidden" />
    <input id="icbc_id" name="icbc_id" value="${requestScope.icbc_id }" type="hidden" />
    <input id="type_id" name="type_id" value="${requestScope.type_id }" type="hidden" />
    <input id="status_id" name="status_id" value="75" type="hidden" />
    <input id="yw_id" name="yw_id" value="${requestScope.yw_id }" type="hidden" />
	<input id="gems_id" name="gems_id" value="${requestScope.pd.gemsid }" type="hidden" />	
	<input id="fs_id" name="fs_id" value="${requestScope.pd.fsid }" type="hidden" />
	<input id="dz_type" name="dz_type" value="${pd.dz_type}" type="hidden"    />	<div class="form-group">
		<label class="col-sm-2 control-label">收件确认</label>
		<div class="col-sm-3">
			<input type="radio" value="已收到"  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="sjqr" id="sjqr">已收到
	            &nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="radio" value="未收到" class="ng-pristine ng-untouched ng-valid ng-not-empty" name="sjqr" id="sjqr" >未收到
		</div>
		<label class="col-sm-3 control-label">收件日期</label>
		<div class="col-sm-3">
			<div class="input-group date ng-isolate-scope ng-not-empty ng-valid">
  <input name="ksrq" id="ksrq" class="form-control" type="text">
  <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
</div>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">材料复核结果</label>
		<div class="col-sm-3">
			<input type="radio" value="通过"  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="clfh" id="clfh">通过
	            &nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="radio" value="不通过" class="ng-pristine ng-untouched ng-valid ng-not-empty" name="clfh" id="clfh">不通过
		</div>
		<!-- ngIf: rootData.taskDefKey=='postget'||taskAct.activityId=='postget' -->
		<!-- ngIf: rootData.taskDefKey=='loanOrder_postget_asun'||rootData.taskDefKey=='loanOrder_postget_bank'||taskAct.activityId=='loanOrder_postget_asun'||taskAct.activityId=='loanOrder_postget_bank' -->
	</div>
	<!-- ngIf: (rootData.taskDefKey&&rootData.taskDefKey =='loanOrder_postget_asun')||(taskAct.activityId&&taskAct.activityId=='loanOrder_postget_asun') -->
	<!-- ngIf: (rootData.taskDefKey&&rootData.taskDefKey == 'loanOrder_postget_asun')||(taskAct.activityId&&taskAct.activityId=='loanOrder_postget_asun') --> 
	<!-- ngIf: (rootData.taskDefKey&&rootData.taskDefKey == 'loanOrder_postget_asun')||(taskAct.activityId&&taskAct.activityId=='loanOrder_postget_asun') -->
	<!-- ngIf: (rootData.taskDefKey=='loanOrder_postget_bank'||rootData.taskDefKey=='loanOrder_postget_asun')&&!notUseButton -->
	<!-- ngIf: rootData.taskDefKey=='loanOrder_postget_org'||taskAct.activityId=='loanOrder_postget_org' -->
		<div class="form-group">
		<label class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea rows="3" id="result_1_msg" name="result_1_msg" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"></textarea>
		</div>
	    </div> 								
		<div class="form-group">
			<label class="col-sm-2 control-label">登记证书</label>
		</div>
		<div class="file-upload">
        <span class="file-upload-text">上传图片</span>
        <input id="file0" name="files" imgid="img0" class="file-upload-input" onchange="javascript:setImagePreviews()" type="file" accept="image/jpg,image/jpeg,image/png">
        </div>
	     	<div style="overflow: hidden;margin-left: 7%;">
	     	<div id="img_div"  style="float:left;left:5px;margin-top: 20px" class="ng-scope">
		     	
				
			</div>
			</div>
	<div style="margin-top: 5%" class="clear"></div>
	<!-- ngIf: !notUseButton -->
<div class="modal-footer">
<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
<a onclick="erp()" class="btn btn-primary" >提交</a>
</div>
</form>
<script>
lay('#version').html('-v'+ laydate.v);
//执行一个laydate实例
laydate.render({
  elem: '#ksrq' //指定元素
});
</script>
<script type="text/javascript">
function erp(){
	var form = new FormData(document.getElementById("erp_form"));
	$.ajax({
        url:"${pageContext.request.contextPath }/erp/erp_dygd_75.do",
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


</script>
<script type="text/javascript">
var magId=0;
function setImagePreviews(){
	var docobj=document.getElementById("file"+magId);
	var dd=document.getElementById("img_div");
	var fileList=docobj.files;	
	for( var i=0;i<fileList.length;i++){
		magId++;
		$(dd).append(
				"<div class='fileUpload_preview' imgid='img"+(magId-1)+"' style='margin-top:5px;'>"+
		     	"<li>"+
		     	"<img id='img"+(magId-1)+"' name='"+(magId-1)+"' class='fileUpload_preview fileUpload_preview-small fileUpload_preview-square' src='"+this.result+"'>"+	  
			    "</li>"+
			    "<div class='btn btn-primary btn-download'>↓</div>"+
			    "<div id='close"+(magId-1)+"' class='btn btn-danger btn-close'>x</div>"+
			    "</div>"
				);
		$(".file-upload [imgid=img"+(magId-1)+"]")[0].style.position="absolute";
		$(".file-upload [imgid=img"+(magId-1)+"]")[0].style.left="-10000px";		
		$(".file-upload").append('<input id="file'+magId+'" name="files" imgid="img'+magId+'" class="file-upload-input" onchange="javascript:setImagePreviews()"  type="file" accept="image/jpg,image/jpeg,image/png">');		
		$("#close"+(magId-1)).on("click",function(e){
			var id=$(this).parents(".fileUpload_preview").attr("imgid");
			$(this).parent().remove();
			$(".file-upload input[imgid="+id+"]").remove();
		});
		var imgObjPreview=document.getElementById("img"+(magId-1));
		if(docobj.files&&docobj.files[i]){
			imgObjPreview.style.display="block";
			imgObjPreview.style.width="100px";
			imgObjPreview.style.height="120px";
			imgObjPreview.src=window.URL.createObjectURL(docobj.files[i]);
		}else{
			//IE
			docobj.select();
			var imgsrc=document.selection.createRange().text;
			var localImageId=document.getElementById("img"+(magId-1));
			localImageId.style.width="100px";
			localImageId.style.height="120px";
			try{
				localIamgeId.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
				localIamgeId.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src=imgsrc;
			}catch(e){
				alert("上传图片出错");
				return false;
			}
			imgObjPreview.style.display="none";
			document.selection.empty();
		}		
	}
	return true;
} 
</script>
</div>
</div>   							  	
</li>
</c:if>