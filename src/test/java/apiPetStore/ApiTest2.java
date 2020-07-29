package apiPetStore;

import helpers.TestObjectCreator;
import helpers.Token;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import models.GetPlaylistResponse;
import models.PostPlaylistRequest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class ApiTest2 {

    private int playlistId;
    private PostPlaylistRequest playlistRequest;

    @Test(priority = 1)
    public int createPlaylist(){
        playlistRequest = TestObjectCreator.createPostPlaylistRequest();
        String token = Token.get("testpro.user03@testpro.io", "te$t$tudent");
        Response response = given()
                .baseUri("https://koelapp.testpro.io/")
                .basePath("api/playlist")
                .header("Authorization","Bearer "+ token)
                .header("Content-Type", "application/json")
                .body(playlistRequest)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .response();

        JsonPath jsonPath = response.jsonPath();
//        jsonPath.prettyPrint();
        GetPlaylistResponse playlist = jsonPath.getObject("$", GetPlaylistResponse.class);
        playlistId = playlist.getId();
        return playlistId;
    }
}
