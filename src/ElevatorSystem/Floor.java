package ElevatorSystem;

public class Floor {
	private int floorNumber;
	ExternalButton externalButton;
	
	public Floor(int i) {
		this.floorNumber = i;
		this.externalButton = new ExternalButton();
		}

	void pressExternalButton(Direction direction) {
		externalButton.pressButton(floorNumber, direction);
	}

}
