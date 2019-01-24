package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.mapper.creditMapper;
import com.model.credit;
import com.util.Page;
@Service
//@Transactional
public class creditServiceImpl extends BaseMySqlService implements creditService{
	
	    @Resource
	    private creditMapper creditMapper;

		
//		public List<credit> findcredit() {
//			List<credit> clist=creditMapper.findcredit();
//			//System.out.println(clist.size()+"-----service");
//			return clist;
//		}


		@Override
		public void save(credit credit) {
			
			creditMapper.save(credit);
		}


		@Override
		public void upcredit(credit credit) {
			
			creditMapper.upcredit(credit);
		}


		@Override
		public void page(HttpServletRequest request, Model model) {
			String pageNow = request.getParameter("pageNow");

			Page page = null;
           
			List<credit> credit = new ArrayList<credit>();

			int totalCount =creditMapper.findcount();
            System.out.println(totalCount);
			if (pageNow != null) {
				page = new Page(totalCount, Integer.parseInt(pageNow),5);
				credit=this.creditMapper.findcredit(page.getStartPos(), page.getPageSize());
			} else {
				page = new Page(totalCount, 1,5);
				credit=this.creditMapper.findcredit(page.getStartPos(), page.getPageSize());
			}

			model.addAttribute("credit", credit);
			model.addAttribute("page", page);
		}


		@Override
		public List<credit> findcredit(int startPos, int pageSize) {
			
			return creditMapper.findcredit(startPos, pageSize);
		}


		@Override
		public int findcount() {
			
			return creditMapper.findcount();
		}


		@Override
		public void delcredit(int id) {
			
			creditMapper.delcredit(id);
		}


		@Override
		public Map findbysfz(String idcard) {
			
			return creditMapper.findbysfz(idcard);
		}


		@Override
		public credit findcreditbyname(String name, String IDcard_num, String phone_num) {
			
			return creditMapper.findcreditbyname(name, IDcard_num, phone_num);
		}


		@Override
		public void upsubmit(credit credit) {
			creditMapper.upsubmit(credit);
			
		}


		@Override
		public Map findcreditbyid(int id) {
			// TODO Auto-generated method stub
			return creditMapper.findcreditbyid(id);
		}


		@Override
		public List<credit> findover(List<?> list) {
			
			return creditMapper.findover(list);
		}


		@Override
		public void editzx(credit credit) {
			
			creditMapper.editzx(credit);
		}




		@Override
		public List<credit> findcredit1(int mdid, int startPos, int pageSize) {
		
			return creditMapper.findcredit1(mdid, startPos,pageSize);
		}



		@Override
		public int findcount1(int mdid) {
			
			return creditMapper.findcount1(mdid);
		}


		@Override
		public List<credit> dshtable(int startPos, int pageSize) {
			
			return creditMapper.dshtable(startPos,pageSize);
		}


		@Override
		public int dshcount() {
			
			return creditMapper.dshcount();
		}


		@Override
		public int countnum(String sum_bit) {
			
			return creditMapper.countnum(sum_bit);
		}


		@Override
		public List<credit> ztlist(String sum_bit, int startPos, int pageSize) {
			
			return creditMapper.ztlist(sum_bit, startPos, pageSize);
		}


		@Override
		public int htcount() {
			// TODO Auto-generated method stub
			return creditMapper.htcount();
		}


		@Override
		public List<credit> httable(int st, int ps) {
			// TODO Auto-generated method stub
			return creditMapper.httable(st, ps);
		}


		@Override
		public int ecount() {
			
			return creditMapper.ecount();
		}


		@Override
		public List<credit> etable(int st, int ps) {
		
			return creditMapper.etable(st, ps);
		}


		@Override
		public List<credit> search() {
			
			return creditMapper.search();
		}


		@Override
		public List<credit> findmdid(String mdid,String sum_bit) {
			
			return creditMapper.findmdid(mdid,sum_bit);
		}


		@Override
		public List<credit> zxbysum_bit(String sum_bit) {
			// TODO Auto-generated method stub
			return creditMapper.zxbysum_bit(sum_bit);
		}


		@Override
		public void hyimg(credit credit) {
			creditMapper.hyimg(credit);
			
		}


	    
	    
}
