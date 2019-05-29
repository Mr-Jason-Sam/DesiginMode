package Observer;

import java.util.Observable;
import java.util.Observer;

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
