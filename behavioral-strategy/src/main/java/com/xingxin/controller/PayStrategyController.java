package com.xingxin.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xingxin.dao.PaymentChannelDao;
import com.xingxin.entity.PaymentChannel;
import com.xingxin.service.PayStrategy;
import com.xingxin.utils.SpringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxh
 * @date 2021/8/22
 */
@RestController
public class PayStrategyController {

    @Autowired
    private PaymentChannelDao paymentChannelDao;

    @GetMapping("/toPayHtml")
    public String toPayHtml(String payCode) {
        PaymentChannel paymentChannel = paymentChannelDao.selectOne(
                new LambdaQueryWrapper<PaymentChannel>().eq(PaymentChannel::getChannelId, payCode));
        if (paymentChannel == null || StringUtils.isBlank(paymentChannel.getStrategyBeanId())) {
            return "数据库缺少支付渠道配置";
        }
        PayStrategy payStrategy = SpringUtils.getBean(paymentChannel.getStrategyBeanId(), PayStrategy.class);
        return payStrategy.toPayHtml();
    }
}
