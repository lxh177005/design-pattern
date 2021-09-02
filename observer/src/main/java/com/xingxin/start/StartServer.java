package com.xingxin.start;

import com.xingxin.observer.ObServer;
import com.xingxin.observer.ObServerSubject;
import com.xingxin.observer.impl.EmailObServer;
import com.xingxin.observer.impl.SMSObServer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author liuxh
 * @date 2021/8/30
 */
@Component
public class StartServer implements ApplicationRunner, ApplicationContextAware {

    @Autowired
    private SMSObServer smsObServer;
    @Autowired
    private EmailObServer emailObServer;
    @Autowired
    private ObServerSubject obServerSubject;

    private ApplicationContext applicationContext;

    // 等springboot IOC容器启动成功后，注册ObServer到ObServerSubject中
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 1.从IOC容器中拿到ObServer实现并注入
//        obServerSubject.addObServer(smsObServer);
//        obServerSubject.addObServer(emailObServer);

        // 2.利用java反射机制，拿到ObServer的子类，然后从Spring容器中getBean
        Map<String, ObServer> beans = applicationContext.getBeansOfType(ObServer.class);
        beans.forEach( (k, v) -> obServerSubject.addObServer(v));

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
