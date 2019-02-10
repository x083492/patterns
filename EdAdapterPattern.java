package patterns;

public class EdAdapterPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdapterTester aT = new AdapterTester();
		aT.testDuckAdapter();
		aT.testTurkeyAdapter();
	}

}

class AdapterTester {
	void testTurkeyAdapter () {
		Turkey turkey = new WildTurkey();
		Duck turkeyAsDuck = new TurkeyAdapter(turkey);
		turkeyAsDuck.quack();
		turkeyAsDuck.fly();
	}

	void testDuckAdapter () {
		Duck duck = new Mallard();
		Turkey duckAsTurkey = new DuckAdapter(duck);
		duckAsTurkey.gobble();
		duckAsTurkey.fly();
	}


interface Duck {
	public void quack();
	public void fly();
}
interface Turkey {
	public void gobble();
	public void  fly();
}

class Mallard implements Duck {
	public void quack() {
		System.out.println("I am a mallard");
	}
	public void fly() {
		System.out.println("I am a flying mallard");
	}

}

class WildTurkey implements Turkey {
	public void gobble() {
		System.out.println("I am a wild turkey");
	}
	public void fly() {
		System.out.println("I am a flying turkey");
	}

}

class TurkeyAdapter implements Duck {
	Turkey turkey;

	public TurkeyAdapter (Turkey turkey) {
		this.turkey = turkey;
	}

	public void quack() {
		turkey.gobble();
	}

	public void fly() {
		turkey.fly();
	}
}

class DuckAdapter implements Turkey {
	Duck duck;

	public DuckAdapter (Duck duck) {
		this.duck = duck;
	}

	public void gobble() {
		duck.quack();
	}

	public void fly() {
		duck.fly();
	}
}

}

