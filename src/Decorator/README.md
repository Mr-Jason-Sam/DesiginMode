#装饰者模式
* 定义：动态地给一个对象添加一些额外的职责就增加功能来说，装饰模式相比生成子类更为灵活。
* UML类图：![装饰者模式](https://upload-images.jianshu.io/upload_images/1933808-4ee067d26f78f16d.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* 综合分析：

	**优点：**
 	
 	1. 装饰者和被装饰者相互解藕。
	2. 继承的替换方案，更灵活地实现“继承”特性。
	3. 动态的扩展功能类，完全符合“开闭原则”。

	**缺点：**
	
	1. 多层装饰，会造成代码复杂性。

	**适用场景：**
	
	1. 扩展一个类的功能。
	2. 功能的多变性，随时动态增加功能。
	3. 为一批兄弟类进行改装，首选装饰者模式。

* 总结：装饰者模式的关键在于Component的operate()方法，整个模式都是以该方法展开装饰。思想需要大家去琢磨和体会，加油！

###装饰者模式实践
####组建抽象类
```
	public abstract class Component{
		public abstract void operate();
	}
```
####被装饰类
```
	public class ConcreteComponent extends Component {
		@Override
		public void operate() {
			System.out.println("I am a Component!");
		}
	}
```
####装饰类组
```
	public abstract class AbstractDecorator extends Component {
		public Component component = null;
		public AbstractDecorator(Component c) {
			component = c;
		}
		@Override
		public abstract void operate();
	}
	
	public class ConcreteDecoratorA extends AbstractDecorator {
		public ConcreteDecoratorA(Component c) {
			super(c);
		}
		@Override
		public void operate() {
			component.operate();
			System.out.println("Add DecoratorA");
		}
	}
	
	public class ConcreteDecoratorB extends AbstractDecorator {
		public ConcreteDecoratorB(Component c) {
			super(c);
		}
		@Override
		public void operate() {
			System.out.println("Add DecoratorB");
			component.operate();
		}
	}
```
####客户端类
```
public class client {
	public static void main(String[] args) {
		Component component = new ConcreteComponent();
		component = new ConcreteDecoratorA(component);
		component.operate();
		component = new ConcreteDecoratorB(component);
		component.operate();
	}
}
```

[源代码](https://github.com/Mr-Jason-Sam/DesiginMode/tree/master/src/Decorator)