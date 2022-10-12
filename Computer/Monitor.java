package Computer;

public class Monitor {
    private double diagonal;
    private final MonitorType type;
    private double weight;

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

    public  double getWeight() {
        return weight;
    }


    public void setDiagonal(double diagonal) {
        this.diagonal = diagonal;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String toString(){
        return getType() + "\n" +
                "Диагональ: " + diagonal  + "\n" +
                "Вес монитора: " + getWeight();
    }
}
