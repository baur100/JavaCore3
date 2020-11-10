package hw18_life;


public class BlueWhale extends Carnivores {
    private String kindName;


    public BlueWhale(String subclass, String squad, String kindName) {
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
        System.out.println("I can eat!");

    }


    @Override
    public void canBreath(String name) {

    }

    public void myInfo() {
        System.out.println("BlueWhale{" +
                "kindName='" + kindName + '\'' +
                ", subclass='" + subclass + '\'' +
                ", squad='" + squad + '\'' +
                '}');
    }
}
