package myPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPageMy extends BasePageMy {

    public LoginPageMy(WebDriver driver) {
        super(driver);
    }

    public MainPageMy loginToApp(String email, String password){
        getEmail().sendKeys(email);
        getPassword().sendKeys(password);
        getLoginButton().click();
        return new MainPageMy(driver);
    }

    public boolean isError(){
//        var errors = driver.findElements(By.xpath("//*[@class='error']"));
//        return errors.size()==1;
        try {
            driver.findElement(By.xpath("//*[@class='error']"));
        } catch (NoSuchElementException error){
            return false;
        }
        return true;
    }
    public WebElement getEmail() {
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type='email']")));
        fluentWait.until(x->x.findElement(By.xpath("//*[@type='email']")));
        return driver.findElement(By.xpath("//*[@type='email']"));
    }

    public WebElement getPassword() {
        return driver.findElement(By.xpath("//*[@type='password']"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.xpath("//*[@type='submit']"));
    }


}
