<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
* { margin: 0; padding: 0;}
#sucaihuo { width: 700px; margin: 0 auto; font-size: 0;}
#sucaihuo li { display: inline-block; width: 32%; margin-left: 1%; padding-top: 1%;}
#sucaihuo li img { width: 100%;}
/* .modal-dialog { 
    position: absolute; 
    top: 0; 
    bottom: 0; 
    left: 0; 
    right: 0; 
}  */

/* .modal-content { 
    /*overflow-y: scroll; */ 
    position: absolute; 
    top: 0; 
    bottom: 0; 
    width: 100%; 
}  */

/* .modal-body { 
    overflow-y: scroll; 
    position: absolute; 
    top: 55px; 
    bottom: 65px; 
    width: 100%; 
}  */

/* .modal-header .close {margin-right: 15px;} 

.modal-footer {
    position: absolute; 
    width: 100%; 
    bottom: 0;  */
}
</style>
<form name="" class="form-horizontal">

       <script>
		   $(document).ready(function(){
			  
			fun2(document.getElementById("pg_brid").value);
			
		   });
			function fun2(selectedBrid){
/* 				alert(selectedBrid); */
				//第一个
				var s = "<option value='0'>**品牌**</option>"; 
			   	$.ajax({ 
			   		url:"${pageContext.request.contextPath}/getAllCarBrand.do",
			   	    type:"POST",
			           success: function(dataCarBrand){
			           	 var con = "";  
			           	$("#brid1").empty();
			           	 $.each($.parseJSON(dataCarBrand),function(index,carBrand){
			           		
			           		if(carBrand.id==selectedBrid){
			           			con += "<option  selected='selected' value="+carBrand.id+">"+carBrand.first+" "+carBrand.name+"</option>";
			           		}else{
			           			con += "<option  value="+carBrand.id+">"+carBrand.first+" "+carBrand.name+"</option>";	        			
			           		}
			           	 });
			           	$("#brid1").append(s+con);
			           }
			    });
			   	fun(selectedBrid);
			}
			
			function fun(selectedBrid){
				//第二个
			    
			   	var selectedSeid ='${pd.seid}';
			   	
			   	if(selectedBrid!=0){
				$.ajax({ 
					url:"${pageContext.request.contextPath}/getCarSeries.do",
					data:{brid:selectedBrid},
				    type:"POST",
				       success: function(dataCarSeries){
				       	var con = "<option value='0'>**车系**</option>"; 
				       	$("#seid1").empty();
				       	 $.each($.parseJSON(dataCarSeries),function(index,carSeries){
				       		if(selectedSeid==carSeries.id){
				       		 	con += "<option selected='selected' value="+carSeries.id+">"+carSeries.name+"</option>";	       		    
				       		}else{
				       			con += "<option  value="+carSeries.id+">"+carSeries.name+"</option>";
				       		}				       	
				       	 });	       	
				       	$("#seid1").append(con);
				       	fun3(document.getElementById("seid1").value);	
				       }
				 });	
				
			   	}
			}
			
			function fun3(selectedSeid){
				var selectedcarid ='${pd.carid}'; 
				if(selectedSeid!=0){
				//第三个
				$.ajax({ 
					url:"${pageContext.request.contextPath}/getCarModel.do",
					data:{seid:selectedSeid},
				    type:"POST",
			        success: function(dataCarModel){
			        	var con = "<option value='0'>**型号**</option>"; 
			        	$("#carid1").empty();
			        	 $.each($.parseJSON(dataCarModel),function(index,carModel){
			        		 if(selectedcarid==carModel.id){
			 	       		 	con += "<option selected='selected' value="+carModel.id+">"+carModel.name+"</option>";
			 	       		}else{
			 	       		    con += "<option  value="+carModel.id+">"+carModel.name+"</option>"; 
			 	       		}       			 
			        	 });        	
			        	$("#carid1").append(con);
			        }
				}); 	
				}
			}
		   </script>
 <div style="border:1px solid #478FCA;   margin:5px; padding:20px;border-radius: 10px;">
		   
		   <div class="form-group">
			<label class="col-sm-2 control-label">关联客户<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input name="icbc_name" id="icbc_name" class="form-control"  value="${pd.c_name }" type="text">
		    </div>
			<label class="col-sm-2 control-label">国产/进口<i class="red">*</i></label>
			<div class="col-sm-3">
	      		<select id="source_id" name="source_id" class="form-control">
								 <option value="0">请选择</option>
								 <option value="1" ${pd.source_id eq '1'?"selected='selected'":''}>国产</option>
								<option value="2" ${pd.source_id eq '2'?"selected='selected'":''}>进口</option>								
								</select>	
			</div>
		</div>
		   <div class="form-group">
			<label class="col-sm-2 control-label">车辆类型<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<select id="cars_type" name="cars_type" class="form-control">
								 <option value="0">请选择</option>
								 <option value="1" ${pd.cars_type eq '1'?"selected='selected'":''}>新车</option>
								<option value="2" ${pd.cars_type eq '2'?"selected='selected'":''}>二手车</option>								
								</select>	
		    </div>
			<label class="col-sm-2 control-label">使用性质<i class="red">*</i></label>
			<div class="col-sm-3">
	      		<select id="property_id" name="property_id" class="form-control">
								 <option value="0">请选择</option>
								 <option value="1" ${pd.property_id eq '1'?"selected='selected'":''}>运营</option>
								<option value="2" ${pd.property_id eq '2'?"selected='selected'":''}>非运营</option>								
								</select>	
			</div>
		</div>
		 <div class="form-group">
			<label class="col-sm-2 control-label">车辆状况<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<select id="car_status" name="car_status" class="form-control">
								 <option value="0">车辆状况</option>
								 <option value="1" ${pd.car_status eq '1'?"selected='selected'":''}>优秀</option>
								 <option value="2" ${pd.car_status eq '2'?"selected='selected'":''}>良好</option>
								 <option value="3" ${pd.car_status eq '3'?"selected='selected'":''}>一般</option>
								</select>
		    </div>
			<label class="col-sm-2 control-label">变速箱<i class="red">*</i></label>
			<div class="col-sm-3">
	      		<select id="gear_box_id" name="gear_box_id" class="form-control">
								 <option value="0">车辆状况</option>
								 <option value="1" ${pd.gear_box_id eq '1'?"selected='selected'":''}>自动</option>
								 <option value="2" ${pd.gear_box_id eq '2'?"selected='selected'":''}>手动</option>
								
				</select>
			</div>
		</div>
		<div class="form-group">
			<label class="col-sm-2 control-label">品牌车型<i class="red">*</i></label>
	  		<div class="col-sm-2">
			<input id="pg_brid" name="pg_brid" type="hidden" value="${pd.brid }" />
			<select id="brid1" name="brid1" onchange="fun(this.options[this.options.selectedIndex].value)" class="form-control">	 
			<option value="0">**品牌**</option>
			</select>	
		    </div>
			<input id="pg_seid" name="pg_seid" type="hidden" value="${pd.seid }" />
			<div class="col-sm-3">
	      		<select id="seid1" name="seid1" onchange="fun3(this.options[this.options.selectedIndex].value)" class="form-control">		 
				<option value="0">**车系**</option>
				</select>
			</div>
			<input id="pg_carid" name="pg_carid" type="hidden" value="${pd.carid }" />
			<div class="col-sm-3">
	      	<select id="carid1" name="carid1" class="form-control">		
	      	<option value="0">**型号**</option>	 
			</select>	
			</div>
		</div>
			<div class="form-group">
			<label class="col-sm-2 control-label">行驶里程(公里)<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input name="car_km_icbc" id="car_km_icbc" class="form-control"  value="${pd.car_km_icbc }" type="text">		
		    </div>
			<label class="col-sm-2 control-label">出厂日期<i class="red">*</i></label>
	  		<div class="col-sm-3">
            <div class="input-group date ng-isolate-scope ng-not-empty ng-valid">
			<input class="form-control" placeholder="请选择日期" id="cardt1" name="cardt1" value="<fmt:formatDate value='${pd.cardt1}' pattern='yyyy-MM-dd' />" type="text">
			<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
			</div>
		    </div>
		    </div>
		    <div class="form-group">
			<label class="col-sm-2 control-label">初次登记日期<i class="red">*</i></label>
	  		<div class="col-sm-3">
	  		<div class="input-group date ng-isolate-scope ng-not-empty ng-valid">
			<input class="form-control" placeholder="请选择日期" id="cardt2" name="cardt2" value="<fmt:formatDate value='${pd.cardt2}' pattern='yyyy-MM-dd' />" type="text">
			<span class="input-group-addon"><i class="fa fa-calendar"></i></span>
			</div>
		    </div>
			<label class="col-sm-2 control-label">车辆颜色<i class="red">*</i></label>
	  		<div class="col-sm-3">
								<select name="color_id" id="color_id" class="form-control">
                                <option value="">请选择车身颜色</option>
								<option value="1" ${pd.color_id eq '1'?"selected='selected'":''}>黑</option>
								<option value="2" ${pd.color_id eq '2'?"selected='selected'":''}>白</option>
								<option value="3" ${pd.color_id eq '3'?"selected='selected'":''}>灰</option>
								<option value="4" ${pd.color_id eq '4'?"selected='selected'":''}>红</option>
								<option value="5" ${pd.color_id eq '5'?"selected='selected'":''}>银</option>
								<option value="6" ${pd.color_id eq '6'?"selected='selected'":''}>蓝</option>
								<option value="7" ${pd.color_id eq '7'?"selected='selected'":''}>金</option>
								<option value="8" ${pd.color_id eq '8'?"selected='selected'":''}> 棕</option>
								<option value="9" ${pd.color_id eq '9'?"selected='selected'":''}> 橙</option>
								<option value="10" ${pd.color_id eq '10'?"selected='selected'":''}> 黄</option>
								<option value="11" ${pd.color_id eq '11'?"selected='selected'":''}> 紫</option>
								<option value="12" ${pd.color_id eq '12'?"selected='selected'":''}> 绿</option>
								<option value="13" ${pd.color_id eq '13'?"selected='selected'":''}> 褐</option>
								<option value="14" ${pd.color_id eq '14'?"selected='selected'":''}> 栗</option>
								<option value="15" ${pd.color_id eq '15'?"selected='selected'":''}> 米</option>
								<option value="16" ${pd.color_id eq '16'?"selected='selected'":''}>银灰</option>
								<option value="17" ${pd.color_id eq '17'?"selected='selected'":''}> 青</option>
								<option value="18" ${pd.color_id eq '18'?"selected='selected'":''}> 香槟</option>
								<option value="19" ${pd.color_id eq '19'?"selected='selected'":''}> 咖啡</option>
								<option value="20" ${pd.color_id eq '20'?"selected='selected'":''}> 天山</option>
								<option value="0" ${pd.color_id eq '0'?"selected='selected'":''}>其他色</option>								
				                </select>
		    </div>
		    </div>
		     <div class="form-group">
			<label class="col-sm-2 control-label">上牌地址<i class="red">*</i></label>
	  		<div class="col-sm-4">
			<input type="hidden" name="mem_states1" id="mem_states1"  value="${pd.mem_states }"  />
								<select name="mem_states" id="mem_states" onchange="citys1(this.options[this.options.selectedIndex].value)" class="form-control">
								 <option>省</option>
								</select>		
		    </div>
		    <div class="col-sm-4">
			<input type="hidden" name="mem_citys1" id="mem_citys1"  value="${pd.mem_citys }"  />
								<select name="mem_citys" id="mem_citys" class="form-control">
								 <option>市</option>
								</select>			
		    </div>
			
		    </div>
		    <div class="form-group">
			<label class="col-sm-2 control-label">原车主姓名<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="" name="" value="${pd.oldowner}"  class="form-control" type="text" />		
		    </div>
		    <label class="col-sm-2 control-label">原车牌号<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="c_carno" name="c_carno" value="${pd.c_carno}"  class="form-control" type="text" />		
		    </div>
		    </div>
		    <div class="form-group">
			<label class="col-sm-2 control-label">车架号<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="vincode" name="vincode" value="${pd.vincode }" class="form-control" type="text" />	
		    </div>
		    <label class="col-sm-2 control-label">品牌型号<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="ppxh" name="ppxh" value="${pd.ppxh }" class="form-control" type="text" />		
		    </div>
		    </div>
		    <div class="form-group">
			<label class="col-sm-2 control-label">发动机号<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="motorcode" name="motorcode" value="${pd.motorcode }" class="form-control" type="text" />
		    </div>
		    <label class="col-sm-2 control-label">预期价格(元)<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="icbc_pricecs" name="icbc_pricecs" value="${pd.icbc_pricecs }" class="form-control" type="number" />	
		    </div>
		    </div>
		    <div class="form-group">
			<label class="col-sm-2 control-label">新车指导价(元)<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="price_new" name="price_new" value="${pd.price_new }"  class="form-control" type="number" />
		    </div>
		    <label class="col-sm-2 control-label">最终评估价(元)<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="price_result" name="price_result" value="${pd.price_result }"  class="form-control" type="number" />	
		    </div>
		    </div>
		    <div class="form-group">
			<label class="col-sm-2 control-label">现车牌号<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="price_result" name="price_result" value=""  class="form-control" type="text" />
		    </div>
		    <label class="col-sm-2 control-label">登记证书编号<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="" name="" value=""  class="form-control" type="text" />
		    </div>
		    </div>
		    <div class="form-group">
			<label class="col-sm-2 control-label">购车发票号<i class="red">*</i></label>
	  		<div class="col-sm-3">
			<input id="" name="" value=""  class="form-control" type="text" />
		    </div>
		    </div>
		     <div class="form-group">
			<label class="col-sm-2 control-label"></label>
	  		<div class="col-sm-4">
			<a  onclick="EditViewById()"  class="btn btn-primary ng-binding" >查看车辆材料</a>
		    </div>
		    <div class="col-sm-4">
			<%-- <a href="javascript:void(0)${pd.carsid }"  class="btn btn-primary ng-binding" >一键下载车辆材料</a> --%>
		    <a href="${pageContext.request.contextPath}/erp/downloadFile_all.do?type=clpg&id=${pd.id}&base_name=汽车评估材料"  class="btn btn-primary ng-binding">一键下载车辆材料</a>
		    </div>
		    </div>
		    </div>
		    <script>
