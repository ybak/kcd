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
<c:forEach var="erp15" items="${requestScope.erp15}" varStatus="status">
			            	
<c:if test="${erp15.status eq '26'}">			            	
<li class="text-primary">
<em>${status.index+1 }.${erp15.taskname_name }：</em>
<div class="big-conte" style="display: none;">                    
<div style="float:left;margin-left:20px;width:260px;" >
<strong>开始时间：</strong>
<fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss"/>
</div>
<div style="float:left;margin-left:20px;width:260px;" >
<strong>处理人：${erp15.gname1 }</strong>
</div>         
</div>							  	
</li>
</c:if>

<c:if test="${erp15.status eq '98'}">	
<li class="text-primary">
<em>${status.index+1 }.${erp15.taskname_name }：</em>
<div class="big-conte" style="display: none;">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
<fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss"/>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong>
<fmt:formatDate value="${erp15.dt_edit}" pattern="yyyy-MM-dd HH:mm:ss"/>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong>${erp15.gname1 }</div>
<strong style="margin-left:10px;"><i>处理信息：</i></strong><br>
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form id="kqyspsh_98" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
	 <div style="display:none;">
		 <textarea id="inObj_98_${status.index+1}">${erp15.result_1_value}</textarea>
	 </div>
	 <div class="form-group ng-scope">
		<label class="col-sm-2 control-label">申请上牌地</label>
		<div class="col-sm-8">
			<input id="98_sqspd_${status.index+1}"  type="text" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required">
		</div>
	 </div>	
    <!-- <div class="form-group">
        <label class="col-sm-2 control-label">申请上牌地<i class="red">*</i>：</label>
        <div class="col-sm-3">
            <select class="form-control ng-isolate-scope ng-not-empty ng-valid ng-valid-required" id="provinceCode" >
            <option value="" class="ng-binding" selected="selected">--请选择--</option><option label="北京市" value="number:11">北京市</option><option label="天津市" value="number:12">天津市</option><option label="河北省" value="number:13">河北省</option><option label="山西" value="number:14">山西</option><option label="内蒙古自治区" value="number:15">内蒙古自治区</option><option label="辽宁省" value="number:21">辽宁省</option><option label="吉林省" value="number:22">吉林省</option><option label="黑龙江省" value="number:23">黑龙江省</option><option label="上海市" value="number:31">上海市</option><option label="江苏省" value="number:32" selected="selected">江苏省</option><option label="浙江省" value="number:33">浙江省</option><option label="安徽省" value="number:34">安徽省</option><option label="福建省" value="number:35">福建省</option><option label="江西省" value="number:36">江西省</option><option label="山东省" value="number:37">山东省</option><option label="河南省" value="number:41">河南省</option><option label="湖北省" value="number:42">湖北省</option><option label="湖南省" value="number:43">湖南省</option><option label="广东省" value="number:44">广东省</option><option label="广西壮族自治区" value="number:45">广西壮族自治区</option><option label="海南省" value="number:46">海南省</option><option label="重庆市" value="number:50">重庆市</option><option label="四川省" value="number:51">四川省</option><option label="贵州省" value="number:52">贵州省</option><option label="云南省" value="number:53">云南省</option><option label="西藏自治区" value="number:54">西藏自治区</option><option label="陕西省" value="number:61">陕西省</option><option label="甘肃省" value="number:62">甘肃省</option><option label="青海省" value="number:63">青海省</option><option label="宁夏回族自治区" value="number:64">宁夏回族自治区</option><option label="新疆维吾尔自治区" value="number:65">新疆维吾尔自治区</option><option label="台湾省" value="number:71">台湾省</option><option label="香港特别行政区" value="number:81">香港特别行政区</option><option label="澳门特别行政区" value="number:82">澳门特别行政区</option></select>
        </div>
        <div class="col-sm-3">
            <select class="form-control ng-isolate-scope ng-not-empty ng-valid ng-valid-required"  name="cityCode" >
            <option value="" class="ng-binding" selected="selected">--请选择--</option><option label="南京市" value="number:3201">南京市</option><option label="无锡市" value="number:3202">无锡市</option><option label="徐州市" value="number:3203">徐州市</option><option label="常州市" value="number:3204">常州市</option><option label="苏州市" value="number:3205" selected="selected">苏州市</option><option label="南通市" value="number:3206">南通市</option><option label="连云港市" value="number:3207">连云港市</option><option label="淮安市" value="number:3208">淮安市</option><option label="盐城市" value="number:3209">盐城市</option><option label="扬州市" value="number:3210">扬州市</option><option label="镇江市" value="number:3211">镇江市</option><option label="泰州市" value="number:3212">泰州市</option><option label="宿迁市" value="number:3213">宿迁市</option></select>
        </div>
        <div class="col-sm-2">
            <select class="form-control ng-isolate-scope ng-not-empty ng-valid" ><option value="" class="ng-binding" selected="selected">--请选择--</option><option label="沧浪区" value="number:320502">沧浪区</option><option label="平江区" value="number:320503">平江区</option><option label="金阊区" value="number:320504">金阊区</option><option label="虎丘区" value="number:320505" selected="selected">虎丘区</option><option label="工业园区" value="number:320508">工业园区</option><option label="高新区" value="number:320509">高新区</option><option label="吴中区" value="number:320506">吴中区</option><option label="相城区" value="number:320507">相城区</option><option label="常熟市" value="number:320581">常熟市</option><option label="张家港市" value="number:320582">张家港市</option><option label="昆山市" value="number:320583">昆山市</option><option label="吴江市" value="number:320584">吴江市</option><option label="太仓市" value="number:320585">太仓市</option></select>
    	</div>
    </div> -->
    <div class="form-group">
        <label class="col-sm-2 control-label">申请原因：</label>
        <div class="col-sm-8">
            <textarea name="result_1_msg" rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text" >${erp15.result_1_msg}</textarea>
        </div>
    </div>
    <!-- ngIf: !notUseButton -->
    <script>
		// 98 处理 json ,并给相应的对象赋值
		var index = ${status.index+1};
		var objS_98index = JSON.parse($("#inObj_98_${status.index+1}").val()); //由JSON字符串转换为JSON对象
		document.getElementById("98_sqspd_${status.index+1}").value = objS_98index['98_sqspd'];
	</script>
    
