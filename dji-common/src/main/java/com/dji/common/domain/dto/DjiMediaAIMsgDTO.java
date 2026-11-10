package com.dji.common.domain.dto;

import lombok.Data;
import java.math.BigDecimal;

/**
 * 转发给 AI 模块的 MQTT 消息 DTO（清洗之后的标准消息）
 * @author: ZK716
 * @date: 2023/11/20
 */
@Data
public class DjiMediaAIMsgDTO {
    private String sn;
    private String taskId;
    private String fileUrl;
    private String fileType;
    private BigDecimal lon;
    private BigDecimal lat;
    private BigDecimal alt;
    private Long captureTime;
    /**
     * 消息生成时间
     */
    private Long createTime;
}
