import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SubscribePage;
import utils.BaseSetup;
import utils.DataGenerator;

public class SubscribeTests extends BaseSetup {

    private HomePage homePage = new HomePage();
    private SubscribePage subscribePage = new SubscribePage();
    private DataGenerator dataGenerator = new DataGenerator();

    @BeforeMethod
    public void launchWebsite() {
        homePage.openStrypesWebsite();
        homePage.clickSubscribeButton();
    }


    @Test
    public void subscribeWithValidEmail() {
        subscribePage.fillEmailAddress(dataGenerator.generateEmailAddress());
        subscribePage.clickSubscribeButton();
        Assert.assertTrue(subscribePage.isToastVisible());
    }

    @Test
    public void tryToSubscribeInvalidEmailAddress() {
        subscribePage.fillEmailAddress("Invalid Email Address");
        Assert.assertTrue(subscribePage.isSubscribeButtonClickable());
    }

    @Test
    public void tryToSubscribeWithBlankEmail() {
        subscribePage.fillEmailAddress("");
        subscribePage.clickSubscribeButton();
        Assert.assertTrue(subscribePage.isToastVisible());
    }

}
