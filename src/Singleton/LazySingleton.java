package Singleton;

//懒汉单例（线程安全）
public class LazySingleton {
	private static LazySingleton singleton;
	private LazySingleton(){}
	private static synchronized LazySingleton getInstance() {
		if (singleton == null) {
			singleton = new LazySingleton();
		}
		return singleton;
	}
}
