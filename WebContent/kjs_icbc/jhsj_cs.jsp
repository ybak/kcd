<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<title>快加后台管理</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/css/bootstrap.css" rel="stylesheet" type="text/css">

<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/jQuery-2.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/bootstrap.js" type="text/javascript"></script>
</head>
<body>
<form action="${pageContext.request.contextPath }/kjrz/getassess.do" method="post" class="form-horizontal">
	   <div class="form-group">
		<label class="col-sm-2 control-label">车况</label>
		<div class="col-sm-8"> 
		<select class="form-control" id="carstatus" name="carstatus"  >
		<option value="0">--请选择--</option>
		<option value="1">优秀</option>
		<option value="2">一般</option>
		<option value="3">较差</option>
		</select>
		</div>
	   </div>
       <div class="form-group">
		<label class="col-sm-2 control-label">车辆用途</label>
		<div class="col-sm-8"> 
		<select class="form-control" id="purpose" name="purpose"  >
		<option value="0">--请选择--</option>
		<option value="1">自用</option>
		<option value="2">公务商用</option>
		<option value="3">营运</option>
		</select>
		</div>
	   </div>
       <div class="form-group">
		<label class="col-sm-2 control-label">省份</label>
		<div class="col-sm-8"> 
		<select class="form-control" onchange="getcity(this.options[this.options.selectedIndex].value)" id="province" name="province"  >
		</select>
		</div>
	   </div>
       <div class="form-group">
		<label class="col-sm-2 control-label">城市</label>
		<div class="col-sm-8"> 
		<select class="form-control"  id="city" name="city"  >
		</select>
		</div>
	   </div>
	   <div class="form-group">
		<label class="col-sm-2 control-label">车辆类型</label>
		<div class="col-sm-8"> 
		<select class="form-control" onchange="getbrand(this.options[this.options.selectedIndex].value)"  id="vehicle" name="vehicle"  >
		<option value="0">--请选择--</option>
		<option value="passenger">乘用车</option>
		<option value="commercial">商用车</option>
		</select>
		</div>
	   </div>
	   <div class="form-group">
		<label class="col-sm-2 control-label">车牌</label>
		<div class="col-sm-8"> 
		<select class="form-control" onchange="getseries(this.options[this.options.selectedIndex].value)"  id="brand" name="brand"  >
		</select>
		</div>
	   </div>
	   <div class="form-group">
		<label class="col-sm-2 control-label">车系</label>
		<div class="col-sm-8">  
		<select class="form-control"  onchange="getcar(this.options[this.options.selectedIndex].value)" id="series" name="series"  >
		</select>
		</div>
	   </div>
	   <div class="form-group">
		<label class="col-sm-2 control-label">车型</label>
		<div class="col-sm-8"> 
		<select class="form-control"  id="car" name="car"  >
		</select>
		</div>
	   </div>
	   <div class="form-group">
		<label class="col-sm-2 control-label">待估车辆的启用年份（格式：yyyy）</label>
		<div class="col-sm-8"> 
		<input class="form-control"  id="useddate" name="useddate" type="text" />
		</div>
	   </div>
	   <div class="form-group">
		<label class="col-sm-2 control-label">待估车辆的启用月份（格式：mm）</label>
		<div class="col-sm-8"> 
		<input class="form-control"  id="useddateMonth" name="useddateMonth" type="text" />
		</div>
	   </div>
	   <div class="form-group">
		<label class="col-sm-2 control-label">待估车辆的公里数，单位万公里</label>
		<div class="col-sm-8"> 
		<input class="form-control"  id="mileage" name="mileage" type="text" />
		</div>
	   </div>
	   <div class="form-group">
		<label class="col-sm-2 control-label">(非必填)待估车辆在购买价(单位万元)</label>
		<div class="col-sm-8"> 
		<input class="form-control"  id="price" name="price" type="text" />
		</div>
	   </div>
	   <input type="submit" class="btn" value="提交">
	  <script type="text/javascript">
	  $(document).ready(function(){
			var con="<option value=''>***请选择***</option>";
			$.post("${pageContext.request.contextPath }/kjrz/getprovince.do",
					function(result){
				     $("#province").empty();
				 $.each(result.result, function(index,item){
				       con += "<option  value="+item.proID+">"+item.proName+"</option>";       			   	      		
			       	 });           	
			       	 $("#province").append(con);		
					},'json');
		});
	   
		
		function  getcity(province){
		          var con="<option value=''>***请选择***</option>";
			$.post("${pageContext.request.contextPath }/kjrz/getcity.do",
					{province:province},
					function(result){
				     $("#city").empty();
				 $.each(result.result, function(index,item){
				       con += "<option  value="+item.cityID+">"+item.cityName+"</option>";       			   	      		
			       	 });           	
			       	 $("#city").append(con);		
					},'json');
		  
	    }
	  
	  function  getbrand(vehicle){
		  var con="<option value=''>***请选择***</option>";
			$.post("${pageContext.request.contextPath }/kjrz/getbrand.do",
					{vehicle:vehicle},
					function(result){
					var res=result.result;
				     $("#brand").empty();
				     for(var key in res){
				     //alert(key+':'+res[key]);
				    	 $.each(res[key], function(index,item){
						       con += "<option  value="+item.id+">"+key+"-"+item.big_ppname+"</option>";       			   	      		
					       	 });
				    }         	
			       	 $("#brand").append(con);		
					},'json');
		  
	    }
	  function  getseries(brand){
		  var con="<option value=''>***请选择***</option>";
			$.post("${pageContext.request.contextPath }/kjrz/getseries.do",
					{brand:brand},
					function(result){
					var res=result.result.pinpai_list;
				     $("#series").empty();
				     for(var i=0;i<res.length;i++){
				     //alert(res[i]);
				    	 $.each(res[i].xilie, function(index,item){
						       con += "<option  value="+item.xlid+">"+res[i].ppname+"-"+item.xlname+"</option>";       			   	      		
					       	 });
				    }         	
			       	 $("#series").append(con);		
					},'json');
		  
	    }
	  function  getcar(series){
		  var con="<option value=''>***请选择***</option>";
			$.post("${pageContext.request.contextPath }/kjrz/getcar.do",
					{series:series},
					function(result){
					var res=result.result.data;
				     $("#car").empty();
				     for(var i=0;i<res.length;i++){
				     //alert(res[i]);
				    	 $.each(res[i].chexing_list, function(index,item){
						       con += "<option  value="+item.id+">"+res[i].pyear+"-"+item.cxname+"</option>";       			   	      		
					       	 });
				    }         	
			       	 $("#car").append(con);		
					},'json');
		  
	    }
	  </script>
</form>
</body>
</html>