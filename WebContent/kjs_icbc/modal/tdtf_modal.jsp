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
<%
	request.setCharacterEncoding("utf-8");
%>		            
<div class="modal-body flex-box" style="height: auto; ">
<div class="flex-row flex-row-rhcen">
<em onclick="funUnfold()" class="text-muted">全部展开</em> 
<em onclick="funClose()" class="text-muted">全部收起</em> 
</div>
<div class="flex-rowcen">
			            	<ol>

<c:forEach var="erp15" items="${requestScope.erp15 }" varStatus="status">
	
<c:if test="${erp15.status eq '87'}">			            	
<li class="text-primary">
<em>${status.index+1 }.${erp15.taskname_name }：</em>
<div class="big-conte" style="display: none;">                    
<div style="float:left;margin-left:20px;width:260px;" >
<strong>开始时间：</strong><fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" >
<strong>处理人：</strong>${erp15.gname1}
</div>         
</div>							  	
</li>
</c:if>

<c:if test="${erp15.status eq '97'}">	
<li class="text-primary">
<em>${status.index+1 }.${erp15.taskname_name }：</em>
<div class="big-conte" style="display: none;">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong><fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong><fmt:formatDate value="${erp15.dt_edit}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong>${erp15.gname1}</div>
<strong style="margin-left:10px;"><i>处理信息：</i></strong><br>
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form id="tdtfsh_97" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
		 <div style="display:none;">
		 	<textarea id="inObj_97_${status.index+1}">${erp15.result_1_value}</textarea>
		 </div>
		 <div class="form-group">
			<label class="col-sm-2 control-label">客户姓名</label>
			<div class="col-sm-3">
				<input value="${pd.c_name}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
			</div>
			<label class="col-sm-2 control-label">业务编号</label>
			<div class="col-sm-3">
				<input value="${pd.gems_code}"  class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
			</div>
		 </div>
		<div class="form-group">
			<label class="col-sm-2 control-label">退单退费材料</label>
		</div>
		<div style="overflow: hidden; margin-left: 7%;">
			<div id="img_97_${status.index+1}" style="float: left; left: 5px; margin-top: 20px" class="ng-scope"></div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">退单退费说明</label>
			<div class="col-sm-8">
				<textarea name="result_1_msg" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">${erp15.result_1_msg}</textarea>
			</div>
		</div> 
	<!-- ngIf: !notUseButton -->
	<script>
		// 97 处理 json ,并给相应的对象赋值
		$(document).ready(function(){	
		var index = ${status.index+1};
		var objS_97index = JSON.parse($("#inObj_97_${status.index+1}").val()); //由JSON字符串转换为JSON对象
			if(objS_97index!=null){
				var dd = document.getElementById("img_97_"+'${status.index+1 }');
				var json = jQuery.parseJSON($("#inObj_97_${status.index+1}").val());
				for(var item in json) {
					if (item.match('bcimg')) {
						$(dd).append("<div class='fileUpload_preview' style='margin-top:5px;'>"
												+ "<li>"
												+ "<img onclick='tdtfaayyclimage(this)' id='"+item+"_"+${status.index+1 }+"' name='"+item+"_"+${status.index+1 }+"' class='fileUpload_preview fileUpload_preview-small fileUpload_preview-square' src='http://a.kcway.net/assess/"+json[item]+"'>"
												+ "</li>"
												/* + "<div class='btn btn-primary btn-download'>↓</div>" */
												/* + "<div id='close"+item+"' class='btn btn-danger btn-close'>x</div>" */
												+ "</div>");
					} else {
						$("#" + item+"_"+'${status.index+1 }').val(json[item]);
					}
				}
			}
		});
		//end
		
		
		function tdtfaayyclimage(obj){
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
    	    $("#tdtfaayyclModal_iframe").attr("src","${pageContext.request.contextPath}/jquery-photo-gallery/gallerys.jsp");
    	     //显示模态框  只有在选择编辑的行   然后根据回调函数成功后才会显示模态框
    	    $('#tdtfaayyclModal').modal({ show: true, backdrop: 'static' });
		}
	</script>
	<div class="modal fade" id="tdtfaayyclModal" tabindex="-1" role="dialog" aria-labelledby="tdtfaayyclModalLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title" align="center" id="tdtfaayyclModalLabel">图片预览</h4>
	            </div>
	            <div class="modal-body" style="height:750px;">
	            <iframe id="tdtfaayyclModal_iframe" width="100%" height="100%" frameborder="0"></iframe>
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


