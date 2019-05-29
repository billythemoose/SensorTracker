public class SensorAdapterPressure implements SensorInterface{
    private sensor.PressureSensor sensorPressure;
    private double min = 4;
    private double max = 7;
    private double critMin = 5;
    private double critMax = 6.58;
    private String units = " bar";
    private double actualValue = 0;
    private int percentValue = 0;

    public SensorAdapterPressure(sensor.PressureSensor sensor) {
        this.sensorPressure = sensor;
    }

    public double value() {
        this.actualValue = this.sensorPressure.readValue();
        this.percentValue();
        return this.actualValue;
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

    public String report() {
        return this.sensorPressure.getReport();
    }
    public String name() {
        return this.sensorPressure.getSensorName();
    }

    public double getMin() {
        return this.min;
    }

    public double getMax() {
        return this.max;
    }

    public String getUnits() {
        return this.units;
    }
}
