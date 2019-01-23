<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="icon" href="${pageContext.request.contextPath }/cskjs_css/logo.png" type="image/x-icon"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	var obj=document.getElementById('gems_fs_id'); 
		  $.ajax({
		   type: "post",
		   dataType: "json",
		   cache:true,
		   async:false, 
		   url: "fsname.do",
		   success: function(msg){
		    var data1 =msg 
		    $.each(data1,function(index, n){
		    	var name= data1[index].name;
		    	var namepy=data1[index].namepy;
		    	var id=data1[index].id;
		    obj.options.add(new Option(namepy+"-"+name,id));	
		    })
		   }		   
         });
})

function ss() {
	var gems_fs_id=document.getElementById('gems_fs_id').value;
	var time=document.getElementById('time').value;
	var querytype=document.getElementById('querytype').value;
	var bc_status=document.getElementById('bc_status').value;
	var book_status=document.getElementById('book_status').value;
	var card_status=document.getElementById('card_status').value;
	var icbcname=document.getElementById('icbcname').value;
	window.location.href ="search_icbc.do?"
	    +"icbcname="+icbcname
		+"&card_status="+card_status
		+"&book_status="+book_status
		+"&gems_fs_id="+gems_fs_id
		+"&bc_status="+status
		+"&time="+time
		+"&querytype="+querytype;	
}

</script>
</head>
<body>
<aside class="control-sidebar control-sidebar-dark" style="position: fixed; max-height: 100%; overflow: auto; padding-bottom: 50px;">
		
<div class="tab-content">
				<!-- Home tab content -->
<h3 class="control-sidebar-heading">开始搜索</h3>
<form id="search_form" action="" method="post" enctype="multipart/form-data">
<input name="do" value="list" type="hidden">
<div class="form-group">
	<label>时间:</label>
	<div class="input-group">
	<input class="form-control daterange" id="time" name="time" value="" placeholder="区间" type="text">
	<div class="input-group-addon"><i class="fa fa-calendar"></i></div>
	</div>
</div>
<div class="form-group">
	<label>选择所属店</label> 
	<select class="form-control" id="gems_fs_id" name="gems_fs_id">
	<option value="0">请选择</option>
	</select>
</div>
<div class="form-group">
	<label>选择查询类型</label> 
	<select class="form-control" id="querytype" name="querytype"  name="querytype">
	<option value="0" selected="">请选择</option>
	<option value="1">APP查询</option>
	<option value="2">API查询</option>
	</select>
</div>
<div class="form-group">
	<label>订单状态</label> 
	<select class="form-control" id="bc_status" name="bc_status">
	<option value="0">请选择</option>
	<option value="1">草稿箱</option>
	<option value="2">正在查询</option>
	<option value="3">完成</option>
	<option value="4">回退</option>
	<option value="5">已撤销</option>	
	</select>
</div>
<div class="form-group">
	<label>授权书状态</label> 
	<select class="form-control" id="book_status" name="book_status">
	<option value="0">请选择</option>
	<option value="1">原件不符</option>
	<option value="2">已完结</option>
	<option value="3">已扣款</option>
	</select>
</div>
<div class="form-group">
	<label>身份证复印件状态</label> 
	<select class="form-control" id="card_status" name="card_status">
	<option value="0">请选择</option>
	<option value="1">已完结</option>
	<option value="2">已扣款</option>
	</select>
</div>
<div class="form-group">
	<label>输入关键字:</label> 
	<input name="icbcname" id="icbcname" value="" class="form-control" placeholder="商户名称/操作人名称/客户姓名/身份证号" type="text">
</div>
<a  onclick="ss();" class="btn btn-block btn-primary">搜索</a>
<input name="type" value="assess" type="hidden">
<input name="cn" value="assess_cars" type="hidden">
<input name="bc_tag" value="3" type="hidden">
<input name="nav" value="0" type="hidden">			
</form>
</div>
</aside>
</body>
</html>