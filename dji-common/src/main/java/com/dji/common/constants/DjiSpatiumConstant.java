package com.dji.common.constants;

/**
 * 司空2 OpenAPI 常量
 * @author: ZK716
 * @date: 2023/11/20
 */
public class DjiSpatiumConstant {

    /**
     * 司空2 OpenAPI 域名，正式/测试区分
     */
    public static final String SPATIUM_API_HOST_TEST = "https://api-test.dji.com";
    public static final String SPATIUM_API_HOST_PROD = "https://api.dji.com";

    /**
     * 回调消息类型：媒体文件（拍照截图，AI分析核心）
     */
    public static final String CALLBACK_TYPE_MEDIA_UPLOAD = "media_upload";
    /**
     * 设备状态上报
     */
    public static final String CALLBACK_TYPE_DEVICE_STATUS = "device_status";

    /**
     * MQTT Topic：无人机媒体消息，ai-analysis消费
     */
    public static final String MQTT_DJI_MEDIA_TOPIC = "dji.media.analysis";

}
