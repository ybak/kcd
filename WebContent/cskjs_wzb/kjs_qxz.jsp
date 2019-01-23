<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
     <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%
String path = request.getContextPath();
String basePath ="https://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>快加后台管理</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<script type="text/javascript">
		var _rooturl = "http://a.kcway.net/assess/";
		var page_cn = "";
</script>
<!-- Bootstrap 3.3.4 -->
<link href="${pageContext.request.contextPath }/cskjs_css/bootstrap.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">

<!-- Font Awesome Icons -->
<!-- Font Awesome Icons -->
<link href="${pageContext.request.contextPath }/cskjs_css/font-awesome.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/cskjs_css/select2.css" rel="stylesheet" type="text/css">
<!-- Theme style -->
<link href="${pageContext.request.contextPath }/cskjs_css/AdminLTE.css" rel="stylesheet" type="text/css">
<!-- AdminLTE Skins. We have chosen the skin-blue for this starter
			page. However, you can choose any other skin. Make sure you
			apply the skin class to the body tag so the changes take effect.
	-->
<link href="${pageContext.request.contextPath }/cskjs_css/skin-green.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/cskjs_css/style.css" rel="stylesheet" type="text/css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		<script src="https://cdn.bootcss.com/html5shiv/r29/html5.min.js"></script>
		<script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
<!-- jQuery 2.1.4 -->
<script src="${pageContext.request.contextPath }/cskjs_css/jQuery-2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/common.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/jquery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/ajaxfileupload.js" type="text/javascript"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/cskjs_css/php.js"></script>
<!-- Bootstrap 3.3.2 JS -->
<script src="${pageContext.request.contextPath }/cskjs_css/bootstrap.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/moment.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/daterangepicker.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/cskjs_css/daterangepicker-bs3.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/cskjs_css/bootstrap-datepicker.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/cskjs_css/datepicker3.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/cskjs_css/bootstrap-datepicker_002.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/bootstrap-datetimepicker.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/cskjs_css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/cskjs_css/bootstrap-datetimepicker_002.js" type="text/javascript"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/cskjs_css/ueditor_002.js"></script>
<script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/cskjs_css/ueditor.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script src="${pageContext.request.contextPath }/cskjs_css/select2.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/zh-CN.js" type="text/javascript"></script>
	
<style type="text/css">
.autocut{    
    overflow:hidden;  
    white-space:nowrap;  
    text-overflow:ellipsis;  
    -o-text-overflow:ellipsis;  
    -icab-text-overflow: ellipsis;  
    -khtml-text-overflow: ellipsis;  
    -moz-text-overflow: ellipsis;  
    -webkit-text-overflow: ellipsis;   
}
.td:hover{color:red;}
.dada{

    border-bottom: 1px solid #cccee1;
    border-left: 1px solid #cccee1;
    border-right: 1px solid #cccee1;
    padding:15px 15px 15px 15px;
    -moz-border-radius: 5px;
    -webkit-border-radius: 5px;
    border-radius: 4px;
    overflow: hidden;
    -moz-box-shadow: 0 0 60px rgba(0, 0, 0, 0.1);
    -webkit-box-shadow: 0 0 60px rgba(0, 0, 0, 0.1);
    box-shadow: 0 0 5px #4187dd66;
}
select {
/*Chrome和Firefox里面的边框是不一样的，所以复写了一下*/
border: solid 1px #fff0;

/*很关键：将默认的select选择框样式清除*/
appearance:none;
-moz-appearance:none;
-webkit-appearance:none;

/*在选择框的最右侧中间显示小箭头图片*/
background: url("${pageContext.request.contextPath }/cskjs_css/xljt@2x.png") no-repeat scroll right center transparent;
/*为下拉小箭头留出一点位置，避免被文字覆盖*/
padding-right: 30px;
}
/*清除ie的默认选择框样式清除，隐藏下拉箭头*/
select::-ms-expand { display: none; }
		</style>
	<!-- AdminLTE App -->
<script src="${pageContext.request.contextPath }/cskjs_css/app.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/combo.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/cskjs_css/imgup.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/cskjs_css/imgup.css" rel="stylesheet" type="text/css">
<!-- <script src="/comm/jquery.dragsort-0.4.min.js" type="text/javascript"></script> -->
<link href="${pageContext.request.contextPath }/cskjs_css/iconfont.css" rel="stylesheet" type="text/css">
 

