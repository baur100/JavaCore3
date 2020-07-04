package SeleniumTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import passengerForDataProvider.TicketPrice;

public class LoginTest extends BaseTest {
    @Parameters({"email", "password"})

//    @DataProvider(name = "Credentials")
//        public Object[][] getData(){
//        return new Object[][] {
//                {"koeluser21@testpro.io", "te$t$tudent", true},
//                {"koeluser03@testpro.io", "te$t$tudent", true},
//                {"koeluser04@testpro.io", "te$t$tudent", true},
//                {"koeluser12222@testpro.io", "test$tudent", false}
//        };
//    }
//
//    @Test(dataProvider = "Credentials")
//    public void LoginToApp(String username, String password, boolean result){
//        System.out.println("Email= " + username);
//        LoginPage loginPage = new LoginPage(driver);
//        mainPage = loginPage.loginToApp(username, password);
//        Assert.assertTrue(mainPage.isMain());
//    }

    @Test
    public void loginTestCorrectCredentialsLoggedToApp(String logIn, String pwd) {
        Assert.assertTrue(mainPage.isMain());
    }
    @Parameters({"email", "password"})
    @Test
    public void loginTestCorrectCredentialsLoggedToApp1(String logIn, String pwd) {
        Assert.assertTrue(mainPage.isMain());
    }
    @Parameters({"email", "password"})
    @Test
    public void loginTestCorrectCredentialsLoggedToApp2(String logIn, String pwd) {
        Assert.assertTrue(mainPage.isMain());
    }
    @Parameters({"email", "password"})
    @Test
    public void loginTestCorrectCredentialsLoggedToApp3(String logIn, String pwd) {
        Assert.assertTrue(mainPage.isMain());
    }
    @Parameters({"email", "password"})
    @Test
    public void loginTestCorrectCredentialsLoggedToApp4(String logIn, String pwd) {
        Assert.assertTrue(mainPage.isMain());
    }

    // самая обычная функция, которвя будет возвращать какой то обьем data
    // DataProvider генерирует какую-то data
    @DataProvider(name="Ages")
    public Object[][] createData(){
        return new Object[][] {
                {1,1000,0.0},
                {5,1000,500},
                {15,1000,1000},
                {68, 1000,800}
        };
    }

    @Test (dataProvider = "Ages")
    public void ticketPriceCalculator(int age, int fare, double result){
        //Arrange
        TicketPrice calculator = new TicketPrice();
        //Act
        double ticketPrice = calculator.getTicketPrice(age, fare);
        //Assert
        Assert.assertEquals(ticketPrice, result);
    }
//    @Test
//    public void ticketPriceForInfant(){
//        //Arrange
//        TicketPrice calculator = new TicketPrice();
//        //Act
//        double ticketPrice = calculator.getTicketPrice(1, 1000);
//        //Assert
//        Assert.assertEquals(ticketPrice, 0.0);
//    }
}