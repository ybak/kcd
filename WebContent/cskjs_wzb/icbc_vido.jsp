<%@page import="com.model1.icbc.icbc_mq_result"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="info_form" action="" class="form-horizontal" method="post" enctype="multipart/form-data" onsubmit="return check()">
<input id="id" name="id" value="${requestScope.icbc_mq.id }" type="hidden">
<input id="adminid" name="adminid" value="${sessionScope.id }" type="hidden">
	<div class="box-body">
<p style="border-bottom: 1px solid #f4f4f4;">
工行进件审核 来自：${requestScope.icbc_mq.gname }-${requestScope.icbc_mq.pname }
<span style="float:right;display:block;">
${fn:substring(requestScope.icbc_mq.dt_add,0,19)} 合同编码：
<font style="color: #ff8700;">${requestScope.icbc_mq.gems_code }</font>
</span>
</p>
	<div class="form-group">
	<h3 align="center" style="margin-right: 300px">用户提交信息</h3>
	</div>
<div style="width: 85%;" class="box-header">

<a href="downloadFiles_all.do?type=mq&id=${requestScope.id }" class="btn btn-success" style="margin-left:100px">一键下载所有视频</a>
</div>
<div class="box-body" style="margin-left: -150px;">
	<div class="form-group">
	<label class="col-sm-2 control-label">面签视频：</label>
		<div class="col-sm-10">
			<div class="row inline-from">			
			<div class="col-sm-4" align="center">
			<c:if test="${!empty requestScope.icbc_mq.imgstep8_1v}">
			<video id="imgstep8_1v"  name="imgstep8_1v" width="400" height="400"  controls="controls">
            <source src="http://a.kcway.net/assess/${requestScope.icbc_mq.imgstep8_1v }" />
            </video>
            <a style="padding: 0px 5px;" class="btn btn-success" id="" href="downloadFile.do?fileUrl=http://a.kcway.net/assess/${requestScope.icbc_mq.imgstep8_1v }&fileName=面签视频1">下载</a>							
							
			</c:if>
			<c:if test="${empty requestScope.icbc_mq.imgstep8_1v}">
			<video id="imgstep8_1v"  name="imgstep8_1v" width="400" height="400"  poster="${pageContext.request.contextPath }/cskjs_css/268222262987697898.jpg"  preload="none">
            <source src="http://a.kcway.net/assess/${requestScope.icbc_mq.imgstep8_1v }" />
            </video>
			</c:if>          
            <span  class="btn btn-warning">面签视频1</span>            
            </div>            
             <div class="col-sm-4" align="center">
            <c:if test="${!empty requestScope.icbc_mq.imgstep8_2v }">
             <video id="imgstep8_2v" name="imgstep8_2v"  width="400" height="400"   controls="controls">
            <source src="http://a.kcway.net/assess/${requestScope.icbc_mq.imgstep8_2v }" />
            </video>
            <a style="padding: 0px 5px;" class="btn btn-success" id="" href="downloadFile.do?fileUrl=http://a.kcway.net/assess/${requestScope.icbc_mq.imgstep8_2v }&fileName=面签视频2">下载</a>
            </c:if> 
            <c:if test="${empty requestScope.icbc_mq.imgstep8_2v }">
             <video id="imgstep8_2v" name="imgstep8_2v"  width="400" height="400"  poster="${pageContext.request.contextPath }/cskjs_css/268222262987697898.jpg"  preload="none">
            <source src="http://a.kcway.net/assess/${requestScope.icbc_mq.imgstep8_2v }" />
            </video>
            </c:if> 
            <span  class="btn btn-warning">面签视频2</span>
            </div>		 
		  </div>
	  </div>    
	</div>
	<div class="form-group" style="margin-top:80px;">
	<label class="col-sm-2 control-label">问答视频：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
			<div class="col-sm-4" align="center">
			<c:if test="${!empty requestScope.icbc_mq.imgstep8_3v }">
			<video id="imgstep8_3v" name="imgstep8_3v"  width="400" height="400"   controls="controls">
            <source src="http://a.kcway.net/assess/${requestScope.icbc_mq.imgstep8_3v }" />
            </video>
            <a style="padding: 0px 5px;" class="btn btn-success" id="" href="downloadFile.do?fileUrl=http://a.kcway.net/assess/${requestScope.icbc_mq.imgstep8_3v }&fileName=问答视频">下载</a>
			</c:if>
			<c:if test="${empty requestScope.icbc_mq.imgstep8_3v }">
			<video id="imgstep8_3v" name="imgstep8_3v"  width="400" height="400"  poster="${pageContext.request.contextPath }/cskjs_css/268222262987697898.jpg"  preload="none">
            <source src="http://a.kcway.net/assess/${requestScope.icbc_mq.imgstep8_3v }" />
            </video>
			</c:if>
            <span  class="btn btn-warning">问答视频</span>
            </div>  
            <!--           
		     <div class="col-sm-4" style="margin-left: 100px;">
		      <table>
		      <tr><td><div class="input-group">
		      <span class="input-group-addon" style="text-align: left;">1.问：您是***，手机号码***是您本人使用吗？</span>
		      </div> </td></tr>
		      
		      <tr><td><div class="input-group">
		      <span class="input-group-addon">答</span> 
			  <input class="form-control"  value="" type="text">
			  </div></td></tr>
			  
			  <tr><td><div class="input-group">
		      <span class="input-group-addon" style="text-align: left;">2.问：您通过安联公司申请的该笔购车分期本金是多少？汽车金融服务费本金是多少？贷款几年？</span>
		      </div> </td></tr>
		      
			  <tr><td><div class="input-group">
		      <span class="input-group-addon">答</span> 
			  <input class="form-control"  value="" type="text">
			  </div></td></tr>
			  
			  <tr><td><div class="input-group">
		      <span class="input-group-addon" style="text-align: left;">3.问：您申请的汽车分期手续费和本金是按期向您收取，每月月还款额请问是多少？</span>
		      </div> </td></tr>
		      
			  <tr><td><div class="input-group">
		      <span class="input-group-addon">答</span> 
			  <input class="form-control"  value="" type="text">
			  </div></td></tr>
			  
			  <tr><td><div  class="input-group">
		      <span  class="input-group-addon" style="text-align: left;">4.问：请您提供一下地址作为银行合同寄收及债务催收和诉讼（仲裁）文书的送达地址，确保您能正常及时接收。</span>
		      </div> </td></tr>

			  <tr><td><div class="input-group">
		      <span class="input-group-addon">答</span> 
			  <input class="form-control"  value="" type="text">
			  </div></td></tr>
		      </table>
		      
		     </div>
		     --> 
		  </div>
	  </div>    
	</div>
		<div class="form-group" style="margin-top:80px;">
	<label class="col-sm-2 control-label">电审视频：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
			<div class="col-sm-4" align="center">
			<c:if test="${!empty requestScope.icbc_mq.imgstep8_4v }">
			<video id="imgstep8_4v" name="imgstep8_4v" width="400" height="400"   controls="controls">
            <source src="http://a.kcway.net/assess/${requestScope.icbc_mq.imgstep8_4v }" />
            </video>
            <a style="padding: 0px 5px;" class="btn btn-success" id="" href="downloadFile.do?fileUrl=http://a.kcway.net/assess/${requestScope.icbc_mq.imgstep8_4v }&fileName=电审视频">下载</a>
			</c:if>
			
			<c:if test="${empty requestScope.icbc_mq.imgstep8_4v }">
			<video id="imgstep8_4v" name="imgstep8_4v" width="400" height="400"  poster="${pageContext.request.contextPath }/cskjs_css/268222262987697898.jpg"  preload="none">
            <source src="http://a.kcway.net/assess/${requestScope.icbc_mq.imgstep8_4v }" />
            </video>
			</c:if>
            <span  class="btn btn-warning">电审视频</span>
            </div> 
            <!-- 
		    <div class="col-sm-4" style="margin-left: 100px;">
		      <table>
		      <tr><td><div class="input-group">
		      <span class="input-group-addon" style="text-align: left;">1.您好，请问你是***先生/女士吗？您是否申请了个人汽车分期付款？</span>
		      </div> </td></tr>
		      
		      <tr><td><div class="input-group">
		      <span class="input-group-addon">答</span> 
			  <input class="form-control"  value="" type="text">
			  </div></td></tr>
			  
			  <tr><td><div class="input-group">
		      <span class="input-group-addon" style="text-align: left;">2.请您提供下您的身份证号码。（生日、几岁）</span>
		      </div> </td></tr>
		      
			  <tr><td><div class="input-group">
		      <span class="input-group-addon">答</span> 
			  <input class="form-control"  value="" type="text">
			  </div></td></tr>
			  
			  <tr><td><div class="input-group">
		      <span class="input-group-addon" style="text-align: left;">3.你的常用手机是哪个？号码是多少？</span>
		      </div> </td></tr>
		      
			  <tr><td><div class="input-group">
		      <span class="input-group-addon">答</span> 
			  <input class="form-control"  value="" type="text">
			  </div></td></tr>
			  
			  <tr><td><div  class="input-group">
		      <span  class="input-group-addon" style="text-align: left;">4.你是否已婚？</span>
		      </div> </td></tr>

			  <tr><td><div class="input-group">
		      <span class="input-group-addon">答</span> 
			  <input class="form-control"  value="" type="text">
			  </div></td></tr>
			  
			  <tr><td><div  class="input-group">
		      <span  class="input-group-addon" style="text-align: left;">5.您的工作单位是哪里？</span>
		      </div> </td></tr>

			  <tr><td><div class="input-group">
		      <span class="input-group-addon">答</span> 
			  <input class="form-control"  value="" type="text">
			  </div></td></tr>
			  
			  <tr><td><div  class="input-group">
		      <span  class="input-group-addon" style="text-align: left;">6.您的月收入是多少？您配偶的月收入是多少？</span>
		      </div> </td></tr>

			  <tr><td><div class="input-group">
		      <span class="input-group-addon">答</span> 
			  <input class="form-control"  value="" type="text">
			  </div></td></tr>
			  
			  <tr><td><div  class="input-group">
		      <span  class="input-group-addon" style="text-align: left;">7.您申请的汽车贷款车辆品牌型号是什么？车辆价格是多少？</span>
		      </div> </td></tr>

			  <tr><td><div class="input-group">
		      <span class="input-group-addon">答</span> 
			  <input class="form-control"  value="" type="text">
			  </div></td></tr>
			  			  
			  <tr><td><div  class="input-group">
		      <span  class="input-group-addon" style="text-align: left;">8.你对收费明细单中所列示的银行贷款本金和手续费是否清楚并确认无误？</span>
		      </div> </td></tr>

			  <tr><td><div class="input-group">
		      <span class="input-group-addon">答</span> 
			  <input class="form-control"  value="" type="text">
			  </div></td></tr>
			  
			  <tr><td><div  class="input-group">
		      <span  class="input-group-addon" style="text-align: left;">9.分期合同等所有的相关资料，都是你本人亲笔签署的吗？对您所签的合同条款是否明确？</span>
		      </div> </td></tr>

			  <tr><td><div class="input-group">
		      <span class="input-group-addon">答</span> 
			  <input class="form-control"  value="" type="text">
			  </div></td></tr>
			  
			  <tr><td><div  class="input-group">
		      <span  class="input-group-addon" style="text-align: left;">10.您提供的资料是否真实?</span>
		      </div> </td></tr>

			  <tr><td><div class="input-group">
		      <span class="input-group-addon">答</span> 
			  <input class="form-control"  value="" type="text">
			  </div></td></tr>
		      </table>
		     </div>
		     -->
		  </div>
	  </div>    
	</div>
			    <script type="text/javascript">
		    
		    function icbc_carsup() {
		    	id=document.getElementById("id").value;
		    	adminid=document.getElementById("adminid").value;
		    	bc_status=document.getElementById("status").value;
		    	remark=document.getElementById("remark").value;
		        // alert(bc_status);
		    	$.ajax({
		    		   type:"post",   
		    		   url:"icbc_sp_up.do",
		    		   data:{
		    			   id : id,
		    			   adminid : adminid,
		    			   bc_status : bc_status,
		    			   remark : remark
		    		   },
		    	  success: function(msg){
		    		  alert("提交成功");
		    		  window.location.reload();
		    		},
		    	 error:function(){
		              alert("提交失败，请稍后重试...");         
		           }
		    	  })
		    	
		    	
		    }
		    </script>
