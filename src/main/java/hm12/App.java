package hm12;


public class App {

    public static void main(String[] args) {
        Bags prada = new Bags("Prada", Material.LEATHER, ColorsHw.YELLOW);
        prada.printout();


        Phone devices = new Phone(new OS[]{OS.IOS, OS.ANDROID}, "iPhone11 and Samsung S10", "Black and Gold");
        devices.printout();
    }
}

