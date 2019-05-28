package Factory;

public class AbstractFactory {
	public static abstract class Produce1 {
		public abstract void dosomething();
	}
	
	public static class ConcreteProduceA1 extends Produce1 {
		@Override
		public void dosomething() {
			System.out.println("I am ProduceA1!");
		}
	}
	
	public static class ConcreteProduceB1 extends Produce1 {
		@Override
		public void dosomething() {
			System.out.println("I am ProduceB1!");
		}
	}
	
	public static abstract class Produce2 {
		public abstract void dosomething();
	}
	
	public static class ConcreteProduceA2 extends Produce2 {
		@Override
		public void dosomething() {
			System.out.println("I am ProduceA2!");
		}
	}
	
	public static class ConcreteProduceB2 extends Produce2 {
		@Override
		public void dosomething() {
			System.out.println("I am ProduceB2!");
		}
	}
	
	public static abstract class Creator {
		public abstract Produce1 createProduce1();
		public abstract Produce2 createProduce2();
	}
	
	public static class ConcreteCreatorA extends Creator {
		@Override
		public Produce1 createProduce1(){
			return new ConcreteProduceA1();
		}
		
		@Override
		public Produce2 createProduce2() {
			return new ConcreteProduceA2();
		}
	}
	
	public static class ConcreteCreatorB extends Creator {
		@Override
		public Produce1 createProduce1(){
			return new ConcreteProduceB1();
		}
		
		@Override
		public Produce2 createProduce2() {
			return new ConcreteProduceB2();
		}
	}
	
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
