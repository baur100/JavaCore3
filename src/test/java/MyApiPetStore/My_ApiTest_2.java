package MyApiPetStore;

import My_models.My_Category;
import My_models.My_GetPetResponse;
import helpers.TestData;
import helpers.TestObjectCreator;
import io.restassured.response.Response;
import models.Category;
import models.GetPetResponse;
import models.PostPetRequest;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class My_ApiTest_2 {
    private long petId;
    private PostPetRequest petRequest;
    @Test(enabled=false)
    public void getPet(){
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/100")
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();

        var jsonPath = response.jsonPath();
        System.out.println(jsonPath.prettify());

        var status = jsonPath.getString("status");
        System.out.println(status);

        My_Category cat = jsonPath.getObject("category", My_Category.class);
        System.out.println(cat.getId());

        System.out.println(jsonPath);

        My_GetPetResponse pet = jsonPath.getObject("$", My_GetPetResponse.class);

        Assert.assertEquals(pet.getStatus(), "available");
        Assert.assertEquals(pet.getName(), "piper");
    }
    @Test(enabled=false)
    public void getByStatus(){
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/findByStatus")
                .queryParam("status", "available")
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();
        var jsonPath = response.jsonPath();
        List<My_GetPetResponse> list = Arrays.asList(jsonPath.getObject("$", My_GetPetResponse[].class));
        System.out.println(list.size());
        System.out.println(list.get(0).getName());
    }
    @Test(priority=1)
    public void createPet(){
        petRequest = TestObjectCreator.createPostRetRequest();
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet")
                .header("Content-Type","application/json")
                .body(petRequest)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .response();
        var jsonPath = response.jsonPath();

        GetPetResponse pet = jsonPath.getObject("$",GetPetResponse.class);
        petId = pet.getId();

        Assert.assertEquals(pet.getStatus(),petRequest.getStatus());
        Assert.assertEquals(pet.getName(),petRequest.getName());
        Assert.assertEquals(pet.getCategory().getName(),petRequest.getCategory().getName());
        Assert.assertEquals(pet.getCategory().getId(),petRequest.getCategory().getId());
//        var headers = response.getHeaders();
//        System.out.println(headers.size());
    }
    @Test(priority=2)
    public void updatePetName(){
        String newName = TestData.randomString(12);
        petRequest.setId(petId);
        petRequest.setName(newName);
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet")
                .header("Content-Type","application/json")
                .body(petRequest)
                .when()
                .put()
                .then()
                .statusCode(200)
                .extract()
                .response();
        var jsonPath = response.jsonPath();

        GetPetResponse pet = jsonPath.getObject("$",GetPetResponse.class);

        Assert.assertEquals(pet.getStatus(),petRequest.getStatus());
        Assert.assertEquals(pet.getName(),newName);
        Assert.assertEquals(pet.getCategory().getName(),petRequest.getCategory().getName());
        Assert.assertEquals(pet.getCategory().getId(),petRequest.getCategory().getId());
        Assert.assertEquals(pet.getId(),petId);
    }
    @Test(priority=3)
    public void deletePetName(){
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/+petId")
                .header("Content-Type","application/json")
                .when()
                .delete()
                .then()
                .statusCode(200)
                .extract()
                .response();
    }
}
