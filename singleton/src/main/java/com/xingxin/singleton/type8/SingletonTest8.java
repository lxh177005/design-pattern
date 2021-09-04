package com.xingxin.singleton.type8;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 单例模式八：枚举实现
 * 优点：jdk1.5枚举，不仅能避免多线程的同步问题，还能防止反序列化创建新的对象
 * 总结：强烈推荐使用
 * @author liuxh
 * @date 2021/7/25
 */
public class SingletonTest8 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
        instance.sayOk();
        instance2.sayOk();

        // 利用java反射破解枚举单例，直接抛异常，因为枚举没有构造函数
//        Constructor<Singleton> declaredConstructor = Singleton.class.getDeclaredConstructor();
//        declaredConstructor.setAccessible(true);
//        Singleton singleton = declaredConstructor.newInstance();
//        System.out.println(instance == singleton);

        // 利用序列化破解枚举单例，无效，返回true
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
// 枚举，不仅能避免多线程的同步问题，还能防止反序列化创建新的对象，强烈推荐使用
enum Singleton {
    /**
     * 单例
     */
    INSTANCE;
    public void sayOk() {
        System.out.println("ok...");
    }
}