package helpers;

import enums.PetStatus;
import models.Category;
import models.PostPetRequest;

import java.util.Random;

public class TestObjectCreator {
    public static PostPetRequest createPostRetRequest(){
        Random random = new Random();
        int categoryId = random.nextInt(15)+1;
        Category category = new Category(categoryId, TestData.randomString(8));
        return new PostPetRequest(category,TestData.randomString(12), PetStatus.available.toString());
    }
}
