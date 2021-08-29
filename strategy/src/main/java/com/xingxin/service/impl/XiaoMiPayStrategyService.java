package com.xingxin.service.impl;

import com.xingxin.service.PayStrategy;
import org.springframework.stereotype.Component;

/**
 * @author liuxh
 * @date 2021/8/22
 */
@Component("xiaoMiPayStrategy")
public class XiaoMiPayStrategyService implements PayStrategy {
    @Override
    public String toPayHtml() {
        return "调用小米支付接口";
    }
}
