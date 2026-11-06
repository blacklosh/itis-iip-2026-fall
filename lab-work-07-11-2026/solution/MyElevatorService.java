package elevator.solution;

import elevator.api.ElevatorService;
import elevator.api.ElevatorState;
import elevator.api.InsideKeyInput;
import elevator.api.InsideKeyType;
import elevator.api.OutsideKeyDirection;
import elevator.api.OutsideKeyInput;
import elevator.impl.cmd.ElevatorCore;

public class MyElevatorService extends ElevatorService {

    private final int countOfFloors;

    private final boolean[] callsOnFloors;

    private RunningStatus currentStatus;

    public MyElevatorService(int countOfFloors) {
        this.countOfFloors = countOfFloors;
        callsOnFloors = new boolean[countOfFloors + 1];
        currentStatus = RunningStatus.WAITING;
    }

    @Override
    public void handleInsideKeyPress(InsideKeyInput info) {
        if(info.getType() == InsideKeyType.FLOOR_NUMBER) {
            callsOnFloors[info.getFloorNumber()] = true;
        }
    }

    @Override
    public void handleOutsideKeyPress(OutsideKeyInput info) {
        if(info.getDirection() == OutsideKeyDirection.CALL) {
            callsOnFloors[info.getFloor()] = true;
        }
    }

    @Override
    protected void loop() {
        ElevatorCore elevator = coreModule.getElevator(0);
        if(currentStatus == RunningStatus.WAITING) {
            for(int i = 0; i <= countOfFloors; i++) {
                boolean call = callsOnFloors[i];
                if(call) {
                    if(i > elevator.getElevatorFloor()) {
                        currentStatus = RunningStatus.MOVING_UP;
                    } else {
                        currentStatus = RunningStatus.MOVING_DOWN;
                    }
                    break;
                }
            }
        } else if(currentStatus == RunningStatus.MOVING_UP) {
            boolean flag = false;
            for(int i = elevator.getElevatorFloor(); i < countOfFloors; i++) {
                if(callsOnFloors[i]) {
                    flag = true;
                    break;
                }
            }
            if(!flag) currentStatus = RunningStatus.WAITING;

            if(elevator.getElevatorState() == ElevatorState.WAITING_CLOSED) {
                if(callsOnFloors[elevator.getElevatorFloor()]) {
                    callsOnFloors[elevator.getElevatorFloor()] = false;
                    currentStatus = RunningStatus.OPENING_DOORS;
                    elevator.openDoors();
                    return;
                }

                elevator.moveToFloor(elevator.getElevatorFloor() + 1);
            }
        } else if(currentStatus == RunningStatus.MOVING_DOWN) {
            boolean flag = false;
            for(int i = elevator.getElevatorFloor(); i >= 0; i--) {
                if(callsOnFloors[i]) {
                    flag = true;
                    break;
                }
            }
            if(!flag) currentStatus = RunningStatus.WAITING;

            if(elevator.getElevatorState() == ElevatorState.WAITING_CLOSED) {
                if (callsOnFloors[elevator.getElevatorFloor()]) {
                    callsOnFloors[elevator.getElevatorFloor()] = false;
                    currentStatus = RunningStatus.OPENING_DOORS;
                    elevator.openDoors();
                    return;
                }

                elevator.moveToFloor(elevator.getElevatorFloor() - 1);
            }
        } else if(currentStatus == RunningStatus.OPENING_DOORS) {
            if(elevator.getElevatorState() == ElevatorState.WAITING_OPENED) {
                currentStatus = RunningStatus.CLOSING_DOORS;
                elevator.closeDoors();
            }
        } else if(currentStatus == RunningStatus.CLOSING_DOORS) {
            if(elevator.getElevatorState() == ElevatorState.WAITING_CLOSED) {
                currentStatus = RunningStatus.WAITING;
            }
        }
    }

    private enum RunningStatus {
        OPENING_DOORS,
        CLOSING_DOORS,
        WAITING,
        MOVING_DOWN,
        MOVING_UP
    }
}
