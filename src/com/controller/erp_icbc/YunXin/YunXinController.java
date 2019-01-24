package com.controller.erp_icbc.YunXin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.controller.erp_icbc.YunXin.seats.PoolCache1;
import com.controller.erp_icbc.YunXin.seats.SP;
import com.controller.erp_icbc.YunXin.seats.ScanPool1;
import com.controller.erp_icbc.YunXin.seats.Seats;
import com.controller.erp_icbc.base.BaseController;
import com.controller.erp_icbc.result.Result;
import com.controller.erp_icbc.utils.EmptyUtil;
import com.controller.erp_icbc.utils.PageInfo;
import com.model1.icbc.erp.PageData;
import com.service1.erp_icbc.YXService;
import com.util.creditutil;
import com.util.duoying.MD5;
/**
 * @Description:TODO
 * @author:LiWang
 * @time:2018年8月22日
 */
@Controller
@RequestMapping("yx/")
public class YunXinController extends BaseController{
	public YunXinController(){
		super();
	};
	@Autowired
	private YXService yx;
	/**
	 * @param icbcid 征信id 用来判大状态是否存在 和查询用户的评估信息和征信信息
	 * @param through 通过或者不通过
	 */
	@RequestMapping(value="sutitstatus.do")
	@ResponseBody
	public void auditStatus(String icbcid,String auditstatus,String channel,HttpServletRequest request){
		Map map=autioMonth(icbcid,auditstatus,channel,request);
		//System.out.println("更新一条视频信息"+JSON.toJSONString(map));
		/*关联一下此result操作和面签信息*/
		yx.update_infocopy_viedo_vid(map);
		//如果审批通过  25的小状态
		if(auditstatus.equals("1")){
			//则添加一个完成的小状态
			map.put("status",25);
			map.put("remark","完成");
			map.put("resultmsg","完成");
			//System.out.println("添加一个完成的状态"+JSON.toJSONString(map));
			yx.insert_kjicbcresult(map);//添加一个完成的小状态
		}
	}
	/**	提取公共部分
	 * @param icbcid 审核的id
	 * auditstatus   通过或者不通过 0代表通过 代表不通过
	 * @param request 用来获
	 */
	public Map  autioMonth(String icbcid,String auditstatus,String channel,HttpServletRequest request){
		String parentid = yx.select_kjicbc_byid("6",icbcid);//查询对应的视频面签大状态是否存在
		Map map=new HashMap<>();
		map.put("channel", channel);
		//通用的直接赋值吧
		map.put("addadmin","121");//pdsession.get("id").toString();//获得当前登录用户的主键
		map.put("editadmin","121");//修改人
		map.put("addtime",creditutil.time());//新建时间
		map.put("editime",creditutil.time());//最后编辑时间
		map.put("sub",creditutil.time());//提交时间
		map.put("icbcid",icbcid);
		map.put("typeid", 6);
		if(auditstatus.equals("1")){//如果审核通过
			yx.updata_mq_status("3",icbcid);//更新免签表状态 3代表审核通过
			map.put("status","25");//25代表完成
			map.put("resultmsg","面签通过");
		}else if(auditstatus.equals("3")){//回退
			yx.updata_mq_status("4",icbcid);//免签不通过
			map.put("status","24");
			map.put("resultmsg","面签不通过");
		}
		if(parentid==null){//不存在大状态  则添加
			//查询信息
			Map icbc = yx.select_icbc_byid(icbcid);
			Map car = yx.select_car_byid(icbcid);
			map.put("c_name", icbc.get("c_name").toString());//姓名
			map.put("gems_id", icbc.get("gems_id").toString());//业务员
			map.put("gems_fs_id",icbc.get("gems_fs_id").toString());//机构
			map.put("c_cardno", icbc.get("c_cardno").toString());//机构
			map.put("vincode",car.get("vincode").toString());//vin码
			map.put("code", car.get("code").toString());//车牌
			//添加一个大状态
			//System.out.println("添加一个大状态"+JSON.toJSONString(map));
			yx.insert_kjicbc(map);
			map.put("parentid",map.get("id"));//重新设置一下result的父级的id
		}else{
			//更新一下大状态 
			//System.out.println("更新一个大状态"+JSON.toJSONString(map));
			yx.update_kjicbc(map);//根据icbcId 和 typeid 主要修改一下最新的狀態 和最後更新時間 和 最後操作的人
			map.put("parentid",parentid);//重新设置一下result的父级的id
		}	
		//保存一个24小状态 结果反馈
		//System.out.println("大状态id"+ map.get("parentid").toString());
		map.put("status",24);
		map.put("remark","结果反馈");
		map.put("resultcode",auditstatus);//1通过 3回退
		//System.out.println("添加一个小状态"+JSON.toJSONString(map));
		yx.insert_kjicbcresult(map);//添加一个小状态
		return map;
	}
	/**一系列的信息 如果视频面签后没有点击通过或者不通过 那么这里面的逻辑就不会执行 审核的逻辑放在查看历史订单中的 切记！！！
	 * @param auditstatus 审核状态
	 * @param customvalue icbc_id address等
	 * @param chanelid 通道id
	 * @param request 
	 * @Description: TODO
	 * @param name
	 * @return 
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(value="viedoAudit.do")
	@ResponseBody
	public void viedoAudit(String auditstatus, String customvalue,String channel,HttpServletRequest request) throws UnsupportedEncodingException{
		//System.out.println("请求参数:"+auditstatus+customvalue+" "+channel);
		JSONObject custom = JSONObject.parseObject(customvalue);
		String icbcid=custom.getString("id");
		Map map=autioMonth(icbcid,auditstatus,channel,request);
		//对小视频的操作
		map.put("address", custom.getString("address"));
		if(yx.select_infocopy(channel)!=null){//面签表
			//更新
			//System.out.println("更新一条视频信息"+JSON.toJSONString(map));
			yx.update_infocopy_viedo(map);
		}else{
			//添加
			//System.out.println("添加一条视频信息"+JSON.toJSONString(map));
			yx.insert_infocopy_viedo(map);
		}
		
		//如果审批通过  25的小状态
		if(auditstatus.equals("1")){
			//则添加一个完成的小状态
			map.put("status",25);
			map.put("remark","完成");
			map.put("resultmsg","完成");
			//System.out.println("添加一个完成的状态"+JSON.toJSONString(map));
			yx.insert_kjicbcresult(map);//添加一个完成的小状态
		}
	}
		//分页查询历史
		@RequestMapping(value="selectOperatingFalse.do")
		@ResponseBody
		public PageInfo selectOperatingFalse(Integer pagesize,
				Integer pageIndex,
				String name,
				String idNumber,
				String organization, //机构的主键
				String viedostartsvalue,//审核状态 1已审核 2未审核
				String viedotype,//视频类型 1视频面签 2视频录制
				String contract,//签约状态 1成功 3回退
				HttpServletRequest request) throws UnsupportedEncodingException{ //签约状态
			request.setCharacterEncoding("utf-8");
			String  s = new String(request.getParameter("name").getBytes("ISO-8859-1"),"utf-8");
			//System.out.println("姓名"+s);
			//System.out.println(pagesize+"，页码："+pageIndex);
			//System.out.println("姓名:"+name+",身份："+idNumber+",机构："+organization+",视频的类型："+viedotype+",状态："+contract+",审核状态："+viedostartsvalue);
			Map map=new HashMap();
			//查询条件
			if(!EmptyUtil.isEmpty(idNumber) ){//身份证
				map.put("idNumber", "%"+idNumber+"%");
			}
			map.put("viedostartsvalue",viedostartsvalue);
			map.put("organization",organization);//机构
			map.put("contract", contract);
			if(!EmptyUtil.isEmpty(name)){//姓名
				map.put("name", "%"+s+"%");
			}
			map.put("viedotype",viedotype);
			
			PageInfo pageinfo=new PageInfo(pageIndex,pagesize);
			if(map.size()>0){
				pageinfo.setCondition(map);
			}		
			pageinfo.setRows(yx.select_operating(pageinfo));//数据
			pageinfo.setTotal(yx.select_operating_count(pageinfo));//总条数
			//System.out.println(JSON.toJSONString(pageinfo));
			return pageinfo;
		}

	/*来电用户的信息*/
	@RequestMapping(value="viedoinfo.do")
	@ResponseBody
	public Map selectViedobyid(String id,String domvalue){
		System.out.println(id+"  "+domvalue);
		Map map=null;
		List select_mq_info=null;
		String icbcid="-1";
		if(domvalue.equals("A")){//视频对话 id为icbc_id
			 map= yx.select_viedo_byid(id);
			 icbcid=id;
		}else if(domvalue.equals("B")){
			 map=(Map) yx.select_viedo_byid2(id).get(0);
			 icbcid=map.get("icbcid").toString();
		}
		select_mq_info = yx.select_mq_info(icbcid);//改  多个面签只取第一个
		if(select_mq_info.size()>0){
			 map.putAll((Map)select_mq_info.get(0));//添加到集合中
		 }
		System.out.println("结果:"+JSON.toJSONString(map));
		return map;
	}
	/**上传成功的回调地址
	 * @param callback
	 * @Description: TODO
	 * @param name
	 * 请求示例:
	 * $.ajax({
	        type: "POST",
	        url: "${pageContext.request.contextPath}/yx/callback.do",
	        dataType: "json",
	        data:{name:'snow.mp4',origAddr:'http://vodk32ywxdf.vod.126.net/vodk32ywxdf/b3d259f4-a7bc-4119-ae24-60e0eb09216e.mp4',type:'upload',vid:1022,user_defined:'userId=123456'},
	        success: function(date){	
	        }	
	      });
	 */
	@RequestMapping(value="callback.do")
	@ResponseBody
	public void callBack(HttpServletRequest request){
			String body="";
			try {
				body = readBody(request);
				StringBuilder redundant=new StringBuilder(body.replaceAll("(\\})|(\\{)|(\\[)|(\\])|(\")", ""));//抄送的完整信息
	    		//字符串处理
	    		body=body.replaceAll("\\\\", "").replaceAll("\"\\{","{").replaceAll("\\}\"","}").replaceAll("\"\\[\\{", "[{").replaceAll("\\}\\]\"", "}]");
	    		JSONObject map = JSONObject.parseObject(body);
				//自定义通道id 这里与前端的操作关联使用通道id 也可以使用书主键id
	    		map.put("channelid",MD5.sign(UUID.randomUUID().toString().replace("-", "").toLowerCase(),"utf-8"));
	    		map.put("viedotype", 0);
	    		map.put("te", redundant.toString());
				yx.addcallback(map);
			} catch (Exception e) {
				//yx.insert_M(body);//如果错误直接保存
			}
	}
	@RequestMapping(value="selectvideo.do")
	@ResponseBody
	public Result selectvideo(){
		return renderSuccess(yx.select_YX_video());
	}

