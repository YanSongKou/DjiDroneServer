package com.dji.business.controller;

import com.dji.common.constants.DjiSpatiumConstant;
import com.dji.common.domain.dto.DjiCallbackDTO;
import com.dji.common.domain.dto.DjiMediaAIMsgDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dji/spatium")
@RequiredArgsConstructor
public class DjiSpatiumCallbackController {

    private final RabbitTemplate rabbitTemplate;
    private final ObjectMapper objectMapper;

    /**
     * 司空回调入口
     * 注意：大疆回调有签名校验，下面我留了校验位置，你拿到正式secret之后补校验逻辑
     */
    @PostMapping("/callback")
    public String callback(@RequestBody DjiCallbackDTO callbackDTO) {
        // ========== 【重要】生产环境必须加：回调签名校验，防止伪造请求 ==========
        // 这里先预留，本地调试可以先注释校验
        // boolean verify = DjiCallbackSignUtil.verify(headers, body, properties.getCallbackSecret());
        // if (!verify) return "fail";

        // 只处理媒体上传消息（拍照、截图，AI分析数据源）
        if (DjiSpatiumConstant.CALLBACK_TYPE_MEDIA_UPLOAD.equals(callbackDTO.getMsgType())) {
            DjiMediaAIMsgDTO aiMsg = new DjiMediaAIMsgDTO();
            aiMsg.setSn(callbackDTO.getSn());
            aiMsg.setTaskId(callbackDTO.getTaskId());
            aiMsg.setFileUrl(callbackDTO.getMedia().getUrl());
            aiMsg.setFileType(callbackDTO.getMedia().getFileType());
            aiMsg.setLon(callbackDTO.getMedia().getLon());
            aiMsg.setLat(callbackDTO.getMedia().getLat());
            aiMsg.setAlt(callbackDTO.getMedia().getAlt());
            aiMsg.setCaptureTime(callbackDTO.getMedia().getCaptureTime());
            aiMsg.setCreateTime(System.currentTimeMillis());

            // 发送MQTT，交给ai-analysis消费识别
            rabbitTemplate.convertAndSend(DjiSpatiumConstant.MQTT_DJI_MEDIA_TOPIC, aiMsg);
        }
        // 其他消息（设备状态）可以自行扩展入库、告警
        return "success";
    }
}
