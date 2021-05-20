package Lesson6.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ContactPersonsPage extends BaseSettings{

    public ContactPersonsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[text() = 'Создать контактное лицо']")
    public WebElement createContactPersonButton;

    public void createContactPerson() {
        createContactPersonButton.click();
               webDriverWait.until(
                      ExpectedConditions.presenceOfElementLocated(new CreateContactPersonPage(driver).inputFirstNameLocator));
    }
    public By createContactPersonButtonLocator = By.xpath("//a[text() = 'Создать контактное лицо']");
}