</head>
<!--
	BODY TAG OPTIONS:
	=================
	Apply one or more of the following classes to get the
	desired effect
	|---------------------------------------------------------|
	| SKINS		 | skin-blue								 |
	|				 | skin-black								|
	|				 | skin-purple							 |
	|				 | skin-yellow							 |
	|				 | skin-red								|
	|				 | skin-green								|
	|---------------------------------------------------------|
	|LAYOUT OPTIONS | fixed									 |
	|				 | layout-boxed							|
	|				 | layout-top-nav							|
	|				 | sidebar-collapse						|
	|				 | sidebar-mini							|
	|---------------------------------------------------------|
	-->
		<script type="text/javascript">
		 //获取checkbox按钮组
		 var allpro = document.getElementsByName("delid");
		 //全选方法
		 function change() {
		    //获取全选按钮
		 var all = document.getElementById("btcheck_all");
		 //全选按钮被选中时，遍历所有按钮
		    if (all.checked) {
		     for (var i = 0; i < allpro.length; i++) {
		     if (allpro[i].type=="checkbox") {
		     allpro[i].checked=true;

		     }
		     }
		     //全选按钮未被选中时
		    }else{
		     for (var i = 0; i < allpro.length; i++) {
		     if (allpro[i].type=="checkbox") {
		     allpro[i].checked=false;
		     }
		     }
		    }
		 }
		</script>	
<body class="skin-green sidebar-mini fixed">
	<div class="wrapper">
