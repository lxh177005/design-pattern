package com.xingxin.template;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 *  抽象方法模板
 * @author liuxh
 * @date 2021/8/24
 */
@Slf4j
@Component
public abstract class AbstractPayCallbackTemplate {

    /**
     *  异步回调接口，共同行为：日志收集，不同行为：验签、返回支付接口、更改支付状态
     */
    public String asyncCallback() {
        // 1.验证参数和签名
        Map<String, String> verifySignature = verifySignature();
        // 2.日志收集
        payLog(verifySignature);
        // 3.判断支付结果
        String code = verifySignature.get("code");
        if (StringUtils.isBlank(code) || !"200".equals(code)) {
            return resultFailed();
        }
        // 3.更改数据库订单支付状态，同时返回不同的支付结果
        return asyncService(verifySignature);

    }

    protected abstract String resultFailed();
    protected abstract String resultSuccess();

    /**
     *  验证参数
     */
    protected abstract Map<String, String> verifySignature();

    /**
     *  使用多线程异步写入数据库
     */
    @Async
    public void payLog(Map<String, String> verifySignature) {
        log.info("第二部：写入数据库中... verifySignature={}", verifySignature);
    }

    /**
     *  更改数据库订单支付状态，同时返回不同的支付结果
     */
    protected abstract String asyncService(Map<String, String> verifySignature);
}
