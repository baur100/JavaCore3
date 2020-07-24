package helpers;

import io.restassured.response.Response;
import models.Credentials;
import models.TokenResponse;

import static io.restassured.RestAssured.given;

public class Token {
    public static String get(String username, String password){
        Credentials credentials = new Credentials(username,password);
        Response response = given()
                .baseUri("https://koelapp.testpro.io/api")
                .basePath("/me")
                .header("Content-Type","application/json")
                .body(credentials)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .response();
        var jsonPath = response.jsonPath();

        TokenResponse token = jsonPath.getObject("$", TokenResponse.class);
        return token.getToken();
    }
}
