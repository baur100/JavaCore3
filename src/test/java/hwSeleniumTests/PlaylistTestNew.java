package hwSeleniumTests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MainPage;

public class PlaylistTestNew extends BaseTest {
    @Parameters({"email","password"})
    @Test
    public void playlistTests_createPlaylist_PlaylistCreated3(String loginId,String pwd){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp(loginId,pwd);
        String playlistId = mainPage.createPlaylist("xxxxx");
        Assert.assertTrue(mainPage.checkPlaylist(playlistId));
    }
    @Parameters({"email","password"})
    @Test
    public void playlistTests_renamePlaylist_PlaylistRenamed2(String loginId,String pwd){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp(loginId,pwd);
        String playlistId = mainPage.createPlaylist("xxxxx");
        mainPage.renamePlaylist(playlistId,"newName");
        Assert.assertTrue(mainPage.checkPlaylist(playlistId,"newName"));
    }
    @Parameters({"email","password"})
    @Test
    public void playlistTests_createPlaylist_PlaylistCreated4(String loginId,String pwd){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp(loginId,pwd);
        String playlistId = mainPage.createPlaylist("xxxxx");
        Assert.assertTrue(mainPage.checkPlaylist(playlistId));
    }
    @Parameters({"email","password"})
    @Test
    public void playlistTests_renamePlaylist_PlaylistRenamed3(String loginId,String pwd){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = loginPage.loginToApp(loginId,pwd);
        String playlistId = mainPage.createPlaylist("xxxxx");
        mainPage.renamePlaylist(playlistId,"newName");
        Assert.assertTrue(mainPage.checkPlaylist(playlistId,"newName"));
    }
}
