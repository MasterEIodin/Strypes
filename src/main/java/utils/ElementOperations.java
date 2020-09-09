package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static config.LocalThreadManager.getDriver;

public class ElementOperations {

    /**
     * Use this for assertion purposes and not for waits before actions.
     * @param locator used to find the element.
     * @return true if the element is visible. Note that the element returns only false if the element is not present and doesn't throw an exception.
     */
    public boolean isElementVisible(By locator) {
        try {
            new WebDriverWait(getDriver(), 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * Use this for assertion purposes and not for waits before actions.
     * @param locator used to find the element.
     * @param seconds the seconds to wait for the element to be visible.
     * @return true if the element is visible. Note that the element returns only false if the element is not present and doesn't throw an exception.
     */
    public boolean isElementVisible(By locator, int seconds) {
        try {
            new WebDriverWait(getDriver(), seconds).until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isElementNotVisible(By locator, int waitTimeMs) {
        return new WebDriverWait(getDriver(), waitTimeMs).until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void clickEmptySpace() {
        getDriver().findElement(By.xpath("//html")).click();
    }

    public void clickButton(By locator) {
        CustomWaits.waitUntilJSReady();
        waitElementToBeClickable(locator);
        getDriver().findElement(locator).click();
    }

    public void clickButtonWithoutWaiting(By locator) {
        CustomWaits.waitUntilJSReady();
        getDriver().findElement(locator).click();
    }

    public void fillInput(By locator, String text) {
        CustomWaits.waitUntilJSReady();
        waitElementToBeClickable(locator);
        getDriver().findElement(locator).clear();
        getDriver().findElement(locator).sendKeys(text);
    }

    public void waitElementToBeClickable(By locator) {
        try {
            new WebDriverWait(getDriver(), 30).until(ExpectedConditions.elementToBeClickable(locator));
        } catch (StaleElementReferenceException e) {
            assertThat("Element is not clickable", false);
        }
    }

    public boolean isElementNotClickable(By locator) {
        return new WebDriverWait(getDriver(), 5).until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(locator)));
    }

    public void sendKeysAction(By locator, Keys key) {
        CustomWaits.waitUntilJSReady();
        waitElementToBeClickable(locator);
        getDriver().findElement(locator).sendKeys(key);
    }

    public void sendImagePath(By locator, String imagePath) {
        CustomWaits.waitUntilJSReady();
        getDriver().findElement(locator).sendKeys(imagePath);
    }
}

