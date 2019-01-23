package com.controller.duoying;
// 4.3 

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.http.duoying.syncjkrxxHttp;
import com.mashape.unirest.http.JsonNode;
import com.model1.archives;
import com.model1.bank;
import com.model1.bx;
import com.model1.carmodel;
import com.model1.fsdy;
import com.model1.mgcert;
import com.model1.thjl;
import com.model1.yhkls;
import com.model1.ylds;
import com.model1.ylqy;
import com.service1.duoying.fsdyService;
import com.service1.duoying.archivesService;
import com.service1.duoying.bankService;
import com.service1.duoying.bxService;
import com.service1.duoying.carmodelService;
import com.service1.duoying.mgcertService;
import com.service1.duoying.thjlService;
import com.service1.duoying.yhklsService;
import com.service1.duoying.yldsService;
import com.service1.duoying.ylqyService;
import com.service1.duoying.zxService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
public class addLoanInfoController{
	
	
	@Autowired
	private mgcertService mgcertService;
	
	@Autowired
	private bankService bankService;
	
	@Autowired
	private ylqyService ylqyService;
	
	@Autowired
	private carmodelService carmodelService;
	
	@Autowired
	private yldsService yldsService;
	
	@Autowired
	private bxService bxService;
	
	@Autowired
	private archivesService archivesService;
	
	@Autowired
	private fsdyService fsdyService;
	
	@Autowired
	private thjlService thjlService;
	
	@Autowired
	private zxService zxService;
	
	@Autowired
	private yhklsService yhklsService;
	
	
	

    /**
     * 以post方式访问
     * 
     * @param url
     *            接口url地址
     * @param xmlBody
     *            xml格式的字符串
     * @return
     */


    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCU41GfwgaxN4b5HjL5BcbTPbkBTjhqalo45yXSUaz1jI29Wg1kvG7SEsBJvNGbPJrD5O/0G9nYddaqUo72jcFyiCtMycIvWdFes62Tc/ulezYD6Wyo5lsVPkGmNg/QitwVpcrKFam/GEiErduae9pwfB8zhyfrCA3iiSPVCGP7ywIDAQAB";

    private static String privatekey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJTjUZ/CBrE3hvkeMvkFxtM9uQFOOGpqWjjnJdJRrPWMjb1aDWS8btISwEm80Zs8msPk7/Qb2dh11qpSjvaNwXKIK0zJwi9Z0V6zrZNz+6V7NgPpbKjmWxU+QaY2D9CK3BWlysoVqb8YSISt25p72nB8HzOHJ+sIDeKJI9UIY/vLAgMBAAECgYEAim5IyCdYnZEpN5qyfgK2+FVdHC+kGJ1Fwb541fIGxE+owbNm3JCu4Td5/ZVHtfRFWXoU+HyksbPuoXIdZnQqtWuInNhdPVpiir6/yXSvP5LLfQN6lqkCzapgtuhuz3Cayp58qb0k4ujZ2l5pegNN7a8plqHUSZNoE3VFHMNNTZECQQDYyRm7U+gliPlnO8bpnnU6ciFbiAeXbWS4z+HY2hLHWqFO7U2grBKueJ1yMYDNL8PCGbbyO0bUxDIu07t5KYg1AkEAr9IEzgIYwbCBujRgJ3rj7r5bXsggzTiHLypj+Uvsq0niI2TvHmiYczP0m9lSHmuvZwhcdhd0bufA81Zigi/z/wJBAIcVAGC3Dw/cgzQtjmviXj/WAC0t3TUhaEK03pEmic8JDTzGJ7n3nwhyhgEzEYRJwByBs3rLLv7DZlXBf68nDwUCQHe4mND2mIj7ebqjg34eriqZsHn/6GYVweeaA+1zh7qzWqsjRbf9HSIFFOEywDo6tXuBNAStv/jtEnQgNH/Vy10CQBzWF7XlU9oXiLwoVoe+7JAe7cnfAfG+2nwiuzc0x9oHB1p7rET3u0AMIR6LfC0K2FWheQRYcqsAWyQviIjWa8I=";

