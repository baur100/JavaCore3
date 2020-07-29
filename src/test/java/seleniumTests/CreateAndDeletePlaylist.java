package seleniumTests;

import apiPetStore.ApiTest2;
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

public class CreateAndDeletePlaylist {
    private WebDriver driver;
    private int playlistId;

    @BeforeMethod
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get("https://koelapp.testpro.io");
        ApiTest2 apiTest2 = new ApiTest2();
        playlistId = apiTest2.createPlaylist();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void deletePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp("testpro.user03@testpro.io", "te$t$tudent");
        mainPage.deletePlayList(playlistId);
        Assert.assertFalse(mainPage.checkPlaylistById(playlistId));
    }
}
