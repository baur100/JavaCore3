package myHelpers;

import myEnums.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFabric {
    public static WebDriver getDriver(Browsers browser) throws NoSuchFieldException {
        switch (browser) {
            case FIREFOX:
                return getFirefoxDriver();
            case CHROME:
                return getChromeDriver();
            default:
                throw new NoSuchFieldException("No such browser");

        }
    }

    private static WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,1000");
        options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        return new ChromeDriver(options);

    }

    private static WebDriver getFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        options.addArguments("--width=1400");
        options.addArguments("--height=1000");
        System.setProperty("webdriver.gecko.driver", "geckodriver");
        return new FirefoxDriver();
    }
}
