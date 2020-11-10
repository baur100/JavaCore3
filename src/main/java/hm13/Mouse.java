package hm13;

import java.util.PrimitiveIterator;

public class Mouse {
    private String brand;
    private String model;
    private MouseType mouseType;

    public Mouse(String brand, String model, MouseType mouseType) {
        this.brand = brand;
        this.model = model;
        this.mouseType = mouseType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public MouseType getMouseType() {
        return mouseType;
    }

    public void setMouseType(MouseType mouseType) {
        this.mouseType = mouseType;
    }
    public void printInfo(){
        System.out.println("Brand = " + brand + "Model = " + model + "Type = " + mouseType);
    }
}
