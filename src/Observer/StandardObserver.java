package Observer;

import java.util.Vector;

public class StandardObserver {
	 public interface IObserver {
		 //条件触发后需要作出的处理
		 public void update();
	 }
	 
	 public static abstract class Subject {
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
	 
	 public static class ConcreteSubject extends Subject {
		 public void dosomething() {
			 //TODO happen events
			 super.notifyObservers();
		 }
	 }
	 
	 public static class ConcreteObserver implements IObserver {
		 @Override
		 public void update() {
			 System.out.println("happen change, handle info!");
		 }
	 }
	 
	 public static void main(String[] args) {
		IObserver observerA = new ConcreteObserver();
		ConcreteSubject subjectA = new ConcreteSubject();
		subjectA.addObserver(observerA);
		subjectA.dosomething();
	}
}
