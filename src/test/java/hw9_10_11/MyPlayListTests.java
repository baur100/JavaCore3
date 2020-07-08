package hw9_10_11;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class MyPlayListTests extends MyBaseTest{
    @Parameters({"email","password"})
    @Test
    public void playlistTests_createPlaylist_PlaylistCreated(String loginId,String pwd){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp(loginId,pwd);
        String playlistId = mainPage.createPlaylist("Michael_JS");
        Assert.assertTrue(mainPage.checkPlaylist(playlistId));
    }
    @Test
    public void playlistTests_renamePlaylist_PlaylistRenamed(String loginId,String pwd){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp(loginId,pwd);
        String playlistId = mainPage.createPlaylist("Michael_JS");
        mainPage.renamePlaylist(playlistId,"MICHAEL_js");
        Assert.assertTrue(mainPage.checkPlaylist(playlistId,"MICHAEL_js"));
    }
    @Test
    public void playlistTests_createPlaylist_PlaylistCreated1(String loginId,String pwd){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp(loginId,pwd);
        String playlistId = mainPage.createPlaylist("Michael_JS");
        Assert.assertTrue(mainPage.checkPlaylist(playlistId));
    }
    @Test
    public void playlistTests_renamePlaylist_PlaylistRenamed1(String loginId,String pwd){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp(loginId,pwd);
        String playlistId = mainPage.createPlaylist("Michael_JS");
        mainPage.renamePlaylist(playlistId,"MICHAEL_js");
        Assert.assertTrue(mainPage.checkPlaylist(playlistId,"MICHAEL_js"));
    }
}
