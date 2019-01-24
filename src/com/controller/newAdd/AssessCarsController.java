package com.controller.newAdd;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.model.jbapi.jbzxapiuser;
import com.model.newAdd.AssessBclientCheck;
import com.model.newAdd.AssessCars;
import com.model.newAdd.AssessCarsItem;
import com.model1.newAdd.CarBrand;
import com.model1.newAdd.CarModell;
import com.model1.newAdd.CarSeries;
import com.service.newAdd.AssessBclientCheckService;
import com.service.newAdd.AssessCarsItemService;
import com.service.newAdd.AssessCarsService;
import com.service.zx.jbzxapiuserService;
import com.service1.newAdd.CarBrandService;
import com.service1.newAdd.CarModelService;
import com.service1.newAdd.CarSeriesService;
import com.util.Page;
import com.util.creditutil;
@Controller
public class AssessCarsController{
	@Autowired
	private AssessCarsService assessCarsService;
	@Autowired
	private CarModelService carModelService;
	@Autowired
	private CarBrandService carBrandService;
	@Autowired
	private CarSeriesService carSeriesService;
	@Autowired
	private AssessBclientCheckService assessBclientCheckService;
	@Autowired
	private AssessCarsItemService assessCarsItemService; 
	@Autowired
	private jbzxapiuserService jbzxapiuserservice;
	HttpServletRequest request;
	HttpServletResponse response;
	
