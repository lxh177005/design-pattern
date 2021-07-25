package com.xingxin.singleton.type4;

/**
 * 单例模式四：懒汉式（线程安全）
 * 优点：起到了lazy loading的效果,也解决了线程安全
 * 缺点：每个线程在获取类的时候都会排队执行getInstance方法，效率低
 * 总结：实际开发中，不要使用这种方式
 *
 * @author liuxh
 * @date 2021/7/25
 */
public class SingletonTest4 {
    public static void main(String[] args) {
        System.out.println("线程安全");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        // 获取两次的都是一样的
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Singleton {
    private static Singleton instance;
    private Singleton() {
    }
    // 提供一个静态的共有方法，当使用时才创建，即懒汉式
    // 加入一个同步处理代码，解决线程安全问题
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}