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
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'dyqkjl_76')==true}">
<li class="text-primary">
<em>抵押情况记录</em>
<div class="big-conte" style="display:block;">                    
<div style="float:left;margin-left:20px;width:260px;" >
<strong>开始时间：</strong><%=dateString %>
</div>        
<br>
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form id="erp_form" name="erp_form" class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required ng-valid-pattern ng-valid-maxlength">
    <input id="admin_id" name="admin_id" value="${sessionScope.pd.id }" type="hidden" />
    <input id="icbc_id" name="icbc_id" value="${requestScope.icbc_id }" type="hidden" />
    <input id="type_id" name="type_id" value="${requestScope.type_id }" type="hidden" />
    <input id="status_id" name="status_id" value="76" type="hidden" />
    <input id="yw_id" name="yw_id" value="${requestScope.yw_id }" type="hidden" />
	<input id="gems_id" name="gems_id" value="${requestScope.pd.gemsid }" type="hidden" />	
	<input id="fs_id" name="fs_id" value="${requestScope.pd.fsid }" type="hidden" />
	<input id="dz_type" name="dz_type" value="${pd.dz_type}" type="hidden"    />	

    
     <div class="form-group">
		<label class="col-sm-2 control-label">车牌号码<i class="red">*</i></label>
		<div class="col-sm-3">
			<input id="cphm" name="cphm" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required ng-valid-pattern ng-valid-maxlength" type="text" pattern="([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}(([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳]{1})" maxlength="8" ng-model="task.plateNum" cg-required="" required="required">
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
			<label class="col-sm-2 control-label">抵押完成日期<i class="red">*</i></label>
			<div class="col-sm-3">
				<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required">
  <input id="dywcrq" name="dywcrq" class="form-control" type="text">
  <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
</div>
			</div>
		</div>
		</div>
		<div class="form-group">
		 <label class="col-sm-2 control-label">登记证书号<i class="red">*</i></label>
		    <div class="col-sm-3">
			  <input id="djzsh" name="djzsh" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">
		    </div>
		     <label class="col-sm-2 control-label">抵押办理人员<i class="red">*</i></label>
		    <div class="col-sm-3">
			  <input id="dyblry" name="dyblry" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text" >
		    </div>
		</div>
		<div class="form-group">
		 <label class="col-sm-2 control-label">上牌方式</label>
		    <div class="col-sm-3">
			  <input type="radio" value="私牌"  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="spfs">私牌
	            &nbsp;&nbsp;&nbsp;&nbsp;
	           <input type="radio" value="公牌"  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="spfs">公牌
		    </div>
	      	</div>
    <div class="form-group">
		<label class="col-sm-2 control-label">车辆类别</label>
		   <!-- ngIf: rootData.editFlag!='1' && rootData.editFlag!='-1' -->
		   <div class="col-sm-3 ng-scope" >
			<input type="radio" value="国产"  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="cplb">国产
	            &nbsp;&nbsp;&nbsp;&nbsp;
	        <input type="radio" value="进口"  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="cplb">进口
		    </div><!-- end ngIf: rootData.editFlag!='1' && rootData.editFlag!='-1' -->
	
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">查验情况</label>
		<div class="col-sm-3">
			<input type="radio" value="通过"  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="cyqk">通过
            &nbsp;&nbsp;&nbsp;&nbsp;
        	<input type="radio" value="不通过" class="ng-pristine ng-untouched ng-valid ng-not-empty" name="cyqk">不通过
		</div> 
	</div>
			<div class="form-group">
				<label class="col-sm-2 control-label">其它说明</label>
				<div class="col-sm-8">
					<textarea rows="3" id="result_1_msg" name="result_1_msg"  class="form-control ng-pristine ng-untouched ng-valid ng-empty" type="text"></textarea>
				</div>
			</div> 

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
  elem: '#dywcrq' //指定元素
});
</script>
<script type="text/javascript">
function erp(){
	var form = new FormData(document.getElementById("erp_form"));
	$.ajax({
        url:"${pageContext.request.contextPath }/erp/erp_dygd_76.do",
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