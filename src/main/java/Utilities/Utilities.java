package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utilities {
    /**
     * Utility function for finding , clicking an elements after waiting to be clicking
     * @param driver
     * @param locater object
     *

     */

    //ToDo:  clicking on element
    public static void clickOnElement(WebDriver driver , By locater){
        new WebDriverWait(driver , Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(locater));
        driver.findElement(locater).click();
    }
    //ToDo: sending date to element
    public static void sendText(WebDriver driver, By locator , String text){
        new WebDriverWait(driver , Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.findElement(locator).sendKeys(text);
    }

    //ToDo: selecting from drop down
    //ToDo: Tacking screenshots

    //ToDo: uploading files using robot

    //ToDo: converting to be element
    //ToDo: get timestamp

    //ToDo: reading data from json file
    //ToDo: reading data from property file
}


