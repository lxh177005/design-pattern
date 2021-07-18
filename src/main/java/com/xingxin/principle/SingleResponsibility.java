package com.xingxin.principle;

/**
 * 单一职责原则：
 * 一个类只负责一项职责，比如userDao、orderDao里面的方法
 * （1）降低类的复杂度，一个类一个职责
 * （2）提高类的可读性，可维护性
 * （3）降低变更带来的风险
 * （4）通常情况下，我们应当遵守单一职责原则，只有逻辑足够简单，才可以在代码级别违反单一职责原则；
 * 只有类的方法足够少，可以在方法级别保持单一职责原则
 *
 * @author liuxh
 * @date 2021/7/3
 */
public class SingleResponsibility {
    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        vehicle.runRoad("汽车");
        vehicle.runAir("飞机");
        vehicle.runWater("轮船");
    }
}

class Vehicle {
    public void runRoad(String vehicle) {
        System.out.println(vehicle + " 在公路上运行...");
    }

    public void runAir(String vehicle) {
        System.out.println(vehicle + " 在天空中运行...");
    }

    public void runWater(String vehicle) {
        System.out.println(vehicle + " 在水中运行...");
    }
}