    private static JSONObject createHead() {
        JSONObject obj = new JSONObject();
        obj.put("ver", "1.0");// 版本
        obj.put("curTime", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        obj.put("nonce", new Random().nextInt(10000));// 一个随机数
      //obj.put("sign", MD5.sign(privatekey + obj.getString("nonce") + obj.getString("curTime"), "UTF-8"));// 签名
        obj.put("signType", "MD5");// 签名类型
        obj.put("appKey", "KCD");// 多盈提供的APPKEY
        return obj;
    }

   
  /**
   * 4.3	添加借款信息         接口说明同步借款人的借款信息
   * @return
   * @throws ParseException
   */

    
    @RequestMapping(value="loaninfo.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String loaninfo()throws ParseException{
		
    	SimpleDateFormat dftime = new SimpleDateFormat("yyyy-MM-dd"); // 日期格式
    	List<Map<String,Object>> maplist=new ArrayList<Map<String,Object>>();
    	List<Map<String,Object>> json=new ArrayList<Map<String,Object>>();
    	Map<String,Object> map=new HashMap<String,Object>();
    	Map<String,Object> hkmap=new HashMap<String,Object>();
    	
    	
    	List<archives> archives = new ArrayList<archives>();    	
    	List<bank> bank = new ArrayList<bank>();
    	List<bx> bx = new ArrayList<bx>();
    	List<carmodel> carmodel = new ArrayList<carmodel>();
    	List<fsdy> fsdy = new ArrayList<fsdy>();	
    	List<thjl> thjl = new ArrayList<thjl>();	
     	List<yhkls> yhkls = new ArrayList<yhkls>();
    	List<ylds> ylds = new ArrayList<ylds>();
     	List<ylqy> ylqy = new ArrayList<ylqy>();
  
    	
    	List<mgcert> mgcert = new ArrayList<mgcert>();
    	mgcert = mgcertService.findmgcertlist();
    	mgcert mg = new mgcert();
    	for(int i=0;i<mgcert.size();i++){
    		mg = mgcert.get(i);
            Map<String,Object> json1=new HashMap<String,Object>();
            json1.put("name", mg.getC_name());// 被查询人 name
            json1.put("identity", mg.getC_cardno());// 身份证 identity
            json1.put("certificateId", "");// 授权书编号 certificate_id
            json1.put("addTime", mg.getDt_add());// 建单时间 addtime
            json1.put("submitTime", mg.getDt_edit());// 最后提交时间 submittime
            json1.put("updateTme", mg.getDt_edit());// 最后更新时间 updatetime
            json1.put("standardDate", "");// 报告基准日 standard
            json1.put("risk", "");// 风险分 risk
            json1.put("credit", mg.getScore());// 信用分 credit
            json1.put("identitySite", "");// 身份证归宿地 identitysite
            json1.put("phoneSite", "");// 手机号归属地 phonesite
            json1.put("inspect", "");// 个人基本信息核查 inspect
            json1.put("remark", "");// 备注 comment
            System.out.println("json1"+json1);
            Map<String,Object> loanInfo1=new HashMap<String,Object>();
            loanInfo1.put("loanBaseId", mg.getGems_code());// 借款信息外部唯一指定ID
                                                               // gems_code
            loanInfo1.put("borrowerId", "fb8c8939-ffb5-4f4b-b381-e079d6b2e171");// 借款人外部指定ID,必须先同步借款人,
            loanInfo1.put("categoryId", mg.getGems_fs_id());// 外部分类ID(归属哪个部门或者门店,需事先同步),没有的情况下填0
                                             // 加盟店 gems_fs_id
            loanInfo1.put("borrowerType", "0");// 外部借款人类型(为兼容不同类型的借款人有同样id),0:个人,1企业
            loanInfo1.put("projectUuid", "PRJ0001");// 项目编号,由本平台提供 PRJ0001
            loanInfo1.put("managerId", mg.getGems_id()); // 客户经理ID gems_id
            loanInfo1.put("approvalAmount", mg.getC_mgprice_result()); // 终审贷款金额 c_mgprice_result
            loanInfo1.put("loanType", "0"); // 贷款类型。0:车贷
            loanInfo1.put("approvalRate", mg.getQ_lv());// 终审利率 q_lv
            loanInfo1.put("isNeedCollateralAudit","");//需要抵押品审核 1是
            loanInfo1.put("loanInvest", "");// 贷款投向。
            loanInfo1.put("loanStatus", "");// 贷款投向。
            loanInfo1.put("loanPurpose", "");// 贷款用途。
            loanInfo1.put("loanTerm", mg.getC_mgdays());// 借款期数 periods
            loanInfo1.put("applyDate", mg.getDt_add());// 申请日期 dt_edit
            loanInfo1.put("applyLoanDuration", mg.getC_mgdays());// 申请借款时长 c_mgdays
            loanInfo1.put("applyAmount", mg.getC_mgprice());// 申请借款金额 c_mgprice
            loanInfo1.put("guaranteeType", "");// 担保方式。
            loanInfo1.put("repaymentType", mg.getC_mgtype());// 还款方式。 c_mgtype
            System.out.println("loanInfo1"+loanInfo1);
            Map<String,Object> dyw=new HashMap<String,Object>();
            dyw.put("name", "抵押物A");// 名称
            dyw.put("collateralType", "0");// 抵押物类型
            dyw.put("ownerName", mg.getC_name());// 产权人姓名
            dyw.put("ownerIdcardNo", mg.getC_cardno());// 产权人身份证号
            dyw.put("newPrice", "25");// 新品价格
            dyw.put("invoiceNo", "");// 发票号码
            dyw.put("valuation", "");// 估值
            dyw.put("mortgageAmount", "");// 抵押金额
            System.out.println("dyw"+dyw);
            Map<String,Object> attachment = new HashMap<String,Object>();
            
            attachment.put("imgstep4_1", mg.getImgstep4_1());//车辆铭牌
            attachment.put("imgstep4_2", mg.getImgstep4_2());//车前45度
            attachment.put("imgstep4_3", mg.getImgstep4_3());//车后45度
            attachment.put("imgstep4_4", mg.getImgstep4_4());//发动机舱 
            attachment.put("imgstep4_5", mg.getImgstep4_5());//后备箱
            attachment.put("imgstep4_6", mg.getImgstep4_6());//中控台
            attachment.put("imgstep4_7", mg.getImgstep4_7());//仪表台公里数
            attachment.put("imgstep4_8", mg.getImgstep4_8());//人车合影
            attachment.put("imgstep4_9", mg.getImgstep4_9());//车辆补充1
            attachment.put("imgstep4_10",mg.getImgstep4_10());//车辆补充2
            attachment.put("imgstep2_1", mg.getImgstep2_1());//产权证1-2页
            attachment.put("imgstep2_2", mg.getImgstep2_2());//产权证3-4页
            attachment.put("imgstep2_3", mg.getImgstep2_3());//产权证5-6页
            System.out.println("attachment"+attachment);
            
            
            String ACCOUNT_NAME = "";
			ACCOUNT_NAME = mg.getC_name().toString();
			System.out.println(ACCOUNT_NAME);
			ylqy = ylqyService.findylqybyname(ACCOUNT_NAME);
			ylqy y = new ylqy();
			for(int j =0;j<ylqy.size();j++){
			Map<String,Object> json2=new HashMap<String,Object>();
    			y = ylqy.get(j);
            json2.put("phone", y.getTEL());// 电话 phone
            hkmap.put("repaymentBank", y.getACCOUNT_NO());// 还款银行账户 Sig_bank
            json.add(json2);
            json.add(json1);
            System.out.println("json:"+json);
			}
    	
    
    	String c_name ="";
    	c_name = mg.getC_name().toString();
    	System.out.println(c_name);
    	thjl = thjlService.findthjlbyc_name(c_name);
    	thjl t = new thjl();
    	for(int a = 0;a<thjl.size();a++){
    	Map<String,Object> thjlmap=new HashMap<String,Object>();
            t = thjl.get(a);
        thjlmap.put("bcperson", t.getC_name());// String 是 被查询人
        thjlmap.put("phone", t.getC_tel());// String 是 手机号码
        thjlmap.put("remark", t.getApi_note());// String 是 结果备注
        thjlmap.put("submitLateTime", t.getDt_add());// DateTime 是 提交时间
        thjlmap.put("updateLateTime", t.getDt_edit());// DateTime 是 更新时间
        thjlmap.put("remark", "");//备注
    	
        
        

       
        
    	Map<String,Object> loanInfo2=new HashMap<String,Object>();
        
        Map<String,Object> attachment2 = new HashMap<String,Object>();
        attachment2.put("imgstep2_7", mg.getImgstep2_7());
        attachment2.put("imgstep2_8", mg.getImgstep2_8());
        attachment2.put("imgstep2_9", mg.getImgstep2_9());
        attachment2.put("imgstep2_12", mg.getImgstep2_12());
        attachment2.put("imgstep2_13", mg.getImgstep2_13());
        attachment2.put("imgstep3_1", mg.getImgstep3_1());
        attachment2.put("imgstep3_2", mg.getImgstep3_2());
        attachment2.put("imgstep3_3", mg.getImgstep3_3());
        attachment2.put("imgstep3_4", mg.getImgstep3_4());
        attachment2.put("imgstep3_5", mg.getImgstep3_5());
        attachment2.put("imgstep3_6", mg.getImgstep3_6());
        attachment2.put("imgstep3_7", mg.getImgstep3_7());
        attachment2.put("imgstep3_8", mg.getImgstep3_8());
        attachment2.put("imgstep3_9", mg.getImgstep3_9());
        attachment2.put("imgstep3_10", mg.getImgstep3_10());
        attachment2.put("imgstep3_11", mg.getImgstep3_11());
        attachment2.put("imgstep3_12", mg.getImgstep3_12());
        attachment2.put("imgstep3_13", mg.getImgstep3_13());
        attachment2.put("imgstep3_14", mg.getImgstep3_14());
        attachment2.put("imgstep3_15", mg.getImgstep3_15());
        attachment2.put("imgstep3_16", mg.getImgstep3_16());
        attachment2.put("imgstep4_12", mg.getImgstep4_12());
        attachment2.put("imgstep4_13", mg.getImgstep4_13());
        attachment2.put("imgstep4_14", mg.getImgstep4_14());
        
        loanInfo2.put("attachment", attachment2);/*
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

        loanInfo2.put("coborrower", a);// 共同借款人

        loanInfo2.put("collateral", "");// 抵押物

        
      
        
       
    	//车辆保养
        String c_carno = "";
        c_carno = mg.getC_carno().toString();
		System.out.println(c_carno);
		archives = archivesService.findarchivesbyc_name(c_carno);
		archives arc = new archives();
		for(int j =0;j<archives.size();j++){
			arc = archives.get(j);
        
	    Map<String,Object> clby=new HashMap<String,Object>();
        clby.put("submitTime", arc.getDt_add()); // 提交时间
        clby.put("standardDate", arc.getDt_fin()); // 报告基准日
        clby.put("drivingimg", "1"); // 行驶证照片
        clby.put("carModel", arc.getR_item4()); // 车型
        clby.put("carSeries", arc.getR_item5()); // 车系
        clby.put("vinNo", arc.getR_item6()); // VIN码
        clby.put("generateTime", arc.getDt_edit()); // 报告生成时间
        clby.put("generateId", arc.getGems_code()); // 报告编号
        clby.put("manufacturer", ""); // 生产厂商
        clby.put("productionDate", arc.getR_item14()); // 生产年份
        clby.put("imgurl", arc.getImgurl()); // 
        clby.put("result_imgurl1", arc.getResult_imgurl1()); // 
        clby.put("result_imgurl2", arc.getResult_imgurl2()); // 
        clby.put("result_imgurl3", arc.getResult_imgurl3()); //
        clby.put("result_imgurl4", arc.getResult_imgurl4()); //
        clby.put("result_imgurl5", arc.getResult_imgurl5()); //
        clby.put("result_imgurl6", arc.getResult_imgurl6()); //
        clby.put("place", ""); // 产地
        clby.put("carType", ""); // 车辆类型
        clby.put("variableBox", ""); // 变数箱类型
        clby.put("displacement", ""); // 排量
        clby.put("fire", ""); // 是否火烧
        clby.put("water", ""); // 是否水泡
        clby.put("importance", ""); // 重要组成部件是否有维修
        clby.put("construction", ""); // 结构件是否有维修
        clby.put("normal", ""); // 公里数是否正常
        clby.put("kilometre", ""); // 预估公里数
        clby.put("upkeepLateTime", ""); // 最后一次保养时间
        clby.put("upkeepNumber", ""); // 每年保养次数
        clby.put("serviceLateTime", ""); // 最后一次维修时间
        clby.put("kilometreYear", ""); // 每年行驶公数数
        clby.put("remark", ""); // 备注
        System.out.println("clby"+clby);
             //车辆档案
      		  Map<String,Object> clda=new HashMap<String,Object>();
              clda.put("plateNumber", arc.getR_item1());// 车辆号码/牌照
              clda.put("owner", arc.getR_item2());// 机动车所有人
              clda.put("idcardNo", arc.getR_item3());// 身份证号码
              clda.put("brandCn", arc.getR_item4());// 中文品牌
              clda.put("vehicleModel", arc.getR_item5());// 车辆型号
              clda.put("vehicleIdentificationCode", arc.getR_item6());// 车辆识别代号
              clda.put("engineNumber", arc.getR_item7());// 发动机号
              clda.put("useType", arc.getR_item8());// 使用性质。
              clda.put("registrationAuthority", arc.getR_item9());// 登记机关
              clda.put("carColor", arc.getR_item10());// 车身颜色
              clda.put("passengerCount", arc.getR_item11());// 核定载客
              clda.put("driverLicenseCode", arc.getR_item12());// 行驶证芯编码
              clda.put("initialRegistrationDate", arc.getR_item13());// 初次登记日期
              clda.put("registrationDate", arc.getR_item14());// 出厂登记日期
              clda.put("scrapDate", arc.getR_item15());// 强制报废期止
              clda.put("insuranceValidityDate", arc.getR_item16());// 保险有效期止
              clda.put("verifyValidityDate", arc.getR_item18());// 校验有效期止
              clda.put("isNewEnergy", arc.getR_item17());// 新能源汽车
              clda.put("power", arc.getR_item19());// 排量功率
              clda.put("carStatus", arc.getR2_item1());// 机动车状态。
              clda.put("accidentEscape", arc.getR2_item2());// 事故逃逸
              clda.put("vehicleDeck", arc.getR2_item3());// 车辆套牌
              clda.put("vehicleRobbery", arc.getR2_item4());// 车辆盗抢
              clda.put("mortgageSign", arc.getR2_item5());// 抵押标记
              clda.put("mortgageTime", arc.getR2_item6());// 抵押时间
              clda.put("mortgageHolder", arc.getR2_item7());// 抵押权人
              clda.put("reportDate", arc.getDt_fin());// 报告基准日
              clda.put("historyMortgage", arc.getR2_item8());// 历史抵押
              clda.put("submitTime", "");// 历史抵押
              System.out.println("clda"+clda);
              
            map.put("clda", clda);
  	        map.put("clby", clby);
		}
		 map.put("thjlmap", thjlmap);
		 map.put("loanInfo2", loanInfo2);
		}
    	
        
    	
    	//String c_name ="";
    	c_name=mg.getC_name().toString();
		
		List<JSONObject> list = new ArrayList<>();
		Map<String,Object> map2=new HashMap<String,Object>();
		List<Map<String,Object>> maplist2=new ArrayList<Map<String,Object>>();
		thjl = thjlService.findthjlbyc_name(c_name);
		thjl th = new thjl();
		for(int v= 0;v<thjl.size();v++){
			th = thjl.get(v);
		Map<String,Object> thmap=new HashMap<String,Object>();
		thmap.put("id", th.getId());
		thmap.put("mid_add", th.getMid_add());
		thmap.put("mid_edit", th.getMid_edit());
		thmap.put("dt_add", th.getDt_add());
		thmap.put("dt_edit", th.getDt_edit());
		thmap.put("bc_status", th.getBc_status());
		thmap.put("quert_type", th.getQuery_type());
		thmap.put("gems_id", th.getGems_id());
		thmap.put("gems_fs_id", th.getGems_fs_id());
		thmap.put("c_name", th.getC_name());
		thmap.put("c_tel", th.getC_tel());
		thmap.put("c_cardno", th.getC_cardno());
		thmap.put("gems_code", th.getGems_code());
		thmap.put("api_status", th.getApi_status());
		thmap.put("api_token", th.getApi_token());
		//thmap.put("api_note", th.getApi_note());
		maplist2.add(thmap);
        System.out.println(th.getApi_note());
		
		}
		
		
		//通话记录***************************

		String jsonStr = "";
		jsonStr = th.getApi_note();
		System.out.println("jsonStr"+jsonStr);
		Map<Object, Object> result = jsonToMap(jsonStr);
		//第一层数据
		System.out.println("编号"+result.get("_id"));
		System.out.println(result.get("basicInfo"));//
		System.out.println(result.get("callRecordsInfo"));//
		System.out.println(result.get("consumeInfo"));
		System.out.println(result.get("contactAreaInfo"));
		System.out.println(result.get("deceitRisk"));
		System.out.println(result.get("messageRecordsInfo"));
		System.out.println(result.get("phoneInfo"));
		System.out.println(result.get("phoneOffInfos"));
		System.out.println("手机号码："+result.get("phone_no"));
		System.out.println(result.get("specialCallInfo"));
		System.out.println("token"+result.get("token"));
		
		//第二层数据toArrayList
		
        Map<Object, Object> id = jsonToMap(result.get("_id"));//
		System.out.println(id.get("$oid"));
		

		
		
		
		
		Map<Object,Object> basicInfo = jsonToMap(result.get("basicInfo"));//基本信息
		System.out.println(basicInfo.get("age"));//年龄
		System.out.println(basicInfo.get("birthArea"));//出生日期
		System.out.println(basicInfo.get("birthday"));//出生地
		System.out.println(basicInfo.get("certNo"));//身份证号码
		System.out.println(basicInfo.get("phoneBelongArea"));//手机号归属地
		System.out.println("电话号码："+basicInfo.get("phoneNo"));//登记手机号
		System.out.println(basicInfo.get("reportID"));//报告编号
		System.out.println(basicInfo.get("reportTime"));//报告时间
		System.out.println(basicInfo.get("sex"));//年龄
		
		Map<Object,Object> phoneInfo = jsonToMap(result.get("phoneInfo"));//运营商基本信息
		System.out.println(phoneInfo.get("addr"));//登记地址
		System.out.println(phoneInfo.get("balance"));//当前余额
		System.out.println(phoneInfo.get("certNo"));//认证省份证号
		System.out.println(phoneInfo.get("email"));//登记邮箱
		System.out.println(phoneInfo.get("firstCallDate"));//最早通话时间
		System.out.println(phoneInfo.get("inNetDate"));//入网时间
		System.out.println(phoneInfo.get("lastCallDate"));//最近通话时间
		System.out.println(phoneInfo.get("netAge"));//网龄
		System.out.println(phoneInfo.get("operator"));//运营商类型
		System.out.println(phoneInfo.get("phoneNo"));//手机号
		System.out.println(phoneInfo.get("pointValue"));//积分值
		System.out.println(phoneInfo.get("realName"));//认证实名
		System.out.println(phoneInfo.get("vipLevel"));//会员等级
		JSONObject one6 = new JSONObject();
	        one6.put("operator", phoneInfo.get("operator"));// 枚举< PhoneServiceProviders > 是 运营商类型
	        // 0 移动
	        // 1 联通
	        // 2 电信
	        // 3 虚拟
	        one6.put("netInTime", phoneInfo.get("inNetDate"));// DateTime 是 入网时间
	        one6.put("autonym", phoneInfo.get("realName"));// String 是 实名认证
	        one6.put("phone", phoneInfo.get("phoneNo"));// String 是 手机号码
	        one6.put("email", phoneInfo.get("email"));// String 否 登记邮箱
	        one6.put("balance", phoneInfo.get("balance"));// Decimal 是 当前余额
	        one6.put("grade", phoneInfo.get("vipLevel"));// Int 是 会员等级
	        one6.put("integral", phoneInfo.get("pointValue"));// Int 是 积分值
	        one6.put("netAge", phoneInfo.get("netAge"));// Int 是 网龄
	        one6.put("beginCallTime", phoneInfo.get("firstCallDate"));// DateTime 是 最早通话时间
	        one6.put("latelyCallTime", phoneInfo.get("lastCallDate"));// DateTime 是 最近通话时间
	        one6.put("regAddress", phoneInfo.get("addr"));// String 是 登记地址
	        one6.put("remark", "remark");
		   list.add(one6);
	        
	        
		Map<Object, Object> deceitRisk = jsonToMap(result.get("deceitRisk"));
		System.out.println(deceitRisk.get("calledByCourtNo"));//是否出现法院相关号码呼叫
		System.out.println(deceitRisk.get("certNoIsValid"));//身份证号码有效性
		System.out.println(deceitRisk.get("emergency_contacted"));//是否联系过紧急联系人
		System.out.println(deceitRisk.get("inBlacklist"));//申请人信息是否命中网贷黑名单
		System.out.println(deceitRisk.get("longTimePowerOff"));//是否出现过长时间关机
		System.out.println(deceitRisk.get("phoneIsAuth"));//运营商是否实名
		System.out.println(deceitRisk.get("samePeople"));//运营商实名是否与登记人一致
		JSONObject one3 = new JSONObject();
	        one3.put("court", deceitRisk.get("calledByCourtNo"));// 枚举<YN> 是 是否出现法院相关号码呼叫
	        one3.put("valid", deceitRisk.get("certNoIsValid"));// 枚举<YN> 是 身份证号码有效性
	        one3.put("urgency", deceitRisk.get("emergency_contacted"));// 枚举<YN> 是 是否联系过紧急联系人
	        one3.put("blackList", deceitRisk.get("inBlacklist"));// 枚举<YN> 是 申请人信息是否命中网贷黑名单
	        one3.put("shutdown", deceitRisk.get("longTimePowerOff"));// 枚举<YN> 是 是否出现长时间关机
	        one3.put("reality", deceitRisk.get("phoneIsAuth"));// 枚举<YN> 是 运营商是否实名
	        one3.put("accordance", deceitRisk.get("samePeople"));// 枚举<YN> 是 运营商实名是否与登记人一致
	        one3.put("remark", "remark");
	        map.put("phoneRiskAnalysis", one3);
		   // list.add(one3);
		
		List<Map<Object, Object>> callRecordsInfo = toList(result.get("callRecordsInfo"));//通话记录分析
		for(int a=0;a<callRecordsInfo.size();a++){
	    Map<Object, Object> call=new HashMap<Object,Object>();
	    call= callRecordsInfo.get(a);
	    System.out.println(call.get("belongArea"));//号码归属地
		System.out.println(call.get("callTimes"));//主叫次数
		System.out.println(call.get("calledTimes"));//被叫次数
		System.out.println(call.get("connTime"));//通话时长
		System.out.println(call.get("connTimes"));//通话次数
		System.out.println(call.get("identifyInfo"));//号码标识
		System.out.println("号码："+call.get("phoneNo"));//号码
		JSONObject one5 = new JSONObject();
        one5.put("callPhone", call.get("phoneNo"));// String 是 通话号码
        one5.put("callTime", call.get("connTime"));// int 是 通话时长
        one5.put("callNumber", call.get("connTimes"));// int 是 通话次数
        one5.put("calling", call.get("callTimes"));// int 是 主叫
        one5.put("called", call.get("calledTimes"));// int 是 被叫
        one5.put("phoneAddress", call.get("belongArea"));// String 是 号码归宿地
        one5.put("remark", "remark");
        list.add(one5);
		}
		

		List<Map<Object, Object>> consumeInfo = toList(result.get("consumeInfo"));//运营商消费分析
		for(int b=0;b<consumeInfo.size();b++){
	    Map<Object, Object> consume=new HashMap<Object,Object>();
	    consume= consumeInfo.get(b);
	    System.out.println(consume.get("callTime"));//主叫时间
		System.out.println(consume.get("calledTime"));//被叫时间
		System.out.println(consume.get("month"));//月份
		System.out.println(consume.get("payMoney"));//话费充值额
		System.out.println(consume.get("totalSmsNumber"));//短信数
		JSONObject one2 = new JSONObject();
        one2.put("month", consume.get("month"));// Int 是 月份
        one2.put("callingTime", consume.get("callTime"));// Int 是 主叫时间
        one2.put("calledTime", consume.get("calledTime"));// Int 是 被叫时间
        one2.put("noteNumber", consume.get("totalSmsNumber"));// Int 是 短信数
        one2.put("balance", consume.get("payMoney"));// Decimal 是 话费充值额
        one2.put("remark", "remark");
        //list.add(one2);
        map2.put("phoneConsumeAnalysis",one2);
		}
		
		
		List<Map<Object, Object>> contactAreaInfo = toList(result.get("contactAreaInfo"));//联系人位置分析
		for(int c=0;c<contactAreaInfo.size();c++){
	    Map<Object, Object> contact=new HashMap<Object,Object>();
	    contact= contactAreaInfo.get(c);
	    System.out.println(contact.get("area"));//地区
		System.out.println(contact.get("callTime"));//主叫时间
		System.out.println(contact.get("callTimes"));//主叫次数
		System.out.println(contact.get("calledTime"));//被叫时间
		System.out.println(contact.get("calledTimes"));//被叫次数
		System.out.println(contact.get("percent"));//占比
		System.out.println(contact.get("totalNumber"));//号码数量
		
		
        JSONObject one = new JSONObject();
        one.put("region", contact.get("area"));// String 是 地区
        one.put("phoneNumber", contact.get("totalNumber"));// int 是 号码数量
        one.put("callingNumber", contact.get("callTimes"));// int 是 主叫次数
        one.put("callingTime", contact.get("callTime"));// int 是 主教时间
        one.put("calledNumber", contact.get("calledTimes"));// int 是 被叫次数
        one.put("calledTime", contact.get("calledTime"));// int 是 被叫时间
        one.put("percentage", contact.get("percent"));// int 是 占比
        one.put("remark", "remark");
     //   list.add(one);
        map2.put("phoneLocationAnalysis",one);
		}
		
		List<Map<Object, Object>> messageRecordsInfo = toList(result.get("messageRecordsInfo"));//短信记录分析
		for(int d=0;d<messageRecordsInfo.size();d++){
	    Map<Object, Object> message=new HashMap<Object,Object>();
	    message= messageRecordsInfo.get(d);
	    System.out.println(message.get("belongArea"));//号码归属地
		System.out.println(message.get("identifyInfo"));//号码标识
		System.out.println(message.get("phoneNo"));//号码
		System.out.println(message.get("totalSmsNumber"));//条数
		
		
	        JSONObject one1 = new JSONObject();
	        one1.put("notePhone", message.get("phoneNo"));// string 是 号码
	        one1.put("noteNumber", message.get("totalSmsNumber"));// int 是 短信条数
	        one1.put("noteAddress", message.get("belongArea"));// string 是 号码归属地
	        one1.put("remark", "remark");
	      //  list.add(one1)
	        map2.put("phoneSMSAnalysis",one1);
		}
		
		List<Map<Object, Object>> phoneOffInfos = toList(result.get("phoneOffInfos"));//关机详情
		for(int e=0;e<phoneOffInfos.size();e++){
	    Map<Object, Object> phoneOff=new HashMap<Object,Object>();
	    phoneOff= phoneOffInfos.get(e);
	    System.out.println(phoneOff.get("beginDate"));//关机开始日期
		System.out.println(phoneOff.get("days"));//关机天数
		System.out.println(phoneOff.get("endDate"));//关机结束日期
		JSONObject one4 = new JSONObject();
        one4.put("beginTime", phoneOff.get("beginDate"));// DateTime 是 开始日期
        one4.put("overTime",phoneOff.get("endDate") );// DateTime 是 结束日期
        one4.put("countDay", phoneOff.get("days"));// int 是 天数
        one4.put("remark", "remark");
        list.add(one4);
		
		
		}
		
		
		List<Map<Object, Object>> specialCallInfo = toList(result.get("specialCallInfo"));//通话短信需求分析
		for(int f=0;f<specialCallInfo.size();f++){
	    Map<Object, Object> special=new HashMap<Object,Object>();
	    special= specialCallInfo.get(f);
	    System.out.println(special.get("connTimes"));//通话次数
		System.out.println(special.get("identityInfo"));//对方标识
		System.out.println(special.get("month"));//月份
		System.out.println(special.get("phoneNo"));//对方号码
		System.out.println(special.get("smsTimes"));//短信条数
		
		}
		
		//还款计划***************************
		
		
		List<Map<String,Object>> hklist=new ArrayList<Map<String,Object>>();
		for(int k =0;k<mgcert.size();k++){
			
			mg = mgcert.get(k);
			hkmap.put("编号：", mg.getGems_code());
			int qs = mg.getC_mgdays()/30;
			hkmap.put("期数", qs);
			int a = mg.getC_mgtype();
			
			
			
			hkmap.put("interestCalculationCycle", 1);// 利息计算周期。0:日计息,1:月计息。
			hkmap.put("repaymentCalculationType", 0);// 还款日期计算策略。0:每月固定日期。
			hkmap.put("repaymentCycle", qs);// 还款周期
			hkmap.put("repaymentDay",mg.getDt_fk().toString()+30);// 还款日
			
			hkmap.put("cycleDayCount", 30);// int 每周期天数
			Date date = dftime.parse(mg.getDt_fk()); // 指定日期
			Date newDate = addDate(date, 0); // 指定日期加上20天 
			hkmap.put("interestStartDateType", dftime.format(newDate));// 计息开始日期。0:发放贷款日期。
			hkmap.put("isAvoidFestival", "");// 还款计划避开节假日
			hkmap.put("isAllowAdvanceRepayment", "");// 允许提前还款

			
			
			
			if(a==1){						
			String str = mg.getC_mgprice_result();
			DecimalFormat df = new DecimalFormat("#.00");  
			double bj = Double.parseDouble(str);
			bj = Double.parseDouble(df.format(bj));			
			hkmap.put("repaymentPrincipal", df.format(bj));// 应还本金 yhbj_money
			hkmap.put("repaymentInterest", df.format(bj*0.0068*qs));// 应还利息 yhlx_money
			hkmap.put("repaymentCost", "0");// 应还费用
			hkmap.put("repaymentTotal", df.format(bj+bj*0.0068*qs));// 应还总额 yhbj_money+ yhlx_money						
			for(int j=0;j<qs;j++){			
				JSONObject hkmap2=new JSONObject(); 
				hkmap2.put("period", j+1);
				Date date1 = dftime.parse(mg.getDt_fk()); // 指定日期
				Date newDate1 = addDate(date1, 30*(j+1)); // 指定日期加上30天 
				hkmap2.put("repaymentDate",dftime.format(newDate1) );//每期期还款计划时间
				hkmap2.put("repaymentPrincipal", df.format(bj/qs));//每期还款计划本金
				hkmap2.put("repaymentInterest", df.format(bj*0.0068));//每期还款计划利息
				hkmap2.put("repaymentTotal", df.format(bj*0.0068+bj/qs));//每期还款计划小计
				hkmap2.put("repaymentCost", 0);//每期应还费用
				hkmap2.put("remark", " ");// 备注
				hklist.add(hkmap2);
				
			}
			hkmap.put("hklist", hklist);
			
			for(int c=0;c<qs;c++){
				if(c ==1){
					//hkmap.put("首期还款计划时间",mg.getDt_fk()+30 );
					//hkmap.put("首期还款计划本金", df.format(bj/qs));
					//hkmap.put("首期还款计划利息", df.format(bj*0.0068));
					//hkmap.put("首期还款计划小计", df.format(bj*0.0068+bj/qs));
					hkmap.put("everyRepaymentAmount", df.format(bj*0.0068+bj/qs));// 每期还款金额 mq_money
					hkmap.put("firstRepaymentAmount", df.format(bj*0.0068+bj/qs));// 首期还款金额 sq_money					
				} if(c ==qs){
					/*hkmap.put("尾期还款计划时间",mg.getDt_fk()+30*c );
					hkmap.put("尾期还款计划本金", df.format(bj/qs));
					hkmap.put("尾期还款计划利息", df.format(bj*0.0068));
					hkmap.put("尾期还款计划小计", df.format(bj*0.0068+bj/qs));*/
					hkmap.put("lastRepaymentAmount", df.format(bj*0.0068+bj/qs));// 尾期还款金额 wq_money
				}				
			}				
			}if(a==0){				
				String str = mg.getC_mgprice_result();
				DecimalFormat df = new DecimalFormat("#.00");  
				double bj = Double.parseDouble(str);
				bj = Double.parseDouble(df.format(bj));				
				hkmap.put("repaymentPrincipal", df.format(bj));// 应还本金 yhbj_money
				hkmap.put("repaymentInterest", df.format(bj*0.01*qs));// 应还利息 yhlx_money
				hkmap.put("repaymentCost", "0");// 应还费用
				hkmap.put("repaymentTotal", df.format(bj+bj*0.01*qs));// 应还总额 yhbj_money+ yhlx_money
				for(int u=0;u<qs;u++){	
					JSONObject hkmap2=new JSONObject(); 
					hkmap2.put("period", u+1);
					Date date1 = dftime.parse(mg.getDt_fk()); // 指定日期
					Date newDate1 = addDate(date1, 30*(u+1)); // 指定日期加上30天 
					hkmap2.put("repaymentDate",dftime.format(newDate1) );//每期期还款计划时间
					hkmap2.put("repaymentPrincipal", df.format(0));//每期还款计划本金
					hkmap2.put("repaymentInterest", df.format(bj*0.01));//每期还款计划利息
					hkmap2.put("repaymentCost", 0);//每期应还费用
					hkmap2.put("remark", " ");// 备注
					if(u+1==qs){						
						hkmap2.put("repaymentTotal", df.format(bj*0.01+bj));//每期还款计划小计
					}else{
						hkmap2.put("repaymentTotal", df.format(bj*0.01));
					}
				
					hklist.add(hkmap2);
					
				}
				hkmap.put("hklist", hklist);
					
					for(int b =0;b<=qs;b++){
						if(b==1){
						/*hkmap.put("首期还款计划时间",mg.getDt_fk()+30 );
						hkmap.put("首期还款计划本金", df.format(0));
						hkmap.put("首期还款计划利息", df.format(bj*0.01));
						hkmap.put("首期还款计划小计", df.format(bj*0.01));*/
						hkmap.put("everyRepaymentAmount", df.format(bj*0.01));// 每期还款金额 mq_money
						hkmap.put("firstRepaymentAmount", df.format(bj*0.01));// 首期还款金额 sq_money
					}if(b ==qs){
						/*hkmap.put("尾期还款计划时间",mg.getDt_fk()+30*b );
						hkmap.put("尾期还款计划本金", df.format(0));
						hkmap.put("尾期还款计划利息", df.format(bj*0.01));
						hkmap.put("尾期还款计划小计", df.format(bj*0.01+bj));*/
						hkmap.put("lastRepaymentAmount", df.format(bj*0.01+bj));// 尾期还款金额 wq_money
					}
					
					
			}
				
				
			}
			
			
			
			
			
			map.put("hkmap", hkmap);
			
			
			
		}
		
