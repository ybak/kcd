package com.controller.icbc;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.service1.kjs_icbc.newicbc_preauditService;
import com.service1.money.moneyfsService;
import com.service1.money.moneyfs_1Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JButton;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.naming.java.javaURLContextFactory;
import org.aspectj.bridge.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mapper.icbc.icbcMapper;
import com.model.credit;
import com.model.icbc.assess_cars;
import com.model.icbc.icbc;
import com.model.icbc.icbc_cardk;
import com.model.icbc.icbc_kk;
import com.model.icbc.icbc_preaudit;
import com.model.icbc.icbc_result;
import com.model.icbc.icbc_zx;
import com.model.jbapi.jbzxapiuser;
import com.model1.carbrand;
import com.model1.carmodel;
import com.model1.carseries;
import com.model1.gems;
import com.model1.money.moneyfs;
import com.model1.money.moneyfs_1;
import com.service.icbc.icbcService;
import com.service.icbc.icbc_cardkService;
import com.service.icbc.icbc_kkService; 
import com.service.icbc.icbc_resultService;
import com.service.icbc.icbc_zxService;
import com.service.zx.jbzxapiuserService;
import com.service1.gemsService;
import com.service1.car.seriesService;
import com.service1.duoying.carmodelService;
import com.service1.kjs_icbc.icbc_result1Service;
import com.service1.kjs_icbc.newicbcService;
import com.util.ImageCheck;
import com.util.UUIDTool;
import com.util.creditutil;
import com.util.jsonutil;

@Controller
public class icbcController {
       @Autowired
       private icbcService icbcservice;
	@Autowired
	private newicbcService newicbcService;
    @Autowired
    private jbzxapiuserService jbzxapiuserservice;
	@Autowired
	private icbc_resultService icbc_resultServices;
	@Autowired
	private icbc_zxService icbc_zxService;
	@Autowired
	private icbc_result1Service icbc_result1Service;
	@Autowired
	private icbc_kkService icbc_kkService;
	
	@Autowired
	private gemsService gemsService;
	@Autowired
	private moneyfsService  moneyfsService;
	@Autowired
	private moneyfs_1Service  moneyfs_1Service;
	
	@Autowired
	private com.service1.car.brandService brandService;
	@Autowired
	private seriesService seriesService;
	@Autowired
	private carmodelService carmodelService;
	
	
	
	/**
	 * 获取车品牌ID
	 * @param appkey
	 * @return
	 */
	@RequestMapping(value="/cars_brid.do",produces="text/html;charset=UTF-8")  
	@ResponseBody
	public String cars_brid(String appkey){
		gems gems;
        if(appkey!=null&&!appkey.equals("")){
			gems=gemsService.find_api(appkey);
			if(gems!=null&&!gems.equals("")){			
				if(gems.getApi_tag()!=1){
					JSONObject result=new JSONObject();
					result.put("result","");
					result.put("msg","未开通API权限");
					result.put("code","211");
					return result.toString();
				}	
			}else{
				JSONObject result=new JSONObject();
				result.put("result","");
				result.put("msg","appkey错误");
				result.put("code","211");
				return result.toString();
			}
		}else{
			JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","appkey不能为空");
			result.put("code","210");
			return result.toString();	
		}
        List<JSONObject> brandjb=new ArrayList<>();
        List<carbrand> cbl=brandService.findbrand();  
        if(cbl.size()>0){
        	for(carbrand cb : cbl){
        		 JSONObject brands=new JSONObject();
				 brands.put("brand_id",cb.getId());
				 brands.put("brand_name",cb.getName());
				 brands.put("brand_first",cb.getFirst());
				 if(cb.getLogo()!=null&&!cb.getLogo().equals("")){
					 brands.put("brand_logo","http://a.kcway.net/"+cb.getLogo());	 
				 }else{
					 brands.put("brand_logo",""); 
				 }
				 brandjb.add(brands);
        	}
        	JSONObject result=new JSONObject();
            result.put("result",brandjb);
            result.put("msg","成功");
            result.put("code","200");
            return result.toString();
        }else{
        	JSONObject result=new JSONObject();
            result.put("result","");
            result.put("msg","失败");
            result.put("code","201");
            return result.toString();
        }
        
		
	}
	/**
	 * 车系id
	 * @param appkey
	 * @return
	 */
	@RequestMapping(value="/cars_seid.do",produces="text/html;charset=UTF-8")  
	@ResponseBody
	public String cars_seid(String appkey){
		gems gems;
        if(appkey!=null&&!appkey.equals("")){
			gems=gemsService.find_api(appkey);
			if(gems!=null&&!gems.equals("")){			
				if(gems.getApi_tag()!=1){
					JSONObject result=new JSONObject();
					result.put("result","");
					result.put("msg","未开通API权限");
					result.put("code","211");
					return result.toString();
				}	
			}else{
				JSONObject result=new JSONObject();
				result.put("result","");
				result.put("msg","appkey错误");
				result.put("code","211");
				return result.toString();
			}
		}else{
			JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","appkey不能为空");
			result.put("code","210");
			return result.toString();	
		}
        List<JSONObject> seriesjb=new ArrayList<>();
        List<carseries> csList=seriesService.findseries();  
        if(csList.size()>0){
        	for(carseries css : csList){
        		 JSONObject seriess=new JSONObject();
				 seriess.put("brand_id", css.getBrand_id());
				 seriess.put("series_id",css.getId());
				 seriess.put("series_name",css.getName());
				 seriesjb.add(seriess);
        	}
        	JSONObject result=new JSONObject();
            result.put("result",seriesjb);
            result.put("msg","成功");
            result.put("code","200");
            return result.toString();
        }else{
        	JSONObject result=new JSONObject();
            result.put("result","");
            result.put("msg","失败");
            result.put("code","201");
            return result.toString();
        }	
	}
	