<!-- 导航栏 -->
<jsp:include page="kjs_navbar.jsp"></jsp:include>
<!-- 内容 -->
<div class="content-wrapper" style="min-height: 517px;">
		<!-- Content Header (Page header) -->

		<section class="content-header">
			<h1 class="dada">
			账户权限<small>共个</small>				
			</h1>			
		</section>
		<!-- Main content -->
		<section class="content">

			<div class="admin-tools">
				<div class="row">
					<div class="col-sm-10 admin-button">
					<div class="btn-group">
						
					<a data-toggle="modal" href="" data-target="#modal" style="background-color: #447feb;" class="btn btn-default">
					<i class="fa fa-edit"></i> 新增</a>
					<a href="javascript:;"  id="del_more_btn" style="background-color: #ff8700;"  class="btn btn-default">
					<i class="fa fa-trash-o"></i> 删除</a>
					</div>
					</div>
					<div class="col-sm-2 admin-page-top hidden-xs">
							<select id="page_limit_select" onchange="window.location.href='/assess/manager/index.php?type=sysset&amp;do=list&amp;cn=user_agp&amp;l='+this.value" class="form-control">
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
														
														<a href="/assess/manager/index.php?type=sysset&amp;do=list&amp;cn=user_agp&amp;p=2" class="btn btn-default">»</a>
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
			<th style="width: 3%" class="text-center hidden-xs">
			<input id="btcheck_all" class="check_all" onchange="change()" type="checkbox"></th>
			<th class="text-center hidden-xs" width="50">ID</th>
			<th class="text-center" width="200">权限组名</th>
			<th class="text-center">用户列表</th>
			<th class="text-center hidden-xs" width="100">添加时间</th>
			<th class="text-center" width="100">状态</th>
			<th class="text-center" width="100">操作</th>
		</tr>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="22" type="checkbox"></td>
			<td class="text-center hidden-xs">22</td>
			<td class="text-center"><span class="s-font-blue">快金所工行审核</span></td>
			<td class="text-center" style="width:50%;word-wrap:break-word;word-break:break-all;"><span class="s-font-blue">杨章伟,洪凯东,谢仙庆,李妍 ,庹杨 ,黄宗健,杨文娟,</span></td>
			<td class="text-center hidden-xs"><p>2018-06-04</p></td>
			<td class="text-center">
				<select id="showtag_22" onchange="ajax_edit(22,'showtag',this.value,'user_agp');" class="form-control">
					<option value="1">开通</option>
					<option value="0" selected="selected">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a href="index.php?type=sysset&amp;cn=user_agp&amp;do=form&amp;id=22" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_22" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="21" type="checkbox"></td>
			<td class="text-center hidden-xs">21</td>
			<td class="text-center"><span class="s-font-blue">点融</span></td>
			<td class="text-center" style="width:50%;word-wrap:break-word;word-break:break-all;"><span class="s-font-blue">刘舒凡,</span></td>
			<td class="text-center hidden-xs"><p>2018-04-18</p></td>
			<td class="text-center">
				<select id="showtag_21" onchange="ajax_edit(21,'showtag',this.value,'user_agp');" class="form-control">
					<option value="1">开通</option>
					<option value="0">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a href="index.php?type=sysset&amp;cn=user_agp&amp;do=form&amp;id=21" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_21" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="20" type="checkbox"></td>
			<td class="text-center hidden-xs">20</td>
			<td class="text-center"><span class="s-font-blue">快金所演示组</span></td>
			<td class="text-center" style="width:50%;word-wrap:break-word;word-break:break-all;"><span class="s-font-blue">快金所演示,快金所演示2,</span></td>
			<td class="text-center hidden-xs"><p>2018-03-31</p></td>
			<td class="text-center">
				<select id="showtag_20" onchange="ajax_edit(20,'showtag',this.value,'user_agp');" class="form-control">
					<option value="1">开通</option>
					<option value="0">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a href="index.php?type=sysset&amp;cn=user_agp&amp;do=form&amp;id=20" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_20" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="19" type="checkbox"></td>
			<td class="text-center hidden-xs">19</td>
			<td class="text-center"><span class="s-font-blue">发现编辑</span></td>
			<td class="text-center" style="width:50%;word-wrap:break-word;word-break:break-all;"><span class="s-font-blue">薛强,薛强,</span></td>
			<td class="text-center hidden-xs"><p>2018-03-20</p></td>
			<td class="text-center">
				<select id="showtag_19" onchange="ajax_edit(19,'showtag',this.value,'user_agp');" class="form-control">
					<option value="1">开通</option>
					<option value="0">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a href="index.php?type=sysset&amp;cn=user_agp&amp;do=form&amp;id=19" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_19" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="18" type="checkbox"></td>
			<td class="text-center hidden-xs">18</td>
			<td class="text-center"><span class="s-font-blue">快金所</span></td>
			<td class="text-center" style="width:50%;word-wrap:break-word;word-break:break-all;"><span class="s-font-blue">老的快金所测试,快金所测试,</span></td>
			<td class="text-center hidden-xs"><p>2018-03-12</p></td>
			<td class="text-center">
				<select id="showtag_18" onchange="ajax_edit(18,'showtag',this.value,'user_agp');" class="form-control">
					<option value="1">开通</option>
					<option value="0">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a href="index.php?type=sysset&amp;cn=user_agp&amp;do=form&amp;id=18" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_18" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="15" type="checkbox"></td>
			<td class="text-center hidden-xs">15</td>
			<td class="text-center"><span class="s-font-blue">客服部模块</span></td>
			<td class="text-center" style="width:50%;word-wrap:break-word;word-break:break-all;"><span class="s-font-blue">张颖,</span></td>
			<td class="text-center hidden-xs"><p>2018-04-08</p></td>
			<td class="text-center">
				<select id="showtag_15" onchange="ajax_edit(15,'showtag',this.value,'user_agp');" class="form-control">
					<option value="1">开通</option>
					<option value="0">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a href="index.php?type=sysset&amp;cn=user_agp&amp;do=form&amp;id=15" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_15" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="12" type="checkbox"></td>
			<td class="text-center hidden-xs">12</td>
			<td class="text-center"><span class="s-font-blue">车辆查询-快金所-点融-征信（风控部）</span></td>
			<td class="text-center" style="width:50%;word-wrap:break-word;word-break:break-all;"><span class="s-font-blue">陈明忠,王朱文,鄢继兴,林姝瑾,唐伟,林世民,</span></td>
			<td class="text-center hidden-xs"><p>2018-02-23</p></td>
			<td class="text-center">
				<select id="showtag_12" onchange="ajax_edit(12,'showtag',this.value,'user_agp');" class="form-control">
					<option value="1">开通</option>
					<option value="0">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a href="index.php?type=sysset&amp;cn=user_agp&amp;do=form&amp;id=12" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_12" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="10" type="checkbox"></td>
			<td class="text-center hidden-xs">10</td>
			<td class="text-center"><span class="s-font-blue">财务报表</span></td>
			<td class="text-center" style="width:50%;word-wrap:break-word;word-break:break-all;"><span class="s-font-blue">吴世玉,</span></td>
			<td class="text-center hidden-xs"><p>2018-01-24</p></td>
			<td class="text-center">
				<select id="showtag_10" onchange="ajax_edit(10,'showtag',this.value,'user_agp');" class="form-control">
					<option value="1">开通</option>
					<option value="0">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a href="index.php?type=sysset&amp;cn=user_agp&amp;do=form&amp;id=10" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_10" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="8" type="checkbox"></td>
			<td class="text-center hidden-xs">8</td>
			<td class="text-center"><span class="s-font-blue">车辆档案查询</span></td>
			<td class="text-center" style="width:50%;word-wrap:break-word;word-break:break-all;"><span class="s-font-blue">数据师3,韩振杰,,李旺,</span></td>
			<td class="text-center hidden-xs"><p>2017-12-04</p></td>
			<td class="text-center">
				<select id="showtag_8" onchange="ajax_edit(8,'showtag',this.value,'user_agp');" class="form-control">
					<option value="1">开通</option>
					<option value="0">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a href="index.php?type=sysset&amp;cn=user_agp&amp;do=form&amp;id=8" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_8" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
			<tr>
			<td class="text-center hidden-xs"><input name="delid" value="6" type="checkbox"></td>
			<td class="text-center hidden-xs">6</td>
			<td class="text-center"><span class="s-font-blue">车辆查询师</span></td>
			<td class="text-center" style="width:50%;word-wrap:break-word;word-break:break-all;"><span class="s-font-blue">zx2,zx3,洪凯东,浦馨月,铺馨月,</span></td>
			<td class="text-center hidden-xs"><p>2018-05-02</p></td>
			<td class="text-center">
				<select id="showtag_6" onchange="ajax_edit(6,'showtag',this.value,'user_agp');" class="form-control">
					<option value="1">开通</option>
					<option value="0">屏蔽</option>
				</select>
			</td>
			<td class="text-center">
				<div class="table-button">
					<a href="index.php?type=sysset&amp;cn=user_agp&amp;do=form&amp;id=6" class="btn btn-default"><i class="fa fa-pencil"></i></a>
					<a href="#" id="delid_6" class="btn btn-default"><i class="fa fa-trash"></i></a>
				</div>
			</td>
		</tr>
		</tbody>
