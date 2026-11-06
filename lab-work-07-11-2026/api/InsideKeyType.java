package elevator.api;

/**
 * Типы кнопок внутри кабины
 */
public enum InsideKeyType {

    // Открыть двери
    SIGNAL_DOOR_OPEN,

    // Закрыть двери
    SIGNAL_DOOR_CLOSE,

    // Тревога, связаться с диспетчером
    SIGNAL_ALARM,

    // Отмена выбора этажа
    SIGNAL_DISCARD,

    // Вкл\выкл кондиционер
    AC_CHANGE,

    // Кнопка с номером этажа
    FLOOR_NUMBER
}
