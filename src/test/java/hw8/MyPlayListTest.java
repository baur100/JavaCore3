package hw8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import java.util.concurrent.TimeUnit;

public class MyPlayListTest {
    WebDriver driver;

    @BeforeMethod
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://koelapp.testpro.io");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void playlistTests_createPlaylist_PlaylistCreated() {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp("testpro.user03@testpro.io", "te$t$tudent");
        String playlistId = mainPage.createPlaylist("MICHAEL_JS");
        Assert.assertTrue(mainPage.checkPlaylist(playlistId));
    }

    @Test
    public void playlistTests_renamePlaylistRenamed(){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp("testpro.user03@testpro.io", "te$t$tudent");
        String playlistId = mainPage.createPlaylist("MICHAEL_JS");
        mainPage.renamePlaylist(playlistId, "MICHAEL_js");
    }
}
