package hw15;

public class Pancakes implements Food{
    private String name1;
    private String ingredients1;
    private int count;

    public Pancakes(String name1, String ingredients1, int count) {
        this.name1 = name1;
        this.ingredients1 = ingredients1;
        this.count = count;
    }

    @Override
    public void present (String yourName){
        System.out.println("This is a " +yourName);
    }
    @Override
    public String myInfo(){
        return "The ingredients of the pancakes are " +ingredients1;
    }

    public void fullInfo(){
        System.out.println(name1 + " consists: " + ingredients1);
    }
    public void portion (int count){
        System.out.println("There are " + count + " " + name1 +"!");
    }
}
