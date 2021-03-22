package lesson_6.page;

import io.qameta.allure.Step;
import lesson_6.base.BaseView;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseView {

    @FindBy(xpath = "//*[@id='user_email']")
    private WebElement inputLogin;

    @FindBy(xpath = "//*[@id='user_password']")
    private WebElement inputPassword;

    @FindBy(css = ".btn")
    private WebElement buttonSignIn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Ввести логин 'so@ova777.ru'")
    public LoginPage enterLogin(String login){
        inputLogin.sendKeys(login);
        return this;
    }

    @Step(value = "Ввести пароль 'Briv31So2'")
    public LoginPage enterPassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }

    @Step(value = "Кликнуть на кнопку 'Вход'")
    public HomePage clickButtonSignIn(){
        buttonSignIn.click();
        return new HomePage(driver);
    }

    @Step(value = "Авторизация на сайте GB")
    public HomePage loginForAnotherTest(String login, String password){
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSignIn.click();
        return new HomePage(driver);
    }
}
