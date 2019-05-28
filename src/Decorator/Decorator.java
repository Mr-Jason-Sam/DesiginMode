package Decorator;

public class Decorator {
	public static abstract class Component{
		public abstract void operate();
	}
	
	public static class ConcreteComponent extends Component {
		@Override
		public void operate() {
			System.out.println("I am a Component!");
		}
	}
	
	public static abstract class AbstractDecorator extends Component {
		public Component component = null;
		public AbstractDecorator(Component c) {
			component = c;
		}
		@Override
		public abstract void operate();
	}
	
	public static class ConcreteDecoratorA extends AbstractDecorator {
		public ConcreteDecoratorA(Component c) {
			super(c);
		}
		@Override
		public void operate() {
			component.operate();
			System.out.println("Add DecoratorA");
		}
	}
	
	public static class ConcreteDecoratorB extends AbstractDecorator {
		public ConcreteDecoratorB(Component c) {
			super(c);
		}
		@Override
		public void operate() {
			System.out.println("Add DecoratorB");
			component.operate();
		}
	}
	
	public static void main(String[] args) {
		Component component = new ConcreteComponent();
		component = new ConcreteDecoratorA(component);
		component.operate();
		component = new ConcreteDecoratorB(component);
		component.operate();
	}
}
