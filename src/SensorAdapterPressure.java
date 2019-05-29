public class SensorAdapterPressure implements SensorInterface{
    private sensor.PressureSensor sensorPressure;
    private double min = 5;
    private double max = 6.58;
    private int percentMin = 0;
    private int percentMax = 0;
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
            return 0;
        }

        this.percentValue = (int)(((this.max - this.actualValue) / (this.max - this.min)) * 100);
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
