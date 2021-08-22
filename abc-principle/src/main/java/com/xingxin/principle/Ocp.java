package com.xingxin.principle;

/**
 * 开闭原则
 * 对扩展开放，对修改关闭；
 * 新增的功能，通过扩展实现，而不是修改已有的代码实现；
 * 开闭原则是设计原则的核心。
 *
 * @author liuxh
 * @date 2021/7/18
 */
public class Ocp {

    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Cirale());
        graphicEditor.drawShape(new Triangle());
    }
}

class GraphicEditor {
    public void drawShape(Shape shape) {
//        if (shape.type == 1) {
//            drawRectangle(shape);
//        } else if (shape.type == 2) {
//            drawCirale(shape);
//        }

        shape.draw();
    }

//    public void drawRectangle(Shape shape) {
//        System.out.println("绘制矩形");
//    }
//
//    public void drawCirale(Shape shape) {
//        System.out.println("绘制圆形");
//    }
}

abstract class Shape {
    int type;

    // 抽象方法，绘制
    public abstract void draw();
}

class Rectangle extends Shape {
    Rectangle() {
        super.type = 1;
    }

    @Override
    public void draw() {
        System.out.println("绘制方形");
    }
}

class Cirale extends Shape {
    Cirale() {
        super.type = 2;
    }

    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}

class Triangle extends Shape {
    public Triangle() {
        super.type = 3;
    }

    @Override
    public void draw() {
        System.out.println("绘制三角形");
    }
}