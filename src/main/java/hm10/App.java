package hm10;

import hm10.Animal;
import hm10.Cities;
import hm10.Device;
import hm10.Food;

public class App {
    public static void main(String[] args) {
        Animal cindy = new Animal();
        cindy.kind = "Cat";
        cindy.name = "Cindy";
        cindy.color = "Gray";
        cindy.breed = "Siamese";

        cindy.printMe();
        cindy.hello2();


        Animal chack = new Animal();
        chack.kind = "Dog";
        chack.name = "Chack";
        chack.color = "White";
        chack.breed = "Husky";

        chack.hello();

        Device iphone = new Device();
        iphone.name = "iPhone";
        iphone.os = "Apple";
        iphone.color = "Gold";
        iphone.memory = 64;

        iphone.ring();

        Device samsung = new Device();
        samsung.name = "Samsung";
        samsung.os = "Android";
        samsung.color = "Black";
        samsung.memory = 128;

        samsung.lowBattery();

        Cities la = new Cities();
        la.name = "Los Angeles";
        la.population = 3990456;
        la.country = "USA";

        Cities odessa = new Cities();
        odessa.name = "Odessa";
        odessa.population = 993120;
        odessa.country = "Ukraine";

        odessa.introduction();

        Food sushi = new Food();
        sushi.name = "Sushi";
        sushi.brand = "Japanese";
        sushi.price = 30;

        Food noodles = new Food();
        noodles.name = "Pad See Ew";
        noodles.brand = "Thai";
        noodles.price = 15;

        noodles.menu();














    }
}
