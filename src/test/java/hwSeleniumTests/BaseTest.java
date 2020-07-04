package hwSeleniumTests;

import enums.Browsers;
import helpers.BrowserFabric;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    protected WebDriver driver;
    @BeforeMethod
    public void startUp() throws NoSuchFieldException {

        driver= BrowserFabric.getDriver(Browsers.CHROME);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://koelapp.testpro.io");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
