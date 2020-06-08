package H17;

public class Trees {
    private String type;
    private int count;

    public Trees(){

    }

    public Trees(String type, int count) {
        this.type = type;
        this.count = count;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Trees{" +
                "type='" + type + '\'' +
                ", count=" + count +
                '}';
    }
}