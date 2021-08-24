package com.xingxin.service.impl;

import com.xingxin.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author liuxh
 * @date 2021/8/24
 */
@Component
public class AliPayServiceImpl implements PaymentService {

    @Override
    public void pay() {
        System.out.println("支付宝支付...");
    }
}
