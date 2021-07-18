package com.xingxin.principle;

/**
 * 依赖倒置原则：
 * 中心思想就是面向接口编程
 * 变量的声明：向上造型
 * 依赖关系的三种传递方式：
 * 接口传递，构造方法传递，setter方式传递
 *
 * @author liuxh
 * @date 2021/7/18
 */
public class DependecyInversion {
    public static void main(String[] args) {
        SendMessage send = new SendMessage();
        send.sendMessage(new Email());
        send.sendMessage(new WeiXin());
    }
}

interface Message {
    String getInfo();
}

class Email implements Message {

    @Override
    public String getInfo() {
        return "Email: hello world!";
    }
}

class WeiXin implements Message {
    @Override
    public String getInfo() {
        return "WeiXin: hello world！";
    }
}

class SendMessage {
    public void sendMessage(Message message) {
        String info = message.getInfo();
        System.out.println("info = " + info);
    }
}