package Swaglabtest;

import Driver.DriverManager;
import Pages.loginPage;
import Utils.*;
import Listeners.TestngListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


@Listeners(TestngListener.class)
public class E2E {
    private static JsonUtils testdata;
    private static WebDriver driver;


    //
    @BeforeSuite
    public  void setUp() {

        LogsUtils.Info( "Browser launched successfully");
        testdata= new JsonUtils("test-data");
        String BrowserName = Utils.PropertiesUtils.getProperty("BrowserType");
        driver = DriverManager.Create_Instance(BrowserName);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }
    @Test(priority = 1)
    public static void SuccessfullLogin(){
        new loginPage(driver).enterUsername(testdata.getJasonData("login-Credenional.username"))
                .enterPassword(testdata.getJasonData("login-Credenional.password")).clickLoginButton().
                AddToCart().ClickCart().ClickonCheckOutBtn().
                EnterFirstName(testdata.getJasonData("Check-out-Page.first-name"))
                .EnterLastName(testdata.getJasonData("Check-out-Page.last-name")).
                EnterPostalCode(testdata.getJasonData("Check-out-Page.postal-code")).ClickonContinueBtn().
                clickFinish().VerifyThanksMsg();

    }

    @AfterSuite
    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }
}
