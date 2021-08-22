package com.xingxin.service.impl;

import com.xingxin.service.PayStrategy;
import org.springframework.stereotype.Component;

/**
 * @author liuxh
 * @date 2021/8/22
 */
@Component("weChatStrategy")
public class WeChatStrategy implements PayStrategy {
    @Override
    public String toPayHtml() {
        return "微信支付。。。";
    }
}
