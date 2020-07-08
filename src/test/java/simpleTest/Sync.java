package simpleTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Sync {
    private WebDriver driver;
    private WebDriverWait wait;
    private FluentWait<WebDriver> fluentWait;
    @BeforeMethod
    public void startUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
//        wait = new WebDriverWait(driver,20);
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(100))
//                .ignoring(ElementClickInterceptedException.class)
//                .ignoring(StaleElementReferenceException.class)
                .ignoring(NoSuchElementException.class);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void loginToApp(){
        driver.get("https://koelapp.testpro.io/");

        String emailXpath = "//*[@type='email']";
        By emailBy = By.xpath(emailXpath);

//        wait.until(ExpectedConditions.elementToBeClickable(emailBy));
        fluentWait.until(x->x.findElement(emailBy));

        WebElement email = driver.findElement(emailBy);
        WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@type='submit']"));

        email.sendKeys("testpro.user03@testpro.io");
        password.sendKeys("te$t$tudent");
        loginButton.click();

//        wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='#!/playlist/4192']"))));
        fluentWait.until(x->x.findElement(By.xpath("//*[@href='#!/playlist/4192']")));
        var element = driver.findElement(By.xpath("//*[@href='#!/playlist/4192']"));
    }
}
