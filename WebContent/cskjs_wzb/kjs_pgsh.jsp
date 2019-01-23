<%@page import="java.util.Random"%>
<%@page import="com.model.icbc.bclient_check"%>
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
<link rel="icon" href="${pageContext.request.contextPath }/cskjs_css/logo.png" type="image/x-icon"/>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

</script>
<script type="text/javascript">		
$(document).ready(function(){
	var pg_states=document.getElementById("pg_states").value;
	var s="<option value='0'>请选择</option>";
	var cityid=0;
$.ajax({ 	
		url:"finfdstates.do",
	    type:"POST",
	    dataType: "json",
       success: function(msg){
       	 var con = ""; 
       	$("#states").empty();
       	$.each(msg,function(index, n){
       		if(msg[index].id==pg_states){
       			con += "<option  selected='selected' value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";
       		}else{
       			con += "<option  value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";	        			
       		}      		
       	 });           	
       	$("#states").append(s+con);
       	citys1($("#states").val());
       }
});

});
function citys1(cityid){
	var s="<option value='0'>请选择</option>";
	var pg_citys=document.getElementById("pg_citys").value;	
	$.ajax({ 	
		url:"fincitys.do",
	    type:"POST",
	    dataType: "json",
	    data :{
	    	state_id : cityid
	    },
       success: function(msg){
       	 var con = "";         	  
       	$("#citys").empty();
       	$.each(msg,function(index, n){
       		if(msg[index].id==pg_citys){
       			con += "<option  selected='selected' value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";
       		}else{
       			con += "<option  value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";	        			
       		}       	      		
       	 });           	
       	$("#citys").append(s+con);      	
       }
});
}
</script>

</head>
<body>
<form id="info_form" action="" class="form-horizontal" method="post" enctype="multipart/form-data" onsubmit="return check()">
<input id="id" name="id" value="${requestScope.assess_cars.id }" type="hidden">
<input id="adminid" name="adminid" value="${sessionScope.id }" type="hidden">
<input id="pg_states" name="pg_states" value="${requestScope.assess_cars.mem_states }" type="hidden">
<input id="pg_citys" name="pg_citys" value="${requestScope.assess_cars.mem_citys }" type="hidden">

