package pages;

import com.github.javafaker.App;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.ElementOperations;

public class ApplicationPage {

    private ElementOperations elementOperations = new ElementOperations();
    private By firstNameField = By.cssSelector("[id='j_id0:SiteTemplate:j_id266:j_id269:blocksection_0:j_id270:0:j_id271:j_id274'");
    private By lastNameField = By.cssSelector("[id='j_id0:SiteTemplate:j_id266:j_id269:blocksection_0:j_id270:1:j_id271:j_id274'");
    private By dateOfBirthField = By.cssSelector("[id='j_id0:SiteTemplate:j_id266:j_id269:blocksection_0:j_id270:2:j_id271:j_id274'");
    private By emailAddressField = By.cssSelector("[id='j_id0:SiteTemplate:j_id266:j_id269:blocksection_0:j_id270:3:j_id275:j_id278'");
    private By mobilePhoneField = By.cssSelector("[id='j_id0:SiteTemplate:j_id266:j_id269:blocksection_0:j_id270:4:j_id271:j_id274'");
    private By sourceDropdown = By.cssSelector("[id='j_id0:SiteTemplate:j_id266:j_id269:blocksection_1:j_id317:0:j_id322:j_id325'");
    private By source = By.xpath("//option[contains(text(),'Other')]");
    private By acceptTermsCheckbox = By.cssSelector("[name='j_id0:SiteTemplate:j_id266:j_id269:blocksection_19:j_id459:j_id474'");
    private By uploadButtonLocator = By.cssSelector("[id='j_id0:SiteTemplate:j_id266:j_id269:j_id412:0:j_id414:j_id415:j_id421'");
    private By submitApplicationButton = By.cssSelector("[name='j_id0:SiteTemplate:j_id206:j_id208:j_id231'");


    public ApplicationPage fillFirstName(String firstName) {
        elementOperations.fillInput(firstNameField, firstName);
        return this;
    }

    public ApplicationPage fillLastName(String lastName) {
        elementOperations.fillInput(lastNameField, lastName);
        return this;
    }


    public ApplicationPage fillDateOfBirth(String dateOfBirth) {
        elementOperations.fillInput(dateOfBirthField, dateOfBirth);
        elementOperations.clickEmptySpace();
        return this;
    }

    public ApplicationPage fillEmailAddress(String emailAddress) {
        elementOperations.fillInput(emailAddressField, emailAddress);
        return this;
    }

    public ApplicationPage fillMobilePhone(String mobilePhone) {
        elementOperations.fillInput(mobilePhoneField, mobilePhone);
        return this;
    }

    public ApplicationPage chooseSource() {
        elementOperations.clickButton(sourceDropdown);
        elementOperations.clickButton(source);
        elementOperations.clickEmptySpace();
        return this;
    }

    public ApplicationPage acceptTermsAndConditions() {
        elementOperations.clickButton(acceptTermsCheckbox);
        return this;
    }

    public ApplicationPage clickUploadDocumentButton() {
        elementOperations.sendImagePath(uploadButtonLocator, "D:/projects/strypes/CV.pdf");
        return this;
    }

    public ApplicationPage clickSubmitApplicationButton() {
        elementOperations.clickButton(submitApplicationButton);
        return this;
    }
}
