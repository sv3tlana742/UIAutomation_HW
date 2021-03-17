package lesson_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class ReferralProgramTest extends BeforeAfterTest{
    @DisplayName("Переход на вкладку \"Правила реферальной программы\"")
    @Test
    public void referralProgramRegTest(){
        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//*[@class=\"gb-top-menu__item dropdown\"]/a[@data-toggle=\"dropdown\"]"))))
                .click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//a[contains(.,'Реферальная программа')]"))))
                .click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//a[@href=\"/rules_referral\"]"))))
                .click();

        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        Assertions.assertEquals("Правила реферальной программы",
                new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//h2[contains(.,'Правила реферальной программы')]")))).getText());

        driver.close();

        driver.switchTo().window(tabs.get(0));
    }
}
