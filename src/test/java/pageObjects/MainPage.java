package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

public class MainPage extends  BasePage{


    public MainPage(WebDriver driver) {
        super(driver);

    }

    public boolean isMain() throws InterruptedException {
      fluentWait.until(x->x.findElement(By.xpath("//i[@class='fa fa-sign-out control']")));
        var list = driver.findElements(By.xpath("//i[@class='fa fa-sign-out control']"));
        return list.size() == 1;
    }

    public String createPlaylist(String name) throws InterruptedException {
        var by1= By.xpath("//i[@class='fa fa-plus-circle control create']");
        fluentWait.until(x->x.findElement(by1));
        WebElement addPlaylistNew = driver.findElement(by1);
        addPlaylistNew.click();

        var by2=By.xpath("//input[@placeholder='↵ to save']");
        fluentWait.until(x->x.findElement(by2));
        WebElement inputPlaylistNew = driver.findElement(by2);
        inputPlaylistNew.sendKeys(name);
        inputPlaylistNew.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        String url = driver.getCurrentUrl();
        var parts= url.split("/");
        return parts[parts.length-1];
      }
    public boolean checkPlaylist(String id) {
        try {
            var by3=By.xpath("//*[@href='#!/playlist/" + id + "']");
            fluentWait.until(x->x.findElement(by3));
            var searchPlaylistNew = driver.findElement(by3);
            System.out.println("Found");
            return true;
        } catch (Exception e) {
            System.out.println("Not found");
            return false;
        }

    }
    public void renamePlaylist(String id, String newName) throws InterruptedException {
        var by3=By.xpath("//*[@href='#!/playlist/" + id + "']");
        fluentWait.until(x->x.findElement(by3));
        var playList = driver.findElement(by3);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",playList);
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        actions.doubleClick(playList).perform();
        var by4= By.xpath("//*[@href='#!/playlist/"+id+"']/../input");
        fluentWait.until(x->x.findElement(by4));
        var inputNew= driver.findElement(by4);
        inputNew.sendKeys(Keys.CONTROL, "a");
        inputNew.sendKeys(newName);
        inputNew.sendKeys(Keys.ENTER);;

    }
    public void checkPlaylistName(String id, String name){
        var by3=By.xpath("//*[@href='#!/playlist/" + id + "']");
        fluentWait.until(x->x.findElement(by3));
        var searchPlaylistNew = driver.findElement(by3);
        String realName= searchPlaylistNew.getText();
        Assert.assertEquals(realName,name);
    }
}
