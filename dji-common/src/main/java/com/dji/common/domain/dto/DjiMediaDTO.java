package com.dji.common.domain.dto;

import lombok.Data;
import java.math.BigDecimal;

/**
 * 媒体文件信息
 * @author: ZK716
 * @date: 2023/11/20
 */
@Data
public class DjiMediaDTO {

    /**
     * 文件下载url（临时url，有有效期）
     */
    private String url;

    /**
     * 文件类型 photo / video
     */
    private String fileType;

    /**
     * 拍摄经纬度 GCJ02 大疆默认坐标系！重点，如有需要水尺识别、GIS要用
     */
    private BigDecimal lon;

    /**
     * 拍摄纬度 GCJ02 大疆默认坐标系
     */
    private BigDecimal lat;

    /**
     * 高度
     */
    private BigDecimal alt;

    /**
     * 拍摄时间
     */
    private Long captureTime;
}