	//设置上传成功后的回调地址 {"ret":{},"requestId":"vodc59a1e37-9654-4314-89fb-406b5661086f","code":200}
	public static String setCallBack(){
		Map map=new HashMap(2);
		map.put("callbackUrl","http://apitest.kcway.net/kcd/yx/callback.do");
		map.put("signKey","kjs9999");
		return HttpYX.doPost(YXConstant.SetCallBack,map);
	}
	/**用于文件上传的初始化，获取xNosToken（上传凭证）、bucket（存储对象的桶名）、object（生成的唯一对象名）。
	 * @param originFileName 上传文件的原始名称（包含后缀名）
	 * @param userFileName 用户命名的上传文件名称
	 * @param typeId 视频所属的类别Id（不填写为默认分类）
	 * @param presetId 视频所需转码模板Id（不填写为默认模板，默认模板不进行转码）
	 * @param uploadCallbackUrl 上传成功后回调客户端的URL地址（需标准http格式）
	 * @param callbackUrl 转码成功后回调客户端的URL地址（需标准http格式）
	 * @param description 上传视频的描述信息
	 * @param watermarkId 视频水印Id（不填写为不添加水印，如果选择，请务必在水印管理中提前完成水印图片的上传和参数的配置；且必需设置prestId字段，且presetId字段不为默认模板）
	 * @param userDefInfo 用户自定义信息，回调会返回此信息（长度不能超过256字符）
	 * @param transOffset 视频转码处理裁剪视频的起始位置（单位：秒）
	 * @param transDuration 视频转码处理裁剪视频的视频时长（单位：秒）
	 	示例：
	  	sbucket": "jdvod6ep5thqk",
        "xNosToken": "UPLOAD ab1856bb39044591939d7b94e1b8e5ee:Lvz8pD5w0VFDnr6DfS4DdUEh/Pjr6QlUbB5fp7SgOV8=:eyJCdWNrZXQiOiJqZHZvZDZlcDV0aHFrIiwiT2JqZWN0IjoiNjM0MzA2ZjctYWE4Mi00ZmE2LWFjM2QtOTZlMDcyNWUyZjBhLm1wNCIsIkV4cGlyZXMiOjE1NjU0OTM5MjgsIkNhbGxiYWNrVXJsIjoiaHR0cDovL3ZjbG91ZC4xNjMuY29tL3hoci92b2Qvbm9zL2NhbGxiYWNrIiwiQ2FsbGJhY2tCb2R5IjoiZmlsZU5hbWU9dGVzdC5tcDQmb2JqZWN0TmFtZT02MzQzMDZmNy1hYTgyLTRmYTYtYWMzZC05NmUwNzI1ZTJmMGEubXA0JiQoT2JqZWN0U2l6ZSkmdWlkPTEwMjMxMDAwOCZ0eXBlSWQ9MTA0MjY3NDY0JnByZXNldElkPTEwNDI4MjQyNCZ3YXRlcm1hcmtJZHM9MTAyMzY2NDQxJmRlc2NyaXB0aW9uPW51bGwmdHJhbnNjb2RlQ2FsbGJhY2s9bnVsbCYkKEFWaW5mby5WaWRlby5EdXJhdGlvbikmJChBVmluZm8uVmlkZW8uSGVpZ2h0KSYkKEFWaW5mby5WaWRlby5XaWR0aCkmMCYwJjAmbnVsbCZ1cGxvYWRTdGFydD0xNTMzOTU3OTI4MzQzJnVwbG9hZENhbGxiYWNrPW51bGwmbnVsbCZtcDQmMCYwJnRyYW5zT2Zmc2V0PW51bGwmdHJhbnNEdXJhdGlvbj1udWxsJmFwcGtleT05MDM5MmNkNDEzMGIzNmJlNTIzMjk5Y2M5YmJhYmVlOCIsIlJlZ2lvbiI6IkpEIn0=",
        "object": "634306f7-aa82-4fa6-ac3d-96e0725e2f0a.mp4"
	 * @Description: TODO
	 * @param name
	 * @return 
	 */
	@RequestMapping(value="UploadInit.do")
	@ResponseBody
	public Result getUploadInit(
			String originFileName,
			String userFileName,
			Integer typeId,
			Integer presetId,
			String uploadCallbackUrl,
			String callbackUrl,
			String description,
			Integer watermarkId,
			String userDefInfo,
			Integer transOffset,
			Integer transDuration){
			if(!EmptyUtil.isEmpty(originFileName)){
				JSONObject jsonobject=new JSONObject();
				jsonobject.put("originFileName", originFileName);
				jsonobject.put("userFileName", userFileName);
				jsonobject.put("typeId", typeId);
				jsonobject.put("presetId", presetId);
				jsonobject.put("uploadCallbackUrl", uploadCallbackUrl);
				jsonobject.put("callbackUrl", callbackUrl);
				jsonobject.put("description", description);
				jsonobject.put("watermarkId", watermarkId);
				jsonobject.put("userDefInfo", userDefInfo);
				jsonobject.put("transOffset", transOffset);
				jsonobject.put("transDuration", transDuration);
				return tokenDispose(HttpYX.doPost(YXConstant.InitUpload,jsonobject.toJSONString()),"1");
			}else{
				return renderError("请输入上传文件的原始名称(包含后缀名)!");
			}
	}
	/**根据传入的accid创建网易云通信ID 如果没有传入accid则由系统创建一个32位的accid
	 * @param accid 自定义accid
	 * @param employcode 使用类型 0 代表审核 1代表客户 2代表上传
	 * @param cfcode 分类名称 
	 */
	@RequestMapping(value="ct.do")
	@ResponseBody
	public Object createAccount(String accid,String employcode){
		if(EmptyUtil.isEmpty(accid)){
			accid=MD5.sign(UUID.randomUUID().toString().replace("-", "").toLowerCase(),"utf-8");
		}
		if(EmptyUtil.isEmpty(employcode) || (!employcode.equals("0") && !employcode.equals("1") && !employcode.equals("2"))){
			return renderError("请输入正确的类型!");
		}else{
			Result result=null;
			if(employcode.equals("2")){//移动上传sdk
				//System.out.println("获取移动上传");
				result=tokenDispose(HttpYX.geMobileUpload(accid),"1");
			}else{//云信视频token
				//System.out.println("获取云信token");
				result=tokenDispose(HttpYX.getToken(accid),"0");
			}
			if(result.isSuccess()){//请求成功！
				Map map=((Map) result.getData());
				map.put("employcode",employcode);//设置类型
				int i=yx.add_YX_account(map);//保存 
				if(i>0){//保存成功
					/*
					//添加好友代码 视频面前不需要添加好友
					List list=null;
					if(employcode.equals("0")){//添加的为审核
						list=yx.query_token("1",-1);//那么查询所有的客户
					}else if(employcode.equals("1")){//添加的为客户
						list=yx.query_token("0", -1);//那么查询所有的审核
					}else{
						return result;
					}
					StringBuffer sb=new StringBuffer();
					//开始直接添加好友
					String s=null;
					String s1=map.get("accid").toString();;
					String s2=null;
					//循环添加好友 
					for(int j=0;j<list.size();j++){
						s=((Map)list.get(j)).get("accid").toString();//发起者
						s2=HttpYX.addBuddy(s,s1);
						if(s2.indexOf("200")==-1){
							sb.append(s1).append("添加：").append(s).append("失败！");
						}
					}
					result.setMessage(sb.toString());*/
					return result;
				}else{
					return renderError("保存失败:"+JSON.toJSONString(result.getData()));//保存失败返回accid、token
				}
			}
			return result;//请求失败 或者保存失败
		}
	}
	/** 解析 创建网易云通信ID 返回结果 
	 * @param s 接口中返回的字符串
	 */
	public  Result tokenDispose(String s,String type){
		if(s!=null){//如果不存在
			////System.out.println("接口返回结果："+s);
			JSONObject jo = JSONObject.parseObject(s);//先创建
			if(jo.getInteger("code")==200){//请求成功
				Map map =null;
				if(type.equals("0")){
					map=jo.getJSONObject("info");
				}else if(type.equals("1")){
					map=jo.getJSONObject("ret");
				}
				return renderSuccess(map);
			}else{//请求失败 
				return renderError(jo.getString("code")+"!");//这里失败的状态码可以 用来确定网易 http://dev.netease.im/docs/product/%E9%80%9A%E7%94%A8/%E7%8A%B6%E6%80%81%E7%A0%81
			}		
		}
		return renderError("请求接口失败！");
	}
	
