package com.controller.erp_icbc.YunXin.seats;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.controller.erp_icbc.YunXin.DataUtil;
/** 生产消费模式 先进先出
 * @author:LiWang
 * @time:2019
 */
public class PoolCache1 {
	 private static Logger log = LogManager.getLogger(PoolCache1.class);
	 //在线
	 public static HashMap<String,LinkedList> container=new HashMap<String,LinkedList>();
	 //忙碌
	 private static  Map<String,ScanPool1> busy=new HashMap<String, ScanPool1>();
	//刷新间隔时间 单位秒
	private static int cleanIntervalSecond =20000;//间隔刷新时间 默认90秒=90000
	public PoolCache1(){};
	static void initContainer(){
		new Thread(new Runnable(){
			@Override
			public void run(){
				while (true){
					try{
						Thread.sleep(cleanIntervalSecond);//1毫秒=0.001秒 
					} catch (InterruptedException e){ //如果任何线程中断了当前线程。当抛出该异常时，当前线程的中断状态 被清除
						e.printStackTrace();
					}
					timeoutDetection();
				}
			}
		}).start();
	} 
	public static ScanPool1 isMarkToBusy(String mark){
		log.info("忙碌的"+JSON.toJSONString(busy));
		return busy.get(mark);
	}
	public static ScanPool1 add(ScanPool1 scanPool){
		String key=scanPool.getBankId();
		LinkedList seats=container.get(key);
		Long createTime=System.currentTimeMillis();
		if(seats!=null){//判断是否有这个银行的坐席
			//返回此列表中首次出现的指定元素的索引，如果此列表中不包含该元素，则返回 -1。
	    	int index=seats.indexOf(scanPool);
	        if (index!=-1) {//存在
	        	//找到这个元素
	        	ScanPool1 scanPool2=(ScanPool1) seats.get(index);
	        	//占用的开始时间或者上一次登陆的时间
				String previousTime=DataUtil.millisecondTodate(scanPool2.getCreateTime());
				scanPool2.setPreviousTime(previousTime);
				//占用的结束时间 或者此次登陆的开始时间
				String laterTime=DataUtil.millisecondTodate(createTime);
				scanPool2.setLaterTime(laterTime);
	        	scanPool2.setCreateTime(createTime);
	        	log.info("更新一个视频组->"+scanPool2);
	        	return scanPool2;
	        }
		}else{
			seats=new LinkedList();
			container.put(key, seats);
		}
		//最后一次更新的时间
		String laterTime=DataUtil.millisecondTodate(createTime);
		scanPool.setLaterTime(laterTime);
		scanPool.setCreateTime(System.currentTimeMillis());//添加登陆开始时间
		//两者都是往队列尾部插入元素，不同的时候，当超出队列界限的时候，add（）方法是抛出异常让你处理，而offer（）方法是直接返回false
        if(!seats.offer(scanPool)){
        	scanPool=null;
        }
        log.info("插入一个视频组->"+scanPool);
		return scanPool;
	}
	
	public static Object deleteActive(ScanPool1 sp){
		LinkedList seats=container.get(sp.getBankId());
		boolean b=false;
		if(seats!=null){
			b=seats.remove(sp);//从此列表中移除首次出现的指定元素（如果存在）。如果列表不包含该元素，则不作更改。更确切地讲，移除具有满足 (o==null ? get(i)==null : o.equals(get(i))) 的最低索引 i 的元素（如果存在这样的元素）。如果此列表已包含指定元素（或者此列表由于调用而发生更改），则返回 true。 
			log.info("Web端收到Becall(活跃)，删除活跃结果->"+b);
		}
		HashMap map=new HashMap();
		map.put("active",b);
		map.put("SP", sp);
		return map;
	}
	
