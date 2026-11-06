package elevator.impl.cmd;

import elevator.api.ElevatorService;
import elevator.api.ElevatorState;
import elevator.impl.model.Elevator;
import elevator.impl.params.ApplicationParameters;
import elevator.impl.window.ElevatorApplicationFrame;
import elevator.impl.window.ElevatorApplicationPanel;

import java.util.ArrayList;
import java.util.List;

public class ElevatorApplicationStarterWithGraphicSimulation implements ElevatorApplicationStarter {

    private final int countOfFloors;

    private final int countOfElevators;

    private final boolean useSimpleButtons;

    private final int displayLength;

    private final ElevatorsConnector connector;

    private ElevatorService service;

    private List<Elevator> elevatorsList = new ArrayList<>();

    private ElevatorApplicationPanel thisPanel;

    public ElevatorApplicationStarterWithGraphicSimulation(ApplicationParameters parameters) {
        countOfElevators = parameters.getCountOfElevators();
        countOfFloors = parameters.getCountOfFloors();
        useSimpleButtons = parameters.isUsingSimpleButtons();
        displayLength = parameters.getDisplayLength();
        connector = createConnector();
    }

    @Override
    public void startSimulation(ElevatorService s) {
        service = s;
        service.setCoreModule(connector);
        service.startScheduledTask();

        ElevatorApplicationPanel panel = new ElevatorApplicationPanel(this);
        ElevatorApplicationFrame frame = new ElevatorApplicationFrame(panel);
        frame.setVisible(true);
        thisPanel = panel;
    }

    @Override
    public int getCountOfFloors() {
        return countOfFloors;
    }

    @Override
    public int getCountOfElevators() {
        return countOfElevators;
    }

    @Override
    public boolean isUseSimpleButtons() {
        return useSimpleButtons;
    }

    @Override
    public int getDisplayLength() {
        return displayLength;
    }

    @Override
    public void stopSimulation() {
        thisPanel.disableButtons();
    }

    @Override
    public ElevatorsConnector getConnector() {
        return connector;
    }

    @Override
    public ElevatorService getService() {
        return service;
    }

    @Override
    public Elevator getElevator(int n) {
        return elevatorsList.get(n);
    }

    private ElevatorsConnector createConnector() {
        List<Elevator> elevators = new ArrayList<>();
        for(int i = 0; i < countOfElevators; i++) {
            Elevator elevator = new Elevator(
                    this,
                    1,
                    ElevatorState.WAITING_CLOSED,
                    0,
                    0,
                    "E" + i
            );
            elevators.add(elevator);
        }
        elevatorsList = elevators;
        return new MultipleElevatorConnector(elevators);
    }
}
