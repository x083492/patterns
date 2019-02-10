package patterns;

public class EdSingleton {
	public enum SingletonEnum {
		SINGLETON_ENUM;
	}
	public static void main(String[] args) {
		SingletonClass eS1 = SingletonClass.getInstance();
		System.out.println(eS1); 
		eS1 = SingletonClass.getInstance();
		System.out.println(eS1); 

		SingletonStaticBlockClass eS2 = SingletonStaticBlockClass.getInstance();
		System.out.println(eS2); 
		eS2 = SingletonStaticBlockClass.getInstance();
		System.out.println(eS2); 

		LazySingletonStaticBlockClass eS3 = LazySingletonStaticBlockClass.getInstance();
		System.out.println(eS3); 
		eS3 = LazySingletonStaticBlockClass.getInstance();
		System.out.println(eS3); 
		
		SafeLazySingletonStaticBlockClass eS4 = SafeLazySingletonStaticBlockClass.getInstance();
		System.out.println(eS4); 
		eS4 = SafeLazySingletonStaticBlockClass.getInstance();
		System.out.println(eS4); 
		
		FastSafeLazySingletonStaticBlockClass eS5 = FastSafeLazySingletonStaticBlockClass.getInstance();
		System.out.println(eS5); 
		eS5 = FastSafeLazySingletonStaticBlockClass.getInstance();
		System.out.println(eS5); 

		
		System.out.println(SingletonEnum.SINGLETON_ENUM.ordinal()); 
		System.out.println(SingletonEnum.SINGLETON_ENUM.toString()); 
		
		ReallySingleton rs = ReallySingleton.getInstance();
		System.out.println(rs); 
		rs = ReallySingleton.getInstance();
		System.out.println(rs); 
		rs = ReallySingleton.getInstance();
		System.out.println(rs); 
		
		System.out.println(ReallySingleton.getInstance().hiMe());
		
	}	
}

 class SingletonClass {
		private int qty = 0;
		private SingletonClass() {}
		private static final SingletonClass INSTANCE = new SingletonClass();
		public static SingletonClass getInstance() {
			return INSTANCE;
		}
 }		

class SingletonStaticBlockClass {
		private int qty = 0;
		private SingletonStaticBlockClass() {}
		private static final SingletonStaticBlockClass INSTANCE;
		static {
			INSTANCE = new SingletonStaticBlockClass();
			//other steps can be added here
		}
		public static SingletonStaticBlockClass getInstance() {
			return INSTANCE;
		}
	
}

class LazySingletonStaticBlockClass {
	private int qty = 0;
	private LazySingletonStaticBlockClass() {}
	private static LazySingletonStaticBlockClass INSTANCE;
	static {
		if (INSTANCE == null) {
			INSTANCE = new LazySingletonStaticBlockClass();
			//other steps can be added here
		}	
	}
	public static LazySingletonStaticBlockClass getInstance() {
		return INSTANCE;
	}

}

class SafeLazySingletonStaticBlockClass {
	private int qty = 0;
	private SafeLazySingletonStaticBlockClass() {}
	private static SafeLazySingletonStaticBlockClass INSTANCE;
	static {
		if (INSTANCE == null) {
			INSTANCE = new SafeLazySingletonStaticBlockClass();
			//other steps can be added here
		}	
	}
	public static synchronized SafeLazySingletonStaticBlockClass getInstance() {
		return INSTANCE;
	}

}

class FastSafeLazySingletonStaticBlockClass {
	private FastSafeLazySingletonStaticBlockClass() {}
	private static volatile FastSafeLazySingletonStaticBlockClass INSTANCE;
	static {
		if (INSTANCE == null) {
			synchronized(FastSafeLazySingletonStaticBlockClass.class) { 
				if (INSTANCE == null) {
					INSTANCE = new FastSafeLazySingletonStaticBlockClass();
					//other steps can be added here					
				}
			}
		}
	}
	public static synchronized FastSafeLazySingletonStaticBlockClass getInstance() {
		return INSTANCE;
	}

}

class ReallySingleton {
	private int qty = 0;
	private ReallySingleton() {}
	private static final ReallySingleton INSTANCE = new ReallySingleton();
	public static ReallySingleton getInstance() {
		return INSTANCE;
	}
	public String hiMe() {
		return "HiMe";
	}

}