</form>
</div>                                             
</div>							  	
</li>
</c:if>

<c:if test="${erp15.status eq '27'}">  
<li class="text-primary">
<em>${status.index+1 }.${erp15.taskname_name }：</em>
<div class="big-conte" style="display: none;">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
<fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss"/>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong>
<fmt:formatDate value="${erp15.dt_edit}" pattern="yyyy-MM-dd HH:mm:ss"/>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong>${erp15.gname1 }</div>
<strong style="margin-left:10px;"><i>处理信息：</i></strong><br>
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
   <!--  <div class="form-group">
        <label class="col-sm-2 control-label">申请上牌地<i class="red">*</i>：</label>
        <div class="col-sm-2">
	        <input disabled="disabled"  type="text" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required">
        </div>
        <div class="col-sm-3">
            <select class="form-control ng-isolate-scope ng-not-empty ng-valid ng-valid-required" id="provinceCode" >
            <option value="" class="ng-binding" selected="selected">--请选择--</option><option label="北京市" value="number:11">北京市</option><option label="天津市" value="number:12">天津市</option><option label="河北省" value="number:13">河北省</option><option label="山西" value="number:14">山西</option><option label="内蒙古自治区" value="number:15">内蒙古自治区</option><option label="辽宁省" value="number:21">辽宁省</option><option label="吉林省" value="number:22">吉林省</option><option label="黑龙江省" value="number:23">黑龙江省</option><option label="上海市" value="number:31">上海市</option><option label="江苏省" value="number:32" selected="selected">江苏省</option><option label="浙江省" value="number:33">浙江省</option><option label="安徽省" value="number:34">安徽省</option><option label="福建省" value="number:35">福建省</option><option label="江西省" value="number:36">江西省</option><option label="山东省" value="number:37">山东省</option><option label="河南省" value="number:41">河南省</option><option label="湖北省" value="number:42">湖北省</option><option label="湖南省" value="number:43">湖南省</option><option label="广东省" value="number:44">广东省</option><option label="广西壮族自治区" value="number:45">广西壮族自治区</option><option label="海南省" value="number:46">海南省</option><option label="重庆市" value="number:50">重庆市</option><option label="四川省" value="number:51">四川省</option><option label="贵州省" value="number:52">贵州省</option><option label="云南省" value="number:53">云南省</option><option label="西藏自治区" value="number:54">西藏自治区</option><option label="陕西省" value="number:61">陕西省</option><option label="甘肃省" value="number:62">甘肃省</option><option label="青海省" value="number:63">青海省</option><option label="宁夏回族自治区" value="number:64">宁夏回族自治区</option><option label="新疆维吾尔自治区" value="number:65">新疆维吾尔自治区</option><option label="台湾省" value="number:71">台湾省</option><option label="香港特别行政区" value="number:81">香港特别行政区</option><option label="澳门特别行政区" value="number:82">澳门特别行政区</option></select>
        </div>
        <div class="col-sm-3">
            <select class="form-control ng-isolate-scope ng-not-empty ng-valid ng-valid-required"  name="cityCode" >
            <option value="" class="ng-binding" selected="selected">--请选择--</option><option label="南京市" value="number:3201">南京市</option><option label="无锡市" value="number:3202">无锡市</option><option label="徐州市" value="number:3203">徐州市</option><option label="常州市" value="number:3204">常州市</option><option label="苏州市" value="number:3205" selected="selected">苏州市</option><option label="南通市" value="number:3206">南通市</option><option label="连云港市" value="number:3207">连云港市</option><option label="淮安市" value="number:3208">淮安市</option><option label="盐城市" value="number:3209">盐城市</option><option label="扬州市" value="number:3210">扬州市</option><option label="镇江市" value="number:3211">镇江市</option><option label="泰州市" value="number:3212">泰州市</option><option label="宿迁市" value="number:3213">宿迁市</option></select>
        </div>
        <div class="col-sm-2">
            <select class="form-control ng-isolate-scope ng-not-empty ng-valid" ><option value="" class="ng-binding" selected="selected">--请选择--</option><option label="沧浪区" value="number:320502">沧浪区</option><option label="平江区" value="number:320503">平江区</option><option label="金阊区" value="number:320504">金阊区</option><option label="虎丘区" value="number:320505" selected="selected">虎丘区</option><option label="工业园区" value="number:320508">工业园区</option><option label="高新区" value="number:320509">高新区</option><option label="吴中区" value="number:320506">吴中区</option><option label="相城区" value="number:320507">相城区</option><option label="常熟市" value="number:320581">常熟市</option><option label="张家港市" value="number:320582">张家港市</option><option label="昆山市" value="number:320583">昆山市</option><option label="吴江市" value="number:320584">吴江市</option><option label="太仓市" value="number:320585">太仓市</option></select>
        </div>
    </div> -->
    <!-- <div class="form-group">
        <label class="col-sm-2 control-label">申请原因：</label>
        <div class="col-sm-8">
            <textarea rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text" ></textarea>
        </div>
    </div> -->
    <div class="form-group">
        <label class="col-sm-2 control-label">审核意见：</label>
        <div class="col-sm-8">
            <input type="radio" value="1" ${erp15.result_1_code eq '1'?"checked='checked'":'' }  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="2677">通过  &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" value="3" ${erp15.result_1_code eq '3'?"checked='checked'":'' }  name="2678">驳回&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" value="2" ${erp15.result_1_code eq '2'?"checked='checked'":'' } name="2679">不通过
        </div>
    </div><!-- end ngIf: (rootData.taskDefKey && rootData.taskDefKey != 'creditSrc_bizAddr_apply' && action != 'detail')||(taskAct.activityId && taskAct.activityId != 'creditSrc_bizAddr_apply') -->
    <!-- ngIf: (rootData.taskDefKey && rootData.taskDefKey != 'creditSrc_bizAddr_apply' && action != 'detail')||(taskAct.activityId && taskAct.activityId != 'creditSrc_bizAddr_apply') --><div ng-if="(rootData.taskDefKey &amp;&amp; rootData.taskDefKey != 'creditSrc_bizAddr_apply' &amp;&amp; action != 'detail')||(taskAct.activityId &amp;&amp; taskAct.activityId != 'creditSrc_bizAddr_apply')" class="form-group ng-scope">
        <label class="col-sm-2 control-label">审核备注：</label>
        <div class="col-sm-8">
            <textarea rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">${erp15.result_1_msg}</textarea>
        </div>
    </div><!-- end ngIf: (rootData.taskDefKey && rootData.taskDefKey != 'creditSrc_bizAddr_apply' && action != 'detail')||(taskAct.activityId && taskAct.activityId != 'creditSrc_bizAddr_apply') -->
    <!-- 根据action确定操作  -->
	<!-- ngIf: !notUseButton -->
