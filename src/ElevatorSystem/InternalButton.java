package ElevatorSystem;

public class InternalButton {
	private ElevatorController controller;

	public InternalButton(ElevatorController controller) {
	    this.controller = controller;
	}

	void pressButton(int floor, Direction direction) {
	    controller.subRequest(floor, direction);
	}
}