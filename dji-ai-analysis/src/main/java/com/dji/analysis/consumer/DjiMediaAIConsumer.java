package com.dji.analysis.consumer;

import com.dji.common.constants.DjiSpatiumConstant;
import com.dji.common.domain.dto.DjiMediaAIMsgDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DjiMediaAIConsumer {

    /**
     * 消费无人机图片消息
     * 这里是AI识别入口：
     * 1. 下载url图片到本地/对象存储
     * 2. 调用YOLO推理接口（船只识别、水尺识别）
     * 3. 识别结果入库、生成告警
     */
    @RabbitListener(queues = DjiSpatiumConstant.MQTT_DJI_MEDIA_TOPIC)
    public void consume(DjiMediaAIMsgDTO msg) {
        System.out.println("收到无人机媒体消息，SN：" + msg.getSn() + " 图片地址：" + msg.getFileUrl());
        // TODO 后续实现：图片下载、调用YOLO、结果保存
    }
}
