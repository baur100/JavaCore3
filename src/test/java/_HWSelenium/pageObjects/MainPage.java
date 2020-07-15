package _HWSelenium.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {
    public MainPage (WebDriver driver) {super(driver);}


    public boolean isMain() {
        var list = driver.findElements(By.cssSelector("[class='fa fa-sign-out control']"));
        return list.size() == 1;
    }
    public void clickPlusButton() {
        for (int i = 0; i < 50; i++) {
            try {
                driver.findElement(By.xpath("//*[@class='fa fa-plus-circle control create']")).click();
                return;
            } catch (ElementClickInterceptedException ignored) {

            }
        }
        throw  new ElementClickInterceptedException("Element not reachable");
    }

//    My homework on create play list

    public String createPlaylistAK(String name) throws InterruptedException {
        var plusButton = driver.findElement(By.xpath("//*[@class='fa fa-plus-circle control create']"));
        plusButton.click();
        var inputField = driver.findElement(By.xpath("//*[@placeholder= '↵ to save'] "));
        Thread.sleep(2000);
        inputField.sendKeys("AK22");
        Thread.sleep(2000);
        inputField.sendKeys(Keys.ENTER);
//        var PlaylistAK22 = driver.findElement(By.xpath("//*[@href=\"#!/playlist/4864\"]"));
//        PlaylistAK22.click();
//        Thread.sleep(4000);
//    }
//    public WebElement getPlaylistAK22 () {return driver.findElement((By.xpath("//*[@href=\"#!/playlist/4864\"]")));
        return name;
    }

    public boolean checkPlaylist(String name) {
        List<WebElement> AK22 = new ArrayList<>();
        AK22 = driver.findElements(By.xpath("//a[contains(text(),'" + name + "')]"));
        if (AK22.isEmpty()) {
            // element doesn't exist
            return false;
        } else {
            // element exists, check for visibility
            return true;
        }
    }




    public WebElement getNewPlaylistField() {
        return driver.findElement(By.xpath("//*[@placeholder= '↵ to save']"));
    }

    public String createPlaylist2(String name) {
        clickPlusButton();
        getNewPlaylistField().sendKeys(name);
        getNewPlaylistField().sendKeys(Keys.RETURN);


        return name;
    }

    public boolean checkPlayList2(String id) {
        var list = driver.findElements(By.xpath("//*[@href='#!/playlist/" + id + "']"));
        return list.size() == 1;
    }

    public boolean checkPlaylist2(String name, String newName) {
        var list = driver.findElements(By.xpath("//a[contains(text(),'" + name + "')]"));
        if (list.size() == 0) {
            return false;
        }
        ;

        return name.equals(list.get(0).getText());
    }

    // my version
    public void renamePlaylist(String name, String newName) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
        var playlist = driver.findElement(By.xpath("//a[contains(text(),'" + name + "')]"));
//        js.executeScript("arguments[0].scrollIntoView();", playlist);
        Actions actions = new Actions(driver);
        actions.doubleClick(playlist).perform();
        var editField = driver.findElement(By.xpath("//*[@class='playlist playlist editing']/input"));
        editField.sendKeys(Keys.CONTROL + "a");
        editField.sendKeys(newName);
        editField.sendKeys(Keys.RETURN);

//    Baurjan
//    public void renamePlaylist(String playlistId, String newName) {
//        var playlist = driver.findElement(By.xpath("//*[@href='#!/playlist/"+playlistId+"']"));
//        Actions actions = new Actions(driver);
//        actions.doubleClick(playlist).perform();
//        var editField = driver.findElement(By.xpath("//*[@class='playlist playlist editing']/input"));
//        editField.sendKeys(Keys.CONTROL+"a");
//        editField.sendKeys(newName);
//        editField.sendKeys(Keys.RETURN);
    }
}

