package Computer;


public class Computer {

    private final String vendor;
    private final String name;
    private Processor processor;
    private OperationalMemory memory;
    private HardDisc disc;
    private Monitor monitor;
    private Keyboard keyboard;
    ;

    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
    }

    public Computer(Processor processor, OperationalMemory memory, HardDisc disc, Monitor monitor, Keyboard keyboard, String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
        this.processor = processor;
        this.memory = memory;
        this.disc = disc;
        this.monitor = monitor;
        this.keyboard = keyboard;
    }

    public void setProcessor(Processor processor) {
        this.processor=processor;
    }

    public void setOperationalMemory(OperationalMemory memory) {
        this.memory = memory;
    }

    public void setHardDisk(HardDisc disc) {
       this.disc = disc;
    }

    public void setMonitor(Monitor monitor) {
       this.monitor = monitor;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public String getVendor() {return vendor;}

    public String getName() {return name;}

    public Processor getProcessor() {return processor;}

    public OperationalMemory getMemory() {return memory;}

    public HardDisc getDisc() {return disc;}

    public Monitor getMonitor() {return monitor;}

    public Keyboard getKeyboard() {return keyboard;}


    public double getWeight() {
        return processor.getWeight()+
                        memory.getWeight()+
                        disc.getWeight()+
                        monitor.getWeight()+
                        keyboard.getWeight();
    }

    public String toString() {
        return "Название: "+name+
                "\nПроизводитель: "+vendor+
                "\nПроцессор: "+processor+
                "\nОперативная память: "+memory+
                "\nНакопитель информации: "+disc+
                "\nЭкран: "+monitor+
                "\nКлавиатура: "+keyboard+"\n"+
                "\nОбщий вес Компьютера составляет:  " + getWeight();
    }
}


