package ElevatorSystem;

public class ExternalButton {
	private ExternalButtonDispatcher externalButtonDispatcher;
	
	void pressButton(int floor, Direction direction) {
		externalButtonDispatcher.subRequest(floor, direction);
	}

	public void setDispatcher(ExternalButtonDispatcher dispatcher) {
	    this.externalButtonDispatcher = dispatcher;
	}
}