package hwSeleniumTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import seleniumTests.BaseTest;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest_CorrectCredentials_LoggedToApp(){
        Assert.assertTrue(mainPage.isMain());
    }
}
