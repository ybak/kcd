<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- 引入日期插件js -->
<script src="${pageContext.request.contextPath}/kjs_icbc/kjs_icbc_style/laydate/laydate.js" type="text/javascript"></script> 
<script src="${pageContext.request.contextPath}/kjs_icbc/kjs_icbc_style/layer/layer.js" type="text/javascript"></script>   
<script src="${pageContext.request.contextPath}/kjs_icbc/kjs_icbc_style/developerLwStyle/index.js" type="text/javascript"></script>   

<div class="form-horizontal">
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper fixed-footer" style="min-height: 943px;">
		<!-- Main content -->
		<section class="content"> <input name="type" value="icbc"
			type="hidden"> <input name="dn" value="assess_fs"
			type="hidden"> <input name="qn" value="list" type="hidden">
		<div class="admin-content nav-tabs-custom box">

		<!-- 弹出层 结束-->
			<div class="box-header with-border">
				<h3 class="box-title">录入还款信息</h3>
			</div>
			<ul class="nav nav-tabs">
				<li class="active" onclick="hk_formfun0('dange')" id="ru" ><a href="javascript:void(0)">单个录入</a></li>
				<li onclick="hk_formfun0('piliang')" id="ru"><a href="javascript:void(0)">批量导入</a></li>
			</ul>
			<!-- excel导入开始 -->
			<div id="piliang" style="padding: 20px; display:none;">
				<div class="form-group">
					<div class="col-sm-10 col-sm-offset-2">
						<div class="row inline-from">
							<div class="col-sm-4">
								<a href="../erp/lrt.do">Excel模板下载</a>
							</div>
						</div>
					</div>
				</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">Excel文件:</label>
						<div class="col-sm-10">
							<div class="row inline-from">
								<div class="col-sm-2">
									<input type="file" id="inputfile" onchange="getFilesize(this)">
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-2 control-label">是否关联到现有的客户</label>
						<div class="col-sm-10">
							<div class="row inline-from">
								<div class="col-sm-2">
									<div class="checkbox">
										<label class="radio-inline">
											<input type="radio" value="1" name="optionsRadios" id="optionsRadios" value="1">(通过订单号关联当前用户)
										</label>
									</div>
								</div>
								<div class="col-sm-2">
									<div class="checkbox">
									<label class="radio-inline">
										<input type="radio"  value="2" name="optionsRadios" id="optionsRadios"  value="2">(通过开卡号关联当前用户)
									</label>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row" style="margin-top: 25px">
						<div class="col-sm-10">
							<div class="col-sm-5 col-md-offset-2">
								<button type="button" class="btn btn-default">重置</button>
								<button type="button" oncli class="btn btn-primary"
								 style="margin-left: 150px">提交</button>
							</div>
						</div>
					</div>
				<script>
					//js上传文件判断
				  function getFilesize(file) { //如果上传文件，会触发
						//var pic1 = $("#file").val(); //获取input框的值，文件路径
						var fileName = $(file).val(); //获取input框的值，文件路径
						var index=fileName.lastIndexOf(".");
						if(index!=-1){
							var message="";
							var suffix=fileName.substring(index+1,fileName.length);
							if (suffix == 'xlsx' || suffix == 'xls'){  
									var fileSize = (file.files[0].size / (1024 * 1024)).toFixed(2);
								 if (fileSize<5) {//kb为单位
						            $("#formTemplate").submit();//提交表单
						       }else{
						        	layer.msg('参数不能为文件的大小不能超过5MB!');
						        	$(file).val("");
									return;
						        }
					       }else{
					        	layer.msg('请选择以".xlsx",".xls"结尾的文件!');
					        	$(file).val("");
					        	return;
					        }
					    }
					}
				</script>
			</div>
			<!-- excel导入结束-->
			<!-- 单个录入开始 -->
			<div id="dange" style="padding: 20px;" >
				<div class="form-group">
					<label class="col-sm-2 control-label">身份证号:</label>
					<div class="col-sm-10">
						<div class="row inline-from">
							<div class="col-sm-4">
								<input name="ordercode" id="ordercode" class="form-control"
									placeholder="请输入身份证号" type="text" required>
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">还款期数:</label>
					<div class="col-sm-10">
						<div class="row inline-from">
							<div class="col-sm-2">
								<select class="form-control" name="periods" id="periods" required>
									<option value="1" selected="selected">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
									<option value="11">11</option>
									<option value="12">12</option>
									<option value="132">13</option>
									<option value="14">14</option>
									<option value="15">15</option>
									<option value="16">16</option>
									<option value="17">17</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="25">25</option>
									<option value="25">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
									<option value="29">29</option>
									<option value="30">30</option>
									<option value="30">31</option>
									<option value="30">32</option>
									<option value="30">33</option>
									<option value="30">34</option>
									<option value="30">35</option>
									<option value="30">36</option>
								</select>
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">还款金额:</label>
					<div class="col-sm-10">
						<div class="row inline-from">
							<div class="col-sm-4">
								<input name="money" id="money"  class="form-control"
									placeholder="请输入本月的还款金额" type="text" required>
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label">还款日期:</label>
					<div class="col-sm-10">
						<div class="row inline-from">
							<div class="col-sm-4">
								<input name="da" id="da" class="form-control" placeholder="请选择还款的具体日期"
									type="text" required>
							</div>
						</div>
					</div>
				</div>
				<div class="row" style="margin-top: 25px">
					<div class="col-sm-10">
						<div class="col-sm-2 col-md-offset-2">
							<button onclick="resetrepayment()" type="button" class="btn btn-default" style="float: left">重置</button>
							<button type="button" class="btn btn-primary"
							 id="sub"  onclick="addrepayment()" style="float:right">提交</button>
						</div>
					</div>
				</div>
			</div>
			<!-- 单个录入结束 -->
		</div>
		<style>
			/* layer弹出层样式 */
			body .layui-layer-setmybg .layui-layer-content{background-color: #2D93CA; color: #fff; overflow: hidden; text-align: center; font-weight: 600;color: #2E2D3C;}
		</style>
		<script>
		/* 点击切换  */
		function hk_formfun0(id){
				if($("#"+id).css("display")=='none'){
					$("#dange,#piliang").toggle();
					$(thi).addClass("active").siblings().removeClass("active");
				}
		}		
		/* 在输入框前面加个星号 */
	    $('select[required],input[required]').before('<span style="color:red;position: absolute;margin-left: -18px; margin-top: 7px; font-size: 22px;">*</span>');  
		//重置信息
		function resetrepayment(){
			$("#da").val("");
			$("#ordercode").val("");
			$("#money").val("");
		}
		//添加
		function addrepayment(){
			//获得输入框的值
			var d=$("#da").val();
			//身份证号
			var o=$("#ordercode").val();
			//还款期数
			var p=$("#periods option:selected").val();
			var m=$("#money").val();
			if(isEmpty(d) || isEmpty(o) || isEmpty(p) || isEmpty(m)){
				/* layer.msg('参数不能为空!'); */
					layer.msg('灵活运用offset', {
					  area: ['260px', '60px'],
					  offset: '70px',
					  skin: 'layui-layer-setmybg',
					  anim: 0
					});
				return;
			}else if(!isMoney(m)){
				layer.msg('请正确填写金额,小数点后面最多两位数字!');
				return
			}else if(!iscard(o)){
				layer.msg('请正确填证件号码!');
				return
			}
			$("#money").val(subZeroAndDot(m));
			/* 提交 */
			$.ajax({
		        type: "GET",
		        url: "${pageContext.request.contextPath}/erp/arepayment.do",
		        dataType: "json",
		        data:{da:d,ordercode:o,periods:p,money:m},
		        success: function(msg){
		        	if(new Number(msg)<=0){
		        		layer.msg('添加失败!');
		        	}else if(new Number(msg)>0){
		        		layer.msg('添加成功!');
		        	}
		        }	
		      });
			}
	
			//执行一个laydate实例
			laydate.render({
				elem :'#da' //指定元素
			});
		</script>
	</section>
	</div>
	<!-- /.content-wrapper -->
	</form>