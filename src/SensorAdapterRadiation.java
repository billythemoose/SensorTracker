// import sensor.RadiationSensor;

public class SensorAdapterRadiation implements SensorInterface{
    private sensor.RadiationSensor sensorRadiation;
    private double min = 3;
    private double max = 4;
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
            return 0;
        }

        this.percentValue = (int)(((this.max - this.actualValue) / (this.max - this.min)) * 100);
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
