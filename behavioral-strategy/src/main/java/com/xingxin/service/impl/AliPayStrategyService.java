package com.xingxin.service.impl;

import com.xingxin.service.PayStrategy;
import org.springframework.stereotype.Component;

/**
 * @author liuxh
 * @date 2021/8/22
 */
@Component("aliPayStrategy")
public class AliPayStrategyService implements PayStrategy {
    @Override
    public String toPayHtml() {
        return "调用支付宝支付接口";
    }
}
