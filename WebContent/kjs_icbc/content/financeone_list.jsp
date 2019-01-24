<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="content-wrapper" style="min-height: 943px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
			银行贷款<small>
			共${requestScope.totalsize}个
			</small>
			</h1>
		</section>

		<!-- Main content -->
		<section class="content">

			<div class="admin-tools">
				<div class="row">
<div class="col-sm-10 admin-button">
<div class="btn-group">		
<script type="text/javascript">
$(document).ready(function(){
	var con="<option value=''>***业务类型***</option>";
	$.post("${pageContext.request.contextPath }/erp/ywlxname.do",
			function(result){
		     $("#ywlx").empty();
		 $.each(result, function(index, item){
		       con += "<option  value="+item.id+">"+item.name+"</option>";       			   	      		
	       	 });           	
	       	 $("#ywlx").append(con);  		
			},'json');
})
</script>
<form action="" class="form-horizontal" >
<input style="display:none">
<label>
业务类型
<select  id="ywlx" name="ywlx" onchange="window.location.href='${pageContext.request.contextPath }/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&cn=${requestScope.cn }&ywlx_id='+this.value" class="form-control form-inline hidden-xs">
	<option value="">--业务类型--</option>
</select>
</label>	
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<label>
搜索功能
</label>
<input onkeydown="javascript:if(event.keyCode==13)selectByC_name();" id="getC_name" type="text" placeholder="请输入客户名字或客户身份证号或车牌号或车辆VIN码" class="form-control ng-pristine ng-untouched ng-valid ng-not-empty" style="width:500px;">
<button onclick="selectByC_name()" class="btn btn-info search-btn" type="button" style="background-color:#00acd6;">查询</button>
<button onclick="btn()" class="btn btn-info search-btn" type="button" style="background-color:#00acd6;" data-toggle="modal" data-target="#myModal">导出</button>	
	
	<div class="modal fade" id="addModal_tdtf" tabindex="-1" role="dialog" aria-labelledby="addModal_nstrLabel" aria-hidden="true">
	    <div class="modal-dialog modal-lg">
	        <div class="modal-content">
	            <div class="modal-header">
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	                <h4 class="modal-title" align="center" id="aayyclModalLabel">导出</h4>
	            </div>
	            <div class="modal-body" style="height:450px;border:1px solid #ccc;background-color:#F7F7F7;border-radius: 10px;margin:30px;">
	             <!-- 模态框插入内容 start -->
	             		<li class="text-primary" >
						<div class="big-conte_">  
						<div class="task_margin ng-scope"  style="  padding-top:10px;padding-left:50px;">
						<form id="tdtfsh_97" enctype="multipart/form-data" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
								 
								 <div class="form-group">
									<label class="col-sm-2 control-label" style="text-align:left;">合作机构:</label>
									<div class="col-sm-4">
										<select  style="margin-left:-35px;" id="Institutions" name="" class="form-control">
											<option value="0">请选择</option>
											<c:forEach items="${Institutions}" var="keyword">
										     	<option>${keyword}</option>
										     </c:forEach>
										</select>
									</div>
									<label class="col-sm-2 control-label" style="text-align:left;">银行:</label>
									<div class="col-sm-4">
										<select  style="margin-left:-60px;" id="Bank" name="" class="form-control">
											<option value="0">请选择银行</option>
											<c:forEach items="${Bank}" var="keyword">
										     	<option>${keyword}</option>
										     </c:forEach>					
										</select>
									</div>
								 </div>
								<div class="form-group">
									<label class="col-sm-2 control-label" style="text-align:left;">导出字段:</label>
									<div class="controler" style="padding-top:8px;margin-left:-35px;"> 
									<input type="checkbox" name="favorite" value="1dt_add00" style="margin-left:-20px;"> ${QueryField[0]} &emsp;
									<input type="checkbox" name="favorite" value="1gems_code01"> ${QueryField[1]} &emsp; &emsp;
									<input type="checkbox" name="favorite" value="1y_name02"> ${QueryField[2]} &emsp; &emsp;
									<input type="checkbox" name="favorite" value="1loan_tpid03"> ${QueryField[3]} &emsp; &emsp;
									<input type="checkbox" name="favorite" value="2a_name04"> ${QueryField[4]} &emsp; 
									</div>
									<div class="controler" style="padding-top:8px;margin-left:-45px;"> 
									<input type="checkbox" name="favorite" value="2loan_level05" style="margin-left:153px;"> ${QueryField[5]} &emsp; &emsp;
									<input type="checkbox" name="favorite" value="2s_name06" style="margin-left:28px;"> ${QueryField[6]} &emsp; 
									<input type="checkbox" name="favorite" value="2s_c_name07"> ${QueryField[7]} &emsp; 
									<input type="checkbox" name="favorite" value="3manager08"> ${QueryField[8]} &emsp; &emsp;
									<input type="checkbox" name="favorite" value="4c_name09"> ${QueryField[9]} &emsp; 
									</div>
									<div class="controler" style="padding-top:8px;margin-left:-45px;"> 
									<input type="checkbox" name="favorite" value="4c_tel10" style="margin-left:153px;"> ${QueryField[10]} &emsp; 
									<input type="checkbox" name="favorite" value="4c_cardno11" style="margin-left:28px;"> ${QueryField[11]} &emsp; 
									<input type="checkbox" name="favorite" value="5cars_type12"> ${QueryField[12]} &emsp; &emsp;&emsp;
									<input type="checkbox" name="favorite" value="5cars_name13"> ${QueryField[13]} &emsp; 
									<input type="checkbox" name="favorite" value="5sp_name14"> ${QueryField[14]} &emsp; 
									</div>
									<div class="controler" style="padding-top:8px;margin-left:-45px;"> 
									<input type="checkbox" name="favorite" value="6kk_loan_amount15" style="margin-left:153px;"> ${QueryField[15]} &emsp; 
									<input type="checkbox" name="favorite" value="6kk_loan_amount_s16"> ${QueryField[16]} &emsp; 
									<input type="checkbox" name="favorite" value="6kk_loan_amount+kk_loan_amount_s17"> ${QueryField[17]} &emsp; &emsp;&emsp;
									<input type="checkbox" name="favorite" value="6kk_loan_ajqx18"> ${QueryField[18]} &emsp; 
									</div>
									<div class="controler" style="padding-top:8px;margin-left:-45px;"> 
									<input type="checkbox" name="favorite" value="6kk_loan_rate19" style="margin-left:153px;"> ${QueryField[19]} &emsp; 
									<input type="checkbox" name="favorite" value="6principalAndInterest20"> ${QueryField[20]} &emsp; &emsp;&emsp;&emsp;
									<input type="checkbox" name="favorite" value="6MonPayments21"> ${QueryField[21]} &emsp; &emsp;
									<input type="checkbox" name="favorite" value="6marketrate22"> ${QueryField[22]} &emsp; 
									</div>
								</div> 		
							<!-- ngIf: !notUseButton -->
						</form>
						</div>                                             
						</div>	
						
						<div class="big-conte_" style="border-top:1px solid #f4f4f4;">  
						<div class="task_margin ng-scope"  style="  border-radius: 10px; padding-top:10px;padding-left:50px;">
						<form id="tdtfsh_97" enctype="multipart/form-data" name="modalForm" class="form-horizontal ng-pristine ng-valid ng-scope">
								 
								 <div class="form-group">
									<label class="col-sm-2 control-label" style="text-align:left;">银行审核时间:</label>
									<div class="col-sm-4" style="">
										<div class="form-control" style="margin-left:-35px;"> 
											<div id="reportrange" > 
											<span id="searchDateRange"></span> 
											<b class="caret"></b> 
											</div> 
										</div>
									</div>
									<label class="col-sm-2 co
									ntrol-label" style="text-align:left;">征信申请时间:</label>
										<div class="col-sm-4">
											<div class="form-control" style="margin-left:-35px;"> 
											<div id="reportrange1" > 
											<span id="searchDateRange1"></span> 
											<b class="caret"></b> 
											</div> 
										</div>
										</div>
								 </div>
								 <div class="form-group">
									 
								</div>
								<div class="form-group">
									<label class="col-sm-2 control-label" style="text-align:left;">业务团队:</label>
									<div class="col-sm-4">
										<select  style="margin-left:-35px;" id="" name="" class="form-control">
											<option value="0">请选择业务团队</option>
											<option value="1" ${requestScope.pd.loan_level eq '1'?"selected='selected'":''}>预期贷款额10万以下（含10万）</option>
											<option value="2" ${requestScope.pd.loan_level eq '2'?"selected='selected'":''}>预期贷款额10万以上</option>							
										</select>
									</div>
									<label class="col-sm-2 control-label" style="text-align:left;">银行:</label>
									<div class="col-sm-4">
										<select  style="margin-left:-60px;" id="" name="" class="form-control">
											<option value="0">请选择银行</option>
											<option value="1" ${requestScope.pd.loan_level eq '1'?"selected='selected'":''}>预期贷款额10万以下（含10万）</option>
											<option value="2" ${requestScope.pd.loan_level eq '2'?"selected='selected'":''}>预期贷款额10万以上</option>							
										</select>
									</div>
								 </div> 		
							<!-- ngIf: !notUseButton -->
						</form>
						</div>                                             
						</div>
												  	
						</li>
						
						<div class="modal-footer" style="margin-top:10px;">
							<button class="btn btn-warning" style="color: #00CED1">取消</button>
							<button onclick="exportExcel()" type="button" class="btn btn-primary" style="color: #00CED1">提交</button>	
						</div>
				 <!-- 模态框插入内容 end -->
				</div>
	            <div class="modal-footer">
	                <button type="button" id="closet" class="btn btn-default" data-dismiss="modal">关闭</button>
	            </div>
	        </div>
	    </div>
	</div>
						        
