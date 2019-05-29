public class SensorAdapterTemperature implements SensorInterface{
    private sensor.TemperatureSensor sensorTemperature;
    private double min = 235;
    private double max = 300;
    private String units = " °C";
    private double actualValue = 0;
    private int percentValue = 0;

    public SensorAdapterTemperature(sensor.TemperatureSensor sensor) {
        this.sensorTemperature = sensor;
    }

    public double value() {
        this.actualValue = this.sensorTemperature.senseTemperature();
        this.percentValue();
        return this.actualValue;
    }

    public String report() {
        return this.sensorTemperature.getTempReport();
    }
    public String name() {
        return this.sensorTemperature.getSensorType();
    }

    public int percentValue() {
        if (this.actualValue > max) {
            return 100;
        }
        if (this.actualValue < min) {
            return 0;
        }

        this.percentValue = (int)(((this.max - this.actualValue) / (this.max - this.min)) * 100);
        return this.percentValue;
    }

    public String getUnits() {
        return this.units;
    }
}
