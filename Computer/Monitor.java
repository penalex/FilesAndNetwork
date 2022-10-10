package Computer;

public class Monitor {
    private final double diagonal;
    private final MonitorType type;
    private static int weight;

    public Monitor(double diagonal, MonitorType type, int weight) {
        this.diagonal = diagonal;
        this.type = type;
        this.weight = weight;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public MonitorType getType() {
        return type;
    }

    public static int getWeight() {
        return weight;
    }
}
