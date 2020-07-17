package seleniumTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.MainPage;

public class PlaylistTests extends BaseTest{

    @Test
    public void playlistTests_createPlaylist_PlaylistCreated(MainPage mainPage){
        String playlistId = mainPage.createPlaylist("xxxxx");
        Assert.assertTrue(mainPage.checkPlaylist(playlistId));
    }
    @Test
    public void playlistTests_renamePlaylist_PlaylistRenamed(MainPage mainPage){
        String playlistId = mainPage.createPlaylist("xxxxx");
        mainPage.renamePlaylist(playlistId,"newName");
        Assert.assertTrue(mainPage.checkPlaylist(playlistId,"newName"));
    }
    @Test
    public void playlistTests_createPlaylist_PlaylistCreated1(MainPage mainPage){
        String playlistId = mainPage.createPlaylist("xxxxx");
        Assert.assertTrue(mainPage.checkPlaylist(playlistId));
    }
    @Test
    public void playlistTests_renamePlaylist_PlaylistRenamed1(MainPage mainPage){
        String playlistId = mainPage.createPlaylist("xxxxx");
        mainPage.renamePlaylist(playlistId,"newName");
        Assert.assertTrue(mainPage.checkPlaylist(playlistId,"newName"));
    }
}
