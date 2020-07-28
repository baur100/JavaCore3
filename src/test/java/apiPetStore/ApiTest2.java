package apiPetStore;

import helpers.TestObjectCreator;
import io.restassured.response.Response;
import models.PostPetRequest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.authentication;
import static io.restassured.RestAssured.given;

public class ApiTest2 {
    private long petId;
    private PostPetRequest petRequest;

//    @Test
//    public void createPet(){
//        petRequest = TestObjectCreator.createPostRetRequest();
//        Response response = given()
//                .baseUri("https://koelapp.testpro.io/")
//                .basePath("api/playlist")
//                .header("Authorization","Bearer "+ )
//    }

}
