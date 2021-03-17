package lesson_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest extends BeforeAfterTest{
    @DisplayName("Авторизация на сайте GB")
    @Test
    public void testLogin(){
        String headMain = new WebDriverWait(driver, 5).until(ExpectedConditions.visibilityOf(driver
                .findElement(By.xpath("//h2[@class=\"gb-header__title\"]")))).getText();

        Assertions.assertEquals("Главная", headMain);
    }
}
