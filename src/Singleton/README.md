#单例模式简介
* 定义：确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例。
* UML类图：![Singleton.png](https://upload-images.jianshu.io/upload_images/1933808-8f5879f92e5f6652.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
* 综合分析：

	**优点：**
	
	1. 对于频繁创建销毁的对象可减少内存开支。
	2. 对于配置复杂、依赖较多的对象，可减少性能开销。
	3. 避免多个兄弟对象之间争夺资源。
	4. 便于设置全局访问点。
	
	**缺点：**
	
	1. 单例模式拓展困难。
	2. 对于测试是困难的。
	3. 与单一指责原则冲突。

	**适用场景：**
	
	1. 系统唯一对象，例如序列号生成器。
	2. 系统共享点和共享数据，例如程序计数器、映射表等。
	3. 创建一个耗费大量资源的对象，例如数据库对象。
	4. 大量静态方法，例如工具类。

#单例模式实践
![单例模式](https://upload-images.jianshu.io/upload_images/1933808-d13c06c5f9712b74.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

> 1. 标准模式
> 2. 懒汉模式
> 3. 饿汉模式
> 4. 双重锁懒汉模式
> 5. 静态内部类
> 6. 枚举模式


###1. 标准模式
```
//标准单例模式
public class StandardSigleton {
	private static StandardSigleton singleton;
	private StandardSigleton() {}
	public static StandardSigleton getInstance() {
		if (singleton == null) {
			singleton = new StandardSigleton();
		}
		return singleton;
	}
}
```

* 特点：以时间换空间，具有更好的用户体验，线程不安全。

###2. 懒汉模式
```
//懒汉单例（线程安全）
public class LazySingleton {
	private static LazySingleton singleton;
	private LazySingleton(){}
	private static synchronized LazySingleton getInstance() {
		if (singleton == null) {
			singleton = new LazySingleton();
		}
		return singleton;
	}
}
```

* 特点：线程安全，synchronized的开销影响性能。

###3. 饿汉模式
```
//饿汉单例模式（线程安全）
public class HungrySingleton {
	private static HungrySingleton singleton =
			new HungrySingleton();
	private HungrySingleton() {}
	public static HungrySingleton geInstance() {
		return singleton;
	}
}
```

* 特点：空间换时间，线程安全（推荐使用）。

###4. 双重锁懒汉模式
```
//双重锁懒汉模式（Double Check Lock）
public class DCLSingleton {
	private volatile static DCLSingleton singleton = null;
	private DCLSingleton() {};
	private static DCLSingleton getInstance() {
		if (singleton == null) {
			synchronized (DCLSingleton.class) {
				if (singleton == null) {
					singleton = new DCLSingleton();
				}
			}
		}
		return singleton;
	}
}
```

> **增加volatile的原因：**<br>
> singleton = new DCLSingleton()的时候会进行三个步骤:
> 
> 1. 堆内分配空间。
> 2. 在堆在初始化参数等信息。
> 3. 对象指针指向堆内存地址。
> 
> 由于JVM存在乱序执行，在多线程中，会出现一种情况，线程A进行了三步（指向内存地址），此刻线程B却以为对象已经初始完，线程B使用该对象便会出错。而volatile保证JVM不会出现乱序。

###5. 静态内部类模式
```
//静态内部类单例模式
public class InnerClassSingleton {
	 private InnerClassSingleton() {}
	 private static class SingletonHoler {
		 private static final InnerClassSingleton INSTANCE =
				 new InnerClassSingleton();
	 }
	 public static InnerClassSingleton getInstance() {
		 return SingletonHoler.INSTANCE;
	 }
}
```

* 特点：高效，线程安全，但存在传参问题。

> 高效原因：第一次加载InnerClassSingleton时不需要分配InnerClassSingleton的内存空间（懒加载优势），而调用getInstance()时，SingleTonHoler才在InnerClassSingleton的运行时常量池里，把符号引用替换为直接引用，这时静态对象INSTANCE也真正被创建。<br>
> 
> 线程安全：JVM会保证一个类的\<clinit>()方法在多线程环境下正确的加锁、同步，从而保证在\<clinit>()方法执行时，只有一个线程去执行，阻塞其他线程，达到线程安全的目的。

*注：此处\<clinit>()可以理解为对static对象的初始化赋值。*

###6. 枚举模式
```
public enum SingleTon{
  INSTANCE;
        public void method(){
        //TODO
     }
}
```

[查看代码](https://github.com/Mr-Jason-Sam/DesiginMode/tree/master/src/Singleton)

[部分摘取文章内容](https://blog.csdn.net/mnb65482/article/details/80458571)