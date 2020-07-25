package apiPetStr;

import helpers.GetKoelData;
import helpers.Tokenz;
import modelsz.DataResponse;
import modelsz.Playlist;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteAllPlaylistz {
    @Test
    public void deleteThem() {
        String token = Tokenz.get("koeluser03@testpro.io", "te$t$tudent");
        DataResponse data = GetKoelData.data();
        Playlist[] playlist = data.playlists;
        for (int i = 0; i < playlist.length; i++) {
            if (playlist[i].getName().startsWith("dg") ||
                playlist[i].getName().startsWith("new")) {
                System.out.println(playlist[i].getName());
                given()
                        .baseUri("https://koelapp.testpro.io/")
                        .basePath("api/playlist/" + playlist[i].id)
                        .header("Authorization","Bearer " + token)
                    .when()
                        .delete()
                    .then()
                        .statusCode(200);
            }
        }
    }
}
