package lesson_6.enums;

import org.openqa.selenium.By;

public enum MainSubMenu {

    SUB_COURSES(".nav #cour-link");

    private final By by;

    MainSubMenu(String css) {
        this.by = By.cssSelector(css);
    }

    public By getBy(){
        return by;
    }
}
