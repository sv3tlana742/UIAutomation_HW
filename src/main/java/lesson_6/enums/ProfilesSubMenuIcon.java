package lesson_6.enums;

import org.openqa.selenium.By;

public enum ProfilesSubMenuIcon {

    PROFILE ("//a[contains(.,'Профиль')]"),
    REFERRAL_PROGRAM("//a[contains(.,'Реферальная программа')]"),
    PROFILE_EXIT ("//a[contains(@href, '/logout')]");

    private final By by;

    ProfilesSubMenuIcon(String xpath) {
        this.by = By.xpath(xpath);
    }

    public By getBy() {
        return by;
    }
}
