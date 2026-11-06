package elevator.solution;

import elevator.api.ElevatorService;
import elevator.impl.cmd.ElevatorApplicationStarter;
import elevator.impl.cmd.ElevatorApplicationStarterWithGraphicSimulation;
import elevator.impl.params.ApplicationParameters;

public class Main {

    public static void main(String[] args) {
        ApplicationParameters parameters = new ApplicationParameters();
        parameters.setCountOfElevators(1);
        parameters.setCountOfFloors(5);
        parameters.setUseSimpleButtons(true);

        ElevatorApplicationStarter starter = new ElevatorApplicationStarterWithGraphicSimulation(parameters);

        ElevatorService service = new MyElevatorService(parameters.getCountOfFloors());
        starter.startSimulation(service);
    }
}
