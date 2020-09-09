import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PodcastPage;
import pages.VacanciesPage;
import config.BaseSetup;

public class NavigationTests extends BaseSetup {

    private HomePage homePage = new HomePage();

    @BeforeMethod
    public void launchWebsite() {
        homePage.openStrypesWebsite();
    }

    @Test
    public void checkPodcastButtonRedirection() {
        PodcastPage podcastPage = new PodcastPage();

        homePage.clickPodcastButton();

        Assert.assertTrue(podcastPage.isPodcastTextVisible());
    }

    @Test
    public void checkVacancies() {
        VacanciesPage vacanciesPage = new VacanciesPage();

        homePage.clickCareersButton();
        homePage.clickVacanciesButton();
        Assert.assertTrue(vacanciesPage.isApplyButtonVisible());
    }
}
