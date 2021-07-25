package com.xingxin.singleton.type6;

/**
 * 单例模式六：双重检测机制
 * 双重检测机制，保证线程安全和懒加载，效率较高
 * 总结：推荐使用
 *
 * @author liuxh
 * @date 2021/7/25
 */
public class SingletonTest6 {
    public static void main(String[] args) {
        System.out.println("线程安全的");
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        // 获取两次的都是一样的
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Singleton {
    // volatile修饰保证可见性和禁止指令重排（有序性）
    private static volatile Singleton instance;

    private Singleton() {
    }

    // 双重检测机制，保证线程安全和懒加载，推荐使用
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}