<script type="text/javascript">

	function btn(){
		$('#addModal_tdtf').modal({ show: true });
	}

</script>

<script type="text/javascript">
    $(document).ready(function (){
        //时间插件
        $('#reportrange span').html(moment().subtract('hours', 1).format('YYYY-MM-DD') + ' 至 ' + moment().format('YYYY-MM-DD'));

        $('#reportrange').daterangepicker(
                {
                    // startDate: moment().startOf('day'),
                    //endDate: moment(),
                    //minDate: '01/01/2012',    //最小时间
                    maxDate : moment(), //最大时间
                    dateLimit : {
                        days : 365
                    }, //起止时间的最大间隔
                    showDropdowns : true,
                    showWeekNumbers : false, //是否显示第几周
                    timePicker : true, //是否显示小时和分钟
                    timePickerIncrement : 60, //时间的增量，单位为分钟
                    timePicker12Hour : false, //是否使用12小时制来显示时间
                    ranges : {
                        //'最近1小时': [moment().subtract('hours',1), moment()],
                        //'今日': [moment().startOf('day'), moment()],
                        //'昨日': [moment().subtract('days', 1).startOf('day'), moment().subtract('days', 1).endOf('day')],
                       // '最近7日': [moment().subtract('days', 6), moment()],
                       // '最近30日': [moment().subtract('days', 29), moment()]
                    },
                    opens : 'right', //日期选择框的弹出位置
                    buttonClasses : [ 'btn btn-default' ],
                    applyClass : 'btn-small btn-primary blue',
                    cancelClass : 'btn-small',
                    format : 'YYYY-MM-DD ', //控件中from和to 显示的日期格式
                    separator : ' to ',
                    locale : {
                        applyLabel : '确定',
                        cancelLabel : '取消',
                        fromLabel : '起始时间',
                        toLabel : '结束时间',
                        customRangeLabel : '自定义',
                        daysOfWeek : [ '日', '一', '二', '三', '四', '五', '六' ],
                        monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月',
                            '七月', '八月', '九月', '十月', '十一月', '十二月' ],
                        firstDay : 1
                    }
                }, function(start, end, label) {//格式化日期显示框

                    $('#reportrange span').html(start.format('YYYY-MM-DD ') + ' 至 ' + end.format('YYYY-MM-DD'));
                });
        
        
      //时间插件
        $('#reportrange1 span').html(moment().subtract('hours', 1).format('YYYY-MM-DD') + ' 至 ' + moment().format('YYYY-MM-DD'));

        $('#reportrange1').daterangepicker(
                {
                    // startDate: moment().startOf('day'),
                    //endDate: moment(),
                    //minDate: '01/01/2012',    //最小时间
                    maxDate : moment(), //最大时间
                    dateLimit : {
                        days : 365
                    }, //起止时间的最大间隔
                    showDropdowns : true,
                    showWeekNumbers : false, //是否显示第几周
                    timePicker : true, //是否显示小时和分钟
                    timePickerIncrement : 60, //时间的增量，单位为分钟
                    timePicker12Hour : false, //是否使用12小时制来显示时间
                    ranges : {
                        //'最近1小时': [moment().subtract('hours',1), moment()],
                        //'今日': [moment().startOf('day'), moment()],
                        //'昨日': [moment().subtract('days', 1).startOf('day'), moment().subtract('days', 1).endOf('day')],
                       // '最近7日': [moment().subtract('days', 6), moment()],
                       // '最近30日': [moment().subtract('days', 29), moment()]
                    },
                    opens : 'right', //日期选择框的弹出位置
                    buttonClasses : [ 'btn btn-default' ],
                    applyClass : 'btn-small btn-primary blue',
                    cancelClass : 'btn-small',
                    format : 'YYYY-MM-DD ', //控件中from和to 显示的日期格式
                    separator : ' to ',
                    locale : {
                        applyLabel : '确定',
                        cancelLabel : '取消',
                        fromLabel : '起始时间',
                        toLabel : '结束时间',
                        customRangeLabel : '自定义',
                        daysOfWeek : [ '日', '一', '二', '三', '四', '五', '六' ],
                        monthNames : [ '一月', '二月', '三月', '四月', '五月', '六月',
                            '七月', '八月', '九月', '十月', '十一月', '十二月' ],
                        firstDay : 1
                    }
                }, function(start, end, label) {//格式化日期显示框

                    $('#reportrange1 span').html(start.format('YYYY-MM-DD ') + ' 至 ' + end.format('YYYY-MM-DD'));
                });
    })
