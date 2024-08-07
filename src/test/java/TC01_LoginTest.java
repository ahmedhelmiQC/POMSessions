import Pages.P01_LoginPage;
import Utilities.DataUtili;
import Utilities.Utilities;
import com.github.javafaker.Faker;
import io.qameta.allure.*;
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
         /// Allure annotations ///
    @Description ("This test case verify that user logged in successfully")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Ahmed")
    @Link(name="Business Document" , url ="https://www.google.com")
    @Issue("https://github.com/ahmedhelmiQC")
    @TmsLink("https:jira.com/zephyr/TC50")
    @Epic("Web panel")
    @Feature("Login")
    @Story("Valid login on web")
    ///
    @Test
    public void validLoginTC() throws IOException {
      new P01_LoginPage(driver);
        entervalidusername();
        new P01_LoginPage(driver).enterPassword(DataUtili.getJsonData("validloginData","password"))
                    .clickLoginButton();
        Utilities.takescreenshot(driver,"first screenshot");

       Assert.assertEquals(driver.getCurrentUrl(),DataUtili.getpropertyvalue("environments","HOME_URL"));
    }
    @Step("step 1")
    public void entervalidusername() throws FileNotFoundException {
        new P01_LoginPage(driver).enterUsernameText(DataUtili.getJsonData("validloginData","username"));
    }

    @Test
    public void invalidLoginTC() throws IOException  ///// Java Faker
    {
        new P01_LoginPage(driver);
        new P01_LoginPage(driver).enterUsernameText(UserName)
                .enterPassword(DataUtili.getJsonData("validloginData","password"))
                .clickLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(),DataUtili.getpropertyvalue("environments","HOME_URL"));
    }
    @AfterMethod
    public void Quite(){
        driver.quit();
    }

}
