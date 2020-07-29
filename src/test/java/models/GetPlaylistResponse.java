package models;

public class GetPlaylistResponse {
    private String name;
    private int id;
    private String[] songs;
    private String status;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
