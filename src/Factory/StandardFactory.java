package Factory;

public class StandardFactory {
	public static abstract class Produce {
		public abstract void dosomething();
	}
	
	public static class ConcreteProduceA extends Produce {
		@Override
		public void dosomething() {
			System.out.println("I am ProduceA!");
		}
	}
	
	public static class ConcreteProduceB extends Produce {
		@Override
		public void dosomething() {
			System.out.println("I am ProduceB!");
		}
	}
	
	public static abstract class Creator {
		public abstract <T extends Produce>T createProduce(Class<T> c);
	}
	
	public static class ConcreteCreator extends Creator {
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
	
	public static void main(String[] args) {
		Creator creator = new ConcreteCreator();
		Produce A = creator.createProduce(ConcreteProduceA.class);
		A.dosomething();
		Produce B = creator.createProduce(ConcreteProduceB.class);
		B.dosomething();
	}
	
}
