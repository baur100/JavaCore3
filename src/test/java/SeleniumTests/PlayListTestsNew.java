package SeleniumTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayListTestsNew extends BaseTest {

    @Test
    public void createPlayList_PlayListCreated2() throws InterruptedException {
        String playlistId = mainPage.createPlayList("Playlist1");
        Assert.assertTrue(mainPage.checkPlayList(playlistId));
    }

    @Test
    public void renamePlayList_PlayListCreated2() throws InterruptedException {
        String playlistId = mainPage.createPlayList("Playlist12");
        mainPage.renamePlayList(playlistId, "newName");
        Assert.assertTrue(mainPage.checkPlayList(playlistId), "newName");
    }


    @Test
    public void createPlayList_PlayListCreated3() throws InterruptedException {
        String playlistId = mainPage.createPlayList("Playlist1");
        Assert.assertTrue(mainPage.checkPlayList(playlistId));
    }

    @Test
    public void renamePlayList_PlayListCreated3() throws InterruptedException {
        String playlistId = mainPage.createPlayList("Playlist12");
        mainPage.renamePlayList(playlistId, "newName");
        Assert.assertTrue(mainPage.checkPlayList(playlistId), "newName");
    }
}
