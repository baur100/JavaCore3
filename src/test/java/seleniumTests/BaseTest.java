package seleniumTests;

import enums.Browsers;
import helpers.BrowserFabric;
import helpers.GetScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver driver;
    @Parameters({"browser"})
    @BeforeMethod
    public void startUp(String browserName) throws NoSuchFieldException {
        Browsers browser;
        if(browserName.equals("CHROME")){
            browser = Browsers.CHROME;
        } else {
            browser = Browsers.FIREFOX;
        }

        driver= BrowserFabric.getDriver(browser);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://koelapp.testpro.io");
    }
    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws InterruptedException {
        if(iTestResult.getStatus()==iTestResult.FAILURE){
            GetScreenshot.capture(driver,iTestResult.getName());
        }
        driver.quit();
    }
}

