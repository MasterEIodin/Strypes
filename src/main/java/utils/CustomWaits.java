package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.LocalThreadManager.getDriver;

public class CustomWaits  {

    private static WebDriverWait jsWait;
    private static JavascriptExecutor jsExec;

    //Get the driver
    public static void setDriver () {
        jsWait = new WebDriverWait(getDriver(), 10);
        jsExec = (JavascriptExecutor) getDriver();
    }

    //Wait for JQuery Load
    public static void waitForJQueryLoad() {
        //Wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = driver -> ((Long) ((JavascriptExecutor) getDriver())
                .executeScript("return jQuery.active") == 0);

        //Get JQuery is Ready
        boolean jqueryReady = (Boolean) jsExec.executeScript("return jQuery.active==0");

        //Wait JQuery until it is Ready!
        if(!jqueryReady) {
            System.out.println("JQuery is NOT Ready!");
            //Wait for jQuery to load
            jsWait.until(jQueryLoad);
        } else {
            System.out.println("JQuery is Ready!");
        }
    }

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

    //Wait Until JQuery and JS Ready
    public static void waitUntilJQueryReady() {
        //First check that JQuery is defined on the page. If it is, then wait AJAX
        Boolean jQueryDefined = (Boolean) ((JavascriptExecutor) getDriver()).executeScript("return typeof jQuery != 'undefined'");
        if (jQueryDefined) {
            //Pre Wait for stability (Optional)
            sleep(20);

            //Wait JQuery Load
            waitForJQueryLoad();

            //Wait JS Load
            waitUntilJSReady();

            //Post Wait for stability (Optional)
            sleep(20);
        }  else {
            System.out.println("jQuery is not defined on this site!");
        }
    }


    private static void sleep(Integer seconds) {
        long secondsLong = (long) seconds;
        try {
            Thread.sleep(secondsLong);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
