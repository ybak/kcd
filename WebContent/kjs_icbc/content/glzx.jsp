<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
										<input type="text"  value="请输入代理商" onblur="baodanselect()"
                                           onfocus="javascript:if(this.value=='请输入代理商')this.value='';" id="baodanval"/>
									</li>
									<li>
										<select id="baodansel" onchange="baodanselect()" >
                                        	<option selected value="0"> 请选择省份</option>
                                        	<option value="0"> 全部</option>
                                        	<c:forEach var="list" items="${comm_city}">
                                            	<option value="${list.id}">${list.name}</option>
                                        	</c:forEach>
                                    	</select><i style="padding-left: 5px; font-weight:bold;">></i>
										
									</li>
									<li>
										<select id="baodantime" onchange="baodanselect()">
                                        	<option selected value="0"> 请选择时间</option>
                                        	<option value="0"> 全部</option>
                                        	<%-- <c:forEach var="list" items="${years }" >
                                            	<option value="${list}">${list}</option>
                                        	</c:forEach> --%>
                                        	<option value="2019"> 18年11月-19年7月</option>
                                        	<option value="2018"> 18年2月-18年10月</option>
                                    	</select><i style="padding-left: 5px; font-weight:bold;">></i>
									</li>
								</ul>
							</div>
							<div style="height: 80%;width: 100%; position: relative; top: -10px; padding-left: 4%;" id="baodan">
							
							</div>
							<!--报单统计左边结束-->
						</div>
						<div class="graph_right">
							<!--报单统计头部右边开始-->
							<div class="graph_statistics_top" >
								<div class="graph_statistics_content" style="width:40%;">
									<%-- <p class="graph_statistics_number font_color_1">${billlist[0].amount }<font>笔</font></p> --%>
									<p class="graph_statistics_number font_color_1">148<font>笔</font></p>
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
									 
									<%-- <tr>
										<td class="font_color_3">${rankinglist[0].name == null?"暂无":rankinglist[0].name}</td>
										<td class="font_color_1 font_size_1">${rankinglist[0].sell == null?0:rankinglist[0].sell }</td>
										<td ><div class="graph_rank">1</div></td>
										<td class="font_color_1 font_size_1">${gemslist[0].gems == null?0:gemslist[0].gems}</td>
										<td class="font_color_3">${gemslist[0].name == null?"暂无":gemslist[0].name}</td>
									</tr>
									<tr>
										<td class="font_color_3">${rankinglist[1].name == null?"暂无":rankinglist[1].name}</td>
										<td class="font_color_1 font_size_1">${rankinglist[1].sell == null?0:rankinglist[1].sell }</td>
										<td ><div class="graph_rank">2</div></td>
										<td class="font_color_1 font_size_1">${gemslist[1].gems == null?0:gemslist[1].gems}</td>
										<td class="font_color_3">${gemslist[1].name == null?"暂无":gemslist[1].name}</td>
									</tr>
									<tr>
										<td class="font_color_3">${rankinglist[2].name == null?"暂无":rankinglist[2].name}</td>
										<td class="font_color_1 font_size_1">${rankinglist[2].sell == null?0:rankinglist[2].sell }</td>
										<td ><div class="graph_rank">3</div></td>
										<td class="font_color_1 font_size_1">${gemslist[2].gems == null?0:gemslist[2].gems}</td>
										<td class="font_color_3">${gemslist[2].name == null?"暂无":gemslist[2].name}</td>
									</tr>
									<tr>
										<td class="font_color_3">${rankinglist[3].name == null?"暂无":rankinglist[3].name}</td>
										<td class="font_color_1 font_size_1">${rankinglist[3].sell == null?0:rankinglist[3].sell }</td>
										<td ><div class="graph_rank">4</div></td>
										<td class="font_color_1 font_size_1">${gemslist[3].gems == null?0:gemslist[3].gems}</td>
										<td class="font_color_3">${gemslist[3].name == null?"暂无":gemslist[3].name}</td>
									</tr>
									<tr>
										<td class="font_color_3">${rankinglist[4].name == null?"暂无":rankinglist[4].name}</td>
										<td class="font_color_1 font_size_1">${rankinglist[4].sell == null?0:rankinglist[4].sell }</td>
										<td ><div class="graph_rank">5</div></td>
										<td class="font_color_1 font_size_1">${gemslist[4].gems == null?0:gemslist[4].gems}</td>
										<td class="font_color_3">${gemslist[4].name == null?"暂无":gemslist[4].name}</td>
									</tr> --%>
									<tr>
										<td class="font_color_3">河北省</td>
										<td class="font_color_1 font_size_1">20</td>
										<td ><div class="graph_rank">1</div></td>
										<td class="font_color_1 font_size_1">12</td>
										<td class="font_color_3">购车无忧汽车服务</td>
									</tr>
									<tr>
										<td class="font_color_3">云南省</td>
										<td class="font_color_1 font_size_1">19</td>
										<td ><div class="graph_rank">2</div></td>
										<td class="font_color_1 font_size_1">11</td>
										<td class="font_color_3">万鑫汽车销售</td>
									</tr>
									<tr>
										<td class="font_color_3">山西省</td>
										<td class="font_color_1 font_size_1">17</td>
										<td ><div class="graph_rank">3</div></td>
										<td class="font_color_1 font_size_1">10</td>
										<td class="font_color_3">恩梯基汽车技术</td>
									</tr>
									<tr>
										<td class="font_color_3">河南省</td>
										<td class="font_color_1 font_size_1">16</td>
										<td ><div class="graph_rank">4</div></td>
										<td class="font_color_1 font_size_1">9</td>
										<td class="font_color_3">车划算汽车信息服务</td>
									</tr>
									<tr>
										<td class="font_color_3">江苏省</td>
										<td class="font_color_1 font_size_1">15</td>
										<td ><div class="graph_rank">5</div></td>
										<td class="font_color_1 font_size_1">8</td>
										<td class="font_color_3">花样年金融控股</td>
									</tr>
									
								</table>
							</div>
							<div style="width: 100%; height: 10%;margin-top: 2%;">
								<button class="graph_button" onclick="show_bjls('baodan')">更多</button>
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
										<input type="text"  value="请输入代理商" onblur="guojianselect()"
                                           onfocus="javascript:if(this.value=='请输入代理商')this.value='';" id="guojianval"/>
									</li>
									<li>
										<select id="guojiansel" onchange="guojianselect()" >
	                                        <option selected value="0"> 请选择省份</option>
	                                        <option value="0"> 全部</option>
	                                        <c:forEach var="list" items="${comm_city}">
	                                            <option value="${list.id}">${list.name}</option>
	                                        </c:forEach>
                                    	</select><i style="padding-left: 5px; font-weight:bold;">></i>
									</li>
									<li>
										<select id="guojiantime" onchange="guojianselect()" >
	                                        <option selected value="0"> 请选择时间</option>
	                                        <option value="0"> 全部</option>
	                                        <%-- <c:forEach var="list" items="${years }" >
	                                            <option value="${list}">${list}</option>
	                                        </c:forEach> --%>
	                                        <option value="2019"> 18年11月-19年7月</option>
                                        	<option value="2018"> 18年2月-18年10月</option>
	                                    </select><i style="padding-left: 5px; font-weight:bold;">></i>
									</li>
								</ul>
							</div>
							<div style="height:70%;width: 92%; position: relative; top: -10px; margin-left: 4%;" id="guojianlv"></div>
							<!--过件率 汽车贷款通过左边结束-->
						</div>
						<div class="graph_right">
							<!--过件率 汽车贷款通过右边开始-->
							<div class="graph_statistics_top" >
								<div class="graph_statistics_content" style="width:40%;float: right;margin-right:22%;">
									<%-- <p class="graph_statistics_number font_color_2">${Math.round(carpass*100/carselect) }<font>%</font></p> --%>
									<p class="graph_statistics_number font_color_2">74<font>%</font></p>
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
									<%-- <tr>
										<td class="font_color_3">${cardpasscomm[0].name == null?"暂无":cardpasscomm[0].name}</td>
										<td class="font_color_1 font_size_1">${Math.round(cardpasscomm[0].rate*100/1) }%</td>
										<td ><div class="graph_rank">1</div></td>
										<td class="font_color_1 font_size_1">${Math.round(cardpassgems[0].rate*100/1) }%</td>
										<td class="font_color_3">${cardpassgems[0].name == null?"暂无":cardpassgems[0].name}</td>
									</tr>
									<tr>
										<td class="font_color_3">${cardpasscomm[1].name == null?"暂无":cardpasscomm[1].name}</td>
										<td class="font_color_1 font_size_1">${Math.round(cardpasscomm[1].rate*100/1) }%</td>
										<td ><div class="graph_rank">2</div></td>
										<td class="font_color_1 font_size_1">${Math.round(cardpassgems[1].rate*100/1) }%</td>
										<td class="font_color_3">${cardpassgems[1].name == null?"暂无":cardpassgems[1].name}</td>
									</tr>
									<tr>
										<td class="font_color_3">${cardpasscomm[2].name == null?"暂无":cardpasscomm[2].name}</td>
										<td class="font_color_1 font_size_1">${Math.round(cardpasscomm[2].rate*100/1) }%</td>
										<td ><div class="graph_rank">3</div></td>
										<td class="font_color_1 font_size_1">${Math.round(cardpassgems[2].rate*100/1) }%</td>
										<td class="font_color_3">${cardpassgems[2].name == null?"暂无":cardpassgems[2].name}</td>
									</tr>
									<tr>
										<td class="font_color_3">${cardpasscomm[3].name == null?"暂无":cardpasscomm[3].name}</td>
										<td class="font_color_1 font_size_1">${Math.round(cardpasscomm[3].rate*100/1) }%</td>
										<td ><div class="graph_rank">4</div></td>
										<td class="font_color_1 font_size_1">${Math.round(cardpassgems[3].rate*100/1) }%</td>
										<td class="font_color_3">${cardpassgems[3].name == null?"暂无":cardpassgems[3].name}</td>
									</tr>
									<tr>
										<td class="font_color_3">${cardpasscomm[4].name == null?"暂无":cardpasscomm[4].name}</td>
										<td class="font_color_1 font_size_1">${Math.round(cardpasscomm[4].rate*100/1) }%</td>
										<td ><div class="graph_rank">5</div></td>
										<td class="font_color_1 font_size_1">${Math.round(cardpassgems[4].rate*100/1) }%</td>
										<td class="font_color_3">${cardpassgems[4].name == null?"暂无":cardpassgems[4].name}</td>
									</tr> --%>
									<tr>
										<td class="font_color_3">河北省</td>
										<td class="font_color_1 font_size_1">79%</td>
										<td ><div class="graph_rank">1</div></td>
										<td class="font_color_1 font_size_1">80%</td>
										<td class="font_color_3">购车无忧汽车服务</td>
									</tr>
									<tr>
										<td class="font_color_3">云南省</td>
										<td class="font_color_1 font_size_1">78%</td>
										<td ><div class="graph_rank">2</div></td>
										<td class="font_color_1 font_size_1">77%</td>
										<td class="font_color_3">恩梯基汽车技术</td>
									</tr>
									<tr>
										<td class="font_color_3">山西省</td>
										<td class="font_color_1 font_size_1">76%</td>
										<td ><div class="graph_rank">3</div></td>
										<td class="font_color_1 font_size_1">76%</td>
										<td class="font_color_3">万鑫汽车销售</td>
									</tr>
									<tr>
										<td class="font_color_3">河南省</td>
										<td class="font_color_1 font_size_1">74%</td>
										<td ><div class="graph_rank">4</div></td>
										<td class="font_color_1 font_size_1">74%</td>
										<td class="font_color_3">车划算汽车信息服务</td>
									</tr>
									<tr>
										<td class="font_color_3">江苏省</td>
										<td class="font_color_1 font_size_1">73%</td>
										<td ><div class="graph_rank">5</div></td>
										<td class="font_color_1 font_size_1">72%</td>
										<td class="font_color_3">花样年金融控股</td>
									</tr>
								</table>
							</div>
							<div style="width: 100%; height: 10%;margin-top: 2%;">
								<button class="graph_button" onclick="show_bjls('guojian')">更多</button>
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
										<input type="text"  value="请输入代理商" onblur="fangkuanselect()"
                                           onfocus="javascript:if(this.value=='请输入代理商')this.value='';" id="fangkuanval"/>
									</li>
									<li>
										<select id="fangkuansel" onchange="fangkuanselect()">
	                                        <option selected value="0"> 请选择省份</option>
	                                        <option value="0"> 全部</option>
	                                        <c:forEach var="list" items="${comm_city}">
	                                            <option value="${list.id}">${list.name}</option>
	                                        </c:forEach>
	                                    </select><i style="padding-left: 5px; font-weight:bold;">></i>
									</li>
									<li>
										<select id="fangkuantime" onchange="fangkuanselect()">
	                                        <option selected value="0"> 请选择时间</option>
	                                        <option value="0"> 全部</option>
	                                        <%-- <c:forEach var="list" items="${years }" >
	                                            <option value="${list}">${list}</option>
	                                        </c:forEach> --%>
	                                        <option value="2019"> 18年8月-19年7月</option>
                                        	<option value="2018"> 18年1月-18年12月</option>
	                                    </select><i style="padding-left: 5px; font-weight:bold;">></i>
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
									<%-- <p class="graph_statistics_number font_color_1">${loanlist[0].amount}<font>笔</font></p> --%>
									<p class="graph_statistics_number font_color_1">106<font>笔</font></p>
									<p class="font_size_2 font_color_3">本月放款总订单</p>
								</div>
								<div class="graph_statistics_content" style="width: 50%;float: right;">
									<p class="graph_statistics_number font_color_2">79903.77
									<font>元</font></p>
									<p class="font_size_2 font_color_3">本月放款均金额</p>
								</div>
							</div>
							
							<div class="graph_statistics_content" style="width: 100%; margin-bottom: 7%;">
									<%-- <p class="graph_statistics_number font_color_2">${Math.ceil(loanlist[0].money) >10000?Math.round(loanlist[0].money/10000): Math.ceil(loanlist[0].money)}
									<font>${Math.ceil(loanlist[0].money)>10000?"万元":"元" }</font></p> --%>
									<p class="graph_statistics_number font_color_2">846.98
									<font>万元</font></p>
									<p class="font_size_2 font_color_3">本月累计放款总订单总金额</p>
							</div>
						
							<div class="graph_statistics_centre">
								<table  class="graph_table">
									 <tr>
									    <th >省份</th>
									    <th colspan="3" class="font_color_1">排名</th>
									    <th >代理商</th>
									 </tr>
									<%-- <tr>
										<td class="font_color_3">${rankingloanlist[0].name == null?"暂无":rankingloanlist[0].name }</td>
										<td class="font_color_1 font_size_1">${rankingloanlist[0].sell == null?0:rankingloanlist[0].sell }</td>
										<td ><div class="graph_rank">1</div></td>
										<td class="font_color_1 font_size_1">${gemsloanlist[0].gems == null?0:gemsloanlist[0].gems }</td>
										<td class="font_color_3">${gemsloanlist[0].name == null?"暂无":gemsloanlist[0].name }</td>
									</tr>
									<tr>
										<td class="font_color_3">${rankingloanlist[1].name == null?"暂无":rankingloanlist[1].name }</td>
										<td class="font_color_1 font_size_1">${rankingloanlist[1].sell == null?0:rankingloanlist[1].sell }</td>
										<td ><div class="graph_rank">2</div></td>
										<td class="font_color_1 font_size_1">${gemsloanlist[1].gems == null?0:gemsloanlist[1].gems }</td>
										<td class="font_color_3">${gemsloanlist[1].name == null?"暂无":gemsloanlist[1].name }</td>
									</tr>
									<tr>
										<td class="font_color_3">${rankingloanlist[2].name == null?"暂无":rankingloanlist[2].name }</td>
										<td class="font_color_1 font_size_1">${rankingloanlist[2].sell == null?0:rankingloanlist[2].sell }</td>
										<td ><div class="graph_rank">3</div></td>
										<td class="font_color_1 font_size_1">${gemsloanlist[2].gems == null?0:gemsloanlist[2].gems }</td>
										<td class="font_color_3">${gemsloanlist[2].name == null?"暂无":gemsloanlist[2].name }</td>
									</tr>
									<tr>
										<td class="font_color_3">${rankingloanlist[3].name == null?"暂无":rankingloanlist[3].name }</td>
										<td class="font_color_1 font_size_1">${rankingloanlist[3].sell == null?0:rankingloanlist[3].sell }</td>
										<td ><div class="graph_rank">4</div></td>
										<td class="font_color_1 font_size_1">${gemsloanlist[3].gems == null?0:gemsloanlist[3].gems }</td>
										<td class="font_color_3">${gemsloanlist[3].name == null?"暂无":gemsloanlist[3].name }</td>
									</tr>
									<tr>
										<td class="font_color_3">${rankingloanlist[4].name == null?"暂无":rankingloanlist[4].name }</td>
										<td class="font_color_1 font_size_1">${rankingloanlist[4].sell == null?0:rankingloanlist[4].sell }</td>
										<td ><div class="graph_rank">5</div></td>
										<td class="font_color_1 font_size_1">${gemsloanlist[4].gems == null?0:gemsloanlist[4].gems }</td>
										<td class="font_color_3">${gemsloanlist[4].name == null?"暂无":gemsloanlist[4].name }</td>
									</tr> --%>
									<tr>
										<td class="font_color_3">云南省</td>
										<td class="font_color_1 font_size_1">17</td>
										<td ><div class="graph_rank">1</div></td>
										<td class="font_color_1 font_size_1">14</td>
										<td class="font_color_3">万鑫汽车销售</td>
									</tr>
									<tr>
										<td class="font_color_3">河北省</td>
										<td class="font_color_1 font_size_1">13</td>
										<td ><div class="graph_rank">2</div></td>
										<td class="font_color_1 font_size_1">12</td>
										<td class="font_color_3">恩梯基汽车技术</td>
									</tr>
									<tr>
										<td class="font_color_3">河南省</td>
										<td class="font_color_1 font_size_1">10</td>
										<td ><div class="graph_rank">3</div></td>
										<td class="font_color_1 font_size_1">9</td>
										<td class="font_color_3">购车无忧汽车服务</td>
									</tr>
									<tr>
										<td class="font_color_3">山西省</td>
										<td class="font_color_1 font_size_1">8</td>
										<td ><div class="graph_rank">4</div></td>
										<td class="font_color_1 font_size_1">6</td>
										<td class="font_color_3">花样年金融控股</td>
									</tr>
									<tr>
										<td class="font_color_3">江苏省</td>
										<td class="font_color_1 font_size_1">6</td>
										<td ><div class="graph_rank">5</div></td>
										<td class="font_color_1 font_size_1">5</td>
										<td class="font_color_3">车划算汽车信息服务</td>
									</tr>
								</table>
							</div>
							<div style="width: 100%; height: 10%;margin-top: 2%;">
								<button class="graph_button" onclick="show_bjls('fangkuan')">更多</button>
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
									<%-- <p class="graph_statistics_number font_color_1">${fklist[0].amount }<font>笔</font></p> --%>
									<p class="graph_statistics_number font_color_1">15<font>笔</font></p>
									<p class="font_size_2 font_color_3">本月已放款未完成</p>
									<p class="font_size_2 font_color_3">抵押的订单总数</p>
								</div>
								<div class="graph_statistics_content" style="width: 50%;float: right;height:76px;">
									<%-- <p class="graph_statistics_number font_color_2">${Math.ceil(fklist[0].money) > 10000?Math.round(fklist[0].money/10000):Math.ceil(fklist[0].money) }
									<font>${Math.ceil(fklist[0].money) > 10000?"万元":"元" }</font></p> --%>
									<p class="graph_statistics_number font_color_2">156.85
									<font>万元</font></p>
									<p class="font_size_2 font_color_3">本月已放款未完成</p>
									<p class="font_size_2 font_color_3">抵押的订单金额</p>
								</div>
							</div>
							<div style="width: 100%;height: 5%; margin-top:25px;">
								<ul class="font_color_3 font_size_2 condition1" >
									<li>
										<input type="text"  value="请输入代理商" onblur="diyaselect()"
                                           onfocus="javascript:if(this.value=='请输入代理商')this.value='';" id="diyaval"/>
									</li>
									<li>
										<select id="diyasel" onchange="diyaselect()">
	                                        <option selected value="0"> 请选择省份</option>
	                                        <option value="0"> 全部</option>
	                                        <c:forEach var="list" items="${comm_city}">
	                                            <option value="${list.id}">${list.name}</option>
	                                        </c:forEach>
	                                    </select><i style="padding-left: 5px; font-weight:bold;">></i>
									</li>
									<li>
										<select id="diyatime" onchange="diyaselect()">
	                                        <option selected value="0"> 请选择时间</option>
	                                        <option value="0"> 全部</option>
	                                        <%-- <c:forEach var="list" items="${years }" >
	                                            <option value="${list}">${list}</option>
	                                        </c:forEach> --%>
	                                        <option value="2019"> 2019</option>
                                        	<option value="2018"> 2018</option>
	                                    </select><i style="padding-left: 5px; font-weight:bold;">></i>
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
										<input type="text"  value="请输入代理商" onblur="cailiaoselect()"
                                           onfocus="javascript:if(this.value=='请输入代理商')this.value='';" id="cailiaoval"/>
									</li>
									<li>
										<select id="cailiaosel" onchange="cailiaoselect()">
	                                        <option selected value="0"> 请选择省份</option>
	                                        <option value="0"> 全部</option>
	                                        <c:forEach var="list" items="${comm_city}">
	                                            <option value="${list.id}">${list.name}</option>
	                                        </c:forEach>
	                                    </select><i style="padding-left: 5px; font-weight:bold;">></i>
									</li>
									<li>
										<select id="cailiaotime" onchange="cailiaoselect()">
	                                        <option selected value="0"> 请选择时间</option>
	                                        <option value="0"> 全部</option>
	                                        <%-- <c:forEach var="list" items="${years }" >
	                                            <option value="${list}">${list}</option>
	                                        </c:forEach> --%>
	                                        <option value="2019"> 2019</option>
                                        	<option value="2018"> 2018</option>
	                                    </select><i style="padding-left: 5px; font-weight:bold;">></i>
									</li>
								</ul>
							</div>
							<div id="cailiaohuishou" style="height: 67%;width: 100%; margin-top: 5%;margin-left: 5%;">
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
										<input type="text"  value="请输入代理商" onblur="yuqiselect()"
                                               onfocus="javascript:if(this.value=='请输入代理商')this.value='';" id="yuqival"/>
									</li>
									<li style="margin-left: 10px;">
										<select id="yuqisel" onchange="yuqiselect()">
                                            <option selected value="0"> 请选择省份</option>
                                            <option value="0"> 全部</option>
                                            <c:forEach var="list" items="${comm_city}">
                                                <option value="${list.id}">${list.name}</option>
                                            </c:forEach>
                                        </select><i style="padding-left: 5px; font-weight:bold;">></i>
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
							<table class="graph_overdue_center">
								<tr>
									<th>代理商</th>
									<th>逾期率</th>
								</tr>
								<%-- <tr>
                                    <td>${yuqilv[0].gname == null?"暂无":yuqilv[0].gname}</td>
                                    <td>${yuqilv[0].yuqilv == null?0:yuqilv[0].yuqilv}%</td>
                                </tr>
                                <tr>
                                    <td>${yuqilv[1].gname == null?"暂无":yuqilv[1].gname}</td>
                                    <td>${yuqilv[1].yuqilv == null?0:yuqilv[1].yuqilv}%</td>
                                </tr>
                                <tr>
                                    <td>${yuqilv[2].gname == null?"暂无":yuqilv[2].gname}</td>
                                    <td>${yuqilv[2].yuqilv == null?0:yuqilv[2].yuqilv}%</td>
                                </tr>
                                <tr>
                                    <td>${yuqilv[3].gname == null?"暂无":yuqilv[3].gname}</td>
                                    <td>${yuqilv[3].yuqilv == null?0:yuqilv[3].yuqilv}%</td>
                                </tr>
                                <tr>
                                    <td>${yuqilv[4].gname == null?"暂无":yuqilv[4].gname}</td>
                                    <td>${yuqilv[4].yuqilv == null?0:yuqilv[4].yuqilv}%</td>
                                </tr> --%>
                                <tr>
                                    <td>万鑫汽车销售</td>
                                    <td>0.37%</td>
                                </tr>
                                <tr>
                                    <td>购车无忧汽车服务</td>
                                    <td>0.36%</td>
                                </tr>
                                <tr>
                                    <td>恩梯基汽车技术</td>
                                    <td>0.35%</td>
                                </tr>
                                <tr>
                                    <td>车划算汽车信息服务</td>
                                    <td>0.22%</td>
                                </tr>
                                <tr>
                                    <td>花样年金融控股</td>
                                    <td>0.15%</td>
                                </tr>
							</table>
							<div style="width: 100%; height: 10%;margin-top: 2%;">
								<button class="graph_button" style="margin-right: 0;" onclick="show_bjls1()">更多</button>
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
										<input type="text"  value="请输入代理商" onblur="dailiselect()"
                                           onfocus="javascript:if(this.value=='请输入代理商')this.value='';" id="dailival"/>
									</li>
									<li>
										<select id="dailitime" onchange="dailiselect()">
	                                        <option selected value="0"> 请选择时间</option>
	                                        <option value="0"> 全部</option>
	                                        <%-- <c:forEach var="list" items="${years }" >
	                                            <option value="${list}">${list}</option>
	                                        </c:forEach> --%>
	                                        <option value="2019"> 2019</option>
                                        	<option value="2018"> 2018</option>
	                                    </select><i style="padding-left: 5px; font-weight:bold;">></i>
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
										<input type="text"  value="请输入代理商" onblur="zhengxinselect()"
                                           onfocus="javascript:if(this.value=='请输入代理商')this.value='';" id="zhengxinval"/>
									</li>
									<li>
		                                <select id="zhengxinsel" onchange="zhengxinselect()">
		                                    <option selected value="0"> 请选择省份</option>
		                                    <option value="0"> 全部</option>
		                                    <c:forEach var="list" items="${comm_city}">
		                                        <option value="${list.id}">${list.name}</option>
		                                    </c:forEach>
		                                </select><i style="padding-left: 5px; font-weight:bold;">></i>
		                            </li>
		                            <li>
	                                    <select id="zhengxintime" onchange="zhengxinselect()">
	                                        <option selected value="0"> 请选择时间</option>
	                                        <option value="0"> 全部</option>
	                                        <%-- <c:forEach var="year" items="${years }" >
	                                            <option value="${year}">${year}</option>
	                                        </c:forEach> --%>
	                                        <option value="2019"> 2019</option>
                                        	<option value="2018"> 2018</option>
	                                    </select><i style="padding-left: 5px; font-weight:bold;">></i>
		                            </li>
								</ul>
							</div>
							<div id="zhengxinchaxuntongguolv" style="width: 100%;height: 80%; position: relative; top: -10px;  ">
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
									<div class="font_size_2 font_color_3" style="margin-top: 7px;float: left;">所属用户</div>
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
							<div class="font_size_2 font_color_3" style="margin-left: 50px;margin-top: 2px;">
								<select id="dianzisel" onchange="dianziselect()" >
                                    <option selected value="0"> 请选择省份</option>
                                    <option value="0"> 全部</option>
                                    <c:forEach var="list" items="${comm_city}">
                                        <option value="${list.id}">${list.name}</option>
                                    </c:forEach>
                                </select><i style="padding-left: 5px; font-weight:bold;">></i>
							</div>
						</div>
						<div id="zijinzhouzhuanlv" style="width: 100%;height: 71%;">
						</div>
					</div>
				</div>
			</div>
			<!-- 数据图2结束 -->
		</div>
	</div>
	
	<div class="modal fade in" id="addModal_tdtf" tabindex="-1" role="dialog" aria-labelledby="imgs_yyclLabel"
     aria-hidden="false">
    <div class="modal-dialog modal-lg" style="width: 400px;height: 600px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" align="center" id="aayyclModalLabel">省份/代理商排名</h4>
            </div>
            <div id="modal_add" class="modal-body modal-open"
                 style="height:100%;border:1px solid #ccc;background-color:#F7F7F7;border-radius: 10px;margin:30px;">
                <div class="graph_statistics_centre">
                    <%--   报单统计更多排名  --%>
                    <table  class="paiming_table_style" id="baodangengduo">
                        <tr>
                            <th style="color:#333333">省份</th>
                            <th colspan="3" class="font_color_1">排名</th>
                            <th >代理商</th>
                        </tr>
                        <%-- <c:forEach items="${ count }" var="rank" varStatus="lists" >
                            <tr>
                            	<td class="font_color_3">${rankinglist[lists.count-1].name == null?"暂无":rankinglist[lists.count-1].name }</td>
								<td class="font_color_1 font_size_1">${rankinglist[lists.count-1].sell == null?0:rankinglist[lists.count-1].sell }</td>
								<td ><div class="graph_rank">${lists.count}</div></td>
								<td class="font_color_1 font_size_1">${gemslist[lists.count-1].gems == null?0:gemslist[lists.count-1].gems }</td>
								<td class="font_color_3">${gemslist[lists.count-1].name == null?"暂无":gemslist[lists.count-1].name }</td>
                            </tr>
                        </c:forEach> --%>
                        			<tr>
										<td class="font_color_3">河北省</td>
										<td class="font_color_1 font_size_1">20</td>
										<td ><div class="graph_rank">1</div></td>
										<td class="font_color_1 font_size_1">12</td>
										<td class="font_color_3">购车无忧汽车服务</td>
									</tr>
									<tr>
										<td class="font_color_3">云南省</td>
										<td class="font_color_1 font_size_1">19</td>
										<td ><div class="graph_rank">2</div></td>
										<td class="font_color_1 font_size_1">11</td>
										<td class="font_color_3">万鑫汽车销售</td>
									</tr>
									<tr>
										<td class="font_color_3">山西省</td>
										<td class="font_color_1 font_size_1">17</td>
										<td ><div class="graph_rank">3</div></td>
										<td class="font_color_1 font_size_1">10</td>
										<td class="font_color_3">恩梯基汽车技术</td>
									</tr>
									<tr>
										<td class="font_color_3">河南省</td>
										<td class="font_color_1 font_size_1">16</td>
										<td ><div class="graph_rank">4</div></td>
										<td class="font_color_1 font_size_1">9</td>
										<td class="font_color_3">车划算汽车信息服务</td>
									</tr>
									<tr>
										<td class="font_color_3">江苏省</td>
										<td class="font_color_1 font_size_1">15</td>
										<td ><div class="graph_rank">5</div></td>
										<td class="font_color_1 font_size_1">8</td>
										<td class="font_color_3">花样年金融控股</td>
									</tr>
									<tr>
										<td class="font_color_3">安徽省</td>
										<td class="font_color_1 font_size_1">13</td>
										<td ><div class="graph_rank">6</div></td>
										<td class="font_color_1 font_size_1">6</td>
										<td class="font_color_3">泓玥汽车服务</td>
									</tr>
									<tr>
										<td class="font_color_3">福建省</td>
										<td class="font_color_1 font_size_1">11</td>
										<td ><div class="graph_rank">7</div></td>
										<td class="font_color_1 font_size_1">5</td>
										<td class="font_color_3">华祥汽车服务</td>
									</tr>
									<tr>
										<td class="font_color_3">浙江省</td>
										<td class="font_color_1 font_size_1">8</td>
										<td ><div class="graph_rank">8</div></td>
										<td class="font_color_1 font_size_1">3</td>
										<td class="font_color_3">驰顺汽车</td>
									</tr>
									<tr>
										<td class="font_color_3">四川省</td>
										<td class="font_color_1 font_size_1">5</td>
										<td ><div class="graph_rank">9</div></td>
										<td class="font_color_1 font_size_1">2</td>
										<td class="font_color_3">简致汽车销售</td>
									</tr>
									<tr>
										<td class="font_color_3">山东省</td>
										<td class="font_color_1 font_size_1">4</td>
										<td ><div class="graph_rank">10</div></td>
										<td class="font_color_1 font_size_1">2</td>
										<td class="font_color_3">巍巍汽车销售服务</td>
									</tr>
                    </table>
                    <%--   汽车贷款更多排名  --%>
                    <table  class="paiming_table_style" id="guojiangengduo">
                        <tr>
                            <th style="color:#333333">省份</th>
                            <th colspan="3" class="font_color_1">排名</th>
                            <th >代理商</th>
                        </tr>
                        <%-- <c:forEach items="${ count }" var="comm" varStatus="lists">
                            <tr>
                            	<td class="font_color_3">${cardpasscomm[lists.count-1].name == null?"暂无":cardpasscomm[lists.count-1].name }</td>
								<td class="font_color_1 font_size_1">${Math.round(cardpasscomm[lists.count-1].rate*100/1) }%</td>
								<td ><div class="graph_rank">${lists.count}</div></td>
								<td class="font_color_1 font_size_1">${Math.round(cardpassgems[lists.count-1].rate*100/1) }%</td>
								<td class="font_color_3">${cardpassgems[lists.count-1].name == null?"暂无":cardpassgems[lists.count-1].name }</td>
                            </tr>
                        </c:forEach> --%>
                        			<tr>
										<td class="font_color_3">河北省</td>
										<td class="font_color_1 font_size_1">79%</td>
										<td ><div class="graph_rank">1</div></td>
										<td class="font_color_1 font_size_1">80%</td>
										<td class="font_color_3">购车无忧汽车服务</td>
									</tr>
									<tr>
										<td class="font_color_3">云南省</td>
										<td class="font_color_1 font_size_1">78%</td>
										<td ><div class="graph_rank">2</div></td>
										<td class="font_color_1 font_size_1">77%</td>
										<td class="font_color_3">恩梯基汽车技术</td>
									</tr>
									<tr>
										<td class="font_color_3">山西省</td>
										<td class="font_color_1 font_size_1">76%</td>
										<td ><div class="graph_rank">3</div></td>
										<td class="font_color_1 font_size_1">76%</td>
										<td class="font_color_3">万鑫汽车销售</td>
									</tr>
									<tr>
										<td class="font_color_3">河南省</td>
										<td class="font_color_1 font_size_1">74%</td>
										<td ><div class="graph_rank">4</div></td>
										<td class="font_color_1 font_size_1">74%</td>
										<td class="font_color_3">车划算汽车信息服务</td>
									</tr>
									<tr>
										<td class="font_color_3">江苏省</td>
										<td class="font_color_1 font_size_1">73%</td>
										<td ><div class="graph_rank">5</div></td>
										<td class="font_color_1 font_size_1">72%</td>
										<td class="font_color_3">花样年金融控股</td>
									</tr>
									<tr>
										<td class="font_color_3">浙江省</td>
										<td class="font_color_1 font_size_1">71%</td>
										<td ><div class="graph_rank">6</div></td>
										<td class="font_color_1 font_size_1">71%</td>
										<td class="font_color_3">华祥汽车服务</td>
									</tr>
									<tr>
										<td class="font_color_3">山东省</td>
										<td class="font_color_1 font_size_1">69%</td>
										<td ><div class="graph_rank">7</div></td>
										<td class="font_color_1 font_size_1">66%</td>
										<td class="font_color_3">驰顺汽车</td>
									</tr>
									<tr>
										<td class="font_color_3">安徽省</td>
										<td class="font_color_1 font_size_1">68%</td>
										<td ><div class="graph_rank">8</div></td>
										<td class="font_color_1 font_size_1">65%</td>
										<td class="font_color_3">简致汽车销售</td>
									</tr>
									<tr>
										<td class="font_color_3">四川省</td>
										<td class="font_color_1 font_size_1">66%</td>
										<td ><div class="graph_rank">9</div></td>
										<td class="font_color_1 font_size_1">64%</td>
										<td class="font_color_3">巍巍汽车销售服务</td>
									</tr>
									<tr>
										<td class="font_color_3">福建省</td>
										<td class="font_color_1 font_size_1">65%</td>
										<td ><div class="graph_rank">10</div></td>
										<td class="font_color_1 font_size_1">63%</td>
										<td class="font_color_3">泓玥汽车服务</td>
									</tr>
                    </table>
                    <%--   放款统计更多排名  --%>
                    <table class="paiming_table_style" id="fangkuangengduo">
                        <tr>
                            <th style="color:#333333">省份</th>
                            <th colspan="3" class="font_color_1">排名</th>
                            <th >代理商</th>
                        </tr>
                        <%-- <c:forEach items="${ count }" var="rank" varStatus="lists">
                            <tr>
                            	<td class="font_color_3">${rankingloanlist[lists.count-1].name == null?"暂无":rankingloanlist[lists.count-1].name }</td>
								<td class="font_color_1 font_size_1">${rankingloanlist[lists.count-1].sell == null?0:rankingloanlist[lists.count-1].sell }</td>
								<td ><div class="graph_rank">${lists.count}</div></td>
								<td class="font_color_1 font_size_1">${gemsloanlist[lists.count-1].gems == null?0:gemsloanlist[lists.count-1].gems }</td>
								<td class="font_color_3">${gemsloanlist[lists.count-1].name == null?"暂无":gemsloanlist[lists.count-1].name }</td>
                            </tr>
                        </c:forEach> --%>
                        			<tr>
										<td class="font_color_3">云南省</td>
										<td class="font_color_1 font_size_1">17</td>
										<td ><div class="graph_rank">1</div></td>
										<td class="font_color_1 font_size_1">14</td>
										<td class="font_color_3">万鑫汽车销售</td>
									</tr>
									<tr>
										<td class="font_color_3">河北省</td>
										<td class="font_color_1 font_size_1">13</td>
										<td ><div class="graph_rank">2</div></td>
										<td class="font_color_1 font_size_1">12</td>
										<td class="font_color_3">恩梯基汽车技术</td>
									</tr>
									<tr>
										<td class="font_color_3">河南省</td>
										<td class="font_color_1 font_size_1">10</td>
										<td ><div class="graph_rank">3</div></td>
										<td class="font_color_1 font_size_1">9</td>
										<td class="font_color_3">购车无忧汽车服务</td>
									</tr>
									<tr>
										<td class="font_color_3">山西省</td>
										<td class="font_color_1 font_size_1">8</td>
										<td ><div class="graph_rank">4</div></td>
										<td class="font_color_1 font_size_1">6</td>
										<td class="font_color_3">花样年金融控股</td>
									</tr>
									<tr>
										<td class="font_color_3">江苏省</td>
										<td class="font_color_1 font_size_1">6</td>
										<td ><div class="graph_rank">5</div></td>
										<td class="font_color_1 font_size_1">5</td>
										<td class="font_color_3">车划算汽车信息服务</td>
									</tr>
									<tr>
										<td class="font_color_3">浙江省</td>
										<td class="font_color_1 font_size_1">3</td>
										<td ><div class="graph_rank">6</div></td>
										<td class="font_color_1 font_size_1">4</td>
										<td class="font_color_3">泓玥汽车服务</td>
									</tr>
									<tr>
										<td class="font_color_3">福建省</td>
										<td class="font_color_1 font_size_1">3</td>
										<td ><div class="graph_rank">7</div></td>
										<td class="font_color_1 font_size_1">3</td>
										<td class="font_color_3">巍巍汽车销售服务</td>
									</tr>
									<tr>
										<td class="font_color_3">安徽省</td>
										<td class="font_color_1 font_size_1">2</td>
										<td ><div class="graph_rank">8</div></td>
										<td class="font_color_1 font_size_1">2</td>
										<td class="font_color_3">驰顺汽车</td>
									</tr>
									<tr>
										<td class="font_color_3">山东省</td>
										<td class="font_color_1 font_size_1">1</td>
										<td ><div class="graph_rank">9</div></td>
										<td class="font_color_1 font_size_1">1</td>
										<td class="font_color_3">简致汽车销售</td>
									</tr>
									<tr>
										<td class="font_color_3">四川省</td>
										<td class="font_color_1 font_size_1">1</td>
										<td ><div class="graph_rank">10</div></td>
										<td class="font_color_1 font_size_1">1</td>
										<td class="font_color_3">华祥汽车服务</td>
									</tr>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" id="closet" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
	
	<div class="modal fade in" id="addModal_tdtf1" tabindex="-1" role="dialog" aria-labelledby="imgs_yyclLabel"
     aria-hidden="false">
    <div class="modal-dialog modal-lg" style="width: 400px;height: 600px;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" align="center" id="">省份/代理商排名</h4>
            </div>
            <div class="modal-body modal-open"
                 style="height:100%;border:1px solid #ccc;background-color:#F7F7F7;border-radius: 10px;margin:30px;">
                <div class="graph_statistics_centre">
                    <%--   逾期更多排名  --%>
                    <table class="yuqipaiming yuqigd">
                        <tr>
                            <th>代理商</th>
                            <th>逾期率</th>
                        </tr>
                        <%-- <c:forEach items="${ count }" var="rank" varStatus="lists">
                            <tr>
                                <td>${yuqilv[lists.count-1].gname == null?"暂无":yuqilv[lists.count-1].gname}</td>
                                <td>${yuqilv[lists.count-1].yuqilv == null?0:yuqilv[lists.count-1].yuqilv}%</td>
                            </tr>
                        </c:forEach> --%>
                        <tr>
                            <td>万鑫汽车销售</td>
                                <td>0.37%</td>
                            </tr>
                            <tr>
                                <td>购车无忧汽车服务</td>
                                <td>0.36%</td>
                            </tr>
                            <tr>
                                <td>恩梯基汽车技术</td>
                                <td>0.35%</td>
                            </tr>
                            <tr>
                                <td>车划算汽车信息服务</td>
                                <td>0.22%</td>
                            </tr>
                            <tr>
                                <td>花样年金融控股</td>
                                <td>0.15%</td>
                            </tr>
                            <tr>
	                        	<td>泓玥汽车服务</td>
	                            <td>0.15%</td>
	                        </tr>
	                        <tr>
	                            <td>巍巍汽车销售服务</td>
	                            <td>0.14%</td>
	                        </tr>
	                        <tr>
	                            <td>驰顺汽车</td>
	                            <td>0.12%</td>
	                        </tr>
	                        <tr>
	                            <td>简致汽车销售</td>
	                            <td>0.10%</td>
	                        </tr>
	                        <tr>
	                            <td>华祥汽车服务</td>
	                            <td>0.08%</td>
	                        </tr>
                    </table>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/kjs_icbc/content/glzx_style/js/DateIMG1.js" ></script>
	<script type="text/javascript">
	  window.onload =function(){
		document.getElementById("graph_transform2").style.display="none";
		
		 //加载可视化组件
        baodanselect();
        guojianselect();
        fangkuanselect();
        diyaselect();
        cailiaoselect();
        zhengxinselect();
        dianziselect();
        yuqiselect();
        dailiselect();
         
	};
	function show_bjls(type) {
        if(type == 'baodan'){
            document.getElementById("guojiangengduo").style.display="none";
            document.getElementById("fangkuangengduo").style.display="none";
            document.getElementById("baodangengduo").style.display="block";
        }
        if(type == 'guojian'){
            document.getElementById("baodangengduo").style.display="none";
            document.getElementById("fangkuangengduo").style.display="none";
            document.getElementById("guojiangengduo").style.display="block";
        }
        if(type == 'fangkuan'){
            document.getElementById("baodangengduo").style.display="none";
            document.getElementById("guojiangengduo").style.display="none";
            document.getElementById("fangkuangengduo").style.display="block";
        }

        $('#addModal_tdtf').modal({show: true});
    }

    function show_bjls1() {
        $('#addModal_tdtf1').modal({show: true});
    }	

	</script>


