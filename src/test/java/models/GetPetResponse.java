package models;

public class GetPetResponse {
    private int id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tag[] tags;

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public Tag[] getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }

    private String status;
}
