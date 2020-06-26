package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected FluentWait<WebDriver> fluentWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.fluentWait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofMillis(100));
    }
}
