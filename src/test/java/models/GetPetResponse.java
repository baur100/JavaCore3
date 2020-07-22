package models;

public class GetPetResponse {
    private long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tags[] tags;
    private String status;

    public long getId() {
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

    public Tags[] getTags() {
        return tags;
    }

    public String getStatus() {
        return status;
    }
}
