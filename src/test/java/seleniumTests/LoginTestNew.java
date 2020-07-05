package seleniumTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestNew extends BaseTest{

    @Test
    public void loginTest_CorrectCredentials_LoggedToApp5(){
        Assert.assertTrue(mainPage.isMain());
    }

    @Test
    public void loginTest_CorrectCredentials_LoggedToApp6(){
        Assert.assertTrue(mainPage.isMain());
    }

    @Test
    public void loginTest_CorrectCredentials_LoggedToApp7(){
        Assert.assertTrue(mainPage.isMain());
    }

    @Test
    public void loginTest_CorrectCredentials_LoggedToApp8(){
        Assert.assertTrue(mainPage.isMain());
    }

    @Test
    public void loginTest_CorrectCredentials_LoggedToApp9(){
        Assert.assertTrue(mainPage.isMain());
    }
//    @Test
//    public void loginTest_WrongCredentials_Error(){
//        LogInPage loginPage = new LogInPage(driver);
//        loginPage.logInToApp("testpro.user03@testpro.io","1111111");
//        Assert.assertTrue(loginPage.isError());
//
//    }
}
