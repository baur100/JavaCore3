package SeleniumTests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTestNew extends BaseTest {
    @Parameters({"email1", "password1"})
    @Test
    public void loginTestCorrectCredentialsLoggedToApp5() {
        Assert.assertTrue(mainPage.isMain());
    }

    @Parameters({"email", "password"})
    @Test
    public void loginTestCorrectCredentialsLoggedToApp6(String logIn, String pwd) {
        Assert.assertTrue(mainPage.isMain());
    }

    @Parameters({"email", "password"})
    @Test
    public void loginTestCorrectCredentialsLoggedToApp7(String logIn, String pwd) {
        Assert.assertTrue(mainPage.isMain());
    }

    @Parameters({"email", "password"})
    @Test
    public void loginTestCorrectCredentialsLoggedToApp8(String logIn, String pwd) {
        Assert.assertTrue(mainPage.isMain());
    }

    @Parameters({"email", "password"})
    @Test
    public void loginTestCorrectCredentialsLoggedToApp9(String logIn, String pwd) {
        Assert.assertTrue(mainPage.isMain());
    }
}