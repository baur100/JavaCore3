package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends BasePage {
    private WebDriverWait wait;

    public MainPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, 5);
    }

    public boolean isMain() {
        var list = driver.findElements(By.cssSelector("[class='fa fa-sign-out control']"));
        return list.size() == 1;
    }

    public WebElement getPlusButton() {
        fluentWait.until(x -> x.findElement(By.xpath("//*[@class='fa fa-plus-circle control create']")).isDisplayed());
        return driver.findElement(By.xpath("//*[@class='fa fa-plus-circle control create']"));
    }

    public WebElement summerHitsPlaylist() {
        return driver.findElement(By.xpath("//*[@class='playlist playlist']/*[contains(text(), \"Summer Hits\")]"));
    }

    private void waitBeforeClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='fa fa-plus-circle control create']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='youtube']")));
    }

    public WebElement getNewPlaylistField() {
        return driver.findElement(By.xpath("//*[@placeholder='↵ to save']"));
    }

    public WebElement getPlayListButton(String playListID) {
        return driver.findElement(By.xpath("//a[contains(@href,'" + playListID + "')]"));
    }

    public WebElement getPlayListField(String playListID) {
        return driver.findElement(By.xpath("//a[contains(@href,'" + playListID + "')]/ancestor::li//input"));
    }

    public WebElement playListButton() {
        return driver.findElement(By.xpath("//*[@class='fa fa-plus-circle control create']"));
    }


    public WebElement playListNameField() {
        return driver.findElement(By.xpath("//form[@class='create']/input[@type='text']"));
    }

    public void createPlaylist(String name) {
        waitBeforeClick(playListButton());
        playListButton().click();
        playListNameField().sendKeys(name);
        playListNameField().sendKeys(Keys.ENTER);
    }

    public boolean checkPlaylist(String name) {
        boolean result = false;
        if (summerHitsPlaylist().getText().equals(name)) {
            result = true;
        }
        return result;
    }

    public void clearPlayListField(String playListID) {
        WebElement element = getPlayListField(playListID);
        int length = element.getAttribute("value").length();
        for (int i = 0; i <= length; i++) {
            element.sendKeys(Keys.BACK_SPACE);
        }
    }

    public void renamePlayList(String playListID, String title) {
        WebElement element = getPlayListButton(playListID);
        actions.doubleClick(element).perform();
        WebElement playListField = getPlayListField(playListID);
        clearPlayListField(playListID);
        playListField.sendKeys(title + Keys.ENTER);
    }

    public String getPlayListTitle(String playListID) {
        WebElement playListLink = getPlayListButton(playListID);
        return playListLink.getText();
    }

    public String getPlayListIDFromURL() {
        waitForUrlToUpdate(3);
        String url = driver.getCurrentUrl();
        return url.split("/")[5];
    }

    public void waitForUrlToUpdate(int seconds) {
        String initialURL = driver.getCurrentUrl();
        FluentWait<WebDriver> waitForUpdatedUrl = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofMillis(500));
        waitForUpdatedUrl.until(driver -> {
            return !driver.getCurrentUrl().equals(initialURL);
        });
    }

    //    public String createPlaylist(String name){
//        getPlusButton().click();
//        getNewPlaylistField().sendKeys(name);
//        getNewPlaylistField().sendKeys(Keys.RETURN);
//        fluentWait.until(x->x.findElement(By.xpath("//div[@class='success show']")).isDisplayed());
//        String url = driver.getCurrentUrl();
//        return url.split("/")[5];
//    }

    //    public boolean checkPlaylist(String id){
//        var list = driver.findElements(By.xpath("//*[@href='#!/playlist/"+id+"']"));
//        return list.size()==1;
//    }
}
