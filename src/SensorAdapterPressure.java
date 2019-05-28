public class SensorAdapterPressure implements SensorInterface{
    private sensor.PressureSensor sensorPressure;

    public SensorAdapterPressure(sensor.PressureSensor sensor) {
        this.sensorPressure = sensor;
    }

    public double value() {
        return this.sensorPressure.readValue();
    }

    public String report() {
        return this.sensorPressure.getReport();
    }
    public String name() {
        return this.sensorPressure.getSensorName();
    }
}
