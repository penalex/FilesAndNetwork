package Computer;

public class HardDisc {
    private final HardDiscType type;
    private final int memory;
    private static int weight;

    public HardDisc(HardDiscType type, int memory, int weight) {
        this.type = type;
        this.memory = memory;
        this.weight = weight;
    }

    public HardDiscType getType() {
        return type;
    }

    public int getMemory() {
        return memory;
    }

    public static int getWeight() {
        return weight;
    }
}