<div class="box-header with-border">
	<div  class="box-body" style="margin-left: 150px;width: 85%" >  	     	            
			<div class="form-group">						
			  <h3 align="center" style="margin-right: 300px">用户提交信息</h3>
			  <div  style="padding-top: 60px;width:85%;">               
             <p>工行进件审核 来自：${requestScope.assess_cars.gname }-${requestScope.assess_cars.pname }<span style="float:right;display:block;">${fn:substring(requestScope.assess_cars.dt_add,0,19)} 合同编码：<font style="color: #ff8700;">${requestScope.assess_cars.code }</font></span></p>            
             
               <table id="data_table" class="divcss table" style="width:100%; ;border-style:none">  
               <tr>
               <td>车辆类型</td>
               <td>
               <select name="cars_type" id="cars_type">
               <option value="0">请选择车辆类型</option>
               <option value="1" ${requestScope.assess_cars.cars_type==1?"selected='selected'":'' }>新车</option>
               <option value="2" ${requestScope.assess_cars.cars_type==2?"selected='selected'":'' }>二手车</option>
               </select>
               </td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">颜色</td>
               <td>
                <select name="color_id" id="color_id">
                 <option value="">请选择车身颜色</option>
								<option value="1" ${requestScope.assess_cars.color_id==1?"selected='selected'":'' }>黑</option>
								<option value="2" ${requestScope.assess_cars.color_id==2?"selected='selected'":'' }>白</option>
								<option value="3" ${requestScope.assess_cars.color_id==3?"selected='selected'":'' }>灰</option>
								<option value="4" ${requestScope.assess_cars.color_id==4?"selected='selected'":'' }>红</option>
								<option value="5" ${requestScope.assess_cars.color_id==5?"selected='selected'":'' }>银</option>
								<option value="6" ${requestScope.assess_cars.color_id==6?"selected='selected'":'' }>蓝</option>
								<option value="7" ${requestScope.assess_cars.color_id==7?"selected='selected'":'' }>金</option>
								<option value="8" ${requestScope.assess_cars.color_id==8?"selected='selected'":'' }> 棕</option>
								<option value="9" ${requestScope.assess_cars.color_id==9?"selected='selected'":'' }> 橙</option>
								<option value="10" ${requestScope.assess_cars.color_id==10?"selected='selected'":'' }> 黄</option>
								<option value="11" ${requestScope.assess_cars.color_id==11?"selected='selected'":'' }> 紫</option>
								<option value="12" ${requestScope.assess_cars.color_id==12?"selected='selected'":'' }> 绿</option>
								<option value="13" ${requestScope.assess_cars.color_id==13?"selected='selected'":'' }> 褐</option>
								<option value="14" ${requestScope.assess_cars.color_id==14?"selected='selected'":'' }> 栗</option>
								<option value="15" ${requestScope.assess_cars.color_id==15?"selected='selected'":'' }> 米</option>
								<option value="16" ${requestScope.assess_cars.color_id==16?"selected='selected'":'' }>银灰</option>
								<option value="17" ${requestScope.assess_cars.color_id==17?"selected='selected'":'' }> 青</option>
								<option value="18" ${requestScope.assess_cars.color_id==18?"selected='selected'":'' }> 香槟</option>
								<option value="19" ${requestScope.assess_cars.color_id==19?"selected='selected'":'' }> 咖啡</option>
								<option value="20" ${requestScope.assess_cars.color_id==20?"selected='selected'":'' }> 天山</option>
								<option value="0" ${requestScope.assess_cars.color_id==0?"selected='selected'":'' }>其他色</option>								
				</select>
				</td>
               <td style="color: #5f5f6c;">所在地</td>
               <td>
               <select id="states" name="states" onchange="citys1(this.options[this.options.selectedIndex].value)">                                                   
               </select>
               <select id="citys" name="citys">                                    
               </select>
                </td>
               </tr>
                <tr>
               <td style="color: #5f5f6c;">行驶里程</td>
               <td>
               <input id="carkm" name="carkm" class="inputcss"  type="text" value="${requestScope.assess_cars.car_km_icbc}" />               
               <span style="margin-left:-40px;padding:3px;border:1px solid #b1bacb;border-radius: 2px;">公里</span>
               </td>
               <td style="color: #5f5f6c;">国产/进口</td>
               <td>
               <input type="hidden" id="source_id" name="source_id" value="${requestScope.assess_cars.source_id }">
               <img id="g1" name="g1" onclick="radioimg('1')" style="padding-right: 5px;" alt="国产" src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png" />国产
               <img id="g2" name="g2" onclick="radioimg('2')"  style="padding-right: 5px;" alt="进口" src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png" />进口
               </td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">VIN</td>
               <td><input id="carvin" name="carvin" class="inputcss" type="text" value="${requestScope.assess_cars.vincode }" /></td>
               <td style="color: #5f5f6c;">使用性质</td>
               <td>
               <input type="hidden" id="property_id" name="property_id" value="${requestScope.assess_cars.property_id }">              
               <img id="y1" name="y1" onclick="radioimg1('1')" style="padding-right: 5px;" alt="" src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png">营运
               <img id="y2" name="y2" onclick="radioimg1('2')" style="padding-right: 5px;" alt="" src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png">非营运</td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">出厂日期</td>
               <td><input id="cardt2" name="cardt2" class="inputcss" type="text" value="${fn:substring(requestScope.assess_cars.cardt1,0,10)}" /></td>
               <td style="color: #5f5f6c;">变速箱</td>
               <td>
               <input type="hidden" id="gear_box_id" name="gear_box_id" value="${requestScope.assess_cars.gear_box_id }">                           
               <img id="b1" name="b1" onclick="radioimg2('1')" style="padding-right: 5px;" alt="" src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png">自动
               <img id="b2" name="b2" onclick="radioimg2('2')" style="padding-right: 5px;" alt="" src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png">手动</td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">初次登记时间</td>
               <td><input id="cardt1" name="cardt1" class="inputcss" type="text" value="${fn:substring(requestScope.assess_cars.cardt2,0,10)}" /></td>
               <td style="color: #5f5f6c;">车辆状况</td>
               <td>
               <input type="hidden" id="car_status" name="car_status" value="${requestScope.assess_cars.car_status }">                            
               <img id="c1" name="c1" onclick="radioimg3('1')" style="padding-right: 5px;" alt="" src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png">一般
               <img id="c2" name="c2" onclick="radioimg3('2')" style="padding-right: 5px;" alt="" src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png">良好
               <img id="c3" name="c3" onclick="radioimg3('3')" style="padding-right: 5px;" alt="" src="${pageContext.request.contextPath }/cskjs_css/910746288699256124.png">优秀</td>
               </tr>
               <tr>
               <td style="color: #5f5f6c;">预期价格</td>
               <td >
               <input class="inputcss" id="icbc_pricecs" name="icbc_pricecs"  type="text"  value="${requestScope.assess_cars.icbc_pricecs}" />
               <span style="margin-left:-40px;padding:3px;border:1px solid #b1bacb;border-radius: 2px;">万元</span>
               </td>  
               <td style="color: #5f5f6c;">裸车价格</td>
               <td >
               <input name="price_new" id="price_new" class="inputcss" type="text" value="${requestScope.assess_cars.price_new }" />
               <span style="margin-left:-26px;padding:3px;border:1px solid #b1bacb;border-radius: 2px;">元</span>
               <span style="margin-left:-5px;padding:3px;border:1px solid #b1bacb;border-radius: 2px;">
               <a style="color: #3c8dbc;" href="javascript:getprice1('${requestScope.carmodel.id }');">获取</a>
               </span>
               </td>                           
               </tr>
               <tr>
               <td style="color: #5f5f6c;">车型</td>
               <td colspan="6">
               <input id="pg_brid" name="pg_brid" type="hidden" value="${requestScope.assess_cars.brid }" />
               <input id="pg_seid" name="pg_seid" type="hidden" value="${requestScope.assess_cars.seid }" />
               <input id="pg_carid" name="pg_carid" type="hidden" value="${requestScope.assess_cars.carid }" />
               <select  id="brid" name="brid" onchange="fun(this.options[this.options.selectedIndex].value)" >                  
               <option value="0">请选择</option>
               </select>
               <select id="seid" name="seid" onchange="fun3(this.options[this.options.selectedIndex].value)" >             
               <option value="0">请选择</option>
               </select>
               <select id="carid" name="carid"> 
               <option value="0">请选择</option>
               </select></td>
               </tr>
               <tr>
                <td style="color: #5f5f6c;"> 车牌号 </td>
                <td>
                <input id="carno" name="carno" class="inputcss" type="text" value="${requestScope.assess_cars.c_carno }" />
                </td>
                <td style="color: #5f5f6c;">品牌车型 </td>
                <td >
                <input id="ppxh" name="ppxh" style="width:200px;padding-left: 6px;border: 1px solid #b1bacb;border-radius: 2px;"  type="text" value="${requestScope.assess_cars.ppxh }" />
                </td>
               </tr>
               
               </table>              
              </div>
              </div>
              </div>
              
		   </div>
		   <script type="text/javascript">
		   $(document).ready(function(){
				fun2(document.getElementById("pg_brid").value);
			});
			function fun2(selectedBrid){
				//第一个
				var s = "<option value='0'>请选择</option>"; 
			   	$.ajax({ 
			   		url:"getAllCarBrand.do",
			   	    type:"POST",
			           success: function(dataCarBrand){
			           	 var con = "";  
			           	$("#brid").empty();
			           	 $.each($.parseJSON(dataCarBrand),function(index,carBrand){
			           		if(carBrand.id==selectedBrid){
			           			con += "<option  selected='selected' value="+carBrand.id+">"+carBrand.first+" "+carBrand.name+"</option>";
			           		}else{
			           			con += "<option  value="+carBrand.id+">"+carBrand.first+" "+carBrand.name+"</option>";	        			
			           		}
			           	 });
			           	$("#brid").append(s+con);
			           }
			    });
			   	fun(selectedBrid);
			}
			
			function fun(selectedBrid){
				//第二个
			   	var selectedSeid =${assess_cars.seid};   
			   	if(selectedBrid!=0){
				$.ajax({ 
					url:"getCarSeries.do",
					data:{brid:selectedBrid},
				    type:"POST",
				       success: function(dataCarSeries){
				       	var con = ""; 
				       	$("#seid").empty();
				       	 $.each($.parseJSON(dataCarSeries),function(index,carSeries){
				       		if(selectedSeid==carSeries.id){
				       		 	con += "<option selected='selected' value="+carSeries.id+">"+carSeries.name+"</option>";	       		    
				       		}else{
				       			con += "<option  value="+carSeries.id+">"+carSeries.name+"</option>";
				       		}				       	
				       	 });	       	
				       	$("#seid").append(con);
				       	fun3(document.getElementById("seid").value);	
				       }
				 });	
				
			   	}
			}
			
			function fun3(selectedSeid){
				var selectedcarid =${assess_cars.carid}; 
				if(selectedSeid!=0){
				//第三个
				$.ajax({ 
					url:"getCarModel.do",
					data:{seid:selectedSeid},
				    type:"POST",
			        success: function(dataCarModel){
			        	var con = ""; 
			        	$("#carid").empty();
			        	 $.each($.parseJSON(dataCarModel),function(index,carModel){
			        		 if(selectedcarid==carModel.id){
			 	       		 	con += "<option selected='selected' value="+carModel.id+">"+carModel.name+"</option>";
			 	       		}else{
			 	       		    con += "<option  value="+carModel.id+">"+carModel.name+"</option>"; 
			 	       		}       			 
			        	 });        	
			        	$("#carid").append(con);
			        }
				}); 	
				}
			}
		   </script>
