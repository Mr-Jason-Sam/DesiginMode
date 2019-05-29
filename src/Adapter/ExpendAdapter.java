package Adapter;

public class ExpendAdapter {
	public static interface IAdaptee {
		public void origin();
	}
	
	public static class concreteAdaptee implements IAdaptee {
		@Override
		public void origin() {
			System.out.println("I am a concreteAdaptee!");
		}
	}
	
	public static interface ITargetA {
		public void expendA();
	}
	
	public static interface ITargetB {
		public void expendB();
	}
	
	public static class ConcreteTargetA implements ITargetA {
		public void expendA() {
			System.out.println("I am a concreteTargetA!");
		}
	}
	
	public static class ConcreteTargetB implements ITargetB {
		public void expendB() {
			System.out.println("I am a concreteTargetB!");
		}
	}
	
	public static class Adapter implements IAdaptee {
		private ITargetA targetA = null;
		private ITargetB targetB = null;
		
		public Adapter(ITargetA targetA, ITargetB targetB) {
			this.targetA = targetA;
			this.targetB = targetB;
		}
		
		public void dosomething() {
			System.out.println("I am a Adapter!");
		}
		
		@Override
		public void origin() {
			targetA.expendA();
			targetB.expendB();
			dosomething();
		}
	}
	 public static void main(String[] args) {
		IAdaptee adaptee = new concreteAdaptee();
		adaptee.origin();
		Adapter adapter =
				new Adapter(new ConcreteTargetA(), new ConcreteTargetB());
		adapter.origin();
	}
	
}
