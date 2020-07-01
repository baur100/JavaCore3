package myPageObjects;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePageMy {
    protected WebDriver driver;
    protected FluentWait<WebDriver> fluentWait;
    protected WebDriverWait wait;


    public BasePageMy(WebDriver driver) {
        this.driver = driver;
        this.fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(ElementClickInterceptedException.class);
//                .ignoring(StaleElementReferenceException.class)
//                .ignoring(org.openqa.selenium.NoSuchElementException.class);
        this.wait = new WebDriverWait(this.driver,10);
    }
}
