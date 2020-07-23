package MyApiPetStore;

import My_models.My_Category;
import My_models.My_GetPetResponse;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class My_ApiTest_2 {
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
    @Test
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
}
