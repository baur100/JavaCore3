package seleniumTests;

import listener.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LogInPage;
import passenger.TicketPrice;

public class LoginTest extends BaseTest{

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void loginTest_CorrectCredentials_LoggedToApp(){
        Assert.assertTrue(mainPage.isMain());
    }

    @Test
    public void loginTest_CorrectCredentials_LoggedToApp1(){
        Assert.assertTrue(mainPage.isMain());
    }

    @Test
    public void loginTest_CorrectCredentials_LoggedToApp2(){
        Assert.assertTrue(mainPage.isMain());
    }

    @Test
    public void loginTest_CorrectCredentials_LoggedToApp3(){
        Assert.assertTrue(mainPage.isMain());
    }

    @Test
    public void loginTest_CorrectCredentials_LoggedToApp4(){
        Assert.assertTrue(mainPage.isMain());
    }
//    @Test
//    public void loginTest_WrongCredentials_Error(){
//        LogInPage loginPage = new LogInPage(driver);
//        loginPage.logInToApp("testpro.user03@testpro.io","1111111");
//        Assert.assertTrue(loginPage.isError());
//
//    }
//    @DataProvider(name = "Ages")
//    public Object[][] createData(){
//        return new Object[][]{
//                {1,1000,0.0},
//                {5,1000,500.0},
//                {15,1000,1000.0},
//                {68,1000,800.0}
//
//        };
//    }
//    @Test(dataProvider = "Ages")
//    public void ticketPriceForDifferentAgeGroups (int age, int fare, double result){
//        //Arrange
//        TicketPrice calculator = new TicketPrice();
//        double ticketPrice = calculator.getTicketPrice(age,fare);
//        Assert.assertEquals(ticketPrice,result);
//    }

//    @Test
//    public void ticketPriceForInfant(){
//        //Arrange
//        TicketPrice calculator = new TicketPrice();
//        double ticketPrice = calculator.getTicketPrice(1,1000);
//        Assert.assertEquals(ticketPrice,0.0);
//    }
}
