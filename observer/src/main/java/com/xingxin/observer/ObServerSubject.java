package com.xingxin.observer;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liuxh
 * @date 2021/8/30
 */
@Component
public class ObServerSubject {

    private ExecutorService executorService;

    /**
     * 初始化线程池
     */
    public ObServerSubject() {
        executorService = Executors.newFixedThreadPool(10);
    }

    /**
     * ObServer类型
     */
    private List<ObServer> obServers = new ArrayList<>();

    /**
     * 添加 ObServer观察者
     *
     * @param obServer
     */
    public void addObServer(ObServer obServer) {
        obServers.add(obServer);
    }

    /**
     * 通知所有的ObServer
     *
     * @param jsonObject
     */
    public void notifyObServers(JSONObject jsonObject) {

        // 遍历发消息
        obServers.forEach(obServer -> {
            // 使用多线程异步发送消息
            executorService.execute(() -> {
                obServer.sendMsg(jsonObject);
            });
        });
    }
}
