<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
             <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
$(document).ready(function(){
	source_id=document.getElementById("source_id").value;//获取目标Id
	g1=document.getElementById("g1");//获取目标Id
	g2=document.getElementById("g2");//获取目标Id
	property_id=document.getElementById("property_id").value;//获取目标Id
	y1=document.getElementById("y1");//获取目标Id
	y2=document.getElementById("y2");//获取目标Id
	gear_box_id=document.getElementById("gear_box_id").value;
	b1=document.getElementById("b1");//获取目标Id
	b2=document.getElementById("b2");//获取目标Id
	car_status=document.getElementById("car_status").value;
	c1=document.getElementById("c1");//获取目标Id
	c2=document.getElementById("c2");//获取目标Id
	c3=document.getElementById("c3");//获取目标Id
	if(source_id==1){
		g1.src="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png";
		g2.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
	}
	if(source_id==2){
		g2.src="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png";
		g1.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
	}
	if(property_id==1){
		y1.src="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png";
		y2.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
	}
	if(property_id==2){
		y2.src="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png";
		y1.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
	}
	if(gear_box_id==1){
		b1.src="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png";
		b2.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
	}
	if(gear_box_id==2){
		b2.src="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png";
		b1.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
	}
	if(car_status==1){
		c3.src="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png";
		c2.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
		c1.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
	}
	if(car_status==2){
		c2.src="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png";
		c1.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
		c3.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
	}
	if(car_status==3){		
		c1.src="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png";
		c2.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
		c3.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
	}
});

function radioimg(i) {
	source_id=document.getElementById("source_id");//获取目标Id
	g1=document.getElementById("g1");//获取目标Id
	g2=document.getElementById("g2");//获取目标Id
	  if(i==1){   
		if(g1.src!="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png"){
		  g1.src="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png";	
		}
		g2.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
		source_id.value=1;
	  }
	  if(i==2){
			if(g2.src!="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png"){
			  g2.src="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png";	
			}
			g1.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
			source_id.value=2;
	 }       
}

function radioimg1(i) {
	property_id=document.getElementById("property_id");//获取目标Id
	y1=document.getElementById("y1");//获取目标Id
	y2=document.getElementById("y2");//获取目标Id
	  if(i==1){   
		if(y1.src!="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png"){
		  y1.src="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png";	
		}
		y2.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
		property_id.value=1;
	  }
	  if(i==2){
			if(y2.src!="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png"){
			  y2.src="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png";	
			}
			y1.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
			property_id.value=2;
		  }       
}
function radioimg2(i) {
	gear_box_id=document.getElementById("gear_box_id");
	b1=document.getElementById("b1");//获取目标Id
	b2=document.getElementById("b2");//获取目标Id
	  if(i==1){   
		if(b1.src!="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png"){
		  b1.src="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png";	
		}
		b2.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
		gear_box_id.value=1;
	  }
	  if(i==2){
			if(b2.src!="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png"){
			  b2.src="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png";	
			}
			b1.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
			gear_box_id.value=2;
		  }       
}
function radioimg3(i) {
	car_status=document.getElementById("car_status");
	c1=document.getElementById("c1");//获取目标Id
	c2=document.getElementById("c2");//获取目标Id
	c3=document.getElementById("c3");//获取目标Id
	  if(i==1){   
		if(c1.src!="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png"){
		  c1.src="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png";	
		}
		c2.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
		c3.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
		car_status.value=3;
	  }
	  if(i==2){
			if(c2.src!="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png"){
			  c2.src="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png";	
			}
			c1.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
			c3.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
			car_status.value=2;
		  }   
	  if(i==3){
			if(c3.src!="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png"){
			  c3.src="${pageContext.request.contextPath }/cskjs_css/744877390532520340.png";	
			}
			c1.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
			c2.src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png";
			car_status.value=1;
		  } 
}

