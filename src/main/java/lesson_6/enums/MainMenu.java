package lesson_6.enums;

import org.openqa.selenium.By;

public enum MainMenu {

    COURSES ("//a[@class='gb-left-menu__nav-item '][@href='/courses']");

    private final By by;

    MainMenu(String xpath) {
        this.by = By.xpath(xpath);
    }

    public By getBy() {
        return by;
    }
}
