import sensor.PressureSensor;
import sensor.RadiationSensor;
import sensor.TemperatureSensor;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow {
    private JPanel rootPanel;
    private JButton readSensorsButton;
    private JProgressBar progressBar1;
    private JLabel firstLabel;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel label2;
    private JLabel label3;

    private static SensorInterface pressureSensor;
    private static SensorInterface radiationSensor;
    private static SensorInterface temperatureSensor;

    public MainWindow() {
        JFrame frame = new JFrame("MainWindow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,1));

        panel1.setBorder(new TitledBorder(pressureSensor.name()));
        panel1.setPreferredSize(new Dimension(300,300));
        panel2.setBorder(new TitledBorder(radiationSensor.name()));
        panel2.setPreferredSize(new Dimension(300,300));
        panel3.setBorder(new TitledBorder(temperatureSensor.name()));
        panel3.setPreferredSize(new Dimension(300,300));

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.setPreferredSize(new Dimension(300,900));

        frame.pack();
        frame.setVisible(true);


        readSensorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstLabel.setText("big penis");
            }
        });
    }

    public static void main(String[] args) {
        pressureSensor = new SensorAdapterPressure(new PressureSensor());
        radiationSensor = new SensorAdapterRadiation(new RadiationSensor());
        temperatureSensor = new SensorAdapterTemperature(new TemperatureSensor());

        MainWindow window = new MainWindow();
    }
}
