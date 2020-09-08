package pages;

import org.openqa.selenium.By;
import utils.ElementOperations;

public class SubscribePage {

    private ElementOperations elementOperations = new ElementOperations();
    private By subscribeButton = By.xpath("//button[@class='btn btn--primary type--uppercase bgr-black']");
    private By emailTextField = By.xpath("//input[@placeholder='Share your email address to learn more']");
    private By toastSuccessful = By.xpath("//div[@class='toast-message']");

    public SubscribePage fillEmailAddress(String emailAddress) {
        elementOperations.fillInput(emailTextField, emailAddress);
        return this;
    }

    public SubscribePage clickSubscribeButton() {
        elementOperations.waitElementToBeClickable(subscribeButton);
        elementOperations.clickButton(subscribeButton);
        return this;
    }

    public boolean isSubscribeButtonClickable() { return elementOperations.isElementNotClickable(subscribeButton); }

    public boolean isToastVisible() { return elementOperations.isElementVisible(toastSuccessful); }
}
