package com.controller.PFmodel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/**
 * 类名称 
 * 类描述: 工行 大数据解析
 * 创建人: 李旺
 */
@Controller
@RequestMapping("/kj")
public class KjICBCController{	
	/**工行数据解析
	 * @param customer
	 * @param s1
	 * @Description: TODO
	 * @param name
	 * @return 
	 */
	public void icbc(Customer customer,String s1){
		 if(s1!=null && !s1.equals("")){
			int[] arr =new int[2];
			arr[0]=s1.indexOf("个人");
			if(arr[0]==-1){//不存在个人的节点
				return;
			}
			arr[1]=s1.indexOf("配偶");//配偶的节点  这里还有可能出现其他共借人的节点 ，但是目前没有看到征信中超过两个人的，不能确定节点的关键字 
			int end=aji(arr,arr[0]);
			if(end==arr[0]){
				end=s1.length();
			}
			String[] s3=s1.substring(arr[0],end).replaceAll("[\\，\\,\\元\\；\\。]",";").replaceAll("[\\：]",":").split(";");//统一化处理
			String sss="";
			for(int j=0;j<s3.length;j++){
					sss=s3[j];
					if(sss.indexOf("已婚")!=-1){
						customer.setIs_marital_status("1");
					}
					int i0=sss.indexOf("未结清贷款笔数");
					if(i0!=-1){
						String ss0_=to(sss,8,i0);
						customer.setUncleared_number(add(customer.getUncleared_number(),ss0_));
						continue;
					}
					int i1=sss.indexOf("信用卡汇总:张数");
					if(i1!=-1){
						customer.setCount_credit(to(sss,9,i1));
						continue;
					}
					int i2=sss.indexOf("授信总额");
					if(i2!=-1){
						customer.setMax_credit(to(sss,5,i2));
						continue;
					}
					int i6=sss.indexOf("单月最高逾期金额");
					if(i6!=-1){
						String ss6_=to(sss,9,i6);
						customer.setHighest_overdue(max(customer.getHighest_overdue(),ss6_));
						continue;
					}
					int i7=sss.indexOf("未结清贷款余额");
					if(i7!=-1){
						String ss7_=to(sss,8,i7);
						customer.setUncleared_monty(add(customer.getUncleared_monty(),ss7_));
						continue;
					}				
				}
		}	
	}
	/**求出一个数组中所有大于某个数的数中的最小值 对征信数据节点的处理
	 * @param arr int数组
	 * @param i 要比较的值
	 * @return
	 * @Description: TODO
	 * @param name
	 * @return 
	 */
	public static int aji(int[] arr,int i){
		int i1=i;//下一个值
		int i2;//最大值
		for(int j=0;j<arr.length;j++){
			if(arr[j]>i){//大于基本值
				i2=arr[j];//赋max值
				if(i1>i2 || i==i1){//第一次进来 i=i1<i2  所以把i2赋值给i1，以后i<i1 第二次进来 如果：i1>i2>i，则：所以把i2赋值给i1，否则不变
					i1=i2;
				}
			}
		}
		return i1;
	}
	//:号
	public static String to(String s,int i,int ii){
		String s1="";
		if(s.substring(ii).indexOf(":")==-1){
			i-=1;
		}
		s1=s.substring(ii+i);
		if(s1.equals("")){
			s1="0";
		}
		return s1;
	}
	//相加
	public static String add(String s1,String s2){
		int i2=0;
		try {
			i2=Integer.parseInt(s2);
		} catch (NumberFormatException e) {
		}
		return Integer.parseInt(s1)+i2+"";
	}
	//求两个数的最大 
	public static String max(String s1,String s2){
		int i2=0;
		try {
			i2=Integer.parseInt(s2);
		} catch (NumberFormatException e) {
		}
		if(i2>Integer.parseInt(s1)){
			return i2+"";
		}else{
			return s1;
		}
	}
	  //大数据征信字段解析
	  public String  bigdate(Customer customer,String ss0){ 
		  if(ss0!=null && !ss0.equals("")){
	    	  JSONArray  ja1=JSONObject.fromObject(ss0).getJSONArray("risk_items");//获得所有的风险项
	    	  if(ja1!=null){////扫描出来的风险项不为空
	    		  for(int i=0;i<ja1.size();i++){//遍历所有的风险项
	    			  JSONObject jo=ja1.getJSONObject(i);//获得这个风险项
	    			  JSONObject jo2;
	    			  try {
	    				  jo2=jo.getJSONObject("item_detail");//检查详情
	    				  String s=jo.getString("item_id");
	    				  if(s.equals("3393158")){
	        				  customer.setSeven_days(jo2.getString("platform_count"));  
	        				 	continue;
	         			  }else if(s.equals("3393160")){
	        				   customer.setOne_month(jo2.getString("platform_count"));
	        				   	continue;
	         			  }else if(s.equals("3393162")){
	           				   customer.setThree_month(jo2.getString("platform_count"));
	           				   continue;
	         			  }else if(s.equals("3393164")){
	    	   				   customer.setSix_month(jo2.getString("platform_count"));
	    	   				   continue;
	        			  }else if(s.equals("3393166")){ 
	    	   				  customer.setTwelve_month(jo2.getString("platform_count"));
	    	   				  continue;
	        			  }else if(s.equals("3392960")){ // 法院执行 失信人
			   				   JSONArray ja2=(JSONArray) jo2.get("namelist_hit_details");//命中名单详情列表 返回关注名单、风险名单、模糊名单规则详情其中的一种或几种
			   				   for(int j=0;j<ja2.size();j++){
			   					JSONArray ja3=ja2.getJSONObject(j).getJSONArray("court_details");//法院详情列表
			   					for(int z=0;z<ja3.size();z++){//遍历
			   						JSONObject jo3=(JSONObject)ja3.get(z);//法院详情
			   						String s0=jo3.get("fraud_type").toString();//欺诈类型  "法院失信"，"法院执行"，"法院结案"中的一种
			   						String s1=jo3.getString("situation").toString();//情况
			   						if(s0.equals("法院失信")){//曾经失信过
			   							customer.setIs_credit("1");
			   							continue;
			   						}
			   						if(s0.equals("法院执行") || s0.equals("法院结案")){
			   							customer.setCourt_execution("1");
			   							continue;
			   						}
			   					  }
			   				    }
			    			 }	
	    				  	 continue;
						} catch (Exception e) {
							// TODO: handle exception
							continue;
						}	
		    		 }
		    	}
		  }
		  return Demo_TaiRA.fun(customer);
    	}
	public static void main(String[] args){
		String s="个人风险筛查结果:通过;;补充信息::已婚授信总额115000元已用额度43519元近六个月使用33367元房贷2010.2.8--2030.2.8151000元月还913元本金余额104377元余141期消费贷款2017.7.9--2020.2.24240000元月还应1123元本月实还5170元";
		/*
		根据订单id查询大数据 返回结果
		RiskServicePreloan r=new RiskServicePreloan();
		String s1=r.query("ER20180703105348488FC4DC").toJSONString();*/
		String s1="{'final_score':27,'credit_score':503,'risk_items':[{'risk_level':'low','item_detail':{'frequency_detail_list':[{'detail':'3个月身份证关联家庭地址数：0'},{'data':['13883911275','138※※※※1275'],'detail':'3月内_身份证_手机号码_关联个数_全局：2'}],'type':'frequency_detail'},'item_id':3393094,'item_name':'3个月内身份证关联多个申请信息','group':'客户行为检测'},{'risk_level':'low','item_detail':{'frequency_detail_list':[{'detail':'7天内_身份证_出现次数_本应用：3'}],'type':'frequency_detail'},'item_id':3393120,'item_name':'7天内设备或身份证或手机号申请次数过多','group':'客户行为检测'},{'risk_level':'high','item_detail':{'platform_detail_dimension':[{'count':1,'detail':['小额贷款公司:1'],'dimension':'借款人手机详情'},{'count':2,'detail':['小额贷款公司:1','厂商汽车金融:1'],'dimension':'借款人身份证详情'}],'platform_detail':['小额贷款公司:1','厂商汽车金融:1'],'platform_count':2,'type':'platform_detail'},'item_id':3393158,'item_name':'7天内申请人在多个平台申请借款','group':'多平台借贷申请检测'},{'risk_level':'medium','item_detail':{'platform_detail_dimension':[{'count':1,'detail':['小额贷款公司:1'],'dimension':'借款人手机详情'},{'count':2,'detail':['小额贷款公司:1','厂商汽车金融:1'],'dimension':'借款人身份证详情'}],'platform_detail':['小额贷款公司:1','厂商汽车金融:1'],'platform_count':2,'type':'platform_detail'},'item_id':3393160,'item_name':'1个月内申请人在多个平台申请借款','group':'多平台借贷申请检测'},{'risk_level':'medium','item_detail':{'platform_detail_dimension':[{'count':1,'detail':['小额贷款公司:1'],'dimension':'借款人手机详情'},{'count':2,'detail':['小额贷款公司:1','厂商汽车金融:1'],'dimension':'借款人身份证详情'}],'platform_detail':['小额贷款公司:1','厂商汽车金融:1'],'platform_count':2,'type':'platform_detail'},'item_id':3393162,'item_name':'3个月内申请人在多个平台申请借款','group':'多平台借贷申请检测'},{'risk_level':'medium','item_detail':{'platform_detail_dimension':[{'count':1,'detail':['小额贷款公司:1'],'dimension':'借款人手机详情'},{'count':2,'detail':['小额贷款公司:1','厂商汽车金融:1'],'dimension':'借款人身份证详情'}],'platform_detail':['小额贷款公司:1','厂商汽车金融:1'],'platform_count':2,'type':'platform_detail'},'item_id':3393164,'item_name':'6个月内申请人在多个平台申请借款','group':'多平台借贷申请检测'},{'risk_level':'low','item_detail':{'platform_detail_dimension':[{'count':1,'detail':['小额贷款公司:1'],'dimension':'借款人手机详情'},{'count':2,'detail':['小额贷款公司:1','厂商汽车金融:1'],'dimension':'借款人身份证详情'}],'platform_detail':['小额贷款公司:1','厂商汽车金融:1'],'platform_count':2,'type':'platform_detail'},'item_id':3393166,'item_name':'12个月内申请人在多个平台申请借款','group':'多平台借贷申请检测'},{'risk_level':'low','item_detail':{'platform_detail_dimension':[{'count':1,'detail':['小额贷款公司:1'],'dimension':'借款人手机详情'},{'count':2,'detail':['小额贷款公司:1','厂商汽车金融:1'],'dimension':'借款人身份证详情'}],'platform_detail':['小额贷款公司:1','厂商汽车金融:1'],'platform_count':2,'type':'platform_detail'},'item_id':3393168,'item_name':'18个月内申请人在多个平台申请借款','group':'多平台借贷申请检测'},{'risk_level':'low','item_detail':{'platform_detail_dimension':[{'count':1,'detail':['小额贷款公司:1'],'dimension':'借款人手机详情'},{'count':2,'detail':['小额贷款公司:1','厂商汽车金融:1'],'dimension':'借款人身份证详情'}],'platform_detail':['小额贷款公司:1','厂商汽车金融:1'],'platform_count':2,'type':'platform_detail'},'item_id':3393170,'item_name':'24个月内申请人在多个平台申请借款','group':'多平台借贷申请检测'},{'risk_level':'low','item_detail':{'platform_detail_dimension':[{'count':1,'detail':['小额贷款公司:1'],'dimension':'借款人手机详情'},{'count':2,'detail':['小额贷款公司:1','厂商汽车金融:1'],'dimension':'借款人身份证详情'}],'platform_detail':['小额贷款公司:1','厂商汽车金融:1'],'platform_count':2,'type':'platform_detail'},'item_id':3393172,'item_name':'近60个月以上申请人在多个平台申请借款','group':'多平台借贷申请检测'},{'risk_level':'medium','item_detail':{'frequency_detail_list':[{'detail':'1小时内_手机号码_出现次数_本应用：3'}],'type':'frequency_detail'},'item_id':3393064,'item_name':'1小时内身份证或手机号申请次数大于等于3','group':'客户行为检测'}],'address_detect':{'mobile_address':'重庆市','id_card_address':'四川省万县市忠县'},'final_decision':'Review','report_time':1530586428000,'success':true,'report_id':'ER20180703105348488FC4DC','apply_time':1530586428000,'application_id':'1807031053486878DC19ABCF52C14C86'}";
		KjICBCController kc=new KjICBCController();
		String defaultvalue="0";
		Customer c=new Customer();
		kc.icbc(c, s);
		try {
			defaultvalue=JSONObject.fromObject(kc.bigdate(c,s1)).toString();
		} catch (Exception e) {
			//json转化异常 这里可以做一些...
		}
		System.out.println("分数："+defaultvalue);
	} 
}