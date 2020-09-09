
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ApplicationPage;
import pages.HomePage;
import pages.VacanciesPage;
import config.BaseSetup;
import utils.DataGenerator;

public class ApplyTests extends BaseSetup {

    HomePage homePage = new HomePage();
    VacanciesPage vacanciesPage = new VacanciesPage();
    ApplicationPage applicationPage = new ApplicationPage();
    DataGenerator dataGenerator = new DataGenerator();

    @BeforeMethod
    public void getToApplicationPage() {
        homePage
                .openStrypesWebsite()
                .clickCareersButton()
                .clickVacanciesButton();
        vacanciesPage.clickApplyButton();

    }

    /**
     The positive test is intentionally left incomplete to avoid spamming the system - hence the "Submit application" button is only clicked on negative scenarios
     **/

    @Test
    public void applyForAJob() {
        applicationPage
                .fillFirstName(dataGenerator.generateFirstName())
                .fillLastName(dataGenerator.generateLastName())
                .fillDateOfBirth(dataGenerator.generateDateOfBirth())
                .fillEmailAddress(dataGenerator.generateEmailAddress())
                .fillMobilePhone(dataGenerator.generatePhoneNumber())
                .chooseSource()
                .acceptTermsAndConditions()
                .clickUploadDocumentButton();

        // applicationPage.clickSubmitApplicationButton();
    }

    /** Found a bug in the negative tests: it is possible to "submit" the application even if some mandatory fields are not filled/selected.
        There is no error message displayed and user data is then cleared **/

    @Test
    public void tryApplicationEmptyFirstName() {
        applicationPage
                .fillLastName(dataGenerator.generateLastName())
                .fillMobilePhone(dataGenerator.generatePhoneNumber())
                .fillEmailAddress(dataGenerator.generateEmailAddress())
                .fillDateOfBirth(dataGenerator.generateDateOfBirth())
                .chooseSource()
                .acceptTermsAndConditions()
                .clickUploadDocumentButton()
                .clickSubmitApplicationButton();

    }

    @Test
    public void tryApplicationTermsNotAccepted() {
        applicationPage
                .fillFirstName(dataGenerator.generateFirstName())
                .fillLastName(dataGenerator.generateLastName())
                .fillMobilePhone(dataGenerator.generatePhoneNumber())
                .fillDateOfBirth(dataGenerator.generateDateOfBirth())
                .fillEmailAddress(dataGenerator.generateEmailAddress())
                .chooseSource()
                .acceptTermsAndConditions()
                .clickUploadDocumentButton()
                .clickSubmitApplicationButton();

    }

    @Test
    public void tryApplicationInvalidEmailAddress() {
        applicationPage
                .fillFirstName(dataGenerator.generateFirstName())
                .fillLastName(dataGenerator.generateLastName())
                .fillMobilePhone(dataGenerator.generatePhoneNumber())
                .fillDateOfBirth(dataGenerator.generateDateOfBirth())
                .fillEmailAddress("invalid@")
                .chooseSource()
                .acceptTermsAndConditions()
                .clickUploadDocumentButton()
                .clickSubmitApplicationButton();

    }

}
