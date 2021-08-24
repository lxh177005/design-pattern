package com.xingxin.factory;

import com.xingxin.service.PaymentService;
import com.xingxin.enums.PaymentEnum;
import com.xingxin.utils.SpringUtils;

/**
 * @author liuxh
 * @date 2021/8/24
 */
public class PaymentFactory {

    // PayTest.payTest示例
    public static PaymentService getPaymentService(String payType) {
        // 枚举获取
        String impl = PaymentEnum.valueOf(payType).getImpl();
        PaymentService paymentService = SpringUtils.getBean(impl, PaymentService.class);
        // 也可以使用数据库获取
        // 也可以直接new
        return paymentService;
    }
}
