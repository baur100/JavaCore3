package myPageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPageMy extends BasePageMy {
    public MainPageMy(WebDriver driver) {
        super(driver);
    }

    public boolean isMain() {
        var list = driver.findElements(By.cssSelector("[class='fa fa-sign-out control']"));
        return list.size() == 1;
    }

    public void clickPlusButton(){
        for (int i = 0; i < 50; i++){
            try{
                driver.findElement(By.xpath("//*[@class='fa fa-plus-circle control create']")).click();
                return;
            } catch (ElementClickInterceptedException ignored){

            }
        }
        throw new ElementClickInterceptedException("Element is not reachable");


//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='fa fa-plus-circle control create']")));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@class='fa fa-plus-circle control create']")));

//        fluentWait.until(x-> x.findElement(By.xpath("//*[@class='fa fa-plus-circle control create']")).isDisplayed());
//        return driver.findElement(By.xpath("//*[@class='fa fa-plus-circle control create']"));
    }

    public WebElement getNewPlaylistField(){
        return driver.findElement(By.xpath("//*[@placeholder='↵ to save']"));
    }

    public String createPlaylist(String name) {
//        Actions actions = new Actions(driver);
//        actions.moveToElement(clickPlusButton()).click().build().perform();
        clickPlusButton();
        getNewPlaylistField().sendKeys(name);
        getNewPlaylistField().sendKeys(Keys.RETURN);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
//        fluentWait.until(x->x.findElement(By.xpath("//div[@class='success show']")).isDisplayed());
        String url = driver.getCurrentUrl();
        return url.split("/")[5];
    }

    public boolean checkPlaylist(String originalName) {
        var list = driver.findElements(By.xpath("//*[@href=\"#!/playlist/"+originalName+"]"));
        return list.size()==1;
    }
    public boolean checkPlaylist(String originalName, String name) {
        var list = driver.findElements(By.xpath("//*[@href=\"#!/playlist/"+originalName+"]"));
        if (list.size()==0) {
            return false;
        }
        return name.equals(list.get(0).getText());
    }


    public void renamePlaylist(String playlistOriginalName, String summer2020) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        var playlist = driver.findElement(By.xpath("//*[@href=\"#!/playlist/"+playlistOriginalName+"]"));
        js.executeScript("arguments[0].scrollIntoView();", playlist);
        Actions actions = new Actions(driver);
        actions.doubleClick(playlist).perform();
        var editField = driver.findElement(By.xpath("//*[class='playlist playlist editing']/input"));
        editField.sendKeys(Keys.CONTROL+"a");
        editField.sendKeys(summer2020);
        editField.sendKeys(Keys.RETURN);

    }
}
