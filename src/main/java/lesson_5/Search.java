package lesson_5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.concurrent.TimeUnit;

import static lesson_5.LoginPage.driver;
import static lesson_5.LoginPage.login;

public class Search {
    static {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        login();

        WebDriverWait driverWait = new WebDriverWait(driver, 5);
        driverWait.until(ExpectedConditions.visibilityOf(driver
                .findElement(By.cssSelector(".gb-top-menu__item > .show-search-form > .svg-icon")))).click();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//*[@class=\"search-panel__form ng-pristine ng-valid\"]/input[@name=\"q\"]"))))
                .sendKeys("java");

        new WebDriverWait(driver, 40)
                .until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//*[@class=\"profession-row-1\"]/div[2]"))));

        driver.quit();
    }
}
