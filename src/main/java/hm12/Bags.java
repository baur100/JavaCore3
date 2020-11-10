package hm12;

public class Bags {
    private String brand;
    private Material material;
    private ColorsHw color;

    public Bags(String brand, Material material, ColorsHw color) {
        this.brand = brand;
        this.material = material;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public ColorsHw getColor() {
        return color;
    }

    public void setColor(ColorsHw color) {
        this.color = color;
    }

    public void printout() {
        System.out.println("Bag: " + brand + ", " + material + ", " + color);
    }
}