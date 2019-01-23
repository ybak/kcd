<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/wangye0119/assets/css/bootstrap.min.css" rel="stylesheet" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/wangye0119/css/style.css" />
<link href="${pageContext.request.contextPath}/wangye0119/assets/css/codemirror.css" rel="stylesheet">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/wangye0119/assets/css/ace.min.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/wangye0119/assets/css/font-awesome.min.css" />
	<!--[if IE 7]>
		  <link rel="stylesheet" href="assets/css/font-awesome-ie7.min.css" />
		<![endif]-->
	<!--[if lte IE 8]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
	<script src="${pageContext.request.contextPath}/wangye0119/assets/js/jquery.min.js"></script>

	<!-- <![endif]-->

	<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

	<!--[if !IE]> -->

	<script type="text/javascript">
			window.jQuery || document.write("<script src='assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>

	<!-- <![endif]-->

	<!--[if IE]>
<script type="text/javascript">
 window.jQuery || document.write("<script src='assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

	<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
	<script src="${pageContext.request.contextPath}/wangye0119/assets/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/wangye0119/assets/js/typeahead-bs2.min.js"></script>
	<!-- page specific plugin scripts -->
	<script src="${pageContext.request.contextPath}/wangye0119/assets/js/jquery.dataTables.min.js"></script>
	<script src="${pageContext.request.contextPath}/wangye0119/assets/js/jquery.dataTables.bootstrap.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/wangye0119/js/H-ui.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/wangye0119/js/H-ui.admin.js"></script>
	<script src="${pageContext.request.contextPath}/wangye0119/assets/layer/layer.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/wangye0119/assets/laydate/laydate.js" type="text/javascript"></script>
	<title>用户列表</title>
</head>

<body>
	<div class="page-content clearfix">
		<div id="Member_Ratings">
			<div class="d_Confirm_Order_style">
				<div class="search_style">

					<ul class="search_content clearfix">
						<li><label class="l_f">会员名称</label>
						<input id="likeTname" name="likeTname" type="text" class="text_add" placeholder="输入客户名字" style="width: 400px" /></li>
						<!-- <li style="width: 90px;">
							<button type="button" class="btn_search">
							<i class="icon-search"></i>查询
							</button>
						</li> -->
					    <c:choose>
							<c:when test="${sessionScope.bms_deptno==10}">
								<li style="width: 80px;">
									<button onclick="selectClientLike()" type="button" class="btn_search"><i class="icon-search"></i>查</button>
								</li>
							</c:when>
							<c:when test="${sessionScope.bms_deptno==20}">
								<li style="width: 80px;">
									<button onclick="selectClientLikeManager()" type="button" class="btn_search"><i class="icon-search"></i>查</button>
								</li>
							</c:when>
							<c:when test="${sessionScope.bms_deptno==30}">
								<li style="width: 80px;">
									<button onclick="selectClientLikeManager()" type="button" class="btn_search"><i class="icon-search"></i>查</button>
								</li>
							</c:when>
						</c:choose>
					</ul>
				</div>
				<!---->
				<div class="border clearfix">
					<span class="l_f">
						<a href="javascript:ovid()" id="member_add" class="btn btn-warning"><i class="icon-plus"></i>添加用户</a>
						<!-- <a href="javascript:ovid()" class="btn btn-danger"><i class="icon-trash"></i>批量删除</a> -->
						<span class="r_f">共<b>${requestScope.clientSum}</b>个客户</span>
					</span> 
				</div>
				<!---->
				<div class="table_menu_list">
					<table class="table table-striped table-bordered table-hover"
						id="sample-table">
						<thead>
							<tr>
								<th width="25"><label><input type="checkbox"
										class="ace"><span class="lbl"></span></label></th>
								<th width="80">ID</th>
								<th width="100">客户名字</th>
								<th width="100">余额</th>
								<th width="100">系统账号</th>
								<th width="80">所属单位</th>
								<th width="120">手机</th>
								<th width="200">地址</th>
								<th width="180">加入时间</th>
								<c:choose>
									<c:when test="${sessionScope.bms_deptno==10}">
										<th width="100">转移客户</th>
									</c:when>
									<c:when test="${sessionScope.bms_deptno==40}">
										<th width="100">转移客户</th>
									</c:when>
								</c:choose>
								<th width="70">状态</th>
								<th width="250">操作</th>
							</tr>
						</thead>
						<tbody>					
							<c:forEach items="${requestScope.list}" var="client">
								<tr>
									<td><label><input type="checkbox" class="ace"><span
												class="lbl"></span></label></td>
									<td>${client.tid}</td>
									<td><u style="cursor:pointer;text-decoration:none;" class="text-primary"
										onclick="member_show('${client.tname}','${pageContext.request.contextPath}/selectOneClientByTid.do','${client.tid}','425','400')">${client.tname}【跟进详情】
										</u></td>
									<td>${client.tsumMany}</td>
									<td>${client.username}</td>
									<td>${client.cname}</td>
									<td>${client.clientPhone}</td>
									<td class="text-l">${client.clientAddress}</td>
									<td>${client.caddTime}</td>
									<c:choose>
										<c:when test="${sessionScope.bms_deptno==10}">
											<td>
												<select onchange="updateClientToUserUp(${client.tid},this.options[this.options.selectedIndex].value)">
													<c:forEach items="${requestScope.allUser}" var="user">
														<option value="${user.uid}" ${client.ucid == user.uid?"selected='selected'":''}>${user.uname}</option>
													</c:forEach>
												</select>
											</td>
										</c:when>
										<c:when test="${sessionScope.bms_deptno==40}">
											<td>
												<select onchange="updateClientToUserUp(${client.tid},this.options[this.options.selectedIndex].value)">
													<c:forEach items="${requestScope.allUser}" var="user">
														<option   value="${user.uid}" ${client.ucid == user.uid?"selected='selected'":''}>${user.uname}--${user.uid}</option>
													</c:forEach>
												</select>
											</td>
										</c:when>
									</c:choose>
									<c:choose>
										<c:when test="${client.status==1}">
											<td class="td-status">
												<span class="label label-success radius">已启用</span>
											</td>
										</c:when>
										<c:when test="${client.status==0}">
											<td class="td-status">
												<span class="label label-defaunt radius">已停用</span>
											</td>
										</c:when>
									</c:choose>
									<td class="td-manage">
										<c:choose>
											<c:when test="${client.status==1}">
												<a onClick="member_stop(this,${client.tid})" href="javascript:;"
												title="停用" class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i>
												</a> 
											</c:when>
											<c:when test="${client.status==0}">
												<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this,${client.tid})" 
													href="javascript:;" title="启用"><i class="icon-ok bigger-120"></i>
												</a>
											</c:when>
										</c:choose> 
										<!-- ${pageContext.request.contextPath}/updateOneClientByTid.do?tid=${client.tid} -->
										<%-- <c:choose>
											<c:when test="${sessionScope.bms_deptno==10}">
												<a title="编辑" onclick="member_edit('001')" href="javascript:;"
													class="btn btn-xs btn-info"><i class="icon-edit bigger-120"></i></a> 
											</c:when>
											<c:when test="${sessionScope.bms_deptno==40}">
												<a title="编辑" onclick="member_edit('001')" href="javascript:;"
													class="btn btn-xs btn-info"><i class="icon-edit bigger-120"></i></a> 
											</c:when>
										</c:choose> --%>
									    <a title="删除"
										href="javascript:;" onclick="member_del(this,${client.tid})"
										class="btn btn-xs btn-warning"><i
											class="icon-trash  bigger-120"></i></a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<!--添加用户图层-->
	<div class="add_menber" id="add_menber_style" style="display:none;">
		<form  action="${pageContext.request.contextPath}/addBMSClient.do" method="post" enctype="multipart/form-data" id="clientAdd">
		<ul class=" page-content">
			<li>
				<label class="label_name">用&nbsp;&nbsp;户 &nbsp;名：</label>
				<span class="add_name"><input name="tname" type="text" class="text_add" /></span>
				<div class="prompt r_f"></div>
			</li>
			
			<li>
				<!-- <label class="label_name">真实姓名：</label>
				<span class="add_name"><input name="真实姓名" type="text" class="text_add" /></span>
				<div class="prompt r_f"></div> -->
			</li>
			
			<li>
				<label class="label_name">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
				<span class="add_name"> 
					<label><input name="sex" value="1" type="radio" checked="checked" class="ace">
					<span class="lbl">男</span></label>&nbsp;&nbsp;&nbsp; 
					<label><input name="sex" value="2" type="radio" class="ace">
					<span class="lbl">女</span></label>&nbsp;&nbsp;&nbsp; 
				</span>
				<div class="prompt r_f"></div>
			</li>
			
			<li>
				<!-- <label class="label_name">固定电话：</label>
				<span class="add_name">
				<input name="固定电话" type="text" class="text_add" />
				</span>
				<div class="prompt r_f"></div> -->
			</li>
			
			<li>
				<label class="label_name">移动电话：</label>
				<span class="add_name"><input name="clientPhone" type="text" class="text_add" /></span>
				<div class="prompt r_f"></div>
			</li>
			
			<li>
				<!-- <label class="label_name">电子邮箱：</label>
				<span class="add_name"><input name="电子邮箱" type="text" class="text_add" /></span>
				<div class="prompt r_f"></div> -->
			</li>
	
			<li>
				<label class="label_name">所属单位：</label>
				<span class="add_name"><input  name="cname" type="text" class="text_add" /></span>
				<div class="prompt r_f"></div>
			</li>

			<li class="adderss">
				<label class="label_name">公司地址：</label>
				<span class="add_name"><input name="clientAddress" type="text" class="text_add" style="width: 350px" /></span>
				<div class="prompt r_f"></div>
			</li>
			<li class="adderss">
				<label class="label_name">跟进情况：</label>
				<span class="add_name"><input name="ta" type="text" class="text_add" style="width: 350px" /></span>
				<div class="prompt r_f"></div>
			</li>
			
			<li>
				<label class="label_name">状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态：</label>
				<span class="add_name"> 
					<label>
						<input name="status" value="1" type="radio" checked="checked" class="ace">
						<span class="lbl">开启</span>
					</label>&nbsp;&nbsp;&nbsp;
					<label>
						<input name="status" value="0" type="radio" class="ace">
						<span class="lbl">关闭</span>
					</label>
				</span>
			<div class="prompt r_f"></div></li>
		</ul>
		</form>
	</div>
</body>
</html>
<script>
jQuery(function($) {
				var oTable1 = $('#sample-table').dataTable( {
				"aaSorting": [[ 1, "desc" ]],//默认第几个排序
		"bStateSave": true,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,8,9]}// 制定列不参与排序
		] } );
				$('table th input:checkbox').on('click' , function(){
					var that = this;
					$(this).closest('table').find('tr > td:first-child input:checkbox')
					.each(function(){
						this.checked = that.checked;
						$(this).closest('tr').toggleClass('selected');
					});
						
				});
				$('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
				function tooltip_placement(context, source) {
					var $source = $(source);
					var $parent = $source.closest('table')
					var off1 = $parent.offset();
					var w1 = $parent.width();
			
					var off2 = $source.offset();
					var w2 = $source.width();
			
					if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
					return 'left';
				}
			})
			
		
