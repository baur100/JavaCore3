package _HWSelenium.seleniumTests;

import _HWSelenium.pageObjects.LoginPage;
import _HWSelenium.pageObjects.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest_CorrectCredentials_loggedToApp(){
        LoginPage loginPage= new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp("testpro.user03@testpro.io", "te$t$tudent");
        Assert.assertTrue(mainPage.isMain());
    }

    @Test
//            (enabled = false)
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


