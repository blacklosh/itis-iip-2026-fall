package elevator.impl.cmd;

/**
 * Базовый интерфейс для начала работы
 */
public interface ElevatorsConnector {

    // Узнать, сколько кабин доступно
    int getNumberOfElevators();

    // Получить управление кабиной по номеру
    ElevatorCore getElevator(int number);

}
