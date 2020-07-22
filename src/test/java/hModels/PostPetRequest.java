package hModels;

public class PostPetRequest {
    private long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tag[] tags;
    private String status;

    public PostPetRequest(long id, Category category, String name, String[] photoUrls, Tag[] tags, String status) {

        this.category = category;
        this.name = name;
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }
}


