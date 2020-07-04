package SeleniumTests;

import enums.Browsers;
import helpers.BrowserFabric;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;

    @Parameters({"email", "password"})
    @BeforeMethod
    public void startUp(String loginID, String pwd) throws NoSuchFieldException {
        driver = BrowserFabric.getDriver(Browsers.CHROME);
        driver.get("https://koelapp.testpro.io/");
        LoginPage loginPage = new LoginPage(driver);
        mainPage = loginPage.loginToApp(loginID, pwd);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
