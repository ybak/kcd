<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="content-wrapper" style="min-height: 943px;padding-right:30px; padding-left: 30px;">
	<script type="text/javascript">
    
    
    function tk(){
    	alert("已发送代偿申请")
    }
    
    function submit(a,b){
    	$.ajax({
    		type: "POST",
            url: "${pageContext.request.contextPath }/lendingResultController/addlendingResult.do",
            data: {c_cardno:a,periods:b},
            success:function(data){
            		alert("发送成功");                  
                    location.reload(true);

            }
    	})
    }
    
    </script>
	
	<section class="content">			
	
		<!-- 数据载入中 请在搜索，筛选，载入的时候显示 放在.box里 -->
		<div class="overlay" style="display:none;">
			<i class="fa fa-refresh fa-spin"></i>
		</div>	
	<div class="box" style="margin-top:10px;">
		<!-- 数据载入中结束 -->
		<table class="table table-bordered table-hover">
	    	<tr>
				<th class="text-center">还款期数</th>
				<th class="text-center">应还日期</th>
				<th class="text-center">应还金额</th>
				<th class="text-center">代偿金额</th>
				<th class="text-center">合作商代偿金额</th>
				<th class="text-center">申请代偿日期</th>
				<th class="text-center">已代偿日期</th>
				<th class="text-center" >状态</th>	
				<th class="text-center" >操作</th>
			</tr>	
			<c:forEach items="${detailList}" var="detail">
		    <tr>
				<td class="text-center">第${detail.repayment_periods }期</td>   
				<td class="text-center">${detail.zc_time }</td>   
				<td class="text-center">${detail.myyh }</td>
				<td class="text-center">${detail.overdue_amount }</td>
				<td class="text-center">${detail.overdue_amount }</td>
				<td class="text-center">${detail.apply_compensatory}</td>
				<td class="text-center">${detail.compensatory_date }</td>
				<td class="text-center">					
					<p>${detail.compensatory_state }</p>
				</td>
				<td class="text-center">						
					<c:if test="${detail.compensatory_state == '未还'}">
					<a class="bottom-btn" onclick="submit('${detail.id_card}','${detail.repayment_periods}')" href="javascript: void(0);">
						<i class="fa fa-hand-paper-o"></i>
					</a>
					</c:if>
					<c:if test="${detail.compensatory_state == '正在处理'}">
					<a href="javascript:void(0);">
						<i class="fa fa-hand-paper-o" onclick="tk()"></i>
					</a>
					</c:if>
					<c:if test="${detail.compensatory_state == '已同意申请'}">
					<a href="javascript:void(0);">
						<i class="fa fa-hand-paper-o"></i>
					</a>
					</c:if>
				</td>				
		    </tr>
		   </c:forEach>
       </table>
     </div>
     </section>
 </div>
	

				
