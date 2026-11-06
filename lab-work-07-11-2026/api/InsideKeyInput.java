package elevator.api;

/**
 * Информация по нажатой кнопке внутри какой-либо кабины
 */
public class InsideKeyInput {

    // Номер кабины, в которой нажата кнопка
    private int elevatorNumber;

    // Тип нажатой кнопки
    private InsideKeyType type;

    // Если тип нажатой кнопки - этаж, то здесь будет его номер
    private Integer floorNumber;

    public InsideKeyInput(int elevatorNumber, InsideKeyType type, Integer floorNumber) {
        this.elevatorNumber = elevatorNumber;
        this.type = type;
        this.floorNumber = floorNumber;
    }

    public int getElevatorNumber() {
        return elevatorNumber;
    }

    public InsideKeyType getType() {
        return type;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    @Override
    public String toString() {
        return "InsideKeyInput{" +
                "elevatorNumber=" + elevatorNumber +
                ", type=" + type +
                ", floorNumber=" + floorNumber +
                '}';
    }
}
