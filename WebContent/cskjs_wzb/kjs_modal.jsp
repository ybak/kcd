<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
/*定义图像以及大小*/
.imageFileInput{

    width: 50px;
    height: 50px;
    position: absolute;
    background-image: url("cskjs_css/678444929467167422.png");/*这里可以换成图片路径（background-image：../img/....）注意图片路径*/
    background-repeat:no-repeat; 
    background-size:60% 60%;
    -moz-background-size:60% 60%;
}
/*定义上传*/
.fileInput{
    height: 100%;
    position: absolute;
    right: 0;
    top: 0;
    opacity: 0;
}
</style>
</head>
<body>
	<!--弹窗框体开始-->
	<div class="modal fade" id="modal" role="dialog" data-backdrop="static"  aria-hidden="true">
		<div class="modal-dialog" role="document">
		<div id="mycontent" class="modal-content">
		<div id="float_page_div">
	          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
            <h4 class="modal-title" id="myModalLabel">编辑信息</h4>
          </div>
          <div class="modal-body">
       
          </div>          
            <div class="modal-footer">
            <button type="button" class="btn btn-default pull-left" data-dismiss="modal" aria-label="Close">取消返回</button>
            <button type="submit" class="btn btn-danger" onclick="$('#float_form').submit()">保存提交</button>
          </div>
        </div>

<script>
var float_submit=function (jo){
	eval('var jo='+jo);
	if(jo.succ){
		if(typeof(float_submit_succ)=='function'){
			float_submit_succ(jo);
		}else{
			window.location.reload();
		}
		$.fancybox.close();
	}else if(jo.msg){
		alert(jo.msg);
	}
}
$('#float_form').submit(function (){

	if(typeof(float_form_check)=='function'){
		if(!float_form_check()){
			return false;
		}
	}
	
	$('#float_form').ajaxSubmit(float_submit); 
	return false;
});
my_loaded($('#float_form'));
</script>
<script>
var float_load_succ_close=null;
function float_reload(html){
	$('#fancybox-content>div').html(html);
	$.fancybox.resize();
	float_load_succ();
}
var float_load_succ=function (){
	if(float_load_succ_close){
		float_load_succ_close=null;
		$.fancybox.close();
		return ;
	}
	$('#fancybox-content form.thickbox').ajaxForm(function (html){
		if(html){
			float_reload(html)
		}
	})
}
//setTimeout(float_load_succ,100);
</script></div>
		</div>
	</div>
