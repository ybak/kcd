package com.controller.erp_icbc.utils;
import java.beans.PropertyEditorSupport;
import org.springframework.web.util.HtmlUtils;
/**
 * String 类型的逃避编辑器
 * PropertyEditor是属性编辑器的接口，它规定了将外部设置值转换为内部JavaBean属性值的转换接口方法
 * @author Administrator
 * @author:LiWang
 * @time:2018年8月2日
 */
public class StringEscapeEditor extends PropertyEditorSupport {
    public StringEscapeEditor() {}

    /* 将属性对象用一个字符串表示，以便外部的属性编辑器能以可视化的方式显示。
     * 缺省返回null，表示该属性不能以字符串表示；
     * @see java.beans.PropertyEditorSupport#getAsText()
     */
    @Override
    public String getAsText() {
        Object value = getValue();//返回属性的当前值。基本类型被封装成对应的包装类实例
        return value != null ? value.toString() : "";
    }
    /* 用一个字符串去更新属性的内部值，这个字符串一般从外部属性编辑器传入
     * @see java.beans.PropertyEditorSupport#setAsText(java.lang.String)
     */
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null) {
            setValue(null);//设置属性的值，基本类型以包装类传入（自动装箱）
        } else {
        	/*Spring HtmlUtils把HTML编码转义，可将HTML标签互相转义
        	String s = HtmlUtils.htmlEscape("<div>hello world</div><p>&nbsp;</p>");  
        	转换后：&lt;div&gt;hello world&lt;/div&gt;&lt;p&gt;&amp;nbsp;&lt;/p&gt;  
        	String s2 = HtmlUtils.htmlUnescape(s);    
        	转换后：<div>hello world</div><p>&nbsp;</p> */ 
            setValue(HtmlUtils.htmlEscape(text));
        }
    }

}
