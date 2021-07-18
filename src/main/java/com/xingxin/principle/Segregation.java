package com.xingxin.principle;

/**
 * 接口隔离原则：
 * 如果一个接口里面有很多个方法，而某个类只使用了它一部分的方法，
 * 因此没有必要将接口的方法全部实现，只需将接口拆分，然后实现
 *
 * @author liuxh
 * @date 2021/7/18
 */
public class Segregation {
    public static void main(String[] args) {
        A a = new A();
        // A类通过接口去使用B类
        a.depend1(new B());
        a.depend2(new B());
        a.depend3(new B());

        C c = new C();
        c.depend1(new D());
        c.depend4(new D());
    }
}

interface interface1 {
    void operation1();
}

interface interface2 {
    void operation2();

    void operation3();
}

interface interface3 {
    void operation4();

    void operation5();
}

class B implements interface1, interface2 {

    @Override
    public void operation1() {
        System.out.println("B实现的operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B实现的operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B实现的operation3");
    }
}

class D implements interface1, interface3 {

    @Override
    public void operation1() {
        System.out.println("C实现的operation1");
    }

    @Override
    public void operation4() {
        System.out.println("C实现的operation4");
    }

    @Override
    public void operation5() {
        System.out.println("C实现的operation5");
    }
}

class A {
    public void depend1(interface1 i) {
        i.operation1();
    }

    public void depend2(interface2 i) {
        i.operation2();
    }

    public void depend3(interface2 i) {
        i.operation3();
    }
}

class C {
    public void depend1(interface1 i) {
        i.operation1();
    }

    public void depend4(interface3 i) {
        i.operation4();
        i.operation5();
    }
}