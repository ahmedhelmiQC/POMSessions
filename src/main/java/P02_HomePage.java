import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class P02_HomePage {


    private final WebDriver driver;
    private final By Logout_Button =By.xpath("//button[contains(@class,logout)]");

    public P02_HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public void logoutButton(){
        driver.findElement(Logout_Button).click();
    }
}
