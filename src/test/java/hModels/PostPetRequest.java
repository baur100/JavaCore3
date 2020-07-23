package hModels;

public class PostPetRequest {
    private long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tag[] tags;
    private String status;

    public PostPetRequest(Category category, String name, String status) {

        this.category = category;
        this.name = name;
        this.status = status;
    }

    public void setId(long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public Category getCategory() { return category; }

    public String getName() { return name; }

    public String getStatus() { return status; }

    public long getId() { return id; }
}


