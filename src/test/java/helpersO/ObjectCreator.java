package helpersO;

import models.Category;
import models.PostPetRequest;
import models.Status;

import java.util.Random;

public class ObjectCreator {
    public static PostPetRequest createPostPetRequest(){
        Random random = new Random();
        int categoryId = random.nextInt(15)+1;
        Category category = new Category(categoryId,TestData.randomString(8));
        return new PostPetRequest(category,TestData.randomString(12), Status.available.toString());

    }
}
