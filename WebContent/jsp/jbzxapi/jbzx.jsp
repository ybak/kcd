<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0093)http://a.kcway.net/assess/manager/index.php?type=assess&do=list&cn=assess_cars&bc_tag=2&nav=1 -->
<html>
<head>
<%
String path = request.getContextPath();
String basePath ="https://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>人行征信简版管理</title>

	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	
	 <script type="text/javascript">
		var _rooturl = "http://a.kcway.net/assess/";
		var page_cn = "assess_cars";
	</script>
	
	<!-- Bootstrap 3.3.4 -->
	<link href="${pageContext.request.contextPath }/acss/bootstrap.min.css" rel="stylesheet" type="text/css">

	<link href="${pageContext.request.contextPath }/acss/font-awesome.min.css" rel="stylesheet" type="text/css">
	
	<link href="${pageContext.request.contextPath }/acss/select2.min.css" rel="stylesheet" type="text/css">
	
	
	<!-- Theme style -->
	<link href="${pageContext.request.contextPath }/acss/AdminLTE.css" rel="stylesheet" type="text/css">

	<link href="${pageContext.request.contextPath }/acss/skin-green.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath }/acss/style.css" rel="stylesheet" type="text/css">


	
	
	<!-- jQuery 2.1.4 -->
	<script src="${pageContext.request.contextPath }/acss/jQuery-2.1.4.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/acss/common.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/acss/jquery.form.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/acss/ajaxfileupload.js" type="text/javascript"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/acss/php.js"></script>

	<!-- Bootstrap 3.3.2 JS -->
	<script src="${pageContext.request.contextPath }/acss/bootstrap.min.js" type="text/javascript"></script>
	
	<script src="${pageContext.request.contextPath }/acss/moment.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/acss/daterangepicker.js" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath }/acss/daterangepicker-bs3.css" rel="stylesheet" type="text/css">
	
	<script src="${pageContext.request.contextPath }/acss/bootstrap-datepicker.js" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath }/acss/datepicker3.css" rel="stylesheet" type="text/css">
	<script src="${pageContext.request.contextPath }/acss/bootstrap-datepicker.zh-CN.js" type="text/javascript"></script>
	
	<script src="${pageContext.request.contextPath }/acss/bootstrap-datetimepicker.js" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath }/acss/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css">
	<script src="${pageContext.request.contextPath }/acss/bootstrap-datetimepicker.zh-CN.js" type="text/javascript"></script>
	
	
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/acss/ueditor.config.js"></script>
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/acss/ueditor.all.min.js"> </script>
	<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
	<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
	<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/acss/zh-cn.js"></script>
	
	
	
	<script src="${pageContext.request.contextPath }/acss/select2.min.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/acss/zh-cn(1).js" type="text/javascript"></script>
	
		
	<!-- AdminLTE App -->
	<script src="${pageContext.request.contextPath }/acss/app.min.js" type="text/javascript"></script>
	 
	<script src="${pageContext.request.contextPath }/acss/combo.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/acss/imgup.js" type="text/javascript"></script>
	<link href="${pageContext.request.contextPath }/acss/imgup.css" rel="stylesheet" type="text/css">
	<!-- <script src="/comm/jquery.dragsort-0.4.min.js" type="text/javascript"></script> -->
	
	<link href="${pageContext.request.contextPath }/acss/iconfont.css" rel="stylesheet" type="text/css">
	<style>@font-face{font-family:uc-nexus-iconfont;src:url(chrome-extension://pogijhnlcfmcppgimcaccdkmbedjkmhi/res/font_9qmmi8b8jsxxbt9.woff) format('woff'),url(chrome-extension://pogijhnlcfmcppgimcaccdkmbedjkmhi/res/font_9qmmi8b8jsxxbt9.ttf) format('truetype')}</style></head>
<script>

function a2(){
	var s=$("#page_limit_select").val();
	//alert(s)
	window.location.href ="jbzxlist.do?size="+s;

}


</script>
<!-- 	<body class="skin-green sidebar-mini fixed"> -->
		<section class="content-header">
			<h1>
		人行征信简版管理			<small>
												共${requestScope.totalCount }个
							</small>
			</h1>
		</section>

		<!-- Main content -->
		<section class="content">

			<div class="admin-tools">
				<div class="row">
					<div class="col-sm-7 admin-button">
					
					<!-- 增加删除按钮 --> 
					<div class="btn-group">
								
							<a href="" class="btn btn-default"><i class="fa fa-edit"></i> 导出</a>
							<a href="" class="btn btn-default" data-toggle="control-sidebar"><i class="fa fa-search"></i> 查询</a>
							
						</div> 
					</div>
					<div class="col-sm-5 admin-page-top hidden-xs">
							<select id="page_limit_select" onchange="a2()" class="form-control">
							                            <option value="10">当前每页显示${requestScope.size}条</option>
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
														<a href="" class="btn btn-default">»</a>
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
			<th>公司名|姓名</th>
			<th class="hidden-xs">被查询人</th>
			<th class="hidden-xs">最后更新时间</th>
			<th style="width: 150px" class="text-center">操作</th>
			<th style="width: 120px" class="text-center">当前状态</th>
	    </tr>
		  	<c:forEach var="jbzx" items="${requestScope.zl}">		  			  								
			<tr>
			<!-- <td class="text-center hidden-xs"><input type="checkbox" name="delid" value="37581"></td> -->
			<td>${jbzx.gname }-${jbzx.pname }</td>
			<td class="hidden-xs">${jbzx.c_name }</td>
			<td class="hidden-xs">
			${fn:substring(jbzx.dt_edit, 0,19)}
			</td>
            <td class="text-center">
				<div class="table-button">
				<a href="jbzxsh.do?id=${jbzx.id }" class="btn btn-default">
				<i class="fa fa-pencil"></i>
				</a>
                </div>
		    </td>
		    <c:if test="${jbzx.bc_status eq 1}">
		    <td class="text-center"><span class="label label-warning" >草稿箱</span></td>
		    </c:if>
		    <c:if test="${jbzx.bc_status eq 2}">
		    <td class="text-center"><span class="label label-success">正在查询</span></td>
		    </c:if>
		    <c:if test="${jbzx.bc_status eq 3}">
		    <td class="text-center"><span class="label label-success">查询完成</span></td>
		    </c:if>
		    <c:if test="${jbzx.bc_status eq 4}">
		    <td class="text-center"><span class="label label-warning">回退</span></td>
		    </c:if>
		    <c:if test="${jbzx.bc_status eq 5}">
		    <td class="text-center"><span class="label label-warning">已撤销</span></td>
		    </c:if>
			</tr>
			</c:forEach>
			</tbody>
</table>
<script>
	function myrefresh()
	{
       window.location.reload();
	}
	setTimeout('myrefresh()',60000); //指定1秒刷新一次
</script>
<script >
$("#menu li").hover(function() {
	alert("111");
    $(this).addClass("active");
}, function() {
    $(this).removeClass("active");
});
</script>				
			</div>
						<div class="foot-page">
<c:if test="${requestScope.totalall ge '1' }">
				<ul class="pagination no-margin">
				       <c:if test="${requestScope.pagenow ne '1' }">
				       <li >
				       <a  href="jbzxlist.do?pagesize=${requestScope.size }&pagenow=${requestScope.pagenow-1}">
				       <span >«</span>
				       </a>
				       </li>
				       </c:if>
				       <%
				       int pagenow=Integer.parseInt(request.getAttribute("pagenow").toString());
				       int totalpage=Integer.parseInt(request.getAttribute("totalall").toString());
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
					   <a id="a<%=j %>" href="jbzxlist.do?pagesize=${requestScope.size }&pagenow=<%=j %>">
					   <%=j %>
					   </a>
					   </li>
					   <%
				       }else{
					   %>
	                   <li id="l<%=j %>" >
					   <a id="a<%=j %>" href="jbzxlist.do?pagesize=${requestScope.size }&pagenow=<%=j %>"><%=j %>					   
					   </a>
					   </li>					   
		               <%
				       }
				       if(j>=totalpage){
					    	  j=i+1; 
					   }
				       }				
		               %>
		               <c:if test="${requestScope.pagenow lt requestScope.totalall}">
		               <c:if test="${requestScope.totalall gt 5}">
					   <li>
					   <a href="jbzxlist.do?pagesize=${requestScope.size }&pagenow=${requestScope.pagenow+1}">
					   <span>»</span>
					   </a>
					   </li>  
					   </c:if>
					   </c:if>					
					   </ul>
					   </c:if>
				<div class="page-num">共${requestScope.totalCount }个 分${requestScope.totalall }页显示</div>
			</div>
  </section><!-- /.content -->
		</body>
		
		<script type="text/javascript" src="${pageContext.request.contextPath }/acss/list.js"></script>		
				<!-- 搜索层 -->
