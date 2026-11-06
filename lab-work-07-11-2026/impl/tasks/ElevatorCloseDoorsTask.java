package elevator.impl.tasks;

import elevator.api.ElevatorState;
import elevator.impl.model.Elevator;

public class ElevatorCloseDoorsTask extends Thread {

    private final Elevator elevator;

    public ElevatorCloseDoorsTask(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void run() {
        for(int i = 100; i > 0; i--) {
            if(!ElevatorState.DOORS_CLOSING.equals(elevator.getElevatorState())) {
                return;
            }
            elevator.setDoorsPosition(i);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        elevator.setDoorsPosition(0);
        elevator.setState(ElevatorState.WAITING_CLOSED);
    }
}