//修改某客户到管理员下面
function updateClientToUserUp(tid,ucid){
	layer.confirm('确定要修改吗?',{
		  btn: ['确定', '取消'] //可以无限个按钮
		}, function(index,layero){
		  	//按钮【确定】的回调
		  	alert(tid+"--"+ucid);
			location.href="updateClientToUserUp.do?tid="+tid+"&ucid="+ucid;
		}, function(index){
		  //按钮【取消】的回调
	});
}			
			
//业务经理或业务员模糊查询   
function selectClientLikeManager(){
	var likeTname = $("#likeTname").val();
	location.href="selectClientLikeManager.do?tname="+likeTname;
}	
			
//主管模糊查询   
function selectClientLike(){
	var likeTname = $("#likeTname").val();
	location.href="selectClientLike.do?tname="+likeTname;
}			
/*用户-添加*/
$('#member_add').on('click', function(){
    layer.open({
        type: 1,
        title: '添加用户',
		maxmin: true, 
		shadeClose: true, //点击遮罩关闭层
        area : ['600px' , ''],
        content:$('#add_menber_style'),
		btn:['提交','取消'],
		yes:function(index,layero){	
		var num=0;
		var str="";
	     $(".add_menber input[type$='text']").each(function(n){
	          if($(this).val()==""){
				   layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
	               title: '提示框',				
				   icon:0,								
	          	   }); 
			       num++;
	            return false;            
	          }
			  });
			  if(num>0){
				  return false;
			  }else{
				  // 提交添加客户表单
				  $("#clientAdd").submit(); 
				  layer.alert('添加成功！',{
	              title: '提示框',				
				  icon:1,		
			  	  });
				  layer.close(index);
			  }		  		     				
			}
	    });
});
/*用户-查看*/
function member_show(title,url,id,w,h){
	layer_show(title+'-跟进记录',url+'?tid='+id,w,h);
}

