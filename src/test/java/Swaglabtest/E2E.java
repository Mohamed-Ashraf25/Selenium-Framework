package Swaglabtest;

import Driver.DriverManager;
import Pages.loginPage;
import Utils.*;
import Listeners.TestngListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.File;


@Listeners(TestngListener.class)
public class E2E {
    File Allure_Results = new File("test-outputs/allure-results");
    File Logs_Results = new File("test-outputs/logs");
    private static WebDriver driver;


    private static JsonUtils testdata;
    //    String Allure_Results = "test-outputs/allure-results";
    String LOgs_Results = "test-outputs/logs";
    @BeforeTest
    public  void setUp() {
        PropertiesUtils.loadProperties();
        FileUtils.DeleteFiles(Allure_Results);
        FileUtils.DeleteFiles( Logs_Results);
        String BrowserName = PropertiesUtils.getProperty("BrowserType");
        testdata= new JsonUtils("test-data");
        driver = DriverManager.Create_Instance(BrowserName);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        LogsUtils.Info( "Browser launched successfully");

    }
    @Test
    public static void SuccessfullLogin(){
        new loginPage(driver).enterUsername(testdata.getJasonData("login-Credenional.username"))
                .enterPassword(testdata.getJasonData("login-Credenional.password")).clickLoginButton();

        ScreenshotUtils.Takescreenshot("LoginPage Successfully");
    }

    @AfterSuite
    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }


}