		//**************共借人信息
		
		 
	        JSONObject a = new JSONObject();
	        a.put("name", mg.getCt_name());
	        ;//
	        a.put("certificateNo", mg.getCt_cardno());
	        ;// String 是 证件号码 ct_cardno
	        a.put("phone", "");
	        ;// String 是 电话
	        a.put("remark", "");
	        ;// String 否
	        a.put("certificateType", "");
	        
		
		
		
		
		
		
		
		
		map.put("coborrower", a);
		
		
		maplist2.add(map2);
		
		
		map.put("json", json);
	      
        map.put("loanInfo1", loanInfo1);
        map.put("dyw", dyw);
        map.put("attachment", attachment);
        map.put("maplist2",maplist2);
       
        maplist.add(map);
		
    	}
    	
    	 JSONObject data = new JSONObject();
	     data.put("loanInfoList", maplist); 
	    JSONObject obj=createHead();
	     obj.put("data", data);
	     String s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/loan/addLoanInfo", obj.toString());				
	    	
	    	
	    	
	        return s.toString();
 
    	
		}
    

   
    

		



 

	public static Map<Object, Object> jsonToMap(Object jsonObj) {
        JSONObject jsonObject = JSONObject.fromObject(jsonObj);
        Map<Object, Object> map = jsonObject;
        return map;
    }
	
	public static List<Map<Object, Object>> toList(Object object)
    {
        List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
        JSONArray jsonArray = JSONArray.fromObject(object);
        for (Object obj : jsonArray)
        {
            JSONObject jsonObject = (JSONObject) obj;
            Map<Object, Object> map = new HashMap<Object, Object>();
            Iterator it = jsonObject.keys();
            while (it.hasNext())
            {
                String key = (String) it.next();
                Object value = jsonObject.get(key);
                map.put(key, value);
            }
            list.add(map);
        }
        return list;
    }
 
	 //日期加多少天
	public static Date addDate(Date date,long day) throws ParseException {							
		 long time = date.getTime(); //得到指定日期的毫秒数
		 day = day*24*60*60*1000; //要加上的天数转换成毫秒数
		 time+=day; //相加得到新的毫秒数
		 return new Date(time); // 将毫秒数转换成日期
		}
	  //日期转换 21312312 格式
	public static String todata(String time) throws ParseException {						
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMdd");// 日期格式
		Date date =df.parse(time); // 指定日期
		//df1.format(date);
	    return df1.format(date).toString(); 
	    
	}
	
	public static void main(String[] args) throws ParseException {

		}

	
	
	
	
	

}
