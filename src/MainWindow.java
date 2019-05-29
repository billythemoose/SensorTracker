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
    private JProgressBar panel1bar;
    private JLabel panel1label;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JLabel panel2label;
    private JLabel panel3label;
    private JPanel panel4;
    private JLabel panel1label2;
    private JProgressBar panel2bar;
    private JProgressBar panel3bar;

    private static SensorInterface pressureSensor;
    private static SensorInterface radiationSensor;
    private static SensorInterface temperatureSensor;

    public MainWindow() {
        JFrame frame = new JFrame("MainWindow");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4,1));

        panel1.setBorder(new TitledBorder(pressureSensor.name()));
        panel1.setPreferredSize(new Dimension(300,100));
        panel2.setBorder(new TitledBorder(radiationSensor.name()));
        panel2.setPreferredSize(new Dimension(300,100));
        panel3.setBorder(new TitledBorder(temperatureSensor.name()));
        panel3.setPreferredSize(new Dimension(300,100));

        panel1label2.setText(pressureSensor.value() + pressureSensor.getUnits());
        panel2label.setText(radiationSensor.value() + radiationSensor.getUnits());
        panel3label.setText(temperatureSensor.value() + temperatureSensor.getUnits());

        panel1bar.setMinimum(0);
        panel1bar.setMaximum(100);
        panel2bar.setMinimum(0);
        panel2bar.setMaximum(100);
        panel3bar.setMinimum(0);
        panel3bar.setMaximum(100);

        panel1bar.setValue(pressureSensor.percentValue());
        panel2bar.setValue(radiationSensor.percentValue());
        panel3bar.setValue(temperatureSensor.percentValue());

        panel4.setLayout(new GridBagLayout());
        GridBagConstraints bagConstraints = new GridBagConstraints();
        bagConstraints.anchor = GridBagConstraints.CENTER;
        panel4.add(readSensorsButton, bagConstraints);

        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        frame.setPreferredSize(new Dimension(300,500));

        frame.pack();
        frame.setVisible(true);


        readSensorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        pressureSensor = new SensorAdapterPressure(new PressureSensor());
        radiationSensor = new SensorAdapterRadiation(new RadiationSensor());
        temperatureSensor = new SensorAdapterTemperature(new TemperatureSensor());

        MainWindow window = new MainWindow();
    }

    public void updateProgressBar(JProgressBar bar) {

    }
}
