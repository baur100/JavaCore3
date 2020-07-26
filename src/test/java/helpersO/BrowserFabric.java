package helpersO;

import enumsO.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class BrowserFabric {
    public static WebDriver getDriver(Browsers browser) throws NoSuchFieldException {
        switch (browser){
            case FIREFOX:
                return getFirefoxDriver();
            case OPERA:
                return getOperaDriver();
            case CHROME:
                return getChromeDriver();
            case SAFARI:
                return getSafariDriver();
            case EDGE:
                return getEdgeDriver();
            default:
                throw new NoSuchFieldException("No such browser!");
        }
    }

    private static WebDriver getEdgeDriver() {
        System.setProperty("webdriver.edge.driver", "msedgedriver");
        return new EdgeDriver();
    }

    private static WebDriver getSafariDriver() {
        SafariOptions safariOptions = new SafariOptions();
        System.setProperty("webdriver.safari.noinstall", "true");
        return new SafariDriver();
    }

    private static WebDriver getChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--window-size=1400,1000");
        System.setProperty("webdriver.chrome.driver", "chromedriver84");
        return new ChromeDriver(options);
    }

    private static WebDriver getOperaDriver() {
        OperaOptions options=new OperaOptions();
        options.addArguments("--headless");
        System.setProperty("webdriver.opera.driver", "operadriver");
        return new OperaDriver(options);
    }

    private static WebDriver getFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        options.addArguments("--wigth=1400");
        options.addArguments("--height=1000");
        System.setProperty("webdriver.gecko.driver","geckodriver");
       return new FirefoxDriver(options);
    }
}
