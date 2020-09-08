package pages;

import org.openqa.selenium.By;
import utils.ElementOperations;

public class PodcastPage {

    private ElementOperations elementOperations = new ElementOperations();
    private By podcastTextLocator = By.xpath("//h1[contains(text(),'Podcast')]");

    public boolean isPodcastTextVisible() { return elementOperations.isElementVisible(podcastTextLocator); }
}
