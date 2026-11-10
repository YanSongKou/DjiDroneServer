package com.dji.common.domain.dto;

import lombok.Data;

/**
 * 回调接收 DTO（大疆推送过来的消息）
 * @author: ZK716
 * @date: 2023/11/20
 */
@Data
public class DjiCallbackDTO {

    /**
     * 消息类型 media_upload / device_status
     */
    private String msgType;

    /**
     * 设备sn号（无人机唯一标识）
     */
    private String sn;

    /**
     * 任务id
     */
    private String taskId;

    /**
     * 媒体信息：图片url、文件类型、拍摄坐标
     */
    private DjiMediaDTO media;

    /**
     * 消息时间
     */
    private Long timestamp;
}
