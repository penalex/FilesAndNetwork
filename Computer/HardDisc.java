package Computer;

public class HardDisc {
    private final HardDiscType type;
    private int memory;
    private double weight;

    public HardDisc(HardDiscType type, int memory, double weight) {
        this.type = type;
        this.memory = memory;
        this.weight = weight;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public HardDiscType getType() {
        return type;
    }

    public  int getMemory() {
        return memory;
    }

    public  double getWeight() {
        return weight;
    }

    public String toString (){
        return getType() + "\n" +
                "Обьем памяти: " + getMemory() + "\n" +
                "Вес жесткого диска: " + getWeight();
    }
}
