package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static config.LocalThreadManager.getDriver;

public class CustomWaits  {

    //Wait Until JS Ready
    public static void waitUntilJSReady() {
        WebDriverWait wait = new WebDriverWait(getDriver(),15);
        JavascriptExecutor jsExec = (JavascriptExecutor) getDriver();

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = driver -> ((JavascriptExecutor) getDriver())
                .executeScript("return document.readyState").toString().equals("complete");

        //Get JS is Ready
        boolean jsReady = jsExec.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if(!jsReady) {
            System.out.println("JS in NOT Ready!");
            //Wait for Javascript to load
            wait.until(jsLoad);
        } else {
            System.out.println("JS is Ready!");
        }
    }
}
