package Lesson6.mail.pagesMail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class InboxMailPage extends BaseSettingMail{
    public InboxMailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class= 'compose-button__txt']")
            public WebElement newLetter;

    public NewLetterPage submitNewLetter(){
        webDriverWait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class= 'compose-button__txt']")));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(newLetter));
        newLetter.click();
        return new NewLetterPage(driver);
    }

    @FindBy(xpath = emailSentLocator)
    public WebElement emailSent;

    public static final String emailSentLocator = "//*[text() = 'Письмо отправлено']";


    @FindBy(xpath = "//a[@href = '/sent/']")
            public WebElement buttonSent;

    public SentPage selectButtonSent(){
        webDriverWait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href = '/sent/']")));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(buttonSent));
        buttonSent.click();
        return new SentPage(driver);
    }

}
