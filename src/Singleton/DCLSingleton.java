package Singleton;

//双重锁懒汉模式（Double Check Lock）
public class DCLSingleton {
	private volatile static DCLSingleton singleton = null;
	private DCLSingleton() {};
	private static DCLSingleton getInstance() {
		if (singleton == null) {
			synchronized (DCLSingleton.class) {
				if (singleton == null) {
					singleton = new DCLSingleton();
				}
			}
		}
		return singleton;
	}
}