/*用户-停用 */
function member_stop(obj,uuid){
	layer.confirm('确认要停用吗？',function(index){
		layer.msg('已停用!',{icon: 5,time:1000});
		location.href="updateClientStatus.do?status=1&tid="+uuid;
	});
}
/*用户-启用  */
function member_start(obj,uuid){
	layer.confirm('确认要启用吗？',function(index){
		layer.msg('已启用!',{icon: 6,time:1000}); 
		location.href="updateClientStatus.do?status=0&tid="+uuid;
	});
} 
/*用户-编辑*/
function member_edit(id){
	  layer.open({
        type: 1,
        title: '修改用户信息',
		maxmin: true, 
		shadeClose:false, //点击遮罩关闭层
        area : ['800px' , ''],
        content:$('#add_menber_style'),
		btn:['提交','取消'],
		yes:function(index,layero){	
		 var num=0;
		 var str="";
     $(".add_menber input[type$='text']").each(function(n){
          if($(this).val()=="")
          {
			   layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
                title: '提示框',				
				icon:0,								
          }); 
		    num++;
            return false;            
          } 
		 });
		  if(num>0){  return false;}	 	
          else{
			  layer.alert('添加成功！',{
               title: '提示框',				
			icon:1,		
			  });
			   layer.close(index);	
		  }		  		     				
		}
    });
}
/*用户-删除*/
function member_del(obj,tid){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
		location.href="deleteClientByTid.do?tid="+tid;
	});
}
laydate({
    elem: '#start',
    event: 'focus' 
});

</script>