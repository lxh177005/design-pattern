package com.xingxin.singleton.type3;

/**
 * 单例模式三：懒汉式（线程不安全）
 * 优点：起到了lazy loading的效果
 * 缺点：只能在单线程下使用
 * 总结：实际开发中，不要使用这种方式
 *
 * @author liuxh
 * @date 2021/7/25
 */
public class SingletonTest3 {
    public static void main(String[] args) {
        System.out.println("线程不安全");
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
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}