package elevator.impl.window;

import elevator.api.*;
import elevator.impl.cmd.ElevatorApplicationStarter;
import elevator.impl.model.Elevator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static elevator.api.InsideKeyType.*;
import static elevator.api.OutsideKeyDirection.*;
import static elevator.api.ElevatorState.*;

public class ElevatorApplicationPanel extends JPanel {

    private final ElevatorApplicationStarter starter;

    private final ElevatorService service;

    private final Font font = new Font("arial", Font.BOLD, 12);

    private final java.util.List<JButton> buttons = new ArrayList<>();

    public ElevatorApplicationPanel(ElevatorApplicationStarter starter) {
        this.starter = starter;
        service = starter.getService();

        setBackground(Color.WHITE);

        for(int i = 0; i < starter.getCountOfElevators(); i++) {
            int shift = i * 310;
            addBigButton("<>", shift + 5, 10, action(i, SIGNAL_DOOR_OPEN));
            addBigButton("><", shift + 65, 10, action(i, SIGNAL_DOOR_CLOSE));
            addBigButton("X", shift + 125, 10, action(i, SIGNAL_DISCARD));
            addBigButton("A", shift + 185, 10, action(i, SIGNAL_ALARM));
            addBigButton("AC", shift + 245, 10, action(i, AC_CHANGE));

            int x = 0;
            int y = 0;
            for(int j = 1; j <= starter.getCountOfFloors(); j++) {
                if(x > 4) {
                    x = 0;
                    y++;
                }
                addBigButton("" + j, shift + 5 + x * 60, 70 + y * 60, action(i, j));
                x++;
            }
        }

        int yShift = 280;
        for(int i = 0; i < starter.getCountOfFloors(); i++) {
            int floorNum = starter.getCountOfFloors() - i;
            addLabel(floorNum + "", 5, yShift + i * 25);
            if(starter.isUseSimpleButtons()) {
                addMediumButton("C", 25, yShift + i * 25, action(floorNum, CALL));
            } else {
                addSmallButton("^", 25, yShift + i * 25, action(floorNum, UP));
                addSmallButton("v", 70, yShift + i * 25, action(floorNum, DOWN));
            }
        }

        setFocusable(true);
        grabFocus();
    }

    private void addBigButton(String title, int x, int y, ActionListener action) {
        addButton(title, x, y, 50, 50, action);
    }

    private void addMediumButton(String title, int x, int y, ActionListener action) {
        addButton(title, x, y, 50, 20, action);
    }

    private void addSmallButton(String title, int x, int y, ActionListener action) {
        addButton(title, x, y, 45, 20, action);
    }

    private void addLabel(String title, int x, int y) {
        JLabel label = new JLabel(title);
        label.setBounds(x, y, 50, 20);
        label.setFont(font);
        add(label);
    }

    private void addButton(String title, int x, int y, int w, int h, ActionListener action) {
        JButton button = new JButton(title);
        button.setBounds(x, y, w, h);
        button.setFont(font);
        button.addActionListener(action);
        add(button);
        buttons.add(button);
    }

    @Override
    protected void paintComponent(Graphics gr) {
        super.paintComponent(gr);

        gr.setColor(Color.BLACK);
        gr.fillRect(0, 265, 1000, 5);

        for(int i = 0; i < starter.getCountOfElevators(); i++) {
            gr.fillRect(303 + i * 310, 0, 5, 265);
        }

        for(int i = 0; i < starter.getCountOfElevators(); i++) {
            Elevator elevator = starter.getElevator(i);
            int lastY = 280 + starter.getCountOfFloors() * 25;
            int y = lastY - elevator.getElevatorFloor() * 25;
            if(MOVING_DOWN.equals(elevator.getElevatorState())) {
                y += elevator.getPositionBetweenFloors() / 4;
            } else if(MOVING_UP.equals(elevator.getElevatorState())) {
                y -= elevator.getPositionBetweenFloors() / 4;
            }
            int x = 150 + i * 150;
            int doorsPos = 100 - elevator.getDoorsPosition();
            boolean ac = elevator.isAc();
            String line = elevator.getDisplayLine();
            String name = elevator.getName();

            gr.setFont(font);
            gr.setColor(Color.BLACK);
            gr.drawString(name + ": " + (line == null ? "" : line), 120 + 310 * i, 260);

            if(INACTIVE.equals(elevator.getElevatorState())) {
                gr.setColor(Color.GRAY);
            } else if(BROKEN.equals(elevator.getElevatorState())) {
                gr.setColor(Color.RED);
            } else {
                gr.setColor(Color.GREEN);
            }

            gr.fillRect(x, y - 5, 130, 30);

            gr.setColor(Color.BLACK);
            gr.fillRect(x + 5, y, 20, 20);
            gr.fillRect(x + 25, y, doorsPos, 20);

            gr.setColor(ac ? Color.CYAN : Color.DARK_GRAY);
            gr.drawString("AC", x + 8, y + 14);
        }

        repaint();
    }

    private ActionListener action(int i, InsideKeyType type) {
        return e -> service.handleInsideKeyPress(
                new InsideKeyInput(i, type, null)
        );
    }

    private ActionListener action(int i, int n) {
        return e -> service.handleInsideKeyPress(
                new InsideKeyInput(i, FLOOR_NUMBER, n)
        );
    }

    private ActionListener action(int n, OutsideKeyDirection direction) {
        return e -> service.handleOutsideKeyPress(
                new OutsideKeyInput(n, direction)
        );
    }

    public void disableButtons() {
        for(JButton button : buttons) {
            button.setEnabled(false);
        }
    }
}
