// import sensor.RadiationSensor;

public class SensorAdapterRadiation implements SensorInterface{
    private sensor.RadiationSensor sensorRadiation;
    private double min = 1;
    private double max = 6;
    private double critMin = 3;
    private double critMax = 4;
    private String units = " rad";
    private double actualValue = 0;
    private int percentValue = 0;

    public SensorAdapterRadiation(sensor.RadiationSensor sensor) {

        this.sensorRadiation = sensor;
    }

    public double value() {
        this.actualValue = this.sensorRadiation.getRadiationValue();
        this.percentValue();
        return this.actualValue;
    }

    public String report() {
        return this.sensorRadiation.getStatusInfo();
    }

    public String name() {
        return this.sensorRadiation.getName();
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
