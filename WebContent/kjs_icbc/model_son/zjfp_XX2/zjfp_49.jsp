<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<% 
SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
long date = new Date().getTime();
String dateString = formatter.format(date);

%>
<script>
	lay('#version').html('-v' + laydate.v);
	//执行一个laydate实例
	laydate.render({
		elem : '#dz_date' //指定元素
			
	});
	
</script>
<script>
lay('#version').html('-v' + laydate.v);
//执行一个laydate实例
laydate.render({
	elem : '#hf_date' //指定元素
		
});
</script>
<c:if  test="${fn:contains(sessionScope.pd.purview_map,'zjfp_49')==true}">
<li class="text-primary">
<em>公司资金分配</em>
<div class="big-conte" style="display: block;">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong><%=dateString %>
</div>
<br>
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form id="zjfp_form" name="zjfp_form" class="form-horizontal ng-pristine ng-valid ng-scope">	

	<input id="admin_id" name="admin_id" value="${sessionScope.pd.id }" type="hidden" />
    <input id="icbc_id" name="icbc_id" value="${requestScope.icbc_id }" type="hidden" />
    <input id="type_id" name="type_id" value="${requestScope.type_id }" type="hidden" />
    <input id="status_id" name="status_id" value="49" type="hidden" />
    <input id="yw_id" name="yw_id" value="${requestScope.yw_id }" type="hidden" />
	<input id="gems_id" name="gems_id" value="${requestScope.pd.gemsid }" type="hidden" />	
	<input id="fs_id" name="fs_id" value="${requestScope.pd.fsid }" type="hidden" />
	<input id="dz_type" name="dz_type" value="${pd.dz_type}" type="hidden"    />
   <c:choose>
   <c:when test="${pd.dz_type eq '2' }">
   
   	<div class="ng-scope">  
     <div class="form-group">
		<label class="col-sm-2 control-label">垫资伙伴</label>
		<div class="col-sm-3"> 
			<select class="form-control"  id="dzhb" name="dzhb" >
			<option value="0">--请选择--</option>
			<option value="1">金锤资产</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">垫资日期</label>
		<div class="col-sm-3">
	 <div class="input-group">
     <input class="form-control" id="dz_date" name="dz_date" type="text">
     <span class="input-group-addon">
     <i class="fa fa-calendar"></i></span>
     </div>
		</div>
		<label class="col-sm-2 control-label">到账金额(元)</label>
		<div class="col-sm-3">
			<input id="dzje" name="dzje" class="form-control" type="text">
		</div>
	</div>
	</div>
   </c:when>
   <c:otherwise>
	<div  class="ng-scope">  
	<div class="form-group">
		<label class="col-sm-2 control-label">划付日期</label>
		<div class="col-sm-3">
	<div class="input-group date" >
  <input id="hf_date" name="hf_date" class="form-control" type="text">
  <span class="input-group-addon"><i class="fa fa-calendar"></i></span>
</div>
		</div>
		<label class="col-sm-2 control-label">划付金额(元)</label>
		<div class="col-sm-3">
			<input id="hfje" name="hfje" class="form-control"  type="text">
		</div>
	</div>
	<div class="form-group">
		<label  class="col-sm-2 control-label">代收金额</label>
		<div class="col-sm-3">
			<input id="dsje" name="dsje" class="form-control"  type="text">
		</div>
	</div> 
	</div>
	</c:otherwise>
</c:choose>
	<div class="modal-footer">
<a onclick="location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&yw_id=${requestScope.yw_id }'" class="btn btn-warning" >取消</a>
<a onclick="erp()" class="btn btn-primary" >提交</a>
</div>
</form>
<script type="text/javascript">
function erp(){
	var form = new FormData(document.getElementById("zjfp_form"));
	$.ajax({
        url:"${pageContext.request.contextPath }/erp/erp_zjfp_49.do",
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