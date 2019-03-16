package com.controller.erp_icbc.YunXin.seats;
/** 
 * 重写equals方法 用来根据mark更新或者删除ScanPool1(视频通话组对象)
 */
public class SP {
	String mark;//标识
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
	@Override
	public String toString() {
		return "SP [mark=" + mark + "]";
	}
}
