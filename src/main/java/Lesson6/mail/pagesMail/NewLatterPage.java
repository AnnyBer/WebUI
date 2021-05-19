package Lesson6.mail.pagesMail;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NewLatterPage extends BaseSettingMail{

    public NewLatterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".container--ItIg4 > .inputContainer--nsqFu > .container--H9L5q")
            public WebElement inputEmail;

    public NewLatterPage fillInputEmail(String email){
        inputEmail.sendKeys(email);
        return this;
    }

    @FindBy(xpath = "//input[@name= 'Subject']")
            public WebElement inputNameSubject;

    public NewLatterPage fillInputNameSubject(String nameSubject){
        inputNameSubject.sendKeys(nameSubject);
        return this;
    }

    @FindBy(xpath = "//span[text() = 'Отправить']")
            public WebElement buttonSend;

    @FindBy(xpath = "//button[@data-test-id = 'false']")
    public WebElement buttonFalse;

    public InboxMailPage submitButtonSend(){
        buttonSend.click();
        buttonFalse.sendKeys(Keys.ENTER);
        return new InboxMailPage(driver);
    }




}