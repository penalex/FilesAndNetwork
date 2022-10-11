package Computer;

public class Keyboard {
    private final String type;
    private final boolean illumination;
    private static double weight;

    public Keyboard(String type, boolean illumination, double weight) {
        this.type = type;
        this.illumination = illumination;
        this.weight = weight;
    }
    public Keyboard setKeyboard(){
        return new Keyboard(type,illumination,weight);
     }

     public String toString (){
         return  getType() + "\n" +
                 "Посдсветка клавиатуры: " + illumination + "\n" +
                 "Вес клавиатуры: " + getWeight();
     }

    public String getType() {
        return type;
    }

    public boolean isIllumination() {
        return illumination;
    }

    public static double getWeight() {
        return weight;
    }
}
