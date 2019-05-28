// import sensor.RadiationSensor;

public class SensorAdapterRadiation implements SensorInterface{
    private sensor.RadiationSensor sensorRadiation;

    public SensorAdapterRadiation(sensor.RadiationSensor sensor) {
        this.sensorRadiation = sensor;
    }

    public double value() {
        return this.sensorRadiation.getRadiationValue();
    }

    public String report() {
        return this.sensorRadiation.getStatusInfo();
    }
    public String name() {
        return this.sensorRadiation.getName();
    }
}
