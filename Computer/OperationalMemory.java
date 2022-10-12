package Computer;

public class OperationalMemory {
    private final String type;
    private int volume;
    private double weight = 0;

    public OperationalMemory(String type, int volume, double weight) {
        this.type = type;
        this.volume = volume;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public OperationalMemory setType(String type) {
        return new OperationalMemory(type,volume,weight);
    }

    public int getVolume() {
        return volume;
    }

    public OperationalMemory setVolume(int volume) {
        return new OperationalMemory(type,volume,weight);
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public OperationalMemory setWeight(int weight) {
        return new OperationalMemory(type,volume,weight);
    }

    public double getWeight() {
        return weight;
    }



    public String toString () {
        return getType() + "\n" +
                "Обьем памяти: " + getVolume() + "\n" +
                "Вес ОЗУ: " + getWeight();
    }
}
