package Computer;

public class Processor {
    private final double frequency;
    private final int core;
    private final String manufacturer;
    private static  double weight = 0;



    public Processor(double frequency, int core, String manufacturer, double weight) {
        this.frequency = frequency;
        this.core = core;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }
    public Processor setFrequency(double frequency){
        return new Processor(frequency,core,manufacturer,weight);
    }

    public double getFrequency() {
        return frequency;
    }

    public Processor setCore(int core){
        return new Processor(frequency,core,manufacturer,weight);
    }

    public int getCore() {
        return core;
    }

    public Processor setManufacturer(int core){
        return new Processor(frequency,core,manufacturer,weight);
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Processor setWeight(int core){
        return new Processor(frequency,core,manufacturer,weight);
    }

    public static double getWeight() {
        return weight;
    }

    public String toString(){
        return getManufacturer() + "\n" +
                "Частота процессора: " + getFrequency() + "\n" +
                "Количество ядер: " + getCore() + "\n" +
                "Вес процессора: " + getWeight();
    }
}
