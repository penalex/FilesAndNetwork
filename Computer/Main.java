package Computer;

public class Main {
    public static void main(String[] args) {

        Computer computer1 = new Computer("jkhnjk","hghg");
        computer1.setProcessor(new Processor(32,12,"gjh",21));
        computer1.setOperationalMemory(new OperationalMemory("DDR3",12,12));
        computer1.setHardDisk(new HardDisc(HardDiscType.SSD,120,12));
        computer1.setMonitor(new Monitor(12.2,MonitorType.VA,12));
        computer1.setKeyboard(new Keyboard("Sun",true,10));
        computer1.getProcessor();
        computer1.getMemory();
        computer1.getDisc();
        computer1.getMonitor();
        computer1.getKeyboard();

        System.out.println( computer1.toString() );







    }
}
