package apiTestsNG;

import helpers.TestDataApi;
import helpers.Tokenz;
import io.restassured.response.Response;
import modelsz.GetPetsResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumTest.RefactoringOverallMethods;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;

public class CreatePLApiDeleteSelenium extends RefactoringOverallMethods {
    private String playListName;
    @Test
    public void createApiPlayList() {
        String token = Tokenz.get("koeluser03@testpro.io", "te$t$tudent");
        playListName = TestDataApi.rendomPetz(8);
        Response response = given()
                .baseUri("https://koelapp.testpro.io/")
                .basePath("/api/playlist")
                .queryParam("name", playListName)
                .header("Authorization", "Bearer " + token)
            .when()
                .post()
            .then()
                .statusCode(200)
                .extract()
                .response();
        var jsonPath = response.jsonPath();
        System.out.println(playListName);
    }
    @Test
    public void deletePlayList() {
        mainPage.deletePlayList(playListName);
        Assert.assertFalse(mainPage.checkPlaylist(playListName));
    }
}
