package simpleTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SimpleTest {
    private WebDriver driver;

    @BeforeMethod
    public void startUp(){
        System.setProperty("webdriver.chromedriver", "chromedriver");
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.addArguments("--no-sandbox");
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void simpleTest_ClickElephant_PageOpened() throws InterruptedException {

        driver.get("https://udemy.com");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        //Act
        WebElement elephant = driver.findElement(By.xpath("//*[contains(@src,'762616')]"));
        elephant.click();
        String title = driver.getTitle();

        //Assert
        Assert.assertEquals(title, "The Complete SQL Bootcamp for the Manipulation and Analysis of Data | Udemy");
    }

    @Test
    public void simpleTest_SearchJava_PageOpened() throws InterruptedException {
        driver.get("https://udemy.com");
        Thread.sleep(2000);
        //Act
        WebElement searchField = driver.findElement(By.xpath("(//*[@name='q'])[2]"));
        searchField.sendKeys("Java");
        searchField.sendKeys(Keys.ENTER);

        String title = driver.getTitle();
//        String url = driver.getCurrentUrl();

        Assert.assertTrue(title.equals("Online Courses - Anytime, Anywhere | Udemy"));
    }

    @Test
    public void login_ToKoel_LoggedToApp() throws InterruptedException {
        driver.get("https://koelapp.testpro.io/");
//        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement email = driver.findElement(By.xpath("//*[@type='email']"));
        WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//*[@type='submit']"));

        email.sendKeys("testpro.user03@testpro.io");
        password.sendKeys("te$t$tudent");
        loginButton.click();

        Thread.sleep(3000);

        List<WebElement> list = new ArrayList<>();
        list = driver.findElements(By.xpath("//*[@class='fa fa-sign-out control']"));

        Assert.assertFalse(list.size()==0);
    }

    @Test
    public void login_ToKoel_WrongCredentials() throws InterruptedException {
        driver.get("https://koelapp.testpro.io/");
        Thread.sleep(2000);

//        WebElement email = driver.findElement(By.xpath("//*[@type='email']"));
        WebElement email = driver.findElement(By.cssSelector("[type='email']"));
        WebElement password = driver.findElement(By.cssSelector("[type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//*[contains(@type,'subm')]"));
//        WebElement loginButton = driver.findElement(By.cssSelector("[type~='subm']"));

        email.sendKeys("testpro.user03@testpro.io");
        password.sendKeys("0te$t$tudent");
        loginButton.click();

        Thread.sleep(3000);

        List<WebElement> listOfErrors = new ArrayList<>();
        listOfErrors = driver.findElements(By.cssSelector(".error"));
        Assert.assertEquals(listOfErrors.size(),1);
    }
}
