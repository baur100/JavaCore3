package seleniumTests;

import helpers.Token;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import static io.restassured.RestAssured.given;

public class PlaylistXreationTest{
    private WebDriver driver;
    private String playlistId;
    @BeforeMethod
    public void startUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://koelapp.testpro.io");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
        System.out.println(playlistId);
        String token = Token.get("testpro.user03@testpro.io", "te$t$tudent");
        given()
                .baseUri("https://koelapp.testpro.io/")
                .basePath("api/playlist/"+playlistId)
                .header("Authorization","Bearer "+token)
                .when()
                .delete()
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    @Test
    public void createPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp("testpro.user03@testpro.io", "te$t$tudent");
        playlistId = mainPage.createPlaylist("xxxxx");
        Assert.assertTrue(mainPage.checkPlaylist(playlistId));
    }
}
