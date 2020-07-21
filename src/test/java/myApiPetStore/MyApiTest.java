package myApiPetStore;

import io.restassured.response.Response;
import models.Category;
import models.GetPetResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class MyApiTest {
    @Test
    public void getPet(){
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/1025")
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

        Category dog = jsonPath.getObject("category",Category.class);
        Assert.assertEquals(dog.getId(),0);
        Assert.assertEquals(dog.getName(),"dog");

        GetPetResponse pet = jsonPath.getObject("$",GetPetResponse.class);

        Assert.assertEquals(pet.getStatus(),"sold");
        Assert.assertEquals(pet.getName(),"Teddy");
    }
    @Test
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
}
