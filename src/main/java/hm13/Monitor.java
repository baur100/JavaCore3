package hm13;

import java.util.PrimitiveIterator;

public class Monitor {
    private String model;
    private String color;

    public Monitor(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void printInfo(){
        System.out.println("Model = " + model + "Color = " + color);
    }
}
