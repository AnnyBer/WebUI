package Lesson6;

import Lesson6.crm.pages.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Lesson6.crm.Configurations.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class TestFromCrm extends BaseTest {

    @BeforeEach
    public void goToPage() {
        driver.get(URL);
    }

    @Test
    void createNewContactPerson(){
        new LoginPage(driver).login("Applanatest1", "Student2020!");
        driver.get(CREATE_CONTACT_URL);

        new ContactPersonsPage(driver).createContactPerson();
        new CreateContactPersonPage(driver)
                .fillInputLastName("Овсянников")
                .fillInputFirstName("Греча")
                .selectOrganization("1234")
                .fillInputJobTitle("Director")
                .selectButtonSaveAndClose();

        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new CreateContactPersonPage(driver).requestSuccessContactLocator)));
        assertThat (new CreateContactPersonPage(driver).requestSuccessContact, isDisplayed());

    }

    @Test
    void createNewProject(){
        new LoginPage(driver).login("Applanatest1", "Student2020!");
        driver.get(CREATE_PROJECT_URL);

        new AllMyProjectPage(driver).createProject();
        new CreateProjectPage(driver)
                .inputProjectName("test4test123456")
                .changeOrganization("Континент+")
                .selectBusinessUnit("Research & Development")
                .selectProjectCurator("Applanatest Applanatest Applanatest")
                .selectRp("Авласёнок Денис")
                .selectAdministrator("Амелина Светлана")
                .selectManager("Козлов Илья")
                .selectContactMain("Форточкина Евдокия")
                .buttonSaveAndClose.click();


        webDriverWait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(new CreateProjectPage(driver).requestSuccessLocator)));

        assertThat(new CreateProjectPage(driver).requestSuccess, isDisplayed());
    }

}
