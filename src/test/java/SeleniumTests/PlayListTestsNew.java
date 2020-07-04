package SeleniumTests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PlayListTestsNew extends BaseTest {
    @Parameters({"email", "password"})
    @Test
    public void createPlayList_PlayListCreated2(String logIn, String pwd) throws InterruptedException {
        String playlistId = mainPage.createPlayList("Playlist1");
        Assert.assertTrue(mainPage.checkPlayList(playlistId));
    }

    @Parameters({"email", "password"})
    @Test
    public void renamePlayList_PlayListCreated2(String logIn, String pwd) throws InterruptedException {
        String playlistId = mainPage.createPlayList("Playlist12");
        mainPage.renamePlayList(playlistId, "newName");
        Assert.assertTrue(mainPage.checkPlayList(playlistId), "newName");
    }

    @Parameters({"email", "password"})
    @Test
    public void createPlayList_PlayListCreated3(String logIn, String pwd) throws InterruptedException {
        String playlistId = mainPage.createPlayList("Playlist1");
        Assert.assertTrue(mainPage.checkPlayList(playlistId));
    }

    @Parameters({"email", "password"})
    @Test
    public void renamePlayList_PlayListCreated3(String logIn, String pwd) throws InterruptedException {
        String playlistId = mainPage.createPlayList("Playlist12");
        mainPage.renamePlayList(playlistId, "newName");
        Assert.assertTrue(mainPage.checkPlayList(playlistId), "newName");
    }
}

