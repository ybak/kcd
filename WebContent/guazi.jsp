<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0088)http://a.kcway.net/assess/manager/index.php?type=assess&cn=assess_query_dr&do=list&nav=1 -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.css">
	
	<title>维修保养API查询</title>
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
	 <link rel='stylesheet' href='css/iconfont.css'>
	 
   	 <link rel='stylesheet' href='css/amazeui.min.css'>
   	 <link rel='stylesheet' href='css/1.css' />
   	 <link rel='stylesheet' href='css/3.css' />
		
	<!-- AdminLTE App -->
	<script src="./acss/app.min.js" type="text/javascript"></script>
	 
	<script src="./acss/combo.js" type="text/javascript"></script>
	<script src="./acss/imgup.js" type="text/javascript"></script>
	<link href="./acss/imgup.css" rel="stylesheet" type="text/css">
	<!-- <script src="/comm/jquery.dragsort-0.4.min.js" type="text/javascript"></script> -->

	<link href="./acss/iconfont.css" rel="stylesheet" type="text/css">
	<style>@font-face{font-family:uc-nexus-iconfont;src:url(chrome-extension://pogijhnlcfmcppgimcaccdkmbedjkmhi/res/font_9qmmi8b8jsxxbt9.woff) format('woff'),url(chrome-extension://pogijhnlcfmcppgimcaccdkmbedjkmhi/res/font_9qmmi8b8jsxxbt9.ttf) format('truetype')}</style></head>
	
	<style type="text/css">
			.modal-backdrop {
			  opacity: 0 !important;
			  filter: alpha(opacity=0) !important;
			}
	</style>
	<body class="skin-green sidebar-mini fixed">	
<script>
$('li.active').parents('li').addClass('treeview').addClass('active');
</script>	

		<section class="content-header">
			<h1>汽车维修保养查询</h1>
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
								<select id="page_limit_select" onchange="a3()" class="form-control">
					                        <option  value="10" }>每页显示条数</option>
											<option value="2" ${page.pageSize==10?selected:''}>每页10条</option>
											<option value="20" ${page.pageSize==10?selected:''}>每页20条</option>
											<option value="30" ${page.pageSize==10?selected:''}>每页30条</option>
											<option value="40" ${page.pageSize==10?selected:''}>每页40条</option>
											<option value="50" ${page.pageSize==10?selected:''}>每页50条</option>
											<option value="60" ${page.pageSize==10?selected:''}>每页60条</option>
											<option value="70" ${page.pageSize==10?selected:''}>每页70条</option>
											<option value="80" ${page.pageSize==10?selected:''}>每页80条</option>
											<option value="90" ${page.pageSize==10?selected:''}>每页90条</option>
											<option value="100" ${page.pageSize==10?selected:''}>每页100条</option>
								</select>
					</div>
				</div>
				<script type="text/javascript">

						function a3(){
							var s=$("#page_limit_select").val();
							window.location.href ="${pageContext.request.contextPath}/sgi.do?pageSize="+s+"&pageNow=${page.pageNow}&conditionOne=${page.map.conditionOne}&conditionTwo=${page.map.conditionTwo}&conditionThree=${page.map.conditionThree}&conditionFour=${page.map.conditionFour}";
						}
				</script>
			</div>
			<div id="main_list" class="admin-content box">
					<!-- 数据载入中 请在搜索，筛选，载入的时候显示 放在.box里 -->
				<div class="overlay" style="display:none;">
					<i class="fa fa-refresh fa-spin"></i>
				</div>

				<c:choose> 
				  <c:when test="${empty page.listdata}">   
				    	<!-- 空数据界面 -->
				  </c:when> 
				  <c:otherwise>   
						<!-- 数据载入中结束 -->
						<table class="table table-bordered table-hover">
							<tbody>
								    <tr>
									<th class="hidden-xs ext-center" style="width:80px">来源公司-操作人</th>
									<th class="hidden-xs ext-center" style="width:80px">余额</th>
									<th class="hidden-xs ext-center" style="width:80px">姓名</th>
									<th class="hidden-xs ext-center" style="width:80px">手机号码</th>
									<th class="hidden-xs ext-center" style="width:130px">身份证号码</th>
									<th class="hidden-xs ext-center" style="width:130px">Vin码</th>
									<th class="hidden-xs ext-center" style="width:80px">查询时间</th>
									<th class="hidden-xs ext-center" style="width:80px">产生报告时间</th>
									<th class="text-center" style="width:80px">查看报告详情</th>
								<!-- 	<th style="width: 120px" class="text-center">更新状态</th> --> <!-- 重新发送请求获取车辆报告信息 -->
									<!-- <th style="width: 80px" class="text-center">查询状态</th>	 -->	
									</tr>
										
									<c:forEach items="${page.listdata}" var="listdata">
										<c:forEach items="${listdata.clist}"  var="vlist"> 
											<tr>
												<td class="hidden-xs">${listdata.api_companyname}-${listdata.api_name}</td>
												<td class="hidden-xs">${listdata.api_money}</td>
												<td class="hidden-xs">${listdata.api_name}</td>
												<td class="hidden-xs">${listdata.api_tel}</td>
												<td class="hidden-xs">${listdata.api_card}</td>
												<td class="hidden-xs">${vlist.gzVin}</td>
												<td class="hidden-xs">${vlist.gzAddtime}</td>
											    <td class="hidden-xs">${vlist.gzUptime}</td>	
												<td class="text-center" >
												 <a href="#" >
											      	 <span class="glyphicon glyphicon-list-alt" 
											       	data-toggle="tooltip" data-placement="bottom" title="点击查看报告详情"
											      	 onclick="b('${vlist.gzid}')">
											          </span>
											       </a>
												</td>	  
										  	  </tr>	 		
										</c:forEach>								
								    </c:forEach>
								</tbody>
							</table> 	
				  </c:otherwise> 
				</c:choose> 
		</div>
 <!-- 模态框（Modal） -->
<div class="modal fade"  id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog "  style="width: 1200px">
        <div class="modal-content" >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel"  >汽车维修保养查询详情</h4>
            </div>
           
			 <!-- 开始 -->
			<div class="box-body" id="resText">
			</div>				
			<!-- 结束 -->		
		
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
               <!--  <button type="button" class="btn btn-primary">提交更改</button> -->
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
		
		<script type="text/javascript">

	  	function b(b){
	  	   $.ajax({
		         url: "${pageContext.request.contextPath}/gbyid.do",
		         type: "POST",
		         data:{gid:b},
		         dataType: "text",
		         success: function(data){
		        	 var obj = JSON.parse(data); //由JSON字符串转换为JSON对象
		        	 $('#resText').empty(); //清空resText里面的所有内容 var html = ''; 
		        	 var v;
			        	html='<div style=" box-shadow: 0 0 5px 1px rgba(0, 0, 0, 0.05);  bor" class="am-margin-sm am-padding-sm am-radius-lg p-boxShadow p-panel p-panel-def p-yhOrder">'
		        			+'<div class="head"><div class="title"><div class="p-yhColor-blove">订单号：';
		        			html+=obj.unionId+'</div>'
		        			+'</div></div></div><div class="am-margin-sm  am-radius-lg p-boxShadow p-yhOrder p-yhOrder-keep">'
		        			+'<div class="repairBlk am-margin-top-sm"><span class="txt">检测结果</span><span class="status"></span></div><ul class="am-avg-sm-3 carSer">'
		        		+'<li class="am-padding-right-xs"><div class="item"><span class="tip"';
		
		        		var arr=new Array();
		        		arr=obj.data.summary.result_report.toString().split(',');
		        		var huo='非火烧';
						if(arr[0].toString().indexOf('无')!=-1){
							html+='style="color: #5BBA2C;"';
						}else{
							html+='style="color:red"';
							huo='火烧';
						}
		        		html+='><i class="iconfont icon-safe"></i></span><i class="iconfont icon-byFire mark"></i></div><div class="am-text-xs">'+huo+'</div></li><li>'
		        			+'<div class="item"><span class="tip"';
		        			var zh='重要部件正常';
			        		if(arr[2].toString().indexOf('异常')!=-1){
		        				html+='style="color:red"';
		        				zh='重要部件异常';
							}else{
								html+='style="color: #5BBA2C;"';
							}
		        			html+='><i class="iconfont icon-safe"></i></span><i class="iconfont icon-engine mark"></i></div><div class="am-block am-text-xs">';
		        			html+=zh+'</div></li><li class="am-padding-right-xs"><div class="item"><span class="tip"';
		        			var shui='非泡水车';
		        			if(arr[1].toString().indexOf('无')!=-1){
								html+='style="color: #5BBA2C;"';
							}else{
								html+='style="color:red"';
								shui='泡水车';
							}
		        			html+='><i class="iconfont icon-safe"></i></span><i class="iconfont icon-floodCar mark"></i></div><span class="am-block am-text-xs">'+shui+'</span>'
		        			+'</li><li class="am-padding-right-xs"><div class="item"><span class="tip"';
		        			var jie='结构件正常';
		        			if(arr[3].toString().indexOf('正常')!=-1){
								html+='style="color: #5BBA2C;"';
							}else{
								html+='style="color:red"';
								jie='结构件异常';
							}
		        			html+='><i class="iconfont icon-safe"></i></span><i class="iconfont icon-jiegoujian mark"></i></div><span class="am-block am-text-xs">'+jie+'</span>'
		        			+'</li><li class="am-padding-right-xs"><div class="item"><span class="tip"';
		        			var li='里程表正常';
		        			if(arr[5].toString().indexOf('正常')!=-1){
								html+='style="color: #5BBA2C;"';
							}else{
								html+='style="color:red"';
								li='里程表异常';
							}
		        			html+='><i class="iconfont icon-safe"></i></span><i class="iconfont icon-trip mark"></i></div><span class="am-block am-text-xs">'+li+'</span>'
		        			+'</li><li><div class="item"><span class="tip"';
		        			if(arr[4].toString().indexOf('正常')!=-1){
								html+='style="color: #5BBA2C;"';
							}else{
								html+='style="color:red"';
							}
		        			html+='><i class="iconfont icon-warn"></i></span><i class="iconfont icon-structuralCar mark"></i></div><span class="am-block am-text-xs">外观件异常</span></li></ul>'	
		        			+'<div class="repairBlk "><span class="txt">维修记录</span><span class="status"></span></div><ul class="am-avg-sm-4 carSer"><li class="am-padding-right-xs"><div class="am-text-xs">全部</div><span class="tips all">';
		        			var v=obj.data.records;
		        			var l=v.length;
		        			html+=l+'次</span></li><li>';
		        			var y;
		        			var v1;//jsonobject
		        			var t;//类型
		        			var j=0;//年份
		        			var s=0;//事故
		        			var w=0;//维修
		        			var b=0;//保养
		        			var html1="";
		        			for(var i=0;i<l;i++){
		        				v1=v[i];
		        				var d=v1.date.toString().substr(0,4);//data
		        				if(j!=d){//年份不相等得时候
		        					html1+='<span class="year">'+d+'</span>';
		        					j=d;
		        				}
		        				html1+='<div class="cnt"><ul class="infos">'
			        			+'<li><i class="iconfont icon-riqi"></i><span class="txt">'+v1.date+'</span></li>'
			        			+'<li><i class="iconfont icon-trip"></i><span class="txt">'+v1.mileage+'公里</span></li><li><i class="iconfont icon-maintain"></i><span class="txt">索赔</span></li>'
			        		 	+'</ul><div class="attr"><span class="lb">项目：</span><span class="val">'+v1.content+'</span></div>'
			        			+'<div class="attr"><span class="lb">备注：</span><span class="val">'+v1.remark+'</span></div></div>';
			        			
		        				t=v1.type.toString();
		        				if(t.indexOf('维修')!=-1){
		        					w++;
		        				}else if(t.indexOf('事故')!=-1){
		        					s++;
		        				}else{
		        					b++;
		        				}
		        			}
		        			html+='<div class="am-text-xs">事故</div><span class="tips danger">'+s+'次</span></li><li class="am-padding-right-xs"><div class="am-text-xs">维修</div><span class="tips warning">'+w+'次</span></li><li><div class="am-text-xs">保养</div><span class="tips success">'+b+'次</span></li></ul><div class="repairRecord">';
		        			html+=html1;
		        			html+='</div></div>';  
		        	 $('#resText').html(html); 
		        	 $('#myModal').modal({
		 	  			keyboard: false
		 	  		 }) 
		          },
		          error:function(err){
		            console.log(err.statusText);
		            console.log('异常');
		          }
		        });
	  	}
		</script>
		<div class="foot-page">
		<c:if test="${page.totalPageCount != '0' }"><!--  总的页数大于等于1 -->
				<ul class="pagination no-margin">
				       <c:if test="${page.pageNow > '1' }"> <!-- 当前页码大于一显示首页和上一页，否则不显示-->
				       <li >
				      <a href="${pageContext.request.contextPath}/sgi.do?pageNow=${page.pageNow-1}&pageSize=${page.pageSize}&conditionOne=${page.map.conditionOne}&conditionTwo=${page.map.conditionTwo}&conditionThree=${page.map.conditionThree}&conditionFour=${page.map.conditionFour}">
				       <span >«</span>
				       </a>
				       </li>
				       </c:if>
				       
				       <c:set var="begin" value="1" />
				       <c:set var="end"  value="10" />
				       <c:choose >
					       <c:when test="${page.totalPageCount > '10'}" > 
					       		<c:if test="${page.pageNow>=1 && page.pageNow<=6}"><!-- 如果当前页数大于等于1并小于6（在这里点击前6页得链接，都显示得是1到10页得链接） -->
					       			
					       		</c:if>
					       		
					       		<c:if test="${page.pageNow>6 && page.pageNow<=page.totalPageCount-4}"><!-- 如果当前页数大于6，并且小于等与总页数；则循环显示当前页-5，到当前页+5的链接 -->
					       				<c:set var="begin" value="${page.pageNow-5}" />
				    				    <c:set var="end"  value="${page.pageNow+5}" />
					       		</c:if>
					       		
					       		<c:if test="${page.pageNow>page.totalPageCount-4 && page.pageNow<=page.totalPageCount}"><!-- 如果当前页大于总页数-4，并且小于总页数（意思就是点击最末尾的四个链接，就显示最后十个链接） -->
					       				<c:set var="begin" value="${page.totalPageCount-9}" />
				    				    <c:set var="end"  value="${page.totalPageCoun}" />
					       		</c:if>
					       </c:when> 
				       		<c:otherwise><!-- 如果总页数小于等与十页就直接把所有链接循环输出。 -->
				       			<%-- <c:forEach begin="1" end="${page.totalPageCount}" varStatus="i" step="1">
						       				<li  class="active">
											   <a  href=" ">
													${i.index}
											   </a>
											</li>
					       		</c:forEach> --%>
				    			<c:set var="end"  value="${page.totalPageCount}" />
				       		</c:otherwise>
				       </c:choose>
				       
				       	<c:forEach begin="${begin}" end="${end}" varStatus="i" step="1">
				       		<c:choose>
				       			<c:when test="${i.index==page.pageNow}"> <!-- 是当前的按钮 -->
				       				<li  class="active">
										   <a  href="${pageContext.request.contextPath}/sgi.do?pageNow=${i.index}&pageSize=${page.pageSize}&conditionOne=${page.map.conditionOne}&conditionTwo=${page.map.conditionTwo}&conditionThree=${page.map.conditionThree}&conditionFour=${page.map.conditionFour}">
												${i.index}
										   </a>
									</li>
				       			</c:when>
					       			
								<c:otherwise>
									<li  class="">
										   <a  href="${pageContext.request.contextPath}/sgi.do?pageNow=${i.index}&pageSize=${page.pageSize}&conditionOne=${page.map.conditionOne}&conditionTwo=${page.map.conditionTwo}&conditionThree=${page.map.conditionThree}&conditionFour=${page.map.conditionFour}">
												${i.index}
										   </a>
									</li>
								</c:otherwise>
				       	</c:choose>

					   </c:forEach>
				       <c:if test="${page.pageNow<page.totalPageCount}"><!-- 如果当前页小于总页数，就显示下一页和尾页的按钮 -->
				       		 <li>
							   <a href="${pageContext.request.contextPath}/sgi.do?pageNow=${page.pageNow+1}&pageSize=${page.pageSize}&conditionOne=${page.map.conditionOne}&conditionTwo=${page.map.conditionTwo}&conditionThree=${page.map.conditionThree}&conditionFour=${page.map.conditionFour}">
							   <span>»</span>
							   </a>
							 </li>
				       </c:if>
				</ul>
			</c:if>
			<div class="page-num">共${page.totalCount}条数据分${page.totalPageCount}页显示</div>
		</div>
	</section>
		
		
	<script type="text/javascript" src="./acss/list.js"></script>		
			<!-- 搜索层 -->
	<aside class="control-sidebar control-sidebar-dark" style="position: fixed; max-height: 100%; overflow: auto; padding-bottom: 50px;">
	<div class="tab-content">
		<!-- Home tab content -->
		<h3 class="control-sidebar-heading">开始搜索</h3>
		<form id="search_form" method="post"  action="${pageContext.request.contextPath}/sgi.do">
			<input type="hidden" name="pageSize" value="${page.pageSize}">
			<div class="form-group">
				<label>创建时间区间</label>
				<div class="input-group">
					<input type="text" class="form-control daterange" name="conditionOne"  value="" placeholder="区间">
					<div class="input-group-addon"><i class="fa fa-calendar"></i></div>
				</div>
			</div>
			<div class="form-group">
				<label>输入appkey/公司名称</label> 
				<input type="text" name="conditionTwo" value="" class="form-control" placeholder="比如快车道或8888">
			</div>
			<div class="form-group">
				<label>输入vin码</label> 
				<input type="text" name="conditionThree" value="" class="form-control" placeholder="比如快车道或8888">
			</div>
		<!-- 	<div class="form-group">
				<label>订单状态</label> 
				<select class="form-control" name="conditionFour">
					<option value="0" selected="selected">请选择</option>
					
					<option value="1">正在查询</option>
					<option value="2">查询完成</option>	
				</select>
			</div> -->
			当前搜索范围：所有订单<button type="submit"  class="btn btn-block btn-primary">搜索</button>
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