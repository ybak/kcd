package com.controller.erp_icbc.YunXin.bean;
/**
 * @Description:TODO
 * @author:LiWang 上传回调实体类
 * @time:2018年8月22日
 */
public class CallBack {
	private String address;//录制的地址
	private String viedotype;
	private String channelId;//自定义通道id
	private String id;
	private String type;//回调类型，上传回调固定为“upload”
	private Long vid;//视频文件标识
	private String name;//视频文件名称（上传时指定视频名称）
	private String origAddr;//视频的播放地址
	private String warnning;//视频类型检测结果，比如视频类型和上传指定不一致，mp4和flv类型的视频不适合流媒体播放拖动等
	private userDefined user_defined;//用户自定义字段值（上传时设置的值）
	public class userDefined{
		private String address;//地址
		private String latitude;//坐标
		private String longitude;
		private String id;//icbcid
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getLatitude() {
			return latitude;
		}
		public void setLatitude(String latitude) {
			this.latitude = latitude;
		}
		public String getLongitude() {
			return longitude;
		}
		public void setLongitude(String longitude) {
			this.longitude = longitude;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		
	}
	public String getViedotype() {
		return viedotype;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public void setViedotype(String viedotype) {
		this.viedotype = viedotype;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getVid() {
		return vid;
	}
	public void setVid(Long vid) {
		this.vid = vid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOrigAddr() {
		return origAddr;
	}
	public void setOrigAddr(String origAddr) {
		this.origAddr = origAddr;
	}
	public String getWarnning() {
		return warnning;
	}
	public void setWarnning(String warnning) {
		this.warnning = warnning;
	}
	public userDefined getUser_defined() {
		return user_defined;
	}
	public void setUser_defined(userDefined user_defined) {
		this.user_defined = user_defined;
	}
}
