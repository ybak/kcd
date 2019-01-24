package com.controller.icbc;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.model.icbc.icbc;
import com.model.icbc.icbc_result;
import com.model.jbapi.jbzxapiuser;
import com.service.icbc.icbcService;
import com.service.icbc.icbc_resultService;
import com.service.icbc.icbc_zxService;
import com.service.zx.jbzxapiuserService;
import com.util.creditutil;
import com.util.limitutil;

@Controller
public class icbcjspController {

	 @Autowired
	 private icbcService icbcservice;
	 
	 @Autowired
	 private icbc_resultService icbc_resultservice;
	 
	 @Autowired
	 private jbzxapiuserService jbzxapiuserservice;
	 
	 @Autowired
	 private icbc_zxService icbc_zxService;
	 
		@RequestMapping(value="/icbclist.do",produces="text/html;charset=UTF-8")	
        private String icbclist(
        		HttpServletRequest request,
        		String pagesize,//每页数量
    			String pagenow,//当前页数
    			String bc_status
    			){
			int now;//当前页数
			if(pagenow!=null&&!pagenow.equals("")){
				now=Integer.parseInt(pagenow);
		        }else{
		        now=1;
		        }	
			int size;//每页数量
			if(pagesize!=null&&!pagesize.equals("")){
				size=Integer.parseInt(pagesize);
		        }else{
		        size=10;
		        }		
		int state=0;
		if(bc_status!=null&&!bc_status.equals("")){
			state=Integer.parseInt(bc_status.replace("?v=4.0", ""));
		}
		List list=new ArrayList<>();
		System.out.println(state);
		List<icbc> il=icbcservice.findicbc(0,state);
		List<icbc> icbcall=new ArrayList<>();
		if(il.size()>0){
			for(int i=0;i<il.size();i++){
				icbc icbc=il.get(i);
				jbzxapiuser jau=jbzxapiuserservice.findapiuserbyid(icbc.getGems_fs_id());	
				if(jau!=null&&!jau.equals("")){
					icbc.setGname(jau.getApi_companyname());
					icbc.setPname(jau.getApi_name());
				}
				icbcall.add(icbc);
			}
		}	
		list= limitutil.fy(icbcall,size,now);
		int q=icbcall.size()%size;
    	int totalpage=0;//总页数
    	if(q==0){
    		totalpage=icbcall.size()/size;	    		
    	}else{
    		totalpage=icbcall.size()/size+1;
    	} 
    	request.setAttribute("totalpage",totalpage);//总页数
    	request.setAttribute("size",size);//每页数量
    	request.setAttribute("now",now);//当前页
    	request.setAttribute("totalno",icbcall.size());//总数量
    	request.setAttribute("list",list);// 
    	request.setAttribute("bc_status",bc_status);//
    	request.setAttribute("pagesize",size);//
    	request.setAttribute("pagenow",now);//
		return "icbc";
	    }
		@RequestMapping(value="/icbcyl.do",produces="text/html;charset=UTF-8")	    
		public String icbcyl(
				String cardid,
				String type,
				HttpServletRequest request
				) throws UnsupportedEncodingException{	
			String name = "";
			if(request.getParameter("name")!=null&&!request.getParameter("name").equals("")){
				name= new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
			}
            request.setAttribute("name", name);
			request.setAttribute("cardid", cardid);
			request.setAttribute("type", type);
			if(type.equals("1")){
				return "yl_modal1";	
			}else
			if(type.equals("2")){
				return "yl_modal2";	
			}else	
			if(type.equals("3")){
				return "yl_modal3";	
			}else
			{
				return "yl_modal4";	
			}	
		}
		
