package com.controller.erp_icbc.YunXin.seats;
public class SP {
	private String mark;//ฑ๊สถ
	@Override
	public boolean equals(Object obj) { 
      if(obj!=null && ((SP)obj).getMark().equals(this.mark)){
    	  return true;
      }
      return false;
    }
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
}
