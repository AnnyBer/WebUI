package Lesson6.crm.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
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

    @Step("Ввод Имени")
    public CreateContactPersonPage fillInputLastName(String lastName){
        inputLastName.sendKeys(lastName);
        return this;
    }

    @FindBy(xpath= "//input[@name='crm_contact[firstName]']")
            public WebElement inputFirstName;

    public By inputFirstNameLocator = By.xpath("//input[@name='crm_contact[firstName]']");

    @Step("Ввод Фамилии")
    public CreateContactPersonPage fillInputFirstName(String firstName){
        inputFirstName.sendKeys(firstName);
        return this;
    }

    @FindBy(xpath= "//span[text()='Укажите организацию']//..")
             public WebElement openListOrganizations;

    @FindBy(css= ".select2-input")
            public  WebElement inputNameOrganization;

    @Step("Выбор Организации")
    public CreateContactPersonPage selectOrganization(String nameOrganization){
        openListOrganizations.click();
        inputNameOrganization.sendKeys(nameOrganization);
        webDriverWait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='" + nameOrganization + "']")));
        inputNameOrganization.sendKeys(Keys.ENTER);
        return this;
        }

    @FindBy(xpath = "//input[@name='crm_contact[jobTitle]']")
        public WebElement inputJobTitle;

    @Step("Ввод Должности")
    public CreateContactPersonPage fillInputJobTitle(String jobTitle){
        inputJobTitle.sendKeys("Director");
        inputJobTitle.sendKeys(Keys.ENTER);
        webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='loader-overlay']")));
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
            public WebElement buttonSaveAndClose;

    @Step("Нажатие кнопки Сохранить и закрыть")
    public ContactPersonsPage selectButtonSaveAndClose(){
        webDriverWait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(buttonSaveAndClose));
        buttonSaveAndClose.click();
        return new ContactPersonsPage(driver);
    }
    @FindBy(xpath = requestSuccessContactLocator)
    public WebElement requestSuccessContact;

    public static final String requestSuccessContactLocator = "//*[text()='Контактное лицо сохранено']";

}
