package lesson_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchTest extends BeforeAfterTest{
    @DisplayName("Работа строки поиска")
    @Test
    public void searchLineTest(){
        WebDriverWait driverWait = new WebDriverWait(driver, 5);
        driverWait.until(ExpectedConditions.visibilityOf(driver
                .findElement(By.cssSelector(".gb-top-menu__item > .show-search-form > .svg-icon")))).click();

        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//*[@class=\"search-panel__form ng-pristine ng-valid\"]/input[@name=\"q\"]"))))
                .sendKeys("java");

        String text = new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//*[@class=\"profession-row-1\"]/div[2]")))).getText();

        Assertions.assertTrue(text.contains("Java"));

        driver.findElement(By.xpath("//input[@class=\"search-panel__search-reset\"]")).click();
    }
}