</script>



<script>
function selectByC_name(){
	var c_name = $("#getC_name").val();
	location.href='${pageContext.request.contextPath}/erp/wdrw_list.do?type=wdrw&dn=wdrw&qn=list&cn=w1&c_name='+c_name;
}
</script>

<script type="text/javascript">
	function exportExcel(){

		var arr = new Array();
		$("input:checkbox[name='favorite']:checked").each(function(i){
			arr[i] = $(this).val();
		});
		alert(arr);
		
	   	 $.ajax({
			type: "POST",
            url: "${pageContext.request.contextPath}/financialExcelController/financialExportExcel.do",
            data: {
            	Institutions:$('#Institutions').val(),
            	Bank:$('#Bank').val(),
            	arr:JSON.stringify(arr),
            },
           	dataType: "json",
            success: function(data){
            	alert(data.status)
            	//关闭弹出层
        	   	$("#closet").click();
            }
		})  
		
	}

</script>
																			
</form>				
</div>
</div>
					<div class="col-sm-2 admin-page-top hidden-xs">
							<select id="page_limit_select" onchange="window.location.href='${pageContext.request.contextPath }/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&pagenow=${requestScope.pagenow}&cn=${requestScope.cn}&c_name=${requestScope.c_name}&pagesize='+this.value" class="form-control">
														<option value="10">每页10条</option>
														<option value="20">每页20条</option>
														<option value="30">每页30条</option>
														<option value="40">每页40条</option>
														<option value="50">每页50条</option>
														<option value="60">每页60条</option>
														<option value="70">每页70条</option>
														<option value="80">每页80条</option>
														<option value="90">每页90条</option>
														<option value="100">每页100条</option>
													</select>
		       <div class="btn-group">
		               <%--  <%
						int pagenow1=Integer.parseInt(request.getAttribute("pagenow").toString());
					    int totalpage1=Integer.parseInt(request.getAttribute("totalpage").toString());
					    if(pagenow1>1&&pagenow1<=totalpage1){
						%>
						<a href="${pageContext.request.contextPath }/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow-1}&cn=${requestScope.cn}&c_name=${requestScope.c_name}" class="btn btn-default">«</a>						
						<%				    	
				         }						
						 if(pagenow1>=1&&pagenow1<totalpage1){
						%>
						<a href="${pageContext.request.contextPath }/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow+1}&cn=${requestScope.cn}&c_name=${requestScope.c_name}" class="btn btn-default">»</a>
                        <%
                        }
                        %> --%>
		       </div>
		       </div>
				</div>
			</div>
			<div id="main_list" class="admin-content box">
					<!-- 数据载入中 请在搜索，筛选，载入的时候显示 放在.box里 -->
				<div class="overlay" style="display:none;">
					<i class="fa fa-refresh fa-spin"></i>
				</div>
				<!-- 数据载入中结束 -->
				<table class="table table-bordered table-hover">
	<tbody>
	
	
				
		<tr>
			<th style="width: 3%" class="text-center hidden-xs"><input class="check_all" type="checkbox"></th>
			<th class="text-center hidden-xs">编号</th>
			<th class="text-center">客户姓名</th>
			<th class="text-center">业务类型</th>
			<th class="text-center">任务名称</th>
			<th class="text-center hidden-xs">任务发起人</th>
			<th class="text-center hidden-xs" >发起机构</th>
			<th class="text-center" width="200">开始时间</th>
			<th class="text-center" width="200">操作</th>
		</tr>
		   <%-- <c:forEach var="pd" items="${requestScope.newpdList }"> --%>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="${pd.id }" type="checkbox"></td>
			<td class="text-center hidden-xs">${pd.id}</td>
			<td class="text-center"><span class="s-font-blue">${pd.icbcname }aaaa</span></td>
			<td class="text-center" style="word-wrap:break-word;word-break:break-all;">
			${pd.tname }aaa
			</td>
			<td class="text-center hidden-xs"><p>
			${pd.knname }aaa
			</p></td>
			<td class="text-center hidden-xs"><p>
			${pd.gemsname }aaa
			</p></td>
			<td class="text-center">
			${pd.fsname }
			</td>
			<td class="text-center">
			<fmt:formatDate value="${pd.dt_add}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
			<td class="text-center">
			    <span id="" class="label label-danger">${pd.opname }正在操作</span>
				<a href="${pageContext.request.contextPath }/erp/wdrw_from.do?type=wdrw&dn=wdrw&qn=form&icbc_id=${pd.icbc_id}&cn=${requestScope.cn}&cn1=4&type_id=${pd.type_id}&yw_id=${pd.id}">
					<i class="fa fa-search-plus"></i>
				</a>
				<a href="${pageContext.request.contextPath}/financialExcelController/findicbcMapbyid.do?type=wdrw&dn=financeone&cn=${requestScope.cn}&qn=form&id=1">
					<i class="fa fa-hand-paper-o"></i>
				</a>
			</td>
		    </tr>
           <%-- </c:forEach> --%>
			
		</tbody>
