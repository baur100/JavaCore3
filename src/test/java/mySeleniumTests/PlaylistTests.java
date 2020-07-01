package mySeleniumTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTests extends BaseTest{

    @Test
    public void playlistTests_createPlaylist_PlaylistCreated() {
        String playlistOriginalName = mainPageMy.createPlaylist("Top2020");
        Assert.assertTrue(mainPageMy.checkPlaylist(playlistOriginalName));
    }
    @Test
    public void playlistTests_renamePlaylist_PlaylistRenamed() {
        String playlistOriginalName = mainPageMy.createPlaylist("Top2020");
        mainPageMy.renamePlaylist(playlistOriginalName,"summer2020");
        Assert.assertTrue(mainPageMy.checkPlaylist(playlistOriginalName, "summer2020"));



    }
}
