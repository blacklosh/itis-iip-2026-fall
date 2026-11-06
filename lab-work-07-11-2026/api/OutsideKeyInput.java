package elevator.api;

/**
 * Информация по нажатой кнопке на каком-либо этаже
 */
public class OutsideKeyInput {

    // Номер этажа, где нажата кнопка
    private int floor;

    // Тип нажатой кнопки
    private OutsideKeyDirection direction;

    public OutsideKeyInput(int floor, OutsideKeyDirection direction) {
        this.floor = floor;
        this.direction = direction;
    }

    public int getFloor() {
        return floor;
    }

    public OutsideKeyDirection getDirection() {
        return direction;
    }

    @Override
    public String toString() {
        return "OutsideKeyInput{" +
                "floor=" + floor +
                ", direction=" + direction +
                '}';
    }
}