</div>
	<div id="section6" class="box-header with-border" style="margin-top:50px; width: 85%">
	<h3 align="center" >审核处理</h3>
    </div>
<div class="box-body">
	<div class="form-group">
	<label class="col-sm-2 control-label">审核：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
				<div class="col-sm-4">
					<div class="input-group">
					<span class="input-group-addon">审核状态</span> 
					<select  id="status" name="status" class="form-control"  onchange="autoremark();">
					   <option value="0">请选择</option>
					   <option value="1" ${requestScope.icbc_mq.bc_status==1?"selected='selected'":''}>草稿箱</option>
                       <option value="2" ${requestScope.icbc_mq.bc_status==2?"selected='selected'":''}>审核中</option>
                       <option value="3" ${requestScope.icbc_mq.bc_status==3?"selected='selected'":''}>审核通过</option>
                       <option value="4" ${requestScope.icbc_mq.bc_status==4?"selected='selected'":''}>回退补件</option>                           
                       <option value="5" ${requestScope.icbc_mq.bc_status==5?"selected='selected'":''}>未用</option>
                       <option value="6" ${requestScope.icbc_mq.bc_status==6?"selected='selected'":''}>撤销</option> 
                   </select>
                   </div>
			</div>
            <div class="col-sm-3">
					<div class="input-group"><span class="input-group-addon">类型</span> 
					<input class="form-control" readonly="" value="视频" type="text"></div>
			</div>
		  </div>
	  </div>
	</div>
	<div class="form-group">
	<label class="col-sm-2 control-label">留言备注说明：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
				<div class="col-sm-4">
					<div class="input-group"><span class="input-group-addon">审核留言</span> <input class="form-control" name="remark" id="remark" type="text"></div>
			</div>
				<div class="col-sm-4">
					<div class="input-group">
					<span class="input-group-addon">留言快速通道</span> 
					<select class="form-control" id="cyly" onchange="setremark(this)">
					<option value="请选择" selected="selected">请选择</option>						
					<option value="查询完成，详情请点击历史查询-&gt;已完成-&gt;查看订单！">查询完成，详情请点击历史查询-&gt;已完成-&gt;查看订单！</option>						
					<option value="恭喜您初审通过,请点编辑按钮,按提示上传其他补充材料！">恭喜您初审通过,请点编辑按钮,按提示上传其他补充材料！</option>						
					<option value="请提供行驶证与驾照正面照片！">请提供行驶证与驾照正面照片！</option>						
					<option value="请上传正确的行驶证照片">请上传正确的行驶证照片</option>						
					<option value="行驶证错误，要的是信息页。车牌车架发动机号页面">行驶证错误，要的是信息页。车牌车架发动机号页面</option>						
					<option value="行驶证要上传信息页面，上传后面一页无法识别。">行驶证要上传信息页面，上传后面一页无法识别。</option>						
					<option value="提交材料过于模糊，无法识别">提交材料过于模糊，无法识别</option>						
					<option value="请 上传行驶证">请 上传行驶证</option>						
					<option value="请上传完整的行驶证驾驶证照片">请上传完整的行驶证驾驶证照片</option>						
					</select></div>
			</div>
		</div>
	</div></div>
	    <script> _V_.options.flash.swf = "assets/lib/js/movive/video-js.swf";</script>  
<div class="form-group">
<label class="col-sm-2 control-label">历次审核事件和留言：</label>
<div class="col-sm-10">
<textarea style="width: 80%; height: 200px" class="form-control" readonly="readonly">
<c:forEach items="${requestScope.iml }" var="iml">${fn:substring(iml.dt_add,0,19)}:状态：${iml.remarkstatus},留言：${iml.remark }
</c:forEach>
</textarea>
</div>
</div>
</div>		
</div>
			<div class="footer-wrap" >
			<div class="box-footer">
				<button type="button" class="btn btn-default" onclick="location.href='kjs_mq.do?out=1&id=${requestScope.id}&querytype=${requestScope.querytype}&size=${requestScope.size}&status=${requestScope.status}'">取消返回</button>
				<button type="button" style="margin-right: 70px;" onclick="icbc_carsup();" class="btn btn-primary pull-right">保存提交</button> 
			</div>
		    </div>	
</form>

</body>
</html>