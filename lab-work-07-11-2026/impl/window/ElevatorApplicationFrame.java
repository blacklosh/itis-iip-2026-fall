package elevator.impl.window;

import javax.swing.*;

public class ElevatorApplicationFrame extends JFrame {

    public ElevatorApplicationFrame(JPanel panel) {
        setContentPane(panel);
        setBounds(100, 100, 1000, 700);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setTitle("Elevator Application");
    }
}
