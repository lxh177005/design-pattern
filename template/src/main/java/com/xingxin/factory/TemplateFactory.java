package com.xingxin.factory;

import com.xingxin.template.AbstractPayCallbackTemplate;
import com.xingxin.utils.SpringUtils;

/**
 * @author liuxh
 * @date 2021/8/25
 */
public class TemplateFactory {

    // 工厂模式，从spring容器中获取bean
    public static AbstractPayCallbackTemplate getAbstractPayCallbackTemplate(String template) {
        return SpringUtils.getBean(template, AbstractPayCallbackTemplate.class);
    }
}
