package com.dji.business.client;

import com.dji.business.config.DjiSpatiumProperties;
import com.dji.common.util.DjiSpatiumSignUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class DjiSpatiumApiClient {

    private final DjiSpatiumProperties properties;
    private final RestTemplate restTemplate;

    /**
     * 构造请求头（所有调用司空openapi接口都要带这个签名头）
     */
    public HttpHeaders buildHeader() {
        long ts = DjiSpatiumSignUtil.getTimestamp();
        String nonce = DjiSpatiumSignUtil.generateNonce();
        String sign = DjiSpatiumSignUtil.sign(properties.getAppKey(), properties.getAppSecret(), ts, nonce);

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-DJI-Key", properties.getAppKey());
        headers.add("X-DJI-Timestamp", String.valueOf(ts));
        headers.add("X-DJI-Nonce", nonce);
        headers.add("X-DJI-Signature", sign);
        headers.add("Content-Type", "application/json");
        return headers;
    }

    /**
     * 示例：查询设备列表，你后续可以扩展：查询任务、下载媒体文件等
     */
    public String listDevice() {
        String url = properties.getHost() + "/openapi/v1/devices";
        HttpHeaders headers = buildHeader();
        // 自行封装请求、返回解析
        return restTemplate.getForObject(url, String.class);
    }
}
