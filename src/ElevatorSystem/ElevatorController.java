package ElevatorSystem;

import java.util.LinkedList;
import java.util.Queue;

public class ElevatorController {
	Elevator elevator;
	private Queue<Request> internalRequests = new LinkedList<>();
	private Queue<Request> externalRequests = new LinkedList<>();

	public ElevatorController(Elevator elevator1) {
		this.elevator = elevator1;
	}

	void subRequest(int floor, Direction direction) {
		elevator.move(floor, direction);
	}

	public void addInternalRequest(int floor, Direction direction) {
		internalRequests.add(new Request(floor, direction));
		processInternalRequests();
	}

	public void addExternalRequest(int floor, Direction direction) {
		externalRequests.add(new Request(floor, direction));
		processExternalRequests();
	}

	private void processInternalRequests() {
		if (!internalRequests.isEmpty() && elevator.getStatus() != Status.MOVING) {
			Request req = internalRequests.poll();
			elevator.move(req.floor, req.direction);
		}
	}

	private void processExternalRequests() {
		if (!externalRequests.isEmpty() && elevator.getStatus() != Status.MOVING) {
			Request req = externalRequests.poll();
			elevator.move(req.floor, req.direction);
		}
	}

	private static class Request {
		int floor;
		Direction direction;

		Request(int floor, Direction direction) {
			this.floor = floor;
			this.direction = direction;
		}
	}
}