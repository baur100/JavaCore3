package MyApiPetStore;

import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class MyApiTest {
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

        String res = response.getBody().print();

        Assert.assertTrue(res.contains("temporary test string"));
    }
}
