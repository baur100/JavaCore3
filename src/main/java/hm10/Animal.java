package hm10;

public class Animal {
    public String kind;
    public String name;
    public String color;
    public String breed;

    public void printMe() {
        System.out.println("name = " + name);
        System.out.println("kind = " + kind);
        System.out.println("breed = " + breed);
        System.out.println("color = " + color);
    }

    public void hello() {
        System.out.println("My "+kind+"'s name is "+name);
    }
    public void hello2(){
        System.out.println("Hello, " +name+ ", meet my dog Chack!");
    }




}
