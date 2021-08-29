package com.xingxin.template.impl;

import com.alibaba.fastjson.JSON;
import com.xingxin.template.AbstractPayCallbackTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuxh
 * @date 2021/8/25
 */
@Slf4j
@Component
public class AliPayCallbackTemplate extends AbstractPayCallbackTemplate {

    @Override
    protected Map<String, String> verifySignature() {
        Map<String, String> map = new HashMap<>();
        map.put("payNo", "123456");
        map.put("paymentStatus", "1");
        map.put("code", "200");
        log.info("第一步：AliPayCallbackTemplate result: {}", JSON.toJSONString(map));
        return map;
    }

    @Override
    protected String asyncService(Map<String, String> verifySignature) {
        String paymentStatus = verifySignature.get("paymentStatus");
        if ("1".equals(paymentStatus)) {
            String payNo = verifySignature.get("payNo");
            log.info("第三步：支付宝支付成功，修改订单状态为已支付, payNo={}", payNo);
        }
        return resultSuccess();
    }

    @Override
    protected String resultFailed() {
        log.info("返回给支付宝支付失败结果给支付宝");
        return "failed";
    }

    @Override
    protected String resultSuccess() {
        log.info("返回成功支付结果给支付宝");
        return "success";
    }
}
