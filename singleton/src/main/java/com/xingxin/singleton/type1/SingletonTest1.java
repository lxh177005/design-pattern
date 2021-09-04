package com.xingxin.singleton.type1;

import java.io.*;

/**
 * 单例模式一：饿汉式
 * 优点：这种写法比较简单，就是类装载的时候完成实例化，避免了线程同步问题
 * 缺点：静态类装载的时候完成了实例化，没有达到lazy loading效果，如果从始至终都没有使用过，则会造成内存浪费
 * 总结：可以用，但是可能造成内存浪费
 * @author liuxh
 * @date 2021/7/25
 */
public class SingletonTest1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        // 获取两次的都是一样的
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());


        // 利用序列化破解单例
        // 序列化：对象从内存-->硬盘
        FileOutputStream fos = new FileOutputStream("E:\\myFiles\\Singleton.obj");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(instance);
        oos.flush();
        oos.close();
        // 反序列化：从硬盘-->内存
        FileInputStream fis = new FileInputStream("E:\\myFiles\\Singleton.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Singleton singleton3 = (Singleton) ois.readObject();
        System.out.println(singleton3==instance);


    }
}
// 饿汉式
class Singleton implements Serializable {
    // 1.构造器私有化
    private Singleton() {

    }
    // 2.本类内部创建对象实例
    private final static Singleton instance = new Singleton();
    // 3.对外提供一个共有的方法，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }

    //返回序列化获取对象 ，保证为单例
    public Object readResolve() {
        return instance;
    }

}
