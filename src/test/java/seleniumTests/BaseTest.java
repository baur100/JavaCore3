package seleniumTests;


import enumsO.Browsers;
import helpersO.BrowserFabric;
import helpersO.GetScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import pageObjects.LogInPage;
import pageObjects.MainPage;

public class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;

    @Parameters({"email","password"})

    @BeforeMethod
    public void startUp(String loginId,String pwd) throws NoSuchFieldException {
        driver = BrowserFabric.getDriver(Browsers.CHROME);
        driver.get("https://koelapp.testpro.io");
        driver.manage().window().maximize();
        LogInPage logInPage = new LogInPage(driver);
        mainPage = logInPage.logInToApp(loginId,pwd); //"testpro.user03@testpro.io","te$t$tudent"
    }
    @AfterMethod
    public void tearDown(ITestResult iTestResult){
        if(iTestResult.getStatus() ==iTestResult.FAILURE){
            GetScreenshot.capture(driver,iTestResult.getName());
        }
        driver.quit();
    }
}
