package patterns;

public class EdStatePattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlarmTest al = new AlarmTest();
		al.testHouseAlarm();
	}

}

class AlarmTest {
	void testHouseAlarm () {
		HouseAlarm ha = new HouseAlarm();
		ha.setState(new DoorOpenState(ha));
		ha.openDoor();
		ha.setState(new DoorClosedState(ha));
		ha.setAlarm(true);
		ha.openDoor();
		ha.setAlarm(false);
		ha.openDoor();
	}
	
}

class HouseAlarm {
	
	boolean alarmed;	
	State doorOpenState;
	State doorClosedState;
	State currentState;

	public HouseAlarm() {
		doorOpenState = new DoorOpenState(this);
		doorClosedState = new DoorClosedState(this);
		currentState = doorOpenState;
	}
	
	public void openDoor() {
		currentState.openDoor();
	}
	public void closeDoor() {
		currentState.closeDoor();
	}
	public State getDoorOpenState() {
		return doorOpenState;
	}

	public State getDoorClosedState() {
		return doorClosedState;
	}

	public State getCurrentState() {
		return currentState;
	}
	public boolean isAlarmed() {
		return alarmed;
	}

	public void setAlarm(boolean alarmed) {
		this.alarmed = alarmed;
	}


	public void setState(State state) {
		this.currentState = state;
	}

	
}

interface State {
	public void openDoor();
	public void closeDoor();
}

class DoorOpenState implements State {
	HouseAlarm houseAlarm; 
	
	public DoorOpenState(HouseAlarm ha) {
		this.houseAlarm = ha;
	}
	public void closeDoor() {
		System.out.println("Closing door...");			
		houseAlarm.setState(houseAlarm.getDoorClosedState());
		
	}
	public void openDoor() {
		System.out.println("Door already open...");
	}	
}

class DoorClosedState implements State {
	HouseAlarm houseAlarm; 
	
	public DoorClosedState(HouseAlarm ha) {
		this.houseAlarm = ha;
	}
	public void openDoor() {
		System.out.println("Opening door!");
		if (houseAlarm.isAlarmed()) {
			System.out.println("Cannot open door. Alarm is on...");
		} else {
			houseAlarm.setState(houseAlarm.getDoorOpenState());			
		}
	}
	public void closeDoor() {
		System.out.println("Door already closed...");
		houseAlarm.closeDoor();
	}
}
