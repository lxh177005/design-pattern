package com.xingxin.service.impl;

import com.xingxin.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author liuxh
 * @date 2021/8/24
 */
@Component
public class WeChatServiceImpl implements PaymentService {
    @Override
    public void pay() {
        System.out.println("微信支付...");
    }
}
