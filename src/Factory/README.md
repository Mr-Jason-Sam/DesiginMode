![Factory.png](https://upload-images.jianshu.io/upload_images/1933808-95769dc037c0e80b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
#工厂模式

> 1. 工厂模式
> 2. 抽象工厂模式

###工厂方法模式
* 定义：定义一个用于创建对象的接口，让子类决定实例化哪一个类，使一个类的实例化延迟到其子类。
* UML类图：![标准工厂模式](https://upload-images.jianshu.io/upload_images/1933808-81961f7314b08c07.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* 综合分析：

 	**优点：**
 	
 	1. 封装性好（隐藏具体代码的实现），代码结构清晰。
	2. 扩展性优秀。
	3. 屏蔽产品类，产品类的实现与调用方无关，调用方只关心工厂接口。

	**缺点：**
	
	1. 代码臃肿，增加代码复杂度。

	**适用场景：**
	
	1. 需要灵活，可扩展的框架。
	2. 产品类过多，需要统一管理。
	3. 测试系统中。

* 拓展：

	**简单工厂**
	
	![简单工厂模式](https://upload-images.jianshu.io/upload_images/1933808-c977b5bc53a06bd3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
	
####工厂方法模式实践
#####产品类

```
	publi abstract class Produce {
		public abstract void dosomething();
	}
	
	public class ConcreteProduceA extends Produce {
		@Override
		public void dosomething() {
			System.out.println("I am ProduceA!");
		}
	}
	
	public class ConcreteProduceB extends Produce {
		@Override
		public void dosomething() {
			System.out.println("I am ProduceB!");
		}
	}
```
#####工厂类
```
	public abstract class Creator {
		public abstract <T extends Produce>T createProduce(Class<T> c);
	}
	
	public class ConcreteCreator extends Creator {
		@Override
		public <T extends Produce>T createProduce(Class<T> c) {
			Produce produce = null;
			try {
				produce = (Produce)Class.forName(c.getName()).newInstance();
			} catch (Exception e) {
				// TODO: handle exception
			}
			return (T)produce;
		}
	}
```
#####客户端
```
public class client {
	public static void main(String[] args) {
		Creator creator = new ConcreteCreator();
		Produce A = creator.createProduce(ConcreteProduceA.class);
		A.dosomething();
		Produce B = creator.createProduce(ConcreteProduceB.class);
		B.dosomething();
	}
}
```

###抽象工厂模式
* 定义：为创建一组相关或相互依赖的对象提供一个接口，而且无须指定它们的具体类。
* UML类图：![抽象工厂模式](https://upload-images.jianshu.io/upload_images/1933808-b3bc6888c482e328.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* 综合分析：

	**缺点：**
	
	1. 产品族拓展困难，修改产品族（例如添加一个产品3）必须要对AbstractCreator和其子类修改，严重违反了“开闭原则”。

	**适用场景：**
	
	1. 一个对象族有相同的约束。即类图中的，produce1和2都有A和B的约束。
	2. 横向拓展容易，纵向拓展困难。（图中produce1、2拓展困难，A和B拓展简单）


####抽象工厂模式实践
#####产品类

```
	public abstract class Produce1 {
		public abstract void dosomething();
	}
	
	public class ConcreteProduceA1 extends Produce1 {
		@Override
		public void dosomething() {
			System.out.println("I am ProduceA1!");
		}
	}
	
	public class ConcreteProduceB1 extends Produce1 {
		@Override
		public void dosomething() {
			System.out.println("I am ProduceB1!");
		}
	}
	
	public abstract class Produce2 {
		public abstract void dosomething();
	}
	
	public class ConcreteProduceA2 extends Produce2 {
		@Override
		public void dosomething() {
			System.out.println("I am ProduceA2!");
		}
	}
	
	public class ConcreteProduceB2 extends Produce2 {
		@Override
		public void dosomething() {
			System.out.println("I am ProduceB2!");
		}
	}
```
#####工厂类
```
	public abstract class Creator {
		public abstract Produce1 createProduce1();
		public abstract Produce2 createProduce2();
	}
	
	public class ConcreteCreatorA extends Creator {
		@Override
		public Produce1 createProduce1(){
			return new ConcreteProduceA1();
		}
		
		@Override
		public Produce2 createProduce2() {
			return new ConcreteProduceA2();
		}
	}
	
	public class ConcreteCreatorB extends Creator {
		@Override
		public Produce1 createProduce1(){
			return new ConcreteProduceB1();
		}
		
		@Override
		public Produce2 createProduce2() {
			return new ConcreteProduceB2();
		}
	}
```
#####客户端
```
public class client {
	public static void main(String[] args) {
		Creator creatorA = new ConcreteCreatorA();
		Creator creatorB = new ConcreteCreatorB();
		Produce1 A1 = creatorA.createProduce1();
		A1.dosomething();
		Produce2 A2 = creatorA.createProduce2();
		A2.dosomething();
		Produce1 B1 = creatorB.createProduce1();
		B1.dosomething();
		Produce2 B2 = creatorB.createProduce2();
		B2.dosomething();
	}
}
```

[源代码]()