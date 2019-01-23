package com.util;

import java.util.ArrayList;
import java.util.List;

public class limitutil {

	
    public static List fy(List list,int pagesize,int nid){
    	System.out.println("·Öí“¹¦ÄÜ");
    	List l=new ArrayList();
        int currIdx = (nid > 1 ? (nid -1) * pagesize : 0);
        for (int i = 0; i < pagesize && i < list.size() - currIdx; i++) {
            Object ij = list.get(currIdx + i);
            l.add(ij);
        }
		return l;	
    }
    
    
    public static void main(String[] args) {
    	List list=new ArrayList<>();
    	for(int i=0;i<10;i++){
    		list.add(i);	
    	}
    	 fy(list,1,2);
    	
	}
}
