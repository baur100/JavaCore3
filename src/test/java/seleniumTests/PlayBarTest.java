package seleniumTests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LogInPage;
import pageObjects.MainPage;

public class PlayBarTest extends BaseTest {
    MainPage mainPage;
    @Parameters({"email","password"})

    @Test
    public void playBarTest_Test_clickOnPlayButton_songIsPlaying(String loginId,String pwd) {
        LogInPage logInPage = new LogInPage(driver);
        mainPage = logInPage.logInToApp(loginId,pwd); //"testpro.user03@testpro.io","te$t$tudent"
        mainPage.playButtonSongPlaying();
        Assert.assertTrue(mainPage.pauseControlDisplayed());
    }

    @Parameters({"email","password"})

    @Test
    public void playBarTest_InfoButtonWorking(String loginId,String pwd) {
        LogInPage logInPage = new LogInPage(driver);
        mainPage = logInPage.logInToApp(loginId,pwd); //"testpro.user03@testpro.io","te$t$tudent"
        mainPage.playButtonSongPlaying();
        mainPage.infoButtonClickable();
        Assert.assertTrue(mainPage.infoOpened());
    }

}
