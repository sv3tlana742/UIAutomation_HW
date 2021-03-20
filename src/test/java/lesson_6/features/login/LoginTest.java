package lesson_6.features.login;

import lesson_6.base.BaseUITest;
import lesson_6.page.LoginPage;
import org.junit.jupiter.api.Test;

import static lesson_6.common.Configuration.*;

public class LoginTest extends BaseUITest {

    @Test
    public void loginBaseTest(){
        new LoginPage(driver)
            .enterLogin(LOGIN)
            .enterPassword(PASSWORD)
            .clickButtonSignIn()
            .checkURL(BASE_URL);
    }
}