</table>
			</div>
<div class="foot-page">
			<c:if test="${requestScope.totalpage ge '1' }">
				<ul class="pagination no-margin">
				       <c:if test="${requestScope.pagenow ne '1' }">
				        <li><a href="${pageContext.request.contextPath }/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow-1}&cn=${requestScope.cn}&c_name=${requestScope.c_name}" aria-label="Next"><span aria-hidden="true">«</span></a></li>
				       </c:if>
					   <%
				       int pagenow=Integer.parseInt(request.getAttribute("pagenow").toString());
				       int totalpage=Integer.parseInt(request.getAttribute("totalpage").toString());
				       int i=5; 
				       int h=1;
				    	 if(totalpage>=5){
				    		  if((pagenow-1)%4==0){
				    			 h=pagenow;
				    			 i=pagenow+4;
				    		  }else{
				    			 h=4*(pagenow-1-((pagenow-1)%4))/4+1;
				    			 i=h+4;
				    		  }				    		  
				    	  }else{
				    		i=totalpage;
				    	  } 
				       for(int j=h;j<i+1;j++){				    	   				    	   
				       if(j==pagenow){
				       %>
					   <li id="l<%=j %>" class="active">
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&pagesize=${requestScope.pagesize}&pagenow=<%=j %>&cn=${requestScope.cn}&c_name=${requestScope.c_name}">
					   <%=j %>
					   </a>
					   </li>
					   <%
				       }else{
					   %>
	                   <li id="l<%=j %>" >
					   <a id="a<%=j %>" href="${pageContext.request.contextPath }/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&pagesize=${requestScope.pagesize}&pagenow=<%=j %>&cn=${requestScope.cn}&c_name=${requestScope.c_name}">
					   <%=j %>					   
					   </a>
					   </li>					   
		               <%
				       }
				       if(j>=totalpage){
					    	  j=i+1; 
					   }
				       }				
		               %>
					   <c:if test="${requestScope.pagenow lt requestScope.totalpage}">
			               <c:if test="${requestScope.totalpage gt 5}">
						  <li><a href="${pageContext.request.contextPath }/erp/wdrw_list.do?type=wdrw&dn=${requestScope.dn }&qn=list&pagesize=${requestScope.pagesize}&pagenow=${requestScope.pagenow+1}&cn=${requestScope.cn}&c_name=${requestScope.c_name}" aria-label="Next"><span aria-hidden="true">»</span></a></li>  
						   </c:if>
					   </c:if>
					     				
					   </ul>
			</c:if>		   
				<div class="page-num">共${requestScope.totalsize}个 分${requestScope.totalpage }页显示</div>
			</div>
					</section><!-- /.content -->
		</div>


