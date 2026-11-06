package elevator.impl.params;

/**
 * Класс для настройки симуляции
 */
public class ApplicationParameters {

    // Сколько хотим этажей (2 - 15)
    private int countOfFloors;

    // Сколько хотим кабин (1 - 3)
    private int countOfElevators;

    // Одиночные или двойные кнопки на этажах
    // true - одиночные, без указания направления
    // false - двойные, с указанием вверх\вниз
    private boolean useSimpleButtons;

    // Сколько символов допустимо на экранчиках
    private int displayLength;

    // Значения по-умолчанию
    public ApplicationParameters() {
        countOfFloors = 15;
        countOfElevators = 3;
        useSimpleButtons = true;
        displayLength = 3;
    }

    public void setCountOfFloors(int countOfFloors) {
        if(countOfFloors < 2) {
            System.err.println("ERROR [PARAMETERS]: There should be at least 2 floors (provided "
                    + countOfFloors + "), fallback to 15");
        } else if(countOfFloors > 15) {
            System.err.println("ERROR [PARAMETERS]: There should be not more than 15 floors (provided "
                    + countOfFloors + "), fallback to 15");
        } else {
            this.countOfFloors = countOfFloors;
        }
    }

    public void setCountOfElevators(int countOfElevators) {
        if(countOfElevators < 1) {
            System.err.println("ERROR [PARAMETERS]: There should be at least 1 elevator (provided "
                    + countOfElevators + "), fallback to 3");
        } else if(countOfElevators > 3) {
            System.err.println("ERROR [PARAMETERS]: There should be not more than 3 elevators (provided "
                    + countOfElevators + "), fallback to 3");
        } else {
            this.countOfElevators = countOfElevators;
        }
    }

    public void setUseSimpleButtons(boolean useSimpleButtons) {
        this.useSimpleButtons = useSimpleButtons;
    }

    public void setDisplayLength(int displayLength) {
        if(displayLength < 1) {
            System.err.println("ERROR [PARAMETERS]: There should be at least 1 symbol at display (provided "
                    + displayLength + "), fallback to 3");
        } else if(displayLength > 3) {
            System.err.println("ERROR [PARAMETERS]: There should be not more than 3 symbols at display (provided "
                    + displayLength + "), fallback to 3");
        } else {
            this.displayLength = displayLength;
        }
    }

    public int getCountOfFloors() {
        return countOfFloors;
    }

    public int getCountOfElevators() {
        return countOfElevators;
    }

    public boolean isUsingSimpleButtons() {
        return useSimpleButtons;
    }

    public int getDisplayLength() {
        return displayLength;
    }
}
