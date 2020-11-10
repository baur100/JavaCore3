package hm11;

public class Furniture {
    private String name;
    private String color;
    private String material;

    public Furniture(String name, String color, String material) {
        this.name = name;
        this.color = color;
        this.material = material;
    }

    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public String getMaterial() {
        return material;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Furniture() {
    }

    public void printout() {
        System.out.println("Name = " + name + "\nColor = " + color + "\nMaterial = " + material);
    }
}
