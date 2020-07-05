package seleniumTests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class LoginTestNew extends BaseTest {

    @Parameters({"email","password"})
    @Test
    public void loginTest_CorrectCredentials_LoggedToApp5(String loginId,String pwd){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp(loginId,pwd);
        Assert.assertTrue(mainPage.isMain());
    }
    @Parameters({"email","password"})
    @Test
    public void loginTest_CorrectCredentials_LoggedToApp6(String loginId,String pwd){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp(loginId,pwd);
        Assert.assertTrue(mainPage.isMain());
    }
    @Parameters({"email","password"})
    @Test
    public void loginTest_CorrectCredentials_LoggedToApp7(String loginId,String pwd){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp(loginId,pwd);
        Assert.assertTrue(mainPage.isMain());
    }
    @Parameters({"email","password"})
    @Test
    public void loginTest_CorrectCredentials_LoggedToApp8(String loginId,String pwd){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp(loginId,pwd);
        Assert.assertTrue(mainPage.isMain());
    }
    @Parameters({"email","password"})
    @Test
    public void loginTest_CorrectCredentials_LoggedToApp9(String loginId,String pwd){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp(loginId,pwd);
        Assert.assertTrue(mainPage.isMain());
    }
}
