package ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String args[]) {

		List<Floor> floorList = new ArrayList<>();
		Floor floor1 = new Floor(1);
		Floor floor2 = new Floor(2);
		Floor floor3 = new Floor(3);
		Floor floor4 = new Floor(4);
		Floor floor5 = new Floor(5);
		floorList.add(floor1);
		floorList.add(floor2);
		floorList.add(floor3);
		floorList.add(floor4);
		floorList.add(floor5);

		new Building(floorList);

		List<ElevatorController> elevatorControllerList = new ArrayList<>();

		Elevator elevator1 = new Elevator();
		elevator1.id = 1;
		ElevatorController controller1 = new ElevatorController(elevator1);
		elevator1.setInternalButton(new InternalButton(controller1));

		Elevator elevator2 = new Elevator();
		elevator2.id = 2;
		ElevatorController controller2 = new ElevatorController(elevator2);
		elevator2.setInternalButton(new InternalButton(controller2));

		elevatorControllerList.add(controller1);
		elevatorControllerList.add(controller2);

		LookDispatcher dispatcher = new LookDispatcher(elevatorControllerList);
		// Assign dispatcher to each floor's external button
		for (Floor floor : floorList) {
			floor.externalButton = new ExternalButton();
			floor.externalButton.setDispatcher(dispatcher);
		}

		// Simulate external requests
		System.out.println("Simulating external requests:");
		floor1.pressExternalButton(Direction.UP); // Request from floor 1 to go UP
		floor5.pressExternalButton(Direction.DOWN); // Request from floor 5 to go DOWN

		// Simulate internal requests
		System.out.println("Simulating internal requests:");
		elevator1.getInternalButton().pressButton(3, Direction.UP); // Inside elevator 1, go to floor 3
		elevator2.getInternalButton().pressButton(2, Direction.DOWN); // Inside elevator 2, go to floor 2

	}
}