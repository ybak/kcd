package com.controller.duoying;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model1.bank;
import com.model1.ylqy;
import com.service1.duoying.bankService;
import com.service1.duoying.ylqyService;

@Controller
public class ylqyController {

	@Autowired
	private ylqyService ylqyService;
	
	@Autowired
	private bankService bankService;
	
	@RequestMapping(value="findylqy.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String finfylqy(String ACCOUNT_NAME){
		List<ylqy> ylqy = new ArrayList<ylqy>();
		ylqy = ylqyService.finfylqy();
		ylqy y = new ylqy();
		List<Map<String,Object>> maplist=new ArrayList<Map<String,Object>>();
		for(int i=0;i<ylqy.size();i++){
			y = ylqy.get(i);
			if(i==ylqy.size()-1){
			Map<String,Object> m=new HashMap<String,Object>();
			m.put("id", y.getId());
			m.put("BANK_CODE", y.getBANK_CODE());
			m.put("ACCOUNT_NAME", y.getACCOUNT_NAME());
			m.put("CURRENCY", y.getCURRENCY());
			m.put("ACCOUNT_TYPE", y.getACCOUNT_TYPE());
			m.put("ACCOUNT_NO", y.getACCOUNT_NO());
			m.put("PROVINCE", y.getPROVINCE());
			m.put("CITY", y.getCITY());
			m.put("BANK_NAME", y.getBANK_NAME());
			m.put("ACCOUNT_PROP", y.getACCOUNT_PROP());//0私人，1公司。不填时，默认为私人0
			m.put("ID_TYPE", y.getID_TYPE());//0：身份证,1: 户口簿，2：护照,3.军官证,4.士兵证，5. 港澳居民来往内地通行证,6. 台湾同胞来往内地通行证,7. 临时身份证,8. 外国人居留证,9. 警官证, X.其他证件
			m.put("c_cardid", y.getC_cardid());
			m.put("TEL", y.getTEL());
			m.put("remark", y.getRemark());
			
			String code = "";
			code = y.getBANK_CODE().toString();
			System.out.println(code);
			List<bank> banklist = new ArrayList<>();
			banklist = bankService.findbankbycode(code);
			bank b = new bank();
			for(int j=0;j<banklist.size();j++){
			b = banklist.get(j);
			m.put("bankname：", b.getName());
			}
			maplist.add(m);
			
			}
		}
		
		return maplist.toString();
		
	
	}
	
	
	
	
	
}
