package lesson_6.features.coursesFree;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lesson_6.base.BaseUITest;
import lesson_6.common.Configuration;
import lesson_6.page.LoginPage;
import org.junit.jupiter.api.Test;

import static lesson_6.common.Configuration.RESULT_FREE_TEXT;

@Feature("Использование checkbox для выбора курсов")
public class CoursesFreeTest extends BaseUITest {

    @Story("Выбор бесплатных курсов")
    @Test
    public void coursesFreeTest(){
        new LoginPage(driver)
            .loginForAnotherTest(Configuration.LOGIN, Configuration.PASSWORD)
            .getCoursesPage()
            .clickCoursesLink()
            .clickCoursesLinkSubMenu()
            .clickFreeCheckbox()
            .checkTextFree(RESULT_FREE_TEXT);
    }
}