	/**直接添加好友
	 * @param accid  加好友发起者accid
	 * @param faccid 加好友接收者accid
	 * http://localhost/kcd/yx/Buddy.do?accid=75dd5d18ee7c102b4aa3ff5c12a5936a&faccid=4a21effaf6827d9a312e628a929f6525
	 */
/*	@RequestMapping(value="Buddy.do")
	@ResponseBody
	public Object addBuddy(String accid,String faccid){
		Result result=new Result();
		if(EmptyUtil.isEmpty(accid) || EmptyUtil.isEmpty(faccid)){
			return renderError("请输入正确的发起者和接受者！");
		}else{
			String s=HttpYX.addBuddy(accid,faccid);
			if(s!=null){
				if(s.indexOf("200")!=-1){//表示成功
					return renderSuccess();
				}else{
					return renderError("添加失败！");
				}
			}else{
				return renderError("请求接口失败！");
			}
		}
	}*/
	/**
	 *占位 
	 *http://localhost/kcd/yx/gcr.do
	 */
	@RequestMapping(value="occupy.do")
	@ResponseBody
	public Object occupy(){
		ScanPool1 scanpool = ((Seats)PoolCache1.Seats).aReduceBusy();
		if(scanpool!=null){
			return renderSuccess(scanpool);
		}else{
			return renderError("暂且没有闲置的视频通话坐席,请稍后再试！");
		}
	}
	/**
	 *释放
	 */
	@RequestMapping(value="free.do")
	@ResponseBody
	public Object freeToken(String mark){
		if(!EmptyUtil.isEmpty(mark)){
			ScanPool1 aAddActive = ((Seats)PoolCache1.Seats).aAddActive(mark);
			if(aAddActive!=null){
				return renderSuccess(aAddActive);
			}
		}
		 return renderError("释放失败!不存在此mark！");
	}
	@RequestMapping(value="refreshtime.do")
	@ResponseBody
	public void  refreshTime(String mark){
		((Seats)PoolCache1.Seats).active.refreshTime(mark);
	}
	/**
		登陆 成功并返回云信ID
	 */
	@RequestMapping(value="login.do")
	@ResponseBody
	public ScanPool1 toLogin(HttpServletRequest request){
		//System.out.println("登陆");
		PageData pdsession= (PageData)request.getSession().getAttribute("pd");//获取session信息
		String id=pdsession.get("id").toString();
		if(!EmptyUtil.isEmpty(id)){//存在
			List list = yx.query_tokenbyid(id);
			if(list.size()>0){	
				ScanPool1 scanpool=(ScanPool1)list.get(0);
				ScanPool1 offer = ((Seats)PoolCache1.Seats).active.offer(scanpool);
				return offer;
			}
		}
		return null;
	}
	/*退出操作*/
	@RequestMapping(value="outlogin.do")
	@ResponseBody
	public  void outLogin(String mark){
		//System.out.println("退出"+mark);
		SP sp=new SP();
		sp.setMark(mark);
		((Seats)PoolCache1.Seats).busy.remove(mark);
		((Seats)PoolCache1.Seats).active.delete(sp);//直接删除
	}	

