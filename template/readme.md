##Ø 定义
提前定义好骨架，相同的行为直接定义在抽象类中（复用），不同的行为由子类完成
##Ø 优缺点
优点： 1、封装不变部分，扩展可变部分。 2、提取公共代码，便于维护。 3、行为由父类控制，子类实现。
缺点：每一个不同的实现都需要一个子类来实现，导致类的个数增加，使得系统更加庞大。

## 源码
restTemplate 和 HttpServlet 。。