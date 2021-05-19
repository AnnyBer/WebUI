package Lesson6.mail.pagesMail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InboxMailPage extends BaseSettingMail{
    public InboxMailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class= 'compose-button__txt']")
            public WebElement newLetter;

    public NewLatterPage submitNewLetter(){
        newLetter.click();
        return new NewLatterPage(driver);
    }

    @FindBy(xpath = emailSentLocator)
    public WebElement emailSent;

    public static final String emailSentLocator = "//*[text() = 'Письмо отправлено']";
}
