package SeleniumTests;

import enums.Browsers;
import helpers.BrowserFabric;
import helpers.GetScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageObjects.LoginPage;
import pageObjects.MainPage;


public class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;

    @Parameters({"email", "password", "browser", "url"})

    @BeforeMethod
    public void startUp(String loginID, String pwd, String browserName, String url) throws NoSuchFieldException {

        Browsers browser;
        if (browserName.equals("CHROME")) {
            browser = Browsers.CHROME;
        } else {
            browser = Browsers.FIREFOX;
        }

        driver = BrowserFabric.getDriver(browser);
        driver.get(url);
        LoginPage loginPage = new LoginPage(driver);
        mainPage = loginPage.loginToApp(loginID, pwd);
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws InterruptedException {
        if (iTestResult.getStatus() == iTestResult.FAILURE) {
            System.out.println("test failed: " + iTestResult.getName());
            GetScreenshot.capture(driver, iTestResult.getName());
        }
        driver.quit();
    }
}
