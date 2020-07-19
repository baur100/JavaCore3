package seleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import java.util.concurrent.TimeUnit;

public class PlaylistTests {
    WebDriver driver;

    @BeforeMethod
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
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
    public void verifyPlayListCreation() {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp("testpro.user03@testpro.io", "te$t$tudent");
        mainPage.waitForPage();
        mainPage.createPlaylist("Summer Hits");

        Assert.assertTrue(mainPage.checkPlaylist("Summer Hits"), "Playlist not found");
    }

    @Test
    public void verifyRenamingPlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp("testpro.user03@testpro.io", "te$t$tudent");
        String initialTitle = "Summer Hits";
        String expectedTitle = "expectedTitle";
        mainPage.waitForPage();
        mainPage.createPlaylist(initialTitle);

        String playListID = mainPage.getPlayListIDFromURL();
        mainPage.renamePlayList(playListID, expectedTitle);
        String actualTitle = mainPage.getPlayListTitle(playListID);
        Assert.assertEquals(actualTitle, expectedTitle, "Title wasn't changed!");
    }

    //    @Test
//    public void playlistTests_createPlaylist_PlaylistCreated(){
//        LoginPage loginPage = new LoginPage(driver);
//        MainPage mainPage = loginPage.loginToApp("testpro.user03@testpro.io","te$t$tudent");
//        String playlistId = mainPage.createPlaylist("xxxxx");
//        Assert.assertTrue(mainPage.checkPlaylist(playlistId));
//    }

}
