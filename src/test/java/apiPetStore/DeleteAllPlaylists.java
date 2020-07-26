package apiPetStore;

import helpersO.GetAllData;
import helpersO.Token;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.DataResponse;
import models.Playlist;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteAllPlaylists {
    @Test
    public void deleteThem() {
        DataResponse data = GetAllData.data();
        Playlist[] playlists = data.playlists;
        for (Playlist pl : playlists) {
            String token = Token.get("testpro.user03@testpro.io", "te$t$tudent");
            given()
                    .baseUri("https://koelapp.testpro.io/")
                    .basePath("api/playlist/" + pl.id)
                    .header("Authorization", "Bearer " + token)
                    .when()
                    .delete()
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();
        }
    }
}
