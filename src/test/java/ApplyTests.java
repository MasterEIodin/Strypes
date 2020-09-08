import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ApplicationPage;
import pages.HomePage;
import pages.VacanciesPage;
import utils.BaseSetup;

public class ApplyTests extends BaseSetup {

    HomePage homePage = new HomePage();
    VacanciesPage vacanciesPage = new VacanciesPage();
    ApplicationPage applicationPage = new ApplicationPage();

    @BeforeMethod
    public void getToApplicationPage() {
        homePage
                .openStrypesWebsite()
                .clickCareersButton()
                .clickVacanciesButton();
        vacanciesPage.clickApplyButton();

    }

    /**
     This test is for proof of concept purposes only, hence the values being hardcoded.
     **/

    @Test
    public void applyForAJob() {
        applicationPage
                .fillFirstName("Dimitar")
                .fillLastName("Dimitrov")
                .fillDateOfBirth("11/04/1987")
                .fillEmailAddress("dimitar_kd@mail.bg")
                .fillMobilePhone("+359897490723")
                .chooseSource()
                .acceptTermsAndConditions()
                .clickUploadDocumentButton();
        // applicationPage.clickSubmitApplicationButton();

    }
}
