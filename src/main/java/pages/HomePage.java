package pages;

import org.openqa.selenium.By;
import utils.ElementOperations;

import static utils.LocalThreadManager.getDriver;

public class HomePage {

    private ElementOperations elementOperations = new ElementOperations();
    private By homeButton = By.xpath("//li[@class='dropdown']//a[contains(text(),'Home')]");
    private By podcastButton = By.xpath("//a[contains(text(),'Podcast')]");
    private By careersDropdown = By.xpath("//span[contains(text(),'Careers')]");
    private By vacanciesButton = By.xpath("//ul[@class='menu-vertical']//a[contains(text(),'Vacancies')]");
    private By subscribeButton = By.xpath("//span[@class='btn__text type--uppercase']");

    public HomePage openStrypesWebsite() {
        getDriver().navigate().to(System.getProperty("WEB_URL"));
        return this;
    }

    public HomePage clickPodcastButton() {
        elementOperations.clickButton(podcastButton);
        return this;
    }

    public HomePage clickCareersButton() {
        elementOperations.clickButton(careersDropdown);
        return this;
    }

    public HomePage clickVacanciesButton() {
        elementOperations.clickButton(vacanciesButton);
        return this;
    }

    public HomePage clickSubscribeButton() {
        elementOperations.clickButton(subscribeButton);
        return this;
    }

}
