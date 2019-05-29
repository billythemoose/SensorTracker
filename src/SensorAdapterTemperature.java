public class SensorAdapterTemperature implements SensorInterface{
    private sensor.TemperatureSensor sensorTemperature;
    private double min = 185;
    private double max = 350;
    private double critMin = 235;
    private double critMax = 300;
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
            return 1;
        }

        this.percentValue = (int)(((this.actualValue - this.min) * 100) / (this.max - this.min));
        return this.percentValue;
    }

    public String getUnits() {
        return this.units;
    }
}
