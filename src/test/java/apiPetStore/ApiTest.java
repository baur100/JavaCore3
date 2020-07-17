package apiPetStore;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTest {
    @Test
    public void getPet(){
        Response response =
        given()
                .baseUri("https://petstore.swagger.io/v2")
                .basePath("/pet/100")
        .when()
                .get()
        .then()
                .statusCode(200)
                .extract()
                .response();
        String res = response.getBody().print();
              Assert.assertTrue(true);
              //Assert.assertTrue(res.contains("XXXZZZ"));
    }
}
