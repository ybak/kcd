<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="content-wrapper" style="min-height: 943px;">
 <section class="content-header">
			<h1>
			征信查询			<small>
				<i class="fa fa-angle-double-right"></i> 工行进件								共495个
							</small>
			</h1>
 </section>
 
 
<section class="content">

			<div class="admin-tools">
				<div class="row">
					<div class="col-sm-10 admin-button">
												<div class="btn-group">
						
																														</div>
					</div>
					<div class="col-sm-2 admin-page-top hidden-xs">
							<select id="page_limit_select" onchange="window.location.href='/assess/manager/index.php?type=assess&amp;do=list&amp;cn=kj_icbc&amp;nav=0&amp;bc_tag=-1&amp;l='+this.value" class="form-control">
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
														
														<a href="/assess/manager/index.php?type=assess&amp;do=list&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;p=2" class="btn btn-default">»</a>
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
			<th style="width: 3%" class="text-center"><input class="check_all" type="checkbox"></th>
			<th>公司名|姓名</th>
			<th class="hidden-xs text-center" style="width: 70px">借款人</th>
			<th class="hidden-xs text-center" style="width: 100px">借款金额(万)</th>
			<th class="hidden-xs text-center" style="width: 100px">审批金额(万)</th>
			<th class="hidden-xs text-center" style="width: 80px">期限</th>
			<th style="width: 140px" class="text-center">操作</th>
			<th style="width: 80px">当前状态</th>
	</tr>
				<tr>
			<td class="text-center"><input name="delid" value="439" type="checkbox"></td>
			<td>来源:联众金融-广东惠州林春祝</td>
			<td class="hidden-xs">谭明珠</td>
			<td class="hidden-xs text-center">0.00</td>
			<td class="hidden-xs text-center"></td>
			<td class="hidden-xs text-center">请选择按揭期限</td>
			<td class="text-center">
				<!--  编辑-->
				<div class="table-button">
									<a href="/assess/manager/index.php?type=assess&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;do=form&amp;id=439&amp;action=check" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
		</td>
			<td>
				<!--当前状态  -->
			<span class="label label-success">查询成功</span>			</td>
	</tr>
				<tr>
			<td class="text-center"><input name="delid" value="376" type="checkbox"></td>
			<td>来源:联众金融-杨贵宝</td>
			<td class="hidden-xs">杨兰飞</td>
			<td class="hidden-xs text-center">0.00</td>
			<td class="hidden-xs text-center"></td>
			<td class="hidden-xs text-center">请选择按揭期限</td>
			<td class="text-center">
				<!--  编辑-->
				<div class="table-button">
									<a href="/assess/manager/index.php?type=assess&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;do=form&amp;id=376&amp;action=check" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
		</td>
			<td>
				<!--当前状态  -->
			<span class="label label-success">查询成功</span>			</td>
	</tr>
				<tr>
			<td class="text-center"><input name="delid" value="382" type="checkbox"></td>
			<td>来源:联众金融-宋立影</td>
			<td class="hidden-xs">于富国</td>
			<td class="hidden-xs text-center">0.00</td>
			<td class="hidden-xs text-center"></td>
			<td class="hidden-xs text-center">请选择按揭期限</td>
			<td class="text-center">
				<!--  编辑-->
				<div class="table-button">
									<a href="/assess/manager/index.php?type=assess&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;do=form&amp;id=382&amp;action=check" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
		</td>
			<td>
				<!--当前状态  -->
			<span class="label label-success">查询成功</span>			</td>
	</tr>
				<tr>
			<td class="text-center"><input name="delid" value="527" type="checkbox"></td>
			<td>来源:佰通洐汽车服务有限公司-徐小龙</td>
			<td class="hidden-xs">杨宏健</td>
			<td class="hidden-xs text-center">0.00</td>
			<td class="hidden-xs text-center"></td>
			<td class="hidden-xs text-center">请选择按揭期限</td>
			<td class="text-center">
				<!--  编辑-->
				<div class="table-button">
									<a href="/assess/manager/index.php?type=assess&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;do=form&amp;id=527&amp;action=check" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
		</td>
			<td>
				<!--当前状态  -->
			<span class="label label-success">查询成功</span>			</td>
	</tr>
				<tr>
			<td class="text-center"><input name="delid" value="555" type="checkbox"></td>
			<td>来源:联鑫融汽车服务有限公司-罗静梅</td>
			<td class="hidden-xs">宋歌</td>
			<td class="hidden-xs text-center">0.00</td>
			<td class="hidden-xs text-center"></td>
			<td class="hidden-xs text-center">请选择按揭期限</td>
			<td class="text-center">
				<!--  编辑-->
				<div class="table-button">
									<a href="/assess/manager/index.php?type=assess&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;do=form&amp;id=555&amp;action=check" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
		</td>
			<td>
				<!--当前状态  -->
			<span class="label label-warning">草稿箱</span>			</td>
	</tr>
				<tr>
			<td class="text-center"><input name="delid" value="554" type="checkbox"></td>
			<td>来源:联鑫融汽车服务有限公司-罗静梅</td>
			<td class="hidden-xs">宋歌</td>
			<td class="hidden-xs text-center">0.00</td>
			<td class="hidden-xs text-center"></td>
			<td class="hidden-xs text-center">请选择按揭期限</td>
			<td class="text-center">
				<!--  编辑-->
				<div class="table-button">
									<a href="/assess/manager/index.php?type=assess&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;do=form&amp;id=554&amp;action=check" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
		</td>
			<td>
				<!--当前状态  -->
			<span class="label label-warning">草稿箱</span>			</td>
	</tr>
				<tr>
			<td class="text-center"><input name="delid" value="553" type="checkbox"></td>
			<td>来源:快车道-李旺</td>
			<td class="hidden-xs">李旺</td>
			<td class="hidden-xs text-center">0.00</td>
			<td class="hidden-xs text-center"></td>
			<td class="hidden-xs text-center">请选择按揭期限</td>
			<td class="text-center">
				<!--  编辑-->
				<div class="table-button">
									<a href="/assess/manager/index.php?type=assess&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;do=form&amp;id=553&amp;action=check" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
		</td>
			<td>
				<!--当前状态  -->
			<span class="label label-warning">草稿箱</span>			</td>
	</tr>
				<tr>
			<td class="text-center"><input name="delid" value="552" type="checkbox"></td>
			<td>来源:索普财务管理有限公司-于子华</td>
			<td class="hidden-xs">霍玉龙</td>
			<td class="hidden-xs text-center">0.00</td>
			<td class="hidden-xs text-center"></td>
			<td class="hidden-xs text-center">请选择按揭期限</td>
			<td class="text-center">
				<!--  编辑-->
				<div class="table-button">
									<a href="/assess/manager/index.php?type=assess&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;do=form&amp;id=552&amp;action=check" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
		</td>
			<td>
				<!--当前状态  -->
			<span class="label label-warning">草稿箱</span>			</td>
	</tr>
				<tr>
			<td class="text-center"><input name="delid" value="551" type="checkbox"></td>
			<td>来源:索普财务管理有限公司-顾长征</td>
			<td class="hidden-xs">顾长征</td>
			<td class="hidden-xs text-center">0.00</td>
			<td class="hidden-xs text-center"></td>
			<td class="hidden-xs text-center">请选择按揭期限</td>
			<td class="text-center">
				<!--  编辑-->
				<div class="table-button">
									<a href="/assess/manager/index.php?type=assess&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;do=form&amp;id=551&amp;action=check" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
		</td>
			<td>
				<!--当前状态  -->
			<span class="label label-warning">草稿箱</span>			</td>
	</tr>
				<tr>
			<td class="text-center"><input name="delid" value="547" type="checkbox"></td>
			<td>来源:索普财务管理有限公司-蔡舜</td>
			<td class="hidden-xs">蔡舜</td>
			<td class="hidden-xs text-center">0.00</td>
			<td class="hidden-xs text-center"></td>
			<td class="hidden-xs text-center">请选择按揭期限</td>
			<td class="text-center">
				<!--  编辑-->
				<div class="table-button">
									<a href="/assess/manager/index.php?type=assess&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;do=form&amp;id=547&amp;action=check" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
		</td>
			<td>
				<!--当前状态  -->
			<span class="label label-warning">草稿箱</span>			</td>
	</tr>
				<tr>
			<td class="text-center"><input name="delid" value="550" type="checkbox"></td>
			<td>来源:索普财务管理有限公司-杨露</td>
			<td class="hidden-xs">杨露</td>
			<td class="hidden-xs text-center">0.00</td>
			<td class="hidden-xs text-center"></td>
			<td class="hidden-xs text-center">请选择按揭期限</td>
			<td class="text-center">
				<!--  编辑-->
				<div class="table-button">
									<a href="/assess/manager/index.php?type=assess&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;do=form&amp;id=550&amp;action=check" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
		</td>
			<td>
				<!--当前状态  -->
			<span class="label label-warning">草稿箱</span>			</td>
	</tr>
				<tr>
			<td class="text-center"><input name="delid" value="549" type="checkbox"></td>
			<td>来源:索普财务管理有限公司-吴飞</td>
			<td class="hidden-xs">吴飞</td>
			<td class="hidden-xs text-center">0.00</td>
			<td class="hidden-xs text-center"></td>
			<td class="hidden-xs text-center">请选择按揭期限</td>
			<td class="text-center">
				<!--  编辑-->
				<div class="table-button">
									<a href="/assess/manager/index.php?type=assess&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;do=form&amp;id=549&amp;action=check" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
		</td>
			<td>
				<!--当前状态  -->
			<span class="label label-warning">草稿箱</span>			</td>
	</tr>
				<tr>
			<td class="text-center"><input name="delid" value="546" type="checkbox"></td>
			<td>来源:索普财务管理有限公司-李齐飞</td>
			<td class="hidden-xs">李齐飞</td>
			<td class="hidden-xs text-center">0.00</td>
			<td class="hidden-xs text-center"></td>
			<td class="hidden-xs text-center">请选择按揭期限</td>
			<td class="text-center">
				<!--  编辑-->
				<div class="table-button">
									<a href="/assess/manager/index.php?type=assess&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;do=form&amp;id=546&amp;action=check" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
		</td>
			<td>
				<!--当前状态  -->
			<span class="label label-warning">草稿箱</span>			</td>
	</tr>
				<tr>
			<td class="text-center"><input name="delid" value="548" type="checkbox"></td>
			<td>来源:索普财务管理有限公司-姜丽丽</td>
			<td class="hidden-xs">姜丽丽</td>
			<td class="hidden-xs text-center">0.00</td>
			<td class="hidden-xs text-center"></td>
			<td class="hidden-xs text-center">请选择按揭期限</td>
			<td class="text-center">
				<!--  编辑-->
				<div class="table-button">
									<a href="/assess/manager/index.php?type=assess&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;do=form&amp;id=548&amp;action=check" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
		</td>
			<td>
				<!--当前状态  -->
			<span class="label label-warning">草稿箱</span>			</td>
	</tr>
				<tr>
			<td class="text-center"><input name="delid" value="523" type="checkbox"></td>
			<td>来源:联鑫融汽车服务有限公司-何文平</td>
			<td class="hidden-xs">周清瑶</td>
			<td class="hidden-xs text-center">0.00</td>
			<td class="hidden-xs text-center"></td>
			<td class="hidden-xs text-center">请选择按揭期限</td>
			<td class="text-center">
				<!--  编辑-->
				<div class="table-button">
									<a href="/assess/manager/index.php?type=assess&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;do=form&amp;id=523&amp;action=check" class="btn btn-default"><i class="fa fa-pencil"></i></a>
									</div>
		</td>
			<td>
				<!--当前状态  -->
			<span class="label label-warning">草稿箱</span>			</td>
	</tr>
			</tbody>
</table>				
			</div>
						<div class="foot-page">
				<ul class="pagination no-margin">
					  <li class="active"><a href="/assess/manager/index.php?type=assess&amp;do=list&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;p=1">1 <span class="sr-only">(current)</span></a></li> <li><a href="/assess/manager/index.php?type=assess&amp;do=list&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;p=2">2</a></li> <li><a href="/assess/manager/index.php?type=assess&amp;do=list&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;p=3">3</a></li> <li><a href="/assess/manager/index.php?type=assess&amp;do=list&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;p=4">4</a></li> <li><a href="/assess/manager/index.php?type=assess&amp;do=list&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;p=5">5</a></li>  <li><a href="/assess/manager/index.php?type=assess&amp;do=list&amp;cn=kj_icbc&amp;l=15&amp;nav=0&amp;bc_tag=-1&amp;p=2" aria-label="Next"><span aria-hidden="true">»</span></a></li>  				</ul>
				<div class="page-num">共495个 分33页显示</div>
			</div>
					</section>
</div>