<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<link href="${pageContext.request.contextPath}/wangye0119/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/wangye0119/css/style.css" />
		<link href="${pageContext.request.contextPath}/wangye0119/assets/css/codemirror.css" rel="stylesheet">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/wangye0119/assets/css/ace.min.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/wangye0119/font/css/font-awesome.min.css" />
		<!--[if lte IE 8]>
	    <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->
			<script src="${pageContext.request.contextPath}/wangye0119/js/jquery-1.9.1.min.js"></script>
			<script src="${pageContext.request.contextPath}/wangye0119/assets/js/bootstrap.min.js"></script>
			<script type="text/javascript"
				src="${pageContext.request.contextPath}/wangye0119/Widget/Validform/5.3.2/Validform.min.js"></script>
			<script src="${pageContext.request.contextPath}/wangye0119/assets/js/typeahead-bs2.min.js"></script>
			<script src="${pageContext.request.contextPath}/wangye0119/assets/js/jquery.dataTables.min.js"></script>
			<script src="${pageContext.request.contextPath}/wangye0119/assets/js/jquery.dataTables.bootstrap.js"></script>
			<script src="${pageContext.request.contextPath}/wangye0119/assets/layer/layer.js" type="text/javascript"></script>
			<script src="${pageContext.request.contextPath}/wangye0119/js/lrtk.js" type="text/javascript"></script>
			<script src="${pageContext.request.contextPath}/wangye0119/assets/layer/layer.js" type="text/javascript"></script>
			<script src="${pageContext.request.contextPath}/wangye0119/assets/laydate/laydate.js" type="text/javascript"></script>
			<title>管理员</title>
</head>