<c:if test="${erp15.status eq '88'}">		
<li class="text-primary">
<em>${status.index+1 }.${erp15.taskname_name }：</em>
<div class="big-conte" style="display: none;">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong><fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong><fmt:formatDate value="${erp15.dt_edit}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong>${erp15.gname1}</div>
<strong style="margin-left:10px;"><i>处理信息：</i></strong><br>
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
		 <div class="form-group">
			<label class="col-sm-2 control-label">客户姓名</label>
			<div class="col-sm-3">
				<input value="${pd.c_name}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
			</div>
			<label class="col-sm-2 control-label">业务编号</label>
			<div class="col-sm-3">
				<input value="${pd.gems_code}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
			</div>
		 </div>
		<%-- <div class="form-group ng-scope" >
			<label class="col-sm-2 control-label">审核结果<span class="red">*</span></label>
			<div class="col-sm-3">
				<input type="radio" value="1" ${erp15.result_1_code eq '1'?"checked='checked'":'' }  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code">通过  &nbsp;&nbsp;&nbsp;&nbsp;
		        <input type="radio" value="2" ${erp15.result_1_code eq '2'?"checked='checked'":'' }  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code">不通过
			</div>	
		</div> --%>
		<div class="form-group">
			<label class="col-sm-2 control-label">退单退费材料</label>
		</div>
		<div style="overflow: hidden;margin-left: 7%">
		<!-- ngRepeat: img in task.filepathlist -->
		</div>
		<!-- <div class="form-group">
			<label class="col-sm-2 control-label" style="margin-top: 57px;">退单退费说明</label>
			<div class="col-sm-8" style="margin-top: 40px;">
				<textarea rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text"></textarea>
			</div>
		</div>  -->
	<div class="form-group">
		<label class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text" >${erp15.result_1_msg}</textarea>
		</div>
	</div> 
	<!-- ngIf: !notUseButton -->
</form>
</div>
</div>   							  	
</li>
</c:if>

<c:if test="${erp15.status eq '89'}">	
<li class="text-primary">
<em>${status.index+1 }.${erp15.taskname_name }：</em>
<div class="big-conte" style="display: none;">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong><fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong><fmt:formatDate value="${erp15.dt_edit}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong>${erp15.gname1}</div>
<strong style="margin-left:10px;"><i>处理信息：</i></strong><br>
<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
     <div class="form-group">
		<label class="col-sm-2 control-label">客户姓名</label>
		<div class="col-sm-3">
			<input value="${pd.c_name}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
		</div>
		<label class="col-sm-2 control-label">业务编号</label>
		<div class="col-sm-3">
			<input value="${pd.gems_code}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
		</div>
	 </div>
	<%--  <div class="form-group ng-scope" >
		<label class="col-sm-2 control-label">审核结果<span class="red">*</span></label>
		<div class="col-sm-3">
			<input type="radio" value="1"  ${erp15.result_1_code eq '1'?"checked='checked'":'' } class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code">通过  &nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="radio" value="2"  ${erp15.result_1_code eq '2'?"checked='checked'":'' } class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code">不通过
		</div>	
	 </div> --%>
	   	<!-- ngIf: !notUseButton -->									
		<div class="form-group">
			<label class="col-sm-2 control-label">退单退费材料</label>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">退单退费说明</label>
			<div class="col-sm-8">
				<textarea rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">${erp15.result_1_msg}</textarea>
			</div>
		</div> 
		<!-- ngIf: !notUseButton -->
</form>
</div>                                             
</div>									  	
</li>
</c:if>

