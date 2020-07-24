package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class MainPage extends BasePage {


    public static final String btSignOut = "//*[@class='fa fa-sign-out control']";
    public static final String btCreatePlayList = "//*[@class='fa fa-plus-circle control create']";
    public static final String fdEnterPlayListName = "//*[@placeholder='↵ to save']";


    public MainPage(WebDriver driver) {
        super(driver);
    }

    public boolean isMain() {
        var list = driver.findElements(By.xpath(btSignOut));
        return list.size()==1;
    }

    public void createPlaylist(String name) {
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(btCreatePlayList)));
//        fluentWait.until(x->x.findElement(By.xpath(btCreatePlayList)).isSelected());
        clickPlusButton();
        WebElement element = driver.findElement(By.xpath(fdEnterPlayListName));
        element.sendKeys(name);
        element.sendKeys(Keys.ENTER);
    }

    public boolean checkPlaylist(String name) {
        var list = driver.findElements(By.xpath("//*[@id='playlists']//*[contains(text(), '"+name+"')]"));
//        var list = driver.findElements(By.xpath("//*[@href='#!/playlist/"+name+"']"));
        System.out.println(list.size());
        return list.size()>0;
    }

    public void clickPlusButton() {
        while(true) {
            try {
                driver.findElement(By.cssSelector(".fa.fa-plus-circle")).click();
                return;
            }
            catch (ElementClickInterceptedException error) {

            }
        }
    }

    public void renamePlayList(String oldName, String newName) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        var playlist = driver.findElement(By.xpath("//*[@id='playlists']//*[contains(text(), '"+oldName+"')]"));
        js.executeScript("arguments[0].scrollIntoView();", playlist);
        Actions action = new Actions(driver);
        action.doubleClick(playlist).perform();
        Thread.sleep(3000);
        var editField = driver.findElement(By.xpath("//*[@class='playlist playlist editing']/input"));
        editField.sendKeys(Keys.CONTROL+"a");
        editField.sendKeys(newName);
        editField.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
    }
}
