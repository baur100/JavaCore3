package hm10;

public class Device {
    public String name;
    public String os;
    public String color;
    public int memory;

    public void ring() {
        System.out.println("Ring-Ring!!!");
    }

    public void lowBattery() {
        System.out.println("Battery is low, charge your phone");
    }
}
