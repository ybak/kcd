package com.http.tyAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class addLoanInfo  {

    /**
     * 以post方式访问
     * 
     * @param url
     *            接口url地址
     * @param xmlBody
     *            xml格式的字符串
     * @return
     */
    public static String post(String url, String xmlBody) {
        HttpClient httpClient = new DefaultHttpClient();
        try {
            HttpPost httpPost = new HttpPost(url);

            StringEntity input = new StringEntity(xmlBody, "UTF-8");
            input.setContentType("application/json");

            httpPost.setEntity(input);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();

            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity httpEntity = httpResponse.getEntity();
                String result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                EntityUtils.consume(httpEntity);
                JSONObject j = JSON.parseObject(result);
                System.out.println(result);
                return result;
            } else {
                HttpEntity httpEntity = httpResponse.getEntity();
                String result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                EntityUtils.consume(httpEntity);
                JSONObject j = JSON.parseObject(result);
                System.out.println(result);
                return result;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                httpClient.getConnectionManager().shutdown();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return "";
    }

    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCU41GfwgaxN4b5HjL5BcbTPbkBTjhqalo45yXSUaz1jI29Wg1kvG7SEsBJvNGbPJrD5O/0G9nYddaqUo72jcFyiCtMycIvWdFes62Tc/ulezYD6Wyo5lsVPkGmNg/QitwVpcrKFam/GEiErduae9pwfB8zhyfrCA3iiSPVCGP7ywIDAQAB";

    private static String privatekey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJTjUZ/CBrE3hvkeMvkFxtM9uQFOOGpqWjjnJdJRrPWMjb1aDWS8btISwEm80Zs8msPk7/Qb2dh11qpSjvaNwXKIK0zJwi9Z0V6zrZNz+6V7NgPpbKjmWxU+QaY2D9CK3BWlysoVqb8YSISt25p72nB8HzOHJ+sIDeKJI9UIY/vLAgMBAAECgYEAim5IyCdYnZEpN5qyfgK2+FVdHC+kGJ1Fwb541fIGxE+owbNm3JCu4Td5/ZVHtfRFWXoU+HyksbPuoXIdZnQqtWuInNhdPVpiir6/yXSvP5LLfQN6lqkCzapgtuhuz3Cayp58qb0k4ujZ2l5pegNN7a8plqHUSZNoE3VFHMNNTZECQQDYyRm7U+gliPlnO8bpnnU6ciFbiAeXbWS4z+HY2hLHWqFO7U2grBKueJ1yMYDNL8PCGbbyO0bUxDIu07t5KYg1AkEAr9IEzgIYwbCBujRgJ3rj7r5bXsggzTiHLypj+Uvsq0niI2TvHmiYczP0m9lSHmuvZwhcdhd0bufA81Zigi/z/wJBAIcVAGC3Dw/cgzQtjmviXj/WAC0t3TUhaEK03pEmic8JDTzGJ7n3nwhyhgEzEYRJwByBs3rLLv7DZlXBf68nDwUCQHe4mND2mIj7ebqjg34eriqZsHn/6GYVweeaA+1zh7qzWqsjRbf9HSIFFOEywDo6tXuBNAStv/jtEnQgNH/Vy10CQBzWF7XlU9oXiLwoVoe+7JAe7cnfAfG+2nwiuzc0x9oHB1p7rET3u0AMIR6LfC0K2FWheQRYcqsAWyQviIjWa8I=";

//    private static JSONObject createHead() {
//        JSONObject obj = new JSONObject();
//        obj.put("ver", "1.0");// 版本
//        obj.put("curTime", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
//        obj.put("nonce", new Random().nextInt(10000));// 一个随机数
//        obj.put("sign", MD5.sign(privatekey + obj.getString("nonce") + obj.getString("curTime"), "UTF-8"));// 签名
//        obj.put("signType", "MD5");// 签名类型
//        obj.put("appKey", "adsdasd");// 多盈提供的APPKEY
//        return obj;
//    }

//    public static void core() {
//        JSONObject data = new JSONObject();
//        List<JSONObject> loanInfoList = new ArrayList<>();
//        loanInfoList.add(addLoanInfo());
//        data.put("loanInfoList", loanInfoList);
//        // 先调用同步借款人接口
//        JSONObject obj = createHead();
//        obj.put("data", data); // 传递的参数
//        cachedThreadPool.execute(new Runnable() {
//            String aa = obj.toString();
//
//            @Override
//            public void run() {
//                post("http://localhost:8080/services/rest/loan/addLoanInfo", aa);
//            }
//        });
//    }

    private static JSONObject addLoanInfo() {
        JSONObject loanInfo = new JSONObject();// 代表一个数据的集合
        loanInfo.put("loanBase", addLoanBase());
        loanInfo.put("repaymentPlan", addRepaymentPlan());
        loanInfo.put("authInfo", addAuthInfo());
        return loanInfo;
    }

    private static Object addAuthInfo() {
        JSONObject authInfo = new JSONObject();
        authInfo.put("creditInvestigate", addAttachment("认证信息附件"));

        authInfo.put("riskInfo", addRiskInfo());

        authInfo.put("riskResult", addRiskResult());
        authInfo.put("phoneCommInfo", addCommInfo());
        authInfo.put("phoneOperatorInfo", addOperatorInfo());
        authInfo.put("phoneCallRecord", phoneCallRecord());
        authInfo.put("phoneWaitRecord", phoneWaitRecord());
        authInfo.put("phoneRiskAnalysis", phoneRiskAnalysis());
        authInfo.put("phoneConsumeAnalysis", phoneConsumeAnalysis());
        authInfo.put("phoneSMSAnalysis", phoneSMSAnalysis());
        authInfo.put("phoneLocationAnalysis", phoneLocationAnalysis());

        return authInfo;
    }

    private static Object phoneLocationAnalysis() {
        List<JSONObject> list = new ArrayList<>();
        JSONObject one = new JSONObject();

        one.put("region", "1");// String 是 地区
        one.put("phoneNumber", "2");// int 是 号码数量
        one.put("callingNumber", "3");// int 是 主叫次数
        one.put("callingTime", "4");// int 是 主教时间
        one.put("calledNumber", "5");// int 是 被叫次数
        one.put("calledTime", "6");// int 是 被叫时间
        one.put("percentage", "7");// int 是 占比
        one.put("remark", "remark");
        list.add(one);
        return list;
    }

    private static Object phoneSMSAnalysis() {
        List<JSONObject> list = new ArrayList<>();
        JSONObject one = new JSONObject();

        one.put("notePhone", "1");// string 是 号码
        one.put("noteNumber", "2");// int 是 短信条数
        one.put("noteAddress", "3");// string 是 号码归属地
        one.put("remark", "remark");
        list.add(one);
        return list;
    }

    private static Object phoneConsumeAnalysis() {

        List<JSONObject> list = new ArrayList<>();
        JSONObject one = new JSONObject();
        one.put("month", "1");// Int 是 月份
        one.put("callingTime", "2");// Int 是 主叫时间
        one.put("calledTime", "3");// Int 是 被叫时间
        one.put("noteNumber", "4");// Int 是 短信数
        one.put("balance", "5");// Decimal 是 话费充值额
        one.put("remark", "remark");
        list.add(one);
        return list;
    }

    private static Object phoneRiskAnalysis() {
        JSONObject one = new JSONObject();
        one.put("court", "1");// 枚举<YN> 是 是否出现法院相关号码呼叫
        one.put("valid", "2");// 枚举<YN> 是 身份证号码有效性
        one.put("urgency", "3");// 枚举<YN> 是 是否联系过紧急联系人
        one.put("blackList", "4");// 枚举<YN> 是 申请人信息是否命中网贷黑名单
        one.put("shutdown", "5");// 枚举<YN> 是 是否出现长时间关机
        one.put("reality", "6");// 枚举<YN> 是 运营商是否实名
        one.put("accordance", "7");// 枚举<YN> 是 运营商实名是否与登记人一致
        one.put("remark", "remark");
        return one;
    }

    private static Object phoneWaitRecord() {
        List<JSONObject> list = new ArrayList<>();
        JSONObject one = new JSONObject();
        one.put("beginTime", "2017808080808");// DateTime 是 开始日期
        one.put("overTime", "2017808080808");// DateTime 是 结束日期
        one.put("countDay", "1");// int 是 天数
        one.put("remark", "remark");
        list.add(one);
        return list;
    }

    private static Object phoneCallRecord() {
        List<JSONObject> list = new ArrayList<>();
        JSONObject one = new JSONObject();
        one.put("callPhone", "1");// String 是 通话号码
        one.put("callTime", "2");// int 是 通话时长
        one.put("callNumber", "3");// int 是 通话次数
        one.put("calling", "4");// int 是 主叫
        one.put("called", "5");// int 是 被叫
        one.put("phoneAddress", "6");// String 是 号码归宿地
        one.put("remark", "remark");
        list.add(one);
        return list;
    }

    private static Object addOperatorInfo() {
        JSONObject one = new JSONObject();
        one.put("operator", "9");// 枚举< PhoneServiceProviders > 是 运营商类型
        // 0 移动
        // 1 联通
        // 2 电信
        // 3 虚拟
        one.put("netInTime", "19991010101010");// DateTime 是 入网时间
        one.put("autonym", "1");// String 是 实名认证
        one.put("phone", "2");// String 是 手机号码
        one.put("email", "3");// String 否 登记邮箱
        one.put("balance", "4");// Decimal 是 当前余额
        one.put("grade", "5");// Int 是 会员等级
        one.put("integral", "6");// Int 是 积分值
        one.put("netAge", "7");// Int 是 网龄
        one.put("beginCallTime", "19991010101010");// DateTime 是 最早通话时间
        one.put("latelyCallTime", "20111010101010");// DateTime 是 最近通话时间
        one.put("regAddress", "1");// String 是 登记地址
        one.put("remark", "remark");
        return one;
    }

    /**
     * 通信数据
     * 
     * @return
     */
    private static Object addCommInfo() {
        JSONObject one = new JSONObject();
        one.put("bcperson", "1");// String 是 被查询人
        one.put("phone", "2");// String 是 手机号码
        one.put("remark", "3");// String 是 结果备注
        one.put("submitLateTime", "19880210000000");// DateTime 是 提交时间
        one.put("updateLateTime", "19880210000000");// DateTime 是 更新时间
        one.put("remark", "remark");
        return one;
    }

    /**
     * 风险评估报告
     * 
     * @return
     */
    private static Object addRiskResult() {
        List<JSONObject> list = new ArrayList<>();
        JSONObject one = new JSONObject();

        one.put("assessGroup", "1");// String 是 评估组
        one.put("assessItem", "2"); // String 是 评估项
        one.put("assessRisk", "3"); // String 是 风险
        one.put("remark", "4"); // String 是 备注comment

        list.add(one);
        return list;
    }

    /**
     * 风险评估数据
     * 
     * @return
     */
    private static Object addRiskInfo() {
        JSONObject json = new JSONObject();

        json.put("name", "1");// 被查询人 name
        json.put("identity", "2");// 身份证 identity
        json.put("phone", "3");// 电话 phone
        json.put("certificateId", "4");// 授权书编号 certificate_id
        json.put("addTime", "20170810000000");// 建单时间 addtime
        json.put("submitTime", "20170810000000");// 最后提交时间 submittime
        json.put("updateTme", "20170810000000");// 最后更新时间 updatetime
        json.put("standardDate", "20170810000000");// 报告基准日 standard
        json.put("risk", "5");// 风险分 risk
        json.put("credit", "6");// 信用分 credit
        json.put("identitySite", "7");// 身份证归宿地 identitysite
        json.put("phoneSite", "8");// 手机号归属地 phonesite
        json.put("inspect", "9");// 个人基本信息核查 inspect
        json.put("remark", "10");// 备注 comment

        return json;
    }

    /**
     * 还款计划
     * 
     * @return
     */
    private static Object addRepaymentPlan() {
        List<JSONObject> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            JSONObject one = new JSONObject();
            one.put("period", i+1+"");// 期数
            one.put("repaymentDate",String.format( "201710%s000000", (i+1)<10?"0"+(i+1):i+1));// 是 应还日期
            one.put("repaymentPrincipal", "200");// 否 应还本金
            one.put("repaymentInterest", "100");// 否 应还利息
            one.put("repaymentCost", "0");// 应还费用
            one.put("repaymentTotal", "300");// 应还小计
            one.put("remark ", "1");// 备注
            list.add(one);
        }
        return list;
    }

    /**
     * 借款基础
     * 
     * @return
     */
    private static Object addLoanBase() {
        JSONObject loanInfo = new JSONObject();
        loanInfo.put("loanBaseId", new Random().nextInt());// 借款信息外部唯一指定ID
                                                           // gems_code

        loanInfo.put("borrowerId", "fb8c8939-ffb5-4f4b-b381-e079d6b2e171");// 借款人外部指定ID,必须先同步借款人,
        loanInfo.put("categoryId", "sh");// 外部分类ID(归属哪个部门或者门店,需事先同步),没有的情况下填0
                                         // 加盟店 gems_fs_id
        loanInfo.put("borrowerType", "0");// 外部借款人类型(为兼容不同类型的借款人有同样id),0:个人,1企业
        loanInfo.put("projectUuid", "PRJ0001");// 项目编号,由本平台提供 PRJ0001
        loanInfo.put("managerId", "1"); // 客户经理ID gems_id
        loanInfo.put("approvalAmount", "2000"); // 终审贷款金额 c_mgprice_result
        loanInfo.put("loanType", "0"); // 贷款类型。0:车贷
        loanInfo.put("approvalRate", "0.03");// 终审利率 q_lv
        loanInfo.put("isNeedCollateralAudit", "4");// 需要抵押品审核 1是
        loanInfo.put("loanInvest", "5");// 贷款投向。
        loanInfo.put("loanStatus", "1");// 贷款投向。
        loanInfo.put("loanPurpose", "6");// 贷款用途。

        loanInfo.put("loanTerm", "7");// 借款期数 periods
        loanInfo.put("applyDate", "19880210000000");// 申请日期 dt_edit
        loanInfo.put("applyLoanDuration", "8");// 申请借款时长 c_mgdays
        loanInfo.put("applyAmount", "2000");// 申请借款金额 c_mgprice
        loanInfo.put("guaranteeType", "9");// 担保方式。

        loanInfo.put("repaymentType", "10");// 还款方式。 c_mgtype

        loanInfo.put("interestCalculationCycle", "11");// 利息计算周期。0:日计息,1:月计息。
        loanInfo.put("repaymentCalculationType", "12");// 还款日期计算策略。0:每月固定日期。
        loanInfo.put("repaymentCycle", "13");// 还款周期
        loanInfo.put("repaymentDay", "14");// 还款日
        loanInfo.put("everyRepaymentAmount", "100");// 每期还款金额 mq_money
        loanInfo.put("firstRepaymentAmount", "99");// 首期还款金额 sq_money
        loanInfo.put("lastRepaymentAmount", "100");// 尾期还款金额 wq_money

        loanInfo.put("cycleDayCount", "15");// int 每周期天数
        loanInfo.put("interestStartDateType", "16");// 计息开始日期。0:发放贷款日期。
        loanInfo.put("isAvoidFestival", "17");// 还款计划避开节假日
        loanInfo.put("isAllowAdvanceRepayment", "18");// 允许提前还款

        loanInfo.put("repaymentBank", addBankInfo2());// 还款银行账户 Sig_bank
        loanInfo.put("repaymentPrincipal", "2000");// 应还本金 yhbj_money
        loanInfo.put("repaymentInterest", "1000");// 应还利息 yhlx_money
        loanInfo.put("repaymentCost", "0");// 应还费用
        loanInfo.put("repaymentTotal", "3000");// 应还总额 yhbj_money+ yhlx_money

        loanInfo.put("attachment", addAttachment(
                "借款信息附件"));/*
                            * 申请表 imgstep2_7 快加评估报告 imgstep2_8 保单（商业） imgstep2_9
                            * 共借人身份证正面 imgstep2_12 共借人身份证反面 imgstep2_13 合同1
                            * imgstep3_1 合同2 imgstep3_2 合同3 imgstep3_3 合同4
                            * imgstep3_4 合同5 imgstep3_5 合同6 imgstep3_6 合同7
                            * imgstep3_7 合同8 imgstep3_8 合同9 imgstep3_9 合同10
                            * imgstep3_10 合同11 imgstep3_11 合同12 imgstep3_12 合同13
                            * imgstep3_13 补充1 imgstep3_14 补充2 imgstep3_15 签约视频
                            * imgstep3_16 其他补充1 imgstep4_12 其他补充2 imgstep4_13
                            * 其他补充3 imgstep4_14
                            */

        loanInfo.put("coborrower", addCoborrower());// 共同借款人

        loanInfo.put("collateral", addCollateral());// 抵押物

        return loanInfo;
    }

    /**
     * 抵押物信息 复数
     * 
     * @return
     */
    private static Object addCollateral() {
        List<JSONObject> list = new ArrayList<>();
        JSONObject one = new JSONObject();

        one.put("name", "抵押物A");// 名称
        one.put("collateralType", "0");// 抵押物类型
        one.put("ownerName", "史学成");// 产权人姓名
        one.put("ownerIdcardNo", "31111");// 产权人身份证号
        one.put("newPrice", "25");// 新品价格
        one.put("invoiceNo", "231232");// 发票号码
        one.put("valuation", "2444");// 估值
        one.put("mortgageAmount", "1234");// 抵押金额
        one.put("attachment", addAttachment("抵押物附件"));// List<CommonAttachment>
                                                      // 否 见附件

        // 车辆铭牌 imgstep4_1
        // 车前45度 imgstep4_2
        // 车后45度 imgstep4_3
        // 发动机舱 imgstep4_4
        // 后备箱 imgstep4_5
        // 中控台 imgstep4_6
        // 仪表台公里数 imgstep4_7
        // 人车合影 imgstep4_8
        // 车辆补充1 imgstep4_9
        // 车辆补充2 imgstep4_10
        // 产权证1-2页 imgstep2_1
        // 产权证3-4页 imgstep2_2
        // 产权证5-6页 imgstep2_3

        one.put("carArchives", addCarArchives());// CarArchives 否 车辆档案
        one.put("carMaintain", addCarMaintain());// CarMaintain 否 车辆保养信息
        one.put("carMaintainRecord", addCarMaintainRecord());
        ;// List<CarMaintainRecord > 否 车辆保养记录
        one.put("carPeccancy", addCarPeccancy());// List<CarPeccancyRecord > 否
                                                 // 车辆违章
        one.put("remark", "");// 否 备注
        list.add(one);
        return list;
    }

    /**
     * 车辆违章记录 复数
     * 
     * @return
     */
    private static Object addCarPeccancy() {
        List<JSONObject> list = new ArrayList<>();
        JSONObject one = new JSONObject();
        one.put("peccancyTime", "1988021000000");// 违章时间
        one.put("peccancyAddress", "1");// 违章地点
        one.put("peccancyContent", "2");// 违章内容
        one.put("peccancyNo", "3");// 违章编号
        one.put("peccancyPrice", "4");// 罚款金额
        one.put("peccancyScore", "5");// 扣分
        one.put("remark", "6");// 备注

        list.add(one);
        return list;
    }

    /**
     * 车辆维修记录 复数
     * 
     * @return
     */
    private static Object addCarMaintainRecord() {
        List<JSONObject> list = new ArrayList<>();

        JSONObject one = new JSONObject();
        one.put("serviceLateTime", "1988021000000");// 时间
        one.put("serviceLateType", "1");// 类型
        one.put("kilometre", "2");// 公里数
        one.put("item", "3");// 项目
        one.put("materials", "4");// 材料
        one.put("remark", "5");// 备注

        list.add(one);
        return list;
    }

    /**
     * 车辆保养
     * 
     * @return
     */
    private static Object addCarMaintain() {
        JSONObject one = new JSONObject();
        one.put("submitTime", "19880210000000"); // 提交时间
        one.put("standardDate", "19880210000001"); // 报告基准日
        one.put("drivingimg", "1"); // 行驶证照片
        one.put("carModel", "2"); // 车型
        one.put("carSeries", "3"); // 车系
        one.put("vinNo", "4"); // VIN码
        one.put("generateTime", "19880210000005"); // 报告生成时间
        one.put("generateId", "6"); // 报告编号
        one.put("manufacturer", "7"); // 生产厂商
        one.put("productionDate", "19880210000006"); // 生产年份
        one.put("place", "9"); // 产地
        one.put("carType", "10"); // 车辆类型
        one.put("variableBox", "11"); // 变数箱类型
        one.put("displacement", "12"); // 排量
        one.put("fire", "13"); // 是否火烧
        one.put("water", "14"); // 是否水泡
        one.put("importance", "16"); // 重要组成部件是否有维修
        one.put("construction", "15"); // 结构件是否有维修
        one.put("normal", "17"); // 公里数是否正常
        one.put("kilometre", "18"); // 预估公里数
        one.put("upkeepLateTime", "19880210000000"); // 最后一次保养时间
        one.put("upkeepNumber", "19"); // 每年保养次数
        one.put("serviceLateTime", "19880210000000"); // 最后一次维修时间
        one.put("kilometreYear", "20"); // 每年行驶公数数
        one.put("remark", ""); // 备注
        return one;
    }

    /**
     * 车辆档案
     * 
     * @return
     */
    private static Object addCarArchives() {
        JSONObject one = new JSONObject();
        one.put("plateNumber", "1");// 车辆号码/牌照
        one.put("owner", "2");// 机动车所有人
        one.put("idcardNo", "3");// 身份证号码
        one.put("brandCn", "4");// 中文品牌
        one.put("vehicleModel", "5");// 车辆型号
        one.put("vehicleIdentificationCode", "6");// 车辆识别代号
        one.put("engineNumber", "7");// 发动机号
        one.put("useType", "8");// 使用性质。
        one.put("registrationAuthority", "9");// 登记机关
        one.put("carColor", "10");// 车身颜色
        one.put("passengerCount", "11");// 核定载客
        one.put("driverLicenseCode", "12");// 行驶证芯编码
        one.put("initialRegistrationDate", "19880210111111");// 初次登记日期
        one.put("registrationDate", "19880210111112");// 出厂登记日期
        one.put("scrapDate", "19880210111113");// 强制报废期止
        one.put("insuranceValidityDate", "19880210111114");// 保险有效期止
        one.put("verifyValidityDate", "19880210111115");// 校验有效期止
        one.put("isNewEnergy", "13");// 新能源汽车
        one.put("power", "14");// 排量功率
        one.put("carStatus", "15");// 机动车状态。
        one.put("accidentEscape", "16");// 事故逃逸
        one.put("vehicleDeck", "17");// 车辆套牌
        one.put("vehicleRobbery", "18");// 车辆盗抢
        one.put("mortgageSign", "19");// 抵押标记
        one.put("mortgageTime", "19880210111116");// 抵押时间
        one.put("mortgageHolder", "20");// 抵押权人
        one.put("reportDate", "19880210111117");// 报告基准日
        one.put("historyMortgage", "21");// 历史抵押
        one.put("submitTime", "19880210111118");// 历史抵押
        return one;
    }

    /**
     * 共借人信息 复数
     * 
     * @return
     */
    private static Object addCoborrower() {
        List<JSONObject> list = new ArrayList<>();
        JSONObject a = new JSONObject();
        a.put("name", "1");
        ;//
        a.put("certificateNo", "2");
        ;// String 是 证件号码 ct_cardno
        a.put("phone", "3");
        ;// String 是 电话
        a.put("remark", "4");
        ;// String 否
        a.put("certificateType", "5");
        list.add(a);
        return list;
    }

    /**
     * 银行,单个
     * 
     * @return
     */
    private static Object addBankInfo2() {
        JSONObject oneBank = new JSONObject();
        oneBank.put("bankName", "华夏银行");// 银行名称 bank
        oneBank.put("bankBranchName", "支行");// String 分行/开户行名称 name
        oneBank.put("accountNo", "abc");// String 银行账号 cardunm
        return oneBank;
    }

    // 附件
    private static Object addAttachment(String a) {
        List<JSONObject> attachment = new ArrayList<>();
        JSONObject xxz = new JSONObject();
        attachment.add(xxz);
        xxz.put("fileName", a);
        xxz.put("fileUrl", "2");
        xxz.put("fileType", "1");
        xxz.put("fileString", "2");
        xxz.put("remark", "3");
        return attachment;
    }

    static ExecutorService cachedThreadPool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws Exception {
       // core();
      //  cachedThreadPool.shutdown();
      System.out.println(addLoanInfo()); // addLoanInfo();
    }

}