<c:if test="${erp15.status eq '90'}">	
<li class="text-primary">
<em>${status.index+1 }.${erp15.taskname_name }：</em>
<div class="big-conte" style="display: none;">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
<fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong><fmt:formatDate value="${erp15.dt_edit}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong>${erp15.gname1}</div>
<strong style="margin-left:10px;"><i>处理信息：</i></strong><br>
<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
		 <div class="form-group">
			<label class="col-sm-2 control-label">客户姓名</label>
			<div class="col-sm-3">
				<input value="${pd.c_name}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
			</div>
			<label class="col-sm-2 control-label">业务编号</label>
			<div class="col-sm-3">
				<input value="${pd.gems_code}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
			</div>
		 </div>
		 <%-- <div class="form-group ng-scope">
				<label class="col-sm-2 control-label">审核结果<span class="red">*</span></label>
				<div class="col-sm-3">
					<input type="radio" value="1" ${erp15.result_1_code eq '1'?"checked='checked'":'' }  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code">通过  &nbsp;&nbsp;&nbsp;&nbsp;
			        <input type="radio" value="2" ${erp15.result_1_code eq '2'?"checked='checked'":'' }  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code">不通过
				</div>	
	 	 </div> --%>
		<div class="form-group">
			<label class="col-sm-2 control-label">退单退费材料</label>
		</div>
		<div style="overflow: hidden;margin-left: 7%">
		<!-- ngRepeat: img in task.filepathlist -->
		</div>
		<!-- <div class="form-group">
			<label class="col-sm-2 control-label" style="margin-top: 57px;">退单退费说明</label>
			<div class="col-sm-8" style="margin-top: 40px;">
				<textarea rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text"></textarea>
			</div>
		</div>  -->
	<div class="form-group">
		<label class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text">${erp15.result_1_msg}</textarea>
		</div>
	</div> 
	<!-- ngIf: !notUseButton -->
</form>
</div>                                             
</div>									  	
</li>
</c:if>

<c:if test="${erp15.status eq '91'}">
<li class="text-primary">
<em>${status.index+1}.${erp15.taskname_name }：</em>
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
<form id="tdtfsh_91" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
		 <div style="display:none;">
			 <textarea id="inObj_91">${erp15.result_1_value}</textarea>
	     </div>
		 <div class="form-group">
			<label class="col-sm-2 control-label">客户姓名</label>
			<div class="col-sm-3">
				<input value="${pd.c_name}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
			</div>
			<label class="col-sm-2 control-label">业务编号</label>
			<div class="col-sm-3">
				<input value="${pd.gems_code}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
			</div>
		 </div>
		 <div class="form-group">
			<label class="col-sm-2 control-label">垫资额</label>
			<div class="col-sm-3">
				<input id="91_dze" name="tdtfsh_90_dze" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
			</div>
			<label class="col-sm-2 control-label">资金占有费</label>
			<div class="col-sm-3">
				<input id="91_zjzyf" name="tdtfsh_90_zjzyf" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
			</div>
		 </div>
		<div class="form-group">
			<label class="col-sm-2 control-label">退单退费材料</label>
		</div>
		<div style="overflow: hidden;margin-left: 7%">
		<!-- ngRepeat: img in task.filepathlist -->
		</div>
		<!-- <div class="form-group">
			<label class="col-sm-2 control-label" style="margin-top: 57px;">退单退费说明</label>
			<div class="col-sm-8" style="margin-top: 40px;">
				<textarea rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text"></textarea>
			</div>
		</div>  -->
	<div class="form-group">
		<label class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text">${erp15.result_1_msg}</textarea>
		</div>
	</div> 
	<!-- ngIf: !notUseButton -->
	<script>
		// 91 处理 json ,并给相应的对象赋值
		var objS_91 = JSON.parse($("#inObj_91").val()); //由JSON字符串转换为JSON对象
		document.getElementById("91_dze").value = objS_91['91_dze'];
		document.getElementById("91_zjzyf").value = objS_91['91_zjzyf'];
	</script>
