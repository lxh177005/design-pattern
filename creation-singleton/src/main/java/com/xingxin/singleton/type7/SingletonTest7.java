package com.xingxin.singleton.type7;

/**
 * 单例模式七：静态内部类
 * 优点：静态内部类在类加载的时候不会立即被加载，在被调用的时候才会加载，
 *       所以实现了懒加载的功能，jvm帮我们实现了线程安全
 * 总结：推荐使用
 * @author liuxh
 * @date 2021/7/25
 */
public class SingletonTest7 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        // 获取两次的都是一样的
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}
// 静态内部类 推荐使用
class Singleton {
    private Singleton() {
    }

    /**
     * 静态内部类在类加载的时候不会立即被加载，
     * 在被调用的时候才会加载，所以实现了懒加载的功能
     * jvm帮我们实现了线程安全
     */
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }
    //提供一个共有方法，对外返回SingletonInstance.INSTANCE;
    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}