<script type="text/javascript">
  function getprice1(id){
   	$.ajax({ 
   		url:"getNewCarPrice.do",
   	    type:"POST",
   	    dataType:"json",
   	    data:{id:id},
        success:function(msg){
        document.getElementById("price_new").value=msg.price*10000;
        },
        error:function(e){
           	alert("正在加载,请稍等!"+e.status);
        }
    });	
   };
</script>		
<script type="text/javascript">
function ylimage(obj){
	if(obj!=0){
	var $img = $(obj),
		imgUrl = $img[0].src;
	}
	var activeIndex=0;
	var imgs = [];
	$(".img_q").each(function(i,elem){
		//alert(elem.src);
		if(obj!=0){
		if(elem.src == imgUrl){
			activeIndex=i;	
		}
		}
		imgs.push({
			url: elem.src, 
			imgHeight :'820',
			imgWidth : '900'
		});
	});
localStorage["photoGalleryImgs"] = JSON.stringify(imgs); //因为此字符串可能是base64字符，appgo无法传
localStorage["photoGalleryActiveIndex"] = activeIndex; 
	   //给iframe加上src路径
    $("#J_pg").attr("src","jquery-photo-gallery/gallerys.jsp");
     //显示模态框  只有在选择编辑的行   然后根据回调函数成功后才会显示模态框
    $('#myModal1').modal({ show: true, backdrop: 'static' });
}
</script>  	
	<div class="box-body">
