package elevator.impl.tasks;

import elevator.api.ElevatorState;
import elevator.impl.model.Elevator;

import static elevator.api.ElevatorState.*;
import static elevator.impl.tasks.MovingDirection.*;

public class ElevatorMovingTask extends Thread {

    private final Elevator elevator;

    private final int targetFloor;

    private final MovingDirection direction;

    public ElevatorMovingTask(Elevator elevator, int targetFloor, MovingDirection direction) {
        this.elevator = elevator;
        this.targetFloor = targetFloor;
        this.direction = direction;
    }

    @Override
    public void run() {
        System.out.println("running to " + targetFloor);
        while (elevator.getElevatorFloor() != targetFloor) {
            if(!(MOVING_UP.equals(elevator.getElevatorState()) && UP.equals(direction) ||
                    (MOVING_DOWN.equals(elevator.getElevatorState()) && DOWN.equals(direction)))) {
                System.out.println("exiting");
                return;
            }

            int pos = elevator.getPositionBetweenFloors() + 1;
            int floor = elevator.getElevatorFloor();
            if(pos >= 100) {
                pos = 0;
                if(UP.equals(direction)) {
                    elevator.setCurrentFloor(floor + 1);
                } else {
                    elevator.setCurrentFloor(floor - 1);
                }
            }
            elevator.setPositionBetweenFloors(pos);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        elevator.setState(ElevatorState.WAITING_CLOSED);
    }
}