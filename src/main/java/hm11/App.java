package hm11;

public class App {
    public static void main(String[] args) {
        String[] color = {"Black", "Red", "White"};
        Bags gucci = new Bags("Gucci", color, 2000);
        String[] col = gucci.getColor();
        for (String v : col) {
            System.out.println(v);
        }

        Bags channel = new Bags("Channel", color, 3000);
        channel.setPrice(4000);
        channel.printout();

        Cat cindy = new Cat("Cat", "Cindy", "Siamese");
        cindy.printout();

        Cat lucy = new Cat("Cat", "Lucy", "Persian");
        lucy.printout();

        Furniture table = new Furniture("Table", "Brown", "Wood");
        table.setColor("Black");
        table.printout();

        Furniture table2 = new Furniture("Table", "White", "Glass");
        table2.printout();

    }
}
