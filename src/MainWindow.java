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

        panel1bar.setMinimum(0);
        panel1bar.setMaximum(100);
        panel2bar.setMinimum(0);
        panel2bar.setMaximum(100);
        panel3bar.setMinimum(0);
        panel3bar.setMaximum(100);

        updateValues(panel1label2, panel1bar, pressureSensor);
        updateValues(panel2label, panel2bar, radiationSensor);
        updateValues(panel3label, panel3bar, temperatureSensor);

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
                updateValues(panel1label2, panel1bar, pressureSensor);
                updateValues(panel2label, panel2bar, radiationSensor);
                updateValues(panel3label, panel3bar, temperatureSensor);
            }
        });
    }

    public void updateValues(JLabel updatePanel, JProgressBar updateBar, SensorInterface updateSensor){
        double newValue = updateSensor.value();
        String updateText = newValue + updateSensor.getUnits();
        Color updateColor = Color.orange;
        String level = "CRITICAL --> ";
        if (newValue > updateSensor.getMax()){
            updateColor = Color.red;
            level = "DANGER --> ";
        }
        else if (newValue < updateSensor.getMin()) {
            updateColor = Color.green;
            level = "OK -->";
        }

        updateText = level + updateText;
        updatePanel.setText(updateText);
        updateBar.setValue(updateSensor.percentValue());
        updateBar.setForeground(updateColor);
    }

    public static void main(String[] args) {
        pressureSensor = new SensorAdapterPressure(new PressureSensor());
        radiationSensor = new SensorAdapterRadiation(new RadiationSensor());
        temperatureSensor = new SensorAdapterTemperature(new TemperatureSensor());

        MainWindow window = new MainWindow();
    }
}
