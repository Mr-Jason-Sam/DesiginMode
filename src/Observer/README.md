#观察者模式
* 定义：定义对象间一种一对多的依赖关系，使得每当一个对象改变状态，则所有依赖它的对象都会得到通知并被自动更新。
* UML类图：![观察者模式](https://upload-images.jianshu.io/upload_images/1933808-82dda5733f389ed6.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)


* 综合分析：

	**优点：**
 	
 	1. 观察者与被观察者是抽象耦合关系，实现类可以动态拓展。
	2. 便于建立一套触发机制，把单一类的触发关系串联起来。

	**缺点：**
	
	1. 开发效率的考虑。把单体的机制分开，需考虑模式应用的价值。
	2. 运行效率的考虑。单线程效率慢，需考虑合理设置多线程。

	**适用场景：**
	
	1. 关联行为场景。关联行为是可拆分的，而不是组合关系。
	2. 多级触发场景。
	3. 跨系统的消息交换场景，如消息队列处理机制。

###观察者模式实践
####观察接口
```
	public interface IObserver {
		 //条件触发后需要作出的处理
		 public void update();
	 }
```
####抽象被观察类
```
	public abstract class Subject {
		 //保证线程安全
		 Vector<IObserver> observers = new Vector<>();
		 
		 public void addObserver(IObserver o) {
			 observers.add(o);
		 }
		 
		 public void removeObserver(IObserver o) {
			 observers.remove(o);
		 }
		 
		 public void notifyObservers() {
			 for(IObserver observer : observers)
				 observer.update();
		 }
	 }
```
####被观察实体类
```
	public class ConcreteSubject extends Subject {
		 public void dosomething() {
			 //TODO happen events
			 super.notifyObservers();
		 }
	 }
```
####观察实体类
```
	public class ConcreteObserver implements IObserver {
		 @Override
		 public void update() {
			 System.out.println("happen change, handle info!");
		 }
	 }
```
####客户端类
```
public class client {
	public static void main(String[] args) {
		IObserver observerA = new ConcreteObserver();
		ConcreteSubject subjectA = new ConcreteSubject();
		subjectA.addObserver(observerA);
		subjectA.dosomething();
	}
}
```

###Java观察者模式实践
* 类图UML：![Java观察者实现](https://upload-images.jianshu.io/upload_images/1933808-5bbfc621023d578e.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

####具体实现代码
```
public class OriginObserver {
	public interface Subject {
		public void dosomething();
	}
	
	public static class ConcreteSubject 
		extends Observable implements Subject {
		@Override
		public void dosomething() {
			//TODO happen events
			super.setChanged();
			super.notifyObservers("obj");
		}
	}
	
	public static class ConcreteObserver implements Observer {
		@Override
		public void update(Observable observable, Object o){
			System.out.println(observable.toString() + ", obj: " + o.toString());
		}
	}
	
	public static void main(String[] args) {
		ConcreteObserver observer = new ConcreteObserver();
		ConcreteSubject subject = new ConcreteSubject();
		subject.addObserver(observer);
		subject.dosomething();
	}
}
```
[源代码](https://github.com/Mr-Jason-Sam/DesiginMode/tree/master/src/Observer)