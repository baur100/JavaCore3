package seleniumTests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaylistTestsNew extends BasedTest {
    @Test
    public void playlistTests_createPlaylist_PlaylistCreated()throws InterruptedException{
        Thread.sleep(1000);
        var id=mainPage.createPlaylist("New");
        System.out.println("My list id="+id);
        Assert.assertTrue(mainPage.checkPlaylist(id));
    }
    @Test
    public void playListTests_renamePlayList3() throws InterruptedException {
        Thread.sleep(1000);
        var id=mainPage.createPlaylist("Ilona");
        System.out.println("new list id:"+id);
        mainPage.renamePlaylist(id, "SuperNew");
        mainPage.checkPlaylistName(id,"SuperNew");
    }
            @Test
        public void playlistTests_createPlaylist_PlaylistCreated3()throws InterruptedException{
            Thread.sleep(1000);
            var id=mainPage.createPlaylist("New");
            System.out.println("My list id="+id);
            Assert.assertTrue(mainPage.checkPlaylist(id));
        }
        @Test
        public void playListTests_renamePlayList4() throws InterruptedException {
            Thread.sleep(1000);
            var id=mainPage.createPlaylist("Ilona");
            System.out.println("new list id:"+id);
            mainPage.renamePlaylist(id, "SuperNew");
            mainPage.checkPlaylistName(id,"SuperNew");
        }

}
