package lesson_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static lesson_5.LoginPage.driver;

public class BeforeAfterTest {
    protected final String GB_URL = "https://geekbrains.ru/";
    protected final String USER_LOGIN = "so@ova777.ru";
    protected final String USER_PASSWORD = "Briv31So2";
    protected WebDriver driver;

    @BeforeAll
    public static void setUpDriverManager(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeTest(){
        setUpDriverSession();
        login();
    }

    @AfterEach
    public void afterTest() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
            .findElement(By.xpath("//*[@class=\"gb-top-menu__item dropdown\"]/a[@data-toggle=\"dropdown\"]"))))
                .click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//a[contains(@href, '/logout')]")))).click();

        if(driver != null){
            driver.quit();
        }
    }

    protected void setUpDriverSession(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    protected void login() {
        driver.get(GB_URL);

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//*[@id=\"gb-analytics-sign-in\"]")))).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//*[@id=\"user_email\"]")))).sendKeys(USER_LOGIN);

        driver.findElement(By.xpath("//*[@id=\"user_password\"]")).sendKeys(USER_PASSWORD);

        driver.findElement(By.cssSelector(".btn")).click();
    }
}
