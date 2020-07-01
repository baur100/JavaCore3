package hwPageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import pageObjects.BasePage;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }
    public boolean isMain() {
        var list =driver.findElements(By.cssSelector("[class='fa fa-sign-out control']"));
        return list.size()==1;
    }
    public WebElement getPlusButton(){
        fluentWait.until(x-> x.findElement(By.xpath("//*[@class='fa fa-plus-circle control create']")).isDisplayed());
        return driver.findElement(By.xpath("//*[@class='fa fa-plus-circle control create']"));
    }
    public WebElement getNewPlaylistField(){
        return driver.findElement(By.xpath("//*[@placeholder='↵ to save']"));
    }
    public String createPlaylist(String name){
        getPlusButton().click();
        getNewPlaylistField().sendKeys(name);
        getNewPlaylistField().sendKeys(Keys.RETURN);
        fluentWait.until(x->x.findElement(By.xpath("//div[@class='success show']")).isDisplayed());
        String url = driver.getCurrentUrl();
        return url.split("/")[5];
    }
    public boolean checkPlaylist(String id){
        var list = driver.findElements(By.xpath("//*[@href='#!/playlist/"+id+"']"));
        return list.size()==1;
    }
    public boolean checkPlaylist(String id, String name){
        var list = driver.findElements(By.xpath("//*[@href='#!/playlist/"+id+"']"));
        if(list.size()==0){
            return false;
        };
        return name.equals(list.get(0).getText());
    }

    public void renamePlaylist(String playlistId, String newName) {
        var playlist = driver.findElement(By.xpath("//*[@href='#!/playlist/"+playlistId+"']"));
        Actions actions = new Actions(driver);
        actions.doubleClick(playlist).perform();
        var editField = driver.findElement(By.xpath("//*[@class='playlist playlist editing']/input"));
        editField.sendKeys(Keys.CONTROL+"a");
        editField.sendKeys(newName);
        editField.sendKeys(Keys.RETURN);


    }
}
