package com.controller.icbc.jsp;




import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.model.apply;
import com.model.icbc.assess_cars;
import com.model.icbc.assess_cars_item;
import com.model.icbc.bclient_check;
import com.model.icbc.icbc;
import com.model.icbc.icbc_kk;
import com.model.index.zxexcel;
import com.model.jbapi.jbzxapiuser;
import com.model.newAdd.pdfdownload;
import com.model1.icbc.icbc_dk;
import com.model1.icbc.icbc_mq;
import com.service1.car.icbc_carsService;
import com.service1.car.newassess_cars_itemService;
import com.service1.kjs_icbc.icbc_dkService;
import com.service1.kjs_icbc.icbc_mqService;
import com.service1.kjs_icbc.newicbcService;
import com.service1.kjs_icbc.newicbc_kkService;
import com.util.creditutil;
import com.util.imgutil;
import com.util.limitutil;
import com.util.newAdd.UrlFilesToZip;

import junit.framework.Assert;


@Controller
public class downallfileController {

	@Autowired
	private newicbcService newicbcService;
	
	//服务器地址:/KCDIMG/assess/upload/
	@Autowired
	private newicbc_kkService newicbc_kkService;
	
	
	@RequestMapping(value="/icbc_pdf.do",produces="text/html;charset=UTF-8")
	public void icbc_pdf(
	             MultipartFile pdf,
	             int id,
				 HttpServletResponse response,
				 HttpServletRequest request
			)throws IOException{
		Date date = new Date(); 
//		String filePath = "E:/快加项目/carsassess/"+new SimpleDateFormat("yyyy/MM/dd/").format(date);        
        String filePath = "/KCDIMG/assess/upload/"+new SimpleDateFormat("yyyy/MM/dd/").format(date);
        String imgpath="upload/"+new SimpleDateFormat("yyyy/MM/dd/").format(date);
        File f = new File(imgpath);
        if(!f.exists()){  
            f.mkdirs();   
        }
       String filename = pdf.getOriginalFilename();
       String prefix=filename.substring(filename.lastIndexOf(".")+1);
       UUID uuid = UUID.randomUUID();
       String uuidname=uuid.toString().replaceAll("-","")+"."+prefix;        	
       byte[] file36Byte = pdf.getBytes();
       FileUtils.writeByteArrayToFile(new File(filePath+uuidname),file36Byte);              
       icbc_kk icbc_kk=new icbc_kk();
       icbc_kk.setPdfstep4_1(imgpath+uuidname);
       icbc_kk.setId(id);
       icbc_kk.setPdf_time(creditutil.time());
       newicbc_kkService.upicbc_kk(icbc_kk);

		
		
	}
	
	
	
