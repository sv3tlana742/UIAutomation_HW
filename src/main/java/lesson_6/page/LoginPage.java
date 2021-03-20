package lesson_6.page;

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

    public LoginPage enterLogin(String login){
        inputLogin.sendKeys(login);
        return this;
    }
    public LoginPage enterPassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }
    public HomePage clickButtonSignIn(){
        buttonSignIn.click();
        return new HomePage(driver);
    }

    public HomePage loginForAnotherTest(String login, String password){
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSignIn.click();
        return new HomePage(driver);
    }
}