<aside class="control-sidebar control-sidebar-dark" style="position: fixed; max-height: 100%; overflow: auto; padding-bottom: 50px;">
		<div class="tab-content">
			<!-- Home tab content -->
			<h3 class="control-sidebar-heading">开始搜索</h3>
			<form id="search_form" action="">
				<input type="hidden" name="do" value="list">
				<div class="form-group">
	<label>评估时间:</label>
	<div class="input-group">
		<input type="text" class="form-control daterange" name="dtbe" value="" placeholder="区间">
		<div class="input-group-addon"><i class="fa fa-calendar"></i></div>
	</div>
</div>
<div class="form-group">
	<label>选择所属店</label> 
	<select class="form-control" name="gems_fs_id">
	<option value="0">请选择</option>
		
		</select>

</div>
<div class="form-group">
	<label>选择查询类型</label> 
	<select class="form-control" name="query_type">
	<option value="-1" selected="">请选择</option>
	<option value="0">快速评估</option>
	<option value="1">专业评估</option>
	</select>
</div>
<div class="form-group">
	<label>订单状态</label> 
	<select class="form-control" name="bc_status_real">
	<option value="">请选择</option><option value="1">草稿箱</option><option value="2">正在估值</option><option value="3">估值完成</option><option value="4">回退</option><option value="5">已撤销</option>	</select>
