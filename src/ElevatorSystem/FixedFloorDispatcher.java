package ElevatorSystem;

import java.util.List;

public class FixedFloorDispatcher extends ExternalButtonDispatcher {
    private int fixedElevatorIndex = 0; // Always assign to the first elevator

    public FixedFloorDispatcher(List<ElevatorController> elevatorController) {
        super(elevatorController);
    }

    @Override
    void subRequest(int floor, Direction direction) {
        ElevatorController selectedElevator = super.elevatorController.get(fixedElevatorIndex);
        selectedElevator.subRequest(floor, direction);
        System.out.println("FixedFloorDispatcher: Assigned request to elevator " + selectedElevator.elevator.getId());
    }
}