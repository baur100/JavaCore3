package My_models;

import models.Category;
import models.Tag;

public class My_PostPetRequest {
    private long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tag[] tags;
    private String status;

    public My_PostPetRequest(Category category, String name, String status) {
        this.category = category;
        this.name = name;
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
