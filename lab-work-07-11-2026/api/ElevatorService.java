package elevator.api;

import elevator.impl.cmd.ElevatorsConnector;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Заготовка для сервиса, управляющего лифтами.
 * Необходимо реализовать абстрактные методы для использования в симуляции.
 */
public abstract class ElevatorService {

    /**
     * ElevatorsConnector позволяет получить информацию
     * о количестве доступных кабин и
     * получить доступ к управлению конкретной кабиной
     */
    protected ElevatorsConnector coreModule;

    /**
     * Период выполнения циклического блока в миллисекундах
     */
    protected int schedulePeriod = 100;

    /**
     * Установка периода выполнения циклического блока.
     * При необходимости - вызвать самостоятельно в Main методе
     */
    public void setSchedulePeriod(int period) {
        schedulePeriod = period;
    }

    /**
     * Метод позволяет установить ElevatorsConnector.
     * Будет вызван при запуске симуляции
     */
    public final void setCoreModule(ElevatorsConnector core) {
        coreModule = core;
    }

    /**
     * Метод будет вызван, если нажата клавиша внутри какой-либо кабины.
     * Требуется переопределение в наследнике с указанием custom логики!
     */
    public abstract void handleInsideKeyPress(InsideKeyInput info);

    /**
     * Метод будет вызван, если нажата клавиша на каком-либо этаже.
     * Требуется переопределение в наследнике с указанием custom логики!
     */
    public abstract void handleOutsideKeyPress(OutsideKeyInput info);

    /**
     * Метод запуска исполнения циклического кода.
     * Будет вызван при запуске симуляции
     */
    public final void startScheduledTask() {
        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                loop();
            }
        }, 0, schedulePeriod);
    }

    /**
     * Циклически выполняющийся метод.
     * Можно при необходимости переопределить его в наследнике
     */
    protected void loop() {

    }

}
