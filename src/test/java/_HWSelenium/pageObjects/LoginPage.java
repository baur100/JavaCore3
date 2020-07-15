package _HWSelenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


public class LoginPage extends BasePage{
    public LoginPage (WebDriver driver) {super(driver);}

    public MainPage loginToApp (String email, String password){
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getLoginButton().click();
        return new MainPage(driver);

    }

    public boolean isError(){

        List<WebElement> listOfErrors = new ArrayList<>();
        listOfErrors = driver.findElements(By.cssSelector(".error"));

        if (listOfErrors.isEmpty())
        {
            // element doesn't exist
            return false;
        }
        else
        {
            // element exists, check for visibility
            return listOfErrors.get(0).isDisplayed();
        }
    }

    public boolean isError2(){
//        var errors = driver.findElements(By. xpath("//*[@class='error']"));
//        return errors.size()==1;
        try {
            driver.findElement(By.xpath("//*[@class='error']"));
        }catch (NoSuchElementException error2) {
            return false;
        }
        return true;

    }

    public WebElement getEmail() {
        fluentWait.until(x->x.findElement(By.xpath("//*[@type='email']")).isDisplayed());
        return driver.findElement(By.xpath("//*[@type='email']"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.xpath("//*[@type='password']"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("//*[@type='submit']"));
    }
}





