package com.xingxin.controller;

import com.xingxin.facade.PayFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuxh
 * @date 2021/9/4
 */
@RestController
@Slf4j
public class FacadeController {

    @Autowired
    private PayFacade payFacade;

    @GetMapping("/payCallback")
    public String payCallback() {
        payFacade.facadeCallback();
        return "success";
    }
}
