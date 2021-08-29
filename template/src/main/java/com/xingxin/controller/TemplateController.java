package com.xingxin.controller;

import com.xingxin.factory.TemplateFactory;
import com.xingxin.template.AbstractPayCallbackTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxh
 * @date 2021/8/25
 */
@RestController
public class TemplateController {

    @GetMapping("/asyncCallback")
    public String asyncCallback(String templateId) {
        AbstractPayCallbackTemplate template = TemplateFactory.getAbstractPayCallbackTemplate(templateId);
        // 使用模板方法 执行共同的骨架
        return template.asyncCallback();
    }
}
