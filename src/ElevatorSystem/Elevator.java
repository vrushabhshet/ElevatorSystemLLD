package ElevatorSystem;

public class Elevator {
	int id;
	int floor;
	Direction direction;
	Status status;
	InternalButton internalButton;

	public Elevator() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public InternalButton getInternalButton() {
		return internalButton;
	}

	public void setInternalButton(InternalButton internalButton) {
		this.internalButton = internalButton;
	}

	// Move the elevator to the requested floor and direction
	public void move(int targetFloor, Direction direction) {
		System.out.println("Elevator " + id + " moving from floor " + floor + " to floor " + targetFloor + " in direction " + direction);
		this.direction = direction;
		this.status = Status.MOVING;
		// Simulate movement
		this.floor = targetFloor;
		this.status = Status.IDLE;
		System.out.println("Elevator " + id + " arrived at floor " + floor);
	}

}