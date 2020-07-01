package hwSeleniumTests;

import hwPageObject.LoginPage;
import hwPageObject.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import seleniumTests.BaseTest;

import java.util.concurrent.TimeUnit;

public class PlaylistTests extends BaseTest {

    @Test
    public void playlistTests_createPlaylist_PlaylistCreated(){
        String playlistId = mainPage.createPlaylist("bbbb");
        Assert.assertTrue(mainPage.checkPlaylist(playlistId));
    }
    @Test
    public void playlistTests_renamePlaylist_PlaylistRenamed(){
        String playlistId = mainPage.createPlaylist("bbbb");
        mainPage.renamePlaylist(playlistId,"cccc");
        Assert.assertTrue(mainPage.checkPlaylist(playlistId,"cccc"));
    }
}

