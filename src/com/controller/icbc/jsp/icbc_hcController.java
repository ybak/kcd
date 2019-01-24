package com.controller.icbc.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.icbc.icbc;
import com.service1.kjs_icbc.newicbcService;
import com.util.creditutil;

@Controller
public class icbc_hcController {

	@Autowired
	private newicbcService newicbcService;
	 //性能最高的方法
    public static String testStringBuilder(int sl) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<sl; i++) {
            sb.append(0);
        }
        return sb.toString();        
    }
	/*
	 * 客户换车操作
	 */
	@RequestMapping(value="kjs/khhc.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String khhc(int id){
		icbc icbc=newicbcService.findicbcbyid(id);
		if(icbc!=null&&!icbc.equals("")){
		icbc newicbc=new icbc();
		newicbc.setFromid(icbc.getId());
		newicbc.setMid_add(icbc.getMid_add());
		newicbc.setMid_edit(icbc.getMid_edit());
		newicbc.setDt_add(creditutil.time());
		newicbc.setDt_edit(creditutil.time());
		newicbc.setBc_status(icbc.getBc_status());
		newicbc.setGems_id(icbc.getGems_id());
		newicbc.setGems_fs_id(icbc.getGems_fs_id());
		icbc icbcmax=newicbcService.findlastid();
		int max=icbcmax.getId()+1;
		String string=icbc.getGems_code();
		//订单前缀
		String indexcode= string.substring(0,string.indexOf("0"));
		String gems_code=indexcode+testStringBuilder(7-String.valueOf(max).length())+max;
		newicbc.setGems_code(gems_code);
		newicbc.setQuery_type(icbc.getQuery_type());
		newicbc.setC_name(icbc.getC_name());
		newicbc.setC_tel(icbc.getC_tel());
		newicbc.setC_cardno(icbc.getC_cardno());
		newicbc.setBank_id(icbc.getBank_id());
		newicbc.setLoan_tpid(icbc.getLoan_tpid());
		newicbc.setLoan_level(icbc.getLoan_level());
		newicbc.setC_name_mt(icbc.getC_name_mt());
		newicbc.setC_tel_mt(icbc.getC_tel_mt());
		newicbc.setC_cardno_mt(icbc.getC_cardno_mt());
		newicbc.setKk_kpj(icbc.getKk_kpj());
		newicbc.setKk_loan_amount(icbc.getKk_loan_amount());
		newicbc.setKk_loan_amount_s(icbc.getKk_loan_amount_s());
		newicbc.setKk_loan_amount_total(icbc.getKk_loan_amount_total());
		newicbc.setKk_loan_ajms(icbc.getKk_loan_ajms());
		newicbc.setKk_loan_ajqx(icbc.getKk_loan_ajqx());
		newicbc.setKk_loan_ajyh(icbc.getKk_loan_ajyh());
		newicbc.setKk_loan_rate(icbc.getKk_loan_rate());
		newicbc.setKk_car_stateid(icbc.getKk_car_stateid());
		newicbc.setKk_car_cityid(icbc.getKk_car_cityid());
		newicbc.setKk_loan_stateid(icbc.getKk_loan_stateid());
		newicbc.setKk_loan_cityid(icbc.getKk_loan_cityid());
		newicbc.setImgstep2_1(icbc.getImgstep2_1());
		newicbc.setImgstep2_2(icbc.getImgstep2_2());
		newicbc.setImgstep2_3(icbc.getImgstep2_3());
		newicbc.setImgstep2_4(icbc.getImgstep2_4());
		newicbc.setImgstep2_5(icbc.getImgstep2_5());
		newicbc.setImgstep2_5s(icbc.getImgstep2_5s());
		newicbc.setC_sex(icbc.getC_sex());
		newicbc.setZx_result(icbc.getZx_result());
		newicbc.setDt_zxresult(icbc.getDt_zxresult());
		if(icbc.getDt_zxsub()!=null&&!icbc.getDt_zxsub().equals("")){
			newicbc.setDt_zxsub(icbc.getDt_zxsub());
		}else{
			newicbc.setDt_zxsub("0000-00-00 00:00:00");
		}
		newicbc.setZxok_tag(icbc.getZxok_tag());
		newicbc.setApi_add(icbc.getApi_add());
		newicbc.setApi_edit(icbc.getApi_edit());
		newicbc.setQuerytype(icbc.getQuerytype());
	    if(icbc.getDt_fin()!=null&&!icbc.getDt_fin().equals("")){
	    	newicbc.setDt_fin(icbc.getDt_fin());
	    }else{
	    	newicbc.setDt_fin("0000-00-00 00:00:00");
	    }	
		newicbc.setAdminop_tag(icbc.getAdminop_tag());
		newicbc.setDt_backtofin(icbc.getDt_backtofin());
		newicbc.setBook_status(icbc.getBook_status());
		newicbc.setCard_status(icbc.getCard_status());
		newicbc.setTr_status(icbc.getTr_status());
		newicbc.setTr_msg(icbc.getTr_msg());
		newicbc.setTr_tag(icbc.getTr_tag());
		newicbc.setDsj_result(icbc.getDsj_result());
		newicbc.setDsj_report_id(icbc.getDsj_report_id());
		if(icbc.getDsj_result_time()!=null&&!icbc.getDsj_result_time().equals("")){
			newicbc.setDsj_result_time(icbc.getDsj_result_time());	
		}else{
			newicbc.setDsj_result_time("0000-00-00 00:00:00");	
		}		
		newicbc.setC_name_gj1(icbc.getC_name_gj1());
		newicbc.setC_name_gj2(icbc.getC_name_gj2());
		newicbc.setC_tel_gj1(icbc.getC_tel_gj1());
		newicbc.setC_tel_gj2(icbc.getC_tel_gj2());
		newicbc.setC_cardno_gj1(icbc.getC_cardno_gj1());
		newicbc.setC_cardno_gj2(icbc.getC_cardno_gj2());
		if(icbc.getDt_sub()!=null&&!icbc.getDt_sub().equals("")){
			newicbc.setDt_sub(icbc.getDt_sub());
		}else{
			newicbc.setDt_sub("0000-00-00 00:00:00");
		}
		newicbc.setFk_status(icbc.getFk_status());
		newicbc.setGems_id_first(icbc.getGems_id_first());
		newicbc.setZjlx(icbc.getZjlx());
		newicbc.setImgstep8_1ss(icbc.getImgstep8_1ss());
		newicbcService.addicbc(newicbc);	
		return "true";
	}
		return "false";
	}
	
	public static void main(String[] args) {
		
		String string="ICBCLZJR0000459";
		System.out.println(string.substring(0,string.indexOf("0")));
	}
}
