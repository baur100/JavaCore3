package helpers;

import io.restassured.response.Response;
import models.DataResponse;
import models.GetPetResponse;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class GetData {
    public static DataResponse data(){
        Response response = given()
                .baseUri("https://koelapp.testpro.io/api")
                .basePath("/data")
                .when()
                .put()
                .then()
                .statusCode(200)
                .extract()
                .response();
        var jsonPath = response.jsonPath();

        return jsonPath.getObject("$",DataResponse.class);

    }
}
