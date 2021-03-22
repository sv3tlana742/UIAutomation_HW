package lesson_6.page;

import lesson_6.base.BaseView;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseView {
    private SearchPage searchPage;
    private CoursesPage coursesPage;

    public HomePage(WebDriver driver) {
        super(driver);
        this.searchPage = new SearchPage(driver);
        this.coursesPage = new CoursesPage(driver);
    }

    public void checkURL(String url){
        assertEquals(driver.getCurrentUrl(), url);
    }

    public SearchPage getSearchPage() {
        return searchPage;
    }

    public CoursesPage getCoursesPage() {
        return coursesPage;
    }
}
