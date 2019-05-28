package Factory;

public class SimpleFactory {
	public interface Produce {
		public void dosomething();
	}
	
	public static class ConcreteProduceA implements Produce {
		@Override
		public void dosomething() {
			System.out.println("I am ProduceA!");
		}
	}
	
	public static class ConcreteProduceB implements Produce {
		@Override
		public void dosomething() {
			System.out.println("I am ProduceB!");
		}
	}
	
	
	public static class Creator {
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
		Creator creator = new Creator();
		Produce A = creator.createProduce(ConcreteProduceA.class);
		A.dosomething();
		Produce B = creator.createProduce(ConcreteProduceB.class);
		B.dosomething();
	}
}
