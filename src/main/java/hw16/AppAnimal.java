package hw16;

import java.util.ArrayList;

public class AppAnimal {
    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<Animal>();
        Animal cat = new Animal("Cat","Siamese", "Chui");
        animals.add(cat);
        Animal dog = new Animal("Dog", "husky","Pit");
        animals.add(dog);
        Animal bird = new Animal("Parrot", "Nestor", "Tosha");
        animals.add(bird);
        animals.set(0,dog);
        animals.set(1, cat);
        boolean isExist = animals.contains(cat);
        System.out.println(isExist);
        animals.remove(0);
        System.out.println(animals);
        animals.forEach(x -> System.out.println(x));
        animals.get(0);
        System.out.println(animals.get(0));

    }
}
