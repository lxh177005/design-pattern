## 策略模式
## Ø 优缺点
优点：策略模式最终帮助我们解决在实际开发中多重if判断问题、提高扩展性、维护性增强、提高代码可读性。
缺点：后期维护不同策略类是非常多、定义类比较多、代码量增大。
优点大于缺点。
## Ø 源码分析
Spring框架中使用的策略模式
1. ClassPathXmlApplicationContext  Spring底层Resource接口采用策略模式
Spring 为 Resource 接口提供了如下实现类：
UrlResource：访问网络资源的实现类。
ClassPathResource：访问类加载路径里资源的实现类。
FileSystemResource：访问文件系统里资源的实现类。
ServletContextResource：访问相对于 ServletContext 路径里的资源的实现类：
InputStreamResource：访问输入流资源的实现类。
ByteArrayResource：访问字节数组资源的实现类。
public ClassPathXmlApplicationContext(String configLocation) throws BeansException {
        this(new String[] {configLocation}, true, null);
}
….





2. 初始化容器  SimpleInstantiationStrategy


