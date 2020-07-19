package models_1;

public class GetPetResponse_1 {
    private int id;
    private Category_1 category_1;
    private String name;
    private String[] photoUrls;
    private Tag_1[] tags_1;

    public int getId() {
        return id;
    }

    public Category_1 getCategory_1() {
        return category_1;
    }

    public String getName() {
        return name;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public Tag_1[] getTags_1(){
            return tags_1;
}

    public String getStatus() {
        return status;
    }

    private String status;
}
