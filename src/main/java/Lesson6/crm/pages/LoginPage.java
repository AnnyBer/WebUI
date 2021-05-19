package Lesson6.crm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BaseSettings{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id= "prependedInput")
    public WebElement inputLogin;

    @FindBy(id= "prependedInput2")
    public WebElement inputPassword;

    @FindBy(id= "_submit")
    public WebElement buttonSubmit;

    public LoginPage fillInputLogin(String login){
        inputLogin.sendKeys(login);
        return this;
    }

    public LoginPage fillInputPassword(String password){
        inputLogin.sendKeys(password);
        return this;
    }

    public MainPage submitLogin() {
        buttonSubmit.click();
        return new MainPage(driver);
    }

    public MainPage login(String login, String password){
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        return new MainPage(driver);
    }
}
