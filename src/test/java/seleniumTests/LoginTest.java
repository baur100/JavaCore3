package seleniumTests;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest extends  BasedTest{

    @Test
    public void loginTest_CorrectCredentials_LoggedToApp() throws InterruptedException {

        Assert.assertTrue(mainPage.isMain());

    }
    @Test(enabled = false)
    public void loginTest_CorrectCredentials_LoggedToApp1() throws InterruptedException {

        Assert.assertTrue(mainPage.isMain());

    }
    @Test
    public void loginTest_CorrectCredentials_LoggedToApp2() throws InterruptedException {

        Assert.assertTrue(mainPage.isMain());

    }
    @Test
    public void loginTest_CorrectCredentials_LoggedToApp3() throws InterruptedException {

        Assert.assertTrue(mainPage.isMain());

    }
    @Test
    public void loginTest_CorrectCredentials_LoggedToApp4() throws InterruptedException {

        Assert.assertTrue(mainPage.isMain());

    }
    @Test
    public void loginTest_CorrectCredentials_LoggedToApp5() throws InterruptedException {

        Assert.assertTrue(mainPage.isMain());

    }

//    @Test
//    public void loginTest_WrongCredentials_Error() {
//        Assert.assertTrue(loginPage.isError());
//
//    }
}
