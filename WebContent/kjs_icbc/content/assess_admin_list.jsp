<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="content-wrapper" style="min-height: 943px;">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>
			账号管理<small>
			共${requestScope.totalpage }个
			</small>
			</h1>
		</section>

		<!-- Main content -->
		<section class="content">
			<div class="admin-tools">
				<div class="row">
					<div class="col-sm-10 admin-button">
					<div class="btn-group">
					<a data-toggle="modal" href="" data-target="#modal" class="btn btn-default"><i class="fa fa-edit"></i> 新增</a>
					<a href="javascript:;" onclick="ajax_edit(null,'showtag','1')" class="btn btn-default" style="display: none;"><i class="fa fa-arrow-circle-o-up"></i> 发布</a>
					<a href="javascript:;" onclick="ajax_edit(null,'showtag','0')" class="btn btn-default" style="display: none;"><i class="fa fa-arrow-circle-o-down"></i> 待审</a>
					<a href="javascript:;" id="del_more_btn" class="btn btn-default"><i class="fa fa-trash-o"></i> 删除</a>
					</div>
					</div>
					<div class="col-sm-2 admin-page-top hidden-xs">
							<select id="page_limit_select" onchange="window.location.href='/assess/manager/index.php?type=sysset&amp;do=list&amp;cn=assess_admin&amp;nav=0&amp;l='+this.value" class="form-control">
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
														
														<a href="/assess/manager/index.php?type=sysset&amp;do=list&amp;cn=assess_admin&amp;nav=0&amp;p=2" class="btn btn-default">»</a>
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
			<th class="text-center hidden-xs" width="50">ID|GEMSID</th>
			<th class="text-center">姓名|用户名</th>
			<th class="text-center hidden-xs">电话|推送ID</th>
			<th class="text-center hidden-xs">权限组</th>
			<th class="text-center hidden-xs">账号分类</th>
			<th class="text-center hidden-xs" width="80">添加时间</th>
			<th class="hidden-xs text-center" width="100">最后登录</th>
			<th class="hidden-xs text-center" width="100">IP</th>
			<th class="text-center hidden-xs" style="width:110px;">状态</th>
			<th class="text-center" width="100">操作</th>
		</tr>
		<c:forEach var="list" items="${requestScope.newpdList }">
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="4779" type="checkbox"></td>
			<td class="text-center hidden-xs"><p>${list.id}<br>${list.gemsid}</p></td>
			<td class="text-center"><span class="s-font-blue">${list.name}<br>
			<font color="red">${list.username}</font></span></td>
			<td class="text-center hidden-xs"><p>${list.tel}<br></p></td>
			<td class="text-center hidden-xs"><p>
			<font style="color:black;background:yellow">远景创投金融技术服务有限公司-普通鉴定师</font>
			</p>
			<br>
			</td>
			<td class="text-center hidden-xs"><p>前台APP</p></td>
			<td class="text-center hidden-xs"><p>
			<fmt:formatDate value="${list.dt_add}" pattern="yyyy-MM-dd"/> </p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs"><p></p></td>
			<td class="text-center hidden-xs">
				<select id="showtag_4779" onchange="ajax_edit(4779,'showtag',this.value,'assess_admin');" class="form-control">
					<option value="1">开通</option>
					<option value="0">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a data-toggle="modal" data-target="#modal" href="" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_4779" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
		</c:forEach>
		</tbody>
</table>
<script>
$(".btn-group a:eq(1)").hide();
$(".btn-group a:eq(2)").hide();
</script>				
			</div>
						<div class="foot-page">
				<ul class="pagination no-margin">
					  <li class="active"><a href="/assess/manager/index.php?type=sysset&amp;do=list&amp;cn=assess_admin&amp;nav=0&amp;p=1">1 <span class="sr-only">(current)</span></a></li> <li><a href="/assess/manager/index.php?type=sysset&amp;do=list&amp;cn=assess_admin&amp;nav=0&amp;p=2">2</a></li> <li><a href="/assess/manager/index.php?type=sysset&amp;do=list&amp;cn=assess_admin&amp;nav=0&amp;p=3">3</a></li> <li><a href="/assess/manager/index.php?type=sysset&amp;do=list&amp;cn=assess_admin&amp;nav=0&amp;p=4">4</a></li> <li><a href="/assess/manager/index.php?type=sysset&amp;do=list&amp;cn=assess_admin&amp;nav=0&amp;p=5">5</a></li>  <li><a href="/assess/manager/index.php?type=sysset&amp;do=list&amp;cn=assess_admin&amp;nav=0&amp;p=2" aria-label="Next"><span aria-hidden="true">»</span></a></li>  				</ul>
				<div class="page-num">共4351个 分436页显示</div>
			</div>
					</section><!-- /.content -->
		</div>
		
