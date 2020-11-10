package hm11;

public class Bags {
    private String model;
    private String[] color;
    private int price;


    public Bags(String model, String[] color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }


    public String getModel() {
        return this.model;
    }

    public String[] getColor() {
        return this.color;
    }

    public int getPrice() {
        return this.price;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String[] color) {
        this.color = color;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Bags() {
    }

    public void printout() {
        System.out.println("Model = " + model + "\nPrice = " + price);
    }


}
