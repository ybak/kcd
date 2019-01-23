package com.controller.erp_icbc;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
/**判断对象是否为null 或者 字符串字面值是否为空字符
 * @Description:TODO
 * @author:LiWang
 * @time:2018年7月28日
 */
public class EmptyUtil {
	 public static boolean isNull(Object obj) {
          return obj == null;
    }
  
    public static boolean isNotNull(Object obj) {
          return !isNull(obj);
    }
    /**
     * @param obj
     * @return
     * @Description: TODO
     * @param name
     * @return 
     */
    public static boolean isEmpty(Object obj) {
          if (obj == null) return true;
          else if(obj instanceof String) return obj.equals("") || obj.equals("null");
          else if (obj instanceof CharSequence) return ((CharSequence) obj).length() == 0;
          /*如果此 collection 不包含元素，则返回 true*/
          else if (obj instanceof Collection) return ((Collection) obj).isEmpty();
          else if (obj instanceof Map) return ((Map) obj).isEmpty();
          else if (obj.getClass().isArray()) return Array.getLength(obj) == 0;
          return false;
     }
     public static boolean isNotEmpty(Object obj) {
          return !isEmpty(obj);
    }
}