</table>
				
			</div>
						<div class="foot-page">
				<ul class="pagination no-margin">
					  <li class="active"><a href="">1 <span class="sr-only">(current)</span></a></li> 
					  <li><a href="">2</a></li>
					  <li><a href="" aria-label="Next"><span aria-hidden="true">»</span></a></li>  				
					  </ul>
				<div class="page-num">共11个 分2页显示</div>
			</div>
	</section>
		</div>
		<script>
$(document).ready(function(){
	$("#info_form").submit(function(){
		//alert($("input:checkbox[name='orders']").val());
		if(this.name.value.length==0){
			alert("请输入管理组名称");
			return false;
		}
	});
});
function check(obj){
	obj.value=(obj.checked?"1":"0");
}
function checkall(obj,type){
	if (type==1){//勾选大类
        input = document.getElementsByTagName("input");
	    for (var i = 0; i < input.length; i++) {
	        if ((input[i].type == "checkbox")&&(input[i].name.length>0)&&(input[i].name.indexOf("/")<0)) {
	        		input[i].checked = obj.checked;
	            	input[i].value= obj.checked?1:0;
	        }
	    }	
	}else{
        input = document.getElementsByTagName("input");
	    for (var i = 0; i < input.length; i++) {
	        if ((input[i].type == "checkbox")&&(input[i].name.length>0)&&(input[i].name.indexOf("/")>=0)) {
	        		input[i].checked = obj.checked;
	            	input[i].value= obj.checked?1:0;
	        }
	    }	
		
	}
}
function checkfl(obj){
	obj.value=(obj.checked?"1":"0");
    input = document.getElementsByTagName("input");
    for (var i = 0; i < input.length; i++) {
        if ((input[i].type == "checkbox")&&(input[i].name.length>0)&&(input[i].name.indexOf(obj.name)>=0)) {
        		input[i].checked = obj.checked;
            	input[i].value= obj.checked?1:0;
        }
    }	
}
</script>
<!-- 弹窗框 -->
<div class="modal fade" id="modal" role="dialog" data-backdrop="static">
		<div class="modal-dialog" role="document">
			<div id="mycontent" class="modal-content" style="width: 800px">
			<div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
            <h4 class="modal-title" id="myModalLabel">新增权限组</h4>
            </div>
            <div class="modal-body">
            <div class="form-horizontal">
		<div class="box-body">
		<form id="info_form" class="form-horizontal" method="post" action=""  enctype="multipart/form-data" >
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">管理组名称</label>
				<div class="col-sm-10">
					<input class="form-control" name="name" placeholder="" type="text">
				</div>
			</div>
			<div class="form-group">
				<label for="link" class="col-sm-2 control-label">权限列表</label>
				<div class="col-sm-10">
					<table class="table table-bordered table-hover">
						<tbody>
							<tr>
							<th style="width: 140px">
							<label class="checkbox-inline">
							<input class="check_all" onclick="checkall(this,1)" type="checkbox">全选
							</label></th>
							<th>
							<label class="checkbox-inline">
							<input class="check_all" onclick="checkall(this,2)" type="checkbox">全选
							</label></th>
							</tr>
								<tr>
								<td>
								<label class="checkbox-inline">
								<input name="managerhome" id="managerhome" value="0" onclick="checkfl(this)" type="checkbox">管理中心</label>
								</td>
								<td>
								</td>
				                </tr>			
				                <tr>
								<td><label class="checkbox-inline"><input name="pggl" id="pggl" value="0" onclick="checkfl(this)" type="checkbox">评估管理</label>
								</td>
								<td> 
								<label class="checkbox-inline"><input name="pggl/qbpg" id="pggl/qbpg" value="0" onclick="check(this)" type="checkbox">全部评估</label>
								 
								<label class="checkbox-inline"><input name="pggl/tjpg" id="pggl/tjpg" value="0" onclick="check(this)" type="checkbox">添加评估</label>
								</td>
				                </tr>				
				                <tr>
								<td><label class="checkbox-inline"><input name="jmdgl" id="jmdgl" value="0" onclick="checkfl(this)" type="checkbox">认证加盟店管理</label>
								</td>
								<td> 
								<label class="checkbox-inline"><input name="jmdgl/syjmd" id="jmdgl/syjmd" value="0" onclick="check(this)" type="checkbox">所有加盟店</label>
								 
								<label class="checkbox-inline"><input name="jmdgl/tjjmd" id="jmdgl/tjjmd" value="0" onclick="check(this)" type="checkbox">添加加盟店</label>
								 
								<label class="checkbox-inline"><input name="jmdgl/jdsgl" id="jmdgl/jdsgl" value="0" onclick="check(this)" type="checkbox">鉴定师管理</label>
								 
								<label class="checkbox-inline"><input name="jmdgl/tjrzjds" id="jmdgl/tjrzjds" value="0" onclick="check(this)" type="checkbox">添加认证鉴定师</label>
								</td>
				</tr>				<tr>
								<td><label class="checkbox-inline"><input name="jrshdgl" id="jrshdgl" value="0" onclick="checkfl(this)" type="checkbox">金融商户端管理</label>
								</td>
								<td> 
								<label class="checkbox-inline"><input name="jrshdgl/dspgdd" id="jrshdgl/dspgdd" value="0" onclick="check(this)" type="checkbox">待审评估订单</label>
								 
								<label class="checkbox-inline"><input name="jrshdgl/已审评估订单" id="jrshdgl/已审评估订单" value="0" onclick="check(this)" type="checkbox">已审评估订单</label>
								 
								<label class="checkbox-inline"><input name="jrshdgl/所有评估订单" id="jrshdgl/所有评估订单" value="0" onclick="check(this)" type="checkbox">所有评估订单</label>
								 
								<label class="checkbox-inline"><input name="jrshdgl/商户店管理" id="jrshdgl/商户店管理" value="0" onclick="check(this)" type="checkbox">商户店管理</label>
								 
								<label class="checkbox-inline"><input name="jrshdgl/添加商户店" id="jrshdgl/添加商户店" value="0" onclick="check(this)" type="checkbox">添加商户店</label>
								 
								<label class="checkbox-inline"><input name="jrshdgl/商户师管理" id="jrshdgl/商户师管理" value="0" onclick="check(this)" type="checkbox">商户师管理</label>
								 
								<label class="checkbox-inline"><input name="jrshdgl/添加商户师" id="jrshdgl/添加商户师" value="0" onclick="check(this)" type="checkbox">添加商户师</label>
								 
								<label class="checkbox-inline"><input name="jrshdgl/待审车辆档案查询" id="jrshdgl/待审车辆档案查询" value="0" onclick="check(this)" type="checkbox">待审车辆档案查询</label>
								 
								<label class="checkbox-inline"><input name="jrshdgl/待审车辆保养查询" id="jrshdgl/待审车辆保养查询" value="0" onclick="check(this)" type="checkbox">待审车辆保养查询</label>
								 
								<label class="checkbox-inline"><input name="jrshdgl/已审车辆查询" id="jrshdgl/已审车辆查询" value="0" onclick="check(this)" type="checkbox">已审车辆查询</label>
								 
								<label class="checkbox-inline"><input name="jrshdgl/所有车辆查询" id="jrshdgl/所有车辆查询" value="0" onclick="check(this)" type="checkbox">所有车辆查询</label>
								 
								<label class="checkbox-inline"><input name="jrshdgl/待审征信查询" id="jrshdgl/待审征信查询" value="0" onclick="check(this)" type="checkbox">待审征信查询</label>
								 
								<label class="checkbox-inline"><input name="jrshdgl/已审征信查询" id="jrshdgl/已审征信查询" value="0" onclick="check(this)" type="checkbox">已审征信查询</label>
								 
								<label class="checkbox-inline"><input name="jrshdgl/所有征信查询" id="jrshdgl/所有征信查询" value="0" onclick="check(this)" type="checkbox">所有征信查询</label>
								 
								<label class="checkbox-inline"><input name="jrshdgl/通讯数据查询" id="jrshdgl/通讯数据查询" value="0" onclick="check(this)" type="checkbox">通讯数据查询</label>
								 
								<label class="checkbox-inline"><input name="jrshdgl/网贷黑名单" id="jrshdgl/网贷黑名单" value="0" onclick="check(this)" type="checkbox">网贷黑名单</label>
								 
								<label class="checkbox-inline"><input name="jrshdgl/银行卡实名" id="jrshdgl/银行卡实名" value="0" onclick="check(this)" type="checkbox">银行卡实名</label>
								</td>
				</tr>				<tr>
								<td><label class="checkbox-inline"><input name="shdzhsq" id="shdzhsq" value="0" onclick="checkfl(this)" type="checkbox">商户端账号申请</label>
								</td>
								<td> 
								<label class="checkbox-inline"><input name="shdzhsq/查看申请列表" id="shdzhsq/查看申请列表" value="0" onclick="check(this)" type="checkbox">查看申请列表</label>
								</td>
				</tr>				<tr>
								<td><label class="checkbox-inline"><input name="smcljc" id="smcljc" value="0" onclick="checkfl(this)" type="checkbox">上门车辆检测</label>
								</td>
								<td> 
								<label class="checkbox-inline"><input name="smcljc/所有预约上门检测" id="smcljc/所有预约上门检测" value="0" onclick="check(this)" type="checkbox">所有预约上门检测</label>
								</td>
				</tr>				
				                <tr>
								<td>
								<label class="checkbox-inline"><input name="pgfzsd" id="pgfzsd" value="0" onclick="checkfl(this)" type="checkbox">评估分值设定</label>
								</td>
								<td> 
								<label class="checkbox-inline"><input name="pgfzsd/外观漆面" id="pgfzsd/外观漆面" value="0" onclick="check(this)" type="checkbox">外观漆面</label>
								 
								<label class="checkbox-inline"><input name="pgfzsd/内饰检测" id="pgfzsd/内饰检测" value="0" onclick="check(this)" type="checkbox">内饰检测</label>
								 
								<label class="checkbox-inline"><input name="pgfzsd/车架结构" id="pgfzsd/车架结构" value="0" onclick="check(this)" type="checkbox">车架结构</label>
								 
								<label class="checkbox-inline"><input name="pgfzsd/泡水" id="pgfzsd/泡水" value="0" onclick="check(this)" type="checkbox">泡水</label>
								 
								<label class="checkbox-inline"><input name="pgfzsd/火烧" id="pgfzsd/火烧" value="0" onclick="check(this)" type="checkbox">火烧</label>
								 
								<label class="checkbox-inline"><input name="pgfzsd/底盘部件" id="pgfzsd/底盘部件" value="0" onclick="check(this)" type="checkbox">底盘部件</label>
								 
								<label class="checkbox-inline"><input name="pgfzsd/技术检测" id="pgfzsd/技术检测" value="0" onclick="check(this)" type="checkbox">技术检测</label>
								 
								<label class="checkbox-inline"><input name="pgfzsd/操控检测" id="pgfzsd/操控检测" value="0" onclick="check(this)" type="checkbox">操控检测</label>
								 
								<label class="checkbox-inline"><input name="pgfzsd/泡水火烧" id="pgfzsd/泡水火烧" value="0" onclick="check(this)" type="checkbox">泡水火烧</label>
								 
								<label class="checkbox-inline"><input name="pgfzsd/车型减分设定" id="pgfzsd/车型减分设定" value="0" onclick="check(this)" type="checkbox">车型减分设定</label>
								</td>
				                </tr>				
				                <tr>
								<td><label class="checkbox-inline"><input name="moneyqry" id="moneyqry" value="0" onclick="checkfl(this)" type="checkbox">财务查询</label>
								</td>
								<td> 
								<label class="checkbox-inline"><input name="moneyqry/czls" id="moneyqry/czls" value="0" onclick="check(this)" type="checkbox">流水查询</label>
								</td>
				</tr>				<tr>
								<td><label class="checkbox-inline"><input name="drzk" id="drzk" value="0" onclick="checkfl(this)" type="checkbox">点融专块</label>
								</td>
								<td> 
								<label class="checkbox-inline"><input name="drzk/所有订单" id="drzk/所有订单" value="0" onclick="check(this)" type="checkbox">所有订单</label>
								</td>
				</tr>				<tr>
								<td><label class="checkbox-inline"><input name="kjs" id="kjs" value="0" onclick="checkfl(this)" type="checkbox">快金所</label>
								</td>
								<td> 
								<label class="checkbox-inline"><input name="kjs/ycjj" id="kjs/ycjj" value="0" onclick="check(this)" type="checkbox">押车进件</label>
								 
								<label class="checkbox-inline"><input name="kjs/yzjj" id="kjs/yzjj" value="0" onclick="check(this)" type="checkbox">押证进件</label>
								</td>
				</tr>				<tr>
								<td><label class="checkbox-inline"><input name="kjfind" id="kjfind" value="0" onclick="checkfl(this)" type="checkbox">发现</label>
								</td>
								<td> 
								<label class="checkbox-inline"><input name="kjfind/all" id="kjfind/all" value="0" onclick="check(this)" type="checkbox">所有文章</label>
								</td>
				</tr>				<tr>
								<td><label class="checkbox-inline"><input name="sysset" id="sysset" value="0" onclick="checkfl(this)" type="checkbox">系统管理</label>
								</td>
								<td> 
								<label class="checkbox-inline"><input name="sysset/zhqx" id="sysset/zhqx" value="0" onclick="check(this)" type="checkbox">账号权限</label>
								 
								<label class="checkbox-inline"><input name="sysset/zhgl" id="sysset/zhgl" value="0" onclick="check(this)" type="checkbox">账号管理</label>
								 
								<label class="checkbox-inline"><input name="sysset/系统设定" id="sysset/系统设定" value="0" onclick="check(this)" type="checkbox">系统设定</label>
								</td>
				</tr>						</tbody>
					</table>
				</div>
			</div>
        </form>
		</div>
	</div>
            </div>
            <div class="modal-footer">
            <button type="button" class="btn btn-default pull-left" data-dismiss="modal" aria-label="Close">取消返回</button>
            <button type="submit" class="btn btn-danger" onclick="$('#info_form').submit()"  >保存提交</button>
            </div>
			</div>
		</div>
	</div>
<!-- 搜索 -->


</div>
</body>
</html>