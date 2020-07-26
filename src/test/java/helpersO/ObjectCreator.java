package helpersO;

import models.Category;
import models.Playlist;
import models.PostPetRequest;
import models.Status;
import org.testng.annotations.Test;

import java.util.Random;

public class ObjectCreator {
    public static PostPetRequest createPostPetRequest(){
        Random random = new Random();
        int categoryId = random.nextInt(15)+1;
        Category category = new Category(categoryId,TestData.randomString(8));
        return new PostPetRequest(category,TestData.randomString(12), Status.available.toString());

    }

    public static Playlist createPostPlaylistRequest(int length){
        String name = TestData.randomString(length);
        String[] rules = new String[0];
        return new Playlist(name,rules);

    }
}
