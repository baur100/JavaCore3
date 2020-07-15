package _HWSelenium.seleniumTests;

import _HWSelenium.pageObjects.LoginPage;
import _HWSelenium.pageObjects.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestNew extends BaseTest {

    @Test
    public void loginTest_CorrectCredentials_loggedToApp(){
        LoginPage loginPage= new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp("testpro.user03@testpro.io", "te$t$tudent");
        Assert.assertTrue(mainPage.isMain());
    }

    @Test
    public void loginTest_CorrectCredentials_loggedToApp1() {
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp("testpro.user03@testpro.io", "te$t$tudent");
        Assert.assertTrue(mainPage.isMain());
    }

    @Test
    public void loginTest_CorrectCredentials_loggedToApp2(){
        LoginPage loginPage= new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp("testpro.user03@testpro.io", "te$t$tudent");
        Assert.assertTrue(mainPage.isMain());

    }




//
//    @Test
//    public void loginTest_WrongCredentials_Error(){
//        LoginPage loginPage = new LoginPage(driver);
//        MainPage mainPage = loginPage.loginToApp("testpro.user03@testpro.io", "11111111");
//        Assert.assertTrue(loginPage.isError());
//    }
//
//    @Test
//        public void loginTest_WrongCredentials_Error2() {
//        LoginPage loginPage = new LoginPage(driver);
//        MainPage mainPage = loginPage.loginToApp("testpro.user03@testpro.io", "11111111");
//        Assert.assertTrue(loginPage.isError2());
//    }





        }


