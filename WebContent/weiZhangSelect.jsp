<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!-- saved from url=(0038)http://apitest.kcway.net/wzsh.do?id=22 -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8"><style>.m-input-select{color:black;width:100%;display:inline-block;*display:inline;position:relative;-webkit-user-select:none;}.m-input-select ul, .m-input-select li{padding:0;margin:0;color:black;}n.m-input-select .m-input{padding-right:22px;color:black;}.m-input-select .m-input-ico{position:absolute;right:0;top:0;width:22px;height:100%;background:url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAwAAAAMCAYAAABWdVznAAAATElEQVQoU2NkIBEwkqiegTwNcXFx/4m1CW4DMZoWLVrEiOIkfJpAikGuwPADNk0wxVg1gASRNSErxqkBpgldMV4NuEKNvHggNg5A6gBo4xYmyyXcLAAAAABJRU5ErkJggg==) no-repeat 50% 50%;}.m-input-select .m-list-wrapper{}.m-input-select .m-list{display:none;position:absolute;z-index:9;top:100%;left:0;right:0;max-width:100%;max-height:500px;overflow:auto;border-bottom:1px solid #ddd;}.m-input-select .m-list-item{cursor:default;padding:5px;margin-top:-1px;list-style:none;background:#fff;color:black;border:1px solid #ddd;border-bottom:none;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;}.m-input-select .m-list-item:hover{background:#2D95FF;}.m-input-select .m-list-item-active{background:#2D95FF;}</style>
<style>.m-input-select{color:black;width:100%;display:inline-block;*display:inline;position:relative;-webkit-user-select:none;}.m-input-select ul, .m-input-select li{padding:0;margin:0;color:black;}n.m-input-select .m-input{padding-right:22px;color:black;}.m-input-select .m-input-ico{position:absolute;right:0;top:0;width:22px;height:100%;background:url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAwAAAAMCAYAAABWdVznAAAATElEQVQoU2NkIBEwkqiegTwNcXFx/4m1CW4DMZoWLVrEiOIkfJpAikGuwPADNk0wxVg1gASRNSErxqkBpgldMV4NuEKNvHggNg5A6gBo4xYmyyXcLAAAAABJRU5ErkJggg==) no-repeat 50% 50%;}.m-input-select .m-list-wrapper{}.m-input-select .m-list{display:none;position:absolute;z-index:9;top:100%;left:0;right:0;max-width:100%;max-height:500px;overflow:auto;border-bottom:1px solid #ddd;}.m-input-select .m-list-item{cursor:default;padding:5px;margin-top:-1px;list-style:none;background:#fff;color:black;border:1px solid #ddd;border-bottom:none;white-space:nowrap;overflow:hidden;text-overflow:ellipsis;}.m-input-select .m-list-item:hover{background:#2D95FF;}.m-input-select .m-list-item-active{background:#2D95FF;}</style>
	<title>快加后台管理</title>
	<!-- Tell the browser to be responsive to screen width -->
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">	
	 <script type="text/javascript">
		var _rooturl = "http://a.kcway.net/assess/";
		var page_cn = "assess_queryzx";
	</script>
	
	<!-- Bootstrap 3.3.4 -->
	<link href="./acss/bootstrap.min.css" rel="stylesheet" type="text/css">
	<!-- Font Awesome Icons -->
	<!-- Font Awesome Icons -->
	<link href="./acss/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	<link href="./acss/select2.min.css" rel="stylesheet" type="text/css">
	
	
	<!-- Theme style -->
	<link href="./acss/AdminLTE.css" rel="stylesheet" type="text/css">
	<!-- AdminLTE Skins. We have chosen the skin-blue for this starter
			page. However, you can choose any other skin. Make sure you
			apply the skin class to the body tag so the changes take effect.
	-->
	<link href="./acss/skin-green.css" rel="stylesheet" type="text/css">
	<link href="./acss/style.css" rel="stylesheet" type="text/css">

	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
		<script src="https://cdn.bootcss.com/html5shiv/r29/html5.min.js"></script>
		<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
	
	<style type="text/css">
 
.footer-wrap{ position: fixed;width: 100%; bottom: 0;z-index: 1000;}
.footer-wrap.box-footer{margin-right: 200px; border-top-color: #d2d6de;}
@media (max-width: 767px) {
.footer-wrap.box-footer {
      margin-right: 0;
  }
}
 
    </style>
	<!-- jQuery 2.1.4 -->
	<script src="./acss/jQuery-2.1.4.min.js" type="text/javascript"></script>
	<script src="./acss/common.js" type="text/javascript"></script>
	<script src="./acss/jquery.form.js" type="text/javascript"></script>
	<script src="./acss/ajaxfileupload.js" type="text/javascript"></script>
	<script type="text/javascript" src="./acss/php.js"></script>

<!-- Bootstrap 3.3.2 JS -->
	<script src="./acss/bootstrap.min.js" type="text/javascript"></script>
	
	<script src="./acss/moment.js" type="text/javascript"></script>
	<script src="./acss/daterangepicker.js" type="text/javascript"></script>
	<link href="./acss/daterangepicker-bs3.css" rel="stylesheet" type="text/css">
	
	<script src="./acss/bootstrap-datepicker.js" type="text/javascript"></script>
	<link href="./acss/datepicker3.css" rel="stylesheet" type="text/css">
	<script src="./acss/bootstrap-datepicker.zh-CN.js" type="text/javascript"></script>
	
	<script src="./acss/bootstrap-datetimepicker.js" type="text/javascript"></script>
	<link href="./acss/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css">
	<script src="./acss/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
	
	
	<script type="text/javascript" charset="utf-8" src="./acss/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="./acss/ueditor.all.min.js"> </script>
	<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
	<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
	<script type="text/javascript" charset="utf-8" src="./acss/zh-cn.js"></script>
	
	
	
	<script src="./acss/select2.min.js" type="text/javascript"></script>
	<script src="./acss/zh-cn(1).js" type="text/javascript"></script>
	
	<!-- AdminLTE App -->
	<script src="./acss/app.min.js" type="text/javascript"></script>
	<script src="./acss/combo.js" type="text/javascript"></script>
	<script src="./acss/imgup.js" type="text/javascript"></script>
	<link href="./acss/imgup.css" rel="stylesheet" type="text/css">
	
	<!-- <script src="/comm/jquery.dragsort-0.4.min.js" type="text/javascript"></script> -->	
	<link href="./acss/iconfont.css" rel="stylesheet" type="text/css">
 	<script src="./jquery.min(2).js"></script>
  	<script src="./jquery.Jcrop.js"></script>
  	<link rel="stylesheet" href="./jquery.Jcrop.css" type="text/css">
    <script type="text/javascript">  
        var current = 0;  
        function turnLeft(){  
            current = (current-90)%360;  
            document.getElementById('result_imgurl1_view').style.transform = 'rotate('+current+'deg)';  
        }  
      
        function zyxz(imgname,timenum,fr,fid) {
        	//var imgname=document.getElementById("imgname").value;
        	//var timenum=document.getElementById("timenum").value;
        	//var fr=document.getElementById("fr").value;
        	//alert(imgname);
      	  $.ajax({
      		   type: "post",   
      		   dataType: "text",
      		   url: "imgsz.do",
      		   data:{
      			imgname : imgname	,
      			timenum : timenum,
      			fr : fr
      		   },
      	 success: function(msg){
      	
      		 if(msg=="s"){
      			 //alert(msg);
      			document.getElementById("result_imgurl"+fid+"_view").src="./image/upload/img/"+timenum+"/"+imgname+"?"+Math.random();      	      	 	 
      		 }
      		}
      	  })
        }
    </script>  
<script type="text/javascript">
//document.getElementById("text").value ="222222222";
$(document).ready(function(){	


	 //test();
});	
function test() {
	var id=document.getElementById("uid").value;
	  $.ajax({
		   type: "post",
		   dataType: "json",
		   url: "historylist.do",
		   data:{
			     uid : id			   
		   },
		   success: function(msg){
			    var result=msg;
			    var str="";
			    $.each(result,function(index, n){
			    	   var zt=result[index].zt;
					   var ly=result[index].ly;
					   var htime=result[index].htime;
					   var time=htime.replace(".0"," ");
					   //alert(time);
			   // str="状态:"+zt+" "+"留言:"+ly+" "+"时间:"+time+"\n"+str;
			    var ztmsg;
			    if(zt==1){ 
			    	ztmsg="草稿箱";
			    }
			    if(zt==2){
			    	ztmsg="申请模板";
			    }
			    if(zt==3){
			    	ztmsg="等待上传";
			    }
			    if(zt==4){
			    	ztmsg="正在查询";
			    }
			    if(zt==5){
			    	ztmsg="查询完成";
			    }
			    if(zt==6){
			    	ztmsg="回退";
			    }
			    if(zt==7){
			    	ztmsg="已撤销";
			    }
			    str=time+";状态:"+ztmsg+",留言:"+ly+"\n"+str;
			    
			    }); 
		 document.getElementById("text").value =str;  
		   }
}) 	  
	  
}
</script> 
	
	</head>
	<body class="skin-green sidebar-mini fixed" style="zoom: 1;"><div id="" class="izViewer" style="display: none; padding: 0px; overflow: hidden; margin: 0px; position: absolute; width: 0px; height: 0px; visibility: visible;"></div>	
<script>
$('li.active').parents('li').addClass('treeview').addClass('active');
</script>
<form id="info_form" action="http://apitest.kcway.net/wzsh.do?id=22" class="form-horizontal" method="post" enctype="multipart/form-data" onsubmit="return check()">		
		<!-- Content Wrapper. Contains page content -->	
		<!-- Main content -->
<section class="content">
			
<script src="./jQueryRotate.js" type="text/javascript"></script>
<div class="admin-content nav-tabs-custom box">
	<div class="box-header with-border">
	API违章查询审核  API违章查询详情来自：${requestScope.fsname }-${requestScope.gemsname}
		<input name="adminop_tag" value="0" type="hidden">
		<div class="box-body">
			<div class="form-group"><label class="col-sm-2 control-label">被查询车信息</label>
				<div class="col-sm-10">
					<div class="row inline-from">
						<div class="col-sm-4">
							<div class="input-group">
							<span class="input-group-addon">车管局名称</span> 
							<input class="form-control" name="authority" id="authority" value="jiangsu" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group">
							<span class="input-group-addon">车牌前缀</span> 
							<input class="form-control" name="carprefix" id="carprefix" value="苏" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group">
							<span class="input-group-addon">车牌后缀</span> 
							<input class="form-control" name="carrest" id="carrest" value="D15K55" type="text"></div>
					</div>
					<div class="col-sm-4">
							<div class="input-group">
							<span class="input-group-addon">车牌类型</span>
							<input class="form-control" name="cartype" id="cartype" value="小型汽车号牌" type="text"></div>
					</div>
					<div class="col-sm-4">
							<div class="input-group">
							<span class="input-group-addon">车架号</span>
							<input class="form-control" name="vinno" id="vinno" value="" type="text"></div>
					</div>
					<div class="col-sm-4">
							<div class="input-group">
							<span class="input-group-addon">发动机号</span>
							<input class="form-control" name="engineno" id="engineno" value="22413Y" type="text"></div>
					</div>
					<div class="col-sm-4">
							<div class="input-group">
							<span class="input-group-addon">手机号</span>
							<input class="form-control" name="mobile" id="mobile" value="" type="text"></div>
					</div>
					<div class="col-sm-4">
							<div class="input-group">
							<span class="input-group-addon">是否返回城市</span>
							<input class="form-control" name="iscity" id="iscity" value="否" type="text">
							</div>
					</div>
				</div>
			</div></div>
	</div>
		<div class="box-header with-border">
			<h3 class="box-title">相关审核结果</h3>
			<div class="form-group">
			<label class="col-sm-2 control-label">报告详情</label>
			
			
			<div class="col-sm-10">
			<div class="row inline-from">
						<div class="col-sm-4">
							<div class="input-group">
							<span class="input-group-addon">车管局名称</span> 
							<input class="form-control" name="authority" id="authority" value="jiangsu" type="text"></div>
					    </div>
					    <div class="col-sm-4">
							<div class="input-group">
							<span class="input-group-addon">车牌ID</span> 
							<input class="form-control" name="authority" id="authority" value="42568629" type="text"></div>
					    </div>
					    <div class="col-sm-4">
							<div class="input-group">
							<span class="input-group-addon">违章条数</span> 
							<input class="form-control" name="authority" id="authority" value="2" type="text"></div>
					    </div>
					    <div class="col-sm-4">
							<div class="input-group">
							<span class="input-group-addon">违章总金额</span> 
							<input class="form-control" name="authority" id="authority" value="250" type="text"></div>
					    </div>
					     <div class="col-sm-4">
							<div class="input-group">
							<span class="input-group-addon">违章总扣分</span> 
							<input class="form-control" name="authority" id="authority" value="9" type="text"></div>
					    </div>
					    
					    
					     
					    <div class="col-sm-10">
					    <div class="input-group">
					    <label class="control-label">第1条</label>	
					    </div>        
					        <div class="input-group">
							<span class="input-group-addon">违章代码</span>
							<input class="form-control" name="" id="" value="13523" type="text">
							 
							</div>
					        <div class="input-group">
							<span class="input-group-addon">违章ID</span>
							<input class="form-control" name="" id="" value="17208632" type="text"> 
							</div>
							<div class="input-group">
							<span class="input-group-addon">时间</span>
							<input class="form-control" name="" id="" value="2017-12-09 14:58:00" type="text">
							 
							</div>
							<div class="input-group">
							<span class="input-group-addon">地点</span>
							<input class="form-control" name="" id="" value="常合高速 " type="text">
							
							</div>
							<div class="input-group">
							<span class="input-group-addon">违章内容</span>
							<input class="form-control" name="" id="" value="驾驶中型以上载客载货汽车、危险物品运输车辆以外的其他机动车行驶超过规定时速10%未达20%的" type="text"> 
							</div>
							<div class="input-group">
							<span class="input-group-addon">罚款金额</span> 
							<input class="form-control" name="" id="" value="50" type="text"> 
							</div>
					        <div class="input-group">
							<span class="input-group-addon">扣分</span> 
							<input class="form-control" name="" id="" value="3" type="text"> 
							</div>
					        <div class="input-group">
							<span class="input-group-addon">采集机关</span>
							<input class="form-control" name="" id="" value="" type="text"> 
							 
							</div>
							<div class="input-group">
							<span class="input-group-addon">违章编号</span>
							 <input class="form-control" name="" id="" value="" type="text"> 
							</div>	
							<div class="input-group">
							<span class="input-group-addon">省</span>
							<input class="form-control" name="" id="" value="安徽" type="text"> 
							<span class="input-group-addon">市</span>
							<input class="form-control" name="" id="" value="马鞍山" type="text"> 
							<span class="input-group-addon">县</span>
							<input class="form-control" name="" id="" value="含山县" type="text"> 
							</div>	
							<div class="input-group">
							<span class="input-group-addon">纬度 </span>
							<input class="form-control" name="" id="" value="0.0000000000" type="text"> 
							<span class="input-group-addon">经度 </span>
							<input class="form-control" name="" id="" value="0.0000000000" type="text"> 
							</div>
                            <div class="input-group">
							<span class="input-group-addon">是否可以代办  </span>
							<input class="form-control" name="" id="" value="否" type="text"> 
							<span class="input-group-addon">代办费用 </span>
							<input class="form-control" name="" id="" value="" type="text"> 
							</div>							
			            </div>
			            
			            
					     
					    <div class="col-sm-10">
					    <div class="input-group">
					    <label class="control-label">第2条</label>	
					    </div>        
					        <div class="input-group">
							<span class="input-group-addon">违章代码</span>
							<input class="form-control" name="" id="" value="1636" type="text">
							 
							</div>
					        <div class="input-group">
							<span class="input-group-addon">违章ID</span>
							<input class="form-control" name="" id="" value="17208633" type="text"> 
							</div>
							<div class="input-group">
							<span class="input-group-addon">时间</span>
							<input class="form-control" name="" id="" value="2018-02-02 17:28:00" type="text">
							 
							</div>
							<div class="input-group">
							<span class="input-group-addon">地点</span>
							<input class="form-control" name="" id="" value="226省道17公里520米至226省道13公里150米 " type="text">
							
							</div>
							<div class="input-group">
							<span class="input-group-addon">违章内容</span>
							<input class="form-control" name="" id="" value="驾驶中型以上载客载货汽车、校车、危险物品运输车辆以外的其他机动车行驶超过规定时速20%以上未达到50%的" type="text"> 
							</div>
							<div class="input-group">
							<span class="input-group-addon">罚款金额</span> 
							<input class="form-control" name="" id="" value="200" type="text"> 
							</div>
					        <div class="input-group">
							<span class="input-group-addon">扣分</span> 
							<input class="form-control" name="" id="" value="6" type="text"> 
							</div>
					        <div class="input-group">
							<span class="input-group-addon">采集机关</span>
							<input class="form-control" name="" id="" value="" type="text"> 
							 
							</div>
							<div class="input-group">
							<span class="input-group-addon">违章编号</span>
							 <input class="form-control" name="" id="" value="" type="text"> 
							</div>	
							<div class="input-group">
							<span class="input-group-addon">省</span>
							<input class="form-control" name="" id="" value="安徽" type="text"> 
							<span class="input-group-addon">市</span>
							<input class="form-control" name="" id="" value="马鞍山" type="text"> 
							<span class="input-group-addon">县</span>
							<input class="form-control" name="" id="" value="含山县" type="text"> 
							</div>	
							<div class="input-group">
							<span class="input-group-addon">纬度 </span>
							<input class="form-control" name="" id="" value="31.8081893776" type="text"> 
							<span class="input-group-addon">经度 </span>
							<input class="form-control" name="" id="" value="118.0108874693" type="text"> 
							</div>
                            <div class="input-group">
							<span class="input-group-addon">是否可以代办  </span>
							<input class="form-control" name="" id="" value="否" type="text"> 
							<span class="input-group-addon">代办费用 </span>
							<input class="form-control" name="" id="" value="" type="text"> 
							</div>							
			            </div>
			            
			            
			</div>
			</div>	
			
			
			

					            
			</div>
	        </div>
				<div class="box-header with-border">
			<h3 class="box-title">相关审核</h3>
	</div>
		<div class="box-body">
			<div class="form-group"><label class="col-sm-2 control-label">审核：</label>
				<div class="col-sm-10">
					<div class="row inline-from">
						<div class="col-sm-6">
							<div class="input-group">
							<span class="input-group-addon">审核状态</span>
							 <select name="bc_status" class="form-control" id="bc_status" onchange="autoremark();">
                            	<option value="1">失败</option>
                            	<option value="2" selected="selected">成功</option>                           
                            	</select>
                            	</div>
					</div>
						<div class="col-sm-6">
							<div class="input-group">
							<span class="input-group-addon">查询类型</span>
 <input class="form-control" readonly="readonly" value="API违章查询" type="text"></div>
					</div>
				</div>
			</div></div>
			<div class="form-group"><label class="col-sm-2 control-label">留言备注说明：</label>
				<div class="col-sm-10">
					<div class="row inline-from">
						<div class="col-sm-8">
							<div class="input-group"><span class="input-group-addon">审核留言</span> <input class="form-control" name="remark" id="remark" type="text"></div>
					</div>
						<div class="col-sm-4">
							<div class="input-group"><span class="input-group-addon">留言快速通道</span>
							 <select class="form-control" id="cyly" onchange="setremark(this)">
							 <option value="请选择" selected="selected">请选择</option>	
							 <option value="查询完成，详情请点击历史查询-&gt;已完成-&gt;查看订单！">查询完成，详情请点击历史查询-&gt;已完成-&gt;查看订单！</option>						
							 <option value="查询完成!">查询完成!</option>						
							 <option value="该车市场受欢迎的较好，新车优惠力度较多。">该车市场受欢迎的较好，新车优惠力度较多。</option>						
							 <option value="系统无法对货车进行评估查询">系统无法对货车进行评估查询</option>						
							 <option value="请上传行驶证和驾驶证等相关资料照片。谢谢">请上传行驶证和驾驶证等相关资料照片。谢谢</option>						
							 <option value="该车年限较久整体保值度不高。">该车年限较久整体保值度不高。</option>						
							 <option value="该车有事故记录情况，大梁与横梁有矫正，门有更换。属于事故车型">该车有事故记录情况，大梁与横梁有矫正，门有更换。属于事故车型</option>						
							 <option value="改订单今日已经重复提交">改订单今日已经重复提交</option>						
							 <option value="无行驶证，驾驶证重复上传">无行驶证，驾驶证重复上传</option>						
							 </select>
							 </div>
					</div>
				</div>
			</div></div>
			<div class="form-group">
			<label class="col-sm-2 control-label">历次审核事件和留言：</label>
				<div class="col-sm-10">
				<textarea style="width: 100%; height: 200px" class="form-control" readonly="readonly">：类型：API违章查询：留言：查询成功                 
                </textarea>
</div></div>		
</div>
</div>
</div>
		</section>
<script>
$(function(){
	$("#info_form").attr("onsubmit","return check()"); 
});
function getprice(obj){
	if ($("#carid").val()!=null){
		url= "ajax.php?do=info&cn=car_model&id="+$("#carid").val();
		jQuery.getJSON(url,function (opt){
			if(opt){
				$("#price_new").val(opt.price);
			}
		})
	}
}
function setremark(obj){
	if ($("#cyly").val()!="请选择快速留言"){
		$("#remark").val($("#cyly").val());
	}
}
function check(){
	$("#upload_result_pdf").attr('filename','');
	$("#upload_result_pdf").val('');
	if ($("#bc_status").val()>4 && $("#bc_status").val()!=7){
		if ($("#remark").val()==""){
			alert("留言为空！");
//			window.console.error('remark null');
			$("#remark").focus();
			return false;
		}
	}
	return true;
} 
function delpic(obj){
	$("#result_doc"+obj+"_view").attr("src","/assess/upload/none.jpg");
	$("#result_doc"+obj).val("");
}
function downallfile(fid){
	window.open('/assess/manager/index.php?cn=kj_zxjb&p=9&type=downzxfile&do=downall&id=12&fid='+fid);
}
function dodownall(){
	for (fid=1;fid<=5;fid++){
		setTimeout('downallfile('+fid+');',(fid-1)*500);
	}
}

function rpic(fid,type){
	var ri = parseInt($("#result_imgurl"+fid+"_view").attr("data-ri"));
	switch (type){
		case 1:
			ri  = ri +90;
			/* if (ri>360){
				ri = 90 ;
			} */
			break;
		case 0:
			ri  = ri -90;
			/* if (ri<0){
				ri = 270 ;
			} */
			break;
	}
	var xfile = $("#result_imgurl"+fid+"_view").attr("data-src");
	$.post("ajax.php?do=rpic",{src:xfile,rtype:type},function(res){
		eval("var res="+res);
		if(res.succ){
			$("#result_imgurl"+fid+"_view").rotate({animateTo:ri});	
			$("#result_imgurl"+fid+"_view").attr("data-ri",ri);
			var tmpstr  = $("#ashowpic"+fid).attr("href");
			var ni = tmpstr.indexOf('?');
			tmpstr = substr(tmpstr,0,ni); 
			var timestamp = Date.parse(new Date());
			//$("#result_imgurl"+fid+"_view").attr("src",tmpstr+"?"+timestamp);
			$("#ashowpic"+fid).attr("href",tmpstr+"?"+timestamp);
		}
	});
}
function autoremark(){
	if ($("#bc_status").val()==3){//完成
		$("#remark").val("查询完成，详情请点击订单详情页查看！");
	}else{
		$("#remark").val("");
	}		
}

function doocrsfz(xtype){
	$.post("ajax.php?do=doocrdr",{fid:12,type:xtype},function(res){
		eval("var res="+res);
		if(res.status==0 || res.status=='OK'){
			var tmpstr='';
			if (res.data.item){
				xdata = res.data.item;
			}else{
				xdata = res.data;
			}
			for(i in xdata ){
				var obj2 = xdata[i];
				if (typeof (obj2) == "object") {
					for(k in obj2 ){
						var obj3 = obj2[k];
						tmpstr=tmpstr+'\r\n'+obj3.name+'  '+obj3.price+'  ';
					}	
				}else{
					tmpstr = tmpstr+xdata[i]+'  ';  //获得属性值
				}
   			}
   			alert(tmpstr);
   			oldstr = $("#textvin").val();
   			if (oldstr.length>0){
   			tmpstr = $("#textvin").val()+'\r\n'+tmpstr;
   			}
   			$("#textvin").val(tmpstr);
   			if(res.data.item.cardno.length>0){
				//$("#c_card_no").val(res.data.item.cardno);
				$("#c_card_type").val('0');
				$("#c_address").val(res.data.item.address);
				if (res.data.item.sex=='男'){
					$("#c_sex").val('1');
				}else{
					$("#c_sex").val('2');
				}
   			}
			if(res.data.item.issue_authority.length>0){
				$("#c_card_office").val(res.data.item.issue_authority);
				$("#c_card_outdate").val(res.data.item.valid_period);
			}
		}else{
			alert('出错：代码-'+res.status+'\r\n出错信息：'+res.info);
		}
	});	
}
</script>
	<!-- <div class="footer-wrap">
			<div class="box-footer">
				<button type="button" class="btn btn-default" onclick="alert(asdasd)">取消返回</button>
				<button type="button" class="btn btn-primary pull-right" onclick="window.location.href=TKJSselectAll.do?status=3" style="">保存提交</button> 
			</div>
		</div> -->
			
</form>		
		
		<!-- Add the sidebar's background. This div must be placed
			 immediately after the control sidebar -->
		<div class="control-sidebar-bg" style="position: fixed; height: auto;"></div>	
	<!-- REQUIRED JS SCRIPTS -->	
	<!-- Optionally, you can add Slimscroll and FastClick plugins.
			Both of these plugins are recommended to enhance the
			user experience. Slimscroll is required when using the
			fixed layout. -->
	<!--弹窗框体开始-->
	<!-- 模态框（Modal） -->
<div class="modal fade" id="modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" style="width: 1150px; left: -9%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" onclick="qxfh();" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">编辑个人征信照片在线修正信息</h4>
            </div>
     <div id="imgid" class="modal-body">  
     <form id="float_form" action="http://apitest.kcway.net/cjimg.do" method="post">  
     <div class="col-sm-4" style="left:40%;top:10px;position:fixed;text-align:right;width:20%">
     <button class="btn btn-warning right" type="button" style="width:100%;" data-dismiss="modal" aria-label="Close" onclick="doreback();">
             还原最初图片
     </button>
     </div>
     
     <input type="hidden" value="" size="4" id="timenum" name="timenum">
     <input type="hidden" value="" size="4" id="imgname" name="imgname">  
     <input type="hidden" value="" size="4" id="imgfid" name="imgfid">   
     <input type="hidden" size="4" id="x" name="x">
     <input type="hidden" size="4" id="y" name="y">
     <input type="hidden" size="4" id="w" name="w">
     <input type="hidden" size="4" id="h" name="h">
     <input type="hidden" size="4" value="" id="uid" name="uid">
     <input type="hidden" size="4" value="" id="name" name="name">
     </form>
    </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default pull-left" data-dismiss="modal" aria-label="Close" onclick="qxfh();">取消返回</button>
                <button type="button" class="btn btn-primary" onclick="SendForm()">保存提交</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<!-- 弹窗框体结束-->
	<!--弹窗框体开始-->
	<div class="modal fade in" id="mymodal" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document" style="width: 1150px; left: -9%;">
		<div id="mycontent" class="modal-content">
		<div id="float_page_div">
<script src="./CJL.js"></script>
<script src="./ImageZoom.js"></script>
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal" aria-label="Close">
			<span aria-hidden="true">×</span>
		</button>
		<h4 class="modal-title" id="myModalLabel">查看图片-赵新成</h4>
	</div>
	<div class="modal-body">
<table>
	<tbody><tr>
		<td valign="top">
		<div id="idList" class="list" data-id="0"> 
		<img src="http://apitest.kcway.net/wzsh.do?id=22" id="img0" data-src="http://a.kcway.net/assess/upload/2017/11/13/1510569896_1.jpgnew.jpg" class="">
		<img src="http://apitest.kcway.net/wzsh.do?id=22" id="img1" data-src="http://a.kcway.net/assess/upload/2017/11/13/602f9abf25c5132709b91c1cbf2c638b.jpgnew.jpg" class="">
		<img src="http://apitest.kcway.net/wzsh.do?id=22" id="img2" data-src="http://a.kcway.net/assess/upload/2017/11/13/749f2c80fde3e3ffc6ccfbf88449699f.jpg" class="">
		<img src="http://apitest.kcway.net/wzsh.do?id=22" id="img3" data-src="http://a.kcway.net/assess/upload/2017/11/13/9e322b72a5e608d613eab841e7542de6.jpg" class="">
		<img src="http://apitest.kcway.net/wzsh.do?id=22" id="img4" data-src="http://a.kcway.net/assess/upload/2017/11/13/6509a6b417a15d01202452279beaa204.jpg" class="">
		<img src="./1510569896_1.jpgnew.jpg" id="img0" class="onzoom"><img src="./602f9abf25c5132709b91c1cbf2c638b.jpgnew.jpg" id="img1" class=""><img src="./749f2c80fde3e3ffc6ccfbf88449699f.jpg" id="img2" class=""><img src="./9e322b72a5e608d613eab841e7542de6.jpg" id="img3" class=""><img src="./6509a6b417a15d01202452279beaa204.jpg" id="img4" class=""></div>
		</td>
		<td>
		<div class="container">
		 <img id="idImage" class="izImage" src="./1510569896_1.jpgnew(1).jpg">
		<div id="idViewer" class="izViewer" style="display: none; padding: 0px; overflow: hidden; position: relative;">
		<img src="http://apitest.kcway.net/wzsh.do?id=22" style="position: absolute; left: 0px; top: 0px;" width="2000" height="1500">
		<img src="./1510569896_1.jpgnew(2).jpg" width="1600" height="1200" style="position: absolute;"></div>
			
			</div>
			</td>
	</tr>
</tbody>
</table>
</div>
	<div class="footer-wrap">
			<div class="box-footer" style="text-align:center;">
				<button type="button" class="btn btn-default" data-dismiss="modal" aria-label="Close">取消返回</button>
				<button type="button" class="btn btn-danger" onclick="dopre();">◁上一张</button>
				<button type="submit" class="btn btn-danger" onclick="donext();">下一张▷</button>
				<button type="button" class="btn btn-default" onclick="showp();">查看原图</button> 
			</div>
		</div>

<script>
(function(){
	$("div.modal-dialog").css("width","1150px");
	$("div.modal-dialog").css("left","-9%");
	var iz = new ImageZoom( "idImage", "idViewer", {
		mode: "handle", handle: "idHandle", scale: 2, delay: 0
	});
	var arrPic = [], list = $$("idList"), image = $$("idImage");
	arrPic.push({ smallPic: "http://a.kcway.net/assess/cache/fillw_80h_60/1510569896_1.jpgnew.jpg", originPic: "http://a.kcway.net/assess/cache/fillw_800h_600/1510569896_1.jpgnew.jpg", zoomPic: "http://a.kcway.net/assess/upload/2017/11/13/1510569896_1.jpgnew.jpg" });
	arrPic.push({ smallPic: "http://a.kcway.net/assess/cache/fillw_80h_60/602f9abf25c5132709b91c1cbf2c638b.jpgnew.jpg", originPic: "http://a.kcway.net/assess/cache/fillw_800h_600/602f9abf25c5132709b91c1cbf2c638b.jpgnew.jpg", zoomPic: "http://a.kcway.net/assess/upload/2017/11/13/602f9abf25c5132709b91c1cbf2c638b.jpgnew.jpg" });
	arrPic.push({ smallPic: "http://a.kcway.net/assess/cache/fillw_80h_60/749f2c80fde3e3ffc6ccfbf88449699f.jpg", originPic: "http://a.kcway.net/assess/cache/fillw_800h_600/749f2c80fde3e3ffc6ccfbf88449699f.jpg", zoomPic: "http://a.kcway.net/assess/upload/2017/11/13/749f2c80fde3e3ffc6ccfbf88449699f.jpg" });
	arrPic.push({ smallPic: "http://a.kcway.net/assess/cache/fillw_80h_60/9e322b72a5e608d613eab841e7542de6.jpg", originPic: "http://a.kcway.net/assess/cache/fillw_800h_600/9e322b72a5e608d613eab841e7542de6.jpg", zoomPic: "http://a.kcway.net/assess/upload/2017/11/13/9e322b72a5e608d613eab841e7542de6.jpg" });
	arrPic.push({ smallPic: "http://a.kcway.net/assess/cache/fillw_80h_60/6509a6b417a15d01202452279beaa204.jpg", originPic: "http://a.kcway.net/assess/cache/fillw_800h_600/6509a6b417a15d01202452279beaa204.jpg", zoomPic: "http://a.kcway.net/assess/upload/2017/11/13/6509a6b417a15d01202452279beaa204.jpg" });
	$$A.forEach(arrPic, function(o, i){
		var img = list.appendChild(document.createElement("img"));
		img.src = o.smallPic;
		img.id="img"+i;
		$("#"+img.id).attr("data-src",o.zoomPic);
		img.onclick = function(){
			iz.reset({ originPic: o.originPic, zoomPic: o.zoomPic });
			$$A.forEach(list.getElementsByTagName("img"), function(img){  img.className = ""; });
			img.className = "onzoom";
			$("#idList").attr("data-id",i);
		}
		var temp;
		img.onmouseover = function(){ if( !this.className ){ this.className = "on"; temp = image.src; image.src = o.originPic; } }
		img.onmouseout = function(){ if( this.className == "on" ){ this.className = ""; image.src = temp; } }
		//if(!i){ img.onclick(); }
		if (i==0){
			 imgnew = img ;
		}
	})
	imgnew.onclick();
	})();
	function dopre(){
		i = $("#idList").attr("data-id");
		i = i -1;
		if (i<0){
			i=4;
		}
		img = document.getElementById("img"+i);
		img.onclick();
	}
	function donext(){
		i = parseInt($("#idList").attr("data-id"));
		i = i +1;
		if (i>4){
			i=0;
		}
		img = document.getElementById("img"+i);
		img.onclick();
	}
	function showp(){
		i = parseInt($("#idList").attr("data-id"));
		img = document.getElementById("img"+i);
		window.open($("#"+img.id).attr("data-src"));     
	}
</script>

</div>
</div>
		</div>
	</div>
<!-- 弹窗框体结束-->

<script type="text/javascript">
function cdown(){

}

$(function(){ 
    var jcrop_api; 
   }); 
function SendForm() 
    {
 //alert("11111111");
 document.getElementById('float_form').submit();
     }
function qxfh(){
	//alert("销毁");
	jcrop_api.destroy();
}
         //启动jcrop 
		function cjimg(fid,imgname){  
			//jcrop_api.init();
			var imgpath=document.getElementById("result_imgurl"+fid+"_view").src;
			document.getElementById("imgname").value=imgname;
			//alert(fid);
			document.getElementById("imgfid").value=fid;
			//var path =  $('#suolueresult_imgurl'+fid+'_view').attr('src');		   
            $("#target").remove();
        	$("#imgid").prepend("<img id='target' name='target'  src='"+imgpath+"'/>");       	
			//document.getElementById("target").src=imgpath;
			//var we=document.getElementById("target").src;
			//alert(fid+"---"+imgpath+"----"+we);        	
           $("div.modal-dialog").css("width","830px");
           $('#target').Jcrop({ 
     	      aspectRatio: 0,
     	      boxWidth:800,
     	      onSelect: updateCoords
     	    },function(){ 
     	         // Use the API to get the real image size  
     	         jcrop_api = this; 
     	        });
     	  jcrop_api.setImage(imgpath);
     	  function updateCoords(c)
     	  {
     	    $('#x').val(c.x);
     	    $('#y').val(c.y);
     	    $('#w').val(c.w);
     	    $('#h').val(c.h);
     	   //alert(c.w);
     	  };	
  		}  		
function openJcrop(){ 
	

} 
function doreback(){
	var fid= document.getElementById("imgfid").value;
	var uid= document.getElementById("uid").value;	
	//alert(fid+"----"+uid);
	$.post("hy.do",{fid:fid,uid:uid},function(res){
		var res =eval("(" + res + ")");
		//alert(res);
		if(res=="1"){
			//alert("还原成功");
			qxfh();
			window.location.reload();		
		}else{
			//alert(res);
		//	alert(res);
		}
	});
}
</script>
	<script>
	
		$('#modal').on('hidden.bs.modal', function (e) {
			$(this).removeData("bs.modal");
	   })
	</script>
	
	<script type="text/javascript" src="./index.js"></script>
	<script type="text/javascript" src="./ui.js"></script>
	

<div class="daterangepicker dropdown-menu show-calendar opensright" style="top: 156.6px; left: 1918px; right: auto;"><div class="calendar first right"><div class="calendar-date"><table class="table-condensed"><thead><tr><th></th><th colspan="5" class="month">十一月 2017</th><th class="next available"><i class="fa fa-arrow-right icon icon-arrow-right glyphicon glyphicon-arrow-right"></i></th></tr><tr><th>日</th><th>一</th><th>二</th><th>三</th><th>四</th><th>五</th><th>六</th></tr></thead><tbody><tr><td class="off disabled" data-title="r0c0">29</td><td class="off disabled" data-title="r0c1">30</td><td class="off disabled" data-title="r0c2">31</td><td class="off disabled" data-title="r0c3">1</td><td class="off disabled" data-title="r0c4">2</td><td class="off disabled" data-title="r0c5">3</td><td class="off disabled" data-title="r0c6">4</td></tr><tr><td class="off disabled" data-title="r1c0">5</td><td class="off disabled" data-title="r1c1">6</td><td class="available active start-date end-date" data-title="r1c2">7</td><td class="available" data-title="r1c3">8</td><td class="available" data-title="r1c4">9</td><td class="available" data-title="r1c5">10</td><td class="available" data-title="r1c6">11</td></tr><tr><td class="available" data-title="r2c0">12</td><td class="available" data-title="r2c1">13</td><td class="available" data-title="r2c2">14</td><td class="available" data-title="r2c3">15</td><td class="available" data-title="r2c4">16</td><td class="available" data-title="r2c5">17</td><td class="available" data-title="r2c6">18</td></tr><tr><td class="available" data-title="r3c0">19</td><td class="available" data-title="r3c1">20</td><td class="available" data-title="r3c2">21</td><td class="available" data-title="r3c3">22</td><td class="available" data-title="r3c4">23</td><td class="available" data-title="r3c5">24</td><td class="available" data-title="r3c6">25</td></tr><tr><td class="available" data-title="r4c0">26</td><td class="available" data-title="r4c1">27</td><td class="available" data-title="r4c2">28</td><td class="available" data-title="r4c3">29</td><td class="available" data-title="r4c4">30</td><td class="available off" data-title="r4c5">1</td><td class="available off" data-title="r4c6">2</td></tr><tr><td class="available off" data-title="r5c0">3</td><td class="available off" data-title="r5c1">4</td><td class="available off" data-title="r5c2">5</td><td class="available off" data-title="r5c3">6</td><td class="available off" data-title="r5c4">7</td><td class="available off" data-title="r5c5">8</td><td class="available off" data-title="r5c6">9</td></tr></tbody></table></div></div><div class="calendar second left"><div class="calendar-date"><table class="table-condensed"><thead><tr><th class="prev available"><i class="fa fa-arrow-left icon icon-arrow-left glyphicon glyphicon-arrow-left"></i></th><th colspan="5" class="month">十一月 2017</th><th class="next available"><i class="fa fa-arrow-right icon icon-arrow-right glyphicon glyphicon-arrow-right"></i></th></tr><tr><th>日</th><th>一</th><th>二</th><th>三</th><th>四</th><th>五</th><th>六</th></tr></thead><tbody><tr><td class="available off" data-title="r0c0">29</td><td class="available off" data-title="r0c1">30</td><td class="available off" data-title="r0c2">31</td><td class="available" data-title="r0c3">1</td><td class="available" data-title="r0c4">2</td><td class="available" data-title="r0c5">3</td><td class="available" data-title="r0c6">4</td></tr><tr><td class="available" data-title="r1c0">5</td><td class="available" data-title="r1c1">6</td><td class="available active start-date end-date" data-title="r1c2">7</td><td class="available" data-title="r1c3">8</td><td class="available" data-title="r1c4">9</td><td class="available" data-title="r1c5">10</td><td class="available" data-title="r1c6">11</td></tr><tr><td class="available" data-title="r2c0">12</td><td class="available" data-title="r2c1">13</td><td class="available" data-title="r2c2">14</td><td class="available" data-title="r2c3">15</td><td class="available" data-title="r2c4">16</td><td class="available" data-title="r2c5">17</td><td class="available" data-title="r2c6">18</td></tr><tr><td class="available" data-title="r3c0">19</td><td class="available" data-title="r3c1">20</td><td class="available" data-title="r3c2">21</td><td class="available" data-title="r3c3">22</td><td class="available" data-title="r3c4">23</td><td class="available" data-title="r3c5">24</td><td class="available" data-title="r3c6">25</td></tr><tr><td class="available" data-title="r4c0">26</td><td class="available" data-title="r4c1">27</td><td class="available" data-title="r4c2">28</td><td class="available" data-title="r4c3">29</td><td class="available" data-title="r4c4">30</td><td class="available off" data-title="r4c5">1</td><td class="available off" data-title="r4c6">2</td></tr><tr><td class="available off" data-title="r5c0">3</td><td class="available off" data-title="r5c1">4</td><td class="available off" data-title="r5c2">5</td><td class="available off" data-title="r5c3">6</td><td class="available off" data-title="r5c4">7</td><td class="available off" data-title="r5c5">8</td><td class="available off" data-title="r5c6">9</td></tr></tbody></table></div></div><div class="ranges"><div class="range_inputs"><div class="daterangepicker_start_input"><label for="daterangepicker_start">开始</label><input class="input-mini" name="daterangepicker_start" value="2017/11/07" type="text"></div><div class="daterangepicker_end_input"><label for="daterangepicker_end">结束</label><input class="input-mini" name="daterangepicker_end" value="2017/11/07" type="text"></div><button class="applyBtn btn btn-small btn-sm btn-success">确定</button>&nbsp;<button class="cancelBtn btn btn-small btn-sm btn-default">取消</button></div></div></div></body></html>