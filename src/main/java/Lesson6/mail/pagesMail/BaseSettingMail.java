package Lesson6.mail.pagesMail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseSettingMail {
    WebDriver driver;
    WebDriverWait webDriverWait;

    public BaseSettingMail(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver, this);
    }
}