<body>
	<div class="page-content clearfix">
		<div class="administrator">
			<div class="d_Confirm_Order_style">
				<div class="search_style">
					<ul class="search_content clearfix">
						<li>
							<label class="l_f">管理员名称</label>
							<input id="uuname" name="uuname" type="text" class="text_add" placeholder="输入管理员名字" style="width: 400px" />
						</li>
					    <li>
					    	<!-- <label class="l_f">添加时间</label> -->
					    	<input type="hidden" class="inline laydate-icon" id="start" style="margin-left: 10px;">
					    </li>
						<li style="width: 80px;">
							<button onclick="selectUserLike()" type="button" class="btn_search">
							<i class="fa fa-search"></i>查</button>
						</li>
					</ul>
				</div>
				<!--操作-->
				<div class="border clearfix">
					<span class="l_f"> 
						<!-- 
							class => btn btn-warning（橙黄色）
							class => btn btn-danger (深砖红色)
						 -->
						<a href="javascript:ovid()" id="administrator_add" class="btn btn-danger"><i class="fa fa-plus"></i> 添加管理员</a> 
						<!-- <a href="javascript:ovid()" class="btn btn-warning"><i class="fa fa-trash"></i>批量删除</a> -->
					</span> 
					<!-- <span class="r_f">共：<b>5</b>人</span> -->
				</div>
				<!--管理员列表-->
				<div class="clearfix administrator_style" id="administrator">
					<div class="left_style">
						<div id="scrollsidebar" class="left_Treeview">
							<div class="show_btn" id="rightArrow">
								<span></span>
							</div>
							<div class="widget-box side_content">
								<div class="side_title">
									<a title="隐藏" class="close_btn"><span></span></a>
								</div>
								<div class="side_list">
									<div class="widget-header header-color-green2">
										<h4 class="lighter smaller">管理员分类列表</h4>
									</div>
									<div class="widget-body">
										<ul class="b_P_Sort_list">
											<li><i class="fa fa-users green"></i> <a href="selectAllUser.do">全部管理员（${requestScope.userSum}）</a></li>
											<li><i class="fa fa-users orange"></i> <a href="selectOtherUser.do?deptno=10">主管（${requestScope.userSupervisorCounts}）</a></li>
											<li><i class="fa fa-users orange"></i> <a href="selectOtherUser.do?deptno=20">业务经理（${requestScope.userManagerCounts}）</a></li>
											<li><i class="fa fa-users orange"></i> <a href="selectOtherUser.do?deptno=30">业务员（${requestScope.userSalesmanCounts}）</a></li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="table_menu_list" id="testIframe">
						<table class="table table-striped table-bordered table-hover"
							id="sample_table">
							<thead>
								<tr> 
									<th width="25px"><label><input type="checkbox" class="ace"><span class="lbl"></span></label></th>
									<!--aria-sort="ascending" aria-label="序号:升序排列" descending ascending-->
									<th width="80px">编号</th>
									<th width="80px">序号</th>
									<th width="80px">真实姓名</th>
									<th width="170px">登录名</th>
									<th width="100px">手机</th>
									<th width="100px">角色</th>
									<th width="180px">加入时间</th>
									<th width="70px">状态</th>
									<th width="150px">操作</th>
								</tr>
							</thead>
							<tbody>
							<c:forEach items="${requestScope.list}"  var="user">
								<tr>
									<td><label><input type="checkbox" class="ace"><span class="lbl"></span></label></td>
									<td>${user.deptno}</td>
									<td id="uid">${user.uid}</td>
									<td>${user.uname}</td>
									<td>${user.username}</td>
									<td>${user.userPhone}</td>
									<td>
										<select id="deptno" onchange="updateDeptno(${user.uid},this.options[this.options.selectedIndex].value)">
											<option  value="10" ${user.deptno==10?"selected='selected'":''}>主管</option>
											<option  value="20" ${user.deptno==20?"selected='selected'":''}>业务经理</option>
											<option  value="30" ${user.deptno==30?"selected='selected'":''}>业务员</option>
										</select>
									</td>
									<td>${user.regTime}</td>
									<c:choose>
										<c:when test="${user.status==1}">
											<td class="td-status">
												<span class="label label-success radius">已启用</span>
											</td>
										</c:when>
										<c:when test="${user.status==0}">
											<td class="td-status">
												<span class="label label-defaunt radius">已停用</span>
											</td>
										</c:when>
									</c:choose>
									<!-- <td class="td-status">
										<span class="label label-success radius">已启用</span>
									</td> -->
									
									<td class="td-manage">
										<c:choose>
											<c:when test="${user.status==1}">
												<a onClick="member_stop(this,${user.uid})" onmousedown="asd()" href="javascript:;"
													title="停用" class="btn btn-xs btn-success"><i class="fa fa-check  bigger-120"></i>
												</a> 
											</c:when>
											<c:when test="${user.status==0}">
												<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this,${user.uid})" href="javascript:;" 
													title="启用"><i class="fa fa-close bigger-120"></i>
												</a>
											</c:when>
										</c:choose>
										<!--  member_edit(${user.uname},${user.username},${user.userPhone})
											  member_editor(${user.uname},${user.username},${user.userPhone})
											  member_edit('编辑','member-add.html','4','','510')"
										-->
										<!-- <a title="编辑" onclick="member_edit('编辑','member-add.html','4','','510')"
											href="javascript:;" class="btn btn-xs btn-info"><i class="fa fa-edit bigger-120"></i>
										</a>  -->
										<a title="删除" href="javascript:;" onclick="member_del(this,${user.uid})" class="btn btn-xs btn-warning">
											<i class="fa fa-trash  bigger-120"></i>
										</a>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<!--添加管理员-->
		<div id="add_administrator_style" class="add_menber" style="display:none;">
			<form action="${pageContext.request.contextPath}/addBMSUser.do" enctype="multipart/form-data" method="post" id="form-admin-add">
				<div class="form-group">
					<label class="form-label"><span class="c-red">*</span>管理员账号：</label>
					<div class="formControls">
						<input onblur="addUser()" type="text" class="input-text" value="" placeholder="登陆账号"
							id="user-name" name="userName" datatype="*2-16" nullmsg="用户名不能为空">
							<span style="color:red;" id="ss"></span>
					</div>
					<div class="col-4">
						<span class="Validform_checktip"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="form-label"><span class="c-red">*</span>初始密码：</label>
					<div class="formControls">
						<input type="password" placeholder="登陆密码" name="userpassword"
							autocomplete="off" value="" class="input-text" datatype="*6-20"
							nullmsg="密码不能为空">
					</div>
					<div class="col-4">
						<span class="Validform_checktip"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="form-label "><span class="c-red">*</span>确认密码：</label>
					<div class="formControls ">
						<input type="password" placeholder="确认登陆密码" autocomplete="off"
							class="input-text Validform_error" errormsg="您两次输入的新密码不一致！"
							datatype="*" nullmsg="请再输入一次新密码！" recheck="userpassword"
							id="newpassword2" name="newpassword2">
					</div>
					<div class="col-4">
						<span class="Validform_checktip"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="form-label"><span class="c-red">*</span>真实姓名：</label>
					<div class="formControls">
						<input type="text" class="input-text" value="" placeholder=""
							id="user-name" name="trueName" datatype="*2-16"
							nullmsg="真实姓名不能为空">
					</div>
					<div class="col-4">
						<span class="Validform_checktip"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="form-label "><span class="c-red">*</span>手机：</label>
					<div class="formControls ">
						<input type="text" class="input-text" value="" placeholder=""
							id="user-tel" name="userTel" datatype="m" nullmsg="手机不能为空">
					</div>
					<div class="col-4">
						<span class="Validform_checktip"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="form-label">角色：</label>
					<div class="formControls ">
						<span class="select-box" style="width: 100px;"> 
						<select class="select" name="adminRole" size="1">
							<option value="10">主管</option>
							<option value="20">业务经理</option>
							<option value="30">业务员</option>
						</select>
						</span>
					</div>
				</div>
				<div>
					<input class="btn btn-primary radius" type="submit" id="Add_Administrator" 
					value="&nbsp;&nbsp;提交&nbsp;&nbsp;" onclick="location.reload()">
					<input class="btn btn-primary radius" type="reset" id="Add_Administrator" 
					value="&nbsp;&nbsp;清空&nbsp;&nbsp;">
			</form>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">

