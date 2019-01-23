<%@page import="java.util.*"%>
<%@page import="com.model.credit"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0088)http://a.kcway.net/assess/manager/index.php?type=assess&cn=assess_query_dr&do=list&nav=1 -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>快加认证-业务报表</title>
	<!-- Tell the browser to be responsive to screen width -->
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	
	 <script type="text/javascript">
		var _rooturl = "http://a.kcway.net/assess/";
		var page_cn = "assess_query_dr";
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
	<style>@font-face{font-family:uc-nexus-iconfont;src:url(chrome-extension://pogijhnlcfmcppgimcaccdkmbedjkmhi/res/font_9qmmi8b8jsxxbt9.woff) format('woff'),url(chrome-extension://pogijhnlcfmcppgimcaccdkmbedjkmhi/res/font_9qmmi8b8jsxxbt9.ttf) format('truetype')}</style></head>

	<body class="skin-green sidebar-mini fixed">

<script>

function a3(){
	var s=$("#page_limit_select").val();
	window.location.href ="limit.do?size="+s;

}

function a1(size) {
	alert(size);
	window.location.href ="limit.do?size="+size+"&pagenow=3";
}
</script>
	


<script>
$('li.active').parents('li').addClass('treeview').addClass('active');
</script>	

		<section class="content-header">
			<h1>
			点融车征信			<small>
                          共${requestScope.totalCount }个
							</small>
			</h1>
		</section>

		<!-- Main content -->
		<section class="content">

			<div class="admin-tools">
				<div class="row">
					<div class="col-sm-7 admin-button">
					<div class="btn-group">						
					<!-- <a href="" class="btn btn-default"><i class="fa fa-edit"></i> 导出数据</a> -->
					<!-- <a href="javascript:;" id="del_more_btn" class="btn btn-default"><i class="fa fa-search"></i> 删除</a>  -->
					<a href=""  class="btn btn-default" data-toggle="control-sidebar"><i class="fa fa-search"></i>搜索</a>
					</div>
					</div>
					<div class="col-sm-5 admin-page-top hidden-xs">
								<select id="page_limit_select"  onchange="a3()" class="form-control">
														<option>每页显示条数</option>
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
	<tbody id="show">
		<tr>
			<th>编号</th>
			<th class="hidden-xs ext-center" style="width:80px">身份信息</th>
			<th class="hidden-xs ext-center" style="width:160px">最后更新时间</th>
			<th style="width: 120px" class="text-center">操作</th>
			<th style="width: 80px" class="text-center">审核状态</th>		
		</tr>
		
		<c:forEach var="c" items="${requestScope.credit }">
		
		    <tr>
			<td>来源:点融网-API专用</td>			
			<td class="hidden-xs">${c.name }</td>
			<td class="hidden-xs">${c.add_time }</td>
			<td class="text-center">
		    <div class="table-button">
			<a href="xg.do?id=${c.id }" class="btn btn-default">
			<i class="fa fa-pencil"></i>
			</a>
			</div>
			<span class="label label-success">${c.sum_bit }</span>
			</td>
			<td><span class="label label-warning">正在查询</span></td>
		    </tr>
		
		</c:forEach>
		
		<!-- 
		<tr>
			<td>来源:点融网-API专用</td>
			
			<td class="hidden-xs">彭孟华</td>
			<td class="hidden-xs">2017-08-30 15:26:59</td>
			<td class="text-center">
				<div class="table-button">
					<a href="" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
																	<span class="label label-success">等待审核</span>
									</td>
			<td><span class="label label-warning">正在查询</span></td>
		</tr>
		<tr>
			<td>来源:点融网-API专用</td>
		
			<td class="hidden-xs">熊万鹏</td>
			<td class="hidden-xs">2017-08-30 15:26:48</td>
			<td class="text-center">
				<div class="table-button">
					<a href="" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
										
						</td>
			<td><span class="label label-success">查询完成</span></td>
		</tr>
		<tr>
			<td>来源:点融网-API专用</td>
			
			<td class="hidden-xs">单佑明</td>
			<td class="hidden-xs">2017-08-30 15:26:11</td>
			<td class="text-center">
				<div class="table-button">
					<a href="" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
																	<span class="label label-danger">数据师1审核中</span>
									</td>
			<td><span class="label label-warning">正在查询</span></td>
		</tr>
		<tr>
			<td>来源:点融网-API专用</td>
			
			<td class="hidden-xs"></td>
			<td class="hidden-xs">2017-08-30 15:26:04</td>
			<td class="text-center">
				<div class="table-button">
					<a href="" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
																	<span class="label label-success">等待审核</span>
									</td>
			<td><span class="label label-warning">正在查询</span></td>
		</tr>
		<tr>
			<td>来源:点融网-API专用</td>
			
			<td class="hidden-xs"></td>
			<td class="hidden-xs">2017-08-30 15:21:02</td>
			<td class="text-center">
				<div class="table-button">
					<a href="" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
																	<span class="label label-success">等待审核</span>
									</td>
			<td><span class="label label-warning">正在查询</span></td>
		</tr>
		<tr>
			<td>来源:点融网-API专用</td>
		
			<td class="hidden-xs">艾秋成</td>
			<td class="hidden-xs">2017-08-30 15:17:54</td>
			<td class="text-center">
				<div class="table-button">
					<a href="" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
										
						</td>
			<td><span class="label label-success">查询完成</span></td>
		</tr>
		<tr>
			<td>来源:点融网-API专用</td>
			
			<td class="hidden-xs">王亭亭</td>
			<td class="hidden-xs">2017-08-30 15:16:13</td>
			<td class="text-center">
				<div class="table-button">
					<a href="" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
										
						</td>
			<td><span class="label label-success">查询完成</span></td>
		</tr>
		<tr>
			<td>来源:点融网-API专用</td>
			
			<td class="hidden-xs">杜鑫</td>
			<td class="hidden-xs">2017-08-30 15:11:45</td>
			<td class="text-center">
				<div class="table-button">
					<a href="" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
										
						</td>
			<td><span class="label label-success">查询完成</span></td>
		</tr>
		<tr>
			<td>来源:点融网-API专用</td>
			
			<td class="hidden-xs">曹家荣</td>
			<td class="hidden-xs">2017-08-30 15:10:12</td>
			<td class="text-center">
				<div class="table-button">
					<a href="" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
										
						</td>
			<td><span class="label label-success">查询完成</span></td>
		</tr>
		 -->
			</tbody>
</table>
				
			</div>
			<% 
		   int w=Integer.parseInt(request.getAttribute("w").toString());
		  
			%>
						<div class="foot-page">
				<ul class="pagination no-margin">
				      <%
				      for(int i=0;i<w;i++){				    	  				      				      
				      %>  
					   <li>
					   <a href="limit.do?size=${requestScope.size }&pagenow=<%=i+1 %>"><%=i+1 %></a>
					   </li> 
					   <%
				      }
					   %> 
					   <li><a href="" aria-label="Next"><span aria-hidden="true">»</span></a></li>  			
			  </ul>
				<div class="page-num">共${requestScope.totalCount }个 分${requestScope.w }页显示</div>
			</div>
					</section><!-- /.content -->
		

		<script type="text/javascript" src="./acss/list.js"></script>		
				<!-- 搜索层 -->
		<aside class="control-sidebar control-sidebar-dark" style="position: fixed; max-height: 100%; overflow: auto; padding-bottom: 50px;">
		<div class="tab-content">
			<!-- Home tab content -->
			<h3 class="control-sidebar-heading">开始搜索</h3>
			<form id="search_form" action="http://a.kcway.net/assess/manager/index.php">
				<input type="hidden" name="do" value="list">
				<div class="form-group">
	<label>创建时间区间</label>
	<div class="input-group">
		<input type="text" class="form-control daterange" name="dtbe" value="" placeholder="区间">
		<div class="input-group-addon">
		<i class="fa fa-calendar"></i>
		</div>
	</div>
</div>
<div class="form-group">
	<label>输入车牌/车主姓名/VIN/身份证</label> 
	<input type="text" name="kw" value="" class="form-control" placeholder="比如张无忌或闽A8888">
</div><div class="form-group">
	<label>提交人</label> 
	<select class="form-control" name="gems_id">
	<option value="">请选择</option>	
	<option value="16">李祁林</option>	
	<option value="360">API专用</option>	
	</select>
</div>
<div class="form-group">
	<label>订单状态</label> 
	<select class="form-control" name="bc_status_real">
	<option value="">请选择</option>
	<option value="1">草稿箱</option>
	<option value="2">正在查询</option>
	<option value="3">查询完成</option>
	<option value="4">回退</option>
	<option value="5">已撤销</option>	
	</select>
</div>
<div class="form-group">
	<label>asid</label> 
	<input type="text" name="asid" value="" class="form-control" placeholder="接口返回的asid">
</div>
当前搜索范围：所有订单<a type="submit" onclick="" class="btn btn-block btn-primary">搜索</a>
<input type="hidden" name="type" value="assess">
<input type="hidden" name="cn" value="assess_query_dr">
<input type="hidden" name="nav" value="1">			
</form>						
		</div>
		</aside><!-- /.control-sidebar -->
		
				
		
		
		<!-- Add the sidebar's background. This div must be placed
			 immediately after the control sidebar -->
		<div class="control-sidebar-bg" style="position: fixed; height: auto;"></div>	
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
	
	<script type="text/javascript" src="./acss/index.js"></script>
	<script type="text/javascript" src="./acss/ui.js"></script>
	

<div class="daterangepicker dropdown-menu show-calendar opensright" style="top: 156px; left: 1394px; right: auto;"><div class="calendar first right"><div class="calendar-date"><table class="table-condensed"><thead><tr><th></th><th colspan="5" class="month">八月 2017</th><th class="next available"><i class="fa fa-arrow-right icon icon-arrow-right glyphicon glyphicon-arrow-right"></i></th></tr><tr><th>日</th><th>一</th><th>二</th><th>三</th><th>四</th><th>五</th><th>六</th></tr></thead><tbody><tr><td class="off disabled" data-title="r0c0">30</td><td class="off disabled" data-title="r0c1">31</td><td class="off disabled" data-title="r0c2">1</td><td class="off disabled" data-title="r0c3">2</td><td class="off disabled" data-title="r0c4">3</td><td class="off disabled" data-title="r0c5">4</td><td class="off disabled" data-title="r0c6">5</td></tr><tr><td class="off disabled" data-title="r1c0">6</td><td class="off disabled" data-title="r1c1">7</td><td class="off disabled" data-title="r1c2">8</td><td class="off disabled" data-title="r1c3">9</td><td class="off disabled" data-title="r1c4">10</td><td class="off disabled" data-title="r1c5">11</td><td class="off disabled" data-title="r1c6">12</td></tr><tr><td class="off disabled" data-title="r2c0">13</td><td class="off disabled" data-title="r2c1">14</td><td class="off disabled" data-title="r2c2">15</td><td class="off disabled" data-title="r2c3">16</td><td class="off disabled" data-title="r2c4">17</td><td class="off disabled" data-title="r2c5">18</td><td class="off disabled" data-title="r2c6">19</td></tr><tr><td class="off disabled" data-title="r3c0">20</td><td class="off disabled" data-title="r3c1">21</td><td class="off disabled" data-title="r3c2">22</td><td class="off disabled" data-title="r3c3">23</td><td class="off disabled" data-title="r3c4">24</td><td class="off disabled" data-title="r3c5">25</td><td class="off disabled" data-title="r3c6">26</td></tr><tr><td class="off disabled" data-title="r4c0">27</td><td class="off disabled" data-title="r4c1">28</td><td class="off disabled" data-title="r4c2">29</td><td class="available active start-date end-date" data-title="r4c3">30</td><td class="available" data-title="r4c4">31</td><td class="available off" data-title="r4c5">1</td><td class="available off" data-title="r4c6">2</td></tr><tr><td class="available off" data-title="r5c0">3</td><td class="available off" data-title="r5c1">4</td><td class="available off" data-title="r5c2">5</td><td class="available off" data-title="r5c3">6</td><td class="available off" data-title="r5c4">7</td><td class="available off" data-title="r5c5">8</td><td class="available off" data-title="r5c6">9</td></tr></tbody></table></div></div><div class="calendar second left"><div class="calendar-date"><table class="table-condensed"><thead><tr><th class="prev available"><i class="fa fa-arrow-left icon icon-arrow-left glyphicon glyphicon-arrow-left"></i></th><th colspan="5" class="month">八月 2017</th><th class="next available"><i class="fa fa-arrow-right icon icon-arrow-right glyphicon glyphicon-arrow-right"></i></th></tr><tr><th>日</th><th>一</th><th>二</th><th>三</th><th>四</th><th>五</th><th>六</th></tr></thead><tbody><tr><td class="available off" data-title="r0c0">30</td><td class="available off" data-title="r0c1">31</td><td class="available" data-title="r0c2">1</td><td class="available" data-title="r0c3">2</td><td class="available" data-title="r0c4">3</td><td class="available" data-title="r0c5">4</td><td class="available" data-title="r0c6">5</td></tr><tr><td class="available" data-title="r1c0">6</td><td class="available" data-title="r1c1">7</td><td class="available" data-title="r1c2">8</td><td class="available" data-title="r1c3">9</td><td class="available" data-title="r1c4">10</td><td class="available" data-title="r1c5">11</td><td class="available" data-title="r1c6">12</td></tr><tr><td class="available" data-title="r2c0">13</td><td class="available" data-title="r2c1">14</td><td class="available" data-title="r2c2">15</td><td class="available" data-title="r2c3">16</td><td class="available" data-title="r2c4">17</td><td class="available" data-title="r2c5">18</td><td class="available" data-title="r2c6">19</td></tr><tr><td class="available" data-title="r3c0">20</td><td class="available" data-title="r3c1">21</td><td class="available" data-title="r3c2">22</td><td class="available" data-title="r3c3">23</td><td class="available" data-title="r3c4">24</td><td class="available" data-title="r3c5">25</td><td class="available" data-title="r3c6">26</td></tr><tr><td class="available" data-title="r4c0">27</td><td class="available" data-title="r4c1">28</td><td class="available" data-title="r4c2">29</td><td class="available active start-date end-date" data-title="r4c3">30</td><td class="available" data-title="r4c4">31</td><td class="available off" data-title="r4c5">1</td><td class="available off" data-title="r4c6">2</td></tr><tr><td class="available off" data-title="r5c0">3</td><td class="available off" data-title="r5c1">4</td><td class="available off" data-title="r5c2">5</td><td class="available off" data-title="r5c3">6</td><td class="available off" data-title="r5c4">7</td><td class="available off" data-title="r5c5">8</td><td class="available off" data-title="r5c6">9</td></tr></tbody></table></div></div><div class="ranges"><div class="range_inputs"><div class="daterangepicker_start_input"><label for="daterangepicker_start">开始</label><input class="input-mini" type="text" name="daterangepicker_start" value=""></div><div class="daterangepicker_end_input"><label for="daterangepicker_end">结束</label><input class="input-mini" type="text" name="daterangepicker_end" value=""></div><button class="applyBtn btn btn-small btn-sm btn-success">确定</button>&nbsp;<button class="cancelBtn btn btn-small btn-sm btn-default">取消</button></div></div></div></body></html>