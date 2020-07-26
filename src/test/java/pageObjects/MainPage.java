package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import seleniumTests.BaseTest;

import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainPage extends BasePage{
    protected static Logger logger = LogManager.getLogger(MainPage.class);
    public MainPage(WebDriver driver) {
        super(driver);
    }


    public class HomePageSelectors {
        public static final String homeButtonXpath = "//*[@class='home active']";
        public static final String plusButtonCssSelector = ".fa.fa-plus-circle";
        public static final String newPlaylistFieldXpath = "//*[contains(@placeholder,'to save')]";
        public static final String playlistsSideBarCss = "[id=playlists]";
        public static final String allSongMenuCss = "[href='#!/songs']";

    }

    public void dragSongToPlaylist(String id) {
        Actions action = new Actions(driver);
        getAllSongMenu().click();
        var song = driver.findElement(By.xpath("//*[contains(@data-song-id,'ee6')]"));
        var myPlaylist = driver.findElement(By.xpath("//*[@href=\"#!/playlist/"+id+"\"]"));
        action.moveToElement(driver.findElement(By.cssSelector(HomePageSelectors.playlistsSideBarCss)));
        var js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",myPlaylist);
        action.dragAndDrop(song,myPlaylist);
    }

    public void deletePlaylist(String id) {
        var myPlaylist = driver.findElement(By.xpath("//*[@href=\"#!/playlist/"+id+"\"]"));
        var js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",myPlaylist);
        myPlaylist.click();
        fluentWait.until(x->x.findElement(By.xpath("//*[contains(@class,'del btn')]")));
        var deleteButtonList = driver.findElements(By.xpath("//*[contains(@class,'del btn')]"));
        deleteButtonList.add(driver.findElement(By.xpath("//*[contains(@class,'del btn')]")));
        for (var v:deleteButtonList) {
            if (deleteButtonList.size() == 0) {
                driver.navigate().refresh();
            }
            else break;
        }
        deleteButtonList.get(0).click();
    }

    public boolean isMain() {
        fluentWait.until(x->x.findElement(By.xpath("//*[@class =\"fa fa-sign-out control\"]")).isDisplayed());
        var signOutButton = driver.findElement(By.xpath("//*[@class =\"fa fa-sign-out control\"]"));
        return signOutButton.isDisplayed();
    }

    public WebElement getAllSongMenu(){
        fluentWait.until(x->x.findElement(By.cssSelector(HomePageSelectors.allSongMenuCss)));
        return driver.findElement(By.cssSelector(HomePageSelectors.allSongMenuCss));
    }

    public void addSongToPlaylist(String name) {
        getAllSongMenu().click();
        var song = driver.findElement(By.xpath("//*[contains(@data-song-id,'ee6')]"));
        song.click();
        var addTo = driver.findElement(By.xpath("//*[contains(@class,'btn-add-to')]"));
        addTo.click();
        Actions action = new Actions(driver);
        var firstElementInFrame = driver.findElement(By.cssSelector("#songsWrapper > h1 > div > div > ul > li.after-current"));
        action.moveToElement(firstElementInFrame);
        var js = (JavascriptExecutor) driver;
        var myPlaylist = driver.findElement(By.xpath("//*[@id=\"songsWrapper\"]/h1/div/div/ul/li[text()='"+name+"']"));
        js.executeScript("arguments[0].scrollIntoView();",myPlaylist);
        myPlaylist.click();
    }

    public boolean checkSongAdded(String id){
        var js = (JavascriptExecutor) driver;
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector(HomePageSelectors.playlistsSideBarCss)));
        var myPlaylist = driver.findElement(By.xpath("//*[@href=\"#!/playlist/"+id+"\"]"));
        js.executeScript("arguments[0].scrollIntoView();",myPlaylist);
        myPlaylist.click();
        var songList = driver.findElements(By.xpath("//*[contains(@data-song-id,'ee6')]"));
        for (var v:songList) {
            if (songList.size() == 1) {
                driver.navigate().refresh();
            }
        }
        return true;
    }

    public WebElement getPlusButton(){
        fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(HomePageSelectors.plusButtonCssSelector)));
        return driver.findElement(By.cssSelector(HomePageSelectors.plusButtonCssSelector));
    }

    public WebElement getPlaylistNameField(){
        fluentWait.until(x->x.findElement(By.xpath(HomePageSelectors.newPlaylistFieldXpath)).isDisplayed());
        return driver.findElement(By.xpath(HomePageSelectors.newPlaylistFieldXpath));

    }
    public String getPlaylistId(){
        String url = driver.getCurrentUrl();
        return url.split("/playlist/")[1];
    }

    public String createPlaylist(String name){
        logger.info("test started");
        Actions actions = new Actions(driver);
        actions.moveToElement(getPlusButton()).click().perform();
        getPlusButton().click();
        logger.info("plus button clicked");
        getPlaylistNameField().click();
        getPlaylistNameField().sendKeys(name);
        logger.info("name pasted");
        getPlaylistNameField().sendKeys(Keys.ENTER);
        logger.info("Enter button pressed");
        fluentWait.until(x->x.findElement(By.xpath("//div[@class = 'success show']")).isDisplayed());
        return getPlaylistId();

    }

    public boolean checkByUrl(String id){
        var list = driver.findElements(By.xpath("//*[@href=\"#!/playlist/"+id+"\"]"));
        return  list.size()==1;
    }

    public boolean checkPlaylist(String name){
        var playlistsSideBar = driver.findElement(By.cssSelector(HomePageSelectors.playlistsSideBarCss));
        var allPlaylists = playlistsSideBar.getText();
        return allPlaylists.contains(name);
    }
    public static int getMax(List<Integer> list){
        int max = list.get(0);
        for(int v:list){
            if(max<v){
                max=v;
            }
        }
        return max;
    }



    public void renamePlaylist(String oldName,String newName){
        Actions action = new Actions(driver);
        fluentWait.until(x->x.findElement(By.xpath("//*[@class='playlist playlist']//*[text()='"+oldName+"']")).isDisplayed());
        List<WebElement> myPlaylists = driver.findElements(By.xpath("//*[@class='playlist playlist']//*[text()='"+oldName+"']"));
        var firstPlaylist = driver.findElement(By.xpath("//*[@class='playlist playlist']//*[text()='"+oldName+"']"));
        List<WebElement> allPlaylists = driver.findElements(By.xpath("//*[@class='playlist playlist']"));
        var index = allPlaylists.indexOf(firstPlaylist);
        int size = myPlaylists.size();
        List<Integer> id = new ArrayList<>(); //<----- it is going to be a list of id's

        //Creating a loop to get all the id's from the playlists with the name,that I created
        for(int i = index+2; i < index+1+size;i++){
            var createdByMe = driver.findElement(By.xpath("//*[@class='playlist playlist']["+i+"]"));
            createdByMe.click();
            id.add(Integer.parseInt(getPlaylistId()));
        }

        //Finding the maximum id-number, which is also the most recent
        int maxId = getMax(id);
        var mostRecentCreatedPlaylistByMe = driver.findElement(By.xpath("//*[contains(@href,'"+maxId+"')]"));
        var js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", mostRecentCreatedPlaylistByMe);
        action.doubleClick(mostRecentCreatedPlaylistByMe).perform();

        fluentWait.until(x->x.findElement(By.xpath("//*[@class = 'playlist playlist editing']//input")));
        var inputField = driver.findElement(By.xpath("//*[@class = 'playlist playlist editing']//input"));

        //deleting the old name from an input field
        for (int k = 0; k < oldName.length();k++) {
            inputField.sendKeys(Keys.BACK_SPACE);
        }
        inputField.sendKeys(newName);
        inputField.sendKeys(Keys.ENTER);

    }

    public boolean checkNewName(String newName){
        var header = driver.findElement(By.xpath("//*[@id=\"playlistWrapper\"]/h1/span"));
        var headerText = header.getText();
        return headerText.contains(newName);
    }

    public void playButtonSongPlaying(){
        fluentWait.until(x->x.findElement(By.xpath("//*[@class=\"play control\"]")));
        var playControl = driver.findElement(By.xpath("//*[@class=\"play control\"]"));
        playControl.click();
    }

    public boolean pauseControlDisplayed(){
        fluentWait.until(x->x.findElement(By.xpath("//*[@class=\"pause control\"]")));
        var pauseControl = driver.findElement(By.xpath("//*[@class=\"pause control\"]"));
        return pauseControl.isDisplayed();
    }

    public void infoButtonClickable(){
        fluentWait.until(x->x.findElement(By.xpath("//span[text()=\"Info\"]")));
        var infoControl = driver.findElement(By.xpath("//span[text()=\"Info\"]"));
        infoControl.click();
    }

    public boolean infoOpened(){
        fluentWait.until(x->x.findElement(By.xpath("//a[text()=\"Lyrics\"]")));
        var infoActive = driver.findElement(By.xpath("//a[text()=\"Lyrics\"]"));
        return infoActive.isDisplayed();
    }
}

