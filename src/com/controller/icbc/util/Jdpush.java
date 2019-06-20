package com.controller.icbc.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;
import cn.jpush.api.push.model.notification.AndroidNotification;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;

public class Jdpush {
	protected static final Logger LOG = LoggerFactory.getLogger(Jdpush.class);

	// demo App defined in resources/jpush-api.conf

	public static final String TITLE = "��ͨ���";
	public static final String ALERT = "��Լ�������ָ";
	public static final String MSG_CONTENT = "��ͨ���ף���Ͽͻ��´�����";
	public static final String REGISTRATION_ID2 = "121c83f76005fca8286";
	public static final String REGISTRATION_ID1 = "1a1018970a876012be0";

	public static final String TAG = "tag_api";

	public static JPushClient jpushClient = null;

	public static void testSendPush(String appKey, String masterSecret,
			String REGISTRATION_ID, String content) {

		jpushClient = new JPushClient(masterSecret, appKey, 3);

		// HttpProxy proxy = new HttpProxy("localhost", 3128);
		// Can use this https proxy: https://github.com/Exa-Networks/exaproxy

		// For push, all you need do is to build PushPayload object.
		// PushPayload payload = buildPushObject_all_all_alert();
		// �������͵����ݣ����������Ȳ���ȫ������
		PushPayload payload = buildPushObject_all_alias_alert(REGISTRATION_ID,
				content);
		try {
			System.out.println(payload.toString());
			PushResult result = jpushClient.sendPush(payload);
			System.out.println(result + "................................");
			LOG.info("Got result - " + result);
		} catch (cn.jiguang.common.resp.APIConnectionException e) {
			LOG.error("Connection error. Should retry later. ", e);
		} catch (cn.jiguang.common.resp.APIRequestException e) {
			LOG.error(
					"Error response from JPush server. Should review and fix it. ",
					e);
			LOG.info("HTTP Status: " + e.getStatus());
			LOG.info("Error Code: " + e.getErrorCode());
			LOG.info("Error Message: " + e.getErrorMessage());
			LOG.info("Msg ID: " + e.getMsgId());
		}
	}

	public static PushPayload buildPushObject_all_all_alert() {
		return PushPayload.alertAll(ALERT);
	}

	public static PushPayload buildPushObject_all_alias_alert(
			String REGISTRATION_ID, String alert) {
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.all())
				// ���ý��ܵ�ƽ̨
				.setAudience(Audience.registrationId(REGISTRATION_ID))
				// Audience����Ϊall��˵�����ù㲥��ʽ���ͣ������û������Խ��յ�
				.setNotification(Notification.alert(alert))
				.setOptions(
						Options.newBuilder().setApnsProduction(true).build())
				.build();
	}

	public static PushPayload buildPushObject_android_tag_alertWithTitle() {
		return PushPayload.newBuilder().setPlatform(Platform.android())
				.setAudience(Audience.all())
				.setNotification(Notification.android(ALERT, TITLE, null))
				.build();
	}

	public static PushPayload buildPushObject_android_and_ios() {
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(Audience.registrationId(REGISTRATION_ID1))
				.setNotification(
						Notification
								.newBuilder()
								.setAlert("alert content")
								.addPlatformNotification(
										AndroidNotification.newBuilder()
												.setTitle("Android Title")
												.build())
								.addPlatformNotification(
										IosNotification
												.newBuilder()
												.incrBadge(1)
												.addExtra("extra_key",
														"extra_value").build())
								.build()).build();
	}

	public static PushPayload buildPushObject_ios_tagAnd_alertWithExtrasAndMessage() {
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.ios())
				.setAudience(Audience.tag_and("tag1", "tag_all"))
				.setNotification(
						Notification
								.newBuilder()
								.addPlatformNotification(
										IosNotification.newBuilder()
												.setAlert(ALERT).setBadge(5)
												.setSound("happy")
												.addExtra("from", "JPush")
												.build()).build())
				.setMessage(Message.content(MSG_CONTENT))
				.setOptions(
						Options.newBuilder().setApnsProduction(true).build())
				.build();
	}

	public static PushPayload buildPushObject_ios_audienceMore_messageWithExtras() {
		return PushPayload
				.newBuilder()
				.setPlatform(Platform.android_ios())
				.setAudience(
						Audience.newBuilder()
								.addAudienceTarget(
										AudienceTarget.tag("tag1", "tag2"))
								.addAudienceTarget(
										AudienceTarget
												.alias("alias1", "alias2"))
								.build())
				.setMessage(
						Message.newBuilder().setMsgContent(MSG_CONTENT)
								.addExtra("from", "JPush").build()).build();
	}

	private static final String appKey = "7e21faf06524b22f0ee1414c";
	private static final String masterSecret = "c87361ae4d7d91067b3ea01a";

	public static void main(String[] args) {
		// Jdpush.testSendPush(appKey,masterSecret,"�ǵķ���");
		// System.out.println("");
	}
}