		@RequestMapping(value="/icbcytoexamine.do",produces="text/html;charset=UTF-8")	    
		public String icbcytoexamine(int id,
				String bc_status,								
				HttpServletRequest request) throws UnsupportedEncodingException, MalformedURLException{
			String gname= new String(request.getParameter("gname").getBytes("ISO-8859-1"), "UTF-8");
			String pname= new String(request.getParameter("gname").getBytes("ISO-8859-1"), "UTF-8");
			icbc icbc=icbcservice.findicbcbyid(id);
			//征信图片
			List<Object> zxlist=new ArrayList<>();
			zxlist.add(icbc.getImgstep2_1());
			zxlist.add(icbc.getImgstep2_2());
			zxlist.add(icbc.getImgstep2_3());
			zxlist.add(icbc.getImgstep2_4());
			zxlist.add(icbc.getImgstep2_5());
			zxlist.removeAll(Collections.singleton(""));
			zxlist.removeAll(Collections.singleton(null));
			if(icbc.getImgstep2_5s()!=null&&!icbc.getImgstep2_5s().equals("")){
				String[] st=icbc.getImgstep2_5s().replace("["," ").replace("]"," ").split(",");
				for(int i=0;i<st.length;i++){
					zxlist.add(st[i]);
				}
			}
			List<Object> zxlist1=new ArrayList<>();
			if(zxlist.size()>0){
			for(int i=0;i<zxlist.size();i++){
				Map<Object, Object> m=new HashMap<>();
				m.put("path",zxlist.get(i));
				m.put("imgsize",getFileSize(zxlist.get(i).toString()));
				zxlist1.add(m);
			}
			}
			//开卡图片
			List<Object> kklist=new ArrayList<>();
			kklist.add(icbc.getImgstep3_1());
			kklist.add(icbc.getImgstep3_2());
			kklist.add(icbc.getImgstep3_3());
			kklist.add(icbc.getImgstep3_4());
			kklist.add(icbc.getImgstep3_5());
			kklist.add(icbc.getImgstep3_6());
			kklist.add(icbc.getImgstep3_7());						
			if(icbc.getImgstep2_8s()!=null&&!icbc.getImgstep2_8s().equals("")){
				String[] st=icbc.getImgstep2_8s().replace("["," ").replace("]"," ").split(",");
				for(int i=0;i<st.length;i++){
					kklist.add(st[i]);
				}
			}
			kklist.removeAll(Collections.singleton(""));
			kklist.removeAll(Collections.singleton(null));
			List<Object> kklist1=new ArrayList<>();
            if(kklist.size()>0){
			for(int i=0;i<kklist.size();i++){
				Map<Object, Object> m=new HashMap<>();
				m.put("path",kklist.get(i));
				m.put("imgsize",getFileSize(kklist.get(i).toString()));
				kklist1.add(m);
			}
            }
			//签访材料
			List<Object> qflist=new ArrayList<>();
			qflist.add(icbc.getImgstep4_1());
			qflist.add(icbc.getImgstep4_2());
			qflist.add(icbc.getImgstep4_3());
			qflist.add(icbc.getImgstep4_4());
			qflist.add(icbc.getImgstep4_5());
			qflist.add(icbc.getImgstep4_6());
			qflist.add(icbc.getImgstep4_7());
			qflist.add(icbc.getImgstep4_9());
			qflist.add(icbc.getImgstep4_10());
			qflist.add(icbc.getImgstep4_11());
			qflist.removeAll(Collections.singleton(""));
			qflist.removeAll(Collections.singleton(null));
			List<Object> qflist1=new ArrayList<>();
			if(qflist.size()>0){
			for(int i=0;i<qflist.size();i++){
				Map<Object, Object> m=new HashMap<>();
				m.put("path",qflist.get(i));
				m.put("imgsize",getFileSize(qflist.get(i).toString()));
				qflist1.add(m);
			}
			}
			//家访材料
			List<Object> jflist=new ArrayList<>();
			if(icbc.getImgstep5_1s()!=null&&!icbc.getImgstep5_1s().equals("")){
				String[] st=icbc.getImgstep5_1s().replace("["," ").replace("]"," ").split(",");
				for(int i=0;i<st.length;i++){
					jflist.add(st[i]);
				}
			}
			if(icbc.getImgstep5_2s()!=null&&!icbc.getImgstep5_2s().equals("")){
				String[] st=icbc.getImgstep5_2s().replace("["," ").replace("]"," ").split(",");
				for(int i=0;i<st.length;i++){
					jflist.add(st[i]);
				}
			}
			if(icbc.getImgstep5_3s()!=null&&!icbc.getImgstep5_3s().equals("")){
				String[] st=icbc.getImgstep5_3s().replace("["," ").replace("]"," ").split(",");
				for(int i=0;i<st.length;i++){
					jflist.add(st[i]);
				}
			}
			jflist.add(icbc.getImgstep5_4v());
			jflist.removeAll(Collections.singleton(""));
			jflist.removeAll(Collections.singleton(null));
			List<Object> jflist1=new ArrayList<>();
			if(jflist.size()>0){
			for(int i=0;i<jflist.size();i++){
				Map<Object, Object> m=new HashMap<>();
				m.put("path",jflist.get(i));
				m.put("imgsize",getFileSize(jflist.get(i).toString()));
				jflist1.add(m);
			}
			}
			//补充材料
			List<Object> bclist=new ArrayList<>();
			bclist.add(icbc.getImgstep6_1());
			bclist.add(icbc.getImgstep6_2());
			bclist.add(icbc.getImgstep6_3());
			bclist.add(icbc.getImgstep6_4());
			if(icbc.getImgstep6_5s()!=null&&!icbc.getImgstep6_5s().equals("")){
				String[] st=icbc.getImgstep6_5s().replace("["," ").replace("]"," ").split(",");
				for(int i=0;i<st.length;i++){
					bclist.add(st[i]);
				}
			}
			bclist.removeAll(Collections.singleton(""));
			bclist.removeAll(Collections.singleton(null));
			//System.out.println(bclist);
			List<Object> bclist1=new ArrayList<>();
			if(bclist.size()>0){
			for(int i=0;i<bclist.size();i++){
				Map<Object, Object> m=new HashMap<>();
				m.put("path",bclist.get(i));
				m.put("imgsize",getFileSize(bclist.get(i).toString()));
				bclist1.add(m);
			}			
   		    }
			List<icbc_result> irl=icbc_resultservice.findresultbyqryid(id);
			request.setAttribute("irl", irl);
			request.setAttribute("bclist1", bclist1);
			request.setAttribute("jflist1", jflist1);
			request.setAttribute("qflist1", qflist1);
			request.setAttribute("kklist1", kklist1);
			request.setAttribute("zxlist1", zxlist1);
			request.setAttribute("icbc", icbc);
			request.setAttribute("gname", gname);
			request.setAttribute("pname", pname);
			request.setAttribute("bc_status", bc_status);
			return "icbcform";
		}		
		@RequestMapping(value="/savetj.do",produces="multipart/form-data;charset=UTF-8")	    		
		public String savetj(
				String c_name,
				String c_cardno,
				String c_tel,
				String bc_status,
				String bc_status1,
				String remark,
				String id
				){
			icbc icbc=new icbc();
			icbc.setC_tel(c_tel);
			icbc.setC_cardno(c_cardno);
			icbc.setC_name(c_name);
			icbc.setBc_status(Integer.parseInt(bc_status));
			icbc.setId(Integer.parseInt(id));
			icbcservice.upicbc(icbc);
			icbc_result icbc_result=new icbc_result();
			icbc_result.setDt_add(creditutil.time());
			icbc_result.setDt_edit(creditutil.time());
			icbc_result.setMid_add(0);
			icbc_result.setMid_edit(0);
			icbc_result.setQryid(Integer.parseInt(id));
			icbc_result.setRemark(remark);
			icbc_result.setStatus(Integer.parseInt(bc_status));
			icbc_resultservice.addicbc_result(icbc_result);					
			if(bc_status1!=null&&!bc_status1.equals("")){
				return "redirect:/icbclist.do?bc_status="+bc_status1;		
			}else{
				return "redirect:/icbclist.do";
			}
			
		}
		
