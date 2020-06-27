package hwPageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import java.util.concurrent.TimeUnit;

public class PlaylistTest {
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
    public void playlistTests_createPlaylist_PlaylistCreated_renameTest(){
        pageObjects.LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp("testpro.user03@testpro.io","te$t$tudent");
        String playlistid = mainPage.createPlaylist("Top10");
        String renameClickOnTop10 =mainPage.createPlaylist("King");

        Assert.assertTrue(mainPage.checkPlaylist(playlistid));
    }




}
