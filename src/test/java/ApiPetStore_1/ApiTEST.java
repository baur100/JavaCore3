package ApiPetStore_1;

import Models_1.GetPetResponce;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTEST {
    @Test
    public void getPet(){
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/678956997512126")
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();
        GetPetResponce pet = jsonPath.getObject("$", GetPetResponce.class);


        Assert.assertEquals(true, true);
    }
}
