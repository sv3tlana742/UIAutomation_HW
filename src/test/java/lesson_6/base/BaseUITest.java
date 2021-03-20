package lesson_6.base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static lesson_6.common.Configuration.*;
import static lesson_6.enums.ProfilesSubMenuIcon.*;
import static lesson_6.enums.TopMenu.*;

public class BaseUITest {
    protected WebDriver driver;

    @BeforeAll
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeTest(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(BASE_URL + LOGIN_PATH);
    }

    @AfterEach
    public void afterTest(){
        driver.findElement((PROFILE_ICON).getBy()).click();
        driver.findElement((PROFILE_EXIT).getBy()).click();
        driver.quit();
    }
}
