<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/js/echarts.min.js" ></script> 
<script src="${pageContext.request.contextPath}/kjs_icbc/kjs_icbc_style/layer/layer.js" type="text/javascript"></script> 
<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/bootstraptable/bootstrap-table.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/bootstraptable/bootstrap-table.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/bootstraptable/bootstrap-table-zh-CN.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css">
<style>
	/* 头部搜索框开始 */
	.my-container {
	    float: left;
	    display: inline-block;
	    margin-right:30px;
	    margin-bottom: 5px;
	}
	.myLabel-content{
		width:70px;
		line-height: 30px;
	}
	.myLabel-content ,.myText-content{
	    float: left;
	    display: inline-block;
	    margin-left: 10px;
	}
	.my-container .btn {
	    height: 30px;
	    font-size: 12px;
	    margin-bottom: 10px;
	}
	
	.my-container-nextline{
		clear:left;
	}
	/* 头部搜索框结束 */
	
	/* 表格的行样式 */
	tr{
		background:white;
	}
</style> 
<div class="content-wrapper" style="min-height: 876px;">
		<!-- Main content -->
		<section class="content">
			<!-- 头部搜索开始-->
			<div class="my-container">
		        <label class="myLabel-content">姓名：</label>
		        <div class="myText-content">
		            <input id="name" type="text" class="form-control" >
		        </div>
		    </div>
		    <div class="my-container">
		        <label class="myLabel-content">机构：</label>
		        <div class="myText-content">
		            <input id="organization" type="text" class="form-control" >
		        </div>
		    </div>
		     <div class="my-container">
		        <label class="myLabel-content">期数：</label>
		        <div class="myText-content">
		          	<select class="form-control"  id="periods">
						<option selected="selected" value="36">36</option>
						<option value="24">24</option>
					</select>
		        </div>
		    </div>
	
		  <!-- 第二行 -->
		  <div class="my-container my-container-nextline">
		  	<div class="my-container">
		        <label class="myLabel-content">开始日期：</label>
		        <div class="myText-content">
		            <input id="name" type="text" class="form-control" >
		        </div>
		    </div>
		  	<div class="my-container">
		        <label class="myLabel-content">条件：</label>
		        <div class="myText-content">
		            <input id="name" type="text" class="form-control" >
		        </div>
		    </div>
		  </div>
		  <!-- 第三行 -->
		  <div class="my-container my-container-nextline">
		        <button id="search" type="button" class="btn btn-primary">搜索</button>
		        <button id="reset" type="button" class="btn btn-default">重置</button>
		  </div>
		 <!-- 头部搜索结束-->
		<!--bootstrap table存放工具栏的盒子 -->
		<div id="toolbar"></div>
		<!--bootstrap table 存放数据的盒子 -->
		<table  class="table table-bordered " id="mytab" style="word-break: keep-all;"> 
		</table>	
		<script>
		
			 //查询按钮事件
		    $('#search_btn').click(function(){
		        $('#mytab').bootstrapTable('refresh', {url: '../index.php/admin/index/userManagement'});
		    })
			/* 查看详情 */
		 	function EditViewById(id){
		    	$('#myModal').modal('show')
			}
			
		    //请求服务数据时所传参数
		    function queryParams(params){
		        return{
		            //页面的大小
		            pagesize: params.limit,
		            //请求第几页
		            pageIndex:params.pageNumber,
		            name:$('#name').val(),
		            periods:$('#periods').val(),
		            organization:$('#organization').val()
		        }
		    }
			//根据窗口调整表格高度
		    $(window).resize(function() {
		        $('#mytab').bootstrapTable('resetView', {
		            height: tableHeight()
		        })
		    })
		    
	        //操作栏的格式化
	        function actionFormatter(value, row, index) {
	            var id = value;
	            var result = "";
	            result += "<a href='javascript:;' class='btn btn-xs green' onclick=\"EditViewById('" + id + "')\" title='查看'><span class='glyphicon glyphicon-search'></span></a>";
	           	return result;
	        }
			//生成用户数据
		    $('#mytab').bootstrapTable({
		      	/* method: 'post',
		        url:"",//要请求数据的文件路径  */
		        contentType: "application/x-www-form-urlencoded",//必须要有！！！！
		        height:tableHeight(),//高度调整
		        toolbar: '#toolbar',//指定工具栏
		        striped: true, //是否显示行间隔色
		        dataField: "res",//bootstrap table 可以前端分页也可以后端分页，这里
		        //我们使用的是后端分页，后端分页时需返回含有total：总记录数,这个键值好像是固定的  
		        //rows： 记录集合 键值可以修改  dataField 自己定义成自己想要的就好
		        pageNumber: 1, //初始化加载第一页，默认第一页
		        pagination:true,//是否分页
		        queryParamsType:'limit',//查询参数组织方式
		        queryParams:queryParams,//请求服务器时所传的参数
		        sidePagination:'client',//指定服务器端分页
		        pageSize:3,   		//单页记录数
		 	    sortable: true,      //是否启用排序
                sortOrder: "asc",    //排序方式
                uniqueId: "ID",      //每一行的唯一标识，一般为主键列 */
		        pageList:[5,10,20,30],//分页步进值
		        showRefresh:true,//刷新按钮
		        showColumns:true,
		        clickToSelect: true,//是否启用点击选中行
		        toolbarAlign:'right',//工具栏对齐方式
		        buttonsAlign:'right',//按钮对齐方式
		        columns:[
		            {
		                title:'全选',
		                field:'id',
		                //复选框
		                checkbox:true,
		                width:25,
		                align:'center',
		                valign:'middle'
		            },
		            {
		                title:'卡号',
		                field:'gc',
		                visible:false
		            },
		            {
		                title:'姓名',
		                field:'name',
		                sortable:true //是否启用排序
		            },
		            {
		                title:'贷款总额',
		                field:'dtp',
		                align:'center'
		            },
		            {
		                title:'分期期数',
		                field:'ad',
		                align:'center'
		            },
		            {
		                title:'已还期数',
		                field:'cou',
		                align:'center'
		            },
		            {
		                title:'已还金额',
		                field:'su',
		                align:'center'
		            },
		            {
		                title:'已还金额',
		                field:'su',
		                align:'center'
		            },
		            {
		                title:'当前状态',
		                field:'status',
		                align:'center'
		            }, {
	                    field:'ID',
	                    title: '操作',
	                    width: 120,
	                    align: 'center',
	                    valign: 'middle',
	                    formatter: actionFormatter
	                }
		            
		        ],
		        data:[{
		        	id:"2",
		        	su:'1000',
		        	status:'还款中'
		        },
		        {
		        	id:"4",
		        	su:'1000',
		        	status:'初级逾期'
		        },
		        {
		        	id:"1",
		        	su:'1000',
		        	status:'已还清'
		        }],
		        locale:'zh-CN',//中文支持,
		        responseHandler:function(res){
		            //在ajax获取到数据，渲染表格之前，修改数据源
		            return res;
		        }
		    })
	
		    //tableHeight函数
		    function tableHeight(){
		        //可以根据自己页面情况进行调整
		        return $(window).height() -280;
		    }
		</script>
			
			
			
