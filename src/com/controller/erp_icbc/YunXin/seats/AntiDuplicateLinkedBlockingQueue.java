package com.controller.erp_icbc.YunXin.seats;
import java.util.LinkedList;
import com.alibaba.fastjson.JSON;
/** 防止并发 防止重复 先进先出 
 * @Description:TODO
 * @author:LiWang
 * @time:2018年8月18日
 */
public class AntiDuplicateLinkedBlockingQueue{
    public final LinkedList<ScanPool1> list = new LinkedList();
    //添加
    public synchronized ScanPool1 offer(ScanPool1 scanpool) {
    	scanpool.setCreateTime(System.currentTimeMillis());//更新登陆开始时间
        if (list.contains(scanpool)) {//存在则直接返回
        	//System.out.println("更新后："+scanpool.getMark());
        	return scanpool;
        }
        if(list.offer(scanpool)){//不存在则添加到结尾 
        	//System.out.println("添加一个活跃的："+JSON.toJSONString(list));
        	  return scanpool;//添加成功 返回
        }
        return null;//添加失败 并且不存在
    }
    //获取最后一个 
    public synchronized ScanPool1 take() {
        return list.poll();
    }
    //删除一个
    public synchronized void delete(SP sp) {
    	//System.out.println("删除一个超时在线的"+sp.getMark());
    	boolean remove = list.remove(sp);
    }
    public void delete(int validtime){
    	for(ScanPool1 scanpool:this.list){
    		//System.out.println("当前时间："+System.currentTimeMillis()+" 活动开始"+scanpool.getCreateTime()+" 有效时间"+validtime);
			if(System.currentTimeMillis()-scanpool.getCreateTime()>validtime*1000){
				delete(scanpool);
			}
		}
    }
    /*更新活跃时间的情况，先读后修改时间，并发可能出现返回的索引不是真正的value，导致更新的为其他的; 所以更新的同时并发删除和增加，也许会导致索引偏移
	这里暂且不加同步方法 并发量大的时候会有影响
	*/
    public void refreshTime(String mark){
    	try {
    		SP sp=new SP();
        	sp.setMark(mark);
        	//如果在通話中將get不到
        	list.get(list.indexOf(sp)).setCreateTime(System.currentTimeMillis());//更新时间
        	//System.out.println("更新："+mark);
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}