</form>
</div>                                             
</div>							  	
</li>
</c:if>	

<c:if test="${erp15.status eq '92'}">
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
<form id="tdtfsh_92" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
		 <input type="hidden" name="adminid" value="${sessionScope.pd.id}">
		 <input type="hidden" name="type_id" value="${requestScope.type_id}"> 
		 <input type="hidden" name="icbc_id" value="${pd.icbc_id}"> 
		 <div class="form-group">
			<label class="col-sm-2 control-label">客户姓名</label>
			<div class="col-sm-3">
				<input value="${pd.c_name}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
			</div>
			<label class="col-sm-2 control-label">业务编号</label>
			<div class="col-sm-3">
				<input value="${pd.gems_code}" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
			</div>
		 </div>
		<div class="form-group ng-scope" >
			<label class="col-sm-2 control-label">审核结果<span class="red">*</span></label>
			<div class="col-sm-4">
				<input type="radio" value="1" ${erp15.result_1_code eq '1'?"checked='checked'":'' } class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code">到账、确认无误（已垫资已收件）  
				&nbsp;&nbsp;&nbsp;&nbsp;
		        <input type="radio" value="2" ${erp15.result_1_code eq '2'?"checked='checked'":'' }  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code">已垫资未收件
				&nbsp;&nbsp;&nbsp;&nbsp;
		        <input type="radio" value="3" ${erp15.result_1_code eq '3'?"checked='checked'":'' }  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="result_1_code">金额不符/未到账
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">退单退费材料</label>
		</div>
		<div style="overflow: hidden;margin-left: 7%">
		<!-- ngRepeat: img in task.filepathlist -->
		</div>
		<!-- <div class="form-group">
			<label class="col-sm-2 control-label" style="margin-top: 57px;">退单退费说明</label>
			<div class="col-sm-8" style="margin-top: 40px;">
				<textarea rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text"></textarea>
			</div>
		</div>  -->
	<div class="form-group">
		<label class="col-sm-2 control-label">备注</label>
		<div class="col-sm-8">
			<textarea name="result_1_msg" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text" >${erp15.result_1_msg}</textarea>
		</div>
	</div> 
	<!-- ngIf: !notUseButton -->
<div class="modal-footer">
	<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }'" class="btn btn-warning" >取消</a>
	<a onclick="erp_tdtfsh_92()"  class="btn btn-primary" >提交</a>	
