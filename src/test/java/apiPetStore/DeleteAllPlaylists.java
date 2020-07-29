package apiPetStore;

import helpers.GetData;
import helpers.Token;
import models.DataResponse;
import models.Playlist;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteAllPlaylists {
    @Test
    public void deleteThem(){
        DataResponse data = GetData.data();
        Playlist[] playlists = data.playlists;
        for (Playlist pl : playlists){
            String token = Token.get("testpro.user03@testpro.io", "te$t$tudent");
            given()
                    .baseUri("https://koelapp.testpro.io/")
                    .basePath("api/playlist/"+pl.id)
                    .header("Authorization","Bearer "+token)
                    .when()
                    .delete()
                    .then()
                    .statusCode(200)
                    .extract()
                    .response();
        }
    }

}
