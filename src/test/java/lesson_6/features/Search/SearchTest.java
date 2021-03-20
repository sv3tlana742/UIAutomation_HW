package lesson_6.features.Search;

import lesson_6.base.BaseUITest;
import lesson_6.common.Configuration;
import lesson_6.page.LoginPage;
import org.junit.jupiter.api.Test;

import static lesson_6.common.Configuration.*;

public class SearchTest extends BaseUITest {

    @Test
    public void searchLineTest(){
        new LoginPage(driver)
            .loginForAnotherTest(Configuration.LOGIN, Configuration.PASSWORD)
            .getSearchPage()
            .clickSearchIcon()
            .enterText(SEARCH_TEXT)
            .checkResult(RESULT_SEARCH_TEXT)
            .exitSearchLine();
    }
}
