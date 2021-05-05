package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ProjectCreation {

    private static WebDriver driver;
    private static  final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";


    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        login();

        driver.get("https://crm.geekbrains.space/project/my");
        driver.findElement(By.xpath("//a[text() = 'Создать проект'] ")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@name='crm_project[name]']")).sendKeys("testfortest12345678");
        Thread.sleep(10000);
        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("1234");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[contains(@id,'s2id_crm_project_contactMain')]/a")).click();
        driver.findElement(By.xpath("//select[@name=\"crm_project[contactMain]\"]/option[5]")).click();
        driver.findElement(By.xpath("//input[@name='crm_project[type]' and contains(@data-name, 'field__1')]")).click();
        Select selectSubdivision = new Select(driver.findElement(By.name("crm_project[businessUnit]")));
        selectSubdivision.selectByVisibleText("Research & Development");
        Select selectСurator = new Select(driver.findElement(By.name("crm_project[curator]")));
        selectСurator.selectByVisibleText("Applanatest Applanatest Applanatest");
        Select selectLeader = new Select(driver.findElement(By.name("crm_project[rp]")));
        selectLeader.selectByVisibleText("Авласёнок Денис");
        Select selectAdministrator = new Select(driver.findElement(By.name("crm_project[administrator]")));
        selectAdministrator.selectByVisibleText("Амелина Светлана");
        Select selectManager = new Select(driver.findElement(By.name("crm_project[manager]")));
        selectManager.selectByVisibleText("Козлов Илья");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();
        Thread.sleep(6000);
        driver.findElement(By.xpath("//*[text()='Проект сохранен']"));
        driver.quit();
    }

    private static void login(){
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();

    }
}
