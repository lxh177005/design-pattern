package com.xingxin.singleton.type8;

/**
 * 单例模式八：枚举实现
 * 优点：jdk1.5枚举，不仅能避免多线程的同步问题，还能防止反序列化创建新的对象
 * 总结：强烈推荐使用
 * @author liuxh
 * @date 2021/7/25
 */
public class SingletonTest8 {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
        instance.sayOk();
        instance2.sayOk();
    }
}
// jdk1.5枚举，不仅能避免多线程的同步问题，还能防止反序列化创建新的对象，强烈推荐使用
enum Singleton {
    INSTANCE;
    public void sayOk() {
        System.out.println("ok...");
    }
}