</div>
<div class="form-group">
	<label>输入关键字:</label> 
	<input type="text" name="kw" value="" class="form-control" placeholder="车辆名称/电话号码/VIN码/车牌">
</div>
<a type="submit" onclick="$(&#39;#search_form&#39;).submit()" class="btn btn-block btn-primary">搜索</a>
<input type="hidden" name="type" value="assess"><input type="hidden" name="cn" value="assess_cars"><input type="hidden" name="bc_tag" value="2"><input type="hidden" name="nav" value="1">			</form>
		</div>
</aside><!-- /.control-sidebar -->
		
				
		
		

	


			
	
	<!--弹窗框体开始-->
	<div class="modal fade" id="modal" role="dialog" data-backdrop="static">
		<div class="modal-dialog" role="document">
		<div id="mycontent" class="modal-content">
		<!--将在这里载入链接页面-->
		</div>
		</div>
	</div>
<!-- 弹窗框体结束-->
	<script>
		$('#modal').on('hidden.bs.modal', function (e) {
			$(this).removeData("bs.modal");
	})
	</script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath }/acss/index.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/acss/ui.js"></script>
	

<div class="daterangepicker dropdown-menu show-calendar opensright" style="top: 156px; left: 1394px; right: auto;"><div class="calendar first right"><div class="calendar-date"><table class="table-condensed"><thead><tr><th></th><th colspan="5" class="month">八月 2017</th><th class="next available"><i class="fa fa-arrow-right icon icon-arrow-right glyphicon glyphicon-arrow-right"></i></th></tr><tr><th>日</th><th>一</th><th>二</th><th>三</th><th>四</th><th>五</th><th>六</th></tr></thead><tbody><tr><td class="off disabled" data-title="r0c0">30</td><td class="off disabled" data-title="r0c1">31</td><td class="off disabled" data-title="r0c2">1</td><td class="off disabled" data-title="r0c3">2</td><td class="off disabled" data-title="r0c4">3</td><td class="off disabled" data-title="r0c5">4</td><td class="off disabled" data-title="r0c6">5</td></tr><tr><td class="off disabled" data-title="r1c0">6</td><td class="off disabled" data-title="r1c1">7</td><td class="off disabled" data-title="r1c2">8</td><td class="off disabled" data-title="r1c3">9</td><td class="off disabled" data-title="r1c4">10</td><td class="off disabled" data-title="r1c5">11</td><td class="off disabled" data-title="r1c6">12</td></tr><tr><td class="off disabled" data-title="r2c0">13</td><td class="off disabled" data-title="r2c1">14</td><td class="off disabled" data-title="r2c2">15</td><td class="off disabled" data-title="r2c3">16</td><td class="off disabled" data-title="r2c4">17</td><td class="off disabled" data-title="r2c5">18</td><td class="off disabled" data-title="r2c6">19</td></tr><tr><td class="off disabled" data-title="r3c0">20</td><td class="off disabled" data-title="r3c1">21</td><td class="off disabled" data-title="r3c2">22</td><td class="off disabled" data-title="r3c3">23</td><td class="off disabled" data-title="r3c4">24</td><td class="off disabled" data-title="r3c5">25</td><td class="off disabled" data-title="r3c6">26</td></tr><tr><td class="off disabled" data-title="r4c0">27</td><td class="off disabled" data-title="r4c1">28</td><td class="off disabled" data-title="r4c2">29</td><td class="available active start-date end-date" data-title="r4c3">30</td><td class="available" data-title="r4c4">31</td><td class="available off" data-title="r4c5">1</td><td class="available off" data-title="r4c6">2</td></tr><tr><td class="available off" data-title="r5c0">3</td><td class="available off" data-title="r5c1">4</td><td class="available off" data-title="r5c2">5</td><td class="available off" data-title="r5c3">6</td><td class="available off" data-title="r5c4">7</td><td class="available off" data-title="r5c5">8</td><td class="available off" data-title="r5c6">9</td></tr></tbody></table></div></div><div class="calendar second left"><div class="calendar-date"><table class="table-condensed"><thead><tr><th class="prev available"><i class="fa fa-arrow-left icon icon-arrow-left glyphicon glyphicon-arrow-left"></i></th><th colspan="5" class="month">八月 2017</th><th class="next available"><i class="fa fa-arrow-right icon icon-arrow-right glyphicon glyphicon-arrow-right"></i></th></tr><tr><th>日</th><th>一</th><th>二</th><th>三</th><th>四</th><th>五</th><th>六</th></tr></thead><tbody><tr><td class="available off" data-title="r0c0">30</td><td class="available off" data-title="r0c1">31</td><td class="available" data-title="r0c2">1</td><td class="available" data-title="r0c3">2</td><td class="available" data-title="r0c4">3</td><td class="available" data-title="r0c5">4</td><td class="available" data-title="r0c6">5</td></tr><tr><td class="available" data-title="r1c0">6</td><td class="available" data-title="r1c1">7</td><td class="available" data-title="r1c2">8</td><td class="available" data-title="r1c3">9</td><td class="available" data-title="r1c4">10</td><td class="available" data-title="r1c5">11</td><td class="available" data-title="r1c6">12</td></tr><tr><td class="available" data-title="r2c0">13</td><td class="available" data-title="r2c1">14</td><td class="available" data-title="r2c2">15</td><td class="available" data-title="r2c3">16</td><td class="available" data-title="r2c4">17</td><td class="available" data-title="r2c5">18</td><td class="available" data-title="r2c6">19</td></tr><tr><td class="available" data-title="r3c0">20</td><td class="available" data-title="r3c1">21</td><td class="available" data-title="r3c2">22</td><td class="available" data-title="r3c3">23</td><td class="available" data-title="r3c4">24</td><td class="available" data-title="r3c5">25</td><td class="available" data-title="r3c6">26</td></tr><tr><td class="available" data-title="r4c0">27</td><td class="available" data-title="r4c1">28</td><td class="available" data-title="r4c2">29</td><td class="available active start-date end-date" data-title="r4c3">30</td><td class="available" data-title="r4c4">31</td><td class="available off" data-title="r4c5">1</td><td class="available off" data-title="r4c6">2</td></tr><tr><td class="available off" data-title="r5c0">3</td><td class="available off" data-title="r5c1">4</td><td class="available off" data-title="r5c2">5</td><td class="available off" data-title="r5c3">6</td><td class="available off" data-title="r5c4">7</td><td class="available off" data-title="r5c5">8</td><td class="available off" data-title="r5c6">9</td></tr></tbody></table></div></div><div class="ranges"><div class="range_inputs"><div class="daterangepicker_start_input"><label for="daterangepicker_start">开始</label><input class="input-mini" type="text" name="daterangepicker_start" value=""></div><div class="daterangepicker_end_input"><label for="daterangepicker_end">结束</label><input class="input-mini" type="text" name="daterangepicker_end" value=""></div><button class="applyBtn btn btn-small btn-sm btn-success">确定</button>&nbsp;<button class="cancelBtn btn btn-small btn-sm btn-default">取消</button></div></div></div></body></html>