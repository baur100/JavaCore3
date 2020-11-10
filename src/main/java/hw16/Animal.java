package hw16;

public class Animal {
    private String kind;
    private String breed;
    private String name;

    public Animal(String kind, String breed, String name) {
        this.kind = kind;
        this.breed = breed;
        this.name = name;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "kind='" + kind + '\'' +
                ", breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
