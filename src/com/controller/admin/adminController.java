package com.controller.admin;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.model1.fs;
import com.service1.fsService;
import com.service1.admin.assess_gemsService;
import com.util.creditutil;
import com.util.jsonutil;
import com.util.limitutil;

@Controller
public class adminController {

	@Autowired
	private assess_gemsService assess_gemsService;
	@Autowired
	private fsService fsService;
	
	@RequestMapping(value="/icbc/gems_sh.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String gems_sh(
			int id,
 			HttpServletRequest request,
 			HttpServletResponse response
			){
	 Map<String,Object> map=assess_gemsService.getgemsmap(id);
	 return jsonutil.toJSONString(map).replace("[", "").replace("]","");				
	}
	
	@RequestMapping(value="/icbc/gems_name.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String gems_name(
			int id,
 			HttpServletRequest request,
 			HttpServletResponse response
			){
	 List<Map<String,Object>> maplist=assess_gemsService.getgemsmapbyfsid(id);
	 return jsonutil.toJSONString(maplist);				
	}
	
	@RequestMapping(value="/icbc/gems_zx.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String gems_zx(
			int icbc_id,
 			HttpServletRequest request,
 			HttpServletResponse response
			){
	 Map<String,Object> map=assess_gemsService.getgemsmapbyicbc_id(icbc_id);
	 return jsonutil.toJSONString(map).replace("[", "").replace("]","");				
	}
	
	@RequestMapping(value="/icbc/zx_gems_up.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String zx_gems_up(
			int gems_id,
			int icbc_id,
			String imgstep1_1,
			String imgstep2_1,
			String imgstep3_1,
			String imgstep4_1,
			String zx_result,
			HttpServletResponse response,
			HttpServletRequest request
			) throws IOException{
		System.out.println("---------"+zx_result);
		if(zx_result.replace(" ", "")!=null&&!zx_result.replace(" ", "").equals("")){			
		Map<String,Object> map1=assess_gemsService.getgemsmap(gems_id);
		if(map1.get("zx_result")!=null&&!map1.get("zx_result").equals("")){
			JSONObject result=new JSONObject();
			result.put("msg","商户师已有征信关联!");
			result.put("code",0);
			return result.toJSONString();
		}else {
			 Map<String,Object> map=new HashMap<String,Object>();
			 map.put("id", gems_id);
	        if(imgstep1_1!=null&&!imgstep1_1.equals("")){
	        	     map.put("imgstep1_1",imgstep1_1);
	        }      
	        if(imgstep2_1!=null&&!imgstep2_1.equals("")){
	        	     map.put("imgstep2_1",imgstep2_1);	
	        }
	        if(imgstep3_1!=null&&!imgstep3_1.equals("")){
	        		 map.put("imgstep3_1",imgstep3_1);
	        }
	        if (imgstep4_1!=null&&!imgstep4_1.equals("")) {
	         map.put("imgstep4_1",imgstep4_1);
	       } 
		 map.put("zx_result",zx_result);
		 map.put("dt_edit",creditutil.time());
		 map.put("icbc_id",icbc_id);
		 assess_gemsService.upgems_zx(map);
		 map1=assess_gemsService.getgemsmapbyicbc_id(icbc_id);
		 JSONObject result=new JSONObject();
		 result.put("fsname",map1.get("fsname"));
		 result.put("gemsid",map1.get("id"));
		 result.put("msg","关联成功!");
		 result.put("code",1);
		 return result.toJSONString();
		}	
		}else{
			 JSONObject result=new JSONObject();			
			 result.put("msg","关联失败!征信不能为空");
			 result.put("code",0);
			 return result.toJSONString();
		}
    }
	
	
	@RequestMapping(value="/icbc/gems_up.do",produces = "text/html;charset=UTF-8")
	public String gems_up(
			int gems_id,
			MultipartFile imgstep1_1,
			MultipartFile imgstep2_1,
			MultipartFile imgstep3_1,
			MultipartFile imgstep4_1,
			String zx_result,
			HttpServletResponse response,
			HttpServletRequest request
			) throws IOException{
		 Map<String,Object> map=new HashMap<String,Object>();
		 map.put("id", gems_id);
		 
		Date date = new Date(); 
//		String filePath = "E:/快加项目/carsassess/"+new SimpleDateFormat("yyyy/MM/dd/").format(date);        
        String filePath = "/KCDIMG/assess/upload/"+new SimpleDateFormat("yyyy/MM/dd/").format(date);
        String imgpath="upload/"+new SimpleDateFormat("yyyy/MM/dd/").format(date);
        File f = new File(imgpath);
        if(!f.exists()){  
            f.mkdirs();   
        }
        String filename1 = imgstep1_1.getOriginalFilename();
        if(filename1!=null&&!filename1.equals("")){
        	 String prefix1=filename1.substring(filename1.lastIndexOf(".")+1);
             UUID uuid1 = UUID.randomUUID();
             String uuidname1=uuid1.toString().replaceAll("-","")+"."+prefix1;        	
             byte[] file36Byte1 = imgstep1_1.getBytes();
             FileUtils.writeByteArrayToFile(new File(filePath+uuidname1),file36Byte1);              
             map.put("imgstep1_1", imgpath+uuidname1);
        }
       
		 
        String filename2 = imgstep2_1.getOriginalFilename();
        if(filename2!=null&&!filename2.equals("")){
        	String prefix2=filename2.substring(filename2.lastIndexOf(".")+1);
            UUID uuid2 = UUID.randomUUID();
            String uuidname2=uuid2.toString().replaceAll("-","")+"."+prefix2;        	
            byte[] file36Byte2 = imgstep2_1.getBytes();
            FileUtils.writeByteArrayToFile(new File(filePath+uuidname2),file36Byte2);              
            map.put("imgstep2_1", imgpath+uuidname2);	
        }
        

        String filename3 = imgstep3_1.getOriginalFilename();
        if(filename3!=null&&!filename3.equals("")){
        	String prefix3=filename3.substring(filename3.lastIndexOf(".")+1);
            UUID uuid3 = UUID.randomUUID();
            String uuidname3=uuid3.toString().replaceAll("-","")+"."+prefix3;        	
            byte[] file36Byte3 = imgstep3_1.getBytes();
            FileUtils.writeByteArrayToFile(new File(filePath+uuidname3),file36Byte3);              
    		 map.put("imgstep3_1", imgpath+uuidname3);
        }
        
		 
        String filename4 = imgstep4_1.getOriginalFilename();
        if (filename4!=null&&!filename4.equals("")) {
      	  String prefix4=filename4.substring(filename4.lastIndexOf(".")+1);
            UUID uuid4 = UUID.randomUUID();
            String uuidname4=uuid4.toString().replaceAll("-","")+"."+prefix4;        	
            byte[] file36Byte4 = imgstep4_1.getBytes();
            FileUtils.writeByteArrayToFile(new File(filePath+uuidname4),file36Byte4);              
            map.put("imgstep4_1", imgpath+uuidname4);
       } 
	 map.put("zx_result", zx_result);
	 map.put("dt_edit", creditutil.time());
	 assess_gemsService.upgems_zx(map);
	 return "forward:/icbc/gems_list.do?apg=zhgl/shsgl";
    }
	