function ypup() {
	id=document.getElementById("id").value;
	adminid=document.getElementById("adminid").value;
	bc_status=document.getElementById("bc_status").value;
	price_reuslt=document.getElementById("price_reuslt").value;
	remark=document.getElementById("remark").value;
	$.ajax({
		   type:"post",   
		   url:"yp_up.do",
		   data:{
			   id : id,
			   adminid : adminid,
			   bc_status : bc_status,
			   price_reuslt : price_reuslt,
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form id="info_form" action="" class="form-horizontal" method="post" enctype="multipart/form-data" onsubmit="return check()">
<input id="id" name="id" value="${requestScope.iPreaudit.id }" type="hidden">
<input id="adminid" name="adminid" value="${sessionScope.id }" type="hidden">
<div class="box-header with-border">
	<div  class="box-body" style="margin-left: 150px;width: 80%" >  	     	            
			<div class="form-group">						
			  <h3 align="center" style="margin-right: 300px">用户提交信息</h3>
			  <div  style="padding-top: 60px;width:85%;">               
             <p>工行进件审核 来自：${requestScope.iPreaudit.gname }-${requestScope.iPreaudit.pname }<span style="float:right;display:block;">${fn:substring(requestScope.iPreaudit.dt_add,0,19)} 合同编码：<font style="color: #ff8700;">${requestScope.iPreaudit.gems_code }</font></span></p>            
              <div class="divcss">
               <table id="data_table" class="table" style="width:100%; ;border-style:none">  
               <tr>
               <td style="color: #5f5f6c;">车牌号</td>
               <td><input id="carno" name="carno" class="inputcss" type="text" value="${requestScope.iPreaudit.carno }" /></td>
               <td></td>
               <td style="color: #5f5f6c;">车型</td>
               <td colspan="3">
               <select id="carid" name="carid" >
               <c:if test="${!empty requestScope.carmodel.name }">
               <option value="${requestScope.carmodel.id }">${requestScope.carmodel.name }</option>
               </c:if>             
               <option value="0">请选择车型</option>                          
               </select>
               </td>
               <td></td>
               <td></td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">行驶里程</td>
               <td><input id="carkm" name="carkm" class="inputcss" type="text" value="${requestScope.iPreaudit.carkm }万里" /></td>
               <td></td>
               <td style="color: #5f5f6c;">国产/进口</td>
               <td></td>
               <td>
               <input type="hidden" id="source_id" name="source_id" value="${requestScope.iPreaudit.source_id }">
               <img id="g1" name="g1" onclick="radioimg('1')" style="padding-right: 5px;" alt="国产" src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png" />国产
               </td>
               <td>
               <img id="g2" name="g2" onclick="radioimg('2')"  style="padding-right: 5px;" alt="进口" src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png" />进口
               </td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">车架号</td>
               <td><input id="carvin" name="carvin" class="inputcss" type="text" value="${requestScope.iPreaudit.carvin }" /></td>
               <td></td>
               <td style="color: #5f5f6c;">使用性质</td>
               <td></td>
               <td>
               <input type="hidden" id="property_id" name="property_id" value="${requestScope.iPreaudit.property_id }">              
               <img id="y1" name="y1" onclick="radioimg1('1')" style="padding-right: 5px;" alt="" src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png">营运</td>
               <td><img id="y2" name="y2" onclick="radioimg1('2')" style="padding-right: 5px;" alt="" src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png">非营运</td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">出厂日期</td>
               <td><input class="inputcss" type="text" value="${fn:substring(requestScope.iPreaudit.cardt2,0,10)}" /></td>
               <td></td>
               <td style="color: #5f5f6c;">变速箱</td>
               <td></td>
               <td>
               <input type="hidden" id="gear_box_id" name="gear_box_id" value="${requestScope.iPreaudit.gear_box_id }">              
              
               <img id="b1" name="b1" onclick="radioimg2('1')" style="padding-right: 5px;" alt="" src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png">手动</td>
               <td><img id="b2" name="b2" onclick="radioimg2('2')" style="padding-right: 5px;" alt="" src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png">自动</td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">初次登记时间</td>
               <td><input class="inputcss" type="text" value="${fn:substring(requestScope.iPreaudit.cardt1,0,10)}" /></td>
               <td></td>
               <td style="color: #5f5f6c;">车辆状况</td>
               <td>
               <input type="hidden" id="car_status" name="car_status" value="${requestScope.iPreaudit.car_status }">              
              
               <img id="c1" name="c1" onclick="radioimg3('1')" style="padding-right: 5px;" alt="" src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png">一般</td>
               <td><img id="c2" name="c2" onclick="radioimg3('2')" style="padding-right: 5px;" alt="" src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png">良好</td>
               <td><img id="c3" name="c3" onclick="radioimg3('3')" style="padding-right: 5px;" alt="" src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png">优秀</td>
               </tr>
               </table>              
              </div>
              </div>
              </div>
		   </div>			
	</div>
	
		<div id="section6" class="box-header with-border" style="width: 85%">
	<h3 align="center" >审核处理</h3>
    </div>
<div class="box-body">
	<div class="form-group">
	<label class="col-sm-2 control-label">审核：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
				<div class="col-sm-4">
					<div class="input-group"><span class="input-group-addon">审核状态</span> 
					<select id="bc_status" name="bc_status" class="form-control"  onchange="autoremark();">
                            	<option value="1" ${requestScope.iPreaudit.bc_status==1?"selected='selected'":''}>草稿箱</option>
                            	<option value="2" ${requestScope.iPreaudit.bc_status==2?"selected='selected'":''}>正在审核中</option>
                            	<option value="3" ${requestScope.iPreaudit.bc_status==3?"selected='selected'":''}>审核通过</option>
                            	<option value="4" ${requestScope.iPreaudit.bc_status==4?"selected='selected'":''}>回退补件</option>
                            	<option value="5" ${requestScope.iPreaudit.bc_status==5?"selected='selected'":''}>已撤销</option>                            
                            	</select>
                            	</div>
			</div>
            <div class="col-sm-3">
					<div class="input-group"><span class="input-group-addon">类型</span> 
					<input class="form-control" readonly="" value="预评" type="text"></div>
			</div>
			<div class="col-sm-3">
					<div class="input-group">
					<span class="input-group-addon">预审价格</span> 
					<input id="price_reuslt"  name="price_reuslt" class="form-control" style="width: 95px;" value="${requestScope.carmodel.price }" type="text">
					<span class="input-group-addon">万</span>
					</div>
			</div>
		  </div>
	  </div>
	</div>
	<div class="form-group"><label class="col-sm-2 control-label">留言备注说明：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
				<div class="col-sm-4">
					<div class="input-group"><span class="input-group-addon">审核留言</span> 
					<input class="form-control" name="remark" id="remark" type="text"></div>
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
					<option value="行驶证要上传信息页面，上传后面一页无法识别。">行驶证要上传信息页面，上传后面一页无法识别。</option>						<option value="提交材料过于模糊，无法识别">提交材料过于模糊，无法识别</option>						
					<option value="请 上传行驶证">请 上传行驶证</option>						
					<option value="请上传完整的行驶证驾驶证照片">请上传完整的行驶证驾驶证照片</option>						
					</select></div>
			</div>
		</div>
	</div></div>
<div class="form-group">
<label class="col-sm-2 control-label">历次审核事件和留言：</label>
<div class="col-sm-10">
<textarea style="width: 80%; height: 200px" class="form-control" readonly="readonly">
<c:forEach items="${requestScope.iResults }" var="il">${fn:substring(il.dt_add,0,19)}:状态：${il.status==0?'草稿':''}${il.status==1?'草稿箱':''}${il.status==2?'提交等待':''}${il.status==3?'查询成功':''}${il.status==4?'回退':''}${il.status==5?'撤销':''},留言：${il.remark }
</c:forEach>
</textarea>
</div>
</div>
</div>	

		<div class="footer-wrap">
			<div class="box-footer" >
				<button type="button" class="btn btn-default" onclick="location.href='newicbc.do?id=${requestScope.id }&out=1&querytype=${requestScope.querytype}&size=${requestScope.size}&status=${requestScope.status}'">取消返回</button>
				<button type="button" style="margin-right: 70px;" onclick="ypup();" class="btn btn-primary pull-right">保存提交</button> 
			</div>
		</div>	
		</form>
		
</body>
</html>