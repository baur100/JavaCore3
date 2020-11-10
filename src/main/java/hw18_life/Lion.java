package hw18_life;

public class Lion extends Carnivores {
    private String kindName;

    public Lion(String subclass, String squad, String kindName) {
        super(subclass, squad);
        this.kindName = kindName;
    }

    @Override
    public void canDie() {

    }

    @Override
    public void canReproduce() {

    }

    @Override
    public void canEat() {

    }


    @Override
    public void canBreath(String name) {
        System.out.println("I can breath!!!");

    }
}
