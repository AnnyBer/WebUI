package Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactCreationMailRu {

    private static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://mail.ru");
        driver.findElement(By.xpath("//a[text() = 'Регистрация']")).click();
        Thread.sleep(6000);
        //driver.findElement(By.xpath("//button[text()='Пропустить']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("fname")).sendKeys("Наталия");
        driver.findElement(By.id("lname")).sendKeys("Морозова");

        driver.findElement(By.xpath("//div[@data-test-id='birth-date__day']")).click();
        driver.findElement(By.xpath("//div[@data-test-id='select-value:5']")).click();
        driver.findElement(By.xpath("//div[@data-test-id='birth-date__month']")).click();
        driver.findElement(By.xpath("//div[@data-test-id='select-value:3']")).click();
        driver.findElement(By.xpath("//div[@data-test-id='birth-date__year']")).click();
        driver.findElement(By.xpath("//div[@data-test-id='select-value:1970']")).click();
        Thread.sleep(7000);
        driver.findElement(By.xpath("//input[@class='input-0-2-101' and contains(@value, 'female')]")).click();


    }
}
