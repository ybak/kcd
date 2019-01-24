package com.controller.duoying;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



import com.alibaba.fastjson.JSONObject;
import com.http.duoying.syncjkrxxHttp;
import com.mashape.unirest.http.JsonNode;
import com.model1.bank;

import com.model1.mgcert;
import com.model1.ylqy;
import com.service1.duoying.bankService;
import com.service1.duoying.carmodelService;

import com.service1.duoying.mgcertService;
import com.service1.duoying.ylqyService;
import com.util.jsonutil;
import com.util.md5util;

import net.sf.json.JSONArray;


@Controller
public class addBorrower2Controller {
	
	@Autowired
	private mgcertService mgcertService;
	
	@Autowired
	private bankService bankService;
	
	@Autowired
	private ylqyService ylqyService;
	
	@Autowired
	private carmodelService carmodelService;

}
