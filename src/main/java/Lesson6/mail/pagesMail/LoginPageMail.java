package Lesson6.mail.pagesMail;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageMail extends BaseSettingMail{

    public LoginPageMail(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "login")
            public WebElement inputLogin;

    @FindBy(xpath = "//button[@data-testid='enter-password']")
            public WebElement enterPassword;

    @FindBy(xpath = "//input[@data-testid= 'password-input']")
            public WebElement inputPassword;

    @FindBy(xpath = "//button[@data-testid = 'login-to-mail']")
        public WebElement buttonSubmitMail;

    @Step("Авторизация")
    public InboxMailPage loginMail(String login, String password) {
        inputLogin.sendKeys(login);
        enterPassword.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputPassword));
        inputPassword.sendKeys(password);
        buttonSubmitMail.click();
        return new InboxMailPage(driver);
    }
}
