package com.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;  
  
public class sublistutil {  
      
    public static  void fenye(List list,int pagesize){  
          
          int totalcount=list.size();    
          int pagecount=0;    
          int m=totalcount%pagesize;    
          if  (m>0){    
           pagecount=totalcount/pagesize+1;    
          }else{    
           pagecount=totalcount/pagesize;    
          }    
             
          for(int i=1;i<=pagecount;i++){         
           if (m==0){    
               List<Integer> subList= list.subList((i-1)*pagesize,pagesize*(i));     
               System.out.println(subList+"-------"+i);       
            }else{    
                if (i==pagecount){    
                      List<Integer> subList= list.subList((i-1)*pagesize,totalcount);     
                      System.out.println(subList+"-------"+i);      
                }else{    
                      List<Integer> subList= list.subList((i-1)*pagesize,pagesize*(i));    
                      System.out.println(subList+"-------"+i);       
                }    
                
             
            }    
          }    
          
    }  
    
    public static List fy(List list,int pagesize,int nid){
    	List l=new ArrayList();
        int currIdx = (nid > 1 ? (nid -1) * pagesize : 0);
        for (int i = 0; i < pagesize && i < list.size() - currIdx; i++) {
            Object ij = list.get(currIdx + i);
            l.add(ij);
        }
       
		return l;
    	
    	
    }
    
     public static void main(String[] args) {    
              
          List<Map<String, String>> list=new ArrayList<Map<String, String>>();
          
        
          for(int i=1;i<52;i++){  
        	  Map r=new HashMap<>();
        	  r.put("i"+i, i);
             list.add(r);       
          }               
          fy(list,10,1);  
      
         }    
  
}  