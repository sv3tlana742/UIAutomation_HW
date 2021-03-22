package lesson_6.features.Search;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lesson_6.base.BaseUITest;
import lesson_6.common.Configuration;
import lesson_6.page.LoginPage;
import org.junit.jupiter.api.Test;

import static lesson_6.common.Configuration.*;

@Feature("Работа строки поиска")
public class SearchTest extends BaseUITest {

    @Story("Поиск по слову 'Java'")
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
