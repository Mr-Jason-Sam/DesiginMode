#适配器模式
* 定义：将一个类的接口变换成客户端所期待的另一种接口，从而使原本因接口不匹配而无法一起工作的两个类能够一起工作。
* UML类图：![适配器模式](https://upload-images.jianshu.io/upload_images/1933808-874562eb690fa03b.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

* 综合分析：

	**优点：**
 	
 	1. 让两个毫不相干的类组合成想要的类。
	2. 增加类间透明度。源对象和目标对象的封装通过中间实现类完美诠释。
	3. 提高类的复用度，减少不必要的重写。
	4. 灵活性高。用则调，不用则弃。

	**适用场景：**
	
	适配器模式是一个补救措施，而不是开发阶段的产物，所以一般都是投产后的产品的一个功能补充，BUG修复等情况下使用。

* 拓展：![ExpendUML.png](https://upload-images.jianshu.io/upload_images/1933808-f8602b99bdd72dc1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
	适配器模式仅可以通过继承/实现的方式进行拓展，也可以通过关联，组装适配类。

###适配器模式实践
####源接口
```
	public static interface IAdaptee {
		public void origin();
	}
```
####目标接口
```
	public static interface ITarget {
		public void expend();
	}
```
####适配器角色
```
	public static class Adapter implements IAdaptee, ITarget{
		@Override
		public void expend() {
			System.out.println("I am a target!");
		}
		
		@Override
		public void origin() {
			System.out.println("I am a adaptee!");
			expend();
		}
	}
```
####客户端类
```
public class client {
	public static void main(String[] args) {
		IAdaptee adaptee = new concreteAdaptee();
		adaptee.origin();
		Adapter adapter = new Adapter();
		adapter.origin();
	}
}
```

[源代码](https://github.com/Mr-Jason-Sam/DesiginMode/tree/master/src/Adapter)