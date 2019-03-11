package com.controller.erp_icbc.YunXin.bean;
/**
 * @Description:TODO
 * @author:LiWang 视频面签回调
 * @time:2018年8月22日
 */
public class Fileinfo {
	private boolean caller;//是否是此通通话的发起者，若是则为true，若不是则没有此字段，可转为Boolean值
	private String channelid;
	private String md5;//文件的md5值
	private String size;//文件的大小
	private String type;//文件的类型
	private String user;//用户帐号，若该文件为混合录制文件，则该字段为"0"
	private String filename;//文件名
	private String url;//文件的下载地址，请不要解析该字段
	private String vid;//点播文件id
	private String timestamp;//文件生成的系统时间
	private String pieceindex;//录制文件的切片索引，如果单通通话录制时长超过切片时长，则录制文件会被且被切割成多个文件
	private boolean mix=false;//是否为混合录制文件，true：混合录制文件；false：单人录制文件
	public boolean isCaller() {
		return caller;
	}
	
	public void setCaller(boolean caller) {
		this.caller = caller;
	}
	public String getChannelid() {
		return channelid;
	}
	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public String getPieceindex() {
		return pieceindex;
	}
	public void setPieceindex(String pieceindex) {
		this.pieceindex = pieceindex;
	}
	public boolean isMix() {
		return mix;
	}
	public void setMix(boolean mix) {
		this.mix = mix;
	}
}
