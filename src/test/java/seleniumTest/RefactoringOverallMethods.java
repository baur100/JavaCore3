package seleniumTest;

import enums.BROWSERS;
import helpers.BrowserFactory;
import helpers.GetScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import java.util.concurrent.TimeUnit;

public class RefactoringOverallMethods {
    protected WebDriver driver;
    protected MainPage mainPage;

    @BeforeMethod
    @Parameters({"browser", "url"})
    //public void startUp(String browser, String app)  throws InterruptedException {
    public void startUp() throws NoSuchFieldException {
        driver = BrowserFactory.getDriver(BROWSERS.FIREFOX);
        /*switch (browser) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("window-size=1400,1000");
                //options.addArguments("--headless");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                FirefoxOptions options1 = new FirefoxOptions();
                options1.addArguments("window-size=1400,1000");
                //options1.addArguments("--headless");
                driver = new FirefoxDriver(options1);
                break;
        }
        driver.get(app);*/


        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://koelapp.testpro.io");
        LoginPage loginPage = new LoginPage(driver);
        mainPage = loginPage.loginToApp("koeluser03@testpro.io", "te$t$tudent");
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws InterruptedException {
            if(iTestResult.getStatus()==iTestResult.FAILURE){
                GetScreenshot.capture(driver,iTestResult.getName());
            }
        Thread.sleep(5000);
        driver.quit();
    }

}
