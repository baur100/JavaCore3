package UnitTests.Tests;

import UnitTests.PageObjects.LoginPage;
import UnitTests.PageObjects.MainPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Playlist {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void startDriver(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://koelapp.testpro.io");
        wait = new WebDriverWait(driver, 10);
    }

    @AfterMethod
    public void endTest(){
        driver.quit();
    }

    @Test
    public void createPlaylist() throws InterruptedException {
        LoginPage login = new LoginPage(driver, wait);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        MainPage main = login.login("koeluser03@testpro.io", "dGUkdCR0dWRlbnQ=");
        Assert.assertTrue(main.isMain());
        main.createPlaylist("RV_Playlist1");
        Assert.assertTrue(main.checkPlaylist("RV_Playlist1"));
    }

}
