package Adapter;

public class AdapterPattern {
	public static interface IAdaptee {
		public void origin();
	}
	
	public static class concreteAdaptee implements IAdaptee {
		@Override
		public void origin() {
			System.out.println("I am a concreteAdaptee!");
		}
	}
	
	public static interface ITarget {
		public void expend();
	}
	
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
	
	public static class Adapter2 extends concreteAdaptee implements ITarget{
		@Override
		public void origin() {
			super.origin();
			System.out.println("I am a adaptee!");
		}
		
		@Override
		public void expend() {
			System.out.println("I am a target!");
		}
	}
	
	public static void main(String[] args) {
//		IAdaptee adaptee = new concreteAdaptee();
//		adaptee.origin();
//		Adapter adapter = new Adapter();
//		adapter.origin();
		
		Adapter2 adapter2 = new Adapter2();
		adapter2.origin();
		adapter2.expend();
	}
}
