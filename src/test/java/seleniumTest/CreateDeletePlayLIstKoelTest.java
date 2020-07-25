package seleniumTest;

import helpers.Tokenz;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateDeletePlayLIstKoelTest extends RefactoringOverallMethods {
    private String playlistId;

    @Test
    public void CreatePlayListKoel() {
        playlistId = mainPage.createPlaylist("dgsreger");
        Assert.assertTrue(mainPage.checkPlaylist("dgsreger"));
    }

    @Test
    public void DeletePlayListKoel() {
        String token = Tokenz.get("koeluser03@testpro.io", "te$t$tudent");
        given()
                .baseUri("https://koelapp.testpro.io/")
                .basePath("api/playlist/" + playlistId)
                .header("Authorization","Bearer " + token)
            .when()
                .delete()
            .then()
                .statusCode(200);
    }
}
