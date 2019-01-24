package com.controller.erp_icbc.YunXin.bean;
import java.util.List;
/**
 * @Description:TODO
 * @author:LiWang 抄送实体类
 * @time:2018年8月22日
 */
public class InfoCopy {
	private Long timestamp;//登出事件发生的时间戳
	private String channelId;//	通道号
	private String createtime;//音视频通话/白板开始的时间, 可转为13位时间戳
	private String duration;//此通通话/白板的通话时长，精确到秒，可转为Integer类型
	private String eventType;//为5，表示是实时音视频/白板时长类型事件
	private List<Members> members;//表示通话/白板的参与者
	private String status;
	private String faccid;//接受者
	private String accid;//登出的账号 发起通话的账号
	private String live;
	/*视频通话状态 SUCCESS：表示正常挂断； 
	TIMEOUT：表示超时；
	SINGLE_PARTICIPATE：表示只有一个参与者；
	UNKNOWN：表示未知状态*/
	private String ext;//音视频发起时的自定义字段，可选，由用户指定
	private List<Fileinfo> fileinfo;
	private Fileinfo fi;//这个特殊用途
	private String type;
	public Long getTimestamp() {
		return timestamp;
	}
	public Fileinfo getFi() {
		return fi;
	}
	public void setFi(Fileinfo fi) {
		this.fi = fi;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getChannelId() {
		return channelId;
	}
	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public List<Members> getMembers() {
		return members;
	}
	public void setMembers(List<Members> members) {
		this.members = members;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getFaccid() {
		return faccid;
	}
	public void setFaccid(String faccid) {
		this.faccid = faccid;
	}
	public String getAccid() {
		return accid;
	}
	public void setAccid(String accid) {
		this.accid = accid;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}

	public List<Fileinfo> getFileinfo() {
		return fileinfo;
	}
	public void setFileinfo(List<Fileinfo> fileinfo) {
		this.fileinfo = fileinfo;
	}
	public String getLive() {
		return live;
	}
	public void setLive(String live) {
		this.live = live;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
