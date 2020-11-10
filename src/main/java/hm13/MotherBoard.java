package hm13;

import java.util.PrimitiveIterator;

public class MotherBoard {
    private String type;
    private String brand;

    public MotherBoard(String type, String brand) {
        this.type = type;
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void printInfo(){
        System.out.println("Type = " + type + "Brand = " + brand);
    }
}
