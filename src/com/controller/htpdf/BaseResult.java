package com.controller.htpdf;
//结果集工具类
public class BaseResult {
	private int code;// code为0失败 1为成功
	private String message;// 提示消息 压缩包已生成！
	private String loadf;
	private Object map;//失败信息 具体失败的合同 字段失败原因
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLoadf() {
		return loadf;
	}
	public void setLoadf(String loadf) {
		this.loadf = loadf;
	}
	public Object getMap() {
		return map;
	}
	public void setMap(Object map) {
		this.map = map;
	}
}
