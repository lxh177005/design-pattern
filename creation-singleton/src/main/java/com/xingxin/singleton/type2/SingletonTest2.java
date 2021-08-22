package com.xingxin.singleton.type2;

/**
 * 单例模式二：饿汉式
 * 和test01是一样的，只不过将类的实例化放在了静态代码块里，结果也是一样的，优缺点也是
 * @author liuxh
 * @date 2021/7/25
 */
public class SingletonTest2 {
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
    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    private Singleton() {

    }

    // 3.对外提供一个共有的方法，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }
}