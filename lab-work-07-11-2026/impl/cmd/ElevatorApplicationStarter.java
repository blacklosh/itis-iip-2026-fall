package elevator.impl.cmd;

import elevator.api.ElevatorService;
import elevator.impl.model.Elevator;

/**
 * Стартер для запуска симуляции. Использовать только первый метод!
 */
public interface ElevatorApplicationStarter {

    /**
     * Запуск симуляции с выбранным сервисов логики
     */
    void startSimulation(ElevatorService service);

    int getCountOfFloors();

    int getCountOfElevators();

    boolean isUseSimpleButtons();

    int getDisplayLength();

    void stopSimulation();

    ElevatorsConnector getConnector();

    ElevatorService getService();

    Elevator getElevator(int n);

}
