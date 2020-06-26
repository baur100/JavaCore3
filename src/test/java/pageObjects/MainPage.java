package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
}
