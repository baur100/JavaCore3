package My_models;

public class My_GetPetResponse {
    private long id;
    private My_Category my_category;
    private String name;
    private String[] photoUrls;
    private My_Tag[] my_tags;
    private String status;

    public long getId() {
        return id;
    }

    public My_Category getCategory() {
        return my_category;
    }

    public String getName() {
        return name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public My_Tag[] getTags() {
        return my_tags;
    }

    public String getStatus() {
        return status;
    }

}
