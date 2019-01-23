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
				<%-- <jsp:include page="/kjs_icbc/zx/zx_${erp15.status }.jsp">
<jsp:param value="${erp15.taskname_name }" name="taskname_name"/>
<jsp:param value="${status.index+1 }" name="status"/>
<jsp:param value="${erp15.sdate }" name="sdate"/>
<jsp:param value="${erp15.gname1 }" name="gname1"/>
<jsp:param value="${erp15.dt_edit }" name="dt_edit"/>
</jsp:include>   
<c:if test="${status.last}">
<jsp:include page="/kjs_icbc/zx/zx_${erp15.status+1}.jsp">
<jsp:param value="${erp15.dt_edit }" name="sdate"/>
</jsp:include>
</c:if> --%>
                <textarea id="zx_${erp15.status}_${status.index+1 }"
					name="zx_${erp15.status}_${status.index+1 }"
					style="display: none;">${erp15.result_1_value }</textarea>
				<c:if test="${erp15.status eq '1'}">
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
								<strong>处理人：</strong>${erp15.gname1 }</div>
						</div></li>

				</c:if>
				<c:if test="${erp15.status eq '2'}">
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
							<div class="task_margin ng-scope">
								<a data-toggle="modal" data-target="#zx_2Modal${status.index+1 }" class="ng-scope">信息较多，如有需要请查看明细</a>
							</div>
						</div></li>
						<script type="text/javascript">						
						$(document).ready(function(){						
							var zx_2=document.getElementById("zx_"+'${erp15.status}'+"_"+'${status.index+1 }').value;
							
							if(zx_2!=null&&zx_2!=''){
						    var img_div = document.getElementById("image_div_${status.index+1 }");
							var json = jQuery
									.parseJSON(zx_2);
							for ( var item in json) {
								if (item.match('imgstep')) {
									//alert(json[item].length);
									if(json[item]!=null&&json[item].length>1){
										if(item=="imgstep2_5s"){
											var arry=json[item];
											for(var i=0;i<arry.length;i++){
												if(arry[i]!=null&&arry[i].length>0){
													$(img_div).append("<div class='col-sm-6 col-md-3'><div class='thumbnail'><img class='img_${status.index+1 }' id='img' name=''  onclick='zximage(this)' style='width: 200px;height: 200px;' src='http://a.kcway.net/assess/"+arry[i]+"'></div></div>");	
												}
											}
											
										}else if (item=="imgstep8_1ss") {
											var arry=json[item];
											for(var i=0;i<arry.length;i++){
												if(arry[i]!=null&&arry[i].length>0){
													$(img_div).append("<div class='col-sm-6 col-md-3'><div class='thumbnail'><img class='img_${status.index+1 }' id='img' name=''  onclick='zximage(this)' style='width: 200px;height: 200px;' src='http://a.kcway.net/assess/"+arry[i]+"'></div></div>");	
												}
											}
										}else{
											$(img_div).append("<div class='col-sm-6 col-md-3'><div class='thumbnail'><img class='img_${status.index+1 }' id='img' name=''  onclick='zximage(this)' style='width: 200px;height: 200px;' src='http://a.kcway.net/assess/"+json[item]+"'></div></div>");
										}
										
									}
								}
								
							}
							}  
						});
						/* 
						<div class="col-sm-6 col-md-3">
			             <div class="thumbnail">
			             <img id="img" name=""  onclick="zximage(this)" style="width: 200px;height: 200px;" src="http://a.kcway.net/assess/upload/2018/04/19/89c27a757a2b05bf746790d997b260c9.jpg">
			              <!-- <div class="caption">
			                <p>
			                    <a href="#" class="btn btn-primary" role="button">按钮</a> 
			                    <a href="#" class="btn btn-default" role="button">按钮</a>
			                </p>
			              </div> -->
			             </div>
			             </div> */
						</script>
						<script type="text/javascript">
