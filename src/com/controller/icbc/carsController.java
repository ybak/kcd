package com.controller.icbc;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import com.controller.icbc.util.carsAssess;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.model.icbc.assess_cars;
import com.model.icbc.assess_cars_item;
import com.model.icbc.bclient_check;
import com.model.icbc.icbc_zx;
import com.model.jbapi.jbzxapiuser;
import com.model1.carbrand;
import com.model1.carmodel;
import com.model1.carseries;
import com.model1.gems;
import com.service.cars.bx_resultService;
import com.service.cars.bx1Service;
import com.service.icbc.assess_carsService;
import com.service.icbc.assess_cars_itemService;
import com.service.icbc.assess_carspgService;
import com.service.icbc.assess_colorService;
import com.service.icbc.bclient_checkService;
import com.service.icbc.icbcService;
import com.service.icbc.icbc_zxService;
import com.service.zx.jbzxapiuserService;
import com.service1.gemsService;
import com.service1.car.brandService;
import com.service1.car.seriesService;
import com.service1.duoying.carmodelService;
import com.util.Base64Test;
import com.util.creditutil;

@Controller
public class carsController {
 private static final String filePath = "/opt/javaimg/image/upload/img";
	  @Autowired
	  private assess_carspgService assess_carspgService;
	  @Autowired
	  private assess_carsService assess_carsService;
	  @Autowired
	  private assess_cars_itemService assess_cars_itemService;
	  @Autowired
	  private assess_colorService assess_colorService;
	  @Autowired
	  private jbzxapiuserService jbzxapiuserService;
	  @Autowired
	  private icbcService icbcservice;
	  @Autowired
	  private brandService brandService;
	  @Autowired
	  private seriesService seriesService;
	  @Autowired
	  private carmodelService carmodelService;
	  @Autowired
	  private bx_resultService bx_resultService;
	  @Autowired
	  private bx1Service bx1Service;
	    //保险
//		@RequestMapping(value="/query_bx.do",produces="application/json;charset=UTF-8")  
//		@ResponseBody
//		public String query_bx(
//				String ckey,
//				String vin
//				){
//			jbzxapiuser jau=jbzxapiuserService.findapiuserbyappkey(ckey);
//			if(ckey!=null&&!ckey.equals("")){
//				if(jau!=null&&!jau.equals("")){	
//			bx1 bx=new bx1();
//			bx.setDt_add(creditutil.time());
//			bx.setDt_edit(creditutil.time());
//			bx.setBc_status(0);
//			bx.setGems_id(jau.getId());
//			bx.setC_carvin(vin);
//			bx.setGems_code("BXKCD");
//			bx1Service.addbx1(bx);	
//			}else{
//					JSONObject result=new JSONObject();
//	    			result.put("result","");
//	    			result.put("msg","ckey错误");
//	    			result.put("code","212");
//	    			return result.toString();
//			}			
//			}else {
//				JSONObject result=new JSONObject();
//    			result.put("result","");
//    			result.put("msg","ckey不能为空");
//    			result.put("code","210");
//    			return result.toString();
//			}
//			
//			 return vin;
//		}
//	     
	     @Autowired
	     private gemsService gemsService;
	     //查询评估详情
		@RequestMapping(value="/querycars.do",produces="application/json;charset=UTF-8")  
		@ResponseBody
		public String querycars(
				String ckey,
	            String orderid){
			assess_cars ac;
			if(orderid!=null&&!orderid.equals("")){
	        	ac=assess_carsService.findcarsbycode(orderid);
	            if(ac==null||ac.equals("")){
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
			jbzxapiuser jau=jbzxapiuserService.findapiuserbyappkey(ckey);
			if(ckey!=null&&!ckey.equals("")){
				if(jau!=null&&!jau.equals("")){
					JSONObject bg=new JSONObject(); 
					bg.put("orderid",orderid);					
					if(ac.getBc_status()==3){							
					    carbrand carbrand=brandService.findbrandbyid(ac.getBrid());
						carseries carseries= seriesService.findseriesbyid(ac.getSeid()); 
						bclient_check bc=bclient_checkService.findassess_msg(3,ac.getId()); 
						if(carseries!=null&&!carseries.equals("")){
					    bg.put("car_type",carseries.getTp_title());	
					    }else{
					    bg.put("car_type","");	
					    }
						if(bc!=null&&!bc.equals("")){
							bg.put("result_msg",bc.getRemark());	
						}else{
							bg.put("result_msg","");	
						}
					    if(carbrand!=null
					    		&&!carbrand.equals("")
					    		&&carseries!=null
					    		&&!carseries.equals("")
					    		){
					    bg.put("brand_type",carbrand.getName()+"-"+carseries.getName());					   
					    }else{
						bg.put("brand_type","");	
						}
					    
					    bg.put("price_result",ac.getPrice_result());					    
					    bg.put("motorcode",ac.getMotorcode());					    				    
					    bg.put("VINcode", ac.getVincode());
					    if(ac.getBc_type()==1){
					    	Map gems=gemsService.selectname(ac.getGems_id());
					    	bg.put("dt_edit",ac.getDt_edit());
					    	bg.put("kj_logo","http://a.kcway.net/assess/manager/images/cb.png");
					    	if(gems!=null&&!gems.equals("")){
					        bg.put("pg_name",gems.get("name"));	
					    	}else{
					    	bg.put("pg_name","");		
					    	}					    	
					    }
					}
					bg.put("status",ac.getBc_status());
				    bg.put("query_type",ac.getBc_type());				    
					JSONObject result=new JSONObject();
	    			result.put("result",bg);
	    			result.put("msg","成功");
	    			result.put("code","200");
	    			return result.toString();										
				}else{
					JSONObject result=new JSONObject();
	    			result.put("result","");
	    			result.put("msg","ckey错误");
	    			result.put("code","212");
	    			return result.toString();
				}			
			}else {
				JSONObject result=new JSONObject();
    			result.put("result","");
    			result.put("msg","ckey不能为空");
    			result.put("code","210");
    			return result.toString();
			}
		}
		
		

		
		
		@RequestMapping(value="/carslibrary.do",produces="application/json;charset=UTF-8")  
		@ResponseBody
		public String carslibrary(String ckey){
          List<JSONObject> brandjb=new ArrayList<>();
          List<JSONObject> modeljb=new ArrayList<>();
          List<JSONObject> seriesjb=new ArrayList<>();
		 jbzxapiuser jau=jbzxapiuserService.findapiuserbyappkey(ckey);
			if(ckey!=null&&!ckey.equals("")){
			if(jau!=null&&!jau.equals("")){
				 List<carbrand> cbl=brandService.findbrand();
				 List<carmodel> carmodels=carmodelService.findcarmodel();
				 List<carseries> carseries=seriesService.findseries();
				 for(carbrand cb : cbl){
					 JSONObject brands=new JSONObject();
					 brands.put("brand_id", cb.getId());
					 brands.put("brand_name", cb.getName());
					 brands.put("brand_ei", cb.getFirst());
					 brandjb.add(brands);
				 }
				 for(carmodel cm : carmodels){
					 JSONObject models=new JSONObject();
					 models.put("brand_id", cm.getBrand_id());
					 models.put("series_id ",cm.getSeries_id());
					 models.put("model_id",cm.getId());
					 models.put("model_name",cm.getName());
					 modeljb.add(models);
				 }
				 for(carseries css : carseries){
					 JSONObject seriess=new JSONObject();
					 seriess.put("brand_id", css.getBrand_id());
					 seriess.put("series_id",css.getId());
					 seriess.put("series_name",css.getName());
					 seriesjb.add(seriess);
				 }
				 JSONObject cars=new JSONObject();
				 cars.put("seriess",seriesjb);
				 cars.put("models", modeljb);
				 cars.put("brands", brandjb);
				 JSONObject result=new JSONObject();
	    		 result.put("result",cars);
	    		 result.put("msg","成功");
	    		 result.put("code","200");
	    		 return result.toString();
			}else{
				JSONObject result=new JSONObject();
    			result.put("result","");
    			result.put("msg","ckey错误");
    			result.put("code","212");
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
	  @Autowired
	  private icbc_zxService icbc_zxService;
	  @Autowired
	  private bclient_checkService bclient_checkService;
	  
	  
	  
	  
	@RequestMapping(value="/carsAssess.do",produces="multipart/form-data;charset=UTF-8")  
	@ResponseBody
	public String carsAssess(
			String mileage,//表显里程			
            String ckey,
            String orderid,
            String querytype,//查询类型           
            String oncarddate,//上牌时间
            String vin,//vin 
            @RequestParam("imgs")MultipartFile[] imgs,
            HttpServletRequest request,
            HttpServletResponse response
			) throws IOException{		
		//response.setContentType("application/json;charset=UTF-8");//防止数据传递乱码
		//request.setCharacterEncoding("UTF-8");
		//System.out.println(request.getCharacterEncoding());
		String oredit=request.getParameter("oredit");//是否编辑此订单  1是 /2否 默认为否 
		String carcolor = null;
		//System.out.println(carcolor);
		int brand_id= 0;
		int series_id= 0;
		int model_id= 0;
		String province= null;
		String city= null;
		System.out.println(request.getParameter("carcolor"));
		if(request.getParameter("carcolor")!=null&&!request.getParameter("carcolor").equals("")){
			//车身颜色
			carcolor=request.getParameter("carcolor");
		    System.out.println(carcolor);
		   
		}
		if(request.getParameter("brand_id")!=null
				&&!request.getParameter("brand_id").equals("")
				&&!request.getParameter("series_id").equals("")
				&&!request.getParameter("model_id").equals("")
				&&request.getParameter("model_id")!=null
				&&request.getParameter("series_id")!=null
				){
			//车型
			brand_id=Integer.parseInt(request.getParameter("brand_id"));	
			series_id=Integer.parseInt(request.getParameter("series_id"));	
			model_id=Integer.parseInt(request.getParameter("model_id"));	
		}
		if(request.getParameter("province")!=null&&!request.getParameter("province").equals("")){
		//所在省
		    province=request.getParameter("province");			
		}
		if(request.getParameter("city")!=null&&!request.getParameter("city").equals("")){
	     //所在市
	        city=request.getParameter("city");			
		}
        icbc_zx icbc=new icbc_zx();
        if(orderid!=null&&!orderid.equals("")){
        	icbc=icbc_zxService.findicbc_zx(orderid);
            if(icbc==null||icbc.equals("")){
            	JSONObject result=new JSONObject();
    			result.put("result","");
    			result.put("msg","订单编号错误");
    			result.put("code","212");
    			return result.toString();
            }	
          }
        String imgpath="http://apitest.kcway.net/image/upload/img/";
		jbzxapiuser jau=jbzxapiuserService.findapiuserbyappkey(ckey);
		if(ckey!=null&&!ckey.equals("")){
		if(jau!=null&&!jau.equals("")){
			String money=jau.getApi_money();			
			if(money!=null&&!money.equals("")){
				BigDecimal b1 = new BigDecimal(money);
				BigDecimal b2 = null;
				if(querytype.equals("0")){
					b2 = new BigDecimal("30");
				}
				if(querytype.equals("1")){
					b2 = new BigDecimal("200");
				}				
				if(b1.subtract(b2).doubleValue()>0){
					String newmoney=b1.subtract(b2).toString();
					assess_cars ac=new assess_cars();
					ac.setCar_km(Integer.parseInt(mileage));
					ac.setColor_id(Integer.parseInt(carcolor));
					//ac.setGems_code("");
					ac.setDt_add(creditutil.time());
					ac.setDt_edit(creditutil.time());
					ac.setBc_status(2);
					ac.setBc_type(Integer.parseInt(querytype));
					ac.setMem_name(jau.getApi_name());
					ac.setMem_id(jau.getId());
					if(querytype.equals("1")){
						if(brand_id!=0&&
								series_id!=0&&
								model_id!=0){
							ac.setCarid(model_id);
							ac.setBrid(brand_id);
							ac.setSeid(series_id);
						}else{
							JSONObject result=new JSONObject();
							result.put("result","");
							result.put("msg","车型不能为空");
							result.put("code","210");
							return result.toString();
						}
						if(oncarddate!=null&&!oncarddate.equals("")){
							ac.setCar_days(oncarddate);
						}else{
							JSONObject result=new JSONObject();
							result.put("result","");
							result.put("msg","上牌时间不能为空");
							result.put("code","210");
							return result.toString();
						}
						if(province!=null&&!province.equals("")){
							ac.setMem_states(Integer.parseInt(province));
						}else{
							JSONObject result=new JSONObject();
							result.put("result","");
							result.put("msg","省份不能为空");
							result.put("code","210");
							return result.toString();
						}
						if(city!=null&&!city.equals("")){
							ac.setMem_citys(Integer.parseInt(city));
						}else{
							JSONObject result=new JSONObject();
							result.put("result","");
							result.put("msg","城市不能为空");
							result.put("code","210");
							return result.toString();
						}
						if(vin!=null&&!vin.equals("")){
							ac.setVincode(vin);
						}else{
							JSONObject result=new JSONObject();
							result.put("result","");
							result.put("msg","车辆vin不能为空");
							result.put("code","210");
							return result.toString();
						}
						
					}					
					if(icbc!=null&&!icbc.equals("")){
						ac.setOrderid(icbc.getId());
					}	
					if (imgs!=null&&imgs.length>0) {
						for(int i=0;i<imgs.length;i++){
						if(imgs[i].getSize()==0){
							JSONObject result=new JSONObject();
							result.put("result","");
							result.put("msg","照片不能为空");
							result.put("code","210");
							return result.toString();	
						}
						}
					}else{
						JSONObject result=new JSONObject();
						result.put("result","");
						result.put("msg","照片不能为空");
						result.put("code","210");
						return result.toString();
					}
					bclient_check bclient_check=new bclient_check();
				       bclient_check.setDt_add(creditutil.time());
				       bclient_check.setDt_edit(creditutil.time());
				       bclient_check.setMid_edit(jau.getId());				       
				       bclient_check.setStatus(2);
					assess_cars aCars = null;
					if(orderid!=null&&!orderid.equals("")){
					aCars=assess_carsService.findcarsbyorder(icbc.getId());
					}
					if(aCars!=null&&!aCars.equals("")){
						if(oredit!=null&&!oredit.equals("")&&oredit.equals("1")){
							ac.setId(aCars.getId());
							assess_carsService.upcodebyid(ac);
							bclient_check.setAssessid(aCars.getId());
							bclient_check.setRemark("编辑专业评估查询");
							bclient_checkService.addbclient_check(bclient_check);
							JSONObject result=new JSONObject();
							result.put("result",orderid);
							result.put("msg","编辑成功");
							result.put("code","200");
							return result.toString();
						}else{
							JSONObject result=new JSONObject();
							result.put("result","");
							result.put("msg","已有专业评估订单");
							result.put("code","214");
							return result.toString();	
						}						
					}else{
					   assess_carsService.addassess_cars(ac);
					   bclient_check.setRemark("提交专业评估查询");
					   bclient_check.setAssessid(ac.getId());
					}	

					if (imgs!=null&&imgs.length>0) {				    	    
				        	List l=new ArrayList<>();
				        	for(int i=0;i<imgs.length;i++){
				        		assess_cars_item aci=new assess_cars_item();
				        		UUID randomUUID = UUID.randomUUID();
				        		String uuidName = randomUUID.toString().replaceAll("-","");				        		
				        		MultipartFile file=imgs[i];
				        		//System.out.println(file.getSize()+"--------");
				        		if(file.getSize()>0){
				        		String filename = file.getOriginalFilename();				        		
				        	    //String prefix=filename.substring(filename.lastIndexOf(".")+1);
				        	    FileUploadTool fut=new FileUploadTool();
				        	    String prefix=fut.getFileExt(filename);
				        	    String path ="/opt/javaimg/image/upload/img/carsassess/"
				        				+creditutil.timefile()+"/"+uuidName+prefix;
				        	    if(fut.checkMediaType(prefix)){
				        	    	File f = new File(path);
				                    if (!f.exists()) {
				                        f.mkdirs();
				                    }
				                    file.transferTo(new File(path));
				        	    }else{
				        	    	byte[] file36Byte = file.getBytes();
					                FileUtils.writeByteArrayToFile(new File(path),file36Byte);	
				        	    }
				                //System.out.println(imgpath+"suppily/"+creditutil.timefile()+UUIDTool.getUUID()+i+"."+prefix);
				        	    //l.add(imgpath+"carsassess/"+creditutil.timefile()+"/"+uuidName+"."+prefix);				        	    
				        		aci.setBcimg(imgpath+"carsassess/"+creditutil.timefile()+"/"+uuidName+prefix);
				        		aci.setCars_id(ac.getId());
				        	    aci.setPoints_id(i+1);
				        		assess_cars_itemService.addcarsitem(aci);			        			
			        		    }else{
						        	JSONObject result=new JSONObject();
									result.put("result","");
									result.put("msg","照片不能为空");
									result.put("code","210");
									return result.toString();
						        }
				        	}  		        
				        }else{
				        	JSONObject result=new JSONObject();
							result.put("result","");
							result.put("msg","照片不能为空");
							result.put("code","210");
							return result.toString();
				        }
					   bclient_checkService.addbclient_check(bclient_check);
				       assess_cars ac1=new assess_cars();
				       ac1.setId(ac.getId());
				       ac1.setCode("KJ"+testStringBuilder(7-String.valueOf(ac.getId()).length())+ac.getId());
				       assess_carsService.upcodebyid(ac1);
				       jbzxapiuser jbzxapiuser=new jbzxapiuser();
				       jbzxapiuser.setId(jau.getId());
				       jbzxapiuser.setApi_money(newmoney);
				       jbzxapiuserService.upmoney(jbzxapiuser);
				       JSONObject result=new JSONObject();
					   result.put("result",orderid);
					   result.put("msg","成功");
					   result.put("code","200");
					   return result.toString();
					
				}else{
					JSONObject result=new JSONObject();
					result.put("result","");
					result.put("msg","余额不足");
					result.put("code","213");
					return result.toString();
				}
			}else{
				JSONObject result=new JSONObject();
				result.put("result","");
				result.put("msg","余额不足");
				result.put("code","213");
				return result.toString();
			}
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
	/**
	 * 评估 专业 json格式
	 * @param mileage
	 * @param ckey
	 * @param orderid
	 * @param querytype
	 * @param oncarddate
	 * @param vin
	 * @param imgs
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/carsAssess_1.do",produces="application/json;charset=UTF-8")  
	@ResponseBody
	public String carsAssess_1(
			@RequestBody carsAssess carsAssess//表显里程		
			) throws IOException{		
		//response.setContentType("application/json;charset=UTF-8");//防止数据传递乱码
		//request.setCharacterEncoding("UTF-8");
		//System.out.println(request.getCharacterEncoding());
		//String oredit=request.getParameter("oredit");//是否编辑此订单  1是 /2否 默认为否 
		String carcolor = null;
		System.out.println(carsAssess.getCkey());
		int brand_id= 0;
		int series_id= 0;
		int model_id= 0;
		String province= null;
		String city= null;
		if(carsAssess.getCarcolor()!=null&&!carsAssess.getCarcolor().equals("")){
			//车身颜色
			carcolor=carsAssess.getCarcolor();
		    //System.out.println(carcolor);
		   
		}
		if(carsAssess.getBrand_id()!=null
				&&!carsAssess.getBrand_id().equals("")
				&&!carsAssess.getSeries_id().equals("")
				&&!carsAssess.getBrand_id().equals("")
				&&carsAssess.getModel_id()!=null
				&&carsAssess.getSeries_id()!=null
				){
			//车型
			brand_id=Integer.parseInt(carsAssess.getBrand_id());	
			series_id=Integer.parseInt(carsAssess.getSeries_id());	
			model_id=Integer.parseInt(carsAssess.getModel_id());	
		}
		if(carsAssess.getProvince()!=null&&!carsAssess.getProvince().equals("")){
		//所在省
		    province=carsAssess.getProvince();			
		}
		if(carsAssess.getCity()!=null&&!carsAssess.getCity().equals("")){
	     //所在市
	       city=carsAssess.getCity();			
		}
        icbc_zx icbc=new icbc_zx();
        if(carsAssess.getOrderid()!=null&&!carsAssess.getOrderid().equals("")){
        	icbc=icbc_zxService.findicbc_zx(carsAssess.getOrderid());
            if(icbc==null||icbc.equals("")){
            	JSONObject result=new JSONObject();
    			result.put("result","");
    			result.put("msg","订单编号错误");
    			result.put("code","212");
    			return result.toString();
            }	
          }
        String imgpath="http://apitest.kcway.net/image/upload/img/";
		jbzxapiuser jau=jbzxapiuserService.findapiuserbyappkey(carsAssess.getCkey());
		if(carsAssess.getCkey()!=null&&!carsAssess.getCkey().equals("")){
		if(jau!=null&&!jau.equals("")){
			String money=jau.getApi_money();			
			if(money!=null&&!money.equals("")){
				BigDecimal b1 = new BigDecimal(money);
				BigDecimal b2 = null;
				if(carsAssess.getQuerytype().equals("0")){
					b2 = new BigDecimal("30");
				}
				if(carsAssess.getQuerytype().equals("1")){
					b2 = new BigDecimal("200");
				}				
				if(b1.subtract(b2).doubleValue()>0){
					String newmoney=b1.subtract(b2).toString();
					assess_cars ac=new assess_cars();
					ac.setCar_km(Integer.parseInt(carsAssess.getMileage()));
					ac.setColor_id(Integer.parseInt(carcolor));
					//ac.setGems_code("");
					ac.setDt_add(creditutil.time());
					ac.setDt_edit(creditutil.time());
					ac.setBc_status(2);
					ac.setBc_type(Integer.parseInt(carsAssess.getQuerytype()));
					ac.setMem_name(jau.getApi_name());
					ac.setMem_id(jau.getId());
					if(carsAssess.getQuerytype().equals("1")){
						if(brand_id!=0&&
								series_id!=0&&
								model_id!=0){
							ac.setCarid(model_id);
							ac.setBrid(brand_id);
							ac.setSeid(series_id);
						}else{
							JSONObject result=new JSONObject();
							result.put("result","");
							result.put("msg","车型不能为空");
							result.put("code","210");
							return result.toString();
						}
						if(carsAssess.getOncarddate()!=null&&!carsAssess.getOncarddate().equals("")){
							ac.setCar_days(carsAssess.getOncarddate());
						}else{
							JSONObject result=new JSONObject();
							result.put("result","");
							result.put("msg","上牌时间不能为空");
							result.put("code","210");
							return result.toString();
						}
						if(carsAssess.getProvince()!=null&&!carsAssess.getProvince().equals("")){
							ac.setMem_states(Integer.parseInt(carsAssess.getProvince()));
						}else{
							JSONObject result=new JSONObject();
							result.put("result","");
							result.put("msg","省份不能为空");
							result.put("code","210");
							return result.toString();
						}
						if(city!=null&&!city.equals("")){
							ac.setMem_citys(Integer.parseInt(city));
						}else{
							JSONObject result=new JSONObject();
							result.put("result","");
							result.put("msg","城市不能为空");
							result.put("code","210");
							return result.toString();
						}
						if(carsAssess.getVin()!=null&&!carsAssess.getVin().equals("")){
							ac.setVincode(carsAssess.getVin());
						}else{
							JSONObject result=new JSONObject();
							result.put("result","");
							result.put("msg","车辆vin不能为空");
							result.put("code","210");
							return result.toString();
						}
						
					}					
					if(icbc!=null&&!icbc.equals("")){
						ac.setOrderid(icbc.getId());
					}	
					if (carsAssess.getImgs()!=null&&carsAssess.getImgs().size()>0) {
						for(int i=0;i<carsAssess.getImgs().size();i++){
							String img=carsAssess.getImgs().get(i);
						if(img.length()==0){
							JSONObject result=new JSONObject();
							result.put("result","");
							result.put("msg","照片不能为空");
							result.put("code","210");
							return result.toString();	
						}
						}
					}else{
						JSONObject result=new JSONObject();
						result.put("result","");
						result.put("msg","照片不能为空");
						result.put("code","210");
						return result.toString();
					}
					bclient_check bclient_check=new bclient_check();
				       bclient_check.setDt_add(creditutil.time());
				       bclient_check.setDt_edit(creditutil.time());
				       bclient_check.setMid_edit(jau.getId());				       
				       bclient_check.setStatus(2);
					assess_cars aCars = null;
					if(carsAssess.getOrderid()!=null&&!carsAssess.getOrderid().equals("")){
					aCars=assess_carsService.findcarsbyorder(icbc.getId());
					}
					if(aCars!=null&&!aCars.equals("")){
						if(carsAssess.getOrderid()!=null&&
								!carsAssess.getOrderid().equals("")&&
								carsAssess.getOrderid().equals("1")){
							ac.setId(aCars.getId());
							assess_carsService.upcodebyid(ac);
							bclient_check.setAssessid(aCars.getId());
							bclient_check.setRemark("编辑专业评估查询");
							bclient_checkService.addbclient_check(bclient_check);
							JSONObject result=new JSONObject();
							result.put("result",carsAssess.getOrderid());
							result.put("msg","编辑成功");
							result.put("code","200");
							return result.toString();
						}else{
							JSONObject result=new JSONObject();
							result.put("result","");
							result.put("msg","已有专业评估订单");
							result.put("code","214");
							return result.toString();	
						}						
					}else{
					   assess_carsService.addassess_cars(ac);
					   bclient_check.setRemark("提交专业评估查询");
					   bclient_check.setAssessid(ac.getId());
					}	
					
					if (carsAssess.getImgs()!=null&&carsAssess.getImgs().size()>0) {				    	    
				        	List l=new ArrayList<>();
				        	for(int i=0;i<carsAssess.getImgs().size();i++){
				        		assess_cars_item aci=new assess_cars_item();
				        		UUID randomUUID = UUID.randomUUID();
				        		String uuidName = randomUUID.toString().replaceAll("-","");				        		
				        		//System.out.println(file.getSize()+"--------");				        						        						        		
				        	    //String prefix=filename.substring(filename.lastIndexOf(".")+1);				       	   
				        	    String prefix=".jpg";
				        	    String newpath="/opt/javaimg/image/upload/img/carsassess/"+creditutil.timefile();
				        	    String path ="C:/Users/Administrator/Desktop/carsassess/"
				        				+creditutil.timefile();	
				        	    File f = new File(newpath);
			                    if (!f.exists()) {
			                        f.mkdirs();
			                    }
				        	    Base64Test.decodeBase64ToImage(carsAssess.getImgs().get(i),newpath,uuidName+prefix);
				                //System.out.println(imgpath+"suppily/"+creditutil.timefile()+UUIDTool.getUUID()+i+"."+prefix);
				        	    //l.add(imgpath+"carsassess/"+creditutil.timefile()+"/"+uuidName+"."+prefix);				        	    
				        		aci.setBcimg(imgpath+"carsassess/"+creditutil.timefile()+"/"+uuidName+prefix);
				        		aci.setImgbase64(carsAssess.getImgs().get(i));
				        		aci.setCars_id(ac.getId());
				        	    aci.setPoints_id(i+1);
				        		assess_cars_itemService.addcarsitem(aci);			        			
				        	}  		        
				        }else{
				        	JSONObject result=new JSONObject();
							result.put("result","");
							result.put("msg","照片不能为空");
							result.put("code","210");
							return result.toString();
				        }
					   bclient_checkService.addbclient_check(bclient_check);
				       assess_cars ac1=new assess_cars();
				       ac1.setId(ac.getId());
				       ac1.setCode("KJ"+testStringBuilder(7-String.valueOf(ac.getId()).length())+ac.getId());
				       assess_carsService.upcodebyid(ac1);
				       jbzxapiuser jbzxapiuser=new jbzxapiuser();
				       jbzxapiuser.setId(jau.getId());
				       jbzxapiuser.setApi_money(newmoney);
				       jbzxapiuserService.upmoney(jbzxapiuser);
				       JSONObject result=new JSONObject();
					   result.put("result",ac1.getCode());
					   result.put("msg","成功");
					   result.put("code","200");
					   return result.toString();
					
				}else{
					JSONObject result=new JSONObject();
					result.put("result","");
					result.put("msg","余额不足");
					result.put("code","213");
					return result.toString();
				}
			}else{
				JSONObject result=new JSONObject();
				result.put("result","");
				result.put("msg","余额不足");
				result.put("code","213");
				return result.toString();
			}
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
	 //性能最高的方法
    public static String testStringBuilder(int sl) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<sl; i++) {
            sb.append(0);
        }
        return sb.toString();
        
    }
	public static void main(String[] args) {
		UUID randomUUID = UUID.randomUUID();
		String uuidName = randomUUID.toString().replaceAll("-","");
		System.out.println(uuidName);
	}
}
