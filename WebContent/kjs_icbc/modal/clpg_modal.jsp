<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<style>
		            	.flex-box{
		            		display: flex;
		            		flex-direction: column;
		            	}
		            	.flex-box div[class^='flex-row']{
		            		width: 100%;
		            	}
		            	.flex-box .flex-row{
		            		height: 35px;	
		            	}
		            	.flex-row-rhcen{
		            		display: flex;
		            		justify-content: flex-end;
		            		align-items: center;
		            	}
		            	em{
		            		cursor: pointer;
		            	}
		            	.flex-row-rhcen em{
		            		padding: 0 5px;
		            	}
		            	.flex-rowcen{
		            		flex: 1;
		            	}
		            	.text-primary em{
		            		display: block;
		            		font-size: 15px;
		            		line-height: 25px;
		            	}
	            		.text-primary .big-conte{
		            		background-color:#f7f7f7;
		            		height:auto!important; 
							height:100px; 
							display:none;
							min-height:100px;
		    				padding: 15px 0;
		    				margin: 15px 0;
		    				border-radius:10px;
		     			}
		     			.big-conte-row span{
		     				text-align: right;
		     				padding-right: 15px;
		     				line-height: 34px;
		     				width: 25%;
		     				float: left;
		     				
		     			}
		     			.big-conte-row input{
		     				float: left;
		     				width: 20%;
		     			}
		     			.big-conte-row{
		     				margin: 20px;
		     				height: 34px;
		     			}
		            </style>
		          <%
   	 request.setCharacterEncoding("utf-8");
    %>  
		          
<div class="modal-body flex-box" style="height: auto; ">
<div class="flex-row flex-row-rhcen">
<em onclick="funUnfold()" class="text-muted">全部展开</em> 
<em onclick="funClose()" class="text-muted">全部收起</em> 
</div>
<div class="flex-rowcen">
			            	<ol>
<c:forEach var="erp15" items="${requestScope.erp15}" varStatus="status">

<c:if test="${erp15.status eq '9'}">       
<li class="text-primary">
<em>${status.index+1 }.${erp15.taskname_name }：</em>
<div class="big-conte" style="display: none;">                     
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
<fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss"/>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong>${erp15.gname1 }</div>
</div>
</li>

</c:if>

 <c:if test="${erp15.status eq '10'}">    
<li class="text-primary">
<em>${status.index+1 }.${erp15.taskname_name }：</em>
<div class="big-conte" style="display: none;">             
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
<fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss"/>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong>
<fmt:formatDate value="${erp15.dt_edit}" pattern="yyyy-MM-dd HH:mm:ss"/>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong>${erp15.gname1 }</div>
<strong style="margin-left:10px;"><i>处理信息：</i></strong><br>
<div class="task_margin ng-scope" >
<a href="#clxx" data-toggle="tab" >相关信息请查看对应页签</a>
</div>                                           
</div>							  	
</li>
</c:if>

