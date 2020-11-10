package hw_scrollPage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.WatchEvent;

public class ScrollPage {
    private WebDriver driver;

    @BeforeMethod
    public void startUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void scrollPage() throws InterruptedException {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(3000);
        WebElement woman = driver.findElement(By.xpath("(//*[@href='http://automationpractice.com/index.php?id_category=3&controller=category'])[2]"));
        woman.click();

        Thread.sleep(3000);

        WebElement womanButtonClicked = driver.findElement(By.xpath("//*[@title='Women' and @class='sf-with-ul']"));
        Assert.assertNotNull(womanButtonClicked);
        String bckgrColor = womanButtonClicked.getCssValue("background-color");
        Assert.assertEquals(bckgrColor, "rgba(51, 51, 51, 1)");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        var element = driver.findElement(By.xpath("//*[@type='checkbox' and @id='layered_id_attribute_group_1']"));
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();

    }
}
