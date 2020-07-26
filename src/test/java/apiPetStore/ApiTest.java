package apiPetStore;

import com.google.gson.Gson;
import helpersO.ObjectCreator;
import helpersO.TestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.GetPetResponse;
import models.PostPetRequest;
import models.Status;
import org.testng.Assert;
import org.testng.annotations.Test;
import storeModels.GetStoreResponse;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiTest {
    private long petId;
    private  PostPetRequest petRequest;
    @Test
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
//        Gson gson = new Gson();
//        gson.fromJson(jsonPath, GetPetResponse.class);
        System.out.println(jsonPath.prettify());
        GetPetResponse pet = jsonPath.getObject("$",GetPetResponse.class);

    }
    @Test
    public void getByStatus(){
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/findByStatus")
                .queryParam("status","pending")
                .when()
                .get()

                .then()
                .statusCode(200)
                .extract()
                .response();
        var jsonPath = response.jsonPath();
        List<GetPetResponse> list = Arrays.asList(jsonPath.getObject("$",GetPetResponse[].class));
        System.out.println(list.size());
        System.out.println(list.get(0).getName());
    }

    @Test(priority = 1)
    public void createPets(){
        this.petRequest = ObjectCreator.createPostPetRequest();
//        Gson gson = new Gson();   ---NO NEED, REST-ASSURED GOT THIS---
//        String body = gson.toJson(petRequest);
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet")
                .contentType(ContentType.JSON)
                .body(petRequest)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .response();
   var jsonPath = response.jsonPath();
   jsonPath.prettyPrint();
   GetPetResponse pet = jsonPath.getObject("$",GetPetResponse.class);
   petId = pet.getId();
   Assert.assertEquals(pet.getStatus(),petRequest.getStatus());
   Assert.assertEquals(pet.getName(),petRequest.getName());
        Assert.assertEquals(pet.getCategory().getName(),petRequest.getCategory().getName());
        Assert.assertEquals(pet.getCategory().getId(),petRequest.getCategory().getId());
    }
@Test(priority = 2)
public void updatePetName(){
        String newName = TestData.randomString(12);
        petRequest.setId(petId);
        petRequest.setName(newName);
    Response response = given()
            .baseUri("https://petstore.swagger.io/v2")
            .basePath("/pet")
            .contentType(ContentType.JSON)
            .body(petRequest)
            .when()
            .put()
            .then()
            .statusCode(200)
            .extract()
            .response();
    var jsonPath = response.jsonPath();
    jsonPath.prettyPrint();
    GetPetResponse pet = jsonPath.getObject("$",GetPetResponse.class);
    Assert.assertEquals(pet.getStatus(),petRequest.getStatus());
    Assert.assertEquals(pet.getName(),newName);
    Assert.assertEquals(pet.getCategory().getName(),petRequest.getCategory().getName());
    Assert.assertEquals(pet.getCategory().getId(),petRequest.getCategory().getId());
    Assert.assertEquals(pet.getId(),petId);
}

//Homework - delete a pet
@Test(priority = 3)
public void deletePet(){
    Response response = given()
            .baseUri("https://petstore.swagger.io/v2")
            .basePath("/pet/"+petId)
            .contentType(ContentType.JSON)
            .body(petRequest)
            .when()
            .delete()
            .then()
            .statusCode(200)
            .extract()
            .response();
    var jsonPath = response.jsonPath();
    jsonPath.prettyPrint();
    GetPetResponse pet = jsonPath.getObject("$",GetPetResponse.class);
    Assert.assertNull(pet.getName());
}

//What I do by myself
    @Test
    public void getOrder(){
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/store/order/2")
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();
        var jsonPath = response.jsonPath();
        System.out.println(jsonPath.prettify());
        GetStoreResponse order = jsonPath.getObject("$",GetStoreResponse.class);
        //Assert.assertEquals(order.getStatus(),"placed");
        //Assert.assertEquals(order.isComplete(),true);
    }

    @Test
    public void getOrdersByStatus(){
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/store/inventory")
                .queryParam("status","pending")
                .when()
                .get()

                .then()
                .statusCode(200)
                .extract()
                .response();
        //var jsonPath = response.jsonPath();
        //List<GetStoreResponse> list = Arrays.asList(jsonPath.getObject("$",GetStoreResponse[].class));
        //System.out.println(list.size());
        //System.out.println(list.get(0).getName());
    }
}
