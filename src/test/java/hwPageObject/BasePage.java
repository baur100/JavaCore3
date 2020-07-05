package hwPageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public  class BasePage {
    protected WebDriver driver;
    protected FluentWait<WebDriver> fluentWait;
    protected WebDriverWait wait;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.fluentWait = new FluentWait<WebDriver>(driver)
            .withTimeout(Duration.ofSeconds(20))
            .pollingEvery(Duration.ofMillis(100));
        this.wait=new WebDriverWait(this.driver,10);
    }

}
