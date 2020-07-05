package seleniumTests;

import listener.RetryAnalyzer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PlaylistTestsNew extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void playlistTests_createPlaylist_playlistCreated2() {
        var playlistId = mainPage.createPlaylist("Playlist TEST");
        Assert.assertTrue(mainPage.checkByUrl(playlistId));
    }

    @Test
    public void playlistTests_renamePlaylist_playlistRenamed2() {
        mainPage.renamePlaylist("Playlist TEST", "Renamed Playlist");
       // Assert.assertTrue(mainPage.checkNewName("Renamed Playlist"));
    }

    @Test
    public void playlistTests_createPlaylist_playlistCreated1() {
        var playlistId = mainPage.createPlaylist("Playlist TEST");
        Assert.assertTrue(mainPage.checkByUrl(playlistId));
    }

    @Test
    public void playlistTests_renamePlaylist_playlistRenamed1() {
        mainPage.renamePlaylist("Playlist TEST", "Renamed Playlist");
        //Assert.assertTrue(mainPage.checkNewName("Renamed Playlist"));
    }

}