	public static Map outLogin(ScanPool1 sp){
		log.info("客户端退出start"+sp);
		LinkedList seats=container.get(sp.getBankId());
		boolean b=false;
		if(seats!=null){
			b=seats.remove(sp);//从此列表中移除首次出现的指定元素（如果存在）。如果列表不包含该元素，则不作更改。更确切地讲，移除具有满足 (o==null ? get(i)==null : o.equals(get(i))) 的最低索引 i 的元素（如果存在这样的元素）。如果此列表已包含指定元素（或者此列表由于调用而发生更改），则返回 true。 
			log.info("客户端退出end(活跃)，结果->"+b);
		}
		ScanPool1 scanPool1=busy.remove(sp.getMark());//与 key 关联的旧值；如果 key 没有任何映射关系，则返回 null。（返回 null 还可能表示该映射之前将 null 与 key 关联。）
		log.info("客户端退出end(忙碌)，结果->"+scanPool1);
		
		//返回给客户端的信息
		HashMap map=new HashMap();
		map.put("SP", sp.toString());
		//true为活跃退出
		map.put("active",b);
		//true为忙碌退出
		map.put("busy",scanPool1==null?false:true);
		return map;
	}
	//客户端刷新
	public static ScanPool1 refresh(String key,String mark){
		log.info("客户端刷新start");
		LinkedList seats=container.get(key);
		if(seats!=null){
			SP sp=new SP();
			sp.setMark(mark);
			int index=seats.indexOf(sp);
			if(index!=-1){
				ScanPool1 scanPool1=(ScanPool1) seats.get(index);
				//之前活跃开始的时间
				String previousTime=DataUtil.millisecondTodate(scanPool1.getCreateTime());
				
				Long createTime=System.currentTimeMillis();
				scanPool1.setCreateTime(createTime);
				
				//之后活跃开始的时间
				String laterTime=DataUtil.millisecondTodate(createTime);
				scanPool1.setPreviousTime(previousTime);
				scanPool1.setLaterTime(laterTime);
				
				log.info("客户端刷新end->"+scanPool1);
				return scanPool1;
			}
		}
		return null;
	}

	//删除在线的 增加忙碌的
	public static ScanPool1 aReduceBusy(String key){
		LinkedList seats=container.get(key);
		if(seats!=null){
			ScanPool1 scanPool1= (ScanPool1) seats.poll();// 获取并移除此列表的头（第一个元素）
			if(scanPool1!=null){
				//之前活跃开始的时间
				String previousTime=DataUtil.millisecondTodate(scanPool1.getCreateTime());
				Long createTime=System.currentTimeMillis();
				scanPool1.setCreateTime(createTime);//在线开始时间
				//之后忙碌开始的时间
				String laterTime=DataUtil.millisecondTodate(createTime);
				scanPool1.setPreviousTime(previousTime);
				scanPool1.setLaterTime(laterTime);
				
				busy.put(scanPool1.getMark(), scanPool1);//添加忙碌中的
				return scanPool1;
			}
		}
		return null;
	}
	public static ScanPool1 defaultSeat(){
		if(container.isEmpty()){
			return null;
		}else{
			for (Map.Entry entry : container.entrySet()) { 
				String key=(String) entry.getKey();
				ScanPool1 scanPool1=aReduceBusy(key);
				if(scanPool1!=null){
					return scanPool1;
				}
			}
			return null;
		}
	}
	public static ScanPool1 deleteBusy(String mark){
		ScanPool1 scanPool1=busy.remove(mark);//删除忙碌中的
		if(scanPool1!=null){
			//之前活跃开始的时间
			scanPool1=add(scanPool1);
			return scanPool1;
		}else{
			return null;
		}
	}
	public static void timeoutDetection(){
		for (Map.Entry entry : container.entrySet()) { 
			LinkedList seats=(LinkedList) entry.getValue();
			String key=(String) entry.getKey();
			int seatsSize=seats.size();
			 if(seatsSize>0){
				 for(int i=0;i<seatsSize;i++){
					 	ScanPool1 scanpool1=(ScanPool1) seats.get(i);
					 	if(System.currentTimeMillis()-scanpool1.getCreateTime()>scanpool1.getOnlinetime()){
							boolean b=seats.remove(scanpool1);
							//从此列表中移除首次出现的指定元素（如果存在）。如果列表不包含该元素，则不作更改。更确切地讲，移除具有满足 (o==null ? get(i)==null : o.equals(get(i))) 的最低索引 i 的元素（如果存在这样的元素）。
							//如果此列表已包含指定元素（或者此列表由于调用而发生更改），则返回 true。 
							log.info("超时管理:删除一个超时在线的(1)->"+scanpool1+",删除结果->"+b);
						}
				 }
			 }else{
				 log.info("清空此银行->"+key);
				 container.remove(key);
			 }
		}
		for(ScanPool1 scanpool1:busy.values()){
			if(System.currentTimeMillis()-scanpool1.getCreateTime()>scanpool1.getValidtime()){
				ScanPool1 remove1=busy.remove(scanpool1.getMark());//与 key 关联的旧值；如果 key 没有任何映射关系，则返回 null。（返回 null 还可能表示该映射之前将 null 与 key 关联。）		
				log.info("超时管理:删除一个忙碌的->"+scanpool1);
				//add(remove1);
			}
		}
	}
}
