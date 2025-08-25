package ElevatorSystem;

import java.util.Comparator;
import java.util.List;

public class ExternalButtonDispatcher {
    protected List<ElevatorController> elevatorController;

    public ExternalButtonDispatcher(List<ElevatorController> elevatorController) {
        this.elevatorController = elevatorController;
    }

    // Select the best elevator (closest and idle)
    ElevatorController selectBestElevator(int floor, Direction direction) {
        return elevatorController.stream()
            .min(Comparator.comparingInt(ec -> {
                Elevator e = ec.elevator;
                int distance = Math.abs(e.getFloor() - floor);
                return (e.getStatus() == Status.IDLE) ? distance : Integer.MAX_VALUE;
            }))
            .orElse(elevatorController.get(0));
    }

    void subRequest(int floor, Direction direction) {
        ElevatorController selectedElevator = selectBestElevator(floor, direction);
        selectedElevator.subRequest(floor, direction);
    }
}