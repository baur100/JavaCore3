package hw15;

public class Cake implements Food {
    private String name;
    private String ingredients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Cake(String name, String ingredients) {
        this.name = name;
        this.ingredients = ingredients;


    }
    @Override
    public void present (String yourName){
        System.out.println("This is a cake " +yourName);
    }
    @Override
    public String myInfo(){
        return "The ingredients of the cake are " +ingredients;
    }

    public void fullInfo(){
        System.out.println("Cake " + name + " consists: " + ingredients);
    }

}
