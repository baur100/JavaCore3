package helpersO;

import io.restassured.response.Response;
import models.DataResponse;
import models.GetPetResponse;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetAllData {
    public static DataResponse data(){
        String token = Token.get("testpro.user03@testpro.io","te$t$tudent");
        Response response = given()
                .baseUri("https://koelapp.testpro.io/api")
                .basePath("/data")
                .header("Authorization","Bearer "+token)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();
        var jsonPath = response.jsonPath();
        return jsonPath.getObject("$",DataResponse.class);
    }

}
