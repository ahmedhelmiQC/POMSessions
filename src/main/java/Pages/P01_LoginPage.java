package Pages;

import Utilities.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P01_LoginPage {
    private WebDriver driver;

    private final By Username = By.id("inputUsername");
    private final By Password = By.id("inputPassword");
    private final By loginButton = By.id("loginButton");

    public P01_LoginPage (WebDriver driver){
        this.driver = driver;
    }
    public P01_LoginPage enterUsernameText(String usernametext){
        Utilities.sendText(driver,Username,usernametext);
        return this;
    }

    public P01_LoginPage enterPassword(String passwordtext){
    Utilities.sendText(driver,Password,passwordtext);
    return this;
    }
    public P02_HomePage clickLoginButton(){
        Utilities.clickOnElement(driver,loginButton);
        return new P02_HomePage(driver);
    }
}
