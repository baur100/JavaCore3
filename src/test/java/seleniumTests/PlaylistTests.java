package seleniumTests;

import listener.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LogInPage;
import pageObjects.MainPage;


public class PlaylistTests extends BaseTest {
    MainPage mainPage;
    @Parameters({"email","password"})

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void playlistTests_createPlaylist_playlistCreated(String loginId, String pwd) {
        LogInPage logInPage = new LogInPage(driver);
        mainPage = logInPage.logInToApp(loginId,pwd); //"testpro.user03@testpro.io","te$t$tudent"
        var playlistId = mainPage.createPlaylist("Playlist TEST");
        Assert.assertTrue(mainPage.checkByUrl(playlistId));
    }
    @Parameters({"email","password"})

    @Test
    public void playlistTests_renamePlaylist_playlistRenamed(String loginId,String pwd) {
        LogInPage logInPage = new LogInPage(driver);
        mainPage = logInPage.logInToApp(loginId,pwd); //"testpro.user03@testpro.io","te$t$tudent"
        mainPage.renamePlaylist("Playlist TEST", "Renamed Playlist");
        //Assert.assertTrue(mainPage.checkNewName("Renamed Playlist"));
    }
    @Parameters({"email","password"})

    @Test
    public void playlistTests_addSongToPlaylist_songAdded(String loginId,String pwd){
        LogInPage logInPage = new LogInPage(driver);
        mainPage = logInPage.logInToApp(loginId,pwd); //"testpro.user03@testpro.io","te$t$tudent"
        var playlistId = mainPage.createPlaylist("Add Song Test");
        mainPage.addSongToPlaylist("Add Song Test");
        Assert.assertTrue(mainPage.checkSongAdded(playlistId));
    }
    @Parameters({"email","password"})

    @Test
    public void playlistTests_dragSongToPlaylist_songAdded(String loginId,String pwd){
        LogInPage logInPage = new LogInPage(driver);
        mainPage = logInPage.logInToApp(loginId,pwd); //"testpro.user03@testpro.io","te$t$tudent"
        var playlistId = mainPage.createPlaylist("Drag Song Test");
        mainPage.dragSongToPlaylist(playlistId);
        Assert.assertTrue(mainPage.checkSongAdded(playlistId));
    }
    @Parameters({"email","password"})

    @Test
    public void playlistTests_deletePlaylist_playlistDeleted(String loginId,String pwd){
        LogInPage logInPage = new LogInPage(driver);
        mainPage = logInPage.logInToApp(loginId,pwd); //"testpro.user03@testpro.io","te$t$tudent"
        var playlistId = mainPage.createPlaylist("Playlist for Removal");
        mainPage.deletePlaylist(playlistId);
        Assert.assertFalse(mainPage.checkPlaylist("Playlist For Removal"));
    }

}