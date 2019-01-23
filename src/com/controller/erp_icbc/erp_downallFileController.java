package com.controller.erp_icbc;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.controller.icbc.jsp.imgfile;
import com.google.gson.JsonObject;
import com.http.HttpUtils;
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
import com.model1.icbc.erp.PageData;
import com.service1.car.icbc_carsService;
import com.service1.car.newassess_cars_itemService;
import com.service1.erp_icbc.erp_wdrwService;
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
public class erp_downallFileController {
	@Autowired
	private erp_wdrwService erp_wdrwService;
	
	/**
     * what 打包下载多个文件到本地并压缩  (有条件限制 type:eg:List数组)
     * when 2018-8-25
     * who  hzj
     * @param type 文件保存的数组
     * EG::type=[upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg, upload/2018/06/30/e495e0311096d997e8c54fd3fce2cf7a.jpg, upload/2018/06/30/183ae07a0d0ff07df8bcc798ea3e2700.jpg, upload/2018/06/30/f14add7bca1db43f1abb1e337672c22b.jpg, upload/2018/06/30/a42bc885f06b67aafd3fbad7351b2de6.jpg, upload/2018/06/30/1e71ca7c23cf5179ac921a17f0bfe174.jpg, upload/2018/06/30/68c9d4257399ac293c1644a9f514d224.jpg, , ]
     *
     */
	@RequestMapping(value = "erp/downloadFile_all.do")
	@ResponseBody
    public void downloadFile_all(String type,String id,String base_name,
    		HttpServletRequest request,HttpServletResponse response)throws Exception {	
	        response.setContentType("application/json;charset=utf-8");  
	        List<imgfile> FileNameList =new ArrayList<imgfile>(); // 用于存放即将下载的照片
	        //压缩文件名字
	        if(base_name.equals("") ||  base_name==null){
	        	base_name =UUID.randomUUID().toString().replaceAll("-","");	
	        }
	        base_name = new String(base_name.getBytes("ISO-8859-1"),"UTF-8");
	        base_name = new String(base_name.getBytes("GB2312"),"ISO-8859-1");
	        base_name=base_name.replaceAll(" ", "");
	        //方法查到五张表全部的信息
	        PageData pData = new PageData();
			pData.put("dn","icbc_erp_kj_icbc");
			pData.put("icbc_id",id);		
			System.out.println("主订单id:"+id);
			if (id != null && !id.equals("")) {
				//得到五张表全部的信息
				PageData pageData = erp_wdrwService.icbc_form(pData);
				//String khName = new String(pageData.getString("c_name").getBytes("ISO-8859-1"),"UTF-8");
				String khName= new String(pageData.getString("c_name").getBytes("GB2312"),"ISO-8859-1");
				System.out.println("客户姓名："+pageData.get("c_name"));
				base_name =khName+"_"+base_name;
				base_name=base_name.replaceAll(" ", "");
				int imgCounts = 1;
				if (pageData != null && !pageData.equals("")){
					//征信材料
					if(type.equals("zx")){
						List<Object> zxImgsList = new ArrayList<>();
						Object imgss1 = (String) pageData.get("imgstep2_1ss") + pageData.get("imgstep2_2ss")+ pageData.get("imgstep2_3ss") + pageData.get("imgstep2_4ss");
						String[] zx_imgs = null;
						imgss1 = imgss1.toString().replace("null","");
						if (imgss1 != null && !imgss1.equals("")){
							zx_imgs = ((String) imgss1).split("");
							if (zx_imgs.length > 0){
								for(int i=0;i<zx_imgs.length;i++){
						        	if(zx_imgs[i]!=null&&!zx_imgs[i].equals("")){
					        			imgfile imgfile=new imgfile();
										imgfile.setImgurl("http://a.kcway.net/assess/"+zx_imgs[i]);
										imgfile.setName(i+1+"");
										imgfile.setFilelast(((String)zx_imgs[i]).substring(((String)zx_imgs[i]).lastIndexOf(".")+1,((String)zx_imgs[i]).length()));
										FileNameList.add(imgfile);	
										imgCounts++;
					        		}
								}
							}
						}
					}
					//主贷人材料
					if(type.equals("zdr")){
						List<Object> zdrImgsList = new ArrayList<>();
						String[] zdrImgs = null;
						if (pageData.get("imgstep2_1ss") != null && !pageData.get("imgstep2_1ss").equals("")) {
							zdrImgs = ((String) pageData.get("imgstep2_1ss")).split("");
							if (zdrImgs.length > 0){
								for (int i = 0; i < zdrImgs.length; i++){
									if (zdrImgs[i] != null && !zdrImgs[i].equals("")) {
										//zdrImgsList.add(zdrImgs[i]);
										imgfile imgfile=new imgfile();
										imgfile.setImgurl("http://a.kcway.net/assess/"+zdrImgs[i]);
										imgfile.setName(i+1+"");
										imgfile.setFilelast(((String)zdrImgs[i]).substring(((String)zdrImgs[i]).lastIndexOf(".")+1,((String)zdrImgs[i]).length()));
										FileNameList.add(imgfile);	
										imgCounts++;
									}
								}
							}
						}
					}
					//主贷人配偶材料
					if(type.equals("zdrpo")){
						List<Object> zdrImgsList = new ArrayList<>();
						String[] zdrImgs = null;
						if (pageData.get("imgstep2_2ss") != null && !pageData.get("imgstep2_2ss").equals("")) {
							zdrImgs = ((String) pageData.get("imgstep2_2ss")).split("");
							if (zdrImgs.length > 0){
								for (int i = 0; i < zdrImgs.length; i++){
									if (zdrImgs[i] != null && !zdrImgs[i].equals("")) {
										//zdrImgsList.add(zdrImgs[i]);
										imgfile imgfile=new imgfile();
										imgfile.setImgurl("http://a.kcway.net/assess/"+zdrImgs[i]);
										imgfile.setName(i+1+"");
										imgfile.setFilelast(((String)zdrImgs[i]).substring(((String)zdrImgs[i]).lastIndexOf(".")+1,((String)zdrImgs[i]).length()));
										FileNameList.add(imgfile);	
										imgCounts++;
									}
								}
							}
						}
					}
					//共还人1材料 
					if(type.equals("ghr1")){
						List<Object> zdrImgsList = new ArrayList<>();
						String[] zdrImgs = null;
						if (pageData.get("imgstep2_3ss") != null && !pageData.get("imgstep2_3ss").equals("")) {
							zdrImgs = ((String) pageData.get("imgstep2_3ss")).split("");
							if (zdrImgs.length > 0){
								for (int i = 0; i < zdrImgs.length; i++){
									if (zdrImgs[i] != null && !zdrImgs[i].equals("")) {
										//zdrImgsList.add(zdrImgs[i]);
										imgfile imgfile=new imgfile();
										imgfile.setImgurl("http://a.kcway.net/assess/"+zdrImgs[i]);
										imgfile.setName(i+1+"");
										imgfile.setFilelast(((String)zdrImgs[i]).substring(((String)zdrImgs[i]).lastIndexOf(".")+1,((String)zdrImgs[i]).length()));
										FileNameList.add(imgfile);	
										imgCounts++;
									}
								}
							}
						}
					}
					//共还人2材料
					if(type.equals("ghr2")){
						List<Object> zdrImgsList = new ArrayList<>();
						String[] zdrImgs = null;
						if (pageData.get("imgstep2_4ss") != null && !pageData.get("imgstep2_4ss").equals("")) {
							zdrImgs = ((String) pageData.get("imgstep2_4ss")).split("");
							if (zdrImgs.length > 0){
								for (int i = 0; i < zdrImgs.length; i++){
									if (zdrImgs[i] != null && !zdrImgs[i].equals("")) {
										//zdrImgsList.add(zdrImgs[i]);
										imgfile imgfile=new imgfile();
										imgfile.setImgurl("http://a.kcway.net/assess/"+zdrImgs[i]);
										imgfile.setName(i+1+"");
										imgfile.setFilelast(((String)zdrImgs[i]).substring(((String)zdrImgs[i]).lastIndexOf(".")+1,((String)zdrImgs[i]).length()));
										FileNameList.add(imgfile);	
										imgCounts++;
									}
								}
							}
						}
					}
					//征信通融材料
					if(type.equals("zxtr")){
						List<Object> zxtrImgsList = new ArrayList<>();
						String[] imgss = null;
						//给每张图片设置url,name,后缀名
						if (pageData.get("imgstep8_1ss") != null && !pageData.get("imgstep8_1ss").equals("")) {
							imgss = ((String) pageData.get("imgstep8_1ss")).split("");
							if(imgss.length > 0) {
								for(int i=0;i<imgss.length;i++){
						        	if(imgss[i]!=null&&!imgss[i].equals("")){
					        			imgfile imgfile=new imgfile();
										imgfile.setImgurl("http://a.kcway.net/assess/"+imgss[i]);
										imgfile.setName(i+1+"");
										imgfile.setFilelast(((String)imgss[i]).substring(((String)imgss[i]).lastIndexOf(".")+1,((String)imgss[i]).length()));
										FileNameList.add(imgfile);	
										imgCounts++;
					        		}
								}
							}
						}
					}
					//汽车评估材料
					if(type.equals("clpg")){
						List<Object> zxImgsList = new ArrayList<>();
						Object imgss1 = (String) pageData.get("imgstep9_1ss") + pageData.get("imgstep9_2ss");
						String[] zx_imgs = null;
						imgss1 = imgss1.toString().replace("null","");
						if (imgss1 != null && !imgss1.equals("")){
							zx_imgs = ((String) imgss1).split("");
							if (zx_imgs.length > 0){
								for(int i=0;i<zx_imgs.length;i++){
						        	if(zx_imgs[i]!=null&&!zx_imgs[i].equals("")){
					        			imgfile imgfile=new imgfile();
										imgfile.setImgurl("http://a.kcway.net/assess/"+zx_imgs[i]);
										imgfile.setName(i+1+"");
										imgfile.setFilelast(((String)zx_imgs[i]).substring(((String)zx_imgs[i]).lastIndexOf(".")+1,((String)zx_imgs[i]).length()));
										FileNameList.add(imgfile);	
										imgCounts++;
					        		}
								}
							}
						}
						/*List<Object> clpgImgsList = new ArrayList<>();
						PageData pData2 = new PageData();
						pData2.put("dn", "assess_cars_item");
						pData2.put("cars_id", pageData.get("carsid"));
						List<PageData> img_pList = erp_wdrwService.icbc_list(pData2);
						//给每张图片设置url,name,后缀名
						if(img_pList.size()>0){
							for(int i=0;i<img_pList.size();i++){
					        	if(img_pList.get(i)!=null&&!img_pList.get(i).equals("")){
					        		String url = img_pList.get(i).getString("bcimg");
					        		if(url!=null&&!url.equals("")){
				        			imgfile imgfile=new imgfile();
									imgfile.setImgurl("http://a.kcway.net/"+url);
									imgfile.setName(i+1+"");
									imgfile.setFilelast(url.substring(url.lastIndexOf(".")+1,url.length()));
									FileNameList.add(imgfile);	
									imgCounts++;
					        		}
				        		}
							}
						}*/
						
					}
					//开卡申请材料
					if(type.equals("kk")){
						List<Object> kkImgsList = new ArrayList<>();
						kkImgsList.add(pageData.get("imgstep3_1"));
						kkImgsList.add(pageData.get("imgstep3_2"));
						kkImgsList.add(pageData.get("imgstep3_3"));
						kkImgsList.add(pageData.get("imgstep3_4"));
						kkImgsList.add(pageData.get("imgstep3_5"));
						kkImgsList.add(pageData.get("imgstep3_6"));
						kkImgsList.add(pageData.get("imgstep3_7"));
						kkImgsList.add(pageData.get("imgstep3_71"));
						kkImgsList.add(pageData.get("imgstep3_72"));
						String[] kk_imgss;
						if (pageData.get("imgstep3_7s") != null && !pageData.get("imgstep3_72").equals("")) {
							kk_imgss = ((String) pageData.get("imgstep3_7s")).split("");
							if (kk_imgss.length > 0) {
								for (int i = 0; i < kk_imgss.length; i++) {
									if (kk_imgss[i] != null && !kk_imgss[i].equals("")) {
										kkImgsList.add(kk_imgss[i]);
									}
								}
							}
						}
						//给每张图片设置url,name,后缀名
						if(kkImgsList.size()>0){
					        for(int i=0;i<kkImgsList.size();i++){
					        	if(kkImgsList.get(i)!=null&&!kkImgsList.get(i).equals("")){
				        			imgfile imgfile=new imgfile();
									imgfile.setImgurl("http://a.kcway.net/assess/"+kkImgsList.get(i));
									imgfile.setName(i+1+"");
									imgfile.setFilelast(((String)kkImgsList.get(i)).substring(((String)kkImgsList.get(i)).lastIndexOf(".")+1,((String)kkImgsList.get(i)).length()));
									FileNameList.add(imgfile);	
									imgCounts++;
				        		}
							}
				        }
					}
					
					//开卡申请PDF材料
					if(type.equals("kkPDF")){
						List<Object> kkPDFList = new ArrayList<>();
						kkPDFList.add(pageData.get("pdf"));
						kkPDFList.add(pageData.get("pdfstep4_1"));
						//给每张图片设置url,name,后缀名
						if(kkPDFList.size()>0){
					        for(int i=0;i<kkPDFList.size();i++){
					        	if(kkPDFList.get(i)!=null&&!kkPDFList.get(i).equals("")){
				        			imgfile imgfile=new imgfile();
									imgfile.setImgurl("http://a.kcway.net/assess/"+kkPDFList.get(i));
									imgfile.setName(i+1+"");
									imgfile.setFilelast(((String)kkPDFList.get(i)).substring(((String)kkPDFList.get(i)).lastIndexOf(".")+1,((String)kkPDFList.get(i)).length()));
									FileNameList.add(imgfile);	
									imgCounts++;
				        		}
							}
				        }
					}
					//视频材料
					if(type.equals("sq")){
						List<Object> sqList = new ArrayList<>();
						sqList.add(pageData.get("imgstep8_1v"));
						sqList.add(pageData.get("imgstep8_2v"));
						sqList.add(pageData.get("imgstep8_3v"));
						sqList.add(pageData.get("imgstep8_4v"));
						//给每张图片设置url,name,后缀名
						if(sqList.size()>0){
					        for(int i=0;i<sqList.size();i++){
					        	if(sqList.get(i)!=null&&!sqList.get(i).equals("")){
				        			imgfile imgfile=new imgfile();
									imgfile.setImgurl("http://a.kcway.net/assess/"+sqList.get(i));
									imgfile.setName(i+1+"");
									imgfile.setFilelast(((String)sqList.get(i)).substring(((String)sqList.get(i)).lastIndexOf(".")+1,((String)sqList.get(i)).length()));
									FileNameList.add(imgfile);	
									imgCounts++;
				        		}
							}
				        }
					}
					//签约材料
					if(type.equals("qy")){
						List<Object> qyImgsList = new ArrayList<>();
						Object imgss1 = (String) pageData.get("imgstep4_1ss") + pageData.get("imgstep4_2ss")+ pageData.get("imgstep4_3ss") + pageData.get("imgstep4_4ss") + pageData.get("imgstep4_5ss");
						String[] qy_imgs = null;
						imgss1 = imgss1.toString().replace("null","");
						// 签约材料
						if (imgss1 != null && !imgss1.equals("")){
							qy_imgs = ((String) imgss1).split("");
							if (qy_imgs.length > 0){
								for(int i=0;i<qy_imgs.length;i++){
						        	if(qy_imgs[i]!=null&&!qy_imgs[i].equals("")){
					        			imgfile imgfile=new imgfile();
										imgfile.setImgurl("http://a.kcway.net/assess/"+qy_imgs[i]);
										imgfile.setName(i+1+"");
										imgfile.setFilelast(((String)qy_imgs[i]).substring(((String)qy_imgs[i]).lastIndexOf(".")+1,((String)qy_imgs[i]).length()));
										FileNameList.add(imgfile);	
										imgCounts++;
					        		}
								}
							}
						}
						/*
						qyImgsList.add(pageData.get("imgstep4_1ss"));
						qyImgsList.add(pageData.get("imgstep4_2ss"));
						qyImgsList.add(pageData.get("imgstep4_3ss"));
						qyImgsList.add(pageData.get("imgstep4_4ss"));
						qyImgsList.add(pageData.get("imgstep4_5ss"));
						//给每张图片设置url,name,后缀名
						if(qyImgsList.size()>0){
					        for(int i=0;i<qyImgsList.size();i++){
					        	if(qyImgsList.get(i)!=null&&!qyImgsList.get(i).equals("")){
				        			imgfile imgfile=new imgfile();
									imgfile.setImgurl("http://a.kcway.net/assess/"+qyImgsList.get(i));
									imgfile.setName(i+1+"");
									imgfile.setFilelast(((String)qyImgsList.get(i)).substring(((String)qyImgsList.get(i)).lastIndexOf(".")+1,((String)qyImgsList.get(i)).length()));
									FileNameList.add(imgfile);	
									imgCounts++;
				        		}
							}
				        }
				        */
					}
					//证明材料
					if(type.equals("zm")){
						List<Object> zmImgsList = new ArrayList<>();
						String[] zm_imgs2 = null;
						if (pageData.get("imgstep5_1ss") != null && !pageData.get("imgstep5_1ss").equals("")) {
							zm_imgs2 = ((String) pageData.get("imgstep5_1ss")).split("");
							if (zm_imgs2.length > 0) {
								for (int i = 0; i < zm_imgs2.length; i++) {
									if (zm_imgs2[i] != null && !zm_imgs2[i].equals("")) {
										zmImgsList.add(zm_imgs2[i]);
									}
								}
							}
						}
						//给每张图片设置url,name,后缀名
						if(zmImgsList.size()>0){
					        for(int i=0;i<zmImgsList.size();i++){
					        	if(zmImgsList.get(i)!=null&&!zmImgsList.get(i).equals("")){
				        			imgfile imgfile=new imgfile();
									imgfile.setImgurl("http://a.kcway.net/assess/"+zmImgsList.get(i));
									imgfile.setName(i+1+"");
									imgfile.setFilelast(((String)zmImgsList.get(i)).substring(((String)zmImgsList.get(i)).lastIndexOf(".")+1,((String)zmImgsList.get(i)).length()));
									FileNameList.add(imgfile);	
									imgCounts++;
				        		}
							}
				        }
						
					}
					//其他材料
					if(type.equals("qt")){
						List<Object> qtImgsList = new ArrayList<>();
						String[] qt_imgs3 = null;
						if (pageData.get("imgstep6_1ss") != null && !pageData.get("imgstep6_1ss").equals("")) {
							qt_imgs3 = ((String) pageData.get("imgstep6_1ss")).split("");
							if (qt_imgs3.length > 0) {
								for (int i = 0; i < qt_imgs3.length; i++) {
									if (qt_imgs3[i] != null && !qt_imgs3[i].equals("")) {
										qtImgsList.add(qt_imgs3[i]);
									}
								}
							}
						}
						//给每张图片设置url,name,后缀名
						if(qtImgsList.size()>0){
					        for(int i=0;i<qtImgsList.size();i++){
					        	if(qtImgsList.get(i)!=null&&!qtImgsList.get(i).equals("")){
				        			imgfile imgfile=new imgfile();
									imgfile.setImgurl("http://a.kcway.net/assess/"+qtImgsList.get(i));
									imgfile.setName(i+1+"");
									imgfile.setFilelast(((String)qtImgsList.get(i)).substring(((String)qtImgsList.get(i)).lastIndexOf(".")+1,((String)qtImgsList.get(i)).length()));
									FileNameList.add(imgfile);	
									imgCounts++;
				        		}
							}
				        }
					}
					//补充材料
					if(type.equals("bc")){
						List<Object> bcImgsList = new ArrayList<>();
						String[] bc_imgs4 = null;
						if (pageData.get("imgstep7_1ss") != null && !pageData.get("imgstep7_1ss").equals("")) {
							bc_imgs4 = ((String) pageData.get("imgstep7_1ss")).split("");
							if (bc_imgs4.length > 0) {
								for (int i = 0; i < bc_imgs4.length; i++) {
									if (bc_imgs4[i] != null && !bc_imgs4[i].equals("")) {
										bcImgsList.add(bc_imgs4[i]);
									}
								}
								
							}
						}
						//给每张图片设置url,name,后缀名
						if(bcImgsList.size()>0){
					        for(int i=0;i<bcImgsList.size();i++){
					        	if(bcImgsList.get(i)!=null&&!bcImgsList.get(i).equals("")){
				        			imgfile imgfile=new imgfile();
									imgfile.setImgurl("http://a.kcway.net/assess/"+bcImgsList.get(i));
									imgfile.setName(i+1+"");
									imgfile.setFilelast(((String)bcImgsList.get(i)).substring(((String)bcImgsList.get(i)).lastIndexOf(".")+1,((String)bcImgsList.get(i)).length()));
									FileNameList.add(imgfile);	
									imgCounts++;
				        		}
							}
				        }
					}
				}
			}
	        
	        /**  原来写法   传一个request
			//压缩文件名字
	        if(base_name.equals("") ||  base_name==null){
	        	base_name =UUID.randomUUID().toString().replaceAll("-","");	
	        }
	        System.out.println("名字::"+base_name);
	        
	        List<String> imgsList = new ArrayList<>();
	        //把 String 类型转化成  数组
	        String[] arrayImg = type.replaceAll(", ",",").replace("[","").replace("]","").split(",");
	        //把数组转化成 list
	        imgsList =  Arrays.asList(arrayImg);
	        //遍历list,给每个文件设置url路径,文件名字,文件类型    添加到另一个list中,进行下载时的压缩保存
	        int imgs = 1;
	        if(imgsList.size()>0){
		        for(int i=0;i<imgsList.size();i++){
		        	if(imgsList.get(i)!=null&&!imgsList.get(i).equals("")){
	        			imgfile imgfile=new imgfile();
						imgfile.setImgurl("http://a.kcway.net/assess/"+imgsList.get(i));
						imgfile.setName(i+1+"");
						imgfile.setFilelast(imgsList.get(i).substring(imgsList.get(i).lastIndexOf(".")+1,imgsList.get(i).length()));
						FileNameList.add(imgfile);	
						imgs++;
	        		}
				}
	        }
	        */
	        
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
			   os = response.getOutputStream(); // 
			   os.write(bos.toByteArray());	               			   
			   os.close();
			   bos.close();			  
			  }catch(Exception ex) {
				   ex.printStackTrace();
				   ServletOutputStream sos = null;  
	               try {  
	                   //response.setContentType("text/html;charset=utf-8");  
	                   sos = response.getOutputStream();  
	                   sos.write("<script>alert('下载失败,请稍后下载!');</script>".getBytes("UTF-8"));
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
     * TODO 下载单个文件到本地
     * @param fileUrl 远程地址
     * @param fileLocal 本地路径
     * @throws Exception 
     */
	@RequestMapping(value = "erp/downloadOneFile.do")
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
        response.setHeader("Content-Disposition", "attachment; filename="+java.net.URLEncoder.encode(fileName,"UTF-8")+pString);    
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
	
}
