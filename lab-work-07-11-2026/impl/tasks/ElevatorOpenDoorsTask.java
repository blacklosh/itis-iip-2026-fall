package elevator.impl.tasks;

import elevator.api.ElevatorState;
import elevator.impl.model.Elevator;

public class ElevatorOpenDoorsTask extends Thread {

    private final Elevator elevator;

    public ElevatorOpenDoorsTask(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++) {
            if(!ElevatorState.DOORS_OPENING.equals(elevator.getElevatorState())) {
                return;
            }
            elevator.setDoorsPosition(i);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        elevator.setDoorsPosition(100);
        elevator.setState(ElevatorState.WAITING_OPENED);
    }
}