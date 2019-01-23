<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${pageContext.request.contextPath }/kjs_icbc/content/glzx_style/css/DateIMG.css" />		
<script type="text/javascript" src="${pageContext.request.contextPath }/kjs_icbc/content/glzx_style/js/echarts.js" ></script>

<div class="content-wrapper"  style="min-height: 944px;background-color: ">
	<div class="form-horizontal">
			<!-- 数据图1开始 -->
			<div id="graph_transform1"  class="graph_big">
				<div class="graph_container">
					<div class="graph_box">
						<div class="graph_left" >
							<!--保单统计左边开始-->
							<div class="graph_title" style="margin-bottom: 5%;">报单统计</div>
							<div style="width: 100%;height: 7%;">
								<ul class="font_color_3 font_size_2 condition1" >
									<li>
										<input type="text" placeholder="请输入代理商" />
									</li>
									<li>
										<div>请选择省份<i>></i></div>
									</li>
									<li>
										<div>请选择时间<i>></i></div>
									</li>
								</ul>
							</div>
							<div style="height: 80%;width: 100%; position: relative; top: -20px; padding-left: 4%;" id="baodan">
							
							</div>
							<!--报单统计左边结束-->
						</div>
						<div class="graph_right">
							<!--报单统计头部右边开始-->
							<div class="graph_statistics_top" >
								<div class="graph_statistics_content" style="width:40%;">
									<p class="graph_statistics_number font_color_1">0<font>笔</font></p>
									<p class="font_size_2 font_color_3">本月报单总量</p>
								</div>
								<%-- <div class="graph_statistics_content" style="width: 50%;float: right;">
									<p class="graph_statistics_number font_color_2">${Math.ceil(loanlist[0].money + fklist[0].money) }<font>元</font></p>
									<p class="font_size_2 font_color_3">本月报单总额</p>
								</div> --%>
							</div>
							<div class="graph_statistics_centre">
								<table  class="graph_table">
									 <tr>
									    <th >省份</th>
									    <th colspan="3" class="font_color_1">排名</th>
									    <th >代理商</th>
									 </tr>
									 
									<tr>
										<td class="font_color_3"> </td>
										<td class="font_color_1 font_size_1">0</td>
										<td ><div class="graph_rank">1</div></td>
										<td class="font_color_1 font_size_1">0</td>
										<td class="font_color_3"> </td>
									</tr>
									<tr>
										<td class="font_color_3"> </td>
										<td class="font_color_1 font_size_1">0</td>
										<td ><div class="graph_rank">2</div></td>
										<td class="font_color_1 font_size_1">0</td>
										<td class="font_color_3"> </td>
									</tr>
									<tr>
										<td class="font_color_3"> </td>
										<td class="font_color_1 font_size_1">0</td>
										<td ><div class="graph_rank">3</div></td>
										<td class="font_color_1 font_size_1">0</td>
										<td class="font_color_3"> </td>
									</tr>
									<tr>
										<td class="font_color_3"> </td>
										<td class="font_color_1 font_size_1">0</td>
										<td ><div class="graph_rank">4</div></td>
										<td class="font_color_1 font_size_1">0</td>
										<td class="font_color_3"> </td>
									</tr>
									<tr>
										<td class="font_color_3"> </td>
										<td class="font_color_1 font_size_1">0</td>
										<td ><div class="graph_rank">5</div></td>
										<td class="font_color_1 font_size_1">0</td>
										<td class="font_color_3"> </td>
									</tr>
								</table>
							</div>
							<div style="width: 100%; height: 10%;margin-top: 2%;">
								<button class="graph_button">更多</button>
							</div>
							<!--报单统计头部右边结束-->
						</div>
					</div>
					<div class="graph_box" style="margin-left: 3%;">
						<div class="graph_left" >
							<!--过件率 汽车贷款通过左边开始-->
							<div class="graph_title" style="margin-bottom: 5%;">过件率(汽车贷款通过)</div>
							<div style="width: 100%;height: 7%;">
								<ul class="font_color_3 font_size_2 condition1" >
									<li>
										<input type="text" placeholder="请输入代理商" />
									</li>
									<li>
										<div>请选择省份<i>></i></div>
									</li>
									<li>
										<div>请选择时间<i>></i></div>
									</li>
								</ul>
							</div>
							<div style="height:70%;width: 92%; position: relative; top: -20px; margin-left: 4%;" id="guojianlv"></div>
							<!--过件率 汽车贷款通过左边结束-->
						</div>
						<div class="graph_right">
							<!--过件率 汽车贷款通过右边开始-->
							<div class="graph_statistics_top" >
								<div class="graph_statistics_content" style="width:40%;float: right;margin-right:22%;">
									<p class="graph_statistics_number font_color_2">0<font>%</font></p>
									<p class="font_size_2 font_color_3">本月过件率</p>
								</div>
							</div>
							<div class="graph_statistics_centre">
								<table  class="graph_table">
									 <tr>
									    <th >省份</th>
									    <th colspan="3" class="font_color_1">排名</th>
									    <th >代理商</th>
									 </tr>
									<tr>
										<td class="font_color_3"> </td>
										<td class="font_color_1 font_size_1">0</td>
										<td ><div class="graph_rank">1</div></td>
										<td class="font_color_1 font_size_1">0</td>
										<td class="font_color_3"> </td>
									</tr>
									<tr>
										<td class="font_color_3"> </td>
										<td class="font_color_1 font_size_1">0</td>
										<td ><div class="graph_rank">2</div></td>
										<td class="font_color_1 font_size_1">0</td>
										<td class="font_color_3"> </td>
									</tr>
									<tr>
										<td class="font_color_3"> </td>
										<td class="font_color_1 font_size_1">0</td>
										<td ><div class="graph_rank">3</div></td>
										<td class="font_color_1 font_size_1">0</td>
										<td class="font_color_3"> </td>
									</tr>
									<tr>
										<td class="font_color_3"> </td>
										<td class="font_color_1 font_size_1">0</td>
										<td ><div class="graph_rank">4</div></td>
										<td class="font_color_1 font_size_1">0</td>
										<td class="font_color_3"> </td>
									</tr>
									<tr>
										<td class="font_color_3"> </td>
										<td class="font_color_1 font_size_1">0</td>
										<td ><div class="graph_rank">5</div></td>
										<td class="font_color_1 font_size_1">0</td>
										<td class="font_color_3"> </td>
									</tr>
								</table>
							</div>
							<div style="width: 100%; height: 10%;margin-top: 2%;">
								<button class="graph_button">更多</button>
							</div>
						</div>
						<!--过件率 汽车贷款通过右边结束-->
					</div>
				</div>
				<div class="graph_container_bottom">
					<div class="graph_box">
						<div class="graph_left" >
							<!--放款统计分析左边开始-->
							<div class="graph_title">放款统计分析</div>
							<div style="width: 100%;height: 5%;  margin-top: 4%;">
								<ul class="font_color_3 font_size_2 condition1" >
									<li>
										<input type="text" placeholder="请输入代理商" />
									</li>
									<li>
										<div>请选择省份<i>></i></div>
									</li>
									<li>
										<div>请选择时间<i>></i></div>
									</li>
								</ul>
							</div>
							<div style="height: 78%;width: 92%; position: relative;">
								<div style="height: 40%; width: 50%; float:left" id="fangkkuan_bar_1"></div>
								<div style="height: 40%; width: 50%; float: right;" id="fangkkuan_bar_2"></div>
								<div style="height: 65%;width: 100%;" id="fangkkuan_lineANDbar_3">
								</div>
							</div>
							<!--放款统计分析左边结束-->
						</div>
						<div class="graph_right">
							<!--放款统计头部右边开始-->
							<div class="graph_statistics_top" style="margin-top: 20%;">
								<div class="graph_statistics_content" style="width:45%;">
									<p class="graph_statistics_number font_color_1">0<font>笔</font></p>
									<p class="font_size_2 font_color_3">本月放款总订单</p>
								</div>
								<div class="graph_statistics_content" style="width: 50%;float: right;">
									<p class="graph_statistics_number font_color_2">0<font>元</font></p>
									<p class="font_size_2 font_color_3">本月放款均金额</p>
								</div>
							</div>
							
							<div class="graph_statistics_content" style="width: 100%; margin-bottom: 7%;">
									<p class="graph_statistics_number font_color_2">0<font>元</font></p>
									<p class="font_size_2 font_color_3">本月累计放款总订单总金额</p>
							</div>
						
							<div class="graph_statistics_centre">
								<table  class="graph_table">
									 <tr>
									    <th >省份</th>
									    <th colspan="3" class="font_color_1">排名</th>
									    <th >代理商</th>
									 </tr>
									<tr>
										<td class="font_color_3"> </td>
										<td class="font_color_1 font_size_1">0</td>
										<td ><div class="graph_rank">1</div></td>
										<td class="font_color_1 font_size_1">0</td>
										<td class="font_color_3"> </td>
									</tr>
									<tr>
										<td class="font_color_3"> </td>
										<td class="font_color_1 font_size_1">0</td>
										<td ><div class="graph_rank">2</div></td>
										<td class="font_color_1 font_size_1">0</td>
										<td class="font_color_3"> </td>
									</tr>
									<tr>
										<td class="font_color_3"> </td>
										<td class="font_color_1 font_size_1">0</td>
										<td ><div class="graph_rank">3</div></td>
										<td class="font_color_1 font_size_1">0</td>
										<td class="font_color_3"> </td>
									</tr>
									<tr>
										<td class="font_color_3"> </td>
										<td class="font_color_1 font_size_1">0</td>
										<td ><div class="graph_rank">4</div></td>
										<td class="font_color_1 font_size_1">0</td>
										<td class="font_color_3"> </td>
									</tr>
									<tr>
										<td class="font_color_3"> </td>
										<td class="font_color_1 font_size_1">0</td>
										<td ><div class="graph_rank">5</div></td>
										<td class="font_color_1 font_size_1">0</td>
										<td class="font_color_3"> </td>
									</tr>
								</table>
							</div>
							<div style="width: 100%; height: 10%;margin-top: 2%;">
								<button class="graph_button">更多</button>
							</div>
								<!--放款统计分析右边结束-->
						</div>
					</div>
					<div class="graph_box"  style="margin-left: 3%;">
						<div style="width: 48%; height: 100%; float: left;" >
							<!--抵押完成情况左边开始-->
							<div class="graph_title" style="margin-bottom: 9%;">抵押完成情况</div>
							<div class="graph_statistics_top" >
								<div class="graph_statistics_content" style="width:45%; height: 76px;">
									<p class="graph_statistics_number font_color_1">0<font>笔</font></p>
									<p class="font_size_2 font_color_3">本月已放款未完成</p>
									<p class="font_size_2 font_color_3">抵押的订单总数</p>
								</div>
								<div class="graph_statistics_content" style="width: 50%;float: right;height:76px;">
									<p class="graph_statistics_number font_color_2">0<font>元</font></p>
									<p class="font_size_2 font_color_3">本月已放款未完成</p>
									<p class="font_size_2 font_color_3">抵押的订单金额</p>
								</div>
							</div>
							<div style="width: 100%;height: 5%; margin-top:25px;">
								<ul class="font_color_3 font_size_2 condition1" >
									<li>
										<input type="text" placeholder="请输入代理商" />
									</li>
									<li>
										<div>请选择省份<i>></i></div>
									</li>
									<li>
										<div>请选择时间<i>></i></div>
									</li>
								</ul>
							</div>
							<div id="diyawancheng" style="height:45%; width: 100%;">
							</div>
							<!--抵押完成情况左边结束-->
						</div>
						<div style="width: 48%;height: 100%; margin-left: 4%;">
							<!--材料回收右边开始-->
							<div class="graph_title" style="margin-bottom: 5%; margin-left: 10%;">材料回收情况</div>
							<div style="width: 100%;height: 5%;">
								<ul class="font_color_3 font_size_2 condition1" >
									<li>
										<input type="text" placeholder="请输入代理商" />
									</li>
									<li>
										<div>请选择省份<i>></i></div>
									</li>
									<li>
										<div>请选择时间<i>></i></div>
									</li>
								</ul>
							</div>
							<div id="cailiaohuishou" style="height: 65%;width: 100%; margin-top: 5%;margin-left: 5%;">
							</div>
							<!--材料回收右边结束-->
						</div>
					</div>
				</div>
			</div>
			<!-- 数据图1结束 -->
			
			<!-- 数据图2开始 -->
			<div class="graph_transform" onclick="graphTransform()">切</br>换</div>
			<div id="graph_transform2" class="graph_big">
				<div style="height: 45%;">
					<div class="graph_box">
						<div style="width: 40%;height: 100%;float: left;" >
							<div class="graph_title" style="margin-bottom: 2%;">逾期率</div>
							<div style="width: 100%;height:6%;margin-left: 15px;">
								<ul class="font_color_3 font_size_2 condition1" >
									<li>
										<input type="text" placeholder="请输入代理商" />
									</li>
									<li style="margin-left: 10px;">
										<div>请选择省份<i>></i></div>
									</li>
								</ul>
							</div>
							<div id="yuqilv1" style="height: 70%;width: 100%;">
							</div>
						</div>
						<div style="width: 18%;height: 100%;float: left;margin-left: 2%;">
							<div style="height: 20%;width: 100%;margin-top: 20%;">
								<div class="graph_statistics_content" style="width: 60%;height: 60%;margin-top: 10%;margin-left: 20%;">
									<img src="${pageContext.request.contextPath }/kjs_icbc/content/glzx_style/img/724618841177387879.png" style="width: 23px;height: 23px;padding-top: 5px;"/>
									<p style="margin: 0;padding: 0;color:#454e70;font-size: 10px;padding-top: 3px;">逾期率预警</p>
								</div>
							</div>
							<style>
								
							</style>
							<table class="graph_overdue_center">
								<tr>
									<th>代理商</th>
									<th>逾期率</th>
								</tr>
								<tr>
									<td> </td>
									<td>0</td>
								</tr>
								<tr>
									<td> </td>
									<td>0</td>
								</tr>
								<tr>
									<td> </td>
									<td>0</td>
								</tr>
								<tr>
									<td> </td>
									<td>0</td>
								</tr>
								<tr>
									<td> </td>
									<td>0</td>
								</tr>
							</table>
							<div style="width: 100%; height: 10%;margin-top: 2%;">
								<button class="graph_button" style="margin-right: 0;">更多</button>
							</div>
						</div>
						<div style="width: 40%;height: 100%; float: right;">
							<ul class="graph_overdue_right" style="margin-top:15%;" class="font_color_3">
								<li>
									<div  class="graph_button" style="margin: 0;float: left;">省份</div>
								</li>
								<li class="font_color_3">代理商</li>
								<li class="font_color_3">客户年龄</li>
								<li class="font_color_3">贷款金额</li>
							</ul>
							<div style="width: 100%;height:70%; margin-left: 8%;" id="yuqilv2">
							</div>
						</div>
					</div>
					<div class="graph_box" style="margin-left: 2%;">
						<!--代理商综合能力分析左边开始-->
						<div style="width: 50%;height: 100%;float: left;">
							<div class="graph_title" style="margin-bottom: 5%;">代理商综合能力分析</div>
							<div style="width: 100%;height:7%;margin-left: 18%;">
								<ul class="font_color_3 font_size_2 condition1" >
									<li>
										<input type="text" placeholder="请输入代理商" />
									</li>
									<li>
										<div>请选择时间<i>></i></div>
									</li>
								</ul>
							</div>
							<div style="height:80%;width: 100%; position: relative; top: -10px; margin-left: 4%;" id="zonghenenglifenxi">
							</div>
						</div>
					    <!--代理商综合能力分析左边结束-->
					    <!--征信查询通过率右边开始-->
						<div  style="width: 50%;height: 100%;">
							<div class="graph_title" style="margin-bottom: 5%;">征信查询通过率</div>
							<div style="width: 100%;height: 7%;">
								<ul class="font_color_3 font_size_2 condition1" >
									<li>
										<input type="text" placeholder="请输入代理商" />
									</li>
									<li>
										<div>请选择省份<i>></i></div>
									</li>
									<li>
										<div>请选择时间<i>></i></div>
									</li>
								</ul>
							</div>
							<div id="zhengxinchaxuntongguolv" style="width: 100%;height: 80%; position: relative; top: -20px;  ">
							</div>
						</div>
					</div>
					 <!--征信查询通过率右边结束-->
				</div>
				<div style="height: 50%;">
					<div class="graph_box">
						<div class="graph_title" style="width: 100%;">客户和车辆画像</div>
						<!--客户和车辆图像开始-->
						<div style="height: 87%;width: 100%; ">
							<!--客户年龄开始-->
							<div style="width: 48%; height: 100%; margin-left:10px;">
								<div style="height: 9%;width: 100%; margin-top: 10px;">
									<div class="font_size_2 font_color_3" style="margin-top: 7px;float: left;">所属省份</div>
									<button class="graph_button" style="float: left;margin-left: 8px;margin-top: 4px;">客户年龄</button>
								</div>
								<div id="kehunianling" style="height: 80%;width: 100%;position: relative; top: -20px; ">
								</div>
							</div>
							<!--客户年龄结束-->
							<!--车龄开始-->
							<div style="width: 48%; height: 100%;">
								<div style="height: 9%;width: 100%; margin-top: 10px;margin-left: 30%;">
									<div class="font_size_2 font_color_3" style=" margin-top: 7px;float: left;">新车</div>
									<button class="graph_button" style="float: left;margin-left: 8px;margin-top: 4px;">车龄</button>
								</div>
								<div id="cheliangnianling" style="height: 80%;width: 100%;position: relative; top: -20px; ">
								</div>
							</div>
							<!--车龄结束-->
						</div>
						<!--客户和车辆图像结束-->
					</div>
					<div class="graph_box"  style="margin-left: 3%;">
						<div class="graph_title" style="margin-bottom: 2%; margin-left: 7%;">资金周转时长(垫资方)</div>
						<div style="width: 100%;height: 5%;">
								<div class="font_size_2 font_color_3" style="margin-left: 50px;margin-top: 2px;">请选择时间<i>></i></div>
						</div>
						<div id="zijinzhouzhuanlv" style="width: 100%;height: 71%;">
						</div>
					</div>
				</div>
			</div>
			<!-- 数据图2结束 -->
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/kjs_icbc/content/glzx_style/js/DateIMG.js" ></script>
	<script type="text/javascript">
	  window.onload =function(){
		document.getElementById("graph_transform2").style.display="none";
	};
 

	</script>


