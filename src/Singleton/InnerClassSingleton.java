package Singleton;

//静态内部类单例模式
public class InnerClassSingleton {
	 private InnerClassSingleton() {}
	 private static class SingletonHoler {
		 private static final InnerClassSingleton INSTANCE =
				 new InnerClassSingleton();
	 }
	 public static InnerClassSingleton getInstance() {
		 return SingletonHoler.INSTANCE;
	 }
}
