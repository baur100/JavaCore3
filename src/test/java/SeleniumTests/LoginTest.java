package SeleniumTests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import passengerForDataProvider.TicketPrice;

public class LoginTest extends BaseTest {

    @DataProvider(name = "Credentials")
        public Object[][] getData(){
        return new Object[][] {
                {"koeluser21@testpro.io", "te$t$tudent", true},
                {"koeluser03@testpro.io", "te$t$tudent", true},
                {"koeluser04@testpro.io", "te$t$tudent", true},
                {"koeluser0211@testpro.io", "test$tudent", false},
        };
    }
//      Object[][] data = new Object[3][2];
//        //Rows - Number of times your test has to be repeated.
//        // Columns - Number of parameters in test data.
//
//// 1st row
//        data[0][0] ="koeluser21@testpro.io";
//        data[0][1] = "te$t$tudent";
//
//// 2nd row
//        data[1][0] ="koeluser03@testpro.io";
//        data[1][1] = "te$t$tudent";
//
//// 3rd row
//        data[2][0] ="koeluser04@testpro.io";
//        data[2][1] = "te$t$tudent";
//        return data;

    @Test(dataProvider = "Credentials")
    public void LoginToApp(String username, String password, boolean result){
        System.out.println("Email= " + username);
        LoginPage loginPage = new LoginPage(driver);
        mainPage = loginPage.loginToApp(username, password);
        System.out.println("Boolean: " + mainPage.isMain());
        Assert.assertTrue(mainPage.isMain());
    }

    @Test
    public void loginTestCorrectCredentialsLoggedToApp() {
        Assert.assertTrue(mainPage.isMain());
    }
    @Test
    public void loginTestCorrectCredentialsLoggedToApp1() {
        Assert.assertTrue(mainPage.isMain());
    }
    @Test
    public void loginTestCorrectCredentialsLoggedToApp2() {
        Assert.assertTrue(mainPage.isMain());
    }
    @Test
    public void loginTestCorrectCredentialsLoggedToApp3() {
        Assert.assertTrue(mainPage.isMain());
    }
    @Test
    public void loginTestCorrectCredentialsLoggedToApp4() {
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
    public void ticketPriceForChild(int age, int fare, double result){
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