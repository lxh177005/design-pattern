package com.xingxin.service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author liuxh
 * @date 2021/8/24
 */
@Getter
@AllArgsConstructor
public enum  PaymentEnum {
    ALI_PAY(1,"aliPayServiceImpl", "阿里支付"),
    WECHAT_PAY(2,"weChatServiceImpl", "微信支付");
    private final Integer payType;
    private final String impl;
    private final String desc;
}
