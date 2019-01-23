<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link href="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/bootstraptable/bootstrap-table.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/bootstraptable/bootstrap-table.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/bootstraptable/bootstrap-table-zh-CN.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/kjs_icbc/kjs_icbc_style/bootstrapTree/bootstrap-treeview.js" type="text/javascript"></script>
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
	
	/*未选中*/
	.treeview .list-group-item.node-checked {
	    color: red;
	}
	/*已选中*/
	.treeview .list-group-item.node-selected {
	    color: red;
	   
	}
</style>
<div class="content-wrapper" style="min-height: 876px;">
	<!-- Main content -->
	<section class="content">
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
	        <button type="button" id="exportDefault" class="btn btn-default">默认报表导出</button>
	        <button type="button" id="exportDynamic" class="btn btn-default">动态报表导出</button>
	  </div>
		  
   		<!-- 模态框（Modal） -->
		<div class="modal fade" id="myModa2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog" style="width: 800px;">
		        <div class="modal-content" >
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">财务信息详情</h4>
		            </div>
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
							  <li class="text-primary">
							  	<em>客户信息</em>
							  	<div class="big-conte" >
							  		<div class="big-conte-row">
							  			<span class="text-muted">姓名:</span>
								  		<input type="text" class="form-control" id="name">
								  		<span class="text-muted">合同编号:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  		
							  		<div class="big-conte-row">
							  			<span class="text-muted">性别:</span>
								  		<input type="text" class="form-control" id="name">
								  		<span class="text-muted">放款日期:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  		
							  		<div class="big-conte-row">
							  			<span class="text-muted">地区:</span>
								  		<input type="text" class="form-control" id="name">
								  		<span class="text-muted">车辆评估价</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  		
							  		<div class="big-conte-row">
							  			<span class="text-muted">渠道商:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  	</div>
							  </li>
							  
							<li class="text-primary">
							  	<em>起贷情况</em>
							  	<div class="big-conte" >
							  		<div class="big-conte-row">
							  			<span class="text-muted">贷款总额:</span>
								  		<input type="text" class="form-control" id="name">
								  		<span class="text-muted">贷款本金:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  		
							  		<div class="big-conte-row">
							  			<span class="text-muted">金融服务费:</span>
								  		<input type="text" class="form-control" id="name">
								  		<span class="text-muted">银行手续费:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  		
							  		<div class="big-conte-row">
							  			<span class="text-muted">本息合计:</span>
								  		<input type="text" class="form-control" id="name">
								  		<span class="text-muted">车辆评估价</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  		
							  		<div class="big-conte-row">
							  			<span class="text-muted">首月还金额:</span>
								  		<input type="text" class="form-control" id="name">
								  		<span class="text-muted">次月还金额:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  		<div class="big-conte-row">
							  			<span class="text-muted">安联金融服务费:</span>
								  		<input type="text" class="form-control" id="name">
							  			<span class="text-muted">快加金融服务费:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  		<div class="big-conte-row">
							  			<span class="text-muted">渠道金融服务费:</span>
								  		<input type="text" class="form-control" id="name">
							  			<span class="text-muted">起贷日:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  			<div class="big-conte-row">
							  			<span class="text-muted">到期日:</span>
								  		<input type="text" class="form-control" id="name">
							  			<span class="text-muted">还款时间:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  		<div class="big-conte-row">
							  			<span class="text-muted">贷款期限:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  	</div>
							  </li>
							  
							<li class="text-primary">
							  	<em>当月回款情况</em>
							  	<div class="big-conte" >
							  		<div class="big-conte-row">
							  			<span class="text-muted">当月期次:</span>
								  		<input type="text" class="form-control" id="name">
								  		<span class="text-muted">还款状态:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  		<div class="big-conte-row">
							  			<span class="text-muted">当月还款(本金):</span>
								  		<input type="text" class="form-control" id="name">
								  		<span class="text-muted">当月还款(利息):</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  		<div class="big-conte-row">
							  			<span class="text-muted">当月应还额:</span>
								  		<input type="text" class="form-control" id="name">
								  		<span class="text-muted">当月实际罚息:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  		<div class="big-conte-row">
							  			<span class="text-muted">当月实际还款金额(本金):</span>
								  		<input type="text" class="form-control" id="name">
								  		<span class="text-muted">当月实际还款(利息):</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  		<div class="big-conte-row">
							  			<span class="text-muted">当月实际还款:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  	</div>
							  </li>
				
							  <li class="text-primary">
							  	<em>累计回款情况</em>
							  	<div class="big-conte" >
							  		<div class="big-conte-row">
							  			<span class="text-muted">累计还款(本金):</span>
								  		<input type="text" class="form-control" id="name">
								  		<span class="text-muted">累计还款(利息):</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  		<div class="big-conte-row">
							  			<span class="text-muted">累计还款(罚息):</span>
								  		<input type="text" class="form-control" id="name">
								  		<span class="text-muted">累计还款金额:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  	</div>
							  </li>
							  
							  <li class="text-primary">
							  	<em>剩余贷款情况</em>
							  	<div class="big-conte" >
							  		<div class="big-conte-row">
							  			<span class="text-muted">剩余本金:</span>
								  		<input type="text" class="form-control" id="name">
								  		<span class="text-muted">剩余利息:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  		<div class="big-conte-row">
							  			<span class="text-muted">剩余总金额:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  	</div>
							  </li>
							  
							  <li class="text-primary">
							  	<em>逾期情况</em>
							  	<div class="big-conte" >
							  		<div class="big-conte-row">
							  			<span class="text-muted">逾期发生日期:</span>
								  		<input type="text" class="form-control" id="name">
								  		<span class="text-muted">逾期发生天数:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  		<div class="big-conte-row">
							  			<span class="text-muted">逾期金额:</span>
								  		<input type="text" class="form-control" id="name">
								  		<span class="text-muted">已还金额:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  		<div class="big-conte-row">
							  			<span class="text-muted">已还期数:</span>
								  		<input type="text" class="form-control" id="name">
								  		<span class="text-muted">未还期数:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  	</div>
							  </li>
							  
							  <li class="text-primary">
							  	<em>快加代还情况</em>
							  	<div class="big-conte" >
							  		<div class="big-conte-row">
							  			<span class="text-muted">代还日期:</span>
								  		<input type="text" class="form-control" id="name">
								  		<span class="text-muted">代还期数:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  		<div class="big-conte-row">
							  			<span class="text-muted">代还本金:</span>
								  		<input type="text" class="form-control" id="name">
								  		<span class="text-muted">代还利息:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  		<div class="big-conte-row">
							  			<span class="text-muted">代还金额:</span>
								  		<input type="text" class="form-control" id="name">
							  		</div>
							  	</div>
							  </li>
							  
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
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
  
		  
		  
		  
		<!-- 点击重置触发模态框 -->
		<div class="modal fade" id="myModal" data-backdrop="false" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog" style="width:500px;">
		        <div class="modal-content">
		            <div class="modal-header">
		                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                <h4 class="modal-title" id="myModalLabel">请选择导出项</h4>
		            </div>
		            <style>
						/*未选中*/
						.treeview .list-group-item.node-checked {
						    color: red;
						}
						/*已选中*/
						.treeview .list-group-item.node-selected {
						    color: red;
						}
					</style>
		            <div class="modal-body" style="height: 700px">
		            		<!--放树的盒子-->
		            		<div style="margin-bottom: 10px;">
		            			<button type="button" class="btn btn-default">全选</button>
		            			<button type="button" class="btn btn-default">反选</button>
		            		</div>
				            <div id="tree" style="height:650px;overflow-y :scroll;">
				            		
				            </div>
		            </div>		
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		                <button type="button" id="exportexcel" class="btn btn-primary">确认导出</button>
		            </div>
		          <!--  bootstrap tree -->
		            <script>
		            	$("#exportexcel").click(function(){
			          		$.each($('#tree').treeview('getChecked'), function(index,value) {
			          			alert(value.nodeId);
			          		});
		            	})

		            	$("#exportDefault").click(function(){
		            		//获取选中的select 返回一个数组
		            		var row=$.map($("#mytab").bootstrapTable('getSelections'),function(row){
		            			return row ;
		            		});
		            		//console.log(row);
		            		if(row.length>0){
		            			var ids="";
		            			for(var i=0;i<row.length;i++){
			            			if(i==0 || i=="0"){
				            			ids+=row[i].su;
				            			}else{
				            			ids+=","+row[i].su;
			            			}
		            			}
		            			console.log("id："+ids.toString());
		            			$('#myModal').modal('show');
		            		}
		            	})
		            	
		            	/*tree开始*/
		            	var tree = [
						  {
						    text: "客户信息",
						    nodes: [
						      {
						        text: "客户姓名"
						      },{
						      	text:"性别"
						      },
						      {
						        text: "放款日期"
						      },{
						      	text:"车辆品牌型号"
						      },{
						      	text:"车辆评估价"
						      },{
						        text: "渠道商"
						      }
						    ]
						  },
						  {
						    text: "起贷情况",
						    nodes: [
						      {
						        text: "贷款总额" 
						      },
						      {
						        text: "贷款本金"
						      },{
						      	text:"金融服务费"
						      },{
						      	text:"银行手续费"
						      },{
						      	text:"本息合计"
						      },{
						      	text:"月还金额"
						      },{
						      	text:"安联金融服务费"
						      },{
						      	text:"快加金融服务费"
						      },{
						      	text:"渠道商金融服务费"
						      }
						    ]
						  },{
						    text: "当月回款情况",
						    nodes: [
						      {
						        text: "当月期次"
						      },{
						      	text:"还款状态"
						      }
						    ]
						  }
						];
		            	$("#tree").treeview({
						    data : tree,// 赋值
						    highlightSelected : false,// 选中项不高亮，避免和上述制定的颜色变化规则冲突
						    multiSelect : false,// 不允许多选，因为我们要通过check框来控制
						    showCheckbox : true,// 展示checkbox
						    /*节点被选中*/
						    onNodeChecked : function(event,node) {						   
							    if (node.nodes != null) {
							    	//如果存在子节点 那么子节店全部选中
							    	//触发nodeChecked事件
							        $.each(node.nodes, function(index, value){
							        	//变红并选中
							            $("#tree").treeview('checkNode',value.nodeId, {
							                silent : true
							            });
							        });
							    } else{
							        // 如果不存在子节点
							        // 获得当前节点的父节点
							        var parentNode = $("#tree").treeview('getParent', node.nodeId);
							        var isAllchecked = true; // 是否全部选中
							        // 获得所有的兄弟节点
							        var siblings = $("#tree").treeview('getSiblings', node.nodeId);
							      	/*遍历所有的兄弟节点 */
							        for ( var i in siblings) {
							            // 有一个没选中，则不是全选
							            if (!siblings[i].state.checked) {
							                isAllchecked = false;
							                break;
							            }
							        }
							        // 全选，则打钩
							        if (isAllchecked) {
							            $("#tree").treeview('checkNode', parentNode.nodeId, {
							                silent : true
							            });
							        } else {// 非全选，则变红
							            $("#tree").treeview('selectNode', parentNode.nodeId, {
							                silent : true
							            });
							        }
							    }
							},
							/*取消选中*/
							onNodeUnchecked : function(event,node) {
						    if (node.nodes != null) {
						    	//取消选中父节点 让父节点下的子节点全部取消选中
						     	$.each(node.nodes, function(index, value) {
						                $("#tree").treeview('uncheckNode', value.nodeId, {
						                    silent : true
						                });
						            });
						    } else {
						    	//获得父节点
						        var parentNode =  $("#tree").treeview('getParent', node.nodeId);
						        var isAllUnchecked = true; // 是否全部取消选中
						        // 子节点有一个选中，那么就不是全部取消选中
						        var siblings =  $("#tree").treeview('getSiblings', node.nodeId);
						        for ( var i in siblings) {
						            if (siblings[i].state.checked) {
						                isAllUnchecked = false;
						                break;
						            }
						        }
						        // 全部取消选中
						        if (isAllUnchecked){
						            $("#tree").treeview('unselectNode', parentNode.nodeId, {
						                silent : true,
						            });
						             $("#tree").treeview('uncheckNode', parentNode.nodeId, {
						                silent : true,
						            });
						        }
						    }
						},
						//折叠所有的节点，折叠整个树
						}).treeview('collapseAll', { silent: true });
						/*tree结束*/
					</script>
		           
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>		
		
		<!--bootstrap table存放工具栏的盒子 -->
		<div id="toolbar"></div>
		
		<!--bootstrap table 存放数据的盒子 -->
		<table  class="table table-bordered " id="mytab" style="word-break: keep-all;"> 
		
		</table>	
		
		
		<script>
		
			/* 开始使用vue.js */
			
			/* var vm=new Vue({
				el:'#export',
				methods:{
					
				}
			}); */
			/* 结束vue.js */
			 //查询按钮事件
		    $('#search_btn').click(function(){
		        $('#mytab').bootstrapTable('refresh', {url: '../index.php/admin/index/userManagement'});
		    })
			/* 查看详情 */
		 	function EditViewById(id){
		    	$('#myModa2').modal('show')
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
	</section><!-- /.content -->
</div>

