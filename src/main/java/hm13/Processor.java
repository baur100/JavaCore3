package hm13;

public class Processor {
    private String CPUtypes;
    private String color;

    public Processor(String CPUtypes, String color) {
        this.CPUtypes = CPUtypes;
        this.color = color;
    }

    public String getCPUtypes() {
        return CPUtypes;
    }

    public void setCPUtypes(String CPUtypes) {
        this.CPUtypes = CPUtypes;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void printInfo(){
        System.out.println("CPUType = " + CPUtypes + "Color = " + color);
    }
}
