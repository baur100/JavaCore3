package hm13;

public class App {
    public static void main(String[] args) {
        Processor dell0 = new Processor("Intel", "Black");
        MotherBoard dell1 = new MotherBoard("ATX", "Dell");
        SystemBlock dell2 = new SystemBlock(dell0,dell1);
        Keyboard dell3 = new Keyboard("Wireless", "White");
        Mouse dell4 = new Mouse("Dell", "Optical", MouseType.WIRELESS);
        Monitor dell5 = new Monitor("Dell", "White");
        Computer dell = new Computer(dell2,dell3,dell4,dell5);

        dell.printInfo();

    }
}
