package Utilities;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class Utilities {
    private static String Screenshots_Path = "test-outputs/screenshot/";
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
    public static void takescreenshot(WebDriver driver , String screenshotname) throws IOException {
        File screenSrc = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); // take screenshot
        File screenDest= new File(Screenshots_Path+screenshotname+".png"); // where save the screen
        FileUtils.copyFile(screenSrc,screenDest);
        Allure.addAttachment(screenshotname, Files.newInputStream(Path.of(screenDest.getPath())));
    }

    //ToDo: uploading files using robot

    //ToDo: converting to be element
    //ToDo: get timestamp

    //ToDo: reading data from json file
    //ToDo: reading data from property file
}


