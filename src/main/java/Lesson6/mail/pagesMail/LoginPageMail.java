package Lesson6.mail.pagesMail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageMail extends BaseSettingMail{

    public LoginPageMail(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "login")
            public WebElement inputLogin;

    public LoginPageMail fillInputLogin(String login){
        inputLogin.sendKeys(login);
        return this;
    }

    @FindBy(xpath = "//button[@data-testid='enter-password']")
            public WebElement enterPassword;

    public LoginPageMail buttonSubmitPassword(){
        enterPassword.click();
        return this;
    }

    @FindBy(xpath = "//input[@data-testid= 'password-input']")
            public WebElement inputPassword;

    public LoginPageMail fillInputPassword(String password){
        inputPassword.sendKeys(password);
        return this;
    }

    @FindBy(xpath = "//button[@data-testid = 'login-to-mail']")
        public WebElement buttonSubmitMail;

    public InboxMailPage submitLoginMail(){
        buttonSubmitMail.click();
        return new InboxMailPage(driver);
    }

    public InboxMailPage loginMail(String login, String password) {
        inputLogin.sendKeys(login);
        enterPassword.click();
        inputPassword.sendKeys(password);
        buttonSubmitMail.click();
        return new InboxMailPage(driver);

    }
  /*  driver.findElement(By.xpath("//input[@data-testid= 'password-input']")).sendKeys("geekbrains13");
        driver.findElement(By.xpath("//button[@data-testid = 'login-to-mail']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Входящие']")));
        driver.findElement(By.xpath("//div[text()='Входящие']"));

   */
}
