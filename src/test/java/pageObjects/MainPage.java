package pageObjects;

import SeleniumTests.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import java.util.List;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.NoSuchElementException;


public class MainPage extends BasePage {
    private static Logger logger = LogManager.getLogger(MainPage.class);
    public MainPage(WebDriver driver) {
        super(driver);
    }

//        wait.until((WebDriver dr1) -> dr1.findElement(By.xpath(MainPageSelectors.playListNameTextField)));
//        fluentWait.until(x->x.findElement(By.xpath(MainPageSelectors.plusButtonPlayListCreation)).isDisplayed());
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MainPageSelectors.plusButtonPlayListCreation)));
//        long now = System.currentTimeMillis();
//        wait.until(ExpectedConditions
//                .elementToBeClickable(By.xpath(MainPageSelectors.plusButtonPlayListCreation)));
//        System.out.println("Elapsed time: " + (System.currentTimeMillis() - now));
//        System.out.println(driver.findElement(By.xpath(MainPageSelectors.plusButtonPlayListCreation)));

    // JavascriptExecutor jse = (JavascriptExecutor)driver;
    // jse.executeScript("arguments[0].click()",mainPage.getPlus());

    // Click on "Plus" button doesn't work, using any of the Explicit waits
    public void clickPlusButton() throws InterruptedException {
        for (int i = 0; i < 50; i++) {
            try {
                driver.findElement(By.xpath(MainPageSelectors.plusButtonPlayListCreation)).click();
                return;
            } catch (org.openqa.selenium.NoSuchElementException nsee) {
                Thread.sleep(100);
            } catch (ElementClickInterceptedException ignored) {
                Thread.sleep(100);
            }
        }
        throw new ElementClickInterceptedException("Element not reachable");
    }

    public WebElement getPlayListNameTextField() {
        return driver.findElement(By.xpath(MainPageSelectors.playListNameTextField));
    }

    public boolean isMain() {
        // wait until "SignOut" element will be clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(MainPageSelectors.signOutControl)));
        // print the "SignOut" element
        WebElement signOut = driver.findElement(By.xpath(MainPageSelectors.signOutControl));
        System.out.println(signOut);
        // validation of "SignOut" element presence on the page
        try {
            driver.findElement(By.xpath(MainPageSelectors.signOutControl));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public String createPlayList(String playListName) throws InterruptedException {
        logger.info("test started");
        clickPlusButton();
        logger.info("plus button clicked");
        getPlayListNameTextField().sendKeys(playListName);
        logger.trace("playlistName pasted");
        getPlayListNameTextField().sendKeys(Keys.ENTER);
        logger.info("button clicked");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(MainPageSelectors.successPlaylistCreated)));
        String url = driver.getCurrentUrl();
        return url.split("/")[5];
    }

    public boolean checkPlayList(String id) {
        List list = driver.findElements(By.xpath("//*[@href='#!/playlist/" + id + "']"));
        return list.size() == 1;
    }

    public boolean checkPlaylist(String id, String name) {
        List<WebElement> list = driver.findElements(By.xpath("//*[@href='#!/playlist/" + id + "']"));
        if (list.size() == 0) {
            return false;
        }
        return name.equals(list.get(0).getText());
    }

//    private String getOldPlaylistXpath(String name) {
//        return "//a[text()='" + name + "']";
//    }
//
//    public String getPlaylistHeadingName(String playlistHeaderName) {
//        return
//                "//span[contains(.,'" + playlistHeaderName + "')]";
//    }

    public void renamePlayList(String playlistId, String newName) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement playlist = driver.findElement(By.xpath("//*[@href='#!/playlist/"+playlistId+"']"));
        js.executeScript("arguments[0].scrollIntoView();", playlist);
       // WebElement playlist = driver.findElement(By.xpath("//*[@href='#!/playlist/" + playlistId + "']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(playlist).perform();
        WebElement editField = driver.findElement(By.xpath(MainPageSelectors.editingPlaylistName));
        editField.sendKeys(Keys.CONTROL + "a");
        editField.sendKeys(newName);
        editField.sendKeys(Keys.RETURN);
    }
}









