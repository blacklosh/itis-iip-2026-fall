package elevator.api;

/**
 * Этот enum показывает, в каком состоянии находится выбранная кабина
 */
public enum ElevatorState {

    // Выключена
    INACTIVE,

    // Сломалась
    BROKEN,

    // Ждёт с закрытыми дверями
    WAITING_CLOSED,

    // В процессе открытия дверей
    DOORS_OPENING,

    // Ждёт с открытыми дверями
    WAITING_OPENED,

    // В процессе закрытия дверей
    DOORS_CLOSING,

    // Движется вверх
    MOVING_UP,

    // Движется вниз
    MOVING_DOWN
}
