<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>工行征信</h1>
<form action="icbcCredit.do" method="post" enctype="multipart/form-data">
姓名:<input type="text" id="name" name="name" /><br/>
业务等级:<input type="text" id="businesslevel" name="businesslevel" /><br/>
贷款产品:<input type="text" id="product_id" name="product_id" /><br/>
按揭银行:<input type="text" id="ajbank_id" name="ajbank_id" /><br/>
身份证号:<input type="text" id="cardno" name="cardno" /><br/>
性别:<input type="text" id="sex" name="sex" /><br/>
手机号:<input type="text" id="phoneno" name="phoneno" /><br/>
appkey:<input type="text" id="appkey" name="appkey" /><br/>
订单编号:<input type="text" id="orderid" name="orderid" /><br/>
通融状态:<input type="text" id="tr_status" name="tr_status" /><br/>
通融原因:<input type="text" id="tr_msg" name="tr_msg" /><br/>
配偶姓名:<input type="text" id="po_name" name="po_name" /><br/>
配偶身份证:<input type="text" id="po_cardno" name="po_cardno" /><br/>
配偶手机号:<input type="text" id="po_phoneno" name="po_phoneno" /><br/>
共借人1:<input type="text" id="g_name1" name="g_name1" /><br/>
共借人1身份证号:<input type="text" id="g_cardno1" name="g_cardno1" /><br/>
共借人1手机:<input type="text" id="g_phoneno1" name="g_phoneno1" /><br/>
共借人2:<input type="text" id="g_name2" name="g_name2" /><br/>
共借人2身份证号:<input type="text" id="g_cardno2" name="g_cardno2" /><br/>
共借人2手机:<input type="text" id="g_phoneno2" name="g_phoneno2" /><br/>
img1:<input type="file" id="cardfront" name="cardfront" /><br/>
img2:<input type="file" id="cardopposite" name="cardopposite" /><br/>
img3:<input type="file" id="authorizebook" name="authorizebook" /><br/>
img4:<input type="file" id="cardfacebook" name="cardfacebook" /><br/>
bc_img1:<input type="file" id="suppily" name="suppily" /><br/>
bc_img1:<input type="file" id="suppily" name="suppily" /><br/>
<input type="submit" value="提交" />
</form>

<h1>征信结果</h1>
<form action="icbcCredit_result.do" method="post" enctype="multipart/form-data">
订单编号:<input type="text" id="orderid" name="orderid" /><br/>
appkey:<input type="text" id="appkey" name="appkey" /><br/>
<input type="submit" value="提交" />
</form>

<h1>汽车预评估</h1>
<form action="icbcpreaudit.do" method="post" enctype="multipart/form-data">
订单编号:<input type="text" id="orderid" name="orderid" /><br/>
ckey:<input type="text" id="ckey" name="ckey" /><br/>
1国产/2进口:<input type="text" id="source_id" name="source_id" /><br/>
使用性质 1营运/2非营运:<input type="text" id="property_id" name="property_id" /><br/>
1自动/2手动:<input type="text" id="gear_box_id" name="gear_box_id" /><br/>
车辆状况:<input type="text" id="car_status" name="car_status" /><br/>
车品牌:<input type="text" id="brand_id" name="brand_id" /><br/>
车系:<input type="text" id="series_id" name="series_id" /><br/>
车型:<input type="text" id="model_id" name="model_id" /><br/>
车牌号:<input type="text" id="carno" name="carno" /><br/>
行驶里程:<input type="text" id="car_mileage" name="car_mileage" /><br/>
车架号:<input type="text" id="car_vin" name="car_vin" /><br/>
初次登记日期:<input type="text" id="first_date" name="first_date" /><br/>
出厂日期:<input type="text" id="factory_date" name="factory_date" /><br/>
是否编辑:<input type="text" id="oredit" name="oredit" /><br/>
<input type="submit" value="提交" />
</form>
<h1>专业评估</h1>
<form action="icbc_cars_assess.do" method="post" enctype="multipart/form-data">
订单编号:<input type="text" id="orderid" name="orderid" /><br/>
ckey:<input type="text" id="appkey" name="appkey" /><br/>
国产/进口:<input type="text" id="source_id" name="source_id" /><br/>
使用性质 :<input type="text" id="property_id" name="property_id" /><br/>
变速箱:<input type="text" id="gear_box_id" name="gear_box_id" /><br/>
 车型:<input type="text" id="brid" name="brid" /><br/>
