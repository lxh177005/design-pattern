package com.xingxin.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author liuxh
 * @date 2021/9/4
 */
@Slf4j
@Service
public class PaymentService {

    public void updatePaymentStatus() {
        log.info("2.修改订单状态为已支付。。。");
    }
}
