package com.controller.ManagementCenter.Management;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itextpdf.text.log.SysoCounter;
import com.model1.ManagementCenter.assess_fs;
import com.model1.icbc.erp.PageData;
import com.service1.ManagementCenter.kj_icbcService;

@Controller
public class Management {
	@Autowired
	private kj_icbcService kj_icbcService;
	private String gems;
	assess_fs assess_fs = new assess_fs();
	
	//��ѯ������ID
    private String SelectGems(String gems){
        String s;
        assess_fs.setGems(gems);
        s = kj_icbcService.SelectGemsId(assess_fs);//���ݿ��ѯ����
        if(s == null || s == ""){
            s="0";
        }
        return s;
    }

	// ǰ̨���ݺ�̨��ȡ
	public void management(HttpServletRequest request) {
		PageData pdLoginSession = (PageData) request.getSession().getAttribute(
				"pd");
		assess_fs.setId(Integer
				.parseInt(pdLoginSession.get("fs_id").toString()));// Integer.parseInt(pdLoginSession.get("fs_id").toString())
		assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id")
				.toString()));
		List<HashMap> loanlist = kj_icbcService.SelectLoan(assess_fs);// �����ѷſ�����ܽ��
																		// amount=0/money=null
		if (loanlist.get(0).get("amount").equals(0)) {
			loanlist.get(0).put("money", 0);
		}
		List<HashMap> fklist = kj_icbcService.SelectFk(assess_fs);// �����ѷſ�δ��Ѻ�������ܽ��
																	// amount=0/money=null
		if (fklist.get(0).get("amount").equals(0)) {
			fklist.get(0).put("money", 0);
		}

		List<HashMap> rankinglist = kj_icbcService.SelectStates(assess_fs);// ÿ���ܶ�������ʡ����
																			// sell,name=null
		for (int i = 0; i < rankinglist.size(); i++) {
			if (rankinglist.get(i).get("sell") == null
					&& rankinglist.get(0).get("sell").equals("")) {
				rankinglist.get(i).put("sell", 0);
				rankinglist.get(i).put("name", " ");
			}
		}

		List<HashMap> gemslist = kj_icbcService.SelectGems(assess_fs);// ÿ���ܶ�����������������
																		// gems,name=null
		for (int i = 0; i < gemslist.size(); i++) {
			if (gemslist.get(i).get("gems") == null
					&& gemslist.get(0).get("gems").equals("")) {
				gemslist.get(i).put("gems", 0);
				gemslist.get(i).put("name", " ");
			}
		}

		List<HashMap> rankingloanlist = kj_icbcService
				.SelectLoanStates(assess_fs);// ÿ�·ſ����ʡ���� sell,name=null
		for (int i = 0; i < rankingloanlist.size(); i++) {
			if (rankingloanlist.get(i).get("sell") == null
					&& rankingloanlist.get(0).get("sell").equals("")) {
				rankingloanlist.get(i).put("sell", 0);
				rankingloanlist.get(i).put("name", " ");
			}
		}

		List<HashMap> gemsloanlist = kj_icbcService.SelectLoanGems(assess_fs);// ÿ�·ſ��������������
																				// gems,name=null
		for (int i = 0; i < gemsloanlist.size(); i++) {
			if (gemsloanlist.get(i).get("gems") == null
					&& gemsloanlist.get(0).get("gems").equals("")) {
				gemsloanlist.get(i).put("gems", 0);
				gemsloanlist.get(i).put("name", " ");
			}
		}

		List<HashMap> cardpasscomm = kj_icbcService
				.SelectCarPassComm(assess_fs);// ÿ��������������ʸ�ʡ���� rate,name=null
		for (int i = 0; i < cardpasscomm.size(); i++) {
			if (cardpasscomm.get(i).get("rate") == null
					&& cardpasscomm.get(0).get("rate").equals("")) {
				cardpasscomm.get(i).put("rate", 0);
				cardpasscomm.get(i).put("name", " ");
			}
		}

		List<HashMap> cardpassgems = kj_icbcService
				.SelectCarPassGems(assess_fs);// ÿ��������������ʸ����������� rate,name=null
		for (int i = 0; i < cardpassgems.size(); i++) {
			if (cardpassgems.get(i).get("rate") == null
					&& cardpassgems.get(0).get("rate").equals("")) {
				cardpassgems.get(i).put("rate", 0);
				cardpassgems.get(i).put("name", " ");
			}
		}
		
		//�����ʴ��������� 
		List<HashMap> yuqilv = kj_icbcService.SelectYuqilv(assess_fs);
		request.setAttribute("yuqilv",yuqilv );
		
		
		
		List<HashMap> comm_city=kj_icbcService.SelectCity();
		request.setAttribute("comm_city",comm_city );//ʡ���б�

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        Date date = new Date();
        int formatDate = Integer.parseInt(sdf.format(date));
        int[] years=new int[5];
        for(int i=0;i<5;i++){
            years[i]=formatDate-i;
        }
        request.setAttribute("years",years );//����б�

        String[] count = new String[10];
        for(int i=0;i<10;i++){
            count[i]=i+"";
        }
        request.setAttribute("count",count );

		request.setAttribute("billlist", kj_icbcService.SelectBill(assess_fs));// ÿ�±�������
																				// 0
		request.setAttribute("loanlist", loanlist);// ÿ���ѷſ�����ܽ��
		request.setAttribute("fklist", fklist);// ÿ���ѷſ�δ��Ѻ�������ܽ��
		request.setAttribute("carselect", kj_icbcService.CountSelect(assess_fs));// ������������
																					// 0
		request.setAttribute("carpass", kj_icbcService.CountPass(assess_fs));// ��������ͨ��
																				// 0
		request.setAttribute("rankinglist", rankinglist);// ÿ���ܶ�������ʡ����
		request.setAttribute("gemslist", gemslist);// ÿ���ܶ�����������������
		request.setAttribute("rankingloanlist", rankingloanlist);// ÿ���ܶ�����������ʡ����
		request.setAttribute("gemsloanlist", gemsloanlist);// ÿ���ܶ���������������������
		request.setAttribute("cardpasscomm", cardpasscomm);// ÿ��������������ʸ�ʡ����
		request.setAttribute("cardpassgems", cardpassgems);// ÿ��������������ʸ�����������

		// request.setAttribute("lll",lll);
	}

	// ÿ�������ܵ�������ͼajaxǰ̨��ȡ null,null,null
	@RequestMapping("erp/Management/getPathMap.do")
	@ResponseBody
	public String getPathMap(HttpServletRequest request,
			HttpServletResponse response,String baodanname,String baodancity,String baodantime) {
		try {
			/*** ��������ȡֵ���ɶ�ά���ݣ���ת��json ***/
			PageData pdLoginSession = (PageData) request.getSession()
					.getAttribute("pd");
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			if(!baodanname.equals("�����������") && !baodanname.equals("")) {
				gems=SelectGems(baodanname);
				assess_fs.setGems_id(Integer.parseInt(gems));
			}else{
				assess_fs.setGems_id(-1);
			}
	        if(!baodancity.equals("0")){
	        	assess_fs.setCity_id(Integer.parseInt(baodancity));
	        }else{
	        	assess_fs.setCity_id(0);
			}
	        //�ж��Ƿ�ѡ��ʱ��
	        if(!baodantime.equals("0")){
	        	assess_fs.setTimedate(Integer.parseInt(baodantime));
	        }else{
	        	assess_fs.setTimedate(0);
			}
			List<HashMap> chart = kj_icbcService.SelectChart(assess_fs);// ��̨��ȡ��ѯ����
			Object[][] Ochart = new Object[2][9];
			if (chart.size() < 9) {
				for (int i = 0; i < chart.size(); i++) {
					Ochart[1][i] = (chart.get(i).get("year") + "-" + chart.get(
							i).get("month"));// �����ڸ�ʽ��������ά����xxxx-xx
					Ochart[0][i] = (chart.get(i).get("total"));// ��ÿ�����ݷ����ά����

				}
				for (int i = chart.size(); i < 9; i++) {
					Ochart[1][i] = "2018-";
					Ochart[0][i] = "0";
				}
			} else {
				for (int i = 0; i < 9; i++) {
					Ochart[1][i] = (chart.get(i).get("year") + "-" + chart.get(
							i).get("month"));// �����ڸ�ʽ��������ά����xxxx-xx
					Ochart[0][i] = (chart.get(i).get("total"));// ��ÿ�����ݷ����ά����
				}
			}
			JSONArray jsonArray = JSONArray.fromObject(Ochart);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // �켣ͼ������ȡ��������
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}

	// ��������ͨ��������ͼajaxǰ̨��ȡ
	@RequestMapping("erp/Management/getCarPathMap.do")
	@ResponseBody
	public String getCarPathMap(HttpServletRequest request,
			HttpServletResponse response,String guojianname,String guojiancity,String guojiantime) {
		try {
			/*** ��������ȡֵ���ɶ�ά���ݣ���ת��json ***/
			PageData pdLoginSession = (PageData) request.getSession()
					.getAttribute("pd");
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			if(!guojianname.equals("�����������") && !guojianname.equals("")) {
				gems=SelectGems(guojianname);
				assess_fs.setGems_id(Integer.parseInt(gems));
			}else{
				assess_fs.setGems_id(-1);
			}
	        if(!guojiancity.equals("0")){
	        	assess_fs.setCity_id(Integer.parseInt(guojiancity));
	        }else{
	        	assess_fs.setCity_id(0);
			}
	        //�ж��Ƿ�ѡ��ʱ��
	        if(!guojiantime.equals("0")){
	        	assess_fs.setTimedate(Integer.parseInt(guojiantime));
	        }else{
	        	assess_fs.setTimedate(0);
			}
			List<HashMap> chart = kj_icbcService.SelectCarChart(assess_fs);// ��̨��ȡ��ѯ����
			Object[][] Ochart = new Object[2][9];
			if (chart.size() < 9) {
				for (int i = 0; i < chart.size(); i++) {
					Ochart[1][i] = (chart.get(i).get("year") + "-" + chart.get(
							i).get("month"));// �����ڸ�ʽ��������ά����xxxx-xx
					Ochart[0][i] = (chart.get(i).get("total"));// ��ÿ�����ݷ����ά����

				}
				for (int i = chart.size(); i < 9; i++) {
					Ochart[1][i] = "2018-";
					Ochart[0][i] = "0";
				}
			} else {
				for (int i = 0; i < 9; i++) {
					Ochart[0][i] = (chart.get(i).get("total"));// ��ÿ�����ݷ����ά����
					Ochart[1][i] = (chart.get(i).get("year") + "-" + chart.get(
							i).get("month"));// �����ڸ�ʽ��������ά����xxxx-xx
				}
			}
			JSONArray jsonArray = JSONArray.fromObject(Ochart);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // �켣ͼ������ȡ��������
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}

	// �¾���������ֲ�����ͼajaxǰ̨��ȡ
	@RequestMapping("erp/Management/getCarFkPathMap.do")
	@ResponseBody
	public String getCarFkPathMap(HttpServletRequest request,
			HttpServletResponse response,String fangkuanname,String fangkuancity,String fangkuantime) {
		try {
			/*** ��������ȡֵ���ɶ�ά���ݣ���ת��json ***/
			PageData pdLoginSession = (PageData) request.getSession()
					.getAttribute("pd");
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			if(!fangkuanname.equals("�����������") && !fangkuanname.equals("")) {
				gems=SelectGems(fangkuanname);
				assess_fs.setGems_id(Integer.parseInt(gems));
			}else{
				assess_fs.setGems_id(-1);
			}
	        if(!fangkuancity.equals("0")){
	        	assess_fs.setCity_id(Integer.parseInt(fangkuancity));
	        }else{
	        	assess_fs.setCity_id(0);
			}
	        //�ж��Ƿ�ѡ��ʱ��
	        if(!fangkuantime.equals("0")){
	        	assess_fs.setTimedate(Integer.parseInt(fangkuantime));
	        }else{
	        	assess_fs.setTimedate(0);
			}
			List<HashMap> chart = kj_icbcService.SelectCarFk(assess_fs);// ��̨��ȡ��ѯ����
			String[] s = new String[2];
			if (chart.size() < 2) {
				if (chart.size() < 1) {
					for (int i = 0; i < 2; i++) {
						s[i] = "0";
					}
				} else {
					if (chart.get(0).get("cartype").toString().equals("1")) {
						s[0] = chart.get(0).get("cartotal").toString();
						s[1] = "0";
					} else {
						s[0] = "0";
						s[1] = chart.get(0).get("cartotal").toString();
					}
				}
			} else {
				for (int i = 0; i < 2; i++) {
					s[i] = chart.get(i).get("cartotal").toString();
				}
			}
			JSONArray jsonArray = JSONArray.fromObject(s);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // �켣ͼ������ȡ��������
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}

	// ������ֲ�����ͼajaxǰ̨��ȡ null,null,null,null
	@RequestMapping("erp/Management/getMoneyPathMap.do")
	@ResponseBody
	public String getMoneyPathMap(HttpServletRequest request,
			HttpServletResponse response,String fangkuanname,String fangkuancity,String fangkuantime) {
		try {
			/*** ��������ȡֵ���ɶ�ά���ݣ���ת��json ***/
			PageData pdLoginSession = (PageData) request.getSession()
					.getAttribute("pd");
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			if(!fangkuanname.equals("�����������") && !fangkuanname.equals("")) {
				gems=SelectGems(fangkuanname);
				assess_fs.setGems_id(Integer.parseInt(gems));
			}else{
				assess_fs.setGems_id(-1);
			}
	        if(!fangkuancity.equals("0")){
	        	assess_fs.setCity_id(Integer.parseInt(fangkuancity));
	        }else{
	        	assess_fs.setCity_id(0);
			}
	        //�ж��Ƿ�ѡ��ʱ��
	        if(!fangkuantime.equals("0")){
	        	assess_fs.setTimedate(Integer.parseInt(fangkuantime));
	        }else{
	        	assess_fs.setTimedate(0);
			}
			List<HashMap> chart = kj_icbcService
					.SelectMoneyDistribute(assess_fs);// ��̨��ȡ��ѯ����
			String[] s = new String[4];
			if (chart.get(0) == null) {
				for (int i = 0; i < 4; i++) {
					s[i] = "0";
				}
			} else {
				for (int i = 1; i < 5; i++) {
					if (chart.get(0).get("singular" + i) == null) {
						s[i - 1] = "0";
					} else {
						s[i - 1] = chart.get(0).get("singular" + i).toString();
					}
				}
			}
			JSONArray jsonArray = JSONArray.fromObject(s);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // �켣ͼ������ȡ��������
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}

	// ��Ѻ��������ֲ�����ͼajaxǰ̨��ȡ
	@RequestMapping("erp/Management/getPawnPathMap.do")
	@ResponseBody
	public String getPawnPathMap(HttpServletRequest request,
			HttpServletResponse response,String diyaname,String diyacity,String diyatime) {
		try {
			/*** ��������ȡֵ���ɶ�ά���ݣ���ת��json ***/
			PageData pdLoginSession = (PageData) request.getSession()
					.getAttribute("pd");
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));// Integer.parseInt(pdLoginSession.get("fs_id").toString())
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			if(!diyaname.equals("�����������") && !diyaname.equals("")) {
				gems=SelectGems(diyaname);
				assess_fs.setGems_id(Integer.parseInt(gems));
			}else{
				assess_fs.setGems_id(-1);
			}
	        if(!diyacity.equals("0")){
	        	assess_fs.setCity_id(Integer.parseInt(diyacity));
	        }else{
	        	assess_fs.setCity_id(0);
			}
	        //�ж��Ƿ�ѡ��ʱ��
	        if(!diyatime.equals("0")){
	        	assess_fs.setTimedate(Integer.parseInt(diyatime));
	        }else{
	        	assess_fs.setTimedate(0);
			}
			List<HashMap> chart = kj_icbcService.SelectResult(assess_fs);// ��̨��ȡ��ѯ����

			String[] s = new String[5];
			if (chart.get(0) == null) {
				for (int i = 0; i < 5; i++) {
					s[i] = "0";
				}
			} else {
				for (int i = 1; i < 6; i++) {
					if (chart.get(0).get("paw" + i) == null) {
						s[i - 1] = "0";
					} else {
						s[i - 1] = chart.get(0).get("paw" + i).toString();
					}
				}
			}
			JSONArray jsonArray = JSONArray.fromObject(s);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // �켣ͼ������ȡ��������
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}

	// ���Ų�ѯ�ֲ�����ͼajaxǰ̨��ȡ null,null 0,1
	@RequestMapping("erp/Management/getCreditPathMap.do")
	@ResponseBody
	public String getCreditPathMap(HttpServletRequest request,
			HttpServletResponse response,String zhengxinname,String zhengxincity,String zhengxintime) {
		try {
			/*** ��������ȡֵ���ɶ�ά���ݣ���ת��json ***/
			PageData pdLoginSession = (PageData) request.getSession()
					.getAttribute("pd");
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			if(!zhengxinname.equals("�����������") && !zhengxinname.equals("")) {
				gems=SelectGems(zhengxinname);
				assess_fs.setGems_id(Integer.parseInt(gems));
			}else{
				assess_fs.setGems_id(-1);
			}
	        if(!zhengxincity.equals("0")){
	        	assess_fs.setCity_id(Integer.parseInt(zhengxincity));
	        }else{
	        	assess_fs.setCity_id(0);
			}
	        //�ж��Ƿ�ѡ��ʱ��
	        if(!zhengxintime.equals("0")){
	        	assess_fs.setTimedate(Integer.parseInt(zhengxintime));
	        }else{
	        	assess_fs.setTimedate(0);
			}
			List<HashMap> credit = kj_icbcService.SelectCredit(assess_fs);// ��̨��ȡ��ѯ����
			String[] s = new String[2];
			if (credit.size() < 2) {
				if (credit.size() < 1) {
					for (int i = 0; i < 2; i++) {
						s[i] = "0";
					}
				} else {
					if (credit.get(0).get("zxok_tag").toString().equals("1")) {
						s[0] = credit.get(0).get("zxok").toString();
						s[1] = "0";
					} else {
						s[0] = "0";
						s[1] = credit.get(0).get("zxok").toString();
					}
				}
			} else {
				for (int i = 0; i < 2; i++) {
					s[i] = credit.get(i).get("zxok").toString();
				}
			}

			JSONArray jsonArray = JSONArray.fromObject(s);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // �켣ͼ������ȡ��������
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}

	// �ͻ�����ֲ�����ͼajaxǰ̨��ȡ null,null,null,null
	@RequestMapping("erp/Management/getAgePathMap.do")
	@ResponseBody
	public String getAgePathMap(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			/*** ��������ȡֵ���ɶ�ά���ݣ���ת��json ***/
			PageData pdLoginSession = (PageData) request.getSession()
					.getAttribute("pd");
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			List<HashMap> credit = kj_icbcService.SelectClientAge(assess_fs);// ��̨��ȡ��ѯ����
			String[] s = new String[4];
			if (credit.get(0) == null) {
				for (int i = 0; i < 4; i++) {
					s[i] = "0";
				}
			} else {
				for (int i = 1; i < 5; i++) {
					if (credit.get(0).get("age" + i) == null) {
						s[i - 1] = "0";
					} else {
						s[i - 1] = credit.get(0).get("age" + i).toString();
					}
				}
			}
			JSONArray jsonArray = JSONArray.fromObject(s);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // �켣ͼ������ȡ��������
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}

	// �³�����ֲ�����ͼajaxǰ̨��ȡ null,null,null,null
	@RequestMapping("erp/Management/getCarsAgePathMap.do")
	@ResponseBody
	public String getCarsAgePathMap(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			/*** ��������ȡֵ���ɶ�ά���ݣ���ת��json ***/
			PageData pdLoginSession = (PageData) request.getSession()
					.getAttribute("pd");
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			List<HashMap> carsage = kj_icbcService.SelectCarsAge(assess_fs);// ��̨��ȡ��ѯ����
			String[] s = new String[4];
			if (carsage.get(0) == null) {
				for (int i = 0; i < 4; i++) {
					s[i] = "0";
				}
			} else {
				for (int i = 1; i < 5; i++) {
					if (carsage.get(0).get("age" + i) == null) {
						s[i - 1] = "0";
					} else {
						s[i - 1] = carsage.get(0).get("age" + i).toString();
					}
				}
			}
			JSONArray jsonArray = JSONArray.fromObject(s);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // �켣ͼ������ȡ��������
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}

	// ���������ֲ�ͼajaxǰ̨��ȡ null,null,null
	@RequestMapping("erp/Management/getAdvanceFundPathMap.do")
	@ResponseBody
	public String getAdvanceFundPathMap(HttpServletRequest request,
			HttpServletResponse response,String dianzicity) {
		try {
			/*** ��������ȡֵ���ɶ�ά���ݣ���ת��json ***/
			PageData pdLoginSession = (PageData) request.getSession()
					.getAttribute("pd");
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			 if(!dianzicity.equals("0")){
		        	assess_fs.setCity_id(Integer.parseInt(dianzicity));
		        }else{
		        	assess_fs.setCity_id(0);
				}
			List<HashMap> fund = kj_icbcService.SelectAdvanceFund(assess_fs);// ��̨��ȡ��ѯ����
			Object[][] Ofund = new Object[2][12];
			if (fund.size() < 12) {
				for (int i = 0; i < fund.size(); i++) {
					Ofund[1][i] = (fund.get(i).get("year") + "-" + fund.get(i)
							.get("month"));// �����ڸ�ʽ��������ά����xxxx-xx
					Ofund[0][i] = (fund.get(i).get("adate"));// ��ÿ�����ݷ����ά����

				}
				for (int i = fund.size(); i < 12; i++) {
					Ofund[1][i] = "2018-";
					Ofund[0][i] = "0";
				}
			} else {
				for (int i = 0; i < 12; i++) {
					Ofund[0][i] = (fund.get(i).get("adate"));// ��ÿ�����ݷ����ά����
					Ofund[1][i] = (fund.get(i).get("year") + "-" + fund.get(i)
							.get("month"));// �����ڸ�ʽ��������ά����xxxx-xx
				}
			}

			// System.out.println(Ochart);
			JSONArray jsonArray = JSONArray.fromObject(Ofund);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // �켣ͼ������ȡ��������
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}

	// ��Ѻ���ϻ��շֲ�ͼajaxǰ̨��ȡ null,null,null
	@RequestMapping("erp/Management/getRecyclePathMap.do")
	@ResponseBody
	public String getRecyclePathMap(HttpServletRequest request,
			HttpServletResponse response,String cailiaoname,String cailiaocity,String cailiaotime) {
		try {
			/*** ��������ȡֵ���ɶ�ά���ݣ���ת��json ***/
			PageData pdLoginSession = (PageData) request.getSession()
					.getAttribute("pd");
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));// Integer.parseInt(pdLoginSession.get("fs_id").toString())
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			if(!cailiaoname.equals("�����������") && !cailiaoname.equals("")) {
				gems=SelectGems(cailiaoname);
				assess_fs.setGems_id(Integer.parseInt(gems));
			}else{
				assess_fs.setGems_id(-1);
			}
	        if(!cailiaocity.equals("0")){
	        	assess_fs.setCity_id(Integer.parseInt(cailiaocity));
	        }else{
	        	assess_fs.setCity_id(0);
			}
	        //�ж��Ƿ�ѡ��ʱ��
	        if(!cailiaotime.equals("0")){
	        	assess_fs.setTimedate(Integer.parseInt(cailiaotime));
	        }else{
	        	assess_fs.setTimedate(0);
			}
			List<HashMap> fund = kj_icbcService.SelectRecycle(assess_fs);// ��̨��ȡ��ѯ����
			Object[][] Ofund = new Object[2][9];
			if (fund.size() < 9) {
				for (int i = 0; i < fund.size(); i++) {
					Ofund[1][i] = (fund.get(i).get("year") + "-" + fund.get(i)
							.get("month"));// �����ڸ�ʽ��������ά����xxxx-xx
					Ofund[0][i] = (fund.get(i).get("total"));// ��ÿ�����ݷ����ά����

				}
				for (int i = fund.size(); i < 9; i++) {
					Ofund[1][i] = "2018-";
					Ofund[0][i] = "0";
				}
			} else {
				for (int i = 0; i < 9; i++) {
					Ofund[0][i] = (fund.get(i).get("total"));// ��ÿ�����ݷ����ά����
					Ofund[1][i] = (fund.get(i).get("year") + "-" + fund.get(i)
							.get("month"));// �����ڸ�ʽ��������ά����xxxx-xx
				}
			}
			// System.out.println(Ochart);
			JSONArray jsonArray = JSONArray.fromObject(Ofund);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // �켣ͼ������ȡ��������
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}

	// �¾ɳ��ſ�ֲ�ͼajaxǰ̨��ȡ null,null,null,null
	@RequestMapping("erp/Management/getNewOldCarsPathMap.do")
	@ResponseBody
	public String getNewOldCarsPathMap(HttpServletRequest request,
			HttpServletResponse response,String fangkuanname,String fangkuancity,String fangkuantime) {
		try {
			/*** ��������ȡֵ���ɶ�ά���ݣ���ת��json ***/
			PageData pdLoginSession = (PageData) request.getSession()
					.getAttribute("pd"); //
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			
			if(!fangkuanname.equals("�����������") && !fangkuanname.equals("")) {
				gems=SelectGems(fangkuanname);
				assess_fs.setGems_id(Integer.parseInt(gems));
			}else{
				assess_fs.setGems_id(-1);
			}
	        if(!fangkuancity.equals("0")){
	        	assess_fs.setCity_id(Integer.parseInt(fangkuancity));
	        }else{
	        	assess_fs.setCity_id(0);
			}
	        //�ж��Ƿ�ѡ��ʱ��
	        if(!fangkuantime.equals("0")){
	        	assess_fs.setTimedate(Integer.parseInt(fangkuantime));
	        }else{
	        	assess_fs.setTimedate(0);
			}
			List<HashMap> newcars = kj_icbcService.SelectNewCars(assess_fs);// ��̨��ȡ��ѯ����
			Object[][] Ofund = new Object[5][12];
			if (newcars.size() < 12) {
				for (int i = 0; i < newcars.size(); i++) {
					Ofund[0][i] = (newcars.get(i).get("year1") + "-" + newcars
							.get(i).get("month1"));// �����ڸ�ʽ��������ά����xxxx-xx
					Ofund[1][i] = (newcars.get(i).get("newcon"));// ���³�ÿ�·ſ�������ά����
					Ofund[2][i] = (newcars.get(i).get("newmoney"));// ���³�ÿ�·ſ��ܽ������ά����
					Ofund[3][i] = (newcars.get(i).get("oldcon"));// �Ѷ��ֳ�ÿ�·ſ�������ά����
					Ofund[4][i] = (newcars.get(i).get("oldmoney"));// �Ѷ��ֳ�ÿ�·ſ��ܽ������ά����

				}
				for (int i = newcars.size(); i < 12; i++) {
					Ofund[0][i] = "2018-";
					Ofund[1][i] = "0";
					Ofund[2][i] = "0";
					Ofund[3][i] = "0";
					Ofund[4][i] = "0";
				}
			} else {
				for (int i = 0; i < 12; i++) {
					Ofund[0][i] = (newcars.get(i).get("year1") + "-" + newcars
							.get(i).get("month1"));// �����ڸ�ʽ��������ά����xxxx-xx
					Ofund[1][i] = (newcars.get(i).get("newcon"));// ���³�ÿ�·ſ�������ά����
					Ofund[2][i] = (newcars.get(i).get("newmoney"));// ���³�ÿ�·ſ��ܽ������ά����
					Ofund[3][i] = (newcars.get(i).get("oldcon"));// �Ѷ��ֳ�ÿ�·ſ�������ά����
					Ofund[4][i] = (newcars.get(i).get("oldmoney"));// �Ѷ��ֳ�ÿ�·ſ��ܽ������ά����
				}
			}
			// System.out.println(Ochart);
			JSONArray jsonArray = JSONArray.fromObject(Ofund);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter();
			pw.print(jsonArray); // �켣ͼ������ȡ��������
			pw.flush();
			pw.close();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
	//������M1��M2��M3�ֲ�ͼajaxǰ̨��ȡ   
	@RequestMapping("erp/Management/getOverdueMap.do")
	@ResponseBody
	public String getOverdueMap(HttpServletRequest request,
			HttpServletResponse response,String yuqiname,String yuqicity){
		try {
			PageData pdLoginSession = (PageData) request.getSession().getAttribute("pd"); //
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id").toString()));
			//�ж����������
			if(!yuqiname.equals("�����������") && !yuqiname.equals("")) {
				gems=SelectGems(yuqiname);
				assess_fs.setGems_id(Integer.parseInt(gems));
			}else{
				assess_fs.setGems_id(-1);
			}
			//�ж�ѡ�����
	        if(!yuqicity.equals("0")){
	        	assess_fs.setCity_id(Integer.parseInt(yuqicity));
	        }else{
	        	assess_fs.setCity_id(0);
			}
	        assess_fs.setCar_type(0);
	        List<HashMap> chart = kj_icbcService.SelectOverdue(assess_fs);// ��̨��ȡ��ѯ����
	        assess_fs.setCar_type(1);
	        List<HashMap> chart1 = kj_icbcService.SelectOverdue(assess_fs);// ��̨��ȡ��ѯ����
	        assess_fs.setCar_type(2);
	        List<HashMap> chart2 = kj_icbcService.SelectOverdue(assess_fs);// ��̨��ȡ��ѯ����
	        
	        Object[][] object = new Object[3][6];	        
	        String []s={"m1a","m1m","m2a","m2m","m3a","m3m"};
	        for(int i=0;i<6;i++){
	            if(chart.get(0).get(s[i]) == "" && chart.get(0).get(s[i]).equals("")){
	                object[0][i]="0";
	            }else{
	                object[0][i]=chart.get(0).get(s[i]);
	            }
	            if(chart1.get(0).get(s[i]) == "" && chart1.get(0).get(s[i]).equals("")){
	                object[1][i]="0";
	            }else {
	                object[1][i] = chart1.get(0).get(s[i]);
	            }
	            if(chart2.get(0).get(s[i]) == "" && chart2.get(0).get(s[i]).equals("")){
	                object[2][i]="0";
	            }else{
	                object[2][i]=chart2.get(0).get(s[i]);
	            }
	        }
	        JSONArray jsonArray = JSONArray.fromObject(object);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw;
			pw = response.getWriter();
			pw.print(jsonArray); // �켣ͼ������ȡ��������
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		return null;
	}
	
	//����ʡ�ݷֲ�ͼajaxǰ̨��ȡ
	@RequestMapping("erp/Management/getStateMap.do")
	@ResponseBody
	public String getStateMap(HttpServletRequest request,
			HttpServletResponse response){
		try {
			PageData pdLoginSession = (PageData) request.getSession()
					.getAttribute("pd"); //
			assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id")
					.toString()));
			List<HashMap> chart = kj_icbcService.SelectStateFive(assess_fs);// ��̨��ȡ��ѯ����
			
			List<HashMap> chart1 = kj_icbcService.SelectStateOther(assess_fs);// ��̨��ȡ��ѯ����
			
			Object[][] object = new Object[6][3];
			if(chart.size()<5){
	            for(int i=0;i<chart.size();i++){
	                object[i][0]=chart.get(i).get("amount");
	                object[i][1]=chart.get(i).get("money");
	                object[i][2]=chart.get(i).get("cname");
	            }
	            for(int i=chart.size();i<5;i++){
	                object[i][0]="0";
	                object[i][1]="0";
	                object[i][2]="ĳĳʡ"+i;
	            }
	        }else{
	            for(int i=0;i<5;i++){
	                object[i][0]=chart.get(i).get("amount");
	                object[i][1]=chart.get(i).get("money");
	                
	                
	                object[i][2]=chart.get(i).get("cname");
	            }
	        }
	        if(chart.size()<6){
	        	object[5][0]="0";
	            object[5][1]="0";
	            object[5][2]="����ʡ";
	        }else{
	            object[5][0]=chart1.get(0).get("Oamount");
	            object[5][1]=chart1.get(0).get("Omoney");
	            object[5][2]="����ʡ";
	        }
	        JSONArray jsonArray = JSONArray.fromObject(object);
			response.setContentType("text/html;charset=UTF-8");
			response.setContentType("application/json");
			PrintWriter pw;
			
			pw = response.getWriter();
			pw.print(jsonArray); // �켣ͼ������ȡ��������
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	//�������ۺ�����ͼajaxǰ̨��ȡ
	@RequestMapping("erp/Management/getAgencyMap.do")
	@ResponseBody
	public String getAgencyMap(HttpServletRequest request,
			HttpServletResponse response,String dailiname,String dailitime){
			try{
				PageData pdLoginSession = (PageData) request.getSession()
						.getAttribute("pd"); //
				assess_fs.setId(Integer.parseInt(pdLoginSession.get("fs_id")
						.toString()));
				assess_fs.setUp_id(Integer.parseInt(pdLoginSession.get("fs_id")
						.toString()));
				List<HashMap> chart1 = kj_icbcService.SelectYwnl(assess_fs);// ��̨��ȡ��ѯ����
				List<HashMap> chart2 = kj_icbcService.SelectJjxl(assess_fs);// ��̨��ȡ��ѯ����
				List<HashMap> chart3 = kj_icbcService.SelectFknl(assess_fs);// ��̨��ȡ��ѯ����
				List<HashMap> chart4 = kj_icbcService.SelectYynl(assess_fs);// ��̨��ȡ��ѯ����
				List<HashMap> chart5 = kj_icbcService.SelectDhnl(assess_fs);// ��̨��ȡ��ѯ����
				if(!dailiname.equals("�����������") && !dailiname.equals("")) {
					gems=SelectGems(dailiname);
					assess_fs.setGems_id(Integer.parseInt(gems));
				}else{
					assess_fs.setGems_id(-1);
				}
		        //�ж��Ƿ�ѡ��ʱ��
		        if(!dailitime.equals("0")){
		        	assess_fs.setTimedate(Integer.parseInt(dailitime));
		        }else{
		        	assess_fs.setTimedate(0);
				}
		        Object[] obj = new Object[6];
		        obj[0] = chart1.get(0).get("years");
		        obj[1] = chart1.get(0).get("amount");
		        if(chart2.get(0).get("da").equals("")){
		            obj[2] = "0";
		        }else{
		            obj[2] = chart2.get(0).get("da");
		        }
		        obj[3] = chart3.get(0).get("amount");
		        obj[4] = chart4.get(0).get("amount");
		        obj[5] = chart5.get(0).get("amount");
		        JSONArray jsonArray = JSONArray.fromObject(obj);
				response.setContentType("text/html;charset=UTF-8");
				response.setContentType("application/json");
				PrintWriter pw;
				
				pw = response.getWriter();
				pw.print(jsonArray); // �켣ͼ������ȡ��������
				pw.flush();
				pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
