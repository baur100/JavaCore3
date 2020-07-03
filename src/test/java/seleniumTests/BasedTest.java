package seleniumTests;

import enums.Browsers;
import helpers.BrowserFabric;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasedTest {
    protected WebDriver driver;
    protected MainPage mainPage;
    @Parameters({"email","password"})
    @BeforeMethod
    public void startUp(String loginId, String pwd) throws NoSuchFieldException {

        driver= BrowserFabric.getDriver(Browsers.CHROME);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://koelapp.testpro.io");
        LoginPage loginPage = new LoginPage(driver);
        mainPage = loginPage.loginToApp(loginId, pwd);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
//"testpro.user03@testpro.io", "te$t$tudent"
