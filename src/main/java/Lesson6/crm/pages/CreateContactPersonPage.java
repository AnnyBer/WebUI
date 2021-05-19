package Lesson6.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateContactPersonPage extends BaseSettings{

    public CreateContactPersonPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath= "//input[@name='crm_contact[lastName]']")
        public WebElement inputLastName;

    public CreateContactPersonPage fillInputLastName(String lastName){
        inputLastName.sendKeys(lastName);
        return this;
    }

    @FindBy(xpath= "//input[@name='crm_contact[firstName]']")
            public WebElement inputFirstName;

    public By inputFirstNameLocator = By.xpath("//input[@name='crm_contact[firstName]']");

    public CreateContactPersonPage fillInputFirstName(String firstName){
        inputFirstName.sendKeys(firstName);
        return this;
    }

    @FindBy(xpath= "//span[text()='Укажите организацию']//..")
             public WebElement openListOrganizations;

    @FindBy(css= ".select2-input")
            public  WebElement inputNameOrganization;

    public CreateContactPersonPage selectOrganization(String nameOrganization){
        openListOrganizations.click();
        inputNameOrganization.sendKeys("1234");
        webDriverWait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + nameOrganization + "']")));
        inputNameOrganization.sendKeys(Keys.ENTER);
        return this;
        }

    @FindBy(xpath = "//input[@name='crm_contact[jobTitle]']")
        public WebElement inputJobTitle;

    public CreateContactPersonPage fillInputJobTitle(String jobTitle){
        inputJobTitle.sendKeys("Director");
        inputJobTitle.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
            public WebElement buttonSaveAndClose;

    @FindBy(xpath = requestSuccessContactLocator)
    public WebElement requestSuccessContact;

    public static final String requestSuccessContactLocator = "//*[text()='Контактное лицо сохранено']";

}
