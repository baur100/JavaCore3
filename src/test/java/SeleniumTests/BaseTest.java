package SeleniumTests;

import enums.Browsers;
import helpers.BrowserFabric;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeMethod
    public void startUp() throws NoSuchFieldException {
        driver = BrowserFabric.getDriver(Browsers.CHROME);
        driver.get("https://koelapp.testpro.io/");
        LoginPage loginPage = new LoginPage(driver);
        mainPage = loginPage.loginToApp("koeluser21@testpro.io", "te$t$tudent");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
