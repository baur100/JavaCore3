package seleniumTests;

import listener.RetryAnalyzer;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class PlaylistTests extends BaseTest {
    @Parameters({"email","password"})

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void playlistTests_createPlaylist_playlistCreated() {
        var playlistId = mainPage.createPlaylist("Playlist TEST");
        Assert.assertTrue(mainPage.checkByUrl(playlistId));
    }
    @Parameters({"email","password"})

    @Test
    public void playlistTests_renamePlaylist_playlistRenamed() {
        mainPage.renamePlaylist("Playlist TEST", "Renamed Playlist");
        //Assert.assertTrue(mainPage.checkNewName("Renamed Playlist"));
    }
    @Parameters({"email","password"})

    @Test
    public void playlistTests_addSongToPlaylist_songAdded(){
        var playlistId = mainPage.createPlaylist("Add Song Test");
        mainPage.addSongToPlaylist("Add Song Test");
        Assert.assertTrue(mainPage.checkSongAdded(playlistId));
    }
    @Parameters({"email","password"})

    @Test
    public void playlistTests_dragSongToPlaylist_songAdded(){
        var playlistId = mainPage.createPlaylist("Drag Song Test");
        mainPage.dragSongToPlaylist(playlistId);
        Assert.assertTrue(mainPage.checkSongAdded(playlistId));
    }
    @Parameters({"email","password"})

    @Test
    public void playlistTests_deletePlaylist_playlistDeleted(){
        var playlistId = mainPage.createPlaylist("Playlist for Removal");
        mainPage.deletePlaylist(playlistId);
        Assert.assertFalse(mainPage.checkPlaylist("Playlist For Removal"));
    }

}