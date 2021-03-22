package lesson_6.enums;

import org.openqa.selenium.By;

public enum TopMenu {

    SEARCH_ICON ("//*[@id='top-menu']//*[@class='show-search-form']/*[@class='svg-icon icon-search ']"),
    PROFILE_ICON ("//*[@class='gb-top-menu__item dropdown']/a[@data-toggle='dropdown']");

    private final By by;

    TopMenu (String xpath) {
        this.by = By.xpath(xpath);
    }

    public By getBy() {
        return by;
    }

}