    @RequestMapping(value="/icbc/gems_list1.do",produces="text/html;charset=UTF-8")
	public String gems_list1(
			String size,//每页数量
 			String pagenow,//当前页数
 			HttpServletRequest request,
 			HttpServletResponse response
			){
    	int s,n;
    	if(size!=null&&!size.equals("")){
    		s=Integer.parseInt(size);
    	}else{
    		s=10;
    	}
    	if(pagenow!=null&&!pagenow.equals("")){
    		n=Integer.parseInt(pagenow);
    	}else{
    		n=1;
    	}
    	List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> mList=assess_gemsService.getgemslist1();
		list=limitutil.fy(mList,s,n);	
		int totalpage;//总页数
		int q=mList.size()%s;
		if(q==0){
			totalpage=mList.size()/s;	    		
		}else{
			totalpage=mList.size()/s+1;
		}
		System.out.println(list.get(1));
		List<fs> fs=fsService.findbypy();
	  	request.setAttribute("fs",fs);//商户店名称
		request.setAttribute("totalpage",totalpage);//总页数
		request.setAttribute("size",s);//每页数量
		request.setAttribute("pagenow",n);//当前页
		request.setAttribute("totalno",mList.size());//总数量
		request.setAttribute("list",list);// 
		return "cskjs_wzb/gems_table";
	}
    
    @RequestMapping(value="/icbc/gems_list.do",produces="text/html;charset=UTF-8")
   	public String gems_list(
   			    String size,//每页数量
    			String pagenow,//当前页数
    			String time,
    			String gems_fs_id,
    			String keyword,
    			String apg,
    			HttpServletRequest request,
    			HttpServletResponse response
   			) throws UnsupportedEncodingException{
   	 String time1= null;
	 String time2= null;
     if(time!=null&&!time.equals("")){
	String[] strings=time.trim().split("-");
	time1=strings[0];
	time2=strings[1].trim();		 
     }	
       	int s,n;
       	if(size!=null&&!size.equals("")){
       		s=Integer.parseInt(size);
       	}else{
       		s=10;
       	}
       	if(pagenow!=null&&!pagenow.equals("")){
       		n=Integer.parseInt(pagenow);
       	}else{
       		n=1;
       	}
       	List<Map<String, Object>> list=new ArrayList<Map<String, Object>>();
       	if(keyword!=null&&!keyword.equals("")){
       		keyword =new String(keyword.getBytes("iso8859-1"),"utf-8");	
       	}
       	int fsid=0;
       	if(gems_fs_id!=null&&!gems_fs_id.equals("")){
       		fsid=Integer.parseInt(gems_fs_id);
       	}
   		List<Map<String, Object>> mList=assess_gemsService.getgemslist(time1,
   				time2,keyword,fsid);
   		list=limitutil.fy(mList,s,n);	
   		int totalpage;//总页数
   		int q=mList.size()%s;
   		if(q==0){
   			totalpage=mList.size()/s;	    		
   		}else{
   			totalpage=mList.size()/s+1;
   		}
   		List<fs> fs=fsService.findbypy();
	  	request.setAttribute("fs",fs);//商户店名称
   		request.setAttribute("totalpage",totalpage);//总页数
   		request.setAttribute("size",s);//每页数量
   		request.setAttribute("pagenow",n);//当前页
   		request.setAttribute("totalno",mList.size());//总数量
   		request.setAttribute("list",list);// 
   		request.setAttribute("new_time",time);//当前页
   		request.setAttribute("new_gems_fs_id",gems_fs_id);//总数量
   		request.setAttribute("new_keyword",keyword);//
   		request.setAttribute("apg",apg);//
   		return "cskjs_wzb/gems_table";
   	}
    
}
