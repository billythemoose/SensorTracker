public class SensorAdapterTemperature implements SensorInterface{
    private sensor.TemperatureSensor sensorTemperature;

    public SensorAdapterTemperature(sensor.TemperatureSensor sensor) {
        this.sensorTemperature = sensor;
    }

    public double value() {
        return this.sensorTemperature.senseTemperature();
    }

    public String report() {
        return this.sensorTemperature.getTempReport();
    }
    public String name() {
        return this.sensorTemperature.getSensorType();
    }
}
