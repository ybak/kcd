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
                         <div class="modal-body flex-box" style="height: auto; ">
		            	<div class="flex-row flex-row-rhcen">
		            		<em onclick="funUnfold()" class="text-muted">全部展开</em> 
		            		<em onclick="funClose()" class="text-muted">全部收起</em> 
		            	</div>
		            	<div class="flex-rowcen">
			            	<ol>
			            	 <c:forEach var="pd" items="${requestScope.pList }">
							  <li class="text-primary">
							  	<em>${pd.tname }</em>
							  	<div class="big-conte" style="display: none;">
							  		<div class="big-conte-row">
							  			<span class="text-muted">开始时间:<fmt:formatDate value="${pd.icbc_dt_add}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
								  		<span class="text-muted">处理时间:<fmt:formatDate value="${pd.dt_edit }" pattern="yyyy-MM-dd HH:mm:ss"/></span>
							  		</div>
							  		
							  	</div>
							  </li>
							  </c:forEach>
						
							  
							</ol>
		            	</div>
		            	<script>
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