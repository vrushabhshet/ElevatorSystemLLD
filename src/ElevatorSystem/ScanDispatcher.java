package ElevatorSystem;

import java.util.List;
import java.util.Random;

public class ScanDispatcher extends ExternalButtonDispatcher {
    public ScanDispatcher(List<ElevatorController> elevatorController) {
        super(elevatorController);
    }

    @Override
    void subRequest(int floor, Direction direction) {
        // Simulate least busy by random selection for demonstration
        int index = new Random().nextInt(super.elevatorController.size());
        ElevatorController selectedElevator = super.elevatorController.get(index);
        selectedElevator.subRequest(floor, direction);
        System.out.println("ScanDispatcher: Assigned request to elevator " + selectedElevator.elevator.getId());
    }
}