<!-- 模态框（Modal） 用来显示视图-->
<div  class="modal fade" id="myModal" tabindex="-1" role="dialog" data-backdrop="false" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 800px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					客户分期还款图
				</h4>
			</div>
			<div class="modal-body" >
				
					   <!--  详情 -->
					    <div style="width: 550px; margin: 0 auto;padding-top: 20px;padding-left:45px">
							<table class="table">
								<caption>具体信息</caption>
							   <thead>
							      <tr>
							         <th>期数</th>
							         <th>还款日期</th>
							         <th>实际还款日期</th>
							         <th>应还款金额</th>
							         <th>实际还款金额</th>
							         <th>罚息</th>
							         <th>还款状态</th>
							      </tr>
							   </thead>
							   <tbody>
							      <tr>
							         <td>1</td>
							         <td>2018-1-14</td>
							         <td>2018-1-13</td>
							         <td>3340.12</td>
							         <td>3340.12</td>
							         <td>0</td>
							         <td>已还款</td>
							      </tr>
							       <tr>
							         <td>1</td>
							         <td>2018-2-15</td>
							         <td>2018-2-17</td>
							         <td>3316</td>
							         <td>3316</td>
							          <td>0</td>
							         <td>已还款</td>
							      </tr>
							      <tr>
							         <td>1</td>
							         <td>2018-3-15</td>
							         <td>2018-3-15</td>
							         <td>3316</td>
							         <td>3316</td>
							          <td>0</td>
							         <td>已还款</td>
							      </tr>
							   </tbody>
							</table>
						</div>
								
						<!--  报表开始 -->
						<div  id="container" style="height:450px;width:600px; margin-left: 100px ">
						
						</div>
						 <script type="text/javascript">
								var dom = document.getElementById("container");
								var myChart = echarts.init(dom);
								var app = {};
								option = null;
								var dataAll = [
								    [
								        [1,1],
								        [2,-2],
								       	[3, 0]/* ,
								        [4, 0],
								        [5, 1],
								        [6, 0],
								        [7, -2],
								        [8, 4.22],
								        [9, 0],
								        [10, 0],
								        [11, 1],
								        [12, 0],
								        [13, 0],
								        [14, 2],
								        [15, 2],
								        [24,90] */
								    ]
								];
								option = {
								    title: {
								        text: '个人已还款情况',
								        subtext:'X轴以上：代表每期提前还款天数;X轴以下:代表每期逾期天数',
								        left:'center'
								    },
								    grid: [
								        {width: '500px', height: '350px',top:'80px'}
								    ],
								    tooltip: {
								        formatter: '(期数,天数):{c}'
								    },
								    xAxis: [
								        {maxInterval:1}
								    ],
								    yAxis: [
								        {name: '单位:(天)',max:31}
								    ],
								    series: [
								        {
								            name: 'I',
								            type: 'scatter',
								            xAxisIndex: 0,
								            yAxisIndex: 0,
								            data: dataAll[0],
								            /*markLine: markLineOpt*/
									        /* 标记线*/
										    markPoint:{
										    	data:[
										    		{type:'max',name:'最大值',symbolSize:[60,50]},
										    		/*symbol：标记的图形 */
										    		{type:'min',name:'最小值',symbolSize:[60,50]}
										    	]
									   		}
								        }
								    ]
								};;
								if (option && typeof option === "object") {
								    myChart.setOption(option, true);
								}
						</script>
			</div>
			<div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary">提交更改</button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>			
		</section>
</div>

