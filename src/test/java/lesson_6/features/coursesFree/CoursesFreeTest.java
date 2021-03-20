package lesson_6.features.coursesFree;

import lesson_6.base.BaseUITest;
import lesson_6.common.Configuration;
import lesson_6.page.LoginPage;
import org.junit.jupiter.api.Test;

import static lesson_6.common.Configuration.RESULT_FREE_TEXT;

public class CoursesFreeTest extends BaseUITest {
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
