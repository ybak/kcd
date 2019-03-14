package com.controller.erp_icbc.YunXin;
/**
 * @Description:TODO
 * @author:LiWang
 * @time:2018年8月22日
 */
public class YXConstant {	
	public static final String appKey="90392cd4130b36be523299cc9bbabee8";
	public static final String appSecret="6128a29483c4";
	//创建网易云通讯id
	public static final String CreateToken="https://api.netease.im/nimserver/user/create.action";
	//创建网易云移动端上传的用户
	public static final String CreateMobileUpload="https://vcloud.163.com/app/vod/thirdpart/user/create";
	//添加好友
	public static final String AddFriends="https://api.netease.im/nimserver/friend/add.action";
	//文件上传初始化
	public static final String InitUpload="https://vcloud.163.com/app/vod/upload/init";
	//获取上传加速节点地址
	public static final String Libs="http://wanproxy.127.net/lbs";
	//设置上传完成的回调地址
	public static final String SetCallBack="https://vcloud.163.com/app/vod/upload/setcallback";
	//刪除視頻原文件
	public static String deleteViedo="https://vcloud.163.com/app/vod/video/videoDelete";
}
