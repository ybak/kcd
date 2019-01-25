package com.controller.ManagementCenter.Management;



import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model1.ManagementCenter.assess_fs;

import com.model1.icbc.erp.PageData;
import com.service1.ManagementCenter.kj_icbcService;
import net.sf.json.JSONArray;


@Controller
public class Management {
	@Autowired
	private kj_icbcService kj_icbcService;

	assess_fs assess_fs=new assess_fs();
	//前台数据后台获取
	public  void management(HttpServletRequest request) {
		PageData pdLoginSession= (PageData)request.getSession().getAttribute("pd");
		assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id").toString()));//Integer.parseInt(pdLoginSession.get("fs_id").toString())
		assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
		List<HashMap> loanlist=kj_icbcService.SelectLoan(assess_fs);//本月已放款单数，总金额   amount=0/money=null
			if(loanlist.get(0).get("amount").equals(0) ){
				loanlist.get(0).put("money",0);
			}
		List<HashMap> fklist=kj_icbcService.SelectFk(assess_fs);//本月已放款未抵押单数，总金额   amount=0/money=null
			if(fklist.get(0).get("amount").equals(0)){
				fklist.get(0).put("money",0);
			}
		
		List<HashMap> rankinglist=kj_icbcService.SelectStates(assess_fs);//每月总订单数各省排名     sell,name=null
			for(int i=0;i<rankinglist.size();i++){
				if(rankinglist.get(i).get("sell")==null && rankinglist.get(0).get("sell").equals("")){
					rankinglist.get(i).put("sell",0);
					rankinglist.get(i).put("name"," ");
				}
			}
		
		List<HashMap> gemslist=kj_icbcService.SelectGems(assess_fs);//每月总订单数各代理商排名    gems,name=null
			for(int i=0;i<gemslist.size();i++){
				if(gemslist.get(i).get("gems")==null && gemslist.get(0).get("gems").equals("")){
					gemslist.get(i).put("gems",0);
					gemslist.get(i).put("name"," ");
				}
			}
		
		List<HashMap> rankingloanlist=kj_icbcService.SelectLoanStates(assess_fs);//每月放款单数各省排名	 sell,name=null
			for(int i=0;i<rankingloanlist.size();i++){
				if(rankingloanlist.get(i).get("sell")==null && rankingloanlist.get(0).get("sell").equals("")){
					rankingloanlist.get(i).put("sell",0);
					rankingloanlist.get(i).put("name"," ");
				}
			}
		
		List<HashMap> gemsloanlist=kj_icbcService.SelectLoanGems(assess_fs);//每月放款单数各代理商排名         gems,name=null
			for(int i=0;i<gemsloanlist.size();i++){
				if(gemsloanlist.get(i).get("gems")==null && gemsloanlist.get(0).get("gems").equals("")){
					gemsloanlist.get(i).put("gems",0);
					gemsloanlist.get(i).put("name"," ");
				}
			}
		
		List<HashMap> cardpasscomm=kj_icbcService.SelectCarPassComm(assess_fs);//每月汽车贷款过件率各省排名     rate,name=null
			for(int i=0;i<cardpasscomm.size();i++){
				if(cardpasscomm.get(i).get("rate")==null && cardpasscomm.get(0).get("rate").equals("")){
					cardpasscomm.get(i).put("rate",0);
					cardpasscomm.get(i).put("name"," ");
				}
			}
		
		List<HashMap> cardpassgems=kj_icbcService.SelectCarPassGems(assess_fs);//每月汽车贷款过件率各代理商排名    rate,name=null
			for(int i=0;i<cardpassgems.size();i++){
				if(cardpassgems.get(i).get("rate")==null && cardpassgems.get(0).get("rate").equals("")){
					cardpassgems.get(i).put("rate",0);
					cardpassgems.get(i).put("name"," ");
				}
			}
		
		request.setAttribute("billlist",kj_icbcService.SelectBill(assess_fs));//每月报单总量     0
		request.setAttribute("loanlist",loanlist);//每月已放款单数，总金额
		request.setAttribute("fklist",fklist);//每月已放款未抵押单数，总金额
		request.setAttribute("carselect",kj_icbcService.CountSelect(assess_fs));//所有汽车贷款     0
		request.setAttribute("carpass",kj_icbcService.CountPass(assess_fs));//汽车贷款通过          0
		request.setAttribute("rankinglist",rankinglist);//每月总订单数各省排名
		request.setAttribute("gemslist",gemslist);//每月总订单数各代理商排名
		request.setAttribute("rankingloanlist",rankingloanlist);//每月总订过件单数各省排名
		request.setAttribute("gemsloanlist",gemsloanlist);//每月总订单数过件各代理商排名
		request.setAttribute("cardpasscomm",cardpasscomm );//每月汽车贷款过件率各省排名
		request.setAttribute("cardpassgems",cardpassgems );//每月汽车贷款过件率各代理商排名
		
		//request.setAttribute("lll",lll);
	}
	//每月数据总单数折线图ajax前台获取           null,null,null
	@RequestMapping("erp/Management/getPathMap.do") 
	@ResponseBody
	public String getPathMap(HttpServletRequest request, HttpServletResponse response){
		try {
			/*** 根据条件取值生成二维数据，并转成json ***/
			PageData pdLoginSession= (PageData)request.getSession().getAttribute("pd");
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			List<HashMap> chart=kj_icbcService.SelectChart(assess_fs);//后台获取查询数据
			Object [][] Ochart=new Object[2][9];			
			if(chart.size()<9){
				for(int i=0;i<chart.size();i++){
					Ochart[1][i]=(chart.get(i).get("year")+"-"+chart.get(i).get("month"));//把日期格式输出放入二维数组xxxx-xx
					Ochart[0][i]=(chart.get(i).get("total"));//把每月数据放入二维数组	
					
				}
				for(int i=chart.size();i<9;i++){
					Ochart[1][i] = "2018-";
					Ochart[0][i] = "0";
				}	
			}else{			
				for(int i=0;i<9;i++){
					Ochart[1][i]=(chart.get(i).get("year")+"-"+chart.get(i).get("month"));//把日期格式输出放入二维数组xxxx-xx
					Ochart[0][i]=(chart.get(i).get("total"));//把每月数据放入二维数组	
				}
			}		
			JSONArray jsonArray = JSONArray.fromObject(Ochart);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // 轨迹图条件，取少量数据
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
	//汽车贷款通过率折线图ajax前台获取
	@RequestMapping("erp/Management/getCarPathMap.do") 
	@ResponseBody
	public String getCarPathMap(HttpServletRequest request, HttpServletResponse response) {
		try {
			/*** 根据条件取值生成二维数据，并转成json ***/
			PageData pdLoginSession= (PageData)request.getSession().getAttribute("pd");	
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			List<HashMap> chart=kj_icbcService.SelectCarChart(assess_fs);//后台获取查询数据
			Object [][] Ochart=new Object[2][9];			
			if(chart.size()<9){
				for(int i=0;i<chart.size();i++){
					Ochart[1][i]=(chart.get(i).get("year")+"-"+chart.get(i).get("month"));//把日期格式输出放入二维数组xxxx-xx
					Ochart[0][i]=(chart.get(i).get("total"));//把每月数据放入二维数组	
					
				}
				for(int i=chart.size();i<9;i++){
					Ochart[1][i] = "2018-";
					Ochart[0][i] = "0";
				}
			}else{
				for(int i=0;i<9;i++){
					Ochart[0][i]=(chart.get(i).get("total"));//把每月数据放入二维数组
					Ochart[1][i]=(chart.get(i).get("year")+"-"+chart.get(i).get("month"));//把日期格式输出放入二维数组xxxx-xx
				}
			}	
			JSONArray jsonArray = JSONArray.fromObject(Ochart);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // 轨迹图条件，取少量数据
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
	//新旧汽车贷款分布扇形图ajax前台获取
	@RequestMapping("erp/Management/getCarFkPathMap.do") 
	@ResponseBody
	public String getCarFkPathMap(HttpServletRequest request, HttpServletResponse response) {
		try {
			/*** 根据条件取值生成二维数据，并转成json ***/
			PageData pdLoginSession= (PageData)request.getSession().getAttribute("pd");	
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			List<HashMap> chart=kj_icbcService.SelectCarFk(assess_fs);//后台获取查询数据
			String[] s = new String[2];
			if(chart.size() < 2){
				if(chart.size()<1){
					for(int i=0;i<2;i++){
						s[i]="0";
					}
				}else{
					if(chart.get(0).get("cartype").toString().equals("1")){
						s[0]=chart.get(0).get("cartotal").toString();
						s[1]="0";
					}else{
						s[0]="0";
						s[1]=chart.get(0).get("cartotal").toString();
					}				
				}		
			}else{
				for(int i=0;i<2;i++){
					s[i]=chart.get(i).get("cartotal").toString();
				}
			}
			JSONArray jsonArray = JSONArray.fromObject(s);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // 轨迹图条件，取少量数据
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
	//贷款金额分布扇形图ajax前台获取     null,null,null,null
	@RequestMapping("erp/Management/getMoneyPathMap.do") 
	@ResponseBody
	public String getMoneyPathMap(HttpServletRequest request, HttpServletResponse response) {
		try {
			/*** 根据条件取值生成二维数据，并转成json ***/
			PageData pdLoginSession= (PageData)request.getSession().getAttribute("pd");	
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			List<HashMap> chart=kj_icbcService.SelectMoneyDistribute(assess_fs);//后台获取查询数据
			String[] s = new String[4];	
			if(chart.get(0) == null){
				for(int i=0;i<4;i++){
					s[i]="0";
				}
			}else{
				for(int i=1;i<5;i++){
					if(chart.get(0).get("singular"+i)==null){
						s[i-1]="0";
					}else{
						s[i-1]=chart.get(0).get("singular"+i).toString();
					}
				}
			}
			JSONArray jsonArray = JSONArray.fromObject(s);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // 轨迹图条件，取少量数据
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
	//抵押完成天数分布扇形图ajax前台获取
	@RequestMapping("erp/Management/getPawnPathMap.do") 
	@ResponseBody
	public String getPawnPathMap(HttpServletRequest request, HttpServletResponse response) {
		try {
			/*** 根据条件取值生成二维数据，并转成json ***/
			PageData pdLoginSession= (PageData)request.getSession().getAttribute("pd");	
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id").toString()));//Integer.parseInt(pdLoginSession.get("fs_id").toString())
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			List<HashMap> chart=kj_icbcService.SelectResult(assess_fs);//后台获取查询数据
			
			String[] s = new String[5];		
			if(chart.get(0) == null){
				for(int i=0;i<5;i++){
					s[i]="0";
				}
			}else{
				for(int i=1;i<6;i++){
					if(chart.get(0).get("paw"+i)==null){
						s[i-1]="0";
					}else{
						s[i-1]=chart.get(0).get("paw"+i).toString();
					}
				}
			}
			JSONArray jsonArray = JSONArray.fromObject(s);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // 轨迹图条件，取少量数据
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
	//征信查询分布扇形图ajax前台获取   null,null       0,1
	@RequestMapping("erp/Management/getCreditPathMap.do") 
	@ResponseBody
	public String getCreditPathMap(HttpServletRequest request, HttpServletResponse response) {
		try {
			/*** 根据条件取值生成二维数据，并转成json ***/
			PageData pdLoginSession= (PageData)request.getSession().getAttribute("pd");	
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			List<HashMap> credit=kj_icbcService.SelectCredit(assess_fs);//后台获取查询数据
			String[] s = new String[3];
			if(credit.size() < 3){
				if(credit.size()<1){
					for(int i=0;i<3;i++){
						s[i]="0";
					}
				}else{
					if(credit.get(0).get("zxok_tag").toString().equals("1")){
						s[0]=credit.get(0).get("zxok").toString();	
					}else{
						s[0]="0";
						for(int i=0;i<credit.size();i++){
							s[i+1]=credit.get(i).get("zxok").toString();
						}
						for(int i=credit.size();i<3;i++){
							s[i+1]="0";
						}
					}					
				}		
			}else{
				for(int i=0;i<3;i++){
					s[i]=credit.get(i).get("zxok").toString();
				}
			}

			JSONArray jsonArray = JSONArray.fromObject(s);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // 轨迹图条件，取少量数据
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
	//客户年龄分布扇形图ajax前台获取      null,null,null,null
	@RequestMapping("erp/Management/getAgePathMap.do") 
	@ResponseBody
	public String getAgePathMap(HttpServletRequest request, HttpServletResponse response) {
		try {
			/*** 根据条件取值生成二维数据，并转成json ***/
			PageData pdLoginSession= (PageData)request.getSession().getAttribute("pd");	
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			List<HashMap> credit=kj_icbcService.SelectClientAge(assess_fs);//后台获取查询数据
			String[] s = new String[4];
			if(credit.get(0) == null){
				for(int i=0;i<4;i++){
					s[i]="0";
				}
			}else{
				for(int i=1;i<5;i++){
					if(credit.get(0).get("age"+i)==null){
						s[i-1]="0";
					}else{
						s[i-1]=credit.get(0).get("age"+i).toString();
					}
				}
			}
			JSONArray jsonArray = JSONArray.fromObject(s);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // 轨迹图条件，取少量数据
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
	//新车年龄分布扇形图ajax前台获取    null,null,null,null
	@RequestMapping("erp/Management/getCarsAgePathMap.do") 
	@ResponseBody
	public String getCarsAgePathMap(HttpServletRequest request, HttpServletResponse response) {
		try {
			/*** 根据条件取值生成二维数据，并转成json ***/
			PageData pdLoginSession= (PageData)request.getSession().getAttribute("pd");	
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			List<HashMap> carsage=kj_icbcService.SelectCarsAge(assess_fs);//后台获取查询数据
			String[] s = new String[4];
			if(carsage.get(0) == null){
				for(int i=0;i<4;i++){
					s[i]="0";
				}
			}else{
				for(int i=1;i<5;i++){
					if(carsage.get(0).get("age"+i)==null){
						s[i-1]="0";
					}else{
						s[i-1]=carsage.get(0).get("age"+i).toString();
					}
				}
			}
			JSONArray jsonArray = JSONArray.fromObject(s);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // 轨迹图条件，取少量数据
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
	//垫资天数分布图ajax前台获取   null,null,null
	@RequestMapping("erp/Management/getAdvanceFundPathMap.do") 
	@ResponseBody
	public String getAdvanceFundPathMap(HttpServletRequest request, HttpServletResponse response) {
		try {
			/*** 根据条件取值生成二维数据，并转成json ***/
			PageData pdLoginSession= (PageData)request.getSession().getAttribute("pd");	
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			List<HashMap> fund=kj_icbcService.SelectAdvanceFund(assess_fs);//后台获取查询数据
			Object [][] Ofund=new Object[2][12];					
			if(fund.size()<12){
				for(int i=0;i<fund.size();i++){
					Ofund[1][i]=(fund.get(i).get("year")+"-"+fund.get(i).get("month"));//把日期格式输出放入二维数组xxxx-xx
					Ofund[0][i]=(fund.get(i).get("adate"));//把每月数据放入二维数组	
					
				}
				for(int i=fund.size();i<12;i++){
					Ofund[1][i] = "2018-";
					Ofund[0][i] = "0";
				}
			}else{
				for(int i=0;i<12;i++){	
					Ofund[0][i]=(fund.get(i).get("adate"));//把每月数据放入二维数组
					Ofund[1][i]=(fund.get(i).get("year")+"-"+fund.get(i).get("month"));//把日期格式输出放入二维数组xxxx-xx
				}
			}
			
			//System.out.println(Ochart);
			JSONArray jsonArray = JSONArray.fromObject(Ofund);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // 轨迹图条件，取少量数据
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
	//抵押材料回收分布图ajax前台获取   null,null,null
	@RequestMapping("erp/Management/getRecyclePathMap.do") 
	@ResponseBody
	public String getRecyclePathMap(HttpServletRequest request, HttpServletResponse response) {
		try {
			/*** 根据条件取值生成二维数据，并转成json ***/
			PageData pdLoginSession= (PageData)request.getSession().getAttribute("pd");	
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id").toString()));//Integer.parseInt(pdLoginSession.get("fs_id").toString())
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			List<HashMap> fund=kj_icbcService.SelectRecycle(assess_fs);//后台获取查询数据
			Object [][] Ofund=new Object[2][9];						
			if(fund.size()<9){
				for(int i=0;i<fund.size();i++){
					Ofund[1][i]=(fund.get(i).get("year")+"-"+fund.get(i).get("month"));//把日期格式输出放入二维数组xxxx-xx
					Ofund[0][i]=(fund.get(i).get("total"));//把每月数据放入二维数组	
					
				}
				for(int i=fund.size();i<9;i++){
					Ofund[1][i] = "2018-";
					Ofund[0][i] = "0";
				}
			}else{
				for(int i=0;i<9;i++){
					Ofund[0][i]=(fund.get(i).get("total"));//把每月数据放入二维数组
					Ofund[1][i]=(fund.get(i).get("year")+"-"+fund.get(i).get("month"));//把日期格式输出放入二维数组xxxx-xx
				}
			}
			//System.out.println(Ochart);
			JSONArray jsonArray = JSONArray.fromObject(Ofund);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // 轨迹图条件，取少量数据
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
	//新旧车放款分布图ajax前台获取    null,null,null,null
	@RequestMapping("erp/Management/getNewOldCarsPathMap.do") 
	@ResponseBody
	public String getNewOldCarsPathMap(HttpServletRequest request, HttpServletResponse response) {
		try {
			/*** 根据条件取值生成二维数据，并转成json ***/
			PageData pdLoginSession= (PageData)request.getSession().getAttribute("pd");	//
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			List<HashMap> newcars=kj_icbcService.SelectNewCars(assess_fs);//后台获取查询数据	
			Object [][] Ofund=new Object[5][12];			
			if(newcars.size()<12){
				for(int i=0;i<newcars.size();i++){
					Ofund[0][i]=(newcars.get(i).get("year1")+"-"+newcars.get(i).get("month1"));//把日期格式输出放入二维数组xxxx-xx
					Ofund[1][i]=(newcars.get(i).get("newcon"));//把新车每月放款单数放入二维数组
					Ofund[2][i]=(newcars.get(i).get("newmoney"));//把新车每月放款总金额放入二维数组
					Ofund[3][i]=(newcars.get(i).get("oldcon"));//把二手车每月放款单数放入二维数组
					Ofund[4][i]=(newcars.get(i).get("oldmoney"));//把二手车每月放款总金额放入二维数组
					
				}
				for(int i=newcars.size();i<12;i++){
					Ofund[0][i] = "2018-";
					Ofund[1][i] = "0";
					Ofund[2][i] = "0";
					Ofund[3][i] = "0";
					Ofund[4][i] = "0";
				}
			}else{
				for(int i=0;i<12;i++){
					Ofund[0][i]=(newcars.get(i).get("year1")+"-"+newcars.get(i).get("month1"));//把日期格式输出放入二维数组xxxx-xx
					Ofund[1][i]=(newcars.get(i).get("newcon"));//把新车每月放款单数放入二维数组
					Ofund[2][i]=(newcars.get(i).get("newmoney"));//把新车每月放款总金额放入二维数组
					Ofund[3][i]=(newcars.get(i).get("oldcon"));//把二手车每月放款单数放入二维数组
					Ofund[4][i]=(newcars.get(i).get("oldmoney"));//把二手车每月放款总金额放入二维数组
				}
			}
			//System.out.println(Ochart);
			JSONArray jsonArray = JSONArray.fromObject(Ofund);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // 轨迹图条件，取少量数据
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
