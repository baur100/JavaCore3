package SeleniumTests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PlayListTests extends BaseTest {
    @Parameters({"email", "password"})

    @Test
    public void createPlayList_PlayListCreated() throws InterruptedException {
        String playlistId = mainPage.createPlayList("Playlist1");
        Assert.assertTrue(mainPage.checkPlayList(playlistId));
    }

    // skip the test locally
    @Test//(enabled = false)
    public void renamePlayList_PlayListCreated() throws InterruptedException {
        String playlistId = mainPage.createPlayList("Playlist12");
        mainPage.renamePlayList(playlistId, "newName");
        Assert.assertTrue(mainPage.checkPlayList(playlistId), "newName");
    }


    @Test
    public void createPlayList_PlayListCreated1() throws InterruptedException {
        String playlistId = mainPage.createPlayList("Playlist1");
        Assert.assertTrue(mainPage.checkPlayList(playlistId));
    }

    @Test
    public void renamePlayList_PlayListCreated1() throws InterruptedException {
        String playlistId = mainPage.createPlayList("Playlist12");
        mainPage.renamePlayList(playlistId, "newName");
        Assert.assertTrue(mainPage.checkPlayList(playlistId), "newName");
    }
}

