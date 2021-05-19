package Lesson6.crm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CreateProjectPage extends BaseSettings{

    public CreateProjectPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='crm_project[name]']")
            public WebElement projectName;

    public By projectNameLocator = By.xpath("//input[@name='crm_project[name]']");

    public CreateProjectPage inputProjectName(String pName){
        projectName.sendKeys(pName);
       return this;
    }

    @FindBy(xpath = "//span[text()='Укажите организацию']/..")
            public WebElement changeOrganizationProject;

    @FindBy(xpath = "//input[@class='select2-input select2-focused select2-active']")
        public WebElement inputNameOrganizationProject;

    @FindBy(xpath = "//li[@class= 'select2-results-dept-0 select2-result select2-result-selectable']")
        public WebElement correctNameOrganization;


    public CreateProjectPage changeOrganization(String nameOrganizationProject){
        changeOrganizationProject.click();
        inputNameOrganizationProject.sendKeys(nameOrganizationProject);
        webDriverWait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class= 'select2-results-dept-0 select2-result select2-result-selectable']")));
        correctNameOrganization.click();
                return this;
    }

    @FindBy(name= "crm_project[businessUnit]")
            public WebElement businessUnit;

    public CreateProjectPage selectBusinessUnit(String bUnit){
        new Select(businessUnit).selectByVisibleText(bUnit);
        return this;
    }

    @FindBy(name = "crm_project[curator]")
            public WebElement projectCurator;

    public CreateProjectPage selectProjectCurator(String pCurator){
        new Select(projectCurator).selectByVisibleText(pCurator);
        return this;
    }

    @FindBy(name = "crm_project[rp]")
    public WebElement rpSelect;

    public CreateProjectPage selectRp(String rp) {
        new Select(rpSelect).selectByVisibleText(rp);
        return this;
    }

    @FindBy(name = "crm_project[administrator]")
    public WebElement selectAdministrator;

    public CreateProjectPage selectAdministrator(String administrator) {
        new Select(selectAdministrator).selectByVisibleText(administrator);
        return this;
    }

    @FindBy(name = "crm_project[manager]")
    public WebElement projectManager;

    public CreateProjectPage selectManager(String manager) {
        new Select(projectManager).selectByVisibleText(manager);
        return this;
    }

    @FindBy(xpath = "//div[@class= 'select2-container select2']/a")
    public WebElement contactMain;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    public WebElement inputContactMain;

    public CreateProjectPage selectContactMain() {
        webDriverWait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class= 'select2-container select2']/a")));
        contactMain.click();
        inputContactMain.sendKeys("Ivanov Ivan");
        webDriverWait.until
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name=\"crm_project[contactMain]\"]/option[5]")));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputContactMain));
        inputContactMain.sendKeys(Keys.ENTER);
        return this;
    }

    @FindBy(xpath = "//button[contains(text(),'Сохранить и закрыть')]")
    public WebElement buttonSaveAndClose;

    @FindBy(xpath = requestSuccessLocator)
    public WebElement requestSuccess;

    public static final String requestSuccessLocator = "//*[text()='Проект сохранен']";

}
