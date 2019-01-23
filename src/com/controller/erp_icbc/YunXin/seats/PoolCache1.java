package com.controller.erp_icbc.YunXin.seats;
/**
 * @Description:TODO
 * @author:LiWang
 * @time:2018年8月18日
 */
public class PoolCache1 {
	//装不同使用类型的坐席
	public static volatile Seats Seats; 
	//刷新间隔时间 
	private static Long cleanIntervalSecond =90L;//循环一次
	/**
	 初始化容器
	 */
	public static void initContainer(final Seats seats){
		Seats=seats;
		new Thread(new Runnable(){
			@Override
			public void run(){
				while (true){
					try{
						Thread.sleep(cleanIntervalSecond*1000);//1毫秒=0.001秒 
					} catch (InterruptedException e){
						e.printStackTrace();
					}
					seats.relieveOccupy();
				}
			}
		}).start();
	} 
}
