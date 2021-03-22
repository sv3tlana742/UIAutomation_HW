package lesson_6.base;

import io.github.bonigarcia.wdm.WebDriverManager;

import lesson_6.listener.CustomLogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import static lesson_6.common.Configuration.*;
import static lesson_6.enums.ProfilesSubMenuIcon.*;
import static lesson_6.enums.TopMenu.*;

public class BaseUITest {
    protected EventFiringWebDriver driver;

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

        RemoteWebDriver chromeDriver = new ChromeDriver(options);
        chromeDriver.setLogLevel(Level.INFO);
        driver = new EventFiringWebDriver(chromeDriver);
        driver.register(new CustomLogger());
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(BASE_URL + LOGIN_PATH);
    }

    @AfterEach
    public void afterTest(){
        driver.findElement((PROFILE_ICON).getBy()).click();
        driver.findElement((PROFILE_EXIT).getBy()).click();

        driver
            .manage()
            .logs()
                .get(LogType.BROWSER)
                .getAll()
                .forEach(System.out::println);

        driver.quit();
    }
}
