package hwPageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) { super(driver);}


    public WebElement getButtonCreatePlaylist() {
        fluentWait.until(x->x.findElement(By.xpath("//*[@class='fa fa-plus-circle control create']")).isDisplayed() );
        return driver.findElement(By.xpath("//*[@class='fa fa-plus-circle control create']"));
    }
    public WebElement getWindowToSave() {
        return driver.findElement(By.xpath("//*[@class=\"create\"]"));
    }

    public String createPlaylist(String name) {

        getButtonCreatePlaylist().click();
        getWindowToSave().sendKeys(name);
        getWindowToSave().sendKeys(Keys.RETURN);
        String url = driver.getCurrentUrl();
        return url.split("/")[4];
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
    public boolean checkPlaylist(String id, String name){
        var list = driver.findElements(By.xpath("//*[@href='#!/playlist/"+id+"']"));
        if(list.size()==0){
            return false;
        };
        return name.equals(list.get(0).getText());
    }


    public boolean checkPlaylist(String id) {
        var list = driver.findElements(By.xpath("//*[@href='#!/playlist/"+id+"']"));
        return list.size()==1;
    }

}
