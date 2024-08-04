import Pages.P01_LoginPage;
import Utilities.DataUtili;
import Utilities.Utilities;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TC01_LoginTest {
    private WebDriver driver;
    String UserName = new Faker().name().username();  /// Java Faker
     @BeforeMethod
    public void SetupDriver() throws IOException {
        driver = new EdgeDriver();
        driver.get(DataUtili.getpropertyvalue("environments","LOGIN_URL"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void validLoginTC() throws IOException {
      new P01_LoginPage(driver);
        new P01_LoginPage(driver).enterUsernameText(DataUtili.getJsonData("validloginData","username"))
                .enterPassword(DataUtili.getJsonData("validloginData","password"))
                    .clickLoginButton();

       Assert.assertEquals(driver.getCurrentUrl(),DataUtili.getpropertyvalue("environments","HOME_URL"));
    }
    @Test
    public void invalidLoginTC() throws IOException  ///// Java Faker
    {
        new P01_LoginPage(driver);
        new P01_LoginPage(driver).enterUsernameText(UserName)
                .enterPassword(DataUtili.getJsonData("validloginData","password"))
                .clickLoginButton();

        Assert.assertNotEquals(driver.getCurrentUrl(),DataUtili.getpropertyvalue("environments","HOME_URL"));
    }
    @AfterMethod
    public void Quite(){
        driver.quit();
    }

}
