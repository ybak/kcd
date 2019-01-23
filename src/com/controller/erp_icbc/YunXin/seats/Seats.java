package com.controller.erp_icbc.YunXin.seats;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/** 并发情况分析：
 *  客户端主动释放和服务器超时释放相同的accid  相同的ScanPool1向active中并发追加可怕，害怕添加重复
 *  客户端主动释放和服务器超时释放不相同的accid 并发添加害怕只添加了一个(极小概率)
	客户端登录，先判断是否存在，如果存在则刷新，不存在则创建，保存可怕，因为这个pool可能在忙碌状态 会导致重复添加SCanpooll 
	归根到底就是在线的不允许并发读，害怕读重复，也害怕并发写重复的，或者没有写上
 * @Description:TODO
 * @author:LiWang
 * @time:2018年8月18日
 */
public  class Seats {
	 //忙碌
	 public  Map<String, ScanPool1>  busy=new HashMap<String, ScanPool1>();
	 //在线  
	 public  AntiDuplicateLinkedBlockingQueue active=new AntiDuplicateLinkedBlockingQueue();
	 //最大的占用时间  最小为10分钟
	 private volatile int validtime;
	 //在线的有效时间
	 public static int onlinetime;
	 public Seats(int validtime,int online) throws Exception{
		 if(validtime<=0 || online<0){
			 throw new RuntimeException("有效时间必须大于0");
		 }
		 	this.validtime=validtime;
		 	this.onlinetime=online;
	 }
	 private Seats(){};
	 /*减少一个在线的  增加一个忙碌的 多个客户端争抢 或者系统超时争抢*/
	 public ScanPool1 aReduceBusy(){
		ScanPool1 ScanPool1 = active.take();//获取并移除此队列的头，如果此队列为空，则返回 null。。
		if(ScanPool1!=null){
			//System.out.println("减少一个在线的:"+JSON.toJSONString(ScanPool1));
			ScanPool1.setCreateTime(System.currentTimeMillis());
			busy.put(ScanPool1.getMark(),ScanPool1);//添加被占用的客户坐席
			return ScanPool1;
		}
		return null;
	 }
	 /*减少一个忙碌的 系统超时和和客户端调用接口*/
	 public ScanPool1 aAddActive(String mark){
		 	
			ScanPool1 ScanPool1 = busy.remove(mark);//与 key 关联的先前值;如果 key 没有映射关系，则返回 null 
			//System.out.println("减少一个忙碌的开始"+mark+","+JSON.toJSONString(ScanPool1));
			ScanPool1 offer=null;
			if(ScanPool1!=null){
				//System.out.println("减少一个忙碌的"+" "+JSON.toJSONString(ScanPool1));
				 offer = active.offer(ScanPool1);//将指定元素插入此队列的尾部。
			}
			return offer;
	 }
	 /*刷新在线的 客户端刷新 */
	 public  void refresh(String mark){
		  active.refreshTime(mark);//获得指定位置的索引
	 }
	 //退出
	 public  void outLogin(String mark){
		 SP sp=new SP();
		 sp.setMark(mark);
		 busy.remove(mark);//删除忙碌的
		 active.delete(sp);//删除活动的
	 }
	 //过期处理
	 public  void relieveOccupy(){
		//System.out.println("轮训检查");
		for(ScanPool1 scanpool:busy.values()){
			if(System.currentTimeMillis()-scanpool.getCreateTime()>this.validtime*1000){
				ScanPool1 remove = busy.remove(scanpool.getMark());//先删除忙碌的
				active.offer(remove);
				//System.out.println("忙碌超时："+JSON.toJSONString(remove));
			}
		}
		this.active.delete(onlinetime);
	 }
	 
	/* public static void main(String[] args) {
		 SP sp=new SP();
		 sp.setMark("123");
		 ScanPool1 sp1=new ScanPool1();
		 sp1.setMark("123");
		 Seats seats=new Seats();
		 seats.active.add(sp1);
		 //System.out.println(seats.active.indexOf(sp));
	}*/
}
