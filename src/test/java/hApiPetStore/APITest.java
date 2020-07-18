package hApiPetStore;

import hModels.Category;
import hModels.GetPetResponse;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class APITest {
    @Test
    public void getPet() {
        Response response = given()
            .baseUri("https://petstore.swagger.io/v2")
            .basePath("/pet/999994978100056")
            .when()
            .get()
            .then()
            .statusCode(200)
            .extract()
            .response();
        String res = response.getBody().print();
//        JsonPath jsonPath = response.jsonPath();
        var jsonPath = response.jsonPath();

        var xx = jsonPath.getString("status");
        System.out.println(jsonPath.prettify());

        var status = response.jsonPath();
        System.out.println(status);

        Category cat = jsonPath.getObject("CATEGORY",Category.class);
        Assert.assertEquals(cat.getId(),1);
        Assert.assertEquals(cat.getName(),"cat");

        System.out.println(cat.getId());
//        System.out.println(jsonPath);

        GetPetResponse pet = jsonPath.getObject("$",GetPetResponse.class);

        Assert.assertEquals(pet.getStatus(),"sold");
        Assert.assertEquals(pet.getName(),"rax");

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
        List<GetPetResponse> list = Arrays.asList(jsonPath.getObject("$",GetPetResponse.class));
        System.out.println(list.get(0).getName());



    }
}
