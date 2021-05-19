package Lesson6;

import Lesson6.crm.pages.CreateContactPersonPage;
import Lesson6.mail.pagesMail.InboxMailPage;
import Lesson6.mail.pagesMail.LoginPageMail;
import Lesson6.mail.pagesMail.NewLatterPage;
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

        new InboxMailPage(driver).submitNewLetter();
        new NewLatterPage(driver)
                .fillInputEmail("ber.anny@yandex.ru")
                .fillInputNameSubject("Test")
                .submitButtonSend();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new InboxMailPage(driver).emailSentLocator)));
        assertThat (new InboxMailPage(driver).emailSent, isDisplayed());

    }



   /* public InboxMailPage newLatterSend(String email, String nameSubject){
        inputEmail.sendKeys(email);
        inputNameSubject.sendKeys(nameSubject);
        buttonSend.click();
        buttonFalse.sendKeys(Keys.ENTER);
        return new InboxMailPage(driver);
    }

    */
}