lay('#version').html('-v'+ laydate.v);
//执行一个laydate实例
laydate.render({
  elem: '#cardt1' //指定元素
});
lay('#version').html('-v'+ laydate.v);
//执行一个laydate实例
laydate.render({
elem: '#cardt2' //指定元素
});
</script>
	        <script>
				$(document).ready(function(){
					var stateid=document.getElementById("mem_states1").value;
				$.ajax({ 	
						url:"${pageContext.request.contextPath }/finfdstates.do",
					    type:"POST",
					    dataType: "json",
				       success: function(msg){
				       	 var con = "<option value=''>所在省</option>"; 
				       	$("#mem_states").empty();
				       	$.each(msg,function(index, n){
				       	  if(stateid==msg[index].id){
				       		con += "<option selected='selected' value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";  
				       	  }else{
				       		con += "<option  value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>"; 
				       	  }
				       	});           	
				       	$("#mem_states").append(con);
				       	
				       }
				
				});
				if(stateid!=null&&stateid!=""){
					 citys1(stateid);
				}else{
					citys1('24');
				}
				  
				});
				function citys1(cityid){
					var cityid1=document.getElementById("mem_citys1").value;
					$.ajax({ 	
						url:"${pageContext.request.contextPath }/fincitys.do",
					    type:"POST",
					    dataType: "json",
					    data :{
					    	state_id : cityid
					    },
				       success: function(msg){
				       	 var con = "<option value=''>所在市</option>";         	  
				       	$("#mem_citys").empty();
				       	$.each(msg,function(index, n){
				       		if(cityid1==msg[index].id){
					       		con += "<option selected='selected' value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>";  
					       	  }else{
					       		con += "<option  value="+msg[index].id+">"+msg[index].chrkey+" "+msg[index].name+"</option>"; 
					       	  }	        			   	      		
				       	 });           	
				       	$("#mem_citys").append(con);      	
				       }
				});
				}
				
				/* 查看详情 */
			 	function EditViewById(){
			    	   $('#carsModal').modal('show');
				}
				
			 	$(function () { $('#cars_imgModal').on('hide.bs.modal', function () {
			 		 if($('body').hasClass('modal-open')){
			 			
			 		}else{
			 			$('#carsModal').modal('show');	
			 		}
			 		 });
			 		 });
			 	function carsimage(obj){
			 		$('#carsModal').modal('hide');
			 		//alert(obj);
			 		if(obj!=0){
			 		var $img = $(obj),
			 			imgUrl = $img[0].src;
			 		}
			 		var activeIndex=0;
			 		var imgs = [];
			 		$(".cars").each(function(i,elem){
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
			 	    $("#cars_img_pg").attr("src","${pageContext.request.contextPath}/jquery-photo-gallery/gallerys.jsp");
			 	     //显示模态框  只有在选择编辑的行   然后根据回调函数成功后才会显示模态框
			 	    $('#cars_imgModal').modal({ show: true, backdrop: 'static' });
			 	}
				</script>
<!-- 模态框（Modal） -->
<div class="modal fade" id="carsModal"  tabindex="-1" role="dialog" aria-labelledby="carsModalLabel" aria-hidden="true" >
    <div class="modal-dialog" style="width: 800px;height: 800px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="carsModalLabel">相关材料</h4>
            </div>
            <div  class="modal-body">
            <div id="" class="row">
            <c:forEach var="pg" items="${requestScope.img_pList}" varStatus="status">
            <c:if test="${!empty pg.bcimg}">
                  <div class="col-sm-6 col-md-3">
                  <div class="thumbnail">
                  <img class="cars" id="" name="" onclick="carsimage(this)" style="width: 200px;height: 200px;" src="http://a.kcway.net/${pg.bcimg}">
                  </div>
                  </div>
            </c:if>
            </c:forEach>
            </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>				
<div class="modal fade" id="cars_imgModal" tabindex="-1" role="dialog" aria-labelledby="cars_imgModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" align="center" id="cars_imgModalLabel">图片预览</h4>
            </div>
            <div class="modal-body" style="height:750px;">
            <iframe id="cars_img_pg" width="100%" height="100%" frameborder="0"></iframe>
            (左右键控制上一张,下一张)
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</form>
<%-- <c:if test="${requestScope.type!='wdrw' }">
<div class="modal-footer">
<button onclick="location.href='${pageContext.request.contextPath}/erp/user_list_.do?type=wlghd&dn=${requestScope.cn }&qn=list&pagesize=10&pagenow=1'" class="btn btn-warning" >取消</button>
<button onclick="location.href=''" class="btn btn-primary" >提交</button>
</div>	
</c:if> --%>		
