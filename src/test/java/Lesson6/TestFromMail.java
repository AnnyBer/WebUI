package Lesson6;

import Lesson6.mail.pagesMail.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Lesson6.mail.ConfigurationsMail.AUTHORIZED_URL;
import static Lesson6.mail.ConfigurationsMail.BASE_URL;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class TestFromMail extends BaseTest{

    @BeforeEach
    public void goToPage() {
        driver.get(BASE_URL);
    }

    @Test
    void createNewLatter(){
        new LoginPageMail(driver).loginMail("geektestbrains", "geekbrains13");
        driver.get(AUTHORIZED_URL);
        driver.manage().window().maximize();

        new InboxMailPage(driver).submitNewLetter();
        new NewLetterPage(driver)
                .fillInputEmail("ber.anny@yandex.ru")
                .fillInputNameSubject("Test")
                .submitButtonSend();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new InboxMailPage(driver).emailSentLocator)));
        assertThat (new InboxMailPage(driver).emailSent, isDisplayed());

    }

    @Test
    void deleteNewLetter(){

        new LoginPageMail(driver).loginMail("geektestbrains", "geekbrains13");
        driver.get(AUTHORIZED_URL);
        driver.manage().window().maximize();

        new InboxMailPage(driver).selectButtonSent();
        new SentPage(driver).selectNameLetter();
        new OpenLetterPage(driver).selectButtonDeleteLetter();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new OpenLetterPage(driver).requestSuccessDeleteLocator)));
        assertThat (new OpenLetterPage(driver).requestSuccessDelete, isDisplayed());


    }
}