<div style="width: 85%;" class="box-header with-border">
<h3 align="center">相关审核</h3>
<a href="downloadFiles_all.do?type=pg&id=${requestScope.id }" class="btn btn-success" style="margin-left:100px">一键下载所有图片</a>
<a onclick="ylimage('0')" class="btn btn-success">一键预览所有图片</a>
</div>
			<div class="form-group" >
			<div  id="section3" class="col-sm-12" style="width: 85%;" align="center"   >
			<div  style="color:#ff8700;" >车辆资料</div>		
			</div>
				<div class="col-sm-12" style="width: 85%;margin-left:100px; margin-top: 50px;">
					<div class="row inline-from">
				    <%
					Random a = new Random(); 
				    %>
				    <c:if test="${!empty requestScope.aItems }">
				     
				    <c:if test="${requestScope.assess_cars.cars_type==1}">
				    <c:forEach items="${requestScope.aItems }" var="imgs" begin="17" end="19" >
					<c:if test="${!empty imgs.bcimg }">					
					<div class="col-sm-2" style="margin:10px 10px;text-align: center;">
							<img onclick="ylimage(this)" class="img_q aligncenter" id="imgstep2_4" name="imgstep2_4" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="http://a.kcway.net/${imgs.bcimg}">
							<div class="col-sm-12" style="*display: inline;*zoom: 1;">
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:imgrotate('${imgs.bcimg}','1');">左转</a>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="downloadFile.do?fileUrl=http://a.kcway.net/${imgs.bcimg}&fileName=<%=a.nextInt(10000) %>" >下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:imgrotate('${imgs.bcimg}','2');">右转</a>					        
						    <br>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="ashowpic3" href="http://a.kcway.net/${imgs.bcimg}" target="_blank">${imgs.name}</a>
						    </div>
					</div>  
					</c:if>
					<c:if test="${empty imgs.bcimg }">
					<div class="col-sm-2" style="margin:10px 10px;text-align: center;">
							<a  href="javascript:void(0)" >
							<img class="img_q aligncenter" id="imgstep2_4" name="imgstep2_4" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png">
							</a>
							<div class="col-sm-12" style="*display: inline;*zoom: 1;">
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">左转</a>	
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">右转</a>					        
						    <br>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="ashowpic3" href="javascript:void(0)">${imgs.name}</a>
						    </div>
					</div>
					</c:if>
					</c:forEach>
					</c:if>
				    
				    <c:if test="${requestScope.assess_cars.cars_type==2}">
				    <c:forEach items="${requestScope.aItems }" var="imgs" begin="0" end="6" >
					<c:if test="${!empty imgs.bcimg }">					
					<div class="col-sm-2" style="margin:10px 10px;text-align: center;">
							<img onclick="ylimage(this)" class="img_q aligncenter" id="imgstep2_4" name="imgstep2_4" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="http://a.kcway.net/${imgs.bcimg}">
							<div class="col-sm-12" style="*display: inline;*zoom: 1;">
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:imgrotate('${imgs.bcimg}','1');">左转</a>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="downloadFile.do?fileUrl=http://a.kcway.net/${imgs.bcimg}&fileName=<%=a.nextInt(10000) %>" >下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:imgrotate('${imgs.bcimg}','2');">右转</a>					        
						    <br>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="ashowpic3" href="http://a.kcway.net/${imgs.bcimg}" target="_blank">${imgs.name}</a>
						    </div>
					</div>  
					</c:if>
					<c:if test="${empty imgs.bcimg }">
					<div class="col-sm-2" style="margin:10px 10px;text-align: center;">
							<a  href="javascript:void(0)" >
							<img class="img_q aligncenter" id="imgstep2_4" name="imgstep2_4" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png">
							</a>
							<div class="col-sm-12" style="*display: inline;*zoom: 1;">
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">左转</a>	
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">右转</a>					        
						    <br>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="ashowpic3" href="javascript:void(0)">${imgs.name}</a>
						    </div>
					</div>
					</c:if>
					</c:forEach>
					</c:if>
					
				    </c:if>    
				    <c:if test="${empty requestScope.aItems }">
				    <%
				       Map map=(Map)request.getAttribute("icbcpg");
				    for(int i=1;i<=7;i++){				    				    
				    %>  
				    <div class="col-sm-2" style="margin:10px 10px;text-align: center;">
							<a  href="javascript:void(0)" >
							<img class="img_q aligncenter" id="imgstep2_4" name="imgstep2_4" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png">
							</a>
							<div class="col-sm-12" style="*display: inline;*zoom: 1;">
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">左转</a>	
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">右转</a>					        
						    <br>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="ashowpic3" href="javascript:void(0)"><%=map.get(i) %></a>
						    </div>
					</div>				    
				    <%} %>
				    </c:if> 				
					</div>
					</div>
