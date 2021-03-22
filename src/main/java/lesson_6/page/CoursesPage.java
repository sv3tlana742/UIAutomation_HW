package lesson_6.page;

import io.qameta.allure.Step;
import lesson_6.base.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static lesson_6.enums.MainMenu.*;
import static lesson_6.enums.MainSubMenu.*;
import static lesson_6.enums.TabsCheckBoxes.*;
import static org.junit.jupiter.api.Assertions.*;

public class CoursesPage extends BaseView {

    @FindBy(css = ".js-course-card:not([hidden]) .gb-course-card__badge")
    private WebElement textCourse;

    public CoursesPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Кликнуть на элемент главного меню 'Курсы'")
    public CoursesPage clickCoursesLink(){
        driver.findElement((COURSES).getBy()).click();
        return this;
    }

    @Step(value = "Кликнуть на элемент подменю 'Курсы'")
    public CoursesPage clickCoursesLinkSubMenu(){
        driver.findElement((SUB_COURSES).getBy()).click();
        return this;
    }

    @Step(value = "Выбрать значение Checkbox 'Бесплатные'")
    public CoursesPage clickFreeCheckbox(){
        driver.findElement((FREE_CHECKBOX).getBy()).click();
        return this;
    }

    @Step(value = "Проверить, что на странице отобразились курсы с пометкой 'Бесплатные'")
    public CoursesPage checkTextFree(String text){
        String message = wait30second.until(ExpectedConditions.visibilityOf(textCourse))
                .getText().toLowerCase();
        assertTrue(message.contains(text));
        return this;
    }
}