<c:if test="${erp15.status eq '11'}">
<li class="text-primary">
<em>${status.index+1 }.${erp15.taskname_name }：</em>
<div class="big-conte" style="display: none;">  
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>开始时间：</strong>
<fmt:formatDate value="${erp15.dt_add}" pattern="yyyy-MM-dd HH:mm:ss"/>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理时间：</strong>
<fmt:formatDate value="${erp15.dt_edit}" pattern="yyyy-MM-dd HH:mm:ss"/>
</div>
<div style="float:left;margin-left:20px;width:260px;" class="ng-binding">
<strong>处理人：</strong>${erp15.gname1 }</div>
<strong style="margin-left:10px;"><i>处理信息：</i></strong><br>
<!-- ngIf: taskAct.pageName!='cudp'||'_cudp'.indexOf(taskAct.pageName)<=-1 -->
<!-- ngInclude: '/modules/'+taskAct.menuCode+'/'+taskAct.pageName+'.html' -->
<div class="task_margin ng-scope"  style="border:1px solid #ccc; border-radius: 10px;background-color:#F7F7F7; padding-top:10px;">
<form name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope ng-valid-required" >
	<div class="form-group ng-scope">
		<label class="col-sm-2 control-label">审核结果</label>
		<div class="col-sm-8"> 
			<input type="radio" value="1" ${erp15.result_1_code eq '1'?"checked='checked'":'' } onchange="showradio('${erp15.id }',this.value)" id="${erp15.id }1" name="${erp15.id }1"  class="ng-pristine ng-untouched ng-valid ng-not-empty">评估完成  
			&nbsp;&nbsp;&nbsp;&nbsp;
		    <input type="radio" value="2" ${erp15.result_1_code eq '2'?"checked='checked'":'' } onchange="showradio('${erp15.id }',this.value)" id="${erp15.id }2" name="${erp15.id }2"  class="ng-pristine ng-untouched ng-valid ng-not-empty">拒绝
	    	&nbsp;&nbsp;&nbsp;&nbsp; 
		    <input type="radio" value="3" ${erp15.result_1_code eq '3'?"checked='checked'":'' } onchange="showradio('${erp15.id }',this.value)" id="${erp15.id }3" name="${erp15.id }3"  class="ng-pristine ng-untouched ng-valid ng-not-empty">回退补件
	    </div>
	</div>
	
	<div class="modal-footer">
		<div class="form-group">
		<!-- ngIf: currentUser.orgType!='HAFU' -->
		<span  class="ng-scope">
			<label class="col-sm-2 control-label">新车指导价</label>
			<div class="col-sm-3">
				<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required" >
					<input class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text" name="price_new"  value="${requestScope.pd.price_new}"><span class="input-group-addon">元</span>
				</div>
			</div> 
		</span><!-- end ngIf: currentUser.orgType!='HAFU' -->
			<label class="col-sm-2 control-label">期望评估价</label>
			<div class="col-sm-3">
				<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required" >
					<input class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text" name="icbc_pricecs"  value="${requestScope.pd.icbc_pricecs}" ><span class="input-group-addon">元</span>
				</div>
			</div> 
		</div> 
		<div class="form-group">
		<!-- ngIf: currentUser.orgType!='HAFU' --><span ng-if="currentUser.orgType!='HAFU'" class="ng-scope">
			<label class="col-sm-2 control-label">建议评估价</label>
			<div class="col-sm-3">
				<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required" >
					<input class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text"  value="" ><span class="input-group-addon">元</span>
				</div>
			</div> 
		</span><!-- end ngIf: currentUser.orgType!='HAFU' -->
			<label class="col-sm-2 control-label">最终评估价<i class="red">*</i></label>
			<div class="col-sm-3">
				<div class="input-group date ng-isolate-scope ng-not-empty ng-valid ng-valid-required" >
					<input class="form-control ng-pristine ng-untouched ng-valid ng-not-empty ng-valid-required" type="text" id="price_result" name="price_result" value="${requestScope.pd.price_result}"><span class="input-group-addon">元</span>
				</div>
			</div> 
		</div> 
		<div class="form-group">
			<label class="col-sm-2 control-label">备注</label>
			<div class="col-sm-8">
				<input class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" type="text" name="remark" value="${erp15.result_1_msg}">
			</div>
		</div> 
	</div>
	<!-- ngIf: !notUseButton --> 
	
</form>
</div>                                             
</div>							  	
</li>
</c:if>


   <c:choose>
		<c:when test="${erp15.status eq '12'}">
			<li class="text-primary">
			<em>${status.index+1}.完成</em>
			<div class="big-conte" style="display: none;">
			<div style="float:left;margin-left:20px;width:260px;" >
			<strong>完成时间：</strong>
			<fmt:formatDate value="${erp15.dt_edit}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</div>
			</div>
			</li>
		</c:when>
	    <c:otherwise>
	        <c:if test="${status.last}">
		    <jsp:include page="/kjs_icbc/model_son/starutil.jsp">
		    <jsp:param value="${erp15.dt_edit }" name="sdate"/>
		    <jsp:param value="${requestScope.sh_name}" name="sname"/>
		    <jsp:param value="${status.index+2 }" name="snum"/>
		    </jsp:include>
		    </c:if>  
	    </c:otherwise>
   </c:choose>

 
</c:forEach>							
							
							</ol>
		            	</div>
		            	<script>
                       function showradio(id,value) {
		            	    	switch(value){
		            	    	  case "1":
		            	    		  $("#"+id+"2").removeAttr("checked");
		            	    		  $("#"+id+"3").removeAttr("checked");
		            	    	   break;
		            	    	  case "2":
		            	    		  $("#"+id+"3").removeAttr("checked");
		            	    		  $("#"+id+"1").removeAttr("checked");
		            	    	   break;
		            	    	  case "3":
		            	    		  $("#"+id+"1").removeAttr("checked");
		            	    		  $("#"+id+"2").removeAttr("checked");
		            	    	   break;
		            	    	  default:
		            	    	   break;
		            	    	 }
		            	    };
		            
		            		$(".text-primary em").click(function(){
		            			$(this).next(".big-conte").slideToggle();
		            		})
		            		//全部展开
		            		function funUnfold(){
		            			$(".big-conte").slideDown();
		            		}
		            		//全部关闭
		            		function funClose(){
		            			$(".big-conte").slideUp();
		            		}
		            	</script>
		            	<div class="flex-row flex-row-rhcen">
		            		<em onclick="funUnfold()" class="text-muted">全部展开</em> 
		            		<em onclick="funClose()" class="text-muted">全部收起</em> 
		            	</div>
		            </div>