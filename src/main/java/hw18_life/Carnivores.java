package hw18_life;

public abstract class Carnivores implements Mammals {
    protected String subclass;
    protected String squad;

    public Carnivores(String subclass, String squad) {
        this.subclass = subclass;
        this.squad = squad;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public String getSquad() {
        return squad;
    }

    public void setSquad(String squad) {
        this.squad = squad;
    }


    @Override
    public void canDie() {
    }

    public void myInfo() {
        System.out.println("BlueWhale{" +
                ", subclass='" + subclass + '\'' +
                ", squad='" + squad + '\'' +
                '}');
    }
}
