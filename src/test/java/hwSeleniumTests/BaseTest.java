package hwSeleniumTests;

import enums.Browsers;
import helpers.BrowserFabric;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    protected WebDriver driver;
    @Parameters({"browser"})
    @BeforeMethod
    public void startUp(String browserName) throws NoSuchFieldException {
        Browsers browser;
        if (browserName.equals("CHROME")) {
            browser = Browsers.CHROME;
        }else {
            browser = Browsers.FIREFOX;
        }
        driver= BrowserFabric.getDriver(browser);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://koelapp.testpro.io");
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
