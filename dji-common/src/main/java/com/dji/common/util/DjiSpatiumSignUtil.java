package com.dji.common.util;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.DigestUtil;

public class DjiSpatiumSignUtil {

    /**
     * 生成随机nonce
     */
    public static String generateNonce() {
        return IdUtil.simpleUUID();
    }

    /**
     * 生成时间戳（秒，大疆要求秒级）
     */
    public static long getTimestamp() {
        return System.currentTimeMillis() / 1000;
    }

    /**
     * 司空2签名算法
     * 官方签名规则：timestamp + nonce + appSecret 拼接后 SHA256
     * @param appKey 密钥key
     * @param appSecret 密钥secret
     * @param timestamp 秒时间戳
     * @param nonce 随机串
     * @return sha256签名
     */
    public static String sign(String appKey, String appSecret, long timestamp, String nonce) {
        // 拼接规则：appKey + timestamp + nonce + appSecret
        String raw = appKey + timestamp + nonce + appSecret;
        return DigestUtil.sha256Hex(raw);
    }
}
