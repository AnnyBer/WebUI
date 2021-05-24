package Lesson6.crm.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllMyProjectPage extends BaseSettings{
    public AllMyProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text() = 'Создать проект']")
    public WebElement createProjectButton;

    @Step("Клик на кнопку Создать проект")
    public void createProject() {
        createProjectButton.click();
        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(new CreateProjectPage(driver).projectNameLocator));
    }
    public By createProjectButtonLocator = By.xpath("//a[text() = 'Создать проект']");
}
