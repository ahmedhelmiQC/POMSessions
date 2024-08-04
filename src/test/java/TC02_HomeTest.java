import Pages.P01_LoginPage;
import Utilities.DataUtili;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.time.Duration;

public class TC02_HomeTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new EdgeDriver();
       driver.get("https://ashraaf7.github.io/AA-Practice-Test-Automation");
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void cickLogoutTC() throws FileNotFoundException {
        new P01_LoginPage(driver).enterUsernameText(DataUtili.getJsonData("validloginData","username"))
                .enterPassword(DataUtili.getJsonData("validloginData","password"))
                .clickLoginButton().logoutButton();
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/main.html");

    }

    @AfterMethod
    public void quite(){
        driver.quit();
    }
}