	/**
	 *获取随机一个上传accid
	 */
	@RequestMapping(value="sur.do")
	@ResponseBody
	public Object setUploadReduce(){
		List list = yx.query_token("2",-1);
		Random random = new Random();
		int n = random.nextInt(list.size());
		return renderSuccess(list.get(n));
	}
	/**
	 * @param infocopy  信息抄送 自定义消息
	 */
	@RequestMapping(value="infocopy.do")
	@ResponseBody
	public JSONObject infoCopy(HttpServletRequest request)
            throws Exception {
        JSONObject result = new JSONObject();
        try {
            // 获取请求体
            String body = readBody(request);
            body=body.replaceAll("\\\\", "");
            if (EmptyUtil.isEmpty(body)) {//如果为null 或者空字符
                result.put("code", 414);
                return result;
            }else{
            	try {
            		StringBuilder redundant=new StringBuilder(body.replaceAll("(\\})|(\\{)|(\\[)|(\\])", ""));//抄送的完整信息
            		//字符串处理
            		body=body.replaceAll("\"\\{","{").replaceAll("\\}\"","}").replaceAll("\"\\[\\{", "[{").replaceAll("\\}\\]\"", "}]");
            		//System.out.println(body);
            		JSONObject map = JSONObject.parseObject(body);
            		map.put("viedotype", "1");//设置视频的类型
            		String eventType = map.get("eventType").toString();
            			String channeid =null;
            			if(eventType.equals("5")){//音视频/白板时长消息抄送
            				 channeid = yx.select_infocopy(map.get("channelId").toString());//获取通道id
            				 //JSONArray members  =JSONArray.parseArray(map.getString("members").toString().replaceAll("(^\"*)|(\"*$)","")); //获得字符串 去掉收尾的"号 再转换为jsonarray
            				 JSONArray members=map.getJSONArray("members");
            				map.put("duration_time",redundant.toString());//完整的通话时长抄送
            				 for(int i=0;i<members.size();i++){//确定出发起者和接收者
            					JSONObject members2=members.getJSONObject(i);
            					//如果是通话的发起者的话，caller字段为true,否则无caller字段;         
            					if(members2.toString().indexOf("caller")==-1){//接收者 
            						map.put("faccid", members2.getString("accid"));//接受者
            						if(channeid!=null){//存在根据channeid更新 
                    					//System.out.println("更新");
                    					 yx.update_infocopy_durationM(map);
                    				 }else{//不存在则添加
                    					 //System.out.println("保存");
                    					 System.out.println(JSON.toJSONString(map));
                    					 yx.insert_infocopy_durationM(map);
                    				 }
            					}
            					//不过不是接收者 则丢掉这条 
            				 }	
            			}else if(eventType.equals("6")){//音视频/白板文件下载信息抄送：
            					JSONArray fileinfo = map.getJSONArray("fileinfo");
            					 String url="";
            					map.put("download_info", redundant.toString());
            					for(int j=0;j<fileinfo.size();j++){
            						JSONObject fileinfo2 = fileinfo.getJSONObject(j);
            						//System.out.println("数据："+JSON.toJSONString(fileinfo2));
            						boolean b=fileinfo2.getBooleanValue("mix");
            						url=fileinfo2.getString("url");
            						if(b && url.indexOf("mp4")!=-1){//mix：是否为混合录制文件，true：混合录制文件；false：单人录制文件 并且为mp4格式
            							channeid = yx.select_infocopy(fileinfo2.getString("channelid"));//判断是否存在通道id
            							map.put("fi", fileinfo2);//这里解决同一次抄送，可能会抄给你不同channel ID 的信息的	
            							 if(channeid!=null){//存在 修改
            								 //System.out.println("更新");
            								 yx.update_infocopy_downloadM(map);
            							 }else{//不存在则添加
            								 //System.out.println("保存");
            								 //System.out.println("哈哈:"+JSON.toJSONString(map));
            								 yx.insert_infocopy_downloadM(map);
            							 }
            						}
            					}
            				}
            		
				} catch (Exception e) {
					yx.insert_M(body);//如果错误直接保存
				}
            }
            // TODO: 比较md5、checkSum是否一致，以及后续业务处理
            result.put("code", 200);
            return result;
        } catch (Exception ex) {
            result.put("code",414);
            return result;
        }
    }
    private String readBody(HttpServletRequest request) throws UnsupportedEncodingException, IOException {
        if (request.getContentLength() > 0) {
        	BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
			StringBuffer sb = new StringBuffer("");
			String temp;
			//循环读取
			while ((temp = br.readLine()) != null) { 
			  sb.append(temp);
			}
			br.close();
            return  sb.toString();
        } else
            return null;
    }
	public static void main(String[] args){
		//信息时长抄送测试
/*		InfoCopy infocopy=new InfoCopy();
		infocopy.setChannelId("62654898432013131");
		infocopy.setCreatetime(System.currentTimeMillis()+"");
		infocopy.setDuration(25+"");
		infocopy.setEventType(5+"");
		infocopy.setStatus("SUCCESS");
		infocopy.setExt("123");
		Members members=new Members();
		members.setAccid("2");
		members.setCaller(true);
		Members members1=new Members();
		members1.setAccid("3");
		List<Members> list=new ArrayList<>();
		list.add(members1);
		list.add(members);	
		infocopy.setMembers(list);
		
		//System.out.println(JSON.toJSONString(infocopy));

		
		//System.out.println(HttpYX.doPost("http://localhost:80/yx/infocopy.do",JSON.toJSONString(infocopy)));*/
		
		
		//删除好友 开始
	/*	List list = yx.query_token("1",-1);
		String s;
		String s1 = "";
		String s2;//接收返回结果
		StringBuilder sb=new StringBuilder();*/
		//循环删除好友 
	/*	int i=0;
		for(int j=0;j<list.size();j++){
			s=((Map)list.get(j)).get("accid").toString();//发起者
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			nvps.add(new BasicNameValuePair("accid",s));
			nvps.add(new BasicNameValuePair("faccid",s1));
			s2=HttpYX.doPost("https://api.netease.im/nimserver/friend/delete.action",nvps);
			if(s2.indexOf("200")==-1){
				sb.append(s1).append("删除：").append(s).append("失败！");
				i++;
			}
		}
		//System.out.println("总的好友数:"+list.size()+",失败个数："+i+" "+sb.toString());*/
		//删除好友结束
		
		//添加好友
		//System.out.println(HttpYX.addBuddy("789", "4a21effaf6827d9a312e628a929f6525"));
	
		//循环删除好友 开始
		//获取所有的审核
		/*List list0 = yx.query_token("0",-1);
		//获取所有的客户
		List list = yx.query_token("1",-1);
		String s;
		String s1 = "";
		String s2;//接收返回结果
		
		//循环删除好友 
		for(int i=0;i<list0.size();i++){
			s1=((Map)list0.get(i)).get("accid").toString();
			int sum=0;
			StringBuilder sb=new StringBuilder();
			for(int j=0;j<list.size();j++){
				s=((Map)list.get(j)).get("accid").toString();//发起者
				List<NameValuePair> nvps = new ArrayList<NameValuePair>();
				nvps.add(new BasicNameValuePair("accid",s));
				nvps.add(new BasicNameValuePair("faccid",s1));
				s2=HttpYX.doPost("https://api.netease.im/nimserver/friend/delete.action",nvps);
				if(s2.indexOf("200")==-1){
					sb.append(s1).append("删除：").append(s).append("失败！");
					sum++;
				}
			}
			//System.out.println(s1+"总的好友数:"+list.size()+",失败个数："+sum+" "+sb.toString());
		}*/
		//循环删除好友结束
		String s="dfd'{dfd}''{";
		//System.out.println(s.replaceAll("\\'\\{","{"));
	}
}