<!-- 弹窗框体结束-->
	<!--弹窗框体开始-->
	<div class="modal fade" id="modal2" role="dialog" data-backdrop="static"  aria-hidden="true">
		<div class="modal-dialog" role="document">
		<div id="mycontent" class="modal-content">
		<div id="float_page_div">
	          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
            <h4 class="modal-title" id="myModalLabel">编辑信息</h4>
          </div>
          <div class="modal-body">
 <form class="form-horizontal" id="float_form" action="" method="post">
 <div class="box-body">
	  	<div class="modal-header">
		<h4 class="modal-title" id="myModalLabel">用户信息</h4>
	    </div>
	    <div class="form-group">
		<label for="title2" class="col-sm-3 control-label">客户姓名</label>
		<div class="col-sm-9">
			<input class="form-control" name=""  type="text">
		</div>		
	    </div>
	    	      <div class="form-group">
		<label for="title2" class="col-sm-3 control-label">身份证号</label>
		<div class="col-sm-9">
			<input class="form-control" name=""  type="text">
		</div>		
	    </div>
	    	      <div class="form-group">
		<label for="title2" class="col-sm-3 control-label">共借人姓名</label>
		<div class="col-sm-9">
			<input class="form-control" name=""  type="text">
		</div>		
	    </div>
	    	    	      <div class="form-group">
		<label for="title2" class="col-sm-3 control-label">共借人身份证号</label>
		<div class="col-sm-9">
			<input class="form-control" name=""  type="text">
		</div>		
	    </div>
	    <div class="form-group">
		<label for="title2" class="col-sm-3 control-label">借款金额</label>
		<div class="col-sm-9">
		<div class="input-group">
				<input class="form-control" name="" id="" value="" type="text">
				<span class="input-group-addon">万</span>
		</div>
		</div>		
	    </div>
	    
	    	    	    	    	      <div class="form-group">
		<label for="title2" class="col-sm-3 control-label">借款期限</label>
		<div class="col-sm-9">
			<div class="input-group">
				<input class="form-control" name="" id="" value="" type="text">
				<span class="input-group-addon">万</span>
		</div>
		</div>		
	    </div>
	    <div class="form-group">
		<label for="title2" class="col-sm-3 control-label">借款方式</label>
		<div class="col-sm-9">
			<select name="c_mgtype" class="form-control" id="c_mgtype">
              <option selected="selected" value="0">先息后本</option>
               <option value="1">等额本息</option>                            	
            </select>
		</div>		
	    </div>
	    <div class="form-group">
		<label for="title2" class="col-sm-3 control-label">车牌号</label>
		<div class="col-sm-9">
			<input class="form-control" name=""  type="text">
		</div>		
	    </div>
	    <div class="form-group">
		<label for="title2" class="col-sm-3 control-label">车型</label>
		<div class="col-sm-9">
			<input class="form-control" name=""  type="text">
		</div>		
	    </div>
	    <div class="modal-header">
		<h4 class="modal-title" id="">补充信息</h4>
	    </div>
	    	    <div class="form-group">
		<label for="title2" class="col-sm-3 control-label">发动机号</label>
		<div class="col-sm-9">
			<input class="form-control" name=""  type="text">
		</div>		
	    </div>
	    	    <div class="form-group">
		<label for="title2" class="col-sm-3 control-label">VIN码</label>
		<div class="col-sm-9">
			<input class="form-control" name=""  type="text">
		</div>		
	    </div>
	    	    	    <div class="form-group">
		<label for="title2" class="col-sm-3 control-label">渠道利率(格式:0.68/1.0)</label>
		<div class="col-sm-9">
			<input step="0.01" class="form-control" name="" id="" value="" type="number">
		</div>		
	    </div>
	    <div class="modal-header">
		<h4 class="modal-title" id="">材料图片</h4>
	    </div>
	    
	    <div class="form-group" style="margin-top:10px;">
		<label for="title2" class="col-sm-3 control-label">车辆证件</label>
		<div class="col-sm-9">
			<div class="imageFileInput">
       <input class="fileInput" type="file" id="" name="">
       </div>
		</div>		
	    </div>
	    <div class="form-group" style="margin-top:10px;">
		<label for="title2" class="col-sm-3 control-label">合同和其他</label>
		<div class="col-sm-9">
			<div class="imageFileInput">
       <input class="fileInput" type="file" id="" name="">
       </div>
		</div>		
	    </div>
	    	    <div class="form-group" style="margin-top:10px;">
		<label for="title2" class="col-sm-3 control-label">车辆照片</label>
		<div class="col-sm-9">
			<div class="imageFileInput">
       <input class="fileInput" type="file" id="" name="">
       </div>
		</div>		
	    </div>
	    	    	    <div class="form-group" style="margin-top:10px;">
		<label for="title2" class="col-sm-3 control-label">放款转账记录截图留档</label>
		<div class="col-sm-9">
			<div class="imageFileInput">
       <input class="fileInput" type="file" id="" name="">
       </div>
		</div>		
	    </div>
 </div>
          </form>
          </div>          
            <div class="modal-footer">
            <button type="button" class="btn btn-default pull-left" data-dismiss="modal" aria-label="Close">取消返回</button>
            <button type="submit" class="btn btn-danger" onclick="$('#float_form').submit()">保存提交</button>
          </div>
        </div>


</body>
</html>