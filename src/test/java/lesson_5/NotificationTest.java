package lesson_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationTest extends BeforeAfterTest {
    @DisplayName("Работа переключателя вкл/выкл. SMS уведомлений")
    @Test
    public void notificationSmsTest() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//*[@class=\"gb-top-menu__item dropdown\"]/a[@data-toggle=\"dropdown\"]"))))
                .click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//a[contains(.,'Профиль')]"))))
                .click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//a[contains(.,'Редактировать профиль')]"))))
                .click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//a[contains(text(),'Уведомления')]"))))
                .click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//label[@class=\"switch\"]/span"))))
                .click();

         String attribute = driver.findElement(By.xpath("//div[@class=\"checkbox checkbox-primary\"]/input[@disabled]"))
                .getAttribute("disabled");

        Assertions.assertTrue(Boolean.parseBoolean(attribute));

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//label[@class=\"switch\"]/span"))))
                .click();
    }
}
