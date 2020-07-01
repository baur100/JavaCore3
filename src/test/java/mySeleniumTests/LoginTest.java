package mySeleniumTests;

import myPageObjects.LoginPageMy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void loginTest_CorrectCredentials_LoggedToApp(){
        Assert.assertTrue(mainPageMy.isMain());
    }
    @Test
    public void loginTest_CorrectCredentials_LoggedToApp1(){
        Assert.assertTrue(mainPageMy.isMain());
    }
    @Test
    public void loginTest_CorrectCredentials_LoggedToAp2(){
        Assert.assertTrue(mainPageMy.isMain());
    }

//    @Test(enabled = false)
//    public void loginTest_WrongCredentials_Error(){
//        LoginPageMy loginPage = new LoginPageMy(driver);
//        loginPage.loginToApp("testpro.user03@testpro.io","12345");
//        Assert.assertTrue(loginPage.isError());
//    }

}