	// 操作 审核  保存提交   method=RequestMethod.POST,produces="multipart/form-data;charset=UTF-8"
	@RequestMapping(value="/updateOneACarsById.do",method=RequestMethod.POST,produces="multipart/form-data;charset=UTF-8")
	public void updateOneACarsById(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("id") int id,
			@RequestParam("brid") int brid,
			@RequestParam("seid") int seid,
			@RequestParam("carid") String carid,
			@RequestParam("vincode") String vincode,
			@RequestParam("car_km") int car_km,
			@RequestParam("color_id") String color_id,
			@RequestParam("car_days") String car_days,
			@RequestParam("price_new") double price_new,
			@RequestParam("motorcode") String motorcode,
			@RequestParam("c_carno") String c_carno,
			@RequestParam("price_result") double price_result,
			@RequestParam("bc_status") int bc_status,
			@RequestParam("remark") String remark
			){
		System.err.println("id--"+id);
		System.err.println("brid--"+brid);
		System.err.println("seid--"+seid);
		System.err.println("carid--"+carid);
		System.err.println("vincode--"+vincode);
		System.err.println("car_km--"+car_km);
		System.err.println("color_id--"+color_id);
		System.err.println("car_days--"+car_days);
		System.err.println("price_new--"+price_new);
		System.err.println("motorcode--"+motorcode);
		System.err.println("c_carno--"+c_carno);
		System.err.println("price_result--"+price_result);
		System.err.println("bc_status--"+bc_status);
		System.err.println("remark--"+remark);
		//添加汽车评估
		int userid = (int) request.getSession().getAttribute("id");
		AssessCars assessCars = new AssessCars();
		assessCars.setBrid(brid);
		assessCars.setSeid(seid);
		assessCars.setCarid(carid);
		assessCars.setVincode(vincode);
		assessCars.setCar_km(car_km);
		assessCars.setColor_id(color_id);
		assessCars.setCar_days(car_days);
		assessCars.setPrice_new((int)(price_new*10000));
		assessCars.setMotorcode(motorcode);
		assessCars.setC_carno(c_carno);
		assessCars.setPrice_result((int)(price_result*10000));
		assessCars.setBc_status(bc_status);
		assessCars.setDt_edit(creditutil.time());
		assessCars.setId(id);
		assessCars.setGems_id(userid);
		int updateStatus = assessCarsService.updateOneACarsById(assessCars);
		//添加留言
		AssessBclientCheck assessBclientCheck = new AssessBclientCheck();
		assessBclientCheck.setAssessid(id);
		assessBclientCheck.setStatus(bc_status);
		assessBclientCheck.setDt_add(creditutil.time());
		assessBclientCheck.setDt_edit(creditutil.time());
		
		assessBclientCheck.setMid_edit(userid);
		assessBclientCheck.setRemark(remark);
		assessBclientCheckService.addAssessBclientCheck(assessBclientCheck);
		request.setAttribute("updateStatus",updateStatus);
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");			
			String msString="提交成功!";
			PrintWriter out = response.getWriter();			
			out.print("<script language=\"javascript\">alert('"+msString+"');window.location.href='selectAllAssessCars.do'</script>");
		} catch (IOException e) {			
			e.printStackTrace();
		}		
	}
	
	@RequestMapping(value="/selectAllAssessCars.do",produces="text/html;charset=UTF-8")
	public String selectAllAssessCars(HttpServletRequest request,HttpServletResponse response){
		//分页查询
		String size=request.getParameter("size");
	    String pagenow=request.getParameter("pagenow");
	    int s;
	    if(size!=null){
	    	s=Integer.parseInt(size);
	    }else{
	    	s=10;
	    }	
	    int totalCount;
	    Page page;
  		//用于保存查询到的数据
	    List<AssessCars>  list = new ArrayList();
	    totalCount =assessCarsService.getSumAssessCars();
	    if (pagenow!=null){				
			page = new Page(totalCount, Integer.parseInt(pagenow),s);
			list= assessCarsService.selectAllAssessCars(page.getStartPos(),page.getPageSize());	
			////////////////////
			for(int i=0;i<list.size();i++){
				AssessCars assessCars = (com.model.newAdd.AssessCars) list.get(i);
				String carid = assessCars.getCarid();
				//得到汽车模型
				CarModell carModel = carModelService.selectCarNameById(Integer.parseInt(carid));
				if(carModel!=null&&!carModel.equals("")){
					String caridName = carModel.getName();
					assessCars.setCarid(caridName);
				}
				//得到公司和人员
				jbzxapiuser appkeyUser = jbzxapiuserservice.findapiuserbyid(assessCars.getMem_id());
				String a = appkeyUser.getApi_companyname();
				String b = appkeyUser.getApi_name();
				assessCars.setMem_name(a+"-"+b);
			}
		}else{
			page = new Page(totalCount, 1,s);					
			list = assessCarsService.selectAllAssessCars(page.getStartPos(),page.getPageSize());	
			pagenow = "1";
			////////////////////
			for(int i=0;i<list.size();i++){
				AssessCars assessCars = (com.model.newAdd.AssessCars) list.get(i);
				String carid = assessCars.getCarid();
				//得到汽车模型
				CarModell carModel = carModelService.selectCarNameById(Integer.parseInt(carid));
				if(carModel!=null&&!carModel.equals("")){
					String caridName = carModel.getName();
					assessCars.setCarid(caridName);
				}
				//得到公司和人员
				jbzxapiuser appkeyUser = jbzxapiuserservice.findapiuserbyid(assessCars.getMem_id());
				String a = appkeyUser.getApi_companyname();
				String b = appkeyUser.getApi_name();
				assessCars.setMem_name(a+"-"+b);
			}
		}				
		int q=totalCount%s;
    	int w=0;
    	if(q==0){
    		w=totalCount/s;
    	}else{
    		w=totalCount/s+1;
    	}   		
    	
    	request.setAttribute("w",w);
    	request.setAttribute("pagenow",pagenow);
    	request.setAttribute("size",s);
		request.setAttribute("totalCount",totalCount);
		request.setAttribute("list", list);
		return "CarEvaluation";
	}
	
	//进入 笔 操作
	@RequestMapping(value="/sAACarsCaoZuo.do",produces="text/html;charset=UTF-8")
	public String sAACarsCaoZuo(HttpServletRequest request,HttpServletResponse response,
			int id){
		AssessCars assessCars = new AssessCars();
		assessCars = assessCarsService.selectOneACarsById(id);
		CarModell carModel = carModelService.selectCarNameById(Integer.parseInt(assessCars.getCarid()));
		if(carModel!=null&&!carModel.equals("")){
			assessCars.setCarid(carModel.getName());
		}
		
		//得到公司和人员
		jbzxapiuser appkeyUser = jbzxapiuserservice.findapiuserbyid(assessCars.getMem_id());
		if(appkeyUser!=null&&!appkeyUser.equals("")){
			String a = appkeyUser.getApi_companyname();
			String b = appkeyUser.getApi_name();
			assessCars.setMem_name(a+"-"+b);
		}
		//得到留言
		ArrayList bclientCheckList = assessBclientCheckService.selectAllAssessBclientCheck(id);
		
		//得到照片
		ArrayList<AssessCarsItem> carsItem = assessCarsItemService.selectAllAssessCarsItem(id);  
		String aa = JSON.toJSONString(carsItem);
		
		request.setAttribute("id",id);
		request.setAttribute("assessCars",assessCars); // 汽车信息
		request.setAttribute("bclientCheckList",bclientCheckList); //留言信息
		request.setAttribute("carsItem",carsItem); // 汽车照片   里面放的都是对象
		request.setAttribute("aa",aa); 
		return "CarEvaluationCaoZuo";
	}
	
	//得到全部汽车品牌   @ResponseBody
	@RequestMapping(value="/getAllCarBrand.do",produces="text/html;charset=UTF-8")
	 @ResponseBody
	public String getAllCarBrand(HttpServletRequest request,HttpServletResponse response){
		List<CarBrand>  AllCarBrandList = new ArrayList<CarBrand>();
		AllCarBrandList = carBrandService.selectAllCarBrand();
		String a = JSON.toJSONString(AllCarBrandList);
		return JSON.toJSONString(AllCarBrandList);
	}
	//得到全部汽车品牌二级信息   @ResponseBody
	@RequestMapping(value="/getCarSeries.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getCarSeries(HttpServletRequest request,HttpServletResponse response){
		String brid = request.getParameter("brid");
		List<CarSeries>  AllCarSeriesList = new ArrayList<CarSeries>();
		AllCarSeriesList = carSeriesService.selectCarSeriesById(Integer.parseInt(brid));
		return JSON.toJSONString(AllCarSeriesList);
	}
	//得到全部汽车品牌三级信息   @ResponseBody
	@RequestMapping(value="/getCarModel.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getCarModel(HttpServletRequest request,HttpServletResponse response){
		String seid = request.getParameter("seid");
		List<CarModell>  AllCarModellList = carModelService.selectCarModellById(Integer.parseInt(seid));
		return JSON.toJSONString(AllCarModellList);
	}
	
	//获取新车价格
	@RequestMapping(value="/getNewCarPrice.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getNewCarPrice(HttpServletRequest request,HttpServletResponse response,
			int id){
		CarModell  OneCarModel = new CarModell();
		OneCarModel = carModelService.selectCarNameById(id);
		return JSON.toJSONString(OneCarModel);
	}
	
	//删除
	@RequestMapping(value="/deleteACars.do",produces="text/html;charset=UTF-8")
	public String deleteACars(HttpServletRequest request,HttpServletResponse response,
			int id){
		assessCarsService.deleteOneACarsById(id);
		return selectAllAssessCars(request, response);
	}
}
