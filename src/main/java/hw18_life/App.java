package hw18_life;

public class App {
    public static void main(String[] args) {
        Lion animal1 = new Lion("Vertebrate", "Predatory", "Lion");
        animal1.canBreath("Lion");

        Wolf animal2 = new Wolf("Vertebrate", "Predatory", "Wolf");
        animal2.canReproduce();

        BlueWhale animal3 = new BlueWhale("Vertebrate", "Predatory", "BlueWhale");
        animal3.myInfo();
    }
}