	/**
	 * 车型id
	 * @param appkey
	 * @return
	 */
	@RequestMapping(value="/cars_carid.do",produces="text/html;charset=UTF-8")  
	@ResponseBody
	public String cars_carid(String appkey){
		gems gems;
        if(appkey!=null&&!appkey.equals("")){
			gems=gemsService.find_api(appkey);
			if(gems!=null&&!gems.equals("")){			
				if(gems.getApi_tag()!=1){
					JSONObject result=new JSONObject();
					result.put("result","");
					result.put("msg","未开通API权限");
					result.put("code","211");
					return result.toString();
				}	
			}else{
				JSONObject result=new JSONObject();
				result.put("result","");
				result.put("msg","appkey错误");
				result.put("code","211");
				return result.toString();
			}
		}else{
			JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","appkey不能为空");
			result.put("code","210");
			return result.toString();	
		}
        List<JSONObject> modeljb=new ArrayList<>();
        List<carmodel> carmodels=carmodelService.findcarmodel();  
        if(carmodels.size()>0){
        	for(carmodel cm : carmodels){
        		 JSONObject models=new JSONObject();
				 models.put("brand_id", cm.getBrand_id());
				 models.put("series_id ",cm.getSeries_id());
				 models.put("model_id",cm.getId());
				 models.put("model_name",cm.getName());
				 modeljb.add(models);
        	}
        	JSONObject result=new JSONObject();
            result.put("result",modeljb);
            result.put("msg","成功");
            result.put("code","200");
            return result.toString();
        }else{
        	JSONObject result=new JSONObject();
            result.put("result","");
            result.put("msg","失败");
            result.put("code","201");
            return result.toString();
        }	
	}
	/**
	 * 提交工行信息
	 * @param name
	 * @param bankid
	 * @param cardid
	 * @param sex
	 * @param phonenumber
	 * @param ckey
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="/icbcIntopieces.do",produces="text/html;charset=UTF-8")	
	@ResponseBody
	public String icbcIntopieces(			
			String bankid,
			String cardid,
			String sex,
			String phonenumber,
			String ckey,
			String name,
			HttpServletRequest request) throws UnsupportedEncodingException{	
		System.out.println("-"+bankid+"-"+cardid+"-"+sex+"-"+phonenumber+"-"+ckey);
		
		//name= new String(request.getParameter("name").getBytes("iso-8859-1"),"utf-8");
		
		icbc icbc=new icbc();
		icbc.setBc_status(1);
		icbc.setDt_add(creditutil.time());
		icbc.setDt_edit(creditutil.time());
		icbc.setGems_code("ICBC");
		if(name!=null&&!name.equals("")){
			icbc.setC_name(name);
		}else{						
			JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","姓名不能为空");
			result.put("code","210");
			return result.toString();	
		}
        if(bankid!=null&&!bankid.equals("")){
        	icbc.setBank_id(Integer.parseInt(bankid));
		}else{
			JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","bankid不能为空");
			result.put("code","210");
			return result.toString();			
		}
        if(cardid!=null&&!cardid.equals("")){
        	icbc.setC_cardno(cardid);
		}else{
			JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","身份证号不能为空");
			result.put("code","210");
			return result.toString();
				
		}
        if(sex!=null&&!sex.equals("")){
        	icbc.setC_sex(Integer.parseInt(sex));
		}else{
			JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","性别不能为空");
			result.put("code","210");
			return result.toString();		
		}
        if(phonenumber!=null&&!phonenumber.equals("")){
        	icbc.setC_tel(phonenumber);
		}else{
			JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","手机号不能为空");
			result.put("code","210");
			return result.toString();			
		}
        if(ckey!=null&&!ckey.equals("")){
        	jbzxapiuser jau=jbzxapiuserservice.findapiuserbyappkey(ckey);
        	if(jau!=null&&!jau.equals("")){
        		icbc.setGems_fs_id(jau.getId());
        		icbc.setGems_id(jau.getId());
        		icbcservice.addicbc(icbc);
        		icbc icbc1=new icbc();
        		icbc1.setId(icbc.getId());
        		String orderid="ICBC"+testStringBuilder(7-String.valueOf(icbc.getId()).length())+icbc.getId();
        		icbc1.setGems_code(orderid);		
        		icbcservice.upicbc(icbc1);		
        		icbc_result icbc_result=new icbc_result();
        		icbc_result.setDt_add(creditutil.time());
        		icbc_result.setDt_edit(creditutil.time());
        		icbc_result.setMid_add(0);
        		icbc_result.setMid_edit(0);
        		icbc_result.setQryid(icbc.getId());
        		icbc_result.setRemark("提交客户信息");
        		icbc_result.setStatus(1);
        		icbc_resultServices.addicbc_result(icbc_result);
        		JSONObject result=new JSONObject();
        		result.put("result",orderid);
        		result.put("msg","提交成功");
        		result.put("code","200");
        		return result.toString();	
        	}else{
    			JSONObject result=new JSONObject();
    			result.put("result","");
    			result.put("msg","ckey错误");
    			result.put("code","211");
    			return result.toString();
    		}       	       	
		}else{
			JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","ckey不能为空");
			result.put("code","210");
			return result.toString();
		}		
				
	}	
	
	
	@RequestMapping(value="/icbcCredit_result.do",produces = "text/html;charset=UTF-8")	
	@ResponseBody
	public String icbcCredit_result(HttpServletRequest request,
            HttpServletResponse response){
		String appkey=request.getParameter("appkey");
        String orderid=request.getParameter("orderid");
        gems gems;
        if(appkey!=null&&!appkey.equals("")){
			gems=gemsService.find_api(appkey);
			if(gems!=null&&!gems.equals("")){			
				if(gems.getApi_tag()!=1){
					JSONObject result=new JSONObject();
					result.put("result","");
					result.put("msg","未开通API权限");
					result.put("code","211");
					return result.toString();
				}	
			}else{
				JSONObject result=new JSONObject();
				result.put("result","");
				result.put("msg","appkey错误");
				result.put("code","211");
				return result.toString();
			}
		}else{
			JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","appkey不能为空");
			result.put("code","210");
			return result.toString();	
		}	
		icbc icbc;
        if(orderid!=null&&!orderid.equals("")){
        	icbc=newicbcService.findicbcbyorderid(orderid);
        	if(icbc!=null&&!icbc.equals("")&&icbc.getGems_id()==gems.getId()){
        		icbc_result ilIcbc_results=icbc_result1Service.lastfindresult(icbc.getId());
        		JSONObject result=new JSONObject();
        		JSONObject result1=new JSONObject();
        		if(ilIcbc_results!=null&&!ilIcbc_results.equals("")){        		  		
        		result1.put("remark",ilIcbc_results.getRemark());
        		}       		        		
        	    result1.put("zx_result",icbc.getZx_result().trim());        	    
        	    result1.put("zx_resultdate", icbc.getDt_zxresult().replace(".0",""));
        	    result1.put("status",icbc.getBc_status());    
        	    result1.put("orderid",icbc.getGems_code());
        	    result1.put("tr_status",icbc.getTr_status());
    			result.put("result",result1);
    			result.put("msg","成功");
    			result.put("code","200");
    			return result.toString();        		
        	}else{
        		JSONObject result=new JSONObject();
    			result.put("result","");
    			result.put("msg","订单编号错误");
    			result.put("code","212");
    			return result.toString();
        	}
        	
        }else{
    		JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","订单编号不能为空");
			result.put("code","210");
			return result.toString();
    	}                	
	}
	/**
	 * 工行征信信息
	 * @param request
	 * @param response
	 * @param cardfront
	 * @param cardopposite
	 * @param authorizebook
	 * @param suppily
	 * @return  /KCDIMG/assess/KCDIMG/assess/upload/
	 * @throws IOException
	 */
	@RequestMapping(value="/icbcCredit.do",produces ="text/html;charset=UTF-8")	
	@ResponseBody
	public String icbcCredit(
			HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam("cardfront") MultipartFile cardfront,//正面
            @RequestParam("cardopposite") MultipartFile cardopposite,//反面           
            @RequestParam("authorizebook") MultipartFile authorizebook,//授权书
            @RequestParam("cardfacebook") MultipartFile cardfacebook,//手持授权书身份证/面签照
            @RequestParam("suppily") MultipartFile[] suppily            
            ) throws IOException{
        icbc iz=new icbc();
        icbc_result ir=new icbc_result();
        String appkey=request.getParameter("appkey");
        String orderid=request.getParameter("orderid");
        String businesslevel=request.getParameter("businesslevel"); //业务等级
        String product_id=request.getParameter("product_id"); //贷款产品
        String ajbank_id=request.getParameter("ajbank_id"); //按揭银行
        String name=request.getParameter("name"); //姓名
        String cardno=request.getParameter("cardno"); //身份证
        String phoneno=request.getParameter("phoneno"); //手机号
        String sex=request.getParameter("sex"); //性别
        //通融
        String tr_status=request.getParameter("tr_status");
        String tr_msg=request.getParameter("tr_msg");
        
        //配偶和共借人
        String po_name=request.getParameter("po_name");
        String po_cardno=request.getParameter("po_cardno");
        String po_phoneno=request.getParameter("po_phoneno");
        String g_name1=request.getParameter("g_name1");
        String g_phoneno1=request.getParameter("g_phoneno1");
        String g_cardno1=request.getParameter("g_cardno1");
        String g_name2=request.getParameter("g_name2");
        String g_phoneno2=request.getParameter("g_phoneno2");
        String g_cardno2=request.getParameter("g_cardno2");
        iz.setTr_msg(tr_msg);
        if(tr_status!=null&&!tr_status.equals("")){
        iz.setTr_status(Integer.parseInt(tr_status));	
        }
        iz.setC_name_mt(po_name);        
        iz.setC_cardno_mt(po_cardno);
        iz.setC_tel_mt(po_phoneno);	
        iz.setC_cardno_gj1(g_cardno1);
        iz.setC_cardno_gj2(g_cardno2);
        iz.setC_name_gj1(g_name1);
        iz.setC_name_gj2(g_name2);
        iz.setC_tel_gj1(g_phoneno1);
        iz.setC_tel_gj2(g_phoneno2);
        gems gems;
		if(appkey!=null&&!appkey.equals("")){
			gems=gemsService.find_api(appkey);
			if(gems!=null&&!gems.equals("")){			
				if(gems.getApi_tag()!=1){
					JSONObject result=new JSONObject();
					result.put("result","");
					result.put("msg","未开通API权限");
					result.put("code","211");
					return result.toString();
				}	
			}else{
				JSONObject result=new JSONObject();
				result.put("result","");
				result.put("msg","appkey错误");
				result.put("code","211");
				return result.toString();
			}
		}else{
			JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","appkey不能为空");
			result.put("code","210");
			return result.toString();	
		}		
		icbc icbcid;
		if(orderid!=null&&!orderid.equals("")){
			icbcid=newicbcService.findicbcbyorderid(orderid);
			if(icbcid==null||icbcid.equals("")){
				JSONObject result=new JSONObject();
    			result.put("result","");
    			result.put("msg","订单编号错误");
    			result.put("code","212");
    			return result.toString();
			}
		}
         //String filePath1 = "C:/Users/Administrator/Desktop/carsassess";
        Date date = new Date(); 
        String filePath = "/KCDIMG/assess/upload/"+new SimpleDateFormat("yyyy/MM/dd/").format(date);
        String imgpath="upload/"+new SimpleDateFormat("yyyy/MM/dd/").format(date);
        File f = new File(imgpath);
        if(!f.exists()){  
            f.mkdirs();   
        } 
        // 响应客户端  
        response.setContentType("text/html;UTF-8"); 
        //System.out.println(cardfront.getOriginalFilename());
        if (cardfront.isEmpty()&&cardopposite.isEmpty()
                &&cardfacebook.isEmpty()&&authorizebook.isEmpty()) {
        	JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","照片不能为空");
			result.put("code","210");
			return result.toString();
        }
        if(sex!=null&&!sex.equals("")){
        	iz.setC_sex(Integer.parseInt(sex));	
        }else{
        	JSONObject result=new JSONObject();
    		result.put("result","");
    		result.put("msg","sex不能为空");
    		result.put("code","210");
    		return result.toString();	
        }
        if(phoneno!=null&&!phoneno.equals("")){
        	iz.setC_tel(phoneno);	
        }else{
        	JSONObject result=new JSONObject();
    		result.put("result","");
    		result.put("msg","phoneno不能为空");
    		result.put("code","210");
    		return result.toString();	
        }
        if(cardno!=null&&!cardno.equals("")){
        	iz.setC_cardno(cardno);	
        }else{
        	JSONObject result=new JSONObject();
    		result.put("result","");
    		result.put("msg","cardno不能为空");
    		result.put("code","210");
    		return result.toString();	
        }
        if(name!=null&&!name.equals("")){
        	iz.setC_name(name);	
        }else{
        	JSONObject result=new JSONObject();
    		result.put("result","");
    		result.put("msg","name不能为空");
    		result.put("code","210");
    		return result.toString();	
        }
        if(ajbank_id!=null&&!ajbank_id.equals("")){
        	iz.setBank_id(Integer.parseInt(ajbank_id));	
        }else{
        	JSONObject result=new JSONObject();
    		result.put("result","");
    		result.put("msg","ajbank_id不能为空");
    		result.put("code","210");
    		return result.toString();	
        }
        if(businesslevel!=null&&!businesslevel.equals("")){
        	iz.setLoan_level(Integer.parseInt(businesslevel));	
        }else{
        	JSONObject result=new JSONObject();
    		result.put("result","");
    		result.put("msg","businesslevel不能为空");
    		result.put("code","210");
    		return result.toString();	
        }
        if(product_id!=null&&!product_id.equals("")){
        iz.setLoan_tpid(Integer.parseInt(product_id));	
        }else{
        	JSONObject result=new JSONObject();
    		result.put("result","");
    		result.put("msg","businesslevel不能为空");
    		result.put("code","210");
    		return result.toString();	        	
        }
        //身份证正面
        if (!cardfront.isEmpty()) {  
        	    String filename = cardfront.getOriginalFilename();
        	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
        	    UUID uuid = UUID.randomUUID();
        	    String uuidname=uuid.toString().replaceAll("-","")+"."+prefix;        	
                byte[] file36Byte = cardfront.getBytes();
                FileUtils.writeByteArrayToFile(new File(filePath+uuidname),file36Byte);
                iz.setImgstep2_1(imgpath+uuidname);                
        }  
        //身份证反面
        if (!cardopposite.isEmpty()) {  
        	    String filename = cardopposite.getOriginalFilename();
        	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
        	    UUID uuid = UUID.randomUUID();
        	    String uuidname=uuid.toString().replaceAll("-","")+"."+prefix;        	
                byte[] file36Byte = cardopposite.getBytes();
                FileUtils.writeByteArrayToFile(new File(filePath+uuidname),file36Byte);
                iz.setImgstep2_2(imgpath+uuidname);
        }  
        //手持身份证授权书/面签照
        if(cardfacebook!=null&&!cardfacebook.equals("")){
        if (!cardfacebook.isEmpty()) {  
    	    String filename = cardfacebook.getOriginalFilename();
    	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
    	    UUID uuid = UUID.randomUUID();
    	    String uuidname=uuid.toString().replaceAll("-","")+"."+prefix;        	
            byte[] file36Byte =cardfacebook.getBytes();
            FileUtils.writeByteArrayToFile(new File(filePath+uuidname),file36Byte);
            iz.setImgstep2_3(imgpath+uuidname);
        }     	
        }
        //面签照
//        if(facebook!=null&&!facebook.equals("")){
//
//        if (!facebook.isEmpty()) {  
//    	    String filename = facebook.getOriginalFilename();
//    	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
//    		String path = filePath +"/facebook/"
//    			   +creditutil.timefile()+"/"+creditutil.timefiles()+"fb."+prefix;
//            byte[] file36Byte = facebook.getBytes();
//            FileUtils.writeByteArrayToFile(new File(path),file36Byte);
//            icbc1.setImgstep2_4(imgpath+"facebook/"+creditutil.timefile()+"/"+creditutil.timefiles()+"fb."+prefix);
//        }
//    	
//        }
        //授权书
        if (!authorizebook.isEmpty()) {  
    	    String filename = authorizebook.getOriginalFilename();
    	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
    	    UUID uuid = UUID.randomUUID();
    	    String uuidname=uuid.toString().replaceAll("-","")+"."+prefix;        	
            byte[] file36Byte =cardfacebook.getBytes();
            FileUtils.writeByteArrayToFile(new File(filePath+uuidname),file36Byte);
            iz.setImgstep2_5(imgpath+uuidname);
        }
        //新增补充资料
        //System.out.println(suppily.length+"-----------");
        if (suppily!=null&&suppily.length>0) {  
        	String pString ="";
        	List l=new ArrayList<>();
        	for(int i=0;i<suppily.length;i++){
        		MultipartFile file=suppily[i];
        		if(file.getSize()>0){
        		String filename = file.getOriginalFilename();
        	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
        	    UUID uuid = UUID.randomUUID();
        	    String uuidname=uuid.toString().replaceAll("-","")+"."+prefix;        	
                byte[] file36Byte =file.getBytes();
                FileUtils.writeByteArrayToFile(new File(filePath+uuidname),file36Byte);
                //System.out.println(imgpath+"suppily/"+creditutil.timefile()+UUIDTool.getUUID()+i+"."+prefix);
                pString=pString+""+imgpath+uuidname;
        		}
        	}  
        	iz.setImgstep2_5s(pString);
        }       
        iz.setDt_edit(creditutil.time());
        iz.setDt_fin("0000-00-00 00:00:00");
        iz.setTr_msg("");
        iz.setDsj_result("");
        iz.setDsj_result_time("0000-00-00 00:00:00");
        iz.setDsj_report_id("");
        iz.setDt_sub("0000-00-00 00:00:00");
        iz.setMid_add(gems.getAdmin_id());
        iz.setMid_edit(gems.getAdmin_id());
        iz.setGems_id(gems.getId());
        iz.setGems_fs_id(gems.getFsid());
        icbc icbc;
        JSONObject result1=new JSONObject();
        if(orderid!=null&&!orderid.equals("")){
        	icbc=newicbcService.findicbcbyorderid(orderid);
            if(icbc!=null&&!icbc.equals("")){
            	iz.setId(icbc.getId());            	
            	newicbcService.upicbc(iz);
            	ir.setRemark("编辑征信查询信息");
            	 result1.put("orderid",icbc.getGems_code());
            }else{
            	JSONObject result=new JSONObject();
    			result.put("result","");
    			result.put("msg","订单编号错误");
    			result.put("code","212");
    			return result.toString();
            }
        }else{
        	iz.setDt_add(creditutil.time());
            iz.setBc_status(2);
            iz.setQuery_type(2);            
            iz.setZx_result("");
            iz.setDt_zxresult("0000-00-00 00:00:00");
            iz.setDt_zxsub("0000-00-00 00:00:00");
            icbc icbc2=newicbcService.findlastid();            
            int max=icbc2.getId()+1;
            String gcode="ICBCAPI"+testStringBuilder(8-String.valueOf(max).length())+max;
            iz.setGems_code(gcode);
            newicbcService.addicbc(iz);
            icbc iz1=new icbc();                  
            ir.setRemark("提交征信查询信息");
            result1.put("orderid",gcode);
			moneyfs moneyfs=new moneyfs();			
			moneyfs.setAmount(-100);
			moneyfs.setBintype(0);
			moneyfs.setDt_add(creditutil.time());
			moneyfs.setDt_edit(creditutil.time());
			moneyfs.setFctype(0);
			moneyfs.setFsid(iz.getGems_fs_id());
			moneyfs.setGemsid(iz.getGems_id());
			moneyfs.setMid(iz.getGems_fs_id());
			moneyfs.setMid_add(gems.getAdmin_id());
			moneyfs.setMid_edit(gems.getAdmin_id());
			moneyfs.setOrderid(iz.getId());
			moneyfs.setOtherid(0);
			moneyfs.setRemark("工行车贷接口-征信查询");
			moneyfs.setStatus(1);
			moneyfs.setType(28);
			moneyfsService.addmoneyfs(moneyfs);
			moneyfs_1 moneyfs1=new moneyfs_1();			
			moneyfs1.setAmount(-100);
			moneyfs1.setBintype(0);
			moneyfs1.setDt_add(creditutil.time());
			moneyfs1.setDt_edit(creditutil.time());
			moneyfs1.setFsid(iz.getGems_fs_id());
			moneyfs1.setGemsid(iz.getGems_id());
			moneyfs1.setMid(iz.getGems_fs_id());
			moneyfs1.setRemark("工行车贷接口-征信查询");
			moneyfs1.setStatus(1);
			moneyfs1.setMoneyid(moneyfs.getId());
			moneyfs1.setBc_type(0);
			moneyfs1.setOrderid(iz.getId());
			moneyfs1.setType(28);
            moneyfs_1Service.addmoneyfs_2(moneyfs1);            
        }
        ir.setDt_add(creditutil.time());
        ir.setDt_edit(creditutil.time());
        ir.setQryid(iz.getId());
        ir.setMid_add(0);
        ir.setMid_edit(0);               
        ir.setStatus(2);        
        icbc_result1Service.addicbc_result(ir); 
        JSONObject result=new JSONObject();
        result.put("result",result1);
		result.put("msg","成功");
		result.put("code","200");
		return result.toString();
	}
	
