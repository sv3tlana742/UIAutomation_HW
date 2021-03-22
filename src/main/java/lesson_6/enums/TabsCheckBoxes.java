package lesson_6.enums;

import org.openqa.selenium.By;

public enum TabsCheckBoxes {

     FREE_CHECKBOX("#filter-0+label");

     private final By by;
     TabsCheckBoxes(String css) {
          this.by = By.cssSelector(css);
     }

     public By getBy(){
          return by;
     }
}
