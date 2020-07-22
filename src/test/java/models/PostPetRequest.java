package models;

public class PostPetRequest {
    private long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tags[] tags;
    private String status;

    public PostPetRequest(Category category, String name, String status) {
        this.category = category;
        this.name = name;
        this.status = status;
    }

    public PostPetRequest(long id, Category category, String name, String[] photoUrls, Tags[] tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

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
