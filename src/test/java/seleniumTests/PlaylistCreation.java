package seleniumTests;

import enumsO.Browsers;
import helpersO.BrowserFabric;
import helpersO.Token;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LogInPage;
import pageObjects.MainPage;

import static io.restassured.RestAssured.given;

public class PlaylistCreation {
    public MainPage mainPage;
    private String playlistId;
    protected WebDriver driver;

    @BeforeMethod
    public void startUp(){

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver=new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1400,1000");
        driver.get("https://koelapp.testpro.io");
        //driver.manage().window().maximize();

    }

    @AfterMethod
    public void  tearDown(){
        System.out.println(playlistId);
        driver.quit();
        String token = Token.get("testpro.user03@testpro.io","te$t$tudent");
        Response response = given()
                .baseUri("https://koelapp.testpro.io")
                .basePath("/playlist/"+playlistId)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer "+token)
                .when()
                .delete()
                .then()
                .statusCode(404)
                .extract()
                .response();
    }


  @Test
    public void createPlaylist(){
        LogInPage logInPage = new LogInPage(driver);
        mainPage = logInPage.logInToApp("testpro.user03@testpro.io","te$t$tudent"); //"testpro.user03@testpro.io","te$t$tudent"
        playlistId = mainPage.createPlaylist("Playlist TEST");
        Assert.assertTrue(mainPage.checkByUrl(playlistId));
    }
}