车型:<input type="text" id="seid" name="seid" /><br/>
车型:<input type="text" id="carid" name="carid" /><br/>  
车辆状况:<input type="text" id="car_status" name="car_status" /><br/>
行驶里程(公里) :<input type="text" id="car_km_icbc" name="car_km_icbc" /><br/>
出厂日期:<input type="text" id="cardt2" name="cardt2" /><br/>
初次等级日期:<input type="text" id="cardt1" name="cardt1" /><br/>
颜色:<input type="text" id="color_id" name="color_id" /><br/>
所在省:<input type="text" id="mem_states" name="mem_states" /><br/>
所在市:<input type="text" id="mem_citys" name="mem_citys" /><br/>
车牌号:<input type="text" id="c_carno" name="c_carno" /><br/>
车架号:<input type="text" id="vincode" name="vincode" /><br/>
预期价格:<input type="text" id="icbc_pricecs" name="icbc_pricecs" /><br/>
1:<input type="file" id="files" name="files" /><br/>
2:<input type="file" id="files" name="files" /><br/>
3:<input type="file" id="files" name="files" /><br/>
4:<input type="file" id="files" name="files" /><br/>
编辑:<input type="text" id="oredit" name="oredit" /><br/>
<input type="submit" value="提交" />
</form>
<h1>专业评估结果</h1>
<form action="icbc_cars_assess_result.do" method="post" enctype="multipart/form-data">
订单编号:<input type="text" id="orderid" name="orderid" /><br/>
appkey:<input type="text" id="appkey" name="appkey" /><br/>
<input type="submit" value="提交" />
</form>
<h1>开卡</h1>
<form action="icbc_Entry.do" method="post" enctype="multipart/form-data">
订单编号:<input type="text" id="orderid" name="orderid" /><br/>
appkey:<input type="text" id="appkey" name="appkey" /><br/>
客户姓名:<input type="text" id="name" name="name" /><br/>
手机号:<input type="text" id="phoneno" name="phoneno" /><br/>
面签照:<input type="file" id="visainterview" name="visainterview" /><br/>
信用卡申请表1:<input type="file" id="creditcard1" name="creditcard1" /><br/>
信用卡申请表2:<input type="file" id="creditcard2" name="creditcard2" /><br/>
身份证正面:<input type="file" id="kkcardfront" name="kkcardfront" /><br/>
身份证反面:<input type="file" id="kkcardopposite" name="kkcardopposite" /><br/>
个人税收居民身份证申明文件:<input type="file" id="doitric" name="doitric" /><br/>
专项分期付款业务信息表 :<input type="file" id="sibit" name="sibit" /><br/>
新增补充材料:<input type="file" id="addsuppily" name="addsuppily" /><br/>
开票价:<input type="text" id="billingprice" name="billingprice" /><br/>
贷款金额:<input type="text" id="loanprice" name="loanprice" /><br/>
服务费:<input type="text" id="coverprice" name="coverprice" /><br/>
贷款总额:<input type="text" id="loanallprice" name="loanallprice" /><br/>
首付金额:<input type="text" id="sfje" name="sfje" /><br/>
按揭模式:<input type="text" id="mortgagemodel" name="mortgagemodel" /><br/>
按揭期限:<input type="text" id="mortgageterm" name="mortgageterm" /><br/>
按揭银行:<input type="text" id="mortgagebank" name="mortgagebank" /><br/>
贷款利率:<input type="text" id="dk_lv" name="dk_lv" /><br/>
垫资类型:<input type="text" id="dz_type" name="dz_type" /><br/>
汽车类型:<input type="text" id="cars_type" name="cars_type" /><br/>
上牌地址1:<input type="text" id="kk_car_stateid" name="kk_car_stateid" /><br/>
上牌地址2:<input type="text" id="kk_car_cityid" name="kk_car_cityid" /><br/>
上牌地址3:<input type="text" id="kk_loan_stateid" name="kk_loan_stateid" /><br/>
上牌地址4:<input type="text" id="kk_loan_cityid" name="kk_loan_cityid" /><br/>
是否编辑此订单:<input type="text" id="oredit" name="oredit" /><br/>
<input type="submit" value="提交" />
</form>
<h1>开卡结果</h1>
<form action="icbc_Entry_result.do" method="post" enctype="multipart/form-data">
订单编号:<input type="text" id="orderid" name="orderid" /><br/>
appkey:<input type="text" id="appkey" name="appkey" /><br/>
<input type="submit" value="提交" />
</form>