$(function () { $('#zximageModal${status.index+1 }').on('hide.bs.modal', function () {
	 if($('body').hasClass('modal-open')){
		
	}else{
		$('#zx_2Modal${status.index+1 }').modal('show');	
	}
	 });
	 });
function zximage(obj){
	$('#zx_2Modal${status.index+1 }').modal('hide');
	//alert(obj);
	if(obj!=0){
	var $img = $(obj),
		imgUrl = $img[0].src;
	}
	var activeIndex=0;
	var imgs = [];
	$(".img_${status.index+1 }").each(function(i,elem){
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
    $("#zxJ_pg${status.index+1 }").attr("src","${pageContext.request.contextPath}/jquery-photo-gallery/gallerys.jsp");
     //显示模态框  只有在选择编辑的行   然后根据回调函数成功后才会显示模态框
    $('#zximageModal${status.index+1 }').modal({ show: true, backdrop: 'static' });
}
</script>
<div class="modal fade" id="zximageModal${status.index+1 }" tabindex="-1" role="dialog" aria-labelledby="zximageModal${status.index+1 }Label" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" align="center" id="myModalLabel">图片预览</h4>
            </div>
            <div class="modal-body" style="height:750px;">
            <iframe id="zxJ_pg${status.index+1 }" width="100%" height="100%" frameborder="0"></iframe>
            (左右键控制上一张,下一张)
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!-- 模态框（Modal） -->
<div class="modal fade" id="zx_2Modal${status.index+1 }"  tabindex="-1" role="dialog" aria-labelledby="zx_2Modal${status.index+1 }Label" aria-hidden="true" >
    <div class="modal-dialog" style="width: 800px;height: 800px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">相关材料</h4>
            </div>
            <div  class="modal-body">
            <div id="image_div_${status.index+1 }" class="row">

             
            </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
				</c:if>
				<c:if test="${erp15.status eq '3'}">
				
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
									<!-- ngIf: notUseButton -->
									<div class="form-group ng-scope">
										<label class="col-sm-2 control-label">审核结果</label>
										<div class="col-sm-8">
											<input type="radio" value="1"
												${erp15.result_1_code eq '1'?"checked='checked'":'' }
												onchange="showradio('${erp15.id }',this.value)"
												id="${erp15.id }" name="${erp15.id }"
												class="ng-pristine ng-untouched ng-valid ng-not-empty">通过
											&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" value="2"
												${erp15.result_1_code eq '2'?"checked='checked'":'' }
												onchange="showradio('${erp15.id }',this.value)"
												id="${erp15.id }" name="${erp15.id }"
												class="ng-pristine ng-untouched ng-valid ng-not-empty">不通过
											&nbsp;&nbsp;&nbsp;&nbsp; <input type="radio" value="3"
												${erp15.result_1_code eq '3'?"checked='checked'":'' }
												onchange="showradio('${erp15.id }',this.value)"
												id="${erp15.id }" name="${erp15.id }"
												class="ng-pristine ng-untouched ng-valid ng-not-empty">回退补件
										</div>
									</div>
									<!-- end ngIf: notUseButton -->
									<div class="form-group">
										<label class="col-sm-2 control-label">备注</label>
										<div class="col-sm-8">
											<textarea
												class="form-control ng-pristine ng-valid ng-not-empty ng-touched"
												style="margin: 0px -5.34375px 0px 0px; height: 141px; width: 545px;">${erp15.result_1_msg }</textarea>
										</div>
									</div>
									<c:if test="${erp15.result_1_code != '3'}" >
										<div style="margin-left: 200px;">
	<ul id="zxtap" class="nav nav-tabs" style="border-bottom:0px;">
        <li class="active">
            <a href="#zdr" data-toggle="tab" aria-expanded="false">主贷人</a>
        </li>
        <li>
            <a href="#ghr1" data-toggle="tab" aria-expanded="true">共还人1</a>
        </li>
         <li>
            <a href="#ghr2" data-toggle="tab" aria-expanded="true">共还人2</a>
        </li>
         <li>
            <a href="#zdrpo" data-toggle="tab" aria-expanded="true">主贷人配偶 </a>
        </li>    
    </ul>
    </div>
    <div id="zxtapContent" class="tab-content">
    <div id="zdr"  class="tab-pane fade active in">
	<!-- end ngIf: notUseButton -->
	<div id="zdr_hai" class="form-group" style="margin-top: 20px;">
		<label class="col-sm-2 control-label">征信报告</label>
		<div class="col-sm-8">
			<textarea  id="zx_result_${status.index+1 }" name="zx_result_${status.index+1 }" class="form-control ng-pristine ng-valid ng-not-empty ng-touched"  style="margin: 0px -5.34375px 0px 0px; height: 141px; width: 545px;"></textarea>
		</div>
	</div>
	<div class="form-group">
	<label class="col-sm-2 control-label">大数据报告</label>
		<div class="col-sm-4">
			<div class="row inline-from">
			        <div class="input-group">
						<input class="form-control" name="dsj_report_id" id="dsj_report_id" value="${pd.dsj_report_id }" type="text">
					    <%-- <span class="input-group-addon">
						<a style="color: #72afd2;" href="javascript:queryid('${pd.c_name }','${pd.c_tel }','${pd.c_cardno }','dsj_report_id')">获取编码</a>
						</span> --%>
						<span class="input-group-addon">
						<a   style="color: #72afd2;" href="javascript:dsj_bg1('dsj_report_id');">查看报告</a>
						</span>
					</div>
					</div>
		</div>
	</div>
    </div>
    <div id="ghr1"  class="tab-pane fade">
   
	<!-- end ngIf: notUseButton -->
	<div id="ghr1_hai" class="form-group" style="margin-top: 20px;">
		<label class="col-sm-2 control-label">征信报告</label>
		<div class="col-sm-8">
			<textarea  id="gjr_zx_result1_${status.index+1 }" name="gjr_zx_result1_${status.index+1 }" class="form-control ng-pristine ng-valid ng-not-empty ng-touched"  style="margin: 0px -5.34375px 0px 0px; height: 141px; width: 545px;"></textarea>
		</div>
	</div>
	<div class="form-group">
	<label class="col-sm-2 control-label">大数据报告</label>
		<div class="col-sm-4">
			<div class="row inline-from">
			        <div class="input-group">
						<input class="form-control" name="gjr_dsj_report_id1" id="gjr_dsj_report_id1" value="${pd.gjr_dsj_report_id1 }" type="text">
					    <%-- <span class="input-group-addon">
						<a style="color: #72afd2;" href="javascript:queryid('${pd.c_name_gj1 }','${pd.c_tel_gj1 }','${pd.c_cardno_gj1 }','gjr_dsj_report_id1')">获取编码</a>
						</span> --%>
						<span class="input-group-addon">
						<a   style="color: #72afd2;" href="javascript:dsj_bg1('gjr_dsj_report_id1');">查看报告</a>
						</span>
					</div>
					</div>
		</div>
	</div>
    </div>
    <div id="ghr2"  class="tab-pane fade">
	<!-- end ngIf: notUseButton -->
	<div id="ghr2_hai" class="form-group" style="margin-top: 20px;">
		<label class="col-sm-2 control-label">征信报告</label>
		<div class="col-sm-8">
			<textarea  id="gjr_zx_result2_${status.index+1 }" name="gjr_zx_result2_${status.index+1 }" class="form-control ng-pristine ng-valid ng-not-empty ng-touched"  style="margin: 0px -5.34375px 0px 0px; height: 141px; width: 545px;"></textarea>
		</div>
	</div>
    <div class="form-group">
	<label class="col-sm-2 control-label">大数据报告</label>
		<div class="col-sm-4">
			<div class="row inline-from">
			        <div class="input-group">
						<input class="form-control" name="gjr_dsj_report_id2" id="gjr_dsj_report_id2" value="${pd.gjr_dsj_report_id2 }" type="text">
					    <%-- <span class="input-group-addon">
						<a style="color: #72afd2;" href="javascript:queryid('${pd.c_name_gj2 }','${pd.c_tel_gj2 }','${pd.c_cardno_gj2 }','gjr_dsj_report_id2')">获取编码</a>
						</span> --%>
						<span class="input-group-addon">
						<a   style="color: #72afd2;" href="javascript:dsj_bg1('gjr_dsj_report_id2');">查看报告</a>
						</span>
					</div>
					</div>
		</div>
	</div>
    </div>
    <div id="zdrpo"  class="tab-pane fade">
	<!-- end ngIf: notUseButton -->
	<div id="zdrpo_hai" class="form-group" style="margin-top: 20px;">
		<label class="col-sm-2 control-label">征信报告</label>
		<div class="col-sm-8">
			<textarea  id="po_zx_result_${status.index+1 }" name="po_zx_result_${status.index+1 }" class="form-control ng-pristine ng-valid ng-not-empty ng-touched"  style="margin: 0px -5.34375px 0px 0px; height: 141px; width: 545px;"></textarea>
		</div>
	</div>
<div class="form-group">
	<label class="col-sm-2 control-label">大数据报告</label>
		<div class="col-sm-4">
			<div class="row inline-from">
			        <div class="input-group">
						<input class="form-control" name="po_dsj_report_id" id="po_dsj_report_id" value="${pd.po_dsj_report_id }" type="text">
					    <%-- <span class="input-group-addon">
						<a style="color: #72afd2;" href="javascript:queryid('${pd.c_name_mt }','${pd.c_tel_mt }','${pd.c_cardno_mt }','po_dsj_report_id')">获取编码</a>
						</span> --%>
						<span class="input-group-addon">
						<a   style="color: #72afd2;" href="javascript:dsj_bg1('po_dsj_report_id');">查看报告</a>
						</span>
					</div>
					</div>
		</div>
	</div>
    </div>
    </div>
    <script type="text/javascript">
    $(document).ready(function(){						
		var zx_3=document.getElementById("zx_"+'${erp15.status}'+"_"+'${status.index+1 }').value;
		if(zx_3!=null&&zx_3!=''){
		var json = jQuery
				.parseJSON(zx_3);
		for ( var item in json) {
			$("#" + item+"_${status.index+1 }").val(json[item]);
		}
		}  
	});
    function dsj_bg1(report_id) {
   	 var dsj_code=document.getElementById(report_id).value;
   	 if(dsj_code!=null&&dsj_code!=""){
   		 var frameSrc="${pageContext.request.contextPath }/dsj_result_jsp.do?report_id="+dsj_code;
     	   //给iframe加上src路径
          $("#NoPermissioniframe1").attr("src", frameSrc);
           //显示模态框  只有在选择编辑的行   然后根据回调函数成功后才会显示模态框
          $('#dsj1Modal').modal({ show: true, backdrop: 'static' }); 
   	 }else{
   		 alert("大数据编码不能为空!");
   	 }
   	 
   	 	
    }
    </script>
									</c:if>
								
								</form>
							</div>
						</div></li>
				</c:if>
					<c:choose>
						<c:when test="${erp15.status eq '4'}">
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
				$("#2").removeAttr("checked");
				$("#3").removeAttr("checked");
				break;
			case "2":
				$("#3").removeAttr("checked");
				$("#1").removeAttr("checked");
				break;
			case "3":
				$("#1").removeAttr("checked");
				$("#2").removeAttr("checked");
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
<!-- 模态框（Modal） -->
<div class="modal fade" id="dsj1Modal" tabindex="-1" role="dialog" aria-labelledby="dsj1ModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" align="center" id="dsj1ModalLabel">大数据报告</h4>
            </div>
            <div class="modal-body" style="height:750px;" >
            <iframe id="NoPermissioniframe1" width="100%" height="100%" frameborder="0"></iframe>
            </div>
            <div class="modal-footer">
                <button type="button"  class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>