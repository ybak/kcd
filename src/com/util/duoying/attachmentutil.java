package com.util.duoying;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.alibaba.fastjson.JSONObject;

public class attachmentutil {

	
    // 附件
    public static JSONObject addAttachment(String fileName,String fileType,String url) {
       // List<JSONObject> attachment = new ArrayList<JSONObject>();
        JSONObject xxz = new JSONObject();	
        xxz.put("fileName",fileName);
        xxz.put("fileUrl","http://a.kcway.net/assess/"+url);
        xxz.put("fileType",fileType);
        xxz.put("fileString","");
        xxz.put("remark", "附件");	       
        return xxz;
    }	
    /**
     * 银行信息 ,单个
     * 
     * @return
     */
    public static JSONObject addBank() {
        //List<JSONObject> banks = new ArrayList<>();
        JSONObject oneBank = new JSONObject();
        oneBank.put("bankName", "华夏银行");// 银行名称 bank
        oneBank.put("bankBranchName", "支行");// String 分行/开户行名称 name
        oneBank.put("accountNo", "abc");// String 银行账号 cardunm
        //banks.add(oneBank);
        return oneBank;
    }
    
    
}
