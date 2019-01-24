package com.controller.duoying;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model1.mgcert;
import com.model1.ylds;
import com.model1.ylqy;
import com.service1.duoying.mgcertService;
import com.service1.duoying.yldsService;
import com.service1.duoying.ylqyService;

@Controller
public class yldsController {

	@Autowired
	private yldsService yldsService;
	
	@Autowired
	private mgcertService mgcertService;
	
	@Autowired
	private ylqyService ylqyService;
	
	@RequestMapping(value="findylds.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String finfylds() throws ParseException{
		List<Map<String,Object>> maplist=new ArrayList<Map<String,Object>>();
		List<ylds> dslist = new ArrayList<ylds>();
		List<mgcert> mglist  = new ArrayList<mgcert>();
		List<ylqy> qylist = new ArrayList<ylqy>();
		List<Map<String,Object>> hklist=new ArrayList<Map<String,Object>>();
		
		//dslist = yldsService.findyldsbyid(id);
		
		mglist = mgcertService.findmgcertlist();
		mgcert mg = new mgcert();
		
		SimpleDateFormat dftime = new SimpleDateFormat("yyyy-MM-dd"); // 鏃ユ湡鏍煎紡
		for(int i =0;i<mglist.size();i++){
			
			Map<String,Object> hkmap=new HashMap<String,Object>();
			mg = mglist.get(i);
			hkmap.put("缂栧彿锛�", mg.getGems_code());
			int qs = mg.getC_mgdays()/30;
			hkmap.put("鏈熸暟", qs);
			int a = mg.getC_mgtype();
			
			
			if(a==1){
			
			
			String str = mg.getC_mgprice_result();
			DecimalFormat df = new DecimalFormat("#.00");  
			double bj = Double.parseDouble(str);
			bj = Double.parseDouble(df.format(bj));
			hkmap.put("搴旇繕鏈噾锛�", df.format(bj));
			hkmap.put("搴旇繕鍒╂伅锛�", df.format(bj*0.0068*qs));
			hkmap.put("搴旇繕灏忔妧锛�", df.format(bj+bj*0.0068*qs));
			
			  
			
			for(int j=0;j<qs;j++){
				System.out.println(j);
				
				Map<String,Object> hkmap2=new HashMap<String,Object>();
				hkmap2.put("绗嚑鏈�", j+1);
				Date date = dftime.parse(mg.getDt_fk()); // 鎸囧畾鏃ユ湡
				Date newDate = addDate(date, 30*j); // 鎸囧畾鏃ユ湡鍔犱笂30澶� 
				hkmap2.put("姣忔湡鏈熻繕娆捐鍒掓椂闂�", dftime.format(newDate) );
				hkmap2.put("姣忔湡杩樻璁″垝鏈噾", df.format(bj/qs));
				hkmap2.put("姣忔湡杩樻璁″垝鍒╂伅", df.format(bj*0.0068));
				hkmap2.put("姣忔湡杩樻璁″垝灏忚", df.format(bj*0.0068+bj/qs));
				hklist.add(hkmap2);
				
			}
			
			hkmap.put("hklist", hklist);
			
			for(int c=0;c<=qs;c++){
				if(c ==1){
					Date date = dftime.parse(mg.getDt_fk()); // 鎸囧畾鏃ユ湡
					Date newDate = addDate(date, 30*c);
					hkmap.put("棣栨湡杩樻璁″垝鏃堕棿", dftime.format(newDate) );
					hkmap.put("棣栨湡杩樻璁″垝鏈噾", df.format(bj/qs));
					hkmap.put("棣栨湡杩樻璁″垝鍒╂伅", df.format(bj*0.0068));
					hkmap.put("棣栨湡杩樻璁″垝灏忚", df.format(bj*0.0068+bj/qs));
				} if(c ==qs){
					Date date = dftime.parse(mg.getDt_fk()); // 鎸囧畾鏃ユ湡
					Date newDate = addDate(date, 30*c);
					hkmap.put("灏炬湡杩樻璁″垝鏃堕棿", dftime.format(newDate) );
					hkmap.put("灏炬湡杩樻璁″垝鏈噾", df.format(bj/qs));
					hkmap.put("灏炬湡杩樻璁″垝鍒╂伅", df.format(bj*0.0068));
					hkmap.put("灏炬湡杩樻璁″垝灏忚", df.format(bj*0.0068+bj/qs));
				}
				
			}	
			
			
			
			
			}if(a==0){
				
				
				String str = mg.getC_mgprice_result();
				DecimalFormat df = new DecimalFormat("#.00");  
				double bj = Double.parseDouble(str);
				bj = Double.parseDouble(df.format(bj));
				hkmap.put("搴旇繕鏈噾锛�", df.format(bj));
				hkmap.put("搴旇繕鍒╂伅锛�", df.format(bj*0.01*qs));
				hkmap.put("搴旇繕灏忔妧锛�", df.format(bj+bj*0.01*qs));
				
				
				for(int u=0;u<qs;u++){
					Map<String,Object> hkmap2=new HashMap<String,Object>();
					hkmap2.put("绗嚑鏈�", u+1);
					Date date = dftime.parse(mg.getDt_fk()); // 鎸囧畾鏃ユ湡
					Date newDate = addDate(date, 30*u); 
					hkmap2.put("姣忔湡鏈熻繕娆捐鍒掓椂闂�",dftime.format(newDate) );
					hkmap2.put("姣忔湡杩樻璁″垝鏈噾", df.format(0));
					hkmap2.put("姣忔湡杩樻璁″垝鍒╂伅", df.format(bj*0.01));
                   if(u+1==qs){
						
						hkmap2.put("姣忔湡杩樻璁″垝灏忚", df.format(bj*0.01+bj));//姣忔湡杩樻璁″垝灏忚
					}else{
						hkmap2.put("姣忔湡杩樻璁″垝灏忚", df.format(bj*0.01));
					}
					hklist.add(hkmap2);
					

				}
				
				hkmap.put("hklist", hklist);
				
					for(int b =0;b<=qs;b++){
						if(b==1){
						Date date = dftime.parse(mg.getDt_fk()); // 鎸囧畾鏃ユ湡
						Date newDate = addDate(date, 30*b); 
						hkmap.put("棣栨湡杩樻璁″垝鏃堕棿", dftime.format(newDate) );
						hkmap.put("棣栨湡杩樻璁″垝鏈噾", df.format(0));
						hkmap.put("棣栨湡杩樻璁″垝鍒╂伅", df.format(bj*0.01));
						hkmap.put("棣栨湡杩樻璁″垝灏忚", df.format(bj*0.01));
					}if(b ==qs){
						Date date = dftime.parse(mg.getDt_fk()); // 鎸囧畾鏃ユ湡
						Date newDate = addDate(date, 30*b);
						hkmap.put("灏炬湡杩樻璁″垝鏃堕棿",dftime.format(newDate) );
						hkmap.put("灏炬湡杩樻璁″垝鏈噾", df.format(0));
						hkmap.put("灏炬湡杩樻璁″垝鍒╂伅", df.format(bj*0.01));
						hkmap.put("灏炬湡杩樻璁″垝灏忚", df.format(bj*0.01+bj));
					}
					
					
			}
				
				
			}
			
			
			
			
			
			maplist.add(hkmap);
			
			
			
		}
		
		
		
		return maplist.toString();
		
	}
	
	
	
	

		public static void main(String[] args) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); // 鏃ユ湡鏍煎紡
		Date date = df.parse("2015-07-31"); // 鎸囧畾鏃ユ湡
		Date newDate = addDate(date, 30); // 鎸囧畾鏃ユ湡鍔犱笂20澶�
		System.out.println(df.format(date));// 杈撳嚭鏍煎紡鍖栧悗鐨勬棩鏈�
		System.out.println(df.format(newDate));
		}


		public static Date addDate(Date date,long day) throws ParseException {
		 long time = date.getTime(); // 寰楀埌鎸囧畾鏃ユ湡鐨勬绉掓暟
		 day = day*24*60*60*1000; // 瑕佸姞涓婄殑澶╂暟杞崲鎴愭绉掓暟
		 time+=day; // 鐩稿姞寰楀埌鏂扮殑姣鏁�
		 return new Date(time); // 灏嗘绉掓暟杞崲鎴愭棩鏈�
		}
	
	
	
}
