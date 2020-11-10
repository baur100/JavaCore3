package hm12;

import java.util.Arrays;

public class Phone {
    private OS[] operatingSystem;
    private String name;
    private String color;

    public Phone(OS operatingSystem[], String name, String color) {
        this.operatingSystem = operatingSystem;
        this.name = name;
        this.color = color;
    }

    public OS[] getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(OS[] operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void printout() {
        System.out.println("Phones: " + Arrays.toString(getOperatingSystem())+ ", " + name + ", " + color);

    }
}
