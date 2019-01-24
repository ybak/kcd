package com.controller.icbc_kjs;

import java.util.HashMap;
import java.util.Map;

import com.util.duoying.mapbeanutil;

public class icbc_urlmodel {

	
	public Map  icbc_url(){
		Map  url=new HashMap<>();
		url.put("newicbc","newicbc.do?id=${requestScope.id }&out=1&querytype=${requestScope.querytype}&size=${requestScope.size}&status=${requestScope.status}");
		url.put("kjs_zx","kjs_zx.do?out=1&id=${requestScope.id}");
		url.put("kjs_pg","kjs_pg.do?out=1&id=${requestScope.id}");
        return url;
	}
	
	
}
