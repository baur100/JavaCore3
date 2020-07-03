package seleniumTests;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import passenger.TicketPrice;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest extends BasedTest {

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

    @DataProvider(name = "Ages")
    public Object[][] createData() {
        return new Object[][]{
                {1, 1000, 0.0},
                {5, 1000, 500.0},
                {15, 1000, 1000.0},
                {68, 1000, 800.0}
        };
    }

    @Test(dataProvider = "Ages")
    public void ticketPriceForCalculator(int age,int fare, double result) {
        //Arrange
        TicketPrice calculator = new TicketPrice();
        double ticketPrice = calculator.getTicketPrice(age, fare);
        Assert.assertEquals(ticketPrice, result);
    }

    @Test
    public void ticketPriceForInfant() {
        //Arrange
        TicketPrice calculator = new TicketPrice();
        double ticketprice = calculator.getTicketPrice(1, 1000);
        Assert.assertEquals(ticketprice, 0.0);
    }
}
