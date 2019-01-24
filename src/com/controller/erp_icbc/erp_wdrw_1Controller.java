package com.controller.erp_icbc;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.controller.icbc.jsp.imgfile;
import com.model1.icbc.erp.PageData;
import com.service1.fsService;
import com.service1.erp_icbc.erp_fiveModelService;
import com.service1.erp_icbc.erp_wdrwService;
import com.service1.kjs_icbc.icbc_result1Service;
import com.service1.kjs_icbc.newicbcService;
import com.service1.kjs_icbc.newicbc_kkService;
import com.service1.send.admin_msgService;
import com.util.creditutil;
import com.util.jsonutil;
import com.util.newAdd.UrlFilesToZip;

@Controller
public class erp_wdrw_1Controller {

	
	
	private static final String appKey ="7e21faf06524b22f0ee1414c"; 
	private static final String masterSecret = "c87361ae4d7d91067b3ea01a";
	
	@Autowired
	private erp_wdrwService erp_wdrwService;
	@Autowired
	private newicbcService newicbcService;
	@Autowired
	private newicbc_kkService newicbc_kkService;
	@Autowired
	private icbc_result1Service icbc_result1Service;
	@Autowired
	private com.service1.kjs_icbc.icbc_dkService icbc_dkService;
	@Autowired
	private fsService fService;
	@Autowired
	private com.service1.adminService adminService;
	@Autowired
	private admin_msgService admin_msgService;
	@Autowired
	private erp_fiveModelService erp_fiveModelService;
	
	
    /**
     * 获取两个List的不同元素
     * @param arry1
     * @param arry2
     * @return
     */
    private static List<Object> getDiffrent(List<Object> arry1, List<Object> arry2) {
        long st = System.nanoTime();
        List<Object> diff = new ArrayList<Object>();
        for(Object str:arry1)
        {
            if(!arry2.contains(str))
            {
                diff.add(str);
            }
        }
        System.out.println("total times "+(System.nanoTime()-st));
        return diff;
    }

	
	/**
     * what 打包下载多个文件到本地并压缩  (有条件限制 type:eg:List数组)
     * when 2018-8-25
     * who  hzj
     * @param type 文件保存的数组
     * EG::type=[upload/2018/06/30/5d8d81f9a88d64e6e803bb499b870419.jpg, upload/2018/06/30/e495e0311096d997e8c54fd3fce2cf7a.jpg, upload/2018/06/30/183ae07a0d0ff07df8bcc798ea3e2700.jpg, upload/2018/06/30/f14add7bca1db43f1abb1e337672c22b.jpg, upload/2018/06/30/a42bc885f06b67aafd3fbad7351b2de6.jpg, upload/2018/06/30/1e71ca7c23cf5179ac921a17f0bfe174.jpg, upload/2018/06/30/68c9d4257399ac293c1644a9f514d224.jpg, , ]
     *
     */
	@RequestMapping(value = "erp/download_lsjlimage.do")
	@ResponseBody
    public void download_lsjlimage(String image_data,String inid,String image_name,
    		HttpServletRequest request,HttpServletResponse response)throws Exception {	
	        response.setContentType("application/json;charset=utf-8");  
	        List<imgfile> FileNameList =new ArrayList<imgfile>(); // 用于存放即将下载的照片
	        //压缩文件名字
	       /* if(base_name.equals("") ||  base_name==null){
	        	base_name =UUID.randomUUID().toString().replaceAll("-","");	
	        }*/
	        //System.out.println("次数："+inid);
	        image_name = new String(image_name.getBytes("ISO-8859-1"),"UTF-8");
/*	        image_name=image_name+"第"+inid+"次补件";*/
	        String  base_name = new String(image_name.getBytes("GB2312"),"ISO-8859-1");
	        //方法查到五张表全部的信息
		        String[] imgs = null;
		        List<Object> zxImgsList = new ArrayList<>();
				if (image_data!= null &&!image_data.equals("")) {
					imgs =image_data.split(",");
					if (imgs.length > 0){
						for (int i = 0; i < imgs.length; i++){
							if (imgs[i] != null && !imgs[i].equals("")) {
								zxImgsList.add(imgs[i]);
							}
						}
					}
				}
				if(zxImgsList.size()>0){
			        for(int i=0;i<zxImgsList.size();i++){
			        	if(zxImgsList.get(i)!=null&&!zxImgsList.get(i).equals("")){
		        			imgfile imgfile=new imgfile();
							imgfile.setImgurl(zxImgsList.get(i).toString());
							imgfile.setName(i+1+"");
							imgfile.setFilelast(((String)zxImgsList.get(i)).substring(((String)zxImgsList.get(i)).lastIndexOf(".")+1,((String)zxImgsList.get(i)).length()));
							FileNameList.add(imgfile);	
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
	  * 图片历史记录
	  * @param icbc_id
	  * @param status
	  * @param type_id
	  * @param lx_id
	  * @param request
	  * @return
	  */
	 @RequestMapping(value = "erp/erp_icbc_lsjl.do", produces = "text/html;charset=UTF-8")
	 @ResponseBody
	 public String erp_icbc_lsjl(
			 Integer icbc_id,
			 Integer status,
			 Integer type_id,
			 Integer lx_id,
			 HttpServletRequest request
			 ){
		 PageData pd=new PageData();
		 pd.put("dn", "erp_icbc_lsjl");
		 pd.put("icbc_id",icbc_id);
		 pd.put("status",status);
		 pd.put("type_id",type_id);
		List<JSONObject> pdList1=new ArrayList<JSONObject>();
		List<JSONObject> pdList2=new ArrayList<JSONObject>();
		List<JSONObject> pdList3=new ArrayList<JSONObject>();
		List<JSONObject> pdList4=new ArrayList<JSONObject>();
		List<PageData> pdList=erp_wdrwService.icbc_list(pd);
		System.out.println("总量："+pdList.size());
	    if(pdList!=null&&!pdList.equals("")&&pdList.size()>0){
	    	 PageData pageData1=new PageData();

	    	for(int i=0;i<pdList.size();i++){
	    	PageData pageData=pdList.get(i);
	    	    // System.out.println("value："+pageData.get("result_1_value"));
	    		if(pageData.get("result_1_value")!=null&&!pageData.get("result_1_value").equals("")){
	    			 JSONObject pageData2=new JSONObject();
	    			 pageData1=pdList.get(0);
	    			 JSONObject jsonObject=JSONObject.parseObject(pageData.get("result_1_value").toString());		
	        	     JSONObject jsonObject1=JSONObject.parseObject(pageData1.get("result_1_value").toString());
	        	                if (lx_id==1) {
	        	                	if(jsonObject1.get("imgstep2_1ss")!=null&&!jsonObject1.get("imgstep2_1ss").equals("")){
		        	    				//System.out.println("json图片地址:"+jsonObject.get("imgstep2_1ss"));
		        	    				pageData2.put("img1", jsonObject1.get("imgstep2_1ss"));
		        	    			}
	        	                	if(jsonObject.get("imgstep2_1ss")!=null&&!jsonObject.get("imgstep2_1ss").equals("")){
	        		    				//System.out.println("json图片地址:"+jsonObject.get("imgstep2_1ss"));
	        		    				pageData2.put("imgstep2_1ss", jsonObject.get("imgstep2_1ss"));
	        		    			}
								}
                                if (lx_id==2) {
                                	if(jsonObject1.get("imgstep2_2ss")!=null&&!jsonObject1.get("imgstep2_2ss").equals("")){
     	                        	   pageData2.put("img2", jsonObject1.get("imgstep2_2ss"));
     	        	    			}
                                	 if(jsonObject.get("imgstep2_2ss")!=null&&!jsonObject.get("imgstep2_2ss").equals("")){
                                  	   pageData2.put("imgstep2_2ss", jsonObject.get("imgstep2_2ss"));
                  	    			}
								}
                                if (lx_id==3) {
                                	if(jsonObject1.get("imgstep2_3ss")!=null&&!jsonObject1.get("imgstep2_3ss").equals("")){
     	                        	   pageData2.put("img3", jsonObject1.get("imgstep2_3ss"));
     	                            }
                                	 if(jsonObject.get("imgstep2_3ss")!=null&&!jsonObject.get("imgstep2_3ss").equals("")){
                                  	   pageData2.put("imgstep2_3ss", jsonObject.get("imgstep2_3ss"));
                                      }
								}
                                if(lx_id==4){
                                	if(jsonObject1.get("imgstep2_4ss")!=null&&!jsonObject1.get("imgstep2_4ss").equals("")){
    	                            	pageData2.put("img4", jsonObject1.get("imgstep2_4ss"));
    	                            }
                                	 if(jsonObject.get("imgstep2_4ss")!=null&&!jsonObject.get("imgstep2_4ss").equals("")){
                                     	pageData2.put("imgstep2_4ss", jsonObject.get("imgstep2_4ss"));
                                     }
                                }
                                if(lx_id==5){
                                	if(jsonObject1.get("imgstep8_1ss")!=null&&!jsonObject1.get("imgstep8_1ss").equals("")){
    	                            	pageData2.put("img5", jsonObject1.get("imgstep8_1ss"));
    	                            }
                                	if(jsonObject.get("imgstep8_1ss")!=null&&!jsonObject.get("imgstep8_1ss").equals("")){
                                    	pageData2.put("imgstep8_1ss", jsonObject.get("imgstep8_1ss"));
                                    }
                                }
                                if(lx_id==6){
    	                            	
    	                            	int num=0;
    	                            	List<Object> arry1=new ArrayList<>();
    	                            	List<Object> arry1_1=new ArrayList<>();
    	                            	List<Object> arry1_2=new ArrayList<>();
    	                            	List<Object> arry2=new ArrayList<>();
    	                            	List<Object> arry2_1=new ArrayList<>();
    	                            	List<Object> arry2_2=new ArrayList<>();
    	                            	if(jsonObject.get("imgstep9_1ss")!=null&&!jsonObject.get("imgstep9_1ss").equals("")){
    	                            		arry1_1=net.sf.json.JSONArray.fromObject(jsonObject.get("imgstep9_1ss").toString());
    	                            		arry1.addAll(arry1_1);
    	                                }
    	                            	if(jsonObject.get("imgstep9_2ss")!=null&&!jsonObject.get("imgstep9_2ss").equals("")){
    	                            		arry1_2=net.sf.json.JSONArray.fromObject(jsonObject.get("imgstep9_2ss").toString());
    	                            		arry1.addAll(arry1_2);
    	                                }
    	                            	if(jsonObject1.get("imgstep9_1ss")!=null&&!jsonObject1.get("imgstep9_1ss").equals("")){
    	                            		arry2_1=net.sf.json.JSONArray.fromObject(jsonObject1.get("imgstep9_1ss").toString());
    	                            		arry2.addAll(arry2_1);
    	                                }
    	                            	if(jsonObject1.get("imgstep9_2ss")!=null&&!jsonObject1.get("imgstep9_2ss").equals("")){
    	                            		arry2_2=net.sf.json.JSONArray.fromObject(jsonObject1.get("imgstep9_2ss").toString());
    	                            		arry2.addAll(arry2_2);
    	                                }
    	                            	pageData2.put("img6",arry2);
    	                            	List<Object> maplist=getDiffrent(arry1, arry2);
    	                            	System.out.println("不同图片数量："+maplist.size());
    	                            	pageData2.put("cars_icbc_imgs", maplist);

                                }
                                if(lx_id==7){
                                	List<Object> kkList=new ArrayList<>();
                                	List<Object> kkList1=new ArrayList<>();
                                	if(jsonObject.get("imgstep3_7s")!=null&&!jsonObject.get("imgstep3_7s").equals("")){
                                		kkList=net.sf.json.JSONArray.fromObject(jsonObject.get("imgstep3_7s").toString());
                                	}
                                    if(jsonObject1.get("imgstep3_7s")!=null&&!jsonObject1.get("imgstep3_7s").equals("")){
                                    	kkList1=net.sf.json.JSONArray.fromObject(jsonObject1.get("imgstep3_7s").toString());
                                	}
                                    kkList.add(jsonObject.get("imgstep3_1"));
                                    kkList.add(jsonObject.get("imgstep3_2"));
                                    kkList.add(jsonObject.get("imgstep3_3"));
                                    kkList.add(jsonObject.get("imgstep3_4"));
                                    kkList.add(jsonObject.get("imgstep3_5"));
                                    kkList.add(jsonObject.get("imgstep3_6"));
                                    kkList.add(jsonObject.get("imgstep3_7"));
                                    kkList.add(jsonObject.get("imgstep3_71"));
                                    kkList.add(jsonObject.get("imgstep3_72"));
                                    kkList1.add(jsonObject1.get("imgstep3_1"));
                                    kkList1.add(jsonObject1.get("imgstep3_2"));
                                    kkList1.add(jsonObject1.get("imgstep3_3"));
                                    kkList1.add(jsonObject1.get("imgstep3_4"));
                                    kkList1.add(jsonObject1.get("imgstep3_5"));
                                    kkList1.add(jsonObject1.get("imgstep3_6"));
                                    kkList1.add(jsonObject1.get("imgstep3_7"));
                                    kkList1.add(jsonObject1.get("imgstep3_71"));
                                    kkList1.add(jsonObject1.get("imgstep3_72"));
                                    List<Object> kk_list=getDiffrent(kkList, kkList1);
                                	pageData2.put("kk_list", kk_list);
                                }
                                if(lx_id==8){
                                	List<Object> ht_List=new ArrayList<>();
                                	List<Object> ht_List1=new ArrayList<>();
                                	//每次记录第一条数据
                    	 			if(jsonObject1.get("imgstep4_1ss")!=null&&!jsonObject1.get("imgstep4_1ss").equals("")){
                    	 				List<Object> list1=JSONArray.parseArray(jsonObject1.get("imgstep4_1ss").toString());
                    	 				ht_List1.addAll(list1);
                    	 			}
                    	 			if(jsonObject1.get("imgstep4_2ss")!=null&&!jsonObject1.get("imgstep4_2ss").equals("")){
                    	 				List<Object> list2=JSONArray.parseArray(jsonObject1.get("imgstep4_2ss").toString());
                    	 				ht_List1.addAll(list2);
                    	 			}
                    	 			if(jsonObject1.get("imgstep4_3ss")!=null&&!jsonObject1.get("imgstep4_3ss").equals("")){
                    	 				List<Object> list3=JSONArray.parseArray(jsonObject1.get("imgstep4_3ss").toString());
                    	 				ht_List1.addAll(list3);
                    	 			}
                    	 			if(jsonObject1.get("imgstep4_4ss")!=null&&!jsonObject1.get("imgstep4_4ss").equals("")){
                    	 				List<Object> list4=JSONArray.parseArray(jsonObject1.get("imgstep4_4ss").toString());
                    	 				ht_List1.addAll(list4);
                    	 			}
                    	 			if(jsonObject1.get("imgstep4_5ss")!=null&&!jsonObject1.get("imgstep4_5ss").equals("")){
                    	 				List<Object> list5=JSONArray.parseArray(jsonObject1.get("imgstep4_5ss").toString());
                    	 				ht_List1.addAll(list5);
                    	 			}
                    	 			//每条数据
                    	 			if(jsonObject.get("imgstep4_1ss")!=null&&!jsonObject.get("imgstep4_1ss").equals("")){
                    	 				List<Object> list1=JSONArray.parseArray(jsonObject.get("imgstep4_1ss").toString());
                    	 				ht_List.addAll(list1);
                    	 			}
                    	 			if(jsonObject.get("imgstep4_2ss")!=null&&!jsonObject.get("imgstep4_2ss").equals("")){
                    	 				List<Object> list2=JSONArray.parseArray(jsonObject.get("imgstep4_2ss").toString());
                    	 				ht_List.addAll(list2);
                    	 			}
                    	 			if(jsonObject.get("imgstep4_3ss")!=null&&!jsonObject.get("imgstep4_3ss").equals("")){
                    	 				List<Object> list3=JSONArray.parseArray(jsonObject.get("imgstep4_3ss").toString());
                    	 				ht_List.addAll(list3);
                    	 			}
                    	 			if(jsonObject.get("imgstep4_4ss")!=null&&!jsonObject.get("imgstep4_4ss").equals("")){
                    	 				List<Object> list4=JSONArray.parseArray(jsonObject.get("imgstep4_4ss").toString());
                    	 				ht_List.addAll(list4);
                    	 			}
                    	 			if(jsonObject.get("imgstep4_5ss")!=null&&!jsonObject.get("imgstep4_5ss").equals("")){
                    	 				List<Object> list5=JSONArray.parseArray(jsonObject.get("imgstep4_5ss").toString());
                    	 				ht_List.addAll(list5);
                    	 			}
                    	 			
                    	 			List<Object> ht_lists=getDiffrent(ht_List, ht_List1);
                                	pageData2.put("ht_lists", ht_lists);
                                }
                                if(lx_id==9){
                	 				List<Object> zm_List=new ArrayList<>();
                                	List<Object> zm_List1=new ArrayList<>();
                	 				if(jsonObject1.get("imgstep5_1ss")!=null&&!jsonObject1.get("imgstep5_1ss").equals("")){
                		 				List<Object> list=JSONArray.parseArray(jsonObject1.get("imgstep5_1ss").toString());
                		 				zm_List1.addAll(list);
                	 				}
                	 				if(jsonObject.get("imgstep5_1ss")!=null&&!jsonObject.get("imgstep5_1ss").equals("")){
                		 				List<Object> list=JSONArray.parseArray(jsonObject.get("imgstep5_1ss").toString());
                		 				zm_List.addAll(list);
                		 			}
                	 				List<Object> zm_lists=getDiffrent(zm_List,zm_List1);
                                	pageData2.put("zm_lists", zm_lists);
                	 			}
                                if(lx_id==10){
                	 				List<Object> qt_List=new ArrayList<>();
                                	List<Object> qt_List1=new ArrayList<>();
                	 				if(jsonObject1.get("imgstep6_1ss")!=null&&!jsonObject1.get("imgstep6_1ss").equals("")){
                		 				List<Object> list=JSONArray.parseArray(jsonObject1.get("imgstep6_1ss").toString());
                		 				qt_List1.addAll(list);
                	 				}
                	 				if(jsonObject.get("imgstep6_1ss")!=null&&!jsonObject.get("imgstep6_1ss").equals("")){
                		 				List<Object> list=JSONArray.parseArray(jsonObject.get("imgstep6_1ss").toString());
                		 				qt_List.addAll(list);
                		 			}
                	 				List<Object> qt_lists=getDiffrent(qt_List,qt_List1);
                                	pageData2.put("qt_lists", qt_lists);
                	 			}
                                if(lx_id==11){
                	 				List<Object> bc_List=new ArrayList<>();
                                	List<Object> bc_List1=new ArrayList<>();
                	 				if(jsonObject1.get("imgstep7_1ss")!=null&&!jsonObject1.get("imgstep7_1ss").equals("")){
                		 				List<Object> list=JSONArray.parseArray(jsonObject1.get("imgstep7_1ss").toString());
                		 				bc_List1.addAll(list);
                	 				}
                	 				if(jsonObject.get("imgstep5_1ss")!=null&&!jsonObject.get("imgstep7_1ss").equals("")){
                		 				List<Object> list=JSONArray.parseArray(jsonObject.get("imgstep7_1ss").toString());
                		 				bc_List.addAll(list);
                		 			}
                	 				List<Object> bc_lists=getDiffrent(bc_List,bc_List1);
                                	pageData2.put("bc_lists", bc_lists);
                	 			}
                                pageData2.put("dt_edit", pageData.get("dt_edit").toString().replace(".0",""));
                                pdList1.add(pageData2);    
	    		}
	    	
	    	}
	    }
		return pdList1.toString();
		
	 }
	
	
	/**
	 * 融资--公司确认收款 103
	 * @param gsqrsk
	 * @param bz
	 * @param admin_id
	 * @param icbc_id
	 * @param type_id
	 * @param status_id
	 * @param yw_id
	 * @param gems_id
	 * @param fs_id
	 * @param icbc_name
	 * @param icbc_adminid
	 * @param dt_date
	 * @param request
	 */
	@RequestMapping(value = "erp/erp_rz_103.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public void erp_rz_103(
			String gsqrsk,
			String bz,
			
			Integer admin_id,
			Integer icbc_id, 
			Integer type_id, 
			Integer status_id, 
			Integer yw_id, 
			Integer gems_id,
			Integer fs_id,
			String icbc_name, 
			Integer icbc_adminid,
			String dt_date,
			HttpServletRequest request
			){
		
		JSONObject json_result=new JSONObject();//json数据
		PageData erp_result=new PageData();//erp进度
		PageData erp_type=new PageData();//erp板块
		json_result.put("gsqrsk", gsqrsk);
		json_result.put("bz", bz);
		//更新类型
		erp_type.put("dn", "icbc_erp_kj_icbc");
		erp_type.put("mid_edit", admin_id);
		erp_type.put("dt_edit", creditutil.time());
		erp_type.put("status", status_id);
		erp_type.put("id", yw_id);
		erp_type.put("c_name", icbc_name);
		//添加进度
		erp_result.put("qryid",yw_id);
		erp_result.put("mid_add",admin_id);
		erp_result.put("mid_edit",admin_id);
		erp_result.put("dt_add",dt_date);
		erp_result.put("dt_edit",creditutil.time());
		erp_result.put("status_oldht", 0);
		erp_result.put("status", status_id);
		erp_result.put("remark","公司确认收款");
		erp_result.put("result_1_code",gsqrsk);
		erp_result.put("result_1_msg",bz);		
		erp_result.put("dt_sub", creditutil.time());
		erp_result.put("type_id", type_id);
		erp_result.put("icbc_id", icbc_id);
		erp_result.put("jsonAll", "");
		erp_result.put("dn", "icbc_erp_kj_icbc_result");
		erp_result.put("result_1_value",json_result.toString());
		erp_wdrwService.update(erp_type);
		erp_wdrwService.save(erp_result);	
		if(gsqrsk.equals("1")){
			PageData erp_result3=new PageData();//erp进度
			PageData erp_type3=new PageData();//erp板块
			//更新类型
			erp_type3.put("dn", "icbc_erp_kj_icbc");
			erp_type3.put("mid_edit", admin_id);
			erp_type3.put("dt_edit", creditutil.time());
			erp_type3.put("status", 104);
			erp_type3.put("id", yw_id);
			//添加进度
			erp_result3.put("qryid",yw_id);
			erp_result3.put("mid_add",admin_id);
			erp_result3.put("mid_edit",admin_id);
			erp_result3.put("dt_add",creditutil.time());
			erp_result3.put("dt_edit",creditutil.time());
			erp_result3.put("status_oldht", 0);
			erp_result3.put("status", 104);
			erp_result3.put("remark","完成");
			erp_result3.put("result_1_code",0);
			erp_result3.put("result_1_msg","");		
			erp_result3.put("dt_sub", creditutil.time());
			erp_result3.put("type_id", type_id);
			erp_result3.put("icbc_id", icbc_id);
			erp_result3.put("jsonAll", "");
			erp_result3.put("dn", "icbc_erp_kj_icbc_result");
			erp_result3.put("result_1_value","");
			erp_wdrwService.update(erp_type3);
			erp_wdrwService.save(erp_result3);	
			//查询上一步节点
			PageData result_date=new PageData();
			result_date.put("dn", "icbc_tocode");
			result_date.put("type_id",10);
			result_date.put("status",49);
			result_date.put("icbc_id",icbc_id);
			PageData rData=erp_wdrwService.icbc_form(result_date);
			PageData result_date1=new PageData();
			result_date1.put("dn", "yhds_tocode");
			result_date1.put("type_id",16);
			result_date1.put("status",101);
			result_date1.put("icbc_id",icbc_id);
			PageData rData1=erp_wdrwService.icbc_form(result_date1);
			//
			PageData erp_result2=new PageData();//erp进度
			PageData erp_type2=new PageData();//erp板块
			erp_type2.put("dn", "icbc_erp_kj_icbc");
			erp_type2.put("mid_edit", admin_id);
			erp_type2.put("dt_edit", creditutil.time());
			erp_type2.put("status", 99);
			erp_type2.put("id",rData.get("id"));
			erp_type2.put("c_name", icbc_name);
			//添加进度
			erp_result2.put("qryid",rData.get("id"));
			erp_result2.put("mid_add",admin_id);
			erp_result2.put("mid_edit",admin_id);
			erp_result2.put("dt_add",rData.get("dt_edit"));
			erp_result2.put("dt_edit",creditutil.time());
			erp_result2.put("status_oldht", 0);
			erp_result2.put("status", 99);
			erp_result2.put("remark","等待融资");
			erp_result2.put("result_1_code",1);
			erp_result2.put("result_1_msg",rData1.get("result_1_msg"));		
			erp_result2.put("dt_sub", creditutil.time());
			erp_result2.put("type_id", 10);
			erp_result2.put("icbc_id", icbc_id);
			erp_result2.put("jsonAll", "");
			erp_result2.put("dn", "icbc_erp_kj_icbc_result");
			erp_result2.put("result_1_value",rData1.get("result_1_value"));
			erp_wdrwService.update(erp_type2);
			erp_wdrwService.save(erp_result2);
		}
	}
			
	/**
	 * 融资--资金方出账 102
	 * @param rz_zh1
	 * @param rz_bank
	 * @param rz_zh2
	 * @param rz_dzje
	 * @param rz_date
	 * @param bz
	 * @param admin_id
	 * @param icbc_id
	 * @param type_id
	 * @param status_id
	 * @param yw_id
	 * @param gems_id
	 * @param fs_id
	 * @param icbc_name
	 * @param icbc_adminid
	 * @param dt_date
	 * @param request
	 */
	@RequestMapping(value = "erp/erp_rz_102.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public void erp_rz_102(
			String rz_zh1,
			String rz_bank,
			String rz_zh2,
			String rz_dzje,
			String rz_date,
			String bz,
			
			Integer admin_id,
			Integer icbc_id, 
			Integer type_id, 
			Integer status_id, 
			Integer yw_id, 
			Integer gems_id,
			Integer fs_id,
			String icbc_name, 
			Integer icbc_adminid,
			String dt_date,
			HttpServletRequest request
			){
		JSONObject json_result=new JSONObject();//json数据
		PageData erp_result=new PageData();//erp进度
		PageData erp_type=new PageData();//erp板块
		json_result.put("rz_zh1", rz_zh1);
		json_result.put("rz_bank", rz_bank);
		json_result.put("rz_zh2", rz_zh2);
		json_result.put("rz_dzje", rz_dzje);
		json_result.put("rz_date", rz_date);
		json_result.put("bz", bz);
		//更新类型
		erp_type.put("dn", "icbc_erp_kj_icbc");
		erp_type.put("mid_edit", admin_id);
		erp_type.put("dt_edit", creditutil.time());
		erp_type.put("status", status_id);
		erp_type.put("id", yw_id);
		erp_type.put("c_name", icbc_name);
		//添加进度
		erp_result.put("qryid",yw_id);
		erp_result.put("mid_add",admin_id);
		erp_result.put("mid_edit",admin_id);
		erp_result.put("dt_add",dt_date);
		erp_result.put("dt_edit",creditutil.time());
		erp_result.put("status_oldht", 0);
		erp_result.put("status", status_id);
		erp_result.put("remark","资金方出账");
		erp_result.put("result_1_code",0);
		erp_result.put("result_1_msg",bz);		
		erp_result.put("dt_sub", creditutil.time());
		erp_result.put("type_id", type_id);
		erp_result.put("icbc_id", icbc_id);
		erp_result.put("jsonAll", "");
		erp_result.put("dn", "icbc_erp_kj_icbc_result");
		erp_result.put("result_1_value",json_result.toString());
		erp_wdrwService.update(erp_type);
		erp_wdrwService.save(erp_result);	
	}
	
	/**
	 * 融资--融资结果 101
	 * @param rz_type
	 * @param bz
	 * @param admin_id
	 * @param icbc_id
	 * @param type_id
	 * @param status_id
	 * @param yw_id
	 * @param gems_id
	 * @param fs_id
	 * @param request
	 */
	@RequestMapping(value = "erp/erp_rz_101.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public void erp_rz_101(
			String rz_dzhb,
			String rz_jg,
			String rz_je,
			String rz_fdrq,
			String rz_qtxx,
			
			Integer admin_id,
			Integer icbc_id, 
			Integer type_id, 
			Integer status_id, 
			Integer yw_id, 
			Integer gems_id,
			Integer fs_id,
			String icbc_name, 
			Integer icbc_adminid,
			String dt_date,
			HttpServletRequest request
			){
		JSONObject json_result=new JSONObject();//json数据
		PageData erp_result=new PageData();//erp进度
		PageData erp_type=new PageData();//erp板块
		json_result.put("rz_dzhb", rz_dzhb);
		json_result.put("rz_jg", rz_jg);
		json_result.put("rz_je", rz_je);
		json_result.put("rz_fdrq", rz_fdrq);
		json_result.put("rz_qtxx", rz_qtxx);
		//更新类型
		erp_type.put("dn", "icbc_erp_kj_icbc");
		erp_type.put("mid_edit", admin_id);
		erp_type.put("dt_edit", creditutil.time());
		erp_type.put("status", status_id);
		erp_type.put("id", yw_id);
		erp_type.put("c_name", icbc_name);
		//添加进度
		erp_result.put("qryid",yw_id);
		erp_result.put("mid_add",admin_id);
		erp_result.put("mid_edit",admin_id);
		erp_result.put("dt_add",dt_date);
		erp_result.put("dt_edit",creditutil.time());
		erp_result.put("status_oldht", 0);
		erp_result.put("status", status_id);
		erp_result.put("remark","融资结果");
		erp_result.put("result_1_code",rz_jg);
		erp_result.put("result_1_msg",rz_qtxx);		
		erp_result.put("dt_sub", creditutil.time());
		erp_result.put("type_id", type_id);
		erp_result.put("icbc_id", icbc_id);
		erp_result.put("jsonAll", "");
		erp_result.put("dn", "icbc_erp_kj_icbc_result");
		erp_result.put("result_1_value",json_result.toString());
		erp_wdrwService.update(erp_type);
		erp_wdrwService.save(erp_result);	
		if(rz_jg.equals("2")){
			PageData erp_result3=new PageData();//erp进度
			PageData erp_type3=new PageData();//erp板块
			//更新类型
			erp_type3.put("dn", "icbc_erp_kj_icbc");
			erp_type3.put("mid_edit", admin_id);
			erp_type3.put("dt_edit", creditutil.time());
			erp_type3.put("status", 104);
			erp_type3.put("id", yw_id);
			//添加进度
			erp_result3.put("qryid",yw_id);
			erp_result3.put("mid_add",admin_id);
			erp_result3.put("mid_edit",admin_id);
			erp_result3.put("dt_add",creditutil.time());
			erp_result3.put("dt_edit",creditutil.time());
			erp_result3.put("status_oldht", 0);
			erp_result3.put("status", 104);
			erp_result3.put("remark","完成");
			erp_result3.put("result_1_code",0);
			erp_result3.put("result_1_msg","");		
			erp_result3.put("dt_sub", creditutil.time());
			erp_result3.put("type_id", type_id);
			erp_result3.put("icbc_id", icbc_id);
			erp_result3.put("jsonAll", "");
			erp_result3.put("dn", "icbc_erp_kj_icbc_result");
			erp_result3.put("result_1_value","");
			erp_wdrwService.update(erp_type3);
			erp_wdrwService.save(erp_result3);	
			//查询上一步节点
			PageData result_date=new PageData();
			result_date.put("dn", "yhds_tocode");
			result_date.put("type_id",10);
			result_date.put("status",49);
			result_date.put("icbc_id",icbc_id);
			PageData rData=erp_wdrwService.icbc_form(result_date);
			//
			PageData erp_result2=new PageData();//erp进度
			PageData erp_type2=new PageData();//erp板块
			erp_type2.put("dn", "icbc_erp_kj_icbc");
			erp_type2.put("mid_edit", admin_id);
			erp_type2.put("dt_edit", creditutil.time());
			erp_type2.put("status", 99);
			erp_type2.put("id",rData.get("id"));
			erp_type2.put("c_name", icbc_name);
			//添加进度
			erp_result2.put("qryid",rData.get("id"));
			erp_result2.put("mid_add",admin_id);
			erp_result2.put("mid_edit",admin_id);
			erp_result2.put("dt_add",rData.get("dt_edit"));
			erp_result2.put("dt_edit",creditutil.time());
			erp_result2.put("status_oldht", 0);
			erp_result2.put("status", 99);
			erp_result2.put("remark","等待融资");
			erp_result2.put("result_1_code",rz_jg);
			erp_result2.put("result_1_msg",rz_qtxx);		
			erp_result2.put("dt_sub", creditutil.time());
			erp_result2.put("type_id", 10);
			erp_result2.put("icbc_id", icbc_id);
			erp_result2.put("jsonAll", "");
			erp_result2.put("dn", "icbc_erp_kj_icbc_result");
			erp_result2.put("result_1_value",json_result.toString());
			erp_wdrwService.update(erp_type2);
			erp_wdrwService.save(erp_result2);
		}
	}
	
	
}
