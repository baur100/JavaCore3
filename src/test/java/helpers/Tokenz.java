package helpers;

import com.google.gson.Gson;
import io.restassured.response.Response;
import modelsz.CredentialsKoelApp;
import modelsz.GetPetsResponse;
import modelsz.TokenResp;

import static io.restassured.RestAssured.given;

public class Tokenz {
    public static String get(String userName, String password) {
        CredentialsKoelApp credentialsKoelApp = new CredentialsKoelApp(userName, password);

        Response response = given()
                .baseUri("https://koelapp.testpro.io/api")
                .basePath("/me")
                //.contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(credentialsKoelApp)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .response();

        var jsonPath = response.jsonPath();

        TokenResp token = jsonPath.getObject("$", TokenResp.class);
        return token.getToken();
    }
}
