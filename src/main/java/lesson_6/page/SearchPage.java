package lesson_6.page;

import io.qameta.allure.Step;
import lesson_6.base.BaseView;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static lesson_6.enums.TopMenu.SEARCH_ICON;
import static org.junit.jupiter.api.Assertions.*;

public class SearchPage extends BaseView {

    @FindBy(xpath = "//*[@class='search-panel__form ng-pristine ng-valid']/input[@name='q']")
    private WebElement inputText;

    @FindBy(xpath = "//input[@class='search-panel__search-reset']")
    private WebElement closeSearchLine;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Кликнуть на иконку поиска")
    public SearchPage clickSearchIcon(){
        driver.findElement((SEARCH_ICON).getBy()).click();
        return this;
    }

    @Step(value = "Ввести значение для поиска 'java'")
    public SearchPage enterText(String searchText){
        inputText.sendKeys(searchText);
        return this;
    }

    @Step(value = "Проверить содержат ли найденные элементы искомое слово")
    public SearchPage checkResult(String text){
        String message = wait30second.until(ExpectedConditions.visibilityOf(driver.findElement
                (By.xpath("//*[@class='profession-row-1']/div[2]")))).getText().toLowerCase();
        assertTrue(message.contains(text));
        return this;
    }

    @Step(value = "Закрыть строку поиса")
    public void exitSearchLine(){
        closeSearchLine.click();
        new HomePage(driver);
    }
}
