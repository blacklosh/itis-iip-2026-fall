package elevator.impl.model;

import elevator.api.ElevatorState;
import elevator.impl.cmd.ElevatorApplicationStarter;
import elevator.impl.cmd.ElevatorCore;
import elevator.impl.tasks.ElevatorCloseDoorsTask;
import elevator.impl.tasks.ElevatorMovingTask;
import elevator.impl.tasks.ElevatorOpenDoorsTask;
import elevator.impl.tasks.MovingDirection;

import java.util.Objects;

import static elevator.api.ElevatorState.*;

public class Elevator implements ElevatorCore {

    private int currentFloor;

    private ElevatorState state;

    private int doorsPosition;

    private int positionBetweenFloors;

    private boolean ac;

    private String displayLine;

    private final ElevatorApplicationStarter starter;

    private final String name;

    public Elevator(ElevatorApplicationStarter starter, int currentFloor, ElevatorState state, int doorsPosition, int positionBetweenFloors, String name) {
        this.currentFloor = currentFloor;
        this.state = state;
        this.doorsPosition = doorsPosition;
        this.positionBetweenFloors = positionBetweenFloors;
        this.starter = starter;
        this.name = name;
    }

    @Override
    public ElevatorState getElevatorState() {
        return state;
    }

    @Override
    public int getElevatorFloor() {
        return currentFloor;
    }

    @Override
    public void openDoors() {
        if(!WAITING_CLOSED.equals(state)) {
            error("[DOORS]: Tried to open doors with incorrect state: " + state.name());
            return;
        }

        state = DOORS_OPENING;
        new ElevatorOpenDoorsTask(this).start();
    }

    @Override
    public void closeDoors() {
        if(!WAITING_OPENED.equals(state)) {
            error("[DOORS]: Tried to close doors with incorrect state: " + state.name());
            return;
        }

        state = DOORS_CLOSING;
        new ElevatorCloseDoorsTask(this).start();
    }

    @Override
    public void moveToFloor(int floor) {
        if(floor < 0) {
            error("[MOVING]: Tried to move to negative floor (provided " + floor + ").");
            return;
        }

        if(floor > starter.getCountOfFloors()) {
            error("[MOVING]: Tried to move to floor that exceeds the limit (provided " + floor + ", allowed " + starter.getCountOfFloors() + ").");
            return;
        }

        if(!WAITING_CLOSED.equals(state)) {
            error("[Moving]: Tried to move with incorrect state: " + state.name());
            return;
        }

        if(floor == currentFloor) {
            warn("[Moving]: Tried to move to floor that already reached.");
            return;
        }

        MovingDirection direction;

        if(floor > currentFloor) {
            state = MOVING_UP;
            direction = MovingDirection.UP;
        } else {
            state = MOVING_DOWN;
            direction = MovingDirection.DOWN;
        }
        new ElevatorMovingTask(this, floor, direction).start();
    }

    @Override
    public void setAirConditioningEnabled(boolean enabled) {
        info("[AC]: " + (enabled ? "enabled" : "disabled"));
        ac = enabled;
    }

    @Override
    public void setStringOnDisplay(String line) {
        if(Objects.isNull(line)) {
            warn("[Display]: Cannot show null string!");
            return;
        }

        if(line.isEmpty()) {
            warn("[Display]: Cannot show empty string!");
            return;
        }

        if(line.length() > starter.getDisplayLength()) {
            warn("[Display]: Line '" + line + "' longer than allowed");
        }

        displayLine = line;
    }

    private void info(String msg) {
        System.out.println(name + " INFO " + msg);
    }

    private void warn(String msg) {
        System.err.println(name + " WARNING " + msg);
    }

    private void error(String msg) {
        System.err.println(name + " ERROR " + msg);
        state = BROKEN;
        starter.stopSimulation();
    }

    public int getDoorsPosition() {
        return doorsPosition;
    }

    public int getPositionBetweenFloors() {
        return positionBetweenFloors;
    }

    public boolean isAc() {
        return ac;
    }

    public String getDisplayLine() {
        return displayLine;
    }

    public String getName() {
        return name;
    }

    public void setDoorsPosition(int doorsPosition) {
        this.doorsPosition = doorsPosition;
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

    public void setPositionBetweenFloors(int positionBetweenFloors) {
        this.positionBetweenFloors = positionBetweenFloors;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
}