</form>
</div>
</div>   							  	
</li>
</c:if>

<%-- <c:if test="${erp15.status eq '28'}">  
<li class="text-primary">
<em>重新申请提交</em>
<div class="big-conte" style="display: none;">
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
</div> 
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>当前任务接收人：</strong>
</div>                                           
</div>							  	
</li>
</c:if> --%>

<c:if test="${erp15.status eq '29'}">  
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
<strong>处理人：</strong>${erp15.gname1 }</div>
<strong style="margin-left:10px;"><i>处理信息：</i></strong><br>
<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required">
   <!--  <div class="form-group">
        <label class="col-sm-2 control-label">申请上牌地<i class="red">*</i>：</label>
        <div class="col-sm-3">
            <select class="form-control ng-isolate-scope ng-not-empty ng-valid ng-valid-required" id="provinceCode" >
            <option value="" class="ng-binding" selected="selected">--请选择--</option><option label="北京市" value="number:11">北京市</option><option label="天津市" value="number:12">天津市</option><option label="河北省" value="number:13">河北省</option><option label="山西" value="number:14">山西</option><option label="内蒙古自治区" value="number:15">内蒙古自治区</option><option label="辽宁省" value="number:21">辽宁省</option><option label="吉林省" value="number:22">吉林省</option><option label="黑龙江省" value="number:23">黑龙江省</option><option label="上海市" value="number:31">上海市</option><option label="江苏省" value="number:32" selected="selected">江苏省</option><option label="浙江省" value="number:33">浙江省</option><option label="安徽省" value="number:34">安徽省</option><option label="福建省" value="number:35">福建省</option><option label="江西省" value="number:36">江西省</option><option label="山东省" value="number:37">山东省</option><option label="河南省" value="number:41">河南省</option><option label="湖北省" value="number:42">湖北省</option><option label="湖南省" value="number:43">湖南省</option><option label="广东省" value="number:44">广东省</option><option label="广西壮族自治区" value="number:45">广西壮族自治区</option><option label="海南省" value="number:46">海南省</option><option label="重庆市" value="number:50">重庆市</option><option label="四川省" value="number:51">四川省</option><option label="贵州省" value="number:52">贵州省</option><option label="云南省" value="number:53">云南省</option><option label="西藏自治区" value="number:54">西藏自治区</option><option label="陕西省" value="number:61">陕西省</option><option label="甘肃省" value="number:62">甘肃省</option><option label="青海省" value="number:63">青海省</option><option label="宁夏回族自治区" value="number:64">宁夏回族自治区</option><option label="新疆维吾尔自治区" value="number:65">新疆维吾尔自治区</option><option label="台湾省" value="number:71">台湾省</option><option label="香港特别行政区" value="number:81">香港特别行政区</option><option label="澳门特别行政区" value="number:82">澳门特别行政区</option></select>
        </div>
        <div class="col-sm-3">
            <select class="form-control ng-isolate-scope ng-not-empty ng-valid ng-valid-required"  name="cityCode" >
            <option value="" class="ng-binding" selected="selected">--请选择--</option><option label="南京市" value="number:3201">南京市</option><option label="无锡市" value="number:3202">无锡市</option><option label="徐州市" value="number:3203">徐州市</option><option label="常州市" value="number:3204">常州市</option><option label="苏州市" value="number:3205" selected="selected">苏州市</option><option label="南通市" value="number:3206">南通市</option><option label="连云港市" value="number:3207">连云港市</option><option label="淮安市" value="number:3208">淮安市</option><option label="盐城市" value="number:3209">盐城市</option><option label="扬州市" value="number:3210">扬州市</option><option label="镇江市" value="number:3211">镇江市</option><option label="泰州市" value="number:3212">泰州市</option><option label="宿迁市" value="number:3213">宿迁市</option></select>
        </div>
        <div class="col-sm-2">
            <select class="form-control ng-isolate-scope ng-not-empty ng-valid" ><option value="" class="ng-binding" selected="selected">--请选择--</option><option label="沧浪区" value="number:320502">沧浪区</option><option label="平江区" value="number:320503">平江区</option><option label="金阊区" value="number:320504">金阊区</option><option label="虎丘区" value="number:320505" selected="selected">虎丘区</option><option label="工业园区" value="number:320508">工业园区</option><option label="高新区" value="number:320509">高新区</option><option label="吴中区" value="number:320506">吴中区</option><option label="相城区" value="number:320507">相城区</option><option label="常熟市" value="number:320581">常熟市</option><option label="张家港市" value="number:320582">张家港市</option><option label="昆山市" value="number:320583">昆山市</option><option label="吴江市" value="number:320584">吴江市</option><option label="太仓市" value="number:320585">太仓市</option></select>
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">申请原因：</label>
        <div class="col-sm-8">
            <textarea rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text" ></textarea>
        </div>
    </div> -->
    <div class="form-group">
        <label class="col-sm-2 control-label">审核意见：</label>
        <div class="col-sm-8">
            <input type="radio" value="1" ${erp15.result_1_code eq '1'?"checked='checked'":'' }  class="ng-pristine ng-untouched ng-valid ng-not-empty" name="2677">通过  &nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" value="3" ${erp15.result_1_code eq '3'?"checked='checked'":'' }  name="2678">驳回&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="radio" value="2" ${erp15.result_1_code eq '2'?"checked='checked'":'' } name="2679">不通过
        </div>
    </div>
    <div class="form-group">
        <label class="col-sm-2 control-label">审核备注：</label>
        <div class="col-sm-8">
            <textarea rows="3" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text">${erp15.result_1_msg}</textarea>
        </div>
    </div>
</form>
</div>                                             
</div>	
</li>
</c:if>

   <c:choose>
		<c:when test="${erp15.status eq '12'}">
			<li class="text-primary">
			<em>${status.index+1}.完成</em>
			<div class="big-conte" style="display: none;">
			<div style="float:left;margin-left:20px;width:260px;" >
			<strong>完成时间：</strong>
			<fmt:formatDate value="${erp15.dt_edit}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</div>
			</div>
			</li>
		</c:when>
	    <c:otherwise>
	    
            <c:if test="${status.last}">
		    <jsp:include page="/kjs_icbc/model_son/starutil.jsp">
		    <jsp:param value="${erp15.dt_edit }" name="sdate"/>
		    <jsp:param value="${requestScope.sh_name}" name="sname"/>
		    <jsp:param value="${status.index+2 }" name="snum"/>
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