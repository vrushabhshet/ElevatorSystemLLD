package ElevatorSystem;

import java.util.List;

public class OddEvenDispatcher extends ExternalButtonDispatcher {
    public OddEvenDispatcher(List<ElevatorController> elevatorController) {
        super(elevatorController);
    }

    @Override
    void subRequest(int floor, Direction direction) {
        int index = (floor % 2 == 0) ? 0 : 1;
        if (index >= super.elevatorController.size()) {
            index = 0; // fallback if not enough elevators
        }
        ElevatorController selectedElevator = super.elevatorController.get(index);
        selectedElevator.subRequest(floor, direction);
        System.out.println("OddEvenDispatcher: Assigned request to elevator " + selectedElevator.elevator.getId());
    }
}