<h1>贷款</h1>
<form action="carDk.do" method="post" enctype="multipart/form-data">
订单编号:<input type="text" id="orderid" name="orderid" /><br/>
appkey:<input type="text" id="appkey" name="appkey" /><br/>
<font>-------签约材料-------</font><br/>
签约材料补充:<input type="file" id="img1_1s" name="img1_1s" /><br/>
首付证明:<input type="file" id="img1_1s" name="img1_1s" /><br/>
专项分期付款调查审批表:<input type="file" id="img1_2s" name="img1_2s" /><br/>
送达地址确认协议:<input type="file" id="img1_2s" name="img1_2s" /><br/>
担保确认函:<input type="file" id="img1_3s" name="img1_3s" /><br/>
承诺书:<input type="file" id="img1_3s" name="img1_3s" /><br/>
委托代购服务协议1:<input type="file" id="img1_4s" name="img1_4s" /><br/>
委托代购服务协议2:<input type="file" id="img1_4s" name="img1_4s" /><br/>
信用卡透支分期付款申请书:<input type="file" id="img1_5s" name="img1_5s" /><br/>
信用卡汽车分期客户告知书:<input type="file" id="img1_5s" name="img1_5s" /><br/>
银行流水(3-6个月内):<input type="file" id="img1_5s" name="img1_5s" /><br/>
<font>------证明材料--------</font><br/>
新增户口本照片1:<input type="file" id="img2_1s" name="img2_1s" /><br/>
新增户口本照片2:<input type="file" id="img2_1s" name="img2_1s" /><br/>
<font>------其他材料--------</font><br/>
新增家庭照片1:<input type="file" id="img3_1s" name="img3_1s" /><br/>
新增家庭照片2:<input type="file" id="img3_1s" name="img3_1s" /><br/>
<font>------补充材料--------</font><br/>
新增驾驶证1:<input type="file" id="img4_1s" name="img4_1s" /><br/>
新增驾驶证2:<input type="file" id="img4_1s" name="img4_1s" /><br/>
编辑:<input type="text" id="oredit" name="oredit" /><br/>
<input type="submit" value="提交" />
</form>
<h1>贷款结果</h1>
<form action="carDk_result.do" method="post" enctype="multipart/form-data">
订单编号:<input type="text" id="orderid" name="orderid" /><br/>
appkey:<input type="text" id="appkey" name="appkey" /><br/>
<input type="submit" value="提交" />
</form>
<h1>面签</h1>
<form action="icbcMQ.do" method="post" enctype="multipart/form-data">
订单编号:<input type="text" id="orderid" name="orderid" /><br/>
appkey:<input type="text" id="appkey" name="appkey" /><br/>
面签视频1:<input type="file" id="video1" name="video1" /><br/>
面签视频2:<input type="file" id="video2" name="video2" /><br/>
面签视频3:<input type="file" id="video3" name="video3" /><br/>
面签视频4:<input type="file" id="video4" name="video4" /><br/>
oredit:<input type="text" id="oredit" name="oredit" /><br/>
<input type="submit" value="提交" />
</form>

<h1>面签结果</h1>
<form action="icbcMQ_result.do" method="post" enctype="multipart/form-data">
订单编号:<input type="text" id="orderid" name="orderid" /><br/>
appkey:<input type="text" id="appkey" name="appkey" /><br/>
<input type="submit" value="提交" />
</form>

<h1>解压文件</h1>
<form action="unzip.do" method="post" enctype="multipart/form-data">
订单编号:<input type="text" id="orderid" name="orderid" /><br/>
appkey:<input type="text" id="appkey" name="appkey" /><br/>
压缩包名称:<input type="text" id="zipname" name="zipname" /><br/>
编辑:<input type="text" id="oredit" name="oredit" /><br/>
<input type="submit" value="提交" />
</form>

</body>
</html>