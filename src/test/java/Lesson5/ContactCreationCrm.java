package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ContactCreationCrm {
    WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String URL = "https://crm.geekbrains.space/user/login";
    private static final String CREATE_CONTACT_URL = "https://crm.geekbrains.space/contact/";
    private static final String CREATE_PROJECT_URL = "https://crm.geekbrains.space/project/my";

    @BeforeTest
    void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setUpBrowser(){
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 10);
        driver.get(URL);
        login();
    }

    @Test
    void createContact(){
        driver.get(CREATE_CONTACT_URL);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text() = 'Создать контактное лицо']")));
        driver.findElement(By.xpath("//a[text() = 'Создать контактное лицо']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='crm_contact[lastName]']")));
        driver.findElement(By.xpath("//input[@name='crm_contact[lastName]']")).sendKeys("Овсянников");
        driver.findElement(By.xpath("//input[@name='crm_contact[firstName]']")).sendKeys("Греча");
        driver.findElement(By.xpath("//span[text()='Укажите организацию']//..")).click();
        driver.findElement(By.cssSelector(".select2-input")).sendKeys("1234");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='1234']")));
        driver.findElement(By.cssSelector(".select2-input")).sendKeys(Keys.ENTER);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='crm_contact[jobTitle]']")));
        driver.findElement(By.xpath("//input[@name='crm_contact[jobTitle]']")).sendKeys("Director");
        driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Контактное лицо сохранено']")));
        driver.findElement(By.xpath("//*[text()='Контактное лицо сохранено']"));
    }

    @Test
    void createProject(){
        driver.get(CREATE_PROJECT_URL);
        driver.findElement(By.xpath("//a[text() = 'Создать проект']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='crm_project[name]']")));
        driver.findElement(By.xpath("//input[@name='crm_project[name]']")).sendKeys("testfortest123456789");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Укажите организацию']/..")));
        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='select2-input select2-focused select2-active']")));
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused select2-active']")).sendKeys("1234");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='select2-results-dept-0 select2-result select2-result-selectable']")));
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@id,'s2id_crm_project_contactMain')]/a")));
        driver.findElement(By.xpath("//div[contains(@id,'s2id_crm_project_contactMain')]/a")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@name=\"crm_project[contactMain]\"]/option[5]")));
        driver.findElement(By.xpath("//select[@name=\"crm_project[contactMain]\"]/option[5]")).click();
        driver.findElement(By.xpath("//input[@name='crm_project[type]' and contains(@data-name, 'field__1')]")).click();
        Select selectSubdivision = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        selectSubdivision.selectByVisibleText("Research & Development");
        Select selectCurator = new Select(driver.findElement(By.name("crm_project[curator]")));
        selectCurator.selectByVisibleText("Applanatest Applanatest Applanatest");
        Select selectLeader = new Select(driver.findElement(By.name("crm_project[rp]")));
        selectLeader.selectByVisibleText("Авласёнок Денис");
        Select selectAdministrator = new Select(driver.findElement(By.name("crm_project[administrator]")));
        selectAdministrator.selectByVisibleText("Амелина Светлана");
        Select selectManager = new Select(driver.findElement(By.name("crm_project[manager]")));
        selectManager.selectByVisibleText("Козлов Илья");
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")));
        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Проект сохранен']")));
        driver.findElement(By.xpath("//*[text()='Проект сохранен']"));
    }

    private  void login(){
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();

    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}