</div>
</form>
<script type="text/javascript">
function erp_tdtfsh_92(){
	   	var form = new FormData(document.getElementById("tdtfsh_92"));
	   	$.ajax({
	           url:"${pageContext.request.contextPath}/erp/erp_tdtfsh_92.do",
	           type:"post",
	           data:form,
	           processData:false,
	           contentType:false,
	           success:function(data){
	            alert("提交成功!");
	            window.location.reload();
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

<c:if test="${erp15.status eq '93'}">
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
<form id="tdtfsh_93" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
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
		 <textarea id="inObj_93">${erp15.result_1_value}</textarea>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">快递公司</label>
		<div class="col-sm-3">
			<input id="kdgs" name="tdtfsh_93_kdgs" class="form-control ng-pristine ng-untouched ng-valid ng-empty">
		</div>
		<!-- ngIf: rootData.taskDefKey == 'loanOrder_postinfo_send'||($parent.taskAct.activityId=='loanOrder_postinfo_send'&&notUseButton) -->
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">快递单号</label>
		<div class="col-sm-3">
			<input id="kddh" name="tdtfsh_93_kddh" class="form-control ng-pristine ng-untouched ng-valid ng-empty">
		</div>
		<label class="col-sm-1 control-label">寄出日期<i class="red">*</i></label>
		<div class="col-sm-3">
			<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required" >
  				<input placeholder="请选择日期" id="date_93" name="tdtfsh_93_jcrq" class="form-control" type="text"><span class="input-group-addon"><i class="fa fa-calendar"></i></span>
			</div>
		</div>
	</div> 
	<!-- ngIf: !notUseButton -->
	<br>
	<div class="form-group">
		<label class="col-sm-2 control-label">上传快递图片</label>
     	<div class="col-sm-3">
     		<input type="text" name="tdtfsh_93_bcimg1" >
	     	<li>
		     	<img id="bcimg1" class="fileUpload_preview fileUpload_preview-small fileUpload_preview-square"  src="http://115.236.182.101:8083/Customer/0~50000/C000292957/20180611A0000061/POST_BILL/1531895808445.jpg">
	     	</li>
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
			<textarea name="result_1_msg" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text">${erp15.result_1_msg}</textarea>
		</div>
	</div> 
	<!-- ngIf: !notUseButton -->
</form>
<script>
lay('#version').html('-v'+ laydate.v);
//执行一个laydate实例
laydate.render({
  elem: '#date_93' //指定元素
});
</script>
<script>
		// 93 处理 json ,并给相应的对象赋值
		var objS_93 = JSON.parse($("#inObj_93").val()); //由JSON字符串转换为JSON对象
		document.getElementById("kdgs").value = objS_93['kdgs'];
		document.getElementById("kddh").value = objS_93.kddh;
		document.getElementById("date_93").value = objS_93.jcrq;
		document.getElementById("bcimg1").src = "http://a.kcway.net/"+objS_93.bcimg1;
		
    	function ylimage(obj){
			if(obj!=0){
			var $img = $(obj),
				imgUrl = $img[0].src;
			}
			
			}
	</script>
</div>
</div>   							  	
</li>
</c:if>	

<c:if test="${erp15.status eq '94'}">
<li class="text-primary">
<em>${status.index+1 }.${erp15.taskname_name }：</em>
<div class="big-conte" style="display: none;">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
<fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss" />
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong>
<fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss" />

</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong>${erp15.gname1}</div>
<strong style="margin-left:10px;"><i>处理信息：</i></strong><br>
<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
	<div style="display:none;">
		 <textarea id="inObj_94">${erp15.result_1_value}</textarea>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">收件确认</label>
		<div class="col-sm-3">
			<input id="94_msg_1" type="radio" value="1"   class="ng-pristine ng-untouched ng-valid ng-not-empty">已收到
	            &nbsp;&nbsp;&nbsp;&nbsp;
	        <input id="94_msg_2" type="radio" value="2"  class="ng-pristine ng-untouched ng-valid ng-not-empty">未收到
		</div>
		<label class="col-sm-2 control-label">收件日期</label>
		<div class="col-sm-3">
        <div class="input-group date ng-isolate-scope ng-empty ng-valid">
        <input id="94_date" class="form-control selectData" type="text">
        <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
        </div>
		</div>
	</div>
	<%-- <div class="form-group">
		<label class="col-sm-2 control-label">材料复核结果</label>
		<div class="col-sm-3">
			<input id="result_1_code_1" type="radio" value="1" ${erp15.result_1_code eq '1'?"checked='checked'":'' } class="ng-pristine ng-untouched ng-valid ng-not-empty" >通过
	            &nbsp;&nbsp;&nbsp;&nbsp;
	        <input id="result_1_code_2" type="radio" value="2" ${erp15.result_1_code eq '2'?"checked='checked'":'' } class="ng-pristine ng-untouched ng-valid ng-not-empty" >不通过
		</div>
	</div> --%>
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
		// 94 处理 json ,并给相应的对象赋值
		var objS_94 = JSON.parse($("#inObj_94").val()); //由JSON字符串转换为JSON对象
		if(objS_94['94_msg'] == "已收到"){
			$("#94_msg_1").attr("checked","checked");
		}else if(objS_94['94_msg'] == "未收到"){
			$("#94_msg_2").attr("checked","checked");
		}else{
			var a = 1;
		}
		document.getElementById("94_date").value = objS_94['94_date'];
	</script>
</form>
</div>                                             
</div>									  	
</li>
</c:if>	


		<c:choose>
			<c:when test="${erp15.status eq '95'}">
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