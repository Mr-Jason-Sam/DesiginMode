package Singleton;

//饿汉单例模式（线程安全）
public class HungrySingleton {
	private static HungrySingleton singleton =
			new HungrySingleton();
	private HungrySingleton() {}
	public static HungrySingleton geInstance() {
		return singleton;
	}
}
