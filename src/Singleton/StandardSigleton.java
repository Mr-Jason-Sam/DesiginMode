package Singleton;

//标准单例模式
public class StandardSigleton {
	private static StandardSigleton singleton;
	private StandardSigleton() {}
	public static StandardSigleton getInstance() {
		if (singleton == null) {
			singleton = new StandardSigleton();
		}
		return singleton;
	}
}
