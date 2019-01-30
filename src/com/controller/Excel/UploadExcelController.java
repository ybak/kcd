package com.controller.Excel;
import java.awt.Desktop;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


import com.controller.erp_icbc.base.BaseController;

import com.model1.icbc.erp.PageData;
import com.service1.Excel.recordService;
import com.util.limitutil;
import com.util.Excel.CommonUtil;
import com.util.Excel.RecordUtil;


import jxl.read.biff.BiffException;

@Controller
@RequestMapping("/uploadExcelController")
public class UploadExcelController extends BaseController{
	private static Logger log = LogManager.getLogger(UploadExcelController.class.getName());
	@Autowired
	private com.mapper1.Excel.uploadExcelMapper uploadExcelMapper;
	@Autowired
	private com.mapper1.Excel.recordMapper recordMapper;
	@Autowired
	private recordService recordService;  
	
	private Logger logger  = Logger.getLogger(UploadExcelController.class);
	private final  String xls = "xls";  
	private final  String xlsx = "xlsx"; 
	//客户姓名 身份证号 还款卡号 卡余额 逾期金额 连续违约次数 最大违约次数 导入日期 在保余额 
	private static String[] ss={"name","id_card","repayment_card","balance_card","overdue_amount","continuity","maximum","add_time","balance_on"};

//	/**
//	 * 往数据库中添加表中数据
//	 * @param list
//	 * @return
//	 * @throws IOException 
//	 * @throws BiffException
//	 */
//	@RequestMapping("/addExcel.do")
//	@ResponseBody
//	public String  addExcel(
//			
//			HttpServletRequest request,HttpServletResponse response,RecordUtil recordUtil) throws BiffException, IOException{  
//		    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
//	        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("file");
//	        String relatDir1=new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
//	        //文件夹不存在则创建
//	        File fdir = new File("D:/eclipse/kcd/WebContent/upload/"+relatDir1);
//	        if (!fdir.exists()) { fdir.mkdirs(); }
//
//	        String oriName = file.getOriginalFilename();
//	        File tempFile = new File(fdir.getPath()+File.separator+oriName);
//	        log.info("文件保存地址->"+tempFile);
//	        file.transferTo(tempFile);
//	       
////	        Map<String,String> rowMap=new HashMap<String,String>();
////	        String[] string= new String[4];//创建ss.length个二维数组，每个数组中有x条数据
////			// 获得工作簿对象 
////			Workbook workbook = Workbook.getWorkbook(tempFile); 
////			// 获得所有工作表 
////			Sheet[] sheets = workbook.getSheets(); 
////			// 遍历工作表 
////			if (sheets != null) { 
////				for (Sheet sheet : sheets) { 
////					// 获得行数 
////					int rows = sheet.getRows(); 
////					// 获得列数 
////					int cols = sheet.getColumns(); 
////					// 读取数据 
////					for (int row = 1; row < rows; row++) { 
////						
////						for (int col = 0; col < cols; col++) {
////							Cell cell = sheet.getCell(col, row); 
////							rowMap.put(ss[col], cell.getContents());
////							//log.info("-------->"+cell.getContents());
////							
////						}
////						log.info("添加还款数据->"+rowMap);
////						
////						int addCount=uploadExcelMapper.addExcel(rowMap);
////						
////						log.info("add->"+addCount);
////						//list.add(rowMap);
////					} 
////				} 				
////			} 
//	        
//	        
//			
//			
//			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式     new Date()为获取当前系统时间
//			PageData pdsession= (PageData)request.getSession().getAttribute("pd");//获取session信息
//			Map<String, String> map=new HashMap<String,String>();
//			map.put("uuid", CommonUtil.getUUID());//序列号
//			map.put("oriName", oriName);//文件名称
//		    map.put("dt_add", df.format(new Date()));//导入时间	
//			map.put("financial_products", "");
//			map.put("mid_add", pdsession.get("name").toString());//获取操作人员
//			recordMapper.addRecord(map);
//			
//			
//		   
//			
//			//map集合转换为JSON对象
//			//创建二维数组
//	        //JSONArray json = new JSONArray(string);
//			//将JSON对象传递给前端AJAX接收
//			response.setContentType("text/html;charset=UTF-8");
//			response.setContentType("application/json");
//			PrintWriter pw = response.getWriter();
//			//pw.print(json); // 轨迹图条件，取少量数据
//			pw.flush();
//			pw.close();
//			
//			//workbook.close(); 
//			return null;
//	}
	
	
	/**
	 * 通过文件名称模糊查询     查询全部数据并分页
	 * @param qn
	 * @param cn
	 * @param type
	 * @param dn
	 * @param totalpage
	 * @param pagenow
	 * @param status
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/select")
	public String select(
			String qn,
			String cn,
			String type,
			String dn,		
			int pagesize,
			int pagenow,
			HttpServletRequest request) throws UnsupportedEncodingException{
	
		requestParams(request);
		List<PageData> newpdList=new ArrayList<>();
		PageData pd=new PageData();
		pd.put("dn", dn);
		String param=request.getParameter("param");
		List<PageData> l1 = recordService.selectRecord(param, pd);
		newpdList=limitutil.fy(l1, pagesize, pagenow);
		System.out.println("*************"+newpdList);
		int q=l1.size()%pagesize;
		int totalpage=0;//总页数
		if(q==0){
			totalpage=l1.size()/pagesize;
		}else{
			totalpage=l1.size()/pagesize+1;
		}
		request.setAttribute("dn", dn);
		request.setAttribute("cn", cn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);
		request.setAttribute("totalpage",totalpage);
		request.setAttribute("pagenow",pagenow);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("totalsize",l1.size());
		request.setAttribute("newpdList", newpdList);
		log.info("结果"+l1);
		return "kjs_icbc/index";
	}
	
	/**
	 * 下载文件
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @throws ParseException
	 */
	@RequestMapping("/download.do")
	@ResponseBody
	public void download(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
		String oriName = request.getParameter("oriName");    //获取要下载的文件名
		if(StringUtils.isNotBlank(oriName)){
			oriName = new String(oriName.getBytes("ISO-8859-1"),"utf-8");
		}
		DataInputStream in = null;
        OutputStream out = null;
		System.out.println(oriName+"------------------------------------");
//		response.setHeader("Content-Disposition", "attachment;oriName="+oriName);  //让浏览器收到这份资源时，以下载的方式提醒，而不是展示；
		
		String dt_add=request.getParameter("dt_add");//获取导入时间
		log.info(dt_add+"**************************");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
		String dstr=dt_add;  //string转成date类型
		java.util.Date date=sdf.parse(dstr);  
		String year=String.format("%tY", date);
		String month=String .format("%tm", date);
		String day=String .format("%td", date);
		System.out.println("年: " + year);  
	    System.out.println("月: " + month);  
	    System.out.println("日: " + day);  
		String excelPath = request.getSession().getServletContext().getRealPath("/upload/" + year + "/" + month + "/" + day + "/" +oriName);//获取文件路径
        log.info("路径"+excelPath);
        
        try{
        	response.reset();// 清空输出流
            
            String resultFileName = oriName;
           log.info("文件名********"+resultFileName);
            response.setCharacterEncoding("UTF-8");  
            //response.setHeader("Content-disposition", "attachment; oriName=" + resultFileName);// 设定输出文件头
            response.setHeader("Content-Disposition", "attachment;filename=" + resultFileName);
            response.setContentType("application/msexcel");// 定义输出类型
            //输入流：本地文件路径
            in = new DataInputStream(
                    new FileInputStream(new File(excelPath)));  
            //输出流
            out = response.getOutputStream();
            //输出文件
            int bytes = 0;
            byte[] bufferOut = new byte[1024];  
            while ((bytes = in.read(bufferOut)) != -1) {  
                out.write(bufferOut, 0, bytes);  
            }
        } catch(Exception e){
            e.printStackTrace();
            response.reset();
            try {
                OutputStreamWriter writer = new OutputStreamWriter(response.getOutputStream(), "UTF-8");  
                String data = "<script language='javascript'>alert(\"\\u64cd\\u4f5c\\u5f02\\u5e38\\uff01\");</script>";
                writer.write(data); 
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }finally {
            if(null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		System.out.println("下载成功");
		
		
		
		} 
	
		/**
		 * 打开excel文件
		 * @param request
		 * @param response
		 * @return
		 * @throws ParseException
		 */
		@RequestMapping("/openExcel.do")
		public String openExcel(HttpServletRequest request, HttpServletResponse response) throws ParseException{
			String oriName = request.getParameter("oriName");    //获取要打开的文件名
			String dt_add=request.getParameter("dt_add");//获取导入时间
			log.info(dt_add+"**************************");
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");//小写的mm表示的是分钟  
			String dstr=dt_add;  //string转成date类型
			java.util.Date date=sdf.parse(dstr);  
			String year=String.format("%tY", date);
			String month=String .format("%tm", date);
			String day=String .format("%td", date);
			System.out.println("年: " + year);  
		    System.out.println("月: " + month);  
		    System.out.println("日: " + day);  
			String excelPath = request.getSession().getServletContext().getRealPath("/upload/" + year + "/" + month + "/" + day + "/" +oriName);//获取文件路径
	        log.info("路径"+excelPath);
	        
	        try {
	            File file = new File(excelPath); // 创建文件对象
	            Desktop.getDesktop().open(file); // 启动已在本机桌面上注册的关联应用程序，打开文件文件file。
	        } catch (IOException | NullPointerException e) { // 异常处理
	            System.err.println(e);
	        }

			return "redirect:/uploadExcelController/select.do?type=hklr&dn=dh_repaymentEntry&qn=list&cn=w1&pagesize=5&pagenow=1";
			
		}


	private ServletRequest getServletContext() {
		// TODO Auto-generated method stub
		return null;
	}


	

	
	
	
	private void requestParams(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}


	private static String[] insert(String[] arr, String str)
	{
	int size = arr.length;

	String[] tmp = new String[size + 1];

	System.arraycopy(arr, 0, tmp, 0, size);

	tmp[size] = str;

	return tmp;
	}
	

	public static void volidateCelll(String s,int i){
		
	}
	
	
	/** 
     * 读入excel文件，解析后返回 
     * @param file 
     * @throws IOException  
     */  
	@RequestMapping("/readExcel.do")
	@ResponseBody
    public Map readExcel(HttpServletRequest request,HttpServletResponse response) throws IOException{  
        
    	MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("file"); 	
    	String relatDir1=new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
        //文件夹不存在则创建
        File fdir = new File("/KCDIMG/assess/upload/"+relatDir1);
        if (!fdir.exists()) { fdir.mkdirs(); }

        String oriName = file.getOriginalFilename();
        
        File tempFile = new File(fdir.getPath()+"/"+oriName);
        log.info("文件保存地址->"+tempFile);
        file.transferTo(tempFile);
        
        String[] string= new String[4];//创建ss.length个二维数组，每个数组中有x条数据
    	//检查文件  
        checkFile(file);  
        //获得Workbook工作薄对象  
        Workbook workbook = getWorkBook(file);  
        //创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回  
        Map<String,String> rowMap=new HashMap<String,String>();
        List<String[]> list = new ArrayList<String[]>();  
        if(workbook != null){  
            for(int sheetNum = 0;sheetNum < workbook.getNumberOfSheets();sheetNum++){  
                //获得当前sheet工作表  
                Sheet sheet = workbook.getSheetAt(sheetNum);  
                if(sheet == null){  
                    continue;  
                }  
                //获得当前sheet的开始行  
                int firstRowNum  = sheet.getFirstRowNum();  
                //获得当前sheet的结束行  
                int lastRowNum = sheet.getLastRowNum();  
                //循环除了第一行的所有行  
                for(int rowNum = firstRowNum+1;rowNum <= lastRowNum;rowNum++){  
                    //获得当前行  
                    Row row = sheet.getRow(rowNum);  
                    if(row == null){  
                        continue;  
                    }  
                    //获得当前行的开始列  
                    int firstCellNum = row.getFirstCellNum();  
                    //获得当前行的列数  
                    int lastCellNum = row.getPhysicalNumberOfCells();  
                    String[] cells = new String[row.getPhysicalNumberOfCells()];  
                    //循环当前行  
                    for(int cellNum = firstCellNum; cellNum < lastCellNum;cellNum++){  
                        Cell cell = row.getCell(cellNum);  
                        cells[cellNum] = getCellValue(cell);
                        rowMap.put(ss[cellNum], cells[cellNum]);
						
					
					
                    }  
                    uploadExcelMapper.addExcel(rowMap);
                    //list.add(cells);  
                }  
            }  
            //workbook.close();  
        }  
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式     new Date()为获取当前系统时间
		PageData pdsession= (PageData)request.getSession().getAttribute("pd");//获取session信息
		Map<String, String> map=new HashMap<String,String>();
		map.put("uuid", CommonUtil.getUUID());//序列号
		map.put("oriName", oriName);//文件名称
	    map.put("dt_add", df.format(new Date()));//导入时间	
		map.put("financial_products", "");
		map.put("filepath", "upload/"+relatDir1+oriName);
		map.put("mid_add", pdsession.get("name").toString());//获取操作人员
		recordMapper.addRecord(map);
		//map集合转换为JSON对象
		//创建二维数组
       // JSONArray json = new JSONArray(string);
		//将JSON对象传递给前端AJAX接收
//		response.setContentType("text/html;charset=UTF-8");
//		response.setContentType("application/json");
//		PrintWriter pw = response.getWriter();
//		//pw.print(json); // 轨迹图条件，取少量数据
//		pw.flush();
//		pw.close();
		//workbook.close();
		Map result =new HashMap();
		result.put("msg","导入成功");
		result.put("code","1");
		return result;
    }  
    public void checkFile(MultipartFile file) throws IOException{  
        //判断文件是否存在  
        if(null == file){  
            logger.error("文件不存在！");  
            throw new FileNotFoundException("文件不存在！");  
        }  
        //获得文件名  
        String fileName = file.getOriginalFilename();  
        //判断文件是否是excel文件  
        if(!fileName.endsWith(xls) && !fileName.endsWith(xlsx)){  
            logger.error(fileName + "不是excel文件");  
            throw new IOException(fileName + "不是excel文件");  
        }  
    }  
    public Workbook getWorkBook(MultipartFile file) {  
        //获得文件名  
        String fileName = file.getOriginalFilename();  
        //创建Workbook工作薄对象，表示整个excel  
        Workbook workbook = null;  
        try {  
            //获取excel文件的io流  
            InputStream is = file.getInputStream();  
            //根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象  
            if(fileName.endsWith(xls)){  
                //2003  
                workbook = new HSSFWorkbook(is);  
            }else if(fileName.endsWith(xlsx)){  
                //2007  
                workbook = new XSSFWorkbook(is);  
            }  
        } catch (IOException e) {  
            logger.info(e.getMessage());  
        }  
        return workbook;  
    }  
    public String getCellValue(Cell cell){  
        String cellValue = "";  
        if(cell == null){  
            return cellValue;  
        }  
        //把数字当成String来读，避免出现1读成1.0的情况  
        if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){  
            cell.setCellType(Cell.CELL_TYPE_STRING);  
        }  
        //判断数据的类型  
        switch (cell.getCellType()){  
            case Cell.CELL_TYPE_NUMERIC: //数字  
                cellValue = String.valueOf(cell.getNumericCellValue());  
                break;  
            case Cell.CELL_TYPE_STRING: //字符串  
                cellValue = String.valueOf(cell.getStringCellValue());  
                break;  
            case Cell.CELL_TYPE_BOOLEAN: //Boolean  
                cellValue = String.valueOf(cell.getBooleanCellValue());  
                break;  
            case Cell.CELL_TYPE_FORMULA: //公式  
                cellValue = String.valueOf(cell.getCellFormula());  
                break;  
            case Cell.CELL_TYPE_BLANK: //空值   
                cellValue = "";  
                break;  
            case Cell.CELL_TYPE_ERROR: //故障  
                cellValue = "非法字符";  
                break;  
            default:  
                cellValue = "未知类型";  
                break;  
        }  
        return cellValue;  
    }  
}


