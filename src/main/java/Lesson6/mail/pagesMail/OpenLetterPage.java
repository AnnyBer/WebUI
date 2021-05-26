package Lesson6.mail.pagesMail;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpenLetterPage extends BaseSettingMail{
    public OpenLetterPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//span[@data-title-shortcut= 'Del']")
            public WebElement buttonDeleteLetter;

    @Step("Нажатие кнопки Удалить")
    public OpenLetterPage selectButtonDeleteLetter(){
        webDriverWait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-title-shortcut= 'Del']")));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(buttonDeleteLetter));
        buttonDeleteLetter.click();
        return new OpenLetterPage(driver);
    }

    @FindBy(xpath = requestSuccessDeleteLocator)
    public WebElement requestSuccessDelete;

    public static final String requestSuccessDeleteLocator = "//*[text()= 'Перемещено в папку «Корзина»']";

}
