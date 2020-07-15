package _HWSelenium.seleniumTests;

import _HWSelenium.pageObjects.LoginPage;
import _HWSelenium.pageObjects.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayListTestsNew extends BaseTest{

    @Test
// my homework Create Playlist
    public void playlistTests_createPlaylist_PlaylistCreated() throws InterruptedException {
        LoginPage loginPage= new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp("testpro.user03@testpro.io", "te$t$tudent");
        String name = mainPage.createPlaylist2("blablabla");
        Assert.assertTrue(mainPage.checkPlaylist ("blablabla"));
    }

    @Test
// my homework Create Playlist
    public void playlistTests_createPlaylist_PlaylistCreated2() throws InterruptedException {
        LoginPage loginPage= new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp("testpro.user03@testpro.io", "te$t$tudent");
        String name = mainPage.createPlaylist2("blablabla");
        Assert.assertTrue(mainPage.checkPlaylist ("blablabla"));
    }


//    @Test
// baurjan
//    public void playlistTests_createPlaylist_PlaylistCreated2() throws InterruptedException {
//        LoginPage loginPage = new LoginPage(driver);
//        MainPage mainPage = loginPage.loginToApp("testpro.user03@testpro.io","te$t$tudent");
//        Thread.sleep(2000);
//        String playlistId = mainPage.createPlaylist2("blablabla");
//        Assert.assertTrue(mainPage.checkPlayList2 ("blablabla"));



//    my version
    @Test
    public void playlistTests_renamePlayList_PlayListRenamed() throws InterruptedException {
        Thread.sleep(2000);
        LoginPage loginPage= new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp("testpro.user03@testpro.io", "te$t$tudent");
        String name = mainPage.createPlaylist2("blablabla");
        mainPage.renamePlaylist(name, "newName");
        Assert.assertTrue(mainPage.checkPlaylist2(name, "newName"));

    }
    @Test
    public void playlistTests_renamePlayList_PlayListRenamed2() throws InterruptedException {
        Thread.sleep(2000);
        LoginPage loginPage= new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp("testpro.user03@testpro.io", "te$t$tudent");
        String name = mainPage.createPlaylist2("blablabla");
        mainPage.renamePlaylist(name, "newName");
        Assert.assertTrue(mainPage.checkPlaylist2(name, "newName"));
    }


//    Baurjan
//    @Test
//  public void playlistTests_renamePlaylist_PlaylistRenamed() throws InterruptedException {
//        LoginPage loginPage = new LoginPage(driver);
//        MainPage mainPage = loginPage.loginToApp("testpro.user03@testpro.io", "te$t$tudent");
//        Thread.sleep(2000);
//        String playlistId = mainPage.createPlaylist2("blablabla");
//        mainPage.renamePlaylist(playlistId, "newName");
//        Assert.assertTrue(mainPage.checkPlaylist2(playlistId, "newName"));}


}


