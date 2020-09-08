package pages;

import org.openqa.selenium.By;
import utils.ElementOperations;

public class VacanciesPage {

    private ElementOperations elementOperations = new ElementOperations();
    private By applyButtonLocator = By.xpath("//span[contains(text(),'Open Application')]");

    public VacanciesPage clickApplyButton() {
        elementOperations.clickButton(applyButtonLocator);
        return this;
    }

    public boolean isApplyButtonVisible() { return elementOperations.isElementVisible(applyButtonLocator); }
}
