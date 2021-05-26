package Lesson6.mail.pagesMail;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SentPage extends BaseSettingMail{
    public SentPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[text()= 'Test']")
            public WebElement nameLetter;

    @Step("Открытие письма")
    public OpenLetterPage selectNameLetter(){
        webDriverWait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()= 'Test']")));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(nameLetter));
        nameLetter.click();

        return new OpenLetterPage(driver);
    }

}
