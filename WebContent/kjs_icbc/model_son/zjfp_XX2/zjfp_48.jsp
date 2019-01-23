<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<% 
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
long date = new Date().getTime();
String dateString = formatter.format(date);

%>
<script>
//执行一个laydate实例
laydate.render({
  elem: '#xdz_date' //指定元素
});
</script>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'qrsqdz_48')==true}">
<li class="text-primary">
<em>合作商确认垫资</em>
<div class="big-conte" style="display:block;">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong><%=dateString %>
</div>
<br>
<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form id="zjfp_form" name="zjfp_form" class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
	<input id="admin_id" name="admin_id" value="${sessionScope.pd.id }" type="hidden" />
    <input id="icbc_id" name="icbc_id" value="${requestScope.icbc_id }" type="hidden" />
    <input id="type_id" name="type_id" value="${requestScope.type_id }" type="hidden" />
    <input id="status_id" name="status_id" value="48" type="hidden" />
    <input id="yw_id" name="yw_id" value="${requestScope.yw_id }" type="hidden" />
	<input id="gems_id" name="gems_id" value="${requestScope.pd.gemsid }" type="hidden" />	
	<input id="fs_id" name="fs_id" value="${requestScope.pd.fsid }" type="hidden" />
	<!-- ngIf: notUseButton && taskAct.activityId !='loanOrder_leadercheck_pay' -->
	<!-- ngIf: notUseButton && (rootData.taskDefKey=='loanOrder_leadercheck_pay'||taskAct.activityId=='loanOrder_leadercheck_pay') -->
	<div class="form-group ng-scope">
		<label class="col-sm-2 control-label">确认垫资申请</label>
		<div class="col-sm-3">
			<select class="form-control" id="dz_type" name="dz_type">
			<option value="0">--请选择--</option>
			<option value="1" ${requestScope.pd.dz_type eq '1'?"selected='selected'":'' }>不垫资</option>
			<option value="2" ${requestScope.pd.dz_type eq '2'?"selected='selected'":'' }>提车垫资</option>
			</select>
		</div>
	</div><!-- end ngIf: notUseButton && (rootData.taskDefKey=='loanOrder_leadercheck_pay'||taskAct.activityId=='loanOrder_leadercheck_pay') -->
	<!-- ngIf: rootData.taskDefKey=='loanOrder_leadercheck_pay'||taskAct.activityId=='loanOrder_leadercheck_pay' -->
	<div class="form-group ng-scope">
		<label class="col-sm-2 control-label">可垫资金额(元)</label>
		<div class="col-sm-3">
			<input id="kdzje" name="kdzje" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
		</div>
		<label class="col-sm-2 control-label">需垫资金额(元)<i class="red">*</i></label>
		<div class="col-sm-3">
			<input id="xdzje" name="xdzje" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required" type="text">
		</div>
	</div><!-- end ngIf: rootData.taskDefKey=='loanOrder_leadercheck_pay'||taskAct.activityId=='loanOrder_leadercheck_pay' -->
	<!-- ngIf: rootData.taskDefKey=='loanOrder_leadercheck_pay'||taskAct.activityId=='loanOrder_leadercheck_pay' -->
	<div class="form-group ng-scope">
<!-- 		<div ng-if="rootData.orgType=='ALAN'" > -->
		<label class="col-sm-2 control-label">融资服务费</label>
		<div class="col-sm-3">
			<input id="rzfwf" name="rzfwf" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
		</div>
<!-- 		</div> -->
		<label class="col-sm-2 control-label">需垫资日期<i class="red">*</i></label>
		<div class="col-sm-3">
			<div class="input-group date ng-isolate-scope ng-not-empty ng-valid">
            <input id="xdz_date" name="xdz_date" class="form-control" type="text">
  <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
</div>
		</div>
	</div><!-- end ngIf: rootData.taskDefKey=='loanOrder_leadercheck_pay'||taskAct.activityId=='loanOrder_leadercheck_pay' -->
	<div class="form-group">
	<label class="col-sm-2 control-label">其它意见</label>
		<div class="col-sm-8">
			<textarea id="qtyj" name="qtyj" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"></textarea>
		</div>
	</div>
	
<!-- 		<div  class='upimgcontent' style="margin:0px auto;width:990px;">
		<div class="fileinput-wrap">
		<input type="file" name="files" id="doc0" imgid="img0" style="width:100px;"
 			onchange="javascript:setImagePreviews()" />
	</div>
 		<div id="dd" style="width:990px;"></div> 
	</div>
	<button type="submit">提交</button> -->
	
<!-- 	<div ng-if="rootData.orgType=='ALAN'" > -->
		<!-- ngIf: !notUseButton&&rootData.taskDefKey=='loanOrder_leadercheck_pay'||taskAct.activityId=='loanOrder_leadercheck_pay' -->
		<div class="file-upload">
        <span class="file-upload-text">上传图片</span>
        <input id="file0" name="files" imgid="img0" class="file-upload-input" onchange="javascript:setImagePreviews()" type="file" accept="image/jpg,image/jpeg,image/png">
        </div>
		
		<!-- end ngIf: !notUseButton&&rootData.taskDefKey=='loanOrder_leadercheck_pay'||taskAct.activityId=='loanOrder_leadercheck_pay' -->									
<!-- 			<div ng-repeat="mt in task.filepathlist"> -->
<!-- 		     	<div type="hidden" ng-init="addImage(mt)"> -->
<!-- 		     	</div> -->
<!-- 	     	</div> -->
	     	<div style="overflow: hidden;margin-left: 7%;">
	     	<!-- ngRepeat: img in task.filepathlist -->
	     	<div id="img_div"  style="float:left;left:5px;margin-top: 20px" class="ng-scope">
		     	
				
			</div><!-- end ngRepeat: img in task.filepathlist -->
			</div>
			<div class="clear"></div> 
			<br>
			<br>
	<div class="modal-footer">
<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
<a onclick="qrsqdz()" class="btn btn-primary" >提交</a>
</div>
</form>
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
			$(".fileUpload_preview input[imgid="+id+"]").remove();
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

/*window.FileReader本地预览*/
/* $( document ).ready(function() {
	var div =document.getElementById("img_div");
	var magId=0;
$("#upfile").change(function () {	
         var obj=$("#upfile")[0].files[0];
         var fr=new FileReader();
         fr.onload=function () {
        	 div.innerHTML="<div class='fileUpload_preview' style='margin-top:5px;'>"+
		     	"<li>"+
				"<img id='' name='' class='fileUpload_preview fileUpload_preview-small fileUpload_preview-square' src='"+this.result+"'>"+	  
			    "</li>"+
				"<div class='btn btn-primary btn-download'>↓</div>"
				+"</div>";
           $("#result_image_view1").attr('src',);
          $("#apath1").attr('href',this.result);
          console.log(this.result); 
         };
    fr.readAsDataURL(obj);
  });
}); */

function qrsqdz(){
	var form = new FormData(document.getElementById("zjfp_form"));
	$.ajax({
        url:"${pageContext.request.contextPath }/erp/qrsqdz.do",
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
</div>                                             
</div>									  	
</li>
</c:if>