//修改
function updateDeptno(uuid,deptno){
	layer.confirm('确定要修改用户权限吗?',{
		  btn: ['确定', '取消'] //可以无限个按钮
		}, function(index,layero){
		  	//按钮【确定】的回调
			location.href="updateUserDeptno.do?deptno="+deptno+"&uid="+uuid;
		}, function(index){
		  //按钮【取消】的回调
	});
}

/* function updateDeptno(uuid){
    layer.open({
	  content: '确定要修改用户吗?请点击',
	  btn: ['业务员', '业务经理','主管'],
	  yes:function(index, layero){
	    //按钮【按钮一】的回调
		  location.href="updateUserDeptno.do?deptno=30"+"&uid="+uuid;
	  },cancel: function(index, layero){
	    //按钮【按钮二】的回调
		  location.href="updateUserDeptno.do?deptno=20"+"&uid="+uuid;
	  },btn3: function(index, layero){
	    //按钮【按钮三】的回调
		  location.href="updateUserDeptno.do?deptno=10"+"&uid="+uuid;
	  }
	  ,cancel: function(){ 
	    //右上角关闭回调
		  window.location.reload();
	  }
	}); 
} */




//模糊查询
function selectUserLike(){
	var uuname = $("#uuname").val();
	//alert(uuname);
	location.href="selectUserLike.do?uname="+uuname;
}

