package Computer;

public class OperationalMemory {
    private final String type;
    private final int volume;
    private static  int weight = 0;

    public OperationalMemory(String type, int volume, int weight) {
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



    public OperationalMemory setWeight(int weight) {
        return new OperationalMemory(type,volume,weight);
    }
    public static int getWeight() {
        return weight;
    }
}
