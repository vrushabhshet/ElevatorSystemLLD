package ElevatorSystem;

import java.util.List;

public class LookDispatcher extends ExternalButtonDispatcher {
    public LookDispatcher(List<ElevatorController> elevatorController) {
        super(elevatorController);
    }

    @Override
    void subRequest(int floor, Direction direction) {
        ElevatorController selected = null;
        for (ElevatorController ec : super.elevatorController) {
            if (ec.elevator.getDirection() == direction && ec.elevator.getStatus() == Status.MOVING) {
                selected = ec;
                break;
            }
        }
        if (selected == null) {
            selected = selectBestElevator(floor, direction);
        }
        selected.subRequest(floor, direction);
        System.out.println("LookDispatcher: Assigned request to elevator " + selected.elevator.getId());
    }
}