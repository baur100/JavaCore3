package hm11;

public class Cat {
    private String kind;
    private String name;
    private String breed;

    public Cat(String kind, String name, String breed) {
        this.kind = kind;
        this.name = name;
        this.breed = breed;
    }

    public String getKind() {
        return kind;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Cat() {
    }

    public void printout() {
        System.out.println("Kind = " + kind + "\nName = " + name + "\nBreed = " + breed);
    }
}
