package seleniumTests;

import listeners.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import passenger.TicketPrice;

public class LoginTest extends BaseTest {
    @Parameters({"email","wrong-password"})
    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginTest_CorrectCredentials_LoggedToApp(String loginId,String pwd){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp(loginId,pwd);
        Assert.assertTrue(mainPage.isMain());
    }
    @Parameters({"email","password"})
    @Test
    public void loginTest_CorrectCredentials_LoggedToApp1(String loginId,String pwd){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp(loginId,pwd);
        Assert.assertTrue(mainPage.isMain());
    }
    @Parameters({"email","password"})
    @Test
    public void loginTest_CorrectCredentials_LoggedToApp2(String loginId,String pwd){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp(loginId,pwd);
        Assert.assertTrue(mainPage.isMain());
    }
    @Parameters({"email","password"})
    @Test
    public void loginTest_CorrectCredentials_LoggedToApp3(String loginId,String pwd){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp(loginId,pwd);
        Assert.assertTrue(mainPage.isMain());
    }
    @Parameters({"email","password"})
    @Test
    public void loginTest_CorrectCredentials_LoggedToApp4(String loginId,String pwd){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp(loginId,pwd);
        Assert.assertTrue(mainPage.isMain());
    }
    @DataProvider(name = "Ages")
    public Object[][] createData(){
        return new Object[][] {
                {1,1000,0.0},
                {5,1000,500.0},
                {15,1000,1000.0},
                {68,1000,800.0}
        };
    }

    @Test (dataProvider = "Ages")
    public void ticketPriceCalculator(int age, int fare, double result){
        TicketPrice calculator = new TicketPrice();
        double ticketPrice = calculator.getTicketPrice(age,fare);
        Assert.assertEquals(ticketPrice,result);
    }

}
