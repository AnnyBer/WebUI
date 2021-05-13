package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestFromMail {

    WebDriver driver;
    WebDriverWait webDriverWait;
    private static final String URL = "https://mail.ru";
    private static final String AUTHORIZED_URL = "https://e.mail.ru/inbox/";

    @BeforeTest
    void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setUpBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, 6);
        driver.get(URL);
        login();
    }

    @Test
    void createNewLetter(){
        driver.get(AUTHORIZED_URL);
        driver.manage().window().maximize();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class= 'compose-button__txt']")));
        driver.findElement(By.xpath("//span[@class= 'compose-button__txt']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".container--ItIg4 > .inputContainer--nsqFu > .container--H9L5q")));
        driver.findElement(By.cssSelector(".container--ItIg4 > .inputContainer--nsqFu > .container--H9L5q")).sendKeys("ber.anny@yandex.ru");
        driver.findElement(By.xpath("//input[@name= 'Subject']")).sendKeys("Test");
        driver.findElement(By.xpath("//span[text() = 'Отправить']")).click();
        driver.findElement(By.xpath("//button[@data-test-id = 'false']")).sendKeys(Keys.ENTER);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text() = 'Письмо отправлено']")));
        driver.findElement(By.xpath("//*[text() = 'Письмо отправлено']"));
    }

    @Test
    void deleteLetter(){
        driver.get(AUTHORIZED_URL);
        driver.manage().window().maximize();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href = '/sent/']")));

        driver.findElement(By.xpath("//a[@href = '/sent/']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()= 'Test']")));
        driver.findElement(By.xpath("//span[text()= 'Test']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@data-title-shortcut= 'Del']")));

        driver.findElement(By.xpath("//span[@data-title-shortcut= 'Del']")).click();
  //      webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()= 'Перемещено в папку "Корзина"']")));

   //     driver.findElement(By.xpath("//*[text()= 'Перемещено в папку "Корзина"']"));

    }



    private  void login() {
        driver.findElement(By.name("login")).sendKeys("geektestbrains");
        driver.findElement(By.xpath("//button[@data-testid='enter-password']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-testid= 'password-input']")));
        driver.findElement(By.xpath("//input[@data-testid= 'password-input']")).sendKeys("geekbrains13");
        driver.findElement(By.xpath("//button[@data-testid = 'login-to-mail']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Входящие']")));
        driver.findElement(By.xpath("//div[text()='Входящие']"));

    }

    @AfterMethod
    void closeBrowser() {
        driver.quit();
    }
}
