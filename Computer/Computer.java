package Computer;


public class Computer {

    private final String vendor;
    private final String name;
    private static Processor processor;
    private static OperationalMemory memory;
    private static HardDisc disc;
    private static Monitor monitor;
    private static Keyboard keyboard;

    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }

    public Computer( Processor processor, OperationalMemory memory, HardDisc disc, Monitor monitor, Keyboard keyboard, String vendor , String name) {
       this.vendor = vendor;
       this.name = name;
       this.processor = processor;
       this.memory = memory;
       this.disc = disc;
       this.monitor = monitor;
       this.keyboard = keyboard;
    }
    public Computer setProcessor (Processor processor) {
        return new Computer(processor,memory,disc,monitor,keyboard,vendor,name);
    }
    public Computer setOperationalMemory (OperationalMemory memory) {
        return new Computer(processor,memory,disc,monitor,keyboard,vendor,name);
    }
    public Computer setHardDisk (HardDisc disc) {
        return new Computer(processor,memory,disc,monitor,keyboard,vendor,name);
    }
    public Computer setMonitor (Monitor monitor) {
        return new Computer(processor,memory,disc,monitor,keyboard,vendor,name);
    }
    public Computer setKeyboard (Keyboard keyboard) {
        return new Computer(processor,memory,disc,monitor,keyboard,vendor,name);
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public Processor getProcessor() {return processor;}

    public OperationalMemory getMemory() {
        return memory;
    }

    public HardDisc getDisc() {
        return disc;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }
    public double getWeight(){
      return Processor.getWeight()+
                OperationalMemory.getWeight()+
                         HardDisc.getWeight()+
                          Monitor.getWeight()+
                         Keyboard.getWeight();
    }

   public String toString(){
               return  "Название: " + getName() +
                "\nПроизводитель: " + vendor +
                "\nПроцессор: " + processor +
                "\nОперативная память: " + Computer.memory +
                "\nНакопитель информации: " + disc +
                "\nЭкран: " + monitor +
                "\nКлавиатура: " + keyboard + "\n" +
                "\nОбщий вес Компьютера составляет: " + getWeight();
    }
}


