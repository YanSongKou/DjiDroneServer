package com.dji.business.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 配置属性类
 * @author: ZK716
 * @date: 2023/4/25
 * @description:
 */

@Data
@Component
@ConfigurationProperties(prefix = "dji.spatium")
public class DjiSpatiumProperties {
    private String appKey;
    private String appSecret;
    private String host;
    private String callbackSecret;
}
