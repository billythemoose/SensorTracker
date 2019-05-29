public interface SensorInterface {
    double value();
    int percentValue();
    String report();
    String name();
    String getUnits();
    double getMin();
    double getMax();
}