<!-- 视频
			<div id="section4" class="col-sm-10" style="width: 85%;margin-top: 50px;" >
			<div align="center" style="color:#ff8700;" >视频材料</div>		
			</div>
<div class="col-sm-10" style="margin-left:100px; margin-top: 50px;">
	<div class="row inline-from">	
<div style="width: 85%;" align="center" >				
<video  width="658" height="444"  poster="${pageContext.request.contextPath }/cskjs_css/268222262987697898.jpg"  preload="none" controls="controls">
<source src="${pageContext.request.contextPath }/cskjs_css/465.mp4" />
</video>
</div>		
									
	</div>
</div>	
-->
</div>
     		<div class="form-group">
			<div id="section3" class="col-sm-10" style="width: 85%;" align="center"  >
			<div  style="color:#ff8700;" >车辆照片</div>		
			</div>
<script type="text/javascript">
function imgrotate(imgpath,fr) {
	  $.ajax({
		   type:"post",   
		   url:"icbc_img.do",
		   data:{
			   imgpath : imgpath,
			   fr : fr
		   },
	  success: function(msg){
		  window.location.reload();
		}
	  })
}
</script>
				<div class="col-sm-12" style="width: 85%;margin-left:100px; margin-top: 50px;">
				<div class="row inline-from">
                <c:if test="${!empty requestScope.aItems }">
				<c:forEach items="${requestScope.aItems }" var="imgs" begin="7" end="16">
					<c:if test="${!empty imgs.bcimg }">					
					<div class="col-sm-2" style="margin:10px 10px;text-align: center;">
							
							<img onclick="ylimage(this)" class="img_q aligncenter" id="imgstep2_4" name="imgstep2_4" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="http://a.kcway.net/${imgs.bcimg}">
							<div class="col-sm-12" style="*display: inline;*zoom: 1;">
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:imgrotate('${imgs.bcimg}','1');">左转</a>	
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="downloadFile.do?fileUrl=http://a.kcway.net/${imgs.bcimg}&fileName=<%=a.nextInt(10000) %>" >下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:imgrotate('${imgs.bcimg}','2');">右转</a>					        
						    
						    <br>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="ashowpic3" href="http://a.kcway.net/${imgs.bcimg}" target="_blank">${imgs.name }</a>
						    
						    </div>
					</div>  
					</c:if>
					<c:if test="${empty imgs.bcimg }">
					<div class="col-sm-2" style="margin:10px 10px;text-align: center;">
							<a  href="javascript:void(0)" >
							<img class="img_q aligncenter" id="imgstep2_4" name="imgstep2_4" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png">
							</a>
							<div class="col-sm-12" style="*display: inline;*zoom: 1;">
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">左转</a>	
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">右转</a>					        
						    <br>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="ashowpic3" href="javascript:void(0)">${imgs.name }</a>
						    </div>
					</div>	
					</c:if>
				</c:forEach>
				</c:if>
				<c:if test="${empty requestScope.aItems }">
				    <%
				    Map map=(Map)request.getAttribute("icbcpg");
				    for(int i=8;i<=17;i++){				    				    
				    %>  
				    <div class="col-sm-2" style="margin:10px 10px;text-align: center;">
							<a  href="javascript:void(0)" >
							<img class="img_q aligncenter" id="imgstep2_4" name="imgstep2_4" data-ri="0" data-src="/kcdweb/kcway2/public/" style="width: 150px; heigth: 150px;margin-top: 30px;margin-bottom: 10px;" src="${pageContext.request.contextPath }/cskjs_css/542820357249194375.png">
							</a>
							<div class="col-sm-12" style="*display: inline;*zoom: 1;">
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">左转</a>	
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">下载</a>							
							<a style="padding: 0px 5px;" class="btn btn-warning" id="" href="javascript:void(0)">右转</a>					        
						    <br>
							<a style="padding: 0px 5px;" class="btn btn-warning" id="ashowpic3" href="javascript:void(0)"><%=map.get(i) %></a>
						    </div>
					</div>				    
				    <%} %>
				</c:if>
					</div>
					</div>
