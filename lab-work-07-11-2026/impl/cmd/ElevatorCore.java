package elevator.impl.cmd;

import elevator.api.ElevatorState;

/**
 * Интерфейс взаимодействия с конкретной кабиной
 */
public interface ElevatorCore {

    // Получить статус кабины
    ElevatorState getElevatorState();

    // Получить номер этажа, где находится кабина
    int getElevatorFloor();

    // Открыть двери кабины
    void openDoors();

    // Закрыть двери кабины
    void closeDoors();

    // Отправить кабину на указанный этаж
    void moveToFloor(int floor);

    // Вкл\выкл кондиционер
    void setAirConditioningEnabled(boolean enabled);

    // Вывести текст на экраны внутри кабины и на этажах
    void setStringOnDisplay(String line);

}