		@RequestMapping(value="/icbcdownload.do",produces="multipart/form-data;charset=UTF-8")
		public void icbcdownload(
				int id,
				String bc_status,	
				HttpServletRequest request, 
				HttpServletResponse response){
			icbc icbc=icbcservice.findicbcbyid(id);
			//征信图片
			List<Object> zxlist=new ArrayList<>();
			zxlist.add(icbc.getImgstep2_1());
			zxlist.add(icbc.getImgstep2_2());
			zxlist.add(icbc.getImgstep2_3());
			zxlist.add(icbc.getImgstep2_4());
			zxlist.add(icbc.getImgstep2_5());			
			if(icbc.getImgstep2_5s()!=null&&!icbc.getImgstep2_5s().equals("")){
				String[] st=icbc.getImgstep2_5s().replace("["," ").replace("]"," ").split(",");
				for(int i=0;i<st.length;i++){
					zxlist.add(st[i]);
				}
			}		
			zxlist.removeAll(Collections.singleton(""));
			zxlist.removeAll(Collections.singleton(null));
			//开卡图片
			List<Object> kklist=new ArrayList<>();
			kklist.add(icbc.getImgstep3_1());
			kklist.add(icbc.getImgstep3_2());
			kklist.add(icbc.getImgstep3_3());
			kklist.add(icbc.getImgstep3_4());
			kklist.add(icbc.getImgstep3_5());
			kklist.add(icbc.getImgstep3_6());
			kklist.add(icbc.getImgstep3_7());						
			if(icbc.getImgstep2_8s()!=null&&!icbc.getImgstep2_8s().equals("")){
				String[] st=icbc.getImgstep2_8s().replace("["," ").replace("]"," ").split(",");
				for(int i=0;i<st.length;i++){
					kklist.add(st[i]);
				}
			}
			kklist.removeAll(Collections.singleton(""));
			kklist.removeAll(Collections.singleton(null));
			//签访材料
			List<Object> qflist=new ArrayList<>();
			qflist.add(icbc.getImgstep4_1());
			qflist.add(icbc.getImgstep4_2());
			qflist.add(icbc.getImgstep4_3());
			qflist.add(icbc.getImgstep4_4());
			qflist.add(icbc.getImgstep4_5());
			qflist.add(icbc.getImgstep4_6());
			qflist.add(icbc.getImgstep4_7());
			qflist.add(icbc.getImgstep4_9());
			qflist.add(icbc.getImgstep4_10());
			qflist.add(icbc.getImgstep4_11());
			qflist.removeAll(Collections.singleton(""));
			qflist.removeAll(Collections.singleton(null));
			//家访材料
			List<Object> jflist=new ArrayList<>();
			if(icbc.getImgstep5_1s()!=null&&!icbc.getImgstep5_1s().equals("")){
				String[] st=icbc.getImgstep5_1s().replace("["," ").replace("]"," ").split(",");
				for(int i=0;i<st.length;i++){
					jflist.add(st[i]);
				}
			}
			if(icbc.getImgstep5_2s()!=null&&!icbc.getImgstep5_2s().equals("")){
				String[] st=icbc.getImgstep5_2s().replace("["," ").replace("]"," ").split(",");
				for(int i=0;i<st.length;i++){
					jflist.add(st[i]);
				}
			}
			if(icbc.getImgstep5_3s()!=null&&!icbc.getImgstep5_3s().equals("")){
				String[] st=icbc.getImgstep5_3s().replace("["," ").replace("]"," ").split(",");
				for(int i=0;i<st.length;i++){
					jflist.add(st[i]);
				}
			}
			jflist.add(icbc.getImgstep5_4v());
			jflist.removeAll(Collections.singleton(""));
			jflist.removeAll(Collections.singleton(null));
			//补充材料
			List<Object> bclist=new ArrayList<>();
			bclist.add(icbc.getImgstep6_1());
			bclist.add(icbc.getImgstep6_2());
			bclist.add(icbc.getImgstep6_3());
			bclist.add(icbc.getImgstep6_4());
			if(icbc.getImgstep6_5s()!=null&&!icbc.getImgstep6_5s().equals("")){
				String[] st=icbc.getImgstep6_5s().replace("["," ").replace("]"," ").split(",");
				for(int i=0;i<st.length;i++){
					bclist.add(st[i]);
				}
			}
			bclist.removeAll(Collections.singleton(""));
			bclist.removeAll(Collections.singleton(null));
			String downloadFilename1 = "征信.zip";//文件的名称 
			String downloadFilename2 = "开卡.zip";//文件的名称
			String downloadFilename3 = "签访.zip";//文件的名称
			String downloadFilename4 = "家访.zip";//文件的名称
			String downloadFilename5 = "补充.zip";//文件的名称
			if(zxlist.size()>0){
				icbcdownloadimg(request, response, downloadFilename1, zxlist);
			}
            if(kklist.size()>0){
            	icbcdownloadimg(request, response, downloadFilename2, kklist);
			}
            if(qflist.size()>0){
            	icbcdownloadimg(request, response, downloadFilename3, qflist);
            }
            if(jflist.size()>0){
            	icbcdownloadimg(request, response, downloadFilename4, jflist);
            }
            if(bclist.size()>0){
            	icbcdownloadimg(request, response, downloadFilename5, bclist);
            }

		}		
		public void icbcdownloadimg(HttpServletRequest request, 
				HttpServletResponse response,String downloadFilename,List list){			
			try {				            
                downloadFilename = URLEncoder.encode(downloadFilename,"UTF-8");//转换中文否则可能会产生乱码
                response.setContentType("application/octet-stream");// 指明response的返回对象是文件流
                response.setHeader("Content-Disposition","attachment;filename=" + downloadFilename);// 设置在下载框默认显示的文件名
                ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());               
                for (int i=0;i<list.size();i++) {
                    URL url = new URL((String) list.get(i));
                   zos.putNextEntry(new ZipEntry(i+".jpg"));
                   //FileInputStream fis = new FileInputStream(new File(files[i])); 
                   InputStream fis = url.openConnection().getInputStream();  
                   byte[] buffer = new byte[1024];    
                   int r = 0;    
                   while ((r = fis.read(buffer)) != -1) {    
                       zos.write(buffer, 0, r);    
                   }    
                   fis.close();  
                  } 
                zos.flush();    
                zos.close();
            } catch (UnsupportedEncodingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }  
		
			
			
		}
		public static void main(String[] args) {
//			String s="[http://apitest.kcway.net/image/upload/img/suppily20180314170012suppily0.jpg, http://apitest.kcway.net/image/upload/img/suppily20180314170012suppily1.jpg, http://apitest.kcway.net/image/upload/img/suppily20180314170012suppily2.jpg, http://apitest.kcway.net/image/upload/img/suppily20180314170012suppily3.jpg]";
//		    
//		    System.out.println(s.replace("["," ").replace("]", " "));
//		    String[] st=s.split(",");
//		    System.out.println(st[1]);
//			List<Object> zxlist=new ArrayList<>();
//			zxlist.add("");
//			zxlist.add("2");
//			zxlist.add("31");
//			zxlist.add("31");
//			zxlist.add("");
//			zxlist.removeAll(Collections.singleton("")); 
//			zxlist.removeAll(Collections.singleton(null)); 
//			System.out.println(zxlist);
			 try {
				   System.out.println(getFileSize("http://aptest.kcway.net/image/upload/img/20180104/89bad2b093a24768a14d65cd3c86f90220180104.jpg"));
				  } catch (Exception e) {
				   e.printStackTrace();
				  }
		}
		
		/**
		  * get file size 通过URL地址获取文件大小
		  * @param filePath * url file path
		  * @return filesize
		  * @throws MalformedURLException
		  */
		 public static String getFileSize(String filePath) throws MalformedURLException{
		  HttpURLConnection urlcon = null;
		  String size="";
		  //format double
		  java.text.DecimalFormat fnum = new java.text.DecimalFormat("#0.00");
		  //create url link
		  URL url=new URL(filePath);
		  try {
		   //open url
		   urlcon = (HttpURLConnection)url.openConnection();
		   //get url properties
		   double filesize=urlcon.getContentLength();
		   if(filesize>0){
			   //System.out.println(filesize);
			   //format output
			   size=fnum.format(filesize/1024/1024);  
		   }else{
			   size="0.00";
			   return size;  
		   }
		   
		  } catch (IOException e) {
		   e.printStackTrace();
		  } finally{
		   //close connect
		   urlcon.disconnect();
		  }
		  return size;
		 }

}