	@Autowired
	private newicbc_preauditService icbc_preauditService;
	
	@RequestMapping(value="/icbcpreaudit_result.do",produces="text/html;charset=UTF-8")	
	@ResponseBody
	public String icbcpreaudit_result(HttpServletRequest request){
		String orderid=request.getParameter("orderid");
		String ckey=request.getParameter("ckey");
		jbzxapiuser jau;
		if(ckey!=null&&!ckey.equals("")){
			jau=jbzxapiuserservice.findapiuserbyappkey(ckey);
			if(jau==null||jau.equals("")){		
				JSONObject result=new JSONObject();
				result.put("result","");
				result.put("msg","ckey错误");
				result.put("code","211");
				return result.toString();	
			}
		}else{
			JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","ckey不能为空");
			result.put("code","210");
			return result.toString();	
		}
		icbc icbc;		
        if(orderid!=null&&!orderid.equals("")){
        	icbc=newicbcService.findicbcbyorderid(orderid);
            if(icbc!=null&&!icbc.equals("")){
            JSONObject result=new JSONObject();
            JSONObject result1=new JSONObject();
            icbc_preaudit iPreaudit=icbc_preauditService.findpreauditbyorder(icbc.getId());
            if(iPreaudit!=null&&!iPreaudit.equals("")){
                if(iPreaudit.getBc_status()==3){
                	result1.put("price_result",iPreaudit.getPrice_reuslt());
                	result1.put("result_msg",iPreaudit.getResult());
                	result1.put("result_time",iPreaudit.getResult_time());
                }
                result1.put("status",iPreaudit.getBc_status());
                result1.put("preaudit_orderid",iPreaudit.getGems_code());
                result1.put("orderid",orderid);
     			result.put("result",result1);     			
     			result.put("msg","成功");
     			result.put("code","200");
     			return result.toString();
            }else{            	
    			result.put("result","");
    			result.put("msg","没有预评估信息");
    			result.put("code","213");
    			return result.toString();
            }

            }else{
            	JSONObject result=new JSONObject();
    			result.put("result","");
    			result.put("msg","订单编号错误");
    			result.put("code","212");
    			return result.toString();
            }
        }else{
        	JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","订单编号不能为空");
			result.put("code","210");
			return result.toString();
        }
	}
	
	
	@RequestMapping(value="/icbcpreaudit.do",produces="text/html;charset=UTF-8")	
	@ResponseBody
	public String icbcpreaudit(HttpServletRequest request){
	  String orderid=request.getParameter("orderid");
	  String ckey=request.getParameter("ckey");
	  String source_id=request.getParameter("source_id");//1国产/2进口
	  String property_id=request.getParameter("property_id");//使用性质 1营运/2非营运
	  String gear_box_id=request.getParameter("gear_box_id");//1自动/2手动
	  String car_status=request.getParameter("car_status");//车辆状况
	  String series_id=request.getParameter("series_id");//车系
	  String model_id=request.getParameter("model_id");//车型
	  String brand_id=request.getParameter("brand_id");//车品牌
	  //String car_type=request.getParameter("car_type");//车型
	  String carno=request.getParameter("carno");//车牌号
	  String car_mileage=request.getParameter("car_mileage");//行驶里程
	  String car_vin=request.getParameter("car_vin");//车架号
	  String first_date=request.getParameter("first_date");//初次登记日期
	  String factory_date=request.getParameter("factory_date");//出厂日期
	  String oredit=request.getParameter("oredit");//是否编辑此订单  1是 /2否 默认为否 
	  jbzxapiuser jau;
	  icbc_preaudit ip=new icbc_preaudit();
		if(ckey!=null&&!ckey.equals("")){
			jau=jbzxapiuserservice.findapiuserbyappkey(ckey);
			if(jau!=null&&!jau.equals("")){
				ip.setApi_add(jau.getId());
			}else{
				JSONObject result=new JSONObject();
				result.put("result","");
				result.put("msg","ckey错误");
				result.put("code","211");
				return result.toString();	
			}
		}else{
			JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","ckey不能为空");
			result.put("code","210");
			return result.toString();	
		}
		icbc icbc;	
		icbc_preaudit icbc_preaudit=null;
        if(orderid!=null&&!orderid.equals("")){
        	icbc=newicbcService.findicbcbyorderid(orderid);
            if(icbc!=null&&!icbc.equals("")){
            	icbc_preaudit=icbc_preauditService.findpreauditbyid(icbc.getId());            	            	
            	ip.setCarkm(car_mileage);
            	if(car_status!=null&&!car_status.equals("")){
            		ip.setCar_status(Integer.parseInt(car_status));	
            	}            	
            	if(brand_id!=null&&!brand_id.equals("")){
            		ip.setBrid(Integer.parseInt(brand_id));
            	}
                if(series_id!=null&&!series_id.equals("")){
                	ip.setSeid(Integer.parseInt(series_id));
            	}
                if(model_id!=null&&!model_id.equals("")){
                	ip.setCarid(Integer.parseInt(model_id));
                }
                ip.setCarvin(car_vin);
                ip.setCarno(carno);
                ip.setCardt1(factory_date);
                ip.setCardt2(first_date);
                ip.setBc_status(2);
                if(gear_box_id!=null&&!gear_box_id.equals("")){
                	ip.setGear_box_id(Integer.parseInt(gear_box_id));
                }
                if(gear_box_id!=null&&!gear_box_id.equals("")){
	                ip.setProperty_id(Integer.parseInt(property_id));	
                }
                if(gear_box_id!=null&&!gear_box_id.equals("")){
	                ip.setSource_id(Integer.parseInt(source_id));
                }
            	ip.setIcbc_id(icbc.getId());
            	icbc_result iResult=new icbc_result();
            	iResult.setDt_add(creditutil.time());
            	iResult.setDt_edit(creditutil.time());
            	iResult.setQryid(icbc.getId());
            	iResult.setStatus(2);
            	iResult.setMid_add(0);
            	iResult.setMid_edit(0);
            	if(oredit!=null&&!oredit.equals("")
            			&&oredit.equals("1")){
            		if(icbc_preaudit!=null&&!icbc_preaudit.equals("")){
            			ip.setId(icbc_preaudit.getId());
            			ip.setApi_edit(jau.getId());
                    	ip.setDt_edit(creditutil.time());
            			icbc_preauditService.uppreaudit(ip);
                		iResult.setRemark("编辑汽车预评信息");
                    	icbc_resultServices.addpreaudit_result(iResult);
                    	JSONObject result=new JSONObject();
                    	JSONObject result1=new JSONObject();
                    	result1.put("preaudit_orderid",icbc_preaudit.getGems_code());
                    	result1.put("orderid",orderid);
            			result.put("result",result1);
            			result.put("msg","编辑成功");
            			result.put("code","200");
            			return result.toString();
            		}else{
            			JSONObject result=new JSONObject();
            			result.put("result",orderid);
            			result.put("msg","无可编辑汽车预评信息");
            			result.put("code","213");
            			return result.toString();
            		}
            	}else{
            		if(icbc_preaudit!=null&&!icbc_preaudit.equals("")){
            			JSONObject result=new JSONObject();
            			result.put("result",orderid);
            			result.put("msg","已有汽车预评信息");
            			result.put("code","214");
            			return result.toString();
            		}
            		ip.setDt_add(creditutil.time());
                	ip.setDt_edit(creditutil.time());
                	ip.setQuery_type(2);
                	icbc_preauditService.addpreaudit(ip);
                	icbc_preaudit ip1=new icbc_preaudit();
                	String ordercode="YPGAPI"+testStringBuilder(8-String.valueOf(ip.getId()).length())+ip.getId();
                	ip1.setGems_code(ordercode);
                	ip1.setId(ip.getId());
                	icbc_preauditService.uppreaudit(ip1);  
                	iResult.setRemark("新增汽车预评信息");
                	icbc_resultServices.addpreaudit_result(iResult);
                	JSONObject result=new JSONObject();
                	JSONObject result1=new JSONObject();
                	result1.put("preaudit_orderid",ip1.getGems_code());
                	result1.put("orderid",orderid);
        			result.put("result",result1);
        			result.put("msg","成功");
        			result.put("code","200");
        			return result.toString();
            	}            	
            }else{
            	JSONObject result=new JSONObject();
    			result.put("result","");
    			result.put("msg","订单编号错误");
    			result.put("code","212");
    			return result.toString();
            }
        }else{
        	JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","订单编号不能为空");
			result.put("code","210");
			return result.toString();
        }
	
	}
	
