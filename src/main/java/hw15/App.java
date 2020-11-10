package hw15;

public class App {
    public static void main(String[] args) {
        Cake napoleon = new Cake("Napoleon","flour, milk, sour cream, butter");
        napoleon.present("Napoleon");
        napoleon.fullInfo();
        System.out.println(napoleon.myInfo());

        Pancakes cherryPancakes = new Pancakes("Cherry Pancakes", "flour, milk, butter", 10);
        cherryPancakes.present("Cherry Pancakes");
        cherryPancakes.fullInfo();
        System.out.println(cherryPancakes.myInfo());
        cherryPancakes.portion(10);
    }

}
