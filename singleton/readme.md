##单例模式
	1.1 定义：就是只能存在一个对象实例， 有八种实现，下面记录有价值的实现方式
	1.2 说明：
	 （1）单例模式保证了系统内存中该类只能存在一个，节省了系统资源，对于一些需要频繁创建和销毁的对象，使用单例模式提高性能；
	（2）当想要实例化一个单例类的时候，必须要记住使用相应的获取对象的方法，而不是new
	（3）单例模式使用的场景：需要频繁的进行创建和销毁的对象，创建对象时耗时过多或者耗费资源过多（即：重量级对象），但又经常用到的对象、频繁访问数据库或文件的对象（比如数据源、session工厂等）
	1.3代码实现：
	// 饿汉式，容易造成内存浪费，且没有达到懒加载效果，可以用，但不推荐使用
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
	// 双重检测机制，保证线程安全和懒加载，推荐使用
	class Singleton {
	    // volatile修饰保证可见性和禁止指令重排（有序性）
	    private static volatile Singleton instance;
	    private Singleton() {
	    }
	    // 双重检测机制
	    public static Singleton getInstance() {
	        if (instance == null) {
	            synchronized (Singleton.class) {
	                if (instance == null) {
	                    instance = new Singleton();
	                }
	            }
	        }
	        return instance;
	    }
	}
	
	// 静态内部类 推荐使用
	class Singleton {
	    private Singleton() {
	    }
	    /**
	     * 静态内部类在类加载的时候不会立即被加载，
	     * 在被调用的时候才会加载，所以实现了懒加载的功能
	     * jvm帮我们实现了线程安全
	     */
	    private static class SingletonInstance {
	        private static final Singleton INSTANCE = new Singleton();
	    }
	    //提供一个共有方法，对外返回SingletonInstance.INSTANCE;
	    public static Singleton getInstance() {
	        return SingletonInstance.INSTANCE;
	    }
	}
	// jdk1.5枚举，不仅能避免多线程的同步问题，还能防止反序列化创建新的对象
	//  强烈推荐使用
	enum Singleton {
	    INSTANCE;
	    public void sayOk() {
	        System.out.println("ok...");
	    }
	}
	1.4源码
	jdk Runtime包 使用了饿汉式单例模式
	private static Runtime currentRuntime = new Runtime();
	    /**
	     * Returns the runtime object associated with the current Java application.
	     * Most of the methods of class <code>Runtime</code> are instance
	     * methods and must be invoked with respect to the current runtime object.
	     *
	     * @return  the <code>Runtime</code> object associated with the current
	     *          Java application.
	     */
	    public static Runtime getRuntime() {
	        return currentRuntime;
	    }
	    /** Don't let anyone else instantiate this class */
	    private Runtime() {}


	
