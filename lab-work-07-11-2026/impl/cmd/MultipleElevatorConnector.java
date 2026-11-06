package elevator.impl.cmd;

import elevator.impl.model.Elevator;

import java.util.ArrayList;
import java.util.List;

public class MultipleElevatorConnector implements ElevatorsConnector {

    private final List<Elevator> elevators;

    public MultipleElevatorConnector(List<Elevator> elevatorList) {
        elevators = new ArrayList<>(elevatorList);
    }

    @Override
    public int getNumberOfElevators() {
        return elevators.size();
    }

    @Override
    public ElevatorCore getElevator(int number) {
        return elevators.get(number);
    }
}
