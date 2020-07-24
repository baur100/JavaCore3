package apiPetStore;

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

public class ApiTest {
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

        var status=jsonPath.getString("status");
        System.out.println(status);

        Category cat = jsonPath.getObject("category",Category.class);
        Assert.assertEquals(cat.getId(),1);
        Assert.assertEquals(cat.getName(),"cat");

        GetPetResponse pet = jsonPath.getObject("$", GetPetResponse.class);

        Assert.assertEquals(pet.getStatus(),"sold");
        Assert.assertEquals(pet.getName(),"Grumpy very Catty");
    }
    @Test(enabled=false)
    public void getByStatus(){
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/findByStatus")
                .queryParam("status","sold")
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();
        var jsonPath = response.jsonPath();
        GetPetResponse[] arr = jsonPath.getObject("$",GetPetResponse[].class);
        List<GetPetResponse> list = Arrays.asList(jsonPath.getObject("$",GetPetResponse[].class));
//        System.out.println(list.size());
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
    public void deletePet(){
        System.out.println(petId);
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/"+petId)
                .when()
                .delete()
                .then()
                .statusCode(200)
                .extract()
                .response();
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/"+petId)
                .when()
                .delete()
                .then()
                .statusCode(404)
                .extract()
                .response();
    }
}
