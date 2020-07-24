package helpers;

import enums.PETSTATUS;
import modelsz.Category;
import modelsz.PostPetRequests;

import java.util.Random;

public class TestObjectCreattor {
    public static PostPetRequests createPostPetzsRequest() {
        Random rendom = new Random();
        int categoryId = rendom.nextInt(15)+1;
        long id = rendom.nextInt();
        Category category = new Category(categoryId, TestDataApi.rendomPetz(8));
        return new PostPetRequests(id, category, TestDataApi.rendomPetz(12), PETSTATUS.available.toString());
    }

}