	@Autowired
	private icbc_cardkService icbc_cardkService;
	
	/**
	 * 家访材料
	 * @param ckey
	 * @param orderid
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/homeMaterial.do",produces="text/html;charset=UTF-8")	
	@ResponseBody
	public String homeMaterial(
			String ckey,
			String orderid,
			@RequestParam("newaccount")MultipartFile[] newaccount,//新增户口本照片
			@RequestParam("newfamily")MultipartFile[] newfamily,//新增家庭照片
			@RequestParam("newdrive")MultipartFile[] newdrive,//新增驾驶证
			@RequestParam("signvideo")MultipartFile signvideo,//签约一分钟视频
		HttpServletRequest request,HttpServletResponse response) throws IOException{
		String filePath = "/opt/javaimg/image/upload/img";
        String imgpath="http://apitest.kcway.net/image/upload/img/";
        // 响应客户端  
        response.setContentType("text/html;UTF-8"); 
        if(ckey!=null&&!ckey.equals("")){
			jbzxapiuser jau=jbzxapiuserservice.findapiuserbyappkey(ckey);
			if(jau==null||jau.equals("")){
				JSONObject result=new JSONObject();
				result.put("result","");
				result.put("msg","ckey错误");
				result.put("code","211");
				return result.toString();		
			}
		}else{
			JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","ckey不能为空");
			result.put("code","210");
			return result.toString();	
		}
        icbc icbc1=new icbc();
        icbc_result ir=new icbc_result();
		if(orderid!=null&&!orderid.equals("")){
        	icbc icbc=icbcservice.findicbcbyorderid(orderid);
        	icbc1.setId(icbc.getId());
        	ir.setQryid(icbc.getId());
            if(icbc==null||icbc.equals("")){
            	JSONObject result=new JSONObject();
    			result.put("result","");
    			result.put("msg","订单编号错误");
    			result.put("code","212");
    			return result.toString();
            }	
        }else{
        	JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","orderid不能为空");
			result.put("code","210");
			return result.toString();
        }
		//新增户口本照片
		if (newaccount!=null&&newaccount.length>0) {  
        	List l=new ArrayList<>();
        	for(int i=0;i<newaccount.length;i++){
        		MultipartFile file=newaccount[i];
        		String filename = file.getOriginalFilename();
        	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
        		String path = filePath+"/newaccount/"+creditutil.timefile()+"/"+creditutil.timefiles()+i+"nc."+prefix;
                byte[] file36Byte = file.getBytes();
                FileUtils.writeByteArrayToFile(new File(path),file36Byte);
                // System.out.println(imgpath+"addsuppily/"+creditutil.timefile()+"/"+UUIDTool.getUUID()+i+"."+prefix);
        	    l.add(imgpath+"newaccount/"+creditutil.timefile()+"/"+creditutil.timefiles()+i+"nc."+prefix);
        	}  
            icbc1.setImgstep5_1s(l.toString());
        }
		//新增家庭照片
		if (newfamily!=null&&newfamily.length>0) {  
        	List l=new ArrayList<>();
        	for(int i=0;i<newfamily.length;i++){
        		MultipartFile file=newfamily[i];
        		String filename = file.getOriginalFilename();
        	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
        		String path = filePath+"/newfamily/"+creditutil.timefile()+"/"+creditutil.timefiles()+i+"nf."+prefix;
                byte[] file36Byte = file.getBytes();
                FileUtils.writeByteArrayToFile(new File(path),file36Byte);
                // System.out.println(imgpath+"addsuppily/"+creditutil.timefile()+"/"+UUIDTool.getUUID()+i+"."+prefix);
        	    l.add(imgpath+"newfamily/"+creditutil.timefile()+"/"+creditutil.timefiles()+i+"nf."+prefix);
        	}  
            icbc1.setImgstep5_2s(l.toString());
        }
		//新增驾驶证照片 
		if (newdrive!=null&&newdrive.length>0) {  
        	List l=new ArrayList<>();
        	for(int i=0;i<newdrive.length;i++){
        		MultipartFile file=newdrive[i];
        		String filename = file.getOriginalFilename();
        	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
        		String path = filePath+"/newdrive/"+creditutil.timefile()+"/"+creditutil.timefiles()+i+"nd."+prefix;
                byte[] file36Byte = file.getBytes();
                FileUtils.writeByteArrayToFile(new File(path),file36Byte);
                // System.out.println(imgpath+"addsuppily/"+creditutil.timefile()+"/"+UUIDTool.getUUID()+i+"."+prefix);
        	    l.add(imgpath+"newdrive/"+creditutil.timefile()+"/"+creditutil.timefiles()+i+"nd."+prefix);
        	}  
            icbc1.setImgstep5_3s(l.toString());
         }
		 //签约1分钟视频 
		 if(signvideo!=null&&!signvideo.equals("")){
		 if (!signvideo.isEmpty()) {  
			String filename = signvideo.getOriginalFilename();
			String prefix=filename.substring(filename.lastIndexOf(".")+1);
			String path = filePath
				+"/signvideo/"+creditutil.timefile()+"/"+creditutil.timefiles()+"sv."+prefix;
			byte[] file36Byte =signvideo.getBytes();
			FileUtils.writeByteArrayToFile(new File(path),file36Byte);
			icbc1.setImgstep5_4v(imgpath+"signvideo/"+creditutil.timefile()+"/"+creditutil.timefiles()+"sv."+prefix);
		 }
		 }
		    icbc1.setBc_status(2); 
	        icbc1.setDt_edit(creditutil.time());
	        icbcservice.upicbc(icbc1);       
	        ir.setDt_add(creditutil.time());
	        ir.setDt_edit(creditutil.time());
	        ir.setMid_add(0);
	        ir.setMid_edit(0); 
	        ir.setRemark("提交开卡家访材料信息");
	        ir.setStatus(2);        
	        icbc_resultServices.addicbc_result(ir);
	        JSONObject result=new JSONObject();
			result.put("result",orderid);
			result.put("msg","成功");
			result.put("code","200");
			return result.toString();
	}
	
	/**
	 * 补充材料
	 * @param ckey
	 * @param orderid
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/supplyMaterial.do",produces="text/html;charset=UTF-8")	
	@ResponseBody
	public String supplyMaterial(
			String ckey,
			String orderid,
			@RequestParam("carbill")MultipartFile carbill,//车辆发票
			@RequestParam("carbillOnline")MultipartFile carbillOnline,//车辆发票网上查询
			@RequestParam("rctp")MultipartFile rctp,//登记证书转产页
			@RequestParam("mcontract")MultipartFile mcontract,//分期付款/抵押合同
			@RequestParam("vacrs")MultipartFile[] vacrs,//新增补充材料(车辆和合同相关)
		HttpServletRequest request,HttpServletResponse response) throws IOException{
		String filePath = "/opt/javaimg/image/upload/img";
        String imgpath="http://apitest.kcway.net/image/upload/img/";
        // 响应客户端  
        response.setContentType("text/html;UTF-8"); 
        if(ckey!=null&&!ckey.equals("")){
			jbzxapiuser jau=jbzxapiuserservice.findapiuserbyappkey(ckey);
			if(jau==null||jau.equals("")){
				JSONObject result=new JSONObject();
				result.put("result","");
				result.put("msg","ckey错误");
				result.put("code","211");
				return result.toString();		
			}
		}else{
			JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","ckey不能为空");
			result.put("code","210");
			return result.toString();	
		}
        icbc icbc1=new icbc();
        icbc_result ir=new icbc_result();
		if(orderid!=null&&!orderid.equals("")){
        	icbc icbc=icbcservice.findicbcbyorderid(orderid);
        	icbc1.setId(icbc.getId());
        	ir.setQryid(icbc.getId());
            if(icbc==null||icbc.equals("")){
            	JSONObject result=new JSONObject();
    			result.put("result","");
    			result.put("msg","订单编号错误");
    			result.put("code","212");
    			return result.toString();
            }	
        }else{
        	JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","orderid不能为空");
			result.put("code","210");
			return result.toString();
        }
		//车辆发票
		if(carbill!=null&&!carbill.equals("")){
		if (!carbill.isEmpty()) {  
			String filename = carbill.getOriginalFilename();
			String prefix=filename.substring(filename.lastIndexOf(".")+1);
			String path = filePath
				+"/carbill/"+creditutil.timefile()+"/"+creditutil.timefiles()+"cb."+prefix;
			byte[] file36Byte =carbill.getBytes();
			FileUtils.writeByteArrayToFile(new File(path),file36Byte);
			icbc1.setImgstep6_1(imgpath+"carbill/"+creditutil.timefile()+"/"+creditutil.timefiles()+"cb."+prefix);
		}
		}
		//车辆发票网上查询
		if(carbillOnline!=null&&!carbillOnline.equals("")){
		if (!carbillOnline.isEmpty()) {  
			String filename = carbillOnline.getOriginalFilename();
			String prefix=filename.substring(filename.lastIndexOf(".")+1);
			String path = filePath
				+"/carbillOnline/"+creditutil.timefile()+"/"+creditutil.timefiles()+"cbo."+prefix;
			byte[] file36Byte =carbillOnline.getBytes();
			FileUtils.writeByteArrayToFile(new File(path),file36Byte);
			icbc1.setImgstep6_2(imgpath+"carbillOnline/"+creditutil.timefile()+"/"+creditutil.timefiles()+"cbo."+prefix);
		}
		}
		//登记证书转产页
		if(rctp!=null&&!rctp.equals("")){
		if (!rctp.isEmpty()) {  
			String filename = rctp.getOriginalFilename();
			String prefix=filename.substring(filename.lastIndexOf(".")+1);
			String path = filePath
				+"/rctp/"+creditutil.timefile()+"/"+creditutil.timefiles()+"rt."+prefix;
			byte[] file36Byte =rctp.getBytes();
			FileUtils.writeByteArrayToFile(new File(path),file36Byte);
			icbc1.setImgstep6_3(imgpath+"rctp/"+creditutil.timefile()+"/"+creditutil.timefiles()+"rt."+prefix);
		}
		}
		//分期付款/抵押合同
		if(mcontract!=null&&!mcontract.equals("")){
		if (!mcontract.isEmpty()) {  
			String filename = mcontract.getOriginalFilename();
			String prefix=filename.substring(filename.lastIndexOf(".")+1);
			String path = filePath
				+"/mcontract/"+creditutil.timefile()+"/"+creditutil.timefiles()+"mt."+prefix;
			byte[] file36Byte =mcontract.getBytes();
			FileUtils.writeByteArrayToFile(new File(path),file36Byte);
			icbc1.setImgstep6_4(imgpath+"mcontract/"+creditutil.timefile()+"/"+creditutil.timefiles()+"mt."+prefix);
		}
		}
		//新增补充材料(车辆和合同相关)
		if (vacrs!=null&&vacrs.length>0) {  
        	List l=new ArrayList<>();
        	for(int i=0;i<vacrs.length;i++){
        		MultipartFile file=vacrs[i];
        		String filename = file.getOriginalFilename();
        	    String prefix=filename.substring(filename.lastIndexOf(".")+1);
        		String path = filePath+"/vacrs/"+creditutil.timefile()+"/"+creditutil.timefiles()+i+"vcs."+prefix;
                byte[] file36Byte = file.getBytes();
                FileUtils.writeByteArrayToFile(new File(path),file36Byte);
                // System.out.println(imgpath+"addsuppily/"+creditutil.timefile()+"/"+UUIDTool.getUUID()+i+"."+prefix);
        	    l.add(imgpath+"vacrs/"+creditutil.timefile()+"/"+creditutil.timefiles()+i+"vcs."+prefix);
        	}  
            icbc1.setImgstep6_5s(l.toString());
         }
		icbc1.setBc_status(2); 
        icbc1.setDt_edit(creditutil.time());
        icbcservice.upicbc(icbc1);       
        ir.setDt_add(creditutil.time());
        ir.setDt_edit(creditutil.time());
        ir.setMid_add(0);
        ir.setMid_edit(0);       
        ir.setRemark("提交开卡补充材料信息");
        ir.setStatus(2);        
        icbc_resultServices.addicbc_result(ir);
        JSONObject result=new JSONObject();
		result.put("result",orderid);
		result.put("msg","成功");
		result.put("code","200");
		return result.toString();
	}
	
	
	@Autowired
	private com.service.icbc.assess_carsService assess_carsService;
	/**
	 * 
	 * @param ckey
	 * @param orderid
	 * @return
	 */
	@RequestMapping(value="/orderState.do",produces="text/html;charset=UTF-8")	
	@ResponseBody
	public String orderState(
			String ckey,
			String orderid
			){
		if(ckey!=null&&!ckey.equals("")){
			jbzxapiuser jau=jbzxapiuserservice.findapiuserbyappkey(ckey);
			if(jau==null||jau.equals("")){
				JSONObject result=new JSONObject();
				result.put("result","");
				result.put("msg","ckey错误");
				result.put("code","211");
				return result.toString();		
			}
		}else{
			JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","ckey不能为空");
			result.put("code","210");
			return result.toString();	
		}
        icbc_result ir=new icbc_result();
		if(orderid!=null&&!orderid.equals("")){
        	icbc_zx icbc_zx=new icbc_zx();
        	icbc_zx=icbc_zxService.findicbc_zx(orderid);             	
            if(icbc_zx!=null&&!icbc_zx.equals("")){
            	icbc_preaudit iPreaudit=icbc_preauditService.findpreauditbyorder(icbc_zx.getId());	
            	assess_cars ac=assess_carsService.findcarsbyorder(icbc_zx.getId());
            	icbc_kk iKk=icbc_kkService.findicbc_kkbyorder(icbc_zx.getId());
            	icbc_cardk icbc_cardk=icbc_cardkService.findicbc_cardk(icbc_zx.getId());
            	List<JSONObject> jbList=new ArrayList<>();
            	if(iPreaudit!=null&&!iPreaudit.equals("")){
            		JSONObject state1=new JSONObject();                	
                	state1.put("msg","汽车预评估");            	                	          		
                	state1.put("state",iPreaudit.getBc_status());   
                	jbList.add(state1);
            	}
            	if(ac!=null&&!ac.equals("")){
            		JSONObject state2=new JSONObject();                	
                	state2.put("msg","汽车专业评估");            	                	          		
                	state2.put("state",ac.getBc_status());
                	jbList.add(state2);
            	}
            	if(iKk!=null&&!iKk.equals("")){
            		JSONObject state3=new JSONObject();                	
                	state3.put("msg","开卡申请");            	                	          		
                	state3.put("state",iKk.getBc_status());
                	jbList.add(state3);
            	}
            	if(icbc_cardk!=null&&!icbc_cardk.equals("")){
            		JSONObject state4=new JSONObject();                	
                	state4.put("msg","汽车贷款");            	                	          		
                	state4.put("state",icbc_cardk.getBc_status());
                	jbList.add(state4);
            	}
            	JSONObject state=new JSONObject();
            	state.put("orderid",orderid);
            	state.put("msg","征信");
            	state.put("state",icbc_zx.getBc_status());            	
            	jbList.add(state);           	
            	JSONObject result=new JSONObject();
        		result.put("result",jbList);
        		result.put("msg","成功");
        		result.put("code","200");
        		return result.toString();            		        		
            }else{
            	JSONObject result=new JSONObject();
    			result.put("result","");
    			result.put("msg","订单编号错误");
    			result.put("code","212");
    			return result.toString();
            }	
        }else{
        	JSONObject result=new JSONObject();
			result.put("result","");
			result.put("msg","orderid不能为空");
			result.put("code","210");
			return result.toString();
        }
	}
	
	
	
	public static void main(String[] args) {
		 Date date = new Date(); 
		 UUID uuid = UUID.randomUUID();
		String subFolder="C:/Users/Administrator/Desktop/carsassess/"+new SimpleDateFormat("yyyy/MM/dd/").format(date);
System.out.println(uuid);


//		List l=new ArrayList<>();
//		for(int k=0;k<10;k++){
//			l.add("i"+k);
//		}
//		System.out.println(l);
//		float price=(float) 1.2123;
//		DecimalFormat decimalFormat=new DecimalFormat(".00");
//        System.out.println(decimalFormat.format(price));
//        String s="0";
//        if(s!=null&&!s.equals("")){
//        System.out.println(s);	
//        }else{
//        	System.out.println("kong");
//        }
	
//		BigDecimal b1 = new BigDecimal("10.2");   
//		BigDecimal b2 = new BigDecimal("2.2"); 
//		BigDecimal b3 = new BigDecimal("10");
//		               System.out.println();
//	    System.out.println(new BigDecimal("10").compareTo(new BigDecimal(b1.add(b2).doubleValue())));
	}
	
	 //性能最高的方法
    public static String testStringBuilder(int sl) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<sl; i++) {
            sb.append(0);
        }
        return sb.toString();        
    }
}
