package models;

public class Playlist {
    public int id;
    public String name;
    public String[] rules;
    public boolean is_smart;

    public void setName(String name) {
        this.name = name;
    }

    public Playlist(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Playlist(String name, String[] rules) {
        this.name = name;
        this.rules = rules;
    }

    public Playlist(String name) {
        this.name = name;
    }

    public Playlist() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String[] getRules() {
        return rules;
    }

    public void setRules(String[] rules) {
        this.rules = rules;
    }

    public boolean isIs_smart() {
        return is_smart;
    }

    public void setIs_smart(boolean is_smart) {
        this.is_smart = is_smart;
    }
}
