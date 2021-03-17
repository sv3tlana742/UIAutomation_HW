package lesson_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoursesFreeTest extends BeforeAfterTest{
    @DisplayName("Поиск курсов в категории \"Бесплатные\"")
    @Test
    public void CoursesTest(){

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//a[@class=\"gb-left-menu__nav-item \"][@href=\"/courses\"]"))))
                .click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.cssSelector(".nav #cour-link")))).click();

        new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.cssSelector("#filter-0+label"))))
                .click();

        String free = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElements(
                        By.cssSelector(".js-course-card:not([hidden]) .gb-course-card__badge")
                ).get(0)))
                .getText();

        Assertions.assertEquals("БЕСПЛАТНО", free);
    }

}
