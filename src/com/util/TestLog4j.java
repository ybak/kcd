package com.util;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public   class  TestLog4j  {
    public   static   void  main(String[] args)  {
       PropertyConfigurator.configure( "C:/Users/Administrator/Desktop/test" );
       Logger logger  =  Logger.getLogger(TestLog4j. class );
       logger.debug( " debug " );
       logger.error( " error " );
   }
} 
