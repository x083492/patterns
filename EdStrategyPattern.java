package patterns;

public class EdStrategyPattern {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestStrategyPattern aT = new TestStrategyPattern();
		aT.testSP();
	}
}

class TestStrategyPattern {

	public  void testSP() {

		Robot r1 = new Robot("Big Robot");
		Robot r2 = new Robot("Cool Robot");
		Robot r3 = new Robot("Rover Robot");

		System.out.println("\r\nNew actions: ");

		r1.setAction(new AgressiveAction());
		r2.setAction(new DefensiveAction());
		r3.setAction(new NormalAction());

		r1.move();
		r2.move();
		r3.move();

		System.out.println("\r\nNew actions: ");

		r1.setAction(new DefensiveAction());
		r2.setAction(new AgressiveAction());

		r1.move();
		r2.move();
		r3.move();
	}
}
interface Action {
	public int moveCommand();
}

class AgressiveAction implements Action{
	public int moveCommand()
	{
		System.out.print(" Agressive Action: if you find another robot attack it");
		return 1;
	}
}

class DefensiveAction implements Action{
	public int moveCommand()
	{
		System.out.print(" Defensive Action: if you find another robot run from it");
		return -1;
	}
}

class NormalAction implements Action{
	public int moveCommand()
	{
		System.out.print(" Normal Action: if you find another robot ignore it");
		return 0;
	}
}

class Robot {
	Action action;
	String name;

	public Robot(String name)
	{
		this.name = name;
	}

	public void setAction(Action action)
	{
		this.action = action;
	}

	public Action getAction()
	{
		return action;
	}

	public void move()
	{
		System.out.println("\n" + this.name + "'s move:");
		action.moveCommand();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}


