package seleniumTests;

import enumsO.Browsers;
import helpersO.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import models.GetPetResponse;
import models.Playlist;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LogInPage;
import pageObjects.MainPage;

import static io.restassured.RestAssured.given;

public class PlaylistCreationApiDeleteSelenium {
    protected WebDriver driver;
    public MainPage mainPage;
    public String playlistId;
    @BeforeMethod
    public void createPlaylistThroughAPI(){
        String token = Token.get("testpro.user03@testpro.io","te$t$tudent");
        Playlist newPlaylist = ObjectCreator.createPostPlaylistRequest(10);
        Response response = given()
                .baseUri("https://koelapp.testpro.io/")
                .basePath("api/playlist")
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .body(newPlaylist)
                .when()
                .post()
                .then()
                .statusCode(200)
                .extract()
                .response();
        var jsonPath = response.jsonPath();
        jsonPath.prettyPrint();
        Playlist playlist = jsonPath.getObject("$",Playlist.class);
        int pl = playlist.getId();
        playlistId=Integer.toString(pl);
    }
    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if(iTestResult.getStatus() ==iTestResult.FAILURE){
            GetScreenshot.capture(driver,iTestResult.getName());
        }
        driver.quit();
    }
    @Test
    public void deletePlaylistInSelenium() throws NoSuchFieldException {
        System.setProperty("webdriver.safari.noinstall", "true");
        driver = new SafariDriver();
        driver.get("https://koelapp.testpro.io");
        driver.manage().window().maximize();
        LogInPage logInPage = new LogInPage(driver);
        mainPage = logInPage.logInToApp("testpro.user03@testpro.io","te$t$tudent"); //"testpro.user03@testpro.io","te$t$tudent"
        mainPage.deletePlaylist(playlistId);
       Assert.assertTrue(mainPage.checkByUrl(playlistId));
    }

}
