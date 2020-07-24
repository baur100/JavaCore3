package seleniumTest;

import listeners.RetryAnalyzer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import passenger.TicketPrice;

import java.util.concurrent.TimeUnit;

public class LoginTest extends RefactoringOverallMethods{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginTest_CorrectCredentials_LoggedToApp() {
        Assert.assertTrue(mainPage.isMain());
    }
    /*@Test
    public void loginTest_WrongCredentials_Error() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApp("testpro.user03@testpro.io", "1111111");
        Assert.assertTrue(loginPage.isError());
    }*/
    @Test
    public void loginTest_CorrectCredentials_LoggedToApp1() {
        Assert.assertTrue(mainPage.isMain());
    }
    @Test
    public void loginTest_CorrectCredentials_LoggedToApp2() {
        Assert.assertTrue(mainPage.isMain());
    }
    @Test
    public void loginTest_CorrectCredentials_LoggedToApp3() {
        Assert.assertTrue(mainPage.isMain());
    }

    @DataProvider(name = "Ages")
    public Object[][] createData() {
        return new Object[][]{
                {1, 1000, 0.0},
                {5, 1000, 500.0},
                {15, 1000, 1000.0},
                {68, 1000, 800.0}
        };
    }

    @Test (dataProvider = "Ages")
    public void ticketPriceCalculator(int age, int fare, double result) {
        TicketPrice calculator = new TicketPrice();
        double ticketPrice = calculator.getTicketPrice(age, fare);
        Assert.assertEquals(ticketPrice, result);
    }
}
