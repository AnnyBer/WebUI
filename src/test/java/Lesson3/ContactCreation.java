package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactCreation {

    private static WebDriver driver;
    private static  final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        login();

    driver.get("https://crm.geekbrains.space/contact/");
    Thread.sleep(3000);
    driver.findElement(By.xpath("//a[text() = 'Создать контактное лицо']")).click();
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@name='crm_contact[lastName]']")).sendKeys("Овсянников");
    driver.findElement(By.xpath("//input[@name='crm_contact[firstName]']")).sendKeys("Греча");
    driver.findElement(By.xpath("//span[text()='Укажите организацию']//..")).click();
    driver.findElement(By.cssSelector(".select2-input")).sendKeys("1234");
    Thread.sleep(3000);
    driver.findElement(By.cssSelector(".select2-input")).sendKeys(Keys.ENTER);
    Thread.sleep(3000);
    driver.findElement(By.xpath("//input[@name='crm_contact[jobTitle]']")).sendKeys("Director");
    driver.findElement(By.xpath("//button[@class='btn btn-success action-button']")).click();
    Thread.sleep(6000);
    driver.findElement(By.xpath("//*[text()='Контактное лицо сохранено']"));

    driver.quit();


    }
    private static void login(){
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();

    }

}

