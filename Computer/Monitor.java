package Computer;

public class Monitor {
    private final double diagonal;
    private final MonitorType type;
    private static double weight;

    public Monitor(double diagonal, MonitorType type, double weight) {
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

    public static double getWeight() {
        return weight;
    }

    public String toString(){
        return getType() + "\n" +
                "Диагональ: " + diagonal  + "\n" +
                "Вес монитора: " + getWeight();
    }
}