jQuery(function($) {
		var oTable1 = $('#sample_table').dataTable( {
		"aaSorting": [[ 1,2,7, "desc" ]],//默认第几个排序
		"bStateSave": false,//状态保存
		"aoColumnDefs": [
		  //{"bVisible": false, "aTargets": [ 3 ]} //控制列的隐藏显示
		  {"orderable":false,"aTargets":[0,3,4,5,6,8,]}// 制定列不参与排序
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
			});

</script>
<script type="text/javascript">
$(function() { 
	$("#administrator").fix({
		float : 'left',
		//minStatue : true,
		skin : 'green',	
		durationTime :false,
		spacingw:50,//设置隐藏时的距离
	    spacingh:270,//设置显示时间距
	});
});
//字数限制
function checkLength(which) {
	var maxChars = 100; //
	if(which.value.length > maxChars){
	   layer.open({
	   icon:2,
	   title:'提示框',
	   content:'您输入的字数超过限制!',	
    });
		// 超过限制的字数了就将 文本框中的内容按规定的字数 截取
		which.value = which.value.substring(0,maxChars);
		return false;
	}else{
		var curr = maxChars - which.value.length; //250 减去 当前输入的
		document.getElementById("sy").innerHTML = curr.toString();
		return true;
	}
};
//初始化宽度、高度  
 $(".widget-box").height($(window).height()-215); 
$(".table_menu_list").width($(window).width()-260);
 $(".table_menu_list").height($(window).height()-215);
  //当文档窗口发生改变时 触发  
    $(window).resize(function(){
	$(".widget-box").height($(window).height()-215);
	 $(".table_menu_list").width($(window).width()-260);
	  $(".table_menu_list").height($(window).height()-215);
	})
 laydate({
    elem: '#start',
    event: 'focus' 
});

/*用户-停用*/
function member_stop(obj,uuid){
	layer.confirm('确认要停用吗？',function(index){
		/* $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this,id)" href="javascript:;" title="启用"><i class="fa fa-close bigger-120"></i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">已停用</span>');
		$(obj).remove();  */
		layer.msg('已停用!',{icon: 5,time:1000});
		location.href="updateUserStatus.do?status=1&uid="+uuid;
	});
}
/*用户-启用 */ 
function member_start(obj,uuid){
	layer.confirm('确认要启用吗？',function(index){
		/* $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this,id)" href="javascript:;" title="停用"><i class="fa fa-check  bigger-120"></i></a>');
		$(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">已启用</span>');
		$(obj).remove(); */
		layer.msg('已启用!',{icon: 6,time:1000}); 
		location.href="updateUserStatus.do?status=0&uid="+uuid;
	});
}

/*产品-编辑*/
function member_edit(title,url,id,w,h){
	layer_show(title,url,w,h);
}

/*产品-删除*/
function member_del(obj,uuid){
	layer.confirm('确认要删除吗？',function(index){
		$(obj).parents("tr").remove();
		layer.msg('已删除!',{icon:1,time:1000});
		location.href="deleteUserByUid.do?uid="+uuid;
	});
}

/*添加管理员*/
$('#administrator_add').on('click', function(){
	layer.open({
	    type: 1,
		title:'添加管理员',
		area: ['700px',''],
		shadeClose: false,
		content: $('#add_administrator_style'),   // 打开该  div
		cancel: function(){  //右上角关闭回调
				location.reload(); // 刷新页面
			}
	});
})

/*添加管理员时验证是否重复 */
function addUser(){
	var username = $("#user-name").val();
	$.ajax({
		url: "addUserBySelectRepeat.do",
        type: "post",
        dataType: "text",
        data:{
        	username:username
        },
        success: function(data){
        	if(data == 1){ // 账号已注册
	        	$("#ss").html("该账号已注册!");
	        	$("#user-name").val("");  
        	}else{  // 账号没有注册
        		$("#ss").html("");
        	}
        }
	});
}

/*表单验证提交*/
$("#form-admin-add").Validform({
		 tiptype:2,
		callback:function(data){
		//form[0].submit();
		if(data.status==1){ 
                layer.msg(data.info, {icon: data.status,time: 1000}, function(){ 
                    location.reload();//刷新页面 
                    });   
            } 
            else{ 
                layer.msg(data.info, {icon: data.status,time: 3000}); 
            } 		  
			var index =parent.$("#iframe").attr("src");
			parent.layer.close(index);
		}
});	
	

</script>

