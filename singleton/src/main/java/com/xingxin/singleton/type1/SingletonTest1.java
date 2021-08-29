package com.xingxin.singleton.type1;

/**
 * 单例模式一：饿汉式
 * 优点：这种写法比较简单，就是类装载的时候完成实例化，避免了线程同步问题
 * 缺点：静态类装载的时候完成了实例化，没有达到lazy loading效果，如果从始至终都没有使用过，则会造成内存浪费
 * 总结：可以用，但是可能造成内存浪费
 * @author liuxh
 * @date 2021/7/25
 */
public class SingletonTest1 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        // 获取两次的都是一样的
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}
// 饿汉式
class Singleton {
    // 1.构造器私有化
    private Singleton() {

    }
    // 2.本类内部创建对象实例
    private final static Singleton instance = new Singleton();
    // 3.对外提供一个共有的方法，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }
}