<!-- 视频
			<div id="section4" class="col-sm-10" style="width: 85%;margin-top: 50px;" >
			<div align="center" style="color:#ff8700;" >视频材料</div>		
			</div>
<div class="col-sm-10" style="margin-left:100px; margin-top: 50px;">
	<div class="row inline-from">	
<div style="width: 85%;" align="center" >				
<video  width="658" height="444"  poster="${pageContext.request.contextPath }/cskjs_css/268222262987697898.jpg"  preload="none" controls="controls">
<source src="${pageContext.request.contextPath }/cskjs_css/465.mp4" />
</video>
</div>		
									
	</div>
</div>	
-->
<script>
function icbc_carsup() {
	id=document.getElementById("id").value;
	adminid=document.getElementById("adminid").value;
	bc_status=document.getElementById("status").value;
	price_result=document.getElementById("price_result").value;
	remark=document.getElementById("remark").value;
	color_id=document.getElementById("color_id").value;
 	mem_states=document.getElementById("states").value;
 	mem_citys=document.getElementById("citys").value;
 	car_km_icbc=document.getElementById("carkm").value;
 	source_id=document.getElementById("source_id").value;
 	vincode=document.getElementById("carvin").value;
 	property_id=document.getElementById("property_id").value;
 	cardt1=document.getElementById("cardt1").value;
 	cardt2=document.getElementById("cardt2").value;
 	gear_box_id=document.getElementById("gear_box_id").value;
 	car_status=document.getElementById("car_status").value;
 	icbc_pricecs=document.getElementById("icbc_pricecs").value;
 	price_new=document.getElementById("price_new").value;
 	brid=document.getElementById("brid").value;
 	seid=document.getElementById("seid").value;
 	carid=document.getElementById("carid").value;
 	carno=document.getElementById("carno").value;
 	ppxh=document.getElementById("ppxh").value;
 	motorcode=document.getElementById("motorcode").value; 	
 	$.ajax({
		   type:"post",   
		   url:"icbc_cars.do",
		   data:{
			   id : id,
			   adminid : adminid,
			   bc_status : bc_status,
			   price_result : price_result,
			   remark : remark,
			   color_id : color_id,
			   mem_states : mem_states,
			   mem_citys : mem_citys,
			   car_km_icbc : car_km_icbc,
			   source_id : source_id,
			   vincode : vincode,
			   property_id : property_id,
			   cardt1 : cardt1,
			   cardt2 : cardt2,
			   gear_box_id : gear_box_id,
			   car_status : car_status,
			   icbc_pricecs : icbc_pricecs,
			   price_new : price_new,
			   brid : brid,
			   seid : seid,
			   carid : carid,
			   carno : carno,
			   ppxh : ppxh,
			   motorcode:motorcode
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

$(function(){
	$("#info_form").attr("onsubmit","return check()"); 
});

function setremark(obj){
	if ($("#cyly").val()!="请选择快速留言"){
		$("#remark").val($("#cyly").val());
	}
}
function check(){
	if ($("#bc_status").val()>2){
		if ($("#remark").val()==""){
			$("#remark").focus();
			alert("留言为空！");
			return false;
		}else{
			if ($("#bc_status").val()==3){
				if ($("#price_result").val()<=0){
					$("#remark").focus();
					alert("评估价不能少于等于0！");
					return false;
				}
			}	
		}
	}
	return true;
} 
function dovinapi(xtype){
	fid = $("#vincode").val();
	$.post("http://a.kcway.net/assess/manager/ajax.php?do=infofromvin",{fid:fid},function(res){
		eval("var res="+res);
		if(res.status==0){
			var tmpstr='';
			for(i in res.result ){
				tmpstr = tmpstr+res.result[i]+'  ';  //获得属性值
   			}
			$("#textvin").val(tmpstr);
		}else{
			alert(res.msg);
		}
	});	
}

function doocr(xtype){
	$.post("http://a.kcway.net/assess/manager/ajax.php?do=doocrdr",{fid:54280,type:xtype},function(res){
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
   			if (xtype==4){
   	   			$("#c_carno").val(xdata.cardno);
   	   			$("#motorcode").val(xdata.vin);
   	   			stmp = xdata.issueDate;//registerDate
   				s1 = stmp.substr(0,4)+'-'+stmp.substr(4,2)+'-'+stmp.substr(6,2);
   				//alert(s1);
	   			$("#car_days").val(s1);
   	   			$("#textxsz").val(tmpstr);
   			}else{
   				$("#textjsz").val(tmpstr);
   				$("#syrxx_item2").val(xdata.cardno);
   			}
		}else{
			alert('出错：代码-'+res.status+'\r\n出错信息：'+res.info);
		}
	});	
}

function doapi(xstep){
	var fid = trim($("#r_item6").val());
	$("#r_item6").val(fid);
	$.post("http://a.kcway.net/assess/manager/ajax.php?do=cbs",{fid:fid,xstep:xstep,gid:54280},function(res){
		eval("var res="+res);
		alert(res.Message);
		switch(xstep)
		{
		case 1:
		  break;
		case 2:
			if (res.Code==0){//
				alert("提交查询订单成功,订单ID:"+res.orderId);
				$("#cbs_orderid").val(res.orderId);
			}
		  break;
		case 3:
			break;
		case 4:
			//alert(res.Code);
			if(res.Code==1104){//
				window.location.reload();
			}
			break;
		}
	});	
}
function docbsapi(xstep){
	var fid = trim($("#vincode").val());
	$("#vincode").val(fid);
	$.post("http://a.kcway.net/assess/manager/ajax.php?do=cbs",{fid:fid,xstep:xstep,gid:54280,xtype:2},function(res){
		eval("var res="+res);
		alert(res.Message);
		switch(xstep)
		{
		case 1:
		  break;
		case 2:
			if (res.Code==0){//
				alert("提交查询订单成功,订单ID:"+res.orderId);
				$("#cbs_orderid").val(res.orderId);
			}
		  break;
		case 3:
			break;
		case 4:
			//alert(res.Code);
			if(res.Code==1104){//
				window.location.reload();
			}
		  break;
		}
	});	
}
function showreport(type){
	switch (type){
	case 0:
		if ($("#showreport").attr("data-now")=="0"){
			$("#divshowreport").hide();
			$("#showreport").attr("data-now","1");
			$("#showreport").html ( "▼");
		}else{
			$("#divshowreport").show();
			$("#showreport").attr("data-now","0");
			$("#showreport").html(  "▲");
		}
		break;
	}
}
</script>
</div>
  	<div id="section6" class="box-header with-border" style="width: 83%">
	<h3 align="center" >审核处理</h3>
    </div>
<div class="box-body" style="margin-left: -100px;">
				<div class="form-group">
					<label class="col-sm-2 control-label">API功能区</label>
					<div class="col-sm-10">
					<div class="row inline-from">
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">VIN</span>
							<input id="vincode_tmp" name="vincode_tmp" class="form-control" value="${requestScope.assess_cars.vincode }" readonly="" type="text">
							<span class="input-group-addon">
								<a style="color: #3c8dbc;" href="javascript:docbsapi(1);">API_可查？</a> 
								 | <a style="color: #3c8dbc;" href="javascript:docbsapi(2);">提交查询</a>
							</span>
						</div>
					</div>
					<div class="col-sm-4">
						<div class="input-group">
							<span class="input-group-addon">订单号</span>
							<input id="cbs_orderid" name="cbs_orderid" readonly="" class="form-control" type="text">
							<span class="input-group-addon">
								<a style="color: #3c8dbc;" href="javascript:docbsapi(3);">查询进度</a> | 
								<a style="color: #3c8dbc;" href="javascript:docbsapi(4);">获取报告</a>
							</span>
						</div>
					</div>
					</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">查博士结果(无)：
					<a href="javascript:showreport(0);">
					<span class="label label-success" id="showreport" data-now="1">▼</span>
					</a>
					</label>
					<div class="col-sm-10" style="display: none" id="divshowreport"></div>
				</div>
		   <div class="form-group" style="margin-right: 10px;">
				<label class="col-sm-2 control-label">API结果：</label>
				<div class="col-sm-10">
					<div class="row inline-from">
						<div class="col-sm-4">
							<div class="input-group">
								<span class="input-group-addon"><a style="color: #3c8dbc;" href="javascript:docbsapi(1);">API VIN</a></span>
								<textarea style="width: 100%; height: 40px" class="form-control" name="textvin" id="textvin"></textarea>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="input-group">
								<span class="input-group-addon"><a style="color: #3c8dbc;" href="javascript:docbsapi(4);">OCR行驶证</a></span>
								<textarea style="width: 100%; height: 40px" class="form-control" name="textxsz" id="textxsz"></textarea>
							</div>
						</div>						
					</div>
				</div>
			</div>
					   <div class="form-group" style="margin-right: 10px;">
				<label class="col-sm-2 control-label"></label>
				<div class="col-sm-10">
					<div class="row inline-from">
						<div class="col-sm-4">
							<div class="input-group">
								<span class="input-group-addon"><a style="color: #3c8dbc;" href="javascript:docbsapi(5);">API违章</a></span>
								<textarea style="width: 100%; height: 40px" class="form-control" name="textwz" id="textwz"></textarea>
							</div>
						</div>
						<div class="col-sm-4">
							<div class="input-group">
								<span class="input-group-addon">发动机编号</span>
								<input id="motorcode" value="${requestScope.assess_cars.motorcode }" onblur="this.value=this.value.toUpperCase()" class="form-control" name="motorcode" type="text">
							</div>
						</div>
					</div>
				</div>
			</div>
	<div class="form-group">
	<label class="col-sm-2 control-label">审核：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
				<div class="col-sm-4">
					<div class="input-group"><span class="input-group-addon">审核状态</span> 
					<select name="status" class="form-control" id="status" onchange="autoremark();">
					            <option value="0">请选择</option>
					            <option value="1" ${requestScope.assess_cars.bc_status==1?"selected='selected'":''}>草稿箱</option>
                            	<option value="2" ${requestScope.assess_cars.bc_status==2?"selected='selected'":''}>审核中</option>
                            	<option value="3" ${requestScope.assess_cars.bc_status==3?"selected='selected'":''}>评估完成</option>
                            	<option value="4" ${requestScope.assess_cars.bc_status==4?"selected='selected'":''}>回退补件</option>
                            	<option value="6" ${requestScope.assess_cars.bc_status==6?"selected='selected'":''}>撤销</option>                            
                   </select>
                   </div>
			</div>
            <div class="col-sm-3">
					<div class="input-group"><span class="input-group-addon">类型</span> 
					<input class="form-control" readonly="" value="评估" type="text"></div>
			</div>
			<div class="col-sm-3">
					<div class="input-group">
					<span class="input-group-addon">评估价格</span> 
					<input id="price_result" name="price_result" class="form-control" style="width: 95px;" value="${requestScope.assess_cars.price_result}" type="text">
					<span class="input-group-addon">元</span>
					</div>
			</div>
		  </div>
	  </div>
	</div>
	<div class="form-group"><label class="col-sm-2 control-label">留言备注说明：</label>
		<div class="col-sm-10">
			<div class="row inline-from">
				<div class="col-sm-4">
				<div class="input-group">
				<span class="input-group-addon">审核留言</span>
				<textarea style="width: 100%; height: 40px" class="form-control" name="remark" id="remark"></textarea>
				</div>
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
<div class="form-group">
<label class="col-sm-2 control-label">历次审核事件和留言：</label>
<div class="col-sm-10">
<textarea style="width: 75%; height: 200px" class="form-control" readonly="readonly">
<c:forEach items="${requestScope.bList}" var="re">${fn:substring(re.dt_add,0,19)}:状态：${re.statusremark },留言：${re.remark }
</c:forEach>
</textarea>
</div>
</div>
</div>	
</div>
		<div class="footer-wrap">
			<div class="box-footer" >
				<button type="button" class="btn btn-default" onclick="location.href='kjs_pg.do?out=1&id=${requestScope.id}&querytype=${requestScope.querytype}&size=${requestScope.size}&status=${requestScope.status}'">取消返回</button>
				<button type="button" style="margin-right: 70px;" onclick="icbc_carsup();" class="btn btn-primary pull-right">保存提交</button> 
			</div>
		</div>	
		</form>

<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" align="center" id="myModalLabel">图片预览</h4>
            </div>
            <div class="modal-body" style="height:750px;" >
            <iframe id="J_pg" width="100%" height="100%" frameborder="0"></iframe>
            (左右键控制上一张,下一张)
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</body>
</html>