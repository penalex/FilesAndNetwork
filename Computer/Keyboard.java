package Computer;

public class Keyboard {
    private final String type;
    private final boolean illumination;
    private static int weight;

    public Keyboard(String type, boolean illumination, int weight) {
        this.type = type;
        this.illumination = illumination;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public boolean isIllumination() {
        return illumination;
    }

    public static int getWeight() {
        return weight;
    }
}
