<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.model1.icbc.erp.PageData"%>
<%@page import="com.util.pagedate"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="content-wrapper" style="min-height: 943px;">
<script type="text/javascript">
    function a3(){
		var s=$("#page_limit_select").val();
		var status=$("#status").val();
		var querytype=$("#querytype").val();		
		window.location.href ="${pageContext.request.contextPath}/matEndiwmentResultControoller/select.do?type=wlghd&dn=compensatoryaffirm&qn=list&pagesize="+s+"&pagenow=1";
    }
    
    function reset(){
    	$('#myform')[0].reset()
    }
    
    function tk(){
    	alert("已发送同意代偿申请")
    }
    
   var submit=function(a,b){
    	$.ajax({
    		type: "POST",
            url: "${pageContext.request.contextPath }/matEndiwmentResultControoller/addAgree.do",
            data: {c_cardno:a,periods:b},
            success:function(data){
            	location.reload(true);
            }
    	})
   }
    </script>

		
		<!-- Main content -->
		<section class="content">
			
		<div id="main_list" class="admin-content box">
			<!-- 数据载入中 请在搜索，筛选，载入的时候显示 放在.box里 -->
			<div class="overlay" style="display:none;">
				<i class="fa fa-refresh fa-spin"></i>
			</div>
			<!-- 数据载入中结束 -->
			<table class="table table-bordered table-hover">
				<tbody>	
					<tr>
						<th style="width:3%" class="text-center hidden-xs"><input class="check_all" type="checkbox"></th>
						<th class="text-center hidden-xs">还款期数</th>
						<th class="text-center hidden-xs">逾期发生日期</th>
						<th class="text-center">逾期天数</th>
						<th class="text-center">申请代偿日期</th>
						<th class="text-center">已代偿日期</th>
						<th class="text-center">垫款金额</th>
						<th class="text-center" >状态</th>											
						<th class="text-center" >操作</th>
					</tr>
					 <c:forEach var="matMap" items="${matMap }"> 
					<tr>
						<td class="text-center hidden-xs">
						<input name="delid"  type="checkbox">
						</td>
						<td class="text-center hidden-xs">
							第${matMap.repayment_periods }期
						</td>
						<td class="text-center hidden-xs">
							${fn:substring(matMap.overdue_date,0,19) }
						</td>
						<td class="text-center">
							<span class="s-font-blue">
								${matMap.overdue_days}
							</span>
						</td>
						<td class="text-center">
							${fn:substring(matMap.apply_compensatory,0,19)}
						</td>
						<td class="text-center">
							<p>
								${fn:substring(matMap.compensatory_date,0,19) }
							</p>
						</td>
						<td class="text-center">
							<p>
								${matMap.advances_amount }
							</p>
						</td>
						
					<td class="text-center">					
							<p>
						${matMap.compensatory_state }
							</p>						
						</td>
					
						<td class="text-center">
							<c:if test="${matMap.compensatory_state == '正在处理'}">
								<a  href="javascript:void(0);" onclick="submit('${matMap.confirm_idCard }','${matMap.repayment_periods}')">
									<i class="fa fa-hand-paper-o"></i>
								</a>
							</c:if>
							<c:if test="${matMap.compensatory_state == '已同意申请'}">
								<a href="javascript:void(0);">
									<i class="fa fa-hand-paper-o" onclick="tk()"></i>
								</a>
							</c:if>
						</td>				
					</tr>
				 </c:forEach> 
				</tbody>
			</table>
			
		</div>
		
			
	</section>
	<!-- /.content -->
</div>