	public static void main(String[] args) {
		Calendar date=Calendar.getInstance();
		SimpleDateFormat format1=new SimpleDateFormat( "yyyy ");
		SimpleDateFormat format2=new SimpleDateFormat( "MM ");
		SimpleDateFormat format3=new SimpleDateFormat( "dd ");
		String name1=format1.format(date.getTime());
		String name2=format2.format(date.getTime());
		String name3=format3.format(date.getTime());
		Date date1 = new Date();
		System.out.println(new SimpleDateFormat("yyyy/MM/dd/").format(new Date()));
//		File file1=new File( "c:/ "+name1);
//		File file2=new File( "c:/ "+name1+"/"+name2);
//		File file3=new File( "c:/ "+name1+"/"+name2+"/"+name3);
//		file1.mkdir();
//		file2.mkdir();
//		file3.mkdir(); 
//		System.out.println(name1+name2+name3);
		String string="http://a.kcway.net/assess/upload/2018/06/19/7436b8149ed914044634201d57d12489.mp4";
         System.out.println(string.substring(string.lastIndexOf(".")));      
		//		boolean res=string.contains("assess/");
//		System.out.println(res);
//		
//		//System.out.println(string.substring(0,1)+"*"+string.substring(2,string.length()));
//		System.out.println(string.substring(0,string.lastIndexOf("/")+1));
//		System.out.println(string.substring(string.lastIndexOf("/")+1, string.length()));
//		if(res){
//			System.out.println(string.replace("assess/", ""));	
//		}
		
	}
	/**
	 * 图片旋转
	 * @param imgname
	 * @param timenum
	 * @param fr
	 * @return
	 */
	@RequestMapping(value="/icbc_img.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public void icbc_img(String imgpath,int fr){				
		  try {
			  boolean res=imgpath.contains("assess/");
			  if(res){
			  imgpath=imgpath.replace("assess/", ""); 
			  }
			 String imgtype=imgpath.substring(imgpath.lastIndexOf(".")+1, imgpath.length());
			 System.out.println(imgtype);
			 BufferedImage src =ImageIO.read(new File("/KCDIMG/assess/"+imgpath));
			 if(fr==1){
				 BufferedImage des=imgutil.Rotate(src,270);
				 Assert.assertNotNull(des);  
			     Assert.assertTrue(ImageIO.write(des,imgtype,new File("/KCDIMG/assess/"+imgpath)));  
			 }
			 if(fr==2){
				 BufferedImage des=imgutil.Rotate(src,90);
				 Assert.assertNotNull(des);  
			     Assert.assertTrue(ImageIO.write(des,imgtype, new File("/KCDIMG/assess/"+imgpath)));  			
			 }		
		     
			 } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	@RequestMapping(value = "downloadFile_all.do")
    public void downloadFile_all(String type,int id,
    		HttpServletRequest request,HttpServletResponse response
    		) throws Exception {		
		//System.out.println(downloadCompany+"----"+downloadNum+"----"+downloadCzr);
		        response.setContentType("text/html;charset=UTF-8");  
		        List<imgfile> FileNameList =new ArrayList<imgfile>(); 
		        
				//随机生成名字
		        String base_name =UUID.randomUUID().toString().replaceAll("-","");		
				//得到要下载的文件名字
		        if(type.equals("icbc")){     
				icbc icbc= newicbcService.findicbcbyid(id);
				if(icbc!=null&&!icbc.equals("")){
					if(icbc.getImgstep2_1()!=null&&!icbc.getImgstep2_1().equals("")){
					imgfile imgfile=new imgfile();	
					imgfile.setImgurl("http://a.kcway.net/assess/"+icbc.getImgstep2_1());
					imgfile.setName("身份证正面");
					FileNameList.add(imgfile);
					}
					if(icbc.getImgstep2_2()!=null&&!icbc.getImgstep2_2().equals("")){
						imgfile imgfile=new imgfile();
						imgfile.setImgurl("http://a.kcway.net/assess/"+icbc.getImgstep2_2());
						imgfile.setName("身份证反面");
						FileNameList.add(imgfile);
					}
					if(icbc.getImgstep2_3()!=null&&!icbc.getImgstep2_3().equals("")){
						imgfile imgfile=new imgfile();
						imgfile.setImgurl("http://a.kcway.net/assess/"+icbc.getImgstep2_3());
						imgfile.setName("手持身份证授权书 _面签");
						FileNameList.add(imgfile);
					}
					if(icbc.getImgstep2_4()!=null&&!icbc.getImgstep2_4().equals("")){
						imgfile imgfile=new imgfile();
						imgfile.setImgurl("http://a.kcway.net/assess/"+icbc.getImgstep2_4());
						imgfile.setName("手持身份证授权书 _面签");
						FileNameList.add(imgfile);
					}
					if(icbc.getImgstep2_5()!=null&&!icbc.getImgstep2_5().equals("")){
						imgfile imgfile=new imgfile();
						imgfile.setImgurl("http://a.kcway.net/assess/"+icbc.getImgstep2_5());
						imgfile.setName("授权书");
						FileNameList.add(imgfile);
					}
					if(icbc.getImgstep2_5s()!=null&&!icbc.getImgstep2_5s().equals("")){
						String[] iS=icbc.getImgstep2_5s().split("");
						if(iS.length>0){
							for(int i=0;i<iS.length;i++){
								imgfile imgfile=new imgfile();
								imgfile.setImgurl("http://a.kcway.net/assess/"+iS[i]);
								imgfile.setName("补充材料"+i+1);
								FileNameList.add(imgfile);
							}
						}
						
					}
				}
	        	
	        }
				// 把全部的文件放进文件数组中  File[]  files
				int leng = FileNameList.size();
				InputStream inputStream = null;
				DataInputStream in = null;
				URL url=null;
				OutputStream os=null;
				ByteArrayOutputStream bos=null;
				try {					   
					   bos = new ByteArrayOutputStream();
					   ZipOutputStream zos = new ZipOutputStream(bos);
					   UrlFilesToZip s = new UrlFilesToZip();
					   int idx = 1;
					   // int size=0;
					   for (imgfile imgfile1:FileNameList) {			    
					    byte[] bytes=null;			    
					    bytes = s.getImageFromURL(imgfile1.getImgurl());				    
					    zos.putNextEntry(new ZipEntry("征信材料/"+imgfile1.getName()+".jpg"));
					    zos.write(bytes, 0, bytes.length);
					    //size=size+bytes.length;
						zos.closeEntry();
					    idx++;	
					   }			
					   zos.close();
					   response.setContentType("application/force-download");// 设置强制下载不打开
					   response.addHeader("Content-Disposition","attachment;fileName="+base_name+".zip");// 设置文件名			   			  
					   os = response.getOutputStream();
					   os.write(bos.toByteArray());	               			   
					   os.close();
					   bos.close();			   
						//request.setAttribute("error","下载成功！");
				    } catch (Exception ex) {
					   ex.printStackTrace();
					   ServletOutputStream sos = null;  
		               try {  
		                   //response.setContentType("text/html;charset=utf-8");  
		                   sos = response.getOutputStream();  
		                   sos.write("<script>alert('下载失败，请与管理员联系~~');</script>".getBytes("UTF-8"));
		                   sos.flush();  
		               } catch (IOException e1) {  
		                   e1.printStackTrace();  
		               }finally{  
		                   if(null != sos){  
		                       try {  
		                           sos.close();  
		                       } catch (IOException e1) {  
		                           e1.printStackTrace();  
		                       }  
		                   }  
		               } 
				    }finally{
				    	if(os!=null){
				    		os.close();
				    	}
				    	if(bos!=null){
				    		bos.close();	
				    	}
				    	
				    }
		
		
	}
	
	@Autowired
	private icbc_carsService icbc_carsService;
	@Autowired
	private newassess_cars_itemService newassess_cars_itemService;
	@Autowired
	private icbc_mqService icbc_mqService;
	@Autowired
	private icbc_dkService icbc_dkService;
	
	@RequestMapping(value = "downloadFiles_all.do")
    public void downloadFiles_all(String type,int id,
    		HttpServletRequest request,HttpServletResponse response
    		) throws Exception {
		System.out.println(type);
		//System.out.println(downloadCompany+"----"+downloadNum+"----"+downloadCzr);
		        response.setContentType("text/html;charset=UTF-8");  
		        List<imgfile> FileNameList =new ArrayList<imgfile>(); 		        
				//随机生成名字
		        String base_name =UUID.randomUUID().toString().replaceAll("-","");		
				//得到要下载的文件名字
		        if(type.equals("pg")){     
		        assess_cars assess_cars=icbc_carsService.findicbc_cars(id);
				if(assess_cars!=null&&!assess_cars.equals("")){
					List<assess_cars_item> aList=newassess_cars_itemService.findicbc_carsimg(assess_cars.getId());				
					if(aList!=null&&aList.size()>0){			
							for(int i=0;i<aList.size();i++){
								assess_cars_item aci=aList.get(i);
								if(aci.getBcimg()!=null&&!aci.getBcimg().equals("")){
									imgfile imgfile=new imgfile();
									imgfile.setImgurl("http://a.kcway.net/"+aci.getBcimg());
									if(i<7){
										imgfile.setName("车辆资料/img"+i+1);
									}else{
										imgfile.setName("车辆照片/img"+i+1);
									} 
									imgfile.setFilelast(aci.getBcimg().substring(aci.getBcimg().lastIndexOf(".")+1,aci.getBcimg().length()));
									FileNameList.add(imgfile);	
								}
						 }						
					 }
				}
	            }
		        if(type.equals("mq")){
		        	System.out.println(type);
		          icbc_mq icbc_mq=icbc_mqService.findmqbyicbc(id);
		        	if(icbc_mq!=null&&!icbc_mq.equals("")){
		        		if(icbc_mq.getImgstep8_1v()!=null&&!icbc_mq.getImgstep8_1v().equals("")){
		        			imgfile imgfile=new imgfile();
							imgfile.setImgurl("http://a.kcway.net/assess/"+icbc_mq.getImgstep8_1v());
							imgfile.setName("mov1");
							imgfile.setFilelast(icbc_mq.getImgstep8_1v().substring(icbc_mq.getImgstep8_1v().lastIndexOf(".")+1, icbc_mq.getImgstep8_1v().length()));
							FileNameList.add(imgfile);	
		        		}
		        		if(icbc_mq.getImgstep8_2v()!=null&&!icbc_mq.getImgstep8_2v().equals("")){
		        			imgfile imgfile=new imgfile();
							imgfile.setImgurl("http://a.kcway.net/assess/"+icbc_mq.getImgstep8_2v());
							imgfile.setName("mov2");
							imgfile.setFilelast(icbc_mq.getImgstep8_2v().substring(icbc_mq.getImgstep8_2v().lastIndexOf(".")+1, icbc_mq.getImgstep8_2v().length()));
							
							FileNameList.add(imgfile);	
		        		}
		        		if(icbc_mq.getImgstep8_3v()!=null&&!icbc_mq.getImgstep8_3v().equals("")){
		        			imgfile imgfile=new imgfile();
							imgfile.setImgurl("http://a.kcway.net/assess/"+icbc_mq.getImgstep8_3v());
							imgfile.setName("mov3");
							imgfile.setFilelast(icbc_mq.getImgstep8_3v().substring(icbc_mq.getImgstep8_3v().lastIndexOf(".")+1, icbc_mq.getImgstep8_3v().length()));
							
							FileNameList.add(imgfile);	
		        		}
		        		if(icbc_mq.getImgstep8_4v()!=null&&!icbc_mq.getImgstep8_4v().equals("")){
		        			imgfile imgfile=new imgfile();
							imgfile.setImgurl("http://a.kcway.net/assess/"+icbc_mq.getImgstep8_4v());
							imgfile.setName("mov4");
							imgfile.setFilelast(icbc_mq.getImgstep8_4v().substring(icbc_mq.getImgstep8_4v().lastIndexOf(".")+1, icbc_mq.getImgstep8_4v().length()));							
							FileNameList.add(imgfile);	
		        		}
		        	}
		        }
		        if(type.equals("kk")){
			          icbc_kk icbc_kk=newicbc_kkService.findicbc_kkbyid(id);
			        	if(icbc_kk!=null&&!icbc_kk.equals("")){
			        		if(icbc_kk.getImgstep3_1()!=null&&!icbc_kk.getImgstep3_1().equals("")){
			        			imgfile imgfile=new imgfile();
								imgfile.setImgurl("http://a.kcway.net/assess/"+icbc_kk.getImgstep3_1());
								imgfile.setName("img1");
								imgfile.setFilelast(icbc_kk.getImgstep3_1().substring(icbc_kk.getImgstep3_1().lastIndexOf(".")+1, icbc_kk.getImgstep3_1().length()));								
								FileNameList.add(imgfile);	
			        		}
			        		if(icbc_kk.getImgstep3_2()!=null&&!icbc_kk.getImgstep3_2().equals("")){
			        			imgfile imgfile=new imgfile();
								imgfile.setImgurl("http://a.kcway.net/assess/"+icbc_kk.getImgstep3_2());
								imgfile.setName("img2");
								imgfile.setFilelast(icbc_kk.getImgstep3_2().substring(icbc_kk.getImgstep3_2().lastIndexOf(".")+1, icbc_kk.getImgstep3_2().length()));
								
								FileNameList.add(imgfile);	
			        		}
			        		if(icbc_kk.getImgstep3_3()!=null&&!icbc_kk.getImgstep3_3().equals("")){
			        			imgfile imgfile=new imgfile();
								imgfile.setImgurl("http://a.kcway.net/assess/"+icbc_kk.getImgstep3_3());
								imgfile.setName("img3");
								imgfile.setFilelast(icbc_kk.getImgstep3_3().substring(icbc_kk.getImgstep3_3().lastIndexOf(".")+1, icbc_kk.getImgstep3_3().length()));
								FileNameList.add(imgfile);	
			        		}
			        		if(icbc_kk.getImgstep3_4()!=null&&!icbc_kk.getImgstep3_4().equals("")){
			        			imgfile imgfile=new imgfile();
								imgfile.setImgurl("http://a.kcway.net/assess/"+icbc_kk.getImgstep3_4());
								imgfile.setName("img4");
								imgfile.setFilelast(icbc_kk.getImgstep3_4().substring(icbc_kk.getImgstep3_4().lastIndexOf(".")+1, icbc_kk.getImgstep3_4().length()));
								
								FileNameList.add(imgfile);	
			        		}
			        		if(icbc_kk.getImgstep3_5()!=null&&!icbc_kk.getImgstep3_5().equals("")){
			        			imgfile imgfile=new imgfile();
								imgfile.setImgurl("http://a.kcway.net/assess/"+icbc_kk.getImgstep3_5());
								imgfile.setName("img5");
								imgfile.setFilelast(icbc_kk.getImgstep3_5().substring(icbc_kk.getImgstep3_5().lastIndexOf(".")+1, icbc_kk.getImgstep3_5().length()));
								
								FileNameList.add(imgfile);	
			        		}
			        		if(icbc_kk.getImgstep3_6()!=null&&!icbc_kk.getImgstep3_6().equals("")){
			        			imgfile imgfile=new imgfile();
								imgfile.setImgurl("http://a.kcway.net/assess/"+icbc_kk.getImgstep3_6());
								imgfile.setName("img6");
								imgfile.setFilelast(icbc_kk.getImgstep3_6().substring(icbc_kk.getImgstep3_6().lastIndexOf(".")+1, icbc_kk.getImgstep3_6().length()));
								
								FileNameList.add(imgfile);	
			        		}
			        		if(icbc_kk.getImgstep3_7()!=null&&!icbc_kk.getImgstep3_7().equals("")){
			        			imgfile imgfile=new imgfile();
								imgfile.setImgurl("http://a.kcway.net/assess/"+icbc_kk.getImgstep3_7());
								imgfile.setName("img7");
								imgfile.setFilelast(icbc_kk.getImgstep3_7().substring(icbc_kk.getImgstep3_7().lastIndexOf(".")+1, icbc_kk.getImgstep3_7().length()));								
								FileNameList.add(imgfile);	
			        		}
			        		if(icbc_kk.getImgstep3_71()!=null&&!icbc_kk.getImgstep3_71().equals("")){
			        			imgfile imgfile=new imgfile();
								imgfile.setImgurl("http://a.kcway.net/assess/"+icbc_kk.getImgstep3_71());
								imgfile.setName("img71");
								imgfile.setFilelast(icbc_kk.getImgstep3_71().substring(icbc_kk.getImgstep3_71().lastIndexOf(".")+1, icbc_kk.getImgstep3_71().length()));								
								FileNameList.add(imgfile);	
			        		}
			        		if(icbc_kk.getImgstep3_72()!=null&&!icbc_kk.getImgstep3_72().equals("")){
			        			imgfile imgfile=new imgfile();
								imgfile.setImgurl("http://a.kcway.net/assess/"+icbc_kk.getImgstep3_72());
								imgfile.setName("img72");
								imgfile.setFilelast(icbc_kk.getImgstep3_72().substring(icbc_kk.getImgstep3_72().lastIndexOf(".")+1, icbc_kk.getImgstep3_72().length()));								
								FileNameList.add(imgfile);	
			        		}
			        		if(icbc_kk.getImgstep3_7s()!=null&&!icbc_kk.getImgstep3_7s().equals("")){
			        			String[] imgs=icbc_kk.getImgstep3_7s().split("");
			        	        if(imgs.length>0){		  
			        	        	for(int i=0;i<imgs.length;i++){
			        	        		if(imgs[i]!=null&&!imgs[i].equals("")){
			        	        			imgfile imgfile=new imgfile();
											imgfile.setImgurl("http://a.kcway.net/assess/"+imgs[i]);
											imgfile.setName("img7s"+i);
											imgfile.setFilelast(imgs[i].substring(imgs[i].lastIndexOf(".")+1,imgs[i].length()));
											FileNameList.add(imgfile);	
			        	        		}
			        	        		
			        	        	}
			        	        	
			        	        }  
			        				
			        		}
			        	}
			        }
		        if(type.equals("dk")){
		        	icbc_dk  icbc_dk=icbc_dkService.finddkbyorder(id);
		        	if(icbc_dk!=null&&!icbc_dk.equals("")){		        		
		        		String imgss=icbc_dk.getImgstep4_1ss()
		        				   +icbc_dk.getImgstep4_2ss()
		        				   +icbc_dk.getImgstep4_3ss()
		        				   +icbc_dk.getImgstep4_4ss()
		        				   +icbc_dk.getImgstep4_5ss();
		        		if(imgss!=null&&!imgss.equals("")){
		        			String[] imgs=imgss.split("");
		        	        if(imgs.length>0){		  
		        	        	for(int i=0;i<imgs.length;i++){
		        	        		if(imgs[i]!=null&&!imgs[i].equals("")){
		        	        			imgfile imgfile=new imgfile();
										imgfile.setImgurl("http://a.kcway.net/assess/"+imgs[i]);
										imgfile.setName("合同材料/img4_1ss"+i);
										imgfile.setFilelast(imgs[i].substring(imgs[i].lastIndexOf(".")+1,imgs[i].length()));
										FileNameList.add(imgfile);	
		        	        		}
		        	        		
		        	        	}
		        	        	
		        	        }  
		        		}
		        		if(icbc_dk.getImgstep5_1ss()!=null&&!icbc_dk.getImgstep5_1ss().equals("")){
		        			String[] imgs=icbc_dk.getImgstep5_1ss().split("");
		        	        if(imgs.length>0){		  
		        	        	for(int i=0;i<imgs.length;i++){
		        	        		if(imgs[i]!=null&&!imgs[i].equals("")){
		        	        			imgfile imgfile=new imgfile();
										imgfile.setImgurl("http://a.kcway.net/assess/"+imgs[i]);
										imgfile.setName("证明材料/img5_1ss"+i);
										imgfile.setFilelast(imgs[i].substring(imgs[i].lastIndexOf(".")+1,imgs[i].length()));
										FileNameList.add(imgfile);	
		        	        		}
		        	        		
		        	        	}
		        	        	
		        	        }  
		        		}
		        		if(icbc_dk.getImgstep6_1ss()!=null&&!icbc_dk.getImgstep6_1ss().equals("")){
		        			String[] imgs=icbc_dk.getImgstep6_1ss().split("");
		        	        if(imgs.length>0){		  
		        	        	for(int i=0;i<imgs.length;i++){
		        	        		if(imgs[i]!=null&&!imgs[i].equals("")){
		        	        			imgfile imgfile=new imgfile();
										imgfile.setImgurl("http://a.kcway.net/assess/"+imgs[i]);
										imgfile.setName("其他材料/img6_1ss"+i);
										imgfile.setFilelast(imgs[i].substring(imgs[i].lastIndexOf(".")+1,imgs[i].length()));
										FileNameList.add(imgfile);	
		        	        		}
		        	        		
		        	        	}
		        	        	
		        	        }  
		        		}
		        		if(icbc_dk.getImgstep7_1ss()!=null&&!icbc_dk.getImgstep7_1ss().equals("")){
		        			String[] imgs=icbc_dk.getImgstep7_1ss().split("");
		        	        if(imgs.length>0){		  
		        	        	for(int i=0;i<imgs.length;i++){
		        	        		if(imgs[i]!=null&&!imgs[i].equals("")){
		        	        			imgfile imgfile=new imgfile();
										imgfile.setImgurl("http://a.kcway.net/assess/"+imgs[i]);
										imgfile.setName("补充材料/img7_1ss"+i);
										imgfile.setFilelast(imgs[i].substring(imgs[i].lastIndexOf(".")+1,imgs[i].length()));
										FileNameList.add(imgfile);	
		        	        		}
		        	        		
		        	        	}
		        	        	
		        	        }  
		        		}
		        	}	
		        }
				// 把全部的文件放进文件数组中  File[]  files
				int leng = FileNameList.size();
				System.out.println(leng);
				InputStream inputStream = null;
				DataInputStream in = null;
				URL url=null;
				OutputStream os=null;
				ByteArrayOutputStream bos=null;
				try {					   
					   bos = new ByteArrayOutputStream();
					   ZipOutputStream zos = new ZipOutputStream(bos);
					   UrlFilesToZip s = new UrlFilesToZip();
					   int idx = 1;
					   // int size=0;
					   for (imgfile imgfile1:FileNameList) {			    
					    byte[] bytes=null;			    
					    bytes = s.getImageFromURL(imgfile1.getImgurl());				    
					    zos.putNextEntry(new ZipEntry(imgfile1.getName()+"."+imgfile1.getFilelast()));
					    zos.write(bytes,0,bytes.length);
					    //size=size+bytes.length;
						zos.closeEntry();
					    idx++;	
					   }			
					   zos.close();
					   response.setContentType("application/force-download");// 设置强制下载不打开
					   response.addHeader("Content-Disposition","attachment;fileName="+base_name+".zip");// 设置文件名			   			  
					   os = response.getOutputStream();
					   os.write(bos.toByteArray());	               			   
					   os.close();
					   bos.close();			   
						//request.setAttribute("error","下载成功！");
				    } catch (Exception ex) {
					   ex.printStackTrace();
					   ServletOutputStream sos = null;  
		               try {  
		                   //response.setContentType("text/html;charset=utf-8");  
		                   sos = response.getOutputStream();  
		                   sos.write("<script>alert('下载失败，请与管理员联系~~');</script>".getBytes("UTF-8"));
		                   sos.flush();  
		               } catch (IOException e1) {  
		                   e1.printStackTrace();  
		               }finally{  
		                   if(null != sos){  
		                       try {  
		                           sos.close();  
		                       } catch (IOException e1) {  
		                           e1.printStackTrace();  
		                       }  
		                   }  
		               } 
				    }finally{
				    	if(os!=null){
				    		os.close();
				    	}
				    	if(bos!=null){
				    		bos.close();	
				    	}
				    	
				    }
		
		
	}
	
	
	/**
     * TODO 下载文件到本地
     * @author nadim  
     * @date Sep 11, 2015 11:45:31 AM
     * @param fileUrl 远程地址
     * @param fileLocal 本地路径
     * @throws Exception 
     */
	@RequestMapping(value = "downloadFile.do")
    public void downloadFile(String fileUrl,String fileName,
    		HttpServletRequest request,HttpServletResponse response
    		) throws Exception {        
		String pString=fileUrl.substring(fileUrl.lastIndexOf("."));
		System.out.println(pString);
        response.setContentType("text/html;charset=UTF-8");     
        BufferedInputStream in = null;    
        BufferedOutputStream out = null;   
        URL url = new URL(fileUrl);
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        urlCon.setConnectTimeout(6000);
        urlCon.setReadTimeout(6000);
        int code = urlCon.getResponseCode();
        if (code != HttpURLConnection.HTTP_OK) {
            throw new Exception("文件读取失败");
        }
        try { 
        response.setContentType("multipart/form-data");    
        response.setCharacterEncoding("UTF-8");    
        response.setHeader("Content-Disposition", "attachment; filename="+fileName+pString);    
        response.setHeader("Content-Length",String.valueOf(urlCon.getContentLength()));    
        in = new BufferedInputStream(urlCon.getInputStream());    
        out = new BufferedOutputStream(response.getOutputStream());    
        byte[] data = new byte[1024];    
        int len = 0;    
        while (-1 != (len=in.read(data, 0, data.length))) {    
            out.write(data, 0, len);    
        }  
        System.out.println("下载成功");
    } catch (Exception e) {    
        e.printStackTrace();    
    } finally {    
        if (in != null) {    
            in.close();    
        }    
        if (out != null) { 
        	out.flush();
            out.close();    
        }    
    }    
	}
    @Autowired
    private com.service.zx.jbzxapiuserService jbzxapiuserService;
	@RequestMapping(value = "toExcel.do",produces = "text/html;charset=UTF-8")
    public void toExcel(
    		String time,
     		String querytype,
     		String bc_status,
     		String gems_fs_id, 
     		String book_status, 
     		String card_status, 
     		String icbcname,
     		String type,
    		HttpServletRequest request,HttpServletResponse response
    		) throws Exception {  
		int querytype1 = 0;
		int bc_status1 = 0;
	  if(type.equals("search")){
			 String time1 = null;
			 String time2= null;
		if(time!=null&&!time.equals("")){
			String[] strings=time.trim().split("-");
			time1=strings[0];
			time2=strings[1].trim();		 
		}	 
		 int gems_fs_id1= 0; 
		 int book_status1= 0; 
		 int card_status1= 0;
		 
		 if(querytype!=null&&!querytype.equals("")){
			 querytype1=Integer.parseInt(querytype);
		 }
	     if(bc_status!=null&&!bc_status.equals("")){
	    	 bc_status1=Integer.parseInt(bc_status);
		 }
	     if(gems_fs_id!=null&&!gems_fs_id.equals("")){
	    	 gems_fs_id1=Integer.parseInt(gems_fs_id);
	    }
	     if(book_status!=null&&!book_status.equals("")){
	    	 book_status1=Integer.parseInt(book_status);
	    }
	     if(card_status!=null&&!card_status.equals("")){
	    	 querytype1=Integer.parseInt(card_status);
	     }	
		 List<icbc> iList= newicbcService.searchicbc(time1,
				 time2,
				 querytype1,
				 bc_status1,
				 gems_fs_id1, 
				 book_status1, 
				 card_status1, 
				 new String(icbcname.getBytes("iso-8859-1"),"UTF-8")
				 );
		 System.out.println(new String(icbcname.getBytes("iso-8859-1"),"UTF-8")+"---------------");
		 System.out.println(iList.size());
		 List<zxexcel> iList1=new ArrayList<>();
		 if(querytype1==2){
 			if(iList.size()>0){
 				for(int i=0;i<iList.size();i++){
 					icbc icbc=iList.get(i);
 					jbzxapiuser jau=jbzxapiuserService.findapiuserbyid(icbc.getApi_add());	
 					if(jau!=null&&!jau.equals("")){
 						icbc.setGname(jau.getApi_companyname());
 						icbc.setPname(jau.getApi_name());
 					}
 					zxexcel zxexcel=new zxexcel();
 					zxexcel.setShname(icbc.getGname());
 					zxexcel.setAddtime(icbc.getDt_add());
 					zxexcel.setStatus(String.valueOf(icbc.getBc_status()));
 					zxexcel.setCzr(icbc.getPname());
 					zxexcel.setKhname(icbc.getC_name());
 					iList1.add(zxexcel);				
 				}    				
 			}  
 			toxxexcel(iList1, response);
 	   }else{
 		for(int i=0;i<iList.size();i++){
 			icbc icbc=iList.get(i);
 			if(icbc.getQuerytype()==2){					
					jbzxapiuser jau=jbzxapiuserService.findapiuserbyid(icbc.getApi_add());	
					if(jau!=null&&!jau.equals("")){
						icbc.setGname(jau.getApi_companyname());
						icbc.setPname(jau.getApi_name());
				}
 			}
 			zxexcel zxexcel=new zxexcel();
 			zxexcel.setShname(icbc.getGname());
 			zxexcel.setAddtime(icbc.getDt_add());
 			zxexcel.setStatus(String.valueOf(icbc.getBc_status()));
 			zxexcel.setCzr(icbc.getPname());
 			zxexcel.setKhname(icbc.getC_name());
 			iList1.add(zxexcel);
 		} 
 		toxxexcel(iList1, response);
 	    }
		 
	  }	
      if(type.equals("icbc")){
    	  if(querytype!=null&&!querytype.equals("")){
    		  querytype1=Integer.parseInt(querytype);  
    	  }
    	  if(bc_status!=null&&!bc_status.equals("")){
    		  bc_status1=Integer.parseInt(bc_status);  
    	  }
    	 List<zxexcel> iList1=new ArrayList<>();
    	 List<icbc> iList=newicbcService.findicbc(querytype1, bc_status1);
    	 if(querytype1==2){
    			if(iList.size()>0){
    				for(int i=0;i<iList.size();i++){
    					icbc icbc=iList.get(i);
    					jbzxapiuser jau=jbzxapiuserService.findapiuserbyid(icbc.getApi_add());	
    					if(jau!=null&&!jau.equals("")){
    						icbc.setGname(jau.getApi_companyname());
    						icbc.setPname(jau.getApi_name());
    					}
    					zxexcel zxexcel=new zxexcel();
    					zxexcel.setShname(icbc.getGname());
    					zxexcel.setAddtime(icbc.getDt_add());
    					zxexcel.setStatus(String.valueOf(icbc.getBc_status()));
    					zxexcel.setCzr(icbc.getPname());
    					zxexcel.setKhname(icbc.getC_name());
    					iList1.add(zxexcel);				
    				}    				
    			}    			
    	}else{
    		for(int i=0;i<iList.size();i++){
    			icbc icbc=iList.get(i);
    			if(icbc.getQuerytype()==2){					
					jbzxapiuser jau=jbzxapiuserService.findapiuserbyid(icbc.getApi_add());	
					if(jau!=null&&!jau.equals("")){
						icbc.setGname(jau.getApi_companyname());
						icbc.setPname(jau.getApi_name());
				}
    			}
    			zxexcel zxexcel=new zxexcel();
    			zxexcel.setShname(icbc.getGname());
    			zxexcel.setAddtime(icbc.getDt_add());
    			zxexcel.setStatus(String.valueOf(icbc.getBc_status()));
    			zxexcel.setCzr(icbc.getPname());
    			zxexcel.setKhname(icbc.getC_name());
    			iList1.add(zxexcel);
    		}    		
    	}
    	 toxxexcel(iList1, response);
      }	
	}
	public static void toxxexcel(List<zxexcel> zxlist,  
            HttpServletResponse response) throws Exception{  		  
        // 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook();  
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("worksheet"); 
      
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
        HSSFRow row = sheet.createRow(0);  
        // 第四步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = wb.createCellStyle();
        
        style.setAlignment(CellStyle.ALIGN_CENTER); // 创建一个居中格式  
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直居中
        style.setBorderBottom(CellStyle.BORDER_THIN); //下边框
        style.setBorderLeft(CellStyle.BORDER_THIN);//左边框
        style.setBorderTop(CellStyle.BORDER_THIN);//上边框
        style.setBorderRight(CellStyle.BORDER_THIN);//右边框        
        HSSFCell cell = row.createCell((short) 0);        
        cell.setCellValue("商户公司名");  
        cell.setCellStyle(style);  
       
        cell = row.createCell((short) 1);         
        cell.setCellValue("金额");  
        cell.setCellStyle(style);  
       
        cell = row.createCell((short) 2);         
        cell.setCellValue("创建时间");  
        cell.setCellStyle(style);  
       
        cell = row.createCell((short) 3);        
        cell.setCellValue("状态");  
        cell.setCellStyle(style);  
       
        cell = row.createCell((short) 4);          
        cell.setCellValue("操作人");  
        cell.setCellStyle(style);  
       
        cell = row.createCell((short) 5);          
        cell.setCellValue("客户姓名");  
        cell.setCellStyle(style);       
      for(int j=0;j<13;j++){
    	  sheet.setColumnWidth(j, 256*35+184);  
      }
        
      String excelname = null;
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，  	         
        zxexcel zc=new zxexcel();
        for (int i = 0; i < zxlist.size(); i++)  
        {   
        	System.out.println("jsonlength:"+zxlist.size());
        	row = sheet.createRow(i + 1);  
            zc =zxlist.get(i);  
            // 第四步，创建单元格，并设置值  
            row.createCell((short) 0).setCellValue(zc.getShname());
            if(zc.getStatus().equals("2")||zc.getStatus().equals("3")||zc.getStatus().equals("4")){
            	row.createCell((short) 1).setCellValue("-60");  
            }else{
            	row.createCell((short) 1).setCellValue(""); 
            }
            row.createCell((short) 2).setCellValue(zc.getAddtime().substring(0,19));
            if(zc.getStatus().equals("3")){
            	row.createCell((short) 3).setCellValue("成功");
            }else if(zc.getStatus().equals("2")){
            	row.createCell((short) 3).setCellValue("正在查询");
            }else if(zc.getStatus().equals("4")){
            	row.createCell((short) 3).setCellValue("回退");
            }else if(zc.getStatus().equals("5")){
            	row.createCell((short) 3).setCellValue("撤销");
            }else{
            	row.createCell((short) 3).setCellValue("草稿箱");
            }            
            row.createCell((short) 4).setCellValue(zc.getCzr());  
            row.createCell((short) 5).setCellValue(zc.getKhname());  
            row.setRowStyle(style);
        }
        excelname ="工行征信_"+creditutil.timefiles()+".xls";
     
        // 第六步，将文件存到指定位置  
        response.setContentType("text/html;charset=UTF-8");     
        BufferedInputStream in = null;    
        BufferedOutputStream out = null;         
        try  
        {  
        	response.setContentType("multipart/form-data");    
            response.setCharacterEncoding("UTF-8");    
            response.setHeader("Content-Disposition", "attachment; filename="+new String(excelname.getBytes("gbk"),"iso-8859-1"));       
            //response.setHeader("Content-Length",String.valueOf()));
            out = new BufferedOutputStream(response.getOutputStream());    
            wb.write(out); 
            //System.out.println("导出完成");   
            out.close();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
    }
	/** 
     * 对字符串处理:将指定位置到指定位置的字符以星号代替 
     *  
     * @param content 
     *            传入的字符串 
     * @param begin 
     *            开始位置 
     * @param end 
     *            结束位置 
     * @return 
     */  
    private static String getStarString(String content) {  
 
        if (content.length()<=1) {  
            return content;  
        }  
        return content.substring(0,1)+"*"+content.substring(2,content.length());  
  
    }  

    
  
}
