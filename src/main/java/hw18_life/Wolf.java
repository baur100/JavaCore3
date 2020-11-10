package hw18_life;

public class Wolf extends Carnivores {
    private String kindName;

    public Wolf(String subclass, String squad, String kindName) {
        super(subclass, squad);
        this.kindName = kindName;
    }

    @Override
    public void canDie() {


    }

    @Override
    public void canReproduce() {
        System.out.println("I can reproduce!");

    }

    @Override
    public void canEat() {

    }


    @Override
    public void canBreath(String name) {

    }
}
